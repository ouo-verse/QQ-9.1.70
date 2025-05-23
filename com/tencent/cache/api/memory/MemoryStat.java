package com.tencent.cache.api.memory;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/cache/api/memory/MemoryStat;", "", "statName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStatName", "()Ljava/lang/String;", "Swap", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class MemoryStat {
    private static final /* synthetic */ MemoryStat[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MemoryStat Swap;

    @NotNull
    private final String statName;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13150);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        MemoryStat memoryStat = new MemoryStat("Swap", 0, "summary.total-swap");
        Swap = memoryStat;
        $VALUES = new MemoryStat[]{memoryStat};
    }

    MemoryStat(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
        } else {
            this.statName = str2;
        }
    }

    public static MemoryStat valueOf(String str) {
        return (MemoryStat) Enum.valueOf(MemoryStat.class, str);
    }

    public static MemoryStat[] values() {
        return (MemoryStat[]) $VALUES.clone();
    }

    @NotNull
    public final String getStatName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.statName;
    }
}
