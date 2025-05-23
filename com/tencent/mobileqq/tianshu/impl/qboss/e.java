package com.tencent.mobileqq.tianshu.impl.qboss;

import NS_MOBILE_QBOSS_PROTO.MobileQbossReportRsp;
import NS_MOBILE_QBOSS_PROTO.tMobileQbossFeedBackInfo;
import android.content.Intent;
import android.os.Bundle;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends MSFServlet {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private tMobileQbossFeedBackInfo a(String str, int i3, int i16, String str2, long j3, String str3, int i17) {
        tMobileQbossFeedBackInfo tmobileqbossfeedbackinfo = new tMobileQbossFeedBackInfo();
        tmobileqbossfeedbackinfo.uiUin = j3;
        tmobileqbossfeedbackinfo.sQBosstrace = str;
        tmobileqbossfeedbackinfo.iOperType = i3;
        tmobileqbossfeedbackinfo.iOperSource = i16;
        tmobileqbossfeedbackinfo.sQua = str3;
        tmobileqbossfeedbackinfo.sUserID = str2;
        tmobileqbossfeedbackinfo.iOperTimes = i17;
        return tmobileqbossfeedbackinfo;
    }

    private ArrayList<tMobileQbossFeedBackInfo> b(String str, int i3, String str2, long j3, String str3, int i16) {
        tMobileQbossFeedBackInfo a16 = a(str, i3, 2, str2, j3, str3, i16);
        ArrayList<tMobileQbossFeedBackInfo> arrayList = new ArrayList<>(1);
        arrayList.add(a16);
        return arrayList;
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg != null) {
            i3 = fromServiceMsg.getResultCode();
        } else {
            i3 = -1;
        }
        Bundle bundle = new Bundle();
        bundle.putString("msg", "servlet result code is " + i3);
        QLog.d("QbossReportServlet", 2, "qboss onReceive onSend");
        if (i3 == 1000) {
            MobileQbossReportRsp a16 = d.a(fromServiceMsg.getWupBuffer());
            if (a16 != null) {
                bundle.putInt("ret", 0);
                bundle.putSerializable("data", a16);
                QLog.d("QbossReportServlet", 2, "qboss onReceive ret");
                notifyObserver(null, 1008, true, bundle, QZoneObserver.class);
                return;
            }
            QLog.d("QbossReportServlet", 2, "qboss onReceive ok");
            if (QLog.isColorLevel()) {
                QLog.d("QbossReportServlet", 2, "QZONE_REPORT_QBOSS fail, decode result is null");
            }
            bundle.putInt("ret", -2);
            notifyObserver(null, 1008, false, bundle, QZoneObserver.class);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QbossReportServlet", 2, "QZONE_REPORT_QBOSS fail, resultCode=" + i3);
        }
        QLog.d("QbossReportServlet", 2, "qboss onReceive not ok");
        bundle.putInt("ret", -3);
        notifyObserver(null, 1008, false, bundle, QZoneObserver.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        String stringExtra = intent.getStringExtra("sQBosstrace");
        int intExtra = intent.getIntExtra("iOperType", 0);
        String stringExtra2 = intent.getStringExtra("sUserID");
        long longExtra = intent.getLongExtra("uin", 0L);
        String stringExtra3 = intent.getStringExtra("qua");
        int intExtra2 = intent.getIntExtra(Element.ELEMENT_NAME_TIMES, 1);
        QLog.d("QbossReportServlet", 2, "qboss onSend");
        d dVar = new d(b(stringExtra, intExtra, stringExtra2, longExtra, stringExtra3, intExtra2));
        byte[] encode = dVar.encode();
        if (encode == null) {
            QLog.e("QbossReportServlet", 1, "onSend request encode result is null.cmd=" + dVar.uniKey());
            encode = new byte[4];
        }
        packet.setTimeout(60000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + dVar.uniKey());
        packet.putSendData(encode);
    }
}
