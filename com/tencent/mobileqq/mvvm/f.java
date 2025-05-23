package com.tencent.mobileqq.mvvm;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\b"}, d2 = {"Landroid/content/res/Resources;", "", "id", "Landroid/graphics/drawable/Drawable;", "c", "a", "Landroid/content/res/ColorStateList;", "b", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f {
    public static final int a(@NotNull Resources resources, @ColorRes int i3) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        return resources.getColor(i3, null);
    }

    @NotNull
    public static final ColorStateList b(@NotNull Resources resources, @ColorRes int i3) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        ColorStateList colorStateList = resources.getColorStateList(i3, null);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "{\n        getColorStateList(id, null)\n    }");
        return colorStateList;
    }

    @NotNull
    public static final Drawable c(@NotNull Resources resources, @DrawableRes int i3) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        Drawable drawable = resources.getDrawable(i3, null);
        Intrinsics.checkNotNullExpressionValue(drawable, "{\n        getDrawable(id, null)\n    }");
        return drawable;
    }
}
