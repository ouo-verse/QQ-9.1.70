package com.tencent.hippy.qq.view.viola.scroll;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TkdHorizontalScrollView extends HippyHorizontalScrollView implements TkdScrollView {
    private boolean mIsLoading;
    private float mLastScrollX;
    private int mPreloadDistance;

    public TkdHorizontalScrollView(Context context) {
        super(context);
        this.mPreloadDistance = 0;
        this.mIsLoading = false;
        this.mLastScrollX = 0.0f;
        this.mScrollMinOffset = (int) PixelUtil.dp2px(5.0f);
        this.mPreloadDistance = (int) PixelUtil.dp2px(200.0f);
    }

    private void setLoadMoreState(boolean z16) {
        this.mIsLoading = z16;
    }

    private boolean shouldEmitEndReachedEvent(int i3, int i16) {
        int i17;
        int width = getWidth();
        int width2 = getWidth();
        if (getChildCount() > 0) {
            width = getChildAt(0).getWidth();
        }
        if (width <= width2 || width < (i17 = this.mPreloadDistance)) {
            return true;
        }
        int i18 = width2 + i3;
        if (i3 <= 0 || i3 <= i16 || i18 < width - i17) {
            return false;
        }
        return true;
    }

    private boolean shouldEmitStartReachedEvent(int i3, int i16) {
        if (i3 < i16 && i3 < this.mPreloadDistance) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.view.viola.scroll.TkdScrollView
    public void callLoadMoreFinish() {
        setLoadMoreState(false);
    }

    @Override // com.tencent.hippy.qq.view.viola.scroll.TkdScrollView
    public void callScrollToPosition(int i3, int i16, final Promise promise) {
        int scrollX = getScrollX() + i3;
        if (i16 <= 0) {
            scrollTo(scrollX, 0);
            if (promise != null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("msg", "on scroll end!");
                promise.resolve(hippyMap);
                return;
            }
            return;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "scrollX", scrollX);
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this, "scrollY", 0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(i16);
        animatorSet.playTogether(ofInt, ofInt2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.hippy.qq.view.viola.scroll.TkdHorizontalScrollView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (promise != null) {
                    HippyMap hippyMap2 = new HippyMap();
                    hippyMap2.pushString("msg", "on scroll end!");
                    promise.resolve(hippyMap2);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
    }

    @Override // com.tencent.hippy.qq.view.viola.scroll.TkdScrollView
    public void callScrollToTop(boolean z16) {
        if (z16) {
            smoothScrollTo(0, 0);
        } else {
            scrollTo(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        if (this.mPreloadDistance > 0 && !this.mIsLoading) {
            if (shouldEmitEndReachedEvent(i3, i17)) {
                TkdScrollViewEventHelper.emitScrollEndReachedEvent(this);
                setLoadMoreState(true);
            } else if (shouldEmitStartReachedEvent(i3, i17)) {
                TkdScrollViewEventHelper.emitScrollStartReachedEvent(this);
                setLoadMoreState(true);
            }
        }
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView, android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 2 && !this.mIsLoading) {
            if (getScrollX() == 0) {
                if (this.mLastScrollX == 0.0f) {
                    this.mLastScrollX = motionEvent.getX();
                } else if (motionEvent.getX() > this.mLastScrollX) {
                    TkdScrollViewEventHelper.emitScrollStartReachedEvent(this);
                    setLoadMoreState(true);
                    this.mLastScrollX = 0.0f;
                }
            } else if (getChildCount() > 0) {
                if (getScrollX() + getWidth() >= getChildAt(0).getWidth() - 2) {
                    if (this.mLastScrollX == 0.0f) {
                        this.mLastScrollX = motionEvent.getX();
                    } else if (motionEvent.getX() < this.mLastScrollX) {
                        TkdScrollViewEventHelper.emitScrollEndReachedEvent(this);
                        setLoadMoreState(true);
                        this.mLastScrollX = 0.0f;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.hippy.qq.view.viola.scroll.TkdScrollView
    public void setPreloadDistance(int i3) {
        this.mPreloadDistance = (int) PixelUtil.dp2px(Math.max(0, i3));
    }
}
