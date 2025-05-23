package et3;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqlive.common.api.IAegisLogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0017\u0010\u0004\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqlive/common/api/IAegisLogApi;", "a", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "()Lcom/tencent/qqlive/common/api/IAegisLogApi;", "Logger", "qq-live-common-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final IAegisLogApi f397112a;

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "<clinit>");
        f397112a = (IAegisLogApi) api;
    }

    @NotNull
    public static final IAegisLogApi a() {
        return f397112a;
    }
}
