package com.tencent.mobileqq.nearbypro.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0000*\u00020\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0007"}, d2 = {"", "Landroid/content/Context;", "context", "c", "b", "", "a", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d {
    public static final float a(float f16, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (f16 * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static final int b(int i3) {
        return (int) ((i3 * MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final int c(int i3, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) ((i3 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
