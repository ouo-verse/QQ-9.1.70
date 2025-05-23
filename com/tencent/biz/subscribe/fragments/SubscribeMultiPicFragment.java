package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.CommodityAdapter;
import com.tencent.biz.subscribe.bizdapters.c;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;

/* loaded from: classes5.dex */
public class SubscribeMultiPicFragment extends SubscribeBaseFragment {
    private BlockContainer M;
    private View N;
    private View P;
    private TextView Q;
    private boolean R;
    private LinearLayout S;
    private long T;
    private com.tencent.biz.subscribe.bizdapters.b U;
    private View V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SubscribeMultiPicFragment.this.onBackEvent();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (SubscribeMultiPicFragment.this.U != null) {
                SubscribeMultiPicFragment subscribeMultiPicFragment = SubscribeMultiPicFragment.this;
                subscribeMultiPicFragment.Eh(subscribeMultiPicFragment.U.R0(1));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void Ch() {
        com.tencent.biz.subscribe.bizdapters.b bVar = this.U;
        if (bVar != null && bVar.O0() != null && this.M.d() != null) {
            VSReporter.n(this.U.O0().poster.f24929id.get(), "auth_" + SubscribeShareHelper.s(this.M.d()), k.f247491e, 0, 0, "", String.valueOf(System.currentTimeMillis() - this.T), "", this.U.O0().f24925id.get());
        }
    }

    private void initView() {
        Bundle bundle = new Bundle();
        bundle.putByteArray("bundle_key_subscribe_feed_bytes_array", this.C.toByteArray());
        bundle.putSerializable("bundle_key_feed_extra_type_info", this.D);
        com.tencent.biz.subscribe.bizdapters.b bVar = new com.tencent.biz.subscribe.bizdapters.b(bundle);
        this.U = bVar;
        bVar.c1(SystemBarActivityModule.getSystemBarComp(getBaseActivity()));
        af0.b bVar2 = this.J;
        if (bVar2 != null) {
            bVar2.w(this.U);
        }
        this.M = (BlockContainer) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.lex);
        this.S = (LinearLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.lqm);
        this.N = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ln8);
        this.P = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f165971dy1);
        this.Q = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.lo5);
        this.V = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.lpl);
        this.M.setParentFragment(this);
        this.M.setLayoutManagerType(3, 2);
        this.M.setEnableLoadMore(true);
        this.M.setExtraTypeInfo(this.D);
        this.M.n(this.U);
        this.M.n(new CommodityAdapter(bundle));
        this.M.n(new c(bundle));
        this.N.setOnClickListener(new a());
        this.M.p();
        this.P.setOnClickListener(new b());
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    protected boolean Ah() {
        return true;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    public void Fh(final CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        super.Fh(certifiedAccountMeta$StFeed);
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment.3
            @Override // java.lang.Runnable
            public void run() {
                if (SubscribeMultiPicFragment.this.U != null) {
                    SubscribeMultiPicFragment.this.U.b1(SubscribeMultiPicFragment.this.S, false);
                    SubscribeMultiPicFragment.this.U.M0(certifiedAccountMeta$StFeed);
                }
            }
        });
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, bf0.a
    public int I1() {
        return ImmersiveUtils.dpToPx(50.0f);
    }

    public View Ih() {
        return this.V;
    }

    public View Jh() {
        return this.P;
    }

    public LinearLayout Kh() {
        return this.S;
    }

    public void Lh(long j3) {
        this.T = j3;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    protected void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        hideTitleBar();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167698c71;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return this.R;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        BlockContainer blockContainer = this.M;
        if (blockContainer != null && blockContainer.l()) {
            return true;
        }
        ExtraTypeInfo extraTypeInfo = this.D;
        if (extraTypeInfo != null && extraTypeInfo.sourceType == 9001) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(getBaseActivity(), QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.PUBLIC_ACCOUNT_DISCOVER_PAGE_SCHEMA, QzoneConfig.DEFAULT_PUBLIC_ACCOUNT_DISCOVER_PAGE_SCHEMA), 2016, null, null);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BlockContainer blockContainer = this.M;
        if (blockContainer != null) {
            blockContainer.m();
        }
        TimeAndCountHelper.d().h("subscribe_freshman_interaction_guide");
        TimeAndCountHelper.d().h("subscribe_freshman_share_guide");
        com.tencent.biz.subscribe.bizdapters.b bVar = this.U;
        if (bVar != null) {
            bVar.Z0();
        }
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Ch();
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.T = System.currentTimeMillis();
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    protected View th() {
        return this.P;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    protected TextView uh() {
        return this.Q;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, bf0.a
    public int[] x1(int i3, int i16) {
        float f16 = i16 / i3;
        float f17 = 1.3333334f;
        if (f16 <= 1.3333334f) {
            f17 = f16;
        }
        int screenWidth = (int) (ImmersiveUtils.getScreenWidth() * f17);
        return new int[]{(int) (screenWidth / f16), screenWidth};
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    protected void xh(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        com.tencent.biz.subscribe.bizdapters.b bVar = this.U;
        if (bVar != null) {
            bVar.f1(certifiedAccountMeta$StFeed);
        }
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    protected void Bh(View view) {
    }
}
