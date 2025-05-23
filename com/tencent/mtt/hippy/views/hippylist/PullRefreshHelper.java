package com.tencent.mtt.hippy.views.hippylist;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.AnimatorListenerBase;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterView;
import com.tencent.mtt.hippy.views.refresh.HippyPullHeaderView;

/* loaded from: classes20.dex */
public abstract class PullRefreshHelper {
    public static final int DURATION = 200;
    public static final float PULL_RATIO = 2.4f;

    @Nullable
    protected ValueAnimator mAnimator;
    protected final LinearLayout mContainer;

    @Nullable
    protected View mItemView;
    protected final HippyRecyclerView mRecyclerView;
    protected PullRefreshStatus mRefreshStatus = PullRefreshStatus.PULL_STATUS_FOLDED;
    protected final RenderNode mRenderNode;

    /* loaded from: classes20.dex */
    public enum PullRefreshStatus {
        PULL_STATUS_FOLDED,
        PULL_STATUS_DRAGGING,
        PULL_STATUS_REFRESHING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PullRefreshHelper(@NonNull HippyRecyclerView hippyRecyclerView, @NonNull RenderNode renderNode) {
        this.mRecyclerView = hippyRecyclerView;
        this.mRenderNode = renderNode;
        this.mContainer = new LinearLayout(hippyRecyclerView.getContext());
    }

    public abstract void enableRefresh();

    /* JADX INFO: Access modifiers changed from: protected */
    public void endAnimation() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.end();
            this.mAnimator = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void endDrag() {
        PullRefreshStatus pullRefreshStatus = this.mRefreshStatus;
        PullRefreshStatus pullRefreshStatus2 = PullRefreshStatus.PULL_STATUS_FOLDED;
        if (pullRefreshStatus == pullRefreshStatus2) {
            return;
        }
        int nodeSize = getNodeSize();
        int visibleSize = getVisibleSize();
        if (visibleSize >= nodeSize) {
            if (this.mRefreshStatus == PullRefreshStatus.PULL_STATUS_DRAGGING) {
                this.mRefreshStatus = PullRefreshStatus.PULL_STATUS_REFRESHING;
                sendReleasedEvent();
            }
            smoothResizeTo(getVisibleSize(), nodeSize, 200);
            return;
        }
        if (this.mRefreshStatus == PullRefreshStatus.PULL_STATUS_DRAGGING) {
            this.mRefreshStatus = pullRefreshStatus2;
        }
        if (visibleSize > 0) {
            smoothResizeTo(getVisibleSize(), 0, 200);
        }
    }

    protected int getNodeSize() {
        if (isVertical()) {
            return this.mRenderNode.getHeight();
        }
        return this.mRenderNode.getWidth();
    }

    public View getView() {
        return this.mContainer;
    }

    public int getVisibleHeight() {
        ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
        if (layoutParams == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int getVisibleSize() {
        ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
        if (layoutParams == null) {
            return 0;
        }
        if (isVertical()) {
            return layoutParams.height;
        }
        return layoutParams.width;
    }

    public int getVisibleWidth() {
        ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
        if (layoutParams == null) {
            return 0;
        }
        return layoutParams.width;
    }

    protected abstract int handleDrag(int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isVertical() {
        int i3;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            i3 = ((LinearLayoutManager) layoutManager).getOrientation();
        } else {
            i3 = 1;
        }
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    public void onDestroy() {
        this.mItemView = null;
        this.mContainer.removeAllViews();
        endAnimation();
    }

    public void onLayoutOrientationChanged() {
        int i3;
        LinearLayout.LayoutParams layoutParams;
        int i16;
        if (this.mItemView != null && this.mContainer != null) {
            boolean isVertical = isVertical();
            int i17 = 0;
            LinearLayout linearLayout = this.mContainer;
            if (isVertical) {
                linearLayout.setOrientation(0);
            } else {
                linearLayout.setOrientation(1);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mItemView.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                layoutParams2.width = this.mRenderNode.getWidth();
                layoutParams2.height = this.mRenderNode.getHeight();
                View view = this.mItemView;
                if (view instanceof HippyPullHeaderView) {
                    layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                    if (isVertical) {
                        i16 = 80;
                    } else {
                        i16 = 5;
                    }
                } else if (view instanceof HippyPullFooterView) {
                    layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                    if (isVertical) {
                        i16 = 48;
                    } else {
                        i16 = 3;
                    }
                }
                layoutParams.gravity = i16;
            }
            ViewGroup.LayoutParams layoutParams3 = this.mContainer.getLayoutParams();
            if (layoutParams3 != null) {
                if (isVertical) {
                    i3 = -1;
                } else {
                    i3 = 0;
                }
                layoutParams3.width = i3;
                if (!isVertical) {
                    i17 = -1;
                }
                layoutParams3.height = i17;
            }
        }
    }

    public void onRefreshCompleted(int i3) {
        if (this.mRefreshStatus == PullRefreshStatus.PULL_STATUS_REFRESHING) {
            this.mRefreshStatus = PullRefreshStatus.PULL_STATUS_FOLDED;
            smoothResizeTo(getVisibleSize(), 0, i3);
        }
    }

    protected void sendCompatScrollEvent() {
        this.mRecyclerView.getRecyclerViewEventHelper().checkSendOnScrollEvent();
    }

    protected abstract void sendPullingEvent(int i3);

    protected abstract void sendReleasedEvent();

    /* JADX WARN: Removed duplicated region for block: B:11:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setItemView(View view) {
        int i3;
        int i16;
        boolean isVertical = isVertical();
        this.mItemView = view;
        this.mContainer.removeAllViews();
        int i17 = 0;
        LinearLayout linearLayout = this.mContainer;
        if (isVertical) {
            linearLayout.setOrientation(0);
        } else {
            linearLayout.setOrientation(1);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mRenderNode.getWidth(), this.mRenderNode.getHeight());
        if (view instanceof HippyPullHeaderView) {
            if (isVertical) {
                i3 = 80;
            } else {
                i3 = 5;
            }
        } else {
            if (view instanceof HippyPullFooterView) {
                if (isVertical) {
                    i3 = 48;
                } else {
                    i3 = 3;
                }
            }
            this.mContainer.addView(view, layoutParams);
            if (!isVertical) {
                i16 = -1;
            } else {
                i16 = 0;
            }
            if (!isVertical) {
                i17 = -1;
            }
            this.mContainer.setLayoutParams(new RecyclerView.LayoutParams(i16, i17));
        }
        layoutParams.gravity = i3;
        this.mContainer.addView(view, layoutParams);
        if (!isVertical) {
        }
        if (!isVertical) {
        }
        this.mContainer.setLayoutParams(new RecyclerView.LayoutParams(i16, i17));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVisibleSize(int i3) {
        ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
        boolean isVertical = isVertical();
        int max = Math.max(i3, 0);
        if (isVertical) {
            layoutParams.height = max;
        } else {
            layoutParams.width = max;
        }
        this.mContainer.setLayoutParams(layoutParams);
        this.mRecyclerView.dispatchLayout();
        sendCompatScrollEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void smoothResizeTo(int i3, int i16, int i17) {
        if (i17 == 0) {
            setVisibleSize(i16);
            return;
        }
        endAnimation();
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, i16);
        this.mAnimator = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mtt.hippy.views.hippylist.PullRefreshHelper.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PullRefreshHelper.this.setVisibleSize(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.mAnimator.addListener(new AnimatorListenerBase() { // from class: com.tencent.mtt.hippy.views.hippylist.PullRefreshHelper.2
            @Override // com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.AnimatorListenerBase, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }
        });
        this.mAnimator.setDuration(i17).start();
    }
}
