package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetMainPageRsp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.constants.QFSNumberConstants;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.e;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class SubscribePersonalDetailFragment extends SubscribeBaseFragment implements SimpleEventReceiver, View.OnClickListener {
    private RelativePersonalDetailHeadItemView M;
    private CertifiedAccountRead$StGetMainPageRsp N;
    private String P;
    private d Q;
    private ImageView R;
    private ImageView S;
    private ImageView T;
    private TextView U;
    private LinearLayout V;
    private long W;
    private long X;
    private e Y;
    private we0.a Z;

    /* renamed from: a0, reason: collision with root package name */
    private BlockContainer f96088a0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountRead$StGetMainPageRsp> {
        b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp) {
            SubscribePersonalDetailFragment.this.bi(z16);
            if (z16) {
                if (certifiedAccountRead$StGetMainPageRsp != null) {
                    hd0.c.k("SubscribePersonalDetail", "sendRequest GetMainPage success");
                    SubscribePersonalDetailFragment.this.N = certifiedAccountRead$StGetMainPageRsp;
                    SubscribePersonalDetailFragment subscribePersonalDetailFragment = SubscribePersonalDetailFragment.this;
                    if (subscribePersonalDetailFragment.C != null && subscribePersonalDetailFragment.N.user != null) {
                        SubscribePersonalDetailFragment subscribePersonalDetailFragment2 = SubscribePersonalDetailFragment.this;
                        subscribePersonalDetailFragment2.C.poster.set(subscribePersonalDetailFragment2.N.user.get());
                    }
                    com.tencent.biz.subscribe.c.d(certifiedAccountRead$StGetMainPageRsp);
                    SubscribePersonalDetailFragment.this.ai(str);
                    SubscribePersonalDetailFragment.this.Zh();
                    SubscribePersonalDetailFragment.this.Z.W(true);
                    if (certifiedAccountRead$StGetMainPageRsp.user.type.get() == 0) {
                        VSReporter.p(certifiedAccountRead$StGetMainPageRsp.user.f24929id.get(), "auth_person", "user_exp", 0, 0, new String[0]);
                    }
                }
                VSReporter.q("subscribe_personal_detail_page_request", VSReporter.e(0L, System.currentTimeMillis() - SubscribePersonalDetailFragment.this.W));
                return;
            }
            hd0.c.k("SubscribePersonalDetail", "sendRequest GetMainPage error");
            if (!TextUtils.isEmpty(str)) {
                str = HardCodeUtil.qqStr(R.string.tx_);
            }
            if (SubscribePersonalDetailFragment.this.getBaseActivity() != null) {
                QQToast.makeText(SubscribePersonalDetailFragment.this.getBaseActivity(), str, 0).show();
            }
            VSReporter.q("subscribe_personal_detail_page_request", VSReporter.e(j3, System.currentTimeMillis() - SubscribePersonalDetailFragment.this.W));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements OnTaskListener<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VSDispatchObserver.OnVSRspCallBack f96091a;

        c(VSDispatchObserver.OnVSRspCallBack onVSRspCallBack) {
            this.f96091a = onVSRspCallBack;
        }

        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
        public void onComplete(Object... objArr) {
            long j3;
            String str;
            CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp;
            if (objArr != null && objArr.length == 4 && this.f96091a != null) {
                boolean z16 = false;
                Object obj = objArr[0];
                Object obj2 = objArr[1];
                Object obj3 = objArr[2];
                Object obj4 = objArr[3];
                if (obj instanceof Boolean) {
                    z16 = ((Boolean) obj).booleanValue();
                }
                boolean z17 = z16;
                if (obj2 instanceof QFSNumberConstants.Long) {
                    j3 = ((Long) obj2).longValue();
                } else {
                    j3 = 0;
                }
                long j16 = j3;
                if (obj3 instanceof String) {
                    str = obj3.toString();
                } else {
                    str = "";
                }
                String str2 = str;
                if (obj4 instanceof CertifiedAccountRead$StGetMainPageRsp) {
                    certifiedAccountRead$StGetMainPageRsp = (CertifiedAccountRead$StGetMainPageRsp) obj4;
                } else {
                    certifiedAccountRead$StGetMainPageRsp = null;
                }
                this.f96091a.onReceive(null, z17, j16, str2, certifiedAccountRead$StGetMainPageRsp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && TextUtils.equals(intent.getAction(), "action_reload_get_main_page")) {
                SubscribePersonalDetailFragment.this.Xh(false);
                SimpleEventBus.getInstance().dispatchEvent(new UserStateUpdateEvent());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean Sh(int i3) {
        char c16;
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser;
        CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp = this.N;
        if (certifiedAccountRead$StGetMainPageRsp != null && (certifiedAccountMeta$StUser = certifiedAccountRead$StGetMainPageRsp.user) != null) {
            String binaryString = Long.toBinaryString(certifiedAccountMeta$StUser.attr.get());
            if (!TextUtils.isEmpty(binaryString) && binaryString.length() > i3) {
                c16 = binaryString.charAt((binaryString.length() - 1) - i3);
                if (c16 != '1') {
                    return true;
                }
                return false;
            }
        }
        c16 = '0';
        if (c16 != '1') {
        }
    }

    private void Th() {
        if (this.f96088a0 != null) {
            a aVar = new a(null);
            this.Z = aVar;
            this.f96088a0.n(aVar);
            e eVar = new e(null);
            this.Y = eVar;
            this.f96088a0.n(eVar);
            this.f96088a0.setEnableRefresh(true);
            this.f96088a0.setEnableLoadMore(false);
            this.f96088a0.setExtraTypeInfo(this.D);
            this.f96088a0.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Uh() {
        return Sh(1);
    }

    private boolean Vh() {
        return Sh(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh(boolean z16) {
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.C;
        if (certifiedAccountMeta$StFeed != null && (certifiedAccountMeta$StUser = certifiedAccountMeta$StFeed.poster) != null) {
            this.P = certifiedAccountMeta$StUser.f24929id.get();
        }
        this.W = System.currentTimeMillis();
        SubscribePersonalDetailRequest subscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.P, null);
        b bVar = new b();
        if (PreLoader.exists("1001" + this.P) && z16) {
            PreLoader.addListener("1001" + this.P, new c(bVar));
            return;
        }
        subscribePersonalDetailRequest.setEnableCache(z16);
        VSNetworkHelper.getInstance().sendRequest(subscribePersonalDetailRequest, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yh(com.tencent.biz.subscribe.part.block.base.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.f()) {
            Xh(true);
        } else if (bVar.i()) {
            Xh(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zh() {
        boolean z16;
        CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp;
        boolean z17 = false;
        if (Vh() && Uh() && (certifiedAccountRead$StGetMainPageRsp = this.N) != null && certifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() > 0) {
            this.R.setVisibility(0);
            VSReporter.n(this.N.user.get().f24929id.get(), "auth_person", "post_exp", 0, 0, "", "");
        } else {
            this.R.setVisibility(8);
        }
        if (this.f96088a0 != null && this.N != null) {
            SubscribeBaseBottomPersonalFragment.a aVar = new SubscribeBaseBottomPersonalFragment.a();
            aVar.f96057d = Wh(this.N);
            if (this.N.isFinish.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.f96055b = z16;
            CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp2 = this.N;
            aVar.f96056c = certifiedAccountRead$StGetMainPageRsp2.extInfo;
            aVar.f96058e = this.C;
            aVar.f96059f = certifiedAccountRead$StGetMainPageRsp2.user.get();
            aVar.f96054a = "share_key_subscribe_opus";
            if (isAdded() && getBaseActivity().app != null) {
                if (SubscribeDraftManager.f().i(getBaseActivity().app.getAccount()) && Uh()) {
                    z17 = true;
                }
                aVar.f96060g = z17;
            }
            aVar.f96061h = this.N;
            aVar.f96062i = this.P;
            e eVar = this.Y;
            if (eVar != null) {
                eVar.f0("share_key_subscribe_opus", new a.d(aVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(String str) {
        RelativePersonalDetailHeadItemView relativePersonalDetailHeadItemView = this.M;
        if (relativePersonalDetailHeadItemView != null) {
            relativePersonalDetailHeadItemView.c(this.N);
            if (!VSNetworkHelper.isProtocolCache(str)) {
                this.M.setCardReport(true);
            }
        }
        CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp = this.N;
        if (certifiedAccountRead$StGetMainPageRsp != null) {
            if (certifiedAccountRead$StGetMainPageRsp.user.type.get() == 1) {
                this.T.setVisibility(0);
                this.S.setVisibility(8);
                return;
            }
            this.T.setVisibility(8);
            if (SubscribeUtils.q(this.N.user.attr.get())) {
                this.S.setVisibility(0);
                VSReporter.p(this.N.user.f24929id.get(), "auth_person", "exp_shoplist", 0, 0, new String[0]);
            } else {
                this.S.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(boolean z16) {
        this.f96088a0.h().u();
        if (!z16 && isAdded()) {
            this.f96088a0.h().x(getResources().getString(R.string.f171701ka4));
        }
    }

    private void ci() {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.titleRoot.setBackgroundColor(getResources().getColor(R.color.f158017al3));
            ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
        }
    }

    private void initView() {
        RelativePersonalDetailHeadItemView relativePersonalDetailHeadItemView = new RelativePersonalDetailHeadItemView(getBaseActivity());
        this.M = relativePersonalDetailHeadItemView;
        relativePersonalDetailHeadItemView.setExtraTypeInfo(this.D);
        this.M.setHostActivity(getBaseActivity());
        this.M.setPostUserData(this.C.poster);
        this.f96088a0 = (BlockContainer) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166789m61);
        ImageView imageView = (ImageView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.m0r);
        this.R = imageView;
        imageView.setOnClickListener(this);
        this.S = (ImageView) this.M.findViewById(R.id.bcu);
        this.T = (ImageView) this.M.findViewById(R.id.dwf);
        this.V = (LinearLayout) this.M.findViewById(R.id.bkz);
        this.U = (TextView) this.M.findViewById(R.id.lo5);
        Th();
        this.S.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.M.findViewById(R.id.du6).setOnClickListener(this);
        if (getBaseActivity() != null) {
            this.Q = new d();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_reload_get_main_page");
            getBaseActivity().registerReceiver(this.Q, intentFilter);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    protected void Bh(View view) {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.C;
        if (certifiedAccountMeta$StFeed != null) {
            certifiedAccountMeta$StFeed.status.set(2);
        }
        ci();
        hideTitleBar();
        initView();
        QZoneHelper.prepareForQQPublicAccountPublishPage();
    }

    protected List<CertifiedAccountMeta$StFeed> Wh(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((CertifiedAccountRead$StGetMainPageRsp) obj).vecFeed.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167703c73;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(SubscribePublishFeedsEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    protected boolean isTransparent() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        boolean z16 = true;
        if (id5 == R.id.m0r) {
            if (!hf0.a.b("subscribe_publish_feed_button", 2000L)) {
                if (!PermissionUtils.isStorePermissionEnable(getBaseActivity())) {
                    DialogUtil.showPermissionDialogForStorage(getBaseActivity());
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("postUin", this.P);
                    CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp = this.N;
                    if (certifiedAccountRead$StGetMainPageRsp != null && certifiedAccountRead$StGetMainPageRsp.user.youZhan.size() > 0) {
                        if (this.N.user.youZhan.get(0).type.get() <= 1) {
                            z16 = false;
                        }
                        intent.putExtra("has_shop", z16);
                    }
                    QZoneHelper.forwardToQQPublicAccountPublishPage(getBaseActivity(), intent, 0);
                    CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp2 = this.N;
                    if (certifiedAccountRead$StGetMainPageRsp2 != null) {
                        VSReporter.n(certifiedAccountRead$StGetMainPageRsp2.user.get().f24929id.get(), "auth_person", "post_clk", 0, 0, "", "");
                    }
                }
            }
        } else if (id5 == R.id.du6) {
            onBackEvent();
        } else if (id5 == R.id.bcu) {
            CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp3 = this.N;
            if (certifiedAccountRead$StGetMainPageRsp3 != null) {
                com.tencent.biz.subscribe.d.l(certifiedAccountRead$StGetMainPageRsp3.user.yzOrderPage.get());
                VSReporter.p(this.N.user.f24929id.get(), "auth_person", "clk_shoplist", 0, 0, new String[0]);
            }
        } else if (id5 == R.id.dwf && this.N != null) {
            ve0.b bVar = new ve0.b();
            bVar.f441506f = !Uh();
            bVar.f441501a = 1;
            if (this.N.vecFeed.get().size() <= 0 || !Uh()) {
                z16 = false;
            }
            bVar.f441507g = z16;
            Eh(bVar);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getBaseActivity() != null && this.Q != null) {
            getBaseActivity().unregisterReceiver(this.Q);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.C;
        if (certifiedAccountMeta$StFeed != null && certifiedAccountMeta$StFeed.poster != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.X;
            VSReporter.n(this.C.poster.f24929id.get(), "auth_person", "exp", 0, 0, "", currentTimeMillis + "");
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        final CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed;
        if (simpleBaseEvent instanceof SubscribePublishFeedsEvent) {
            SubscribePublishFeedsEvent subscribePublishFeedsEvent = (SubscribePublishFeedsEvent) simpleBaseEvent;
            if (subscribePublishFeedsEvent.mState == 1 && (certifiedAccountMeta$StFeed = subscribePublishFeedsEvent.mFeed) != null) {
                getMainHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment.4
                    @Override // java.lang.Runnable
                    public void run() {
                        hd0.c.k("SubscribePersonalDetail", "onReceiveEvent  publishFeed.type.get()" + certifiedAccountMeta$StFeed.type.get());
                        ve0.b bVar = new ve0.b();
                        bVar.f441506f = SubscribePersonalDetailFragment.this.Uh() ^ true;
                        bVar.f441501a = 1;
                        bVar.f441502b = certifiedAccountMeta$StFeed;
                        ExtraTypeInfo extraTypeInfo = new ExtraTypeInfo();
                        extraTypeInfo.pageType = com.tencent.biz.subscribe.d.d(certifiedAccountMeta$StFeed.type.get());
                        hd0.c.k("SubscribePersonalDetail", "onReceiveEvent  publishFeed.share.shortUrl" + certifiedAccountMeta$StFeed.share.shorturl.get());
                        if (!TextUtils.isEmpty(certifiedAccountMeta$StFeed.share.shorturl.get())) {
                            hd0.c.k("SubscribePersonalDetail", "onReceiveEvent  publishFeed.share.shortUrl" + certifiedAccountMeta$StFeed.share.shorturl.get());
                        }
                        bVar.f441505e = extraTypeInfo;
                        bVar.f441504d = certifiedAccountMeta$StFeed.share;
                        new SubscribeQRCodeShareHelper(SubscribePersonalDetailFragment.this.getBaseActivity()).B(bVar);
                    }
                });
            }
        }
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.X = System.currentTimeMillis();
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    protected View th() {
        LinearLayout linearLayout = this.V;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            for (int childCount = this.V.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.V.getChildAt(childCount);
                if (childAt.getVisibility() == 0) {
                    return childAt;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    protected TextView uh() {
        return this.U;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends we0.a {
        a(Bundle bundle) {
            super(bundle);
        }

        @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
        public void U(com.tencent.biz.subscribe.part.block.base.b bVar) {
            if (bVar.f() || bVar.i()) {
                if (SubscribePersonalDetailFragment.this.Y != null && SubscribePersonalDetailFragment.this.Y.j0() == 1) {
                    SimpleEventBus.getInstance().dispatchEvent(new SubDraftChangeEvent());
                }
                SubscribePersonalDetailFragment.this.Yh(bVar);
            }
        }

        @Override // we0.a
        protected BaseWidgetView i0(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
            return SubscribePersonalDetailFragment.this.M;
        }

        @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
        public void a0(Bundle bundle) {
        }
    }
}
