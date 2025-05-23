package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StEntry;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.account_folder.recommend_banner.b;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TopRecommendBannerAdapter extends b {
    private List<ve0.a> C = new ArrayList();
    private boolean D;
    private RecyclerView E;

    public TopRecommendBannerAdapter(@NotNull RecyclerView recyclerView) {
        this.E = recyclerView;
    }

    private void C() {
        RecyclerView recyclerView = this.E;
        if (recyclerView != null) {
            if (recyclerView.isComputingLayout()) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.subscribe.account_folder.recommend_banner.TopRecommendBannerAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TopRecommendBannerAdapter.this.notifyDataSetChanged();
                    }
                }, 500L);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    private void D() {
        this.C.clear();
        this.C.addAll(this.f95668d.subList(0, 10));
        List<ve0.a> list = this.f95668d;
        this.f95668d = list.subList(10, list.size());
    }

    public boolean A() {
        List<ve0.a> list;
        if (this.D && (list = this.f95668d) != null && list.size() < 10) {
            return true;
        }
        return false;
    }

    public boolean B() {
        List<ve0.a> list = this.f95668d;
        if (list != null && list.size() >= 10) {
            D();
            C();
            return true;
        }
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ve0.a> list = this.C;
        if (list != null) {
            return list.size() + q();
        }
        return q();
    }

    @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.b, android.support.v7.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ int getItemViewType(int i3) {
        return super.getItemViewType(i3);
    }

    @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.b
    public List<ve0.a> p() {
        return this.C;
    }

    @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.b
    /* renamed from: r */
    public /* bridge */ /* synthetic */ void onBindViewHolder(b.a aVar, int i3) {
        super.onBindViewHolder(aVar, i3);
        EventCollector.getInstance().onRecyclerBindViewHolder(aVar, i3, getItemId(i3));
    }

    public void remove(int i3) {
        if (i3 < this.C.size()) {
            this.C.remove(i3);
            notifyItemRemoved(q() + i3);
            notifyItemRangeChanged(q() + i3, this.C.size() - i3);
        }
    }

    @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.b
    /* renamed from: s */
    public /* bridge */ /* synthetic */ b.a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return super.onCreateViewHolder(viewGroup, i3);
    }

    @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.b
    /* renamed from: t */
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(b.a aVar) {
        super.onViewAttachedToWindow(aVar);
    }

    @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.b
    public /* bridge */ /* synthetic */ void u(boolean z16) {
        super.u(z16);
    }

    @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.b
    public void v(CertifiedAccountMeta$StEntry certifiedAccountMeta$StEntry, List<ve0.a> list) {
        this.f95672i = certifiedAccountMeta$StEntry;
        List<ve0.a> list2 = this.f95668d;
        if (list2 != null) {
            list2.addAll(list);
        } else {
            this.f95668d = list;
        }
        List<ve0.a> list3 = this.f95668d;
        if (list3 != null) {
            if (list3.size() >= 10) {
                D();
                C();
            } else {
                this.C.addAll(list);
                this.f95668d.clear();
                C();
            }
        }
    }

    @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.b
    public /* bridge */ /* synthetic */ void w(a aVar) {
        super.w(aVar);
    }

    @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.b
    public /* bridge */ /* synthetic */ void x(boolean z16) {
        super.x(z16);
    }

    @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.b
    public /* bridge */ /* synthetic */ void y(boolean z16) {
        super.y(z16);
    }

    public boolean z() {
        List<ve0.a> list = this.f95668d;
        if (list == null || list.size() <= 0) {
            return false;
        }
        this.C.add(this.f95668d.remove(0));
        notifyItemInserted(this.C.size());
        return true;
    }
}
