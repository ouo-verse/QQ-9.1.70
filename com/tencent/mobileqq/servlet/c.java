package com.tencent.mobileqq.servlet;

import GIFT_MALL_PROTOCOL.doufu_piece_rsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.vip.manager.MonitorManager;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends MSFServlet {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (intent != null && fromServiceMsg != null) {
            int resultCode = fromServiceMsg.getResultCode();
            Bundle bundle = new Bundle();
            bundle.putString("msg", "servlet result code is " + resultCode);
            if (resultCode == 1000) {
                byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                doufu_piece_rsp a16 = cooperation.vip.manager.b.a(wupBuffer, new int[1]);
                if (a16 != null) {
                    bundle.putInt("ret", 0);
                    bundle.putSerializable("data", a16);
                    notifyObserver(null, 1009, true, bundle, QZoneObserver.class);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("BirthDayNoticeServlet", 2, "GET_BIRTHDAY_DATA fail, decode result is null");
                }
                bundle.putInt("ret", -2);
                MonitorManager.f().h(19, 2, " \u89e3\u5305\u5931\u8d25 " + wupBuffer, false);
                notifyObserver(null, 1009, false, bundle, QZoneObserver.class);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BirthDayNoticeServlet", 2, "GET_BIRTHDAY_DATA fail, resultCode=" + resultCode);
            }
            MonitorManager.f().h(19, 3, " \u540e\u53f0\u8fd4\u56de\u5931\u8d25\uff0c \u9519\u8bef\u7801 " + resultCode + " \u9519\u8bef\u4fe1\u606f " + fromServiceMsg.getBusinessFailMsg(), false);
            bundle.putInt("ret", -3);
            notifyObserver(null, 1009, false, bundle, QZoneObserver.class);
            return;
        }
        MonitorManager.f().h(19, 1, " \u8bf7\u6c42\u5931\u8d25 intent =" + intent + "  respone= " + fromServiceMsg, false);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        cooperation.vip.manager.b bVar = new cooperation.vip.manager.b(Long.valueOf(intent.getLongExtra("selfuin", 0L)).longValue(), new HashMap());
        byte[] encode = bVar.encode();
        if (encode == null) {
            QLog.e("BirthDayNoticeServlet", 1, "onSend request encode result is null.cmd=" + bVar.uniKey());
            encode = new byte[4];
        }
        packet.setTimeout(60000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + bVar.uniKey());
        packet.putSendData(encode);
    }
}
