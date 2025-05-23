package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StEntry;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    protected List<ve0.a> f95668d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.subscribe.account_folder.recommend_banner.a f95669e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f95670f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f95671h;

    /* renamed from: i, reason: collision with root package name */
    protected CertifiedAccountMeta$StEntry f95672i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f95673m = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 == 0 && this.f95672i != null) {
            return 3;
        }
        return p().get(i3 - q()).f441498a;
    }

    public List<ve0.a> p() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int q() {
        if (this.f95672i != null) {
            return 1;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i3) {
        if (aVar != null) {
            View view = aVar.itemView;
            if (view instanceof RecommendBannerEntryItemView) {
                ((RecommendBannerEntryItemView) view).setEntry(this.f95672i);
            } else {
                int q16 = i3 - q();
                View view2 = aVar.itemView;
                if (view2 instanceof RecommendBannerItemView) {
                    RecommendBannerItemView recommendBannerItemView = (RecommendBannerItemView) view2;
                    recommendBannerItemView.setData(p().get(q16).f441499b, q16);
                    recommendBannerItemView.setRecommendBannerFolwListener(this.f95669e);
                } else if (view2 instanceof RecommendBannerFeedItemView) {
                    ((RecommendBannerFeedItemView) view2).setData(p().get(q16).f441500c, q16);
                }
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(aVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        Context context = viewGroup.getContext();
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(x.c(context, 144.0f), x.c(context, 213.0f));
        if (i3 == 3) {
            RecommendBannerEntryItemView recommendBannerEntryItemView = new RecommendBannerEntryItemView(context);
            recommendBannerEntryItemView.setLayoutParams(layoutParams);
            recommendBannerEntryItemView.setIsCloseShadow(this.f95670f);
            recommendBannerEntryItemView.setInNightMode(this.f95671h);
            return new a(recommendBannerEntryItemView);
        }
        if (i3 == 1) {
            RecommendBannerItemView recommendBannerItemView = new RecommendBannerItemView(context);
            recommendBannerItemView.setLayoutParams(layoutParams);
            recommendBannerItemView.setIsCloseShadow(this.f95670f);
            recommendBannerItemView.setInNightMode(this.f95671h);
            recommendBannerItemView.setInNewFolderPage(this.f95673m);
            return new a(recommendBannerItemView);
        }
        if (i3 == 2) {
            RecommendBannerFeedItemView recommendBannerFeedItemView = new RecommendBannerFeedItemView(context);
            recommendBannerFeedItemView.setLayoutParams(layoutParams);
            recommendBannerFeedItemView.setIsCloseShadow(this.f95670f);
            recommendBannerFeedItemView.setInNightMode(this.f95671h);
            return new a(recommendBannerFeedItemView);
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(a aVar) {
        super.onViewAttachedToWindow(aVar);
        int adapterPosition = aVar.getAdapterPosition() - q();
        if (!ArrayUtils.isOutOfArrayIndex(adapterPosition, p()) && p().get(adapterPosition) != null) {
            VSReporter.n(p().get(adapterPosition).f441499b.f24929id.get(), "auth_page", "recom_exp", 0, 0, "", "", String.valueOf(adapterPosition), p().get(adapterPosition).f441499b.nick.get());
        }
    }

    public void u(boolean z16) {
        this.f95670f = z16;
    }

    public void v(CertifiedAccountMeta$StEntry certifiedAccountMeta$StEntry, List<ve0.a> list) {
        throw null;
    }

    public void w(com.tencent.biz.subscribe.account_folder.recommend_banner.a aVar) {
        this.f95669e = aVar;
    }

    public void x(boolean z16) {
        this.f95673m = z16;
    }

    public void y(boolean z16) {
        this.f95671h = z16;
    }
}
