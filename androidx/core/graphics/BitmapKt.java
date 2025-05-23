package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0086\b\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a)\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u00a2\u0006\u0002\b\u0010H\u0086\b\u00f8\u0001\u0000\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0014H\u0086\n\u001a\u001d\u0010\u0015\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0086\n\u001a'\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0086\b\u001a'\u0010\u001a\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u0003H\u0086\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001c"}, d2 = {"createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", DownloadInfo.spKey_Config, "Landroid/graphics/Bitmap$Config;", "hasAlpha", "", "colorSpace", "Landroid/graphics/ColorSpace;", "applyCanvas", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "contains", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "get", HippyTKDListViewAdapter.X, "y", "scale", "filter", "set", "color", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class BitmapKt {
    @NotNull
    public static final Bitmap applyCanvas(@NotNull Bitmap applyCanvas, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(applyCanvas, "$this$applyCanvas");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new Canvas(applyCanvas));
        return applyCanvas;
    }

    public static final boolean contains(@NotNull Bitmap contains, @NotNull Point p16) {
        int i3;
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        Intrinsics.checkNotNullParameter(p16, "p");
        int i16 = p16.x;
        return i16 >= 0 && i16 < contains.getWidth() && (i3 = p16.y) >= 0 && i3 < contains.getHeight();
    }

    @NotNull
    public static final Bitmap createBitmap(int i3, int i16, @NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i3, int i16, Bitmap.Config config, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static final int get(@NotNull Bitmap get, int i3, int i16) {
        Intrinsics.checkNotNullParameter(get, "$this$get");
        return get.getPixel(i3, i16);
    }

    @NotNull
    public static final Bitmap scale(@NotNull Bitmap scale, int i3, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(scale, "$this$scale");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(scale, i3, i16, z16);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "Bitmap.createScaledBitma\u2026s, width, height, filter)");
        return createScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap scale, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            z16 = true;
        }
        Intrinsics.checkNotNullParameter(scale, "$this$scale");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(scale, i3, i16, z16);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "Bitmap.createScaledBitma\u2026s, width, height, filter)");
        return createScaledBitmap;
    }

    public static final void set(@NotNull Bitmap set, int i3, int i16, @ColorInt int i17) {
        Intrinsics.checkNotNullParameter(set, "$this$set");
        set.setPixel(i3, i16, i17);
    }

    public static final boolean contains(@NotNull Bitmap contains, @NotNull PointF p16) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        Intrinsics.checkNotNullParameter(p16, "p");
        float f16 = p16.x;
        float f17 = 0;
        if (f16 < f17 || f16 >= contains.getWidth()) {
            return false;
        }
        float f18 = p16.y;
        return f18 >= f17 && f18 < ((float) contains.getHeight());
    }

    @RequiresApi(26)
    @NotNull
    public static final Bitmap createBitmap(int i3, int i16, @NotNull Bitmap.Config config, boolean z16, @NotNull ColorSpace colorSpace) {
        Bitmap createBitmap;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        createBitmap = Bitmap.createBitmap(i3, i16, config, z16, colorSpace);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(widt\u2026ig, hasAlpha, colorSpace)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i3, int i16, Bitmap.Config config, boolean z16, ColorSpace colorSpace, int i17, Object obj) {
        Bitmap createBitmap;
        ColorSpace.Named named;
        if ((i17 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i17 & 8) != 0) {
            z16 = true;
        }
        if ((i17 & 16) != 0) {
            named = ColorSpace.Named.SRGB;
            colorSpace = ColorSpace.get(named);
            Intrinsics.checkNotNullExpressionValue(colorSpace, "ColorSpace.get(ColorSpace.Named.SRGB)");
        }
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        createBitmap = Bitmap.createBitmap(i3, i16, config, z16, colorSpace);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(widt\u2026ig, hasAlpha, colorSpace)");
        return createBitmap;
    }
}
