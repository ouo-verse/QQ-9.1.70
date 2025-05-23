package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes.dex */
public class KeyTrigger extends Key {
    public static final int KEY_TYPE = 5;
    static final String NAME = "KeyTrigger";
    private static final String TAG = "KeyTrigger";
    RectF mCollisionRect;
    private Method mFireCross;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private Method mFireNegativeCross;
    private boolean mFireNegativeReset;
    private Method mFirePositiveCross;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    RectF mTargetRect;
    private int mTriggerCollisionId;
    private View mTriggerCollisionView;
    private int mTriggerID;
    private int mTriggerReceiver;
    float mTriggerSlack;
    private int mCurveFit = -1;
    private String mCross = null;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class Loader {
        private static final int COLLISION = 9;
        private static final int CROSS = 4;
        private static final int FRAME_POS = 8;
        private static final int NEGATIVE_CROSS = 1;
        private static final int POSITIVE_CROSS = 2;
        private static final int POST_LAYOUT = 10;
        private static final int TARGET_ID = 7;
        private static final int TRIGGER_ID = 6;
        private static final int TRIGGER_RECEIVER = 11;
        private static final int TRIGGER_SLACK = 5;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(R.styleable.KeyTrigger_triggerReceiver, 11);
        }

        Loader() {
        }

        public static void read(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                switch (mAttrMap.get(index)) {
                    case 1:
                        keyTrigger.mNegativeCross = typedArray.getString(index);
                        continue;
                    case 2:
                        keyTrigger.mPositiveCross = typedArray.getString(index);
                        continue;
                    case 4:
                        keyTrigger.mCross = typedArray.getString(index);
                        continue;
                    case 5:
                        keyTrigger.mTriggerSlack = typedArray.getFloat(index, keyTrigger.mTriggerSlack);
                        continue;
                    case 6:
                        keyTrigger.mTriggerID = typedArray.getResourceId(index, keyTrigger.mTriggerID);
                        continue;
                    case 7:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            keyTrigger.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyTrigger.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                continue;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyTrigger.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            break;
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, keyTrigger.mFramePosition);
                        keyTrigger.mFramePosition = integer;
                        keyTrigger.mFireThreshold = (integer + 0.5f) / 100.0f;
                        continue;
                    case 9:
                        keyTrigger.mTriggerCollisionId = typedArray.getResourceId(index, keyTrigger.mTriggerCollisionId);
                        continue;
                    case 10:
                        keyTrigger.mPostLayout = typedArray.getBoolean(index, keyTrigger.mPostLayout);
                        continue;
                    case 11:
                        keyTrigger.mTriggerReceiver = typedArray.getResourceId(index, keyTrigger.mTriggerReceiver);
                        break;
                }
                Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
            }
        }
    }

    public KeyTrigger() {
        int i3 = Key.UNSET;
        this.mTriggerReceiver = i3;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = i3;
        this.mTriggerCollisionId = i3;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mCollisionRect = new RectF();
        this.mTargetRect = new RectF();
        this.mType = 5;
        this.mCustomConstraints = new HashMap<>();
    }

    private void setUpRect(RectF rectF, View view, boolean z16) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z16) {
            view.getMatrix().mapRect(rectF);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void conditionallyFire(float f16, View view) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26 = true;
        if (this.mTriggerCollisionId != Key.UNSET) {
            if (this.mTriggerCollisionView == null) {
                this.mTriggerCollisionView = ((ViewGroup) view.getParent()).findViewById(this.mTriggerCollisionId);
            }
            setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
            setUpRect(this.mTargetRect, view, this.mPostLayout);
            if (this.mCollisionRect.intersect(this.mTargetRect)) {
                if (this.mFireCrossReset) {
                    this.mFireCrossReset = false;
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (this.mFirePositiveReset) {
                    this.mFirePositiveReset = false;
                    z19 = true;
                } else {
                    z19 = false;
                }
                this.mFireNegativeReset = true;
                z26 = z19;
                z18 = false;
            } else {
                if (!this.mFireCrossReset) {
                    this.mFireCrossReset = true;
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (this.mFireNegativeReset) {
                    this.mFireNegativeReset = false;
                    z18 = true;
                } else {
                    z18 = false;
                }
                this.mFirePositiveReset = true;
                z26 = false;
            }
        } else {
            if (this.mFireCrossReset) {
                float f17 = this.mFireThreshold;
                if ((f16 - f17) * (this.mFireLastPos - f17) < 0.0f) {
                    this.mFireCrossReset = false;
                    z16 = true;
                    if (!this.mFireNegativeReset) {
                        float f18 = this.mFireThreshold;
                        float f19 = f16 - f18;
                        if ((this.mFireLastPos - f18) * f19 < 0.0f && f19 < 0.0f) {
                            this.mFireNegativeReset = false;
                            z17 = true;
                            if (this.mFirePositiveReset) {
                                float f26 = this.mFireThreshold;
                                float f27 = f16 - f26;
                                if ((this.mFireLastPos - f26) * f27 < 0.0f && f27 > 0.0f) {
                                    this.mFirePositiveReset = false;
                                    z18 = z17;
                                }
                            } else if (Math.abs(f16 - this.mFireThreshold) > this.mTriggerSlack) {
                                this.mFirePositiveReset = true;
                            }
                            z26 = false;
                            z18 = z17;
                        }
                    } else if (Math.abs(f16 - this.mFireThreshold) > this.mTriggerSlack) {
                        this.mFireNegativeReset = true;
                    }
                    z17 = false;
                    if (this.mFirePositiveReset) {
                    }
                    z26 = false;
                    z18 = z17;
                }
            } else if (Math.abs(f16 - this.mFireThreshold) > this.mTriggerSlack) {
                this.mFireCrossReset = true;
            }
            z16 = false;
            if (!this.mFireNegativeReset) {
            }
            z17 = false;
            if (this.mFirePositiveReset) {
            }
            z26 = false;
            z18 = z17;
        }
        this.mFireLastPos = f16;
        if (z18 || z16 || z26) {
            ((MotionLayout) view.getParent()).fireTrigger(this.mTriggerID, z26, f16);
        }
        if (this.mTriggerReceiver != Key.UNSET) {
            view = ((MotionLayout) view.getParent()).findViewById(this.mTriggerReceiver);
        }
        if (z18 && this.mNegativeCross != null) {
            if (this.mFireNegativeCross == null) {
                try {
                    this.mFireNegativeCross = view.getClass().getMethod(this.mNegativeCross, new Class[0]);
                } catch (NoSuchMethodException unused) {
                    Log.e("KeyTrigger", "Could not find method \"" + this.mNegativeCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
                }
            }
            try {
                this.mFireNegativeCross.invoke(view, new Object[0]);
            } catch (Exception unused2) {
                Log.e("KeyTrigger", "Exception in call \"" + this.mNegativeCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
            }
        }
        if (z26 && this.mPositiveCross != null) {
            if (this.mFirePositiveCross == null) {
                try {
                    this.mFirePositiveCross = view.getClass().getMethod(this.mPositiveCross, new Class[0]);
                } catch (NoSuchMethodException unused3) {
                    Log.e("KeyTrigger", "Could not find method \"" + this.mPositiveCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
                }
            }
            try {
                this.mFirePositiveCross.invoke(view, new Object[0]);
            } catch (Exception unused4) {
                Log.e("KeyTrigger", "Exception in call \"" + this.mPositiveCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
            }
        }
        if (z16 && this.mCross != null) {
            if (this.mFireCross == null) {
                try {
                    this.mFireCross = view.getClass().getMethod(this.mCross, new Class[0]);
                } catch (NoSuchMethodException unused5) {
                    Log.e("KeyTrigger", "Could not find method \"" + this.mCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
                }
            }
            try {
                this.mFireCross.invoke(view, new Object[0]);
            } catch (Exception unused6) {
                Log.e("KeyTrigger", "Exception in call \"" + this.mCross + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
            }
        }
    }

    int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger), context);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
    }
}
