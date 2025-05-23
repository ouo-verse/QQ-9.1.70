package com.tencent.mobileqq.troop.teamup.home;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.TroopInfoRepo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ3\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/a;", "", "", "troopId", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "callback", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f298951a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55752);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f298951a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull String troopId, @NotNull Function1<? super Boolean, Unit> callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(troopId, "troopId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (QLog.isDebugVersion()) {
            QLog.d("TroopTeamUpTeamUpRoleChecker", 4, "handleWhenInGroup for " + troopId);
        }
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopId);
        if (troopInfoFromCache != null) {
            z16 = troopInfoFromCache.hadJoinTroop();
        } else {
            z16 = false;
        }
        callback.invoke(Boolean.valueOf(z16));
    }
}
