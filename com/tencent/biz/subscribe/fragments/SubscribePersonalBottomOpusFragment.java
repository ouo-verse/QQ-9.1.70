package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetMainPageRsp;
import NS_COMM.COMM;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.c;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import java.util.List;

/* loaded from: classes5.dex */
public class SubscribePersonalBottomOpusFragment extends SubscribeBaseBottomPersonalFragment {
    private com.tencent.biz.subscribe.bizdapters.c G;
    protected ExtraTypeInfo H;

    /* loaded from: classes5.dex */
    class a implements c.d {
        a() {
        }

        @Override // com.tencent.biz.subscribe.bizdapters.c.d
        public void a(View view, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            if (certifiedAccountMeta$StFeed != null) {
                if (certifiedAccountMeta$StFeed.f24925id.get().startsWith("fakeid_")) {
                    QQToast.makeText(SubscribePersonalBottomOpusFragment.this.getBaseActivity(), HardCodeUtil.qqStr(R.string.tx9), 0).show();
                } else if (view instanceof RelativeFeedItemView) {
                    RelativeFeedItemView relativeFeedItemView = (RelativeFeedItemView) view;
                    if (relativeFeedItemView.I != null) {
                        com.tencent.biz.subscribe.d.q(SubscribePersonalBottomOpusFragment.this.getBaseActivity(), certifiedAccountMeta$StFeed, 0, af0.b.k(relativeFeedItemView.I, certifiedAccountMeta$StFeed.cover.width.get(), certifiedAccountMeta$StFeed.cover.height.get()));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    class b implements MultiViewBlock.a<com.tencent.biz.subscribe.bizdapters.c> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class a implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountRead$StGetMainPageRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.biz.subscribe.bizdapters.c f96080a;

            a(com.tencent.biz.subscribe.bizdapters.c cVar) {
                this.f96080a = cVar;
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp) {
                if (z16 && certifiedAccountRead$StGetMainPageRsp != null) {
                    com.tencent.biz.subscribe.bizdapters.c cVar = this.f96080a;
                    List<CertifiedAccountMeta$StFeed> list = certifiedAccountRead$StGetMainPageRsp.vecFeed.get();
                    COMM.StCommonExt stCommonExt = certifiedAccountRead$StGetMainPageRsp.extInfo;
                    boolean z17 = true;
                    if (certifiedAccountRead$StGetMainPageRsp.isFinish.get() != 1) {
                        z17 = false;
                    }
                    cVar.D0(list, stCommonExt, z17);
                }
            }
        }

        b() {
        }

        @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.tencent.biz.subscribe.part.block.base.b bVar, com.tencent.biz.subscribe.bizdapters.c cVar) {
            SubscribeBaseBottomPersonalFragment.a aVar;
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed;
            if (bVar.g() && (aVar = SubscribePersonalBottomOpusFragment.this.E) != null && (certifiedAccountMeta$StFeed = aVar.f96058e) != null) {
                VSNetworkHelper.getInstance().sendRequest(new SubscribePersonalDetailRequest(certifiedAccountMeta$StFeed.poster.f24929id.get(), bVar.c()), new a(cVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SubscribeBaseBottomPersonalFragment.a f96082d;

        c(SubscribeBaseBottomPersonalFragment.a aVar) {
            this.f96082d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(this.f96082d.f96058e.poster.registerCertifiedAccountUrl.get())) {
                com.tencent.biz.subscribe.d.l(this.f96082d.f96058e.poster.registerCertifiedAccountUrl.get());
                VSReporter.p(this.f96082d.f96058e.poster.f24929id.get(), "auth_person", "apply_clk", 0, 0, new String[0]);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SubscribeBaseBottomPersonalFragment.a f96084d;

        d(SubscribeBaseBottomPersonalFragment.a aVar) {
            this.f96084d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.biz.subscribe.d.l("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", this.f96084d.f96058e.poster.f24929id.get()));
            VSReporter.p(this.f96084d.f96058e.poster.f24929id.get(), "auth_person", "sync_qzone", 0, 0, new String[0]);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SubscribeBaseBottomPersonalFragment.a f96086d;

        e(SubscribeBaseBottomPersonalFragment.a aVar) {
            this.f96086d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intent intent = new Intent();
            intent.putExtra("postUin", this.f96086d.f96058e.poster.f24929id.get());
            if (this.f96086d.f96058e.poster.youZhan.size() > 0) {
                boolean z16 = true;
                if (this.f96086d.f96058e.poster.youZhan.get(0).type.get() <= 1) {
                    z16 = false;
                }
                intent.putExtra("has_shop", z16);
            }
            QZoneHelper.forwardToQQPublicAccountPublishPage(SubscribePersonalBottomOpusFragment.this.getBaseActivity(), intent, 0);
            VSReporter.p(this.f96086d.f96058e.poster.f24929id.get(), "auth_person", "blank_post", 0, 0, new String[0]);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void initData() {
        SubscribeBaseBottomPersonalFragment.a aVar = this.E;
        if (aVar != null) {
            List<CertifiedAccountMeta$StFeed> list = aVar.f96057d;
            if (list != null) {
                th(list, aVar.f96056c, aVar.f96055b);
                com.tencent.biz.subscribe.bizdapters.c cVar = this.G;
                if (cVar != null) {
                    cVar.f0("share_key_subscribe_user", new a.d(this.E.f96059f));
                }
            }
            sh(this.E);
        }
    }

    private void sh(SubscribeBaseBottomPersonalFragment.a aVar) {
        List<CertifiedAccountMeta$StFeed> list;
        if (getBaseActivity() == null || this.F == null) {
            return;
        }
        if (aVar != null && ((list = aVar.f96057d) == null || list.size() <= 0)) {
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = aVar.f96058e;
            if (certifiedAccountMeta$StFeed == null) {
                return;
            }
            if (certifiedAccountMeta$StFeed.poster.type.get() == 0) {
                if (SubscribeUtils.k(aVar.f96058e.poster.attr.get(), 6)) {
                    this.F.z(new c(aVar));
                } else {
                    this.F.setHintImageFilePath(SubscribeUtils.j() + "/certified_account_feeds_empty.png");
                    if (SubscribeUtils.k(aVar.f96058e.poster.attr.get(), 1)) {
                        this.F.y(HardCodeUtil.qqStr(R.string.vyj), 13, getResources().getColor(R.color.f157977zw));
                    } else {
                        this.F.y(HardCodeUtil.qqStr(R.string.szs), 13, getResources().getColor(R.color.f157977zw));
                    }
                }
            } else if (SubscribeUtils.k(aVar.f96058e.poster.attr.get(), 1)) {
                this.F.A(new d(aVar), new e(aVar));
            } else {
                this.F.setHintImageFilePath(SubscribeUtils.j() + "/certified_account_feeds_empty.png");
                this.F.y(HardCodeUtil.qqStr(R.string.szs), 13, getResources().getColor(R.color.f157977zw));
            }
            VSReporter.p(aVar.f96058e.poster.f24929id.get(), "auth_person", "blank_exp", 0, 0, new String[0]);
            return;
        }
        this.F.setVisibility(8);
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
    protected void initView() {
        com.tencent.biz.subscribe.bizdapters.c cVar = new com.tencent.biz.subscribe.bizdapters.c(null);
        this.G = cVar;
        cVar.O0(false);
        this.G.r0(true);
        this.G.N0(new a());
        this.G.e0(new b());
        this.D.n(this.G);
        this.D.p();
        initData();
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
    ExtraTypeInfo ph() {
        ExtraTypeInfo extraTypeInfo;
        if (getBaseActivity() != null && getBaseActivity().getIntent() != null) {
            extraTypeInfo = (ExtraTypeInfo) getBaseActivity().getIntent().getSerializableExtra(ExtraTypeInfo.KEY_SUBSCRIBE_INTENT_EXTRA_TYPE_INFO);
        } else {
            extraTypeInfo = null;
        }
        if (extraTypeInfo == null) {
            extraTypeInfo = new ExtraTypeInfo();
        }
        ExtraTypeInfo extraTypeInfo2 = new ExtraTypeInfo(7002, extraTypeInfo.sourceType);
        this.H = extraTypeInfo2;
        return extraTypeInfo2;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
    public void qh(int i3) {
        com.tencent.biz.subscribe.a.a();
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
    public void rh(String str, SubscribeBaseBottomPersonalFragment.a aVar) {
        if ("share_key_subscribe_opus".equals(str)) {
            this.E = aVar;
            initData();
        }
    }

    public void th(List<CertifiedAccountMeta$StFeed> list, COMM.StCommonExt stCommonExt, boolean z16) {
        com.tencent.biz.subscribe.bizdapters.c cVar = this.G;
        if (cVar != null) {
            cVar.P0(list, stCommonExt, z16);
        }
    }
}
