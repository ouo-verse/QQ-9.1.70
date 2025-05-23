package com.tencent.mobileqq.aio.msg.service;

import android.content.Context;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.GetMsgsAndStatusRecord;
import com.tencent.qqnt.kernel.nativeinterface.GetMsgsStatusEnum;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgWithStatusCallback;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/aio/msg/service/p;", "Lcom/tencent/aio/data/msglist/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getMsgsWithStatus$1", f = "AIOMsgServiceWithContext.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMsgServiceWithContext$getMsgsWithStatus$1 extends SuspendLambda implements Function2<ProducerScope<? super p<com.tencent.aio.data.msglist.a>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $appid;
    final /* synthetic */ o $req;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMsgServiceWithContext this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/aio/msg/service/AIOMsgServiceWithContext$getMsgsWithStatus$1$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgWithStatusCallback;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GetMsgsStatusEnum;", "status", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onResult", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements IGetMsgWithStatusCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f190214a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Function1<p<com.tencent.aio.data.msglist.a>, Unit>> f190215b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AIOMsgServiceWithContext f190216c;

        a(long j3, Ref.ObjectRef<Function1<p<com.tencent.aio.data.msglist.a>, Unit>> objectRef, AIOMsgServiceWithContext aIOMsgServiceWithContext) {
            this.f190214a = j3;
            this.f190215b = objectRef;
            this.f190216c = aIOMsgServiceWithContext;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), objectRef, aIOMsgServiceWithContext);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMsgWithStatusCallback
        public void onResult(int result, @Nullable String errMsg, @Nullable GetMsgsStatusEnum status, @Nullable ArrayList<MsgRecord> msgList) {
            ArrayList<MsgRecord> arrayList;
            Context c16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), errMsg, status, msgList);
                return;
            }
            if (msgList == null) {
                try {
                    arrayList = new ArrayList<>();
                } catch (CancellationException unused) {
                    QLog.d("AIOMsgService", 1, "getMsgsWithStatus Coroutine cancelled");
                    return;
                }
            } else {
                arrayList = msgList;
            }
            QLog.d("AIOMsgService", 1, "getMsgsWithStatus callback result=" + result + ", errMsg=" + errMsg + ", msg size=" + Integer.valueOf(arrayList.size()) + ", status=" + status + ", appid=" + this.f190214a);
            Function1<p<com.tencent.aio.data.msglist.a>, Unit> function1 = this.f190215b.element;
            if (function1 != null) {
                if (result == 0) {
                    z16 = true;
                }
                MsgListUtil msgListUtil = MsgListUtil.f24918a;
                c16 = this.f190216c.c();
                function1.invoke(new p<>(z16, result, errMsg, MsgListUtil.q(msgListUtil, arrayList, c16, null, 4, null), status));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgServiceWithContext$getMsgsWithStatus$1(o oVar, long j3, AIOMsgServiceWithContext aIOMsgServiceWithContext, Continuation<? super AIOMsgServiceWithContext$getMsgsWithStatus$1> continuation) {
        super(2, continuation);
        this.$req = oVar;
        this.$appid = j3;
        this.this$0 = aIOMsgServiceWithContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, oVar, Long.valueOf(j3), aIOMsgServiceWithContext, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgServiceWithContext$getMsgsWithStatus$1 aIOMsgServiceWithContext$getMsgsWithStatus$1 = new AIOMsgServiceWithContext$getMsgsWithStatus$1(this.$req, this.$appid, this.this$0, continuation);
        aIOMsgServiceWithContext$getMsgsWithStatus$1.L$0 = obj;
        return aIOMsgServiceWithContext$getMsgsWithStatus$1;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getMsgsWithStatus$1$callback$1, T] */
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
                objectRef.element = new Function1<p<com.tencent.aio.data.msglist.a>, Unit>(producerScope) { // from class: com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getMsgsWithStatus$1$callback$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ProducerScope<p<com.tencent.aio.data.msglist.a>> $$this$callbackFlow;

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
                    public /* bridge */ /* synthetic */ Unit invoke(p<com.tencent.aio.data.msglist.a> pVar) {
                        invoke2(pVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull p<com.tencent.aio.data.msglist.a> it) {
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
                Contact h16 = AIOUtil.f194084a.h(this.$req.a());
                h16.guildId = "";
                w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    e16.getMsgsWithStatus(new GetMsgsAndStatusRecord(h16, this.$req.c(), this.$req.d(), this.$req.b(), this.$req.e(), false, this.$appid), new a(this.$appid, objectRef, this.this$0));
                }
                Function0<Unit> function0 = new Function0<Unit>(objectRef) { // from class: com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext$getMsgsWithStatus$1.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Ref.ObjectRef<Function1<p<com.tencent.aio.data.msglist.a>, Unit>> $callback;

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
    public final Object invoke(@NotNull ProducerScope<? super p<com.tencent.aio.data.msglist.a>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgServiceWithContext$getMsgsWithStatus$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
