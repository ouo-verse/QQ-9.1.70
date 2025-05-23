package com.tencent.mobileqq.aio.msg.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IGetRevealTofuAuthorityCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService;
import com.tencent.qqnt.kernel.nativeinterface.RevealAuthorityReq;
import com.tencent.qqnt.kernel.nativeinterface.RevealAuthorityRsp;
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
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/aio/msg/service/t;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msg.service.AIOMsgService$authorityTofu$1", f = "AIOMsgService.kt", i = {}, l = {303}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMsgService$authorityTofu$1 extends SuspendLambda implements Function2<ProducerScope<? super t>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $msgId;
    final /* synthetic */ RevealAuthorityReq $req;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgService$authorityTofu$1(RevealAuthorityReq revealAuthorityReq, long j3, Continuation<? super AIOMsgService$authorityTofu$1> continuation) {
        super(2, continuation);
        this.$req = revealAuthorityReq;
        this.$msgId = j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, revealAuthorityReq, Long.valueOf(j3), continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(long j3, Ref.ObjectRef objectRef, int i3, String errMsg, RevealAuthorityRsp revealAuthorityRsp) {
        Function1 function1;
        QLog.i("AIOMsgService", 1, "authorityTofu:: nt sdk authority cb, msgId=" + j3 + ", result=" + i3 + ", errMsg=" + errMsg + ", rsp=" + revealAuthorityRsp);
        if (revealAuthorityRsp != null && (function1 = (Function1) objectRef.element) != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            function1.invoke(new t(j3, i3, errMsg, revealAuthorityRsp));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgService$authorityTofu$1 aIOMsgService$authorityTofu$1 = new AIOMsgService$authorityTofu$1(this.$req, this.$msgId, continuation);
        aIOMsgService$authorityTofu$1.L$0 = obj;
        return aIOMsgService$authorityTofu$1;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.mobileqq.aio.msg.service.AIOMsgService$authorityTofu$1$callback$1, T] */
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
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new Function1<t, Unit>(producerScope) { // from class: com.tencent.mobileqq.aio.msg.service.AIOMsgService$authorityTofu$1$callback$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ProducerScope<t> $$this$callbackFlow;

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
                    public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                        invoke2(tVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull t it) {
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
                IKernelLiteBusinessService liteBusinessService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getLiteBusinessService();
                if (liteBusinessService != null) {
                    RevealAuthorityReq revealAuthorityReq = this.$req;
                    final long j3 = this.$msgId;
                    liteBusinessService.getRevealTofuAuthority(revealAuthorityReq, new IGetRevealTofuAuthorityCallback() { // from class: com.tencent.mobileqq.aio.msg.service.e
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetRevealTofuAuthorityCallback
                        public final void onResult(int i16, String str, RevealAuthorityRsp revealAuthorityRsp) {
                            AIOMsgService$authorityTofu$1.b(j3, objectRef, i16, str, revealAuthorityRsp);
                        }
                    });
                }
                Function0<Unit> function0 = new Function0<Unit>(objectRef) { // from class: com.tencent.mobileqq.aio.msg.service.AIOMsgService$authorityTofu$1.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Ref.ObjectRef<Function1<t, Unit>> $callback;

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
    public final Object invoke(@NotNull ProducerScope<? super t> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgService$authorityTofu$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
