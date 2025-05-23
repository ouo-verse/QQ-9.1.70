package com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFeedDetailRspInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.events.QFSThemeChangeEvent;
import com.tencent.biz.qqcircle.helpers.y;
import com.tencent.biz.qqcircle.immersive.events.QFSExitFoldCacheSaveEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFeedPositionChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFoldFullScreenChangeEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.m;
import com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.lazyload.QFSLazyLoadUtils;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.qcircle.api.IQCircleColdBootServiceV2;
import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.event.QFSRedPointFeedAddEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSRedPointFeedRemoveEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.data.base.DataObserverWrapper;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tmassistantbase.util.GlobalUtil;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleCounter$RedPointInfo;

/* loaded from: classes4.dex */
public class QFSLayerTabPart extends QFSLayerBasePart {
    public static String P = "TAB_TYPE_FOLLOW";
    public static String Q = "TAB_TYPE_RECOMMEND";
    public static String R = "TAB_TYPE_NEARBY";
    private QCircleInitBean C;
    private boolean D;
    private boolean F;
    private volatile boolean H;
    private final int J;
    private boolean K;
    private QFSFeedPositionChangeEvent N;

    /* renamed from: d, reason: collision with root package name */
    private final QCircleTabInfo f86625d;

    /* renamed from: e, reason: collision with root package name */
    private int f86626e;

    /* renamed from: f, reason: collision with root package name */
    private QFSTabFeedViewModel f86627f;

    /* renamed from: h, reason: collision with root package name */
    private t40.b f86628h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f86629i;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f86630m;
    private final Observer<UIStateData<List<e30.b>>> E = new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.e
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            QFSLayerTabPart.this.Z9((UIStateData) obj);
        }
    };
    private volatile boolean G = true;
    private boolean I = false;
    private boolean L = true;
    private final Runnable M = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSLayerTabPart.1
        @Override // java.lang.Runnable
        public void run() {
            QLog.d("FeedLine_QFSLayerTabPart", 1, "prePullRedFeed ");
            QFSLayerTabPart.this.Qa(false);
            QCircleFolderBean Y9 = QFSLayerTabPart.this.Y9();
            if (QFSLayerTabPart.this.f86627f != null) {
                QFSLayerTabPart.this.f86627f.r2().F(new m.a().c("pre_pull").m(1).j(Y9).f(false).g(false).e(false).n(QFSLayerTabPart.this.getReportBean()).k(QFSLayerTabPart.this.f86629i));
            } else {
                QLog.d("FeedLine_QFSLayerTabPart", 1, "prePullRedFeed but mFeedViewModel is null");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Observer<UIStateData<QCircleFeedDetailRspInfo>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<QCircleFeedDetailRspInfo> uIStateData) {
            QFSLayerTabPart.this.ba(uIStateData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Observer<String> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            ((QFSLayerBasePart) QFSLayerTabPart.this).mPlayPageReport.K(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements Observer<Long> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            ((QFSLayerBasePart) QFSLayerTabPart.this).mPlayPageReport.L(l3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements QFSPageTurnContainer.j {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.j
        public void a(boolean z16) {
            QFSLayerTabPart.this.za(z16, 1, -1.0f);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.j
        public void b(boolean z16) {
            QFSLayerTabPart.this.za(z16, 4, -1.0f);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.j
        public void c(boolean z16, float f16) {
            QFSLayerTabPart.this.za(z16, 3, f16);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.j
        public void onComplete(boolean z16) {
            QFSLayerTabPart.this.za(z16, 2, -1.0f);
        }
    }

    public QFSLayerTabPart(QCircleInitBean qCircleInitBean, QCircleTabInfo qCircleTabInfo) {
        this.C = qCircleInitBean;
        ia();
        this.f86625d = qCircleTabInfo;
        this.J = R9(qCircleTabInfo);
        this.f86626e = 0;
    }

    private void Ca(byte[] bArr) {
        Object valueOf;
        String tag = getTAG();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("putRedDotTransInfo ");
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        QLog.e(tag, 1, sb5.toString());
        this.f86630m = bArr;
        QFSTabFeedViewModel qFSTabFeedViewModel = this.f86627f;
        if (qFSTabFeedViewModel == null) {
            return;
        }
        if (bArr != null && bArr.length != 0) {
            qFSTabFeedViewModel.r2().C(bArr);
            this.f86627f.n3("common_reddot_insert_info");
            this.f86627f.e2(QCircleReportHelper.newEntry("common_reddot_insert_info", this.f86630m));
        } else {
            QLog.e(getTAG(), 1, "wrapRedDotTransInfo no data,direct return!");
            this.f86627f.n3("common_reddot_insert_info");
        }
    }

    private void Da(int i3) {
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null && !ab0.a.a(i3, mVar.getDataList()) && getHostFragment() != null && getHostFragment().isResumed()) {
            w20.a.j().v(this.mLayerPageAdapter.getDataList().get(i3).g());
        }
    }

    private void Ea(@NonNull UIStateData<List<e30.b>> uIStateData) {
        boolean z16;
        String str;
        if (uIStateData.getState() != 5 && uIStateData.getState() != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        String valueOf = String.valueOf(this.f86625d.getSource());
        String str2 = QCirclePeriodCollect.PERIOD_NOTIFY_PAGE_BY_CACHE;
        if (z16) {
            str = QCirclePeriodCollect.PERIOD_NOTIFY_PAGE_BY_CACHE;
        } else {
            str = QCirclePeriodCollect.PERIOD_NOTIFY_PAGE_BY_NET;
        }
        QCirclePeriodCollect.record(valueOf, str);
        if (ta()) {
            QCirclePeriodCollect.record(String.valueOf(this.f86625d.getSource()), QCirclePeriodCollect.PERIOD_PAGE_LOADED);
        }
        String valueOf2 = String.valueOf(this.f86625d.getSource());
        if (!z16) {
            str2 = QCirclePeriodCollect.PERIOD_NOTIFY_PAGE_BY_NET;
        }
        QCirclePeriodCollect.flushPeriodReport(valueOf2, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ka(int i3) {
        int type;
        QFSFeedPositionChangeEvent qFSFeedPositionChangeEvent = this.N;
        if (qFSFeedPositionChangeEvent == null) {
            this.N = new QFSFeedPositionChangeEvent(i3);
        } else {
            qFSFeedPositionChangeEvent.setPosition(i3);
        }
        e30.b bVar = (e30.b) RFSafeListUtils.get(this.mLayerPageAdapter.getDataList(), this.mCurrentFeedPos);
        this.N.setFeedData(bVar);
        QFSFeedPositionChangeEvent qFSFeedPositionChangeEvent2 = this.N;
        QCircleTabInfo qCircleTabInfo = this.f86625d;
        if (qCircleTabInfo == null) {
            type = 0;
        } else {
            type = qCircleTabInfo.getType();
        }
        qFSFeedPositionChangeEvent2.setTabType(type);
        SimpleEventBus.getInstance().dispatchEvent(this.N);
        this.f86627f.Y2(i3, bVar);
        com.tencent.biz.qqcircle.immersive.manager.c.d().b(getDtPageId(), bVar, i3);
    }

    private boolean N9() {
        if (6 != this.f86625d.getType() && 9 != this.f86625d.getType()) {
            return false;
        }
        return true;
    }

    private void P9() {
        QCircleTabInfo qCircleTabInfo = this.f86625d;
        if (qCircleTabInfo == null) {
            return;
        }
        int type = qCircleTabInfo.getType();
        boolean z16 = false;
        if (type != 1) {
            if (type != 6) {
                if (type == 9) {
                    QQCircleCounter$RedPointInfo friendRedPointInfoByAppId = QCircleHostRedPointHelper.getFriendRedPointInfoByAppId(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
                    if (friendRedPointInfoByAppId != null && friendRedPointInfoByAppId.redType.get() == 9 && friendRedPointInfoByAppId.showType.get() != 0) {
                        z16 = true;
                    }
                    this.f86629i = z16;
                }
            } else {
                byte[] bArr = this.f86630m;
                if (bArr != null && bArr.length > 0) {
                    z16 = true;
                }
                this.f86629i = z16;
            }
        } else {
            QQCircleCounter$RedPointInfo smallRedPointInfotByAppid = QCircleHostRedPointHelper.getSmallRedPointInfotByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
            if (smallRedPointInfotByAppid != null && smallRedPointInfotByAppid.rptRedInfo.size() > 0) {
                z16 = true;
            }
            this.f86629i = z16;
        }
        QLog.d("FeedLine_QFSLayerTabPart", 1, "checkHasRedDot result:" + this.f86629i);
    }

    private String Q9(int i3) {
        if (i3 != 1) {
            if (i3 != 6) {
                return R;
            }
            return Q;
        }
        return P;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qa(boolean z16) {
        QCircleTabInfo qCircleTabInfo = this.f86625d;
        if (qCircleTabInfo == null) {
            return;
        }
        this.mPlayPageReport.I(qCircleTabInfo.getType(), y.g().l(), y.g().k(), y.g().t(), y.g().c());
        if (this.f86625d.getType() == 6) {
            Ca(y.g().m(z16));
            return;
        }
        if (this.f86625d.getType() == 9) {
            byte[] f16 = y.g().f(z16);
            if (f16 != null && f16.length != 0) {
                Ca(f16);
            } else if (y.g().l() == 9) {
                Ca(y.g().m(z16));
            }
        }
    }

    private int R9(QCircleTabInfo qCircleTabInfo) {
        if (qCircleTabInfo == null) {
            return -1;
        }
        int type = qCircleTabInfo.getType();
        if (type != 6) {
            if (type != 9) {
                return -1;
            }
            return 75;
        }
        return 10000;
    }

    private void S9(final t40.d dVar) {
        QLog.d("FeedLine_QFSLayerTabPart", 1, "doDispatchExitCacheSaveEvent do");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.g
            @Override // java.lang.Runnable
            public final void run() {
                QFSLayerTabPart.this.va(dVar);
            }
        });
    }

    private boolean T9() {
        boolean z16 = false;
        if (this.H) {
            QLog.d("FeedLine_QFSLayerTabPart", 1, "doSaveCache but have save by memory cache");
            return false;
        }
        if (!this.L) {
            QLog.d("FeedLine_QFSLayerTabPart", 1, "doSaveCache but mFragmentCanRestore false");
            return false;
        }
        if (bz.t()) {
            QLog.d("FeedLine_QFSLayerTabPart", 1, "doSaveCache reason isSupportSplitViewMode");
            k30.e.i().w();
        } else {
            if (!QCirclePluginUtil.isTabMode()) {
                QLog.d("FeedLine_QFSLayerTabPart", 1, "doSaveCache reason not tab mode");
            }
            Ia(true, z16);
            return z16;
        }
        z16 = true;
        Ia(true, z16);
        return z16;
    }

    private boolean U9() {
        return !QCirclePluginGlobalInfo.E();
    }

    private int Z9() {
        return this.J;
    }

    private void aa(@NonNull final UIStateData<QCircleFeedDetailRspInfo> uIStateData) {
        QLog.d("FeedLine_QFSLayerTabPart", 1, "FeedLine_handleFeedDetailResp :" + uIStateData.getState());
        if (uIStateData.getState() == 3) {
            QCircleFeedDetailRspInfo data = uIStateData.getData();
            if (data == null) {
                return;
            }
            List<e30.b> list = data.feeds;
            List<e30.b> feedList = getFeedList();
            if (list != null && feedList != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    e30.b bVar = list.get(i3);
                    if (bVar != null) {
                        int i16 = 0;
                        while (true) {
                            if (i16 >= feedList.size()) {
                                break;
                            }
                            e30.b bVar2 = feedList.get(i16);
                            if (bVar2 != null && TextUtils.equals(bVar2.g().f398449id.get(), bVar.g().f398449id.get())) {
                                bVar2.m(bVar);
                                triggerFullDetailFeed(bVar2, i16);
                                QLog.d("FeedLine_QFSLayerTabPart", 1, "FeedLine_handleFeedDetailResp triggerFeedReplace feedId:" + bVar2.g().f398449id.get() + ", pos:" + i16);
                                break;
                            }
                            i16++;
                        }
                    }
                }
                if (isContainerOnScreen()) {
                    QLog.d("FeedLine_QFSLayerTabPart", 1, "FeedLine_handleFeedDetailResp noticeRightPersonalData");
                    noticeRightPersonalData(this.mCurrentFeedPos);
                }
                notifyPostFeedChange(false, "TYPE_SELECT_FEED_LOAD_DETAIL");
                return;
            }
            QLog.d("FeedLine_QFSLayerTabPart", 1, "FeedLine_handleFeedDetailResp feeds:" + list + ", originFeedList:" + feedList);
            return;
        }
        if (uIStateData.getState() == 4) {
            getLayerPageAdapter().I0(new ArrayList(), true, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSLayerTabPart.8
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("FeedLine_QFSLayerTabPart", 1, "FeedLine_handleFeedDetailResp noticeError");
                    QFSLayerTabPart.this.f86627f.j().postValue(UIStateData.obtainError(uIStateData.getMsg()).setRetCode(uIStateData.getRetCode()));
                }
            });
        }
    }

    private void ca(QFSFoldFullScreenChangeEvent qFSFoldFullScreenChangeEvent) {
        Activity activity = getActivity();
        if (qFSFoldFullScreenChangeEvent == null || activity == null || activity.hashCode() != qFSFoldFullScreenChangeEvent.getHashCode()) {
            return;
        }
        this.L = false;
        t40.d dVar = (t40.d) getIocInterface(t40.d.class);
        if (dVar != null) {
            dVar.Te(false);
        }
        QLog.d("FeedLine_QFSLayerTabPart", 1, "handlerFoldFullScreenEvent");
        Ia(true, true);
        if (!qFSFoldFullScreenChangeEvent.isEnter() && getTabType() == 6) {
            S9(dVar);
        }
    }

    private void da(@NonNull QFSRedPointFeedAddEvent qFSRedPointFeedAddEvent) {
        if (qFSRedPointFeedAddEvent.getSource() != Z9() || !this.K) {
            return;
        }
        if (kc0.a.g()) {
            QLog.d("FeedLine_QFSLayerTabPart", 1, "[handlerRedPointFeedAddEvent] tab is select");
            return;
        }
        QFSTabFeedViewModel qFSTabFeedViewModel = this.f86627f;
        if (qFSTabFeedViewModel != null) {
            qFSTabFeedViewModel.D3(getContext(), qFSRedPointFeedAddEvent.getFeedListRsp(), this.mCurrentFeedPos);
        }
    }

    private void ea(@NonNull QFSRedPointFeedRemoveEvent qFSRedPointFeedRemoveEvent) {
        if (qFSRedPointFeedRemoveEvent.getSource() != Z9() || !this.K) {
            return;
        }
        if (kc0.a.g()) {
            QLog.d("FeedLine_QFSLayerTabPart", 1, "[handlerRedPointFeedRemoveEvent] tab is select");
            return;
        }
        QFSTabFeedViewModel qFSTabFeedViewModel = this.f86627f;
        if (qFSTabFeedViewModel != null) {
            qFSTabFeedViewModel.A3();
        }
    }

    private void ga() {
        QLog.d("FeedLine_QFSLayerTabPart", 1, "handlerThemeChangeEvent");
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_main_tab_save_feed_when_theme_change", true)) {
            QLog.d("FeedLine_QFSLayerTabPart", 1, "handlerThemeChangeEvent return from config");
        } else {
            this.H = true;
            Ia(true, true);
        }
    }

    private String getDtPageId() {
        QCircleReportBean reportBean = getReportBean();
        if (reportBean == null) {
            return "";
        }
        return reportBean.getDtPageId();
    }

    private void ia() {
        Intent intent;
        if (getActivity() != null && this.C == null && (intent = getActivity().getIntent()) != null && intent.hasExtra("key_bundle_common_init_bean")) {
            Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
            if (serializableExtra instanceof QCircleInitBean) {
                this.C = (QCircleInitBean) serializableExtra;
            }
        }
    }

    private void initLayerPageContainerListener() {
        this.mLayerPageContainer.setOnRefreshViewStatusListener(new d());
        this.mLayerPageContainer.setOnPositionChangeToDataOutListener(new QFSPageTurnContainer.i() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.f
            @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.i
            public final QFSPageTurnContainer.f a(int i3, boolean z16) {
                QFSPageTurnContainer.f wa5;
                wa5 = QFSLayerTabPart.this.wa(i3, z16);
                return wa5;
            }
        });
    }

    private void initListener() {
        this.f86627f.j().observeForever(new DataObserverWrapper(this.E));
        if (N9()) {
            this.f86627f.q2().observeForever(new a());
        }
        this.f86627f.t2().observeForever(new b());
        this.f86627f.u2().observeForever(new c());
    }

    private IDataDisplaySurface<e30.b> ma() {
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null) {
            mVar.getDataList();
        }
        QFSTabFeedViewModel qFSTabFeedViewModel = (QFSTabFeedViewModel) getHostFragment().getViewModel(QFSTabFeedViewModel.class);
        this.f86627f = qFSTabFeedViewModel;
        qFSTabFeedViewModel.y3(this.f86625d);
        this.f86627f.z3(this.mFeedWasteCollector);
        na();
        oa();
        w20.a.j().registerDisplaySurface(String.valueOf(this.f86625d.getType()), this.f86627f);
        this.f86627f.H2(Q9(this.f86625d.getType()));
        initListener();
        return this.f86627f;
    }

    private void na() {
        if (6 == this.f86625d.getType()) {
            this.f86627f.J2(this.mLayerPageAdapter);
        }
    }

    private void oa() {
        if (r.q0(this.f86625d.getType())) {
            this.f86627f.K2(this.mLayerPageAdapter);
            QLog.d("FeedLine_QFSLayerTabPart", 1, "[injectPublishSuccessTabScroller] mTabInfo.getType() =" + this.f86625d.getType() + ", enableJumpFriendTabAfterPublish() = " + uq3.c.E());
        }
    }

    private boolean pa() {
        QFSTabFeedViewModel.c value;
        QFSTabFeedViewModel qFSTabFeedViewModel = this.f86627f;
        if (qFSTabFeedViewModel == null || (value = qFSTabFeedViewModel.v2().getValue()) == null) {
            return false;
        }
        return value.f86648g;
    }

    private boolean qa() {
        UIStateData<QCircleFeedDetailRspInfo> value;
        if (!N9() || (value = this.f86627f.q2().getValue()) == null || value.getState() != 4) {
            return false;
        }
        return true;
    }

    private boolean ra() {
        UIStateData<QCircleFeedDetailRspInfo> value;
        if (!N9() || (value = this.f86627f.q2().getValue()) == null || value.getState() != 1) {
            return false;
        }
        return true;
    }

    private boolean sa() {
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() || uq3.c.X0("qqcircle", "qqcircle_enable_preload_on_study_mode", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    private boolean ua() {
        if (getHostFragment() instanceof QFSFolderTabFragment) {
            return ((QFSFolderTabFragment) getHostFragment()).Rh();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void va(t40.d dVar) {
        if (dVar != null) {
            int lc5 = dVar.lc();
            RFWLog.d("FeedLine_QFSLayerTabPart", RFWLog.USR, "[doDispatchExitCacheSaveEvent] currentTabType:" + lc5);
            k30.e.i().u(lc5);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSExitFoldCacheSaveEvent(getActivityHashCode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ QFSPageTurnContainer.f wa(int i3, boolean z16) {
        List<e30.b> dataList;
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar == null) {
            dataList = null;
        } else {
            dataList = mVar.getDataList();
        }
        return v30.b.f(dataList, i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xa() {
        this.mLayerPageContainer.o(true);
        this.mLayerPageContainer.p(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void za(boolean z16, int i3, float f16) {
        int type;
        if (z16) {
            return;
        }
        e40.b bVar = new e40.b(i3);
        bVar.d(f16);
        QCircleTabInfo qCircleTabInfo = this.f86625d;
        if (qCircleTabInfo == null) {
            type = 0;
        } else {
            type = qCircleTabInfo.getType();
        }
        bVar.e(type);
        t40.b bVar2 = this.f86628h;
        if (bVar2 != null) {
            bVar2.onHandlerMessage("event_layer_head_view_refresh_status", bVar);
        }
    }

    public void Aa() {
        QFSTabFeedViewModel qFSTabFeedViewModel;
        if (QCirclePluginUtil.isQFSTabNativeFragmentMode(getActivity()) && (qFSTabFeedViewModel = this.f86627f) != null) {
            qFSTabFeedViewModel.x3(Z9());
        }
    }

    public void Ba() {
        runOnActivityUiThread(this.M, uq3.c.R0());
    }

    public void Fa(int i3) {
        QFSTabFeedViewModel qFSTabFeedViewModel;
        if (ra()) {
            QLog.d(getTAG(), 1, "refreshContent but isLoadingFeedDetail");
        } else if (Oa(i3) && (qFSTabFeedViewModel = this.f86627f) != null && qFSTabFeedViewModel.i3(i3)) {
            QLog.d(getTAG(), 1, "refreshContent use local refresh");
        } else {
            this.mLayerPageContainer.h(i3);
        }
    }

    public void Ga(boolean z16, boolean z17, boolean z18, int i3) {
        if (this.f86627f == null) {
            return;
        }
        if (pa() && !this.I) {
            QLog.e(getTAG(), 1, "requestData()  but currentShowRedPointScreen");
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.d
                @Override // java.lang.Runnable
                public final void run() {
                    QFSLayerTabPart.this.xa();
                }
            });
            return;
        }
        if (z16) {
            if (qa() || ra()) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSLayerTabPart.6
                    @Override // java.lang.Runnable
                    public void run() {
                        ((QFSLayerBasePart) QFSLayerTabPart.this).mLayerPageContainer.o(true);
                    }
                });
                QLog.i(getTAG(), 1, "requestData() loadMore but is is load simple feed");
                return;
            }
        } else {
            this.f86627f.q2().postValue(null);
        }
        ja();
        if (z16) {
            QLog.i(getTAG(), 1, "requestData() loadMore");
            if (uq3.c.H()) {
                Qa(true);
            }
            this.f86627f.r2().F(new m.a().c("load_more").l(z18).j(Y9()).n(getReportBean()).m(this.f86626e));
            return;
        }
        QLog.i(getTAG(), 1, "requestData() refresh");
        if (Oa(i3) && this.f86627f.i3(i3)) {
            QLog.i(getTAG(), 1, "requestData() refresh from local");
        } else {
            Qa(true);
            this.f86627f.r2().F(new m.a().c("refresh").m(this.f86626e).j(Y9()).n(getReportBean()).f(true));
        }
    }

    public void Ha() {
        Ga(true, false, true, 1);
    }

    protected void Ia(boolean z16, boolean z17) {
        String str;
        int i3;
        String tag = getTAG();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("savePageCache");
        QCircleTabInfo qCircleTabInfo = this.f86625d;
        if (qCircleTabInfo != null) {
            str = qCircleTabInfo.getName();
        } else {
            str = GlobalUtil.DEF_STRING;
        }
        sb5.append(str);
        sb5.append(",needSaveDisk:");
        sb5.append(z16);
        sb5.append(",needSaveMemory:");
        sb5.append(z17);
        QLog.d(tag, 1, sb5.toString());
        if (z17) {
            k30.e.i().w();
        }
        try {
            if (this.f86627f != null) {
                QFSPageTurnContainer qFSPageTurnContainer = this.mLayerPageContainer;
                if (qFSPageTurnContainer != null) {
                    i3 = qFSPageTurnContainer.B().getCurrentItem();
                } else {
                    i3 = 0;
                }
                if (this.mLayerPageAdapter.getDataList() != null && this.mLayerPageAdapter.getDataList().size() != 0) {
                    this.f86627f.q3(this.mLayerPageAdapter.getDataList());
                    if (z16) {
                        this.f86627f.r3("CACHE_TYPE_DISK", i3, 0);
                    }
                    if (z17) {
                        this.f86627f.r3("CACHE_TYPE_MEMORY", i3, 0);
                    } else {
                        this.f86627f.g2();
                    }
                }
            }
        } catch (Exception e16) {
            RFWLog.e("FeedLine_QFSLayerTabPart", RFWLog.USR, "savePageCache error:" + e16);
        }
    }

    protected void Ja(int i3, boolean z16) {
        QFSPageTurnContainer qFSPageTurnContainer;
        if (this.mLayerPageAdapter != null && (qFSPageTurnContainer = this.mLayerPageContainer) != null) {
            int currentItem = qFSPageTurnContainer.B().getCurrentItem();
            QLog.d("FeedLine_QFSLayerTabPart", 1, "[scrollToPosition], position: " + i3 + ", currentItem: " + currentItem);
            if (currentItem != i3) {
                this.mLayerPageAdapter.onFeedUnSelected(new RFWFeedSelectInfo(currentItem).setUnSelectedType("TYPE_UNSELECTED_SCROLL_TO_POS"));
                this.mLayerPageContainer.B().setCurrentItem(i3, z16);
            }
        }
    }

    public void La(int i3, boolean z16) {
        try {
            Ja(i3, z16);
        } catch (Throwable th5) {
            RFWLog.d("FeedLine_QFSLayerTabPart", RFWLog.USR, "[setCurrentItemPos] error: ", th5);
        }
    }

    public void Ma(boolean z16) {
        this.D = z16;
    }

    public void Na() {
        QLog.d("FeedLine_QFSLayerTabPart", 1, "setRedPointScreenConsumeFlag");
        Qa(true);
        QFSTabFeedViewModel qFSTabFeedViewModel = this.f86627f;
        if (qFSTabFeedViewModel != null) {
            qFSTabFeedViewModel.x3(Z9());
        }
        QFSPageTurnContainer qFSPageTurnContainer = this.mLayerPageContainer;
        if (qFSPageTurnContainer != null) {
            int q16 = qFSPageTurnContainer.q();
            this.mLayerPageContainer.k(this.mCurrentFeedPos, q16);
            this.mLayerPageContainer.i(this.mCurrentFeedPos, q16);
        }
    }

    public boolean O9() {
        QFSTabFeedViewModel qFSTabFeedViewModel = this.f86627f;
        if (qFSTabFeedViewModel == null) {
            return false;
        }
        return qFSTabFeedViewModel.N2();
    }

    public boolean Oa(int i3) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    public void Pa() {
        QFSTabFeedViewModel qFSTabFeedViewModel;
        IPreloadTask task = ((IQCircleColdBootServiceV2) QRoute.api(IQCircleColdBootServiceV2.class)).getTask(Z9());
        if (task == null) {
            return;
        }
        Object preloadRsp = task.getPreloadRsp();
        if (preloadRsp instanceof FeedCloudRead$StGetFeedListRsp) {
            FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = (FeedCloudRead$StGetFeedListRsp) preloadRsp;
            QLog.d("FeedLine_QFSLayerTabPart", 1, "[trySwitchToPreloadRedPointScreen] preloadRsp feed size:" + feedCloudRead$StGetFeedListRsp.vecFeed.size());
            if (!feedCloudRead$StGetFeedListRsp.vecFeed.isEmpty() && (qFSTabFeedViewModel = this.f86627f) != null) {
                qFSTabFeedViewModel.D3(getContext(), feedCloudRead$StGetFeedListRsp, this.mCurrentFeedPos);
            }
        }
    }

    public FeedCloudMeta$StFeed V9() {
        e30.b W9 = W9();
        if (W9 != null) {
            return W9.g();
        }
        return null;
    }

    public e30.b W9() {
        QFSPageTurnContainer qFSPageTurnContainer;
        e30.b C0;
        if (this.mLayerPageAdapter == null || (qFSPageTurnContainer = this.mLayerPageContainer) == null || qFSPageTurnContainer.B() == null || (C0 = this.mLayerPageAdapter.C0(this.mLayerPageContainer.B().getCurrentItem())) == null) {
            return null;
        }
        return C0;
    }

    public int X9() {
        QFSPageTurnContainer qFSPageTurnContainer = this.mLayerPageContainer;
        if (qFSPageTurnContainer != null && qFSPageTurnContainer.B() != null) {
            return this.mLayerPageContainer.B().getCurrentItem();
        }
        return -1;
    }

    protected QCircleFolderBean Y9() {
        if (getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().hasExtra("key_bundle_common_init_bean")) {
            return (QCircleFolderBean) getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
        }
        return null;
    }

    public void ba(UIStateData<QCircleFeedDetailRspInfo> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        if (uIStateData.isLoading()) {
            QLog.d("FeedLine_QFSLayerTabPart", 1, "FeedLine_handleFeedDetailStatus loading");
            this.mLayerPageContainer.setTouchEnable(false);
            return;
        }
        QLog.d("FeedLine_QFSLayerTabPart", 1, "FeedLine_handleFeedDetailStatus :" + uIStateData.getState());
        aa(uIStateData);
        this.mLayerPageContainer.setTouchEnable(true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QFSRedPointFeedRemoveEvent.class);
        eventClass.add(QFSRedPointFeedAddEvent.class);
        eventClass.add(QFSThemeChangeEvent.class);
        eventClass.add(QFSFoldFullScreenChangeEvent.class);
        eventClass.add(ASEngineTabStatusEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.c
    public int getFeedSourceType() {
        QCircleTabInfo qCircleTabInfo = this.f86625d;
        if (qCircleTabInfo == null) {
            return 0;
        }
        return qCircleTabInfo.getSource();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public QCircleInitBean getInitBean() {
        ia();
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public int getLayerPageType() {
        return 1;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        String name;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("FeedLine_QFSLayerTabPart_");
        QCircleTabInfo qCircleTabInfo = this.f86625d;
        if (qCircleTabInfo == null) {
            name = "null";
        } else {
            name = qCircleTabInfo.getName();
        }
        sb5.append(name);
        return sb5.toString();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.c
    public int getTabType() {
        QCircleTabInfo qCircleTabInfo = this.f86625d;
        if (qCircleTabInfo == null) {
            return 0;
        }
        return qCircleTabInfo.getType();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public Drawable getTransitionLoadingDrawable() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public String getViewModelKey() {
        QCircleTabInfo qCircleTabInfo = this.f86625d;
        if (qCircleTabInfo != null) {
            return String.valueOf(qCircleTabInfo.getType());
        }
        return super.getViewModelKey();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected IDataDisplaySurface<e30.b> getViewModelSurface() {
        return ma();
    }

    public boolean ha() {
        if (this.F) {
            return true;
        }
        this.F = true;
        getMainHandler().removeCallbacksAndMessages(this.M);
        la();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void handleEmptyState() {
        QCircleStatusView qCircleStatusView;
        hideLoadingView();
        if (isEmptyContent() && (qCircleStatusView = this.mFaultHintView) != null) {
            qCircleStatusView.w0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    /* renamed from: handleFeedRsp */
    public void Z9(UIStateData<List<e30.b>> uIStateData) {
        QLog.d("FeedLine_QFSLayerTabPart", 1, "handleFeedRsp mFeedViewModel:" + this.f86627f + ",this:" + this);
        if ((qa() || ra()) && uIStateData.getState() != 3 && uIStateData.getState() != 4 && uIStateData.getState() != 1 && uIStateData.getState() != 0) {
            QLog.e("FeedLine_QFSLayerTabPart", 1, "handleFeedRsp but is load detail feed info, rsp uiStateData\uff1a" + uIStateData.getState());
            return;
        }
        List<e30.b> data = uIStateData.getData();
        if (data != null && data.size() >= 2) {
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_HAVE_MORE_FEED_TIME);
        }
        super.Z9(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void handleSuccessState(UIStateData<List<e30.b>> uIStateData, boolean z16) {
        if (N9() && this.G) {
            this.G = false;
            new com.tencent.biz.qqcircle.immersive.repository.foldertab.j(this.f86627f).k(uIStateData.getData());
        }
        super.handleSuccessState(uIStateData, z16);
        Ea(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void initPageReport(Activity activity) {
        boolean isInLocalActivity = QCirclePluginUtil.isInLocalActivity(getActivity());
        this.K = isInLocalActivity;
        this.mPlayPageReport.J(isInLocalActivity);
        QCircleTabInfo qCircleTabInfo = this.f86625d;
        if (qCircleTabInfo != null && qCircleTabInfo.getType() == 6) {
            this.mPlayPageReport.C();
        }
        super.initPageReport(activity);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public boolean isContainerOnScreen() {
        if (getHostFragment() != null) {
            return getHostFragment().isResumed();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public boolean isEmptyContent() {
        Boolean bool = (Boolean) broadcastGetMessage("get_pymk_is_empty", null);
        if (bool == null) {
            return super.isEmptyContent();
        }
        if (super.isEmptyContent() && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    protected void ja() {
        boolean ua5 = ua();
        this.f86626e = !ua5 ? 1 : 0;
        QLog.d(getTAG(), 1, "initPullSceneType isRealVisibleToUser :" + ua5 + ",SceneType : " + this.f86626e);
    }

    protected void la() {
        String str;
        String str2;
        boolean z16;
        Qa(true);
        ja();
        QCircleFolderBean Y9 = Y9();
        P9();
        FeedCloudMeta$StFeed d16 = QCirclePluginGlobalInfo.d();
        if (d16 != null) {
            str = d16.f398449id.get();
        } else {
            str = null;
        }
        this.mPlayPageReport.G(str);
        if (Y9 != null && Y9.isForceFromNetwork()) {
            QLog.d("FeedLine_QFSLayerTabPart", 1, "[initViewData] forceNetwork,fastPlayFeedId:" + str);
            this.mPlayPageReport.B("disk_cache_mode", "1");
            this.f86627f.r2().F(new m.a().c("init").m(this.f86626e).j(Y9).f(false).g(false).e(false).i(d16).n(getReportBean()).k(this.f86629i).d(uq3.o.p()));
            return;
        }
        QLog.d("FeedLine_QFSLayerTabPart", 1, "[initViewData] default, fastPlayFeedId:" + str);
        boolean U9 = U9();
        com.tencent.biz.qqcircle.immersive.report.f fVar = this.mPlayPageReport;
        if (U9) {
            str2 = "0";
        } else {
            str2 = "2";
        }
        fVar.B("disk_cache_mode", str2);
        if (Y9 != null) {
            z16 = Y9.isForceFromPushPreloadCache();
        } else {
            z16 = false;
        }
        this.f86627f.r2().F(new m.a().c("init").m(this.f86626e).j(Y9).f(U9).g(sa()).e(true).i(d16).h(z16).n(getReportBean()).k(this.f86629i).d(uq3.o.p()));
        QCirclePluginGlobalInfo.Y(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void noticeLazyLoadRightPersonalPage(boolean z16) {
        if (!z16 && ta()) {
            QFSLazyLoadUtils.d(getContext());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected void noticeRightPersonalData(int i3) {
        e30.b bVar;
        Da(i3);
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar == null || ab0.a.a(i3, mVar.getDataList()) || !ua() || getContext() == null || this.f86625d == null || (bVar = this.mLayerPageAdapter.getDataList().get(i3)) == null) {
            return;
        }
        FeedCloudMeta$StFeed g16 = bVar.g();
        e40.j jVar = new e40.j();
        jVar.f395620a = g16;
        jVar.f395621b = g16.poster.get();
        jVar.f395622c = i3;
        w20.a.j().l(getContext().hashCode()).postValue(jVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void notifyCurrentFeedChange(final int i3) {
        super.notifyCurrentFeedChange(i3);
        if (ua()) {
            if (this.mIsNeedDelaySendFeedChangeEvent) {
                RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSLayerTabPart.7
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d(QFSLayerTabPart.this.getTAG(), 1, "sendPositionChangeEvent... delay");
                        QFSLayerTabPart.this.Ka(i3);
                    }
                }, 600L, true);
                this.mIsNeedDelaySendFeedChangeEvent = false;
            } else {
                Ka(i3);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.b
    public void onHandlerMessage(String str, Object... objArr) {
        t40.b bVar = this.f86628h;
        if (bVar != null) {
            bVar.onHandlerMessage(str, objArr);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        initLayerPageContainerListener();
        if (ta()) {
            ha();
        }
        this.mLayerPageContainer.setLoadMoreBottomMargin(QCirclePluginUtil.getBottomMarginHeight(getActivity()));
        com.tencent.mobileqq.qui.b.f276860a.a(this.mLayerPageContainer, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
        if (this.f86625d.getType() == 6) {
            this.mLayerPageContainer.setLoadMorePreloadNum(uq3.c.l2());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.f86628h = (t40.b) getIocInterface(t40.b.class);
        P9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        com.tencent.biz.qqcircle.immersive.adapter.m mVar;
        super.onPartDestroy(activity);
        if (this.f86627f != null && (mVar = this.mLayerPageAdapter) != null && mVar.getDataList() != null && this.mLayerPageAdapter.getDataList().size() != 0) {
            this.f86627f.s3(this.mLayerPageAdapter.getDataList());
            k30.h.f().p(null);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        e30.b W9;
        super.onPartPause(activity);
        if (this.I && (W9 = W9()) != null) {
            k30.h.f().p(W9);
        }
        this.I = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        QFSTabFeedViewModel qFSTabFeedViewModel;
        super.onPartResume(activity);
        this.I = true;
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null && mVar.getDataList() != null && this.mLayerPageAdapter.getDataList().size() > 2) {
            QLog.d("FeedLine_QFSLayerTabPart", 1, "onPartResume: recording PERIOD_HAVE_MORE_FEED_TIME ");
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_HAVE_MORE_FEED_TIME);
        }
        if (!QCirclePluginUtil.isQFSTabNativeFragmentMode(activity) && (qFSTabFeedViewModel = this.f86627f) != null) {
            qFSTabFeedViewModel.x3(Z9());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        QLog.d("FeedLine_QFSLayerTabPart", 1, "onPartStop do save cache");
        T9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSRedPointFeedAddEvent) {
            da((QFSRedPointFeedAddEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSRedPointFeedRemoveEvent) {
            ea((QFSRedPointFeedRemoveEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSThemeChangeEvent) {
            ga();
        } else if (simpleBaseEvent instanceof QFSFoldFullScreenChangeEvent) {
            ca((QFSFoldFullScreenChangeEvent) simpleBaseEvent);
        }
        super.onReceiveEvent(simpleBaseEvent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void requestData(boolean z16, boolean z17) {
        Ga(z16, z17, false, 0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected void requestDataByTouchType(boolean z16, boolean z17, int i3) {
        Ga(z16, z17, false, i3);
    }

    public boolean ta() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void checkEmptyContentOperation() {
    }
}
