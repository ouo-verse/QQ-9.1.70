package com.tencent.qqnt.troop.inner;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/troop/inner/b;", "", "", "troopUin", "b", "c", "", "troopMemNumSeq", "", "e", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "a", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "d", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mmkv", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f362726a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63233);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f362726a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(String troopUin) {
        return "troopMemNumSeq3-" + troopUin;
    }

    private final String c(String troopUin) {
        return "troopMemNumSeq3-" + troopUin;
    }

    private final MMKVOptionEntityV2 d() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP)");
        return fromV2;
    }

    public final long a(@Nullable String troopUin, @NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) troopInfo)).longValue();
        }
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        if (troopUin == null) {
            return 0L;
        }
        if (troopInfo.getMemberNum() <= 4 && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106150", true) && d().getLong(c(troopUin), 0L) == 0) {
            d().putLong(c(troopUin), troopInfo.mMemberNumSeq);
        }
        return d().getLong(b(troopUin), 0L);
    }

    public final void e(@Nullable String troopUin, long troopMemNumSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, Long.valueOf(troopMemNumSeq));
        } else {
            if (troopUin == null) {
                return;
            }
            d().putLong(b(troopUin), troopMemNumSeq);
        }
    }
}
