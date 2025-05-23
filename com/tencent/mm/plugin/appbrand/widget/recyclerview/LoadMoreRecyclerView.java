package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LoadMoreRecyclerView extends com.tencent.luggage.wxa.bm.b {

    /* renamed from: c, reason: collision with root package name */
    public View f152500c;

    /* renamed from: d, reason: collision with root package name */
    public c f152501d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f152502e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        public int f152503a = 0;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinearLayoutManager f152504b;

        public a(LinearLayoutManager linearLayoutManager) {
            this.f152504b = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0 && LoadMoreRecyclerView.this.e() && this.f152503a == LoadMoreRecyclerView.this.f123075a.getItemCount() - 1 && LoadMoreRecyclerView.this.f152501d != null) {
                c cVar = LoadMoreRecyclerView.this.f152501d;
                LoadMoreRecyclerView loadMoreRecyclerView = LoadMoreRecyclerView.this;
                cVar.a(loadMoreRecyclerView, loadMoreRecyclerView.f123075a.b());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            this.f152503a = this.f152504b.findLastVisibleItemPosition();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends RecyclerView.AdapterDataObserver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinearLayoutManager f152506a;

        public b(LinearLayoutManager linearLayoutManager) {
            this.f152506a = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            super.onItemRangeRemoved(i3, i16);
            if (LoadMoreRecyclerView.this.e() && this.f152506a.findLastVisibleItemPosition() == LoadMoreRecyclerView.this.f123075a.getItemCount() - 1 && LoadMoreRecyclerView.this.f152501d != null) {
                c cVar = LoadMoreRecyclerView.this.f152501d;
                LoadMoreRecyclerView loadMoreRecyclerView = LoadMoreRecyclerView.this;
                cVar.a(loadMoreRecyclerView, loadMoreRecyclerView.f123075a.b());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a(LoadMoreRecyclerView loadMoreRecyclerView, RecyclerView.Adapter adapter);
    }

    public LoadMoreRecyclerView(Context context) {
        super(context);
        a();
    }

    @Override // com.tencent.luggage.wxa.bm.b
    public boolean c() {
        if (this.f152500c != null) {
            if (this.f123075a.getItemCount() == 1 && this.f123075a.a() == 1) {
                return true;
            }
            return false;
        }
        return super.c();
    }

    public LinearLayoutManager d() {
        return new LinearLayoutManager(getContext());
    }

    public boolean e() {
        return this.f152502e;
    }

    public void setLoadingView(View view) {
        View view2 = this.f152500c;
        if (view2 == view) {
            return;
        }
        if (view2 != null && !view2.equals(view)) {
            c(this.f152500c);
        }
        this.f152500c = view;
        if (view != null) {
            a(view);
            this.f152500c.setVisibility(this.f152502e ? 0 : 8);
        }
    }

    public void setOnLoadingStateChangedListener(c cVar) {
        this.f152501d = cVar;
    }

    private void a() {
        LinearLayoutManager d16 = d();
        super.setLayoutManager(d16);
        addOnScrollListener(new a(d16));
        this.f123075a.registerAdapterDataObserver(new b(d16));
    }

    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }

    @Override // com.tencent.luggage.wxa.bm.b
    public void a(View view) {
        int a16 = this.f123075a.a() - 1;
        if (this.f152500c != null && a16 >= 0) {
            super.a(a16, view);
        } else {
            super.a(view);
        }
    }

    public void setLoadingView(int i3) {
        setLoadingView(LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) this, false));
    }

    public void a(boolean z16) {
        if (this.f152502e == z16) {
            return;
        }
        this.f152502e = z16;
        View view = this.f152500c;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
    }
}
