package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class KeyAttributes extends Key {
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttribute";
    private String mTransitionEasing;
    private int mCurveFit = -1;
    private boolean mVisibility = false;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mProgress = Float.NaN;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_PIVOT_X = 19;
        private static final int ANDROID_PIVOT_Y = 20;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            mAttrMap.append(R.styleable.KeyAttribute_android_elevation, 2);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotation, 4);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotationX, 5);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotationY, 6);
            mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            mAttrMap.append(R.styleable.KeyAttribute_android_scaleX, 7);
            mAttrMap.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            mAttrMap.append(R.styleable.KeyAttribute_transitionEasing, 9);
            mAttrMap.append(R.styleable.KeyAttribute_motionTarget, 10);
            mAttrMap.append(R.styleable.KeyAttribute_framePosition, 12);
            mAttrMap.append(R.styleable.KeyAttribute_curveFit, 13);
            mAttrMap.append(R.styleable.KeyAttribute_android_scaleY, 14);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationX, 15);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationY, 16);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationZ, 17);
            mAttrMap.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        Loader() {
        }

        public static void read(KeyAttributes keyAttributes, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                switch (mAttrMap.get(index)) {
                    case 1:
                        keyAttributes.mAlpha = typedArray.getFloat(index, keyAttributes.mAlpha);
                        break;
                    case 2:
                        keyAttributes.mElevation = typedArray.getDimension(index, keyAttributes.mElevation);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                    case 4:
                        keyAttributes.mRotation = typedArray.getFloat(index, keyAttributes.mRotation);
                        break;
                    case 5:
                        keyAttributes.mRotationX = typedArray.getFloat(index, keyAttributes.mRotationX);
                        break;
                    case 6:
                        keyAttributes.mRotationY = typedArray.getFloat(index, keyAttributes.mRotationY);
                        break;
                    case 7:
                        keyAttributes.mScaleX = typedArray.getFloat(index, keyAttributes.mScaleX);
                        break;
                    case 8:
                        keyAttributes.mTransitionPathRotate = typedArray.getFloat(index, keyAttributes.mTransitionPathRotate);
                        break;
                    case 9:
                        keyAttributes.mTransitionEasing = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                            keyAttributes.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyAttributes.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyAttributes.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyAttributes.mTargetId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                            break;
                        }
                    case 12:
                        keyAttributes.mFramePosition = typedArray.getInt(index, keyAttributes.mFramePosition);
                        break;
                    case 13:
                        keyAttributes.mCurveFit = typedArray.getInteger(index, keyAttributes.mCurveFit);
                        break;
                    case 14:
                        keyAttributes.mScaleY = typedArray.getFloat(index, keyAttributes.mScaleY);
                        break;
                    case 15:
                        keyAttributes.mTranslationX = typedArray.getDimension(index, keyAttributes.mTranslationX);
                        break;
                    case 16:
                        keyAttributes.mTranslationY = typedArray.getDimension(index, keyAttributes.mTranslationY);
                        break;
                    case 17:
                        keyAttributes.mTranslationZ = typedArray.getDimension(index, keyAttributes.mTranslationZ);
                        break;
                    case 18:
                        keyAttributes.mProgress = typedArray.getFloat(index, keyAttributes.mProgress);
                        break;
                    case 19:
                        keyAttributes.mPivotX = typedArray.getDimension(index, keyAttributes.mPivotX);
                        break;
                    case 20:
                        keyAttributes.mPivotY = typedArray.getDimension(index, keyAttributes.mPivotY);
                        break;
                }
            }
        }
    }

    public KeyAttributes() {
        this.mType = 1;
        this.mCustomConstraints = new HashMap<>();
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x009f, code lost:
    
        if (r1.equals(com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation.KeyPath.SCALE_Y) == false) goto L12;
     */
    @Override // androidx.constraintlayout.motion.widget.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addValues(HashMap<String, SplineSet> hashMap) {
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            SplineSet splineSet = hashMap.get(next);
            char c16 = 7;
            if (next.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(next.substring(7));
                if (constraintAttribute != null) {
                    ((SplineSet.CustomSet) splineSet).setPoint(this.mFramePosition, constraintAttribute);
                }
            } else {
                switch (next.hashCode()) {
                    case -1249320806:
                        if (next.equals(BasicAnimation.KeyPath.ROTATION_X)) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (next.equals(BasicAnimation.KeyPath.ROTATION_Y)) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (next.equals("translationX")) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (next.equals("translationY")) {
                            c16 = 3;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (next.equals("translationZ")) {
                            c16 = 4;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (next.equals("progress")) {
                            c16 = 5;
                            break;
                        }
                        break;
                    case -908189618:
                        if (next.equals(BasicAnimation.KeyPath.SCALE_X)) {
                            c16 = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        break;
                    case -760884510:
                        if (next.equals("transformPivotX")) {
                            c16 = '\b';
                            break;
                        }
                        break;
                    case -760884509:
                        if (next.equals("transformPivotY")) {
                            c16 = '\t';
                            break;
                        }
                        break;
                    case -40300674:
                        if (next.equals(BasicAnimation.KeyPath.ROTATION)) {
                            c16 = '\n';
                            break;
                        }
                        break;
                    case -4379043:
                        if (next.equals("elevation")) {
                            c16 = 11;
                            break;
                        }
                        break;
                    case 37232917:
                        if (next.equals("transitionPathRotate")) {
                            c16 = '\f';
                            break;
                        }
                        break;
                    case 92909918:
                        if (next.equals(c.f123400v)) {
                            c16 = '\r';
                            break;
                        }
                        break;
                }
                c16 = '\uffff';
                switch (c16) {
                    case 0:
                        if (!Float.isNaN(this.mRotationX)) {
                            splineSet.setPoint(this.mFramePosition, this.mRotationX);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (!Float.isNaN(this.mRotationY)) {
                            splineSet.setPoint(this.mFramePosition, this.mRotationY);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (!Float.isNaN(this.mTranslationX)) {
                            splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (!Float.isNaN(this.mTranslationY)) {
                            splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (!Float.isNaN(this.mTranslationZ)) {
                            splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (!Float.isNaN(this.mProgress)) {
                            splineSet.setPoint(this.mFramePosition, this.mProgress);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (!Float.isNaN(this.mScaleX)) {
                            splineSet.setPoint(this.mFramePosition, this.mScaleX);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (!Float.isNaN(this.mScaleY)) {
                            splineSet.setPoint(this.mFramePosition, this.mScaleY);
                            break;
                        } else {
                            break;
                        }
                    case '\b':
                        if (!Float.isNaN(this.mRotationX)) {
                            splineSet.setPoint(this.mFramePosition, this.mPivotX);
                            break;
                        } else {
                            break;
                        }
                    case '\t':
                        if (!Float.isNaN(this.mRotationY)) {
                            splineSet.setPoint(this.mFramePosition, this.mPivotY);
                            break;
                        } else {
                            break;
                        }
                    case '\n':
                        if (!Float.isNaN(this.mRotation)) {
                            splineSet.setPoint(this.mFramePosition, this.mRotation);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (!Float.isNaN(this.mElevation)) {
                            splineSet.setPoint(this.mFramePosition, this.mElevation);
                            break;
                        } else {
                            break;
                        }
                    case '\f':
                        if (!Float.isNaN(this.mTransitionPathRotate)) {
                            splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                            break;
                        } else {
                            break;
                        }
                    case '\r':
                        if (!Float.isNaN(this.mAlpha)) {
                            splineSet.setPoint(this.mFramePosition, this.mAlpha);
                            break;
                        } else {
                            break;
                        }
                    default:
                        Log.v("KeyAttributes", "UNKNOWN addValues \"" + next + "\"");
                        break;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add(c.f123400v);
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add(BasicAnimation.KeyPath.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add(BasicAnimation.KeyPath.ROTATION_X);
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add(BasicAnimation.KeyPath.ROTATION_Y);
        }
        if (!Float.isNaN(this.mPivotX)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add(BasicAnimation.KeyPath.SCALE_X);
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add(BasicAnimation.KeyPath.SCALE_Y);
        }
        if (!Float.isNaN(this.mProgress)) {
            hashSet.add("progress");
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (this.mCurveFit == -1) {
            return;
        }
        if (!Float.isNaN(this.mAlpha)) {
            hashMap.put(c.f123400v, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mElevation)) {
            hashMap.put("elevation", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotation)) {
            hashMap.put(BasicAnimation.KeyPath.ROTATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashMap.put(BasicAnimation.KeyPath.ROTATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashMap.put(BasicAnimation.KeyPath.ROTATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotX)) {
            hashMap.put("transformPivotX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashMap.put("transformPivotY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashMap.put("translationX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashMap.put("translationY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashMap.put("translationZ", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashMap.put(BasicAnimation.KeyPath.SCALE_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashMap.put(BasicAnimation.KeyPath.SCALE_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mProgress)) {
            hashMap.put("progress", Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + it.next(), Integer.valueOf(this.mCurveFit));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c16 = 1;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals(BasicAnimation.KeyPath.ROTATION_X)) {
                    c16 = 2;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals(BasicAnimation.KeyPath.ROTATION_Y)) {
                    c16 = 3;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c16 = 4;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c16 = 5;
                    break;
                }
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c16 = 6;
                    break;
                }
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c16 = 7;
                    break;
                }
                break;
            case -908189618:
                if (str.equals(BasicAnimation.KeyPath.SCALE_X)) {
                    c16 = '\b';
                    break;
                }
                break;
            case -908189617:
                if (str.equals(BasicAnimation.KeyPath.SCALE_Y)) {
                    c16 = '\t';
                    break;
                }
                break;
            case -40300674:
                if (str.equals(BasicAnimation.KeyPath.ROTATION)) {
                    c16 = '\n';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c16 = 11;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c16 = '\f';
                    break;
                }
                break;
            case 92909918:
                if (str.equals(c.f123400v)) {
                    c16 = '\r';
                    break;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c16 = 14;
                    break;
                }
                break;
            case 1317633238:
                if (str.equals("mTranslationZ")) {
                    c16 = 15;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c16 = 16;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                this.mProgress = toFloat(obj);
                return;
            case 1:
                this.mTransitionEasing = obj.toString();
                return;
            case 2:
                this.mRotationX = toFloat(obj);
                return;
            case 3:
                this.mRotationY = toFloat(obj);
                return;
            case 4:
                this.mTranslationX = toFloat(obj);
                return;
            case 5:
                this.mTranslationY = toFloat(obj);
                return;
            case 6:
                this.mPivotX = toFloat(obj);
                return;
            case 7:
                this.mPivotY = toFloat(obj);
                return;
            case '\b':
                this.mScaleX = toFloat(obj);
                return;
            case '\t':
                this.mScaleY = toFloat(obj);
                return;
            case '\n':
                this.mRotation = toFloat(obj);
                return;
            case 11:
                this.mElevation = toFloat(obj);
                return;
            case '\f':
                this.mTransitionPathRotate = toFloat(obj);
                return;
            case '\r':
                this.mAlpha = toFloat(obj);
                return;
            case 14:
                this.mCurveFit = toInt(obj);
                return;
            case 15:
                this.mTranslationZ = toFloat(obj);
                return;
            case 16:
                this.mVisibility = toBoolean(obj);
                return;
            default:
                return;
        }
    }
}
