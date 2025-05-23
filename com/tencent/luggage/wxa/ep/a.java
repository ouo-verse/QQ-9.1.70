package com.tencent.luggage.wxa.ep;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static int a(Context context, float f16) {
        return (int) TypedValue.applyDimension(1, f16, context.getResources().getDisplayMetrics());
    }
}
