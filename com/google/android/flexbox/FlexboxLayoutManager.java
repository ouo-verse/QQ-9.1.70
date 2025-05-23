package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements com.google.android.flexbox.a, RecyclerView.SmoothScroller.ScrollVectorProvider {
    private static final Rect X = new Rect();
    private boolean C;
    private List<com.google.android.flexbox.b> D;
    private final com.google.android.flexbox.c E;
    private RecyclerView.Recycler F;
    private RecyclerView.State G;
    private c H;
    private b I;
    private OrientationHelper J;
    private OrientationHelper K;
    private SavedState L;
    private int M;
    private int N;
    private int P;
    private int Q;
    private boolean R;
    private SparseArray<View> S;
    private final Context T;
    private View U;
    private int V;
    private c.b W;

    /* renamed from: d, reason: collision with root package name */
    private int f33103d;

    /* renamed from: e, reason: collision with root package name */
    private int f33104e;

    /* renamed from: f, reason: collision with root package name */
    private int f33105f;

    /* renamed from: h, reason: collision with root package name */
    private int f33106h;

    /* renamed from: i, reason: collision with root package name */
    private int f33107i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f33108m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private int f33117a;

        /* renamed from: b, reason: collision with root package name */
        private int f33118b;

        /* renamed from: c, reason: collision with root package name */
        private int f33119c;

        /* renamed from: d, reason: collision with root package name */
        private int f33120d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f33121e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f33122f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f33123g;

        b() {
            this.f33120d = 0;
        }

        static /* synthetic */ int l(b bVar, int i3) {
            int i16 = bVar.f33120d + i3;
            bVar.f33120d = i16;
            return i16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            int startAfterPadding;
            int width;
            if (!FlexboxLayoutManager.this.q() && FlexboxLayoutManager.this.f33108m) {
                if (this.f33121e) {
                    width = FlexboxLayoutManager.this.J.getEndAfterPadding();
                } else {
                    width = FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.J.getStartAfterPadding();
                }
                this.f33119c = width;
                return;
            }
            if (this.f33121e) {
                startAfterPadding = FlexboxLayoutManager.this.J.getEndAfterPadding();
            } else {
                startAfterPadding = FlexboxLayoutManager.this.J.getStartAfterPadding();
            }
            this.f33119c = startAfterPadding;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(View view) {
            OrientationHelper orientationHelper = FlexboxLayoutManager.this.f33104e == 0 ? FlexboxLayoutManager.this.K : FlexboxLayoutManager.this.J;
            if (!FlexboxLayoutManager.this.q() && FlexboxLayoutManager.this.f33108m) {
                if (this.f33121e) {
                    this.f33119c = orientationHelper.getDecoratedStart(view) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.f33119c = orientationHelper.getDecoratedEnd(view);
                }
            } else if (this.f33121e) {
                this.f33119c = orientationHelper.getDecoratedEnd(view) + orientationHelper.getTotalSpaceChange();
            } else {
                this.f33119c = orientationHelper.getDecoratedStart(view);
            }
            this.f33117a = FlexboxLayoutManager.this.getPosition(view);
            int i3 = 0;
            this.f33123g = false;
            int[] iArr = FlexboxLayoutManager.this.E.f33155c;
            int i16 = this.f33117a;
            if (i16 == -1) {
                i16 = 0;
            }
            int i17 = iArr[i16];
            if (i17 != -1) {
                i3 = i17;
            }
            this.f33118b = i3;
            if (FlexboxLayoutManager.this.D.size() > this.f33118b) {
                this.f33117a = ((com.google.android.flexbox.b) FlexboxLayoutManager.this.D.get(this.f33118b)).f33149o;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t() {
            this.f33117a = -1;
            this.f33118b = -1;
            this.f33119c = Integer.MIN_VALUE;
            boolean z16 = false;
            this.f33122f = false;
            this.f33123g = false;
            if (FlexboxLayoutManager.this.q()) {
                if (FlexboxLayoutManager.this.f33104e == 0) {
                    if (FlexboxLayoutManager.this.f33103d == 1) {
                        z16 = true;
                    }
                    this.f33121e = z16;
                    return;
                } else {
                    if (FlexboxLayoutManager.this.f33104e == 2) {
                        z16 = true;
                    }
                    this.f33121e = z16;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.f33104e == 0) {
                if (FlexboxLayoutManager.this.f33103d == 3) {
                    z16 = true;
                }
                this.f33121e = z16;
            } else {
                if (FlexboxLayoutManager.this.f33104e == 2) {
                    z16 = true;
                }
                this.f33121e = z16;
            }
        }

        @NonNull
        public String toString() {
            return "AnchorInfo{mPosition=" + this.f33117a + ", mFlexLinePosition=" + this.f33118b + ", mCoordinate=" + this.f33119c + ", mPerpendicularCoordinate=" + this.f33120d + ", mLayoutFromEnd=" + this.f33121e + ", mValid=" + this.f33122f + ", mAssignedFromSavedState=" + this.f33123g + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int f33125a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f33126b;

        /* renamed from: c, reason: collision with root package name */
        private int f33127c;

        /* renamed from: d, reason: collision with root package name */
        private int f33128d;

        /* renamed from: e, reason: collision with root package name */
        private int f33129e;

        /* renamed from: f, reason: collision with root package name */
        private int f33130f;

        /* renamed from: g, reason: collision with root package name */
        private int f33131g;

        /* renamed from: h, reason: collision with root package name */
        private int f33132h;

        /* renamed from: i, reason: collision with root package name */
        private int f33133i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f33134j;

        c() {
            this.f33132h = 1;
            this.f33133i = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean D(RecyclerView.State state, List<com.google.android.flexbox.b> list) {
            int i3;
            int i16 = this.f33128d;
            if (i16 >= 0 && i16 < state.getItemCount() && (i3 = this.f33127c) >= 0 && i3 < list.size()) {
                return true;
            }
            return false;
        }

        static /* synthetic */ int c(c cVar, int i3) {
            int i16 = cVar.f33129e + i3;
            cVar.f33129e = i16;
            return i16;
        }

        static /* synthetic */ int d(c cVar, int i3) {
            int i16 = cVar.f33129e - i3;
            cVar.f33129e = i16;
            return i16;
        }

        static /* synthetic */ int i(c cVar, int i3) {
            int i16 = cVar.f33125a - i3;
            cVar.f33125a = i16;
            return i16;
        }

        static /* synthetic */ int l(c cVar) {
            int i3 = cVar.f33127c;
            cVar.f33127c = i3 + 1;
            return i3;
        }

        static /* synthetic */ int m(c cVar) {
            int i3 = cVar.f33127c;
            cVar.f33127c = i3 - 1;
            return i3;
        }

        static /* synthetic */ int n(c cVar, int i3) {
            int i16 = cVar.f33127c + i3;
            cVar.f33127c = i16;
            return i16;
        }

        static /* synthetic */ int q(c cVar, int i3) {
            int i16 = cVar.f33130f + i3;
            cVar.f33130f = i16;
            return i16;
        }

        static /* synthetic */ int u(c cVar, int i3) {
            int i16 = cVar.f33128d + i3;
            cVar.f33128d = i16;
            return i16;
        }

        static /* synthetic */ int v(c cVar, int i3) {
            int i16 = cVar.f33128d - i3;
            cVar.f33128d = i16;
            return i16;
        }

        @NonNull
        public String toString() {
            return "LayoutState{mAvailable=" + this.f33125a + ", mFlexLinePosition=" + this.f33127c + ", mPosition=" + this.f33128d + ", mOffset=" + this.f33129e + ", mScrollingOffset=" + this.f33130f + ", mLastScrollDelta=" + this.f33131g + ", mItemDirection=" + this.f33132h + ", mLayoutDirection=" + this.f33133i + '}';
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    private void A() {
        if (this.J != null) {
            return;
        }
        if (q()) {
            if (this.f33104e == 0) {
                this.J = OrientationHelper.createHorizontalHelper(this);
                this.K = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.J = OrientationHelper.createVerticalHelper(this);
                this.K = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.f33104e == 0) {
            this.J = OrientationHelper.createVerticalHelper(this);
            this.K = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.J = OrientationHelper.createHorizontalHelper(this);
            this.K = OrientationHelper.createVerticalHelper(this);
        }
    }

    private int B(RecyclerView.Recycler recycler, RecyclerView.State state, c cVar) {
        if (cVar.f33130f != Integer.MIN_VALUE) {
            if (cVar.f33125a < 0) {
                c.q(cVar, cVar.f33125a);
            }
            T(recycler, cVar);
        }
        int i3 = cVar.f33125a;
        int i16 = cVar.f33125a;
        boolean q16 = q();
        int i17 = 0;
        while (true) {
            if ((i16 > 0 || this.H.f33126b) && cVar.D(state, this.D)) {
                com.google.android.flexbox.b bVar = this.D.get(cVar.f33127c);
                cVar.f33128d = bVar.f33149o;
                i17 += Q(bVar, cVar);
                if (!q16 && this.f33108m) {
                    c.d(cVar, bVar.a() * cVar.f33133i);
                } else {
                    c.c(cVar, bVar.a() * cVar.f33133i);
                }
                i16 -= bVar.a();
            }
        }
        c.i(cVar, i17);
        if (cVar.f33130f != Integer.MIN_VALUE) {
            c.q(cVar, i17);
            if (cVar.f33125a < 0) {
                c.q(cVar, cVar.f33125a);
            }
            T(recycler, cVar);
        }
        return i3 - cVar.f33125a;
    }

    private View C(int i3) {
        View H = H(0, getChildCount(), i3);
        if (H == null) {
            return null;
        }
        int i16 = this.E.f33155c[getPosition(H)];
        if (i16 == -1) {
            return null;
        }
        return D(H, this.D.get(i16));
    }

    private View D(View view, com.google.android.flexbox.b bVar) {
        boolean q16 = q();
        int i3 = bVar.f33142h;
        for (int i16 = 1; i16 < i3; i16++) {
            View childAt = getChildAt(i16);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.f33108m && !q16) {
                    if (this.J.getDecoratedEnd(view) >= this.J.getDecoratedEnd(childAt)) {
                    }
                    view = childAt;
                } else {
                    if (this.J.getDecoratedStart(view) <= this.J.getDecoratedStart(childAt)) {
                    }
                    view = childAt;
                }
            }
        }
        return view;
    }

    private View E(int i3) {
        View H = H(getChildCount() - 1, -1, i3);
        if (H == null) {
            return null;
        }
        return F(H, this.D.get(this.E.f33155c[getPosition(H)]));
    }

    private View F(View view, com.google.android.flexbox.b bVar) {
        boolean q16 = q();
        int childCount = (getChildCount() - bVar.f33142h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.f33108m && !q16) {
                    if (this.J.getDecoratedStart(view) <= this.J.getDecoratedStart(childAt)) {
                    }
                    view = childAt;
                } else {
                    if (this.J.getDecoratedEnd(view) >= this.J.getDecoratedEnd(childAt)) {
                    }
                    view = childAt;
                }
            }
        }
        return view;
    }

    private View G(int i3, int i16, boolean z16) {
        int i17;
        if (i16 > i3) {
            i17 = 1;
        } else {
            i17 = -1;
        }
        while (i3 != i16) {
            View childAt = getChildAt(i3);
            if (P(childAt, z16)) {
                return childAt;
            }
            i3 += i17;
        }
        return null;
    }

    private View H(int i3, int i16, int i17) {
        int i18;
        int position;
        A();
        ensureLayoutState();
        int startAfterPadding = this.J.getStartAfterPadding();
        int endAfterPadding = this.J.getEndAfterPadding();
        if (i16 > i3) {
            i18 = 1;
        } else {
            i18 = -1;
        }
        View view = null;
        View view2 = null;
        while (i3 != i16) {
            View childAt = getChildAt(i3);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < i17) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.J.getDecoratedStart(childAt) >= startAfterPadding && this.J.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i3 += i18;
        }
        if (view == null) {
            return view2;
        }
        return view;
    }

    private int I(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    private int J(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    private int K(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    private int L(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    private int N(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z16;
        if (getChildCount() == 0 || i3 == 0) {
            return 0;
        }
        A();
        int i16 = 1;
        this.H.f33134j = true;
        if (!q() && this.f33108m) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 ? i3 <= 0 : i3 >= 0) {
            i16 = -1;
        }
        int abs = Math.abs(i3);
        h0(i16, abs);
        int B = this.H.f33130f + B(recycler, state, this.H);
        if (B < 0) {
            return 0;
        }
        if (z16) {
            if (abs > B) {
                i3 = (-i16) * B;
            }
        } else if (abs > B) {
            i3 = i16 * B;
        }
        this.J.offsetChildren(-i3);
        this.H.f33131g = i3;
        return i3;
    }

    private int O(int i3) {
        int height;
        int height2;
        int i16;
        boolean z16 = false;
        if (getChildCount() == 0 || i3 == 0) {
            return 0;
        }
        A();
        boolean q16 = q();
        View view = this.U;
        if (q16) {
            height = view.getWidth();
        } else {
            height = view.getHeight();
        }
        if (q16) {
            height2 = getWidth();
        } else {
            height2 = getHeight();
        }
        if (getLayoutDirection() == 1) {
            z16 = true;
        }
        if (z16) {
            int abs = Math.abs(i3);
            if (i3 < 0) {
                i16 = Math.min((height2 + this.I.f33120d) - height, abs);
            } else if (this.I.f33120d + i3 > 0) {
                i16 = this.I.f33120d;
            } else {
                return i3;
            }
        } else {
            if (i3 > 0) {
                return Math.min((height2 - this.I.f33120d) - height, i3);
            }
            if (this.I.f33120d + i3 < 0) {
                i16 = this.I.f33120d;
            } else {
                return i3;
            }
        }
        return -i16;
    }

    private boolean P(View view, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int J = J(view);
        int L = L(view);
        int K = K(view);
        int I = I(view);
        if (paddingLeft <= J && width >= K) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (J < width && K < paddingLeft) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (paddingTop <= L && height >= I) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (L < height && I < paddingTop) {
            z26 = false;
        } else {
            z26 = true;
        }
        if (z16) {
            if (z17 && z19) {
                return true;
            }
            return false;
        }
        if (z18 && z26) {
            return true;
        }
        return false;
    }

    private int Q(com.google.android.flexbox.b bVar, c cVar) {
        if (q()) {
            return R(bVar, cVar);
        }
        return S(bVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int R(com.google.android.flexbox.b bVar, c cVar) {
        float f16;
        float f17;
        float f18;
        int b16;
        int i3;
        LayoutParams layoutParams;
        float f19;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = getWidth();
        int i16 = cVar.f33129e;
        if (cVar.f33133i == -1) {
            i16 -= bVar.f33141g;
        }
        int i17 = i16;
        int i18 = cVar.f33128d;
        int i19 = this.f33105f;
        int i26 = 1;
        if (i19 != 0) {
            if (i19 != 1) {
                if (i19 != 2) {
                    if (i19 != 3) {
                        if (i19 != 4) {
                            if (i19 == 5) {
                                if (bVar.f33142h != 0) {
                                    f18 = (width - bVar.f33139e) / (r4 + 1);
                                } else {
                                    f18 = 0.0f;
                                }
                                f16 = paddingLeft + f18;
                                f17 = (width - paddingRight) - f18;
                            } else {
                                throw new IllegalStateException("Invalid justifyContent is set: " + this.f33105f);
                            }
                        } else {
                            int i27 = bVar.f33142h;
                            if (i27 != 0) {
                                f18 = (width - bVar.f33139e) / i27;
                            } else {
                                f18 = 0.0f;
                            }
                            float f26 = f18 / 2.0f;
                            f16 = paddingLeft + f26;
                            f17 = (width - paddingRight) - f26;
                        }
                    } else {
                        f16 = paddingLeft;
                        int i28 = bVar.f33142h;
                        if (i28 != 1) {
                            f19 = i28 - 1;
                        } else {
                            f19 = 1.0f;
                        }
                        f18 = (width - bVar.f33139e) / f19;
                        f17 = width - paddingRight;
                    }
                } else {
                    int i29 = bVar.f33139e;
                    f16 = paddingLeft + ((width - i29) / 2.0f);
                    f17 = (width - paddingRight) - ((width - i29) / 2.0f);
                }
            } else {
                int i36 = bVar.f33139e;
                float f27 = (width - i36) + paddingRight;
                f18 = 0.0f;
                f17 = i36 - paddingLeft;
                f16 = f27;
            }
            float f28 = f16 - this.I.f33120d;
            float f29 = f17 - this.I.f33120d;
            float max = Math.max(f18, 0.0f);
            b16 = bVar.b();
            int i37 = 0;
            i3 = i18;
            while (i3 < i18 + b16) {
                View f36 = f(i3);
                if (f36 != null) {
                    if (cVar.f33133i == i26) {
                        calculateItemDecorationsForChild(f36, X);
                        addView(f36);
                    } else {
                        calculateItemDecorationsForChild(f36, X);
                        addView(f36, i37);
                        i37++;
                    }
                    int i38 = i37;
                    com.google.android.flexbox.c cVar2 = this.E;
                    long j3 = cVar2.f33156d[i3];
                    int y16 = cVar2.y(j3);
                    int x16 = this.E.x(j3);
                    LayoutParams layoutParams2 = (LayoutParams) f36.getLayoutParams();
                    if (shouldMeasureChild(f36, y16, x16, layoutParams2)) {
                        f36.measure(y16, x16);
                    }
                    float leftDecorationWidth = f28 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + getLeftDecorationWidth(f36);
                    float rightDecorationWidth = f29 - (((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + getRightDecorationWidth(f36));
                    int topDecorationHeight = i17 + getTopDecorationHeight(f36);
                    if (this.f33108m) {
                        layoutParams = layoutParams2;
                        this.E.Q(f36, bVar, Math.round(rightDecorationWidth) - f36.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + f36.getMeasuredHeight());
                    } else {
                        layoutParams = layoutParams2;
                        this.E.Q(f36, bVar, Math.round(leftDecorationWidth), topDecorationHeight, Math.round(leftDecorationWidth) + f36.getMeasuredWidth(), topDecorationHeight + f36.getMeasuredHeight());
                    }
                    i37 = i38;
                    f28 = leftDecorationWidth + f36.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(f36) + max;
                    f29 = rightDecorationWidth - (((f36.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + getLeftDecorationWidth(f36)) + max);
                }
                i3++;
                i26 = 1;
            }
            c.n(cVar, this.H.f33133i);
            return bVar.a();
        }
        f16 = paddingLeft;
        f17 = width - paddingRight;
        f18 = 0.0f;
        float f282 = f16 - this.I.f33120d;
        float f292 = f17 - this.I.f33120d;
        float max2 = Math.max(f18, 0.0f);
        b16 = bVar.b();
        int i372 = 0;
        i3 = i18;
        while (i3 < i18 + b16) {
        }
        c.n(cVar, this.H.f33133i);
        return bVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int S(com.google.android.flexbox.b bVar, c cVar) {
        float f16;
        float f17;
        float f18;
        int b16;
        int i3;
        float f19;
        boolean z16;
        View view;
        int i16;
        float f26;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i17 = cVar.f33129e;
        int i18 = cVar.f33129e;
        if (cVar.f33133i == -1) {
            int i19 = bVar.f33141g;
            i17 -= i19;
            i18 += i19;
        }
        int i26 = i17;
        int i27 = i18;
        int i28 = cVar.f33128d;
        int i29 = this.f33105f;
        boolean z17 = true;
        if (i29 != 0) {
            if (i29 != 1) {
                if (i29 != 2) {
                    if (i29 != 3) {
                        if (i29 != 4) {
                            if (i29 == 5) {
                                if (bVar.f33142h != 0) {
                                    f18 = (height - bVar.f33139e) / (r4 + 1);
                                } else {
                                    f18 = 0.0f;
                                }
                                f16 = paddingTop + f18;
                                f17 = (height - paddingBottom) - f18;
                            } else {
                                throw new IllegalStateException("Invalid justifyContent is set: " + this.f33105f);
                            }
                        } else {
                            int i36 = bVar.f33142h;
                            if (i36 != 0) {
                                f18 = (height - bVar.f33139e) / i36;
                            } else {
                                f18 = 0.0f;
                            }
                            float f27 = f18 / 2.0f;
                            f16 = paddingTop + f27;
                            f17 = (height - paddingBottom) - f27;
                        }
                    } else {
                        f16 = paddingTop;
                        int i37 = bVar.f33142h;
                        if (i37 != 1) {
                            f26 = i37 - 1;
                        } else {
                            f26 = 1.0f;
                        }
                        f18 = (height - bVar.f33139e) / f26;
                        f17 = height - paddingBottom;
                    }
                } else {
                    int i38 = bVar.f33139e;
                    f16 = paddingTop + ((height - i38) / 2.0f);
                    f17 = (height - paddingBottom) - ((height - i38) / 2.0f);
                }
            } else {
                int i39 = bVar.f33139e;
                float f28 = (height - i39) + paddingBottom;
                f18 = 0.0f;
                f17 = i39 - paddingTop;
                f16 = f28;
            }
            float f29 = f16 - this.I.f33120d;
            float f36 = f17 - this.I.f33120d;
            float max = Math.max(f18, 0.0f);
            b16 = bVar.b();
            int i46 = 0;
            i3 = i28;
            while (i3 < i28 + b16) {
                View f37 = f(i3);
                if (f37 == null) {
                    i16 = i3;
                    z16 = z17;
                    f19 = max;
                } else {
                    com.google.android.flexbox.c cVar2 = this.E;
                    f19 = max;
                    long j3 = cVar2.f33156d[i3];
                    int y16 = cVar2.y(j3);
                    int x16 = this.E.x(j3);
                    if (shouldMeasureChild(f37, y16, x16, (LayoutParams) f37.getLayoutParams())) {
                        f37.measure(y16, x16);
                    }
                    float topDecorationHeight = f29 + ((ViewGroup.MarginLayoutParams) r13).topMargin + getTopDecorationHeight(f37);
                    float bottomDecorationHeight = f36 - (((ViewGroup.MarginLayoutParams) r13).rightMargin + getBottomDecorationHeight(f37));
                    if (cVar.f33133i == 1) {
                        calculateItemDecorationsForChild(f37, X);
                        addView(f37);
                    } else {
                        calculateItemDecorationsForChild(f37, X);
                        addView(f37, i46);
                        i46++;
                    }
                    int i47 = i46;
                    int leftDecorationWidth = i26 + getLeftDecorationWidth(f37);
                    int rightDecorationWidth = i27 - getRightDecorationWidth(f37);
                    boolean z18 = this.f33108m;
                    if (z18) {
                        if (this.C) {
                            z16 = true;
                            view = f37;
                            i16 = i3;
                            this.E.R(f37, bVar, z18, rightDecorationWidth - f37.getMeasuredWidth(), Math.round(bottomDecorationHeight) - f37.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            z16 = true;
                            view = f37;
                            i16 = i3;
                            this.E.R(view, bVar, z18, rightDecorationWidth - view.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Math.round(topDecorationHeight) + view.getMeasuredHeight());
                        }
                    } else {
                        z16 = true;
                        view = f37;
                        i16 = i3;
                        if (this.C) {
                            this.E.R(view, bVar, z18, leftDecorationWidth, Math.round(bottomDecorationHeight) - view.getMeasuredHeight(), leftDecorationWidth + view.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                        } else {
                            this.E.R(view, bVar, z18, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + view.getMeasuredWidth(), Math.round(topDecorationHeight) + view.getMeasuredHeight());
                        }
                    }
                    View view2 = view;
                    f29 = topDecorationHeight + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r13).topMargin + getBottomDecorationHeight(view2) + f19;
                    i46 = i47;
                    f36 = bottomDecorationHeight - (((view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r13).bottomMargin) + getTopDecorationHeight(view2)) + f19);
                }
                i3 = i16 + 1;
                max = f19;
                z17 = z16;
            }
            c.n(cVar, this.H.f33133i);
            return bVar.a();
        }
        f16 = paddingTop;
        f17 = height - paddingBottom;
        f18 = 0.0f;
        float f292 = f16 - this.I.f33120d;
        float f362 = f17 - this.I.f33120d;
        float max2 = Math.max(f18, 0.0f);
        b16 = bVar.b();
        int i462 = 0;
        i3 = i28;
        while (i3 < i28 + b16) {
        }
        c.n(cVar, this.H.f33133i);
        return bVar.a();
    }

    private void T(RecyclerView.Recycler recycler, c cVar) {
        if (!cVar.f33134j) {
            return;
        }
        if (cVar.f33133i == -1) {
            U(recycler, cVar);
        } else {
            V(recycler, cVar);
        }
    }

    private void U(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        int i3;
        View childAt;
        int i16;
        if (cVar.f33130f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(childCount - 1)) == null || (i16 = this.E.f33155c[getPosition(childAt)]) == -1) {
            return;
        }
        com.google.android.flexbox.b bVar = this.D.get(i16);
        int i17 = i3;
        while (true) {
            if (i17 < 0) {
                break;
            }
            View childAt2 = getChildAt(i17);
            if (childAt2 != null) {
                if (!x(childAt2, cVar.f33130f)) {
                    break;
                }
                if (bVar.f33149o != getPosition(childAt2)) {
                    continue;
                } else if (i16 <= 0) {
                    childCount = i17;
                    break;
                } else {
                    i16 += cVar.f33133i;
                    bVar = this.D.get(i16);
                    childCount = i17;
                }
            }
            i17--;
        }
        recycleChildren(recycler, childCount, i3);
    }

    private void V(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        View childAt;
        if (cVar.f33130f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(0)) == null) {
            return;
        }
        int i3 = this.E.f33155c[getPosition(childAt)];
        int i16 = -1;
        if (i3 == -1) {
            return;
        }
        com.google.android.flexbox.b bVar = this.D.get(i3);
        int i17 = 0;
        while (true) {
            if (i17 >= childCount) {
                break;
            }
            View childAt2 = getChildAt(i17);
            if (childAt2 != null) {
                if (!y(childAt2, cVar.f33130f)) {
                    break;
                }
                if (bVar.f33150p != getPosition(childAt2)) {
                    continue;
                } else if (i3 >= this.D.size() - 1) {
                    i16 = i17;
                    break;
                } else {
                    i3 += cVar.f33133i;
                    bVar = this.D.get(i3);
                    i16 = i17;
                }
            }
            i17++;
        }
        recycleChildren(recycler, 0, i16);
    }

    private void W() {
        int widthMode;
        boolean z16;
        if (q()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        c cVar = this.H;
        if (widthMode != 0 && widthMode != Integer.MIN_VALUE) {
            z16 = false;
        } else {
            z16 = true;
        }
        cVar.f33126b = z16;
    }

    private void X() {
        boolean z16;
        boolean z17;
        boolean z18;
        int layoutDirection = getLayoutDirection();
        int i3 = this.f33103d;
        boolean z19 = false;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        this.f33108m = false;
                        this.C = false;
                        return;
                    }
                    if (layoutDirection == 1) {
                        z19 = true;
                    }
                    this.f33108m = z19;
                    if (this.f33104e == 2) {
                        this.f33108m = !z19;
                    }
                    this.C = true;
                    return;
                }
                if (layoutDirection == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                this.f33108m = z18;
                if (this.f33104e == 2) {
                    this.f33108m = !z18;
                }
                this.C = false;
                return;
            }
            if (layoutDirection != 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f33108m = z17;
            if (this.f33104e == 2) {
                z19 = true;
            }
            this.C = z19;
            return;
        }
        if (layoutDirection == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f33108m = z16;
        if (this.f33104e == 2) {
            z19 = true;
        }
        this.C = z19;
    }

    private boolean c0(RecyclerView.State state, b bVar) {
        View C;
        int startAfterPadding;
        boolean z16 = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (bVar.f33121e) {
            C = E(state.getItemCount());
        } else {
            C = C(state.getItemCount());
        }
        if (C != null) {
            bVar.s(C);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if (this.J.getDecoratedStart(C) >= this.J.getEndAfterPadding() || this.J.getDecoratedEnd(C) < this.J.getStartAfterPadding()) {
                    z16 = true;
                }
                if (z16) {
                    if (bVar.f33121e) {
                        startAfterPadding = this.J.getEndAfterPadding();
                    } else {
                        startAfterPadding = this.J.getStartAfterPadding();
                    }
                    bVar.f33119c = startAfterPadding;
                }
            }
            return true;
        }
        return false;
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        A();
        View C = C(itemCount);
        View E = E(itemCount);
        if (state.getItemCount() == 0 || C == null || E == null) {
            return 0;
        }
        return Math.min(this.J.getTotalSpace(), this.J.getDecoratedEnd(E) - this.J.getDecoratedStart(C));
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View C = C(itemCount);
        View E = E(itemCount);
        if (state.getItemCount() != 0 && C != null && E != null) {
            int position = getPosition(C);
            int position2 = getPosition(E);
            int abs = Math.abs(this.J.getDecoratedEnd(E) - this.J.getDecoratedStart(C));
            int i3 = this.E.f33155c[position];
            if (i3 != 0 && i3 != -1) {
                return Math.round((i3 * (abs / ((r4[position2] - i3) + 1))) + (this.J.getStartAfterPadding() - this.J.getDecoratedStart(C)));
            }
        }
        return 0;
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View C = C(itemCount);
        View E = E(itemCount);
        if (state.getItemCount() == 0 || C == null || E == null) {
            return 0;
        }
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((Math.abs(this.J.getDecoratedEnd(E) - this.J.getDecoratedStart(C)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
    }

    private boolean d0(RecyclerView.State state, b bVar, SavedState savedState) {
        int i3;
        View childAt;
        int decoratedStart;
        boolean z16 = false;
        if (!state.isPreLayout() && (i3 = this.M) != -1) {
            if (i3 >= 0 && i3 < state.getItemCount()) {
                bVar.f33117a = this.M;
                bVar.f33118b = this.E.f33155c[bVar.f33117a];
                SavedState savedState2 = this.L;
                if (savedState2 != null && savedState2.j(state.getItemCount())) {
                    bVar.f33119c = this.J.getStartAfterPadding() + savedState.f33116e;
                    bVar.f33123g = true;
                    bVar.f33118b = -1;
                    return true;
                }
                if (this.N == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.M);
                    if (findViewByPosition != null) {
                        if (this.J.getDecoratedMeasurement(findViewByPosition) > this.J.getTotalSpace()) {
                            bVar.r();
                            return true;
                        }
                        if (this.J.getDecoratedStart(findViewByPosition) - this.J.getStartAfterPadding() < 0) {
                            bVar.f33119c = this.J.getStartAfterPadding();
                            bVar.f33121e = false;
                            return true;
                        }
                        if (this.J.getEndAfterPadding() - this.J.getDecoratedEnd(findViewByPosition) < 0) {
                            bVar.f33119c = this.J.getEndAfterPadding();
                            bVar.f33121e = true;
                            return true;
                        }
                        if (bVar.f33121e) {
                            decoratedStart = this.J.getDecoratedEnd(findViewByPosition) + this.J.getTotalSpaceChange();
                        } else {
                            decoratedStart = this.J.getDecoratedStart(findViewByPosition);
                        }
                        bVar.f33119c = decoratedStart;
                    } else {
                        if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                            if (this.M < getPosition(childAt)) {
                                z16 = true;
                            }
                            bVar.f33121e = z16;
                        }
                        bVar.r();
                    }
                    return true;
                }
                if (q() || !this.f33108m) {
                    bVar.f33119c = this.J.getStartAfterPadding() + this.N;
                } else {
                    bVar.f33119c = this.N - this.J.getEndPadding();
                }
                return true;
            }
            this.M = -1;
            this.N = Integer.MIN_VALUE;
        }
        return false;
    }

    private void e0(RecyclerView.State state, b bVar) {
        if (!d0(state, bVar, this.L) && !c0(state, bVar)) {
            bVar.r();
            bVar.f33117a = 0;
            bVar.f33118b = 0;
        }
    }

    private void ensureLayoutState() {
        if (this.H == null) {
            this.H = new c();
        }
    }

    private void f0(int i3) {
        if (i3 >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.E.t(childCount);
        this.E.u(childCount);
        this.E.s(childCount);
        if (i3 >= this.E.f33155c.length) {
            return;
        }
        this.V = i3;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.M = getPosition(childClosestToStart);
        if (!q() && this.f33108m) {
            this.N = this.J.getDecoratedEnd(childClosestToStart) + this.J.getEndPadding();
        } else {
            this.N = this.J.getDecoratedStart(childClosestToStart) - this.J.getStartAfterPadding();
        }
    }

    private int fixLayoutEndGap(int i3, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z16) {
        boolean z17;
        int i16;
        int endAfterPadding;
        if (!q() && this.f33108m) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            int startAfterPadding = i3 - this.J.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            i16 = N(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.J.getEndAfterPadding() - i3;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            i16 = -N(-endAfterPadding2, recycler, state);
        }
        int i17 = i3 + i16;
        if (z16 && (endAfterPadding = this.J.getEndAfterPadding() - i17) > 0) {
            this.J.offsetChildren(endAfterPadding);
            return endAfterPadding + i16;
        }
        return i16;
    }

    private int fixLayoutStartGap(int i3, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z16) {
        int i16;
        int startAfterPadding;
        if (!q() && this.f33108m) {
            int endAfterPadding = this.J.getEndAfterPadding() - i3;
            if (endAfterPadding <= 0) {
                return 0;
            }
            i16 = N(-endAfterPadding, recycler, state);
        } else {
            int startAfterPadding2 = i3 - this.J.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            i16 = -N(startAfterPadding2, recycler, state);
        }
        int i17 = i3 + i16;
        if (z16 && (startAfterPadding = i17 - this.J.getStartAfterPadding()) > 0) {
            this.J.offsetChildren(-startAfterPadding);
            return i16 - startAfterPadding;
        }
        return i16;
    }

    private void g0(int i3) {
        int i16;
        int i17;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z16 = true;
        if (q()) {
            int i18 = this.P;
            if (i18 == Integer.MIN_VALUE || i18 == width) {
                z16 = false;
            }
            i16 = this.H.f33126b ? this.T.getResources().getDisplayMetrics().heightPixels : this.H.f33125a;
        } else {
            int i19 = this.Q;
            if (i19 == Integer.MIN_VALUE || i19 == height) {
                z16 = false;
            }
            if (!this.H.f33126b) {
                i16 = this.H.f33125a;
            } else {
                i16 = this.T.getResources().getDisplayMetrics().widthPixels;
            }
        }
        int i26 = i16;
        this.P = width;
        this.Q = height;
        int i27 = this.V;
        if (i27 == -1 && (this.M != -1 || z16)) {
            if (this.I.f33121e) {
                return;
            }
            this.D.clear();
            this.W.a();
            if (q()) {
                this.E.e(this.W, makeMeasureSpec, makeMeasureSpec2, i26, this.I.f33117a, this.D);
            } else {
                this.E.h(this.W, makeMeasureSpec, makeMeasureSpec2, i26, this.I.f33117a, this.D);
            }
            this.D = this.W.f33158a;
            this.E.p(makeMeasureSpec, makeMeasureSpec2);
            this.E.X();
            b bVar = this.I;
            bVar.f33118b = this.E.f33155c[bVar.f33117a];
            this.H.f33127c = this.I.f33118b;
            return;
        }
        if (i27 == -1) {
            i17 = this.I.f33117a;
        } else {
            i17 = Math.min(i27, this.I.f33117a);
        }
        int i28 = i17;
        this.W.a();
        if (q()) {
            if (this.D.size() > 0) {
                this.E.j(this.D, i28);
                this.E.b(this.W, makeMeasureSpec, makeMeasureSpec2, i26, i28, this.I.f33117a, this.D);
            } else {
                this.E.s(i3);
                this.E.d(this.W, makeMeasureSpec, makeMeasureSpec2, i26, 0, this.D);
            }
        } else if (this.D.size() > 0) {
            this.E.j(this.D, i28);
            this.E.b(this.W, makeMeasureSpec2, makeMeasureSpec, i26, i28, this.I.f33117a, this.D);
        } else {
            this.E.s(i3);
            this.E.g(this.W, makeMeasureSpec, makeMeasureSpec2, i26, 0, this.D);
        }
        this.D = this.W.f33158a;
        this.E.q(makeMeasureSpec, makeMeasureSpec2, i28);
        this.E.Y(i28);
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private void h0(int i3, int i16) {
        boolean z16;
        int i17;
        this.H.f33133i = i3;
        boolean q16 = q();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        if (!q16 && this.f33108m) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.H.f33129e = this.J.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View F = F(childAt, this.D.get(this.E.f33155c[position]));
            this.H.f33132h = 1;
            c cVar = this.H;
            cVar.f33128d = position + cVar.f33132h;
            if (this.E.f33155c.length <= this.H.f33128d) {
                this.H.f33127c = -1;
            } else {
                c cVar2 = this.H;
                cVar2.f33127c = this.E.f33155c[cVar2.f33128d];
            }
            if (z16) {
                this.H.f33129e = this.J.getDecoratedStart(F);
                this.H.f33130f = (-this.J.getDecoratedStart(F)) + this.J.getStartAfterPadding();
                c cVar3 = this.H;
                cVar3.f33130f = Math.max(cVar3.f33130f, 0);
            } else {
                this.H.f33129e = this.J.getDecoratedEnd(F);
                this.H.f33130f = this.J.getDecoratedEnd(F) - this.J.getEndAfterPadding();
            }
            if ((this.H.f33127c == -1 || this.H.f33127c > this.D.size() - 1) && this.H.f33128d <= c()) {
                int i18 = i16 - this.H.f33130f;
                this.W.a();
                if (i18 > 0) {
                    if (q16) {
                        this.E.d(this.W, makeMeasureSpec, makeMeasureSpec2, i18, this.H.f33128d, this.D);
                    } else {
                        this.E.g(this.W, makeMeasureSpec, makeMeasureSpec2, i18, this.H.f33128d, this.D);
                    }
                    this.E.q(makeMeasureSpec, makeMeasureSpec2, this.H.f33128d);
                    this.E.Y(this.H.f33128d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.H.f33129e = this.J.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View D = D(childAt2, this.D.get(this.E.f33155c[position2]));
            this.H.f33132h = 1;
            int i19 = this.E.f33155c[position2];
            if (i19 == -1) {
                i19 = 0;
            }
            if (i19 <= 0) {
                this.H.f33128d = -1;
            } else {
                this.H.f33128d = position2 - this.D.get(i19 - 1).b();
            }
            c cVar4 = this.H;
            if (i19 > 0) {
                i17 = i19 - 1;
            } else {
                i17 = 0;
            }
            cVar4.f33127c = i17;
            if (z16) {
                this.H.f33129e = this.J.getDecoratedEnd(D);
                this.H.f33130f = this.J.getDecoratedEnd(D) - this.J.getEndAfterPadding();
                c cVar5 = this.H;
                cVar5.f33130f = Math.max(cVar5.f33130f, 0);
            } else {
                this.H.f33129e = this.J.getDecoratedStart(D);
                this.H.f33130f = (-this.J.getDecoratedStart(D)) + this.J.getStartAfterPadding();
            }
        }
        c cVar6 = this.H;
        cVar6.f33125a = i16 - cVar6.f33130f;
    }

    private void i0(b bVar, boolean z16, boolean z17) {
        if (!z17) {
            this.H.f33126b = false;
        } else {
            W();
        }
        if (!q() && this.f33108m) {
            this.H.f33125a = bVar.f33119c - getPaddingRight();
        } else {
            this.H.f33125a = this.J.getEndAfterPadding() - bVar.f33119c;
        }
        this.H.f33128d = bVar.f33117a;
        this.H.f33132h = 1;
        this.H.f33133i = 1;
        this.H.f33129e = bVar.f33119c;
        this.H.f33130f = Integer.MIN_VALUE;
        this.H.f33127c = bVar.f33118b;
        if (z16 && this.D.size() > 1 && bVar.f33118b >= 0 && bVar.f33118b < this.D.size() - 1) {
            com.google.android.flexbox.b bVar2 = this.D.get(bVar.f33118b);
            c.l(this.H);
            c.u(this.H, bVar2.b());
        }
    }

    private static boolean isMeasurementUpToDate(int i3, int i16, int i17) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        if (i17 > 0 && i3 != i17) {
            return false;
        }
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                return true;
            }
            if (mode != 1073741824 || size != i3) {
                return false;
            }
            return true;
        }
        if (size < i3) {
            return false;
        }
        return true;
    }

    private void j0(b bVar, boolean z16, boolean z17) {
        if (!z17) {
            this.H.f33126b = false;
        } else {
            W();
        }
        if (!q() && this.f33108m) {
            this.H.f33125a = (this.U.getWidth() - bVar.f33119c) - this.J.getStartAfterPadding();
        } else {
            this.H.f33125a = bVar.f33119c - this.J.getStartAfterPadding();
        }
        this.H.f33128d = bVar.f33117a;
        this.H.f33132h = 1;
        this.H.f33133i = -1;
        this.H.f33129e = bVar.f33119c;
        this.H.f33130f = Integer.MIN_VALUE;
        this.H.f33127c = bVar.f33118b;
        if (z16 && bVar.f33118b > 0 && this.D.size() > bVar.f33118b) {
            com.google.android.flexbox.b bVar2 = this.D.get(bVar.f33118b);
            c.m(this.H);
            c.v(this.H, bVar2.b());
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i3, int i16) {
        while (i16 >= i3) {
            removeAndRecycleViewAt(i16, recycler);
            i16--;
        }
    }

    private boolean shouldMeasureChild(View view, int i3, int i16, RecyclerView.LayoutParams layoutParams) {
        if (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i16, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
            return false;
        }
        return true;
    }

    private boolean x(View view, int i3) {
        if (!q() && this.f33108m) {
            if (this.J.getDecoratedEnd(view) <= i3) {
                return true;
            }
            return false;
        }
        if (this.J.getDecoratedStart(view) >= this.J.getEnd() - i3) {
            return true;
        }
        return false;
    }

    private boolean y(View view, int i3) {
        if (!q() && this.f33108m) {
            if (this.J.getEnd() - this.J.getDecoratedStart(view) <= i3) {
                return true;
            }
            return false;
        }
        if (this.J.getDecoratedEnd(view) <= i3) {
            return true;
        }
        return false;
    }

    private void z() {
        this.D.clear();
        this.I.t();
        this.I.f33120d = 0;
    }

    @NonNull
    public List<com.google.android.flexbox.b> M() {
        ArrayList arrayList = new ArrayList(this.D.size());
        int size = this.D.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.google.android.flexbox.b bVar = this.D.get(i3);
            if (bVar.b() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void Y(int i3) {
        int i16 = this.f33106h;
        if (i16 != i3) {
            if (i16 == 4 || i3 == 4) {
                removeAllViews();
                z();
            }
            this.f33106h = i3;
            requestLayout();
        }
    }

    public void Z(int i3) {
        if (this.f33103d != i3) {
            removeAllViews();
            this.f33103d = i3;
            this.J = null;
            this.K = null;
            z();
            requestLayout();
        }
    }

    public void a0(int i3) {
        if (i3 != 2) {
            int i16 = this.f33104e;
            if (i16 != i3) {
                if (i16 == 0 || i3 == 0) {
                    removeAllViews();
                    z();
                }
                this.f33104e = i3;
                this.J = null;
                this.K = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }

    @Override // com.google.android.flexbox.a
    public int b() {
        if (this.D.size() == 0) {
            return 0;
        }
        int size = this.D.size();
        int i3 = Integer.MIN_VALUE;
        for (int i16 = 0; i16 < size; i16++) {
            i3 = Math.max(i3, this.D.get(i16).f33139e);
        }
        return i3;
    }

    public void b0(int i3) {
        if (this.f33105f != i3) {
            this.f33105f = i3;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public int c() {
        return this.G.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        int i3;
        if (this.f33104e == 0) {
            return q();
        }
        if (q()) {
            int width = getWidth();
            View view = this.U;
            if (view != null) {
                i3 = view.getWidth();
            } else {
                i3 = 0;
            }
            if (width <= i3) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        int i3;
        if (this.f33104e == 0) {
            return !q();
        }
        if (q()) {
            return true;
        }
        int height = getHeight();
        View view = this.U;
        if (view != null) {
            i3 = view.getHeight();
        } else {
            i3 = 0;
        }
        if (height > i3) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(@NonNull RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i3) {
        View childAt;
        int i16;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        if (i3 < getPosition(childAt)) {
            i16 = -1;
        } else {
            i16 = 1;
        }
        if (q()) {
            return new PointF(0.0f, i16);
        }
        return new PointF(i16, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(@NonNull RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(@NonNull RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(@NonNull RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // com.google.android.flexbox.a
    public int d() {
        return this.f33107i;
    }

    @Override // com.google.android.flexbox.a
    public View f(int i3) {
        View view = this.S.get(i3);
        if (view != null) {
            return view;
        }
        return this.F.getViewForPosition(i3);
    }

    public int findFirstVisibleItemPosition() {
        View G = G(0, getChildCount(), false);
        if (G == null) {
            return -1;
        }
        return getPosition(G);
    }

    public int findLastVisibleItemPosition() {
        View G = G(getChildCount() - 1, -1, false);
        if (G == null) {
            return -1;
        }
        return getPosition(G);
    }

    @Override // com.google.android.flexbox.a
    public int g() {
        return this.f33104e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.f33106h;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.f33103d;
    }

    @Override // com.google.android.flexbox.a
    public int h() {
        int size = this.D.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            i3 += this.D.get(i16).f33141g;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.a
    public List<com.google.android.flexbox.b> i() {
        return this.D;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // com.google.android.flexbox.a
    public int j(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (q()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // com.google.android.flexbox.a
    public int k(View view, int i3, int i16) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (q()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // com.google.android.flexbox.a
    public void l(View view, int i3, int i16, com.google.android.flexbox.b bVar) {
        calculateItemDecorationsForChild(view, X);
        if (q()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.f33139e += leftDecorationWidth;
            bVar.f33140f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            bVar.f33139e += topDecorationHeight;
            bVar.f33140f += topDecorationHeight;
        }
    }

    @Override // com.google.android.flexbox.a
    public int m(int i3, int i16, int i17) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i16, i17, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public View n(int i3) {
        return f(i3);
    }

    @Override // com.google.android.flexbox.a
    public int o(int i3, int i16, int i17) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i16, i17, canScrollHorizontally());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.U = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.R) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i3, int i16) {
        super.onItemsAdded(recyclerView, i3, i16);
        f0(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int i3, int i16, int i17) {
        super.onItemsMoved(recyclerView, i3, i16, i17);
        f0(Math.min(i3, i16));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i3, int i16) {
        super.onItemsRemoved(recyclerView, i3, i16);
        f0(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i3, int i16, Object obj) {
        super.onItemsUpdated(recyclerView, i3, i16, obj);
        f0(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i3;
        int i16;
        this.F = recycler;
        this.G = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        X();
        A();
        ensureLayoutState();
        this.E.t(itemCount);
        this.E.u(itemCount);
        this.E.s(itemCount);
        this.H.f33134j = false;
        SavedState savedState = this.L;
        if (savedState != null && savedState.j(itemCount)) {
            this.M = this.L.f33115d;
        }
        if (!this.I.f33122f || this.M != -1 || this.L != null) {
            this.I.t();
            e0(state, this.I);
            this.I.f33122f = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.I.f33121e) {
            j0(this.I, false, true);
        } else {
            i0(this.I, false, true);
        }
        g0(itemCount);
        B(recycler, state, this.H);
        if (this.I.f33121e) {
            i16 = this.H.f33129e;
            i0(this.I, true, false);
            B(recycler, state, this.H);
            i3 = this.H.f33129e;
        } else {
            i3 = this.H.f33129e;
            j0(this.I, true, false);
            B(recycler, state, this.H);
            i16 = this.H.f33129e;
        }
        if (getChildCount() > 0) {
            if (this.I.f33121e) {
                fixLayoutStartGap(i16 + fixLayoutEndGap(i3, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i3 + fixLayoutStartGap(i16, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.L = null;
        this.M = -1;
        this.N = Integer.MIN_VALUE;
        this.V = -1;
        this.I.t();
        this.S.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.L = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.L != null) {
            return new SavedState(this.L);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() <= 0) {
            savedState.k();
        } else {
            View childClosestToStart = getChildClosestToStart();
            savedState.f33115d = getPosition(childClosestToStart);
            savedState.f33116e = this.J.getDecoratedStart(childClosestToStart) - this.J.getStartAfterPadding();
        }
        return savedState;
    }

    @Override // com.google.android.flexbox.a
    public void p(int i3, View view) {
        this.S.put(i3, view);
    }

    @Override // com.google.android.flexbox.a
    public boolean q() {
        int i3 = this.f33103d;
        if (i3 == 0 || i3 == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (q() && this.f33104e != 0) {
            int O = O(i3);
            b.l(this.I, O);
            this.K.offsetChildren(-O);
            return O;
        }
        int N = N(i3, recycler, state);
        this.S.clear();
        return N;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i3) {
        this.M = i3;
        this.N = Integer.MIN_VALUE;
        SavedState savedState = this.L;
        if (savedState != null) {
            savedState.k();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!q() && (this.f33104e != 0 || q())) {
            int O = O(i3);
            b.l(this.I, O);
            this.K.offsetChildren(-O);
            return O;
        }
        int N = N(i3, recycler, state);
        this.S.clear();
        return N;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<com.google.android.flexbox.b> list) {
        this.D = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i3);
        startSmoothScroll(linearSmoothScroller);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        private int f33115d;

        /* renamed from: e, reason: collision with root package name */
        private int f33116e;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean j(int i3) {
            int i16 = this.f33115d;
            if (i16 >= 0 && i16 < i3) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k() {
            this.f33115d = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f33115d + ", mAnchorOffset=" + this.f33116e + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f33115d);
            parcel.writeInt(this.f33116e);
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f33115d = parcel.readInt();
            this.f33116e = parcel.readInt();
        }

        SavedState(SavedState savedState) {
            this.f33115d = savedState.f33115d;
            this.f33116e = savedState.f33116e;
        }
    }

    public FlexboxLayoutManager(Context context, int i3, int i16) {
        this.f33107i = -1;
        this.D = new ArrayList();
        this.E = new com.google.android.flexbox.c(this);
        this.I = new b();
        this.M = -1;
        this.N = Integer.MIN_VALUE;
        this.P = Integer.MIN_VALUE;
        this.Q = Integer.MIN_VALUE;
        this.S = new SparseArray<>();
        this.V = -1;
        this.W = new c.b();
        Z(i3);
        a0(i16);
        Y(4);
        this.T = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i3, int i16) {
        super.onItemsUpdated(recyclerView, i3, i16);
        f0(i3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int C;
        private int D;
        private boolean E;

        /* renamed from: d, reason: collision with root package name */
        private float f33109d;

        /* renamed from: e, reason: collision with root package name */
        private float f33110e;

        /* renamed from: f, reason: collision with root package name */
        private int f33111f;

        /* renamed from: h, reason: collision with root package name */
        private float f33112h;

        /* renamed from: i, reason: collision with root package name */
        private int f33113i;

        /* renamed from: m, reason: collision with root package name */
        private int f33114m;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<LayoutParams> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutParams[] newArray(int i3) {
                return new LayoutParams[i3];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f33109d = 0.0f;
            this.f33110e = 1.0f;
            this.f33111f = -1;
            this.f33112h = -1.0f;
            this.C = 16777215;
            this.D = 16777215;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float O() {
            return this.f33112h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void U(int i3) {
            this.f33114m = i3;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void W(int i3) {
            this.f33113i = i3;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean Y() {
            return this.E;
        }

        public void a(float f16) {
            this.f33112h = f16;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.f33111f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.f33109d;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.f33110e;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.D;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.C;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.f33114m;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.f33113i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeFloat(this.f33109d);
            parcel.writeFloat(this.f33110e);
            parcel.writeInt(this.f33111f);
            parcel.writeFloat(this.f33112h);
            parcel.writeInt(this.f33113i);
            parcel.writeInt(this.f33114m);
            parcel.writeInt(this.C);
            parcel.writeInt(this.D);
            parcel.writeByte(this.E ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.f33109d = 0.0f;
            this.f33110e = 1.0f;
            this.f33111f = -1;
            this.f33112h = -1.0f;
            this.C = 16777215;
            this.D = 16777215;
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.f33109d = 0.0f;
            this.f33110e = 1.0f;
            this.f33111f = -1;
            this.f33112h = -1.0f;
            this.C = 16777215;
            this.D = 16777215;
            this.f33109d = parcel.readFloat();
            this.f33110e = parcel.readFloat();
            this.f33111f = parcel.readInt();
            this.f33112h = parcel.readFloat();
            this.f33113i = parcel.readInt();
            this.f33114m = parcel.readInt();
            this.C = parcel.readInt();
            this.D = parcel.readInt();
            this.E = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    @Override // com.google.android.flexbox.a
    public void e(com.google.android.flexbox.b bVar) {
    }
}
