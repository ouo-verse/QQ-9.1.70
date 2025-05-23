package com.tencent.mobileqq.aio.msg.service;

import android.content.Context;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import defpackage.MsgListUtil;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getLatestDbMsgs$1", f = "AIOMsgServiceWithContext.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMsgServiceWithContext$getLatestDbMsgs$1 extends SuspendLambda implements Function2<ProducerScope<? super com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AIOSession $aioSession;
    final /* synthetic */ int $cnt;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMsgServiceWithContext this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgServiceWithContext$getLatestDbMsgs$1(AIOSession aIOSession, int i3, AIOMsgServiceWithContext aIOMsgServiceWithContext, Continuation<? super AIOMsgServiceWithContext$getLatestDbMsgs$1> continuation) {
        super(2, continuation);
        this.$aioSession = aIOSession;
        this.$cnt = i3;
        this.this$0 = aIOMsgServiceWithContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aIOSession, Integer.valueOf(i3), aIOMsgServiceWithContext, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Ref.ObjectRef objectRef, AIOMsgServiceWithContext aIOMsgServiceWithContext, int i3, String str, ArrayList msgList) {
        boolean z16;
        Context c16;
        try {
            QLog.d("AIOMsgService", 1, "getLatestDbMsgs callback result=" + i3 + ", errMsg=" + str + ", msg size=" + msgList.size());
            Function1 function1 = (Function1) objectRef.element;
            if (function1 != null) {
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                MsgListUtil msgListUtil = MsgListUtil.f24918a;
                Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
                c16 = aIOMsgServiceWithContext.c();
                function1.invoke(new com.tencent.aio.msgservice.h(z16, i3, str, MsgListUtil.q(msgListUtil, msgList, c16, null, 4, null)));
            }
        } catch (CancellationException unused) {
            QLog.d("AIOMsgService", 1, "getLatestDbMsgs Coroutine cancelled");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgServiceWithContext$getLatestDbMsgs$1 aIOMsgServiceWithContext$getLatestDbMsgs$1 = new AIOMsgServiceWithContext$getLatestDbMsgs$1(this.$aioSession, this.$cnt, this.this$0, continuation);
        aIOMsgServiceWithContext$getLatestDbMsgs$1.L$0 = obj;
        return aIOMsgServiceWithContext$getLatestDbMsgs$1;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getLatestDbMsgs$1$callback$1] */
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
                objectRef.element = new Function1<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Unit>(producerScope) { // from class: com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getLatestDbMsgs$1$callback$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ProducerScope<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> $$this$callbackFlow;

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
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar) {
                        invoke2(hVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> it) {
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
                Contact h16 = AIOUtil.f194084a.h(this.$aioSession);
                IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
                int i16 = this.$cnt;
                final AIOMsgServiceWithContext aIOMsgServiceWithContext = this.this$0;
                iMsgService.getLatestDbMsgs(h16, i16, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.service.j
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                    public final void onResult(int i17, String str, ArrayList arrayList) {
                        AIOMsgServiceWithContext$getLatestDbMsgs$1.b(Ref.ObjectRef.this, aIOMsgServiceWithContext, i17, str, arrayList);
                    }
                });
                Function0<Unit> function0 = new Function0<Unit>(objectRef) { // from class: com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getLatestDbMsgs$1.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Ref.ObjectRef<Function1<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Unit>> $callback;

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
    public final Object invoke(@NotNull ProducerScope<? super com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgServiceWithContext$getLatestDbMsgs$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
