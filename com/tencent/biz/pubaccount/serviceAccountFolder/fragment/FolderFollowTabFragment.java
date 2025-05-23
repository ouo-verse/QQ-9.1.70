package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$GetPortalRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$GetSubscriptionReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$GetSubscriptionRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFollowFeedsRsp;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderNTManager;
import com.tencent.biz.pubaccount.util.k;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter;
import com.tencent.biz.subscribe.network.SubscribeGetFollowFeedsRequest;
import com.tencent.biz.subscribe.network.SubscribeGetQCircleFeedListRequest;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vip.n;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import cooperation.qzone.mobilereport.MobileReportManager;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class FolderFollowTabFragment extends FolderBaseTabFragment implements DragFrameLayout.b {

    /* renamed from: a0, reason: collision with root package name */
    public static String f79969a0 = "FolderFollowTabFragment";

    /* renamed from: b0, reason: collision with root package name */
    public static String f79970b0 = "";
    private Activity I;
    private BlockContainer J;
    private ServiceFolderFollowPBHeadView K;
    private QQAppInterface L;
    private DragFrameLayout M;
    private boolean N;
    private ExtraTypeInfo P;
    private RelativeLiveFeedsAdapter Q;
    private com.tencent.biz.subscribe.bizdapters.a R;
    private g T;
    private ViewPager U;
    private LinearLayout V;
    private TextView W;
    private LinearLayout X;
    public TextView Y;
    private boolean S = true;
    private ServiceAccountFolderNTManager.a Z = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements ServiceAccountFolderNTManager.a {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderNTManager.a
        public void a(@Nullable List<RecentContactInfo> list) {
            FolderFollowTabFragment.this.Vh(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(FolderFollowTabFragment.f79970b0)) {
                Intent intent = new Intent(FolderFollowTabFragment.this.I, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", FolderFollowTabFragment.f79970b0);
                FolderFollowTabFragment.this.I.startActivity(intent);
                MobileReportManager.getInstance().reportActionLive("", "25", "qq_live", "tab_page", "bottom_button", 102, 1, System.currentTimeMillis(), "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements MultiViewBlock.a<RelativeLiveFeedsAdapter> {
        c() {
        }

        @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.tencent.biz.subscribe.part.block.base.b bVar, RelativeLiveFeedsAdapter relativeLiveFeedsAdapter) {
            if (bVar.g()) {
                FolderFollowTabFragment.this.Hh(relativeLiveFeedsAdapter);
                FolderFollowTabFragment.this.Ih(relativeLiveFeedsAdapter);
            } else if (bVar.i() || bVar.f()) {
                FolderFollowTabFragment.this.Mh(relativeLiveFeedsAdapter);
                FolderFollowTabFragment.this.Oh(relativeLiveFeedsAdapter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountRead$StGetFollowFeedsRsp> {
        e() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountRead$StGetFollowFeedsRsp certifiedAccountRead$StGetFollowFeedsRsp) {
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
            if (z16 && j3 == 0 && certifiedAccountRead$StGetFollowFeedsRsp != null) {
                if (FolderFollowTabFragment.this.K != null && !isProtocolCache && certifiedAccountRead$StGetFollowFeedsRsp.messStatus.get() != null) {
                    FolderFollowTabFragment.this.K.y(certifiedAccountRead$StGetFollowFeedsRsp.messStatus.noticeCount.get());
                    FolderFollowTabFragment.this.K.setJumpWebMessageListUrl(certifiedAccountRead$StGetFollowFeedsRsp.messStatus.jumpURL.get());
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                QQToast.makeText(FolderFollowTabFragment.this.I, 1, str, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountRead$StGetFollowFeedsRsp> {
        f() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountRead$StGetFollowFeedsRsp certifiedAccountRead$StGetFollowFeedsRsp) {
            if (z16 && j3 == 0 && certifiedAccountRead$StGetFollowFeedsRsp != null && certifiedAccountRead$StGetFollowFeedsRsp.messStatus.get() != null) {
                FolderFollowTabFragment.this.Uh(certifiedAccountRead$StGetFollowFeedsRsp.messStatus.noticeCount.get());
                FolderFollowTabFragment.this.Qh(certifiedAccountRead$StGetFollowFeedsRsp.messStatus.jumpURL.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g extends BroadcastReceiver {
        g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && TextUtils.equals(intent.getAction(), "action_refresh_return_page") && FolderFollowTabFragment.this.Q != null) {
                FolderFollowTabFragment folderFollowTabFragment = FolderFollowTabFragment.this;
                folderFollowTabFragment.Mh(folderFollowTabFragment.Q);
                FolderFollowTabFragment folderFollowTabFragment2 = FolderFollowTabFragment.this;
                folderFollowTabFragment2.Oh(folderFollowTabFragment2.Q);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(boolean z16, Object obj, RelativeLiveFeedsAdapter relativeLiveFeedsAdapter) {
        if (this.K != null && z16 && (obj instanceof CertifiedAccountRead$GetSubscriptionRsp)) {
            QLog.d(f79969a0, 2, "isSuccess:" + z16 + " addFeedsData:");
            CertifiedAccountRead$GetSubscriptionRsp certifiedAccountRead$GetSubscriptionRsp = (CertifiedAccountRead$GetSubscriptionRsp) obj;
            List<CertifiedAccountRead$GetPortalRsp.RoomLstItem> list = certifiedAccountRead$GetSubscriptionRsp.room_lst.get();
            CertifiedAccountRead$GetSubscriptionRsp.Bottom bottom = certifiedAccountRead$GetSubscriptionRsp.bottom.get();
            String str = certifiedAccountRead$GetSubscriptionRsp.page_info.get();
            relativeLiveFeedsAdapter.H().n(str);
            if (list != null && list.size() > 0) {
                relativeLiveFeedsAdapter.q0(list, bottom, str);
            } else {
                relativeLiveFeedsAdapter.W(false);
            }
        }
    }

    private void Fh() {
        a aVar = new a();
        this.Z = aVar;
        ServiceAccountFolderNTManager serviceAccountFolderNTManager = ServiceAccountFolderNTManager.f79965a;
        serviceAccountFolderNTManager.c(aVar);
        serviceAccountFolderNTManager.d();
        k.a("SERVICE_FOLDER_COST", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        QLog.i("SCF-" + f79969a0, 1, "[requestQCircleData] isSuccess=" + z16 + ",retCode=" + j3 + ",errMsg=" + str + ",traceId=" + baseRequest.getTraceId());
        Jh(true);
        ServiceFolderFollowPBHeadView serviceFolderFollowPBHeadView = this.K;
        if (serviceFolderFollowPBHeadView == null) {
            QLog.e(f79969a0, 1, "[requestQCircleData] mHeadView is null");
            return;
        }
        if (z16 && j3 == 0 && feedCloudRead$StGetFeedListRsp != null) {
            serviceFolderFollowPBHeadView.setQCircleData(feedCloudRead$StGetFeedListRsp);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            QQToast.makeText(this.I, 1, str, 0).show();
        }
        this.K.setQCircleData(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(RelativeLiveFeedsAdapter relativeLiveFeedsAdapter) {
        VSNetworkHelper.getInstance().sendRequest(new SubscribeGetFollowFeedsRequest(relativeLiveFeedsAdapter.H().c(), relativeLiveFeedsAdapter.H().d()), new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih(final RelativeLiveFeedsAdapter relativeLiveFeedsAdapter) {
        CertifiedAccountRead$GetSubscriptionReq certifiedAccountRead$GetSubscriptionReq = new CertifiedAccountRead$GetSubscriptionReq();
        if (!TextUtils.isEmpty(this.L.getCurrentUin())) {
            certifiedAccountRead$GetSubscriptionReq.uin.set(Long.valueOf(this.L.getCurrentUin()).longValue());
        }
        if (!TextUtils.isEmpty(relativeLiveFeedsAdapter.H().d())) {
            certifiedAccountRead$GetSubscriptionReq.page_info.set(relativeLiveFeedsAdapter.H().d());
        }
        certifiedAccountRead$GetSubscriptionReq.page_id.set(1);
        n.request("QQLive.GetSubscriptionData", certifiedAccountRead$GetSubscriptionReq, CertifiedAccountRead$GetSubscriptionRsp.class, new BusinessObserver() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.6
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, final boolean z16, final Object obj) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        FolderFollowTabFragment.this.Dh(z16, obj, relativeLiveFeedsAdapter);
                    }
                });
            }
        });
    }

    private void Jh(boolean z16) {
        this.J.setRefreshing(false);
        com.tencent.biz.subscribe.part.block.a c16 = this.J.c();
        if (c16 != null) {
            c16.I(true, z16);
        }
    }

    private void Kh() {
        this.V = (LinearLayout) this.C.findViewById(R.id.tif);
        this.W = (TextView) this.C.findViewById(R.id.f94605cq);
        this.X = (LinearLayout) this.C.findViewById(R.id.tig);
        this.W.setText("\u53d1\u73b0\u66f4\u591a\u7cbe\u5f69\u5185\u5bb9");
        this.W.getPaint().setShader(new LinearGradient(0.0f, 0.0f, this.W.getPaint().getTextSize() * this.W.getText().length(), 0.0f, Color.parseColor("#FFC235"), Color.parseColor("#FF00CE"), Shader.TileMode.CLAMP));
        this.V.setOnClickListener(new b());
    }

    private void Lh() {
        BlockContainer blockContainer = (BlockContainer) this.C.findViewById(R.id.m8f);
        this.J = blockContainer;
        blockContainer.setParentFragment(this);
        this.J.setLayoutManagerType(3, 2);
        this.J.setEnableLoadMore(true);
        ServiceFolderFollowPBHeadView serviceFolderFollowPBHeadView = new ServiceFolderFollowPBHeadView(getBaseActivity());
        this.K = serviceFolderFollowPBHeadView;
        serviceFolderFollowPBHeadView.setDragHost(this.M);
        this.K.setmFolderViewPager(this.U);
        RelativeLiveFeedsAdapter relativeLiveFeedsAdapter = new RelativeLiveFeedsAdapter(null);
        this.Q = relativeLiveFeedsAdapter;
        relativeLiveFeedsAdapter.y0(this.N);
        this.Q.z0(false);
        this.Q.e0(new c());
        this.Q.w0(0);
        com.tencent.biz.subscribe.bizdapters.a aVar = new com.tencent.biz.subscribe.bizdapters.a(null);
        this.R = aVar;
        aVar.l0(this.N);
        this.J.n(new d(null));
        this.J.n(this.Q);
        this.J.setExtraTypeInfo(this.P);
        this.J.setEnableRefresh(true);
        this.J.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh(RelativeLiveFeedsAdapter relativeLiveFeedsAdapter) {
        SubscribeGetFollowFeedsRequest subscribeGetFollowFeedsRequest = new SubscribeGetFollowFeedsRequest(null);
        subscribeGetFollowFeedsRequest.setEnableCache(true);
        this.S = true;
        VSNetworkHelper.getInstance().sendRequest(subscribeGetFollowFeedsRequest, new e());
        if (py.a.a()) {
            Ph();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh(boolean z16, Object obj, RelativeLiveFeedsAdapter relativeLiveFeedsAdapter) {
        if (this.K != null && z16 && (obj instanceof CertifiedAccountRead$GetSubscriptionRsp)) {
            QLog.d(f79969a0, 2, "isSuccess:" + z16 + " setAddonRsp:");
            CertifiedAccountRead$GetSubscriptionRsp certifiedAccountRead$GetSubscriptionRsp = (CertifiedAccountRead$GetSubscriptionRsp) obj;
            List<CertifiedAccountRead$GetPortalRsp.RoomLstItem> list = certifiedAccountRead$GetSubscriptionRsp.room_lst.get();
            CertifiedAccountRead$GetSubscriptionRsp.Bottom bottom = certifiedAccountRead$GetSubscriptionRsp.bottom.get();
            String str = certifiedAccountRead$GetSubscriptionRsp.page_info.get();
            relativeLiveFeedsAdapter.H().n(str);
            TextView textView = this.Y;
            if (textView != null) {
                textView.setVisibility(8);
            }
            Sh(relativeLiveFeedsAdapter, list, bottom, str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(final RelativeLiveFeedsAdapter relativeLiveFeedsAdapter) {
        CertifiedAccountRead$GetSubscriptionReq certifiedAccountRead$GetSubscriptionReq = new CertifiedAccountRead$GetSubscriptionReq();
        if (!TextUtils.isEmpty(this.L.getCurrentUin())) {
            certifiedAccountRead$GetSubscriptionReq.uin.set(Long.valueOf(this.L.getCurrentUin()).longValue());
        }
        if (!TextUtils.isEmpty(relativeLiveFeedsAdapter.H().d())) {
            certifiedAccountRead$GetSubscriptionReq.page_info.set("");
        }
        certifiedAccountRead$GetSubscriptionReq.page_id.set(1);
        n.request("QQLive.GetSubscriptionData", certifiedAccountRead$GetSubscriptionReq, CertifiedAccountRead$GetSubscriptionRsp.class, new BusinessObserver() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.5
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, final boolean z16, final Object obj) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        FolderFollowTabFragment.this.Nh(z16, obj, relativeLiveFeedsAdapter);
                    }
                });
            }
        });
    }

    private void Ph() {
        SubscribeGetQCircleFeedListRequest subscribeGetQCircleFeedListRequest = new SubscribeGetQCircleFeedListRequest(45);
        subscribeGetQCircleFeedListRequest.setEnableCache(false);
        VSNetworkHelper.getInstance().sendRequest(subscribeGetQCircleFeedListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.fragment.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                FolderFollowTabFragment.this.Gh(baseRequest, z16, j3, str, (FeedCloudRead$StGetFeedListRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh(String str) {
        ServiceFolderFollowPBHeadView serviceFolderFollowPBHeadView = this.K;
        if (serviceFolderFollowPBHeadView != null) {
            serviceFolderFollowPBHeadView.setJumpWebMessageListUrl(str);
        }
    }

    private void Sh(RelativeLiveFeedsAdapter relativeLiveFeedsAdapter, List<CertifiedAccountRead$GetPortalRsp.RoomLstItem> list, CertifiedAccountRead$GetSubscriptionRsp.Bottom bottom, String str, boolean z16) {
        if (list != null && list.size() > 0) {
            List<CertifiedAccountRead$GetPortalRsp.RoomItem> list2 = list.get(0).room_lst.get();
            if (list2 != null && list2.size() == 0) {
                this.K.x(true, list.get(0).tab_info.name.get());
            } else {
                this.K.x(false, null);
            }
            z16 = relativeLiveFeedsAdapter.v0(z16, list);
            relativeLiveFeedsAdapter.A0(list, bottom, str);
        } else {
            relativeLiveFeedsAdapter.q();
            this.K.x(true, null);
        }
        if (bottom != null && z16) {
            Th(z16, bottom.desc.get(), bottom.jump_url.get());
        } else {
            Th(false, null, null);
        }
    }

    private void Th(boolean z16, String str, String str2) {
        LinearLayout linearLayout = this.V;
        if (linearLayout != null && this.X != null && this.W != null) {
            linearLayout.setVisibility(8);
            this.X.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh(final List<RecentContactInfo> list) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.9
            @Override // java.lang.Runnable
            public void run() {
                if (list.isEmpty()) {
                    if (FolderFollowTabFragment.this.K != null) {
                        FolderFollowTabFragment.this.K.setTopBannerVisibility(false);
                    }
                } else if (FolderFollowTabFragment.this.K != null) {
                    FolderFollowTabFragment.this.K.setTopBannerVisibility(true);
                    FolderFollowTabFragment.this.K.setData(list);
                }
            }
        });
    }

    private void initView() {
        DragFrameLayout e16 = DragFrameLayout.e(getBaseActivity());
        this.M = e16;
        e16.addOnDragModeChangeListener(this, false);
        Lh();
        if (getBaseActivity() != null) {
            this.T = new g();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_refresh_return_page");
            getBaseActivity().registerReceiver(this.T, intentFilter);
        }
        this.Y = (TextView) this.C.findViewById(R.id.uwx);
        Kh();
    }

    public int Eh() {
        return FolderBaseTabFragment.G;
    }

    public void Rh(ViewPager viewPager) {
        this.U = viewPager;
    }

    public void Uh(int i3) {
        ServiceFolderFollowPBHeadView serviceFolderFollowPBHeadView = this.K;
        if (serviceFolderFollowPBHeadView != null) {
            serviceFolderFollowPBHeadView.y(i3);
        }
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
        String str;
        if (this.M.getMode() == -1 && qUIBadgeDragLayout.getDragView() != null && qUIBadgeDragLayout.getDragView().getId() == R.id.m8b) {
            RecentContactInfo recentContactInfo = (RecentContactInfo) qUIBadgeDragLayout.getDragView().getTag(R.id.m87);
            int intValue = ((Integer) qUIBadgeDragLayout.getDragView().getTag(R.id.m85)).intValue();
            if (recentContactInfo != null) {
                QQAppInterface qQAppInterface = this.L;
                if (recentContactInfo.getUnreadCnt() == 0) {
                    str = "0";
                } else {
                    str = "1";
                }
                ReportController.o(qQAppInterface, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X800687D", "0X800687D", 0, 0, str, "" + recentContactInfo.getUnreadCnt(), "" + (intValue + 1), "" + recentContactInfo.getMsgId());
                ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).markRead4PA(recentContactInfo.getPeerUid(), null);
                VSReporter.n(String.valueOf(recentContactInfo.getPeerUin()), "auth_page", TagValue.IGNORE, 0, 0, new String[0]);
                if (QLog.isColorLevel()) {
                    QLog.d(f79969a0, 2, "onChange->drag red dot:" + recentContactInfo.getPeerUin());
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.C == null) {
            this.C = LayoutInflater.from(getBaseActivity()).inflate(R.layout.c7e, (ViewGroup) null, false);
        }
        boolean m3 = SubscribeUtils.m();
        this.N = m3;
        if (m3) {
            this.C.setBackgroundColor(-16777216);
        } else {
            this.C.setBackgroundColor(-657670);
        }
        QLog.d(FolderBaseTabFragment.F, 4, "onCreateView:" + Eh());
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ServiceAccountFolderNTManager.f79965a.r(this.Z);
        ServiceFolderFollowPBHeadView serviceFolderFollowPBHeadView = this.K;
        if (serviceFolderFollowPBHeadView != null) {
            serviceFolderFollowPBHeadView.w();
        }
        if (getBaseActivity() != null && this.T != null) {
            getBaseActivity().unregisterReceiver(this.T);
        }
        BlockContainer blockContainer = this.J;
        if (blockContainer != null) {
            blockContainer.m();
        }
        QQAppInterface qQAppInterface = this.L;
        if (qQAppInterface != null) {
            qQAppInterface.removeHandler(FolderFollowTabFragment.class);
        }
    }

    @Override // com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment
    protected void ph() {
        if (this.C == null) {
            this.C = LayoutInflater.from(getBaseActivity()).inflate(R.layout.c7e, (ViewGroup) null, false);
        }
        this.N = SubscribeUtils.m();
        this.L = getBaseActivity().app;
        if (getBaseActivity() != null && getBaseActivity().getIntent() != null) {
            ExtraTypeInfo extraTypeInfo = (ExtraTypeInfo) getBaseActivity().getIntent().getSerializableExtra(ExtraTypeInfo.KEY_SUBSCRIBE_INTENT_EXTRA_TYPE_INFO);
            if (extraTypeInfo == null) {
                extraTypeInfo = new ExtraTypeInfo();
            }
            this.P = new ExtraTypeInfo(7003, extraTypeInfo.sourceType);
        }
        this.I = getBaseActivity();
        initView();
        Fh();
        QLog.d(FolderBaseTabFragment.F, 4, "initViewData:" + Eh());
    }

    @Override // com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment
    public void qh(ServiceAccountFolderActivityNew serviceAccountFolderActivityNew, int i3) {
        if (i3 == Eh()) {
            serviceAccountFolderActivityNew.b3(true);
            if (serviceAccountFolderActivityNew.f3()) {
                serviceAccountFolderActivityNew.l3(8);
                Fh();
                RelativeLiveFeedsAdapter relativeLiveFeedsAdapter = this.Q;
                if (relativeLiveFeedsAdapter != null) {
                    Mh(relativeLiveFeedsAdapter);
                    Oh(this.Q);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d extends we0.a {
        d(Bundle bundle) {
            super(bundle);
        }

        @Override // we0.a
        protected BaseWidgetView i0(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
            return FolderFollowTabFragment.this.K;
        }

        @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
        public void U(com.tencent.biz.subscribe.part.block.base.b bVar) {
        }

        @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
        public void a0(Bundle bundle) {
        }
    }
}
