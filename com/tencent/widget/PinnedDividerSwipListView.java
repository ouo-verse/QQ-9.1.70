package com.tencent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.widget.AbsListView;
import java.util.LinkedList;

/* loaded from: classes27.dex */
public class PinnedDividerSwipListView extends SwipListView implements AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_ = null;
    private static final int PINNED_DIVDER_STATE_PINNED = 0;
    private static final int PINNED_DIVDER_STATE_PUSHING_UP = 1;
    private static final int PINNED_DIVIDER_STATE_INVISIBLE = -1;
    private DividerAdapter mAdapter;
    private Context mContext;
    private int mCurDividerViewPushUpDistance;
    private int mCurDividerViewState;
    private View mFloatingView;
    private LinkedList<View> mHeaderViews;
    private PinnedDividerListView.b mOnLayoutListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private OnScrollListenerAdapter mOnScrollListenerAdapter;

    /* loaded from: classes27.dex */
    public static abstract class DividerAdapter extends XBaseAdapter {
        static IPatchRedirector $redirector_;

        public DividerAdapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public abstract void configDividerView(View view, int i3);

        public abstract int getDividerLayout();

        public abstract boolean isDividerView(int i3);
    }

    /* loaded from: classes27.dex */
    public interface OnLayoutListener {
        void onLayout(View view, int i3, int i16, int i17, int i18);
    }

    /* loaded from: classes27.dex */
    public static class OnScrollListenerAdapter implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;

        public OnScrollListenerAdapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) absListView, i3);
            }
        }
    }

    public PinnedDividerSwipListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mContext = null;
        this.mAdapter = null;
        this.mFloatingView = null;
        this.mCurDividerViewState = 0;
        this.mCurDividerViewPushUpDistance = 0;
        this.mOnScrollListener = null;
        this.mOnScrollListenerAdapter = null;
        this.mHeaderViews = new LinkedList<>();
        this.mOnLayoutListener = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        super.setOnScrollListener(this);
    }

    @Override // com.tencent.widget.ListView
    public void addHeaderView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            addHeaderView(view, null, false);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        View view = this.mFloatingView;
        if (view != null && view.getVisibility() == 0) {
            drawChild(canvas, this.mFloatingView, getDrawingTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.mFloatingView != null) {
            int firstVisiblePosition = getFirstVisiblePosition() - this.mHeaderViews.size();
            if (firstVisiblePosition >= 0) {
                this.mFloatingView.setVisibility(0);
                View view = this.mFloatingView;
                view.layout(0, -this.mCurDividerViewPushUpDistance, view.getMeasuredWidth(), this.mFloatingView.getMeasuredHeight() - this.mCurDividerViewPushUpDistance);
                this.mAdapter.configDividerView(this.mFloatingView, firstVisiblePosition);
            } else {
                this.mFloatingView.setVisibility(4);
            }
        }
        int childCount = getChildCount();
        for (int size = this.mHeaderViews.size() + 1; size < childCount; size++) {
            View childAt = getChildAt(size);
            if (childAt.getVisibility() != 0) {
                childAt.setVisibility(0);
            }
        }
        PinnedDividerListView.b bVar = this.mOnLayoutListener;
        if (bVar != null) {
            bVar.onLayout(this, i3, i16, i17, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        View view = this.mFloatingView;
        if (view != null) {
            measureChild(view, i3, i16);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.mFloatingView != null) {
            if (i3 >= this.mHeaderViews.size()) {
                i3 -= this.mHeaderViews.size();
                this.mAdapter.configDividerView(this.mFloatingView, i3);
                if (this.mAdapter.isDividerView(i3)) {
                    this.mCurDividerViewState = 0;
                    i18 = 1;
                } else {
                    View childAt = getChildAt(0);
                    if (childAt != null && childAt.getBottom() > this.mFloatingView.getMeasuredHeight()) {
                        this.mCurDividerViewState = 0;
                    } else if (this.mAdapter.isDividerView(i3 + 1)) {
                        this.mCurDividerViewState = 1;
                    } else {
                        this.mCurDividerViewState = 0;
                    }
                    i18 = 0;
                }
                int childCount = getChildCount();
                if (i18 != 0) {
                    View childAt2 = getChildAt(0);
                    if (childAt2.getVisibility() != 4) {
                        childAt2.setVisibility(4);
                    }
                }
                while (i18 < childCount) {
                    View childAt3 = getChildAt(i18);
                    if (childAt3.getVisibility() != 0) {
                        childAt3.setVisibility(0);
                    }
                    i18++;
                }
                if (this.mCurDividerViewState == 1) {
                    View childAt4 = getChildAt(1);
                    int measuredHeight = this.mFloatingView.getMeasuredHeight();
                    if (childAt4 != null) {
                        i19 = childAt4.getTop();
                    } else {
                        i19 = 0;
                    }
                    this.mCurDividerViewPushUpDistance = measuredHeight - i19;
                } else {
                    this.mCurDividerViewPushUpDistance = 0;
                }
                this.mFloatingView.setVisibility(0);
                View view = this.mFloatingView;
                view.layout(0, -this.mCurDividerViewPushUpDistance, view.getMeasuredWidth(), this.mFloatingView.getMeasuredHeight() - this.mCurDividerViewPushUpDistance);
            } else {
                this.mCurDividerViewState = -1;
                this.mFloatingView.setVisibility(4);
                int size = this.mHeaderViews.size();
                if (this.mAdapter.getCount() > 0 && this.mAdapter.isDividerView(0) && size >= i3 && size < i3 + i16) {
                    getChildAt(size - i3).setVisibility(0);
                }
            }
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
        OnScrollListenerAdapter onScrollListenerAdapter = this.mOnScrollListenerAdapter;
        if (onScrollListenerAdapter != null) {
            onScrollListenerAdapter.onScroll(absListView, i3, i16, i17);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) absListView, i3);
            return;
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
        OnScrollListenerAdapter onScrollListenerAdapter = this.mOnScrollListenerAdapter;
        if (onScrollListenerAdapter != null) {
            onScrollListenerAdapter.onScrollStateChanged(absListView, i3);
        }
    }

    @Override // com.tencent.widget.ListView
    public boolean removeHeaderView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) view)).booleanValue();
        }
        boolean removeHeaderView = super.removeHeaderView(view);
        if (removeHeaderView) {
            this.mHeaderViews.remove(view);
        }
        return removeHeaderView;
    }

    public void setOnLayoutListener(PinnedDividerListView.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.mOnLayoutListener = bVar;
        }
    }

    @Override // com.tencent.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onScrollListener);
        } else {
            this.mOnScrollListener = onScrollListener;
        }
    }

    public void setOnScrollListenerAdapter(OnScrollListenerAdapter onScrollListenerAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) onScrollListenerAdapter);
        } else {
            this.mOnScrollListenerAdapter = onScrollListenerAdapter;
        }
    }

    @Override // com.tencent.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, obj, Boolean.valueOf(z16));
        } else {
            super.addHeaderView(view, obj, z16);
            this.mHeaderViews.add(view);
        }
    }

    @Override // com.tencent.widget.SwipListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listAdapter);
            return;
        }
        if (listAdapter instanceof DividerAdapter) {
            DividerAdapter dividerAdapter = (DividerAdapter) listAdapter;
            this.mAdapter = dividerAdapter;
            int dividerLayout = dividerAdapter.getDividerLayout();
            if (dividerLayout != 0) {
                this.mFloatingView = LayoutInflater.from(this.mContext).inflate(dividerLayout, (ViewGroup) this, false);
                requestLayout();
            }
            super.setAdapter((ListAdapter) this.mAdapter);
            return;
        }
        this.mAdapter = null;
        super.setAdapter(listAdapter);
    }

    public PinnedDividerSwipListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mContext = null;
        this.mAdapter = null;
        this.mFloatingView = null;
        this.mCurDividerViewState = 0;
        this.mCurDividerViewPushUpDistance = 0;
        this.mOnScrollListener = null;
        this.mOnScrollListenerAdapter = null;
        this.mHeaderViews = new LinkedList<>();
        this.mOnLayoutListener = null;
        init(context);
    }

    public PinnedDividerSwipListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mContext = null;
        this.mAdapter = null;
        this.mFloatingView = null;
        this.mCurDividerViewState = 0;
        this.mCurDividerViewPushUpDistance = 0;
        this.mOnScrollListener = null;
        this.mOnScrollListenerAdapter = null;
        this.mHeaderViews = new LinkedList<>();
        this.mOnLayoutListener = null;
        init(context);
    }
}
