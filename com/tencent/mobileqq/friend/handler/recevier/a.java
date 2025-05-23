package com.tencent.mobileqq.friend.handler.recevier;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0004H&J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H&R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/friend/handler/recevier/a;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "T", "", "", "cmd", "", "a", "c", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "data", "", "e", "Lcom/tencent/common/app/AppInterface;", "Lcom/tencent/common/app/AppInterface;", "b", "()Lcom/tencent/common/app/AppInterface;", "appRuntime", "Lcom/tencent/mobileqq/app/BusinessHandler;", "d", "()Lcom/tencent/mobileqq/app/BusinessHandler;", "handler", "<init>", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/app/BusinessHandler;)V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
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
        return Intrinsics.areEqual(c(), cmd);
    }

    @NotNull
    public final AppInterface b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppInterface) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appRuntime;
    }

    @NotNull
    public abstract String c();

    @NotNull
    public final T d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.handler;
    }

    public abstract void e(@NotNull ToServiceMsg req, @NotNull FromServiceMsg res, @Nullable Object data);
}
