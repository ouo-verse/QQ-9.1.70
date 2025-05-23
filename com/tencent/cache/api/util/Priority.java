package com.tencent.cache.api.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0000H\u0086\u0002J\t\u0010\u0004\u001a\u00020\u0000H\u0086\u0002j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/cache/api/util/Priority;", "", "(Ljava/lang/String;I)V", "dec", "inc", "Low", "Normal", "High", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class Priority {
    private static final /* synthetic */ Priority[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final Priority High;
    public static final Priority Low;
    public static final Priority Normal;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13504);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        Priority priority = new Priority("Low", 0);
        Low = priority;
        Priority priority2 = new Priority("Normal", 1);
        Normal = priority2;
        Priority priority3 = new Priority("High", 2);
        High = priority3;
        $VALUES = new Priority[]{priority, priority2, priority3};
    }

    Priority(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    public static Priority valueOf(String str) {
        return (Priority) Enum.valueOf(Priority.class, str);
    }

    public static Priority[] values() {
        return (Priority[]) $VALUES.clone();
    }

    @NotNull
    public final Priority dec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Priority) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        int i3 = a.f98638b[ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3) {
                return Normal;
            }
            throw new NoWhenBranchMatchedException();
        }
        return Low;
    }

    @NotNull
    public final Priority inc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Priority) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        int i3 = a.f98637a[ordinal()];
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return High;
        }
        return Normal;
    }
}
