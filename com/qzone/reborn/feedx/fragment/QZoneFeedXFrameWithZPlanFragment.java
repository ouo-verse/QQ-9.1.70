package com.qzone.reborn.feedx.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.app.QZoneRunInQQEnv;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.reborn.feedx.block.k;
import com.qzone.reborn.feedx.block.t;
import com.qzone.reborn.feedx.block.u;
import com.qzone.reborn.feedx.block.y;
import com.qzone.reborn.feedx.part.bo;
import com.qzone.reborn.feedx.part.bz;
import com.qzone.reborn.feedx.util.ah;
import com.qzone.reborn.part.QConciseZPlanPart;
import com.qzone.util.ar;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.feed.ILebaPluginFeedApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QZoneConfigHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QZoneTopGestureLayout;
import cooperation.qzone.api.OnSwitchQzoneTabListener;
import cooperation.qzone.api.QzoneFragmentImpl;
import cooperation.qzone.util.QZLog;
import gf.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import ve.i;

@ArgusTag(testConfigKey = "argus_qzone_feed", testTags = {"AUTO_PRELOAD"})
@Page(business = Business.QZone, type = PageHierarchy.MainPage)
/* loaded from: classes37.dex */
public class QZoneFeedXFrameWithZPlanFragment extends QZoneFriendFeedXFragment implements QzoneFragmentImpl, com.tencent.mobileqq.zootopia.api.b, o {
    private static final float QQ_TAB_WIDGET_HEIGHT = 53.0f;
    public static final String TAG = "QZoneFeedXFrameWithZplanFragment";
    private AppRuntime mApp;
    private com.qzone.reborn.part.b mConciseUnreadPart;
    private k mEmptyPageBlock;
    private com.tencent.mobileqq.leba.feed.c mNavigatorController;
    private bo mTitlePart;
    private u mZPlanHeaderBlock;
    private QConciseZPlanPart mZPlanPart;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a extends com.qzone.reborn.feedx.viewmodel.g {
        a() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i5(QZoneResult qZoneResult) {
            if (QZoneFeedXFrameWithZPlanFragment.this.mZPlanPart != null) {
                QZoneFeedXFrameWithZPlanFragment.this.mZPlanPart.Ka();
            }
        }
    }

    private void initZPlan() {
        QConciseZPlanPart qConciseZPlanPart = this.mZPlanPart;
        if (qConciseZPlanPart != null) {
            qConciseZPlanPart.La();
        }
        this.mFeedDataViewModel.k2(new a());
    }

    private boolean isZPlanSwitchOpen() {
        long uin;
        if (com.qzone.reborn.util.k.f59549a.g()) {
            return false;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime != null) {
            uin = appRuntime.getLongAccountUin();
        } else {
            uin = LoginData.getInstance().getUin();
        }
        return ((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(uin);
    }

    private void updateDynamicBanner() {
        com.qzone.reborn.part.b bVar = this.mConciseUnreadPart;
        if (bVar == null) {
            return;
        }
        bVar.Q9(this.mTopBannerIoc.d());
        this.mConciseUnreadPart.R9((n6.e) this.mTopBannerIoc);
    }

    @Override // com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        bz bzVar = new bz(R.id.n2d, buildBlockList(), true);
        this.mListBlockPart = bzVar;
        arrayList.add(bzVar);
        com.qzone.reborn.part.b bVar = new com.qzone.reborn.part.b();
        this.mConciseUnreadPart = bVar;
        arrayList.add(bVar);
        bo boVar = new bo(this);
        this.mTitlePart = boVar;
        arrayList.add(boVar);
        boolean isZPlanSwitchOpen = isZPlanSwitchOpen();
        QZLog.i("QZoneConciseZPlan QZoneFeedXFrameWithZplanFragment", 1, "[assembleParts] ZPlanSwitchIsOpen=" + isZPlanSwitchOpen);
        if (isZPlanSwitchOpen) {
            QConciseZPlanPart qConciseZPlanPart = new QConciseZPlanPart(this);
            this.mZPlanPart = qConciseZPlanPart;
            arrayList.add(qConciseZPlanPart);
        }
        arrayList.addAll(new ve.f().c(new i().g("1").e(getMFromDtPageId())));
        return arrayList;
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void attachQQContext(Activity activity, AppRuntime appRuntime) {
        this.mApp = appRuntime;
        u5.a.g(AccessibilityUtil.i(activity));
        if (QZoneRunInQQEnv.init(appRuntime)) {
            un.c.e();
            jm.b.f410600a.e().clearPagePreLoaders(activity);
            return;
        }
        throw new IllegalStateException("fained to init qzone env");
    }

    List<MultiViewBlock> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        u uVar = new u(null, this);
        this.mZPlanHeaderBlock = uVar;
        arrayList.add(uVar);
        arrayList.add(new t(null));
        k kVar = new k(null);
        this.mEmptyPageBlock = kVar;
        arrayList.add(kVar);
        arrayList.add(new y(null));
        return arrayList;
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void clearCache() {
        QZoneFeedService U = QZoneFeedService.U();
        if (U != null) {
            U.O();
        }
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void clearMemoryCache() {
        try {
            RFWThreadManager.getInstance().execOnSubThread(new c());
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void forceRefresh() {
        if (this.mZPlanPart != null) {
            RFWLog.d(TAG, RFWLog.USR, "forceRefresh mZPlanPart showProgressBar");
            this.mZPlanPart.t();
        } else if (this.mZPlanHeaderBlock != null) {
            RFWLog.d(TAG, RFWLog.USR, "forceRefresh mZPlanHeaderBlock showProgressBar");
            this.mZPlanHeaderBlock.s0();
        } else {
            this.mFeedDataViewModel.P1();
        }
        bz bzVar = this.mListBlockPart;
        if (bzVar != null) {
            bzVar.I9(0, true);
        }
    }

    @Override // gf.o
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment, n6.d.a
    public ViewStub getBannerContainerViewStub() {
        u uVar = this.mZPlanHeaderBlock;
        if (uVar != null && uVar.getSingleBlockRootView() != null) {
            return (ViewStub) this.mZPlanHeaderBlock.getSingleBlockRootView().findViewById(R.id.hui);
        }
        QLog.e(TAG, 1, "getBannerContainerViewStub error: " + this.mZPlanHeaderBlock);
        return null;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("qq_session_id", com.tencent.mobileqq.leba.report.d.c().f());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQ_MODE, com.tencent.mobileqq.leba.report.d.e());
        hashMap.put("SourceID", "");
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDS_PATTERN, "feeds");
        if (isZPlanSwitchOpen()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_avatar_display", str);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ci5;
    }

    @Override // com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment, com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_discover_feeds_page";
    }

    @Override // gf.o
    public View getFeedListView(View view) {
        return this.mListBlockPart.getBlockContainer();
    }

    @Override // gf.o
    public com.tencent.mobileqq.leba.feed.c getNavigatorController() {
        if (this.mNavigatorController == null) {
            this.mNavigatorController = ((ILebaPluginFeedApi) QRoute.api(ILebaPluginFeedApi.class)).getLebaPluginFeedController(getActivity(), this.mApp, (QBaseActivity) getActivity());
        }
        return this.mNavigatorController;
    }

    public RecyclerView getRecyclerView() {
        if (this.mListBlockPart.getBlockContainer() == null) {
            RFWLog.fatal(TAG, 1, new RuntimeException("getBlockContainer() return null"));
            return null;
        }
        return this.mListBlockPart.getBlockContainer().getRecyclerView();
    }

    @Override // com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment, com.qzone.reborn.base.QZoneBaseFragment, com.qzone.util.ap.a
    public int getReportPageId() {
        return 12;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // gf.o
    public uh.a getZPlanTitleHost() {
        return (uh.a) this.mTitlePart.mFeedxTitle;
    }

    @Override // gf.o
    public boolean handleEventUIThread(Event event) {
        com.qzone.reborn.part.b bVar = this.mConciseUnreadPart;
        if (bVar == null) {
            QLog.d(TAG, 1, "[handleEventUIThread] concise unread part should not be null.");
            return false;
        }
        return bVar.H9(event);
    }

    @Override // com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment
    public void initIoc() {
        super.initIoc();
        registerIoc(this, o.class);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    @Override // gf.o
    public boolean isFeedViewListOnTop() {
        return getRecyclerView() != null && getRecyclerView().getChildCount() > 0 && ah.a(getRecyclerView()) == 0 && getRecyclerView().getChildAt(0) != null && getRecyclerView().getChildAt(0).getTop() == 0;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return super.onBackEvent();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().onThemeColorChange();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment, com.qzone.reborn.base.QZoneBaseFeedxFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.d(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        com.tencent.mobileqq.leba.feed.c cVar = this.mNavigatorController;
        if (cVar != null) {
            cVar.onDestroy();
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.tencent.mobileqq.leba.feed.c cVar = this.mNavigatorController;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    @Override // gf.o
    public void onRefresh() {
        this.mFeedDataViewModel.P1();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.mobileqq.leba.feed.c cVar = this.mNavigatorController;
        if (cVar != null) {
            cVar.onResume();
        }
        QConciseZPlanPart qConciseZPlanPart = this.mZPlanPart;
        if (qConciseZPlanPart != null) {
            qConciseZPlanPart.onResume();
        }
    }

    @Override // com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.tencent.mobileqq.leba.feed.c cVar = this.mNavigatorController;
        if (cVar != null) {
            cVar.onStop();
        }
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void onSwitchOutofQzone() {
        QConciseZPlanPart qConciseZPlanPart = this.mZPlanPart;
        if (qConciseZPlanPart != null) {
            qConciseZPlanPart.Ja();
        }
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void onSwitchToQzone() {
        QConciseZPlanPart qConciseZPlanPart = this.mZPlanPart;
        if (qConciseZPlanPart != null) {
            qConciseZPlanPart.Ia();
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        updateDynamicBanner();
        boolean isZPlanSwitchOpen = isZPlanSwitchOpen();
        QZLog.i("QZoneConciseZPlan QZoneFeedXFrameWithZplanFragment", 1, "[initZPlan] ZPlanSwitchIsOpen=" + isZPlanSwitchOpen);
        if (isZPlanSwitchOpen) {
            initZPlan();
        }
        bz bzVar = this.mListBlockPart;
        if (bzVar == null || bzVar.getBlockContainer() == null) {
            return;
        }
        this.mListBlockPart.getBlockContainer().setEnableRefresh(false);
        int d16 = ar.d(53.0f);
        this.mListBlockPart.getBlockContainer().setPadding(0, 0, 0, d16);
        com.tencent.mobileqq.qui.b.f276860a.f(this.mListBlockPart.getBlockContainer(), d16);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    @Override // gf.o
    public void scrollToTop() {
        if (getRecyclerView() != null) {
            getRecyclerView().scrollToPosition(0);
        }
    }

    @Override // gf.o
    public void setDispatchTouchEventListener(QZonePullToRefreshListView.a aVar) {
        if (this.mListBlockPart.getBlockContainer() != null) {
            this.mListBlockPart.getBlockContainer().setDispatchTouchEventListener(aVar);
        }
    }

    @Override // gf.o
    public void setNestedScrollingEnabled(boolean z16) {
        if (getRecyclerView() != null) {
            getRecyclerView().setNestedScrollingEnabled(z16);
        }
    }

    @Override // gf.o
    public void setSupportPullDown(boolean z16) {
        if (getRecyclerView() != null) {
            getRecyclerView().setOverScrollMode(z16 ? 0 : 2);
        }
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public int setTitleAlphaAndGetLastValue(int i3) {
        return 0;
    }

    @Override // gf.o
    public void setupCorner(int i3) {
        u uVar = this.mZPlanHeaderBlock;
        if (uVar != null) {
            uVar.r0(i3);
        }
    }

    @Override // gf.o
    public boolean shouldScrollTopWhenRefreshComplete() {
        return QZoneConfigHelper.P0();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // gf.o
    public QZoneTopGestureLayout getTopGestureLayout(View view) {
        return (QZoneTopGestureLayout) view.findViewById(R.id.mzj);
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void resetReportFlag() {
    }

    @Override // gf.o
    public void stopAllAudio() {
    }

    @Override // gf.o
    public void setQZoneRefreshIndicatorInterface(com.qzone.feed.ui.activity.f fVar) {
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void setQzoneSwitchlistener(OnSwitchQzoneTabListener onSwitchQzoneTabListener) {
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void setRightButtonType(int i3) {
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void setTitleView(ViewGroup viewGroup) {
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void updatePublishBox(Intent intent) {
    }
}
