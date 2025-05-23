package com.tencent.mobileqq.troop.flame.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troopmanage.ITroopManageApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.action.f;
import com.tencent.qqnt.graytips.action.l;
import com.tencent.qqnt.graytips.handler.b;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildPermissionService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/api/impl/a;", "Lcom/tencent/qqnt/graytips/handler/b;", "Landroid/content/Context;", "context", "", "troopUin", "", "d", "Lcom/tencent/qqnt/graytips/action/f;", "actionInfo", "Lorg/json/JSONObject;", "b", "jsonObject", "a", "Lmqq/app/AppRuntime;", "app", "Lgv3/a;", "aioAbility", "c", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/api/impl/a$a;", "", "", "TAG", "Ljava/lang/String;", "TROOP_UIN", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.flame.api.impl.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35641);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(Context context, String troopUin) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intent intent = new Intent();
        intent.putExtra("uin", peekAppRuntime.getCurrentAccountUin());
        intent.putExtra("troop_uin", troopUin);
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        ITroopInfoService iTroopInfoService = (ITroopInfoService) runtimeService;
        intent.putExtra(AppConstants.Key.KEY_QIDIAN_PRIVATE_TROOP, iTroopInfoService.isQidianPrivateTroop(troopUin));
        boolean isTroopGuild = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuild(troopUin);
        intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_IS_GUILD, isTroopGuild);
        TroopInfo findTroopInfo = iTroopInfoService.findTroopInfo(troopUin);
        if (isTroopGuild) {
            String troopGuildId = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildId(troopUin);
            intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_GUILD_ID, troopGuildId);
            intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_CHANNEL_ID, ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopFeedChannelId(troopGuildId));
            boolean z16 = false;
            intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_GUILD_FEED_PERMISSION, ((ITroopGuildPermissionService) peekAppRuntime.getRuntimeService(ITroopGuildPermissionService.class, "")).getTroopFeedTalkPermission(troopGuildId, false));
            if (findTroopInfo != null) {
                z16 = findTroopInfo.isTroopGuildSwitchOpen();
            }
            intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_GUILD_FEED_SWITCH, z16);
        }
        intent.putExtra(ITroopManageApi.KEY_IS_FROM_FLAME_GRAY_TIPS, true);
        ((ITroopManageApi) QRoute.api(ITroopManageApi.class)).openTroopSubManageFeatureFragment(context, intent);
        QLog.i("TroopFlameSwitchSettingHandler", 1, "[jumpToFlameSwitchSettingPage] troopUin = " + troopUin);
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    @NotNull
    public f a(@NotNull JSONObject jsonObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this, (Object) jsonObject);
        }
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String optString = jsonObject.optString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(TROOP_UIN, \"\")");
        return new l(optString);
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    @NotNull
    public JSONObject b(@NotNull f actionInfo) {
        l lVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSONObject) iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionInfo);
        }
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        JSONObject jSONObject = new JSONObject();
        if (actionInfo instanceof l) {
            lVar = (l) actionInfo;
        } else {
            lVar = null;
        }
        if (lVar != null) {
            jSONObject.put("troop_uin", lVar.a());
        }
        return jSONObject;
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public void c(@NotNull AppRuntime app, @NotNull Context context, @NotNull f actionInfo, @Nullable gv3.a aioAbility) {
        l lVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, app, context, actionInfo, aioAbility);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        if (actionInfo instanceof l) {
            lVar = (l) actionInfo;
        } else {
            lVar = null;
        }
        if (lVar != null) {
            if (lVar.a().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                d(context, lVar.a());
            }
        }
    }
}
