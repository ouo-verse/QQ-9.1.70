package com.tencent.biz.qqcircle.comment.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.events.QFSCommentTabSelectEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentAreaBottomWidget extends QCircleBaseWidgetView<QFSCommentInfo> implements Observer<e30.b> {
    public static final String R = com.tencent.biz.qqcircle.utils.h.a(R.string.f181813es);
    public static final String S = com.tencent.biz.qqcircle.utils.h.a(R.string.f19306497);
    public static final String T = com.tencent.biz.qqcircle.utils.h.a(R.string.f1930949_);
    private com.tencent.biz.qqcircle.viewmodels.m C;
    private com.tencent.biz.qqcircle.viewmodels.n D;
    private FeedCloudMeta$StFeed E;
    private QFSCommentInfo F;
    private int G;
    private boolean H;
    private boolean I;
    private int J;
    private boolean K;
    private int L;
    private boolean M;
    private QCircleReportBean N;
    private e30.b P;
    private WeakReference<r20.a> Q;

    /* renamed from: d, reason: collision with root package name */
    private ViewPager2 f83985d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.qqcircle.comment.e f83986e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private LinearLayout f83987f;

    /* renamed from: h, reason: collision with root package name */
    private q f83988h;

    /* renamed from: i, reason: collision with root package name */
    private q f83989i;

    /* renamed from: m, reason: collision with root package name */
    private q f83990m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements OnPromiseRejected {
        a() {
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
        public void onFail(String str) {
            RFWLog.e("QFSCommentAreaBottomWidget", RFWLog.USR, new RuntimeException("[getCommentPartIoc]  error = " + str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements OnPromiseResolved<r20.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPromiseResolved f83992a;

        b(OnPromiseResolved onPromiseResolved) {
            this.f83992a = onPromiseResolved;
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(r20.a aVar) {
            QFSCommentAreaBottomWidget.this.Q = new WeakReference(aVar);
            this.f83992a.onDone(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSCommentAreaBottomWidget.this.h1(0, true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSCommentAreaBottomWidget.this.h1(1, true);
            QFSCommentAreaBottomWidget.this.b1(view, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_PRAISED_TAB);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSCommentAreaBottomWidget.this.h1(2, true);
            QFSCommentAreaBottomWidget.this.b1(view, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_PUSHED_TAB);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements OnPromiseResolved<r20.a> {
        f() {
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(r20.a aVar) {
            if (aVar != null) {
                QFSCommentAreaBottomWidget.this.O0(aVar.getCommentPartHost());
            } else {
                QLog.e(QFSCommentAreaBottomWidget.this.getLogTag(), 1, "[initViewModel] ioc == null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements Observer<Integer> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            QLog.d(QFSCommentAreaBottomWidget.this.getLogTag(), 1, "[updateCommentCount] integer = " + num);
            QFSCommentAreaBottomWidget.this.e1(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class h extends ViewPager2.OnPageChangeCallback {
        h() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            QFSCommentAreaBottomWidget.this.k1(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class i extends LinearSmoothScroller {
        i(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getVerticalSnapPreference() {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class j implements OnPromiseResolved<r20.a> {
        j() {
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(r20.a aVar) {
            boolean z16 = true;
            if (aVar == null) {
                QLog.e(QFSCommentAreaBottomWidget.this.getLogTag(), 1, "[updateSelected] ioc == null");
                return;
            }
            int i3 = 0;
            if (QFSCommentAreaBottomWidget.this.G != 0) {
                z16 = false;
            }
            if (!z16 || cq.f92752a.r(QFSCommentAreaBottomWidget.this.getFeedData())) {
                i3 = 8;
            }
            aVar.setCommentBottomBarVisibility(i3);
        }
    }

    public QFSCommentAreaBottomWidget(@NonNull Context context, QCircleReportBean qCircleReportBean) {
        super(context);
        this.N = qCircleReportBean;
        P0();
        Q0();
        S0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> G0() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", getFeedData().f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL);
        return buildElementParams;
    }

    private List<String> I0() {
        QCircleInitBean initBean = getInitBean();
        if (initBean != null && initBean.getActionBean() != null) {
            return initBean.getActionBean().mCommentPanelLikeTabAnchorUinList;
        }
        return null;
    }

    private int J0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(getFeedData().f398449id.get());
        if (f16 == null) {
            return 0;
        }
        return f16.totalClickCount.get();
    }

    private List<String> K0() {
        QCircleInitBean initBean = getInitBean();
        if (initBean != null && initBean.getActionBean() != null) {
            return initBean.getActionBean().mCommentPanelPushTabAnchorUinList;
        }
        return null;
    }

    private String L0(int i3) {
        if (i3 == 1) {
            return getFeedData().likeInfo.f398454id.get();
        }
        if (i3 == 2) {
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
            try {
                qQCircleFeedBase$StFeedBusiReqData.mergeFrom(getFeedData().busiData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            return qQCircleFeedBase$StFeedBusiReqData.pushList.f398457id.get();
        }
        return "";
    }

    public static String M0(String str, int i3) {
        if (i3 > 0) {
            return str + " " + com.tencent.biz.qqcircle.immersive.utils.r.f(i3);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(IPartHost iPartHost) {
        if (iPartHost == null) {
            QLog.e(getLogTag(), 1, "[initCommentBlockViewModel] partHost == null");
        } else {
            if (!(iPartHost instanceof QCircleBaseFragment)) {
                QLog.e(getLogTag(), 1, "[initCommentBlockViewModel] partHost not instanceof QCircleBaseFragment");
                return;
            }
            com.tencent.biz.qqcircle.viewmodels.n nVar = (com.tencent.biz.qqcircle.viewmodels.n) getViewModel((QCircleBaseFragment) iPartHost, com.tencent.biz.qqcircle.viewmodels.n.class);
            this.D = nVar;
            nVar.a2().observeForever(new g());
        }
    }

    private void P0() {
        this.f83987f = (LinearLayout) findViewById(R.id.u27);
        q qVar = new q(getContext());
        this.f83988h = qVar;
        qVar.c(new c());
        q qVar2 = new q(getContext());
        this.f83989i = qVar2;
        qVar2.c(new d());
        q qVar3 = new q(getContext());
        this.f83990m = qVar3;
        qVar3.c(new e());
    }

    private void Q0() {
        this.C = (com.tencent.biz.qqcircle.viewmodels.m) getViewModel(com.tencent.biz.qqcircle.viewmodels.m.class);
        F0(this, new f());
    }

    private void S0() {
        this.f83985d = (ViewPager2) findViewById(R.id.f3521119);
        com.tencent.biz.qqcircle.comment.e eVar = new com.tencent.biz.qqcircle.comment.e(this.N);
        this.f83986e = eVar;
        this.f83985d.setAdapter(eVar);
        this.f83985d.registerOnPageChangeCallback(new h());
    }

    private boolean U0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
        if (feedCloudMeta$StFeed != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), getFeedData().f398449id.get())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(r20.a aVar) {
        if (aVar == null) {
            QLog.e(getLogTag(), 1, "[updateData] ioc == null");
        } else {
            l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(r20.a aVar) {
        Z0(aVar);
        int i3 = this.G;
        if (i3 == 1 && this.K) {
            QLog.d(getLogTag(), 1, "[updateData] forceFresh like tab");
            a1(this.G, true);
            this.K = false;
            return;
        }
        if (i3 == 2 && this.M) {
            QLog.d(getLogTag(), 1, "[updateData] forceFresh push tab");
            a1(this.G, true);
            this.M = false;
        } else if (!U0() || (aVar != null && aVar.hasReceiveNeedResetBlockEvent())) {
            QLog.d(getLogTag(), 1, "[updateData] forceFresh current tab:" + this.G);
            a1(this.G, true);
        }
    }

    private boolean X0() {
        boolean isOwner = QCirclePluginUtil.isOwner(getFeedData().poster.f398463id.get());
        boolean m3 = uq3.c.m();
        boolean isDebugVersion = HostAppSettingUtil.isDebugVersion();
        QLog.d(getLogTag(), 1, "[needShowAdditionalTab] isHostFeed = " + isOwner + ", mIsFullScreen = " + this.I + ", isHitExp = " + m3 + ", isDebugVersion = " + isDebugVersion);
        if (!this.I && isOwner && (m3 || isDebugVersion)) {
            return true;
        }
        return false;
    }

    private void Z0(final r20.a aVar) {
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentAreaBottomWidget.this.V0(aVar);
            }
        });
    }

    private void a1(int i3, boolean z16) {
        List<String> K0;
        String obj;
        if (i3 == 0) {
            return;
        }
        int i16 = 1;
        if (!this.H) {
            QLog.d(getLogTag(), 1, "[refreshTabData] not need show additional tab");
            return;
        }
        if (this.C == null) {
            QLog.e(getLogTag(), 1, "[refreshTabData] mCommentAreaViewModel == null, tabIndex = " + i3);
            return;
        }
        FeedCloudMeta$StFeed feedData = getFeedData();
        if (i3 == 1) {
            K0 = I0();
        } else {
            K0 = K0();
        }
        List<String> list = K0;
        String L0 = L0(i3);
        String str = getFeedData().poster.f398463id.get();
        String logTag = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[refreshTabData] tabIndex = ");
        sb5.append(i3);
        sb5.append(", feedId = ");
        sb5.append(feedData.f398449id.get());
        sb5.append(", feedUid = ");
        sb5.append(str);
        sb5.append(", anchorUinList = ");
        if (list == null) {
            obj = "";
        } else {
            obj = list.toString();
        }
        sb5.append(obj);
        sb5.append(", key = ");
        sb5.append(L0);
        QLog.d(logTag, 1, sb5.toString());
        com.tencent.biz.qqcircle.viewmodels.m mVar = this.C;
        if (i3 != 1) {
            i16 = 2;
        }
        mVar.Z1(feedData, str, list, L0, i16, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.reportEvent("dt_clck", view, G0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.widget.QFSCommentAreaBottomWidget.12
            @Override // java.lang.Runnable
            public void run() {
                if (QFSCommentAreaBottomWidget.this.f83989i != null && QFSCommentAreaBottomWidget.this.f83990m != null) {
                    VideoReport.setElementId(QFSCommentAreaBottomWidget.this.f83989i.a(), QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_PRAISED_TAB);
                    VideoReport.reportEvent("dt_imp", QFSCommentAreaBottomWidget.this.f83989i.a(), QFSCommentAreaBottomWidget.this.G0());
                    View a16 = QFSCommentAreaBottomWidget.this.f83989i.a();
                    ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
                    VideoReport.setElementClickPolicy(a16, clickPolicy);
                    View a17 = QFSCommentAreaBottomWidget.this.f83989i.a();
                    ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
                    VideoReport.setElementExposePolicy(a17, exposurePolicy);
                    VideoReport.setElementId(QFSCommentAreaBottomWidget.this.f83990m.a(), QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_PUSHED_TAB);
                    VideoReport.reportEvent("dt_imp", QFSCommentAreaBottomWidget.this.f83990m.a(), QFSCommentAreaBottomWidget.this.G0());
                    VideoReport.setElementClickPolicy(QFSCommentAreaBottomWidget.this.f83990m.a(), clickPolicy);
                    VideoReport.setElementExposePolicy(QFSCommentAreaBottomWidget.this.f83990m.a(), exposurePolicy);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(int i3) {
        if (this.f83988h == null) {
            QLog.e(getLogTag(), 1, "[setCommentNumText] mCommentTabView == null");
            return;
        }
        if (i3 > 0 && !QCirclePluginUtil.isFeedOwner(getFeedData())) {
            this.f83988h.e(com.tencent.biz.qqcircle.immersive.utils.r.f(i3) + "\u6761" + R);
            return;
        }
        this.f83988h.e(M0(R, i3));
    }

    private void f1(int i3) {
        q qVar = this.f83989i;
        if (qVar == null) {
            QLog.e(getLogTag(), 1, "[setLikeNumText] mLikeTabView == null");
        } else {
            this.J = i3;
            qVar.e(M0(S, i3));
        }
    }

    private void g1(int i3) {
        q qVar = this.f83990m;
        if (qVar == null) {
            QLog.e(getLogTag(), 1, "[setPushNumText] mPushTabView == null");
        } else {
            this.L = i3;
            qVar.e(M0(T, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FeedCloudMeta$StFeed getFeedData() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QFSCommentInfo qFSCommentInfo = this.F;
        if (qFSCommentInfo != null && (feedCloudMeta$StFeed = qFSCommentInfo.mFeed) != null) {
            return feedCloudMeta$StFeed;
        }
        return new FeedCloudMeta$StFeed();
    }

    private QCircleInitBean getInitBean() {
        if (!(getContext() instanceof Activity)) {
            return null;
        }
        return (QCircleInitBean) ((Activity) getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(int i3, boolean z16) {
        ViewPager2 viewPager2 = this.f83985d;
        if (viewPager2 == null) {
            QLog.e(getLogTag(), 1, "[setViewPageCurItemView] mViewPager == null, pos = " + i3);
            return;
        }
        viewPager2.setCurrentItem(i3, z16);
        SimpleEventBus.getInstance().dispatchEvent(new QFSCommentTabSelectEvent(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(int i3) {
        boolean z16;
        boolean z17;
        this.G = i3;
        boolean z18 = true;
        if (this.f83988h != null && this.f83989i != null && this.f83990m != null) {
            QLog.d(getLogTag(), 1, "[updateSelected] mCurIndex = " + this.G);
            q qVar = this.f83988h;
            if (this.G == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            qVar.d(z16);
            q qVar2 = this.f83989i;
            if (this.G == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            qVar2.d(z17);
            q qVar3 = this.f83990m;
            if (this.G != 2) {
                z18 = false;
            }
            qVar3.d(z18);
            F0(this, new j());
            if (!this.H) {
                this.f83988h.b(4);
            }
            a1(this.G, false);
            return;
        }
        QLog.e(getLogTag(), 1, "[updateSelected] tabView == null");
    }

    private void l1() {
        int i3;
        int i16;
        QFSCommentInfo.ActionBean actionBean;
        QFSCommentInfo qFSCommentInfo = this.F;
        if (qFSCommentInfo == null || (actionBean = qFSCommentInfo.mActionBean) == null || (i3 = actionBean.mShowCommentPanelTabIndex) < 0) {
            i3 = 0;
        }
        ViewPager2 viewPager2 = this.f83985d;
        if (viewPager2 != null) {
            i16 = viewPager2.getCurrentItem();
        } else {
            i16 = -1;
        }
        h1(i3, false);
        if (i16 == i3) {
            k1(i3);
        }
    }

    private void m1() {
        int i3;
        int i16 = 3;
        if (this.H) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        if (this.f83987f.getChildCount() == i3) {
            if (QLog.isColorLevel()) {
                QLog.d(getLogTag(), 2, "[updateTabViewAndAdapter] count equal, not need update tabView and adapter");
                return;
            }
            return;
        }
        ViewPager2 viewPager2 = this.f83985d;
        if (viewPager2 != null) {
            viewPager2.setUserInputEnabled(this.H);
        }
        this.f83987f.removeAllViews();
        if (!this.H) {
            this.f83987f.setGravity(1);
            this.f83987f.addView(this.f83988h.a());
            this.f83988h.f(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary));
        } else {
            this.f83987f.addView(this.f83988h.a());
            this.f83987f.addView(this.f83989i.a());
            this.f83987f.addView(this.f83990m.a());
            com.tencent.biz.qqcircle.helpers.f fVar = com.tencent.biz.qqcircle.helpers.f.f84618a;
            fVar.b(this.f83987f);
            fVar.c(this.f83988h);
            fVar.c(this.f83989i);
            fVar.c(this.f83990m);
            this.f83987f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.widget.QFSCommentAreaBottomWidget.9
                @Override // java.lang.Runnable
                public void run() {
                    QFSCommentAreaBottomWidget.this.c1();
                }
            });
        }
        com.tencent.biz.qqcircle.comment.e eVar = this.f83986e;
        if (eVar != null) {
            if (!this.H) {
                i16 = 1;
            }
            eVar.l0(i16);
            return;
        }
        QLog.e(getLogTag(), 1, "[updateTabView] mAdapter == null");
    }

    public void A0(int i3) {
        QLog.d(getLogTag(), 1, "[adjustQFSCommentAreaBottomWidget] containerRecycleViewHeight = " + i3);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            QLog.e(getLogTag(), 1, "[adjustQFSCommentAreaBottomWidget] layoutParams == null");
        } else {
            layoutParams.height = i3;
            setLayoutParams(layoutParams);
        }
    }

    public boolean C0() {
        QCircleBlockContainer qCircleBlockContainer;
        com.tencent.biz.qqcircle.comment.e eVar = this.f83986e;
        if (eVar == null) {
            return false;
        }
        View i06 = eVar.i0(this.G);
        if (i06 instanceof QFSCommentAreaTabBaseView) {
            qCircleBlockContainer = ((QFSCommentAreaTabBaseView) i06).m0();
        } else if (i06 instanceof QFSCommentAreaCommentView) {
            qCircleBlockContainer = ((QFSCommentAreaCommentView) i06).N0();
        } else {
            qCircleBlockContainer = null;
        }
        if (qCircleBlockContainer == null || !qCircleBlockContainer.canScrollVertically(-1)) {
            return false;
        }
        return true;
    }

    public void D0(String str) {
        com.tencent.biz.qqcircle.comment.h.G().s(str);
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.D;
        if (nVar != null) {
            nVar.S1();
        }
        View i06 = this.f83986e.i0(0);
        if (!(i06 instanceof QFSCommentAreaCommentView)) {
            return;
        }
        ((QFSCommentAreaCommentView) i06).c1(true);
    }

    public BlockContainer E0() {
        QFSCommentAreaCommentView qFSCommentAreaCommentView = (QFSCommentAreaCommentView) this.f83986e.i0(0);
        if (qFSCommentAreaCommentView == null) {
            QLog.e(getLogTag(), 1, "[getCommentBlockContainer] comment view is null");
            return null;
        }
        return qFSCommentAreaCommentView.N0();
    }

    public void F0(View view, OnPromiseResolved<r20.a> onPromiseResolved) {
        r20.a aVar;
        if (onPromiseResolved == null) {
            return;
        }
        WeakReference<r20.a> weakReference = this.Q;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            onPromiseResolved.onDone(aVar);
        } else {
            RFWIocAbilityProvider.g().getIoc(r20.a.class).originView(view).done(new b(onPromiseResolved)).fail(new a()).run();
        }
    }

    public int H0() {
        com.tencent.biz.qqcircle.comment.e eVar = this.f83986e;
        if (eVar == null) {
            return 0;
        }
        View i06 = eVar.i0(0);
        if (!(i06 instanceof QFSCommentAreaCommentView)) {
            return 0;
        }
        return ((QFSCommentAreaCommentView) i06).Q0();
    }

    public int N0() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            QLog.e(getLogTag(), 1, "[adjustQFSCommentAreaBottomWidget] layoutParams == null");
            return 0;
        }
        return layoutParams.height;
    }

    public boolean T0() {
        com.tencent.biz.qqcircle.comment.e eVar = this.f83986e;
        if (eVar == null) {
            return false;
        }
        View i06 = eVar.i0(this.G);
        if (i06 instanceof QFSCommentAreaTabBaseView) {
            com.tencent.biz.qqcircle.adapter.q l06 = ((QFSCommentAreaTabBaseView) i06).l0();
            if (l06 != null && l06.getNUM_BACKGOURND_ICON() != 0) {
                return false;
            }
            return true;
        }
        if (!(i06 instanceof QFSCommentAreaCommentView)) {
            return false;
        }
        return ((QFSCommentAreaCommentView) i06).o1();
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        FeedCloudMeta$StFeed g16;
        if (bVar == null) {
            g16 = null;
        } else {
            g16 = bVar.g();
        }
        if (g16 == null) {
            QLog.e(getLogTag(), 1, "[onChanged] stFeed == null");
            return;
        }
        if (!TextUtils.equals(g16.f398449id.get(), getFeedData().f398449id.get())) {
            QLog.e(getLogTag(), 1, "[onChanged] feedId not equal");
            return;
        }
        if (g16.likeInfo.count.get() != this.J) {
            this.K = true;
        }
        int J0 = J0(g16);
        if (J0 != this.L) {
            this.M = true;
            g1(J0);
        }
    }

    public void d1(int i3, boolean z16) {
        QLog.d("QFSCommentAreaBottomWidget", 1, "[scrollToPosition] pos: " + i3 + ", toTop: " + z16);
        com.tencent.biz.qqcircle.comment.e eVar = this.f83986e;
        if (eVar != null && (eVar.i0(0) instanceof QFSCommentAreaCommentView)) {
            QFSCommentAreaCommentView qFSCommentAreaCommentView = (QFSCommentAreaCommentView) this.f83986e.i0(0);
            if (qFSCommentAreaCommentView != null && qFSCommentAreaCommentView.N0() != null && qFSCommentAreaCommentView.N0().getRecyclerView() != null) {
                NestScrollRecyclerView recyclerView = qFSCommentAreaCommentView.N0().getRecyclerView();
                if ((recyclerView.getLayoutManager() instanceof LinearLayoutManager) && z16) {
                    ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(i3, 0);
                    return;
                } else {
                    recyclerView.scrollToPosition(i3);
                    return;
                }
            }
            QLog.e("QFSCommentAreaBottomWidget", 1, "[scrollToPosition] commentView is null ");
            return;
        }
        QLog.e("QFSCommentAreaBottomWidget", 1, "[scrollToPosition] adapter is null ");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g8w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSCommentAreaBottomWidget";
    }

    public void i1(int i3) {
        QFSCommentAreaCommentView qFSCommentAreaCommentView;
        com.tencent.biz.qqcircle.comment.e eVar = this.f83986e;
        if (eVar != null && (eVar.i0(0) instanceof QFSCommentAreaCommentView) && (qFSCommentAreaCommentView = (QFSCommentAreaCommentView) this.f83986e.i0(0)) != null && qFSCommentAreaCommentView.N0() != null && qFSCommentAreaCommentView.N0().getRecyclerView() != null) {
            NestScrollRecyclerView recyclerView = qFSCommentAreaCommentView.N0().getRecyclerView();
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (i3 != linearLayoutManager.findFirstVisibleItemPosition()) {
                    QLog.e("QFSCommentAreaBottomWidget", 4, "[smoothScrollSnapTop] pos: " + i3 + ", firstPos: " + linearLayoutManager.findFirstVisibleItemPosition());
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("QFSCommentAreaBottomWidget", 4, "[smoothScrollSnapTop] pos: " + i3);
                }
                i iVar = new i(recyclerView.getContext());
                iVar.setTargetPosition(i3);
                linearLayoutManager.startSmoothScroll(iVar);
            }
        }
    }

    public void j1(QFSCommentInfo qFSCommentInfo) {
        this.E = getFeedData();
        this.F = qFSCommentInfo;
        this.H = X0();
        m1();
        e1(getFeedData().commentCount.get());
        f1(getFeedData().likeInfo.count.get());
        g1(J0(getFeedData()));
        F0(this, new OnPromiseResolved() { // from class: com.tencent.biz.qqcircle.comment.widget.a
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QFSCommentAreaBottomWidget.this.W0((r20.a) obj);
            }
        });
        this.P = new e30.b(getFeedData());
        w20.a.j().observerGlobalState(this.P, this);
    }

    public void setIsFullScreen(boolean z16) {
        this.I = z16;
    }

    public void z0(int i3) {
        QLog.d(getLogTag(), 1, "[adjustWidgetBottomPadding] padding = " + i3);
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSCommentInfo qFSCommentInfo, int i3) {
    }
}
