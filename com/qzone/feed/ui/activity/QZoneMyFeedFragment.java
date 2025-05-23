package com.qzone.feed.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.common.activities.base.CustomListViewFragment;
import com.qzone.common.activities.base.QZoneBaseFeedFragment;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.feed.business.model.BusinessMyRelationData;
import com.qzone.feed.business.service.QZoneAllowJoinAlbumService;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.feed.ui.activity.NoticeBannerConfProxy;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.reborn.feedx.activity.QZoneFriendFeedXActivity;
import com.qzone.util.ToastUtil;
import com.qzone.widget.QZonePullToRefreshListView;
import com.qzone.widget.aa;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqperf.tools.PerformanceReportUtils;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.TimeCostTrace;
import d5.ab;
import d5.o;
import d5.q;
import d5.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneMyFeedFragment extends QZoneBaseFeedFragment<com.qzone.common.activities.titlebuilder.a> {

    /* renamed from: y1, reason: collision with root package name */
    private static int f47293y1 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FEED_PSVADV_SHOW_POS, 1);

    /* renamed from: j1, reason: collision with root package name */
    private TextView f47294j1;

    /* renamed from: k1, reason: collision with root package name */
    private TextView f47295k1;

    /* renamed from: m1, reason: collision with root package name */
    private View f47297m1;

    /* renamed from: n1, reason: collision with root package name */
    private View f47298n1;

    /* renamed from: o1, reason: collision with root package name */
    private boolean f47299o1;

    /* renamed from: p1, reason: collision with root package name */
    private QZoneFeedService f47300p1;

    /* renamed from: r1, reason: collision with root package name */
    private long f47302r1;

    /* renamed from: s1, reason: collision with root package name */
    private View f47303s1;

    /* renamed from: t1, reason: collision with root package name */
    private e f47304t1;

    /* renamed from: u1, reason: collision with root package name */
    private boolean f47305u1;

    /* renamed from: v1, reason: collision with root package name */
    public com.qzone.homepage.ui.component.a f47306v1;

    /* renamed from: w1, reason: collision with root package name */
    private ViewGroup f47307w1;

    /* renamed from: l1, reason: collision with root package name */
    private ArrayList<BusinessMyRelationData> f47296l1 = new ArrayList<>();

    /* renamed from: q1, reason: collision with root package name */
    private boolean f47301q1 = false;

    /* renamed from: x1, reason: collision with root package name */
    private boolean f47308x1 = false;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class RemovePosTask implements Runnable {
        RemovePosTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u5.b.z0("MyFeed_Pause_Pos");
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class SavePausePosTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f47318d;

        SavePausePosTask(int i3) {
            this.f47318d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            u5.b.q0("MyFeed_Pause_Pos", this.f47318d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements com.qzone.widget.b {
        a() {
        }

        @Override // com.qzone.widget.b
        public void a(aa aaVar) {
            if (QZoneMyFeedFragment.this.f47305u1) {
                QZoneMyFeedFragment.this.f47305u1 = false;
                if (((CustomListViewFragment) QZoneMyFeedFragment.this).E == null || ((CustomListViewFragment) QZoneMyFeedFragment.this).E.j0() == null) {
                    return;
                }
                ((CustomListViewFragment) QZoneMyFeedFragment.this).E.j0().removeHeaderView(QZoneMyFeedFragment.this.f47303s1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneMyFeedFragment.this.f47307w1.removeView(view);
            QZoneMyFeedFragment.this.f47307w1.setVisibility(8);
            QZoneMyFeedFragment.this.f47308x1 = true;
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void bk() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.bz8, (ViewGroup) null);
        this.f47303s1 = inflate;
        if (inflate != null) {
            e eVar = new e(inflate);
            this.f47304t1 = eVar;
            eVar.setFinishListener(new a());
        }
    }

    private void ck() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.bqw, (ViewGroup) null);
        this.f47298n1 = inflate;
        if (inflate != null) {
            View findViewById = inflate.findViewById(R.id.f58);
            this.f47297m1 = findViewById;
            findViewById.setContentDescription(getResources().getString(R.string.gqn));
            this.f47294j1 = (TextView) this.f47298n1.findViewById(R.id.f166373f53);
            this.f47295k1 = (TextView) this.f47298n1.findViewById(R.id.f166374f54);
            this.E.j0().addHeaderView(this.f47298n1);
        }
        hk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ek(int i3) {
        if (!this.f47299o1 && this.f47296l1.size() > 0) {
            if (this.f47296l1.size() <= i3) {
                i3 = 0;
            }
            BusinessMyRelationData businessMyRelationData = this.f47296l1.get(i3);
            final Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.f155029h5);
            loadAnimation.setAnimationListener(new b(i3 + 1));
            Animation loadAnimation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.f155028h4);
            loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.feed.ui.activity.QZoneMyFeedFragment.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (QZoneMyFeedFragment.this.f47296l1.size() > 1) {
                        QZoneMyFeedFragment.this.getHandler().postDelayed(new Runnable() { // from class: com.qzone.feed.ui.activity.QZoneMyFeedFragment.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QZoneMyFeedFragment.this.f47294j1.startAnimation(loadAnimation);
                                QZoneMyFeedFragment.this.f47295k1.startAnimation(loadAnimation);
                            }
                        }, 2000L);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.f47295k1.setText(businessMyRelationData.nickname);
            this.f47294j1.setText(businessMyRelationData.actiondesc);
            this.f47294j1.startAnimation(loadAnimation2);
            this.f47295k1.startAnimation(loadAnimation2);
        }
    }

    private void fk(boolean z16) {
        ViewGroup viewGroup = this.f47307w1;
        if (viewGroup != null) {
            viewGroup.setVisibility(z16 ? 0 : 8);
        }
    }

    private void hk() {
        ArrayList<BusinessMyRelationData> arrayList = this.f47296l1;
        if (arrayList != null && arrayList.size() > 0) {
            this.E.j0().addHeaderView(this.f47298n1);
            this.f47297m1.setVisibility(0);
        } else {
            this.E.j0().removeHeaderView(this.f47298n1);
            this.f47297m1.setVisibility(8);
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f47301q1 = intent.getBooleanExtra("FromNotification", false);
        }
        this.f47300p1 = QZoneFeedService.b0(this.f47301q1);
        ki();
        this.D = new QZoneMyFeedAdapter(this, this.E.j0());
        this.E.j0().setAdapter((ListAdapter) this.D);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.feed.ui.activity.QZoneMyFeedFragment.2
            @Override // java.lang.Runnable
            public void run() {
                QZoneMyFeedFragment.this.f47300p1.Q0();
                if (LocalMultiProcConfig.getInt4Uin("qzone_preget_passive_open", 0, LoginData.getInstance().getUin()) == 1) {
                    String string4Uin = LocalMultiProcConfig.getString4Uin("qzone_passive_undealtime", "", LoginData.getInstance().getUin());
                    if (!TextUtils.isEmpty(string4Uin)) {
                        QZoneWriteOperationService.v0().M(string4Uin);
                        LocalMultiProcConfig.putString4Uin("qzone_passive_undeal_readtime", string4Uin, LoginData.getInstance().getUin());
                    }
                    int int4Uin = LocalMultiProcConfig.getInt4Uin("qzone_passive_need_refresh", 1, LoginData.getInstance().getUin());
                    if (int4Uin == 1 || !QZoneMyFeedFragment.this.f47300p1.f0()) {
                        QZLog.i(BaseFragment.TAG, 1, "refreshFeed 0" + int4Uin);
                        QZoneMyFeedFragment.this.mj(0L);
                        return;
                    }
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.feed.ui.activity.QZoneMyFeedFragment.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneFeedAlertService.getInstance().clearSingleUnreadCount(1);
                            if (QZLog.isColorLevel()) {
                                QZLog.d("QzoneRedTypeInfo", 2, "qzone redtypeinfo:my feed space is loading finish , reddot is clear");
                            }
                        }
                    });
                    QZoneMyFeedFragment.this.getHandler().post(new Runnable() { // from class: com.qzone.feed.ui.activity.QZoneMyFeedFragment.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneMyFeedFragment qZoneMyFeedFragment = QZoneMyFeedFragment.this;
                            qZoneMyFeedFragment.dj(qZoneMyFeedFragment.si() != null ? QZoneMyFeedFragment.this.si().H() : false);
                        }
                    });
                    return;
                }
                QZLog.i(BaseFragment.TAG, 1, "refreshFeed 1");
                QZoneMyFeedFragment.this.mj(0L);
            }
        });
    }

    private void initUI() {
        setTitle(QZoneConfigHelper.c0());
        Ki();
        ck();
        bk();
        Hi(this.f47298n1);
        Ii();
        Dh(true);
        dk();
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragment
    protected boolean Gh() {
        return true;
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment
    protected boolean Ni() {
        return true;
    }

    public void gk(BusinessFeedData businessFeedData) {
        BusinessFeedData businessFeedData2;
        if (this.E == null) {
            return;
        }
        for (int i3 = 0; i3 < this.E.getCount(); i3++) {
            View childAt = this.E.getChildAt(i3);
            if (childAt != null && (childAt instanceof AbsFeedView)) {
                AbsFeedView absFeedView = (AbsFeedView) childAt;
                if ((absFeedView instanceof FeedView) && (businessFeedData2 = absFeedView.mFeedData) == businessFeedData) {
                    businessFeedData2.getLocalInfoV2().canJoinAlbum = false;
                    businessFeedData2.getLocalInfoV2().joinedAlbum = true;
                    absFeedView.updateMenuArea(businessFeedData2);
                }
            }
        }
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment, com.qzone.common.activities.base.CustomListViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        TextCellLayout.setIsInMsgPage(true);
        this.f45257t0 = "qzone_myfeed";
        PerfTracer.traceStart(PerfTracer.MYFEED_ONCREATE);
        super.onCreate(bundle);
        PerfTracer.traceStart(PerfTracer.MYFEED_INITUI);
        initUI();
        PerfTracer.trace(PerfTracer.MYFEED_INITUI, PerfTracer.MYFEED_INITDATA);
        initData();
        PerfTracer.traceEnd(PerfTracer.MYFEED_INITDATA);
        try {
            QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
            if (qQNotificationManager != null) {
                qQNotificationManager.cancel("QZoneMyFeedActivity.onCreate", 241);
            }
            y yVar = this.G0;
            if (yVar != null) {
                yVar.a(241);
            }
        } catch (Exception e16) {
            QZLog.e(BaseFragment.TAG, "NotificationManager cancel exception", e16);
        }
        this.f47306v1 = new com.qzone.homepage.ui.component.a(getActivity());
        PerfTracer.traceEnd(PerfTracer.MYFEED_ONCREATE);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        finish();
        if (!this.f47301q1) {
            return true;
        }
        QZoneHelper.forwardToQZoneFriendFeedActivity(getActivity(), new Intent(getActivity(), (Class<?>) QZoneFriendFeedXActivity.class), false);
        return true;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.qzone.common.activities.base.ActivityCallBackInterface
    public void onBackPressed() {
        onBackEvent();
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new RemovePosTask());
        BaseAdapter baseAdapter = this.D;
        if (baseAdapter != null) {
            ((QZoneMyFeedAdapter) baseAdapter).d();
        }
        QZoneFeedService qZoneFeedService = this.f47300p1;
        if (qZoneFeedService != null) {
            qZoneFeedService.close();
        }
        QZonePullToRefreshListView qZonePullToRefreshListView = this.E;
        if (qZonePullToRefreshListView != null) {
            qZonePullToRefreshListView.setAdapter((ListAdapter) this.D);
        }
        super.onDestroy();
        com.qzone.homepage.ui.component.a aVar = this.f47306v1;
        if (aVar != null) {
            aVar.c();
        }
        com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().recyleFeedView(false, this.f45261x0);
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment, com.qzone.common.activities.base.CustomListViewFragment, com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        int i3 = message.what;
        if (i3 == 2) {
            BusinessFeedData businessFeedData = (BusinessFeedData) message.obj;
            int i16 = message.arg1;
            if (businessFeedData == null || !checkNetworkConnect()) {
                return;
            }
            QZoneFeedService qZoneFeedService = this.f47300p1;
            if (qZoneFeedService != null) {
                qZoneFeedService.Z0(businessFeedData, true);
            }
            if (QZLog.isDevelopLevel()) {
                QZLog.i(QZLog.TO_DEVICE_TAG, 4, "send view report,gdtfeed_feedkey:" + businessFeedData.getFeedCommInfo().feedskey + " gdtfeed_content:" + businessFeedData.getCellSummary().summary + " index=" + i16);
            }
            if (businessFeedData.isBrandUgcAdvFeeds()) {
                com.qzone.misc.network.report.f.n(businessFeedData);
                return;
            }
            return;
        }
        if (i3 == 602) {
            u5.b.q0("photo_status", 2);
            return;
        }
        if (i3 == 30530) {
            this.D.notifyDataSetChanged();
            return;
        }
        if (i3 != 1000196) {
            return;
        }
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && unpack.getSucceed() && (unpack.getData() instanceof Bundle)) {
            Bundle bundle = (Bundle) unpack.getData();
            if (bundle.getInt("ret_code", 0) == 0) {
                gk((BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, "allow_feed"));
                return;
            }
            return;
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastAllowJoinAlbumFail", "\u64cd\u4f5c\u5931\u8d25");
        if (unpack != null && !unpack.getSucceed() && !TextUtils.isEmpty(unpack.getMessage())) {
            config = unpack.getMessage();
        }
        ToastUtil.s(config, 4);
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment, com.qzone.common.activities.base.CustomListViewFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        int i3;
        PerfTracer.traceStart(PerfTracer.MYFEED_ONRESUME);
        TextCellLayout.setIsInMsgPage(true);
        super.onResume();
        TextCellLayout.f50567b2 = true;
        this.f47299o1 = false;
        ek(0);
        if (this.f47302r1 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f47302r1;
            this.f47302r1 = 0L;
            String stringExtra = getIntent().getStringExtra("refer");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (stringExtra.equals(QZoneHelper.QZoneAppConstants.REFER_MSG_NOTIFICATION)) {
                i3 = 8;
            } else if (stringExtra.equals(QZoneHelper.QZoneAppConstants.REFER_PUSH_BANNER)) {
                i3 = 7;
            } else {
                i3 = stringExtra.equals("getActiveFeeds") ? 9 : -1;
            }
            if (i3 > 0 && currentTimeMillis > 0) {
                if (QZLog.isDevelopLevel()) {
                    QZLog.i(TimeCostTrace.TAG_QZONE_LAUNCH, 4, "uiSwitch launchCost:" + currentTimeMillis);
                }
                PerformanceReportUtils.j(BaseApplication.getContext(), LoginData.getInstance().getUinString(), i3, currentTimeMillis);
            }
        }
        e eVar = this.f47304t1;
        if (eVar != null && !eVar.e()) {
            NoticeBannerConfProxy.a().b(new NoticeBannerConfProxy.c() { // from class: com.qzone.feed.ui.activity.QZoneMyFeedFragment.3
                @Override // com.qzone.feed.ui.activity.NoticeBannerConfProxy.c
                public void a(final NoticeBannerConfProxy.b bVar) {
                    if (bVar != null && bVar.f47289a) {
                        QZoneMyFeedFragment.this.getHandler().post(new Runnable() { // from class: com.qzone.feed.ui.activity.QZoneMyFeedFragment.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (QZoneMyFeedFragment.this.f47304t1 == null || QZoneMyFeedFragment.this.isFinishing() || QZoneMyFeedFragment.this.isDestroyed()) {
                                    return;
                                }
                                if (QZoneMyFeedFragment.this.f47305u1) {
                                    e eVar2 = QZoneMyFeedFragment.this.f47304t1;
                                    NoticeBannerConfProxy.b bVar2 = bVar;
                                    eVar2.h(bVar2.f47290b, bVar2.f47291c);
                                    return;
                                }
                                QZoneMyFeedFragment.this.f47305u1 = true;
                                if (((CustomListViewFragment) QZoneMyFeedFragment.this).E == null || ((CustomListViewFragment) QZoneMyFeedFragment.this).E.j0() == null) {
                                    return;
                                }
                                ((CustomListViewFragment) QZoneMyFeedFragment.this).E.j0().addHeaderView(QZoneMyFeedFragment.this.f47303s1);
                                e eVar3 = QZoneMyFeedFragment.this.f47304t1;
                                NoticeBannerConfProxy.b bVar3 = bVar;
                                eVar3.h(bVar3.f47290b, bVar3.f47291c);
                                QZoneMyFeedFragment.this.f47304t1.f();
                            }
                        });
                    } else {
                        QZoneMyFeedFragment.this.getHandler().post(new Runnable() { // from class: com.qzone.feed.ui.activity.QZoneMyFeedFragment.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (QZoneMyFeedFragment.this.f47305u1) {
                                    QZoneMyFeedFragment.this.f47305u1 = false;
                                    if (((CustomListViewFragment) QZoneMyFeedFragment.this).E == null || ((CustomListViewFragment) QZoneMyFeedFragment.this).E.j0() == null) {
                                        return;
                                    }
                                    ((CustomListViewFragment) QZoneMyFeedFragment.this).E.j0().removeHeaderView(QZoneMyFeedFragment.this.f47303s1);
                                }
                            }
                        });
                    }
                }
            });
        }
        com.qzone.homepage.ui.component.a aVar = this.f47306v1;
        if (aVar != null) {
            aVar.e();
        }
        PerfTracer.traceEnd(PerfTracer.MYFEED_ONRESUME);
        PerfTracer.traceClick2Completed(this);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment
    @Inject(type = "com.qzone.feed.ui.activity.MyFeedFragmentFeedPresenterImp")
    public void setFeedPresenterInf(o oVar) {
        super.setFeedPresenterInf(oVar);
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment
    @Inject
    @Named("MyFeedFragmentForbiddenViewImp")
    public void setForbiddenViewInf(q qVar) {
        super.setForbiddenViewInf(qVar);
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    @Inject
    @Named("MyFeedFragmentReporter")
    public void setReporterInf(ab abVar) {
        super.setReporterInf(abVar);
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment
    public com.qzone.feed.business.service.a si() {
        return this.f47300p1;
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment
    protected String yi() {
        return "key_passive_feed_refresh_last_timestamp";
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.f47299o1 = true;
        TextCellLayout.setIsInMsgPage(false);
        QZonePullToRefreshListView qZonePullToRefreshListView = this.E;
        if (qZonePullToRefreshListView != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new SavePausePosTask(qZonePullToRefreshListView.j0().getFirstVisiblePosition()));
        }
        TextCellLayout.f50567b2 = false;
        com.qzone.homepage.ui.component.a aVar = this.f47306v1;
        if (aVar != null) {
            aVar.d();
        }
        super.onPause();
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment
    public void Aj(List<BusinessFeedData> list, boolean z16) {
        String n3;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator<BusinessFeedData> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BusinessFeedData next = it.next();
            if (next.isCellQbossPsvAdv()) {
                String str = BaseFragment.TAG;
                QZLog.d(str, 2, "feedData isCellQbossPsvAdv");
                arrayList.remove(next);
                if (next.getCellQbossPsvAdv().extendinfo != null) {
                    String str2 = next.getCellQbossPsvAdv().extendinfo.get("psv_adv_res_data");
                    if (!TextUtils.isEmpty(str2) && (n3 = g15.a.n(str2)) != null && g15.a.m(n3).booleanValue()) {
                        if (next.getOperationInfo().qbossTrace != null) {
                            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportIntercept(next.getOperationInfo().qbossTrace, null);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    arrayList.add(f47293y1, next);
                } else {
                    arrayList.add(0, next);
                    QZLog.w(str, 2, "CellQbossPsvAdv pos error");
                }
            }
        }
        ((QZoneMyFeedAdapter) this.D).setData(arrayList);
        fk(arrayList.size() > 0 && !this.f47308x1);
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment
    protected void Qi(QZoneResult qZoneResult) {
        if (qZoneResult == null || !qZoneResult.getSucceed()) {
            return;
        }
        Bundle bundle = qZoneResult.getBundle();
        if (bundle.containsKey(BusinessMyRelationData.STORE_KEY)) {
            ArrayList<BusinessMyRelationData> arrayListFromBundle = ParcelableWrapper.getArrayListFromBundle(bundle, BusinessMyRelationData.STORE_KEY);
            this.f47296l1 = arrayListFromBundle;
            if (arrayListFromBundle != null) {
                ek(0);
            }
        } else {
            this.f47296l1.clear();
        }
        hk();
    }

    public void ak(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            QZoneAllowJoinAlbumService.b().a(getHandler(), businessFeedData);
        }
    }

    @Override // com.qzone.common.activities.base.QZoneBaseFeedFragment
    protected void cj(QZoneResult qZoneResult) {
        if (qZoneResult != null && qZoneResult.getSucceed()) {
            LocalMultiProcConfig.putInt4Uin("qzone_passive_need_refresh", 0, LoginData.getInstance().getUin());
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.feed.ui.activity.QZoneMyFeedFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    QZoneFeedAlertService.getInstance().clearSingleUnreadCount(1);
                    if (QZLog.isColorLevel()) {
                        QZLog.d("QzoneRedTypeInfo", 2, "qzone redtypeinfo:my feed space is loading finish , reddot is clear");
                    }
                }
            });
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(BaseFragment.TAG, 2, "this log is for qzonetest : the QZoneMyFeedActivity is loading complete.");
        }
    }

    private void dk() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f68813h2);
        this.f47307w1 = linearLayout;
        linearLayout.setVisibility(8);
        if (getActivity() != null) {
            View qZoneWechatGuildNoticeBar = ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).getQZoneWechatGuildNoticeBar(getActivity(), new c());
            RFWLog.d(BaseFragment.TAG, RFWLog.USR, "initTopTips: " + qZoneWechatGuildNoticeBar);
            if (qZoneWechatGuildNoticeBar != null) {
                this.f47307w1.addView(qZoneWechatGuildNoticeBar);
            }
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.bnp, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f47320d;

        b(int i3) {
            this.f47320d = i3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QZoneMyFeedFragment.this.f47296l1.size() <= 0 || QZoneMyFeedFragment.this.f47299o1) {
                return;
            }
            QZoneMyFeedFragment.this.ek(this.f47320d);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
