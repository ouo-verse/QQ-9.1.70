package nf0;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends RecyclerView.LayoutManager {

    /* renamed from: p, reason: collision with root package name */
    private static float f420073p = 45.0f;

    /* renamed from: q, reason: collision with root package name */
    private static float f420074q = 20.0f;

    /* renamed from: r, reason: collision with root package name */
    private static int f420075r = 1;

    /* renamed from: s, reason: collision with root package name */
    private static int f420076s = 2;

    /* renamed from: c, reason: collision with root package name */
    private int f420079c;

    /* renamed from: e, reason: collision with root package name */
    private int f420081e;

    /* renamed from: f, reason: collision with root package name */
    private int f420082f;

    /* renamed from: g, reason: collision with root package name */
    private int f420083g;

    /* renamed from: m, reason: collision with root package name */
    private int f420089m;

    /* renamed from: n, reason: collision with root package name */
    private int f420090n;

    /* renamed from: a, reason: collision with root package name */
    private float f420077a = 1.4f;

    /* renamed from: b, reason: collision with root package name */
    private float f420078b = 225.0f;

    /* renamed from: k, reason: collision with root package name */
    private SparseBooleanArray f420087k = new SparseBooleanArray();

    /* renamed from: l, reason: collision with root package name */
    private SparseArray<Float> f420088l = new SparseArray<>();

    /* renamed from: o, reason: collision with root package name */
    private boolean f420091o = true;

    /* renamed from: d, reason: collision with root package name */
    private float f420080d = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f420084h = f420073p;

    /* renamed from: i, reason: collision with root package name */
    private int f420085i = 180;

    /* renamed from: j, reason: collision with root package name */
    private int f420086j = 270;

    /* compiled from: P */
    /* renamed from: nf0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C10843a extends LinearSmoothScroller {
        C10843a(Context context) {
            super(context);
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public PointF computeScrollVectorForPosition(int i3) {
            return a.this.computeScrollVectorForPosition(i3);
        }
    }

    public a(Context context, int i3) {
        this.f420083g = 0;
        this.f420079c = i3;
        this.f420083g = 180;
    }

    private int a(float f16) {
        return (int) (this.f420079c * Math.cos(Math.toRadians(90.0f - f16)));
    }

    private int b(float f16) {
        return (int) (this.f420079c * Math.sin(Math.toRadians(90.0f - f16)));
    }

    private float c(float f16) {
        if (Math.abs(f16) < this.f420085i || Math.abs(f16) > this.f420086j) {
            return 1.0f;
        }
        return ((1.0f - (Math.abs(f16 - this.f420078b) / 45.0f)) * (this.f420077a - 1.0f)) + 1.0f;
    }

    private void d() {
        if (this.f420080d < 0.0f) {
            this.f420080d = 0.0f;
        }
        if (this.f420080d > g()) {
            this.f420080d = g();
        }
    }

    private int f() {
        return (getWidth() - getPaddingRight()) - getPaddingLeft();
    }

    private float g() {
        return ((getItemCount() - 1) * this.f420084h) - 90.0f;
    }

    private int j() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    private void k(RecyclerView.Recycler recycler, RecyclerView.State state) {
        l(recycler, state, f420076s);
    }

    private void l(RecyclerView.Recycler recycler, RecyclerView.State state, int i3) {
        if (state.isPreLayout()) {
            return;
        }
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            int position = getPosition(childAt);
            if (this.f420088l.get(position).floatValue() - this.f420080d > this.f420086j || this.f420088l.get(position).floatValue() - this.f420080d < this.f420085i) {
                this.f420087k.put(position, false);
                removeAndRecycleView(childAt, recycler);
            }
        }
        int itemCount = getItemCount();
        for (int i17 = 0; i17 < itemCount; i17++) {
            if (this.f420088l.get(i17) != null && this.f420088l.get(i17).floatValue() - this.f420080d <= this.f420086j + f420073p && this.f420088l.get(i17).floatValue() - this.f420080d >= this.f420085i - f420073p && !this.f420087k.get(i17)) {
                ViewGroup viewGroup = (ViewGroup) recycler.getViewForPosition(i17);
                View childAt2 = viewGroup.getChildAt(0);
                measureChildWithMargins(viewGroup, 0, 0);
                if (i3 == f420075r) {
                    addView(viewGroup, 0);
                } else {
                    addView(viewGroup);
                }
                float floatValue = this.f420088l.get(i17).floatValue();
                if (itemCount > (90.0f / f420073p) + 1.0f) {
                    floatValue -= this.f420080d;
                }
                float f16 = floatValue;
                int a16 = a(f16);
                int b16 = b(f16);
                viewGroup.setRotation(f16);
                int i18 = this.f420081e;
                int i19 = this.f420082f;
                layoutDecorated(viewGroup, i18 + a16, i19 + b16, i18 + a16 + this.f420089m, i19 + b16 + this.f420090n);
                childAt2.setRotation(-f16);
                this.f420087k.put(i17, true);
                m(viewGroup, f16);
            }
        }
    }

    private void m(ViewGroup viewGroup, float f16) {
        if (this.f420091o) {
            float c16 = c(f16);
            viewGroup.setScaleX(c16);
            viewGroup.setScaleY(c16);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return true;
    }

    public PointF computeScrollVectorForPosition(int i3) {
        int i16;
        if (getChildCount() == 0) {
            return null;
        }
        if (i3 < getPosition(getChildAt(0))) {
            i16 = -1;
        } else {
            i16 = 1;
        }
        return new PointF(i16, 0.0f);
    }

    public int e() {
        return Math.round(this.f420080d / this.f420084h);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public float h() {
        return this.f420077a;
    }

    public int i(int i3) {
        return (int) (((i3 * this.f420084h) - this.f420080d) * f420074q);
    }

    public void n(boolean z16) {
        this.f420091o = z16;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
        this.f420080d = 0.0f;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            if (state.getItemCount() > 0 && !state.isPreLayout()) {
                View viewForPosition = recycler.getViewForPosition(0);
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, 0, 0);
                this.f420089m = getDecoratedMeasuredWidth(viewForPosition);
                this.f420090n = getDecoratedMeasuredHeight(viewForPosition);
                this.f420081e = f() - this.f420089m;
                this.f420082f = j() - this.f420090n;
                float f16 = this.f420083g;
                for (int i3 = 0; i3 < getItemCount(); i3++) {
                    this.f420088l.put(i3, Float.valueOf(f16));
                    this.f420087k.put(i3, false);
                    f16 += this.f420084h;
                }
                detachAndScrapAttachedViews(recycler);
                d();
                k(recycler, state);
                return;
            }
            this.f420080d = 0.0f;
            if (state.getItemCount() == 0) {
                removeAndRecycleAllViews(recycler);
            }
        } catch (IndexOutOfBoundsException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051 A[LOOP:0: B:10:0x004b->B:12:0x0051, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a0  */
    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        float g16;
        int i16;
        int i17 = 0;
        if ((90.0f / f420073p) + 1.0f >= getItemCount()) {
            return 0;
        }
        int i18 = -i3;
        float f16 = f420074q;
        float f17 = this.f420080d;
        float f18 = (i18 / f16) + f17;
        if (f18 < 0.0f) {
            g16 = (-f17) * f16;
        } else {
            if (f18 > g()) {
                g16 = (g() - this.f420080d) * f420074q;
            }
            int i19 = i18;
            float f19 = i19 / f420074q;
            this.f420080d += f19;
            i16 = 0;
            while (i16 < getChildCount()) {
                ViewGroup viewGroup = (ViewGroup) getChildAt(i16);
                View childAt = viewGroup.getChildAt(i17);
                float rotation = viewGroup.getRotation() - f19;
                int a16 = a(rotation);
                int b16 = b(rotation);
                viewGroup.setRotation(rotation);
                int i26 = this.f420081e;
                int i27 = this.f420082f;
                layoutDecorated(viewGroup, i26 + a16, i27 + b16, i26 + a16 + this.f420089m, i27 + b16 + this.f420090n);
                childAt.setRotation(-rotation);
                m(viewGroup, rotation);
                i16++;
                i17 = 0;
            }
            if (i3 <= 0) {
                l(recycler, state, f420075r);
            } else {
                l(recycler, state, f420076s);
            }
            return i19;
        }
        i18 = (int) g16;
        int i192 = i18;
        float f192 = i192 / f420074q;
        this.f420080d += f192;
        i16 = 0;
        while (i16 < getChildCount()) {
        }
        if (i3 <= 0) {
        }
        return i192;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i3) {
        if (i3 >= 0 && i3 <= getItemCount() - 1) {
            float f16 = i3 * this.f420084h;
            if (f16 != this.f420080d) {
                this.f420080d = f16;
                d();
                requestLayout();
                Log.i("EditVideoSmartMusicPart", "scrollToPosition pos:" + i3);
            }
        }
        EventCollector.getInstance().onRecyclerViewScrollToPosition(this);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollHorizontallyBy(-i3, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        C10843a c10843a = new C10843a(recyclerView.getContext());
        c10843a.setTargetPosition(i3);
        Log.i("EditVideoSmartMusicPart", "smoothScrollToPosition pos:" + i3);
        startSmoothScroll(c10843a);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void startSmoothScroll(RecyclerView.SmoothScroller smoothScroller) {
        super.startSmoothScroll(smoothScroller);
    }
}
