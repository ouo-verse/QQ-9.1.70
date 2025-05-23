package nb0;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.text.TextUtilsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends PagerSnapHelper {

    /* renamed from: a, reason: collision with root package name */
    private int f419592a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f419593b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f419594c;

    /* renamed from: d, reason: collision with root package name */
    protected int f419595d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f419596e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f419597f;

    /* renamed from: g, reason: collision with root package name */
    private float f419598g;

    /* renamed from: h, reason: collision with root package name */
    private int f419599h;

    /* renamed from: i, reason: collision with root package name */
    private float f419600i;

    /* renamed from: j, reason: collision with root package name */
    private OrientationHelper f419601j;

    /* renamed from: k, reason: collision with root package name */
    private OrientationHelper f419602k;

    /* renamed from: l, reason: collision with root package name */
    private c f419603l;

    /* renamed from: m, reason: collision with root package name */
    protected RecyclerView f419604m;

    /* renamed from: n, reason: collision with root package name */
    private RecyclerView.OnScrollListener f419605n;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            b.this.j(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: nb0.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C10837b extends LinearSmoothScroller {
        C10837b(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return b.this.f419598g / displayMetrics.densityDpi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            RecyclerView recyclerView = b.this.f419604m;
            if (recyclerView != null && recyclerView.getLayoutManager() != null) {
                b bVar = b.this;
                int[] calculateDistanceToFinalSnap = bVar.calculateDistanceToFinalSnap(bVar.f419604m.getLayoutManager(), view);
                int i3 = calculateDistanceToFinalSnap[0];
                int i16 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i3), Math.abs(i16)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i3, i16, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void b(int i3);
    }

    public b(int i3) {
        this(i3, false, null);
    }

    private void c() {
        View d16;
        int childAdapterPosition;
        RecyclerView.LayoutManager layoutManager = this.f419604m.getLayoutManager();
        if (layoutManager != null && (d16 = d(layoutManager, false)) != null && (childAdapterPosition = this.f419604m.getChildAdapterPosition(d16)) != -1) {
            this.f419603l.b(childAdapterPosition);
        }
    }

    private int g(View view, @NonNull OrientationHelper orientationHelper) {
        int decoratedEnd;
        int endAfterPadding;
        if (!this.f419597f) {
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

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f419601j;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f419601j = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f419601j;
    }

    private int h(View view, @NonNull OrientationHelper orientationHelper) {
        int decoratedStart;
        int startAfterPadding;
        if (!this.f419597f) {
            decoratedStart = orientationHelper.getDecoratedStart(view);
            if (decoratedStart >= orientationHelper.getStartAfterPadding() / 2) {
                startAfterPadding = orientationHelper.getStartAfterPadding();
            } else {
                return decoratedStart;
            }
        } else {
            decoratedStart = orientationHelper.getDecoratedStart(view);
            startAfterPadding = orientationHelper.getStartAfterPadding();
        }
        return decoratedStart - startAfterPadding;
    }

    private int i() {
        float width;
        float f16;
        if (this.f419600i != -1.0f) {
            if (this.f419601j != null) {
                width = this.f419604m.getHeight();
                f16 = this.f419600i;
            } else {
                if (this.f419602k == null) {
                    return Integer.MAX_VALUE;
                }
                width = this.f419604m.getWidth();
                f16 = this.f419600i;
            }
            return (int) (width * f16);
        }
        int i3 = this.f419599h;
        if (i3 == -1) {
            return Integer.MAX_VALUE;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i3) {
        boolean z16;
        c cVar;
        if (i3 == 0 && (cVar = this.f419603l) != null && this.f419596e) {
            int i16 = this.f419595d;
            if (i16 != -1) {
                cVar.b(i16);
            } else {
                c();
            }
        }
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f419596e = z16;
    }

    private boolean k(int i3, boolean z16) {
        if (this.f419604m.getLayoutManager() != null) {
            if (z16) {
                RecyclerView.SmoothScroller createScroller = createScroller(this.f419604m.getLayoutManager());
                if (createScroller != null) {
                    createScroller.setTargetPosition(i3);
                    this.f419604m.getLayoutManager().startSmoothScroll(createScroller);
                    return true;
                }
                return false;
            }
            this.f419604m.scrollToPosition(i3);
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f419604m;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.f419605n);
        }
        if (recyclerView != null) {
            recyclerView.setOnFlingListener(null);
            int i3 = this.f419592a;
            if (i3 == 8388611 || i3 == 8388613) {
                boolean z16 = true;
                if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
                    z16 = false;
                }
                this.f419593b = z16;
            }
            recyclerView.addOnScrollListener(this.f419605n);
            this.f419604m = recyclerView;
        } else {
            this.f419604m = null;
        }
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    @NonNull
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        if (this.f419592a == 17) {
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
        int[] iArr = new int[2];
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return iArr;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager.canScrollHorizontally()) {
            boolean z16 = this.f419593b;
            if ((z16 && this.f419592a == 8388613) || (!z16 && this.f419592a == 8388611)) {
                iArr[0] = h(view, getHorizontalHelper(linearLayoutManager));
            } else {
                iArr[0] = g(view, getHorizontalHelper(linearLayoutManager));
            }
        } else if (linearLayoutManager.canScrollVertically()) {
            if (this.f419592a == 48) {
                iArr[1] = h(view, getVerticalHelper(linearLayoutManager));
            } else {
                iArr[1] = g(view, getVerticalHelper(linearLayoutManager));
            }
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @NonNull
    public int[] calculateScrollDistance(int i3, int i16) {
        if (this.f419604m != null && ((this.f419601j != null || this.f419602k != null) && (this.f419599h != -1 || this.f419600i != -1.0f))) {
            Scroller scroller = new Scroller(this.f419604m.getContext(), new DecelerateInterpolator());
            int i17 = i();
            int i18 = -i17;
            scroller.fling(0, 0, i3, i16, i18, i17, i18, i17);
            return new int[]{scroller.getFinalX(), scroller.getFinalY()};
        }
        return super.calculateScrollDistance(i3, i16);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if ((layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) && (recyclerView = this.f419604m) != null) {
            return new C10837b(recyclerView.getContext());
        }
        return null;
    }

    @Nullable
    public View d(@NonNull RecyclerView.LayoutManager layoutManager, boolean z16) {
        View e16;
        int i3 = this.f419592a;
        if (i3 != 17) {
            if (i3 != 48) {
                if (i3 != 80) {
                    if (i3 != 8388611) {
                        if (i3 != 8388613) {
                            e16 = null;
                        } else {
                            e16 = e(layoutManager, getHorizontalHelper(layoutManager), 8388613, z16);
                        }
                    } else {
                        e16 = e(layoutManager, getHorizontalHelper(layoutManager), 8388611, z16);
                    }
                } else {
                    e16 = e(layoutManager, getVerticalHelper(layoutManager), 8388613, z16);
                }
            } else {
                e16 = e(layoutManager, getVerticalHelper(layoutManager), 8388611, z16);
            }
        } else if (layoutManager.canScrollHorizontally()) {
            e16 = e(layoutManager, getHorizontalHelper(layoutManager), 17, z16);
        } else {
            e16 = e(layoutManager, getVerticalHelper(layoutManager), 17, z16);
        }
        if (e16 != null) {
            this.f419595d = this.f419604m.getChildAdapterPosition(e16);
        } else {
            this.f419595d = -1;
        }
        return e16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public View e(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull OrientationHelper orientationHelper, int i3, boolean z16) {
        int end;
        boolean z17;
        int abs;
        View view = null;
        if (layoutManager.getChildCount() != 0 && (layoutManager instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (layoutManager.getClipToPadding()) {
                end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
            } else {
                end = orientationHelper.getEnd() / 2;
            }
            boolean z18 = true;
            if ((i3 == 8388611 && !this.f419593b) || (i3 == 8388613 && this.f419593b)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if ((i3 != 8388611 || !this.f419593b) && (i3 != 8388613 || this.f419593b)) {
                z18 = false;
            }
            int i16 = Integer.MAX_VALUE;
            for (int i17 = 0; i17 < linearLayoutManager.getChildCount(); i17++) {
                View childAt = linearLayoutManager.getChildAt(i17);
                if (z17) {
                    if (!this.f419597f) {
                        abs = Math.abs(orientationHelper.getDecoratedStart(childAt));
                    } else {
                        abs = Math.abs(orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(childAt));
                    }
                } else if (z18) {
                    if (!this.f419597f) {
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

    public int f() {
        View findSnapView;
        RecyclerView recyclerView = this.f419604m;
        if (recyclerView != null && recyclerView.getLayoutManager() != null && (findSnapView = findSnapView(this.f419604m.getLayoutManager())) != null) {
            return this.f419604m.getChildAdapterPosition(findSnapView);
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(@NonNull RecyclerView.LayoutManager layoutManager) {
        return d(layoutManager, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f419602k;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f419602k = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f419602k;
    }

    public boolean l(int i3) {
        if (i3 == -1) {
            return false;
        }
        return k(i3, false);
    }

    public void m(float f16) {
        this.f419599h = -1;
        this.f419600i = f16;
    }

    public boolean n(int i3) {
        if (i3 == -1) {
            return false;
        }
        return k(i3, true);
    }

    public b(int i3, @NonNull c cVar) {
        this(i3, false, cVar);
    }

    public b(int i3, boolean z16, @Nullable c cVar) {
        this.f419596e = false;
        this.f419597f = false;
        this.f419598g = 100.0f;
        this.f419599h = -1;
        this.f419600i = -1.0f;
        this.f419605n = new a();
        if (i3 != 8388611 && i3 != 8388613 && i3 != 80 && i3 != 48 && i3 != 17) {
            i3 = 8388611;
        }
        this.f419594c = z16;
        this.f419592a = i3;
        this.f419603l = cVar;
    }
}
