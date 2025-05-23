package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    boolean firstDown;
    private float lastPos;
    private float lastY;
    private long mAnimationStartTime;
    private int mBeginState;
    private RectF mBoundsCheck;
    int mCurrentState;
    int mDebugPath;
    private DecelerateInterpolator mDecelerateLogic;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    HashMap<View, MotionController> mFrameArrayList;
    private int mFrames;
    int mHeightMeasureMode;
    private boolean mInLayout;
    boolean mInTransition;
    boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    Interpolator mInterpolator;
    boolean mIsAnimating;
    private boolean mKeepAnimating;
    private KeyCache mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    float mLastVelocity;
    private int mLastWidthMeasureSpec;
    private float mListenerPosition;
    private int mListenerState;
    protected boolean mMeasureDuringTransition;
    Model mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private ArrayList<MotionHelper> mOnHideHelpers;
    private ArrayList<MotionHelper> mOnShowHelpers;
    float mPostInterpolationPosition;
    private View mRegionView;
    MotionScene mScene;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private StateCache mStateCache;
    private StopLogic mStopLogic;
    private boolean mTemporalInterpolator;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private ArrayList<TransitionListener> mTransitionListeners;
    float mTransitionPosition;
    TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState;

        static {
            int[] iArr = new int[TransitionState.values().length];
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = iArr;
            try {
                iArr[TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class DecelerateInterpolator extends MotionInterpolator {
        float maxA;
        float initalV = 0.0f;
        float currentP = 0.0f;

        DecelerateInterpolator() {
        }

        public void config(float f16, float f17, float f18) {
            this.initalV = f16;
            this.currentP = f17;
            this.maxA = f18;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17;
            float f18;
            float f19 = this.initalV;
            if (f19 > 0.0f) {
                float f26 = this.maxA;
                if (f19 / f26 < f16) {
                    f16 = f19 / f26;
                }
                MotionLayout.this.mLastVelocity = f19 - (f26 * f16);
                f17 = (f19 * f16) - (((f26 * f16) * f16) / 2.0f);
                f18 = this.currentP;
            } else {
                float f27 = this.maxA;
                if ((-f19) / f27 < f16) {
                    f16 = (-f19) / f27;
                }
                MotionLayout.this.mLastVelocity = (f27 * f16) + f19;
                f17 = (f19 * f16) + (((f27 * f16) * f16) / 2.0f);
                f18 = this.currentP;
            }
            return f17 + f18;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return MotionLayout.this.mLastVelocity;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;
        DashPathEffect mDashPathEffect;
        Paint mFillPaint;
        int mKeyFrameCount;
        float[] mKeyFramePoints;
        Paint mPaint;
        Paint mPaintGraph;
        Paint mPaintKeyframes;
        Path mPath;
        int[] mPathMode;
        float[] mPoints;
        private float[] mRectangle;
        int mShadowTranslate;
        Paint mTextPaint;
        final int RED_COLOR = -21965;
        final int KEYFRAME_COLOR = -2067046;
        final int GRAPH_COLOR = -13391360;
        final int SHADOW_COLOR = 1996488704;
        final int DIAMOND_SIZE = 10;
        Rect mBounds = new Rect();
        boolean mPresentationMode = false;

        public DevModeDraw() {
            this.mShadowTranslate = 1;
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            this.mPaint.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.mPaintKeyframes = paint2;
            paint2.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.mPaintGraph = paint3;
            paint3.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.mTextPaint = paint4;
            paint4.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            Paint paint5 = new Paint();
            this.mFillPaint = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = dashPathEffect;
            this.mPaintGraph.setPathEffect(dashPathEffect);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode) {
                this.mPaint.setStrokeWidth(8.0f);
                this.mFillPaint.setStrokeWidth(8.0f);
                this.mPaintKeyframes.setStrokeWidth(8.0f);
                this.mShadowTranslate = 4;
            }
        }

        private void drawBasicPath(Canvas canvas) {
            canvas.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathAsConfigured(Canvas canvas) {
            boolean z16 = false;
            boolean z17 = false;
            for (int i3 = 0; i3 < this.mKeyFrameCount; i3++) {
                int i16 = this.mPathMode[i3];
                if (i16 == 1) {
                    z16 = true;
                }
                if (i16 == 2) {
                    z17 = true;
                }
            }
            if (z16) {
                drawPathRelative(canvas);
            }
            if (z17) {
                drawPathCartesian(canvas);
            }
        }

        private void drawPathCartesian(Canvas canvas) {
            float[] fArr = this.mPoints;
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[fArr.length - 2];
            float f19 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f16, f18), Math.max(f17, f19), Math.max(f16, f18), Math.max(f17, f19), this.mPaintGraph);
            canvas.drawLine(Math.min(f16, f18), Math.min(f17, f19), Math.min(f16, f18), Math.max(f17, f19), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(Canvas canvas, float f16, float f17) {
            float[] fArr = this.mPoints;
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f26 = fArr[fArr.length - 2];
            float f27 = fArr[fArr.length - 1];
            float min = Math.min(f18, f26);
            float max = Math.max(f19, f27);
            float min2 = f16 - Math.min(f18, f26);
            float max2 = Math.max(f19, f27) - f17;
            String str = "" + (((int) (((min2 * 100.0f) / Math.abs(f26 - f18)) + 0.5d)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawText(str, ((min2 / 2.0f) - (this.mBounds.width() / 2)) + min, f17 - 20.0f, this.mTextPaint);
            canvas.drawLine(f16, f17, Math.min(f18, f26), f17, this.mPaintGraph);
            String str2 = "" + (((int) (((max2 * 100.0f) / Math.abs(f27 - f19)) + 0.5d)) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas.drawText(str2, f16 + 5.0f, max - ((max2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f16, f17, f16, Math.max(f19, f27), this.mPaintGraph);
        }

        private void drawPathRelative(Canvas canvas) {
            float[] fArr = this.mPoints;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.mPaintGraph);
        }

        private void drawPathRelativeTicks(Canvas canvas, float f16, float f17) {
            float[] fArr = this.mPoints;
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f26 = fArr[fArr.length - 2];
            float f27 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot(f18 - f26, f19 - f27);
            float f28 = f26 - f18;
            float f29 = f27 - f19;
            float f36 = (((f16 - f18) * f28) + ((f17 - f19) * f29)) / (hypot * hypot);
            float f37 = f18 + (f28 * f36);
            float f38 = f19 + (f36 * f29);
            Path path = new Path();
            path.moveTo(f16, f17);
            path.lineTo(f37, f38);
            float hypot2 = (float) Math.hypot(f37 - f16, f38 - f17);
            String str = "" + (((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
            canvas.drawLine(f16, f17, f37, f38, this.mPaintGraph);
        }

        private void drawPathScreenTicks(Canvas canvas, float f16, float f17, int i3, int i16) {
            String str = "" + (((int) ((((f16 - (i3 / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i3)) + 0.5d)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawText(str, ((f16 / 2.0f) - (this.mBounds.width() / 2)) + 0.0f, f17 - 20.0f, this.mTextPaint);
            canvas.drawLine(f16, f17, Math.min(0.0f, 1.0f), f17, this.mPaintGraph);
            String str2 = "" + (((int) ((((f17 - (i16 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i16)) + 0.5d)) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas.drawText(str2, f16 + 5.0f, 0.0f - ((f17 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f16, f17, f16, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawRectangle(Canvas canvas, MotionController motionController) {
            this.mPath.reset();
            for (int i3 = 0; i3 <= 50; i3++) {
                motionController.buildRect(i3 / 50, this.mRectangle, 0);
                Path path = this.mPath;
                float[] fArr = this.mRectangle;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.mPath;
                float[] fArr2 = this.mRectangle;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.mPath;
                float[] fArr3 = this.mRectangle;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.mPath;
                float[] fArr4 = this.mRectangle;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.mPath.close();
            }
            this.mPaint.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.mPath, this.mPaint);
            canvas.translate(-2.0f, -2.0f);
            this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawPath(this.mPath, this.mPaint);
        }

        private void drawTicks(Canvas canvas, int i3, int i16, MotionController motionController) {
            int i17;
            int i18;
            int i19;
            float f16;
            float f17;
            View view = motionController.mView;
            if (view != null) {
                i17 = view.getWidth();
                i18 = motionController.mView.getHeight();
            } else {
                i17 = 0;
                i18 = 0;
            }
            for (int i26 = 1; i26 < i16 - 1; i26++) {
                if (i3 != 4 || this.mPathMode[i26 - 1] != 0) {
                    float[] fArr = this.mKeyFramePoints;
                    int i27 = i26 * 2;
                    float f18 = fArr[i27];
                    float f19 = fArr[i27 + 1];
                    this.mPath.reset();
                    this.mPath.moveTo(f18, f19 + 10.0f);
                    this.mPath.lineTo(f18 + 10.0f, f19);
                    this.mPath.lineTo(f18, f19 - 10.0f);
                    this.mPath.lineTo(f18 - 10.0f, f19);
                    this.mPath.close();
                    int i28 = i26 - 1;
                    motionController.getKeyFrame(i28);
                    if (i3 == 4) {
                        int i29 = this.mPathMode[i28];
                        if (i29 == 1) {
                            drawPathRelativeTicks(canvas, f18 - 0.0f, f19 - 0.0f);
                        } else if (i29 == 2) {
                            drawPathCartesianTicks(canvas, f18 - 0.0f, f19 - 0.0f);
                        } else if (i29 == 3) {
                            i19 = 3;
                            f16 = f19;
                            f17 = f18;
                            drawPathScreenTicks(canvas, f18 - 0.0f, f19 - 0.0f, i17, i18);
                            canvas.drawPath(this.mPath, this.mFillPaint);
                        }
                        i19 = 3;
                        f16 = f19;
                        f17 = f18;
                        canvas.drawPath(this.mPath, this.mFillPaint);
                    } else {
                        i19 = 3;
                        f16 = f19;
                        f17 = f18;
                    }
                    if (i3 == 2) {
                        drawPathRelativeTicks(canvas, f17 - 0.0f, f16 - 0.0f);
                    }
                    if (i3 == i19) {
                        drawPathCartesianTicks(canvas, f17 - 0.0f, f16 - 0.0f);
                    }
                    if (i3 == 6) {
                        drawPathScreenTicks(canvas, f17 - 0.0f, f16 - 0.0f, i17, i18);
                    }
                    canvas.drawPath(this.mPath, this.mFillPaint);
                }
            }
            float[] fArr2 = this.mPoints;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.mPaintKeyframes);
                float[] fArr3 = this.mPoints;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.mPaintKeyframes);
            }
        }

        private void drawTranslation(Canvas canvas, float f16, float f17, float f18, float f19) {
            canvas.drawRect(f16, f17, f18, f19, this.mPaintGraph);
            canvas.drawLine(f16, f17, f18, f19, this.mPaintGraph);
        }

        public void draw(Canvas canvas, HashMap<View, MotionController> hashMap, int i3, int i16) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i16 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.mEndState) + ":" + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.mTextPaint);
                    canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.mPaint);
                }
                for (MotionController motionController : hashMap.values()) {
                    int drawPath = motionController.getDrawPath();
                    if (i16 > 0 && drawPath == 0) {
                        drawPath = 1;
                    }
                    if (drawPath != 0) {
                        this.mKeyFrameCount = motionController.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
                        if (drawPath >= 1) {
                            int i17 = i3 / 16;
                            float[] fArr = this.mPoints;
                            if (fArr == null || fArr.length != i17 * 2) {
                                this.mPoints = new float[i17 * 2];
                                this.mPath = new Path();
                            }
                            int i18 = this.mShadowTranslate;
                            canvas.translate(i18, i18);
                            this.mPaint.setColor(1996488704);
                            this.mFillPaint.setColor(1996488704);
                            this.mPaintKeyframes.setColor(1996488704);
                            this.mPaintGraph.setColor(1996488704);
                            motionController.buildPath(this.mPoints, i17);
                            drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                            this.mPaint.setColor(-21965);
                            this.mPaintKeyframes.setColor(-2067046);
                            this.mFillPaint.setColor(-2067046);
                            this.mPaintGraph.setColor(-13391360);
                            int i19 = this.mShadowTranslate;
                            canvas.translate(-i19, -i19);
                            drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                            if (drawPath == 5) {
                                drawRectangle(canvas, motionController);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        public void drawAll(Canvas canvas, int i3, int i16, MotionController motionController) {
            if (i3 == 4) {
                drawPathAsConfigured(canvas);
            }
            if (i3 == 2) {
                drawPathRelative(canvas);
            }
            if (i3 == 3) {
                drawPathCartesian(canvas);
            }
            drawBasicPath(canvas);
            drawTicks(canvas, i3, i16, motionController);
        }

        void getTextBounds(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.mBounds);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class Model {
        int mEndId;
        int mStartId;
        ConstraintWidgetContainer mLayoutStart = new ConstraintWidgetContainer();
        ConstraintWidgetContainer mLayoutEnd = new ConstraintWidgetContainer();
        ConstraintSet mStart = null;
        ConstraintSet mEnd = null;

        Model() {
        }

        private void debugLayout(String str, ConstraintWidgetContainer constraintWidgetContainer) {
            String str2;
            String str3;
            String str4;
            String str5 = str + " " + Debug.getName((View) constraintWidgetContainer.getCompanionWidget());
            Log.v(MotionLayout.TAG, str5 + "  ========= " + constraintWidgetContainer);
            int size = constraintWidgetContainer.getChildren().size();
            for (int i3 = 0; i3 < size; i3++) {
                String str6 = str5 + "[" + i3 + "] ";
                ConstraintWidget constraintWidget = constraintWidgetContainer.getChildren().get(i3);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                String str7 = "_";
                if (constraintWidget.mTop.mTarget == null) {
                    str2 = "_";
                } else {
                    str2 = "T";
                }
                sb5.append(str2);
                String sb6 = sb5.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(sb6);
                if (constraintWidget.mBottom.mTarget == null) {
                    str3 = "_";
                } else {
                    str3 = "B";
                }
                sb7.append(str3);
                String sb8 = sb7.toString();
                StringBuilder sb9 = new StringBuilder();
                sb9.append(sb8);
                if (constraintWidget.mLeft.mTarget == null) {
                    str4 = "_";
                } else {
                    str4 = "L";
                }
                sb9.append(str4);
                String sb10 = sb9.toString();
                StringBuilder sb11 = new StringBuilder();
                sb11.append(sb10);
                if (constraintWidget.mRight.mTarget != null) {
                    str7 = BdhLogUtil.LogTag.Tag_Req;
                }
                sb11.append(str7);
                String sb12 = sb11.toString();
                View view = (View) constraintWidget.getCompanionWidget();
                String name = Debug.getName(view);
                if (view instanceof TextView) {
                    name = name + "(" + ((Object) ((TextView) view).getText()) + ")";
                }
                Log.v(MotionLayout.TAG, str6 + "  " + name + " " + constraintWidget + " " + sb12);
            }
            Log.v(MotionLayout.TAG, str5 + " done. ");
        }

        private void debugLayoutParam(String str, ConstraintLayout.LayoutParams layoutParams) {
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" ");
            if (layoutParams.startToStart != -1) {
                str2 = "SS";
            } else {
                str2 = "__";
            }
            sb5.append(str2);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            String str13 = "|__";
            if (layoutParams.startToEnd == -1) {
                str3 = "|__";
            } else {
                str3 = "|SE";
            }
            sb7.append(str3);
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(sb8);
            if (layoutParams.endToStart == -1) {
                str4 = "|__";
            } else {
                str4 = "|ES";
            }
            sb9.append(str4);
            String sb10 = sb9.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(sb10);
            if (layoutParams.endToEnd == -1) {
                str5 = "|__";
            } else {
                str5 = "|EE";
            }
            sb11.append(str5);
            String sb12 = sb11.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(sb12);
            if (layoutParams.leftToLeft == -1) {
                str6 = "|__";
            } else {
                str6 = "|LL";
            }
            sb13.append(str6);
            String sb14 = sb13.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append(sb14);
            if (layoutParams.leftToRight == -1) {
                str7 = "|__";
            } else {
                str7 = "|LR";
            }
            sb15.append(str7);
            String sb16 = sb15.toString();
            StringBuilder sb17 = new StringBuilder();
            sb17.append(sb16);
            if (layoutParams.rightToLeft == -1) {
                str8 = "|__";
            } else {
                str8 = "|RL";
            }
            sb17.append(str8);
            String sb18 = sb17.toString();
            StringBuilder sb19 = new StringBuilder();
            sb19.append(sb18);
            if (layoutParams.rightToRight == -1) {
                str9 = "|__";
            } else {
                str9 = "|RR";
            }
            sb19.append(str9);
            String sb20 = sb19.toString();
            StringBuilder sb21 = new StringBuilder();
            sb21.append(sb20);
            if (layoutParams.topToTop == -1) {
                str10 = "|__";
            } else {
                str10 = "|TT";
            }
            sb21.append(str10);
            String sb22 = sb21.toString();
            StringBuilder sb23 = new StringBuilder();
            sb23.append(sb22);
            if (layoutParams.topToBottom == -1) {
                str11 = "|__";
            } else {
                str11 = "|TB";
            }
            sb23.append(str11);
            String sb24 = sb23.toString();
            StringBuilder sb25 = new StringBuilder();
            sb25.append(sb24);
            if (layoutParams.bottomToTop == -1) {
                str12 = "|__";
            } else {
                str12 = "|BT";
            }
            sb25.append(str12);
            String sb26 = sb25.toString();
            StringBuilder sb27 = new StringBuilder();
            sb27.append(sb26);
            if (layoutParams.bottomToBottom != -1) {
                str13 = "|BB";
            }
            sb27.append(str13);
            Log.v(MotionLayout.TAG, str + sb27.toString());
        }

        private void debugWidget(String str, ConstraintWidget constraintWidget) {
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" ");
            String str7 = "B";
            String str8 = "__";
            if (constraintWidget.mTop.mTarget == null) {
                str2 = "__";
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("T");
                if (constraintWidget.mTop.mTarget.mType != ConstraintAnchor.Type.TOP) {
                    str6 = "B";
                } else {
                    str6 = "T";
                }
                sb6.append(str6);
                str2 = sb6.toString();
            }
            sb5.append(str2);
            String sb7 = sb5.toString();
            StringBuilder sb8 = new StringBuilder();
            sb8.append(sb7);
            if (constraintWidget.mBottom.mTarget == null) {
                str3 = "__";
            } else {
                StringBuilder sb9 = new StringBuilder();
                sb9.append("B");
                if (constraintWidget.mBottom.mTarget.mType == ConstraintAnchor.Type.TOP) {
                    str7 = "T";
                }
                sb9.append(str7);
                str3 = sb9.toString();
            }
            sb8.append(str3);
            String sb10 = sb8.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(sb10);
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft.mTarget;
            String str9 = BdhLogUtil.LogTag.Tag_Req;
            if (constraintAnchor == null) {
                str4 = "__";
            } else {
                StringBuilder sb12 = new StringBuilder();
                sb12.append("L");
                if (constraintWidget.mLeft.mTarget.mType == ConstraintAnchor.Type.LEFT) {
                    str5 = "L";
                } else {
                    str5 = BdhLogUtil.LogTag.Tag_Req;
                }
                sb12.append(str5);
                str4 = sb12.toString();
            }
            sb11.append(str4);
            String sb13 = sb11.toString();
            StringBuilder sb14 = new StringBuilder();
            sb14.append(sb13);
            if (constraintWidget.mRight.mTarget != null) {
                StringBuilder sb15 = new StringBuilder();
                sb15.append(BdhLogUtil.LogTag.Tag_Req);
                if (constraintWidget.mRight.mTarget.mType == ConstraintAnchor.Type.LEFT) {
                    str9 = "L";
                }
                sb15.append(str9);
                str8 = sb15.toString();
            }
            sb14.append(str8);
            Log.v(MotionLayout.TAG, str + sb14.toString() + " ---  " + constraintWidget);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            Iterator<ConstraintWidget> it = constraintWidgetContainer.getChildren().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                sparseArray.put(((View) next.getCompanionWidget()).getId(), next);
            }
            Iterator<ConstraintWidget> it5 = constraintWidgetContainer.getChildren().iterator();
            while (it5.hasNext()) {
                ConstraintWidget next2 = it5.next();
                View view = (View) next2.getCompanionWidget();
                constraintSet.applyToLayoutParams(view.getId(), layoutParams);
                next2.setWidth(constraintSet.getWidth(view.getId()));
                next2.setHeight(constraintSet.getHeight(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.applyToHelper((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (constraintSet.getVisibilityMode(view.getId()) == 1) {
                    next2.setVisibility(view.getVisibility());
                } else {
                    next2.setVisibility(constraintSet.getVisibility(view.getId()));
                }
            }
            Iterator<ConstraintWidget> it6 = constraintWidgetContainer.getChildren().iterator();
            while (it6.hasNext()) {
                ConstraintWidget next3 = it6.next();
                if (next3 instanceof VirtualLayout) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) next3.getCompanionWidget();
                    Helper helper = (Helper) next3;
                    constraintHelper.updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).captureWidgets();
                }
            }
        }

        public void build() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.mFrameArrayList.clear();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = MotionLayout.this.getChildAt(i3);
                MotionLayout.this.mFrameArrayList.put(childAt, new MotionController(childAt));
            }
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt2 = MotionLayout.this.getChildAt(i16);
                MotionController motionController = MotionLayout.this.mFrameArrayList.get(childAt2);
                if (motionController != null) {
                    if (this.mStart != null) {
                        ConstraintWidget widget = getWidget(this.mLayoutStart, childAt2);
                        if (widget != null) {
                            motionController.setStartState(widget, this.mStart);
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                    if (this.mEnd != null) {
                        ConstraintWidget widget2 = getWidget(this.mLayoutEnd, childAt2);
                        if (widget2 != null) {
                            motionController.setEndState(widget2, this.mEnd);
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
            }
        }

        void copy(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            HashMap<ConstraintWidget, ConstraintWidget> hashMap = new HashMap<>();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.getChildren().clear();
            constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
            Iterator<ConstraintWidget> it = children.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (next instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                    constraintWidget = new androidx.constraintlayout.solver.widgets.Barrier();
                } else if (next instanceof Guideline) {
                    constraintWidget = new Guideline();
                } else if (next instanceof Flow) {
                    constraintWidget = new Flow();
                } else if (next instanceof Helper) {
                    constraintWidget = new HelperWidget();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                constraintWidgetContainer2.add(constraintWidget);
                hashMap.put(next, constraintWidget);
            }
            Iterator<ConstraintWidget> it5 = children.iterator();
            while (it5.hasNext()) {
                ConstraintWidget next2 = it5.next();
                hashMap.get(next2).copy(next2, hashMap);
            }
        }

        ConstraintWidget getWidget(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.getCompanionWidget() == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintWidget constraintWidget = children.get(i3);
                if (constraintWidget.getCompanionWidget() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        void initFrom(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.mStart = constraintSet;
            this.mEnd = constraintSet2;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(((ConstraintLayout) MotionLayout.this).mLayoutWidget.getMeasurer());
            this.mLayoutEnd.setMeasurer(((ConstraintLayout) MotionLayout.this).mLayoutWidget.getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            copy(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.mLayoutStart);
            copy(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.mLayoutEnd);
            if (MotionLayout.this.mTransitionLastPosition > 0.5d) {
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
            } else {
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
            }
            this.mLayoutStart.setRtl(MotionLayout.this.isRtl());
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(MotionLayout.this.isRtl());
            this.mLayoutEnd.updateHierarchy();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutStart;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    this.mLayoutEnd.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutStart;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    this.mLayoutEnd.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            }
        }

        public boolean isNotConfiguredWith(int i3, int i16) {
            if (i3 == this.mStartId && i16 == this.mEndId) {
                return false;
            }
            return true;
        }

        public void measure(int i3, int i16) {
            boolean z16;
            boolean z17;
            boolean z18;
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.mWidthMeasureMode = mode;
            motionLayout.mHeightMeasureMode = mode2;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            MotionLayout motionLayout2 = MotionLayout.this;
            if (motionLayout2.mCurrentState == motionLayout2.getStartState()) {
                MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i3, i16);
                if (this.mStart != null) {
                    MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i3, i16);
                }
            } else {
                if (this.mStart != null) {
                    MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i3, i16);
                }
                MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i3, i16);
            }
            boolean z19 = false;
            if ((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                MotionLayout motionLayout3 = MotionLayout.this;
                motionLayout3.mWidthMeasureMode = mode;
                motionLayout3.mHeightMeasureMode = mode2;
                if (motionLayout3.mCurrentState == motionLayout3.getStartState()) {
                    MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i3, i16);
                    if (this.mStart != null) {
                        MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i3, i16);
                    }
                } else {
                    if (this.mStart != null) {
                        MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i3, i16);
                    }
                    MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i3, i16);
                }
                MotionLayout.this.mStartWrapWidth = this.mLayoutStart.getWidth();
                MotionLayout.this.mStartWrapHeight = this.mLayoutStart.getHeight();
                MotionLayout.this.mEndWrapWidth = this.mLayoutEnd.getWidth();
                MotionLayout.this.mEndWrapHeight = this.mLayoutEnd.getHeight();
                MotionLayout motionLayout4 = MotionLayout.this;
                if (motionLayout4.mStartWrapWidth == motionLayout4.mEndWrapWidth && motionLayout4.mStartWrapHeight == motionLayout4.mEndWrapHeight) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                motionLayout4.mMeasureDuringTransition = z18;
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            int i17 = motionLayout5.mStartWrapWidth;
            int i18 = motionLayout5.mStartWrapHeight;
            int i19 = motionLayout5.mWidthMeasureMode;
            if (i19 == Integer.MIN_VALUE || i19 == 0) {
                i17 = (int) (i17 + (motionLayout5.mPostInterpolationPosition * (motionLayout5.mEndWrapWidth - i17)));
            }
            int i26 = motionLayout5.mHeightMeasureMode;
            if (i26 == Integer.MIN_VALUE || i26 == 0) {
                i18 = (int) (i18 + (motionLayout5.mPostInterpolationPosition * (motionLayout5.mEndWrapHeight - i18)));
            }
            if (!this.mLayoutStart.isWidthMeasuredTooSmall() && !this.mLayoutEnd.isWidthMeasuredTooSmall()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (this.mLayoutStart.isHeightMeasuredTooSmall() || this.mLayoutEnd.isHeightMeasuredTooSmall()) {
                z19 = true;
            }
            MotionLayout.this.resolveMeasuredDimension(i3, i16, i17, i18, z17, z19);
        }

        public void reEvaluateState() {
            measure(MotionLayout.this.mLastWidthMeasureSpec, MotionLayout.this.mLastHeightMeasureSpec);
            MotionLayout.this.setupMotionViews();
        }

        public void setMeasuredId(int i3, int i16) {
            this.mStartId = i3;
            this.mEndId = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i3);

        void computeCurrentVelocity(int i3, float f16);

        float getXVelocity();

        float getXVelocity(int i3);

        float getYVelocity();

        float getYVelocity(int i3);

        void recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class StateCache {
        float mProgress = Float.NaN;
        float mVelocity = Float.NaN;
        int startState = -1;
        int endState = -1;
        final String KeyProgress = "motion.progress";
        final String KeyVelocity = "motion.velocity";
        final String KeyStartState = "motion.StartState";
        final String KeyEndState = "motion.EndState";

        StateCache() {
        }

        void apply() {
            int i3 = this.startState;
            if (i3 != -1 || this.endState != -1) {
                if (i3 == -1) {
                    MotionLayout.this.transitionToState(this.endState);
                } else {
                    int i16 = this.endState;
                    if (i16 == -1) {
                        MotionLayout.this.setState(i3, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i3, i16);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.mVelocity)) {
                if (Float.isNaN(this.mProgress)) {
                    return;
                }
                MotionLayout.this.setProgress(this.mProgress);
            } else {
                MotionLayout.this.setProgress(this.mProgress, this.mVelocity);
                this.mProgress = Float.NaN;
                this.mVelocity = Float.NaN;
                this.startState = -1;
                this.endState = -1;
            }
        }

        public Bundle getTransitionState() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.mProgress);
            bundle.putFloat("motion.velocity", this.mVelocity);
            bundle.putInt("motion.StartState", this.startState);
            bundle.putInt("motion.EndState", this.endState);
            return bundle;
        }

        public void recordState() {
            this.endState = MotionLayout.this.mEndState;
            this.startState = MotionLayout.this.mBeginState;
            this.mVelocity = MotionLayout.this.getVelocity();
            this.mProgress = MotionLayout.this.getProgress();
        }

        public void setEndState(int i3) {
            this.endState = i3;
        }

        public void setProgress(float f16) {
            this.mProgress = f16;
        }

        public void setStartState(int i3) {
            this.startState = i3;
        }

        public void setTransitionState(Bundle bundle) {
            this.mProgress = bundle.getFloat("motion.progress");
            this.mVelocity = bundle.getFloat("motion.velocity");
            this.startState = bundle.getInt("motion.StartState");
            this.endState = bundle.getInt("motion.EndState");
        }

        public void setVelocity(float f16) {
            this.mVelocity = f16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i3, int i16, float f16);

        void onTransitionCompleted(MotionLayout motionLayout, int i3);

        void onTransitionStarted(MotionLayout motionLayout, int i3, int i16);

        void onTransitionTrigger(MotionLayout motionLayout, int i3, boolean z16, float f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(null);
    }

    private void checkStructure() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            Log.e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int startId = motionScene.getStartId();
        MotionScene motionScene2 = this.mScene;
        checkStructure(startId, motionScene2.getConstraintSet(motionScene2.getStartId()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<MotionScene.Transition> it = this.mScene.getDefinedTransitions().iterator();
        while (it.hasNext()) {
            MotionScene.Transition next = it.next();
            if (next == this.mScene.mCurrentTransition) {
                Log.v(TAG, "CHECK: CURRENT");
            }
            checkStructure(next);
            int startConstraintSetId = next.getStartConstraintSetId();
            int endConstraintSetId = next.getEndConstraintSetId();
            String name = Debug.getName(getContext(), startConstraintSetId);
            String name2 = Debug.getName(getContext(), endConstraintSetId);
            if (sparseIntArray.get(startConstraintSetId) == endConstraintSetId) {
                Log.e(TAG, "CHECK: two transitions with the same start and end " + name + "->" + name2);
            }
            if (sparseIntArray2.get(endConstraintSetId) == startConstraintSetId) {
                Log.e(TAG, "CHECK: you can't have reverse transitions" + name + "->" + name2);
            }
            sparseIntArray.put(startConstraintSetId, endConstraintSetId);
            sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
            if (this.mScene.getConstraintSet(startConstraintSetId) == null) {
                Log.e(TAG, " no such constraintSetStart " + name);
            }
            if (this.mScene.getConstraintSet(endConstraintSetId) == null) {
                Log.e(TAG, " no such constraintSetEnd " + name);
            }
        }
    }

    private void computeCurrentPositions() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.setStartCurrentState(childAt);
            }
        }
    }

    private void debugPos() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            Log.v(TAG, " " + Debug.getLocation() + " " + Debug.getName(this) + " " + Debug.getName(getContext(), this.mCurrentState) + " " + Debug.getName(childAt) + childAt.getLeft() + " " + childAt.getTop());
        }
    }

    private void evaluateLayout() {
        float f16;
        boolean z16;
        float signum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.mInterpolator;
        if (!(interpolator instanceof StopLogic)) {
            f16 = ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration;
        } else {
            f16 = 0.0f;
        }
        float f17 = this.mTransitionLastPosition + f16;
        if (this.mTransitionInstantly) {
            f17 = this.mTransitionGoalPosition;
        }
        if ((signum > 0.0f && f17 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f17 <= this.mTransitionGoalPosition)) {
            f17 = this.mTransitionGoalPosition;
            z16 = true;
        } else {
            z16 = false;
        }
        if (interpolator != null && !z16) {
            if (this.mTemporalInterpolator) {
                f17 = interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f);
            } else {
                f17 = interpolator.getInterpolation(f17);
            }
        }
        if ((signum > 0.0f && f17 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f17 <= this.mTransitionGoalPosition)) {
            f17 = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = f17;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.interpolate(childAt, f17, nanoTime2, this.mKeyCache);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    private void fireTransitionChange() {
        ArrayList<TransitionListener> arrayList;
        if ((this.mTransitionListener != null || ((arrayList = this.mTransitionListeners) != null && !arrayList.isEmpty())) && this.mListenerPosition != this.mTransitionPosition) {
            if (this.mListenerState != -1) {
                TransitionListener transitionListener = this.mTransitionListener;
                if (transitionListener != null) {
                    transitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
                }
                ArrayList<TransitionListener> arrayList2 = this.mTransitionListeners;
                if (arrayList2 != null) {
                    Iterator<TransitionListener> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
                    }
                }
                this.mIsAnimating = true;
            }
            this.mListenerState = -1;
            float f16 = this.mTransitionPosition;
            this.mListenerPosition = f16;
            TransitionListener transitionListener2 = this.mTransitionListener;
            if (transitionListener2 != null) {
                transitionListener2.onTransitionChange(this, this.mBeginState, this.mEndState, f16);
            }
            ArrayList<TransitionListener> arrayList3 = this.mTransitionListeners;
            if (arrayList3 != null) {
                Iterator<TransitionListener> it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    it5.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
                }
            }
            this.mIsAnimating = true;
        }
    }

    private void fireTransitionStarted(MotionLayout motionLayout, int i3, int i16) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionStarted(this, i3, i16);
        }
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList != null) {
            Iterator<TransitionListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionStarted(motionLayout, i3, i16);
            }
        }
    }

    private boolean handlesTouchEvent(float f16, float f17, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (handlesTouchEvent(view.getLeft() + f16, view.getTop() + f17, viewGroup.getChildAt(i3), motionEvent)) {
                    return true;
                }
            }
        }
        this.mBoundsCheck.set(view.getLeft() + f16, view.getTop() + f17, f16 + view.getRight(), f17 + view.getBottom());
        if (motionEvent.getAction() == 0) {
            if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent)) {
                return true;
            }
        } else if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    private void init(AttributeSet attributeSet) {
        MotionScene motionScene;
        int i3;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z16 = true;
            for (int i16 = 0; i16 < indexCount; i16++) {
                int index = obtainStyledAttributes.getIndex(i16);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.mScene = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.mCurrentState = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z16 = obtainStyledAttributes.getBoolean(index, z16);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.mDebugPath == 0) {
                        if (obtainStyledAttributes.getBoolean(index, false)) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        this.mDebugPath = i3;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.mDebugPath = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.mScene == null) {
                Log.e(TAG, "WARNING NO app:layoutDescription tag");
            }
            if (!z16) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            checkStructure();
        }
        if (this.mCurrentState == -1 && (motionScene = this.mScene) != null) {
            this.mCurrentState = motionScene.getStartId();
            this.mBeginState = this.mScene.getStartId();
            this.mEndState = this.mScene.getEndId();
        }
    }

    private void processTransitionCompleted() {
        ArrayList<TransitionListener> arrayList;
        if (this.mTransitionListener == null && ((arrayList = this.mTransitionListeners) == null || arrayList.isEmpty())) {
            return;
        }
        this.mIsAnimating = false;
        Iterator<Integer> it = this.mTransitionCompleted.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            TransitionListener transitionListener = this.mTransitionListener;
            if (transitionListener != null) {
                transitionListener.onTransitionCompleted(this, next.intValue());
            }
            ArrayList<TransitionListener> arrayList2 = this.mTransitionListeners;
            if (arrayList2 != null) {
                Iterator<TransitionListener> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    it5.next().onTransitionCompleted(this, next.intValue());
                }
            }
        }
        this.mTransitionCompleted.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupMotionViews() {
        boolean z16;
        float f16;
        float f17;
        int childCount = getChildCount();
        this.mModel.build();
        boolean z17 = true;
        this.mInTransition = true;
        int width = getWidth();
        int height = getHeight();
        int gatPathMotionArc = this.mScene.gatPathMotionArc();
        int i3 = 0;
        if (gatPathMotionArc != -1) {
            for (int i16 = 0; i16 < childCount; i16++) {
                MotionController motionController = this.mFrameArrayList.get(getChildAt(i16));
                if (motionController != null) {
                    motionController.setPathMotionArc(gatPathMotionArc);
                }
            }
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i17));
            if (motionController2 != null) {
                this.mScene.getKeyFrames(motionController2);
                motionController2.setup(width, height, this.mTransitionDuration, getNanoTime());
            }
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            if (staggered < 0.0d) {
                z16 = true;
            } else {
                z16 = false;
            }
            float abs = Math.abs(staggered);
            float f18 = -3.4028235E38f;
            float f19 = Float.MAX_VALUE;
            float f26 = -3.4028235E38f;
            float f27 = Float.MAX_VALUE;
            int i18 = 0;
            while (true) {
                if (i18 < childCount) {
                    MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i18));
                    if (!Float.isNaN(motionController3.mMotionStagger)) {
                        break;
                    }
                    float finalX = motionController3.getFinalX();
                    float finalY = motionController3.getFinalY();
                    if (z16) {
                        f17 = finalY - finalX;
                    } else {
                        f17 = finalY + finalX;
                    }
                    f27 = Math.min(f27, f17);
                    f26 = Math.max(f26, f17);
                    i18++;
                } else {
                    z17 = false;
                    break;
                }
            }
            if (z17) {
                for (int i19 = 0; i19 < childCount; i19++) {
                    MotionController motionController4 = this.mFrameArrayList.get(getChildAt(i19));
                    if (!Float.isNaN(motionController4.mMotionStagger)) {
                        f19 = Math.min(f19, motionController4.mMotionStagger);
                        f18 = Math.max(f18, motionController4.mMotionStagger);
                    }
                }
                while (i3 < childCount) {
                    MotionController motionController5 = this.mFrameArrayList.get(getChildAt(i3));
                    if (!Float.isNaN(motionController5.mMotionStagger)) {
                        motionController5.mStaggerScale = 1.0f / (1.0f - abs);
                        if (z16) {
                            motionController5.mStaggerOffset = abs - (((f18 - motionController5.mMotionStagger) / (f18 - f19)) * abs);
                        } else {
                            motionController5.mStaggerOffset = abs - (((motionController5.mMotionStagger - f19) * abs) / (f18 - f19));
                        }
                    }
                    i3++;
                }
                return;
            }
            while (i3 < childCount) {
                MotionController motionController6 = this.mFrameArrayList.get(getChildAt(i3));
                float finalX2 = motionController6.getFinalX();
                float finalY2 = motionController6.getFinalY();
                if (z16) {
                    f16 = finalY2 - finalX2;
                } else {
                    f16 = finalY2 + finalX2;
                }
                motionController6.mStaggerScale = 1.0f / (1.0f - abs);
                motionController6.mStaggerOffset = abs - (((f16 - f27) * abs) / (f26 - f27));
                i3++;
            }
        }
    }

    private static boolean willJump(float f16, float f17, float f18) {
        if (f16 > 0.0f) {
            float f19 = f16 / f18;
            if (f17 + ((f16 * f19) - (((f18 * f19) * f19) / 2.0f)) > 1.0f) {
                return true;
            }
            return false;
        }
        float f26 = (-f16) / f18;
        if (f17 + (f16 * f26) + (((f18 * f26) * f26) / 2.0f) < 0.0f) {
            return true;
        }
        return false;
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new ArrayList<>();
        }
        this.mTransitionListeners.add(transitionListener);
    }

    void animateTo(float f16) {
        if (this.mScene == null) {
            return;
        }
        float f17 = this.mTransitionLastPosition;
        float f18 = this.mTransitionPosition;
        if (f17 != f18 && this.mTransitionInstantly) {
            this.mTransitionLastPosition = f18;
        }
        float f19 = this.mTransitionLastPosition;
        if (f19 == f16) {
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = f16;
        this.mTransitionDuration = r0.getDuration() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f19;
        this.mTransitionLastPosition = f19;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void disableAutoTransition(boolean z16) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.disableAutoTransition(z16);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        String state;
        evaluate(false);
        super.dispatchDraw(canvas);
        if (this.mScene == null) {
            return;
        }
        if ((this.mDebugPath & 1) == 1 && !isInEditMode()) {
            this.mFrames++;
            long nanoTime = getNanoTime();
            long j3 = this.mLastDrawTime;
            if (j3 != -1) {
                if (nanoTime - j3 > 200000000) {
                    this.mLastFps = ((int) ((this.mFrames / (((float) r5) * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.mFrames = 0;
                    this.mLastDrawTime = nanoTime;
                }
            } else {
                this.mLastDrawTime = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            String str = this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ";
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(Debug.getState(this, this.mEndState));
            sb5.append(" (progress: ");
            sb5.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb5.append(" ) state=");
            int i3 = this.mCurrentState;
            if (i3 == -1) {
                state = "undefined";
            } else {
                state = Debug.getState(this, i3);
            }
            sb5.append(state);
            String sb6 = sb5.toString();
            paint.setColor(-16777216);
            canvas.drawText(sb6, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(sb6, 10.0f, getHeight() - 30, paint);
        }
        if (this.mDebugPath > 1) {
            if (this.mDevModeDraw == null) {
                this.mDevModeDraw = new DevModeDraw();
            }
            this.mDevModeDraw.draw(canvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
        }
    }

    public void enableTransition(int i3, boolean z16) {
        MotionScene.Transition transition = getTransition(i3);
        if (z16) {
            transition.setEnable(true);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (transition == motionScene.mCurrentTransition) {
            Iterator<MotionScene.Transition> it = motionScene.getTransitionsWithState(this.mCurrentState).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MotionScene.Transition next = it.next();
                if (next.isEnabled()) {
                    this.mScene.mCurrentTransition = next;
                    break;
                }
            }
        }
        transition.setEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void evaluate(boolean z16) {
        float f16;
        boolean z17;
        boolean z18;
        int i3;
        float interpolation;
        if (this.mTransitionLastTime == -1) {
            this.mTransitionLastTime = getNanoTime();
        }
        float f17 = this.mTransitionLastPosition;
        if (f17 > 0.0f && f17 < 1.0f) {
            this.mCurrentState = -1;
        }
        boolean z19 = true;
        boolean z26 = false;
        if (this.mKeepAnimating || (this.mInTransition && (z16 || this.mTransitionGoalPosition != f17))) {
            float signum = Math.signum(this.mTransitionGoalPosition - f17);
            long nanoTime = getNanoTime();
            Interpolator interpolator = this.mInterpolator;
            if (!(interpolator instanceof MotionInterpolator)) {
                f16 = ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration;
                this.mLastVelocity = f16;
            } else {
                f16 = 0.0f;
            }
            float f18 = this.mTransitionLastPosition + f16;
            if (this.mTransitionInstantly) {
                f18 = this.mTransitionGoalPosition;
            }
            if ((signum > 0.0f && f18 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f18 <= this.mTransitionGoalPosition)) {
                f18 = this.mTransitionGoalPosition;
                this.mInTransition = false;
                z17 = true;
            } else {
                z17 = false;
            }
            this.mTransitionLastPosition = f18;
            this.mTransitionPosition = f18;
            this.mTransitionLastTime = nanoTime;
            if (interpolator != null && !z17) {
                if (this.mTemporalInterpolator) {
                    interpolation = interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f);
                    this.mTransitionLastPosition = interpolation;
                    this.mTransitionLastTime = nanoTime;
                    Interpolator interpolator2 = this.mInterpolator;
                    if (interpolator2 instanceof MotionInterpolator) {
                        float velocity = ((MotionInterpolator) interpolator2).getVelocity();
                        this.mLastVelocity = velocity;
                        if (Math.abs(velocity) * this.mTransitionDuration <= EPSILON) {
                            this.mInTransition = false;
                        }
                        if (velocity > 0.0f && interpolation >= 1.0f) {
                            this.mTransitionLastPosition = 1.0f;
                            this.mInTransition = false;
                            interpolation = 1.0f;
                        }
                        if (velocity < 0.0f && interpolation <= 0.0f) {
                            this.mTransitionLastPosition = 0.0f;
                            this.mInTransition = false;
                            f18 = 0.0f;
                        }
                    }
                } else {
                    interpolation = interpolator.getInterpolation(f18);
                    Interpolator interpolator3 = this.mInterpolator;
                    if (interpolator3 instanceof MotionInterpolator) {
                        this.mLastVelocity = ((MotionInterpolator) interpolator3).getVelocity();
                    } else {
                        this.mLastVelocity = ((interpolator3.getInterpolation(f18 + f16) - interpolation) * signum) / f16;
                    }
                }
                f18 = interpolation;
            }
            if (Math.abs(this.mLastVelocity) > EPSILON) {
                setState(TransitionState.MOVING);
            }
            if ((signum > 0.0f && f18 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f18 <= this.mTransitionGoalPosition)) {
                f18 = this.mTransitionGoalPosition;
                this.mInTransition = false;
            }
            if (f18 >= 1.0f || f18 <= 0.0f) {
                this.mInTransition = false;
                setState(TransitionState.FINISHED);
            }
            int childCount = getChildCount();
            this.mKeepAnimating = false;
            long nanoTime2 = getNanoTime();
            this.mPostInterpolationPosition = f18;
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                MotionController motionController = this.mFrameArrayList.get(childAt);
                if (motionController != null) {
                    this.mKeepAnimating = motionController.interpolate(childAt, f18, nanoTime2, this.mKeyCache) | this.mKeepAnimating;
                }
            }
            if ((signum > 0.0f && f18 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f18 <= this.mTransitionGoalPosition)) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!this.mKeepAnimating && !this.mInTransition && z18) {
                setState(TransitionState.FINISHED);
            }
            if (this.mMeasureDuringTransition) {
                requestLayout();
            }
            this.mKeepAnimating = (!z18) | this.mKeepAnimating;
            if (f18 <= 0.0f && (i3 = this.mBeginState) != -1 && this.mCurrentState != i3) {
                this.mCurrentState = i3;
                this.mScene.getConstraintSet(i3).applyCustomAttributes(this);
                setState(TransitionState.FINISHED);
                z26 = true;
            }
            if (f18 >= 1.0d) {
                int i17 = this.mCurrentState;
                int i18 = this.mEndState;
                if (i17 != i18) {
                    this.mCurrentState = i18;
                    this.mScene.getConstraintSet(i18).applyCustomAttributes(this);
                    setState(TransitionState.FINISHED);
                    z26 = true;
                }
            }
            if (!this.mKeepAnimating && !this.mInTransition) {
                if ((signum > 0.0f && f18 == 1.0f) || (signum < 0.0f && f18 == 0.0f)) {
                    setState(TransitionState.FINISHED);
                }
            } else {
                invalidate();
            }
            if ((!this.mKeepAnimating && this.mInTransition && signum > 0.0f && f18 == 1.0f) || (signum < 0.0f && f18 == 0.0f)) {
                onNewStateAttachHandlers();
            }
        }
        float f19 = this.mTransitionLastPosition;
        if (f19 >= 1.0f) {
            int i19 = this.mCurrentState;
            int i26 = this.mEndState;
            if (i19 == i26) {
                z19 = z26;
            }
            this.mCurrentState = i26;
        } else {
            if (f19 <= 0.0f) {
                int i27 = this.mCurrentState;
                int i28 = this.mBeginState;
                if (i27 == i28) {
                    z19 = z26;
                }
                this.mCurrentState = i28;
            }
            this.mNeedsFireTransitionCompleted |= z26;
            if (z26 && !this.mInLayout) {
                requestLayout();
            }
            this.mTransitionPosition = this.mTransitionLastPosition;
        }
        z26 = z19;
        this.mNeedsFireTransitionCompleted |= z26;
        if (z26) {
            requestLayout();
        }
        this.mTransitionPosition = this.mTransitionLastPosition;
    }

    protected void fireTransitionCompleted() {
        int i3;
        ArrayList<TransitionListener> arrayList;
        if ((this.mTransitionListener != null || ((arrayList = this.mTransitionListeners) != null && !arrayList.isEmpty())) && this.mListenerState == -1) {
            this.mListenerState = this.mCurrentState;
            if (!this.mTransitionCompleted.isEmpty()) {
                i3 = this.mTransitionCompleted.get(r0.size() - 1).intValue();
            } else {
                i3 = -1;
            }
            int i16 = this.mCurrentState;
            if (i3 != i16 && i16 != -1) {
                this.mTransitionCompleted.add(Integer.valueOf(i16));
            }
        }
        processTransitionCompleted();
    }

    public void fireTrigger(int i3, boolean z16, float f16) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i3, z16, f16);
        }
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList != null) {
            Iterator<TransitionListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i3, z16, f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAnchorDpDt(int i3, float f16, float f17, float f18, float[] fArr) {
        String resourceName;
        HashMap<View, MotionController> hashMap = this.mFrameArrayList;
        View viewById = getViewById(i3);
        MotionController motionController = hashMap.get(viewById);
        if (motionController != null) {
            motionController.getDpDt(f16, f17, f18, fArr);
            float y16 = viewById.getY();
            this.lastPos = f16;
            this.lastY = y16;
            return;
        }
        if (viewById == null) {
            resourceName = "" + i3;
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i3);
        }
        Log.w(TAG, "WARNING could not find view id " + resourceName);
    }

    public ConstraintSet getConstraintSet(int i3) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSet(i3);
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getConstraintSetNames(int i3) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(i3);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public void getDebugMode(boolean z16) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        this.mDebugPath = i3;
        invalidate();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene.Transition getTransition(int i3) {
        return this.mScene.getTransitionById(i3);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        if (this.mScene != null) {
            this.mTransitionDuration = r0.getDuration() / 1000.0f;
        }
        return this.mTransitionDuration * 1000.0f;
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f16, float f17, float[] fArr, int i3) {
        float f18;
        float f19 = this.mLastVelocity;
        float f26 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            float signum = Math.signum(this.mTransitionGoalPosition - f26);
            float interpolation = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
            f18 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            f19 = (signum * ((interpolation - f18) / EPSILON)) / this.mTransitionDuration;
        } else {
            f18 = f26;
        }
        Interpolator interpolator = this.mInterpolator;
        if (interpolator instanceof MotionInterpolator) {
            f19 = ((MotionInterpolator) interpolator).getVelocity();
        }
        MotionController motionController = this.mFrameArrayList.get(view);
        if ((i3 & 1) == 0) {
            motionController.getPostLayoutDvDp(f18, view.getWidth(), view.getHeight(), f16, f17, fArr);
        } else {
            motionController.getDpDt(f18, f16, f17, fArr);
        }
        if (i3 < 2) {
            fArr[0] = fArr[0] * f19;
            fArr[1] = fArr[1] * f19;
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i3) {
        if (i3 != 0) {
            try {
                this.mScene = new MotionScene(getContext(), this, i3);
                if (isAttachedToWindow()) {
                    this.mScene.readFallback(this);
                    this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
                    rebuildScene();
                    this.mScene.setRtl(isRtl());
                    return;
                }
                return;
            } catch (Exception e16) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e16);
            }
        }
        this.mScene = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int lookUpConstraintId(String str) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.lookUpConstraintId(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        MotionScene.Transition transition;
        int i3;
        super.onAttachedToWindow();
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (i3 = this.mCurrentState) != -1) {
            ConstraintSet constraintSet = motionScene.getConstraintSet(i3);
            this.mScene.readFallback(this);
            if (constraintSet != null) {
                constraintSet.applyTo(this);
            }
            this.mBeginState = this.mCurrentState;
        }
        onNewStateAttachHandlers();
        StateCache stateCache = this.mStateCache;
        if (stateCache != null) {
            stateCache.apply();
            return;
        }
        MotionScene motionScene2 = this.mScene;
        if (motionScene2 != null && (transition = motionScene2.mCurrentTransition) != null && transition.getAutoTransition() == 4) {
            transitionToEnd();
            setState(TransitionState.SETUP);
            setState(TransitionState.MOVING);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int touchRegionId;
        RectF touchRegion;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && this.mInteractionEnabled && (transition = motionScene.mCurrentTransition) != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (touchRegion = touchResponse.getTouchRegion(this, new RectF())) == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) && (touchRegionId = touchResponse.getTouchRegionId()) != -1)) {
            View view = this.mRegionView;
            if (view == null || view.getId() != touchRegionId) {
                this.mRegionView = findViewById(touchRegionId);
            }
            if (this.mRegionView != null) {
                this.mBoundsCheck.set(r0.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
                if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent(0.0f, 0.0f, this.mRegionView, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        this.mInLayout = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z16, i3, i16, i17, i18);
                return;
            }
            int i19 = i17 - i3;
            int i26 = i18 - i16;
            if (this.mLastLayoutWidth != i19 || this.mLastLayoutHeight != i26) {
                rebuildScene();
                evaluate(true);
            }
            this.mLastLayoutWidth = i19;
            this.mLastLayoutHeight = i26;
            this.mOldWidth = i19;
            this.mOldHeight = i26;
        } finally {
            this.mInLayout = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        boolean z16;
        if (this.mScene == null) {
            super.onMeasure(i3, i16);
            return;
        }
        boolean z17 = false;
        if (this.mLastWidthMeasureSpec == i3 && this.mLastHeightMeasureSpec == i16) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            onNewStateAttachHandlers();
            processTransitionCompleted();
            z16 = true;
        }
        if (this.mDirtyHierarchy) {
            z16 = true;
        }
        this.mLastWidthMeasureSpec = i3;
        this.mLastHeightMeasureSpec = i16;
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if ((z16 || this.mModel.isNotConfiguredWith(startId, endId)) && this.mBeginState != -1) {
            super.onMeasure(i3, i16);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(startId), this.mScene.getConstraintSet(endId));
            this.mModel.reEvaluateState();
            this.mModel.setMeasuredId(startId, endId);
        } else {
            z17 = true;
        }
        if (this.mMeasureDuringTransition || z17) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int width = this.mLayoutWidget.getWidth() + getPaddingLeft() + getPaddingRight();
            int height = this.mLayoutWidget.getHeight() + paddingTop;
            int i17 = this.mWidthMeasureMode;
            if (i17 == Integer.MIN_VALUE || i17 == 0) {
                width = (int) (this.mStartWrapWidth + (this.mPostInterpolationPosition * (this.mEndWrapWidth - r7)));
                requestLayout();
            }
            int i18 = this.mHeightMeasureMode;
            if (i18 == Integer.MIN_VALUE || i18 == 0) {
                height = (int) (this.mStartWrapHeight + (this.mPostInterpolationPosition * (this.mEndWrapHeight - r7)));
                requestLayout();
            }
            setMeasuredDimension(width, height);
        }
        evaluateLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f16, float f17, boolean z16) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f16, float f17) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(final View view, int i3, int i16, int[] iArr, int i17) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int touchRegionId;
        MotionScene motionScene = this.mScene;
        if (motionScene == null || (transition = motionScene.mCurrentTransition) == null || !transition.isEnabled()) {
            return;
        }
        MotionScene.Transition transition2 = this.mScene.mCurrentTransition;
        if (transition2 != null && transition2.isEnabled() && (touchResponse = transition2.getTouchResponse()) != null && (touchRegionId = touchResponse.getTouchRegionId()) != -1 && view.getId() != touchRegionId) {
            return;
        }
        MotionScene motionScene2 = this.mScene;
        if (motionScene2 != null && motionScene2.getMoveWhenScrollAtTop()) {
            float f16 = this.mTransitionPosition;
            if ((f16 == 1.0f || f16 == 0.0f) && view.canScrollVertically(-1)) {
                return;
            }
        }
        if (transition2.getTouchResponse() != null && (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 1) != 0) {
            float progressDirection = this.mScene.getProgressDirection(i3, i16);
            float f17 = this.mTransitionLastPosition;
            if ((f17 <= 0.0f && progressDirection < 0.0f) || (f17 >= 1.0f && progressDirection > 0.0f)) {
                view.setNestedScrollingEnabled(false);
                view.post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setNestedScrollingEnabled(true);
                    }
                });
                return;
            }
        }
        float f18 = this.mTransitionPosition;
        long nanoTime = getNanoTime();
        float f19 = i3;
        this.mScrollTargetDX = f19;
        float f26 = i16;
        this.mScrollTargetDY = f26;
        this.mScrollTargetDT = (float) ((nanoTime - this.mScrollTargetTime) * 1.0E-9d);
        this.mScrollTargetTime = nanoTime;
        this.mScene.processScrollMove(f19, f26);
        if (f18 != this.mTransitionPosition) {
            iArr[0] = i3;
            iArr[1] = i16;
        }
        evaluate(false);
        if (iArr[0] != 0 || iArr[1] != 0) {
            this.mUndergoingMotion = true;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18, int i19) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onNewStateAttachHandlers() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        if (motionScene.autoTransition(this, this.mCurrentState)) {
            requestLayout();
            return;
        }
        int i3 = this.mCurrentState;
        if (i3 != -1) {
            this.mScene.addOnClickListeners(this, i3);
        }
        if (this.mScene.supportTouch()) {
            this.mScene.setupTouch();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i3) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i3, int i16) {
        MotionScene.Transition transition;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (transition = motionScene.mCurrentTransition) != null && transition.getTouchResponse() != null && (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i3) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        float f16 = this.mScrollTargetDX;
        float f17 = this.mScrollTargetDT;
        motionScene.processScrollUp(f16 / f17, this.mScrollTargetDY / f17);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null && this.mInteractionEnabled && motionScene.supportTouch()) {
            MotionScene.Transition transition = this.mScene.mCurrentTransition;
            if (transition != null && !transition.isEnabled()) {
                return super.onTouchEvent(motionEvent);
            }
            this.mScene.processTouchEvent(motionEvent, getCurrentState(), this);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new ArrayList<>();
            }
            this.mTransitionListeners.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList<>();
                }
                this.mOnShowHelpers.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new ArrayList<>();
                }
                this.mOnHideHelpers.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void parseLayoutDescription(int i3) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e(TAG, "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList == null) {
            return false;
        }
        return arrayList.remove(transitionListener);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (!this.mMeasureDuringTransition && this.mCurrentState == -1 && (motionScene = this.mScene) != null && (transition = motionScene.mCurrentTransition) != null && transition.getLayoutDuringTransition() == 0) {
            return;
        }
        super.requestLayout();
    }

    public void setDebugMode(int i3) {
        this.mDebugPath = i3;
        invalidate();
    }

    public void setInteractionEnabled(boolean z16) {
        this.mInteractionEnabled = z16;
    }

    public void setInterpolatedProgress(float f16) {
        if (this.mScene != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolator = this.mScene.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f16));
                return;
            }
        }
        setProgress(f16);
    }

    public void setOnHide(float f16) {
        ArrayList<MotionHelper> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mOnHideHelpers.get(i3).setProgress(f16);
            }
        }
    }

    public void setOnShow(float f16) {
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mOnShowHelpers.get(i3).setProgress(f16);
            }
        }
    }

    public void setProgress(float f16, float f17) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f16);
            this.mStateCache.setVelocity(f17);
            return;
        }
        setProgress(f16);
        setState(TransitionState.MOVING);
        this.mLastVelocity = f17;
        animateTo(1.0f);
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.mCurrentState == -1) {
            return;
        }
        TransitionState transitionState3 = this.mTransitionState;
        this.mTransitionState = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            fireTransitionChange();
        }
        int i3 = AnonymousClass2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[transitionState3.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 && transitionState == transitionState2) {
                fireTransitionCompleted();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            fireTransitionChange();
        }
        if (transitionState == transitionState2) {
            fireTransitionCompleted();
        }
    }

    public void setTransition(int i3, int i16) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setStartState(i3);
            this.mStateCache.setEndState(i16);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mBeginState = i3;
            this.mEndState = i16;
            motionScene.setTransition(i3, i16);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(i3), this.mScene.getConstraintSet(i16));
            rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            transitionToStart();
        }
    }

    public void setTransitionDuration(int i3) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            Log.e(TAG, "MotionScene not defined");
        } else {
            motionScene.setDuration(i3);
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setTransitionState(bundle);
        if (isAttachedToWindow()) {
            this.mStateCache.apply();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return Debug.getName(context, this.mBeginState) + "->" + Debug.getName(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    public void touchAnimateTo(int i3, float f16, float f17) {
        if (this.mScene == null || this.mTransitionLastPosition == f16) {
            return;
        }
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        float duration = this.mScene.getDuration() / 1000.0f;
        this.mTransitionDuration = duration;
        this.mTransitionGoalPosition = f16;
        this.mInTransition = true;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            if (i3 != 4) {
                if (i3 == 5) {
                    if (willJump(f17, this.mTransitionLastPosition, this.mScene.getMaxAcceleration())) {
                        this.mDecelerateLogic.config(f17, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
                        this.mInterpolator = this.mDecelerateLogic;
                    } else {
                        this.mStopLogic.config(this.mTransitionLastPosition, f16, f17, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
                        this.mLastVelocity = 0.0f;
                        int i16 = this.mCurrentState;
                        this.mTransitionGoalPosition = f16;
                        this.mCurrentState = i16;
                        this.mInterpolator = this.mStopLogic;
                    }
                }
            } else {
                this.mDecelerateLogic.config(f17, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
                this.mInterpolator = this.mDecelerateLogic;
            }
        } else {
            if (i3 == 1) {
                f16 = 0.0f;
            } else if (i3 == 2) {
                f16 = 1.0f;
            }
            this.mStopLogic.config(this.mTransitionLastPosition, f16, f17, duration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
            int i17 = this.mCurrentState;
            this.mTransitionGoalPosition = f16;
            this.mCurrentState = i17;
            this.mInterpolator = this.mStopLogic;
        }
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        animateTo(1.0f);
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToState(int i3) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setEndState(i3);
            return;
        }
        transitionToState(i3, -1, -1);
    }

    public void updateState(int i3, ConstraintSet constraintSet) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setConstraintSet(i3, constraintSet);
        }
        updateState();
        if (this.mCurrentState == i3) {
            constraintSet.applyTo(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class MyTracker implements MotionTracker {

        /* renamed from: me, reason: collision with root package name */
        private static MyTracker f26462me = new MyTracker();
        VelocityTracker tracker;

        MyTracker() {
        }

        public static MyTracker obtain() {
            f26462me.tracker = VelocityTracker.obtain();
            return f26462me;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i3) {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i3);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.tracker = null;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i3, float f16) {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i3, f16);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int i3) {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity(i3);
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int i3) {
            if (this.tracker != null) {
                return getYVelocity(i3);
            }
            return 0.0f;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18, int i19, int[] iArr) {
        if (this.mUndergoingMotion || i3 != 0 || i16 != 0) {
            iArr[0] = iArr[0] + i17;
            iArr[1] = iArr[1] + i18;
        }
        this.mUndergoingMotion = false;
    }

    public void transitionToState(int i3, int i16, int i17) {
        StateSet stateSet;
        int convertToConstraintSet;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (stateSet = motionScene.mStateSet) != null && (convertToConstraintSet = stateSet.convertToConstraintSet(this.mCurrentState, i3, i16, i17)) != -1) {
            i3 = convertToConstraintSet;
        }
        int i18 = this.mCurrentState;
        if (i18 == i3) {
            return;
        }
        if (this.mBeginState == i3) {
            animateTo(0.0f);
            return;
        }
        if (this.mEndState == i3) {
            animateTo(1.0f);
            return;
        }
        this.mEndState = i3;
        if (i18 != -1) {
            setTransition(i18, i3);
            animateTo(1.0f);
            this.mTransitionLastPosition = 0.0f;
            transitionToEnd();
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = getNanoTime();
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mBeginState = -1;
        this.mScene.setTransition(-1, this.mEndState);
        this.mScene.getStartId();
        int childCount = getChildCount();
        this.mFrameArrayList.clear();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            this.mFrameArrayList.put(childAt, new MotionController(childAt));
        }
        this.mInTransition = true;
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(i3));
        rebuildScene();
        this.mModel.build();
        computeCurrentPositions();
        int width = getWidth();
        int height = getHeight();
        for (int i26 = 0; i26 < childCount; i26++) {
            MotionController motionController = this.mFrameArrayList.get(getChildAt(i26));
            this.mScene.getKeyFrames(motionController);
            motionController.setup(width, height, this.mTransitionDuration, getNanoTime());
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            float f16 = Float.MAX_VALUE;
            float f17 = -3.4028235E38f;
            for (int i27 = 0; i27 < childCount; i27++) {
                MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i27));
                float finalY = motionController2.getFinalY() + motionController2.getFinalX();
                f16 = Math.min(f16, finalY);
                f17 = Math.max(f17, finalY);
            }
            for (int i28 = 0; i28 < childCount; i28++) {
                MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i28));
                float finalX = motionController3.getFinalX();
                float finalY2 = motionController3.getFinalY();
                motionController3.mStaggerScale = 1.0f / (1.0f - staggered);
                motionController3.mStaggerOffset = staggered - ((((finalX + finalY2) - f16) * staggered) / (f17 - f16));
            }
        }
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        invalidate();
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    public void setProgress(float f16) {
        if (f16 < 0.0f || f16 > 1.0f) {
            Log.w(TAG, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f16);
            return;
        }
        if (f16 <= 0.0f) {
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f16 >= 1.0f) {
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            setState(TransitionState.MOVING);
        }
        if (this.mScene == null) {
            return;
        }
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = f16;
        this.mTransitionPosition = f16;
        this.mTransitionLastTime = -1L;
        this.mAnimationStartTime = -1L;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i3, int i16, int i17) {
        setState(TransitionState.SETUP);
        this.mCurrentState = i3;
        this.mBeginState = -1;
        this.mEndState = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i3, i16, i17);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.getConstraintSet(i3).applyTo(this);
        }
    }

    public void setTransition(int i3) {
        float f16;
        if (this.mScene != null) {
            MotionScene.Transition transition = getTransition(i3);
            this.mBeginState = transition.getStartConstraintSetId();
            this.mEndState = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache();
                }
                this.mStateCache.setStartState(this.mBeginState);
                this.mStateCache.setEndState(this.mEndState);
                return;
            }
            int i16 = this.mCurrentState;
            if (i16 == this.mBeginState) {
                f16 = 0.0f;
            } else {
                f16 = i16 == this.mEndState ? 1.0f : Float.NaN;
            }
            this.mScene.setTransition(transition);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            rebuildScene();
            this.mTransitionLastPosition = Float.isNaN(f16) ? 0.0f : f16;
            if (Float.isNaN(f16)) {
                Log.v(TAG, Debug.getLocation() + " transitionToStart ");
                transitionToStart();
                return;
            }
            setProgress(f16);
        }
    }

    private void checkStructure(int i3, ConstraintSet constraintSet) {
        String name = Debug.getName(getContext(), i3);
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            int id5 = childAt.getId();
            if (id5 == -1) {
                Log.w(TAG, "CHECK: " + name + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (constraintSet.getConstraint(id5) == null) {
                Log.w(TAG, "CHECK: " + name + " NO CONSTRAINTS for " + Debug.getName(childAt));
            }
        }
        int[] knownIds = constraintSet.getKnownIds();
        for (int i17 = 0; i17 < knownIds.length; i17++) {
            int i18 = knownIds[i17];
            String name2 = Debug.getName(getContext(), i18);
            if (findViewById(knownIds[i17]) == null) {
                Log.w(TAG, "CHECK: " + name + " NO View matches id " + name2);
            }
            if (constraintSet.getHeight(i18) == -1) {
                Log.w(TAG, "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
            }
            if (constraintSet.getWidth(i18) == -1) {
                Log.w(TAG, "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTransition(MotionScene.Transition transition) {
        this.mScene.setTransition(transition);
        setState(TransitionState.SETUP);
        if (this.mCurrentState == this.mScene.getEndId()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        this.mTransitionLastTime = transition.isTransitionFlag(1) ? -1L : getNanoTime();
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if (startId == this.mBeginState && endId == this.mEndState) {
            return;
        }
        this.mBeginState = startId;
        this.mEndState = endId;
        this.mScene.setTransition(startId, endId);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        rebuildScene();
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(attributeSet);
    }

    private void checkStructure(MotionScene.Transition transition) {
        Log.v(TAG, "CHECK: transition = " + transition.debugString(getContext()));
        Log.v(TAG, "CHECK: transition.setDuration = " + transition.getDuration());
        if (transition.getStartConstraintSetId() == transition.getEndConstraintSetId()) {
            Log.e(TAG, "CHECK: start and end constraint set should not be the same!");
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList<>();
        init(attributeSet);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i3, int i16) {
    }
}
