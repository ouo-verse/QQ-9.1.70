package com.tencent.qqnt.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/report/TroopMemberCacheStrategy;", "", "version", "", "(Ljava/lang/String;II)V", "getVersion", "()I", "DEFAULT", "USE_MEMBER_LIST", "AVERAGE", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class TroopMemberCacheStrategy {
    private static final /* synthetic */ TroopMemberCacheStrategy[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TroopMemberCacheStrategy AVERAGE;
    public static final TroopMemberCacheStrategy DEFAULT;
    public static final TroopMemberCacheStrategy USE_MEMBER_LIST;
    private final int version;

    private static final /* synthetic */ TroopMemberCacheStrategy[] $values() {
        return new TroopMemberCacheStrategy[]{DEFAULT, USE_MEMBER_LIST, AVERAGE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62756);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        DEFAULT = new TroopMemberCacheStrategy("DEFAULT", 0, 0);
        USE_MEMBER_LIST = new TroopMemberCacheStrategy("USE_MEMBER_LIST", 1, 1);
        AVERAGE = new TroopMemberCacheStrategy("AVERAGE", 2, 2);
        $VALUES = $values();
    }

    TroopMemberCacheStrategy(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.version = i16;
        }
    }

    public static TroopMemberCacheStrategy valueOf(String str) {
        return (TroopMemberCacheStrategy) Enum.valueOf(TroopMemberCacheStrategy.class, str);
    }

    public static TroopMemberCacheStrategy[] values() {
        return (TroopMemberCacheStrategy[]) $VALUES.clone();
    }

    public final int getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.version;
    }
}
