package com.tencent.mobileqq.wink.report;

import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/report/b;", "", "", "loadingType", "timeCost", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "a", "", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f326260a = new b();

    b() {
    }

    private final WinkPublishQualityReportData a(String loadingType, String timeCost) {
        WinkPublishQualityReportData winkPublishQualityReportData = new WinkPublishQualityReportData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 32767, null);
        winkPublishQualityReportData.setTraceId(WinkContext.INSTANCE.d().getTraceId());
        winkPublishQualityReportData.setEventId("E_PICKER_LOADING");
        winkPublishQualityReportData.setExt1(timeCost);
        winkPublishQualityReportData.setExt4(loadingType);
        return winkPublishQualityReportData;
    }

    public final void b(@NotNull String loadingType, @NotNull String timeCost) {
        Intrinsics.checkNotNullParameter(loadingType, "loadingType");
        Intrinsics.checkNotNullParameter(timeCost, "timeCost");
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 != null) {
            f16.b(a(loadingType, timeCost), WinkContext.INSTANCE.d().k().a());
        }
    }
}
