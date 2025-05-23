package com.qzone.album.ui.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes39.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    private int C;
    private int D;
    private int E;
    private GestureDetector F;
    private Queue<View> G;
    private AdapterView.OnItemSelectedListener H;
    private AdapterView.OnItemClickListener I;
    private AdapterView.OnItemLongClickListener J;
    private GestureDetector.OnGestureListener K;
    private boolean L;
    private DataSetObserver M;

    /* renamed from: d, reason: collision with root package name */
    public boolean f44182d;

    /* renamed from: e, reason: collision with root package name */
    protected ListAdapter f44183e;

    /* renamed from: f, reason: collision with root package name */
    protected int f44184f;

    /* renamed from: h, reason: collision with root package name */
    protected int f44185h;

    /* renamed from: i, reason: collision with root package name */
    protected Scroller f44186i;

    /* renamed from: m, reason: collision with root package name */
    private int f44187m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        private boolean a(MotionEvent motionEvent, View view) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int width = view.getWidth() + i3;
            int i16 = iArr[1];
            rect.set(i3, i16, width, view.getHeight() + i16);
            return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.m(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return HorizontalListView.this.n(motionEvent, motionEvent2, f16, f17);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            int childCount = HorizontalListView.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = HorizontalListView.this.getChildAt(i3);
                if (a(motionEvent, childAt)) {
                    if (HorizontalListView.this.J != null) {
                        AdapterView.OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.J;
                        HorizontalListView horizontalListView = HorizontalListView.this;
                        int i16 = horizontalListView.f44187m + 1 + i3;
                        HorizontalListView horizontalListView2 = HorizontalListView.this;
                        onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i16, horizontalListView2.f44183e.getItemId(horizontalListView2.f44187m + 1 + i3));
                        return;
                    }
                    return;
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            HorizontalListView horizontalListView;
            synchronized (HorizontalListView.this) {
                horizontalListView = HorizontalListView.this;
                horizontalListView.f44185h += (int) f16;
            }
            horizontalListView.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            int i3 = 0;
            while (true) {
                if (i3 >= HorizontalListView.this.getChildCount()) {
                    break;
                }
                View childAt = HorizontalListView.this.getChildAt(i3);
                if (a(motionEvent, childAt)) {
                    if (HorizontalListView.this.I != null) {
                        AdapterView.OnItemClickListener onItemClickListener = HorizontalListView.this.I;
                        HorizontalListView horizontalListView = HorizontalListView.this;
                        int i16 = horizontalListView.f44187m + 1 + i3;
                        HorizontalListView horizontalListView2 = HorizontalListView.this;
                        onItemClickListener.onItemClick(horizontalListView, childAt, i16, horizontalListView2.f44183e.getItemId(horizontalListView2.f44187m + 1 + i3));
                    }
                    if (HorizontalListView.this.H != null) {
                        AdapterView.OnItemSelectedListener onItemSelectedListener = HorizontalListView.this.H;
                        HorizontalListView horizontalListView3 = HorizontalListView.this;
                        int i17 = horizontalListView3.f44187m + 1 + i3;
                        HorizontalListView horizontalListView4 = HorizontalListView.this;
                        onItemSelectedListener.onItemSelected(horizontalListView3, childAt, i17, horizontalListView4.f44183e.getItemId(horizontalListView4.f44187m + 1 + i3));
                    }
                } else {
                    i3++;
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            synchronized (HorizontalListView.this) {
                HorizontalListView.this.L = true;
            }
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            HorizontalListView.this.q();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44182d = true;
        this.f44187m = -1;
        this.C = 0;
        this.D = Integer.MAX_VALUE;
        this.E = 0;
        this.G = new LinkedList();
        this.K = new a();
        this.L = false;
        this.M = new b();
        l();
    }

    private void g(View view, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i3, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    private void h(int i3) {
        View childAt = getChildAt(getChildCount() - 1);
        j(childAt != null ? childAt.getRight() : 0, i3);
        View childAt2 = getChildAt(0);
        i(childAt2 != null ? childAt2.getLeft() : 0, i3);
    }

    private synchronized void l() {
        this.f44187m = -1;
        this.C = 0;
        this.E = 0;
        this.f44184f = 0;
        this.f44185h = 0;
        this.D = Integer.MAX_VALUE;
        this.f44186i = new Scroller(getContext());
        this.F = new GestureDetector(getContext(), this.K);
    }

    private void o(int i3) {
        if (getChildCount() > 0) {
            int i16 = this.E + i3;
            this.E = i16;
            for (int i17 = 0; i17 < getChildCount(); i17++) {
                View childAt = getChildAt(i17);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i16, 0, i16 + measuredWidth, childAt.getMeasuredHeight());
                i16 += measuredWidth + childAt.getPaddingRight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q() {
        l();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.F.onTouchEvent(motionEvent) | super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    @Override // android.widget.AdapterView
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public ListAdapter getAdapter() {
        return this.f44183e;
    }

    protected boolean m(MotionEvent motionEvent) {
        this.f44186i.forceFinished(true);
        return true;
    }

    protected boolean n(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        synchronized (this) {
            this.f44186i.fling(this.f44185h, 0, (int) (-f16), 0, 0, this.D, 0, 0);
        }
        requestLayout();
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected synchronized void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f44183e == null) {
            return;
        }
        if (this.L) {
            int i19 = this.f44184f;
            l();
            removeAllViewsInLayout();
            this.f44185h = i19;
            this.L = false;
        }
        if (this.f44186i.computeScrollOffset()) {
            this.f44185h = this.f44186i.getCurrX();
        }
        if (this.f44185h <= 0) {
            this.f44185h = 0;
            this.f44186i.forceFinished(true);
        }
        int i26 = this.f44185h;
        int i27 = this.D;
        if (i26 >= i27) {
            this.f44185h = i27;
            this.f44186i.forceFinished(true);
        }
        int i28 = this.f44184f - this.f44185h;
        p(i28);
        h(i28);
        o(i28);
        this.f44184f = this.f44185h;
        if (!this.f44186i.isFinished()) {
            post(new Runnable() { // from class: com.qzone.album.ui.widget.HorizontalListView.3
                @Override // java.lang.Runnable
                public void run() {
                    HorizontalListView.this.requestLayout();
                }
            });
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.I = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.J = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.H = onItemSelectedListener;
    }

    private void p(int i3) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i3 <= 0) {
            this.E += childAt.getMeasuredWidth();
            this.G.offer(childAt);
            removeViewInLayout(childAt);
            this.f44187m++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i3 >= getWidth()) {
            this.G.offer(childAt2);
            removeViewInLayout(childAt2);
            this.C--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.f44183e;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.M);
        }
        this.f44183e = listAdapter;
        listAdapter.registerDataSetObserver(this.M);
        q();
    }

    private void j(int i3, int i16) {
        while (i3 + i16 < getWidth() && this.C < this.f44183e.getCount()) {
            View view = this.f44183e.getView(this.C, this.G.poll(), this);
            g(view, -1);
            i3 += view.getMeasuredWidth();
            if (this.C == this.f44183e.getCount() - 1) {
                this.D = (this.f44184f + i3) - getWidth();
            }
            if (this.D < 0) {
                this.D = 0;
            }
            this.C++;
        }
    }

    private void i(int i3, int i16) {
        int i17;
        while (i3 + i16 > 0 && (i17 = this.f44187m) >= 0) {
            View view = this.f44183e.getView(i17, this.G.poll(), this);
            g(view, 0);
            i3 -= view.getMeasuredWidth();
            this.f44187m--;
            this.E -= view.getMeasuredWidth();
        }
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i3) {
    }
}
