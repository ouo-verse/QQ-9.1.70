package com.tencent.mobileqq.flock.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/flock/api/JoinFlockAndTroopResult;", "", "(Ljava/lang/String;I)V", "SUCCESS", "SYS_ERROR", "PARAMS_ERROR", "qq-flock-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class JoinFlockAndTroopResult {
    private static final /* synthetic */ JoinFlockAndTroopResult[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final JoinFlockAndTroopResult PARAMS_ERROR;
    public static final JoinFlockAndTroopResult SUCCESS;
    public static final JoinFlockAndTroopResult SYS_ERROR;

    private static final /* synthetic */ JoinFlockAndTroopResult[] $values() {
        return new JoinFlockAndTroopResult[]{SUCCESS, SYS_ERROR, PARAMS_ERROR};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34246);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SUCCESS = new JoinFlockAndTroopResult("SUCCESS", 0);
        SYS_ERROR = new JoinFlockAndTroopResult("SYS_ERROR", 1);
        PARAMS_ERROR = new JoinFlockAndTroopResult("PARAMS_ERROR", 2);
        $VALUES = $values();
    }

    JoinFlockAndTroopResult(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static JoinFlockAndTroopResult valueOf(String str) {
        return (JoinFlockAndTroopResult) Enum.valueOf(JoinFlockAndTroopResult.class, str);
    }

    public static JoinFlockAndTroopResult[] values() {
        return (JoinFlockAndTroopResult[]) $VALUES.clone();
    }
}
