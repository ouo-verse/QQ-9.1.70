package com.qzone.common.activities.base;

import android.content.Intent;
import android.text.TextUtils;
import com.qzone.app.QZoneAppInterface;
import com.qzone.common.account.LoginData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ci {
    public static void b(Intent intent) {
        if (intent == null) {
            return;
        }
        long j3 = 0;
        if (intent.getBooleanExtra("FromNotification", false) && LoginData.getInstance().getUin() > 0) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "from notification, drop uin");
            return;
        }
        String stringExtra = intent.getStringExtra("qzone_uin");
        String stringExtra2 = intent.getStringExtra("nickname");
        String stringExtra3 = intent.getStringExtra("sid");
        if (TextUtils.isEmpty(stringExtra)) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "sync ignore, account is empty. currentAccount:" + com.qzone.util.b.a(LoginData.getInstance().getUin()));
            return;
        }
        try {
            j3 = Long.valueOf(stringExtra).longValue();
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            QZLog.w(QZLog.TO_DEVICE_TAG, "invalid sync account:" + com.qzone.util.b.b(stringExtra));
        }
        a(j3, stringExtra3, stringExtra2);
    }

    private static void a(long j3, String str, String str2) {
        if (j3 <= 0) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "sync login fail, account is empty. currentAccount:" + com.qzone.util.b.a(LoginData.getInstance().getUin()));
            return;
        }
        if (str2 != null && !str2.equals("")) {
            LoginData.getInstance().setNickName(str2);
        }
        long uin = LoginData.getInstance().getUin();
        if (j3 != uin) {
            LoginData.getInstance().setUin(j3);
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "sync login:" + com.qzone.util.b.a(j3) + "," + str2);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("old_uin", String.valueOf(uin));
            hashMap.put("new_uin", String.valueOf(j3));
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(uin + "", "qzone_sync_login", true, 0L, 0L, hashMap, null);
            AppRuntime qzoneAppInterface = LoginData.getInstance().getQzoneAppInterface();
            if (qzoneAppInterface == null || !(qzoneAppInterface instanceof QZoneAppInterface)) {
                return;
            }
            QZoneAppInterface qZoneAppInterface = (QZoneAppInterface) qzoneAppInterface;
            qZoneAppInterface.setLoaded(false);
            qZoneAppInterface.onLogin();
            String valueOf = String.valueOf(j3);
            if (valueOf.equals(qZoneAppInterface.getAccount())) {
                return;
            }
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "login for different uin in app:" + com.qzone.util.b.b(qZoneAppInterface.getAccount()));
            LoginData.getInstance().login(valueOf);
        }
    }
}
