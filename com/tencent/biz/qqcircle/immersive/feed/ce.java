package com.tencent.biz.qqcircle.immersive.feed;

import android.app.Activity;
import android.view.View;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ce {

    /* renamed from: a, reason: collision with root package name */
    private static AdFeedbackDialogFragment.Listener f86057a;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16, AdFeedbackDialogFragment.Result result) {
        QLog.i("QFSFeedECFeedBackHelper", 1, "[openFeedBack] listener invoke, result action = " + result.action + ", result result = " + result.result);
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(10, feedCloudMeta$StFeed.f398449id.get(), false));
        if (result.action == 3) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(feedCloudMeta$StFeed.f398449id.get(), 3));
            QCircleToast.i(QCircleToast.f91646f, R.string.f182873hn, 0);
            d(feedCloudMeta$StFeed, i3, i16);
        }
    }

    public static void c(View view, final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final int i3, final int i16) {
        if (feedCloudMeta$StFeed == null) {
            QLog.i("QFSFeedECFeedBackHelper", 1, "[openDisLikeFeedBack] stFeed = null");
            return;
        }
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem negativeFeedbackItem = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem();
        negativeFeedbackItem.action_type.set(3);
        negativeFeedbackItem.icon_url.set("https://amsweb-cdn-gz-1258344696.file.myqcloud.com/web\u5f00\u53d1\u7ec4/\u8d44\u6e90\u6587\u4ef6/\u4e0d\u611f\u5174\u8da3-\u6a2a\u7248@2x.png");
        negativeFeedbackItem.text.set("\u5173\u95ed\u6b64\u6761\u5e7f\u544a");
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
        adInfo.report_info.neg_fb_items.add(negativeFeedbackItem);
        GdtAd gdtAd = new GdtAd();
        gdtAd.info = adInfo;
        f86057a = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.biz.qqcircle.immersive.feed.cd
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                ce.b(FeedCloudMeta$StFeed.this, i3, i16, result);
            }
        };
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        adFeedbackParams.activity = new WeakReference<>((Activity) view.getContext());
        adFeedbackParams.listener = new WeakReference<>(f86057a);
        adFeedbackParams.f61346ad = gdtAd;
        adFeedbackParams.styleId = 0;
        adFeedbackParams.shouldShowToast = false;
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
        } catch (Throwable th5) {
            QLog.e("QFSFeedECFeedBackHelper", 1, "[openFeedBack]", th5);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(10, feedCloudMeta$StFeed.f398449id.get(), true));
        QLog.i("QFSFeedECFeedBackHelper", 1, "[openFeedBack] feedbackAd = " + gdtAd + ", AdFeedbackParams = " + adFeedbackParams + ", feedId = " + feedCloudMeta$StFeed.f398449id.get());
    }

    private static void d(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ua0.c.a(feedCloudMeta$StFeed).setToUin(feedCloudMeta$StFeed.poster.f398463id.get()).setActionType(65).setSubActionType(3).setIndex(i16).setExt3(feedCloudMeta$StFeed.createTime.toString()).setPageId(i3)));
    }
}
