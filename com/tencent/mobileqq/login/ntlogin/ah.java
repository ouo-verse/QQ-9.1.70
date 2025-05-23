package com.tencent.mobileqq.login.ntlogin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/ah;", "", "", "account", "value", "", "b", "a", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "incorrectCookieMap", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ah {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ah f242228a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, String> incorrectCookieMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21344);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f242228a = new ah();
            incorrectCookieMap = new ConcurrentHashMap<>();
        }
    }

    ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final String a(@NotNull String account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) account);
        }
        Intrinsics.checkNotNullParameter(account, "account");
        return incorrectCookieMap.get(account);
    }

    public final void b(@NotNull String account, @NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) account, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(value, "value");
        incorrectCookieMap.put(account, value);
    }

    public final void c(@NotNull String account) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) account);
        } else {
            Intrinsics.checkNotNullParameter(account, "account");
            incorrectCookieMap.remove(account);
        }
    }
}
