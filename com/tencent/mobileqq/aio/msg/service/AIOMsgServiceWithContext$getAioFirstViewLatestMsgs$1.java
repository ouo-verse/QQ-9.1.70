package com.tencent.mobileqq.aio.msg.service;

import android.content.Context;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IGetAioFirstViewLatestMsgCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import defpackage.MsgListUtil;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
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
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Pair;", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1", f = "AIOMsgServiceWithContext.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1 extends SuspendLambda implements Function2<ProducerScope<? super Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, ? extends Boolean>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AIOSession $aioSession;
    final /* synthetic */ int $cnt;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMsgServiceWithContext this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1(AIOSession aIOSession, int i3, AIOMsgServiceWithContext aIOMsgServiceWithContext, Continuation<? super AIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1> continuation) {
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
    public static final void b(Ref.ObjectRef objectRef, AIOMsgServiceWithContext aIOMsgServiceWithContext, int i3, String str, ArrayList msgList, boolean z16) {
        boolean z17;
        Context c16;
        try {
            QLog.d("AIOMsgService", 1, "getAioFirstViewLatestMsgs callback result=" + i3 + ", errMsg=" + str + ", msg size=" + msgList.size() + ", needContinueGetMsg=" + z16);
            Function1 function1 = (Function1) objectRef.element;
            if (function1 != null) {
                if (i3 == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                MsgListUtil msgListUtil = MsgListUtil.f24918a;
                Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
                c16 = aIOMsgServiceWithContext.c();
                function1.invoke(new Pair(new com.tencent.aio.msgservice.h(z17, i3, str, MsgListUtil.q(msgListUtil, msgList, c16, null, 4, null)), Boolean.valueOf(z16)));
            }
        } catch (CancellationException unused) {
            QLog.d("AIOMsgService", 1, "getAioFirstViewLatestMsgs Coroutine cancelled");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1 aIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1 = new AIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1(this.$aioSession, this.$cnt, this.this$0, continuation);
        aIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1.L$0 = obj;
        return aIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, ? extends Boolean>> producerScope, Continuation<? super Unit> continuation) {
        return invoke2((ProducerScope<? super Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Boolean>>) producerScope, continuation);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1$callback$1] */
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
                objectRef.element = new Function1<Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, ? extends Boolean>, Unit>(producerScope) { // from class: com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1$callback$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ProducerScope<Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Boolean>> $$this$callbackFlow;

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
                    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, ? extends Boolean> pair) {
                        invoke2((Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Boolean>) pair);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Boolean> it) {
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
                iMsgService.getAioFirstViewLatestMsgs(h16, i16, new IGetAioFirstViewLatestMsgCallback() { // from class: com.tencent.mobileqq.aio.msg.service.i
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAioFirstViewLatestMsgCallback
                    public final void onResult(int i17, String str, ArrayList arrayList, boolean z16) {
                        AIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1.b(Ref.ObjectRef.this, aIOMsgServiceWithContext, i17, str, arrayList, z16);
                    }
                });
                Function0<Unit> function0 = new Function0<Unit>(objectRef) { // from class: com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Ref.ObjectRef<Function1<Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Boolean>, Unit>> $callback;

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

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Boolean>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgServiceWithContext$getAioFirstViewLatestMsgs$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
