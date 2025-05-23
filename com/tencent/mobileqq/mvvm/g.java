package com.tencent.mobileqq.mvvm;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\u0005"}, d2 = {"Landroid/view/View;", "Landroid/graphics/drawable/Drawable;", "background", "", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g {
    public static final void a(@NotNull View view, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setBackground(drawable);
    }
}
