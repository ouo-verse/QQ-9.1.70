package com.tencent.mobileqq.guild.feed.feedlist.section.recommend;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u00a8\u0006\u0002"}, d2 = {"Landroid/graphics/drawable/Drawable;", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {
    @NotNull
    public static final Drawable a(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        drawable.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        return drawable;
    }
}
