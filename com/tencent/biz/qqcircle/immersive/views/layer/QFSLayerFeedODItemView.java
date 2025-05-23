package com.tencent.biz.qqcircle.immersive.views.layer;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.live.od.QFSODFeedsRequest;
import com.tencent.biz.qqcircle.immersive.feed.live.w;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.b;
import feedcloud.FeedCloudMeta$RoomInfoData;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ua0.c;
import weprotocols.WEProtocolsVaslive$DatingRoomInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerFeedODItemView extends QFSLayerFeedAbsItemView {
    private final IAegisLogApi G;
    private b H;
    private int I;
    private long J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSODFeedsRequest.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.live.od.QFSODFeedsRequest.a
        public void a(b bVar) {
            QFSLayerFeedODItemView qFSLayerFeedODItemView = QFSLayerFeedODItemView.this;
            qFSLayerFeedODItemView.bindData(bVar, qFSLayerFeedODItemView.I);
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.live.od.QFSODFeedsRequest.a
        public void fail(int i3, String str) {
            QFSLayerFeedODItemView.this.G.w("QFSLayerFeedODItemView", "fetch od room stFeed error! code:" + i3 + " msg:" + str);
        }
    }

    public QFSLayerFeedODItemView(@NonNull Context context, int i3) {
        super(context, i3);
        this.J = -1L;
        this.G = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    }

    private void G0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, WEProtocolsVaslive$DatingRoomInfo wEProtocolsVaslive$DatingRoomInfo) {
        FeedCloudMeta$RoomInfoData h16 = w.h(feedCloudMeta$StFeed);
        if (h16 == null) {
            return;
        }
        if (w.f(feedCloudMeta$StFeed, wEProtocolsVaslive$DatingRoomInfo)) {
            this.G.i("QFSLayerFeedODItemView", "is live finish!! can't fetch data");
            return;
        }
        QFSODFeedsRequest qFSODFeedsRequest = new QFSODFeedsRequest(h16.roomId.get());
        qFSODFeedsRequest.i(feedCloudMeta$StFeed);
        qFSODFeedsRequest.h(new a());
    }

    private void H0() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.J;
        if (j3 != -1 && currentTimeMillis - j3 < 1000) {
            this.G.w("QFSLayerFeedODItemView", "tryFeedNewOdFeedData fail, mLastRequestTime:" + this.J + " cur:" + currentTimeMillis);
            return;
        }
        b bVar = this.H;
        if (bVar == null) {
            return;
        }
        FeedCloudMeta$StFeed g16 = bVar.g();
        if (g16 == null) {
            this.G.w("QFSLayerFeedODItemView", "tryFeedNewOdFeedData fail, sourceData is null");
            return;
        }
        WEProtocolsVaslive$DatingRoomInfo c16 = w.c(this.H);
        if (c16 == null) {
            this.G.w("QFSLayerFeedODItemView", "tryFeedNewOdFeedData fail, datingRoomInfo is null");
        } else {
            this.J = currentTimeMillis;
            G0(g16, c16);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSLayerFeedODItemView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(b bVar, int i3) {
        if (bVar != null && bVar.g() != null) {
            VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(c.d(bVar));
            String b16 = w.b(bVar.g());
            if (!TextUtils.isEmpty(b16)) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, b16);
            }
            FeedCloudMeta$RoomInfoData h16 = w.h(bVar.g());
            if (h16 != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_ROOM_TYPE, Integer.valueOf(h16.roomType.get()));
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQLIVE_ROOM_ID, Long.valueOf(h16.roomId.get()));
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
            v70.a.b(buildElementParams, bVar);
            v70.a.a(buildElementParams, bVar);
            VideoReport.setElementParams(this, buildElementParams);
            VideoReport.setElementReuseIdentifier(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA + bVar.g().f398449id.get());
            VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
            this.G.i("QFSLayerFeedODItemView", "dtReportBindItemView  pos = " + i3 + " , feedType = " + bVar.g().type.get());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        H0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        H0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> m3;
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        com.tencent.biz.qqcircle.immersive.layer.base.b q06 = q0();
        if (q06 != null && (m3 = q06.m()) != null) {
            arrayList.addAll(m3);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(b bVar, int i3) {
        this.H = bVar;
        this.I = i3;
        super.bindData(bVar, i3);
    }
}
