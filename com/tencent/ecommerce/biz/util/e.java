package com.tencent.ecommerce.biz.util;

import android.content.Context;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0015\u0010\u0007\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\t\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0015\u0010\t\u001a\u00020\u0000*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"", "Landroid/content/Context;", "context", "", "a", "c", "(F)I", "dp", "e", "px", "d", "(I)F", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e {
    public static final int a(float f16, Context context) {
        return (int) TypedValue.applyDimension(1, f16, context.getResources().getDisplayMetrics());
    }

    public static final int c(float f16) {
        return (int) TypedValue.applyDimension(1, f16, com.tencent.ecommerce.base.device.a.f100685b.e());
    }

    public static final float d(int i3) {
        return com.tencent.ecommerce.base.device.a.f100685b.e().density * i3;
    }

    public static final int e(float f16) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(com.tencent.ecommerce.base.device.a.f100685b.e().density * f16);
        return roundToInt;
    }

    public static /* synthetic */ int b(float f16, Context context, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            context = wg0.a.a();
        }
        return a(f16, context);
    }
}
