package com.tencent.richframework.widget.refresh.layout.wrapper;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshContent;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.listener.ScrollBoundaryDecider;
import com.tencent.richframework.widget.refresh.layout.simple.SimpleBoundaryDecider;
import com.tencent.richframework.widget.refresh.layout.util.SmartUtil;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RefreshContentWrapper implements IRefreshContent, ValueAnimator.AnimatorUpdateListener {
    protected View mContentView;
    protected View mFixedFooter;
    protected View mFixedHeader;
    protected View mOriginalContentView;
    protected View mScrollableView;
    protected int mLastSpinner = 0;
    protected boolean mEnableRefresh = true;
    protected boolean mEnableLoadMore = true;
    protected SimpleBoundaryDecider mBoundaryAdapter = new SimpleBoundaryDecider();

    public RefreshContentWrapper(@NonNull View view) {
        this.mScrollableView = view;
        this.mOriginalContentView = view;
        this.mContentView = view;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshContent
    public boolean canLoadMore() {
        if (this.mEnableLoadMore && this.mBoundaryAdapter.canLoadMore(this.mContentView)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshContent
    public boolean canRefresh() {
        if (this.mEnableRefresh && this.mBoundaryAdapter.canRefresh(this.mContentView)) {
            return true;
        }
        return false;
    }

    protected void findScrollableView(View view, IRefreshKernel iRefreshKernel) {
        boolean z16;
        this.mContentView.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            if (view2 == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            view = findScrollableViewInternal(view, z16);
            if (view == view2) {
                break;
            } else {
                view2 = view;
            }
        }
        if (view2 != null) {
            this.mScrollableView = view2;
        }
    }

    protected View findScrollableViewByPoint(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (SmartUtil.isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if ((childAt instanceof ViewPager) || !SmartUtil.isContentView(childAt)) {
                        pointF.offset(pointF2.x, pointF2.y);
                        View findScrollableViewByPoint = findScrollableViewByPoint(childAt, pointF, view2);
                        pointF.offset(-pointF2.x, -pointF2.y);
                        return findScrollableViewByPoint;
                    }
                    return childAt;
                }
            }
        }
        return view2;
    }

    protected View findScrollableViewInternal(View view, boolean z16) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z16 || view3 != view) && SmartUtil.isContentView(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        linkedList.add(viewGroup.getChildAt(i3));
                    }
                }
            }
        }
        if (view2 != null) {
            return view2;
        }
        return view;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshContent
    @NonNull
    public View getScrollableView() {
        return this.mScrollableView;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshContent
    @NonNull
    public View getView() {
        return this.mContentView;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void moveSpinner(int i3, int i16, int i17) {
        boolean z16;
        View view;
        View view2;
        View findViewById;
        View findViewById2;
        boolean z17 = true;
        if (i16 != -1 && (findViewById2 = this.mOriginalContentView.findViewById(i16)) != null) {
            if (i3 > 0) {
                findViewById2.setTranslationY(i3);
                z16 = true;
                if (i17 != -1 && (findViewById = this.mOriginalContentView.findViewById(i17)) != null) {
                    if (i3 >= 0) {
                        findViewById.setTranslationY(i3);
                        if (!z17) {
                            this.mOriginalContentView.setTranslationY(i3);
                        } else {
                            this.mOriginalContentView.setTranslationY(0.0f);
                        }
                        view = this.mFixedHeader;
                        if (view != null) {
                            view.setTranslationY(Math.max(0, i3));
                        }
                        view2 = this.mFixedFooter;
                        if (view2 != null) {
                            view2.setTranslationY(Math.min(0, i3));
                            return;
                        }
                        return;
                    }
                    if (findViewById.getTranslationY() < 0.0f) {
                        findViewById.setTranslationY(0.0f);
                    }
                }
                z17 = z16;
                if (!z17) {
                }
                view = this.mFixedHeader;
                if (view != null) {
                }
                view2 = this.mFixedFooter;
                if (view2 != null) {
                }
            } else if (findViewById2.getTranslationY() > 0.0f) {
                findViewById2.setTranslationY(0.0f);
            }
        }
        z16 = false;
        if (i17 != -1) {
            if (i3 >= 0) {
            }
        }
        z17 = z16;
        if (!z17) {
        }
        view = this.mFixedHeader;
        if (view != null) {
        }
        view2 = this.mFixedFooter;
        if (view2 != null) {
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshContent
    public void onActionDown(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.mContentView.getLeft(), -this.mContentView.getTop());
        View view = this.mScrollableView;
        View view2 = this.mContentView;
        if (view != view2) {
            this.mScrollableView = findScrollableViewByPoint(view2, pointF, view);
        }
        if (this.mScrollableView == this.mContentView) {
            this.mBoundaryAdapter.mActionEvent = null;
        } else {
            this.mBoundaryAdapter.mActionEvent = pointF;
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (intValue - this.mLastSpinner) * this.mScrollableView.getScaleY();
            View view = this.mScrollableView;
            if (view instanceof AbsListView) {
                SmartUtil.scrollListBy((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        this.mLastSpinner = intValue;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshContent
    public ValueAnimator.AnimatorUpdateListener scrollContentWhenFinished(int i3) {
        View view = this.mScrollableView;
        if (view != null && i3 != 0) {
            if ((i3 < 0 && view.canScrollVertically(1)) || (i3 > 0 && this.mScrollableView.canScrollVertically(-1))) {
                this.mLastSpinner = i3;
                return this;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshContent
    public void setEnableLoadMoreWhenContentNotFull(boolean z16) {
        this.mBoundaryAdapter.mEnableLoadMoreWhenContentNotFull = z16;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshContent
    public void setScrollBoundaryDecider(ScrollBoundaryDecider scrollBoundaryDecider) {
        if (scrollBoundaryDecider instanceof SimpleBoundaryDecider) {
            this.mBoundaryAdapter = (SimpleBoundaryDecider) scrollBoundaryDecider;
        } else {
            this.mBoundaryAdapter.boundary = scrollBoundaryDecider;
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshContent
    public void setUpComponent(IRefreshKernel iRefreshKernel, View view, View view2) {
        findScrollableView(this.mContentView, iRefreshKernel);
        if (view != null || view2 != null) {
            this.mFixedHeader = view;
            this.mFixedFooter = view2;
            FrameLayout frameLayout = new FrameLayout(this.mContentView.getContext());
            int indexOfChild = iRefreshKernel.getRefreshLayout().getLayout().indexOfChild(this.mContentView);
            iRefreshKernel.getRefreshLayout().getLayout().removeView(this.mContentView);
            frameLayout.addView(this.mContentView, 0, new ViewGroup.LayoutParams(-1, -1));
            iRefreshKernel.getRefreshLayout().getLayout().addView(frameLayout, indexOfChild, this.mContentView.getLayoutParams());
            this.mContentView = frameLayout;
            if (view != null) {
                view.setTag(R.id.f87754v8, "fixed-top");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int indexOfChild2 = viewGroup.indexOfChild(view);
                viewGroup.removeView(view);
                layoutParams.height = SmartUtil.measureViewHeight(view);
                viewGroup.addView(new Space(this.mContentView.getContext()), indexOfChild2, layoutParams);
                frameLayout.addView(view, 1, layoutParams);
            }
            if (view2 != null) {
                view2.setTag(R.id.f87754v8, "fixed-bottom");
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                int indexOfChild3 = viewGroup2.indexOfChild(view2);
                viewGroup2.removeView(view2);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
                layoutParams2.height = SmartUtil.measureViewHeight(view2);
                viewGroup2.addView(new Space(this.mContentView.getContext()), indexOfChild3, layoutParams2);
                layoutParams3.gravity = 80;
                frameLayout.addView(view2, 1, layoutParams3);
            }
        }
    }
}
