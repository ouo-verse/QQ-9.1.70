package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderNTManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.util.k;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter;
import com.tencent.biz.subscribe.network.SubscribeGetQCircleFeedListRequest;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.widget.relativevideo.QCircleServiceFolderView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedBaseHeaderView;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.widget.CirclePageIndicator;
import common.config.service.QzoneConfig;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;
import tr2.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class FolderRecommendTabFragment extends FolderBaseTabFragment implements DragFrameLayout.b {
    private static DragFrameLayout U = null;
    public static View V = null;
    public static LinearLayout W = null;
    public static TextView X = null;
    public static LinearLayout Y = null;
    public static String Z = "";
    private BlockContainer I;
    protected ExtraTypeInfo J;
    protected String K;
    private boolean M;
    private boolean N;
    private d P;
    private RelativeLiveFeedsAdapter Q;
    private QQAppInterface S;
    private int L = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_SUBSCRIBE_SETTING, QzoneConfig.SECONDARY_RECOMMEND_BANNER_CHECK_DISPLAY_INTERVAL, 3);
    private ServiceAccountFolderNTManager.a R = null;
    private TianShuGetAdvCallback T = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class BannerPagerAdapter extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private List<b.h> f79990d = new ArrayList();

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f79991d;

            a(int i3) {
                this.f79991d = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                try {
                    b.h hVar = (b.h) BannerPagerAdapter.this.f79990d.get(this.f79991d);
                    BannerPagerAdapter bannerPagerAdapter = BannerPagerAdapter.this;
                    bannerPagerAdapter.e((b.h) bannerPagerAdapter.f79990d.get(this.f79991d), view.getContext());
                    if (hVar != null) {
                        FolderRecommendTabFragment.Ch("227", "227", hVar.f437170d.iAdId + "", 102, 1);
                    }
                } catch (IndexOutOfBoundsException e16) {
                    e16.printStackTrace();
                    QLog.e("FolderRecommendTabFragment", 1, "on click IndexOutOfBoundsException", e16);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        BannerPagerAdapter() {
        }

        private void g() {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.BannerPagerAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    BannerPagerAdapter.this.notifyDataSetChanged();
                }
            });
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
            }
        }

        public void e(b.h hVar, Context context) {
            if (hVar != null) {
                if ("1".equals(hVar.f437167a) && !TextUtils.isEmpty(hVar.f437168b)) {
                    Intent intent = new Intent(context, (Class<?>) QQBrowserDelegationActivity.class);
                    intent.putExtra("url", hVar.f437168b);
                    intent.putExtra("fromOneCLickCLose", true);
                    context.startActivity(intent);
                    return;
                }
                if ("2".equals(hVar.f437167a) && !TextUtils.isEmpty(hVar.f437168b)) {
                    Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent2.setData(Uri.parse(hVar.f437168b));
                    context.startActivity(intent2);
                }
            }
        }

        public List<b.h> f() {
            return this.f79990d;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.f79990d.size();
        }

        public void h(List<b.h> list) {
            this.f79990d.clear();
            if (list != null) {
                this.f79990d.addAll(list);
            }
            g();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fs8, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.f164573t40);
            imageView.setImageDrawable(URLDrawable.getDrawable(this.f79990d.get(i3).f437169c));
            imageView.setOnClickListener(new a(i3));
            viewGroup.addView(inflate);
            return inflate;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements TianShuGetAdvCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            List<b.h> list;
            if (z16) {
                list = b.h.a(z16, getAdsRsp, com.tencent.luggage.wxa.j2.c.CTRL_INDEX);
            } else {
                list = null;
            }
            if (FolderRecommendTabFragment.this.P != null) {
                FolderRecommendTabFragment.this.P.l0(list);
            }
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
            if (!TextUtils.isEmpty(FolderRecommendTabFragment.Z)) {
                MobileReportManager.getInstance().reportActionLive("", "25", "qq_live", "find_page", "bottom_button", 102, 1, System.currentTimeMillis(), "");
                Intent intent = new Intent(FolderRecommendTabFragment.this.getBaseActivity(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", FolderRecommendTabFragment.Z);
                FolderRecommendTabFragment.this.getBaseActivity().startActivity(intent);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements ServiceAccountFolderNTManager.a {
        c() {
        }

        @Override // com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderNTManager.a
        public void a(@Nullable List<RecentContactInfo> list) {
            FolderRecommendTabFragment.this.Dh(list);
        }
    }

    private void Bh() {
        W = (LinearLayout) this.C.findViewById(R.id.tif);
        X = (TextView) this.C.findViewById(R.id.f94605cq);
        Y = (LinearLayout) this.C.findViewById(R.id.tig);
        X.setText("\u53d1\u73b0\u66f4\u591a\u7cbe\u5f69\u5185\u5bb9");
        X.getPaint().setShader(new LinearGradient(0.0f, 0.0f, X.getPaint().getTextSize() * X.getText().length(), 0.0f, Color.parseColor("#FFC235"), Color.parseColor("#FF00CE"), Shader.TileMode.CLAMP));
        W.setOnClickListener(new b());
    }

    public static void Ch(String str, String str2, String str3, int i3, int i16) {
        String str4;
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            str4 = runtime.getAccount();
        } else {
            str4 = "";
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = str4 + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = i16;
        tianShuReportData.mAppId = str;
        tianShuReportData.mPageId = str2;
        tianShuReportData.mItemId = str3;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mOperTime = serverTimeMillis;
        TianShuManager.getInstance().report(tianShuReportData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(final List<RecentContactInfo> list) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (list.isEmpty()) {
                    if (FolderRecommendTabFragment.this.P != null && FolderRecommendTabFragment.this.P.L != null) {
                        FolderRecommendTabFragment.this.P.L.setTopBannerVisibility(false);
                        return;
                    }
                    return;
                }
                if (FolderRecommendTabFragment.this.P != null && FolderRecommendTabFragment.this.P.L != null) {
                    FolderRecommendTabFragment.this.P.L.setTopBannerVisibility(true);
                    FolderRecommendTabFragment.this.P.L.setAdapterData(list);
                }
            }
        });
    }

    private boolean wh() {
        if ((System.currentTimeMillis() / 1000) - yh() > this.L * 24 * 60 * 60) {
            return true;
        }
        return false;
    }

    private void zh() {
        c cVar = new c();
        this.R = cVar;
        ServiceAccountFolderNTManager serviceAccountFolderNTManager = ServiceAccountFolderNTManager.f79965a;
        serviceAccountFolderNTManager.c(cVar);
        serviceAccountFolderNTManager.d();
        k.a("SERVICE_FOLDER_COST", null);
    }

    protected void Ah() {
        BlockContainer blockContainer = (BlockContainer) this.C.findViewById(R.id.f166789m61);
        this.I = blockContainer;
        blockContainer.setParentFragment(this);
        this.I.setLayoutManagerType(3, 2);
        this.I.setEnableLoadMore(true);
        d dVar = new d(null);
        this.P = dVar;
        this.I.n(dVar);
        RelativeLiveFeedsAdapter relativeLiveFeedsAdapter = new RelativeLiveFeedsAdapter(null);
        this.Q = relativeLiveFeedsAdapter;
        relativeLiveFeedsAdapter.x0(0);
        this.Q.y0(this.M);
        this.Q.z0(false);
        this.Q.w0(1);
        this.I.n(this.Q);
        this.I.setExtraTypeInfo(this.J);
        this.I.setEnableRefresh(true);
        this.I.p();
        V = this.C.findViewById(R.id.uwx);
        zh();
        Bh();
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
        String str;
        DragFrameLayout dragFrameLayout = U;
        if (dragFrameLayout != null && dragFrameLayout.getMode() == -1 && qUIBadgeDragLayout.getDragView() != null && qUIBadgeDragLayout.getDragView().getId() == R.id.m8b) {
            RecentContactInfo recentContactInfo = (RecentContactInfo) qUIBadgeDragLayout.getDragView().getTag(R.id.m87);
            int intValue = ((Integer) qUIBadgeDragLayout.getDragView().getTag(R.id.m85)).intValue();
            if (recentContactInfo != null) {
                QQAppInterface qQAppInterface = this.S;
                if (recentContactInfo.getUnreadCnt() == 0) {
                    str = "0";
                } else {
                    str = "1";
                }
                ReportController.o(qQAppInterface, "dc01160", IPublicAccountHandler.MAIN_ACTION, "", "0X800687D", "0X800687D", 0, 0, str, "" + recentContactInfo.getUnreadCnt(), "" + (intValue + 1), "" + recentContactInfo.getMsgId());
                ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).markRead4PA(recentContactInfo.getPeerUid(), null);
                VSReporter.n(String.valueOf(recentContactInfo.getPeerUin()), "auth_page", TagValue.IGNORE, 0, 0, new String[0]);
                if (QLog.isColorLevel()) {
                    QLog.d("FolderRecommendTabFragment", 2, "onChange->drag red dot:" + recentContactInfo.getPeerUin());
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.C == null) {
            this.C = LayoutInflater.from(getBaseActivity()).inflate(R.layout.c6v, (ViewGroup) null);
        }
        boolean m3 = SubscribeUtils.m();
        this.M = m3;
        if (m3) {
            this.C.setBackgroundColor(-16777216);
        } else {
            this.C.setBackgroundColor(-657670);
        }
        QLog.d(FolderBaseTabFragment.F, 4, "onCreateView:" + xh());
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        FolderRecommendHeadItemView folderRecommendHeadItemView;
        super.onDestroy();
        BlockContainer blockContainer = this.I;
        if (blockContainer != null) {
            blockContainer.m();
            this.I = null;
        }
        ServiceAccountFolderNTManager.f79965a.r(this.R);
        d dVar = this.P;
        if (dVar != null && (folderRecommendHeadItemView = dVar.L) != null) {
            folderRecommendHeadItemView.v();
            this.P.L = null;
            this.P = null;
        }
        DragFrameLayout dragFrameLayout = U;
        if (dragFrameLayout != null) {
            dragFrameLayout.removeOnDragModeChangeListener(this);
            U = null;
        }
        if (V != null) {
            V = null;
        }
        if (W != null) {
            W = null;
        }
        if (X != null) {
            X = null;
        }
        if (Y != null) {
            Y = null;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        DragFrameLayout dragFrameLayout = U;
        if (dragFrameLayout != null) {
            dragFrameLayout.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getBaseActivity() instanceof ServiceAccountFolderActivityNew) {
            ((ServiceAccountFolderActivityNew) getBaseActivity()).b3(false);
        }
    }

    @Override // com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment
    protected void ph() {
        if (this.C == null) {
            this.C = LayoutInflater.from(getBaseActivity()).inflate(R.layout.c6v, (ViewGroup) null);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            this.S = (QQAppInterface) runtime;
        }
        DragFrameLayout e16 = DragFrameLayout.e(getBaseActivity());
        U = e16;
        e16.addOnDragModeChangeListener(this, false);
        this.K = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        this.M = SubscribeUtils.m();
        if (getBaseActivity() != null && getBaseActivity().getIntent() != null) {
            ExtraTypeInfo extraTypeInfo = (ExtraTypeInfo) getBaseActivity().getIntent().getSerializableExtra(ExtraTypeInfo.KEY_SUBSCRIBE_INTENT_EXTRA_TYPE_INFO);
            if (extraTypeInfo == null) {
                extraTypeInfo = new ExtraTypeInfo();
            }
            this.J = new ExtraTypeInfo(7004, extraTypeInfo.sourceType);
        }
        Ah();
        QLog.d(FolderBaseTabFragment.F, 4, "initViewData:" + xh());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
                tianShuAdPosItemData.mPosId = com.tencent.luggage.wxa.j2.c.CTRL_INDEX;
                tianShuAdPosItemData.mNeedCnt = 6;
                arrayList.add(tianShuAdPosItemData);
                TianShuManager.getInstance().requestAdv(arrayList, FolderRecommendTabFragment.this.T);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment
    public void qh(ServiceAccountFolderActivityNew serviceAccountFolderActivityNew, int i3) {
        if (i3 == xh()) {
            serviceAccountFolderActivityNew.b3(false);
            if (serviceAccountFolderActivityNew.f3()) {
                zh();
            }
            if (wh() && !this.N) {
                this.N = true;
                VSReporter.m("auth_discover", "reco_exp", 0, 0, new String[0]);
            }
        }
    }

    public int xh() {
        return FolderBaseTabFragment.H;
    }

    public long yh() {
        try {
            return Long.valueOf(cl.d(BaseApplication.getContext(), "subscribe_recommend_banner_unlike_timestamp_" + this.K)).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class FolderRecommendHeadItemView extends RelativeFeedBaseHeaderView {
        private QQViewPager E;
        private CirclePageIndicator F;
        private BannerPagerAdapter G;
        private RelativeLayout H;
        private ImageView I;
        private RecyclerView J;
        private ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter K;
        private LinearLayoutManager L;
        private QCircleServiceFolderView M;

        public FolderRecommendHeadItemView(Context context) {
            super(context);
        }

        @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
        public int i() {
            return R.layout.fs9;
        }

        @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
        public void p(Context context, View view) {
            QQViewPager qQViewPager = (QQViewPager) view.findViewById(R.id.f166764i24);
            this.E = qQViewPager;
            qQViewPager.requestParentDisallowInterecptTouchEvent(true);
            this.J = (RecyclerView) view.findViewById(R.id.m8c);
            ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter serviceAccountFoldAdapter = new ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter(getContext(), this.J);
            this.K = serviceAccountFoldAdapter;
            serviceAccountFoldAdapter.w(SubscribeUtils.m());
            this.J.setAdapter(this.K);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.L = linearLayoutManager;
            linearLayoutManager.setOrientation(0);
            this.J.setLayoutManager(this.L);
            this.K.v(FolderRecommendTabFragment.U);
            BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter();
            this.G = bannerPagerAdapter;
            this.E.setAdapter(bannerPagerAdapter);
            CirclePageIndicator circlePageIndicator = (CirclePageIndicator) view.findViewById(R.id.f71193nh);
            this.F = circlePageIndicator;
            circlePageIndicator.setViewPager(this.E, 0);
            this.F.setBackgroundColor(0);
            this.F.setCirclePadding(BaseAIOUtils.f(6.0f, context.getResources()));
            this.F.setOnPageChangeListener(new a());
            this.H = (RelativeLayout) view.findViewById(R.id.uvu);
            this.I = (ImageView) view.findViewById(R.id.uvt);
            this.I.setImageDrawable(URLDrawable.getDrawable("https://sola.gtimg.cn/aoi/sola/20201119210154_6KQkLOzrpX.png", (URLDrawable.URLDrawableOptions) null));
            this.M = (QCircleServiceFolderView) view.findViewById(R.id.f83404jg);
        }

        public void setAdapterData(Object obj) {
            List<RecentContactInfo> list = (List) obj;
            ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter serviceAccountFoldAdapter = this.K;
            if (serviceAccountFoldAdapter != null) {
                serviceAccountFoldAdapter.u(list);
            }
        }

        @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
        public void setData(Object obj) {
            super.setData(obj);
        }

        public void setQCircleData(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            QCircleServiceFolderView qCircleServiceFolderView = this.M;
            if (qCircleServiceFolderView == null) {
                return;
            }
            qCircleServiceFolderView.setData(feedCloudRead$StGetFeedListRsp, 46);
        }

        public void setTopBannerVisibility(boolean z16) {
            if (z16) {
                if (this.J.getVisibility() == 8) {
                    this.J.setVisibility(0);
                    VSReporter.m("auth_follow", "service_exp", 0, 0, new String[0]);
                    return;
                }
                return;
            }
            if (this.J.getVisibility() == 0) {
                this.J.setVisibility(8);
            }
        }

        public void v() {
            ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter serviceAccountFoldAdapter = this.K;
            if (serviceAccountFoldAdapter != null) {
                serviceAccountFoldAdapter.s();
            }
        }

        public void w(final boolean z16) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z16 && FolderRecommendHeadItemView.this.E.getVisibility() == 8) {
                        FolderRecommendHeadItemView.this.E.setVisibility(0);
                        FolderRecommendHeadItemView.this.F.setVisibility(0);
                    } else if (!z16 && FolderRecommendHeadItemView.this.E.getVisibility() == 0) {
                        FolderRecommendHeadItemView.this.E.setVisibility(8);
                        FolderRecommendHeadItemView.this.F.setVisibility(8);
                    }
                }
            });
        }

        public void x(boolean z16, String str, String str2) {
            if (FolderRecommendTabFragment.X != null && FolderRecommendTabFragment.W != null && FolderRecommendTabFragment.Y != null) {
                FolderRecommendTabFragment.W.setVisibility(8);
                FolderRecommendTabFragment.Y.setVisibility(8);
            }
        }

        public void y(boolean z16) {
            if (z16) {
                this.H.setVisibility(0);
            } else {
                this.H.setVisibility(8);
            }
            View view = FolderRecommendTabFragment.V;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class a implements ViewPager.OnPageChangeListener {
            a() {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                b.h hVar = FolderRecommendHeadItemView.this.G.f().get(i3);
                if (hVar != null) {
                    FolderRecommendTabFragment.Ch("227", "227", hVar.f437170d.iAdId + "", 101, 1);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f16, int i16) {
            }
        }

        @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
        public void c(Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d extends we0.a {
        FolderRecommendHeadItemView L;

        public d(Bundle bundle) {
            super(bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k0(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            QLog.i("FolderRecommendTabFragment", 1, "[requestQCircleData] isSuccess=" + z16 + ",retCode=" + j3 + ",errMsg=" + str + ",traceId=" + baseRequest.getTraceId());
            FolderRecommendHeadItemView folderRecommendHeadItemView = this.L;
            if (folderRecommendHeadItemView == null) {
                QLog.e("FolderRecommendTabFragment", 1, "[requestQCircleData] folderRecommendHeadItemView is null");
                return;
            }
            if (z16 && j3 == 0 && feedCloudRead$StGetFeedListRsp != null) {
                folderRecommendHeadItemView.setQCircleData(feedCloudRead$StGetFeedListRsp);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                QQToast.makeText(C(), 1, str, 0).show();
            }
            this.L.setQCircleData(null);
        }

        private void m0() {
            SubscribeGetQCircleFeedListRequest subscribeGetQCircleFeedListRequest = new SubscribeGetQCircleFeedListRequest(46);
            subscribeGetQCircleFeedListRequest.setEnableCache(false);
            VSNetworkHelper.getInstance().sendRequest(subscribeGetQCircleFeedListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.fragment.b
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    FolderRecommendTabFragment.d.this.k0(baseRequest, z16, j3, str, (FeedCloudRead$StGetFeedListRsp) obj);
                }
            });
        }

        @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
        public void U(com.tencent.biz.subscribe.part.block.base.b bVar) {
            ArrayList arrayList = new ArrayList();
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            tianShuAdPosItemData.mPosId = com.tencent.luggage.wxa.j2.c.CTRL_INDEX;
            tianShuAdPosItemData.mNeedCnt = 6;
            arrayList.add(tianShuAdPosItemData);
            TianShuManager.getInstance().requestAdv(arrayList, FolderRecommendTabFragment.this.T);
        }

        @Override // we0.a
        protected BaseWidgetView i0(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
            this.L = new FolderRecommendHeadItemView(viewGroup.getContext());
            if (FolderRecommendTabFragment.this.Q != null) {
                FolderRecommendTabFragment.this.Q.B0(this.L);
            }
            return this.L;
        }

        public void l0(List<b.h> list) {
            this.L.G.h(list);
            if (list != null && list.size() > 0) {
                FolderRecommendTabFragment.Ch("227", "227", list.get(0).f437170d.iAdId + "", 101, 1);
                this.L.w(true);
            } else {
                this.L.w(false);
            }
            if (py.a.a()) {
                m0();
            }
        }

        @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
        public void a0(Bundle bundle) {
        }
    }
}
