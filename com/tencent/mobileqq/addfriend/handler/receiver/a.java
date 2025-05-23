package com.tencent.mobileqq.addfriend.handler.receiver;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0004H&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/addfriend/handler/receiver/a;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "T", "", "", "cmd", "", "a", "b", "Lcom/tencent/qqnt/remote/d;", "toNTMsg", "Lcom/tencent/qqnt/remote/b;", "fromNTMsg", "", "d", "Lcom/tencent/common/app/AppInterface;", "Lcom/tencent/common/app/AppInterface;", "getAppRuntime", "()Lcom/tencent/common/app/AppInterface;", "appRuntime", "Lcom/tencent/mobileqq/app/BusinessHandler;", "c", "()Lcom/tencent/mobileqq/app/BusinessHandler;", "handler", "<init>", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/app/BusinessHandler;)V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class a<T extends BusinessHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface appRuntime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final T handler;

    public a(@NotNull AppInterface appRuntime, @NotNull T handler) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(handler, "handler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) handler);
        } else {
            this.appRuntime = appRuntime;
            this.handler = handler;
        }
    }

    public final boolean a(@NotNull String cmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cmd)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        return Intrinsics.areEqual(b(), cmd);
    }

    @NotNull
    public abstract String b();

    @NotNull
    public final T c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.handler;
    }

    public abstract void d(@NotNull com.tencent.qqnt.remote.d toNTMsg, @NotNull com.tencent.qqnt.remote.b fromNTMsg);
}
