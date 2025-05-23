package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001f\u001a\u00020\u0019*\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0087\u0002\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0001H\u0087\b\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020#H\u0087\b\u001a\r\u0010$\u001a\u00020\u0005*\u00020\u0001H\u0087\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0000\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\"\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0010*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00018\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006\"\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006\u00a8\u0006%"}, d2 = {com.tencent.luggage.wxa.c8.c.f123400v, "", "getAlpha", "(I)I", "", "", "(J)F", "blue", "getBlue", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "green", "getGreen", "isSrgb", "", "(J)Z", "isWideGamut", "luminance", "getLuminance", "(I)F", "red", "getRed", "component1", "Landroid/graphics/Color;", "component2", "component3", "component4", "convertTo", "Landroid/graphics/ColorSpace$Named;", QCircleDaTongConstant.ElementParamValue.PLUS, "c", "toColor", "toColorInt", "", "toColorLong", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ColorKt {
    public static final int component1(@ColorInt int i3) {
        return (i3 >> 24) & 255;
    }

    public static final int component2(@ColorInt int i3) {
        return (i3 >> 16) & 255;
    }

    public static final int component3(@ColorInt int i3) {
        return (i3 >> 8) & 255;
    }

    public static final int component4(@ColorInt int i3) {
        return i3 & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i3, @NotNull ColorSpace.Named colorSpace) {
        ColorSpace colorSpace2;
        long convert;
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        colorSpace2 = ColorSpace.get(colorSpace);
        convert = Color.convert(i3, colorSpace2);
        return convert;
    }

    public static final int getAlpha(@ColorInt int i3) {
        return (i3 >> 24) & 255;
    }

    public static final int getBlue(@ColorInt int i3) {
        return i3 & 255;
    }

    @RequiresApi(26)
    @NotNull
    public static final ColorSpace getColorSpace(long j3) {
        ColorSpace colorSpace;
        colorSpace = Color.colorSpace(j3);
        Intrinsics.checkNotNullExpressionValue(colorSpace, "Color.colorSpace(this)");
        return colorSpace;
    }

    public static final int getGreen(@ColorInt int i3) {
        return (i3 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i3) {
        float luminance;
        luminance = Color.luminance(i3);
        return luminance;
    }

    public static final int getRed(@ColorInt int i3) {
        return (i3 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j3) {
        boolean isSrgb;
        isSrgb = Color.isSrgb(j3);
        return isSrgb;
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j3) {
        boolean isWideGamut;
        isWideGamut = Color.isWideGamut(j3);
        return isWideGamut;
    }

    @RequiresApi(26)
    @NotNull
    public static final Color plus(@NotNull Color plus, @NotNull Color c16) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(c16, "c");
        Color compositeColors = ColorUtils.compositeColors(c16, plus);
        Intrinsics.checkNotNullExpressionValue(compositeColors, "ColorUtils.compositeColors(c, this)");
        return compositeColors;
    }

    @RequiresApi(26)
    @NotNull
    public static final Color toColor(@ColorInt int i3) {
        Color valueOf;
        valueOf = Color.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(valueOf, "Color.valueOf(this)");
        return valueOf;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j3) {
        int argb;
        argb = Color.toArgb(j3);
        return argb;
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i3) {
        long pack;
        pack = Color.pack(i3);
        return pack;
    }

    @RequiresApi(26)
    public static final float component1(@NotNull Color component1) {
        float component;
        Intrinsics.checkNotNullParameter(component1, "$this$component1");
        component = component1.getComponent(0);
        return component;
    }

    @RequiresApi(26)
    public static final float component2(@NotNull Color component2) {
        float component;
        Intrinsics.checkNotNullParameter(component2, "$this$component2");
        component = component2.getComponent(1);
        return component;
    }

    @RequiresApi(26)
    public static final float component3(@NotNull Color component3) {
        float component;
        Intrinsics.checkNotNullParameter(component3, "$this$component3");
        component = component3.getComponent(2);
        return component;
    }

    @RequiresApi(26)
    public static final float component4(@NotNull Color component4) {
        float component;
        Intrinsics.checkNotNullParameter(component4, "$this$component4");
        component = component4.getComponent(3);
        return component;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i3, @NotNull ColorSpace colorSpace) {
        long convert;
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        convert = Color.convert(i3, colorSpace);
        return convert;
    }

    @RequiresApi(26)
    public static final float getAlpha(long j3) {
        float alpha;
        alpha = Color.alpha(j3);
        return alpha;
    }

    @RequiresApi(26)
    public static final float getBlue(long j3) {
        float blue;
        blue = Color.blue(j3);
        return blue;
    }

    @RequiresApi(26)
    public static final float getGreen(long j3) {
        float green;
        green = Color.green(j3);
        return green;
    }

    @RequiresApi(26)
    public static final float getLuminance(long j3) {
        float luminance;
        luminance = Color.luminance(j3);
        return luminance;
    }

    @RequiresApi(26)
    public static final float getRed(long j3) {
        float red;
        red = Color.red(j3);
        return red;
    }

    @RequiresApi(26)
    @NotNull
    public static final Color toColor(long j3) {
        Color valueOf;
        valueOf = Color.valueOf(j3);
        Intrinsics.checkNotNullExpressionValue(valueOf, "Color.valueOf(this)");
        return valueOf;
    }

    @ColorInt
    public static final int toColorInt(@NotNull String toColorInt) {
        Intrinsics.checkNotNullParameter(toColorInt, "$this$toColorInt");
        return Color.parseColor(toColorInt);
    }

    @RequiresApi(26)
    public static final float component1(long j3) {
        float red;
        red = Color.red(j3);
        return red;
    }

    @RequiresApi(26)
    public static final float component2(long j3) {
        float green;
        green = Color.green(j3);
        return green;
    }

    @RequiresApi(26)
    public static final float component3(long j3) {
        float blue;
        blue = Color.blue(j3);
        return blue;
    }

    @RequiresApi(26)
    public static final float component4(long j3) {
        float alpha;
        alpha = Color.alpha(j3);
        return alpha;
    }

    @RequiresApi(26)
    public static final long convertTo(long j3, @NotNull ColorSpace.Named colorSpace) {
        ColorSpace colorSpace2;
        long convert;
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        colorSpace2 = ColorSpace.get(colorSpace);
        convert = Color.convert(j3, colorSpace2);
        return convert;
    }

    @RequiresApi(26)
    public static final long convertTo(long j3, @NotNull ColorSpace colorSpace) {
        long convert;
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        convert = Color.convert(j3, colorSpace);
        return convert;
    }

    @RequiresApi(26)
    @NotNull
    public static final Color convertTo(@NotNull Color convertTo, @NotNull ColorSpace.Named colorSpace) {
        ColorSpace colorSpace2;
        Color convert;
        Intrinsics.checkNotNullParameter(convertTo, "$this$convertTo");
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        colorSpace2 = ColorSpace.get(colorSpace);
        convert = convertTo.convert(colorSpace2);
        Intrinsics.checkNotNullExpressionValue(convert, "convert(ColorSpace.get(colorSpace))");
        return convert;
    }

    @RequiresApi(26)
    @NotNull
    public static final Color convertTo(@NotNull Color convertTo, @NotNull ColorSpace colorSpace) {
        Color convert;
        Intrinsics.checkNotNullParameter(convertTo, "$this$convertTo");
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        convert = convertTo.convert(colorSpace);
        Intrinsics.checkNotNullExpressionValue(convert, "convert(colorSpace)");
        return convert;
    }
}
