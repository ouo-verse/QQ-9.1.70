package com.tencent.qqnt.avatar.business.bitmap.layout;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001JU\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\f\u0010\rJ9\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0004H&\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/avatar/business/bitmap/layout/b;", "", "", "size", "", "Lkotlin/Pair;", "", "subSize", "gap", "gapColor", "Landroid/graphics/Bitmap;", "bitmaps", "b", "(I[Lkotlin/Pair;II[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "count", "a", "(III)[Lkotlin/Pair;", "bimaps", "c", "(III[Landroid/graphics/Bitmap;)[Landroid/graphics/Bitmap;", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface b {
    @NotNull
    Pair<Float, Float>[] a(int size, int gap, int count);

    @Nullable
    Bitmap b(int size, @NotNull Pair<Float, Float>[] subSize, int gap, int gapColor, @Nullable Bitmap[] bitmaps);

    @NotNull
    Bitmap[] c(int size, int gap, int count, @NotNull Bitmap[] bimaps);
}
