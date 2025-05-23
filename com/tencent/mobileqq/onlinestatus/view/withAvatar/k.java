package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u0001\u00a8\u0006\u0007"}, d2 = {"Landroid/view/View;", "", "colorRes", "a", "drawableRes", "Landroid/graphics/drawable/Drawable;", "b", "qqonlinestatus-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class k {
    public static final int a(@NotNull View view, @ColorRes int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return ResourcesCompat.getColor(view.getResources(), i3, null);
    }

    @Nullable
    public static final Drawable b(@NotNull View view, @DrawableRes int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return ResourcesCompat.getDrawable(view.getResources(), i3, null);
    }
}
