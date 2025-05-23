package com.tencent.qmethod.pandoraex.monitor;

import android.app.PendingIntent;
import android.telephony.SmsManager;
import androidx.annotation.RequiresApi;
import com.tencent.qmethod.pandoraex.core.MonitorReporter;
import vr3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SmsMonitor {
    static final String SMS_URI = "content://sms";
    public static final String TAG = "SmsMonitor";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isQuerySms(String str) {
        return str.startsWith(SMS_URI);
    }

    public static void sendTextMessage(SmsManager smsManager, String str, String str2, String str3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("sms", "SM#SE_TX_MESS#SSSPP", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            smsManager.sendTextMessage(str, str2, str3, pendingIntent, pendingIntent2);
        }
    }

    @RequiresApi(api = 30)
    public static void sendTextMessage(SmsManager smsManager, String str, String str2, String str3, PendingIntent pendingIntent, PendingIntent pendingIntent2, long j3) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("sms", "SM#SE_TX_MESS#SSSPPL", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            smsManager.sendTextMessage(str, str2, str3, pendingIntent, pendingIntent2, j3);
        }
    }
}
