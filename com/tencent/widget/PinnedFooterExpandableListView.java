package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.PinnedHeaderExpandableListView;

/* loaded from: classes27.dex */
public class PinnedFooterExpandableListView extends XExpandableListView implements AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PinnedFooterExpandableListView";
    private boolean mActionDownHappened;
    PinnedHeaderExpandableListView.ExpandableListAdapter mAdapter;
    Context mContext;
    int mFloatingGroupPos;
    boolean mFooterEnable;
    int mHeaderHeight;
    View mHeaderView;
    int mHeaderWidth;
    private boolean mIsHeaderGroupClickable;
    private FooterExpandListViewListener mListener;
    OnLayoutListener mOnLayoutListener;
    AbsListView.OnScrollListener mOnScrollListener;
    private View mTouchTarget;

    /* loaded from: classes27.dex */
    public interface FooterExpandListViewListener {
        void onClickHeader(PinnedFooterExpandableListView pinnedFooterExpandableListView, View view, int i3);

        void onHeaderDisable();
    }

    /* loaded from: classes27.dex */
    public interface OnLayoutListener {
        void onLayout(View view, int i3, int i16, int i17, int i18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PinnedFooterExpandableListView f384629d;

        a(PinnedFooterExpandableListView pinnedFooterExpandableListView) {
            this.f384629d = pinnedFooterExpandableListView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PinnedFooterExpandableListView.this, (Object) pinnedFooterExpandableListView);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (PinnedFooterExpandableListView.this.mListener != null) {
                FooterExpandListViewListener footerExpandListViewListener = PinnedFooterExpandableListView.this.mListener;
                PinnedFooterExpandableListView pinnedFooterExpandableListView = this.f384629d;
                PinnedFooterExpandableListView pinnedFooterExpandableListView2 = PinnedFooterExpandableListView.this;
                footerExpandListViewListener.onClickHeader(pinnedFooterExpandableListView, pinnedFooterExpandableListView2.mHeaderView, pinnedFooterExpandableListView2.mFloatingGroupPos);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public PinnedFooterExpandableListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mContext = null;
        this.mAdapter = null;
        this.mHeaderView = null;
        this.mOnLayoutListener = null;
        this.mOnScrollListener = null;
        this.mFloatingGroupPos = -1;
        init(context);
    }

    private View getTouchTarget(View view, int i3, int i16) {
        View view2;
        int i17;
        if (!(view instanceof ViewGroup)) {
            return view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int i18 = childCount - 1;
        while (true) {
            if (i18 >= 0) {
                if (isChildrenDrawingOrderEnabled) {
                    i17 = getChildDrawingOrder(childCount, i18);
                } else {
                    i17 = i18;
                }
                view2 = viewGroup.getChildAt(i17);
                if (isTouchPointInView(view2, i3, i16)) {
                    break;
                }
                i18--;
            } else {
                view2 = null;
                break;
            }
        }
        if (view2 != null) {
            return view2;
        }
        return viewGroup;
    }

    private void init(Context context) {
        this.mContext = context;
        super.setOnScrollListener(this);
    }

    private boolean isTouchPointInView(View view, int i3, int i16) {
        if (view.isClickable() && i16 >= view.getTop() && i16 <= view.getBottom() && i3 >= view.getLeft() && i3 <= view.getRight()) {
            return true;
        }
        return false;
    }

    private void refreshHeader() {
        boolean z16;
        int i3;
        ExpandableListAdapter expandableListAdapter = getExpandableListAdapter();
        if (!(expandableListAdapter instanceof PinnedHeaderExpandableListView.ExpandableListAdapter)) {
            return;
        }
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(lastVisiblePosition));
        int measuredHeight = this.mHeaderView.getMeasuredHeight();
        int height = getHeight();
        int i16 = height - measuredHeight;
        int i17 = lastVisiblePosition - 2;
        int i18 = lastVisiblePosition - 1;
        int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(i17));
        if (packedPositionGroup == ((PinnedHeaderExpandableListView.ExpandableListAdapter) expandableListAdapter).getGroupCount() - 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i17 >= 0 && packedPositionGroup2 != packedPositionGroup) {
            if (ExpandableListView.getPackedPositionGroup(getExpandableListPosition(i18)) == packedPositionGroup) {
                i3 = i18;
            } else {
                i3 = lastVisiblePosition;
            }
            View childAt = getChildAt(i3 - firstVisiblePosition);
            if (childAt != null && height - childAt.getTop() >= measuredHeight) {
                int i19 = packedPositionGroup + 1;
                PinnedHeaderExpandableListView.ExpandableListAdapter expandableListAdapter2 = this.mAdapter;
                if (expandableListAdapter2 != null && i19 < expandableListAdapter2.getGroupCount()) {
                    this.mFloatingGroupPos = i19;
                    this.mAdapter.configHeaderView(this.mHeaderView, i19);
                }
                int top = childAt.getTop() + measuredHeight;
                if (top >= i16) {
                    i16 = top;
                }
                if (z16) {
                    this.mFloatingGroupPos = -1;
                    int i26 = -measuredHeight;
                    this.mHeaderView.layout(0, i26, this.mHeaderWidth, i26);
                    return;
                }
                this.mHeaderView.layout(0, i16, this.mHeaderWidth, measuredHeight + i16);
                return;
            }
            PinnedHeaderExpandableListView.ExpandableListAdapter expandableListAdapter3 = this.mAdapter;
            if (expandableListAdapter3 != null && packedPositionGroup < expandableListAdapter3.getGroupCount()) {
                this.mFloatingGroupPos = packedPositionGroup;
                this.mAdapter.configHeaderView(this.mHeaderView, packedPositionGroup);
            }
            if (z16 && i3 != lastVisiblePosition) {
                this.mFloatingGroupPos = -1;
                this.mHeaderView.layout(0, -measuredHeight, this.mHeaderWidth, -this.mHeaderHeight);
                return;
            } else {
                if (ExpandableListView.getPackedPositionType(getExpandableListPosition(i18)) == 0) {
                    setFooterEnable(false);
                    FooterExpandListViewListener footerExpandListViewListener = this.mListener;
                    if (footerExpandListViewListener != null) {
                        footerExpandListViewListener.onHeaderDisable();
                    }
                    this.mFloatingGroupPos = -1;
                    this.mHeaderView.layout(0, -measuredHeight, this.mHeaderWidth, -this.mHeaderHeight);
                    return;
                }
                this.mHeaderView.layout(0, i16, this.mHeaderWidth, this.mHeaderHeight + i16);
                return;
            }
        }
        if (z16) {
            this.mFloatingGroupPos = -1;
            View view = this.mHeaderView;
            int i27 = this.mHeaderHeight;
            view.layout(0, -i27, this.mHeaderWidth, -i27);
        } else {
            this.mHeaderView.layout(0, i16, this.mHeaderWidth, this.mHeaderHeight + i16);
        }
        int i28 = packedPositionGroup + 1;
        PinnedHeaderExpandableListView.ExpandableListAdapter expandableListAdapter4 = this.mAdapter;
        if (expandableListAdapter4 != null && i28 < expandableListAdapter4.getGroupCount()) {
            this.mFloatingGroupPos = i28;
            this.mAdapter.configHeaderView(this.mHeaderView, i28);
        }
    }

    public void createHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.mHeaderView != null || !this.mFooterEnable) {
            return;
        }
        ExpandableListAdapter expandableListAdapter = getExpandableListAdapter();
        if (expandableListAdapter instanceof PinnedHeaderExpandableListView.ExpandableListAdapter) {
            PinnedHeaderExpandableListView.ExpandableListAdapter expandableListAdapter2 = (PinnedHeaderExpandableListView.ExpandableListAdapter) expandableListAdapter;
            this.mAdapter = expandableListAdapter2;
            int headerViewLayoutResourceId = expandableListAdapter2.getHeaderViewLayoutResourceId();
            if (headerViewLayoutResourceId != 0) {
                View inflate = LayoutInflater.from(this.mContext).inflate(headerViewLayoutResourceId, (ViewGroup) this, false);
                this.mHeaderView = inflate;
                if (inflate != null) {
                    inflate.setOnClickListener(new a(this));
                }
                requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ExpandableListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        View view = this.mHeaderView;
        if (view != null && view.getVisibility() == 0) {
            drawChild(canvas, this.mHeaderView, getDrawingTime());
        }
    }

    @Override // com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int packedPositionGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int pointToPosition = pointToPosition(x16, y16);
        View view = this.mHeaderView;
        if (view != null && view.getVisibility() == 0 && y16 >= this.mHeaderView.getTop() && y16 <= this.mHeaderView.getBottom()) {
            if (motionEvent.getAction() == 0) {
                this.mTouchTarget = getTouchTarget(this.mHeaderView, x16, y16);
                this.mActionDownHappened = true;
            } else if (motionEvent.getAction() == 1) {
                View touchTarget = getTouchTarget(this.mHeaderView, x16, y16);
                View view2 = this.mTouchTarget;
                if (touchTarget == view2 && view2.isClickable()) {
                    this.mTouchTarget.performClick();
                    invalidate(new Rect(0, 0, this.mHeaderWidth, this.mHeaderHeight));
                } else if (this.mIsHeaderGroupClickable && (packedPositionGroup = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(pointToPosition))) != -1 && this.mActionDownHappened) {
                    if (isGroupExpanded(packedPositionGroup)) {
                        collapseGroup(packedPositionGroup);
                    } else {
                        expandGroup(packedPositionGroup);
                    }
                }
                this.mActionDownHappened = false;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.drawableStateChanged();
        View view = this.mHeaderView;
        if (view != null) {
            view.refreshDrawableState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        OnLayoutListener onLayoutListener = this.mOnLayoutListener;
        if (onLayoutListener != null) {
            onLayoutListener.onLayout(this, i3, i16, i17, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        View view = this.mHeaderView;
        if (view != null) {
            measureChild(view, i3, i16);
            this.mHeaderWidth = this.mHeaderView.getMeasuredWidth();
            this.mHeaderHeight = this.mHeaderView.getMeasuredHeight();
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.mHeaderView != null) {
            refreshHeader();
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
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
    }

    @Override // com.tencent.widget.ExpandableListView
    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) expandableListAdapter);
        } else {
            super.setAdapter(expandableListAdapter);
            createHeaderView();
        }
    }

    public void setFooterEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        this.mFooterEnable = z16;
        View view = this.mHeaderView;
        if (view != null) {
            if (z16) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void setListener(FooterExpandListViewListener footerExpandListViewListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) footerExpandListViewListener);
        } else {
            this.mListener = footerExpandListViewListener;
        }
    }

    public void setOnLayoutListener(OnLayoutListener onLayoutListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onLayoutListener);
        } else {
            this.mOnLayoutListener = onLayoutListener;
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

    public PinnedFooterExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mContext = null;
        this.mAdapter = null;
        this.mHeaderView = null;
        this.mOnLayoutListener = null;
        this.mOnScrollListener = null;
        this.mFloatingGroupPos = -1;
        init(context);
    }

    public PinnedFooterExpandableListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mContext = null;
        this.mAdapter = null;
        this.mHeaderView = null;
        this.mOnLayoutListener = null;
        this.mOnScrollListener = null;
        this.mFloatingGroupPos = -1;
        init(context);
    }
}
