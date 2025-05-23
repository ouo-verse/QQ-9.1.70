package com.tencent.biz.qqcircle.immersive.views.layer;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSFullScreenSeekBarEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoErrorPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenRatePlayGesturePresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ac;
import com.tencent.biz.qqcircle.immersive.feed.ag;
import com.tencent.biz.qqcircle.immersive.feed.al;
import com.tencent.biz.qqcircle.immersive.feed.ax;
import com.tencent.biz.qqcircle.immersive.feed.cp;
import com.tencent.biz.qqcircle.immersive.feed.cq;
import com.tencent.biz.qqcircle.immersive.feed.cr;
import com.tencent.biz.qqcircle.immersive.feed.cs;
import com.tencent.biz.qqcircle.immersive.feed.cu;
import com.tencent.biz.qqcircle.immersive.utils.ad.QFSFullScreenPauseAdPresenter;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.utils.cb;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.b;
import e40.p;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import ua0.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerFullScreenVideoItemView extends QFSLayerFeedAbsItemView implements SimpleEventReceiver {
    private int G;
    private b H;
    private RFWFeedSelectInfo I;
    private boolean J;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSLayerFullScreenVideoItemView> f90801a;

        public a(QFSLayerFullScreenVideoItemView qFSLayerFullScreenVideoItemView) {
            this.f90801a = new WeakReference<>(qFSLayerFullScreenVideoItemView);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (this.f90801a.get() == null) {
                return buildElementParams;
            }
            QFSLayerFullScreenVideoItemView qFSLayerFullScreenVideoItemView = this.f90801a.get();
            b data = qFSLayerFullScreenVideoItemView.getData();
            int i3 = qFSLayerFullScreenVideoItemView.G;
            buildElementParams.putAll(c.d(data));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUBLISH_TIMESTAMP, Long.valueOf(data.g().createTime.get()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUBLISH_COVER_URL, data.g().cover.picUrl.get());
            if (c40.a.f(data.g())) {
                qFSLayerFullScreenVideoItemView.getIocInterface(t40.a.class);
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(c40.a.c(data.g())));
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_SHOW_AD, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.ad.a.h((ViewGroup) qFSLayerFullScreenVideoItemView.findViewById(R.id.f40181do))));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_CACHE, Integer.valueOf(r.a0(data.g()) ? 1 : 0));
            return buildElementParams;
        }
    }

    public QFSLayerFullScreenVideoItemView(@NonNull Context context, int i3) {
        super(context, i3);
        this.J = false;
    }

    private void G0(QFSFullScreenSeekBarEvent qFSFullScreenSeekBarEvent) {
        QLog.d("QFSLayerFullFullScreenVideoItemView", 1, "[handlerFullScreenSeekBarEvent] event feedId: " + qFSFullScreenSeekBarEvent.getFeedId() + " | action: " + qFSFullScreenSeekBarEvent.getSeekBarAction());
        if (qFSFullScreenSeekBarEvent.getSeekBarAction() == 1) {
            this.J = true;
        } else if (qFSFullScreenSeekBarEvent.getSeekBarAction() == 2) {
            this.J = false;
        }
    }

    private void H0(QFSFullScreenSeekBarEvent qFSFullScreenSeekBarEvent) {
        if (qFSFullScreenSeekBarEvent instanceof QFSFullScreenSeekBarEvent) {
            G0(qFSFullScreenSeekBarEvent);
        }
    }

    private void I0(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return;
        }
        rFWFeedSelectInfo.setFullVideo(true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.qqcircle.immersive.manager.a
    public boolean V(p pVar) {
        return this.J;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSFullScreenSeekBarEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gto;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSLayerFullFullScreenVideoItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(b bVar, int i3) {
        if (bVar != null && bVar.g() != null) {
            VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
            VideoReport.setEventDynamicParams(this, new a(this));
            VideoReport.setElementReuseIdentifier(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA + bVar.g().f398449id.get());
            VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
            if (QLog.isColorLevel()) {
                QLog.i(getLogTag(), 1, "[dtReportBindItemView]  pos = " + i3 + " , feedType = " + bVar.g().type.get());
            }
            this.G = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        I0(rFWFeedSelectInfo);
        super.onFeedSelected(rFWFeedSelectInfo);
        this.I = rFWFeedSelectInfo;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        I0(rFWFeedSelectInfo);
        super.onFeedUnSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSFullScreenSeekBarEvent) {
            H0((QFSFullScreenSeekBarEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        I0(rFWFeedSelectInfo);
        super.onResumed(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        arrayList.add(QFSFullScreenVideoPresenter.class);
        arrayList.add(cs.class);
        arrayList.add(QFSFeedChildVideoErrorPresenter.class);
        arrayList.add(cr.class);
        arrayList.add(ax.class);
        arrayList.add(ac.class);
        arrayList.add(al.class);
        arrayList.add(ag.class);
        arrayList.add(QFSFullScreenPauseAdPresenter.class);
        arrayList.add(cp.class);
        if (cb.c()) {
            arrayList.add(QFSFullScreenRatePlayGesturePresenter.class);
        }
        if (com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.b.wa()) {
            arrayList.add(cq.class);
        }
        if (com.tencent.biz.qqcircle.immersive.utils.a.e()) {
            arrayList.add(cu.class);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    public void x0(b bVar, int i3) {
        super.x0(bVar, i3);
        this.H = bVar;
    }
}
