package com.tencent.mobileqq.zplan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u0000 \n2\u00020\u0001:\u0001\u000bJ\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZplanHandleApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "business", "method", "params", "", "handleDataToUE", "", "handleDataToMain", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZplanHandleApi extends QRouteApi {

    @NotNull
    public static final String BUSINESS_DRESS_INFO = "dressInfo";

    @NotNull
    public static final String BUSINESS_MOD_API = "modApi";

    @NotNull
    public static final String BUSINESS_RESERVE = "reservation";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f331334a;

    @NotNull
    public static final String METHOD_REFRESH_DRESS_INFO = "refreshDressInfo";

    @NotNull
    public static final String METHOD_REFRESH_RESERVE = "refreshReservationList";

    @NotNull
    public static final String METHOD_SILENCE_DOWNLOAD = "silentDownloadModInQQScene";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZplanHandleApi$a;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.api.IZplanHandleApi$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f331334a = new Companion();

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b {
        public static /* synthetic */ boolean a(IZplanHandleApi iZplanHandleApi, String str, String str2, String str3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str3 = null;
                }
                return iZplanHandleApi.handleDataToMain(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleDataToMain");
        }
    }

    boolean handleDataToMain(@NotNull String business, @NotNull String method, @Nullable String params);

    void handleDataToUE(@NotNull String business, @NotNull String method, @Nullable String params);
}
