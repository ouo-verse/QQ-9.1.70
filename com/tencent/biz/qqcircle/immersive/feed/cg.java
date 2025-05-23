package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cg extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (com.tencent.biz.qqcircle.utils.k.g("exp_xsj_mianliu", "exp_xsj_mianliu_C") && !QCirclePluginGlobalInfo.D() && !QCircleHostGlobalInfo.isWifiState() && com.tencent.biz.qqcircle.immersive.utils.r.i() != -1) {
            QCircleToast.o(m0().getString(R.string.f196354h3), 1);
            QCirclePluginGlobalInfo.X(true);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedFreeFlowToastPresenter";
    }
}
