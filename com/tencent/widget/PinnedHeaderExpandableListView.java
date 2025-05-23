package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;

/* loaded from: classes27.dex */
public class PinnedHeaderExpandableListView extends XExpandableListView implements AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_ = null;
    private static final int PINNED_HEADER_STATE_INVISIBLE = -1;
    private static final int PINNED_HEADER_STATE_PINNED = 0;
    private static final int PINNED_HEADER_STATE_PUSHING_UP = 1;
    private ExpandableListAdapter mAdapter;
    private Context mContext;
    private int mCurHeaderGroupPos;
    private int mCurHeaderViewPushUpDistance;
    private int mCurHeaderViewState;
    private boolean mDispatchTouchEventToHeaderView;
    private View mHeaderView;
    private ExpandableListView.OnGroupClickListener mOnGroupClickedListener;
    private OnLayoutListener mOnLayoutListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    protected boolean mShouldHeaderShow;
    private boolean oweOneForceLayout;

    /* loaded from: classes27.dex */
    public static abstract class ExpandableListAdapter extends BaseExpandableListAdapter {
        static IPatchRedirector $redirector_;

        public ExpandableListAdapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public abstract void configHeaderView(View view, int i3);

        public abstract int getHeaderViewLayoutResourceId();

        public boolean needHideBackgroundGroup() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    /* loaded from: classes27.dex */
    public interface OnLayoutListener {
        void onLayout(View view, int i3, int i16, int i17, int i18);
    }

    /* loaded from: classes27.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PinnedHeaderExpandableListView.this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        
            if (r3.onGroupClick(r4, r10, r11, r4.mAdapter.getGroupId(r11)) == false) goto L18;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                PinnedHeaderExpandableListView pinnedHeaderExpandableListView = PinnedHeaderExpandableListView.this;
                long expandableListPosition = pinnedHeaderExpandableListView.getExpandableListPosition(pinnedHeaderExpandableListView.getFirstVisiblePosition());
                if (ExpandableListView.getPackedPositionType(expandableListPosition) == 0 || ExpandableListView.getPackedPositionType(expandableListPosition) == 1) {
                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                    if (PinnedHeaderExpandableListView.this.mOnGroupClickedListener != null) {
                        ExpandableListView.OnGroupClickListener onGroupClickListener = PinnedHeaderExpandableListView.this.mOnGroupClickedListener;
                        PinnedHeaderExpandableListView pinnedHeaderExpandableListView2 = PinnedHeaderExpandableListView.this;
                    }
                    PinnedHeaderExpandableListView.this.collapseGroup(packedPositionGroup);
                }
            }
            return true;
        }
    }

    public PinnedHeaderExpandableListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mContext = null;
        this.mAdapter = null;
        this.mHeaderView = null;
        this.mDispatchTouchEventToHeaderView = false;
        this.mCurHeaderViewState = 0;
        this.mCurHeaderViewPushUpDistance = 0;
        this.mCurHeaderGroupPos = -1;
        this.mOnLayoutListener = null;
        this.mOnScrollListener = null;
        this.mOnGroupClickedListener = null;
        this.oweOneForceLayout = false;
        this.mShouldHeaderShow = true;
        init(context);
    }

    private void configHeaderView(int i3, boolean z16) {
        View childAt;
        int i16;
        int packedPositionType = ExpandableListView.getPackedPositionType(getExpandableListPosition(i3));
        int i17 = 1;
        if (packedPositionType != 2) {
            if (packedPositionType == 0) {
                if (isUseReplaceHeaderView()) {
                    this.mCurHeaderViewState = 0;
                } else {
                    int i18 = i3 + 1;
                    if (ExpandableListView.getPackedPositionType(getExpandableListPosition(i18)) != 0 && ExpandableListView.getPackedPositionType(getExpandableListPosition(i18)) != 2) {
                        this.mCurHeaderViewState = 0;
                    } else {
                        this.mCurHeaderViewState = -1;
                    }
                }
            } else if (getChildAt(0).getBottom() > this.mHeaderView.getMeasuredHeight()) {
                this.mCurHeaderViewState = 0;
            } else if (ExpandableListView.getPackedPositionType(getExpandableListPosition(i3 + 1)) == 0) {
                this.mCurHeaderViewState = 1;
            } else {
                this.mCurHeaderViewState = 0;
            }
        } else {
            this.mCurHeaderViewState = -1;
        }
        int i19 = this.mCurHeaderViewState;
        if (i19 != -1) {
            if (i19 == 1) {
                View childAt2 = getChildAt(1);
                int measuredHeight = this.mHeaderView.getMeasuredHeight();
                if (childAt2 != null) {
                    i16 = childAt2.getTop();
                } else {
                    i16 = 0;
                }
                this.mCurHeaderViewPushUpDistance = measuredHeight - i16;
            } else {
                this.mCurHeaderViewPushUpDistance = 0;
            }
            if (this.mShouldHeaderShow) {
                this.mHeaderView.setVisibility(0);
                if (this.mAdapter.needHideBackgroundGroup()) {
                    if (packedPositionType == 0 && (childAt = getChildAt(0)) != null && !isDirectChildHeaderOrFooter(childAt)) {
                        childAt.setVisibility(4);
                    } else {
                        i17 = 0;
                    }
                    int childCount = getChildCount();
                    while (i17 < childCount) {
                        View childAt3 = getChildAt(i17);
                        if (childAt3 != null && childAt3.getVisibility() != 0 && !isDirectChildHeaderOrFooter(childAt3)) {
                            childAt3.setVisibility(0);
                        }
                        i17++;
                    }
                }
            }
            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(i3));
            if (packedPositionGroup != this.mCurHeaderGroupPos || z16 || this.oweOneForceLayout) {
                this.oweOneForceLayout = false;
                this.mCurHeaderGroupPos = packedPositionGroup;
                this.mAdapter.configHeaderView(this.mHeaderView, packedPositionGroup);
                this.mHeaderView.measure(View.MeasureSpec.makeMeasureSpec(this.mHeaderView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeaderView.getMeasuredHeight(), 1073741824));
                View view = this.mHeaderView;
                view.layout(0, 0, view.getMeasuredWidth(), this.mHeaderView.getMeasuredHeight());
                return;
            }
            return;
        }
        if (z16) {
            this.oweOneForceLayout = true;
        }
        this.mHeaderView.setVisibility(4);
        if (this.mAdapter.needHideBackgroundGroup()) {
            int childCount2 = getChildCount();
            for (int i26 = 0; i26 < childCount2; i26++) {
                View childAt4 = getChildAt(i26);
                if (childAt4 != null && childAt4.getVisibility() != 0 && !isDirectChildHeaderOrFooter(childAt4)) {
                    childAt4.setVisibility(0);
                }
            }
        }
    }

    private void init(Context context) {
        this.mContext = context;
        super.setOnScrollListener(this);
    }

    private void refreshAllChild(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                refreshAllChild(viewGroup.getChildAt(i3));
            }
        }
        view.refreshDrawableState();
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
        if (this.mHeaderView != null && !isUseReplaceHeaderView() && this.mHeaderView.getVisibility() == 0) {
            canvas.save();
            canvas.translate(0.0f, -this.mCurHeaderViewPushUpDistance);
            drawChild(canvas, this.mHeaderView, getDrawingTime());
            canvas.restore();
        }
    }

    @Override // com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (this.mDispatchTouchEventToHeaderView) {
            View view2 = this.mHeaderView;
            if (view2 != null && view2.dispatchTouchEvent(motionEvent)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.mDispatchTouchEventToHeaderView = false;
            }
            return z16;
        }
        if (!isUseReplaceHeaderView() && (view = this.mHeaderView) != null && x16 >= 0.0f && x16 <= view.getMeasuredWidth() && y16 >= 0.0f && y16 <= this.mHeaderView.getMeasuredHeight() - this.mCurHeaderViewPushUpDistance && motionEvent.getAction() == 0 && this.mHeaderView.getVisibility() == 0 && this.mHeaderView.dispatchTouchEvent(motionEvent)) {
            this.mDispatchTouchEventToHeaderView = true;
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.drawableStateChanged();
        if (this.mHeaderView != null && !isUseReplaceHeaderView()) {
            refreshAllChild(this.mHeaderView);
        }
    }

    public View getHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (View) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mHeaderView;
    }

    public View initHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        int headerViewLayoutResourceId = this.mAdapter.getHeaderViewLayoutResourceId();
        if (headerViewLayoutResourceId != 0) {
            return LayoutInflater.from(this.mContext).inflate(headerViewLayoutResourceId, (ViewGroup) this, false);
        }
        return null;
    }

    public boolean isUseReplaceHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.mHeaderView != null && !isUseReplaceHeaderView()) {
            configHeaderView(getFirstVisiblePosition(), true);
        }
        OnLayoutListener onLayoutListener = this.mOnLayoutListener;
        if (onLayoutListener != null) {
            onLayoutListener.onLayout(this, i3, i16, i17, i18);
        }
        if (isUseReplaceHeaderView() && (view = this.mHeaderView) != null) {
            view.setTranslationY(-this.mCurHeaderViewPushUpDistance);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        if (this.mHeaderView != null && !isUseReplaceHeaderView()) {
            measureChild(this.mHeaderView, i3, i16);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.mHeaderView != null) {
            configHeaderView(i3, false);
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) absListView, i3);
            return;
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
    }

    @Override // com.tencent.widget.ExpandableListView
    public void setAdapter(android.widget.ExpandableListAdapter expandableListAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) expandableListAdapter);
            return;
        }
        super.setAdapter(expandableListAdapter);
        if (expandableListAdapter instanceof ExpandableListAdapter) {
            this.mAdapter = (ExpandableListAdapter) expandableListAdapter;
            View initHeaderView = initHeaderView();
            this.mHeaderView = initHeaderView;
            if (initHeaderView != null) {
                initHeaderView.setOnTouchListener(new a());
            }
            requestLayout();
        }
    }

    public void setHeaderViewShouldShow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.mShouldHeaderShow = z16;
        }
    }

    @Override // com.tencent.widget.ExpandableListView
    public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener onGroupClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onGroupClickListener);
        } else {
            this.mOnGroupClickedListener = onGroupClickListener;
            super.setOnGroupClickListener(onGroupClickListener);
        }
    }

    public void setOnLayoutListener(OnLayoutListener onLayoutListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onLayoutListener);
        } else {
            this.mOnLayoutListener = onLayoutListener;
        }
    }

    @Override // com.tencent.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onScrollListener);
        } else {
            this.mOnScrollListener = onScrollListener;
        }
    }

    public PinnedHeaderExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mContext = null;
        this.mAdapter = null;
        this.mHeaderView = null;
        this.mDispatchTouchEventToHeaderView = false;
        this.mCurHeaderViewState = 0;
        this.mCurHeaderViewPushUpDistance = 0;
        this.mCurHeaderGroupPos = -1;
        this.mOnLayoutListener = null;
        this.mOnScrollListener = null;
        this.mOnGroupClickedListener = null;
        this.oweOneForceLayout = false;
        this.mShouldHeaderShow = true;
        init(context);
    }

    public PinnedHeaderExpandableListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mContext = null;
        this.mAdapter = null;
        this.mHeaderView = null;
        this.mDispatchTouchEventToHeaderView = false;
        this.mCurHeaderViewState = 0;
        this.mCurHeaderViewPushUpDistance = 0;
        this.mCurHeaderGroupPos = -1;
        this.mOnLayoutListener = null;
        this.mOnScrollListener = null;
        this.mOnGroupClickedListener = null;
        this.oweOneForceLayout = false;
        this.mShouldHeaderShow = true;
        init(context);
    }
}
