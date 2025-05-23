package com.tencent.mobileqq.qroute.route;

import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.tencent.mobileqq.qroute.route.Router2$request$1", f = "Router2.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {141, 208, 214, 220, 226}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "result", "$this$launch", "e", "it", "$this$launch", "e", "it", "$this$launch", "e", "it"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes17.dex */
public final class Router2$request$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Navigator $navigator;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Router2$request$1(Navigator navigator, Continuation continuation) {
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
        Router2$request$1 router2$request$1 = new Router2$request$1(this.$navigator, completion);
        router2$request$1.p$ = (CoroutineScope) obj;
        return router2$request$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
        return ((Router2$request$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [int, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r26 = this.label;
            try {
            } catch (QRouteException e16) {
                k.d("request route error: " + e16.getErrorCode(), e16);
                Function2<Navigator, QRouteException, Unit> routeFailedCallback = this.$navigator.getRouteFailedCallback();
                if (routeFailedCallback != null) {
                    Thread currentThread = Thread.currentThread();
                    Looper mainLooper = Looper.getMainLooper();
                    Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
                    if (true ^ Intrinsics.areEqual(currentThread, mainLooper.getThread())) {
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        Router2$request$1$invokeSuspend$$inlined$let$lambda$2 router2$request$1$invokeSuspend$$inlined$let$lambda$2 = new Router2$request$1$invokeSuspend$$inlined$let$lambda$2(null, routeFailedCallback, this, e16);
                        this.L$0 = r26;
                        this.L$1 = e16;
                        this.L$2 = routeFailedCallback;
                        this.label = 4;
                        if (BuildersKt.withContext(main, router2$request$1$invokeSuspend$$inlined$let$lambda$2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        routeFailedCallback.invoke(this.$navigator, e16);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            } catch (InterruptedException e17) {
                k.d("request route error", e17);
                Function1<Navigator, Unit> routeTimeoutCallback = this.$navigator.getRouteTimeoutCallback();
                if (routeTimeoutCallback != null) {
                    Thread currentThread2 = Thread.currentThread();
                    Looper mainLooper2 = Looper.getMainLooper();
                    Intrinsics.checkExpressionValueIsNotNull(mainLooper2, "Looper.getMainLooper()");
                    if (true ^ Intrinsics.areEqual(currentThread2, mainLooper2.getThread())) {
                        MainCoroutineDispatcher main2 = Dispatchers.getMain();
                        Router2$request$1$invokeSuspend$$inlined$let$lambda$3 router2$request$1$invokeSuspend$$inlined$let$lambda$3 = new Router2$request$1$invokeSuspend$$inlined$let$lambda$3(null, routeTimeoutCallback, this);
                        this.L$0 = r26;
                        this.L$1 = e17;
                        this.L$2 = routeTimeoutCallback;
                        this.label = 5;
                        if (BuildersKt.withContext(main2, router2$request$1$invokeSuspend$$inlined$let$lambda$3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        routeTimeoutCallback.invoke(this.$navigator);
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            } catch (TimeoutCancellationException e18) {
                Function1<Navigator, Unit> routeTimeoutCallback2 = this.$navigator.getRouteTimeoutCallback();
                if (routeTimeoutCallback2 != null) {
                    Thread currentThread3 = Thread.currentThread();
                    Looper mainLooper3 = Looper.getMainLooper();
                    Intrinsics.checkExpressionValueIsNotNull(mainLooper3, "Looper.getMainLooper()");
                    if (true ^ Intrinsics.areEqual(currentThread3, mainLooper3.getThread())) {
                        MainCoroutineDispatcher main3 = Dispatchers.getMain();
                        Router2$request$1$invokeSuspend$$inlined$let$lambda$1 router2$request$1$invokeSuspend$$inlined$let$lambda$1 = new Router2$request$1$invokeSuspend$$inlined$let$lambda$1(null, routeTimeoutCallback2, this);
                        this.L$0 = r26;
                        this.L$1 = e18;
                        this.L$2 = routeTimeoutCallback2;
                        this.label = 3;
                        if (BuildersKt.withContext(main3, router2$request$1$invokeSuspend$$inlined$let$lambda$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        routeTimeoutCallback2.invoke(this.$navigator);
                        Unit unit3 = Unit.INSTANCE;
                    }
                }
            }
            if (r26 != 0) {
                if (r26 != 1) {
                    if (r26 != 2) {
                        if (r26 != 3) {
                            if (r26 != 4) {
                                if (r26 == 5) {
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }
                        }
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = this.p$;
                if (this.$navigator.getTimeout() > 0) {
                    long timeout = this.$navigator.getTimeout();
                    Router2$request$1$result$1 router2$request$1$result$1 = new Router2$request$1$result$1(this, null);
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = TimeoutKt.withTimeout(timeout, router2$request$1$result$1, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    obj = Router2.f276492c.m(this.$navigator);
                }
            }
            Thread currentThread4 = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(Looper.getMainLooper(), "Looper.getMainLooper()");
            if (!Intrinsics.areEqual(currentThread4, r10.getThread())) {
                MainCoroutineDispatcher main4 = Dispatchers.getMain();
                Router2$request$1$invokeSuspend$$inlined$runOnUI$1 router2$request$1$invokeSuspend$$inlined$runOnUI$1 = new Router2$request$1$invokeSuspend$$inlined$runOnUI$1(null, this, obj);
                this.L$0 = coroutineScope;
                this.L$1 = obj;
                this.label = 2;
                if (BuildersKt.withContext(main4, router2$request$1$invokeSuspend$$inlined$runOnUI$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                com.tencent.mobileqq.qroute.utils.d.a(this.$navigator.getRouteSuccessCallback(), obj);
                Unit unit4 = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 1, (Object) this, obj);
    }
}
