package com.tencent.mobileqq.troop.troopownertask;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.troopownertask.api.impl.TroopOwnerTaskCacheRepo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0007J\u0016\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopownertask/g;", "", "", "g", "", "troopUin", "Lkotlin/Function1;", "", "runnable", "b", "d", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/b;", "task", "k", "f", "j", "e", "Landroid/content/Context;", "context", WadlProxyConsts.KEY_JUMP_URL, "i", "", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/a;", TabPreloadItem.TAB_NAME_MESSAGE, h.F, "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f301003a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60004);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f301003a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 runnable, String str, TroopInfo troopInfo) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        boolean z16 = false;
        if (troopInfo != null && troopInfo.isTroopOwner(str)) {
            z16 = true;
        }
        runnable.invoke(Boolean.valueOf(z16));
    }

    public final void b(@NotNull String troopUin, @NotNull final Function1<? super Boolean, Unit> runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        final String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026va, ProcessConstant.MAIN)");
        ((ITroopInfoService) runtimeService).asyncGetTroopInfo(troopUin, new com.tencent.mobileqq.data.troop.a() { // from class: com.tencent.mobileqq.troop.troopownertask.f
            @Override // com.tencent.mobileqq.data.troop.a
            public final void a(TroopInfo troopInfo) {
                g.c(Function1.this, currentAccountUin, troopInfo);
            }
        });
    }

    public final boolean d(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026va, ProcessConstant.MAIN)");
        TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(troopUin);
        if (findTroopInfo != null) {
            return findTroopInfo.isTroopOwner(currentAccountUin);
        }
        return false;
    }

    public final boolean e(@NotNull String troopUin, @NotNull com.tencent.mobileqq.troop.troopownertask.api.impl.b task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) troopUin, (Object) task)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(task, "task");
        if (g() && d(troopUin) && task.c() > 0 && !TroopOwnerTaskCacheRepo.f300970a.c()) {
            return true;
        }
        return false;
    }

    public final boolean f(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (g() && d(troopUin)) {
            TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
            if (troopOwnerTaskCacheRepo.d()) {
                return true;
            }
            com.tencent.mobileqq.troop.troopownertask.api.impl.b n3 = troopOwnerTaskCacheRepo.n(troopUin);
            if (n3.e() > 0 || n3.c() > 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Nullable
    public final com.tencent.mobileqq.troop.troopownertask.api.impl.a h(@NotNull List<com.tencent.mobileqq.troop.troopownertask.api.impl.a> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.troop.troopownertask.api.impl.a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgList);
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        com.tencent.mobileqq.troop.troopownertask.api.impl.a aVar = null;
        long j3 = 0;
        for (com.tencent.mobileqq.troop.troopownertask.api.impl.a aVar2 : msgList) {
            if (aVar2.c() > j3) {
                aVar = aVar2;
            }
            j3 = aVar2.c();
        }
        return aVar;
    }

    public final void i(@NotNull Context context, @NotNull String jumpUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) jumpUrl);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).jumpToUrl(context, jumpUrl);
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            TroopOwnerTaskCacheRepo.f300970a.t();
        }
    }

    public final void k(@NotNull String troopUin, @NotNull com.tencent.mobileqq.troop.troopownertask.api.impl.b task) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin, (Object) task);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(task, "task");
        if (e(troopUin, task)) {
            i3 = task.c();
        } else {
            i3 = 0;
        }
        ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(MobileQQ.sMobileQQ.peekAppRuntime(), troopUin, "troop", 7, i3);
    }
}
