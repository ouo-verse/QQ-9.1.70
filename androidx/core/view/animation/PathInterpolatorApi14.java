package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i3 = ((int) (length / 0.002f)) + 1;
        this.mX = new float[i3];
        this.mY = new float[i3];
        float[] fArr = new float[2];
        for (int i16 = 0; i16 < i3; i16++) {
            pathMeasure.getPosTan((i16 * length) / (i3 - 1), fArr, null);
            this.mX[i16] = fArr[0];
            this.mY[i16] = fArr[1];
        }
    }

    private static Path createCubic(float f16, float f17, float f18, float f19) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f16, f17, f18, f19, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f16, float f17) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f16, f17, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        if (f16 <= 0.0f) {
            return 0.0f;
        }
        if (f16 >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i3 = 0;
        while (length - i3 > 1) {
            int i16 = (i3 + length) / 2;
            if (f16 < this.mX[i16]) {
                length = i16;
            } else {
                i3 = i16;
            }
        }
        float[] fArr = this.mX;
        float f17 = fArr[length];
        float f18 = fArr[i3];
        float f19 = f17 - f18;
        if (f19 == 0.0f) {
            return this.mY[i3];
        }
        float f26 = (f16 - f18) / f19;
        float[] fArr2 = this.mY;
        float f27 = fArr2[i3];
        return f27 + (f26 * (fArr2[length] - f27));
    }

    PathInterpolatorApi14(float f16, float f17) {
        this(createQuad(f16, f17));
    }

    PathInterpolatorApi14(float f16, float f17, float f18, float f19) {
        this(createCubic(f16, f17, f18, f19));
    }
}
