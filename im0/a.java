package im0;

import com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import hm0.WXMiniSessionData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\f\u0010\t\u001a\u00020\u0002*\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lim0/a;", "", "", "action", "", "params", "", "a", "", "c", "Lhm0/a;", "reportData", "b", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f407983a = new a();

    a() {
    }

    private final void a(String action, Map<String, String> params) {
        if (QLog.isColorLevel()) {
            QLog.i("GdtWXMINIProgramReportHelper", 2, "reportJumpAction, params: " + params);
        }
        ((IAdAttaReporterApi) QRoute.api(IAdAttaReporterApi.class)).report("wxmini", "mini_ad", action, params);
    }

    private final String c(boolean z16) {
        if (z16) {
            return "1";
        }
        return "0";
    }

    public final void b(@NotNull WXMiniSessionData reportData) {
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        if (QLog.isColorLevel()) {
            QLog.i("GdtWXMINIProgramReportHelper", 2, "reportWXMiniJumpAction");
        }
        a aVar = f407983a;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("ext1", reportData.getPosId()), TuplesKt.to("ext2", reportData.getAppId()), TuplesKt.to("ext3", reportData.getTraceId()), TuplesKt.to("ext4", reportData.getOriginId()), TuplesKt.to("ext5", String.valueOf(reportData.getJumpTypeQQMC())), TuplesKt.to("ext6", String.valueOf(reportData.getJumpTypeAMS())), TuplesKt.to("ext7", aVar.c(reportData.getHasAuth())), TuplesKt.to("ext8", aVar.c(reportData.getJumpSuccess())), TuplesKt.to("ext9", aVar.c(reportData.getUndertake())), TuplesKt.to("ext10", aVar.c(reportData.getJumpInside())));
        aVar.a("jump", mapOf);
    }
}
