package com.tencent.biz.qqcircle.richframework.widget.looplist;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LoopLayoutManagerHelper {

    /* renamed from: a, reason: collision with root package name */
    private RecyclerView.Adapter f92148a;

    /* renamed from: b, reason: collision with root package name */
    private RecyclerView f92149b;

    /* renamed from: c, reason: collision with root package name */
    private b f92150c;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<LinearLayoutManager> f92154g;

    /* renamed from: n, reason: collision with root package name */
    private boolean f92161n;

    /* renamed from: f, reason: collision with root package name */
    private long f92153f = 3000;

    /* renamed from: h, reason: collision with root package name */
    private int f92155h = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f92156i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f92157j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f92158k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f92159l = false;

    /* renamed from: o, reason: collision with root package name */
    private final Runnable f92162o = new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.widget.looplist.LoopLayoutManagerHelper.1
        @Override // java.lang.Runnable
        public void run() {
            LoopLayoutManagerHelper.this.t();
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private a f92151d = new a(this);

    /* renamed from: e, reason: collision with root package name */
    private ViewTouchIntercepter f92152e = new ViewTouchIntercepter(this);

    /* renamed from: m, reason: collision with root package name */
    private boolean f92160m = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ViewTouchIntercepter implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<LoopLayoutManagerHelper> f92163d;

        /* renamed from: e, reason: collision with root package name */
        private Runnable f92164e = new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.widget.looplist.LoopLayoutManagerHelper.ViewTouchIntercepter.1
            @Override // java.lang.Runnable
            public void run() {
                LoopLayoutManagerHelper loopLayoutManagerHelper = (LoopLayoutManagerHelper) ViewTouchIntercepter.this.f92163d.get();
                if (loopLayoutManagerHelper != null) {
                    loopLayoutManagerHelper.s(false);
                    loopLayoutManagerHelper.q();
                }
            }
        };

        ViewTouchIntercepter(LoopLayoutManagerHelper loopLayoutManagerHelper) {
            this.f92163d = new WeakReference<>(loopLayoutManagerHelper);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            LoopLayoutManagerHelper loopLayoutManagerHelper = this.f92163d.get();
            if (loopLayoutManagerHelper != null && view != null) {
                if (!loopLayoutManagerHelper.f()) {
                    loopLayoutManagerHelper.q();
                    return true;
                }
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.removeCallbacks(this.f92164e);
                    loopLayoutManagerHelper.s(true);
                }
                if (action == 3 || action == 1) {
                    view.postDelayed(this.f92164e, 100L);
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<LoopLayoutManagerHelper> f92165d;

        public a(LoopLayoutManagerHelper loopLayoutManagerHelper) {
            this.f92165d = new WeakReference<>(loopLayoutManagerHelper);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            LoopLayoutManagerHelper loopLayoutManagerHelper = this.f92165d.get();
            if (loopLayoutManagerHelper == null || recyclerView == null || loopLayoutManagerHelper.i()) {
                return;
            }
            loopLayoutManagerHelper.o();
        }
    }

    public LoopLayoutManagerHelper(LinearLayoutManager linearLayoutManager) {
        this.f92154g = new WeakReference<>(linearLayoutManager);
    }

    private void p() {
        RecyclerView recyclerView = this.f92149b;
        if (recyclerView == null) {
            return;
        }
        recyclerView.removeCallbacks(this.f92162o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        RecyclerView recyclerView = this.f92149b;
        if (recyclerView != null && this.f92154g != null) {
            recyclerView.smoothScrollToPosition(this.f92155h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z16) {
        this.f92158k = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        RecyclerView recyclerView;
        if (this.f92157j && (recyclerView = this.f92149b) != null && this.f92154g != null) {
            int i3 = this.f92155h + 1;
            this.f92155h = i3;
            recyclerView.smoothScrollToPosition(i3);
        }
    }

    private void u() {
        if (!this.f92157j) {
            return;
        }
        RecyclerView recyclerView = this.f92149b;
        if ((recyclerView == null || recyclerView.getScrollState() != 2) && this.f92161n && this.f92160m) {
            t();
        }
    }

    public int d() {
        b bVar = this.f92150c;
        if (bVar == null) {
            return 0;
        }
        return bVar.j0(this.f92155h);
    }

    public int e(int i3) {
        b bVar = this.f92150c;
        if (bVar == null) {
            return i3;
        }
        return bVar.j0(i3);
    }

    public boolean f() {
        return this.f92159l;
    }

    public boolean g() {
        return this.f92156i;
    }

    public boolean h() {
        return this.f92157j;
    }

    public boolean i() {
        return this.f92158k;
    }

    public void j(int i3) {
        RecyclerView.Adapter adapter = this.f92148a;
        if (adapter != null && this.f92150c != null) {
            adapter.notifyItemChanged(i3);
            this.f92150c.notifyItemChanged(i3);
        }
    }

    public void k(int i3) {
        RecyclerView.Adapter adapter = this.f92148a;
        if (adapter != null && this.f92150c != null) {
            adapter.notifyItemInserted(i3);
            this.f92150c.notifyItemInserted(i3);
        }
    }

    public void l(RecyclerView.Adapter adapter) {
        if (this.f92160m && adapter == this.f92150c) {
            return;
        }
        this.f92160m = true;
        this.f92148a = adapter;
        this.f92150c = new b(this, adapter);
        RecyclerView recyclerView = this.f92149b;
        if (recyclerView != null) {
            RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
            b bVar = this.f92150c;
            if (adapter2 != bVar) {
                this.f92149b.setAdapter(bVar);
            }
        }
        u();
    }

    public void m(RecyclerView recyclerView) {
        this.f92161n = true;
        this.f92149b = recyclerView;
        recyclerView.addOnScrollListener(this.f92151d);
        this.f92149b.setOnTouchListener(this.f92152e);
        if (this.f92160m) {
            RecyclerView.Adapter adapter = this.f92149b.getAdapter();
            b bVar = this.f92150c;
            if (adapter != bVar) {
                this.f92149b.setAdapter(bVar);
            }
        }
        u();
    }

    public void n() {
        this.f92157j = true;
        u();
    }

    public void o() {
        RecyclerView recyclerView = this.f92149b;
        if (recyclerView == null) {
            return;
        }
        recyclerView.removeCallbacks(this.f92162o);
        this.f92149b.postDelayed(this.f92162o, this.f92153f);
    }

    public void r(int i3) {
        RecyclerView recyclerView = this.f92149b;
        if (recyclerView == null) {
            return;
        }
        recyclerView.scrollToPosition(i3);
        this.f92155h = i3;
    }

    public void v() {
        this.f92157j = false;
        p();
        r(e(this.f92155h));
    }
}
