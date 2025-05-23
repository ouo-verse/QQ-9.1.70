package com.tencent.biz.qqcircle.immersive.views.layer.ad;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoErrorPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ac;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFullScreenAdCardPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFullScreenAdVideoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.en;
import com.tencent.biz.qqcircle.immersive.feed.ad.g;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.feed.ax;
import com.tencent.biz.qqcircle.immersive.feed.cs;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Map;
import l30.a;
import ua0.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerFullScreenAdVideoItemView extends QFSLayerFeedAbsItemView {
    private int G;
    private GdtAd H;
    private g I;

    public QFSLayerFullScreenAdVideoItemView(@NonNull Context context, int i3) {
        super(context, i3);
        this.H = new GdtAd();
        this.I = new g();
    }

    private void E0(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return;
        }
        rFWFeedSelectInfo.setFullVideo(true);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gtm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(a.a().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSLayerFullScreenAdVideoItemView";
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
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(c.d(bVar));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUBLISH_TIMESTAMP, Long.valueOf(bVar.g().createTime.get()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUBLISH_COVER_URL, bVar.g().cover.picUrl.get());
            if (this.H.isValid()) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_ID, Long.valueOf(this.H.getAId()));
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_TRACE_ID, this.H.getTraceId());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_URL, this.H.getUrlForClick());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_POS_ID, this.H.getPosId());
            }
            buildElementParams.put("xsj_feed_id", bVar.g().f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, bVar.g().feedShowReason.showReason.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE, 5);
            VideoReport.setElementParams(this, buildElementParams);
            VideoReport.setElementReuseIdentifier(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA + bVar.g().f398449id.get());
            VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
            if (QLog.isColorLevel()) {
                QLog.i("QFSLayerFullScreenAdVideoItemView", 1, "dtReportBindItemView  pos = " + i3 + " , feedType = " + bVar.g().type.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I.i(this.H, this, this.G, getQCircleExtraTypeInfo());
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        this.I.f(getContext());
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        E0(rFWFeedSelectInfo);
        super.onFeedSelected(rFWFeedSelectInfo);
        this.I.h();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        E0(rFWFeedSelectInfo);
        super.onFeedUnSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        this.I.g();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        E0(rFWFeedSelectInfo);
        this.I.h();
        super.onResumed(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStart(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStart(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        arrayList.add(QFSFullScreenAdVideoPresenter.class);
        arrayList.add(en.class);
        arrayList.add(cs.class);
        arrayList.add(QFSFeedChildVideoErrorPresenter.class);
        arrayList.add(ax.class);
        arrayList.add(ac.class);
        arrayList.add(QFSFullScreenAdCardPresenter.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    public void x0(b bVar, int i3) {
        super.x0(bVar, i3);
        if (bVar == null) {
            return;
        }
        this.G = i3;
        this.H = new GdtAd(u.e(bVar));
        this.I = new g();
    }
}
