package com.tencent.mobileqq.vip.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J \u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\u001a\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0004H&J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&R\u0014\u0010\u0015\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipDataUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uin", "", "vipdataFlag", "Lcom/tencent/mobileqq/vip/api/VipData;", "getVipData", "getVipDataForFriends", "Lkotlin/Function0;", "", "callBack", "requestAndUpdateData", "vipDataFlag", "updateFlagData", "Lcom/tencent/mobileqq/vip/api/j;", "callback", "registerVipDataChangedCallback", "unRegisterVipDataChangedCallback", "getSplendidTitle", "()Ljava/lang/String;", "splendidTitle", "Companion", "a", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVipDataUtils extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipDataUtils$a;", "", "Lcom/tencent/mobileqq/vip/api/IVipDataUtils;", "a", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.IVipDataUtils$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f312787a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39898);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f312787a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @JvmStatic
        @NotNull
        public final IVipDataUtils a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IVipDataUtils) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            QRouteApi api = QRoute.api(IVipDataUtils.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVipDataUtils::class.java)");
            return (IVipDataUtils) api;
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(39904), (Class<?>) IVipDataUtils.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2);
        } else {
            INSTANCE = Companion.f312787a;
        }
    }

    @NotNull
    String getSplendidTitle();

    @NotNull
    VipData getVipData(@Nullable String uin, int vipdataFlag);

    @NotNull
    VipData getVipDataForFriends(@Nullable String uin);

    void registerVipDataChangedCallback(@NotNull String uin, @NotNull j callback);

    void requestAndUpdateData(@NotNull String uin, @Nullable Function0<Unit> callBack);

    void unRegisterVipDataChangedCallback(@NotNull String uin, @Nullable j callback);

    void updateFlagData(@Nullable String uin, int vipDataFlag);
}
