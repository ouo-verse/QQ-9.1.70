package com.tencent.qqnt.ntrelation.constant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/ntrelation/constant/RelationObserverType;", "", "(Ljava/lang/String;I)V", "ONLY_ONCE", "CONTINUOUS", "contacts_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class RelationObserverType {
    private static final /* synthetic */ RelationObserverType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final RelationObserverType CONTINUOUS;
    public static final RelationObserverType ONLY_ONCE;

    private static final /* synthetic */ RelationObserverType[] $values() {
        return new RelationObserverType[]{ONLY_ONCE, CONTINUOUS};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37285);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ONLY_ONCE = new RelationObserverType("ONLY_ONCE", 0);
        CONTINUOUS = new RelationObserverType("CONTINUOUS", 1);
        $VALUES = $values();
    }

    RelationObserverType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static RelationObserverType valueOf(String str) {
        return (RelationObserverType) Enum.valueOf(RelationObserverType.class, str);
    }

    public static RelationObserverType[] values() {
        return (RelationObserverType[]) $VALUES.clone();
    }
}
