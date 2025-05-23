package com.tencent.mobileqq.troop.troopgame.api.impl;

import android.app.Dialog;
import android.content.Context;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.mobileqq.troop.troopgame.aiomisc.MetaDreamGrayTips;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameApi;
import com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.model.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.troop.TroopInfoRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0015\u0016B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/troopgame/api/impl/TroopGameApiImpl;", "Lcom/tencent/mobileqq/troop/troopgame/api/ITroopGameApi;", "Lcom/tencent/aio/main/businesshelper/h;", "createHelper", "", "troopUin", "", "isJoin", "isPassive", "", "handleJoinOrExitTroop", "Landroid/content/Context;", "context", "Landroid/app/Dialog;", "showTroopGameCardTipsIfNeeded", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "enableShowGameCard", "<init>", "()V", "Companion", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopGameApiImpl implements ITroopGameApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "TroopGameApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopgame/api/impl/TroopGameApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopgame.api.impl.TroopGameApiImpl$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J$\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/troopgame/api/impl/TroopGameApiImpl$b;", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", "isSuc", "", "uin", "", "onGetTroopInfoResult", "isSucc", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExt;", "oldTroppInfoExtObj", "onGetTroopInfoExtComplete", "d", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String troopUin;

        public b(@NotNull String troopUin) {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin);
            } else {
                this.troopUin = troopUin;
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoExtComplete(boolean isSucc, @Nullable String troopUin, @Nullable GroupExt oldTroppInfoExtObj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(isSucc), troopUin, oldTroppInfoExtObj);
                return;
            }
            QLog.d(TroopGameApiImpl.TAG, 1, "onGetTroopInfoExtComplete(isSuc=" + isSucc + ", troopUin=" + troopUin + ")");
            if (!Intrinsics.areEqual(troopUin, this.troopUin)) {
                return;
            }
            MetaDreamGrayTips.f300262a.c(this.troopUin, false);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            ((AppInterface) peekAppRuntime).removeObserver(this);
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoResult(boolean isSuc, @Nullable String uin) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuc), uin);
                return;
            }
            if (uin == null) {
                return;
            }
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(uin);
            QLog.d(TroopGameApiImpl.TAG, 1, "onGetSimpleTroopInfoResult(isSuc=" + isSuc + ", troopUin=" + this.troopUin + ", info=" + troopInfoFromCache + ")");
            if (troopInfoFromCache != null) {
                str = troopInfoFromCache.getTroopUin();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, this.troopUin) && troopInfoFromCache.groupExt.groupInfoExtSeq != 0) {
                MetaDreamGrayTips.f300262a.c(this.troopUin, false);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                ((AppInterface) peekAppRuntime).removeObserver(this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57644);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopGameApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.ITroopGameApi
    @NotNull
    public h createHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.mobileqq.troop.troopgame.e();
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.ITroopGameApi
    public boolean enableShowGameCard(@Nullable TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopInfo)).booleanValue();
        }
        if (com.tencent.mobileqq.troop.troopsetting.vm.a.f301534a.a() && com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.model.a.a(troopInfo)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.ITroopGameApi
    public void handleJoinOrExitTroop(@NotNull String troopUin, boolean isJoin, boolean isPassive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, Boolean.valueOf(isJoin), Boolean.valueOf(isPassive));
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        QLog.d(TAG, 1, "handleJoinOrExitTroop(troopUin=" + troopUin + ", isJoin=" + isJoin + ", isPassive=" + isPassive + ")");
        if (isJoin) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            ((AppInterface) peekAppRuntime).addObserver(new b(troopUin));
            MetaDreamGrayTips.f300262a.c(troopUin, true);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.ITroopGameApi
    @Nullable
    public Dialog showTroopGameCardTipsIfNeeded(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Dialog) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return c.b(context);
    }
}
