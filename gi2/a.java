package gi2;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "e", "", "a", "qq-live-base-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
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
}
