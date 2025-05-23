package ca3;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lca3/c;", "Lz93/c;", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "data", "", "businessType", "", "a", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "b", "getTraceId", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c implements z93.c {
    @Override // z93.c
    public void a(@NotNull WinkPublishQualityReportData data, int businessType) {
        Intrinsics.checkNotNullParameter(data, "data");
        WinkPublishReportQueue.INSTANCE.report(data, businessType);
    }

    @Override // z93.c
    public void b(@NotNull WinkPublishQualityReportData data, @NotNull String businessName) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        WinkPublishReportQueue.INSTANCE.report(data, businessName);
    }

    @Override // z93.c
    @NotNull
    public String getTraceId() {
        String format = new SimpleDateFormat("MMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
        String str = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + format + "_" + UUID.randomUUID();
        QLog.d("QQWinkQualityReportApiImpl", 1, "traceId:" + str);
        return str;
    }
}
