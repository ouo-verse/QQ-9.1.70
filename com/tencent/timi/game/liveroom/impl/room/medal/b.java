package com.tencent.timi.game.liveroom.impl.room.medal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.RegionDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Bitmap;", "a", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {
    @NotNull
    public static final Bitmap a(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "this.bitmap");
            return bitmap;
        }
        if (drawable instanceof RegionDrawable) {
            Bitmap bitmap2 = ((RegionDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap2, "this.bitmap");
            return bitmap2;
        }
        Bitmap bitmap3 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap3);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        Intrinsics.checkNotNullExpressionValue(bitmap3, "bitmap");
        return bitmap3;
    }
}
