package com.tencent.richframework.compat.immersive.color;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.richframework.compat.immersive.color.IColorFetcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/richframework/compat/immersive/color/CanvasDrawColorFetcher;", "Lcom/tencent/richframework/compat/immersive/color/IColorFetcher;", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/tencent/richframework/compat/immersive/color/IColorFetcher$Area;", GdtGetUserInfoHandler.KEY_AREA, "Landroid/util/Pair;", "", "", "getColor", "<init>", "()V", "Companion", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public abstract class CanvasDrawColorFetcher implements IColorFetcher {
    @NotNull
    public Pair<Boolean, Integer> getColor(@NotNull Drawable drawable, @NotNull IColorFetcher.Area area) {
        int coerceAtMost;
        Bitmap createBitmap;
        Canvas canvas;
        int coerceAtMost2;
        int coerceAtMost3;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(area, "area");
        int width = drawable.getBounds().width();
        int height = drawable.getBounds().height();
        if (width != 0 && height != 0) {
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(5, height);
            createBitmap = Bitmap.createBitmap(width, coerceAtMost2, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(draw\u2026 Bitmap.Config.ARGB_8888)");
            canvas = new Canvas(createBitmap);
            if (area == IColorFetcher.Area.BOTTOM) {
                coerceAtMost3 = RangesKt___RangesKt.coerceAtMost((-height) + 5, 0);
                canvas.translate(0.0f, coerceAtMost3);
            }
        } else {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(5, drawable.getIntrinsicHeight());
            createBitmap = Bitmap.createBitmap(intrinsicWidth, coerceAtMost, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(\n   \u2026g.ARGB_8888\n            )");
            canvas = new Canvas(createBitmap);
            if (area == IColorFetcher.Area.BOTTOM) {
                canvas.translate(0.0f, Math.min((-drawable.getIntrinsicHeight()) + 5, 0));
            }
            Drawable.Callback callback = drawable.getCallback();
            Rect rect = new Rect(drawable.getBounds());
            Rect rect2 = new Rect(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.setCallback(null);
            drawable.setBounds(rect2);
            drawable.draw(canvas);
            drawable.setBounds(rect);
            drawable.setCallback(callback);
        }
        drawable.draw(canvas);
        int immersiveColorFromBitmap = ColorFetchUtil.INSTANCE.getImmersiveColorFromBitmap(createBitmap);
        createBitmap.recycle();
        return new Pair<>(Boolean.TRUE, Integer.valueOf(immersiveColorFromBitmap));
    }
}
