package com.tencent.biz.qqcircle.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0007"}, d2 = {"Landroid/graphics/Bitmap;", "bitmap1", "bitmap2", "a", "Landroid/view/View;", "view", "b", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class e {
    @Nullable
    public static final Bitmap a(@Nullable Bitmap bitmap, @Nullable Bitmap bitmap2) {
        if (bitmap == null && bitmap2 == null) {
            return null;
        }
        if (bitmap == null) {
            return bitmap2;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight() + bitmap2.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, 0.0f, bitmap.getHeight(), (Paint) null);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        if (!bitmap2.isRecycled()) {
            bitmap2.recycle();
        }
        return createBitmap;
    }

    @NotNull
    public static final Bitmap b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getHeight(), 1073741824));
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }
}
