package com.tencent.aio.runtime;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0001\u00a2\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u001b\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J#\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000eH\u0096\u0001J\u001b\u0010\u0010\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u000eH\u0096\u0001J#\u0010\u0011\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u001b\u0010\u0019\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001R\u0017\u0010\u001e\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/aio/runtime/b;", "Lcom/tencent/mvi/base/route/j;", "Lcom/tencent/mvi/base/route/g;", "subscribe", "Lcom/tencent/mvi/base/route/a;", "action", "", "f", "", QQBrowserActivity.KEY_MSG_TYPE, "d", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "c", "Lcom/tencent/mvi/base/route/b;", "l", "j", "g", "Lcom/tencent/mvi/base/route/MsgIntent;", "message", h.F, "Lcom/tencent/mvi/base/route/k;", "k", "i", "e", "b", "a", "Lcom/tencent/mvi/base/route/j;", "getMessenger", "()Lcom/tencent/mvi/base/route/j;", "messenger", "<init>", "(Lcom/tencent/mvi/base/route/j;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b implements j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j messenger;

    public b(@NotNull j messenger) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) messenger);
        } else {
            this.messenger = messenger;
        }
    }

    @Override // com.tencent.mvi.base.route.e
    public void a(@Nullable String msgType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) msgType);
        } else {
            this.messenger.a(msgType);
        }
    }

    @Override // com.tencent.mvi.base.route.d
    public void b(@Nullable String msgType, @NotNull com.tencent.mvi.base.route.a action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) msgType, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            this.messenger.b(msgType, action);
        }
    }

    @Override // com.tencent.mvi.base.route.d
    public void c(@Nullable String msgType, @NotNull com.tencent.mvi.base.route.a action, @NotNull LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, msgType, action, lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.messenger.c(msgType, action, lifecycleOwner);
    }

    @Override // com.tencent.mvi.base.route.d
    public void d(@Nullable String msgType, @NotNull com.tencent.mvi.base.route.a action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgType, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            this.messenger.d(msgType, action);
        }
    }

    @Override // com.tencent.mvi.base.route.e
    public void e(@NotNull g subscribe) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) subscribe);
        } else {
            Intrinsics.checkNotNullParameter(subscribe, "subscribe");
            this.messenger.e(subscribe);
        }
    }

    @Override // com.tencent.mvi.base.route.d
    public void f(@NotNull g subscribe, @NotNull com.tencent.mvi.base.route.a action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) subscribe, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(subscribe, "subscribe");
        Intrinsics.checkNotNullParameter(action, "action");
        this.messenger.f(subscribe, action);
    }

    @Override // com.tencent.mvi.base.route.e
    public void g(@Nullable String msgType, @NotNull com.tencent.mvi.base.route.b action, @NotNull LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, msgType, action, lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.messenger.g(msgType, action, lifecycleOwner);
    }

    @Override // com.tencent.mvi.base.route.d
    public void h(@NotNull MsgIntent message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) message);
        } else {
            Intrinsics.checkNotNullParameter(message, "message");
            this.messenger.h(message);
        }
    }

    @Override // com.tencent.mvi.base.route.d
    public void i(@NotNull g subscribe, @NotNull com.tencent.mvi.base.route.a action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) subscribe, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(subscribe, "subscribe");
        Intrinsics.checkNotNullParameter(action, "action");
        this.messenger.i(subscribe, action);
    }

    @Override // com.tencent.mvi.base.route.e
    public void j(@Nullable String msgType, @NotNull com.tencent.mvi.base.route.b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) msgType, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            this.messenger.j(msgType, action);
        }
    }

    @Override // com.tencent.mvi.base.route.e
    @Nullable
    public k k(@NotNull MsgIntent message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (k) iPatchRedirector.redirect((short) 12, (Object) this, (Object) message);
        }
        Intrinsics.checkNotNullParameter(message, "message");
        return this.messenger.k(message);
    }

    @Override // com.tencent.mvi.base.route.e
    public void l(@NotNull g subscribe, @NotNull com.tencent.mvi.base.route.b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) subscribe, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(subscribe, "subscribe");
        Intrinsics.checkNotNullParameter(action, "action");
        this.messenger.l(subscribe, action);
    }
}
