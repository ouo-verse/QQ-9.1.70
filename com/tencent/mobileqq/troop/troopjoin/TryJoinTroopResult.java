package com.tencent.mobileqq.troop.troopjoin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopjoin/TryJoinTroopResult;", "", "(Ljava/lang/String;I)V", "NOTHING", "SYS_ERROR", "PARAMS_ERROR", "HAS_JOINED", "HAS_LAUNCH", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TryJoinTroopResult {
    private static final /* synthetic */ TryJoinTroopResult[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TryJoinTroopResult HAS_JOINED;
    public static final TryJoinTroopResult HAS_LAUNCH;
    public static final TryJoinTroopResult NOTHING;
    public static final TryJoinTroopResult PARAMS_ERROR;
    public static final TryJoinTroopResult SYS_ERROR;

    private static final /* synthetic */ TryJoinTroopResult[] $values() {
        return new TryJoinTroopResult[]{NOTHING, SYS_ERROR, PARAMS_ERROR, HAS_JOINED, HAS_LAUNCH};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25265);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NOTHING = new TryJoinTroopResult("NOTHING", 0);
        SYS_ERROR = new TryJoinTroopResult("SYS_ERROR", 1);
        PARAMS_ERROR = new TryJoinTroopResult("PARAMS_ERROR", 2);
        HAS_JOINED = new TryJoinTroopResult("HAS_JOINED", 3);
        HAS_LAUNCH = new TryJoinTroopResult("HAS_LAUNCH", 4);
        $VALUES = $values();
    }

    TryJoinTroopResult(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TryJoinTroopResult valueOf(String str) {
        return (TryJoinTroopResult) Enum.valueOf(TryJoinTroopResult.class, str);
    }

    public static TryJoinTroopResult[] values() {
        return (TryJoinTroopResult[]) $VALUES.clone();
    }
}
