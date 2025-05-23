package com.tencent.mobileqq.aio.msg.service;

import android.content.Context;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
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
@DebugMetadata(c = "com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1", f = "AIOMsgServiceWithContext.kt", i = {}, l = {431}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1 extends SuspendLambda implements Function2<ProducerScope<? super com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $clientSeq;
    final /* synthetic */ int $cnt;
    final /* synthetic */ long $msgTime;
    final /* synthetic */ Contact $peer;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMsgServiceWithContext this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/aio/msg/service/AIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onResult", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements IMsgOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Function1<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Unit>> f190212a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOMsgServiceWithContext f190213b;

        a(Ref.ObjectRef<Function1<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Unit>> objectRef, AIOMsgServiceWithContext aIOMsgServiceWithContext) {
            this.f190212a = objectRef;
            this.f190213b = aIOMsgServiceWithContext;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) objectRef, (Object) aIOMsgServiceWithContext);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
        public void onResult(int result, @Nullable String errMsg, @NotNull ArrayList<MsgRecord> msgList) {
            Context c16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), errMsg, msgList);
                return;
            }
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            try {
                Function1<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Unit> function1 = this.f190212a.element;
                if (function1 != null) {
                    if (result == 0) {
                        z16 = true;
                    }
                    MsgListUtil msgListUtil = MsgListUtil.f24918a;
                    c16 = this.f190213b.c();
                    function1.invoke(new com.tencent.aio.msgservice.h<>(z16, result, errMsg, MsgListUtil.q(msgListUtil, msgList, c16, null, 4, null)));
                }
            } catch (CancellationException unused) {
                QLog.d("AIOMsgService", 1, "getMsgsWithMsgTimeAndClientSeqForC2C Coroutine cancelled");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1(Contact contact, long j3, long j16, int i3, AIOMsgServiceWithContext aIOMsgServiceWithContext, Continuation<? super AIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1> continuation) {
        super(2, continuation);
        this.$peer = contact;
        this.$msgTime = j3;
        this.$clientSeq = j16;
        this.$cnt = i3;
        this.this$0 = aIOMsgServiceWithContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, contact, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), aIOMsgServiceWithContext, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1 aIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1 = new AIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1(this.$peer, this.$msgTime, this.$clientSeq, this.$cnt, this.this$0, continuation);
        aIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1.L$0 = obj;
        return aIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [T, com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1$callback$1] */
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
                objectRef.element = new Function1<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Unit>(producerScope) { // from class: com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1$callback$1
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
                w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    e16.getMsgsWithMsgTimeAndClientSeqForC2C(this.$peer, this.$msgTime, this.$clientSeq, this.$cnt, true, false, true, new a(objectRef, this.this$0));
                }
                Function0<Unit> function0 = new Function0<Unit>(objectRef) { // from class: com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1.2
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgServiceWithContext$getMsgsWithMsgTimeAndClientSeqForC2C$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
