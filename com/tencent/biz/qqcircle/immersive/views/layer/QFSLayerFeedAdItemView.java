package com.tencent.biz.qqcircle.immersive.views.layer;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.g;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSAdSpaceDispatchTouchEvent;
import com.tencent.biz.qqcircle.immersive.utils.d;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.GdtAntiSpamReportHelper;
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
import java.util.List;
import java.util.Map;
import ua0.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerFeedAdItemView extends QFSLayerFeedAbsItemView {
    private int G;
    private GdtAd H;
    private g I;
    private final GdtAntiSpamReportHelper J;
    private boolean K;
    private boolean L;
    private volatile boolean M;
    private int N;
    private float P;
    private float Q;
    private long R;

    public QFSLayerFeedAdItemView(@NonNull Context context, int i3) {
        super(context, i3);
        this.H = new GdtAd();
        this.I = new g();
        this.J = new GdtAntiSpamReportHelper();
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private QCircleExtraTypeInfo E0(b bVar) {
        if (bVar == null) {
            return null;
        }
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo.pageType = getPageId();
        qCircleExtraTypeInfo.mFeed = bVar.g();
        qCircleExtraTypeInfo.mPlayScene = 2;
        qCircleExtraTypeInfo.sourceType = getParentPageId();
        qCircleExtraTypeInfo.mDataPosition = getDataPosInList();
        return qCircleExtraTypeInfo;
    }

    private boolean F0(MotionEvent motionEvent) {
        if (!this.L) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && H0(motionEvent)) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        } else {
            this.P = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            this.Q = rawY;
            this.J.setDownData((int) this.P, (int) rawY);
            this.M = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean G0(MotionEvent motionEvent) {
        if (!this.K) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent == null) {
            QLog.e("QFSLayerFeedAdItemView", 1, "[dispatchTouchEvent] error, event is null");
            return super.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSAdSpaceDispatchTouchEvent(this.H, motionEvent));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean H0(MotionEvent motionEvent) {
        if (this.M) {
            QLog.d("QFSLayerFeedAdItemViewSlide", 2, "opening landing page, return");
            return false;
        }
        int rawX = (int) (this.P - motionEvent.getRawX());
        int rawY = (int) (this.Q - motionEvent.getRawY());
        if (QLog.isDebugVersion()) {
            QLog.d("QFSLayerFeedAdItemViewSlide", 2, "left slide move,  deltaX:\u3010" + rawX + "\u3011, deltaY :\u3010" + rawY + "\u3011, mTouchSlop :\u3010" + this.N + "\u3011");
        }
        if (rawX <= this.N || Math.abs(rawX) <= Math.abs(rawY)) {
            return false;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("QFSLayerFeedAdItemViewSlide", 2, "left slide move, success");
        }
        this.J.setUpData((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        j.f90213a.J(this.H, this, this.G, getQCircleExtraTypeInfo(), 100, this.J.getAdAntiSpamForClickParams(this));
        this.M = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.K) {
            return G0(motionEvent);
        }
        if (this.L) {
            return F0(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gen;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSLayerFeedAdItemView";
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
                QLog.i("QFSLayerFeedAdItemView", 1, "dtReportBindItemView  pos = " + i3 + " , feedType = " + bVar.g().type.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I.j(this.H, this, this.G, getQCircleExtraTypeInfo(), this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        this.I.f(getContext());
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        this.I.h();
        this.R = System.currentTimeMillis();
        this.J.setExpoTime();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        d dVar = d.f90201a;
        dVar.j(this.H.getAdSelectedUrl(), this.R, System.currentTimeMillis());
        dVar.m(this.H.getTraceId(), "action", "0");
        dVar.m(this.H.getTraceId(), "click_pos", "0");
        dVar.f(this.H, 3, this.G);
        this.J.resetExpoTime();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        this.I.g();
        d dVar = d.f90201a;
        dVar.f(this.H, 3, this.G);
        dVar.k();
        dVar.j(this.H.getAdSelectedUrl(), this.R, System.currentTimeMillis());
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        this.I.h();
        super.onResumed(rFWFeedSelectInfo);
        d dVar = d.f90201a;
        dVar.m(this.H.getTraceId(), "action", "0");
        dVar.m(this.H.getTraceId(), "click_pos", "0");
        if (this.R != 0) {
            this.R = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStart(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStart(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> b16;
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        com.tencent.biz.qqcircle.immersive.layer.base.b q06 = q0();
        if (q06 != null && (b16 = q06.b()) != null) {
            arrayList.addAll(b16);
        }
        return arrayList;
    }

    public void setEnableSlide(boolean z16) {
        this.L = z16;
    }

    public void setShouldNotifyDispatchTouchEventForSpace(boolean z16) {
        this.K = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    public void x0(b bVar, int i3) {
        if (bVar == null) {
            return;
        }
        this.G = i3;
        this.H = new GdtAd(u.e(bVar));
        this.I = new g();
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : s0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.V0(bVar);
                qFSBaseFeedChildPresenter.L0(bVar.g(), i3);
            }
        }
        this.R = 0L;
        d.f90201a.c(bVar.g(), this.H);
        setExtraTypeInfo(E0(bVar));
    }
}
