package com.tencent.ams.fusion.widget.longpress;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class LongPressView extends FrameLayout implements Animator.AnimatorListener, Animator.AnimatorProgressListener {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_LONG_PRESS_DURATION = 1000;
    private static final float MIN_TOUCH_AREA_EXPAND_VALUE = 1.0f;
    private static final int SHADOW_END_COLOR = 0;
    private static final int SHADOW_START_COLOR = 2130706432;
    private static final float ShADOW_VIEW_HEIGHT_DP = 240.0f;
    private static final String TAG = "LongPressView";
    private final LongPressAnimationHelper animationHelper;
    private boolean mIsDebug;
    private volatile boolean mIsLongPressFinish;
    private boolean mIsStop;
    private int mLongPressDuration;
    private LongPressListener mLongPressListener;
    private float mTouchAreaExpandValue;
    private View mTouchAreaView;

    public LongPressView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mLongPressDuration = 1000;
        this.mTouchAreaExpandValue = 1.0f;
        Logger.setDebug(Utils.isInDebug(context));
        this.animationHelper = new LongPressAnimationHelper(context);
        initView();
    }

    private boolean checkTouchInArea(float f16, float f17) {
        RectF touchAreaRect = getTouchAreaRect();
        Logger.d(TAG, String.format("checkTouchInArea - touchX:%s, touchY:%s, left:%s, right:%s, top:%s, bottom:%s", Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(touchAreaRect.left), Float.valueOf(touchAreaRect.right), Float.valueOf(touchAreaRect.top), Float.valueOf(touchAreaRect.bottom)));
        if (this.mIsDebug) {
            showTouchArea(touchAreaRect);
        }
        if (f16 < touchAreaRect.left || f16 > touchAreaRect.right || f17 < touchAreaRect.top || f17 > touchAreaRect.bottom) {
            return false;
        }
        return true;
    }

    private View createBottomShadowView() {
        View view = new View(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) Utils.dp2px(240.0f));
        layoutParams.gravity = 80;
        view.setLayoutParams(layoutParams);
        view.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{2130706432, 0}));
        return view;
    }

    private RectF getTouchAreaRect() {
        PointF longPressCenterPoint = getLongPressCenterPoint();
        float longPressAreaSize = this.animationHelper.getLongPressAreaSize() * this.mTouchAreaExpandValue;
        float f16 = longPressCenterPoint.x;
        float f17 = longPressAreaSize / 2.0f;
        float f18 = longPressCenterPoint.y;
        return new RectF(f16 - f17, f18 - f17, f16 + f17, f18 + f17);
    }

    private void initView() {
        addView(createBottomShadowView());
        addView(this.animationHelper.createAnimView());
    }

    private void showTouchArea(RectF rectF) {
        if (this.mTouchAreaView == null) {
            View view = new View(getContext());
            this.mTouchAreaView = view;
            view.setBackgroundColor(-16776961);
            addView(this.mTouchAreaView);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mTouchAreaView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        layoutParams.width = (int) rectF.width();
        layoutParams.height = (int) rectF.height();
        layoutParams.leftMargin = (int) rectF.left;
        layoutParams.topMargin = (int) rectF.top;
        this.mTouchAreaView.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.mIsStop && !this.mIsLongPressFinish) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 && !this.mIsLongPressFinish) {
                    this.animationHelper.stopProgressAnimation();
                    long progressAnimatorPlayedDuration = this.animationHelper.getProgressAnimatorPlayedDuration();
                    LongPressListener longPressListener = this.mLongPressListener;
                    if (longPressListener != null) {
                        longPressListener.onLongPressCancel(progressAnimatorPlayedDuration);
                    }
                    Logger.i(TAG, "onLongPressCancel duration:" + progressAnimatorPlayedDuration);
                }
            } else {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                if (checkTouchInArea(x16, y16)) {
                    this.animationHelper.startProgressAnimation(this.mLongPressDuration, this, this);
                    LongPressListener longPressListener2 = this.mLongPressListener;
                    if (longPressListener2 != null) {
                        longPressListener2.onLongPressStart(x16, y16);
                    }
                    Logger.i(TAG, "onLongPressStart");
                    return true;
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public PointF getLongPressCenterPoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (PointF) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.animationHelper.getLongPressCenterPoint(this);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
    public void onAnimationFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.mIsLongPressFinish = true;
        LongPressListener longPressListener = this.mLongPressListener;
        if (longPressListener != null) {
            longPressListener.onLongPressFinish();
        }
        Logger.i(TAG, "onLongPressFinish");
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorProgressListener
    public void onAnimationProgressUpdate(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
            return;
        }
        Logger.d(TAG, "onAnimationProgressUpdate: " + f16);
        LongPressListener longPressListener = this.mLongPressListener;
        if (longPressListener != null) {
            longPressListener.onLongPressProgressUpdate(f16);
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Logger.i(TAG, "pause");
        LongPressAnimationHelper longPressAnimationHelper = this.animationHelper;
        if (longPressAnimationHelper != null) {
            longPressAnimationHelper.pauseAnimation();
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Logger.i(TAG, "resume");
        LongPressAnimationHelper longPressAnimationHelper = this.animationHelper;
        if (longPressAnimationHelper != null) {
            longPressAnimationHelper.resumeAnimation();
        }
    }

    public void setDebug(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.mIsDebug = z16;
            Logger.setDebug(z16);
        }
    }

    public void setHeartColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.animationHelper.setHeartColor(str);
        }
    }

    public void setLongPressAreaExpand(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else if (f16 >= 1.0f) {
            this.mTouchAreaExpandValue = f16;
        }
    }

    public void setLongPressDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (i3 > 0) {
            this.mLongPressDuration = i3;
            return;
        }
        Logger.w(TAG, "setLongPressDuration with invalid duration:" + i3);
    }

    public void setLongPressListener(LongPressListener longPressListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) longPressListener);
        } else {
            this.mLongPressListener = longPressListener;
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.animationHelper.setSubTitle(str);
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.animationHelper.setTitle(str);
        }
    }

    public void start() {
        LongPressAnimationHelper longPressAnimationHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Logger.i(TAG, "start");
        if (!this.mIsStop && (longPressAnimationHelper = this.animationHelper) != null) {
            longPressAnimationHelper.startBreathingAnimation();
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Logger.i(TAG, "stop");
        this.mIsStop = true;
        LongPressAnimationHelper longPressAnimationHelper = this.animationHelper;
        if (longPressAnimationHelper != null) {
            longPressAnimationHelper.stopAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorProgressListener
    public int updateInterval() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 100;
    }
}
