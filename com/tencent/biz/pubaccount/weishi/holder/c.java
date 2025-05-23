package com.tencent.biz.pubaccount.weishi.holder;

import UserGrowth.stFeed;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.n;
import com.tencent.mobileqq.R;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends BaseViewHolder<stFeed> {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.f f80793d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f80794e;

    /* renamed from: f, reason: collision with root package name */
    private h10.c f80795f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f80796h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayoutManager f80797i;

    public static c c(ViewGroup viewGroup, com.tencent.biz.pubaccount.weishi.f fVar) {
        return new c(viewGroup, fVar);
    }

    public RecyclerView d() {
        return this.f80794e;
    }

    public void f() {
        LinearLayoutManager linearLayoutManager = this.f80797i;
        if (linearLayoutManager == null || this.f80795f == null) {
            return;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.f80797i.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition >= this.f80795f.getDataList().size()) {
            return;
        }
        while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f80794e.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
            if (findViewHolderForAdapterPosition instanceof h10.d) {
                ((h10.d) findViewHolderForAdapterPosition).o();
            }
            findFirstVisibleItemPosition++;
        }
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void bindData(stFeed stfeed) {
        if (stfeed == null) {
            this.f80796h.setVisibility(8);
            return;
        }
        this.f80796h.setVisibility(0);
        this.f80795f.q(stfeed);
        this.f80795f.fillList(stfeed.person_meta);
    }

    c(ViewGroup viewGroup, com.tencent.biz.pubaccount.weishi.f fVar) {
        super(viewGroup, R.layout.fx7);
        this.f80793d = fVar;
        e();
    }

    private void e() {
        this.f80796h = (LinearLayout) getView(R.id.f165391lk1);
        this.f80794e = (RecyclerView) getView(R.id.f71243nm);
        TextView textView = (TextView) getView(R.id.f125417m0);
        TextView textView2 = (TextView) getView(R.id.f125407lz);
        ImageView imageView = (ImageView) getView(R.id.f125187ld);
        textView2.setVisibility(8);
        imageView.setVisibility(8);
        textView.setText(R.string.f241887t3);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.f80797i = linearLayoutManager;
        this.f80794e.setLayoutManager(linearLayoutManager);
        this.f80794e.setHasFixedSize(true);
        h10.c cVar = new h10.c(getContext(), this.f80793d);
        this.f80795f = cVar;
        this.f80794e.setAdapter(cVar);
        this.f80794e.addItemDecoration(new n());
    }
}
