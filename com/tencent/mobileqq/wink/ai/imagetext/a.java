package com.tencent.mobileqq.wink.ai.imagetext;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.report.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u001a\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/ai/imagetext/a;", "", "", "", "a", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f317671a = new a();

    a() {
    }

    @NotNull
    public final Map<String, String> a() {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("compressTime", "0"), TuplesKt.to(PhotoCategorySinglePicInfo.UPLOAD_TIME, "0"), TuplesKt.to("firstTokenTime", "0"), TuplesKt.to("totalTime", "0"), TuplesKt.to(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "0"), TuplesKt.to("textCount", "0"), TuplesKt.to("useStream", "1"), TuplesKt.to("concurrent", "1"));
        return mutableMapOf;
    }

    public final void b(@NotNull Map<String, String> reportParams) {
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        e.f326265a.n("seed#image#text#costime", reportParams, true);
    }
}
