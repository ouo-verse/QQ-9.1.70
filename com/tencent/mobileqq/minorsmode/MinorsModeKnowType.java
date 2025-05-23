package com.tencent.mobileqq.minorsmode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minorsmode/MinorsModeKnowType;", "", "(Ljava/lang/String;I)V", "INVALID", "OPEN_BY_SYSTEM", "OPEN_BY_SYSTEM_FROM_ELDER", "CLOSE_BY_SYSTEM", "CLOSE_BY_SYSTEM_TO_ELDER", "CLOSE_ALONE", "CLOSE_ALONE_TO_ELDER", "CHECK_CLOSE_BY_SYSTEM", "ONLY_CHANGE_AGE", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class MinorsModeKnowType {
    private static final /* synthetic */ MinorsModeKnowType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MinorsModeKnowType CHECK_CLOSE_BY_SYSTEM;
    public static final MinorsModeKnowType CLOSE_ALONE;
    public static final MinorsModeKnowType CLOSE_ALONE_TO_ELDER;
    public static final MinorsModeKnowType CLOSE_BY_SYSTEM;
    public static final MinorsModeKnowType CLOSE_BY_SYSTEM_TO_ELDER;
    public static final MinorsModeKnowType INVALID;
    public static final MinorsModeKnowType ONLY_CHANGE_AGE;
    public static final MinorsModeKnowType OPEN_BY_SYSTEM;
    public static final MinorsModeKnowType OPEN_BY_SYSTEM_FROM_ELDER;

    private static final /* synthetic */ MinorsModeKnowType[] $values() {
        return new MinorsModeKnowType[]{INVALID, OPEN_BY_SYSTEM, OPEN_BY_SYSTEM_FROM_ELDER, CLOSE_BY_SYSTEM, CLOSE_BY_SYSTEM_TO_ELDER, CLOSE_ALONE, CLOSE_ALONE_TO_ELDER, CHECK_CLOSE_BY_SYSTEM, ONLY_CHANGE_AGE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25188);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INVALID = new MinorsModeKnowType("INVALID", 0);
        OPEN_BY_SYSTEM = new MinorsModeKnowType("OPEN_BY_SYSTEM", 1);
        OPEN_BY_SYSTEM_FROM_ELDER = new MinorsModeKnowType("OPEN_BY_SYSTEM_FROM_ELDER", 2);
        CLOSE_BY_SYSTEM = new MinorsModeKnowType("CLOSE_BY_SYSTEM", 3);
        CLOSE_BY_SYSTEM_TO_ELDER = new MinorsModeKnowType("CLOSE_BY_SYSTEM_TO_ELDER", 4);
        CLOSE_ALONE = new MinorsModeKnowType("CLOSE_ALONE", 5);
        CLOSE_ALONE_TO_ELDER = new MinorsModeKnowType("CLOSE_ALONE_TO_ELDER", 6);
        CHECK_CLOSE_BY_SYSTEM = new MinorsModeKnowType("CHECK_CLOSE_BY_SYSTEM", 7);
        ONLY_CHANGE_AGE = new MinorsModeKnowType("ONLY_CHANGE_AGE", 8);
        $VALUES = $values();
    }

    MinorsModeKnowType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MinorsModeKnowType valueOf(String str) {
        return (MinorsModeKnowType) Enum.valueOf(MinorsModeKnowType.class, str);
    }

    public static MinorsModeKnowType[] values() {
        return (MinorsModeKnowType[]) $VALUES.clone();
    }
}
