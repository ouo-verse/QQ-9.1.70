package com.tencent.mobileqq.register.prettyaccount;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/register/prettyaccount/PrettyAccountABTestExp;", "", "(Ljava/lang/String;I)V", "EXP_DEF", "EXP_1", "EXP_2", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class PrettyAccountABTestExp {
    private static final /* synthetic */ PrettyAccountABTestExp[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final PrettyAccountABTestExp EXP_1;
    public static final PrettyAccountABTestExp EXP_2;
    public static final PrettyAccountABTestExp EXP_DEF;

    private static final /* synthetic */ PrettyAccountABTestExp[] $values() {
        return new PrettyAccountABTestExp[]{EXP_DEF, EXP_1, EXP_2};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27156);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        EXP_DEF = new PrettyAccountABTestExp("EXP_DEF", 0);
        EXP_1 = new PrettyAccountABTestExp("EXP_1", 1);
        EXP_2 = new PrettyAccountABTestExp("EXP_2", 2);
        $VALUES = $values();
    }

    PrettyAccountABTestExp(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static PrettyAccountABTestExp valueOf(String str) {
        return (PrettyAccountABTestExp) Enum.valueOf(PrettyAccountABTestExp.class, str);
    }

    public static PrettyAccountABTestExp[] values() {
        return (PrettyAccountABTestExp[]) $VALUES.clone();
    }
}
