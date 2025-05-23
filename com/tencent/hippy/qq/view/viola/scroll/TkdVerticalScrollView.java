package com.tencent.hippy.qq.view.viola.scroll;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.scroll.HippyVerticalScrollView;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TkdVerticalScrollView extends HippyVerticalScrollView implements TkdScrollView {
    private boolean mIsLoading;
    private int mPreloadDistance;

    public TkdVerticalScrollView(Context context) {
        super(context);
        this.mPreloadDistance = 0;
        this.mIsLoading = false;
        this.mScrollMinOffset = (int) PixelUtil.dp2px(5.0f);
        this.mPreloadDistance = (int) PixelUtil.dp2px(200.0f);
    }

    private boolean shouldEmitEndReachedEvent(int i3, int i16) {
        int i17;
        int height = getHeight();
        int height2 = getHeight();
        if (getChildCount() > 0) {
            height = getChildAt(0).getHeight();
        }
        if (height <= height2 || height < (i17 = this.mPreloadDistance)) {
            return true;
        }
        int i18 = height2 + i3;
        if (i3 <= 0 || i3 <= i16 || i18 < height - i17) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.hippy.qq.view.viola.scroll.TkdScrollView
    public void callLoadMoreFinish() {
        this.mIsLoading = false;
    }

    @Override // com.tencent.hippy.qq.view.viola.scroll.TkdScrollView
    public void callScrollToPosition(int i3, int i16, final Promise promise) {
        int scrollY = getScrollY() + i3;
        if (i16 <= 0) {
            scrollTo(0, scrollY);
            if (promise != null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("msg", "on scroll end!");
                promise.resolve(hippyMap);
                return;
            }
            return;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "scrollX", 0);
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this, "scrollY", scrollY);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(i16);
        animatorSet.playTogether(ofInt, ofInt2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.hippy.qq.view.viola.scroll.TkdVerticalScrollView.1
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
    @Override // com.tencent.mtt.hippy.views.scroll.HippyVerticalScrollView, androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        if (this.mPreloadDistance > 0 && !this.mIsLoading && shouldEmitEndReachedEvent(i16, i18)) {
            TkdScrollViewEventHelper.emitScrollEndReachedEvent(this);
            this.mIsLoading = true;
        }
    }

    @Override // com.tencent.hippy.qq.view.viola.scroll.TkdScrollView
    public void setPreloadDistance(int i3) {
        this.mPreloadDistance = (int) PixelUtil.dp2px(Math.max(0, i3));
    }
}
