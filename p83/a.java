package p83;

import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.b;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import z93.c;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJM\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0007J\u001e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\tJ\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u001c"}, d2 = {"Lp83/a;", "", "", "step", "packageUrl", "Lcom/tencent/mobileqq/winkpublish/report/b;", "errorCode", "", QzoneIPCModule.RESULT_CODE, "", QCircleWeakNetReporter.KEY_COST, "fileSize", "", "b", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/winkpublish/report/b;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "a", "e", "i", "d", "progress", "g", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "costMs", h.F, "f", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f425783a = new a();

    a() {
    }

    private final void b(String step, String packageUrl, b errorCode, Integer resultCode, Long cost, Long fileSize) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            Result.Companion companion = Result.INSTANCE;
            WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_WINK_MATERIAL_DOWNLOAD");
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            WinkContext e16 = companion2.e();
            Unit unit = null;
            if (e16 != null) {
                str = e16.getTraceId();
            } else {
                str = null;
            }
            WinkPublishQualityReportData.Builder ext2 = eventId.traceId(str).ext1(step).ext2(packageUrl);
            if (cost != null) {
                str2 = cost.toString();
            } else {
                str2 = null;
            }
            WinkPublishQualityReportData.Builder ext3 = ext2.ext3(str2);
            if (fileSize != null) {
                str3 = fileSize.toString();
            } else {
                str3 = null;
            }
            WinkPublishQualityReportData.Builder ext4 = ext3.ext4(str3);
            if (errorCode != null) {
                str4 = Long.valueOf(errorCode.transformedCode()).toString();
            } else {
                str4 = null;
            }
            WinkPublishQualityReportData.Builder ext5 = ext4.ext5(str4);
            if (errorCode != null) {
                str5 = errorCode.getMessage();
            } else {
                str5 = null;
            }
            WinkPublishQualityReportData reportData = ext5.ext6(str5).retCode(String.valueOf(resultCode)).getReportData();
            c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                f16.a(reportData, companion2.d().k().b());
                unit = Unit.INSTANCE;
            }
            Result.m476constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    static /* synthetic */ void c(a aVar, String str, String str2, b bVar, Integer num, Long l3, Long l16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            num = 0;
        }
        Integer num2 = num;
        if ((i3 & 16) != 0) {
            l3 = 0L;
        }
        Long l17 = l3;
        if ((i3 & 32) != 0) {
            l16 = 0L;
        }
        aVar.b(str, str2, bVar, num2, l17, l16);
    }

    public final void a(@NotNull String packageUrl) {
        Intrinsics.checkNotNullParameter(packageUrl, "packageUrl");
        w53.b.f("MaterialDownloadReporter", "[beforeStart] " + packageUrl);
        c(this, "beforeStart", packageUrl, null, null, null, null, 56, null);
    }

    public final void d(@NotNull String packageUrl, @NotNull b errorCode) {
        Intrinsics.checkNotNullParameter(packageUrl, "packageUrl");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        w53.b.f("MaterialDownloadReporter", "[intercept] errorCode=" + errorCode + ", " + packageUrl);
        c(this, "intercept", packageUrl, errorCode, null, null, null, 56, null);
    }

    public final void e(@NotNull String packageUrl, @NotNull b errorCode) {
        Intrinsics.checkNotNullParameter(packageUrl, "packageUrl");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        w53.b.f("MaterialDownloadReporter", "[interceptStart] errorCode=" + errorCode + ", " + packageUrl);
        c(this, "interceptStart", packageUrl, errorCode, null, null, null, 56, null);
    }

    public final void f(@NotNull String packageUrl, @Nullable b errorCode) {
        Intrinsics.checkNotNullParameter(packageUrl, "packageUrl");
        c(this, "onFinished", packageUrl, errorCode, null, null, null, 56, null);
    }

    public final void g(@NotNull String packageUrl, int progress) {
        Intrinsics.checkNotNullParameter(packageUrl, "packageUrl");
        w53.b.f("MaterialDownloadReporter", "[onProgressUpdated] progress=" + progress + ", " + packageUrl);
    }

    public final void h(@NotNull String packageUrl, @NotNull NetResp resp, long costMs) {
        Intrinsics.checkNotNullParameter(packageUrl, "packageUrl");
        Intrinsics.checkNotNullParameter(resp, "resp");
        b bVar = new b(resp.mErrCode, resp.mErrDesc);
        w53.b.f("MaterialDownloadReporter", "[onResp] result=" + resp.mResult + ", errorCode=" + bVar + ", costMs=" + costMs + ", fileSize=" + resp.mTotalFileLen + ", " + packageUrl);
        b("onResp", packageUrl, bVar, Integer.valueOf(resp.mResult), Long.valueOf(costMs), Long.valueOf(resp.mTotalFileLen));
    }

    public final void i(@NotNull String packageUrl) {
        Intrinsics.checkNotNullParameter(packageUrl, "packageUrl");
        w53.b.f("MaterialDownloadReporter", "[onStarted] " + packageUrl);
        c(this, "onStarted", packageUrl, null, null, null, null, 56, null);
    }
}
