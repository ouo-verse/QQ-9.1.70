package com.tencent.biz.qqcircle.immersive.feed;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.aspectj.QCircleForbidInteractProcessor;
import com.tencent.biz.qqcircle.events.QFSBarrageSwitchEvent;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputHelper;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputPopupWindow;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageUpdateEvent;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSDoBarrageRequest;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSFakeBarrageEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StDoBarrageRsp;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSFeedChildRightWriteBarragePresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private FeedCloudMeta$StFeed I;
    private boolean J;
    private long K;
    private t40.h L;
    private View M;
    private ImageView N;
    private t40.c P;
    private ViewStub Q;
    private View R;
    private ImageView S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoBarrageRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f85197a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StBarrage f85198b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f85199c;

        b(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, int i3) {
            this.f85197a = feedCloudMeta$StFeed;
            this.f85198b = feedCloudMeta$StBarrage;
            this.f85199c = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoBarrageRsp feedCloudWrite$StDoBarrageRsp) {
            QLog.i("QDM-QFSFeedChildRightWriteBarragePresenter", 1, "[addFeedBarrage]  onReceive | isSuccess = " + z16 + " | retCode =" + j3 + " | errMsg = " + str + " | cmdName = " + baseRequest.getCmd() + " | traceId = " + baseRequest.getTraceId());
            if (z16 && j3 == 0 && feedCloudWrite$StDoBarrageRsp != null) {
                QLog.d("QDM-QFSFeedChildRightWriteBarragePresenter", 1, "addFeedBarrage Success");
                String str2 = this.f85198b.f398446id.get();
                this.f85198b.f398446id.set(feedCloudWrite$StDoBarrageRsp.barrage.f398446id.get());
                this.f85198b.createTime.set(feedCloudWrite$StDoBarrageRsp.barrage.createTime.get());
                feedCloudWrite$StDoBarrageRsp.barrage.set(this.f85198b);
                QFSBarrageUpdateEvent qFSBarrageUpdateEvent = new QFSBarrageUpdateEvent(1, this.f85197a.f398449id.get(), this.f85198b, this.f85199c);
                qFSBarrageUpdateEvent.fakeBarrageId = str2;
                SimpleEventBus.getInstance().dispatchEvent(qFSBarrageUpdateEvent);
                return;
            }
            QLog.e("QDM-QFSFeedChildRightWriteBarragePresenter", 1, "addFeedBarrage error:" + j3 + "  errorMsg:" + str);
            SimpleEventBus.getInstance().dispatchEvent(new QFSBarrageUpdateEvent(2, this.f85197a.f398449id.get(), this.f85198b, this.f85199c));
            QFSFeedChildRightWriteBarragePresenter.this.x1(j3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StBarrage != null) {
            VSNetworkHelper.getInstance().sendRequest(i3, new QFSDoBarrageRequest(feedCloudMeta$StFeed, feedCloudMeta$StBarrage, 1), new b(feedCloudMeta$StFeed, feedCloudMeta$StBarrage, i3));
        } else {
            QLog.w("QDM-QFSFeedChildRightWriteBarragePresenter", 1, "[addFeedBarrage] error: feed should not be null");
        }
    }

    private void n1(View view) {
        if (view == null) {
            return;
        }
        if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            QLog.d("QDM-QFSFeedChildRightWriteBarragePresenter", 1, "[barrageBtnClick] forbid send barrage because of sencebeat");
            return;
        }
        if (QCircleForbidInteractProcessor.forbidInteractIfGuildFeed(this.I, 5)) {
            QLog.d("QDM-QFSFeedChildRightWriteBarragePresenter", 1, "[barrageBtnClick] guild feed forbid interact");
            return;
        }
        if (view.getId() == R.id.f41311gq) {
            w1();
            y1(QCircleDaTongConstant.ElementId.EM_XSJ_BULLET_SCREEN_INPUT_BOX);
        } else if (view.getId() == R.id.f45701sl) {
            w1();
            y1(QCircleDaTongConstant.ElementId.EM_XSJ_BULLET_SCREEN_INPUT_BOX);
        }
    }

    private void o1() {
        QFSBarrageInputPopupWindow p16 = QFSBarrageInputHelper.r().p();
        if (p16 != null && p16.isShowing()) {
            p16.dismiss();
        }
    }

    private void p1(final String str) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildRightWriteBarragePresenter.3
            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildRightWriteBarragePresenter.this.q1(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(String str) {
        View view;
        if (this.I != null && (view = this.M) != null) {
            VideoReport.setElementId(view, str);
            VideoReport.setElementExposePolicy(this.M, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(this.M, ClickPolicy.REPORT_NONE);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PLAY_SETTING_BUTTON_STATE, Integer.valueOf(this.J ? 1 : 0));
            buildElementParams.putAll(ua0.c.e(this.I));
            buildElementParams.put("dt_pgid", r0());
            VideoReport.reportEvent("dt_imp", this.M, buildElementParams);
            VideoReport.setElementReuseIdentifier(this.M, this.I.f398449id.get());
        }
    }

    private void r1(QFSBarrageSwitchEvent qFSBarrageSwitchEvent) {
        boolean z16 = true;
        if (qFSBarrageSwitchEvent.eventStatus != 1) {
            z16 = false;
        }
        this.J = z16;
        z1();
    }

    private void s1(com.tencent.biz.qqcircle.immersive.feed.event.an anVar) {
        if (anVar == null) {
            return;
        }
        this.K = anVar.e();
        if (!com.tencent.biz.qqcircle.manager.d.b().e(this.I) || !com.tencent.biz.qqcircle.manager.d.b().d()) {
            return;
        }
        if (this.L == null) {
            this.L = (t40.h) u0(t40.h.class);
        }
        t40.h hVar = this.L;
        if (hVar != null) {
            hVar.updateProgress(this.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        n1(this.R);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void u1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        ViewStub viewStub;
        if (!com.tencent.biz.qqcircle.immersive.utils.o.f(feedCloudMeta$StFeed) || (viewStub = this.Q) == null || this.R != null) {
            return;
        }
        try {
            View inflate = viewStub.inflate();
            this.R = inflate;
            this.S = (ImageView) inflate.findViewById(R.id.f34110y_);
            this.R.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.bl
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSFeedChildRightWriteBarragePresenter.this.t1(view);
                }
            });
        } catch (Throwable th5) {
            QLog.e("QDM-QFSFeedChildRightWriteBarragePresenter", 1, "[inflateLeftBarrageView] ex: ", th5);
        }
    }

    private void w1() {
        com.tencent.biz.qqcircle.immersive.model.bottombarrage.c cVar = new com.tencent.biz.qqcircle.immersive.model.bottombarrage.c(this.I, null);
        cVar.g(true);
        cVar.i(this.K);
        long j3 = this.K;
        cVar.h(false);
        QFSBarrageInputHelper.r().w(getReportBean().getDtPageId());
        QFSBarrageInputHelper.r().x((Activity) m0(), cVar, new a(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(long j3, String str) {
        if (!HostNetworkUtils.isNetworkAvailable()) {
            com.tencent.biz.qqcircle.utils.cj.c(false, -1L, QCircleApplication.APP.getResources().getString(R.string.f181603e8), 0, QCircleToast.f91645e);
        } else {
            com.tencent.biz.qqcircle.utils.cj.c(false, j3, str, 0, QCircleToast.f91645e);
        }
    }

    private void y1(String str) {
        ImageView imageView;
        if (this.I != null && (imageView = this.N) != null) {
            VideoReport.setElementId(imageView, str);
            VideoReport.setElementClickPolicy(this.N, ClickPolicy.REPORT_NONE);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PLAY_SETTING_BUTTON_STATE, Integer.valueOf(this.J ? 1 : 0));
            buildElementParams.putAll(ua0.c.e(this.I));
            VideoReport.reportEvent("dt_clck", this.N, buildElementParams);
            VideoReport.setElementReuseIdentifier(this.N, this.I.f398449id.get());
        }
    }

    private void z1() {
        int i3;
        if (this.P == null) {
            this.P = (t40.c) u0(t40.c.class);
        }
        View view = this.M;
        int i16 = 0;
        if (view == null) {
            QLog.e("QDM-QFSFeedChildRightWriteBarragePresenter", 1, "[updateShowStatus] mBarrageLl is null");
        } else {
            if (com.tencent.biz.qqcircle.immersive.utils.o.g(this.I)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        u1(this.I);
        if (this.R != null) {
            boolean f16 = com.tencent.biz.qqcircle.immersive.utils.o.f(this.I);
            View view2 = this.R;
            if (!f16) {
                i16 = 8;
            }
            view2.setVisibility(i16);
            if (f16 && this.S != null) {
                if (com.tencent.biz.qqcircle.manager.d.b().d()) {
                    this.S.setImageResource(R.drawable.opu);
                } else {
                    this.S.setImageResource(R.drawable.opt);
                }
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.an) {
            s1((com.tencent.biz.qqcircle.immersive.feed.event.an) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean H0() {
        return com.tencent.biz.qqcircle.manager.i.a("qfs_barrage_entrance_show");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View findViewById = view.findViewById(R.id.f41311gq);
        this.M = findViewById;
        findViewById.setOnClickListener(this);
        this.Q = (ViewStub) view.findViewById(R.id.f45711sm);
        ImageView imageView = (ImageView) this.M.findViewById(R.id.f41301gp);
        this.N = imageView;
        imageView.setImageResource(com.tencent.biz.qqcircle.k.a());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QFSBarrageSwitchEvent.class);
        return eventClass;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        n1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        this.J = com.tencent.biz.qqcircle.manager.d.b().d();
        z1();
        if (com.tencent.biz.qqcircle.immersive.utils.o.f(this.I)) {
            p1(QCircleDaTongConstant.ElementId.EM_XSJ_BULLET_SCREEN_INPUT_BOX);
        } else {
            p1(QCircleDaTongConstant.ElementId.EM_XSJ_BULLET_SCREEN_INPUT_BOX);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        z1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSBarrageSwitchEvent) {
            r1((QFSBarrageSwitchEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStop(rFWFeedSelectInfo);
        o1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QDM-QFSFeedChildRightWriteBarragePresenter", 1, "[onBindData] stFeed should not be null.");
        } else {
            this.I = feedCloudMeta$StFeed;
            u1(feedCloudMeta$StFeed);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QDM-QFSFeedChildRightWriteBarragePresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements QFSBarrageInputHelper.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f85195a;

        a(long j3) {
            this.f85195a = j3;
        }

        @Override // com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputHelper.e
        public void b(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
            if (QFSFeedChildRightWriteBarragePresenter.this.K != -1) {
                feedCloudMeta$StBarrage.feedPlayTime.set(QFSFeedChildRightWriteBarragePresenter.this.K);
                feedCloudMeta$StBarrage.pannelOpenTime.set(this.f85195a);
                QLog.d("QDM-QFSFeedChildRightWriteBarragePresenter", 2, "[onSendEvent] mVideoProgress = " + QFSFeedChildRightWriteBarragePresenter.this.K + ",openInputTime:" + this.f85195a);
            }
            QFSFeedChildRightWriteBarragePresenter qFSFeedChildRightWriteBarragePresenter = QFSFeedChildRightWriteBarragePresenter.this;
            qFSFeedChildRightWriteBarragePresenter.m1(qFSFeedChildRightWriteBarragePresenter.m0().hashCode(), QFSFeedChildRightWriteBarragePresenter.this.I, feedCloudMeta$StBarrage);
            SimpleEventBus.getInstance().dispatchEvent(new QFSFakeBarrageEvent(QFSFeedChildRightWriteBarragePresenter.this.I.f398449id.get(), feedCloudMeta$StBarrage, hashCode()));
        }

        @Override // com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputHelper.e
        public void a(int i3) {
        }
    }
}
