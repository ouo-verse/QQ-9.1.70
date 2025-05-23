package com.tencent.mobileqq.servlet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc00420;
import java.util.HashMap;

/* loaded from: classes18.dex */
public class ClearPushReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    public ClearPushReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(QQAppInterface qQAppInterface, String str, int i3) {
        if (qQAppInterface != null && i3 > 0) {
            LpReportInfo_dc00420.report(4, 0, null, str, i3);
            if (QLog.isColorLevel()) {
                QLog.d("pushReport", 2, "EXPOSE: uin: " + qQAppInterface.getAccount() + " pushstatkey: " + str);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("actiontype", "4");
            hashMap.put("pushstatkey", str);
            hashMap.put("mergenum", i3 + "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getAccount(), StatisticCollector.QZONE_PUSH_DATA_REPORT, true, 0L, 0L, hashMap, null);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        QZoneManagerImp qZoneManagerImp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("pushstatkey");
        int intExtra = intent.getIntExtra("mergenum", 0);
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            QQAppInterface qQAppInterface = (QQAppInterface) application.getRuntime();
            int intExtra2 = intent.getIntExtra("pushtype", 0);
            if ((intExtra2 == 1 || intExtra2 == 300) && (qZoneManagerImp = (QZoneManagerImp) qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER)) != null) {
                qZoneManagerImp.x(1, 0);
            }
            a(qQAppInterface, stringExtra, intExtra);
        }
    }
}
