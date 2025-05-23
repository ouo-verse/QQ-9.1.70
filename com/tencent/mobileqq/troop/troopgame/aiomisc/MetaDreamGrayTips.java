package com.tencent.mobileqq.troop.troopgame.aiomisc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.action.k;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.xweb.FileReaderHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/troopgame/aiomisc/MetaDreamGrayTips;", "", "", "troopUin", "i", "", h.F, "j", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "c", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "b", "Lkotlin/Lazy;", "g", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkvEntity", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "checking", "Lcom/tencent/common/app/AppInterface;", "f", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class MetaDreamGrayTips {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MetaDreamGrayTips f300262a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mmkvEntity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean checking;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57631);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f300262a = new MetaDreamGrayTips();
        lazy = LazyKt__LazyJVMKt.lazy(MetaDreamGrayTips$mmkvEntity$2.INSTANCE);
        mmkvEntity = lazy;
        checking = new AtomicBoolean(false);
    }

    MetaDreamGrayTips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final String troopUin, boolean z16) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        MetaDreamGrayTips metaDreamGrayTips = f300262a;
        String j3 = metaDreamGrayTips.j(troopUin);
        if (z16) {
            metaDreamGrayTips.g().removeKey(metaDreamGrayTips.j(troopUin));
        } else if (metaDreamGrayTips.g().decodeLong(j3, 0L) != 0) {
            checking.set(false);
            return;
        }
        IRuntimeService runtimeService = metaDreamGrayTips.f().getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(troopUin);
        if (findTroopInfo != null) {
            boolean isExited = findTroopInfo.isExited();
            int i3 = findTroopInfo.groupExt.groupInfoExtSeq;
            boolean isTroopMDGameCardEnabled = findTroopInfo.isTroopMDGameCardEnabled();
            QLog.d("MetaDreamGrayTips", 1, "checkAndInsertEnableGrayTips(" + troopUin + ", " + z16 + "): troopExited=" + isExited + ", extSeq=" + i3 + ", mdCardEnabled=" + isTroopMDGameCardEnabled);
            if (!isExited && i3 > 0) {
                metaDreamGrayTips.g().encodeLong(j3, System.currentTimeMillis());
                if (isTroopMDGameCardEnabled) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopgame.aiomisc.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            MetaDreamGrayTips.e(troopUin);
                        }
                    });
                }
            }
        }
        checking.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        f300262a.h(troopUin);
    }

    private final AppInterface f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        return (AppInterface) peekAppRuntime;
    }

    private final MMKVOptionEntity g() {
        return (MMKVOptionEntity) mmkvEntity.getValue();
    }

    private final void h(String troopUin) {
        String tips = HardCodeUtil.qqStr(R.string.f2334677b);
        String str = " " + HardCodeUtil.qqStr(R.string.f23342778);
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(troopUin, 2, 2405L, 1, true, true, null);
        Intrinsics.checkNotNullExpressionValue(tips, "tips");
        LocalGrayTip.LocalGrayTipBuilder h16 = localGrayTipBuilder.g(tips, 1).h(str, new k(i(troopUin)), 3);
        QLog.d("MetaDreamGrayTips", 1, "insertEnableGrayTips on need, troopUin = " + troopUin);
        INtGrayTipApi iNtGrayTipApi = (INtGrayTipApi) QRoute.api(INtGrayTipApi.class);
        AppInterface f16 = f();
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type mqq.app.AppRuntime");
        iNtGrayTipApi.addLocalGrayTip(f16, h16.m(), null);
    }

    private final String i(String troopUin) {
        return "mqqapi://card/show_pslcard?card_type=groupsetting&uin=" + troopUin + "&focus_item=wangzhe&version=1&src_type=internal";
    }

    public final void c(@NotNull final String troopUin, final boolean force) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, Boolean.valueOf(force));
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AtomicBoolean atomicBoolean = checking;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopgame.aiomisc.a
            @Override // java.lang.Runnable
            public final void run() {
                MetaDreamGrayTips.d(troopUin, force);
            }
        }, 16, null, true);
    }

    @NotNull
    public final String j(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return "TroopGame" + f().getCurrentAccountUin() + "MetaDreamGrayTipsCheckTimeStamp" + troopUin;
    }
}
