package org.tencwebrtc;

import android.graphics.Matrix;
import android.graphics.Point;
import android.view.View;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RendererCommon {
    private static float BALANCED_VISIBLE_FRACTION = 0.5625f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.tencwebrtc.RendererCommon$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$tencwebrtc$RendererCommon$ScalingType;

        static {
            int[] iArr = new int[ScalingType.values().length];
            $SwitchMap$org$tencwebrtc$RendererCommon$ScalingType = iArr;
            try {
                iArr[ScalingType.SCALE_ASPECT_FIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$tencwebrtc$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$tencwebrtc$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_BALANCED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface GlDrawer {
        void drawOes(int i3, float[] fArr, int i16, int i17, int i18, int i19, int i26, int i27);

        void drawRgb(int i3, float[] fArr, int i16, int i17, int i18, int i19, int i26, int i27);

        void drawYuv(int[] iArr, float[] fArr, int i3, int i16, int i17, int i18, int i19, int i26);

        void release();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface RendererEvents {
        void onFirstFrameRendered();

        void onFrameResolutionChanged(int i3, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum ScalingType {
        SCALE_ASPECT_FIT,
        SCALE_ASPECT_FILL,
        SCALE_ASPECT_BALANCED
    }

    private static void adjustOrigin(float[] fArr) {
        float f16 = fArr[12] - ((fArr[0] + fArr[4]) * 0.5f);
        fArr[12] = f16;
        float f17 = fArr[13] - ((fArr[1] + fArr[5]) * 0.5f);
        fArr[13] = f17;
        fArr[12] = f16 + 0.5f;
        fArr[13] = f17 + 0.5f;
    }

    public static float[] convertMatrixFromAndroidGraphicsMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return new float[]{fArr[0], fArr[3], 0.0f, fArr[6], fArr[1], fArr[4], 0.0f, fArr[7], 0.0f, 0.0f, 1.0f, 0.0f, fArr[2], fArr[5], 0.0f, fArr[8]};
    }

    public static Matrix convertMatrixToAndroidGraphicsMatrix(float[] fArr) {
        float[] fArr2 = {fArr[0], fArr[4], fArr[12], fArr[1], fArr[5], fArr[13], fArr[3], fArr[7], fArr[15]};
        Matrix matrix = new Matrix();
        matrix.setValues(fArr2);
        return matrix;
    }

    private static float convertScalingTypeToVisibleFraction(ScalingType scalingType) {
        int i3 = AnonymousClass1.$SwitchMap$org$tencwebrtc$RendererCommon$ScalingType[scalingType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return BALANCED_VISIBLE_FRACTION;
                }
                throw new IllegalArgumentException();
            }
            return 0.0f;
        }
        return 1.0f;
    }

    public static Point getDisplaySize(ScalingType scalingType, float f16, int i3, int i16) {
        return getDisplaySize(convertScalingTypeToVisibleFraction(scalingType), f16, i3, i16);
    }

    public static float[] getLayoutMatrix(boolean z16, float f16, float f17) {
        float f18;
        float f19;
        if (f17 > f16) {
            f19 = f16 / f17;
            f18 = 1.0f;
        } else {
            f18 = f17 / f16;
            f19 = 1.0f;
        }
        if (z16) {
            f18 *= -1.0f;
        }
        float[] fArr = new float[16];
        android.opengl.Matrix.setIdentityM(fArr, 0);
        android.opengl.Matrix.scaleM(fArr, 0, f18, f19, 1.0f);
        adjustOrigin(fArr);
        return fArr;
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class VideoLayoutMeasure {
        private ScalingType scalingTypeMatchOrientation;
        private ScalingType scalingTypeMismatchOrientation;

        public VideoLayoutMeasure() {
            ScalingType scalingType = ScalingType.SCALE_ASPECT_BALANCED;
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType;
        }

        public Point measure(int i3, int i16, int i17, int i18) {
            boolean z16;
            ScalingType scalingType;
            int defaultSize = View.getDefaultSize(Integer.MAX_VALUE, i3);
            int defaultSize2 = View.getDefaultSize(Integer.MAX_VALUE, i16);
            if (i17 != 0 && i18 != 0 && defaultSize != 0 && defaultSize2 != 0) {
                float f16 = i17 / i18;
                float f17 = defaultSize / defaultSize2;
                boolean z17 = true;
                if (f16 > 1.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (f17 <= 1.0f) {
                    z17 = false;
                }
                if (z16 == z17) {
                    scalingType = this.scalingTypeMatchOrientation;
                } else {
                    scalingType = this.scalingTypeMismatchOrientation;
                }
                Point displaySize = RendererCommon.getDisplaySize(scalingType, f16, defaultSize, defaultSize2);
                if (View.MeasureSpec.getMode(i3) == 1073741824) {
                    displaySize.x = defaultSize;
                }
                if (View.MeasureSpec.getMode(i16) == 1073741824) {
                    displaySize.y = defaultSize2;
                }
                return displaySize;
            }
            return new Point(defaultSize, defaultSize2);
        }

        public void setScalingType(ScalingType scalingType) {
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType;
        }

        public void setScalingType(ScalingType scalingType, ScalingType scalingType2) {
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType2;
        }
    }

    private static Point getDisplaySize(float f16, float f17, int i3, int i16) {
        if (f16 != 0.0f && f17 != 0.0f) {
            return new Point(Math.min(i3, Math.round((i16 / f16) * f17)), Math.min(i16, Math.round((i3 / f16) / f17)));
        }
        return new Point(i3, i16);
    }
}
