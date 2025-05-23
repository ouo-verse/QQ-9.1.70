package com.tencent.mobileqq.guild.home.views.sticky;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a extends RecyclerView.ItemDecoration {
    private boolean C = true;
    private ip1.a D;

    /* renamed from: d, reason: collision with root package name */
    private final Function1<Integer, Boolean> f225688d;

    /* renamed from: e, reason: collision with root package name */
    private int f225689e;

    /* renamed from: f, reason: collision with root package name */
    private int f225690f;

    /* renamed from: h, reason: collision with root package name */
    private int[] f225691h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView.Adapter f225692i;

    /* renamed from: m, reason: collision with root package name */
    private StickyHeadContainer f225693m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.home.views.sticky.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C7803a extends RecyclerView.AdapterDataObserver {
        C7803a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            a.this.g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16) {
            a.this.g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            a.this.g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            a.this.g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            a.this.g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16, Object obj) {
            a.this.g();
        }
    }

    public a(StickyHeadContainer stickyHeadContainer, Function1<Integer, Boolean> function1) {
        this.f225693m = stickyHeadContainer;
        this.f225688d = function1;
    }

    private void b(RecyclerView recyclerView) {
        int d16 = d(recyclerView.getLayoutManager());
        this.f225689e = d16;
        int e16 = e(d16);
        if (this.f225690f != e16) {
            this.f225690f = e16;
        }
    }

    private void c(RecyclerView recyclerView) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (this.f225692i != adapter) {
            this.f225692i = adapter;
            this.f225690f = -1;
            adapter.registerAdapterDataObserver(new C7803a());
        }
    }

    private int d(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return 0;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        this.f225691h = iArr;
        staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
        int i3 = Integer.MAX_VALUE;
        for (int i16 : this.f225691h) {
            i3 = Math.min(i16, i3);
        }
        return i3;
    }

    private int e(int i3) {
        if (this.f225692i.getItemCount() == 0) {
            return -1;
        }
        while (i3 >= 0) {
            if (this.f225688d.invoke(Integer.valueOf(i3)).booleanValue()) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    private boolean f(RecyclerView recyclerView, View view) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return false;
        }
        return this.f225688d.invoke(Integer.valueOf(childAdapterPosition)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f225693m.c();
    }

    public void h(ip1.a aVar) {
        this.D = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i3;
        super.onDraw(canvas, recyclerView, state);
        c(recyclerView);
        if (this.f225692i == null) {
            return;
        }
        b(recyclerView);
        if (this.C) {
            int i16 = this.f225689e;
            int i17 = this.f225690f;
            if (i16 >= i17 && i17 != -1) {
                View findChildViewUnder = recyclerView.findChildViewUnder(canvas.getWidth() / 2, this.f225693m.a() + 0.01f);
                this.f225693m.b(this.f225690f);
                if (f(recyclerView, findChildViewUnder) && findChildViewUnder.getTop() > 0) {
                    i3 = findChildViewUnder.getTop() - this.f225693m.a();
                } else {
                    i3 = 0;
                }
                ip1.a aVar = this.D;
                if (aVar != null) {
                    aVar.a(i3);
                    return;
                }
                return;
            }
        }
        ip1.a aVar2 = this.D;
        if (aVar2 != null) {
            aVar2.b();
        }
    }
}
