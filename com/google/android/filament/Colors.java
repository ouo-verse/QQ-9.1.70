package com.google.android.filament;

import androidx.annotation.NonNull;
import androidx.annotation.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Colors {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.google.android.filament.Colors$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$filament$Colors$Conversion;
        static final /* synthetic */ int[] $SwitchMap$com$google$android$filament$Colors$RgbaType;

        static {
            int[] iArr = new int[Conversion.values().length];
            $SwitchMap$com$google$android$filament$Colors$Conversion = iArr;
            try {
                iArr[Conversion.ACCURATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$filament$Colors$Conversion[Conversion.FAST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[RgbaType.values().length];
            $SwitchMap$com$google$android$filament$Colors$RgbaType = iArr2;
            try {
                iArr2[RgbaType.SRGB.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$android$filament$Colors$RgbaType[RgbaType.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$android$filament$Colors$RgbaType[RgbaType.PREMULTIPLIED_SRGB.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$android$filament$Colors$RgbaType[RgbaType.PREMULTIPLIED_LINEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Conversion {
        ACCURATE,
        FAST
    }

    /* compiled from: P */
    @Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface LinearColor {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum RgbType {
        SRGB,
        LINEAR
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum RgbaType {
        SRGB,
        LINEAR,
        PREMULTIPLIED_SRGB,
        PREMULTIPLIED_LINEAR
    }

    Colors() {
    }

    @NonNull
    @Size(3)
    public static float[] cct(float f16) {
        float[] fArr = new float[3];
        nCct(f16, fArr);
        return fArr;
    }

    @NonNull
    @Size(3)
    public static float[] illuminantD(float f16) {
        float[] fArr = new float[3];
        nIlluminantD(f16, fArr);
        return fArr;
    }

    private static native void nCct(float f16, @NonNull @Size(3) float[] fArr);

    private static native void nIlluminantD(float f16, @NonNull @Size(3) float[] fArr);

    @NonNull
    @Size(3)
    public static float[] toLinear(@NonNull RgbType rgbType, float f16, float f17, float f18) {
        return toLinear(rgbType, new float[]{f16, f17, f18});
    }

    @NonNull
    @Size(min = 3)
    public static float[] toLinear(@NonNull RgbType rgbType, @NonNull @Size(min = 3) float[] fArr) {
        return rgbType == RgbType.LINEAR ? fArr : toLinear(Conversion.ACCURATE, fArr);
    }

    @NonNull
    @Size(4)
    public static float[] toLinear(@NonNull RgbaType rgbaType, float f16, float f17, float f18, float f19) {
        return toLinear(rgbaType, new float[]{f16, f17, f18, f19});
    }

    @NonNull
    @Size(min = 4)
    public static float[] toLinear(@NonNull RgbaType rgbaType, @NonNull @Size(min = 4) float[] fArr) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$android$filament$Colors$RgbaType[rgbaType.ordinal()];
        if (i3 == 1) {
            toLinear(Conversion.ACCURATE, fArr);
        } else if (i3 != 2) {
            return i3 != 3 ? fArr : toLinear(Conversion.ACCURATE, fArr);
        }
        float f16 = fArr[3];
        fArr[0] = fArr[0] * f16;
        fArr[1] = fArr[1] * f16;
        fArr[2] = fArr[2] * f16;
        return fArr;
    }

    @NonNull
    public static float[] toLinear(@NonNull Conversion conversion, @NonNull @Size(min = 3) float[] fArr) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$android$filament$Colors$Conversion[conversion.ordinal()];
        int i16 = 0;
        if (i3 == 1) {
            while (i16 < 3) {
                float f16 = fArr[i16];
                fArr[i16] = f16 <= 0.04045f ? f16 / 12.92f : (float) Math.pow((f16 + 0.055f) / 1.055f, 2.4000000953674316d);
                i16++;
            }
        } else if (i3 == 2) {
            while (i16 < 3) {
                fArr[i16] = (float) Math.sqrt(fArr[i16]);
                i16++;
            }
        }
        return fArr;
    }
}
