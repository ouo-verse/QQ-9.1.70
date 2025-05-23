package com.tencent.turingcam;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Amfcp {
    public static int a(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null || !TextUtils.equals(registerReceiver.getAction(), "android.intent.action.BATTERY_CHANGED")) {
                return -1;
            }
            int i3 = 0;
            int intExtra = registerReceiver.getIntExtra("level", 0);
            int intExtra2 = registerReceiver.getIntExtra("scale", 100);
            if (intExtra2 == 0) {
                return -1;
            }
            int i16 = (intExtra * 100) / intExtra2;
            if (i16 >= 0) {
                i3 = i16;
            }
            if (i3 > 100) {
                return 100;
            }
            return i3;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
