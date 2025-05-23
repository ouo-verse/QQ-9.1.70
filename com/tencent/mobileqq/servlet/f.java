package com.tencent.mobileqq.servlet;

import KQQ.PluginInfo;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private long f286483d;

    /* renamed from: e, reason: collision with root package name */
    private long f286484e;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f286483d = 0L;
            this.f286484e = 0L;
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int resultCode;
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.GameCenterServlet", 2, "recieve flag from server.");
        }
        QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
        this.f286484e = System.currentTimeMillis();
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            List<PluginInfo> a16 = eq2.b.a(fromServiceMsg.getWupBuffer());
            if (a16 != null && a16.size() > 0) {
                if (qQAppInterface == null) {
                    eVar = null;
                } else {
                    eVar = (e) qQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER);
                }
                if (eVar != null) {
                    eVar.h(a16);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(QCircleDaTongConstant.ElementParamValue.NEW, a16.get(0).Flag);
                    bundle.putInt("gc_notify_type", 2);
                    notifyObserver(null, 10000, true, bundle, com.tencent.mobileqq.observer.a.class);
                    QLog.e("Q.lebatab.GameCenterServlet", 2, "[red dot] 1");
                    if (qQAppInterface != null) {
                        StatisticCollector.getInstance(qQAppInterface.getApp()).collectPerformance(qQAppInterface.getCurrentAccountUin(), StatisticCollector.PLUGIN_GETUNREAD_TAG, true, this.f286484e - this.f286483d, 0L, new HashMap<>(), "");
                        return;
                    }
                    return;
                }
            } else if (qQAppInterface != null) {
                String str = "|wufbuf: " + HexUtil.bytes2HexStr(fromServiceMsg.getWupBuffer());
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_FailCode", String.valueOf(9045));
                hashMap.put(ReportConstant.KEY_ERR_DESC, str);
                StatisticCollector.getInstance(qQAppInterface.getApp()).collectPerformance(qQAppInterface.getCurrentAccountUin(), StatisticCollector.PLUGIN_GETUNREAD_TAG, false, this.f286484e - this.f286483d, 0L, hashMap, "");
            }
        } else if (qQAppInterface != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("|resultcode: ");
            if (fromServiceMsg == null) {
                resultCode = -1;
            } else {
                resultCode = fromServiceMsg.getResultCode();
            }
            sb5.append(resultCode);
            sb5.append("|reason: ");
            sb5.append(BaseMessageHandler.getTimeoutReason(fromServiceMsg));
            String sb6 = sb5.toString();
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("param_FailCode", String.valueOf(AppConstants.RichMediaErrorCode.ERROR_REQEUST_TIMEOUT));
            hashMap2.put(ReportConstant.KEY_ERR_DESC, sb6);
            StatisticCollector.getInstance(qQAppInterface.getApp()).collectPerformance(qQAppInterface.getCurrentAccountUin(), StatisticCollector.PLUGIN_GETUNREAD_TAG, false, this.f286484e - this.f286483d, 0L, hashMap2, "");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("gc_notify_type", 2);
        notifyObserver(null, 10000, false, bundle2, com.tencent.mobileqq.observer.a.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        String action = intent.getAction();
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("gc_pluginid_list");
        if (action != null && action.equals("gc_get_newandunreadmsg")) {
            eq2.b.b(packet, arrayList);
        }
        this.f286483d = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.GameCenterServlet", 2, "send get flag request.");
        }
    }

    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void service(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        String action = intent.getAction();
        if (action != null && "gc_refresh_ui".equals(action)) {
            int intExtra = intent.getIntExtra("gc_notify_type", 0);
            Bundle bundle = new Bundle();
            bundle.putBoolean(QCircleDaTongConstant.ElementParamValue.NEW, true);
            bundle.putInt("gc_notify_type", intExtra);
            notifyObserver(null, 10000, true, bundle, com.tencent.mobileqq.observer.a.class);
            BaseApplication.getContext().sendBroadcast(new Intent(RedTouchConst.Action.PUSH_ACTION_FOR_AV));
            if (QLog.isColorLevel()) {
                QLog.d("Q.lebatab.GameCenterServlet", 2, "[red dot] game center send broadcast");
                return;
            }
            return;
        }
        super.service(intent);
    }
}
