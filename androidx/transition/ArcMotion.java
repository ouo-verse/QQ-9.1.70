package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes.dex */
public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle;
    private float mMaximumTangent;
    private float mMinimumHorizontalAngle;
    private float mMinimumHorizontalTangent;
    private float mMinimumVerticalAngle;
    private float mMinimumVerticalTangent;

    public ArcMotion() {
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }

    private static float toTangent(float f16) {
        if (f16 >= 0.0f && f16 <= 90.0f) {
            return (float) Math.tan(Math.toRadians(f16 / 2.0f));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f16, float f17, float f18, float f19) {
        boolean z16;
        float f26;
        float f27;
        float f28;
        Path path = new Path();
        path.moveTo(f16, f17);
        float f29 = f18 - f16;
        float f36 = f19 - f17;
        float f37 = (f29 * f29) + (f36 * f36);
        float f38 = (f16 + f18) / 2.0f;
        float f39 = (f17 + f19) / 2.0f;
        float f46 = 0.25f * f37;
        if (f17 > f19) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Math.abs(f29) < Math.abs(f36)) {
            float abs = Math.abs(f37 / (f36 * 2.0f));
            if (z16) {
                f27 = abs + f19;
                f26 = f18;
            } else {
                f27 = abs + f17;
                f26 = f16;
            }
            f28 = this.mMinimumVerticalTangent;
        } else {
            float f47 = f37 / (f29 * 2.0f);
            if (z16) {
                f27 = f17;
                f26 = f47 + f16;
            } else {
                f26 = f18 - f47;
                f27 = f19;
            }
            f28 = this.mMinimumHorizontalTangent;
        }
        float f48 = f46 * f28 * f28;
        float f49 = f38 - f26;
        float f56 = f39 - f27;
        float f57 = (f49 * f49) + (f56 * f56);
        float f58 = this.mMaximumTangent;
        float f59 = f46 * f58 * f58;
        if (f57 >= f48) {
            if (f57 > f59) {
                f48 = f59;
            } else {
                f48 = 0.0f;
            }
        }
        if (f48 != 0.0f) {
            float sqrt = (float) Math.sqrt(f48 / f57);
            f26 = ((f26 - f38) * sqrt) + f38;
            f27 = f39 + (sqrt * (f27 - f39));
        }
        path.cubicTo((f16 + f26) / 2.0f, (f17 + f27) / 2.0f, (f26 + f18) / 2.0f, (f27 + f19) / 2.0f, f18, f19);
        return path;
    }

    public void setMaximumAngle(float f16) {
        this.mMaximumAngle = f16;
        this.mMaximumTangent = toTangent(f16);
    }

    public void setMinimumHorizontalAngle(float f16) {
        this.mMinimumHorizontalAngle = f16;
        this.mMinimumHorizontalTangent = toTangent(f16);
    }

    public void setMinimumVerticalAngle(float f16) {
        this.mMinimumVerticalAngle = f16;
        this.mMinimumVerticalTangent = toTangent(f16);
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        obtainStyledAttributes.recycle();
    }
}
