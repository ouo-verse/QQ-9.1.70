package com.tencent.luggage.wxa.p003do;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }
}
