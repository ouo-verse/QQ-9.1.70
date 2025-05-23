package com.qzone.proxy.feedcomponent.model.gdt.reporter;

import android.text.TextUtils;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtReporter;
import vo.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GdtCrossAdReporterForQzone {
    public static final String ACTION_TYPE_SCROLL_INTERACTION = "6";
    private static final String KEY_INTERACTIVE_TYPE = "__INTERACTIVE_TYPE__";
    private static final String KEY_VIEW_ID = "__VIEW_ID__";
    private static final String TAG = "GdtCrossAdReporterForQzone";

    public static void reportForInteraction(BusinessFeedData businessFeedData) {
        if (!GdtAdFeedUtil.isCrossAd(businessFeedData)) {
            GdtLog.e(TAG, "[reportForInteraction]");
            return;
        }
        GdtAd E = GdtFeedUtilForQZone.E(businessFeedData);
        if (E != null) {
            GdtReporter.doCgiReport(E.getUrlForClick());
            b.m(true, businessFeedData);
        }
        String interactiveUrl = GdtAdFeedUtil.getInteractiveUrl(businessFeedData);
        if (TextUtils.isEmpty(interactiveUrl)) {
            return;
        }
        String viewId = GdtAdFeedUtil.getViewId(businessFeedData);
        if (!TextUtils.isEmpty(viewId)) {
            interactiveUrl = interactiveUrl.replace(KEY_VIEW_ID, viewId);
        }
        GdtReporter.doCgiReport(interactiveUrl.replace(KEY_INTERACTIVE_TYPE, "6"));
    }
}
