package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import eipc.EIPCCallback;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011J:\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\u000f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasProfileCardApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "layoutId", "backgroundId", "cardId", "", "extInfo", "diyTemplate", "Leipc/EIPCCallback;", "callback", "", "setProfileCard", "", "forceRequest", "getCardInfo", "Companion", "a", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasProfileCardApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f308452a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0003\u001a\u00020\u0002H\u0087\b\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasProfileCardApi$a;", "", "Lcom/tencent/mobileqq/vas/api/IVasProfileCardApi;", "a", "<init>", "()V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.api.IVasProfileCardApi$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f308452a = new Companion();

        Companion() {
        }

        @JvmStatic
        @NotNull
        public final IVasProfileCardApi a() {
            QRouteApi api = QRoute.api(IVasProfileCardApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVasProfileCardApi::class.java)");
            return (IVasProfileCardApi) api;
        }
    }

    void getCardInfo(@Nullable EIPCCallback callback, boolean forceRequest);

    void setProfileCard(long layoutId, long backgroundId, long cardId, @NotNull String extInfo, @NotNull String diyTemplate, @Nullable EIPCCallback callback);
}
