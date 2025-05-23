package com.tencent.mobileqq.guild.widget.qqui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class AdapterView<T extends Adapter> extends ViewGroup {

    @ViewDebug.ExportedProperty(category = "list")
    int C;
    long D;

    @ViewDebug.ExportedProperty(category = "list")
    protected int E;
    long F;
    private View G;

    @ViewDebug.ExportedProperty(category = "list")
    protected int H;
    protected int I;
    long J;
    private boolean K;
    private boolean L;
    private AdapterView<T>.SelectionNotifier M;
    boolean N;

    /* renamed from: d, reason: collision with root package name */
    @ViewDebug.ExportedProperty(category = "scrolling")
    public int f236445d;

    /* renamed from: e, reason: collision with root package name */
    long f236446e;

    /* renamed from: f, reason: collision with root package name */
    boolean f236447f;

    /* renamed from: h, reason: collision with root package name */
    int f236448h;

    /* renamed from: i, reason: collision with root package name */
    boolean f236449i;

    /* renamed from: m, reason: collision with root package name */
    boolean f236450m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private class SelectionNotifier implements Runnable {
        final /* synthetic */ AdapterView this$0;

        @Override // java.lang.Runnable
        public void run() {
            AdapterView adapterView = this.this$0;
            if (!adapterView.f236450m) {
                adapterView.b();
            } else if (adapterView.c() != null) {
                this.this$0.post(this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface c {
    }

    public AdapterView(Context context) {
        super(context);
        this.f236445d = 0;
        this.f236446e = Long.MIN_VALUE;
        this.f236447f = false;
        this.f236449i = false;
        this.C = -1;
        this.D = Long.MIN_VALUE;
        this.E = -1;
        this.F = Long.MIN_VALUE;
        this.I = -1;
        this.J = Long.MIN_VALUE;
        this.N = false;
    }

    private boolean j() {
        int count;
        T c16 = c();
        if (c16 == null || (count = c16.getCount()) <= 0) {
            return false;
        }
        if (e() <= 0 && f() >= count - 1) {
            return false;
        }
        return true;
    }

    private void k(boolean z16) {
        if (i()) {
            z16 = false;
        }
        if (z16) {
            View view = this.G;
            if (view != null) {
                view.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.f236450m) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        View view2 = this.G;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public abstract T c();

    @Override // android.view.ViewGroup
    protected boolean canAnimate() {
        if (super.canAnimate() && this.H > 0) {
            return true;
        }
        return false;
    }

    @ViewDebug.CapturedViewProperty
    public int d() {
        return this.H;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View h16 = h();
        if (h16 != null && h16.getVisibility() == 0 && h16.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public int e() {
        return this.f236445d;
    }

    public int f() {
        return (this.f236445d + getChildCount()) - 1;
    }

    @ViewDebug.CapturedViewProperty
    public int g() {
        return this.C;
    }

    public abstract View h();

    boolean i() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.M);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setScrollable(j());
        View h16 = h();
        if (h16 != null) {
            accessibilityEvent.setEnabled(h16.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(g());
        accessibilityEvent.setFromIndex(e());
        accessibilityEvent.setToIndex(f());
        accessibilityEvent.setItemCount(d());
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        try {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        accessibilityNodeInfo.setScrollable(j());
        View h16 = h();
        if (h16 != null) {
            accessibilityNodeInfo.setEnabled(h16.isEnabled());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        this.f236448h = getHeight();
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"NewApi"})
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        try {
            if (super.onRequestSendAccessibilityEvent(view, accessibilityEvent)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                onInitializeAccessibilityEvent(obtain);
                view.dispatchPopulateAccessibilityEvent(obtain);
                accessibilityEvent.appendRecord(obtain);
                return true;
            }
        } catch (Exception e16) {
            QLog.e("AdapterView", 1, e16, new Object[0]);
        }
        return false;
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

    public abstract void setAdapter(T t16);

    public void setEmptyView(View view) {
        boolean z16;
        this.G = view;
        T c16 = c();
        if (c16 != null && !c16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        k(z16);
    }

    @Override // android.view.View
    public void setFocusable(boolean z16) {
        boolean z17;
        T c16 = c();
        boolean z18 = true;
        if (c16 != null && c16.getCount() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.K = z16;
        if (!z16) {
            this.L = false;
        }
        if (!z16 || (z17 && !i())) {
            z18 = false;
        }
        super.setFocusable(z18);
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z16) {
        boolean z17;
        T c16 = c();
        boolean z18 = false;
        if (c16 != null && c16.getCount() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.L = z16;
        if (z16) {
            this.K = true;
        }
        if (z16 && (!z17 || i())) {
            z18 = true;
        }
        super.setFocusableInTouchMode(z18);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemLongClickListener(b bVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
    }

    public abstract void setSelection(int i3);

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public AdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f236445d = 0;
        this.f236446e = Long.MIN_VALUE;
        this.f236447f = false;
        this.f236449i = false;
        this.C = -1;
        this.D = Long.MIN_VALUE;
        this.E = -1;
        this.F = Long.MIN_VALUE;
        this.I = -1;
        this.J = Long.MIN_VALUE;
        this.N = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
    }

    public void setOnItemClickListener(a aVar) {
    }

    public void setOnItemSelectedListener(c cVar) {
    }

    public AdapterView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236445d = 0;
        this.f236446e = Long.MIN_VALUE;
        this.f236447f = false;
        this.f236449i = false;
        this.C = -1;
        this.D = Long.MIN_VALUE;
        this.E = -1;
        this.F = Long.MIN_VALUE;
        this.I = -1;
        this.J = Long.MIN_VALUE;
        this.N = false;
    }
}
