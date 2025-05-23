package com.tencent.now.linkpkanchorplay.recommendlist.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.now.app.common.widget.recyclerview.CommonRecyclerView;
import g55.z;
import xm3.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RecommendAnchorListView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private CommonRecyclerView f338428d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.now.linkpkanchorplay.recommendlist.widget.a f338429e;

    /* renamed from: f, reason: collision with root package name */
    private xm3.b f338430f;

    /* renamed from: h, reason: collision with root package name */
    private int f338431h;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            if (RecommendAnchorListView.this.f338429e.getItemCount() > 0 && RecommendAnchorListView.this.f338428d.computeVerticalScrollExtent() + RecommendAnchorListView.this.f338428d.computeVerticalScrollOffset() >= RecommendAnchorListView.this.f338428d.computeVerticalScrollRange()) {
                RecommendAnchorListView.this.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements b.a {
        b() {
        }

        @Override // xm3.b.a
        public void a(z zVar) {
            e55.a[] aVarArr;
            com.tencent.now.linkpkanchorplay.recommendlist.widget.a aVar = RecommendAnchorListView.this.f338429e;
            if (zVar == null) {
                aVarArr = null;
            } else {
                aVarArr = zVar.f401404a;
            }
            aVar.x0(aVarArr);
        }
    }

    public RecommendAnchorListView(@NonNull Context context) {
        super(context);
        this.f338428d = null;
        this.f338429e = null;
        this.f338430f = null;
        this.f338431h = 3;
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f338430f == null) {
            xm3.b bVar = new xm3.b();
            this.f338430f = bVar;
            bVar.b();
        }
        this.f338430f.d(new b());
    }

    public void d(View view) {
        this.f338428d.C(view);
    }

    protected int e() {
        return R.layout.ffa;
    }

    public void f() {
        this.f338429e = new com.tencent.now.linkpkanchorplay.recommendlist.widget.a(getContext());
        this.f338428d.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f338428d.setAdapter(this.f338429e);
        h();
        this.f338428d.addOnScrollListener(new a());
    }

    public void g() {
        this.f338428d = (CommonRecyclerView) LayoutInflater.from(getContext()).inflate(e(), (ViewGroup) this, true).findViewById(R.id.f71433o5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xm3.b bVar = this.f338430f;
        if (bVar != null) {
            bVar.e();
            this.f338430f = null;
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i3) {
        super.onWindowSystemUiVisibilityChanged(i3);
    }

    public void setEmptyView(int i3) {
        this.f338429e.q0(i3);
    }

    public void setRecommendInviteType(int i3) {
        this.f338431h = i3;
        this.f338429e.y0(i3);
    }

    public void setSource(int i3) {
        this.f338429e.z0(i3);
    }

    public RecommendAnchorListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f338428d = null;
        this.f338429e = null;
        this.f338430f = null;
        this.f338431h = 3;
        g();
    }

    public RecommendAnchorListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338428d = null;
        this.f338429e = null;
        this.f338430f = null;
        this.f338431h = 3;
        g();
    }
}
