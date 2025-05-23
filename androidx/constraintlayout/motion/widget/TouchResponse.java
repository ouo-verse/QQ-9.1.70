package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class TouchResponse {
    private static final boolean DEBUG = false;
    static final int FLAG_DISABLE_POST_SCROLL = 1;
    static final int FLAG_DISABLE_SCROLL = 2;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP = 0;
    private float mLastTouchX;
    private float mLastTouchY;
    private final MotionLayout mMotionLayout;
    private static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private int mTouchAnchorSide = 0;
    private int mTouchSide = 0;
    private int mOnTouchUp = 0;
    private int mTouchAnchorId = -1;
    private int mTouchRegionId = -1;
    private int mLimitBoundsTo = -1;
    private float mTouchAnchorY = 0.5f;
    private float mTouchAnchorX = 0.5f;
    private float mTouchDirectionX = 0.0f;
    private float mTouchDirectionY = 1.0f;
    private boolean mDragStarted = false;
    private float[] mAnchorDpDt = new float[2];
    private float mMaxVelocity = 4.0f;
    private float mMaxAcceleration = 1.2f;
    private boolean mMoveWhenScrollAtTop = true;
    private float mDragScale = 1.0f;
    private int mFlags = 0;
    private float mDragThreshold = 10.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.mMotionLayout = motionLayout;
        fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void fill(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.mTouchAnchorId = typedArray.getResourceId(index, this.mTouchAnchorId);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i16 = typedArray.getInt(index, this.mTouchAnchorSide);
                this.mTouchAnchorSide = i16;
                float[] fArr = TOUCH_SIDES[i16];
                this.mTouchAnchorX = fArr[0];
                this.mTouchAnchorY = fArr[1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i17 = typedArray.getInt(index, this.mTouchSide);
                this.mTouchSide = i17;
                float[] fArr2 = TOUCH_DIRECTION[i17];
                this.mTouchDirectionX = fArr2[0];
                this.mTouchDirectionY = fArr2[1];
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.mMaxVelocity = typedArray.getFloat(index, this.mMaxVelocity);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.mMaxAcceleration = typedArray.getFloat(index, this.mMaxAcceleration);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.mMoveWhenScrollAtTop = typedArray.getBoolean(index, this.mMoveWhenScrollAtTop);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.mDragScale = typedArray.getFloat(index, this.mDragScale);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.mDragThreshold = typedArray.getFloat(index, this.mDragThreshold);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.mTouchRegionId = typedArray.getResourceId(index, this.mTouchRegionId);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.mOnTouchUp = typedArray.getInt(index, this.mOnTouchUp);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.mFlags = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.mLimitBoundsTo = typedArray.getResourceId(index, 0);
            }
        }
    }

    private void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
        fill(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float dot(float f16, float f17) {
        return (f16 * this.mTouchDirectionX) + (f17 * this.mTouchDirectionY);
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getFlags() {
        return this.mFlags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF getLimitBoundsTo(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i3 = this.mLimitBoundsTo;
        if (i3 == -1 || (findViewById = viewGroup.findViewById(i3)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getProgressDirection(float f16, float f17) {
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, this.mMotionLayout.getProgress(), this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f18 = this.mTouchDirectionX;
        if (f18 != 0.0f) {
            float[] fArr = this.mAnchorDpDt;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f16 * f18) / fArr[0];
        }
        float[] fArr2 = this.mAnchorDpDt;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f17 * this.mTouchDirectionY) / fArr2[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF getTouchRegion(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i3 = this.mTouchRegionId;
        if (i3 == -1 || (findViewById = viewGroup.findViewById(i3)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processTouchEvent(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i3, MotionScene motionScene) {
        float f16;
        float f17;
        int i16;
        float f18;
        float f19;
        float f26;
        motionTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = motionEvent.getRawY() - this.mLastTouchY;
                    float rawX = motionEvent.getRawX() - this.mLastTouchX;
                    if (Math.abs((this.mTouchDirectionX * rawX) + (this.mTouchDirectionY * rawY)) > this.mDragThreshold || this.mDragStarted) {
                        float progress = this.mMotionLayout.getProgress();
                        if (!this.mDragStarted) {
                            this.mDragStarted = true;
                            this.mMotionLayout.setProgress(progress);
                        }
                        int i17 = this.mTouchAnchorId;
                        if (i17 != -1) {
                            this.mMotionLayout.getAnchorDpDt(i17, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                        } else {
                            float min = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                            float[] fArr = this.mAnchorDpDt;
                            fArr[1] = this.mTouchDirectionY * min;
                            fArr[0] = min * this.mTouchDirectionX;
                        }
                        float f27 = this.mTouchDirectionX;
                        float[] fArr2 = this.mAnchorDpDt;
                        if (Math.abs(((f27 * fArr2[0]) + (this.mTouchDirectionY * fArr2[1])) * this.mDragScale) < 0.01d) {
                            float[] fArr3 = this.mAnchorDpDt;
                            fArr3[0] = 0.01f;
                            fArr3[1] = 0.01f;
                        }
                        if (this.mTouchDirectionX != 0.0f) {
                            f19 = rawX / this.mAnchorDpDt[0];
                        } else {
                            f19 = rawY / this.mAnchorDpDt[1];
                        }
                        float max = Math.max(Math.min(progress + f19, 1.0f), 0.0f);
                        if (max != this.mMotionLayout.getProgress()) {
                            this.mMotionLayout.setProgress(max);
                            motionTracker.computeCurrentVelocity(1000);
                            float xVelocity = motionTracker.getXVelocity();
                            float yVelocity = motionTracker.getYVelocity();
                            if (this.mTouchDirectionX != 0.0f) {
                                f26 = xVelocity / this.mAnchorDpDt[0];
                            } else {
                                f26 = yVelocity / this.mAnchorDpDt[1];
                            }
                            this.mMotionLayout.mLastVelocity = f26;
                        } else {
                            this.mMotionLayout.mLastVelocity = 0.0f;
                        }
                        this.mLastTouchX = motionEvent.getRawX();
                        this.mLastTouchY = motionEvent.getRawY();
                        return;
                    }
                    return;
                }
                return;
            }
            this.mDragStarted = false;
            motionTracker.computeCurrentVelocity(1000);
            float xVelocity2 = motionTracker.getXVelocity();
            float yVelocity2 = motionTracker.getYVelocity();
            float progress2 = this.mMotionLayout.getProgress();
            int i18 = this.mTouchAnchorId;
            if (i18 != -1) {
                this.mMotionLayout.getAnchorDpDt(i18, progress2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            } else {
                float min2 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                float[] fArr4 = this.mAnchorDpDt;
                fArr4[1] = this.mTouchDirectionY * min2;
                fArr4[0] = min2 * this.mTouchDirectionX;
            }
            float f28 = this.mTouchDirectionX;
            float[] fArr5 = this.mAnchorDpDt;
            float f29 = fArr5[0];
            float f36 = fArr5[1];
            if (f28 != 0.0f) {
                f16 = xVelocity2 / f29;
            } else {
                f16 = yVelocity2 / f36;
            }
            if (!Float.isNaN(f16)) {
                f17 = (f16 / 3.0f) + progress2;
            } else {
                f17 = progress2;
            }
            if (f17 != 0.0f && f17 != 1.0f && (i16 = this.mOnTouchUp) != 3) {
                MotionLayout motionLayout = this.mMotionLayout;
                if (f17 < 0.5d) {
                    f18 = 0.0f;
                } else {
                    f18 = 1.0f;
                }
                motionLayout.touchAnimateTo(i16, f18, f16);
                if (0.0f >= progress2 || 1.0f <= progress2) {
                    this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            }
            if (0.0f >= f17 || 1.0f <= f17) {
                this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                return;
            }
            return;
        }
        this.mLastTouchX = motionEvent.getRawX();
        this.mLastTouchY = motionEvent.getRawY();
        this.mDragStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scrollMove(float f16, float f17) {
        float f18;
        float progress = this.mMotionLayout.getProgress();
        if (!this.mDragStarted) {
            this.mDragStarted = true;
            this.mMotionLayout.setProgress(progress);
        }
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f19 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        if (Math.abs((f19 * fArr[0]) + (this.mTouchDirectionY * fArr[1])) < 0.01d) {
            float[] fArr2 = this.mAnchorDpDt;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f26 = this.mTouchDirectionX;
        if (f26 != 0.0f) {
            f18 = (f16 * f26) / this.mAnchorDpDt[0];
        } else {
            f18 = (f17 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
        }
        float max = Math.max(Math.min(progress + f18, 1.0f), 0.0f);
        if (max != this.mMotionLayout.getProgress()) {
            this.mMotionLayout.setProgress(max);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scrollUp(float f16, float f17) {
        float f18;
        boolean z16;
        boolean z17 = false;
        this.mDragStarted = false;
        float progress = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f19 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        float f26 = fArr[0];
        float f27 = this.mTouchDirectionY;
        float f28 = fArr[1];
        float f29 = 0.0f;
        if (f19 != 0.0f) {
            f18 = (f16 * f19) / f26;
        } else {
            f18 = (f17 * f27) / f28;
        }
        if (!Float.isNaN(f18)) {
            progress += f18 / 3.0f;
        }
        if (progress != 0.0f) {
            if (progress != 1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i3 = this.mOnTouchUp;
            if (i3 != 3) {
                z17 = true;
            }
            if (z17 & z16) {
                MotionLayout motionLayout = this.mMotionLayout;
                if (progress >= 0.5d) {
                    f29 = 1.0f;
                }
                motionLayout.touchAnimateTo(i3, f29, f18);
            }
        }
    }

    public void setAnchorId(int i3) {
        this.mTouchAnchorId = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDown(float f16, float f17) {
        this.mLastTouchX = f16;
        this.mLastTouchY = f17;
    }

    public void setMaxAcceleration(float f16) {
        this.mMaxAcceleration = f16;
    }

    public void setMaxVelocity(float f16) {
        this.mMaxVelocity = f16;
    }

    public void setRTL(boolean z16) {
        if (z16) {
            float[][] fArr = TOUCH_DIRECTION;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = TOUCH_SIDES;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = TOUCH_DIRECTION;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = TOUCH_SIDES;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = TOUCH_SIDES[this.mTouchAnchorSide];
        this.mTouchAnchorX = fArr5[0];
        this.mTouchAnchorY = fArr5[1];
        float[] fArr6 = TOUCH_DIRECTION[this.mTouchSide];
        this.mTouchDirectionX = fArr6[0];
        this.mTouchDirectionY = fArr6[1];
    }

    public void setTouchAnchorLocation(float f16, float f17) {
        this.mTouchAnchorX = f16;
        this.mTouchAnchorY = f17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUpTouchEvent(float f16, float f17) {
        this.mLastTouchX = f16;
        this.mLastTouchY = f17;
        this.mDragStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setupTouch() {
        View view;
        int i3 = this.mTouchAnchorId;
        if (i3 != -1) {
            view = this.mMotionLayout.findViewById(i3);
            if (view == null) {
                Log.e(TAG, "cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.2
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public void onScrollChange(NestedScrollView nestedScrollView2, int i16, int i17, int i18, int i19) {
                }
            });
        }
    }

    public String toString() {
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }
}
