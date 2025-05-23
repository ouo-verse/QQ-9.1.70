package com.qzone.reborn.qzmoment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.detail.ui.component.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class DragViewLayout extends FrameLayout {
    private float C;
    private boolean D;
    private b E;
    private View F;
    private m G;

    /* renamed from: d, reason: collision with root package name */
    private List<Integer> f59042d;

    /* renamed from: e, reason: collision with root package name */
    private bn.b f59043e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f59044f;

    /* renamed from: h, reason: collision with root package name */
    private int f59045h;

    /* renamed from: i, reason: collision with root package name */
    private int f59046i;

    /* renamed from: m, reason: collision with root package name */
    private float f59047m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
        void onClick();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private class c extends m.b {
        c() {
        }

        @Override // com.qzone.detail.ui.component.m.b
        public int a(View view, int i3, int i16) {
            if (DragViewLayout.this.getPaddingLeft() > i3) {
                return DragViewLayout.this.getPaddingLeft();
            }
            int width = view.getWidth() + i3;
            int width2 = DragViewLayout.this.getWidth() - DragViewLayout.this.getPaddingRight();
            return width > width2 ? width2 - view.getWidth() : i3;
        }

        @Override // com.qzone.detail.ui.component.m.b
        public int b(View view, int i3, int i16) {
            if (DragViewLayout.this.getPaddingTop() > i3) {
                return DragViewLayout.this.getPaddingTop();
            }
            int height = view.getHeight() + i3;
            int height2 = DragViewLayout.this.getHeight() - DragViewLayout.this.getPaddingBottom();
            return height > height2 ? height2 - view.getHeight() : i3;
        }

        @Override // com.qzone.detail.ui.component.m.b
        public int d(View view) {
            return view.getMeasuredWidth();
        }

        @Override // com.qzone.detail.ui.component.m.b
        public int e(View view) {
            return view.getMeasuredHeight();
        }

        @Override // com.qzone.detail.ui.component.m.b
        public void j(int i3) {
            super.j(i3);
            DragViewLayout.c(DragViewLayout.this);
        }

        @Override // com.qzone.detail.ui.component.m.b
        public void l(View view, float f16, float f17) {
            super.l(view, f16, f17);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean z16 = ((float) view.getLeft()) > (((float) DragViewLayout.this.getWidth()) / 2.0f) - (((float) marginLayoutParams.width) / 2.0f);
            if (z16) {
                DragViewLayout.this.G.G((DragViewLayout.this.getWidth() - marginLayoutParams.width) - marginLayoutParams.leftMargin, marginLayoutParams.topMargin);
            } else {
                DragViewLayout.this.G.G(marginLayoutParams.leftMargin, marginLayoutParams.topMargin);
            }
            if (DragViewLayout.this.f59043e != null) {
                DragViewLayout.this.f59043e.d(z16);
            }
            DragViewLayout.this.invalidate();
        }

        @Override // com.qzone.detail.ui.component.m.b
        public boolean m(View view, int i3) {
            return DragViewLayout.this.f59042d.contains(Integer.valueOf(view.getId()));
        }
    }

    public DragViewLayout(Context context) {
        super(context);
        this.f59042d = new ArrayList();
        this.f59044f = false;
        this.D = false;
        this.G = m.m(this, 20.0f, new c());
    }

    static /* bridge */ /* synthetic */ a c(DragViewLayout dragViewLayout) {
        dragViewLayout.getClass();
        return null;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.G.l(true)) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16 = false;
        if (motionEvent.getAction() == 0) {
            this.f59047m = motionEvent.getX();
            this.C = motionEvent.getY();
            View s16 = this.G.s((int) motionEvent.getX(), (int) motionEvent.getY());
            if (s16 != null && s16 == this.F) {
                z16 = true;
            }
        }
        if (z16) {
            return true;
        }
        return this.G.H(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int i26 = 0;
        if (this.f59044f) {
            while (i26 < getChildCount()) {
                View childAt = getChildAt(i26);
                if (childAt.getVisibility() == 8) {
                    return;
                }
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (this.f59042d.contains(Integer.valueOf(childAt.getId())) && (measuredWidth != (i19 = this.f59045h) || measuredHeight != this.f59046i)) {
                    left -= measuredWidth - i19;
                    this.f59045h = measuredWidth;
                    top -= measuredHeight - this.f59046i;
                    this.f59046i = measuredHeight;
                }
                childAt.layout(left, top, measuredWidth + left, measuredHeight + top);
                i26++;
            }
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        this.f59044f = true;
        while (i26 < getChildCount()) {
            View childAt2 = getChildAt(i26);
            if (this.f59042d.contains(Integer.valueOf(childAt2.getId()))) {
                this.F = childAt2;
                this.f59045h = childAt2.getMeasuredWidth();
                this.f59046i = childAt2.getMeasuredHeight();
                return;
            }
            i26++;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        this.G.A(motionEvent);
        if (this.F == null) {
            return false;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        boolean z16 = ((float) this.F.getTop()) <= y16 && ((float) this.F.getBottom()) >= y16 && ((float) this.F.getLeft()) <= x16 && ((float) this.F.getRight()) >= x16;
        int action = motionEvent.getAction();
        if (action == 1) {
            requestDisallowInterceptTouchEvent(false);
            if (z16 && this.f59047m == x16 && this.C == y16 && (bVar = this.E) != null) {
                bVar.onClick();
            }
        } else if (action == 2) {
            requestDisallowInterceptTouchEvent(true);
        }
        return z16;
    }

    public void setDragViewClickListener(b bVar) {
        this.E = bVar;
    }

    public void setFeedData(bn.b bVar) {
        this.f59043e = bVar;
        this.f59044f = bVar.b();
    }

    public void e(int i3) {
        if (i3 == -1) {
            return;
        }
        this.f59042d.add(Integer.valueOf(i3));
    }

    public DragViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f59042d = new ArrayList();
        this.f59044f = false;
        this.D = false;
        this.G = m.m(this, 20.0f, new c());
        setClickable(true);
    }

    public DragViewLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f59042d = new ArrayList();
        this.f59044f = false;
        this.D = false;
        this.G = m.m(this, 20.0f, new c());
        setClickable(true);
    }

    public void setDragListener(a aVar) {
    }
}
