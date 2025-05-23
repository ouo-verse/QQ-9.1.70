package p32;

import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.techreport.d;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"", "e", "", "b", "a", "ic-game-base-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    public static final void a(@NotNull Throwable e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        StringBuilder sb5 = new StringBuilder();
        StackTraceElement[] stackTrace = e16.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb5.append(stackTraceElement.toString());
            sb5.append("\n");
        }
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).a("page_sdk_exception", sb5.toString());
    }

    public static final void b(@NotNull Throwable e16) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(e16, "e");
        StringBuilder sb5 = new StringBuilder();
        StackTraceElement[] stackTrace = e16.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb5.append(stackTraceElement.toString());
            sb5.append("\n");
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(AudienceReportConst.EVENT_MSG, sb5.toString()));
        d.g("ev_icgame_call_from_wrong_thread", mapOf);
    }
}
