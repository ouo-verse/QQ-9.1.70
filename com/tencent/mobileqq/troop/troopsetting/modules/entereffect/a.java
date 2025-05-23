package com.tencent.mobileqq.troop.troopsetting.modules.entereffect;

import android.content.Context;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/entereffect/a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/entereffect/api/ITroopEnterEffectService;", "effectService", "Lcom/tencent/mobileqq/troop/api/IChatSettingForTroopApi;", "troopApi", "", "troopUin", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f301161a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60205);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301161a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@Nullable Context context, @NotNull ITroopEnterEffectService effectService, @NotNull IChatSettingForTroopApi troopApi, @NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(effectService, "effectService");
        Intrinsics.checkNotNullParameter(troopApi, "troopApi");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (context == null) {
            QLog.e("TroopEnterEffectHandler", 1, "invalid params");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putString("url", VasWebviewUtil.addEntryParamToUrl(troopApi.getUrlFromIndividuationUrlHelper_entryEffect() + "&gc=" + troopUin, 52));
        activityURIRequest.setRequestCode(15);
        QRoute.startUri(activityURIRequest, (o) null);
        eu.g("Grp_set_new", "grpData_admin", "specialEntrance_click", 0, 0, troopUin);
        effectService.report("grp_data", "entry_clk", troopUin);
        troopApi.reportCommercialDrainage(peekAppRuntime.getCurrentUin(), "style", "0X8008E62", "", 1, 0, 0, "", String.valueOf(effectService.getEffectId(troopUin)), "");
    }
}
