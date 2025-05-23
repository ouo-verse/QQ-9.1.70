package com.tencent.mobileqq.aio.msg.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IQueryFirstRoamMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.RoamDatemsg;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/aio/msg/service/r;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$queryFirstRoamMsg$1", f = "AIOMsgServiceWithContext.kt", i = {}, l = {398}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
final class AIOMsgServiceWithContext$queryFirstRoamMsg$1 extends SuspendLambda implements Function2<ProducerScope<? super r>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Contact $peer;
    final /* synthetic */ long $time;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/aio/msg/service/AIOMsgServiceWithContext$queryFirstRoamMsg$1$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryFirstRoamMsgCallback;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/RoamDatemsg;", "roamDatemsg", "", "onResult", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements IQueryFirstRoamMsgCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Function1<r, Unit>> f190217a;

        a(Ref.ObjectRef<Function1<r, Unit>> objectRef) {
            this.f190217a = objectRef;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) objectRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQueryFirstRoamMsgCallback
        public void onResult(int result, @NotNull String errMsg, @Nullable RoamDatemsg roamDatemsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), errMsg, roamDatemsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Function1<r, Unit> function1 = this.f190217a.element;
            if (function1 != null) {
                function1.invoke(new r(result, errMsg, roamDatemsg));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgServiceWithContext$queryFirstRoamMsg$1(Contact contact, long j3, Continuation<? super AIOMsgServiceWithContext$queryFirstRoamMsg$1> continuation) {
        super(2, continuation);
        this.$peer = contact;
        this.$time = j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, contact, Long.valueOf(j3), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgServiceWithContext$queryFirstRoamMsg$1 aIOMsgServiceWithContext$queryFirstRoamMsg$1 = new AIOMsgServiceWithContext$queryFirstRoamMsg$1(this.$peer, this.$time, continuation);
        aIOMsgServiceWithContext$queryFirstRoamMsg$1.L$0 = obj;
        return aIOMsgServiceWithContext$queryFirstRoamMsg$1;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$queryFirstRoamMsg$1$callback$1, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new Function1<r, Unit>(producerScope) { // from class: com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$queryFirstRoamMsg$1$callback$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ProducerScope<r> $$this$callbackFlow;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                        this.$$this$callbackFlow = producerScope;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) producerScope);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(r rVar) {
                        invoke2(rVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull r it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        this.$$this$callbackFlow.mo2003trySendJP2dKIU(it);
                        SendChannel.DefaultImpls.close$default(this.$$this$callbackFlow, null, 1, null);
                    }
                };
                w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    e16.queryFirstRoamMsg(this.$peer, this.$time, new a(objectRef));
                }
                Function0<Unit> function0 = new Function0<Unit>(objectRef) { // from class: com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$queryFirstRoamMsg$1.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Ref.ObjectRef<Function1<r, Unit>> $callback;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$callback = objectRef;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) objectRef);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            this.$callback.element = null;
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super r> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgServiceWithContext$queryFirstRoamMsg$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
