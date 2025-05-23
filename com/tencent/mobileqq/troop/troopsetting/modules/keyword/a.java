package com.tencent.mobileqq.troop.troopsetting.modules.keyword;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.ax;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.troopsetting.modules.base.j;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ.\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/keyword/a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/api/IChatSettingForTroopApi;", "troopApi", "Lcom/tencent/mobileqq/troop/a;", "status", "", "troopUin", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f301176a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301176a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@Nullable Context context, @NotNull IChatSettingForTroopApi troopApi, @Nullable com.tencent.mobileqq.troop.a status, @Nullable String troopUin) {
        String replace$default;
        Intrinsics.checkNotNullParameter(troopApi, "troopApi");
        if (context != null && status != null && troopUin != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            AppInterface appInterface = (AppInterface) peekAppRuntime;
            long j3 = status.f293505g;
            long uptimeMillis = SystemClock.uptimeMillis();
            status.f293505g = uptimeMillis;
            if (uptimeMillis < j3 + 1000) {
                return;
            }
            troopApi.setStringForQVipConfigManager_keyWordExpireList(appInterface, troopUin, status.f293500b);
            troopApi.setBooleanForQVipConfigManager_keyWordGuideClicked(appInterface);
            String urlFromIndividuationUrlHelper_keyWord = troopApi.getUrlFromIndividuationUrlHelper_keyWord();
            Intrinsics.checkNotNullExpressionValue(urlFromIndividuationUrlHelper_keyWord, "troopApi.urlFromIndividuationUrlHelper_keyWord");
            ax.f200193c = urlFromIndividuationUrlHelper_keyWord;
            replace$default = StringsKt__StringsJVMKt.replace$default(urlFromIndividuationUrlHelper_keyWord, "[groupid]", troopUin, false, 4, (Object) null);
            ax.f200193c = replace$default;
            String addParameter = URLUtil.addParameter(replace$default, "from", VipFunCallConstants.KEY_GROUP);
            Intrinsics.checkNotNullExpressionValue(addParameter, "addParameter(WebViewAutoTest.url, \"from\", \"group\")");
            ax.f200193c = addParameter;
            QLog.d("TroopKeywordHandler", 2, "onClick: " + addParameter);
            j.f301158a.b(appInterface, "dc00898", "", troopUin, QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A8F8", (r29 & 64) != 0 ? 0 : status.f293504f, (r29 & 128) != 0 ? 0 : 1, (r29 & 256) != 0 ? "" : null, (r29 & 512) != 0 ? "" : null, (r29 & 1024) != 0 ? "" : null, (r29 & 2048) != 0 ? "" : null);
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_BROWSER);
            activityURIRequest.extra().putLong("startOpenPageTime", System.currentTimeMillis());
            activityURIRequest.extra().putString("url", ax.f200193c);
            activityURIRequest.extra().putBoolean("isShowAd", false);
            QRoute.startUri(activityURIRequest, (o) null);
            return;
        }
        QLog.e("TroopKeywordHandler", 1, "handleClickAction invalid params");
    }
}
