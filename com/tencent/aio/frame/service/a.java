package com.tencent.aio.frame.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ml3.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J$\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0001\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aio/frame/service/a;", "Lml3/b;", "T", "Ljava/lang/Class;", "clazz", "Lml3/a;", "a", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lml3/b;", "aioService", "Lcom/tencent/aio/frame/service/DrawerFrameBackEventDispatcher;", "Lcom/tencent/aio/frame/service/DrawerFrameBackEventDispatcher;", "backEventDispatcher", "<init>", "(Lml3/b;Lcom/tencent/aio/frame/service/DrawerFrameBackEventDispatcher;)V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b aioService;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final DrawerFrameBackEventDispatcher backEventDispatcher;

    public a(@NotNull b aioService, @NotNull DrawerFrameBackEventDispatcher backEventDispatcher) {
        Intrinsics.checkNotNullParameter(aioService, "aioService");
        Intrinsics.checkNotNullParameter(backEventDispatcher, "backEventDispatcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioService, (Object) backEventDispatcher);
        } else {
            this.aioService = aioService;
            this.backEventDispatcher = backEventDispatcher;
        }
    }

    @Override // ml3.b
    @NotNull
    public <T> ml3.a<T> a(@NotNull Class<T> clazz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ml3.a) iPatchRedirector.redirect((short) 1, (Object) this, (Object) clazz);
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (clazz.isAssignableFrom(com.tencent.aio.api.runtime.emitter.a.class)) {
            DrawerFrameBackEventDispatcher drawerFrameBackEventDispatcher = this.backEventDispatcher;
            if (drawerFrameBackEventDispatcher != null) {
                return drawerFrameBackEventDispatcher;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.mvi.api.business.IEmitterRegister<T>");
        }
        return this.aioService.a(clazz);
    }

    @Override // ml3.b
    public <T> T b(@NotNull Class<T> clazz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) clazz);
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.aioService.b(clazz);
    }
}
