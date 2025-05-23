package com.tencent.mobileqq.nearbypro.aio.utils;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\t\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bJ4\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0018\u0010\r\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bJ0\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/utils/a;", "", "Landroid/view/View;", "view", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "pageId", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "", "c", "id", "elementParams", "b", "a", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f253152a = new a();

    a() {
    }

    public final void a(@Nullable View view, @Nullable String id5, @Nullable Map<String, ? extends Object> elementParams) {
        VideoReport.setElementId(view, id5);
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        if (elementParams != null) {
            hashMap.putAll(elementParams);
        }
        VideoReport.setElementParams(view, hashMap);
        VideoReport.reportEvent("dt_clck", view, elementParams);
    }

    public final void b(@Nullable View view, @Nullable String id5, @Nullable Map<String, ? extends Object> elementParams) {
        VideoReport.setElementId(view, id5);
        if (elementParams != null) {
            VideoReport.setElementParams(view, elementParams);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    public final void c(@NotNull View view, @NotNull Activity activity, @NotNull String pageId, @Nullable Map<String, ? extends Object> pageParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(view, pageId);
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        if (pageParams != null) {
            hashMap.putAll(pageParams);
        }
        VideoReport.setPageParams(view, new PageParams(hashMap));
        VideoReport.setPageContentId(view, String.valueOf(SystemClock.elapsedRealtime()), true);
        VideoReport.setPageReportPolicy(view, PageReportPolicy.REPORT_ALL);
    }
}
