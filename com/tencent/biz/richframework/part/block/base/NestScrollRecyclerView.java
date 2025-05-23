package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NestScrollRecyclerView extends RecyclerView implements NestedScrollingParent2 {
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mNeedLimitHeightWidth;
    private NestScrollDelegate mNestScrollDelegate;
    private WeakReference<View> mNestTargetViewRef;
    private WeakReference<View> mNestTargetViewWrapperRef;
    private NestedScrollingParentHelper mParentHelper;
    private IRefreshViewProvider mParentRefreshViewProvider;
    private int mTouchSlop;
    private TransDispatchDelegate mTransDispatchDelegate;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface NestScrollDelegate {
        float[] getChildOffsetXY();

        boolean isNestViewNotReachTop(RecyclerView recyclerView);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface TransDispatchDelegate {
        boolean needTransDispatch(MotionEvent motionEvent, RecyclerView recyclerView);
    }

    public NestScrollRecyclerView(Context context) {
        this(context, null);
    }

    private void init() {
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public static boolean isInViewArea(View view, float f16, float f17) {
        view.getLocalVisibleRect(new Rect());
        if (f16 > r0.left && f16 < r0.right && f17 > r0.top && f17 < r0.bottom) {
            return true;
        }
        return false;
    }

    private boolean isNestViewNotReachTop(RecyclerView recyclerView) {
        if (recyclerView instanceof NestScrollRecyclerView) {
            NestScrollRecyclerView nestScrollRecyclerView = (NestScrollRecyclerView) recyclerView;
            if (nestScrollRecyclerView.getNestScrollDelegate() != null) {
                return nestScrollRecyclerView.getNestScrollDelegate().isNestViewNotReachTop(recyclerView);
            }
        }
        if (this.mNestTargetViewWrapperRef != null && this.mNestTargetViewRef.get() != null) {
            if (this.mNestTargetViewWrapperRef.get().getTop() > 0) {
                return true;
            }
            return false;
        }
        RFWLog.d("NestScrollRecyclerView", RFWLog.USR, "[isNestViewNotReachTop] mNestTargetViewWrapper is null");
        return false;
    }

    private boolean isParentConsume(int i3, RecyclerView recyclerView) {
        setParentRefreshViewDelegate(recyclerView);
        if ((i3 > 0 && isNestViewNotReachTop(recyclerView)) || (i3 < 0 && !recyclerView.canScrollVertically(-1))) {
            return true;
        }
        return false;
    }

    private void setParentRefreshView(IRefreshViewProvider iRefreshViewProvider) {
        this.mParentRefreshViewProvider = iRefreshViewProvider;
    }

    private void setParentRefreshViewDelegate(RecyclerView recyclerView) {
        if ((recyclerView instanceof NestScrollRecyclerView) && (getAdapter() instanceof PullLoadMoreAdapter) && ((PullLoadMoreAdapter) getAdapter()).isEnableRefresh()) {
            NestScrollRecyclerView nestScrollRecyclerView = (NestScrollRecyclerView) recyclerView;
            if (nestScrollRecyclerView.getParentRefreshViewProvider() == null) {
                nestScrollRecyclerView.setParentRefreshView(((PullLoadMoreAdapter) getAdapter()).getRefreshViewProvider());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view;
        WeakReference<View> weakReference = this.mNestTargetViewRef;
        if (weakReference == null) {
            view = null;
        } else {
            view = weakReference.get();
        }
        if (this.mTransDispatchDelegate != null && view != null) {
            RecyclerView recyclerView = view;
            if (!isNestViewNotReachTop(recyclerView) && isInViewArea(view, motionEvent.getRawX(), motionEvent.getRawY()) && this.mTransDispatchDelegate.needTransDispatch(motionEvent, recyclerView)) {
                if (view instanceof NestScrollRecyclerView) {
                    NestScrollRecyclerView nestScrollRecyclerView = (NestScrollRecyclerView) view;
                    if (nestScrollRecyclerView.getNestScrollDelegate() != null && nestScrollRecyclerView.getNestScrollDelegate().getChildOffsetXY() != null) {
                        modifyEventPos(motionEvent, view, nestScrollRecyclerView.getNestScrollDelegate().getChildOffsetXY());
                        return view.dispatchTouchEvent(motionEvent);
                    }
                }
                modifyEventPos(motionEvent, view, new float[]{0.0f, 0.0f});
                return view.dispatchTouchEvent(motionEvent);
            }
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e16) {
            if (!RFWApplication.isDebug()) {
                return false;
            }
            throw e16;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i3, int i16) {
        return super.fling(i3, i16);
    }

    public NestScrollDelegate getNestScrollDelegate() {
        return this.mNestScrollDelegate;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public IRefreshViewProvider getParentRefreshViewProvider() {
        return this.mParentRefreshViewProvider;
    }

    public void modifyEventPos(MotionEvent motionEvent, View view, @NonNull float[] fArr) {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        getGlobalVisibleRect(rect);
        float f16 = rect.left - rect2.left;
        float f17 = rect.top - rect2.top;
        if (fArr.length >= 2) {
            f16 -= fArr[0];
            f17 -= fArr[1];
        }
        motionEvent.offsetLocation(f16, f17);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        motionEvent.getActionIndex();
        View view = null;
        if (action != 0) {
            if (action != 2) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            int x16 = (int) (motionEvent.getX() + 0.5f);
            int y16 = (int) (motionEvent.getY() + 0.5f);
            int i3 = x16 - this.mInitialTouchX;
            int i16 = (int) ((y16 - this.mInitialTouchY) * 1.0f);
            if (Math.abs(i3) > this.mTouchSlop && Math.abs(i3) >= Math.abs(i16)) {
                return false;
            }
            WeakReference<View> weakReference = this.mNestTargetViewRef;
            if (weakReference != null) {
                view = weakReference.get();
            }
            if (view instanceof NestScrollRecyclerView) {
                return false;
            }
        } else {
            this.mInitialTouchX = (int) (motionEvent.getX() + 0.5f);
            this.mInitialTouchY = (int) (motionEvent.getY() + 0.5f);
            this.mNestTargetViewRef = null;
            this.mNestTargetViewWrapperRef = null;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.mNeedLimitHeightWidth) {
            i16 = View.MeasureSpec.makeMeasureSpec(ImmersiveUtils.getScreenHeight(), Integer.MIN_VALUE);
            i3 = View.MeasureSpec.makeMeasureSpec(ImmersiveUtils.getScreenWidth(), Integer.MIN_VALUE);
        }
        if (RFWApplication.isDebug()) {
            super.onMeasure(i3, i16);
            return;
        }
        try {
            super.onMeasure(i3, i16);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f16, float f17, boolean z16) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f16, float f17) {
        if (!(view instanceof NestScrollRecyclerView)) {
            return false;
        }
        int i3 = (int) f17;
        if (isParentConsume(i3, (NestScrollRecyclerView) view)) {
            fling((int) f16, i3);
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr, int i17) {
        if ((view instanceof RecyclerView) && isParentConsume(i16, (RecyclerView) view)) {
            scrollBy(0, i16);
            iArr[1] = i16;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3, int i16) {
        this.mNestTargetViewRef = new WeakReference<>(view2);
        this.mNestTargetViewWrapperRef = new WeakReference<>(view);
        this.mParentHelper.onNestedScrollAccepted(view, view2, i3);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3, int i16) {
        if ((i3 & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i3) {
        this.mParentHelper.onStopNestedScroll(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((getAdapter() instanceof PullLoadMoreAdapter) && ((PullLoadMoreAdapter) getAdapter()).isEnableRefresh() && ((PullLoadMoreAdapter) getAdapter()).getRefreshViewProvider() != null) {
            ((PullLoadMoreAdapter) getAdapter()).getRefreshViewProvider().handleRefreshGesture(motionEvent);
        }
        if (getParentRefreshViewProvider() != null) {
            getParentRefreshViewProvider().handleRefreshGesture(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
    }

    public void setNeedLimitHeightWidth(boolean z16) {
        this.mNeedLimitHeightWidth = z16;
    }

    public void setNestScrollDelegate(NestScrollDelegate nestScrollDelegate) {
        this.mNestScrollDelegate = nestScrollDelegate;
    }

    public void setTransDispatchDelegate(TransDispatchDelegate transDispatchDelegate) {
        this.mTransDispatchDelegate = transDispatchDelegate;
    }

    public NestScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19) {
    }
}
