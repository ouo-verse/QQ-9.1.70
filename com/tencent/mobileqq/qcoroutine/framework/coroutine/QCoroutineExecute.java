package com.tencent.mobileqq.qcoroutine.framework.coroutine;

import com.tencent.mobileqq.qcoroutine.api.f;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qcoroutine.framework.QTaskPool;
import com.tencent.mobileqq.qcoroutine.framework.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/QCoroutineExecute;", "", "a", "Companion", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class QCoroutineExecute {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ]\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011Ji\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J[\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J^\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u00a2\u0006\u0002\b\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/QCoroutineExecute$Companion;", "", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "name", "", "isMain", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "b", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "T", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/a;", "a", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lcom/tencent/mobileqq/qcoroutine/api/coroutine/a;", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "type", "c", "(Lcom/tencent/mobileqq/qcoroutine/api/i;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "d", "(Lcom/tencent/mobileqq/qcoroutine/api/i;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Nullable
        public final <T> com.tencent.mobileqq.qcoroutine.api.coroutine.a<T> a(@NotNull CoroutineScope scope, @NotNull String name, @Nullable Boolean isMain, @NotNull CoroutineStart start, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
            QTaskPool e16;
            String str;
            String name2;
            String str2;
            String name3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.qcoroutine.api.coroutine.a) iPatchRedirector.redirect((short) 2, this, scope, name, isMain, start, block);
            }
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(start, "start");
            Intrinsics.checkNotNullParameter(block, "block");
            com.tencent.mobileqq.qcoroutine.framework.a aVar = (com.tencent.mobileqq.qcoroutine.framework.a) scope.getCoroutineContext().get(com.tencent.mobileqq.qcoroutine.framework.a.INSTANCE);
            com.tencent.mobileqq.qcoroutine.framework.coroutine.jetpack.a aVar2 = com.tencent.mobileqq.qcoroutine.framework.coroutine.jetpack.a.f261830c;
            if (aVar2.b(scope)) {
                CoroutineContext c16 = aVar2.c(aVar, name, isMain, scope);
                CoroutineName coroutineName = (CoroutineName) c16.get(CoroutineName.INSTANCE);
                if (coroutineName != null && (name3 = coroutineName.getName()) != null) {
                    str2 = name3;
                } else {
                    str2 = name;
                }
                a aVar3 = new a(str2, f.f261769e, RunnableType.ASYNC, null, 8, null);
                com.tencent.mobileqq.qcoroutine.api.coroutine.a<T> a16 = aVar2.a().a(aVar3);
                a16.j(BuildersKt.async(scope, c16, start, new QCoroutineExecute$Companion$qAsyncExecute$1(aVar3, block, null)));
                return a16;
            }
            if (aVar == null || (e16 = d.f261833c.e(aVar.j())) == null) {
                return null;
            }
            CoroutineContext n3 = e16.n(name, isMain, scope);
            CoroutineName coroutineName2 = (CoroutineName) n3.get(CoroutineName.INSTANCE);
            if (coroutineName2 != null && (name2 = coroutineName2.getName()) != null) {
                str = name2;
            } else {
                str = name;
            }
            a aVar4 = new a(str, e16.l(), RunnableType.ASYNC, null, 8, null);
            com.tencent.mobileqq.qcoroutine.api.coroutine.a<T> a17 = e16.f().a(aVar4);
            a17.j(BuildersKt.async(scope, e16.e().plus(n3), start, new QCoroutineExecute$Companion$qAsyncExecute$$inlined$let$lambda$1(aVar4, null, name, isMain, scope, start, block)));
            return a17;
        }

        @Nullable
        public final com.tencent.mobileqq.qcoroutine.api.coroutine.b b(@NotNull CoroutineScope scope, @NotNull String name, @Nullable Boolean isMain, @NotNull CoroutineStart start, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
            QTaskPool e16;
            String str;
            String name2;
            String str2;
            String name3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.mobileqq.qcoroutine.api.coroutine.b) iPatchRedirector.redirect((short) 1, this, scope, name, isMain, start, block);
            }
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(start, "start");
            Intrinsics.checkNotNullParameter(block, "block");
            com.tencent.mobileqq.qcoroutine.framework.a aVar = (com.tencent.mobileqq.qcoroutine.framework.a) scope.getCoroutineContext().get(com.tencent.mobileqq.qcoroutine.framework.a.INSTANCE);
            com.tencent.mobileqq.qcoroutine.framework.coroutine.jetpack.a aVar2 = com.tencent.mobileqq.qcoroutine.framework.coroutine.jetpack.a.f261830c;
            if (aVar2.b(scope)) {
                CoroutineContext c16 = aVar2.c(aVar, name, isMain, scope);
                CoroutineName coroutineName = (CoroutineName) c16.get(CoroutineName.INSTANCE);
                if (coroutineName != null && (name3 = coroutineName.getName()) != null) {
                    str2 = name3;
                } else {
                    str2 = name;
                }
                a aVar3 = new a(str2, f.f261769e, RunnableType.LAUNCH, null, 8, null);
                com.tencent.mobileqq.qcoroutine.api.coroutine.b b16 = aVar2.a().b(aVar3);
                b16.j(BuildersKt.launch(scope, c16, start, new QCoroutineExecute$Companion$qLaunchExecute$1(aVar3, block, null)));
                return b16;
            }
            if (aVar == null || (e16 = d.f261833c.e(aVar.j())) == null) {
                return null;
            }
            CoroutineContext n3 = e16.n(name, isMain, scope);
            CoroutineName coroutineName2 = (CoroutineName) n3.get(CoroutineName.INSTANCE);
            if (coroutineName2 != null && (name2 = coroutineName2.getName()) != null) {
                str = name2;
            } else {
                str = name;
            }
            a aVar4 = new a(str, e16.l(), RunnableType.LAUNCH, null, 8, null);
            com.tencent.mobileqq.qcoroutine.api.coroutine.b b17 = e16.f().b(aVar4);
            b17.j(BuildersKt.launch(scope, e16.e().plus(n3), start, new QCoroutineExecute$Companion$qLaunchExecute$$inlined$let$lambda$1(aVar4, null, name, isMain, scope, start, block)));
            return b17;
        }

        @Nullable
        public final <T> T c(@NotNull i type, @NotNull String name, @Nullable Boolean isMain, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (T) iPatchRedirector.redirect((short) 3, this, type, name, isMain, block);
            }
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(block, "block");
            if (Intrinsics.areEqual(type, f.f261769e)) {
                com.tencent.mobileqq.qcoroutine.framework.coroutine.jetpack.a aVar = com.tencent.mobileqq.qcoroutine.framework.coroutine.jetpack.a.f261830c;
                CoroutineContext d16 = aVar.d(name, isMain, null);
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = (T) new a(name, type, RunnableType.ASYNC, null, 8, null);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = (T) aVar.a().a((a) objectRef.element);
                return (T) BuildersKt.runBlocking(d16, new QCoroutineExecute$Companion$qRunBlockingExecute$1(name, objectRef, objectRef2, block, null));
            }
            QTaskPool e16 = d.f261833c.e(type);
            if (e16 == null) {
                return null;
            }
            CoroutineContext n3 = e16.n(name, isMain, null);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = (T) new a(name, type, RunnableType.ASYNC, null, 8, null);
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            objectRef4.element = (T) e16.f().a((a) objectRef3.element);
            return (T) BuildersKt.runBlocking(e16.e().plus(n3), new QCoroutineExecute$Companion$qRunBlockingExecute$$inlined$let$lambda$1(objectRef3, objectRef4, null, name, isMain, type, block));
        }

        @Nullable
        public final <T> Object d(@NotNull i iVar, @NotNull String str, @Nullable Boolean bool, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, this, iVar, str, bool, function2, continuation);
            }
            if (Intrinsics.areEqual(iVar, f.f261769e)) {
                com.tencent.mobileqq.qcoroutine.framework.coroutine.jetpack.a aVar = com.tencent.mobileqq.qcoroutine.framework.coroutine.jetpack.a.f261830c;
                CoroutineContext d16 = aVar.d(str, bool, null);
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = (T) new a(str, iVar, RunnableType.ASYNC, null, 8, null);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = (T) aVar.a().a((a) objectRef.element);
                return BuildersKt.withContext(d16, new QCoroutineExecute$Companion$qWithContextExecute$2(str, objectRef, objectRef2, function2, null), continuation);
            }
            QTaskPool e16 = d.f261833c.e(iVar);
            if (e16 == null) {
                return null;
            }
            CoroutineContext n3 = e16.n(str, bool, null);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = (T) new a(str, iVar, RunnableType.ASYNC, null, 8, null);
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            objectRef4.element = (T) e16.f().a((a) objectRef3.element);
            return BuildersKt.withContext(e16.e().plus(n3), new QCoroutineExecute$Companion$qWithContextExecute$$inlined$let$lambda$1(objectRef3, objectRef4, null, str, bool, iVar, continuation, function2), continuation);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11704);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
