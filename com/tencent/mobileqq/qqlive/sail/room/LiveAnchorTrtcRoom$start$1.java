package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.error.a;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.room.LiveAnchorTrtcRoom$start$1", f = "LiveAnchorTrtcRoom.kt", i = {}, l = {67, 269}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class LiveAnchorTrtcRoom$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function1<l<Boolean>, Unit> $callback;
    final /* synthetic */ boolean $enablePushStream;
    Object L$0;
    int label;
    final /* synthetic */ LiveAnchorTrtcRoom this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAnchorTrtcRoom$start$1(LiveAnchorTrtcRoom liveAnchorTrtcRoom, Function1<? super l<Boolean>, Unit> function1, boolean z16, Continuation<? super LiveAnchorTrtcRoom$start$1> continuation) {
        super(2, continuation);
        this.this$0 = liveAnchorTrtcRoom;
        this.$callback = function1;
        this.$enablePushStream = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, liveAnchorTrtcRoom, function1, Boolean.valueOf(z16), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LiveAnchorTrtcRoom$start$1(this.this$0, this.$callback, this.$enablePushStream, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0117  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        RoomTrtcProxyImpl roomTrtcProxyImpl;
        CoroutineContext coroutineContext;
        RoomTrtcProxyImpl roomTrtcProxyImpl2;
        boolean z16;
        Continuation intercepted;
        Object result;
        Object coroutine_suspended2;
        RoomTrtcProxyImpl roomTrtcProxyImpl3;
        l<Boolean> lVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        Object obj2 = obj;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    result = obj2;
                    lVar = (l) result;
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    companion.i(this.this$0.N(), "start", "pushedStreamResult=" + lVar);
                    if (lVar.b() != 0) {
                        companion.w(this.this$0.N(), "start", "push stream failed, " + lVar);
                        this.this$0.M().a(20);
                        this.$callback.invoke(lVar);
                        return Unit.INSTANCE;
                    }
                    this.this$0.M().a(40);
                    this.$callback.invoke(new l<>(Boxing.boxBoolean(true), 0L, null, 0, 12, null));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
            companion2.i(this.this$0.N(), "start");
            if (!this.this$0.M().b(30)) {
                companion2.w(this.this$0.N(), "start", "cannot change to starting state, " + this.this$0.M());
                this.$callback.invoke(a.Companion.c(com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE, -10000003L, Boxing.boxBoolean(false), null, 4, null));
                return Unit.INSTANCE;
            }
            this.this$0.M().a(30);
            roomTrtcProxyImpl = this.this$0.trtcProxy;
            if (!roomTrtcProxyImpl.m()) {
                coroutineContext = this.this$0.initTrtcCoroutineContext;
                LiveAnchorTrtcRoom$start$1$result$1 liveAnchorTrtcRoom$start$1$result$1 = new LiveAnchorTrtcRoom$start$1$result$1(this.this$0, null);
                this.label = 1;
                obj2 = BuildersKt.withContext(coroutineContext, liveAnchorTrtcRoom$start$1$result$1, this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            roomTrtcProxyImpl2 = this.this$0.trtcProxy;
            roomTrtcProxyImpl2.q(this.this$0.L().n());
            z16 = this.this$0.isStreamPushed;
            if (!z16) {
                roomTrtcProxyImpl3 = this.this$0.trtcProxy;
                roomTrtcProxyImpl3.p(true);
            } else if (this.$enablePushStream) {
                LiveAnchorTrtcRoom liveAnchorTrtcRoom = this.this$0;
                this.L$0 = liveAnchorTrtcRoom;
                this.label = 2;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                cancellableContinuationImpl.initCancellability();
                liveAnchorTrtcRoom.f(new Function1<l<Boolean>, Unit>(cancellableContinuationImpl) { // from class: com.tencent.mobileqq.qqlive.sail.room.LiveAnchorTrtcRoom$start$1$pushedStreamResult$1$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ CancellableContinuation<l<Boolean>> $cont;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                        this.$cont = cancellableContinuationImpl;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(l<Boolean> lVar2) {
                        invoke2(lVar2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull l<Boolean> result2) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) result2);
                        } else {
                            Intrinsics.checkNotNullParameter(result2, "result");
                            this.$cont.resumeWith(Result.m476constructorimpl(result2));
                        }
                    }
                });
                result = cancellableContinuationImpl.getResult();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (result == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(this);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                lVar = (l) result;
                AegisLogger.Companion companion3 = AegisLogger.INSTANCE;
                companion3.i(this.this$0.N(), "start", "pushedStreamResult=" + lVar);
                if (lVar.b() != 0) {
                }
            }
            this.this$0.M().a(40);
            this.$callback.invoke(new l<>(Boxing.boxBoolean(true), 0L, null, 0, 12, null));
            return Unit.INSTANCE;
        }
        l<Boolean> lVar2 = (l) obj2;
        if (lVar2.b() != 0) {
            AegisLogger.INSTANCE.w(this.this$0.N(), "start", "init trtc failed, " + lVar2);
            this.$callback.invoke(lVar2);
            return Unit.INSTANCE;
        }
        roomTrtcProxyImpl2 = this.this$0.trtcProxy;
        roomTrtcProxyImpl2.q(this.this$0.L().n());
        z16 = this.this$0.isStreamPushed;
        if (!z16) {
        }
        this.this$0.M().a(40);
        this.$callback.invoke(new l<>(Boxing.boxBoolean(true), 0L, null, 0, 12, null));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LiveAnchorTrtcRoom$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
