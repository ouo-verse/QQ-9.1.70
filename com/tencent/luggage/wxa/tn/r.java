package com.tencent.luggage.wxa.tn;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class r {
    public static int a(Intent intent, String str, int i3) {
        if (intent == null) {
            return i3;
        }
        try {
            return intent.getIntExtra(str, i3);
        } catch (Exception e16) {
            w.b("MicroMsg.IntentUtil", "getIntExtra exception:%s", e16.getMessage());
            return i3;
        }
    }

    public static boolean a(Intent intent, String str, boolean z16) {
        if (intent == null) {
            return z16;
        }
        try {
            return intent.getBooleanExtra(str, z16);
        } catch (Exception e16) {
            w.b("MicroMsg.IntentUtil", "getBooleanExtra exception:%s", e16.getMessage());
            return z16;
        }
    }

    public static String a(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getStringExtra(str);
        } catch (Exception e16) {
            w.b("MicroMsg.IntentUtil", "getStringExtra exception:%s", e16.getMessage());
            return null;
        }
    }
}
