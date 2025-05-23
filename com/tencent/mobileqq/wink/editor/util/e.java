package com.tencent.mobileqq.wink.editor.util;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\"\u0014\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Landroid/graphics/RectF;", "", "a", "", "[F", "TEMP_FLOATS", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final float[] f322632a = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    @NotNull
    public static final String a(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<this>");
        return "{ width = " + rectF.width() + ", height = " + rectF.height() + ", [" + rectF.left + ", " + rectF.top + ", " + rectF.right + ", " + rectF.bottom + "] }";
    }
}
