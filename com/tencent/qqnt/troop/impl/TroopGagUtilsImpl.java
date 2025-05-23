package com.tencent.qqnt.troop.impl;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopgag.data.e;
import com.tencent.qqnt.troop.ITroopGagUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J'\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u001d\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J'\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u001b\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0013\u0010\u0013\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0013\u0010\u0014\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0013\u0010\u0015\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0013\u0010\u0016\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0096\u0001J\u0019\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\rH\u0096\u0001J\u0011\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0096\u0001\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/troop/impl/TroopGagUtilsImpl;", "Lcom/tencent/qqnt/troop/ITroopGagUtils;", "", "troopUin", "", "clearMySelfGagInfo", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lfs2/a;", "callback", "fetchGagListFromDB", "fetchGagListFromNet", "fetchGagListWithMemberInfoFromNet", "", "isFirst", "Lcom/tencent/mobileqq/troop/troopgag/data/d;", "getSelfGagInfo", "Lcom/tencent/mobileqq/troop/troopgag/data/e;", "getTroopGagInfo", "getTroopOwnerReportStr", "isAdmin", "isMySelfSilent", "isOwner", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "onPushMeGagMsg", "onPushOtherMemberGagMsg", "onPushTroopGagMsg", "", "resId", "bSucceed", "showTipsToast", "", "gagTime", "transformGagTimeForSettingUI", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopGagUtilsImpl implements ITroopGagUtils {
    static IPatchRedirector $redirector_;
    private final /* synthetic */ TroopGagUtils $$delegate_0;

    public TroopGagUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = TroopGagUtils.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void clearMySelfGagInfo(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin);
        } else {
            this.$$delegate_0.clearMySelfGagInfo(troopUin);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void fetchGagListFromDB(@Nullable String troopUin, @Nullable LifecycleOwner owner, @Nullable fs2.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, owner, callback);
        } else {
            this.$$delegate_0.fetchGagListFromDB(troopUin, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void fetchGagListFromNet(@Nullable String troopUin, @Nullable LifecycleOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin, (Object) owner);
        } else {
            this.$$delegate_0.fetchGagListFromNet(troopUin, owner);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void fetchGagListWithMemberInfoFromNet(@Nullable String troopUin, @Nullable LifecycleOwner owner, @Nullable fs2.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, owner, callback);
        } else {
            this.$$delegate_0.fetchGagListWithMemberInfoFromNet(troopUin, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    @NotNull
    public com.tencent.mobileqq.troop.troopgag.data.d getSelfGagInfo(@Nullable String troopUin, boolean isFirst) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.troop.troopgag.data.d) iPatchRedirector.redirect((short) 6, this, troopUin, Boolean.valueOf(isFirst));
        }
        return this.$$delegate_0.getSelfGagInfo(troopUin, isFirst);
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    @NotNull
    public e getTroopGagInfo(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (e) iPatchRedirector.redirect((short) 7, (Object) this, (Object) troopUin);
        }
        return this.$$delegate_0.getTroopGagInfo(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    @NotNull
    public String getTroopOwnerReportStr(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) troopUin);
        }
        return this.$$delegate_0.getTroopOwnerReportStr(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public boolean isAdmin(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) troopUin)).booleanValue();
        }
        return this.$$delegate_0.isAdmin(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public boolean isMySelfSilent(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) troopUin)).booleanValue();
        }
        return this.$$delegate_0.isMySelfSilent(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public boolean isOwner(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) troopUin)).booleanValue();
        }
        return this.$$delegate_0.isOwner(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void onPushMeGagMsg(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) troopInfo);
        } else {
            Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
            this.$$delegate_0.onPushMeGagMsg(troopInfo);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void onPushOtherMemberGagMsg(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.onPushOtherMemberGagMsg(troopUin);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void onPushTroopGagMsg(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) troopInfo);
        } else {
            Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
            this.$$delegate_0.onPushTroopGagMsg(troopInfo);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    public void showTipsToast(int resId, boolean bSucceed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(resId), Boolean.valueOf(bSucceed));
        } else {
            this.$$delegate_0.showTipsToast(resId, bSucceed);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopGagUtils
    @NotNull
    public String transformGagTimeForSettingUI(long gagTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, gagTime);
        }
        return this.$$delegate_0.transformGagTimeForSettingUI(gagTime);
    }
}
