package com.tencent.biz.qqcircle.immersive.model.bottombarrage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.aspectj.QCircleForbidInteractProcessor;
import com.tencent.biz.qqcircle.events.QFSBarrageSwitchEvent;
import com.tencent.biz.qqcircle.events.QFSBottomBarrageHintTextEvent;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputHelper;
import com.tencent.biz.qqcircle.manager.d;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StDoBarrageRsp;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomBarrageBarView extends QCircleBaseWidgetView<FeedCloudMeta$StFeed> implements View.OnClickListener, SimpleEventReceiver {
    private long C;
    private String D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private View f87291d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f87292e;

    /* renamed from: f, reason: collision with root package name */
    private View f87293f;

    /* renamed from: h, reason: collision with root package name */
    private QCircleAsyncTextView f87294h;

    /* renamed from: i, reason: collision with root package name */
    private FeedCloudMeta$StFeed f87295i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f87296m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoBarrageRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f87299a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StBarrage f87300b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f87301c;

        b(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, int i3) {
            this.f87299a = feedCloudMeta$StFeed;
            this.f87300b = feedCloudMeta$StBarrage;
            this.f87301c = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoBarrageRsp feedCloudWrite$StDoBarrageRsp) {
            QLog.i("QDM-QFSBottomBarrageBarView", 1, "[addFeedBarrage]  onReceive | isSuccess = " + z16 + " | retCode =" + j3 + " | errMsg = " + str + " | cmdName = " + baseRequest.getCmd() + " | traceId = " + baseRequest.getTraceId());
            if (z16 && j3 == 0 && feedCloudWrite$StDoBarrageRsp != null) {
                QLog.d("QDM-QFSBottomBarrageBarView", 1, "addFeedBarrage Success");
                String str2 = this.f87300b.f398446id.get();
                this.f87300b.f398446id.set(feedCloudWrite$StDoBarrageRsp.barrage.f398446id.get());
                this.f87300b.createTime.set(feedCloudWrite$StDoBarrageRsp.barrage.createTime.get());
                feedCloudWrite$StDoBarrageRsp.barrage.set(this.f87300b);
                QFSBarrageUpdateEvent qFSBarrageUpdateEvent = new QFSBarrageUpdateEvent(1, this.f87299a.f398449id.get(), this.f87300b, this.f87301c);
                qFSBarrageUpdateEvent.fakeBarrageId = str2;
                SimpleEventBus.getInstance().dispatchEvent(qFSBarrageUpdateEvent);
                return;
            }
            QLog.e("QDM-QFSBottomBarrageBarView", 1, "addFeedBarrage error:" + j3 + "  errorMsg:" + str);
            SimpleEventBus.getInstance().dispatchEvent(new QFSBarrageUpdateEvent(2, this.f87299a.f398449id.get(), this.f87300b, this.f87301c));
            QFSBottomBarrageBarView.this.C0(j3, str);
        }
    }

    public QFSBottomBarrageBarView(@NonNull Context context) {
        super(context);
        this.f87296m = d.b().d();
        this.C = -1L;
    }

    private void A0(View view, int i3) {
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(long j3, String str) {
        if (!HostNetworkUtils.isNetworkAvailable()) {
            cj.c(false, -1L, QCircleApplication.APP.getResources().getString(R.string.f181603e8), 0, QCircleToast.f91645e);
        } else {
            cj.c(false, j3, str, 0, QCircleToast.f91645e);
        }
    }

    private void E0(boolean z16) {
        View view;
        int i3;
        if (this.f87291d != null && (view = this.f87293f) != null) {
            int i16 = 0;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
            QCircleAsyncTextView qCircleAsyncTextView = this.f87294h;
            if (!z16) {
                i16 = 8;
            }
            qCircleAsyncTextView.setVisibility(i16);
            this.f87291d.requestLayout();
        }
    }

    private void F0(boolean z16) {
        ImageView imageView = this.f87292e;
        if (imageView == null) {
            return;
        }
        if (z16) {
            imageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nt_));
        } else {
            imageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nt9));
        }
    }

    private void G0(boolean z16, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleAsyncTextView qCircleAsyncTextView = this.f87294h;
        if (qCircleAsyncTextView == null) {
            return;
        }
        if (feedCloudMeta$StFeed == null) {
            if (z16) {
                qCircleAsyncTextView.setText(h.a(R.string.f1902941p));
                this.f87294h.setTextColor(getContext().getResources().getColor(R.color.cla));
                return;
            } else {
                qCircleAsyncTextView.setText(h.a(R.string.f1902941p));
                this.f87294h.setTextColor(getContext().getResources().getColor(R.color.cli));
                return;
            }
        }
        if (z16) {
            String a16 = h.a(R.string.f1902941p);
            this.f87294h.setTextColor(getContext().getResources().getColor(R.color.cla));
            this.f87294h.setText(a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StBarrage != null) {
            VSNetworkHelper.getInstance().sendRequest(i3, new QFSDoBarrageRequest(feedCloudMeta$StFeed, feedCloudMeta$StBarrage, 1), new b(feedCloudMeta$StFeed, feedCloudMeta$StBarrage, i3));
        } else {
            QLog.w("QDM-QFSBottomBarrageBarView", 1, "[addFeedBarrage] error: feed should not be null");
        }
    }

    private void p0(View view) {
        if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            QLog.d("QDM-QFSBottomBarrageBarView", 1, "[barrageBtnClick] forbid send barrage because of sencebeat");
            return;
        }
        if (QCircleForbidInteractProcessor.forbidInteractIfGuildFeed(this.f87295i, 5)) {
            QLog.d("QDM-QFSBottomBarrageBarView", 1, "[barrageBtnClick] guild feed forbid interact");
            return;
        }
        if (view.getId() == R.id.f39431bn) {
            if (fb0.a.b("QDM-QFSBottomBarrageBarView", 500L)) {
                return;
            }
            v0();
            r0(this.f87292e, QCircleDaTongConstant.ElementId.EM_XSJ_BULLET_SCREEN_SETTING_BUTTON, true);
            return;
        }
        if (view.getId() != R.id.f39441bo || !d.b().d()) {
            return;
        }
        z0();
        s0(this.f87294h, QCircleDaTongConstant.ElementId.EM_XSJ_BULLET_SCREEN_INPUT_BOX, true);
    }

    private void r0(View view, String str, boolean z16) {
        if (this.f87295i != null && view != null) {
            VideoReport.setElementId(view, str);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.setElementReuseIdentifier(view, this.f87295i.f398449id.get());
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.e(this.f87295i));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PLAY_SETTING_BUTTON_STATE, Integer.valueOf(this.f87296m ? 1 : 0));
            if (z16) {
                VideoReport.reportEvent("dt_clck", view, buildElementParams);
            } else {
                VideoReport.setElementParams(view, buildElementParams);
            }
        }
    }

    private void s0(View view, String str, boolean z16) {
        String dtPageId;
        if (this.f87295i != null && view != null) {
            VideoReport.setElementId(view, str);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementReuseIdentifier(view, this.f87295i.f398449id.get());
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PLAY_SETTING_BUTTON_STATE, Integer.valueOf(this.f87296m ? 1 : 0));
            buildElementParams.putAll(ua0.c.e(this.f87295i));
            if (z16) {
                VideoReport.setElementParams(view, buildElementParams);
                return;
            }
            if (getReportBean() == null) {
                dtPageId = QCircleDaTongConstant.PageId.PG_XSJ_FULL_SCREEN_PAGE;
            } else {
                dtPageId = getReportBean().getDtPageId();
            }
            buildElementParams.put("dt_pgid", dtPageId);
            VideoReport.reportEvent("dt_imp", view, buildElementParams);
        }
    }

    private void u0(QFSBottomBarrageHintTextEvent qFSBottomBarrageHintTextEvent) {
        View view;
        if (this.f87294h != null && (view = this.f87291d) != null && view.getVisibility() == 0) {
            this.D = qFSBottomBarrageHintTextEvent.getBarrageText();
            G0(this.f87296m, qFSBottomBarrageHintTextEvent.getFeed());
        }
    }

    private void v0() {
        int i3 = 2;
        QLog.d("QDM-QFSBottomBarrageBarView", 1, "[handleBarrageSwitchIconClicked] before operation | isBarrageOpenBefore: ", Boolean.valueOf(this.f87296m));
        this.f87296m = !this.f87296m;
        d.b().h(this.f87296m);
        D0(this.f87296m);
        if (this.f87296m) {
            i3 = 1;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSBarrageSwitchEvent(i3));
    }

    private void w0(QFSVideoPauseEvent qFSVideoPauseEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f87295i;
        if (feedCloudMeta$StFeed != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), qFSVideoPauseEvent.mFeedId)) {
            setVideoProgress(qFSVideoPauseEvent.mProgress);
        }
    }

    private void x0(QFSBarrageSwitchEvent qFSBarrageSwitchEvent) {
        boolean z16 = true;
        if (qFSBarrageSwitchEvent.eventStatus != 1) {
            z16 = false;
        }
        this.f87296m = z16;
        D0(z16);
    }

    private void z0() {
        c cVar = new c(this.f87295i, null);
        cVar.h(true);
        cVar.i(this.C);
        long j3 = this.C;
        QFSBarrageInputHelper.r().w(getReportBean().getDtPageId());
        QFSBarrageInputHelper.r().x((Activity) getContext(), cVar, new a(j3));
    }

    public void B0() {
        A0(this.f87291d, 0);
    }

    public void D0(boolean z16) {
        F0(z16);
        G0(z16, this.f87295i);
        E0(z16);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSBottomBarrageHintTextEvent.class);
        arrayList.add(QFSVideoPauseEvent.class);
        arrayList.add(QFSBarrageSwitchEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QDM-QFSBottomBarrageBarView";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        p0(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSBottomBarrageHintTextEvent) {
            u0((QFSBottomBarrageHintTextEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSVideoPauseEvent) {
            w0((QFSVideoPauseEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSBarrageSwitchEvent) {
            x0((QFSBarrageSwitchEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QDM-QFSBottomBarrageBarView", 1, "[bindData] stFeed should not be null.");
            return;
        }
        this.f87295i = feedCloudMeta$StFeed;
        QLog.d("QDM-QFSBottomBarrageBarView", 1, "this =" + hashCode() + ", [bindData] stFeed = " + feedCloudMeta$StFeed.f398449id.get());
        if (!d.b().e(feedCloudMeta$StFeed)) {
            y0();
            return;
        }
        B0();
        r0(this.f87292e, QCircleDaTongConstant.ElementId.EM_XSJ_BULLET_SCREEN_SETTING_BUTTON, false);
        s0(this.f87294h, QCircleDaTongConstant.ElementId.EM_XSJ_BULLET_SCREEN_INPUT_BOX, false);
    }

    public void setLayoutId(int i3) {
        this.E = i3;
    }

    public void setVideoProgress(long j3) {
        this.C = j3;
    }

    public void y0() {
        A0(this.f87291d, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSBarrageInputHelper.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f87297a;

        a(long j3) {
            this.f87297a = j3;
        }

        @Override // com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputHelper.e
        public void b(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
            if (QFSBottomBarrageBarView.this.C != -1) {
                feedCloudMeta$StBarrage.feedPlayTime.set(QFSBottomBarrageBarView.this.C);
                feedCloudMeta$StBarrage.pannelOpenTime.set(this.f87297a);
                QLog.d("QDM-QFSBottomBarrageBarView", 2, "[onSendEvent] mVideoProgress = " + QFSBottomBarrageBarView.this.C + ",openInputTime:" + this.f87297a);
            }
            QFSBottomBarrageBarView qFSBottomBarrageBarView = QFSBottomBarrageBarView.this;
            qFSBottomBarrageBarView.o0(qFSBottomBarrageBarView.getContext().hashCode(), QFSBottomBarrageBarView.this.f87295i, feedCloudMeta$StBarrage);
            SimpleEventBus.getInstance().dispatchEvent(new QFSFakeBarrageEvent(QFSBottomBarrageBarView.this.f87295i.f398449id.get(), feedCloudMeta$StBarrage, hashCode()));
        }

        @Override // com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputHelper.e
        public void a(int i3) {
        }
    }
}
