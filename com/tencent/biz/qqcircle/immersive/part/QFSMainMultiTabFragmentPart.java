package com.tencent.biz.qqcircle.immersive.part;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.beans.QCircleTabNameInfo;
import com.tencent.biz.qqcircle.beans.QCircleTabNameInfoKt;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSHeaderRefreshEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSMainTabNetworkDataEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSMainTabSelectEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSRecSwitchChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSRefreshMainTabEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSInitTabEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPageSelectEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSRedPointTipsEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSTabTitleVisibilityEvent;
import com.tencent.biz.qqcircle.immersive.manager.QFSEcommerceTopViewManager;
import com.tencent.biz.qqcircle.immersive.manager.QFSTopViewManager;
import com.tencent.biz.qqcircle.immersive.tab.QFSActivityTabFragment;
import com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment;
import com.tencent.biz.qqcircle.immersive.tab.QFSGameTabFragment;
import com.tencent.biz.qqcircle.immersive.tab.mixfeed.QFSMixFeedMainTabFragment;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.biz.qqcircle.lazyload.QFSLazyLoadUtils;
import com.tencent.biz.qqcircle.lazyload.QFSNotifyLazyLoadEvent;
import com.tencent.biz.qqcircle.requests.QCircleClearCountRequest;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.event.QCircleFeedOptEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSSelectTabEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRedPointEvent;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.richframework.data.base.DataObserverWrapper;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudRead$StClearCountInfo;
import feedcloud.FeedCloudRead$StClearCountRsp;
import feedcloud.FeedCloudRead$StClearCountRspInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleFeedBase$StSubTabInfo;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* loaded from: classes4.dex */
public class QFSMainMultiTabFragmentPart extends u implements SimpleEventReceiver, t40.b {

    /* renamed from: g0, reason: collision with root package name */
    private static int f87393g0;
    private com.tencent.biz.qqcircle.viewmodels.j F;
    private t40.b G;
    private QFSFolderTabFragment H;
    private int J;
    private int K;
    private ValueAnimator P;
    private QCircleTabInfo Q;
    private QFSFolderTabFragment R;
    private boolean S;
    private View T;
    private View U;
    private int V;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f87394a0;

    /* renamed from: d, reason: collision with root package name */
    private TabLayoutCompat f87397d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f87399e;

    /* renamed from: e0, reason: collision with root package name */
    private long f87400e0;

    /* renamed from: f, reason: collision with root package name */
    private QFSViewPager f87401f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.adapter.r f87403h;

    /* renamed from: i, reason: collision with root package name */
    private final List<com.tencent.biz.qqcircle.immersive.views.h> f87404i = new CopyOnWriteArrayList();

    /* renamed from: m, reason: collision with root package name */
    private final List<f60.a> f87405m = new CopyOnWriteArrayList();
    private final List<QCircleTabNameInfo> C = new CopyOnWriteArrayList();
    private final List<QCircleTabInfo> D = new CopyOnWriteArrayList();
    private final List<QFSFolderTabFragment> E = new CopyOnWriteArrayList();
    private int I = -1;
    private int L = -1;
    private int M = -1;
    private int N = 0;
    private boolean W = false;
    private int X = 501;
    private final Observer<List<QQCircleFeedBase$StTabInfo>> Y = new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.cv
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            QFSMainMultiTabFragmentPart.this.hb((List) obj);
        }
    };
    private final Map<String, QFSFolderTabFragment> Z = new ConcurrentHashMap();

    /* renamed from: b0, reason: collision with root package name */
    private boolean f87395b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f87396c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private final Set<Integer> f87398d0 = new HashSet();

    /* renamed from: f0, reason: collision with root package name */
    private boolean f87402f0 = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue;
            if (valueAnimator != null && (animatedValue = valueAnimator.getAnimatedValue()) != null && QFSMainMultiTabFragmentPart.this.P != null) {
                QFSMainMultiTabFragmentPart.this.f87399e.setAlpha(((Float) animatedValue).floatValue() / 100.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StClearCountRsp> {
        b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StClearCountRsp feedCloudRead$StClearCountRsp) {
            StringBuilder sb5 = new StringBuilder();
            if (z16 && j3 == 0) {
                sb5.append("[sendClearOuterEntranceRedPointRequest] clear outer red dot success!");
                if (feedCloudRead$StClearCountRsp != null) {
                    sb5.append(", result.retCode: ");
                    sb5.append(feedCloudRead$StClearCountRsp.result.retCode.get());
                    sb5.append(", result.msg: ");
                    sb5.append(feedCloudRead$StClearCountRsp.result.f398427msg.get());
                    List<FeedCloudRead$StClearCountRspInfo> list = feedCloudRead$StClearCountRsp.clearCountRspInfos.get();
                    if (list != null) {
                        sb5.append(", rspInfoList size: " + list.size());
                        Iterator<FeedCloudRead$StClearCountRspInfo> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            FeedCloudRead$StClearCountRspInfo next = it.next();
                            if (next != null && next.countType.get() == 1) {
                                EeveeRedpointUtil.saveLastOuterEntranceRedPointClearRspTimestamp(next.clearTime.get());
                                break;
                            }
                        }
                    } else {
                        sb5.append(", rspInfoList is null!");
                    }
                }
                QLog.d("QCircleEeveeRedPoint_QFSMainMultiTabFragmentPart", 1, sb5);
                return;
            }
            sb5.append("[sendClearOuterEntranceRedPointRequest]");
            sb5.append(" clear outer red dot error! isSuccess : ");
            sb5.append(z16);
            sb5.append(", retCode: ");
            sb5.append(j3);
            if (feedCloudRead$StClearCountRsp != null) {
                sb5.append(", result.retCode: ");
                sb5.append(feedCloudRead$StClearCountRsp.result.retCode.get());
                sb5.append(", result.msg: ");
                sb5.append(feedCloudRead$StClearCountRsp.result.f398427msg.get());
            }
            QLog.e("QCircleEeveeRedPoint_QFSMainMultiTabFragmentPart", 1, sb5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements View.OnScrollChangeListener {
        c() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i3, int i16, int i17, int i18) {
            com.tencent.biz.qqcircle.immersive.utils.ay.b(QFSMainMultiTabFragmentPart.this.f87404i, QFSMainMultiTabFragmentPart.this.T, QFSMainMultiTabFragmentPart.this.U);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements TabLayoutCompat.j {
        d() {
        }

        private void c(TabLayoutCompat.f fVar, int i3) {
            if (fVar != null) {
                if (i3 == 1) {
                    QFSMainMultiTabFragmentPart.this.wa(fVar.d(), 1);
                    EventCollector.getInstance().onViewClicked(fVar.b());
                } else {
                    QFSMainMultiTabFragmentPart qFSMainMultiTabFragmentPart = QFSMainMultiTabFragmentPart.this;
                    qFSMainMultiTabFragmentPart.wa(qFSMainMultiTabFragmentPart.J, 2);
                }
            }
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.j
        public void a(TabLayoutCompat.f fVar, @Nullable TabLayoutCompat.f fVar2, int i3) {
            c(fVar, i3);
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.j
        public View b(ViewGroup viewGroup, int i3) {
            com.tencent.biz.qqcircle.immersive.views.h hVar = new com.tencent.biz.qqcircle.immersive.views.h(viewGroup);
            QFSMainMultiTabFragmentPart.this.f87404i.add(hVar);
            QFSMainMultiTabFragmentPart.this.La(hVar, i3);
            int size = QFSMainMultiTabFragmentPart.this.f87404i.size() - 1;
            if (QFSMainMultiTabFragmentPart.this.E.size() > size) {
                QFSMainMultiTabFragmentPart.this.f87405m.add(new f60.a(hVar, (QFSFolderTabFragment) QFSMainMultiTabFragmentPart.this.E.get(size)));
            } else {
                String str = "[onCreateTab] add tab error: mFragmentList size:" + QFSMainMultiTabFragmentPart.this.E.size() + ",currentAddIndex:" + size;
                QLog.e("QFSMainMultiTabFragmentPart", 1, str);
                if (QCircleHostConstants._AppSetting.isDebugVersion()) {
                    throw new RuntimeException(str);
                }
            }
            if (QFSMainMultiTabFragmentPart.this.C.size() > size) {
                VideoReport.setElementId(hVar.a(), QCircleDaTongConstant.ElementId.EM_XSJ_TOP_TAB);
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAB_TITLE, ((QCircleTabNameInfo) QFSMainMultiTabFragmentPart.this.C.get(size)).getTabName());
                QFSMainMultiTabFragmentPart.this.cc(buildElementParams, i3);
                VideoReport.setElementParams(hVar.a(), buildElementParams);
            }
            return hVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements TabLayoutCompat.c {
        e() {
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.c
        public void a(TabLayoutCompat.f fVar) {
            if (QFSMainMultiTabFragmentPart.this.f87401f != null) {
                QFSMainMultiTabFragmentPart.this.f87401f.setCurrentItem(fVar.d(), QFSMainMultiTabFragmentPart.this.f87394a0);
            }
            com.tencent.biz.qqcircle.immersive.views.h Wa = QFSMainMultiTabFragmentPart.this.Wa(fVar.d());
            if (Wa != null) {
                Wa.i(true);
            }
            QLog.i("QFSMainMultiTabFragmentPart", 1, "onTabSelected : " + fVar.d() + ", mRealFirstSelected : " + QFSMainMultiTabFragmentPart.this.S);
            if (QFSMainMultiTabFragmentPart.this.S) {
                QFSMainMultiTabFragmentPart.this.J = fVar.d();
                j60.a.d(QFSMainMultiTabFragmentPart.this.E, QFSMainMultiTabFragmentPart.this.J);
                QFSMainMultiTabFragmentPart.this.nc();
                QFSMainMultiTabFragmentPart.this.Ca();
                QFSMainMultiTabFragmentPart.this.oc(fVar.d(), true);
            }
            QFSMainMultiTabFragmentPart.this.ta(fVar.d());
            QFSMainMultiTabFragmentPart.this.ua(fVar.d());
            QFSMainMultiTabFragmentPart.this.getPartManager().broadcastMessage("qfs_force_skin_change", Boolean.valueOf(QFSMainMultiTabFragmentPart.this.Gb(fVar.d())));
            QFSMainMultiTabFragmentPart.this.Rb(fVar);
            QFSMainMultiTabFragmentPart.this.Da(fVar.d(), true);
            QFSMainMultiTabFragmentPart.this.Ba();
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.c
        public void b(TabLayoutCompat.f fVar) {
            QFSMainMultiTabFragmentPart.this.Da(fVar.d(), false);
            com.tencent.biz.qqcircle.immersive.views.h Wa = QFSMainMultiTabFragmentPart.this.Wa(fVar.d());
            if (Wa != null) {
                Wa.i(false);
            }
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.c
        public void c(TabLayoutCompat.f fVar) {
            if (fVar.d() == QFSMainMultiTabFragmentPart.this.J) {
                EventCollector.getInstance().onViewClicked(fVar.b());
                if (!fb0.a.a("qfs_main_tab_fast_click_tag")) {
                    QFSMainMultiTabFragmentPart qFSMainMultiTabFragmentPart = QFSMainMultiTabFragmentPart.this;
                    qFSMainMultiTabFragmentPart.Wb(qFSMainMultiTabFragmentPart.J, 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewTreeObserver f87421d;

        g(ViewTreeObserver viewTreeObserver) {
            this.f87421d = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (this.f87421d.isAlive()) {
                this.f87421d.removeOnPreDrawListener(this);
            } else {
                QFSMainMultiTabFragmentPart.this.f87397d.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            QFSMainMultiTabFragmentPart.this.f87397d.setScrollPosition(QFSMainMultiTabFragmentPart.this.f87401f.getCurrentItem(), 0.0f, true);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h implements ViewTreeObserver.OnPreDrawListener {
        h() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            QFSMainMultiTabFragmentPart.this.f87397d.getViewTreeObserver().removeOnPreDrawListener(this);
            QFSMainMultiTabFragmentPart.this.f87397d.setScrollPosition(QFSMainMultiTabFragmentPart.this.f87401f.getCurrentItem(), 0.0f, true);
            return false;
        }
    }

    private void Aa() {
        QLog.d(EeveeRedpointUtil.LOG_TAG_PREFIX + getTAG(), 1, "[clearLocalOuterEntranceRedPoint");
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(6);
        if (EeveeRedpointUtil.enableNumRedClear(QCircleHostRedPointHelper.getQQUpdatesTabOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE))) {
            arrayList.add(2);
        }
        QCircleHostRedPointHelper.setOuterEntranceRedPointReaded(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE, arrayList);
    }

    private boolean Ab(int i3) {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        if (this.D.size() <= i3 || (qQCircleFeedBase$StTabInfo = this.D.get(i3).mTab) == null || qQCircleFeedBase$StTabInfo.tabType.get() != 8) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        QFSFolderTabFragment qFSFolderTabFragment = this.R;
        if (qFSFolderTabFragment == null) {
            QLog.e("QFSMainMultiTabFragmentPart", 1, "dealWithSilenceInsert but mCurrentFragment is null");
        } else if (qFSFolderTabFragment.Vh()) {
            qFSFolderTabFragment.ci();
            qFSFolderTabFragment.th();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ca() {
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart.4
            @Override // java.lang.Runnable
            public void run() {
                if (QFSMainMultiTabFragmentPart.this.getHostFragment() != null) {
                    QFSMainMultiTabFragmentPart.this.getHostFragment().registerDaTongReportPageId();
                }
            }
        }, 500L, true);
    }

    private boolean Cb(int i3) {
        if (this.D.size() <= i3) {
            return false;
        }
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = this.D.get(i3).mTab;
        if (qQCircleFeedBase$StTabInfo != null && qQCircleFeedBase$StTabInfo.tabType.get() != 9) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da(int i3, boolean z16) {
        QCircleTabInfo Ta = Ta(i3);
        if (Ta != null && Ta.mTab.get() != null) {
            QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = Ta.mTab.get();
            QFSMainTabSelectEvent qFSMainTabSelectEvent = new QFSMainTabSelectEvent();
            qFSMainTabSelectEvent.setIsSelected(z16);
            qFSMainTabSelectEvent.setTabSourceType(qQCircleFeedBase$StTabInfo.sourceType.get());
            qFSMainTabSelectEvent.setTabType(qQCircleFeedBase$StTabInfo.tabType.get());
            qFSMainTabSelectEvent.setTabName(qQCircleFeedBase$StTabInfo.tabName.get());
            SimpleEventBus.getInstance().dispatchEvent(qFSMainTabSelectEvent);
            return;
        }
        RFWLog.e("QFSMainMultiTabFragmentPart", RFWLog.USR, "disPatchTabSelectStatus tabInfo is null");
    }

    private boolean Db(int i3) {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        if (this.D.size() <= i3 || (qQCircleFeedBase$StTabInfo = this.D.get(i3).mTab) == null) {
            return false;
        }
        return QFSGameTabFragment.INSTANCE.a(new QCircleTabInfo(qQCircleFeedBase$StTabInfo));
    }

    private boolean Eb(int i3) {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        if (this.D.size() <= i3 || (qQCircleFeedBase$StTabInfo = this.D.get(i3).mTab) == null || qQCircleFeedBase$StTabInfo.tabType.get() != 8) {
            return false;
        }
        return true;
    }

    private void Fa(boolean z16, QFSFolderTabFragment qFSFolderTabFragment) {
        if (z16 && !TextUtils.isEmpty(QCirclePluginGlobalInfo.z())) {
            qFSFolderTabFragment.ai();
        }
    }

    private void Ga(boolean z16, QFSFolderTabFragment qFSFolderTabFragment) {
        if (z16) {
            qFSFolderTabFragment.scrollToTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gb(int i3) {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        if (this.D.size() <= i3 || (qQCircleFeedBase$StTabInfo = this.D.get(i3).mTab) == null) {
            return false;
        }
        if (qQCircleFeedBase$StTabInfo.tabType.get() != 8 && qQCircleFeedBase$StTabInfo.tabType.get() != 14 && qQCircleFeedBase$StTabInfo.tabInfoByOperators.tabIconInfo.effectOnPageIcons.get() != 2) {
            return false;
        }
        return true;
    }

    private void Ha(boolean z16, int i3) {
        QFSViewPager qFSViewPager = this.f87401f;
        if (qFSViewPager != null) {
            this.S = true;
            qFSViewPager.setCurrentItem(i3, z16);
        }
    }

    private boolean Hb(int i3, QFSFolderTabFragment qFSFolderTabFragment) {
        if (qFSFolderTabFragment == null || qFSFolderTabFragment.Eh() == null || i3 != qFSFolderTabFragment.Eh().getType()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Ia, reason: merged with bridge method [inline-methods] */
    public void Mb(int i3) {
        try {
            if (this.f87404i.size() > i3 && this.C.size() > i3) {
                VideoReport.setElementId(this.f87404i.get(i3).a(), QCircleDaTongConstant.ElementId.EM_XSJ_TOP_TAB);
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAB_TITLE, this.C.get(i3).getTabName());
                cc(buildElementParams, i3);
                VideoReport.setElementParams(this.f87404i.get(i3).a(), buildElementParams);
                VideoReport.setElementEndExposePolicy(this.f87404i.get(i3).a(), EndExposurePolicy.REPORT_ALL);
            }
        } catch (Exception e16) {
            QLog.d(getTAG(), 1, "dtBindTabReport:" + e16.getMessage());
        }
    }

    private boolean Ib() {
        if (uq3.c.X0("qqcircle", "qqcircle_enable_auto_change_main_tab", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    private void Ja(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        QFSViewPager qFSViewPager = this.f87401f;
        if (qFSViewPager == null) {
            return;
        }
        int currentItem = qFSViewPager.getCurrentItem();
        QLog.d("QFSMainMultiTabFragmentPart", 1, "fs_lifecycle dtReportPageRegisterWhenTabStatusChange  mMultiViewPagerIndex = " + currentItem);
        if (aSEngineTabStatusEvent.isSelected()) {
            if (this.E.size() > currentItem && currentItem >= 0) {
                this.E.get(currentItem).registerDaTongReportPageId();
                return;
            }
            return;
        }
        if (this.E.size() > currentItem && currentItem >= 0) {
            this.E.get(currentItem).dtPageLogicDestroy();
        }
    }

    private void Jb() {
        QFSFolderTabFragment Pa = Pa(this.J);
        if (Pa != null) {
            Pa.vh();
            Pa.th();
        }
    }

    public static boolean Ka() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_pre_save_red_point_info_qq_tab", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kb() {
        com.tencent.biz.qqcircle.immersive.views.h hVar;
        QQCircleCounter$RedPointInfo friendRedPointInfoByAppId = QCircleHostRedPointHelper.getFriendRedPointInfoByAppId(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        if (friendRedPointInfoByAppId == null) {
            return;
        }
        String str = friendRedPointInfoByAppId.wording.get();
        QLog.d("QFSMainMultiTabFragmentPart", 1, "handleRedPointTips tipsText : " + str + "mFriendTabIndex : " + this.L);
        if (!TextUtils.isEmpty(str) && this.L >= 0) {
            int size = this.f87404i.size();
            int i3 = this.L;
            if (size > i3 && this.J != i3 && (hVar = this.f87404i.get(i3)) != null && hVar.a() != null) {
                int[] iArr = new int[2];
                hVar.a().getLocationInWindow(iArr);
                SimpleEventBus.getInstance().dispatchEvent(new QFSRedPointTipsEvent(QCircleHostUtil.convertRedDisplayInfoToString(friendRedPointInfoByAppId.rptRedInfo.get()), str, iArr[0] + (hVar.a().getWidth() / 2), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void La(@NonNull com.tencent.biz.qqcircle.immersive.views.h hVar, int i3) {
        if (i3 < this.D.size()) {
            hVar.j(this.D.get(i3));
            return;
        }
        String str = "[fullTabViewInfo] error: mTabInfoList size:" + this.D.size() + ",position:" + i3;
        QLog.e("QFSMainMultiTabFragmentPart", 1, str);
        if (!QCircleHostConstants._AppSetting.isDebugVersion()) {
        } else {
            throw new RuntimeException(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lb() {
        com.tencent.biz.qqcircle.immersive.utils.ay.b(this.f87404i, this.T, this.U);
    }

    private void Nb(int i3) {
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart.11

            /* renamed from: com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart$11$a */
            /* loaded from: classes4.dex */
            class a implements ValueAnimator.AnimatorUpdateListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ float f87406d;

                a(float f16) {
                    this.f87406d = f16;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Object animatedValue;
                    if (valueAnimator != null && (animatedValue = valueAnimator.getAnimatedValue()) != null && QFSMainMultiTabFragmentPart.this.f87399e != null) {
                        Float f16 = (Float) animatedValue;
                        QFSMainMultiTabFragmentPart.this.f87399e.setTranslationY(f16.floatValue());
                        float f17 = this.f87406d;
                        if (f17 >= 0.0f) {
                            QFSMainMultiTabFragmentPart.this.f87399e.setAlpha((f17 - f16.floatValue()) / this.f87406d);
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (QFSMainMultiTabFragmentPart.this.f87399e == null) {
                    return;
                }
                QFSMainMultiTabFragmentPart.this.f87399e.setAlpha(1.0f);
                float translationY = QFSMainMultiTabFragmentPart.this.f87397d.getTranslationY();
                if (QFSMainMultiTabFragmentPart.this.P != null) {
                    QFSMainMultiTabFragmentPart.this.P.cancel();
                }
                QFSMainMultiTabFragmentPart.this.P = new ValueAnimator();
                QFSMainMultiTabFragmentPart.this.P.setFloatValues(translationY, 0.0f);
                QFSMainMultiTabFragmentPart.this.P.setDuration(300L);
                QFSMainMultiTabFragmentPart.this.P.addUpdateListener(new a(translationY));
                QFSMainMultiTabFragmentPart.this.P.start();
            }
        }, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ob(int i3) {
        QCircleTabInfo qCircleTabInfo;
        boolean z16 = true;
        if (this.E.size() <= i3) {
            QLog.e("QFSMainMultiTabFragmentPart", 1, "fs_lifecycle onPageSelected  but mFragmentList size = " + this.E.size() + ", pos = " + i3);
            return;
        }
        QLog.i("QFSMainMultiTabFragmentPart", 1, "fs_lifecycle onPageSelected  mMultiViewPager pos = " + i3 + " , mLastPageSelectPosition = " + this.H);
        this.J = i3;
        nc();
        QFSFolderTabFragment qFSFolderTabFragment = this.H;
        if (qFSFolderTabFragment != null) {
            qFSFolderTabFragment.setUserVisibleHint(false);
            this.H.li(false);
        }
        QFSFolderTabFragment qFSFolderTabFragment2 = this.E.get(i3);
        qFSFolderTabFragment2.setUserVisibleHint(true);
        qFSFolderTabFragment2.li(true);
        this.H = qFSFolderTabFragment2;
        Nb(0);
        QFSPageSelectEvent qFSPageSelectEvent = new QFSPageSelectEvent(i3);
        if (i3 < this.D.size() && (qCircleTabInfo = this.D.get(i3)) != null) {
            qFSPageSelectEvent.mSelectTabInfo = qCircleTabInfo;
            qFSPageSelectEvent.mSelectTabType = qCircleTabInfo.getType();
            if (qCircleTabInfo.getType() == 8 && uq3.c.U4()) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSNotifyLazyLoadEvent(3));
            }
        }
        SimpleEventBus.getInstance().dispatchEvent(qFSPageSelectEvent);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (i3 != this.E.size() - 1) {
            z16 = false;
        }
        simpleEventBus.dispatchEvent(new QFSEnableSlideRightActionEvent(z16, getContext()));
    }

    private QFSFolderTabFragment Pa(int i3) {
        if (this.E.size() != 0 && i3 >= 0 && i3 < this.E.size()) {
            return this.E.get(i3);
        }
        return null;
    }

    private boolean Pb(QCircleTabInfo qCircleTabInfo) {
        if (qCircleTabInfo != null && ((qCircleTabInfo.getType() == 8 || qCircleTabInfo.getType() == 9) && (SimpleUIUtil.isNowElderMode() || !com.tencent.biz.qqcircle.manager.i.a("qfs_community_entrance_show")))) {
            return true;
        }
        return false;
    }

    private String Qa(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (qQCircleCounter$RedPointInfo == null || !"dot".equals(Ra(qQCircleCounter$RedPointInfo))) {
            return "";
        }
        return qQCircleCounter$RedPointInfo.extend.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean Qb(QCircleRedPointEvent qCircleRedPointEvent) {
        if (qCircleRedPointEvent != null && qCircleRedPointEvent.mRedPointMainMsgType == 115) {
            if (!getHostFragment().isResumed()) {
                return Boolean.FALSE;
            }
            QQCircleCounter$RedPointInfo friendRedPointInfoByAppId = QCircleHostRedPointHelper.getFriendRedPointInfoByAppId(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
            if (friendRedPointInfoByAppId == null) {
                QLog.i("QFSMainMultiTabFragmentPart", 1, "don't needUpdateFriendRedPoint, redPointInfo == null");
                return Boolean.FALSE;
            }
            String redPointId = EeveeRedpointUtil.getRedPointId(friendRedPointInfoByAppId);
            if (redPointId != null && !redPointId.isEmpty()) {
                if (redPointId.equals(EeveeRedpointUtil.getFriendTabIdForReadOnlyWording())) {
                    QLog.i("QFSMainMultiTabFragmentPart", 1, "don't needUpdateFriendRedPoint, hasReadWording, friendTabId=" + redPointId);
                    return Boolean.FALSE;
                }
                if (redPointId.equals(EeveeRedpointUtil.getFriendTabIdForRead())) {
                    QLog.i("QFSMainMultiTabFragmentPart", 1, "don't needUpdateFriendRedPoint, hasRead, friendTabId=" + redPointId);
                    return Boolean.FALSE;
                }
                return Boolean.TRUE;
            }
            QLog.i("QFSMainMultiTabFragmentPart", 1, "don't needUpdateFriendRedPoint, friendTabId isNullOrEmpty");
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    private String Ra(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (uq3.k.a().c("sp_key_friend_tab_show_new_tips", true)) {
            return QCircleDaTongConstant.ElementParamValue.NEW;
        }
        if (qQCircleCounter$RedPointInfo != null && qQCircleCounter$RedPointInfo.redType.get() == 9 && qQCircleCounter$RedPointInfo.showType.get() != 0) {
            return "dot";
        }
        return "none";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rb(TabLayoutCompat.f fVar) {
        if (ASInject.g().getAsEngineDelegate() != null && ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)) {
            boolean z16 = false;
            if (Eb(fVar.d())) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSSelectTabEvent(false));
                return;
            }
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if ((!Gb(fVar.d()) && !Db(fVar.d())) || QCircleCommonUtil.isInNightMode()) {
                z16 = true;
            }
            simpleEventBus.dispatchEvent(new QFSSelectTabEvent(z16));
        }
    }

    private QCircleLpReportDc05504.DataBuilder Sa(int i3, boolean z16) {
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        int i16 = 2;
        if (i3 == 1) {
            dataBuilder.setActionType(22);
            if (!z16) {
                i16 = 3;
            }
            dataBuilder.setSubActionType(i16);
        } else {
            int i17 = 11;
            if (i3 == 6) {
                dataBuilder.setActionType(23);
                if (!z16) {
                    i17 = 9;
                }
                dataBuilder.setSubActionType(i17);
            } else if (i3 == 4) {
                dataBuilder.setActionType(94);
                if (!z16) {
                    i16 = 3;
                }
                dataBuilder.setSubActionType(i16);
            } else {
                dataBuilder.setActionType(22);
                if (!z16) {
                    i17 = 9;
                }
                dataBuilder.setSubActionType(i17);
            }
        }
        return dataBuilder;
    }

    private int Sb() {
        int i3 = this.N;
        this.N = i3 + 1;
        return i3;
    }

    private QCircleTabInfo Ta(int i3) {
        if (this.D.size() <= i3) {
            return null;
        }
        return this.D.get(i3);
    }

    private void Tb(boolean z16) {
        FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2;
        if (!ra()) {
            QLog.e("QFSMainMultiTabFragmentPart", 1, "refreshTabList canAutoChangeTab return false");
            return;
        }
        if (this.F == null) {
            QLog.e("QFSMainMultiTabFragmentPart", 1, "refreshTabList but mTabViewModel is null");
            return;
        }
        QLog.d("QFSMainMultiTabFragmentPart", 1, "refreshTabList");
        com.tencent.biz.qqcircle.viewmodels.j jVar = this.F;
        if (uq3.o.i()) {
            feedCloudMeta$StGPSV2 = com.tencent.biz.qqcircle.c.e().d();
        } else {
            feedCloudMeta$StGPSV2 = new FeedCloudMeta$StGPSV2();
        }
        jVar.M1(feedCloudMeta$StGPSV2, new QCircleFolderBean((QCircleReportBean) getViewTagData()), z16);
    }

    public static String Va() {
        int i3 = f87393g0;
        int i16 = 1;
        if (i3 != 1) {
            i16 = 3;
            if (i3 != 3) {
                if (i3 != 6) {
                    i16 = -1;
                } else {
                    i16 = 2;
                }
            }
        }
        return String.valueOf(i16);
    }

    private void Vb(List<QQCircleFeedBase$StTabInfo> list) {
        if (!ra()) {
            QLog.e("QFSMainMultiTabFragmentPart", 1, "refreshTabListFromNetworkData canAutoChangeTab return false");
            return;
        }
        if (this.F != null && list != null && !list.isEmpty()) {
            QLog.d("QFSMainMultiTabFragmentPart", 1, "refreshTabListFromNetworkData tab size" + list.size());
            this.F.L1().postValue(list);
            return;
        }
        QLog.e("QFSMainMultiTabFragmentPart", 1, "refreshTabListFromNetworkData status error,mTabViewModel:" + this.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wb(int i3, int i16) {
        if (this.E.size() != 0 && i3 >= 0 && i3 < this.E.size()) {
            this.E.get(i3).gi(i16);
        }
    }

    private void Xa(Object... objArr) {
        QLog.d("QFSMainMultiTabFragmentPart", 1, "handleCommunitySubTabSelect, mIsRememberSubTabInfo: " + this.f87395b0 + ", mIsTransmitSubTabInfo: " + this.f87396c0);
        if (!this.f87395b0) {
            return;
        }
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof QQCircleFeedBase$StSubTabInfo) {
                QQCircleFeedBase$StSubTabInfo qQCircleFeedBase$StSubTabInfo = (QQCircleFeedBase$StSubTabInfo) obj;
                int i3 = qQCircleFeedBase$StSubTabInfo.sourceType.get();
                String str = qQCircleFeedBase$StSubTabInfo.tabName.get();
                QLog.d("QFSMainMultiTabFragmentPart", 1, "handleCommunitySubTabSelect, subTabType: " + i3 + ", subTabName: " + str);
                if (i3 != -1 && !TextUtils.isEmpty(str)) {
                    QCircleTabNameInfo updateSelectedSubTabName = QCircleTabNameInfoKt.updateSelectedSubTabName(this.C, 8, i3, str, this.f87396c0);
                    if (updateSelectedSubTabName == null) {
                        QLog.w("QFSMainMultiTabFragmentPart", 1, "handleCommunitySubTabSelect, info is null ");
                        return;
                    }
                    com.tencent.biz.qqcircle.immersive.utils.bq.f90197a.e(updateSelectedSubTabName);
                    if (!this.f87396c0) {
                        return;
                    }
                    int i16 = this.M;
                    if (i16 >= 0 && i16 < this.f87404i.size()) {
                        com.tencent.biz.qqcircle.immersive.views.h hVar = this.f87404i.get(this.M);
                        if (hVar != null) {
                            hVar.p(updateSelectedSubTabName.getShowTabName());
                            return;
                        }
                        return;
                    }
                    QLog.w("QFSMainMultiTabFragmentPart", 1, "handleCommunitySubTabSelect, invalid index ");
                    return;
                }
                return;
            }
        }
        QLog.w("QFSMainMultiTabFragmentPart", 1, "handleCommunitySubTabSelect, invalid data ");
    }

    private void Xb() {
        Iterator<Map.Entry<String, QFSFolderTabFragment>> it = this.Z.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, QFSFolderTabFragment> next = it.next();
            if (!this.E.contains(next.getValue())) {
                it.remove();
                QLog.d("QFSMainMultiTabFragmentPart", 1, "removeUnUsedFragment " + next.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ya() {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.ct
            @Override // java.lang.Runnable
            public final void run() {
                QFSMainMultiTabFragmentPart.this.Kb();
            }
        }, 500L);
    }

    private void Yb(List<QQCircleFeedBase$StTabInfo> list) {
        boolean z16;
        QLog.d("QFSMainMultiTabFragmentPart", 1, "resetTabInfo 0");
        ArrayList<QCircleTabNameInfo> arrayList = new ArrayList<>();
        ArrayList<QCircleTabInfo> arrayList2 = new ArrayList<>();
        ArrayList<QFSFolderTabFragment> arrayList3 = new ArrayList<>();
        boolean z17 = false;
        int i3 = 0;
        for (QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo : list) {
            if (qQCircleFeedBase$StTabInfo != null) {
                QCircleTabInfo wrapper = QCircleTabInfo.wrapper(qQCircleFeedBase$StTabInfo);
                if (Pb(wrapper)) {
                    QLog.d("QFSMainMultiTabFragmentPart", 1, "needFilterTab return true,tab name:" + wrapper.getName());
                } else {
                    if (wrapper.mTab.tabType.get() == 11) {
                        i3++;
                    }
                    QFSFolderTabFragment qFSFolderTabFragment = this.Z.get(wrapper.getTabTaskId());
                    if (qFSFolderTabFragment == null) {
                        QLog.d("QFSMainMultiTabFragmentPart", 1, "create new fragment" + wrapper.getName());
                        qFSFolderTabFragment = QFSFolderTabFragment.uh(wrapper, Sb());
                    } else {
                        QLog.d("QFSMainMultiTabFragmentPart", 1, "load fragment from cache" + wrapper.getName());
                    }
                    if (qFSFolderTabFragment != null) {
                        if (arrayList3.contains(qFSFolderTabFragment)) {
                            QLog.e("QFSMainMultiTabFragmentPart", 1, "fragment repeat add");
                        } else {
                            if (qFSFolderTabFragment instanceof QFSActivityTabFragment) {
                                ((QFSActivityTabFragment) qFSFolderTabFragment).Si(i3);
                            }
                            if (this.I == wrapper.getType()) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            qFSFolderTabFragment.ki(z16);
                            this.Z.put(wrapper.getTabTaskId(), qFSFolderTabFragment);
                            arrayList3.add(qFSFolderTabFragment);
                            arrayList.add(com.tencent.biz.qqcircle.immersive.utils.bq.f90197a.a(wrapper, getActivity().getIntent(), this.f87395b0, this.f87396c0));
                            arrayList2.add(wrapper);
                        }
                    } else {
                        QLog.e("QFSMainMultiTabFragmentPart", 1, "addTab invalid input data!");
                    }
                    if (qQCircleFeedBase$StTabInfo.tabType.get() == 6) {
                        this.K = list.indexOf(qQCircleFeedBase$StTabInfo);
                    }
                    if (qQCircleFeedBase$StTabInfo.tabType.get() == 9) {
                        this.L = list.indexOf(qQCircleFeedBase$StTabInfo);
                        z17 = true;
                    }
                    if (qQCircleFeedBase$StTabInfo.tabType.get() == 8) {
                        this.M = arrayList2.indexOf(wrapper);
                        QLog.d("QFSMainMultiTabFragmentPart", 1, "resetTabInfo, mCommunityTabIndex: " + this.M);
                    }
                }
            }
        }
        QCirclePluginGlobalInfo.W(z17);
        com.tencent.biz.qqcircle.immersive.utils.r.P0(arrayList3);
        Zb(arrayList, arrayList2, arrayList3);
        QLog.d("QFSMainMultiTabFragmentPart", 1, "resetTabInfo 1");
    }

    private void Za(Object... objArr) {
        if (this.f87399e != null && objArr != null && objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof e40.b) {
                e40.b bVar = (e40.b) obj;
                int b16 = bVar.b();
                QLog.d("QFSMainMultiTabFragmentPart", 1, "titlebar refresh" + b16);
                if (b16 == 3) {
                    this.f87399e.setAlpha(1.0f - bVar.a());
                    this.f87399e.setTranslationY(this.f87397d.getHeight() * bVar.a());
                } else if (b16 == 4) {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSHeaderRefreshEvent(false, bVar.c()));
                } else if (b16 == 2) {
                    Nb(200);
                    SimpleEventBus.getInstance().dispatchEvent(new QFSHeaderRefreshEvent(true, bVar.c()));
                }
                broadcastMessage("qfs_refresh_event", bVar);
            }
        }
    }

    private void Zb(ArrayList<QCircleTabNameInfo> arrayList, ArrayList<QCircleTabInfo> arrayList2, ArrayList<QFSFolderTabFragment> arrayList3) {
        this.D.clear();
        this.D.addAll(arrayList2);
        QCircleTabInfo.initTabPriority(arrayList2);
        this.E.clear();
        this.E.addAll(arrayList3);
        this.C.clear();
        this.C.addAll(arrayList);
        this.f87404i.clear();
        if (!this.f87405m.isEmpty()) {
            f60.a aVar = this.f87405m.get(0);
            com.tencent.biz.qqcircle.immersive.manager.e.a().clearGroup(aVar.getContextHashCode(), aVar.getGroup());
        }
        this.f87405m.clear();
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            QLog.d("QFSMainMultiTabFragmentPart", 1, "resetTabInfos index:" + i3 + ", info:" + this.C.get(i3));
        }
    }

    private void ab() {
        if (Ka()) {
            if (QCirclePluginUtil.isInLocalActivity(getActivity())) {
                QLog.d("QFSMainMultiTabFragmentPart", 1, "stashOutLayerRedPointInfo in tab mode");
                com.tencent.biz.qqcircle.helpers.y.g().a();
            } else {
                QLog.d("QFSMainMultiTabFragmentPart", 1, "stashOutLayerRedPointInfo in update entrance");
                jc();
            }
        } else {
            jc();
        }
        ac();
        Aa();
    }

    private void ac() {
        QLog.d("QCircleEeveeRedPoint_QFSMainMultiTabFragmentPart", 1, "[sendClearOuterEntranceRedPointRequest] ");
        FeedCloudRead$StClearCountInfo feedCloudRead$StClearCountInfo = new FeedCloudRead$StClearCountInfo();
        feedCloudRead$StClearCountInfo.clearType.set(1);
        feedCloudRead$StClearCountInfo.countType.set(1);
        feedCloudRead$StClearCountInfo.delayTimeInterval.set(EeveeRedpointUtil.getFollowTabClearRedDotDelayInSecond());
        VSNetworkHelper.getInstance().sendRequest(new QCircleClearCountRequest(HostDataTransUtils.getAccount(), feedCloudRead$StClearCountInfo), new b());
    }

    private void bb(QFSRecSwitchChangeEvent qFSRecSwitchChangeEvent) {
        int i3;
        com.tencent.biz.qqcircle.immersive.views.h Wa = Wa(this.K);
        if (Wa == null) {
            return;
        }
        if (qFSRecSwitchChangeEvent.isSwitchOpen()) {
            i3 = R.string.f183313iu;
        } else {
            i3 = R.string.f183273iq;
        }
        Wa.p(com.tencent.biz.qqcircle.utils.h.a(i3));
        Wb(this.K, 1);
    }

    private void bc(List<QQCircleFeedBase$StTabInfo> list) {
        Yb(list);
        this.f87397d.setVisibility(0);
        this.f87403h.d(this.E);
        this.f87403h.e(this.C);
        this.f87403h.notifyDataSetChanged();
        Xb();
        com.tencent.biz.qqcircle.immersive.utils.ay.b(this.f87404i, this.T, this.U);
        this.f87400e0 = com.tencent.biz.qqcircle.helpers.y.g().h();
    }

    private void cb(final QCircleRedPointEvent qCircleRedPointEvent) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart.6
            @Override // java.lang.Runnable
            public void run() {
                if (QFSMainMultiTabFragmentPart.this.Qb(qCircleRedPointEvent).booleanValue()) {
                    QFSMainMultiTabFragmentPart.this.Ya();
                    QFSMainMultiTabFragmentPart.this.ic();
                    QFSMainMultiTabFragmentPart qFSMainMultiTabFragmentPart = QFSMainMultiTabFragmentPart.this;
                    qFSMainMultiTabFragmentPart.oc(qFSMainMultiTabFragmentPart.J, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(Map<String, Object> map, int i3) {
        String str = "none";
        if (Ab(i3)) {
            if (com.tencent.biz.qqcircle.f.v().f0()) {
                str = QCircleDaTongConstant.ElementParamValue.NEW;
            }
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, str);
            return;
        }
        if (Cb(i3)) {
            QQCircleCounter$RedPointInfo friendRedPointInfoByAppId = QCircleHostRedPointHelper.getFriendRedPointInfoByAppId(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, Ra(friendRedPointInfoByAppId));
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, Qa(friendRedPointInfoByAppId));
            return;
        }
        QCircleTabInfo Ta = Ta(i3);
        if (Ta != null && !j60.a.h(Ta)) {
            if (j60.a.a(Ta)) {
                str = "function";
            } else if (j60.a.b(Ta)) {
                str = QCircleDaTongConstant.ElementParamValue.OPERATION;
            }
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, str);
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, Ta.getTabTaskId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(boolean z16) {
        List<QFSFolderTabFragment> list = this.E;
        for (int i3 = 0; i3 < list.size(); i3++) {
            QFSFolderTabFragment qFSFolderTabFragment = list.get(i3);
            if (qFSFolderTabFragment != null && !(qFSFolderTabFragment instanceof QFSMixFeedMainTabFragment)) {
                qFSFolderTabFragment.Yh(z16);
            }
        }
    }

    private void eb() {
        if (com.tencent.biz.qqcircle.helpers.y.g().r()) {
            QLog.d("QFSMainMultiTabFragmentPart", 1, "[handleRedPointTabType] current small window jump intercept.");
            return;
        }
        if (!xb() && Fb()) {
            this.I = com.tencent.biz.qqcircle.helpers.y.g().l();
            QLog.d("QFSMainMultiTabFragmentPart", 1, "[handleRedPointTabType] mAssignShowTabType: " + this.I);
            hc();
        }
    }

    private boolean ec() {
        byte[] f16 = com.tencent.biz.qqcircle.helpers.y.g().f(false);
        if (f16 != null && f16.length != 0) {
            return true;
        }
        byte[] m3 = com.tencent.biz.qqcircle.helpers.y.g().m(false);
        if (com.tencent.biz.qqcircle.helpers.y.g().l() != 9 || m3 == null || m3.length == 0) {
            return false;
        }
        return true;
    }

    private void fb() {
        if (com.tencent.biz.qqcircle.helpers.y.g().l() == 6 && com.tencent.biz.qqcircle.helpers.y.g().t()) {
            Jb();
        } else {
            Ba();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(int i3) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_read_schema_type_in_select_tab_event", true) || mb(i3)) {
            return;
        }
        int x16 = QCirclePluginGlobalInfo.x(true);
        QLog.d("QFSMainMultiTabFragmentPart", 1, "handleSchemaType: " + x16);
        if (x16 != -1) {
            this.V = x16;
            this.W = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hb(List<QQCircleFeedBase$StTabInfo> list) {
        if (list != null && list.size() != 0) {
            QCirclePluginGlobalInfo.Z(false);
            ub(j60.a.e(list));
        } else {
            QLog.e("QFSMainMultiTabFragmentPart", 1, "handleTabInfoRsp() return unexpected data\uff01");
        }
    }

    private void hc() {
        int i3 = this.I;
        if (i3 == -1) {
            return;
        }
        rc(i3);
        gc(this.I, false, false, false);
    }

    private void ib(int i3) {
        boolean z16;
        if (this.D.size() <= i3) {
            return;
        }
        if (!Gb(i3) && !Db(i3)) {
            z16 = true;
        } else {
            z16 = false;
        }
        for (com.tencent.biz.qqcircle.immersive.views.h hVar : this.f87404i) {
            if (hVar != null) {
                hVar.n(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic() {
        QQCircleCounter$RedPointInfo friendRedPointInfoByAppId = QCircleHostRedPointHelper.getFriendRedPointInfoByAppId(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        if (friendRedPointInfoByAppId == null) {
            return;
        }
        com.tencent.biz.qqcircle.helpers.y.g().v(friendRedPointInfoByAppId);
    }

    private void jb(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (!aSEngineTabStatusEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)) {
            return;
        }
        if (aSEngineTabStatusEvent.isSelected()) {
            long h16 = com.tencent.biz.qqcircle.helpers.y.g().h();
            if (sa()) {
                long j3 = this.f87400e0;
                if (j3 != 0 && h16 == j3) {
                    QLog.d("QFSMainMultiTabFragmentPart", 1, "receive onTab selected event but not need dealWith,reason reselect");
                    return;
                }
            }
            this.f87400e0 = h16;
            QLog.d("QFSMainMultiTabFragmentPart", 1, "receive onTab selected event");
            ab();
            ic();
            eb();
            Ya();
            fb();
            oc(this.J, true);
            j60.a.d(this.E, this.J);
            Ea();
        } else {
            j60.a.c(this.E, this.J);
            mc();
        }
        Ja(aSEngineTabStatusEvent);
    }

    private void jc() {
        QLog.d("QFSMainMultiTabFragmentPart", 1, "stashOutLayerRedPointInfo");
        com.tencent.biz.qqcircle.helpers.y.g().w(com.tencent.biz.qqcircle.helpers.y.e(getContext()));
        com.tencent.biz.qqcircle.helpers.y.g().a();
    }

    private void kb(QFSTabTitleVisibilityEvent qFSTabTitleVisibilityEvent) {
        float f16;
        if (qFSTabTitleVisibilityEvent == null) {
            return;
        }
        QLog.w("QFSMainMultiTabFragmentPart", 1, "handleTitleVisiableEvent: " + qFSTabTitleVisibilityEvent + ",mMultiTabsWrapper:" + this.f87399e);
        FrameLayout frameLayout = this.f87399e;
        if (frameLayout != null && frameLayout.getVisibility() != qFSTabTitleVisibilityEvent.getVisibility()) {
            if (qFSTabTitleVisibilityEvent.needAnimation()) {
                float f17 = 100.0f;
                if (qFSTabTitleVisibilityEvent.getVisibility() == 0) {
                    f16 = 30.0f;
                } else {
                    f16 = 100.0f;
                }
                if (qFSTabTitleVisibilityEvent.getVisibility() != 0) {
                    f17 = 0.0f;
                }
                ValueAnimator valueAnimator = this.P;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, f17);
                this.P = ofFloat;
                ofFloat.setDuration(qFSTabTitleVisibilityEvent.getDuration());
                this.P.addUpdateListener(new a());
                this.P.start();
            }
            this.f87399e.setVisibility(qFSTabTitleVisibilityEvent.getVisibility());
            return;
        }
        QLog.w("QFSMainMultiTabFragmentPart", 1, "handleTitleVisiableEvent status equals return");
    }

    private void kc() {
        try {
            if (this.C.size() < this.f87404i.size()) {
                QLog.d(getTAG(), 1, "triggerTabDTReport not ready:" + this.C.size() + "|" + this.f87404i.size());
                return;
            }
            for (int i3 = 0; i3 < this.f87404i.size(); i3++) {
                VideoReport.setElementId(this.f87404i.get(i3).a(), QCircleDaTongConstant.ElementId.EM_XSJ_TOP_TAB);
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAB_TITLE, this.C.get(i3).getTabName());
                VideoReport.setElementParams(this.f87404i.get(i3).a(), buildElementParams);
                VideoReport.reportEvent("dt_imp", this.f87404i.get(i3).a(), buildElementParams);
                if (QLog.isDevelopLevel()) {
                    QLog.d(getTAG(), 4, "triggerTabDTReport:" + i3 + "|" + this.C.get(i3));
                }
            }
        } catch (Exception e16) {
            QLog.d(getTAG(), 1, "triggerTabDTReport:" + e16.getMessage());
        }
    }

    private boolean lb(QFSFolderTabFragment qFSFolderTabFragment, QCircleTabInfo qCircleTabInfo) {
        if (qCircleTabInfo != null && qFSFolderTabFragment != null) {
            qFSFolderTabFragment.rh();
            return qFSFolderTabFragment.Mh();
        }
        return false;
    }

    private boolean mb(int i3) {
        for (int i16 = 0; i16 < this.E.size(); i16++) {
            if (Hb(i3, this.E.get(i16))) {
                return true;
            }
        }
        return false;
    }

    private void mc() {
        for (int i3 = 0; i3 < this.E.size(); i3++) {
            this.E.get(i3).oi();
        }
    }

    private void nb() {
        QFSFolderTabFragment qFSFolderTabFragment = this.R;
        if (qFSFolderTabFragment != null) {
            qFSFolderTabFragment.Lh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc() {
        com.tencent.biz.qqcircle.immersive.adapter.r rVar = this.f87403h;
        if (rVar != null) {
            Fragment item = rVar.getItem(this.J);
            if (!(item instanceof QFSFolderTabFragment)) {
                return;
            }
            QFSFolderTabFragment qFSFolderTabFragment = (QFSFolderTabFragment) item;
            this.R = qFSFolderTabFragment;
            QCircleTabInfo Eh = qFSFolderTabFragment.Eh();
            this.Q = Eh;
            if (Eh != null) {
                int type = Eh.getType();
                f87393g0 = type;
                rc(type);
            }
        }
    }

    private void ob() {
        if (QCircleApplication.isRDMVersion() && com.tencent.biz.qqcircle.f.E() != null && !QCirclePluginGlobalInfo.k().exptName.equals(com.tencent.biz.qqcircle.utils.h.a(R.string.f182603gx))) {
            View inflate = ((ViewStub) getPartRootView().findViewById(R.id.f32360tj)).inflate();
            if (inflate != null) {
                TextView textView = (TextView) inflate.findViewById(R.id.f110466il);
                ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).topMargin = ImmersiveUtils.getStatusBarHeight(inflate.getContext());
                textView.setText(QCirclePluginGlobalInfo.k().exptName);
                return;
            }
            QLog.e("QFSMainMultiTabFragmentPart", 1, "viewStub.inflate error");
        }
    }

    private void pa() {
        this.f87397d.m();
        this.f87397d.f(new e());
    }

    private void pb() {
        boolean z16;
        boolean z17 = false;
        if (uq3.c.X0("qqcircle", "qqcircle_need_save_zone_tab_selection", 0).intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f87395b0 = z16;
        if (uq3.c.X0("qqcircle", "qqcircle_need_sync_zone_tab", 0).intValue() == 1) {
            z17 = true;
        }
        this.f87396c0 = z17;
        QLog.d("QFSMainMultiTabFragmentPart", 1, "initExperiment, mIsRememberSubTabInfo: " + this.f87395b0 + ", mIsTransmitSubTabInfo: " + this.f87396c0);
    }

    private void qa() {
        this.f87401f.addOnPageChangeListener(new f());
    }

    private void qb() {
        Intent intent;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null && intent.hasExtra("key_bundle_common_init_bean")) {
            Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
            if (!(serializableExtra instanceof QCircleFolderBean)) {
                return;
            }
            this.I = ((QCircleFolderBean) serializableExtra).getAssignShowTabType();
            QLog.d("QFSMainMultiTabFragmentPart", 1, "[initIntentData] mAssignShowTabType: " + this.I);
        }
    }

    private void qc(List<QQCircleFeedBase$StTabInfo> list) {
        boolean w3 = QCirclePluginGlobalInfo.w();
        Iterator<QQCircleFeedBase$StTabInfo> it = list.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (it.next().tabType.get() == 9) {
                z16 = uq3.c.E();
            }
        }
        QLog.d("QFSMainMultiTabFragmentPart", 1, "[updateSchemaTabType] hasFriendTab : " + z16 + ", isFromPublish = " + w3);
        if (w3 && z16) {
            this.V = 9;
        }
    }

    private boolean ra() {
        if (Ib()) {
            return true;
        }
        QLog.e("QFSMainMultiTabFragmentPart", 1, "canAutoRefreshTab wns switch is close,mFragmentList size:" + this.E.size());
        return this.E.isEmpty();
    }

    private void rb(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.vg5);
        this.f87399e = frameLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.topMargin = com.tencent.biz.qqcircle.immersive.utils.r.K(view.getContext());
        this.f87399e.setLayoutParams(layoutParams);
        this.T = view.findViewById(R.id.f45721sn);
        this.U = view.findViewById(R.id.f52272_c);
        TabLayoutCompat tabLayoutCompat = (TabLayoutCompat) view.findViewById(R.id.f165304vg4);
        this.f87397d = tabLayoutCompat;
        tabLayoutCompat.setSelectedIndicatorNoShadowLayer();
        sc();
        this.f87397d.setSelectedTabIndicatorWidth(DisplayUtil.dip2px(getContext(), 20.0f));
        this.f87397d.setSelectedTabIndicatorHeight(DisplayUtil.dip2px(getContext(), 2.0f));
        this.f87397d.setSelectedTabIndicatorPaddingBottom(DisplayUtil.dip2px(getContext(), 8.0f));
        this.f87397d.setupWithViewPager(this.f87401f);
        this.f87397d.setOnScrollChangeListener(new c());
        this.f87397d.setViewPagerTabEventListener(new d());
        pa();
    }

    private void rc(int i3) {
        if (i3 == 1) {
            this.X = 501;
        } else if (i3 == 6) {
            this.X = 503;
        } else if (i3 == 9) {
            this.X = 504;
        } else if (i3 == 4) {
            this.X = 591;
        } else if (i3 == 8) {
            this.X = Integer.MAX_VALUE;
        }
        broadcastMessage("tab_changed_new_layer", Integer.valueOf(i3));
    }

    private boolean sa() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_folder_red_point_refresh_need_intercept_tab_re_select", true);
    }

    private void sb(View view) {
        this.f87403h = new com.tencent.biz.qqcircle.immersive.adapter.r(getHostFragment().getChildFragmentManager());
        QFSViewPager qFSViewPager = (QFSViewPager) view.findViewById(R.id.vg6);
        this.f87401f = qFSViewPager;
        registerIoc(qFSViewPager, this, t40.b.class);
        this.f87401f.setAdapter(this.f87403h);
        this.f87401f.setOffscreenPageLimit(100);
        qa();
    }

    private void sc() {
        this.f87397d.setTabMode(0);
        this.f87397d.setScrollableTabMinWidth(-2);
        this.f87397d.setTabGravity(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ta(int i3) {
        View findViewById;
        if (getActivity() == null || (findViewById = getActivity().findViewById(R.id.vfw)) == null) {
            return;
        }
        ib(i3);
        if (!Gb(i3) && !Db(i3)) {
            Resources resources = getActivity().getResources();
            if (resources != null) {
                findViewById.setBackgroundColor(resources.getColor(R.color.cje));
                return;
            } else {
                QLog.e("QFSMainMultiTabFragmentPart", 1, "getResources is null");
                return;
            }
        }
        findViewById.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_backplate));
    }

    private void tc() {
        hc();
        if (this.f87401f != null && this.f87397d != null) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_same_obj_remove_view_observer", true)) {
                ViewTreeObserver viewTreeObserver = this.f87397d.getViewTreeObserver();
                viewTreeObserver.addOnPreDrawListener(new g(viewTreeObserver));
            } else {
                QLog.d("QFSMainMultiTabFragmentPart", 1, "updateTargetTypeTab use old removeOnPreDrawListener");
                this.f87397d.getViewTreeObserver().addOnPreDrawListener(new h());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua(int i3) {
        Iterator<com.tencent.biz.qqcircle.immersive.views.h> it = this.f87404i.iterator();
        while (it.hasNext()) {
            it.next().g(this.f87397d, Gb(i3));
        }
        com.tencent.biz.qqcircle.immersive.utils.ay.b(this.f87404i, this.T, this.U);
    }

    private void ub(List<QQCircleFeedBase$StTabInfo> list) {
        if (list != null && list.size() != 0) {
            xa(list);
            bc(list);
            tc();
            Ya();
            SimpleEventBus.getInstance().dispatchEvent(new QFSInitTabEvent());
            return;
        }
        QLog.e("QFSMainMultiTabFragmentPart", 1, "initTabLayout invalid input data!");
    }

    private void va(boolean z16, boolean z17, int i3, QFSFolderTabFragment qFSFolderTabFragment) {
        if (!z16) {
            return;
        }
        if (qFSFolderTabFragment != null && z17 && i3 == 1 && EeveeRedpointUtil.getFollowTabFeedListLastPreRspTimestamp() <= EeveeRedpointUtil.getFollowTabFeedListLastRspTimestamp() && this.f87398d0.contains(1)) {
            qFSFolderTabFragment.fi();
            return;
        }
        if (qFSFolderTabFragment != null && ec() && i3 == 9 && this.f87398d0.contains(9)) {
            qFSFolderTabFragment.vh();
        } else if (qFSFolderTabFragment != null && !j60.a.h(qFSFolderTabFragment.Eh()) && z17) {
            qFSFolderTabFragment.fi();
        }
    }

    private void vb() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qfs_enable_gps_fetch_default", false)) {
            com.tencent.biz.qqcircle.c.e().g(getActivity(), true);
        }
        com.tencent.biz.qqcircle.viewmodels.j jVar = (com.tencent.biz.qqcircle.viewmodels.j) getViewModel(com.tencent.biz.qqcircle.viewmodels.j.class);
        this.F = jVar;
        if (jVar != null) {
            jVar.L1().observeForever(new DataObserverWrapper(this.Y));
        }
        QCirclePeriodCollect.record(QCirclePeriodCollect.PERIOD_REQUEST_TAB);
        Tb(false);
        ViewCompat.setPaddingRelative(this.f87397d, 0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(int i3, int i16) {
        int i17;
        if (this.E.size() > i3) {
            QCircleTabInfo Eh = this.E.get(i3).Eh();
            if (Eh != null) {
                i17 = Eh.getType();
            } else {
                i17 = 0;
            }
            QLog.d("QFSMainMultiTabFragmentPart", 1, "[checkPageSelected] pos: ", Integer.valueOf(i3), " | triggerCallback: ", Integer.valueOf(i16), " | tabType: ", Integer.valueOf(i17));
            if (i16 == 1) {
                QCircleLpReportDc05504.report(Sa(i17, false));
            } else if (i16 == 2) {
                QCircleLpReportDc05504.report(Sa(i17, true));
            }
            kc();
        }
    }

    private void wb() {
        if (this.I == 8) {
            return;
        }
        if (!QFSTopViewManager.e().f() && !QFSEcommerceTopViewManager.b().c()) {
            this.f87399e.setVisibility(0);
        } else {
            this.f87399e.setVisibility(4);
        }
    }

    private void xa(List<QQCircleFeedBase$StTabInfo> list) {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        QLog.d("QFSMainMultiTabFragmentPart", 1, "checkShowTabType schemaTabType : " + this.V);
        if (this.V != -1) {
            qc(list);
            this.I = this.V;
            this.W = true;
            return;
        }
        int m3 = k30.e.i().m();
        if (QCircleHostGlobalInfo.isNeedRestoreFolderUI() && m3 != -1) {
            this.I = m3;
            QLog.d("QFSMainMultiTabFragmentPart", 1, "[checkShowTabType] isOrientationChange: true. lastShowTabTypeCache: " + m3 + ",mAssignShowTabType: " + this.I);
            return;
        }
        if (com.tencent.biz.qqcircle.utils.bp.b()) {
            this.I = com.tencent.biz.qqcircle.utils.bp.a();
            QLog.d("QFSMainMultiTabFragmentPart", 1, "[checkShowTabType] restore from rebuild " + this.I);
            return;
        }
        if (com.tencent.biz.qqcircle.helpers.y.g().n() && com.tencent.biz.qqcircle.helpers.y.g().l() > 0) {
            this.I = com.tencent.biz.qqcircle.helpers.y.g().l();
            return;
        }
        QCircleTabInfo qCircleTabInfo = this.Q;
        if (qCircleTabInfo != null && (qQCircleFeedBase$StTabInfo = qCircleTabInfo.mTab) != null) {
            this.I = qQCircleFeedBase$StTabInfo.tabType.get();
            QLog.d("QFSMainMultiTabFragmentPart", 1, "[checkShowTabType] load from currentTabInfo, mAssignShowTabType: " + this.I);
            return;
        }
        if (this.I == -1) {
            this.I = QCirclePluginGlobalInfo.n();
        }
        QLog.d("QFSMainMultiTabFragmentPart", 1, "[checkShowTabType] firstShowTabSourceType:" + this.I);
    }

    private boolean xb() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_folder_schema_intercept_red_point_jump", false)) {
            return false;
        }
        QLog.d("QFSMainMultiTabFragmentPart", 1, "[interceptRedPointJump] mEnterBySchema: " + this.W);
        return this.W;
    }

    private boolean yb(QFSFolderTabFragment qFSFolderTabFragment) {
        if (qFSFolderTabFragment == null || qFSFolderTabFragment.Eh() == null || qFSFolderTabFragment.Eh().mTab == null || qFSFolderTabFragment.Eh().mTab.tabType.get() != 6) {
            return false;
        }
        return true;
    }

    private void za() {
        QFSFolderTabFragment qFSFolderTabFragment = this.R;
        if (qFSFolderTabFragment != null) {
            qFSFolderTabFragment.hi();
        }
    }

    public boolean Bb() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_folder_reset_index_when_tab_select", true);
    }

    public void Ea() {
        for (int i3 = 0; i3 < this.E.size(); i3++) {
            QFSFolderTabFragment qFSFolderTabFragment = this.E.get(i3);
            if (qFSFolderTabFragment != null) {
                qFSFolderTabFragment.Xh();
            }
        }
    }

    public boolean Fb() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_folder_red_point_jump_tab_use_need_refresh_flag", true)) {
            if (com.tencent.biz.qqcircle.helpers.y.g().t() && com.tencent.biz.qqcircle.helpers.y.g().l() > 0) {
                return true;
            }
            return false;
        }
        if (com.tencent.biz.qqcircle.helpers.y.g().n() && com.tencent.biz.qqcircle.helpers.y.g().l() > 0) {
            return true;
        }
        return false;
    }

    public String Ma() {
        QFSFolderTabFragment qFSFolderTabFragment = this.R;
        if (qFSFolderTabFragment != null) {
            return qFSFolderTabFragment.getDaTongPageId();
        }
        return "";
    }

    public int Na() {
        if (this.R != null && uq3.c.d0()) {
            return this.R.getPageId();
        }
        return this.X;
    }

    public int Oa() {
        QCircleTabInfo qCircleTabInfo = this.Q;
        if (qCircleTabInfo != null) {
            return qCircleTabInfo.getType();
        }
        return 6;
    }

    public void Te(boolean z16) {
        this.f87402f0 = z16;
        RFWLog.d("QFSMainMultiTabFragmentPart", RFWLog.USR, "setFragmentCanRestore:" + z16);
    }

    public f60.a Ua(int i3) {
        if (this.f87405m.size() > i3) {
            return this.f87405m.get(i3);
        }
        return null;
    }

    public boolean Uf() {
        return this.f87402f0;
    }

    public com.tencent.biz.qqcircle.immersive.views.h Wa(int i3) {
        if (this.f87404i.size() > i3) {
            return this.f87404i.get(i3);
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void beforeFinish() {
        super.beforeFinish();
        if (this.Q != null && this.f87402f0) {
            k30.e.i().u(this.Q.getType());
        }
        for (QFSFolderTabFragment qFSFolderTabFragment : this.E) {
            if (qFSFolderTabFragment != null) {
                qFSFolderTabFragment.beforeFinish();
            }
        }
    }

    public void gc(int i3, boolean z16, boolean z17, boolean z18) {
        QLog.d("QFSMainMultiTabFragmentPart", 1, "[showSelectTab] targetShowTabType: " + i3 + " | smoothScroll: " + z16 + " | refresh: " + z18 + " | scrollToTop: " + z17);
        if (i3 < 0) {
            return;
        }
        QLog.d("QFSMainMultiTabFragmentPart", 1, "[showSelectTab] targetShowTabType = " + i3 + ", smoothScroll = " + z16 + ", scrollToTop = " + z17);
        boolean z19 = false;
        int i16 = -1;
        QFSFolderTabFragment qFSFolderTabFragment = null;
        int i17 = 0;
        while (true) {
            if (i17 >= this.E.size()) {
                break;
            }
            QFSFolderTabFragment qFSFolderTabFragment2 = this.E.get(i17);
            if (yb(qFSFolderTabFragment2)) {
                i16 = i17;
                qFSFolderTabFragment = qFSFolderTabFragment2;
            }
            if (Hb(i3, qFSFolderTabFragment2)) {
                Ha(z16, i17);
                Ga(z17, qFSFolderTabFragment2);
                Fa(z18, qFSFolderTabFragment2);
                z19 = true;
                break;
            }
            i17++;
        }
        if (!z19 && qFSFolderTabFragment != null) {
            QLog.d("QFSMainMultiTabFragmentPart", 1, "[showSelectTab] targetShowTabType not find: " + i3);
            Ha(z16, i16);
            Ga(z17, qFSFolderTabFragment);
            Fa(z18, qFSFolderTabFragment);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(e40.b.class);
        arrayList.add(QCircleSelectTabEvent.class);
        arrayList.add(QCircleFeedOptEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        arrayList.add(QFSRecSwitchChangeEvent.class);
        arrayList.add(QFSTabTitleVisibilityEvent.class);
        arrayList.add(QFSRefreshMainTabEvent.class);
        arrayList.add(QFSMainTabNetworkDataEvent.class);
        arrayList.add(QCircleRedPointEvent.class);
        arrayList.add(QCircleConfigChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMainMultiTabFragmentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.equals(str, "action_get_fragment")) {
            return this.R;
        }
        return super.getMessage(str, obj);
    }

    public void oc(int i3, boolean z16) {
        for (final int i16 = 0; i16 < this.E.size(); i16++) {
            f60.a Ua = Ua(i16);
            QCircleTabInfo Eh = this.E.get(i16).Eh();
            if (Ua != null && Eh != null && Eh.mTab != null) {
                if (i16 == i3) {
                    va(z16, lb(this.E.get(i16), Eh), Eh.getType(), this.E.get(i16));
                    za();
                    nb();
                    Ua.d();
                    this.f87398d0.add(Integer.valueOf(Eh.getType()));
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.cw
                        @Override // java.lang.Runnable
                        public final void run() {
                            QFSMainMultiTabFragmentPart.this.Mb(i16);
                        }
                    });
                } else {
                    Ua.g();
                    Mb(i16);
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        for (QFSFolderTabFragment qFSFolderTabFragment : this.E) {
            if (qFSFolderTabFragment != null) {
                qFSFolderTabFragment.onBackEvent();
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TabLayoutCompat tabLayoutCompat = this.f87397d;
        if (tabLayoutCompat != null) {
            tabLayoutCompat.D();
        }
    }

    @Override // t40.b
    public void onHandlerMessage(String str, Object... objArr) {
        t40.b bVar = this.G;
        if (bVar != null) {
            bVar.onHandlerMessage(str, objArr);
        }
        if (TextUtils.equals(str, "event_open_comment")) {
            broadcastMessage("comment_panel_show", objArr[0]);
            return;
        }
        if (TextUtils.equals(str, "event_hide_comment")) {
            broadcastMessage("comment_panel_dismiss", null);
            return;
        }
        if (TextUtils.equals(str, "event_open_comment_input")) {
            broadcastMessage("comment_input_window_show", objArr[0]);
            return;
        }
        if (TextUtils.equals(str, "event_open_share")) {
            broadcastMessage("share_action_show_share_sheet", objArr[0]);
            return;
        }
        if (TextUtils.equals(str, "event_silent_share")) {
            broadcastMessage("share_action_silent_share", objArr[0]);
            return;
        }
        if (TextUtils.equals(str, "event_layer_head_view_refresh_status")) {
            Za(objArr);
            return;
        }
        if (TextUtils.equals(str, "event_open_friend_push_panel")) {
            broadcastMessage("light_interact_list_show", objArr[0]);
            return;
        }
        if (TextUtils.equals(str, "event_open_push_progress_panel")) {
            broadcastMessage("open_push_progress_panel", objArr[0]);
            return;
        }
        if (TextUtils.equals(str, "event_open_push_mission_panel")) {
            broadcastMessage("open_push_mission_panel", objArr[0]);
        } else if (TextUtils.equals(str, "event_community_sub_tab_select")) {
            Xa(objArr);
        } else if (TextUtils.equals(str, "event_open_similar_panel")) {
            broadcastMessage("action_open_similar_panel", objArr[0]);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        sb(view);
        rb(view);
        tb();
        qb();
        vb();
        wb();
        ob();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.G = (t40.b) getIocInterface(t40.b.class);
        SimpleEventBus.getInstance().registerReceiver(this);
        ab();
        ic();
        this.V = QCirclePluginGlobalInfo.x(true);
        pb();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_folder_default_trigger_lazy_load", false)) {
            QLog.d("QFSMainMultiTabFragmentPart", 1, "main tab send lazy load event");
            QFSLazyLoadUtils.d(getContext());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.f87402f0 && this.Q != null && com.tencent.biz.qqcircle.utils.bz.t()) {
            k30.e.i().u(this.Q.getType());
        }
        QCircleTabInfo qCircleTabInfo = this.Q;
        if (qCircleTabInfo != null) {
            com.tencent.biz.qqcircle.utils.bp.c(qCircleTabInfo.getType());
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ValueAnimator valueAnimator = this.P;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.P.cancel();
            this.P = null;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.W = false;
        QLog.d(getTAG(), 1, "onPartPause");
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        kc();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleSelectTabEvent) {
            QCircleSelectTabEvent qCircleSelectTabEvent = (QCircleSelectTabEvent) simpleBaseEvent;
            final int i3 = qCircleSelectTabEvent.tabType;
            final boolean z16 = qCircleSelectTabEvent.needScrollTop;
            final boolean z17 = qCircleSelectTabEvent.needSmoothScroll;
            final boolean z18 = qCircleSelectTabEvent.needRefresh;
            final boolean z19 = qCircleSelectTabEvent.fromSchema;
            getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart.9
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("QFSMainMultiTabFragmentPart", 1, "handle QCircleSelectTabEvent fromSchema:" + z19 + ",tabType:" + i3);
                    if (!QFSMainMultiTabFragmentPart.this.Bb()) {
                        QFSMainMultiTabFragmentPart.this.W = true;
                    } else if (z19) {
                        QFSMainMultiTabFragmentPart.this.W = true;
                        QFSMainMultiTabFragmentPart.this.V = i3;
                    }
                    QFSMainMultiTabFragmentPart.this.gb(i3);
                    QFSMainMultiTabFragmentPart.this.gc(i3, z17, z16, z18);
                    if (((QCircleSelectTabEvent) simpleBaseEvent).needDownOnePage) {
                        QFSMainMultiTabFragmentPart.this.R.ei(1);
                    }
                }
            });
            return;
        }
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            jb((ASEngineTabStatusEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSRecSwitchChangeEvent) {
            bb((QFSRecSwitchChangeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTabTitleVisibilityEvent) {
            kb((QFSTabTitleVisibilityEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSRefreshMainTabEvent) {
            Tb(true);
            return;
        }
        if (simpleBaseEvent instanceof QFSMainTabNetworkDataEvent) {
            Vb(((QFSMainTabNetworkDataEvent) simpleBaseEvent).tabInfos);
        } else if (simpleBaseEvent instanceof QCircleRedPointEvent) {
            cb((QCircleRedPointEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.cu
                @Override // java.lang.Runnable
                public final void run() {
                    QFSMainMultiTabFragmentPart.this.Lb();
                }
            }, 500L);
        }
    }

    private void tb() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements ViewPager.OnPageChangeListener {
        f() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            QLog.d("QFSMainMultiTabFragmentPart", 1, "onPageScrollStateChanged :" + i3);
            if (i3 == 1) {
                QFSMainMultiTabFragmentPart.this.f87394a0 = true;
                QFSMainMultiTabFragmentPart.this.dc(true);
            } else if (i3 == 0) {
                QFSMainMultiTabFragmentPart.this.f87394a0 = false;
                QFSMainMultiTabFragmentPart.this.dc(false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            QFSMainMultiTabFragmentPart.this.Ob(i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }
}
