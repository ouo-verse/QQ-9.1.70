package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFeedDetailRsp;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.bizdapters.c;
import com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.widget.SubscribeFollowInfoView;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeMultiPicHeadItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends DetailBaseBlock implements bf0.b {

    /* renamed from: e0, reason: collision with root package name */
    private RelativeMultiPicHeadItemView f95771e0;

    /* renamed from: f0, reason: collision with root package name */
    private long f95772f0;

    /* renamed from: g0, reason: collision with root package name */
    private SubscribeFollowInfoView f95773g0;

    /* renamed from: h0, reason: collision with root package name */
    private View f95774h0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements c.d {
        a() {
        }

        @Override // com.tencent.biz.subscribe.bizdapters.c.d
        public void a(View view, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            b.this.i1(certifiedAccountMeta$StFeed);
        }
    }

    public b(Bundle bundle) {
        super(bundle);
    }

    private boolean g1() {
        if (this.f95771e0.f() != null) {
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = (CertifiedAccountMeta$StFeed) this.f95771e0.f();
            if (certifiedAccountMeta$StFeed.f24925id.get().equals(this.N.f24925id.get()) && certifiedAccountMeta$StFeed.title.get().equals(this.N.title.get()) && certifiedAccountMeta$StFeed.createTime.get() == this.N.createTime.get() && certifiedAccountMeta$StFeed.images.size() == this.N.images.size()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void h1(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        RelativeMultiPicHeadItemView relativeMultiPicHeadItemView = this.f95771e0;
        if (relativeMultiPicHeadItemView != null) {
            relativeMultiPicHeadItemView.setData(certifiedAccountMeta$StFeed);
        }
        SubscribeFollowInfoView subscribeFollowInfoView = this.f95773g0;
        if (subscribeFollowInfoView != null) {
            subscribeFollowInfoView.setData(certifiedAccountMeta$StFeed);
            if (this.f95773g0.getVisibility() == 4) {
                this.f95773g0.setVisibility(0);
            }
        }
        if (J() instanceof SubscribeMultiPicFragment) {
            ((SubscribeMultiPicFragment) J()).Lh(System.currentTimeMillis());
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void Q(MultiViewBlock multiViewBlock, int i3) {
        if (multiViewBlock.O() != null && "RELATIVE_ADAPTER_UNIQUE_KEY".equals(multiViewBlock.O())) {
            ((c) multiViewBlock).N0(new a());
        }
    }

    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock
    protected View S0() {
        if (J() instanceof SubscribeMultiPicFragment) {
            return ((SubscribeMultiPicFragment) J()).Ih();
        }
        return null;
    }

    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock
    protected void T0(CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp, boolean z16) {
        h1(certifiedAccountRead$StGetFeedDetailRsp.feed.get());
        SubscribeFollowInfoView subscribeFollowInfoView = this.f95773g0;
        if (subscribeFollowInfoView != null && subscribeFollowInfoView.getVisibility() == 8) {
            this.f95773g0.setVisibility(0);
        }
        View view = this.f95774h0;
        if (view != null && view.getVisibility() == 8) {
            this.f95774h0.setVisibility(0);
        }
        if (K() != null && (K().getLayoutManager() instanceof StaggeredGridLayoutManager)) {
            ((StaggeredGridLayoutManager) K().getLayoutManager()).scrollToPositionWithOffset(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock
    public void Y0(long j3, String str) {
        super.Y0(j3, str);
        SubscribeFollowInfoView subscribeFollowInfoView = this.f95773g0;
        if (subscribeFollowInfoView != null) {
            subscribeFollowInfoView.setVisibility(8);
        }
        View view = this.f95774h0;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock, com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void a0(Bundle bundle) {
        super.a0(bundle);
    }

    @Override // bf0.b
    public void b() {
        RelativeMultiPicHeadItemView relativeMultiPicHeadItemView = this.f95771e0;
        if (relativeMultiPicHeadItemView != null && relativeMultiPicHeadItemView.u() != null) {
            this.f95771e0.u().setAlpha(1.0f);
        }
    }

    @Override // bf0.b
    public void e() {
        RelativeMultiPicHeadItemView relativeMultiPicHeadItemView = this.f95771e0;
        if (relativeMultiPicHeadItemView != null && relativeMultiPicHeadItemView.u() != null) {
            this.f95771e0.u().setAlpha(1.0f);
        }
    }

    @Override // bf0.b
    public void h() {
        RelativeMultiPicHeadItemView relativeMultiPicHeadItemView = this.f95771e0;
        if (relativeMultiPicHeadItemView != null && relativeMultiPicHeadItemView.u() != null) {
            this.f95771e0.u().setAlpha(0.0f);
        }
    }

    @Override // we0.a
    protected BaseWidgetView i0(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        if (J() instanceof SubscribeMultiPicFragment) {
            SubscribeFollowInfoView subscribeFollowInfoView = new SubscribeFollowInfoView(C());
            this.f95773g0 = subscribeFollowInfoView;
            subscribeFollowInfoView.setExtraTypeInfo(D());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(29.0f));
            layoutParams.leftMargin = ImmersiveUtils.dpToPx(9.0f);
            layoutParams.rightMargin = ImmersiveUtils.dpToPx(15.0f);
            layoutParams.gravity = 16;
            this.f95773g0.setLayoutParams(layoutParams);
            this.f95773g0.setVisibility(4);
            this.f95774h0 = ((SubscribeMultiPicFragment) J()).Jh();
            ((SubscribeMultiPicFragment) J()).Kh().addView(this.f95773g0);
        }
        RelativeMultiPicHeadItemView relativeMultiPicHeadItemView = new RelativeMultiPicHeadItemView(viewGroup.getContext());
        this.f95771e0 = relativeMultiPicHeadItemView;
        com.tencent.biz.subscribe.utils.c cVar = this.T;
        if (cVar != null) {
            cVar.b(relativeMultiPicHeadItemView.u());
        }
        return this.f95771e0;
    }

    public void i1(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (System.currentTimeMillis() - this.f95772f0 < 500) {
            return;
        }
        VSReporter.n(certifiedAccountMeta$StFeed.poster.f24929id.get(), "auth_" + SubscribeShareHelper.s(D()), "clk_recom", 0, 0, "", "", certifiedAccountMeta$StFeed.f24925id.get(), certifiedAccountMeta$StFeed.title.get());
        this.f95772f0 = System.currentTimeMillis();
        if (com.tencent.biz.subscribe.d.e(certifiedAccountMeta$StFeed.type.get())) {
            this.N = certifiedAccountMeta$StFeed;
            this.L.t(certifiedAccountMeta$StFeed);
            f0("share_key_subscribe_feeds_update", new a.d(certifiedAccountMeta$StFeed, true));
        } else {
            com.tencent.biz.subscribe.d.o(y(), certifiedAccountMeta$StFeed);
            if (y() != null) {
                y().finish();
            }
        }
    }

    @Override // bf0.b
    public void m() {
        QLog.d(DetailBaseBlock.f95725c0, 1, "onTransAnimateInit disableLoading!");
        N0();
        RelativeMultiPicHeadItemView relativeMultiPicHeadItemView = this.f95771e0;
        if (relativeMultiPicHeadItemView != null && relativeMultiPicHeadItemView.u() != null) {
            this.f95771e0.u().setAlpha(0.0f);
        }
    }

    @Override // we0.a, android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (!g1()) {
            h1(this.N);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock, com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        RelativeMultiPicHeadItemView relativeMultiPicHeadItemView = this.f95771e0;
        if (relativeMultiPicHeadItemView != null) {
            relativeMultiPicHeadItemView.destroy();
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void U(com.tencent.biz.subscribe.part.block.base.b bVar) {
    }
}
