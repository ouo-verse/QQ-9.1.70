package com.qzone.common.event.ui.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class ExtendAdapterView<T extends Adapter> extends ViewGroup {
    int C;
    private int D;
    boolean E;
    c F;
    boolean G;
    int H;
    long I;
    int J;
    long K;
    private View L;
    int M;
    int N;
    int P;
    long Q;
    private boolean R;
    private boolean S;

    /* renamed from: d, reason: collision with root package name */
    int f45900d;

    /* renamed from: e, reason: collision with root package name */
    int f45901e;

    /* renamed from: f, reason: collision with root package name */
    int f45902f;

    /* renamed from: h, reason: collision with root package name */
    long f45903h;

    /* renamed from: i, reason: collision with root package name */
    long f45904i;

    /* renamed from: m, reason: collision with root package name */
    boolean f45905m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a implements ContextMenu.ContextMenuInfo {

        /* renamed from: a, reason: collision with root package name */
        public View f45906a;

        /* renamed from: b, reason: collision with root package name */
        public int f45907b;

        /* renamed from: c, reason: collision with root package name */
        public long f45908c;

        public a(View view, int i3, long j3) {
            this.f45906a = view;
            this.f45907b = i3;
            this.f45908c = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends DataSetObserver {

        /* renamed from: a, reason: collision with root package name */
        private Parcelable f45909a = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Parcelable parcelable;
            ExtendAdapterView extendAdapterView = ExtendAdapterView.this;
            extendAdapterView.G = true;
            extendAdapterView.N = extendAdapterView.M;
            extendAdapterView.M = extendAdapterView.f().getCount();
            if (ExtendAdapterView.this.f().hasStableIds() && (parcelable = this.f45909a) != null) {
                ExtendAdapterView extendAdapterView2 = ExtendAdapterView.this;
                if (extendAdapterView2.N == 0 && extendAdapterView2.M > 0) {
                    extendAdapterView2.onRestoreInstanceState(parcelable);
                    this.f45909a = null;
                    ExtendAdapterView.this.c();
                    ExtendAdapterView.this.requestLayout();
                }
            }
            ExtendAdapterView.this.r();
            ExtendAdapterView.this.c();
            ExtendAdapterView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExtendAdapterView extendAdapterView = ExtendAdapterView.this;
            extendAdapterView.G = true;
            if (extendAdapterView.f().hasStableIds()) {
                this.f45909a = ExtendAdapterView.this.onSaveInstanceState();
            }
            ExtendAdapterView extendAdapterView2 = ExtendAdapterView.this;
            extendAdapterView2.N = extendAdapterView2.M;
            extendAdapterView2.M = 0;
            extendAdapterView2.J = -1;
            extendAdapterView2.K = Long.MIN_VALUE;
            extendAdapterView2.H = -1;
            extendAdapterView2.I = Long.MIN_VALUE;
            extendAdapterView2.f45905m = false;
            extendAdapterView2.c();
            ExtendAdapterView.this.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface c {
        void onItemClick(ExtendAdapterView<?> extendAdapterView, View view, int i3, long j3);
    }

    public ExtendAdapterView(Context context) {
        super(context);
        this.f45900d = 0;
        this.f45903h = Long.MIN_VALUE;
        this.f45905m = false;
        this.E = false;
        this.H = -1;
        this.I = Long.MIN_VALUE;
        this.J = -1;
        this.K = Long.MIN_VALUE;
        this.P = -1;
        this.Q = Long.MIN_VALUE;
    }

    public static int resolveSizeAndState(int i3, int i16, int i17) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                i3 = size;
            }
        } else if (size < i3) {
            i3 = 16777216 | size;
        }
        return i3 | ((-16777216) & i17);
    }

    private void v(boolean z16) {
        if (n()) {
            z16 = false;
        }
        if (z16) {
            View view = this.L;
            if (view != null) {
                view.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.G) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        View view2 = this.L;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        T f16 = f();
        boolean z16 = !(f16 == null || f16.getCount() == 0) || n();
        super.setFocusableInTouchMode(z16 && this.S);
        super.setFocusable(z16 && this.R);
        if (this.L != null) {
            v(f16 == null || f16.isEmpty());
        }
    }

    @Override // android.view.ViewGroup
    protected boolean canAnimate() {
        return super.canAnimate() && this.M > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.J == this.P && this.K == this.Q) {
            return;
        }
        s();
        this.P = this.J;
        this.Q = this.K;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View l3 = l();
        return l3 != null && l3.getVisibility() == 0 && l3.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    int e() {
        int i3 = this.M;
        if (i3 == 0) {
            return -1;
        }
        long j3 = this.f45903h;
        int i16 = this.f45902f;
        if (j3 == Long.MIN_VALUE) {
            return -1;
        }
        int i17 = i3 - 1;
        int min = Math.min(i17, Math.max(0, i16));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        T f16 = f();
        if (f16 == null) {
            return -1;
        }
        int i18 = min;
        int i19 = i18;
        boolean z16 = false;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (f16.getItemId(min) != j3) {
                boolean z17 = i18 == i17;
                boolean z18 = i19 == 0;
                if (z17 && z18) {
                    break;
                }
                if (z18 || (z16 && !z17)) {
                    i18++;
                    z16 = false;
                    min = i18;
                } else if (z17 || (!z16 && !z18)) {
                    i19--;
                    z16 = true;
                    min = i19;
                }
            } else {
                return min;
            }
        }
        return -1;
    }

    public abstract T f();

    public long g(int i3) {
        T f16 = f();
        if (f16 == null || i3 < 0) {
            return Long.MIN_VALUE;
        }
        return f16.getItemId(i3);
    }

    public int h() {
        return (this.f45900d + getChildCount()) - 1;
    }

    @ViewDebug.CapturedViewProperty
    public long j() {
        return this.I;
    }

    @ViewDebug.CapturedViewProperty
    public int k() {
        return this.H;
    }

    public abstract View l();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m() {
        boolean z16;
        boolean z17;
        int i3 = this.M;
        if (i3 > 0) {
            z16 = true;
            if (this.f45905m) {
                this.f45905m = false;
                int e16 = e();
                if (e16 >= 0 && p(e16, true) == e16) {
                    t(e16);
                    z17 = true;
                    if (!z17) {
                        int k3 = k();
                        if (k3 >= i3) {
                            k3 = i3 - 1;
                        }
                        if (k3 < 0) {
                            k3 = 0;
                        }
                        int p16 = p(k3, true);
                        if (p16 < 0) {
                            p16 = p(k3, false);
                        }
                        if (p16 >= 0) {
                            t(p16);
                            d();
                        }
                    }
                    z16 = z17;
                }
            }
            z17 = false;
            if (!z17) {
            }
            z16 = z17;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.J = -1;
        this.K = Long.MIN_VALUE;
        this.H = -1;
        this.I = Long.MIN_VALUE;
        this.f45905m = false;
        d();
    }

    boolean n() {
        return false;
    }

    public boolean o() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        this.D = getHeight();
    }

    public boolean q(View view, int i3, long j3, MotionEvent motionEvent) {
        if (this.F == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.F.onItemClick(this, view, i3, j3);
        return true;
    }

    void r() {
        if (getChildCount() > 0) {
            this.f45905m = true;
            this.f45904i = this.D;
            int i3 = this.J;
            if (i3 >= 0) {
                View childAt = getChildAt(i3 - this.f45900d);
                this.f45903h = this.I;
                this.f45902f = this.H;
                if (childAt != null) {
                    this.f45901e = childAt.getTop();
                }
                this.C = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T f16 = f();
            int i16 = this.f45900d;
            if (i16 >= 0 && i16 < f16.getCount()) {
                this.f45903h = f16.getItemId(this.f45900d);
            } else {
                this.f45903h = -1L;
            }
            this.f45902f = this.f45900d;
            if (childAt2 != null) {
                this.f45901e = childAt2.getTop();
            }
            this.C = 1;
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i3) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        if (this.J == -1 || !isShown() || isInTouchMode()) {
            return;
        }
        sendAccessibilityEvent(4);
    }

    public abstract void setAdapter(T t16);

    public void setEmptyView(View view) {
        this.L = view;
        T f16 = f();
        v(f16 == null || f16.isEmpty());
    }

    @Override // android.view.View
    public void setFocusable(boolean z16) {
        T f16 = f();
        boolean z17 = true;
        boolean z18 = f16 == null || f16.getCount() == 0;
        this.R = z16;
        if (!z16) {
            this.S = false;
        }
        if (!z16 || (z18 && !n())) {
            z17 = false;
        }
        super.setFocusable(z17);
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z16) {
        T f16 = f();
        boolean z17 = false;
        boolean z18 = f16 == null || f16.getCount() == 0;
        this.S = z16;
        if (z16) {
            this.R = true;
        }
        if (z16 && (!z18 || n())) {
            z17 = true;
        }
        super.setFocusableInTouchMode(z17);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(c cVar) {
        this.F = cVar;
    }

    public abstract void setSelection(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i3) {
        this.H = i3;
        long g16 = g(i3);
        this.I = g16;
        if (this.f45905m && this.C == 0 && i3 >= 0) {
            this.f45902f = i3;
            this.f45903h = g16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i3) {
        this.J = i3;
        this.K = g(i3);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public int i(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException unused) {
            }
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (getChildAt(i3).equals(view)) {
                return this.f45900d + i3;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public ExtendAdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f45900d = 0;
        this.f45903h = Long.MIN_VALUE;
        this.f45905m = false;
        this.E = false;
        this.H = -1;
        this.I = Long.MIN_VALUE;
        this.J = -1;
        this.K = Long.MIN_VALUE;
        this.P = -1;
        this.Q = Long.MIN_VALUE;
    }

    public ExtendAdapterView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f45900d = 0;
        this.f45903h = Long.MIN_VALUE;
        this.f45905m = false;
        this.E = false;
        this.H = -1;
        this.I = Long.MIN_VALUE;
        this.J = -1;
        this.K = Long.MIN_VALUE;
        this.P = -1;
        this.Q = Long.MIN_VALUE;
    }

    int p(int i3, boolean z16) {
        return i3;
    }
}
