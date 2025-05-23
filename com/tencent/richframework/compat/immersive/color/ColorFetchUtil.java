package com.tencent.richframework.compat.immersive.color;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/richframework/compat/immersive/color/ColorFetchUtil;", "", "", "allColor", "", "getMostCountColor", "frontColor", "backColor", "compositingColor", "color", "", "calculateLuminance", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "getImmersiveColorFromBitmap", "COLOR_POINT_VALUE", "[I", "<init>", "()V", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ColorFetchUtil {

    @NotNull
    public static final ColorFetchUtil INSTANCE = new ColorFetchUtil();
    private static final int[] COLOR_POINT_VALUE = new int[5];

    ColorFetchUtil() {
    }

    private final int getMostCountColor(int[] allColor) {
        HashMap hashMap = new HashMap();
        int i3 = allColor[0];
        int i16 = 0;
        for (int i17 : allColor) {
            Integer num = (Integer) hashMap.get(Integer.valueOf(i17));
            if (num != null) {
                int intValue = num.intValue() + 1;
                hashMap.put(Integer.valueOf(i17), Integer.valueOf(intValue));
                if (intValue > i16) {
                    i3 = i17;
                    i16 = intValue;
                }
            } else {
                hashMap.put(Integer.valueOf(i17), 1);
            }
        }
        return i3;
    }

    public final double calculateLuminance(int color) {
        double alpha = Color.alpha(color) / 255.0f;
        return ((Color.red(color) / 255.0f) * 0.2126d * alpha) + ((Color.green(color) / 255.0f) * 0.7152d * alpha) + ((Color.blue(color) / 255.0f) * 0.0722d * alpha);
    }

    public final int compositingColor(int frontColor, int backColor) {
        float red = Color.red(frontColor);
        float green = Color.green(frontColor);
        float blue = Color.blue(frontColor);
        float alpha = Color.alpha(frontColor);
        float red2 = Color.red(backColor);
        float green2 = Color.green(backColor);
        float blue2 = Color.blue(backColor);
        float f16 = alpha / 255.0f;
        float alpha2 = (1 - f16) * Color.alpha(backColor);
        float f17 = alpha2 / 255.0f;
        return Color.argb((int) (alpha + alpha2), (int) ((red * f16) + (red2 * f17)), (int) ((green * f16) + (green2 * f17)), (int) ((blue * f16) + (blue2 * f17)));
    }

    public final int getImmersiveColorFromBitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 3 || height <= 3) {
            return 0;
        }
        int[] iArr = COLOR_POINT_VALUE;
        int i3 = height - 3;
        iArr[2] = bitmap.getPixel(width / 2, i3);
        int pixel = bitmap.getPixel(3, i3);
        iArr[0] = pixel;
        int i16 = iArr[2];
        if (pixel == i16) {
            return i16;
        }
        int i17 = width - 3;
        int pixel2 = bitmap.getPixel(i17, i3);
        iArr[4] = pixel2;
        int i18 = iArr[0];
        if (i18 != pixel2) {
            int i19 = iArr[2];
            if (pixel2 != i19) {
                int i26 = width / 4;
                iArr[1] = bitmap.getPixel(i17 - i26, i3);
                iArr[3] = bitmap.getPixel(i26 + 3, i3);
                return getMostCountColor(iArr);
            }
            return i19;
        }
        return i18;
    }
}
