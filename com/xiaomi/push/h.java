package com.xiaomi.push;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: P */
/* loaded from: classes28.dex */
public class h {
    public static boolean a(Context context) {
        try {
            return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e16) {
            jz4.c.q(e16);
            return false;
        }
    }

    public static boolean b(Context context) {
        Intent intent = null;
        try {
            intent = ie.c(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), null, null);
        } catch (Exception unused) {
        }
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra != 2 && intExtra != 5) {
            return false;
        }
        return true;
    }
}
