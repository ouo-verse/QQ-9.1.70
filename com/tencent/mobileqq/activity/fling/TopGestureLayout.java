package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EstablishSetting;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TopGestureLayout extends RelativeLayout {
    static IPatchRedirector $redirector_ = null;
    public static final int FLAG_GESTURE_END = -1;
    public static final int FLAG_GESTURE_FLINE_RL = 2;
    public static final int FLAG_GESTURE_FLING_LR = 1;
    public static final int FLAG_GESTURE_IDLE = 0;
    public static final String TAG = "TopGestureLayout";
    public GestureDetector defaultGestureDetector;
    protected GestureDetector.SimpleOnGestureListener gestureListener;
    private boolean isInLayout;
    private int mGestureFlag;
    private boolean mInterceptScrollLR;
    private boolean mInterceptScrollRL;
    InterceptTouchEventListener mInterceptTouchEventListener;
    private boolean mInterceptTouchFlag;
    private boolean mIsInterceptChildEventWhenScroll;
    public OnGestureListener mOnFlingGesture;
    public GestureDetector mTopGestureDetector;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface InterceptTouchEventListener {
        void OnDispatchTouchEvent(MotionEvent motionEvent);

        boolean OnInterceptTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface OnChangeMultiScreenListener {
        void onChangeMultiScreen(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface OnGestureListener {
        void flingLToR();

        void flingRToL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class TopGestureDetector extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;
        private float mTouchSlot;

        public TopGestureDetector(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TopGestureLayout.this, (Object) context);
            } else {
                this.mTouchSlot = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            TopGestureLayout.this.setGestureFlag(0);
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (!TopGestureLayout.this.isGestureIdle() && !TopGestureLayout.this.isGestureEnd()) {
                if (motionEvent != null && motionEvent2 != null) {
                    float x16 = motionEvent.getX() - motionEvent2.getX();
                    float abs = Math.abs((motionEvent.getY() - motionEvent2.getY()) / x16);
                    if (TopGestureLayout.this.hasGestureFlag(1)) {
                        if (x16 < 0.0f && abs < 0.5f) {
                            TopGestureLayout topGestureLayout = TopGestureLayout.this;
                            if (topGestureLayout.mOnFlingGesture != null) {
                                topGestureLayout.setGestureFlag(-1);
                                if (!TopGestureLayout.this.isInTwoFingerMode()) {
                                    TopGestureLayout.this.mOnFlingGesture.flingLToR();
                                }
                            }
                        }
                    } else if (TopGestureLayout.this.hasGestureFlag(2) && x16 > 0.0f && abs < 0.5f) {
                        TopGestureLayout topGestureLayout2 = TopGestureLayout.this;
                        if (topGestureLayout2.mOnFlingGesture != null) {
                            topGestureLayout2.setGestureFlag(-1);
                            if (!TopGestureLayout.this.isInTwoFingerMode()) {
                                TopGestureLayout.this.mOnFlingGesture.flingRToL();
                            }
                        }
                    }
                    return super.onFling(motionEvent, motionEvent2, f16, f17);
                }
                return super.onFling(motionEvent, motionEvent2, f16, f17);
            }
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (TopGestureLayout.this.isGestureEnd()) {
                return super.onScroll(motionEvent, motionEvent2, f16, f17);
            }
            if (motionEvent != null && motionEvent2 != null) {
                float x16 = motionEvent.getX() - motionEvent2.getX();
                float abs = Math.abs((motionEvent.getY() - motionEvent2.getY()) / x16);
                if (TopGestureLayout.this.isGestureIdle()) {
                    if (Math.abs(x16) > this.mTouchSlot) {
                        if (f16 < 0.0f && abs < 0.5f) {
                            if (TopGestureLayout.this.mInterceptScrollLR) {
                                TopGestureLayout.this.setGestureFlag(1);
                                return TopGestureLayout.this.mIsInterceptChildEventWhenScroll;
                            }
                        } else if (f16 > 0.0f && abs < 0.5f && TopGestureLayout.this.mInterceptScrollRL) {
                            TopGestureLayout.this.setGestureFlag(2);
                            return TopGestureLayout.this.mIsInterceptChildEventWhenScroll;
                        }
                    }
                } else if (TopGestureLayout.this.hasGestureFlag(1)) {
                    if (f16 > 0.0f || abs >= 0.5f) {
                        TopGestureLayout.this.setGestureFlag(-1);
                    }
                } else if (TopGestureLayout.this.hasGestureFlag(2) && (f16 < 0.0f || abs >= 0.5f)) {
                    TopGestureLayout.this.setGestureFlag(-1);
                }
                return super.onScroll(motionEvent, motionEvent2, f16, f17);
            }
            return super.onScroll(motionEvent, motionEvent2, f16, f17);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
            }
            TopGestureLayout.this.setGestureFlag(-1);
            return super.onSingleTapUp(motionEvent);
        }
    }

    public TopGestureLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mInterceptTouchFlag = true;
        this.mInterceptScrollRL = false;
        this.mInterceptScrollLR = true;
        this.mIsInterceptChildEventWhenScroll = true;
        this.isInLayout = false;
        init(context);
    }

    private void reportTGRemoveException() {
        if (this.isInLayout) {
            RuntimeException runtimeException = new RuntimeException("TGRemoveCatchedException");
            if (!EstablishSetting.isDebugVersion()) {
                QLog.e(TAG, 1, "TGRemoveCatchedException ", runtimeException);
                return;
            }
            throw runtimeException;
        }
    }

    @Override // android.view.ViewGroup
    protected void detachViewFromParent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            reportTGRemoveException();
            super.detachViewFromParent(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
        } else {
            if (canvas == null) {
                return;
            }
            try {
                super.dispatchDraw(canvas);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) motionEvent)).booleanValue();
        }
        InterceptTouchEventListener interceptTouchEventListener = this.mInterceptTouchEventListener;
        if (interceptTouchEventListener != null) {
            interceptTouchEventListener.OnDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public GestureDetector getGestureDetector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (GestureDetector) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mTopGestureDetector;
    }

    public GestureDetector.SimpleOnGestureListener getGestureListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (GestureDetector.SimpleOnGestureListener) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.gestureListener;
    }

    @Override // android.view.View
    public int getPaddingTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        if (!useSupPadding()) {
            return ImmersiveUtils.getStatusBarHeight(getContext());
        }
        return super.getPaddingTop();
    }

    public int getPaddingTop2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return super.getPaddingTop();
    }

    public boolean hasGestureFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, i3)).booleanValue();
        }
        if (!isGestureEnd() && (this.mGestureFlag & i3) == i3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        TopGestureDetector topGestureDetector = new TopGestureDetector(context);
        this.gestureListener = topGestureDetector;
        GestureDetector newStickerDismissGestureDetectorInstance = FlingHelperUtils.utils.newStickerDismissGestureDetectorInstance(this, context, topGestureDetector);
        this.mTopGestureDetector = newStickerDismissGestureDetectorInstance;
        this.defaultGestureDetector = newStickerDismissGestureDetectorInstance;
    }

    public boolean isGestureEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        if (this.mGestureFlag == -1) {
            return true;
        }
        return false;
    }

    public boolean isGestureIdle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (this.mGestureFlag == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isInTwoFingerMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        GestureDetector gestureDetector = this.mTopGestureDetector;
        if (gestureDetector != null) {
            return FlingHelperUtils.utils.isInTwoFingerMode(gestureDetector);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.mInterceptTouchFlag) {
            return false;
        }
        InterceptTouchEventListener interceptTouchEventListener = this.mInterceptTouchEventListener;
        if (interceptTouchEventListener != null && !interceptTouchEventListener.OnInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return this.mTopGestureDetector.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.mTopGestureDetector.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) view);
        } else {
            reportTGRemoveException();
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) view);
        } else {
            reportTGRemoveException();
            super.removeViewInLayout(view);
        }
    }

    public void restoreGestureDetector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        GestureDetector gestureDetector = this.defaultGestureDetector;
        if (gestureDetector != null) {
            this.mTopGestureDetector = gestureDetector;
        } else {
            this.mTopGestureDetector = FlingHelperUtils.utils.newStickerDismissGestureDetectorInstance(this, getContext(), this.gestureListener);
        }
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) gestureDetector);
        } else {
            this.mTopGestureDetector = gestureDetector;
        }
    }

    public void setGestureFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else if (i3 != 0 && i3 != -1) {
            this.mGestureFlag = i3 | (this.mGestureFlag & (~i3));
        } else {
            this.mGestureFlag = i3;
        }
    }

    public void setInterceptScrollLRFlag(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.mInterceptScrollLR = z16;
        }
    }

    public void setInterceptScrollRLFlag(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else {
            this.mInterceptScrollRL = z16;
        }
    }

    public void setInterceptTouchEventListener(InterceptTouchEventListener interceptTouchEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) interceptTouchEventListener);
        } else {
            this.mInterceptTouchEventListener = interceptTouchEventListener;
        }
    }

    public void setInterceptTouchFlag(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.mInterceptTouchFlag = z16;
        }
    }

    public void setIsInterceptChildEventWhenScroll(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.mIsInterceptChildEventWhenScroll = z16;
        }
    }

    public void setOnFlingGesture(OnGestureListener onGestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) onGestureListener);
        } else {
            this.mOnFlingGesture = onGestureListener;
        }
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else if (!useSupPadding()) {
            super.setPadding(i3, ImmersiveUtils.getStatusBarHeight(getContext()), i17, i18);
        } else {
            super.setPadding(i3, i16, i17, i18);
        }
    }

    public void setPadding2(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.setPadding(i3, i16, i17, i18);
        }
    }

    protected boolean useSupPadding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected void detachViewFromParent(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) view);
        } else {
            reportTGRemoveException();
            super.detachViewFromParent(view);
        }
    }

    public TopGestureLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TopGestureLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mInterceptTouchFlag = true;
        this.mInterceptScrollRL = false;
        this.mInterceptScrollLR = true;
        this.mIsInterceptChildEventWhenScroll = true;
        this.isInLayout = false;
        init(context);
    }

    public TopGestureLayout(Context context, InterceptTouchEventListener interceptTouchEventListener) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) interceptTouchEventListener);
            return;
        }
        this.mInterceptTouchFlag = true;
        this.mInterceptScrollRL = false;
        this.mInterceptScrollLR = true;
        this.mIsInterceptChildEventWhenScroll = true;
        this.isInLayout = false;
        init(context);
        this.mInterceptTouchEventListener = interceptTouchEventListener;
    }
}
