package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {
    private Path mOriginalPatternPath;
    private final Path mPatternPath;
    private final Matrix mTempMatrix;

    public PatternPathMotion() {
        Path path = new Path();
        this.mPatternPath = path;
        this.mTempMatrix = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.mOriginalPatternPath = path;
    }

    private static float distance(float f16, float f17) {
        return (float) Math.sqrt((f16 * f16) + (f17 * f17));
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f16, float f17, float f18, float f19) {
        float f26 = f18 - f16;
        float f27 = f19 - f17;
        float distance = distance(f26, f27);
        double atan2 = Math.atan2(f27, f26);
        this.mTempMatrix.setScale(distance, distance);
        this.mTempMatrix.postRotate((float) Math.toDegrees(atan2));
        this.mTempMatrix.postTranslate(f16, f17);
        Path path = new Path();
        this.mPatternPath.transform(this.mTempMatrix, path);
        return path;
    }

    public Path getPatternPath() {
        return this.mOriginalPatternPath;
    }

    public void setPatternPath(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f16 = fArr[0];
        float f17 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f18 = fArr[0];
        float f19 = fArr[1];
        if (f18 == f16 && f19 == f17) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.mTempMatrix.setTranslate(-f18, -f19);
        float f26 = f16 - f18;
        float f27 = f17 - f19;
        float distance = 1.0f / distance(f26, f27);
        this.mTempMatrix.postScale(distance, distance);
        this.mTempMatrix.postRotate((float) Math.toDegrees(-Math.atan2(f27, f26)));
        path.transform(this.mTempMatrix, this.mPatternPath);
        this.mOriginalPatternPath = path;
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.PATTERN_PATH_MOTION);
        try {
            String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (namedString != null) {
                setPatternPath(PathParser.createPathFromPathData(namedString));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public PatternPathMotion(Path path) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        setPatternPath(path);
    }
}
