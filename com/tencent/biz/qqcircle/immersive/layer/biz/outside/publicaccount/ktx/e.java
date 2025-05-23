package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx;

import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0005\u001a\u00020\u0003*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0007\u001a\u00020\u0006*\u0004\u0018\u00010\u0000\u00a8\u0006\b"}, d2 = {"Landroid/view/View;", "Landroid/graphics/Rect;", "d", "", "b", "c", "", "a", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e {
    @NotNull
    public static final int[] a(@Nullable View view) {
        if (view == null) {
            return new int[0];
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static final float b(@Nullable View view) {
        if (view == null) {
            return 0.0f;
        }
        return d(view).height();
    }

    public static final float c(@Nullable View view) {
        boolean z16;
        if (view == null) {
            return 0.0f;
        }
        float b16 = b(view);
        if (b16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || view.getMeasuredHeight() == 0) {
            return 0.0f;
        }
        return b16 / view.getMeasuredHeight();
    }

    @NotNull
    public static final Rect d(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
