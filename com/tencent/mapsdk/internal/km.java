package com.tencent.mapsdk.internal;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class km {
    public static int a(Context context, int i3) {
        return (int) TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
    }
}
