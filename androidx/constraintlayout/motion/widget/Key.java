package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class Key {
    static final String ALPHA = "alpha";
    static final String CUSTOM = "CUSTOM";
    static final String ELEVATION = "elevation";
    static final String PIVOT_X = "transformPivotX";
    static final String PIVOT_Y = "transformPivotY";
    static final String PROGRESS = "progress";
    static final String ROTATION = "rotation";
    static final String ROTATION_X = "rotationX";
    static final String ROTATION_Y = "rotationY";
    static final String SCALE_X = "scaleX";
    static final String SCALE_Y = "scaleY";
    static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    static final String TRANSLATION_X = "translationX";
    static final String TRANSLATION_Y = "translationY";
    static final String TRANSLATION_Z = "translationZ";
    public static int UNSET = -1;
    static final String WAVE_OFFSET = "waveOffset";
    static final String WAVE_PERIOD = "wavePeriod";
    static final String WAVE_VARIES_BY = "waveVariesBy";
    HashMap<String, ConstraintAttribute> mCustomConstraints;
    int mFramePosition;
    int mTargetId;
    String mTargetString;
    protected int mType;

    public Key() {
        int i3 = UNSET;
        this.mFramePosition = i3;
        this.mTargetId = i3;
        this.mTargetString = null;
    }

    public abstract void addValues(HashMap<String, SplineSet> hashMap);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void getAttributeNames(HashSet<String> hashSet);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void load(Context context, AttributeSet attributeSet);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean matches(String str) {
        String str2 = this.mTargetString;
        if (str2 != null && str != null) {
            return str.matches(str2);
        }
        return false;
    }

    public abstract void setValue(String str, Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float toFloat(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return Float.parseFloat(obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int toInt(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return Integer.parseInt(obj.toString());
    }

    public void setInterpolation(HashMap<String, Integer> hashMap) {
    }
}
