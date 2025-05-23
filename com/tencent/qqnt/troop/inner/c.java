package com.tencent.qqnt.troop.inner;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.qqnt.troop.TroopInfoRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\r\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/troop/inner/c;", "", "", "troopUin", "b", "a", "d", "troopName", "", "e", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "c", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mmkv", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f362727a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63235);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f362727a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a(String troopUin) {
        String string;
        if (troopUin == null || (string = c().getString(b(troopUin), "")) == null) {
            return "";
        }
        return string;
    }

    private final String b(String troopUin) {
        return "troopName-" + troopUin;
    }

    private final MMKVOptionEntityV2 c() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP)");
        return fromV2;
    }

    @NotNull
    public final String d(@Nullable String troopUin) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin);
        }
        if (troopUin == null) {
            return "";
        }
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
        boolean z18 = true;
        if (troopInfoFromCache != null) {
            String str = troopInfoFromCache.troopNameFromNT;
            if (str != null) {
                if (str.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (z16 && !Intrinsics.areEqual(troopInfoFromCache.troopNameFromNT, troopUin)) {
                        String str2 = troopInfoFromCache.troopNameFromNT;
                        Intrinsics.checkNotNullExpressionValue(str2, "{\n            troopInfo.troopNameFromNT\n        }");
                        return str2;
                    }
                }
            }
            z16 = false;
            if (z16) {
                String str22 = troopInfoFromCache.troopNameFromNT;
                Intrinsics.checkNotNullExpressionValue(str22, "{\n            troopInfo.troopNameFromNT\n        }");
                return str22;
            }
        }
        String a16 = a(troopUin);
        if (a16.length() != 0) {
            z18 = false;
        }
        if (!z18) {
            return a16;
        }
        return troopUin;
    }

    public final void e(@Nullable String troopUin, @Nullable String troopName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) troopName);
        } else {
            if (troopUin == null) {
                return;
            }
            c().putString(b(troopUin), troopName);
        }
    }
}
