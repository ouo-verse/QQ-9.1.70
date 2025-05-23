package com.tencent.ams.fusion.widget.slideinteractive;

import android.content.Context;
import android.gesture.Gesture;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.base.SlideInspector;
import com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView;
import com.tencent.ams.fusion.widget.utils.FusionWidgetConfig;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SlideGestureViewHelper implements ISlideGestureView.OnGestureListener, ISlideGestureView.OnGesturePerformedListener {
    static IPatchRedirector $redirector_ = null;
    private static final int CLEAR_GESTURE_DELAY_MILLIS = 16;
    private static final int DEFAULT_GESTURE_COLOR = -1;
    private static final String TAG = "SlideGestureViewHelper";
    private final ViewConfiguration mConfiguration;
    private boolean mDisallowGestureEventNotify;
    private float mDownX;
    private float mDownY;
    private ISlideGestureView mDrawGestureView;
    private Rect mDrawRect;
    private int mGestureBottomMargin;
    private int mGestureClickBottomMargin;
    private int mGestureClickLeftMargin;
    private int mGestureClickRightMargin;
    private int mGestureClickViewHeight;
    private View[] mGestureClickViews;
    private volatile String mGestureColor;
    private int mGestureLeftMargin;
    private int mGestureRightMargin;
    private int mGestureSlideDirection;
    private float mGestureSlideValidAngle;
    private volatile int mGestureSlideValidHeightDp;
    private volatile int mGestureStrokeWidthDp;
    private int mGestureViewHeight;
    private volatile boolean mGestureVisible;
    private volatile boolean mIsGestureOutOfHotArea;
    private final Handler mMainHandler;
    private final View mRootView;
    private ISlideGestureListener mSlideGestureListener;
    private volatile SlideInspector mSlideInspector;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface GestureType {
        public static final int CLICK = 1;
        public static final int SLIDE = 2;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ISlideGestureListener {
        void onGestureResult(int i3, View view, boolean z16, float f16, float f17, float f18);

        void onGestureStart();

        void onTouch(View view, MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface SlideDirection {
        public static final int BOTTOM = 4;
        public static final int LEFT = 1;
        public static final int RIGHT = 3;
        public static final int TOP = 2;
    }

    public SlideGestureViewHelper(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) viewGroup);
            return;
        }
        this.mIsGestureOutOfHotArea = false;
        this.mGestureVisible = true;
        this.mGestureStrokeWidthDp = 8;
        this.mGestureSlideValidHeightDp = 100;
        this.mGestureSlideDirection = 2;
        this.mGestureSlideValidAngle = 90.0f;
        this.mGestureClickLeftMargin = 0;
        this.mGestureClickRightMargin = 0;
        this.mGestureClickViewHeight = 0;
        this.mGestureClickBottomMargin = 0;
        this.mGestureLeftMargin = 0;
        this.mGestureRightMargin = 0;
        this.mGestureViewHeight = -1;
        this.mGestureBottomMargin = 0;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mDisallowGestureEventNotify = false;
        this.mConfiguration = ViewConfiguration.get(context);
        this.mRootView = viewGroup;
        addGestureLayer(context, viewGroup);
    }

    private void addGestureLayer(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View createDrawGestureView = createDrawGestureView(context);
        if (createDrawGestureView != null) {
            updateGestureLayerLayoutParams(createDrawGestureView);
            if (createDrawGestureView.getParent() != null) {
                ((ViewGroup) createDrawGestureView.getParent()).removeView(createDrawGestureView);
            }
            viewGroup.addView(createDrawGestureView);
        }
    }

    private void calculateYOffset(@NonNull PointF pointF, @NonNull PointF pointF2) {
        float f16;
        boolean z16;
        float f17 = pointF2.x - pointF.x;
        float f18 = pointF2.y - pointF.y;
        Logger.d("SlideGestureViewHelperprocessYOffset dpY=  " + Utils.px2dp(f18));
        if (this.mConfiguration != null && (f17 * f17) + (f18 * f18) <= r0.getScaledTouchSlop() * this.mConfiguration.getScaledTouchSlop()) {
            Logger.d("action is click");
            if (isClickInHotArea()) {
                dispatchGestureResultEvent(1, null, true, f17, f18, 0.0f);
                return;
            }
            View findClickTargetView = findClickTargetView();
            if (findClickTargetView != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            dispatchGestureResultEvent(1, findClickTargetView, z16, f17, f18, 0.0f);
            return;
        }
        if (this.mSlideInspector == null) {
            SingleDirectionSlideInspector singleDirectionSlideInspector = new SingleDirectionSlideInspector();
            singleDirectionSlideInspector.setGestureSlideDirection(this.mGestureSlideDirection);
            singleDirectionSlideInspector.setGestureSlideValidAngle(this.mGestureSlideValidAngle);
            singleDirectionSlideInspector.setGestureSlideValidHeightDp(this.mGestureSlideValidHeightDp);
            this.mSlideInspector = singleDirectionSlideInspector;
        }
        boolean inspect = this.mSlideInspector.inspect(pointF, pointF2);
        if (this.mSlideInspector instanceof SingleDirectionSlideInspector) {
            f16 = ((SingleDirectionSlideInspector) this.mSlideInspector).getInspectAngle();
        } else {
            f16 = 0.0f;
        }
        dispatchGestureResultEvent(2, null, inspect, f17, f18, f16);
    }

    private View createDrawGestureView(Context context) {
        if (this.mDrawGestureView != null) {
            Logger.d("SlideGestureViewHelperdo not createDrawGestureView");
            return (View) this.mDrawGestureView;
        }
        if (FusionWidgetConfig.isEnableNewSlideGestureView()) {
            this.mDrawGestureView = new NewSlideGestureView(context);
        } else {
            this.mDrawGestureView = new SlideGestureView(context);
        }
        this.mDrawGestureView.setGestureStrokeType(0);
        this.mDrawGestureView.setGestureColor(getGestureColor());
        this.mDrawGestureView.setGestureVisible(this.mGestureVisible);
        this.mDrawGestureView.setUncertainGestureColor(getGestureColor());
        this.mDrawGestureView.setGestureStrokeWidth(Utils.dp2px(this.mGestureStrokeWidthDp));
        this.mDrawGestureView.setFadeOffset(0L);
        this.mDrawGestureView.setDrawRect(this.mDrawRect);
        Logger.d(TAG, "createDrawGestureView finish");
        return (View) this.mDrawGestureView;
    }

    private void dispatchGestureResultEvent(int i3, View view, boolean z16, float f16, float f17, float f18) {
        ISlideGestureListener iSlideGestureListener;
        if (!this.mDisallowGestureEventNotify && (iSlideGestureListener = this.mSlideGestureListener) != null) {
            iSlideGestureListener.onGestureResult(i3, view, z16, f16, f17, f18);
        }
    }

    private void dispatchGestureStartEvent() {
        ISlideGestureListener iSlideGestureListener;
        if (!this.mDisallowGestureEventNotify && (iSlideGestureListener = this.mSlideGestureListener) != null) {
            iSlideGestureListener.onGestureStart();
        }
    }

    private void dispatchGestureTouchEvent(View view, MotionEvent motionEvent) {
        ISlideGestureListener iSlideGestureListener;
        if (!this.mDisallowGestureEventNotify && (iSlideGestureListener = this.mSlideGestureListener) != null) {
            iSlideGestureListener.onTouch(view, motionEvent);
        }
    }

    private View findClickTargetView() {
        ISlideGestureView iSlideGestureView;
        if (this.mGestureClickViews != null && (iSlideGestureView = this.mDrawGestureView) != null) {
            float left = this.mDownX + iSlideGestureView.getLeft();
            float top = this.mDownY + this.mDrawGestureView.getTop();
            for (View view : this.mGestureClickViews) {
                if (isClickInTargetView(left, top, view)) {
                    return view;
                }
            }
        }
        return null;
    }

    private int getGestureColor() {
        if (!TextUtils.isEmpty(this.mGestureColor)) {
            try {
                return Color.parseColor(this.mGestureColor);
            } catch (Throwable unused) {
                return -1;
            }
        }
        return -1;
    }

    private boolean isClickInHotArea() {
        if (this.mGestureClickViewHeight == 0) {
            return false;
        }
        float left = this.mDownX + this.mDrawGestureView.getLeft();
        float top = this.mDownY + this.mDrawGestureView.getTop();
        Rect rect = new Rect();
        rect.left = this.mGestureClickLeftMargin;
        rect.bottom = this.mRootView.getHeight() - this.mGestureClickBottomMargin;
        rect.right = this.mRootView.getWidth() - this.mGestureClickRightMargin;
        rect.top = rect.bottom - this.mGestureClickViewHeight;
        return rect.contains((int) left, (int) top);
    }

    private boolean isClickInTargetView(float f16, float f17, View view) {
        if (view == null || f16 <= view.getLeft() || f16 >= view.getRight() || f17 <= view.getTop() || f17 >= view.getBottom()) {
            return false;
        }
        return true;
    }

    private void processOutOfHotAreaEvent(View view, float f16, float f17) {
        if (f16 < 0.0f) {
            f16 = 0.0f;
        } else if (f16 > view.getWidth()) {
            f16 = view.getWidth();
        }
        if (f17 < 0.0f) {
            f17 = 0.0f;
        } else if (f17 > view.getHeight()) {
            f17 = view.getHeight();
        }
        calculateYOffset(new PointF(this.mDownX, this.mDownY), new PointF(f16, f17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGestureLayerLayoutParams(View view) {
        if (view == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.mGestureViewHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = this.mGestureViewHeight;
        }
        layoutParams.leftMargin = this.mGestureLeftMargin;
        layoutParams.rightMargin = this.mGestureRightMargin;
        layoutParams.bottomMargin = this.mGestureBottomMargin;
        layoutParams.gravity = 80;
        view.setLayoutParams(layoutParams);
        view.requestLayout();
    }

    public View getDrawGestureView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (View) this.mDrawGestureView;
    }

    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        Logger.d(TAG, NodeProps.ON_ATTACHED_TO_WINDOW);
        ISlideGestureView iSlideGestureView = this.mDrawGestureView;
        if (iSlideGestureView != null) {
            iSlideGestureView.addOnGestureListener(this);
            this.mDrawGestureView.addOnGesturePerformedListener(this);
        }
    }

    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        Logger.d(TAG, NodeProps.ON_DETACHED_FROM_WINDOW);
        ISlideGestureView iSlideGestureView = this.mDrawGestureView;
        if (iSlideGestureView != null) {
            iSlideGestureView.removeOnGestureListener(this);
            this.mDrawGestureView.removeOnGesturePerformedListener(this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView.OnGestureListener
    public void onGesture(View view, MotionEvent motionEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) view, (Object) motionEvent);
            return;
        }
        dispatchGestureTouchEvent(view, motionEvent);
        if (motionEvent != null && view != null) {
            int historySize = motionEvent.getHistorySize();
            int pointerCount = motionEvent.getPointerCount();
            for (int i3 = 0; i3 < historySize; i3++) {
                for (int i16 = 0; i16 < pointerCount; i16++) {
                    Logger.d("SlideGestureViewHelperonGesture, pointerId: " + motionEvent.getPointerId(i16) + ", HistoricalX: " + motionEvent.getHistoricalX(i16, i3) + ", HistoricalY: " + motionEvent.getHistoricalY(i16, i3));
                    float historicalX = motionEvent.getHistoricalX(i16, i3);
                    float historicalY = motionEvent.getHistoricalY(i16, i3);
                    if (historicalX >= 0.0f && historicalX <= view.getWidth() && historicalY >= 0.0f && historicalY <= view.getHeight()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16 && !this.mIsGestureOutOfHotArea) {
                        Logger.d("SlideGestureViewHelperonGesture,GestureOutOfHotArea: currentX= " + historicalX + ", currentY: " + historicalY);
                        this.mIsGestureOutOfHotArea = true;
                        processOutOfHotAreaEvent(view, historicalX, historicalY);
                        this.mMainHandler.postDelayed(new Runnable(view) { // from class: com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ View val$overlay;

                            {
                                this.val$overlay = view;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SlideGestureViewHelper.this, (Object) view);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                KeyEvent.Callback callback = this.val$overlay;
                                if (callback instanceof ISlideGestureView) {
                                    ((ISlideGestureView) callback).clear(false);
                                }
                            }
                        }, 16L);
                    }
                }
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView.OnGestureListener
    public void onGestureCancelled(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) view, (Object) motionEvent);
            return;
        }
        Logger.d("SlideGestureViewHelperonGestureCancelled getX= " + motionEvent.getX() + " getY= " + motionEvent.getY());
        dispatchGestureTouchEvent(view, motionEvent);
        this.mIsGestureOutOfHotArea = true;
        processOutOfHotAreaEvent(view, motionEvent.getX(), motionEvent.getY());
        this.mMainHandler.postDelayed(new Runnable(view) { // from class: com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ View val$overlay;

            {
                this.val$overlay = view;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SlideGestureViewHelper.this, (Object) view);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Logger.w(SlideGestureViewHelper.TAG, "onGestureCancelled overlay.clear");
                KeyEvent.Callback callback = this.val$overlay;
                if (callback instanceof ISlideGestureView) {
                    ((ISlideGestureView) callback).clear(false);
                }
            }
        }, 16L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView.OnGestureListener
    public void onGestureEnded(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) view, (Object) motionEvent);
            return;
        }
        dispatchGestureTouchEvent(view, motionEvent);
        if (view instanceof ISlideGestureView) {
            ((ISlideGestureView) view).cancelGestureEvent(motionEvent);
        }
        if (motionEvent == null) {
            return;
        }
        Logger.d("SlideGestureViewHelperonGestureEnded event " + motionEvent.toString());
        if (!this.mIsGestureOutOfHotArea) {
            calculateYOffset(new PointF(this.mDownX, this.mDownY), new PointF(motionEvent.getX(), motionEvent.getY()));
        }
        this.mDownX = motionEvent.getX();
        this.mDownY = motionEvent.getY();
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView.OnGesturePerformedListener
    public void onGesturePerformed(View view, Gesture gesture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view, (Object) gesture);
            return;
        }
        Logger.d("SlideGestureViewHelperonGesturePerformed " + gesture);
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView.OnGestureListener
    public void onGestureStarted(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) view, (Object) motionEvent);
            return;
        }
        dispatchGestureTouchEvent(view, motionEvent);
        if (motionEvent == null) {
            return;
        }
        this.mIsGestureOutOfHotArea = false;
        Logger.d("SlideGestureViewHelperonGestureStarted event " + motionEvent.toString());
        this.mDownX = motionEvent.getX();
        this.mDownY = motionEvent.getY();
        dispatchGestureStartEvent();
    }

    public void setDisallowGestureEventNotify(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.mDisallowGestureEventNotify = z16;
        }
    }

    public void setDrawRect(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) rect);
            return;
        }
        this.mDrawRect = rect;
        ISlideGestureView iSlideGestureView = this.mDrawGestureView;
        if (iSlideGestureView != null) {
            iSlideGestureView.setDrawRect(rect);
        }
    }

    public void setEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        Logger.d(TAG, "setEnabled: " + z16);
        ISlideGestureView iSlideGestureView = this.mDrawGestureView;
        if (iSlideGestureView != null) {
            iSlideGestureView.setEnabled(z16);
        }
    }

    public void setGestureClickHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.d(TAG, "setGestureClickHotArea: leftMargin: " + i3 + ", rightMargin: " + i16 + ", bottomMargin: " + i17 + ", height: " + i18);
        this.mGestureClickLeftMargin = i3;
        this.mGestureClickRightMargin = i16;
        this.mGestureClickBottomMargin = i17;
        this.mGestureClickViewHeight = i18;
    }

    public void setGestureClickView(View... viewArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) viewArr);
        } else {
            this.mGestureClickViews = viewArr;
        }
    }

    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        Logger.d(TAG, "setGestureColor: " + str);
        this.mGestureColor = str;
        ISlideGestureView iSlideGestureView = this.mDrawGestureView;
        if (iSlideGestureView != null) {
            iSlideGestureView.setGestureColor(getGestureColor());
            this.mDrawGestureView.setUncertainGestureColor(getGestureColor());
        }
    }

    public void setGestureHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.d(TAG, "setGestureHotArea leftMargin: " + i3 + ", rightMargin: " + i16 + ", bottomMargin: " + i17 + ", height: " + i18);
        this.mGestureLeftMargin = i3;
        this.mGestureRightMargin = i16;
        this.mGestureBottomMargin = i17;
        this.mGestureViewHeight = i18;
        Utils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SlideGestureViewHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    SlideGestureViewHelper slideGestureViewHelper = SlideGestureViewHelper.this;
                    slideGestureViewHelper.updateGestureLayerLayoutParams((View) slideGestureViewHelper.mDrawGestureView);
                }
            }
        });
    }

    public void setGestureSlideDirection(@SlideDirection int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.mGestureSlideDirection = i3;
        }
    }

    public void setGestureSlideValidAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else if (f16 > 0.0f) {
            this.mGestureSlideValidAngle = f16;
        }
    }

    public void setGestureSlideValidHeightDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        Logger.d(TAG, "setGestureSlideValidHeightDp: " + i3);
        if (i3 > 0) {
            this.mGestureSlideValidHeightDp = i3;
            return;
        }
        Logger.w(TAG, "setGestureSlideValidHeight with an invalid height: " + i3);
    }

    public void setGestureStrokeWidthDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        Logger.d(TAG, "setGestureStrokeWidthDp: " + i3);
        this.mGestureStrokeWidthDp = i3;
        ISlideGestureView iSlideGestureView = this.mDrawGestureView;
        if (iSlideGestureView != null) {
            iSlideGestureView.setGestureStrokeWidth(Utils.dp2px(this.mGestureStrokeWidthDp));
        }
    }

    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        Logger.d(TAG, "setGestureVisible: " + z16);
        this.mGestureVisible = z16;
        ISlideGestureView iSlideGestureView = this.mDrawGestureView;
        if (iSlideGestureView != null) {
            iSlideGestureView.setGestureVisible(this.mGestureVisible);
        }
    }

    public void setSlideGestureListener(ISlideGestureListener iSlideGestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iSlideGestureListener);
        } else {
            this.mSlideGestureListener = iSlideGestureListener;
        }
    }

    public void setSlideInspector(SlideInspector slideInspector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) slideInspector);
        } else {
            this.mSlideInspector = slideInspector;
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        ISlideGestureView iSlideGestureView = this.mDrawGestureView;
        if (iSlideGestureView != null) {
            iSlideGestureView.stop();
        }
    }
}
