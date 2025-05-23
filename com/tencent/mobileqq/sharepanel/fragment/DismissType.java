package com.tencent.mobileqq.sharepanel.fragment;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/fragment/DismissType;", "", "(Ljava/lang/String;I)V", "CANCEL", "DISMISS", "FORCE_CANCEL", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class DismissType {
    private static final /* synthetic */ DismissType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final DismissType CANCEL;
    public static final DismissType DISMISS;
    public static final DismissType FORCE_CANCEL;

    private static final /* synthetic */ DismissType[] $values() {
        return new DismissType[]{CANCEL, DISMISS, FORCE_CANCEL};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35767);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        CANCEL = new DismissType("CANCEL", 0);
        DISMISS = new DismissType("DISMISS", 1);
        FORCE_CANCEL = new DismissType("FORCE_CANCEL", 2);
        $VALUES = $values();
    }

    DismissType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static DismissType valueOf(String str) {
        return (DismissType) Enum.valueOf(DismissType.class, str);
    }

    public static DismissType[] values() {
        return (DismissType[]) $VALUES.clone();
    }
}
