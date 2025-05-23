package com.tencent.widget;

import android.annotation.SuppressLint;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;

/* loaded from: classes27.dex */
public class PinnedHeadAndFootExpandableListView extends XExpandableListView implements AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;
    boolean C;
    int D;
    int E;
    int F;
    AbsListView.OnScrollListener G;
    ExpandableListView.OnGroupClickListener H;
    int I;
    boolean J;
    View K;
    boolean L;
    boolean M;
    private boolean N;
    public int P;

    /* renamed from: d, reason: collision with root package name */
    int f384631d;

    /* renamed from: e, reason: collision with root package name */
    int f384632e;

    /* renamed from: f, reason: collision with root package name */
    Context f384633f;

    /* renamed from: h, reason: collision with root package name */
    c f384634h;

    /* renamed from: i, reason: collision with root package name */
    View f384635i;

    /* renamed from: m, reason: collision with root package name */
    View f384636m;

    /* loaded from: classes27.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PinnedHeadAndFootExpandableListView.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                PinnedHeadAndFootExpandableListView pinnedHeadAndFootExpandableListView = PinnedHeadAndFootExpandableListView.this;
                long expandableListPosition = pinnedHeadAndFootExpandableListView.getExpandableListPosition(pinnedHeadAndFootExpandableListView.getFirstVisiblePosition());
                if (ExpandableListView.getPackedPositionType(expandableListPosition) == 0 || ExpandableListView.getPackedPositionType(expandableListPosition) == 1) {
                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                    PinnedHeadAndFootExpandableListView pinnedHeadAndFootExpandableListView2 = PinnedHeadAndFootExpandableListView.this;
                    ExpandableListView.OnGroupClickListener onGroupClickListener = pinnedHeadAndFootExpandableListView2.H;
                    if (onGroupClickListener == null || !onGroupClickListener.onGroupClick(pinnedHeadAndFootExpandableListView2, view, packedPositionGroup, pinnedHeadAndFootExpandableListView2.f384634h.getGroupId(packedPositionGroup))) {
                        PinnedHeadAndFootExpandableListView.this.collapseGroup(packedPositionGroup);
                    }
                }
            }
            return true;
        }
    }

    /* loaded from: classes27.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PinnedHeadAndFootExpandableListView f384638d;

        b(PinnedHeadAndFootExpandableListView pinnedHeadAndFootExpandableListView) {
            this.f384638d = pinnedHeadAndFootExpandableListView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PinnedHeadAndFootExpandableListView.this, (Object) pinnedHeadAndFootExpandableListView);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PinnedHeadAndFootExpandableListView.this.getClass();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes27.dex */
    public interface c extends ExpandableListAdapter {
        void configHeaderView(View view, int i3);

        int getHeaderViewLayoutResourceId();
    }

    /* loaded from: classes27.dex */
    public interface d {
    }

    /* loaded from: classes27.dex */
    public interface e {
    }

    public PinnedHeadAndFootExpandableListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f384633f = null;
        this.f384634h = null;
        this.f384635i = null;
        this.f384636m = null;
        this.C = false;
        this.D = 0;
        this.E = 0;
        this.F = -1;
        this.G = null;
        this.H = null;
        this.I = -1;
        this.N = false;
        init(context);
    }

    private void b0() {
        setFooterEnable(false);
    }

    private View c0(View view, int i3, int i16) {
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
                if (d0(view2, i3, i16)) {
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

    private void configHeaderView(int i3, boolean z16) {
        int i16;
        int packedPositionType = ExpandableListView.getPackedPositionType(getExpandableListPosition(i3));
        if (packedPositionType != 2) {
            if (packedPositionType == 0) {
                int i17 = i3 + 1;
                if (ExpandableListView.getPackedPositionType(getExpandableListPosition(i17)) != 0 && ExpandableListView.getPackedPositionType(getExpandableListPosition(i17)) != 2) {
                    this.D = 0;
                } else {
                    this.D = -1;
                }
            } else if (getChildAt(0).getBottom() > this.f384636m.getMeasuredHeight()) {
                this.D = 0;
            } else if (ExpandableListView.getPackedPositionType(getExpandableListPosition(i3 + 1)) == 0) {
                this.D = 1;
            } else {
                this.D = 0;
            }
        } else {
            this.D = -1;
        }
        int i18 = this.D;
        if (i18 != -1) {
            if (i18 == 1) {
                View childAt = getChildAt(1);
                int measuredHeight = this.f384636m.getMeasuredHeight();
                if (childAt != null) {
                    i16 = childAt.getTop();
                } else {
                    i16 = 0;
                }
                this.E = measuredHeight - i16;
            } else {
                this.E = 0;
            }
            this.f384636m.setVisibility(0);
            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(i3));
            if (packedPositionGroup != this.F || z16 || this.N) {
                this.N = false;
                this.F = packedPositionGroup;
                this.f384634h.configHeaderView(this.f384636m, packedPositionGroup);
                this.f384636m.measure(View.MeasureSpec.makeMeasureSpec(this.f384636m.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f384636m.getMeasuredHeight(), 1073741824));
                View view = this.f384636m;
                view.layout(0, 0, view.getMeasuredWidth(), this.f384636m.getMeasuredHeight());
                return;
            }
            return;
        }
        if (z16) {
            this.N = true;
        }
        this.f384636m.setVisibility(4);
    }

    private boolean d0(View view, int i3, int i16) {
        if (view.isClickable() && i16 >= view.getTop() && i16 <= view.getBottom() && i3 >= view.getLeft() && i3 <= view.getRight()) {
            return true;
        }
        return false;
    }

    private void e0(int i3) {
        c cVar = this.f384634h;
        if (cVar != null && this.f384635i != null && i3 < cVar.getGroupCount()) {
            this.I = i3;
            if (i3 < 1) {
                this.f384635i.setVisibility(8);
            } else {
                this.f384635i.setVisibility(0);
                this.f384634h.configHeaderView(this.f384635i, i3);
            }
        }
    }

    private void init(Context context) {
        this.f384633f = context;
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

    @Override // com.tencent.widget.ListView
    public void addHeaderView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view);
        } else {
            this.P = 1;
            super.addHeaderView(view);
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
        View view = this.f384636m;
        if (view != null && view.getVisibility() == 0) {
            canvas.save();
            canvas.translate(0.0f, -this.E);
            drawChild(canvas, this.f384636m, getDrawingTime());
            canvas.restore();
        }
        View view2 = this.f384635i;
        if (view2 != null && view2.getVisibility() == 0) {
            drawChild(canvas, this.f384635i, getDrawingTime());
        }
    }

    @Override // com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int i3 = (int) x16;
        int i16 = (int) y16;
        int pointToPosition = pointToPosition(i3, i16);
        View view = this.f384635i;
        if (view != null && view.getVisibility() == 0 && i16 >= this.f384635i.getTop() && i16 <= this.f384635i.getBottom()) {
            if (motionEvent.getAction() == 0) {
                this.K = c0(this.f384635i, i3, i16);
                this.L = true;
            } else if (motionEvent.getAction() == 1) {
                View c06 = c0(this.f384635i, i3, i16);
                View view2 = this.K;
                if (c06 == view2 && view2.isClickable()) {
                    this.K.performClick();
                    invalidate(new Rect(0, 0, this.f384631d, this.f384632e));
                } else if (this.M) {
                    ExpandableListView.getPackedPositionGroup(getExpandableListPosition(pointToPosition));
                }
                this.L = false;
            }
            return true;
        }
        this.K = null;
        if (this.C) {
            View view3 = this.f384636m;
            if (view3 != null && view3.dispatchTouchEvent(motionEvent)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.C = false;
            }
            return z16;
        }
        if (this.f384636m != null && x16 >= 0.0f && x16 <= r2.getMeasuredWidth() && y16 >= 0.0f && y16 <= this.f384636m.getMeasuredHeight() - this.E && motionEvent.getAction() == 0 && this.f384636m.getVisibility() == 0 && this.f384636m.dispatchTouchEvent(motionEvent)) {
            this.C = true;
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
        View view = this.f384636m;
        if (view != null) {
            refreshAllChild(view);
        }
        View view2 = this.f384635i;
        if (view2 != null) {
            refreshAllChild(view2);
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
        if (this.f384636m != null) {
            configHeaderView(getFirstVisiblePosition(), true);
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
        View view = this.f384636m;
        if (view != null) {
            measureChild(view, i3, i16);
        }
        View view2 = this.f384635i;
        if (view2 != null) {
            measureChild(view2, i3, i16);
            this.f384631d = this.f384635i.getMeasuredWidth();
            this.f384632e = this.f384635i.getMeasuredHeight();
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.f384636m != null) {
            configHeaderView(i3, false);
        }
        if (this.f384635i != null) {
            refreshHeader();
        }
        AbsListView.OnScrollListener onScrollListener = this.G;
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
        AbsListView.OnScrollListener onScrollListener = this.G;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
    }

    protected void refreshHeader() {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (this.f384635i == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PinnedHeadAndFootExpandableListView", 2, "mHeaderView null");
                return;
            }
            return;
        }
        ExpandableListAdapter expandableListAdapter = super.getExpandableListAdapter();
        if (!(expandableListAdapter instanceof c)) {
            if (QLog.isColorLevel()) {
                QLog.d("PinnedHeadAndFootExpandableListView", 2, "object null");
                return;
            }
            return;
        }
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(lastVisiblePosition));
        int measuredHeight = this.f384635i.getMeasuredHeight();
        int height = getHeight();
        int i16 = height - measuredHeight;
        int i17 = lastVisiblePosition - 2;
        int i18 = lastVisiblePosition - 1;
        int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(i17));
        if (packedPositionGroup == ((c) expandableListAdapter).getGroupCount() - 1) {
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
            if (height - childAt.getTop() >= measuredHeight) {
                e0(packedPositionGroup + 1);
                int top = childAt.getTop() + measuredHeight;
                if (top >= i16) {
                    i16 = top;
                }
                if (z16) {
                    this.I = -1;
                    int i19 = -measuredHeight;
                    this.f384635i.layout(0, i19, this.f384631d, i19);
                    return;
                }
                this.f384635i.layout(0, i16, this.f384631d, measuredHeight + i16);
                return;
            }
            e0(packedPositionGroup);
            if (z16 && i3 != lastVisiblePosition) {
                this.I = -1;
                this.f384635i.layout(0, -measuredHeight, this.f384631d, -this.f384632e);
                return;
            } else {
                if (ExpandableListView.getPackedPositionType(getExpandableListPosition(i18)) == 0) {
                    b0();
                    this.I = -1;
                    this.f384635i.layout(0, -measuredHeight, this.f384631d, -this.f384632e);
                    return;
                }
                this.f384635i.layout(0, i16, this.f384631d, this.f384632e + i16);
                return;
            }
        }
        if (z16) {
            this.I = -1;
            View view = this.f384635i;
            int i26 = this.f384632e;
            view.layout(0, -i26, this.f384631d, -i26);
        } else {
            this.f384635i.layout(0, i16, this.f384631d, this.f384632e + i16);
        }
        e0(packedPositionGroup + 1);
    }

    @Override // com.tencent.widget.ListView
    public boolean removeHeaderView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) view)).booleanValue();
        }
        this.P = 0;
        return super.removeHeaderView(view);
    }

    @Override // com.tencent.widget.ExpandableListView
    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) expandableListAdapter);
            return;
        }
        super.setAdapter(expandableListAdapter);
        if (expandableListAdapter instanceof c) {
            c cVar = (c) expandableListAdapter;
            this.f384634h = cVar;
            int headerViewLayoutResourceId = cVar.getHeaderViewLayoutResourceId();
            if (headerViewLayoutResourceId != 0) {
                View inflate = LayoutInflater.from(this.f384633f).inflate(headerViewLayoutResourceId, (ViewGroup) this, false);
                this.f384636m = inflate;
                if (inflate != null) {
                    inflate.setTag("headerView");
                    this.f384636m.setOnTouchListener(new a());
                }
                if (this.J && this.f384635i == null) {
                    View inflate2 = LayoutInflater.from(this.f384633f).inflate(headerViewLayoutResourceId, (ViewGroup) this, false);
                    this.f384635i = inflate2;
                    if (inflate2 != null) {
                        inflate2.setTag("footerView");
                        this.f384635i.setOnClickListener(new b(this));
                    }
                }
                requestLayout();
            }
        }
    }

    public void setFooterEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        this.J = z16;
        View view = this.f384635i;
        if (view != null) {
            if (z16) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void setFooterListener(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
        }
    }

    @Override // com.tencent.widget.ExpandableListView
    public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener onGroupClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onGroupClickListener);
        } else {
            this.H = onGroupClickListener;
            super.setOnGroupClickListener(onGroupClickListener);
        }
    }

    public void setOnLayoutListener(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) eVar);
        }
    }

    @Override // com.tencent.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onScrollListener);
        } else {
            this.G = onScrollListener;
        }
    }

    public PinnedHeadAndFootExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f384633f = null;
        this.f384634h = null;
        this.f384635i = null;
        this.f384636m = null;
        this.C = false;
        this.D = 0;
        this.E = 0;
        this.F = -1;
        this.G = null;
        this.H = null;
        this.I = -1;
        this.N = false;
        init(context);
    }

    public PinnedHeadAndFootExpandableListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f384633f = null;
        this.f384634h = null;
        this.f384635i = null;
        this.f384636m = null;
        this.C = false;
        this.D = 0;
        this.E = 0;
        this.F = -1;
        this.G = null;
        this.H = null;
        this.I = -1;
        this.N = false;
        init(context);
    }
}
