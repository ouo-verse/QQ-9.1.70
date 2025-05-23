package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasPagLoadApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "initPagSo", "", "requestPagDownload", "", "block", "Lkotlin/Function0;", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasPagLoadApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0087\bJ\t\u0010\u0005\u001a\u00020\u0004H\u0086\n\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasPagLoadApi$Companion;", "", "()V", "get", "Lcom/tencent/mobileqq/vas/api/IVasPagLoadApi;", "invoke", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        Companion() {
        }

        @JvmStatic
        @NotNull
        public final IVasPagLoadApi get() {
            QRouteApi api = QRoute.api(IVasPagLoadApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVasPagLoadApi::class.java)");
            return (IVasPagLoadApi) api;
        }

        @NotNull
        public final IVasPagLoadApi invoke() {
            QRouteApi api = QRoute.api(IVasPagLoadApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVasPagLoadApi::class.java)");
            return (IVasPagLoadApi) api;
        }
    }

    boolean initPagSo();

    void requestPagDownload(@NotNull Function0<Unit> block);
}
