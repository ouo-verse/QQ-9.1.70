package com.tencent.qqnt.push.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.mobileqq.troop.announcement.api.impl.TroopAnnouncementHandler;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/push/impl/TroopAnnouncementPushHelper;", "", "", "troopUin", "", "joinTime", "", "b", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class TroopAnnouncementPushHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopAnnouncementPushHelper f360710a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62558);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f360710a = new TroopAnnouncementPushHelper();
        }
    }

    TroopAnnouncementPushHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull final String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (bg.e() == null) {
            return;
        }
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopSeqAndJoinTime(troopUin, "TroopAnnouncementPushHelper", null, new Function2<Boolean, TroopInfo, Unit>(troopUin) { // from class: com.tencent.qqnt.push.impl.TroopAnnouncementPushHelper$getAnnouncementAfterJoin$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $troopUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$troopUin = troopUin;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAnnouncementPushHelper.this, (Object) troopUin);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                invoke(bool.booleanValue(), troopInfo);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull TroopInfo troopInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), troopInfo);
                } else {
                    Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
                    TroopAnnouncementPushHelper.this.b(this.$troopUin, troopInfo.dwCmdUinJoinTime);
                }
            }
        });
    }

    public final void b(@NotNull String troopUin, long joinTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, Long.valueOf(joinTime));
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppInterface e16 = bg.e();
        if (e16 == null) {
            return;
        }
        com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
        long k3 = aVar.k("get_troop_intro_time", 0L, true);
        int troopIntroGapHour = ((ITroopAnnouncementHelperApi) QRoute.api(ITroopAnnouncementHelperApi.class)).getTroopIntroGapHour();
        if (joinTime > 0 && NetConnInfoCenter.getServerTime() - k3 > troopIntroGapHour * 60 * 60) {
            BusinessHandler businessHandler = e16.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.announcement.api.impl.TroopAnnouncementHandler");
            ((TroopAnnouncementHandler) businessHandler).K2(troopUin, troopUin, (short) 34);
            aVar.w("get_troop_intro_time", NetConnInfoCenter.getServerTime(), true);
        }
    }
}
