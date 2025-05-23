package com.tencent.mobileqq.qroute.route;

import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.tencent.mobileqq.qroute.route.Router2$requestWithReturn$1", f = "Router2.kt", i = {0, 1, 1, 1}, l = {170, 208}, m = "invokeSuspend", n = {"$this$runBlocking", "$this$runBlocking", "routeMetaData", "routeHandler"}, s = {"L$0", "L$0", "L$1", "L$2"})
/* loaded from: classes17.dex */
public final class Router2$requestWithReturn$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Navigator $navigator;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
    @DebugMetadata(c = "com.tencent.mobileqq.qroute.route.Router2$requestWithReturn$1$1", f = "Router2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.qroute.route.Router2$requestWithReturn$1$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        int label;
        private CoroutineScope p$;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) Router2$requestWithReturn$1.this, (Object) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
            }
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(completion);
            anonymousClass1.p$ = (CoroutineScope) obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
            }
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            List o16;
            T t16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Router2 router2 = Router2.f276492c;
                    List<String> pathSegments = Router2$requestWithReturn$1.this.$navigator.getUri().getPathSegments();
                    Intrinsics.checkExpressionValueIsNotNull(pathSegments, "navigator.uri.pathSegments");
                    o16 = router2.o(pathSegments);
                    k.b("handle PathInterceptors: " + o16);
                    Iterator<T> it = o16.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            t16 = it.next();
                            Pair pair = (Pair) t16;
                            if (Boxing.boxBoolean(((h) pair.getSecond()).a((String) pair.getFirst(), Router2$requestWithReturn$1.this.$navigator)).booleanValue()) {
                                break;
                            }
                        } else {
                            t16 = (T) null;
                            break;
                        }
                    }
                    if (t16 == null) {
                        return Unit.INSTANCE;
                    }
                    throw new QRouteException(1005, Router2$requestWithReturn$1.this.$navigator.getPath() + "\u8bf7\u6c42\u88ab\u62e6\u622a\u3002", new Throwable());
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Router2$requestWithReturn$1(Navigator navigator, Continuation continuation) {
        super(2, continuation);
        this.$navigator = navigator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) navigator, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
        }
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        Router2$requestWithReturn$1 router2$requestWithReturn$1 = new Router2$requestWithReturn$1(this.$navigator, completion);
        router2$requestWithReturn$1.p$ = (CoroutineScope) obj;
        return router2$requestWithReturn$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, obj);
        }
        return ((Router2$requestWithReturn$1) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = this.p$;
                Router2 router2 = Router2.f276492c;
                coroutineScope2 = Router2.coroutineScope;
                CoroutineContext coroutineContext = coroutineScope2.getCoroutineContext();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
                this.L$0 = coroutineScope;
                this.label = 1;
                if (BuildersKt.withContext(coroutineContext, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            RouteMetaData routeMetaData = n.c().get(this.$navigator.getPath());
            if (routeMetaData != null) {
                Intrinsics.checkExpressionValueIsNotNull(routeMetaData, "routes[navigator.path] ?\u2026\u8ba4\u662f\u5426\u6dfb\u52a0\u4e86\u8be5path\u7684RoutePage\u6ce8\u89e3\")");
                Function2<Navigator, String, Unit> beforeRouteCallback = this.$navigator.getBeforeRouteCallback();
                if (beforeRouteCallback != null) {
                    beforeRouteCallback.invoke(this.$navigator, routeMetaData.b());
                }
                routeMetaData.a();
                j<? extends Object> jVar = n.b().get(Boxing.boxInt(routeMetaData.c()));
                if (jVar != null) {
                    Intrinsics.checkExpressionValueIsNotNull(jVar, "routeTypeHandlers[routeM\u2026not found RouteHandler!\")");
                    Thread currentThread = Thread.currentThread();
                    Looper mainLooper = Looper.getMainLooper();
                    Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
                    if (true ^ Intrinsics.areEqual(currentThread, mainLooper.getThread())) {
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        Router2$requestWithReturn$1$invokeSuspend$$inlined$runOnUI$1 router2$requestWithReturn$1$invokeSuspend$$inlined$runOnUI$1 = new Router2$requestWithReturn$1$invokeSuspend$$inlined$runOnUI$1(null, this, jVar, routeMetaData);
                        this.L$0 = coroutineScope;
                        this.L$1 = routeMetaData;
                        this.L$2 = jVar;
                        this.label = 2;
                        Object withContext = BuildersKt.withContext(main, router2$requestWithReturn$1$invokeSuspend$$inlined$runOnUI$1, this);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return withContext;
                    }
                    return jVar.a(routeMetaData, this.$navigator);
                }
                throw new QRouteException(1003, "path: " + this.$navigator.getPath() + ", route type: " + routeMetaData.c() + " could not found RouteHandler!", null, 4, null);
            }
            throw new QRouteException(1002, "\u672a\u627e\u5230" + this.$navigator.getPath() + "\u8def\u5f84\u5bf9\u5e94\u7684\u7ec4\u4ef6\uff0c\u8bf7\u786e\u8ba4\u662f\u5426\u6dfb\u52a0\u4e86\u8be5path\u7684RoutePage\u6ce8\u89e3", null, 4, null);
        }
        return iPatchRedirector.redirect((short) 1, (Object) this, obj);
    }
}
