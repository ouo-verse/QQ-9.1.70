package com.tencent.biz.qqcircle.immersive.tab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.f;
import com.tencent.biz.qqcircle.helpers.y;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.immersive.events.QFSChangePgidEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.preload.QFSAdFeedSourcePreloadManager;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSLayerTabPart;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.part.QFSClockInPendantPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMainNextVideoGuidePart;
import com.tencent.biz.qqcircle.immersive.part.QFSPersonalRecommendSwitchPanelPart;
import com.tencent.biz.qqcircle.immersive.part.QFSSuspendOpenPushBoxPart;
import com.tencent.biz.qqcircle.immersive.part.bn;
import com.tencent.biz.qqcircle.immersive.views.QFSPublishBannerPart;
import com.tencent.biz.qqcircle.immersive.views.searchsquare.event.QFSSquarePageLifecycleChangeEvent;
import com.tencent.biz.qqcircle.immersive.views.searchsquare.event.QFSSquarePageSelectedEvent;
import com.tencent.biz.qqcircle.manager.QCirclePublishPromoteDataManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.event.QFSReceivePushFeedEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSRefreshTabEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSilenceInsertHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e40.g;
import e40.s;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleCounter$RedPointInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSRecommendTabFragment extends QFSFolderLayerTabFragment {
    public static String Y = "";
    private QFSPublishBannerPart U;
    private final ShowBannerTask V;
    private QFSSuspendOpenPushBoxPart W;
    private QFSTabFeedViewModel X;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static final class ShowBannerTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QFSRecommendTabFragment> f90015d;

        public ShowBannerTask(QFSRecommendTabFragment qFSRecommendTabFragment) {
            this.f90015d = new WeakReference<>(qFSRecommendTabFragment);
        }

        @Override // java.lang.Runnable
        public void run() {
            QLog.d("QFSRecommendTabFragment", 1, "ShowBannerTask, run ");
            QFSRecommendTabFragment qFSRecommendTabFragment = this.f90015d.get();
            if (qFSRecommendTabFragment != null) {
                qFSRecommendTabFragment.Ai();
            } else {
                QLog.d("QFSRecommendTabFragment", 1, "ShowBannerTask, fragment is null ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QFSRecommendTabFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
        QFSHodorCollectManager.f84689a.a("qfs_recommend_tab_create_cost");
        this.V = new ShowBannerTask(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ai() {
        if (this.U != null) {
            g g16 = QCirclePublishPromoteDataManager.f().g();
            QLog.d("QFSRecommendTabFragment", 1, "showBanner, toastInfo: " + g16);
            if (g16 == null) {
                return;
            }
            if (f.v().u(g16.c())) {
                QLog.d("QFSRecommendTabFragment", 1, "showBanner, has show ");
                return;
            }
            f.v().S(g16.c());
            this.U.J9(new s().d(g16.f()).c(g16.f395607b));
            this.U.M9();
        }
    }

    private void Bi() {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            String str = qCircleInitBean.getSchemeAttrs().get("xsj_main_entrance");
            if (QCircleDaTongConstant.ElementParamValue.QQ_MAIN_TAB.equals(str)) {
                y.g().w(QCircleHostRedPointHelper.getQQUpdatesTabOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE));
            } else if (QCircleDaTongConstant.ElementParamValue.QQ_UPDATES_TAB.equals(str)) {
                y.g().w(QCircleHostRedPointHelper.getQQUpdatesTabOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE));
            } else {
                y.g().w(new QQCircleCounter$RedPointInfo());
            }
            y.g().a();
            return;
        }
        y.g().w(new QQCircleCounter$RedPointInfo());
    }

    private void Ci() {
        RFWThreadManager.getUIHandler().removeCallbacks(this.V);
    }

    private void Di() {
        QLog.d("QFSRecommendTabFragment", 1, "try2ShowBannerTaskDelayed ");
        Ci();
        RFWThreadManager.getUIHandler().postDelayed(this.V, 6000L);
    }

    private void initViewModel() {
        if (this.X != null) {
            return;
        }
        QFSTabFeedViewModel qFSTabFeedViewModel = (QFSTabFeedViewModel) getViewModel(QFSTabFeedViewModel.class);
        this.X = qFSTabFeedViewModel;
        qFSTabFeedViewModel.p2().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.tab.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSRecommendTabFragment.xi((FeedCloudMeta$StFeed) obj);
            }
        });
    }

    private void wi(@NonNull QFSReceivePushFeedEvent qFSReceivePushFeedEvent) {
        QFSTabFeedViewModel qFSTabFeedViewModel;
        if (QCirclePluginUtil.isInLocalActivity(getActivity()) == qFSReceivePushFeedEvent.isTabPage && (qFSTabFeedViewModel = this.X) != null) {
            qFSTabFeedViewModel.C3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void xi(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        SimpleEventBus.getInstance().dispatchEvent(new QFSSquarePageSelectedEvent(feedCloudMeta$StFeed));
    }

    private void yi() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setPageId(getPageId()).setActionType(23).setSubActionType(1));
    }

    private void zi(Map<String, Object> map) {
        if (TextUtils.isEmpty(Y)) {
            return;
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_REF_LOCATION, Y);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public boolean Vh() {
        return QCircleSilenceInsertHelper.getInstance().needSilenceInsert();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new QFSMainNextVideoGuidePart());
        QFSPublishBannerPart qFSPublishBannerPart = new QFSPublishBannerPart(3);
        this.U = qFSPublishBannerPart;
        assembleParts.add(qFSPublishBannerPart);
        QFSSuspendOpenPushBoxPart qFSSuspendOpenPushBoxPart = new QFSSuspendOpenPushBoxPart();
        this.W = qFSSuspendOpenPushBoxPart;
        assembleParts.add(qFSSuspendOpenPushBoxPart);
        assembleParts.add(new QFSClockInPendantPart());
        assembleParts.add(new QFSPersonalRecommendSwitchPanelPart());
        assembleParts.add(new bn());
        return assembleParts;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        zi(hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g_z;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return "pg_xsj_explore_page";
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QFSRefreshTabEvent.class);
        eventClass.add(QFSReceivePushFeedEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSRecommendTabFragment";
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 503;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QCircleSilenceInsertHelper.getInstance().clear();
        super.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SimpleEventBus.getInstance().dispatchEvent(new QFSSquarePageLifecycleChangeEvent(Lifecycle.Event.ON_PAUSE));
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSRefreshTabEvent) {
            vi((QFSRefreshTabEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSReceivePushFeedEvent) {
            wi((QFSReceivePushFeedEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        if (this.D && Rh()) {
            yi();
        }
        super.onResume();
        initViewModel();
        SimpleEventBus.getInstance().dispatchEvent(new QFSChangePgidEvent(getDaTongPageId()));
        QFSTabFeedViewModel qFSTabFeedViewModel = (QFSTabFeedViewModel) getViewModel(QFSTabFeedViewModel.class);
        if (qFSTabFeedViewModel == null) {
            return;
        }
        w20.a.j().registerDisplaySurface(String.valueOf(this.E.getType()), qFSTabFeedViewModel);
        Di();
        QFSAdFeedSourcePreloadManager.k().o(qFSTabFeedViewModel);
        QFSHodorCollectManager.f84689a.c("qfs_recommend_tab_create_cost");
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Ci();
        SimpleEventBus.getInstance().dispatchEvent(new QFSSquarePageLifecycleChangeEvent(Lifecycle.Event.ON_STOP));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void rh() {
        QCircleFolderBean qCircleFolderBean;
        if (getActivity() != null && getActivity().getIntent() != null && (qCircleFolderBean = (QCircleFolderBean) getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean")) != null) {
            this.H = qCircleFolderBean.hasRedDotShownOnEntrance();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        if (z16) {
            if (this.C) {
                yi();
                return;
            }
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSSquarePageLifecycleChangeEvent(Lifecycle.Event.ON_STOP));
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void th() {
        QLog.d("QFSRecommendTabFragment", 1, "clearSilenceInsertFlag");
        QCircleSilenceInsertHelper.getInstance().clearSilenceInsertFlag();
    }

    protected void vi(@NonNull QFSRefreshTabEvent qFSRefreshTabEvent) {
        QFSTabFeedViewModel qFSTabFeedViewModel;
        if (qFSRefreshTabEvent.getTabType() != 6) {
            return;
        }
        if (qFSRefreshTabEvent.needSaveRedPoint()) {
            Bi();
        }
        PBRepeatMessageField<FeedCloudCommon$Entry> mapInfo = qFSRefreshTabEvent.getMapInfo();
        if (mapInfo != null && (qFSTabFeedViewModel = this.X) != null) {
            qFSTabFeedViewModel.r2().B(mapInfo);
        }
        fi();
        QLog.d("QFSRecommendTabFragment", 1, "handleForceRefreshRecommEvent scrollToTopAndRefresh");
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public FeedCloudMeta$StFeed zh() {
        QFSLayerTabPart qFSLayerTabPart = this.R;
        if (qFSLayerTabPart == null) {
            return null;
        }
        return qFSLayerTabPart.V9();
    }
}
