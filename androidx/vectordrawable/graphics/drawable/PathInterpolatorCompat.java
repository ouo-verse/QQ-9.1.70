package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void initCubic(float f16, float f17, float f18, float f19) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f16, f17, f18, f19, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(Path path) {
        int i3 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.mX = new float[min];
            this.mY = new float[min];
            float[] fArr = new float[2];
            for (int i16 = 0; i16 < min; i16++) {
                pathMeasure.getPosTan((i16 * length) / (min - 1), fArr, null);
                this.mX[i16] = fArr[0];
                this.mY[i16] = fArr[1];
            }
            if (Math.abs(this.mX[0]) <= 1.0E-5d && Math.abs(this.mY[0]) <= 1.0E-5d) {
                int i17 = min - 1;
                if (Math.abs(this.mX[i17] - 1.0f) <= 1.0E-5d && Math.abs(this.mY[i17] - 1.0f) <= 1.0E-5d) {
                    float f16 = 0.0f;
                    int i18 = 0;
                    while (i3 < min) {
                        float[] fArr2 = this.mX;
                        int i19 = i18 + 1;
                        float f17 = fArr2[i18];
                        if (f17 >= f16) {
                            fArr2[i3] = f17;
                            i3++;
                            f16 = f17;
                            i18 = i19;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f17);
                        }
                    }
                    if (!pathMeasure.nextContour()) {
                        return;
                    } else {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb5.append(this.mX[0]);
            sb5.append(",");
            sb5.append(this.mY[0]);
            sb5.append(" end:");
            int i26 = min - 1;
            sb5.append(this.mX[i26]);
            sb5.append(",");
            sb5.append(this.mY[i26]);
            throw new IllegalArgumentException(sb5.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }

    private void initQuad(float f16, float f17) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f16, f17, 1.0f, 1.0f);
        initPath(path);
    }

    private void parseInterpolatorFromTypeArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 4);
            Path createPathFromPathData = PathParser.createPathFromPathData(namedString);
            if (createPathFromPathData != null) {
                initPath(createPathFromPathData);
                return;
            }
            throw new InflateException("The path is null, which is created from " + namedString);
        }
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
                float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
                float namedFloat2 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
                boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
                if (hasAttribute == TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
                    if (!hasAttribute) {
                        initQuad(namedFloat, namedFloat2);
                        return;
                    } else {
                        initCubic(namedFloat, namedFloat2, TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
                        return;
                    }
                }
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            }
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        throw new InflateException("pathInterpolator requires the controlX1 attribute");
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

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }
}
