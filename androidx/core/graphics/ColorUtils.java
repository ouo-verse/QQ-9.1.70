package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.tencent.mapsdk.internal.by;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] fArr) {
        int round;
        int round2;
        int round3;
        float f16 = fArr[0];
        float f17 = fArr[1];
        float f18 = fArr[2];
        float abs = (1.0f - Math.abs((f18 * 2.0f) - 1.0f)) * f17;
        float f19 = f18 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f16 / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f16) / 60) {
            case 0:
                round = Math.round((abs + f19) * 255.0f);
                round2 = Math.round((abs2 + f19) * 255.0f);
                round3 = Math.round(f19 * 255.0f);
                break;
            case 1:
                round = Math.round((abs2 + f19) * 255.0f);
                round2 = Math.round((abs + f19) * 255.0f);
                round3 = Math.round(f19 * 255.0f);
                break;
            case 2:
                round = Math.round(f19 * 255.0f);
                round2 = Math.round((abs + f19) * 255.0f);
                round3 = Math.round((abs2 + f19) * 255.0f);
                break;
            case 3:
                round = Math.round(f19 * 255.0f);
                round2 = Math.round((abs2 + f19) * 255.0f);
                round3 = Math.round((abs + f19) * 255.0f);
                break;
            case 4:
                round = Math.round((abs2 + f19) * 255.0f);
                round2 = Math.round(f19 * 255.0f);
                round3 = Math.round((abs + f19) * 255.0f);
                break;
            case 5:
            case 6:
                round = Math.round((abs + f19) * 255.0f);
                round2 = Math.round(f19 * 255.0f);
                round3 = Math.round((abs2 + f19) * 255.0f);
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return Color.rgb(constrain(round, 0, 255), constrain(round2, 0, 255), constrain(round3, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = 100.0d) double d16, @FloatRange(from = -128.0d, to = 127.0d) double d17, @FloatRange(from = -128.0d, to = 127.0d) double d18) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d16, d17, d18, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = 100.0d) double d16, @FloatRange(from = -128.0d, to = 127.0d) double d17, @FloatRange(from = -128.0d, to = 127.0d) double d18, @NonNull double[] dArr) {
        double d19;
        double d26 = (d16 + 16.0d) / 116.0d;
        double d27 = (d17 / 500.0d) + d26;
        double d28 = d26 - (d18 / 200.0d);
        double pow = Math.pow(d27, 3.0d);
        if (pow <= XYZ_EPSILON) {
            pow = ((d27 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        if (d16 > 7.9996247999999985d) {
            d19 = Math.pow(d26, 3.0d);
        } else {
            d19 = d16 / XYZ_KAPPA;
        }
        double pow2 = Math.pow(d28, 3.0d);
        if (pow2 <= XYZ_EPSILON) {
            pow2 = ((d28 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = pow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = d19 * 100.0d;
        dArr[2] = pow2 * XYZ_WHITE_REFERENCE_Z;
    }

    public static void RGBToHSL(@IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i16, @IntRange(from = 0, to = 255) int i17, @NonNull float[] fArr) {
        float f16;
        float abs;
        float f17 = i3 / 255.0f;
        float f18 = i16 / 255.0f;
        float f19 = i17 / 255.0f;
        float max = Math.max(f17, Math.max(f18, f19));
        float min = Math.min(f17, Math.min(f18, f19));
        float f26 = max - min;
        float f27 = (max + min) / 2.0f;
        if (max == min) {
            f16 = 0.0f;
            abs = 0.0f;
        } else {
            if (max == f17) {
                f16 = ((f18 - f19) / f26) % 6.0f;
            } else if (max == f18) {
                f16 = ((f19 - f17) / f26) + 2.0f;
            } else {
                f16 = 4.0f + ((f17 - f18) / f26);
            }
            abs = f26 / (1.0f - Math.abs((2.0f * f27) - 1.0f));
        }
        float f28 = (f16 * 60.0f) % 360.0f;
        if (f28 < 0.0f) {
            f28 += 360.0f;
        }
        fArr[0] = constrain(f28, 0.0f, 360.0f);
        fArr[1] = constrain(abs, 0.0f, 1.0f);
        fArr[2] = constrain(f27, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i16, @IntRange(from = 0, to = 255) int i17, @NonNull double[] dArr) {
        RGBToXYZ(i3, i16, i17, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i16, @IntRange(from = 0, to = 255) int i17, @NonNull double[] dArr) {
        double pow;
        double pow2;
        double pow3;
        if (dArr.length == 3) {
            double d16 = i3 / 255.0d;
            if (d16 < 0.04045d) {
                pow = d16 / 12.92d;
            } else {
                pow = Math.pow((d16 + 0.055d) / 1.055d, 2.4d);
            }
            double d17 = i16 / 255.0d;
            if (d17 < 0.04045d) {
                pow2 = d17 / 12.92d;
            } else {
                pow2 = Math.pow((d17 + 0.055d) / 1.055d, 2.4d);
            }
            double d18 = i17 / 255.0d;
            if (d18 < 0.04045d) {
                pow3 = d18 / 12.92d;
            } else {
                pow3 = Math.pow((d18 + 0.055d) / 1.055d, 2.4d);
            }
            dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
            dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
            dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = 95.047d) double d16, @FloatRange(from = 0.0d, to = 100.0d) double d17, @FloatRange(from = 0.0d, to = 108.883d) double d18) {
        double d19;
        double d26;
        double d27;
        double d28 = (((3.2406d * d16) + ((-1.5372d) * d17)) + ((-0.4986d) * d18)) / 100.0d;
        double d29 = ((((-0.9689d) * d16) + (1.8758d * d17)) + (0.0415d * d18)) / 100.0d;
        double d36 = (((0.0557d * d16) + ((-0.204d) * d17)) + (1.057d * d18)) / 100.0d;
        if (d28 > 0.0031308d) {
            d19 = (Math.pow(d28, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d19 = d28 * 12.92d;
        }
        if (d29 > 0.0031308d) {
            d26 = (Math.pow(d29, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d26 = d29 * 12.92d;
        }
        if (d36 > 0.0031308d) {
            d27 = (Math.pow(d36, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d27 = d36 * 12.92d;
        }
        return Color.rgb(constrain((int) Math.round(d19 * 255.0d), 0, 255), constrain((int) Math.round(d26 * 255.0d), 0, 255), constrain((int) Math.round(d27 * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = 95.047d) double d16, @FloatRange(from = 0.0d, to = 100.0d) double d17, @FloatRange(from = 0.0d, to = 108.883d) double d18, @NonNull double[] dArr) {
        if (dArr.length == 3) {
            double pivotXyzComponent = pivotXyzComponent(d16 / XYZ_WHITE_REFERENCE_X);
            double pivotXyzComponent2 = pivotXyzComponent(d17 / 100.0d);
            double pivotXyzComponent3 = pivotXyzComponent(d18 / XYZ_WHITE_REFERENCE_Z);
            dArr[0] = Math.max(0.0d, (116.0d * pivotXyzComponent2) - 16.0d);
            dArr[1] = (pivotXyzComponent - pivotXyzComponent2) * 500.0d;
            dArr[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i3, @ColorInt int i16, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        float f17 = 1.0f - f16;
        return Color.argb((int) ((Color.alpha(i3) * f17) + (Color.alpha(i16) * f16)), (int) ((Color.red(i3) * f17) + (Color.red(i16) * f16)), (int) ((Color.green(i3) * f17) + (Color.green(i16) * f16)), (int) ((Color.blue(i3) * f17) + (Color.blue(i16) * f16)));
    }

    public static void blendHSL(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, to = 1.0d) float f16, @NonNull float[] fArr3) {
        if (fArr3.length == 3) {
            float f17 = 1.0f - f16;
            fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f16);
            fArr3[1] = (fArr[1] * f17) + (fArr2[1] * f16);
            fArr3[2] = (fArr[2] * f17) + (fArr2[2] * f16);
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, to = 1.0d) double d16, @NonNull double[] dArr3) {
        if (dArr3.length == 3) {
            double d17 = 1.0d - d16;
            dArr3[0] = (dArr[0] * d17) + (dArr2[0] * d16);
            dArr3[1] = (dArr[1] * d17) + (dArr2[1] * d16);
            dArr3[2] = (dArr[2] * d17) + (dArr2[2] * d16);
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double calculateContrast(@ColorInt int i3, @ColorInt int i16) {
        if (Color.alpha(i16) == 255) {
            if (Color.alpha(i3) < 255) {
                i3 = compositeColors(i3, i16);
            }
            double calculateLuminance = calculateLuminance(i3) + 0.05d;
            double calculateLuminance2 = calculateLuminance(i16) + 0.05d;
            return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i16));
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public static double calculateLuminance(@ColorInt int i3) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i3, tempDouble3Array);
        return tempDouble3Array[1] / 100.0d;
    }

    public static int calculateMinimumAlpha(@ColorInt int i3, @ColorInt int i16, float f16) {
        int i17 = 255;
        if (Color.alpha(i16) == 255) {
            double d16 = f16;
            if (calculateContrast(setAlphaComponent(i3, 255), i16) < d16) {
                return -1;
            }
            int i18 = 0;
            for (int i19 = 0; i19 <= 10 && i17 - i18 > 1; i19++) {
                int i26 = (i18 + i17) / 2;
                if (calculateContrast(setAlphaComponent(i3, i26), i16) < d16) {
                    i18 = i26;
                } else {
                    i17 = i26;
                }
            }
            return i17;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i16));
    }

    @VisibleForTesting
    static float circularInterpolate(float f16, float f17, float f18) {
        if (Math.abs(f17 - f16) > 180.0f) {
            if (f17 > f16) {
                f16 += 360.0f;
            } else {
                f17 += 360.0f;
            }
        }
        return (f16 + ((f17 - f16) * f18)) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int i3, @NonNull float[] fArr) {
        RGBToHSL(Color.red(i3), Color.green(i3), Color.blue(i3), fArr);
    }

    public static void colorToLAB(@ColorInt int i3, @NonNull double[] dArr) {
        RGBToLAB(Color.red(i3), Color.green(i3), Color.blue(i3), dArr);
    }

    public static void colorToXYZ(@ColorInt int i3, @NonNull double[] dArr) {
        RGBToXYZ(Color.red(i3), Color.green(i3), Color.blue(i3), dArr);
    }

    private static int compositeAlpha(int i3, int i16) {
        return 255 - (((255 - i16) * (255 - i3)) / 255);
    }

    public static int compositeColors(@ColorInt int i3, @ColorInt int i16) {
        int alpha = Color.alpha(i16);
        int alpha2 = Color.alpha(i3);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i3), alpha2, Color.red(i16), alpha, compositeAlpha), compositeComponent(Color.green(i3), alpha2, Color.green(i16), alpha, compositeAlpha), compositeComponent(Color.blue(i3), alpha2, Color.blue(i16), alpha, compositeAlpha));
    }

    private static int compositeComponent(int i3, int i16, int i17, int i18, int i19) {
        if (i19 == 0) {
            return 0;
        }
        return (((i3 * 255) * i16) + ((i17 * i18) * (255 - i16))) / (i19 * 255);
    }

    private static float constrain(float f16, float f17, float f18) {
        return f16 < f17 ? f17 : f16 > f18 ? f18 : f16;
    }

    public static double distanceEuclidean(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            threadLocal.set(dArr2);
            return dArr2;
        }
        return dArr;
    }

    private static double pivotXyzComponent(double d16) {
        if (d16 > XYZ_EPSILON) {
            return Math.pow(d16, 0.3333333333333333d);
        }
        return ((d16 * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i3, @IntRange(from = 0, to = 255) int i16) {
        if (i16 >= 0 && i16 <= 255) {
            return (i3 & 16777215) | (i16 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int constrain(int i3, int i16, int i17) {
        return i3 < i16 ? i16 : i3 > i17 ? i17 : i3;
    }

    @NonNull
    @RequiresApi(26)
    public static Color compositeColors(@NonNull Color color, @NonNull Color color2) {
        ColorSpace.Model model;
        ColorSpace.Model model2;
        ColorSpace.Model model3;
        ColorSpace.Model model4;
        ColorSpace colorSpace;
        ColorSpace colorSpace2;
        float[] components;
        float[] components2;
        float alpha;
        float alpha2;
        int componentCount;
        ColorSpace colorSpace3;
        Color valueOf;
        ColorSpace colorSpace4;
        model = color.getModel();
        model2 = color2.getModel();
        if (Objects.equals(model, model2)) {
            colorSpace = color2.getColorSpace();
            colorSpace2 = color.getColorSpace();
            if (!Objects.equals(colorSpace, colorSpace2)) {
                colorSpace4 = color2.getColorSpace();
                color = color.convert(colorSpace4);
            }
            components = color.getComponents();
            components2 = color2.getComponents();
            alpha = color.alpha();
            alpha2 = color2.alpha();
            float f16 = alpha2 * (1.0f - alpha);
            componentCount = color2.getComponentCount();
            int i3 = componentCount - 1;
            float f17 = alpha + f16;
            components2[i3] = f17;
            if (f17 > 0.0f) {
                alpha /= f17;
                f16 /= f17;
            }
            for (int i16 = 0; i16 < i3; i16++) {
                components2[i16] = (components[i16] * alpha) + (components2[i16] * f16);
            }
            colorSpace3 = color2.getColorSpace();
            valueOf = Color.valueOf(components2, colorSpace3);
            return valueOf;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Color models must match (");
        model3 = color.getModel();
        sb5.append(model3);
        sb5.append(" vs. ");
        model4 = color2.getModel();
        sb5.append(model4);
        sb5.append(")");
        throw new IllegalArgumentException(sb5.toString());
    }
}
