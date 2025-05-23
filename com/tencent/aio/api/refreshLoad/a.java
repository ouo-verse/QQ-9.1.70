package com.tencent.aio.api.refreshLoad;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.PreLoadRefreshImpl;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.RefreshType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\u0007\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\b\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\u0003J\u0014\u0010\n\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\"\u0010\u0012\u001a\u00020\f8\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/aio/api/refreshLoad/a;", "", "Lkotlin/Function0;", "", "action", "a", "function", "c", "e", "d", "b", "f", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/PreLoadRefreshImpl;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/PreLoadRefreshImpl;", "getPreLoadDispatcher$sdk_debug", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/PreLoadRefreshImpl;", "g", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/PreLoadRefreshImpl;)V", "preLoadDispatcher", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public PreLoadRefreshImpl preLoadDispatcher;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public final void a(@NotNull Function0<Unit> action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        PreLoadRefreshImpl preLoadRefreshImpl = this.preLoadDispatcher;
        if (preLoadRefreshImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preLoadDispatcher");
        }
        preLoadRefreshImpl.r(action);
    }

    public final void b(@NotNull Function0<Unit> action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        PreLoadRefreshImpl preLoadRefreshImpl = this.preLoadDispatcher;
        if (preLoadRefreshImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preLoadDispatcher");
        }
        if (preLoadRefreshImpl.f0()) {
            action.invoke();
        }
    }

    public final void c(@NotNull Function0<Unit> function) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) function);
            return;
        }
        Intrinsics.checkNotNullParameter(function, "function");
        PreLoadRefreshImpl preLoadRefreshImpl = this.preLoadDispatcher;
        if (preLoadRefreshImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preLoadDispatcher");
        }
        preLoadRefreshImpl.s(function);
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        PreLoadRefreshImpl preLoadRefreshImpl = this.preLoadDispatcher;
        if (preLoadRefreshImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preLoadDispatcher");
        }
        preLoadRefreshImpl.u(RefreshType.PreLoadMore);
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        PreLoadRefreshImpl preLoadRefreshImpl = this.preLoadDispatcher;
        if (preLoadRefreshImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preLoadDispatcher");
        }
        preLoadRefreshImpl.v(RefreshType.PreRefresh);
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public final void g(@NotNull PreLoadRefreshImpl preLoadRefreshImpl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) preLoadRefreshImpl);
        } else {
            Intrinsics.checkNotNullParameter(preLoadRefreshImpl, "<set-?>");
            this.preLoadDispatcher = preLoadRefreshImpl;
        }
    }
}
