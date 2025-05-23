package com.tencent.mobileqq.vip.api;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fJ:\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipPayApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "payJsonString", "", "invokerId", "url", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/vip/api/k;", "callBackVip", "", "newPay", "Companion", "a", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVipPayApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String AID = "mvip.pt.client.privilege_svip";

    @NotNull
    public static final String BASE_URL = "https://pay.qq.com/h5/index.shtml?";
    public static final int BUSINESS_TYPE = 100;

    @NotNull
    public static final String CMD = "trpc.tianxuan.commpay.RevenueCommPay.SsoBuyItem";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String DEFAULT_DOMAIN = "vip.qq.com";

    @NotNull
    public static final String ITEM_ID = "85459_84ad93b2";

    @NotNull
    public static final String METHOD_BUYGOODS = "buyGoods";

    @NotNull
    public static final String METHOD_PAY_SUBSCRIBE = "paySubscribe";

    @NotNull
    public static final String PAY_TAG = "VAS_PAY";

    @NotNull
    public static final String PF_PREFIX = "qq_m_qq-2001-android-2011-";

    @NotNull
    public static final String PF_SUFFIX = "$a$b13$x$t0";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipPayApi$a;", "", "<init>", "()V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.IVipPayApi$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f312789a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39956);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f312789a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(39958), (Class<?>) IVipPayApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f312789a;
        }
    }

    void newPay(@NotNull String payJsonString, int invokerId, @NotNull String url, @NotNull String reportAction, @NotNull Activity activity, @Nullable k callBackVip);
}
