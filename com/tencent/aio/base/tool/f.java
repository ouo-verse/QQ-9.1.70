package com.tencent.aio.base.tool;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"", "Landroid/content/Context;", "context", "a", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class f {
    public static final float a(float f16, @NotNull Context context) {
        DisplayMetrics displayMetrics;
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        if (resources != null) {
            displayMetrics = resources.getDisplayMetrics();
        } else {
            displayMetrics = null;
        }
        return TypedValue.applyDimension(1, f16, displayMetrics);
    }
}
