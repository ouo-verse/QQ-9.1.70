package com.tencent.tuxmeterqui.timepicker;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u00a8\u0006\u0007"}, d2 = {"dip2px", "", "Landroid/content/Context;", "dpValue", "", "px2dip", "pxValue", "tuxmeterQUI_debug"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ContextExtKt {
    public static final int dip2px(@NotNull Context context, float f16) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final int px2dip(@NotNull Context context, float f16) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) ((f16 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
