package com.tencent.ad.tangram.statistics;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.util.AdClickUtil;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdReporterOfDeeplink {
    private static final String TAG = "AdReporterOfDeeplink";

    public static void report(@Nullable AdClickUtil.Params params, @Nullable AdClickUtil.Result result, boolean z16) {
        int i3;
        int i16;
        int i17;
        boolean z17;
        int i18;
        int i19;
        int i26;
        if (params != null && params.isValid() && result != null) {
            if (!result.isSuccess()) {
                AdLog.e(TAG, "report error, not success");
                return;
            }
            if (TextUtils.isEmpty(params.f61334ad.getAppDeeplink(params.clickLocationParams))) {
                return;
            }
            if (result.action == 15) {
                AdLog.i(TAG, "[report] ACTION_TRIPLE_LINK_URL_STEP no need to report");
                return;
            }
            if (z16) {
                i3 = 297;
            } else {
                i3 = 245;
            }
            AdReporterForEffect.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, i3);
            if (z16) {
                i16 = sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_WITH_DEEPLINK_DELAYED_START;
            } else {
                i16 = sdk_event_log.SdkEventDimension.EVENT_TRY_TO_OPEN_APP_WITH_DEEPLINK;
            }
            int i27 = i16;
            link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
            int i28 = 1;
            reportBiz.deeplink_scene = 1;
            if (z16) {
                i17 = 3;
            } else {
                i17 = 1;
            }
            reportBiz.deeplink_type = i17;
            AdReporterForLinkEvent.getInstance().reportAsync(params.activity.get(), i27, params.f61334ad, reportBiz, null);
            if (result.isSuccess() && ((i26 = result.action) == 4 || i26 == 18 || i26 == 16)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                AdReporterForEffect.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, 246);
                WeakReference weakReference = new WeakReference(params.activity.get());
                Ad ad5 = params.f61334ad;
                if (z16) {
                    i19 = 295;
                } else {
                    i19 = 290;
                }
                AdReporterForEffect.reportAsync(weakReference, ad5, i19);
            }
            if (z17) {
                if (z16) {
                    i18 = sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_WITH_DEEPLINK_DELAYED_SUCCESS;
                } else {
                    i18 = sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_WITH_DEEPLINK_SUCCESS;
                }
            } else if (z16) {
                i18 = sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_WITH_DEEPLINK_DELAYED_FAILED;
            } else {
                i18 = sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_WITH_DEEPLINK_FAILED;
            }
            int i29 = i18;
            link_report.LinkReport.ReportBiz reportBiz2 = new link_report.LinkReport.ReportBiz();
            reportBiz2.deeplink_scene = 1;
            if (z16) {
                i28 = 3;
            }
            reportBiz2.deeplink_type = i28;
            AdReporterForLinkEvent.getInstance().reportAsync(params.activity.get(), i29, params.f61334ad, reportBiz2, null);
            return;
        }
        AdLog.e(TAG, "report error");
    }
}
