package com.qzone.proxy.feedcomponent.model.gdt.reporter;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtReporter;
import vo.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GdtCarouselCardReporterForQzone {
    public static final String ACTION_TYPE_CLICK = "2";
    public static final String ACTION_TYPE_EXPOSURE = "1";
    public static final String ACTION_TYPE_SCROLLED_BY_AUTOMATICALLY = "4";
    public static final String ACTION_TYPE_SCROLLED_MANUALLY = "3";
    public static final String ACTION_TYPE_VIDEO_START = "5";
    private static final String KEY_INTERACTIVE_TYPE = "__INTERACTIVE_TYPE__";
    private static final String KEY_VIEW_ID = "__VIEW_ID__";
    private static final String TAG = "GdtCarouselCardReporterForQzone";

    public static void reportForActionType(BusinessFeedData businessFeedData, int i3, String str) {
        GdtAdFeedUtil.CarouselCardInfo carouselCardInfoForPosition;
        if (businessFeedData == null || (carouselCardInfoForPosition = GdtAdFeedUtil.getCarouselCardInfoForPosition(businessFeedData, i3)) == null) {
            return;
        }
        String str2 = carouselCardInfoForPosition.interactiveUrl;
        String str3 = carouselCardInfoForPosition.viewId;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        String replace = str2.replace(KEY_INTERACTIVE_TYPE, str).replace(KEY_VIEW_ID, str3);
        GdtLog.i(TAG, String.format("[reportForAction] position = %d, event = %s", Integer.valueOf(i3), str));
        GdtReporter.doCgiReport(replace);
        str.hashCode();
        if (!str.equals("2")) {
            if (str.equals("3")) {
                String str4 = carouselCardInfoForPosition.clickUrl;
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                GdtReporter.doCgiReport(str4.replace(KEY_VIEW_ID, str3));
                b.m(true, businessFeedData);
                return;
            }
            return;
        }
        if (businessFeedData.getAdData().getCarouselCardClickedOrManuallyScrolledItemPosition() != businessFeedData.getAdData().getCarouselCardFirstVisibleItemPosition()) {
            reportForActionType(businessFeedData, businessFeedData.getAdData().getCarouselCardClickedOrManuallyScrolledItemPosition(), "1");
        }
    }
}
