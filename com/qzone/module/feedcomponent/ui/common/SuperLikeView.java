package com.qzone.module.feedcomponent.ui.common;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.adapter.feedcomponent.h;
import com.qzone.component.OnTouchEventDelegateListener;
import com.qzone.component.TouchEventDelegator;
import com.qzone.module.feedcomponent.util.PressStateUtils;
import com.qzone.proxy.feedcomponent.ui.SuperLikeAnimator$Event;
import com.qzone.proxy.feedcomponent.util.g;
import com.qzone.widget.AsyncImageView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SuperLikeView extends AsyncImageView implements TouchEventDelegator {
    public static final int LONG_PRESS_TIME_DELAY = h.b("QZoneSetting", "polymorphicPraiseLongClickTime", 200);
    Runnable mCheckStartAnimation;
    boolean mEndAnimation;
    OnEventBack mEventBack;
    SetTouchDelegate mSetTouchDelegate;
    boolean mStartAnimation;
    private OnTouchEventDelegateListener mTouchEventDelegateListener;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnEventBack {
        void onEventBack(SuperLikeAnimator$Event superLikeAnimator$Event, View view);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private class SetTouchDelegate implements Runnable {
        View mParent;

        SetTouchDelegate() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            SuperLikeView.this.getHitRect(rect);
            int a16 = g.a(10.0f);
            rect.top -= a16;
            rect.bottom += a16;
            rect.left -= a16;
            rect.right += a16;
            this.mParent.setTouchDelegate(new TouchDelegate(rect, SuperLikeView.this));
        }
    }

    public SuperLikeView(Context context) {
        this(context, null);
    }

    private boolean passTouchEventIfNeed(MotionEvent motionEvent) {
        OnTouchEventDelegateListener onTouchEventDelegateListener;
        if (!this.mStartAnimation || (onTouchEventDelegateListener = this.mTouchEventDelegateListener) == null) {
            return false;
        }
        onTouchEventDelegateListener.onTouchEventListener(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.mSetTouchDelegate.mParent == null) {
            View view = (View) getParent();
            SetTouchDelegate setTouchDelegate = this.mSetTouchDelegate;
            setTouchDelegate.mParent = view;
            ViewCompat.postOnAnimation(view, setTouchDelegate);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TouchDelegate touchDelegate = getTouchDelegate();
        if (touchDelegate != null) {
            touchDelegate.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mStartAnimation = false;
            this.mEndAnimation = false;
            postDelayed(this.mCheckStartAnimation, LONG_PRESS_TIME_DELAY);
            PressStateUtils.setAlphaAfterPress(this);
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                passTouchEventIfNeed(motionEvent);
                return true;
            }
            if (actionMasked != 3) {
                return false;
            }
            if (!this.mStartAnimation) {
                removeCallbacks(this.mCheckStartAnimation);
            }
            PressStateUtils.setAlphaBeforePress(this);
            passTouchEventIfNeed(motionEvent);
            return true;
        }
        if (passTouchEventIfNeed(motionEvent)) {
            return true;
        }
        if (!this.mStartAnimation) {
            removeCallbacks(this.mCheckStartAnimation);
            if (this.mEventBack != null && isEnabled() && isClickable()) {
                this.mEventBack.onEventBack(SuperLikeAnimator$Event.CLICK, this);
            }
        }
        PressStateUtils.setAlphaBeforePress(this);
        return true;
    }

    public void setOnEventBack(OnEventBack onEventBack) {
        this.mEventBack = onEventBack;
    }

    @Override // com.qzone.component.TouchEventDelegator
    public void setTouchEventDelegateListener(OnTouchEventDelegateListener onTouchEventDelegateListener) {
        this.mTouchEventDelegateListener = onTouchEventDelegateListener;
    }

    public SuperLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckStartAnimation = new Runnable() { // from class: com.qzone.module.feedcomponent.ui.common.SuperLikeView.1
            @Override // java.lang.Runnable
            public void run() {
                SuperLikeView superLikeView = SuperLikeView.this;
                superLikeView.mStartAnimation = true;
                OnEventBack onEventBack = superLikeView.mEventBack;
                if (onEventBack != null) {
                    onEventBack.onEventBack(SuperLikeAnimator$Event.START_LONG_PRESS, superLikeView);
                }
            }
        };
        this.mSetTouchDelegate = new SetTouchDelegate();
    }

    public void setDisallowInterceptTouchEvent(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
    }
}
