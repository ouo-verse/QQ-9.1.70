package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCircleFeedShareEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSCommentSendEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class p extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements x60.b, x60.a {
    private final w60.a I;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;

    public p() {
        w60.a aVar = new w60.a();
        this.I = aVar;
        aVar.r(this);
        aVar.q(this);
    }

    private boolean g1() {
        try {
            QCircleReportBean reportBean = getReportBean();
            if (reportBean == null) {
                return false;
            }
            if (reportBean.getPageId() == 501) {
                return true;
            }
            if (reportBean.getPageId() == 503) {
                return true;
            }
            return false;
        } catch (Throwable th5) {
            QLog.e("BGV-QFSFeedChildBottomGeneralGuidePresenter", 1, "[isDisplayGuidePage] error: ", th5);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean h1() {
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).type.get() == 3) {
            return true;
        }
        return false;
    }

    private boolean i1() {
        if (this.J && h1() && this.K && !this.L) {
            return false;
        }
        return true;
    }

    private boolean j1() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_guide_enabled", 0) != 1) {
            return false;
        }
        return true;
    }

    @Override // x60.a
    public QCircleReportBean A() {
        return getReportBean();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (i1()) {
            return;
        }
        this.I.n(hVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.J = j1();
        w60.a aVar = this.I;
        if (aVar != null) {
            aVar.m(view);
        }
    }

    @Override // x60.a
    public QCircleExtraTypeInfo f() {
        return r();
    }

    @Override // x60.b
    public void g(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        T0(hVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCirclePolyPraiseUpdateEvent.class);
        eventClass.add(QCirclePushUpdateEvent.class);
        eventClass.add(QCircleFeedShareEvent.class);
        eventClass.add(QFSCommentSendEvent.class);
        eventClass.add(QFSBottomDynamicGuideEvent.class);
        return eventClass;
    }

    @Override // x60.b
    public void i(String str, Object... objArr) {
        if (s0() == null) {
            QLog.e("BGV-QFSFeedChildBottomGeneralGuidePresenter", 1, "[onSendIocMessage] feed ioc should not be null.");
        } else {
            s0().onHandlerMessage(str, objArr);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        String str;
        boolean z16;
        PBRepeatField<Integer> pBRepeatField;
        super.L0(feedCloudMeta$StFeed, i3);
        this.L = com.tencent.biz.qqcircle.immersive.utils.r.D0(this.E, i3, getReportBean().getDtPageId());
        this.K = g1();
        this.J = j1();
        if (feedCloudMeta$StFeed == null) {
            str = "null";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        if (feedCloudMeta$StFeed != null && (pBRepeatField = feedCloudMeta$StFeed.opMask2) != null && pBRepeatField.get().contains(21)) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("BGV-QFSFeedChildBottomGeneralGuidePresenter", 1, "[onBindData] feed id: " + str + " | position: " + i3 + " | mIsShowBottomBanner: " + this.L + " | mIsDisplayGuidePage: " + this.K + " | mIsWnsOpenBottomCommentGuide: " + this.J + " | isFeedExistsComment: " + z16);
        if (i1()) {
            return;
        }
        this.I.j(feedCloudMeta$StFeed, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i || i1()) {
            return;
        }
        this.I.k(rFWFeedSelectInfo);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i || i1()) {
            return;
        }
        this.I.l(rFWFeedSelectInfo);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (i1()) {
            return;
        }
        this.I.o(simpleBaseEvent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "BGV-QFSFeedChildBottomGeneralGuidePresenter";
    }
}
