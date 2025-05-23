package com.tencent.luggage.wxa.s9;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static void a(AudioManager audioManager, int i3, int i16, int i17) {
        if (com.tencent.luggage.wxa.aa.a.c(24)) {
            w.d("MicroMsg.AudioAdaptNHelp", "setStreamVolume()");
            try {
                audioManager.setStreamVolume(i3, i16, i17);
                return;
            } catch (Exception e16) {
                w.b("MicroMsg.AudioAdaptNHelp", "setStreamVolume() Exception:%s", e16.getMessage());
                a();
                return;
            }
        }
        audioManager.setStreamVolume(i3, i16, i17);
    }

    public static void a() {
        boolean isNotificationPolicyAccessGranted = ((NotificationManager) com.tencent.luggage.wxa.tn.a.a().getSystemService("notification")).isNotificationPolicyAccessGranted();
        w.d("MicroMsg.AudioAdaptNHelp", "requestPermission() result:%s", Boolean.valueOf(isNotificationPolicyAccessGranted));
        if (isNotificationPolicyAccessGranted) {
            return;
        }
        try {
            Intent intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", com.tencent.luggage.wxa.tn.a.a().getPackageName());
            Application a16 = com.tencent.luggage.wxa.tn.a.a();
            com.tencent.luggage.wxa.fa.b.a(a16, intent);
            a16.startActivity(intent);
        } catch (Exception e16) {
            w.b("MicroMsg.AudioAdaptNHelp", "requestPermission() Exception:%s", e16.getMessage());
        }
    }
}
