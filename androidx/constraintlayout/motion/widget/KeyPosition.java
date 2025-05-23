package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* loaded from: classes.dex */
public class KeyPosition extends KeyPositionBase {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    private static final String PERCENT_X = "percentX";
    private static final String PERCENT_Y = "percentY";
    private static final String TAG = "KeyPosition";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    String mTransitionEasing = null;
    int mPathMotionArc = Key.UNSET;
    int mDrawPath = 0;
    float mPercentWidth = Float.NaN;
    float mPercentHeight = Float.NaN;
    float mPercentX = Float.NaN;
    float mPercentY = Float.NaN;
    float mAltPercentX = Float.NaN;
    float mAltPercentY = Float.NaN;
    int mPositionType = 0;
    private float mCalculatedPositionX = Float.NaN;
    private float mCalculatedPositionY = Float.NaN;

    /* loaded from: classes.dex */
    private static class Loader {
        private static final int CURVE_FIT = 4;
        private static final int DRAW_PATH = 5;
        private static final int FRAME_POSITION = 2;
        private static final int PATH_MOTION_ARC = 10;
        private static final int PERCENT_HEIGHT = 12;
        private static final int PERCENT_WIDTH = 11;
        private static final int PERCENT_X = 6;
        private static final int PERCENT_Y = 7;
        private static final int SIZE_PERCENT = 8;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TYPE = 9;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(R.styleable.KeyPosition_percentX, 6);
            mAttrMap.append(R.styleable.KeyPosition_percentY, 7);
            mAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        Loader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void read(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            keyPosition.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyPosition.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyPosition.mTargetId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            break;
                        }
                    case 2:
                        keyPosition.mFramePosition = typedArray.getInt(index, keyPosition.mFramePosition);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            keyPosition.mTransitionEasing = typedArray.getString(index);
                            break;
                        } else {
                            keyPosition.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        keyPosition.mCurveFit = typedArray.getInteger(index, keyPosition.mCurveFit);
                        break;
                    case 5:
                        keyPosition.mDrawPath = typedArray.getInt(index, keyPosition.mDrawPath);
                        break;
                    case 6:
                        keyPosition.mPercentX = typedArray.getFloat(index, keyPosition.mPercentX);
                        break;
                    case 7:
                        keyPosition.mPercentY = typedArray.getFloat(index, keyPosition.mPercentY);
                        break;
                    case 8:
                        float f16 = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        keyPosition.mPercentWidth = f16;
                        keyPosition.mPercentHeight = f16;
                        break;
                    case 9:
                        keyPosition.mPositionType = typedArray.getInt(index, keyPosition.mPositionType);
                        break;
                    case 10:
                        keyPosition.mPathMotionArc = typedArray.getInt(index, keyPosition.mPathMotionArc);
                        break;
                    case 11:
                        keyPosition.mPercentWidth = typedArray.getFloat(index, keyPosition.mPercentWidth);
                        break;
                    case 12:
                        keyPosition.mPercentHeight = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                }
            }
            if (keyPosition.mFramePosition == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public KeyPosition() {
        this.mType = 2;
    }

    private void calcCartesianPosition(float f16, float f17, float f18, float f19) {
        float f26;
        float f27;
        float f28;
        float f29 = f18 - f16;
        float f36 = f19 - f17;
        float f37 = 0.0f;
        if (Float.isNaN(this.mPercentX)) {
            f26 = 0.0f;
        } else {
            f26 = this.mPercentX;
        }
        if (Float.isNaN(this.mAltPercentY)) {
            f27 = 0.0f;
        } else {
            f27 = this.mAltPercentY;
        }
        if (Float.isNaN(this.mPercentY)) {
            f28 = 0.0f;
        } else {
            f28 = this.mPercentY;
        }
        if (!Float.isNaN(this.mAltPercentX)) {
            f37 = this.mAltPercentX;
        }
        this.mCalculatedPositionX = (int) (f16 + (f26 * f29) + (f37 * f36));
        this.mCalculatedPositionY = (int) (f17 + (f29 * f27) + (f36 * f28));
    }

    private void calcPathPosition(float f16, float f17, float f18, float f19) {
        float f26 = f18 - f16;
        float f27 = f19 - f17;
        float f28 = this.mPercentX;
        float f29 = this.mPercentY;
        this.mCalculatedPositionX = f16 + (f26 * f28) + ((-f27) * f29);
        this.mCalculatedPositionY = f17 + (f27 * f28) + (f26 * f29);
    }

    private void calcScreenPosition(int i3, int i16) {
        float f16 = this.mPercentX;
        float f17 = 0;
        this.mCalculatedPositionX = ((i3 - 0) * f16) + f17;
        this.mCalculatedPositionY = ((i16 - 0) * f16) + f17;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    void calcPosition(int i3, int i16, float f16, float f17, float f18, float f19) {
        int i17 = this.mPositionType;
        if (i17 != 1) {
            if (i17 != 2) {
                calcCartesianPosition(f16, f17, f18, f19);
                return;
            } else {
                calcScreenPosition(i3, i16);
                return;
            }
        }
        calcPathPosition(f16, f17, f18, f19);
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    float getPositionX() {
        return this.mCalculatedPositionX;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    float getPositionY() {
        return this.mCalculatedPositionY;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int i3, int i16, RectF rectF, RectF rectF2, float f16, float f17) {
        calcPosition(i3, i16, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        if (Math.abs(f16 - this.mCalculatedPositionX) < 20.0f && Math.abs(f17 - this.mCalculatedPositionY) < 20.0f) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f16, float f17, String[] strArr, float[] fArr) {
        int i3 = this.mPositionType;
        if (i3 != 1) {
            if (i3 != 2) {
                positionCartAttributes(rectF, rectF2, f16, f17, strArr, fArr);
                return;
            } else {
                positionScreenAttributes(view, rectF, rectF2, f16, f17, strArr, fArr);
                return;
            }
        }
        positionPathAttributes(rectF, rectF2, f16, f17, strArr, fArr);
    }

    void positionCartAttributes(RectF rectF, RectF rectF2, float f16, float f17, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        String str = strArr[0];
        if (str != null) {
            if (PERCENT_X.equals(str)) {
                fArr[0] = (f16 - centerX) / centerX2;
                fArr[1] = (f17 - centerY) / centerY2;
                return;
            } else {
                fArr[1] = (f16 - centerX) / centerX2;
                fArr[0] = (f17 - centerY) / centerY2;
                return;
            }
        }
        strArr[0] = PERCENT_X;
        fArr[0] = (f16 - centerX) / centerX2;
        strArr[1] = PERCENT_Y;
        fArr[1] = (f17 - centerY) / centerY2;
    }

    void positionPathAttributes(RectF rectF, RectF rectF2, float f16, float f17, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        float hypot = (float) Math.hypot(centerX2, centerY2);
        if (hypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f18 = centerX2 / hypot;
        float f19 = centerY2 / hypot;
        float f26 = f17 - centerY;
        float f27 = f16 - centerX;
        float f28 = ((f18 * f26) - (f27 * f19)) / hypot;
        float f29 = ((f18 * f27) + (f19 * f26)) / hypot;
        String str = strArr[0];
        if (str != null) {
            if (PERCENT_X.equals(str)) {
                fArr[0] = f29;
                fArr[1] = f28;
                return;
            }
            return;
        }
        strArr[0] = PERCENT_X;
        strArr[1] = PERCENT_Y;
        fArr[0] = f29;
        fArr[1] = f28;
    }

    void positionScreenAttributes(View view, RectF rectF, RectF rectF2, float f16, float f17, String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        String str = strArr[0];
        if (str != null) {
            if (PERCENT_X.equals(str)) {
                fArr[0] = f16 / width;
                fArr[1] = f17 / height;
                return;
            } else {
                fArr[1] = f16 / width;
                fArr[0] = f17 / height;
                return;
            }
        }
        strArr[0] = PERCENT_X;
        fArr[0] = f16 / width;
        strArr[1] = PERCENT_Y;
        fArr[1] = f17 / height;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c16 = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c16 = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c16 = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c16 = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals(PERCENT_X)) {
                    c16 = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals(PERCENT_Y)) {
                    c16 = 6;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                this.mTransitionEasing = obj.toString();
                return;
            case 1:
                this.mPercentWidth = toFloat(obj);
                return;
            case 2:
                this.mPercentHeight = toFloat(obj);
                return;
            case 3:
                this.mDrawPath = toInt(obj);
                return;
            case 4:
                float f16 = toFloat(obj);
                this.mPercentWidth = f16;
                this.mPercentHeight = f16;
                return;
            case 5:
                this.mPercentX = toFloat(obj);
                return;
            case 6:
                this.mPercentY = toFloat(obj);
                return;
            default:
                return;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }
}
