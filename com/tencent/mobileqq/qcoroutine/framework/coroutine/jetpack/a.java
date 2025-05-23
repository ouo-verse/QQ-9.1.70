package com.tencent.mobileqq.qcoroutine.framework.coroutine.jetpack;

import com.tencent.mobileqq.qcoroutine.api.f;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qcoroutine.framework.coroutine.c;
import com.tencent.mobileqq.qcoroutine.framework.e;
import com.tencent.mobileqq.qcoroutine.souce.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J1\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ)\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/jetpack/a;", "", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "b", "Lcom/tencent/mobileqq/qcoroutine/framework/a;", "coroutineTaskPoolType", "", "name", "isMain", "Lkotlin/coroutines/CoroutineContext;", "c", "(Lcom/tencent/mobileqq/qcoroutine/framework/a;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/coroutines/CoroutineScope;)Lkotlin/coroutines/CoroutineContext;", "d", "(Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/coroutines/CoroutineScope;)Lkotlin/coroutines/CoroutineContext;", "Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/c;", "a", "Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/c;", "()Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/c;", "coroutRunablePools", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final c coroutRunablePools;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CoroutineDispatcher dispatcher;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f261830c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11722);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f261830c = new a();
        f fVar = f.f261769e;
        coroutRunablePools = new c(fVar);
        dispatcher = d.a(Dispatchers.getIO(), fVar.a());
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @NotNull
    public final c a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (c) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return coroutRunablePools;
    }

    public final boolean b(@NotNull CoroutineScope scope) {
        i iVar;
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) scope)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        com.tencent.mobileqq.qcoroutine.framework.a aVar = (com.tencent.mobileqq.qcoroutine.framework.a) scope.getCoroutineContext().get(com.tencent.mobileqq.qcoroutine.framework.a.INSTANCE);
        if (aVar != null) {
            iVar = aVar.j();
        } else {
            iVar = null;
        }
        if (iVar != null && Intrinsics.areEqual(iVar, f.f261769e)) {
            return true;
        }
        if (iVar == null) {
            String name = scope.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "scope.javaClass.name");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, "androidx.", false, 2, null);
            if (startsWith$default) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final CoroutineContext c(@Nullable com.tencent.mobileqq.qcoroutine.framework.a coroutineTaskPoolType, @NotNull String name, @Nullable Boolean isMain, @NotNull CoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CoroutineContext) iPatchRedirector.redirect((short) 4, this, coroutineTaskPoolType, name, isMain, scope);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (coroutineTaskPoolType == null) {
            coroutineTaskPoolType = new com.tencent.mobileqq.qcoroutine.framework.a(f.f261769e);
        }
        return coroutineTaskPoolType.plus(d(name, isMain, scope));
    }

    @NotNull
    public final CoroutineContext d(@NotNull String name, @Nullable Boolean isMain, @Nullable CoroutineScope scope) {
        CoroutineName c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CoroutineContext) iPatchRedirector.redirect((short) 5, this, name, isMain, scope);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
        if (scope != null) {
            c16 = e.a(name, scope);
        } else {
            c16 = e.c(name);
        }
        if (c16 != null) {
            coroutineContext = coroutineContext.plus(c16);
        }
        if (isMain != null) {
            CoroutineContext coroutineContext2 = dispatcher;
            if (isMain.booleanValue()) {
                coroutineContext2 = Dispatchers.getMain().getImmediate();
            }
            return coroutineContext.plus(coroutineContext2);
        }
        return coroutineContext;
    }
}
