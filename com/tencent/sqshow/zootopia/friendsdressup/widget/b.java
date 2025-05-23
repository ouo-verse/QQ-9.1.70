package com.tencent.sqshow.zootopia.friendsdressup.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.core.text.TextUtilsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes34.dex */
public class b extends LinearSnapHelper {

    /* renamed from: a, reason: collision with root package name */
    private int f370647a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f370648b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f370649c;

    /* renamed from: d, reason: collision with root package name */
    private int f370650d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f370651e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f370652f;

    /* renamed from: g, reason: collision with root package name */
    private float f370653g;

    /* renamed from: h, reason: collision with root package name */
    private int f370654h;

    /* renamed from: i, reason: collision with root package name */
    private float f370655i;

    /* renamed from: j, reason: collision with root package name */
    private OrientationHelper f370656j;

    /* renamed from: k, reason: collision with root package name */
    private OrientationHelper f370657k;

    /* renamed from: l, reason: collision with root package name */
    private g f370658l;

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView f370659m;

    /* renamed from: n, reason: collision with root package name */
    private RecyclerView.OnScrollListener f370660n;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            b.this.k(i3);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.sqshow.zootopia.friendsdressup.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    class C9810b extends LinearSmoothScroller {
        C9810b(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return b.this.f370653g / displayMetrics.densityDpi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            if (b.this.f370659m == null || b.this.f370659m.getLayoutManager() == null) {
                return;
            }
            b bVar = b.this;
            int[] calculateDistanceToFinalSnap = bVar.calculateDistanceToFinalSnap(bVar.f370659m.getLayoutManager(), view);
            int i3 = calculateDistanceToFinalSnap[0];
            int i16 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i3), Math.abs(i16)));
            if (calculateTimeForDeceleration > 0) {
                action.update(i3, i16, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    public b(int i3) {
        this(i3, false, null);
    }

    private void d() {
        View e16;
        int childAdapterPosition;
        RecyclerView.LayoutManager layoutManager = this.f370659m.getLayoutManager();
        if (layoutManager == null || (e16 = e(layoutManager, false)) == null || (childAdapterPosition = this.f370659m.getChildAdapterPosition(e16)) == -1) {
            return;
        }
        this.f370658l.b(childAdapterPosition);
    }

    private View f(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i3, boolean z16) {
        int end;
        int abs;
        View view = null;
        if (layoutManager.getChildCount() != 0 && (layoutManager instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (z16 && j(linearLayoutManager) && !this.f370649c) {
                return null;
            }
            if (layoutManager.getClipToPadding()) {
                end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
            } else {
                end = orientationHelper.getEnd() / 2;
            }
            boolean z17 = true;
            boolean z18 = (i3 == 8388611 && !this.f370648b) || (i3 == 8388613 && this.f370648b);
            if ((i3 != 8388611 || !this.f370648b) && (i3 != 8388613 || this.f370648b)) {
                z17 = false;
            }
            int i16 = Integer.MAX_VALUE;
            for (int i17 = 0; i17 < linearLayoutManager.getChildCount(); i17++) {
                View childAt = linearLayoutManager.getChildAt(i17);
                if (z18) {
                    if (!this.f370652f) {
                        abs = Math.abs(orientationHelper.getDecoratedStart(childAt));
                    } else {
                        abs = Math.abs(orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(childAt));
                    }
                } else if (z17) {
                    if (!this.f370652f) {
                        abs = Math.abs(orientationHelper.getDecoratedEnd(childAt) - orientationHelper.getEnd());
                    } else {
                        abs = Math.abs(orientationHelper.getEndAfterPadding() - orientationHelper.getDecoratedEnd(childAt));
                    }
                } else {
                    abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - end);
                }
                if (abs < i16) {
                    view = childAt;
                    i16 = abs;
                }
            }
        }
        return view;
    }

    private int g(View view, OrientationHelper orientationHelper) {
        int decoratedEnd;
        int endAfterPadding;
        if (!this.f370652f) {
            int decoratedEnd2 = orientationHelper.getDecoratedEnd(view);
            if (decoratedEnd2 >= orientationHelper.getEnd() - ((orientationHelper.getEnd() - orientationHelper.getEndAfterPadding()) / 2)) {
                decoratedEnd = orientationHelper.getDecoratedEnd(view);
                endAfterPadding = orientationHelper.getEnd();
            } else {
                return decoratedEnd2 - orientationHelper.getEndAfterPadding();
            }
        } else {
            decoratedEnd = orientationHelper.getDecoratedEnd(view);
            endAfterPadding = orientationHelper.getEndAfterPadding();
        }
        return decoratedEnd - endAfterPadding;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f370657k;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f370657k = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f370657k;
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f370656j;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f370656j = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f370656j;
    }

    private int h(View view, OrientationHelper orientationHelper) {
        int decoratedStart;
        int startAfterPadding;
        if (!this.f370652f) {
            decoratedStart = orientationHelper.getDecoratedStart(view);
            if (decoratedStart < orientationHelper.getStartAfterPadding() / 2) {
                return decoratedStart;
            }
            startAfterPadding = orientationHelper.getStartAfterPadding();
        } else {
            decoratedStart = orientationHelper.getDecoratedStart(view);
            startAfterPadding = orientationHelper.getStartAfterPadding();
        }
        return decoratedStart - startAfterPadding;
    }

    private int i() {
        float width;
        float f16;
        if (this.f370655i != -1.0f) {
            if (this.f370656j != null) {
                width = this.f370659m.getHeight();
                f16 = this.f370655i;
            } else {
                if (this.f370657k == null) {
                    return Integer.MAX_VALUE;
                }
                width = this.f370659m.getWidth();
                f16 = this.f370655i;
            }
            return (int) (width * f16);
        }
        int i3 = this.f370654h;
        if (i3 != -1) {
            return i3;
        }
        return Integer.MAX_VALUE;
    }

    private boolean j(LinearLayoutManager linearLayoutManager) {
        return ((linearLayoutManager.getReverseLayout() || this.f370647a != 8388611) && !(linearLayoutManager.getReverseLayout() && this.f370647a == 8388613) && ((linearLayoutManager.getReverseLayout() || this.f370647a != 48) && !(linearLayoutManager.getReverseLayout() && this.f370647a == 80))) ? this.f370647a == 17 ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 || linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1 : linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 : linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f370659m;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.f370660n);
        }
        if (recyclerView != null) {
            recyclerView.setOnFlingListener(null);
            int i3 = this.f370647a;
            if (i3 == 8388611 || i3 == 8388613) {
                this.f370648b = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
            }
            recyclerView.addOnScrollListener(this.f370660n);
            this.f370659m = recyclerView;
        } else {
            this.f370659m = null;
        }
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        if (this.f370647a == 17) {
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
        int[] iArr = new int[2];
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return iArr;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager.canScrollHorizontally()) {
            boolean z16 = this.f370648b;
            if ((z16 && this.f370647a == 8388613) || (!z16 && this.f370647a == 8388611)) {
                iArr[0] = h(view, getHorizontalHelper(linearLayoutManager));
            } else {
                iArr[0] = g(view, getHorizontalHelper(linearLayoutManager));
            }
        } else if (linearLayoutManager.canScrollVertically()) {
            if (this.f370647a == 48) {
                iArr[1] = h(view, getVerticalHelper(linearLayoutManager));
            } else {
                iArr[1] = g(view, getVerticalHelper(linearLayoutManager));
            }
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateScrollDistance(int i3, int i16) {
        if (this.f370659m != null && ((this.f370656j != null || this.f370657k != null) && (this.f370654h != -1 || this.f370655i != -1.0f))) {
            Scroller scroller = new Scroller(this.f370659m.getContext(), new DecelerateInterpolator());
            int i17 = i();
            int i18 = -i17;
            scroller.fling(0, 0, i3, i16, i18, i17, i18, i17);
            return new int[]{scroller.getFinalX(), scroller.getFinalY()};
        }
        return super.calculateScrollDistance(i3, i16);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.f370659m) == null) {
            return null;
        }
        return new C9810b(recyclerView.getContext());
    }

    public View e(RecyclerView.LayoutManager layoutManager, boolean z16) {
        View f16;
        int i3 = this.f370647a;
        if (i3 != 17) {
            if (i3 == 48) {
                f16 = f(layoutManager, getVerticalHelper(layoutManager), 8388611, z16);
            } else if (i3 == 80) {
                f16 = f(layoutManager, getVerticalHelper(layoutManager), 8388613, z16);
            } else if (i3 != 8388611) {
                f16 = i3 != 8388613 ? null : f(layoutManager, getHorizontalHelper(layoutManager), 8388613, z16);
            } else {
                f16 = f(layoutManager, getHorizontalHelper(layoutManager), 8388611, z16);
            }
        } else if (layoutManager.canScrollHorizontally()) {
            f16 = f(layoutManager, getHorizontalHelper(layoutManager), 17, z16);
        } else {
            f16 = f(layoutManager, getVerticalHelper(layoutManager), 17, z16);
        }
        if (f16 != null) {
            this.f370650d = this.f370659m.getChildAdapterPosition(f16);
        } else {
            this.f370650d = -1;
        }
        return f16;
    }

    public void m(g gVar) {
        this.f370658l = gVar;
    }

    public b(int i3, boolean z16, g gVar) {
        this.f370651e = false;
        this.f370652f = false;
        this.f370653g = 100.0f;
        this.f370654h = -1;
        this.f370655i = -1.0f;
        this.f370660n = new a();
        if (i3 != 8388611 && i3 != 8388613 && i3 != 80 && i3 != 48 && i3 != 17) {
            throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP | CENTER constants");
        }
        this.f370649c = z16;
        this.f370647a = i3;
        this.f370658l = gVar;
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return e(layoutManager, true);
    }

    public void l(float f16) {
        this.f370654h = -1;
        this.f370655i = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i3) {
        g gVar;
        if (i3 == 0 && (gVar = this.f370658l) != null && this.f370651e) {
            int i16 = this.f370650d;
            if (i16 != -1) {
                gVar.b(i16);
            } else {
                d();
            }
        }
        this.f370651e = i3 != 0;
    }
}
