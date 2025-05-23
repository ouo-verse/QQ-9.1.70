package com.tencent.mobileqq.filebrowser;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0000\"\u001b\u0010\u0005\u001a\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"", "a", "Lkotlin/Lazy;", "b", "()Z", "canUseNewPlayerFromConfig", "qqfile-filebrowser-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class M4APlayerConfigKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f205929a;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19788);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(M4APlayerConfigKt$canUseNewPlayerFromConfig$2.INSTANCE);
            f205929a = lazy;
        } else {
            redirector.redirect((short) 1);
        }
    }

    public static final boolean a() {
        return b();
    }

    private static final boolean b() {
        return ((Boolean) f205929a.getValue()).booleanValue();
    }
}
