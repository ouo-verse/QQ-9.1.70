package com.tencent.biz.qqcircle.richframework.widget.looplist;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends LinearLayoutManager {

    /* renamed from: d, reason: collision with root package name */
    private LoopLayoutManagerHelper f92166d;

    /* renamed from: e, reason: collision with root package name */
    private float f92167e;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.richframework.widget.looplist.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0928a extends LinearSmoothScroller {
        C0928a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return a.this.f92167e / displayMetrics.densityDpi;
        }
    }

    public a(Context context, int i3, boolean z16) {
        super(context, i3, z16);
        this.f92167e = 500.0f;
        t(context);
    }

    private void t(Context context) {
        this.f92166d = new LoopLayoutManagerHelper(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.f92166d.l(adapter2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f92166d.m(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onInterceptFocusSearch(View view, int i3) {
        return super.onInterceptFocusSearch(view, i3);
    }

    public int r() {
        return this.f92166d.d();
    }

    public LoopLayoutManagerHelper s() {
        return this.f92166d;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        C0928a c0928a = new C0928a(recyclerView.getContext());
        c0928a.setTargetPosition(i3);
        startSmoothScroll(c0928a);
    }
}
