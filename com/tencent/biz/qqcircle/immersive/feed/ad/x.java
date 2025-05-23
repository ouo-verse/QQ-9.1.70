package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static FeedCloudMeta$StFeed f85769a;

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, Object> f85770b;

    /* renamed from: c, reason: collision with root package name */
    private static AdFeedbackDialogFragment.Listener f85771c = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.w
        @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
        public final void onResult(AdFeedbackDialogFragment.Result result) {
            x.d(result);
        }
    };

    private static void b(String str, String str2, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            map.put("xsj_eid", str2);
            VideoReport.reportEvent(str, null, map);
        }
    }

    public static void c(View view, GdtAd gdtAd, FeedCloudMeta$StFeed feedCloudMeta$StFeed, AdFeedbackDialogFragment.Listener listener, int i3) {
        f85769a = feedCloudMeta$StFeed;
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        adFeedbackParams.activity = new WeakReference<>((Activity) view.getContext());
        adFeedbackParams.listener = new WeakReference<>(listener);
        adFeedbackParams.f61346ad = gdtAd;
        adFeedbackParams.styleId = i3;
        adFeedbackParams.isDarkMode = QCircleSkinHelper.getInstance().isDarkMode();
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
        } catch (Throwable th5) {
            QLog.e("QFSFeedAdFeedBackHelper", 1, "innerOpenAdFeedBackDialog", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AdFeedbackDialogFragment.Result result) {
        String str;
        QFSFeedAdFeedbackEvent qFSFeedAdFeedbackEvent = new QFSFeedAdFeedbackEvent(QFSFeedAdFeedbackEvent.STATUS_END);
        qFSFeedAdFeedbackEvent.setResult(result);
        SimpleEventBus.getInstance().dispatchEvent(qFSFeedAdFeedbackEvent);
        if (result.action == 3) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(f85769a.f398449id.get(), 8));
            str = QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_FEEDBACK_CLOSE;
        } else {
            str = null;
        }
        if (result.action == 6) {
            str = QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_FEEDBACK_COMPLAIN;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b("ev_xsj_abnormal_clck", str, f85770b);
    }

    public static void e(View view, GdtAd gdtAd, FeedCloudMeta$StFeed feedCloudMeta$StFeed, Map<String, Object> map, QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        g(view, gdtAd, feedCloudMeta$StFeed, map, qCircleExtraTypeInfo, null, 0);
    }

    public static void f(View view, GdtAd gdtAd, FeedCloudMeta$StFeed feedCloudMeta$StFeed, Map<String, Object> map, QCircleExtraTypeInfo qCircleExtraTypeInfo, AdFeedbackDialogFragment.Listener listener) {
        g(view, gdtAd, feedCloudMeta$StFeed, map, qCircleExtraTypeInfo, listener, 0);
    }

    public static void g(View view, GdtAd gdtAd, FeedCloudMeta$StFeed feedCloudMeta$StFeed, Map<String, Object> map, QCircleExtraTypeInfo qCircleExtraTypeInfo, AdFeedbackDialogFragment.Listener listener, int i3) {
        f85770b = map;
        if (listener == null) {
            listener = f85771c;
        }
        c(view, gdtAd, feedCloudMeta$StFeed, listener, i3);
        QFSFeedAdFeedbackEvent qFSFeedAdFeedbackEvent = new QFSFeedAdFeedbackEvent(QFSFeedAdFeedbackEvent.STATUS_START);
        qFSFeedAdFeedbackEvent.setAd(gdtAd);
        SimpleEventBus.getInstance().dispatchEvent(qFSFeedAdFeedbackEvent);
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.h(400, 4, qCircleExtraTypeInfo, 1);
        b("ev_xsj_abnormal_imp", QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_FEEDBACK_TAB, map);
    }
}
