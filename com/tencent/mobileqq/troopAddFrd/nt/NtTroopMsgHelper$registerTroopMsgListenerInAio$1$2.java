package com.tencent.mobileqq.troopAddFrd.nt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troopAddFrd.nt.NtTroopMsgHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.api.IMsgService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troopAddFrd.nt.NtTroopMsgHelper$registerTroopMsgListenerInAio$1$2", f = "NtTroopMsgHelper.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class NtTroopMsgHelper$registerTroopMsgListenerInAio$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $troopUin;
    int label;
    final /* synthetic */ NtTroopMsgHelper this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troopAddFrd/nt/NtTroopMsgHelper$registerTroopMsgListenerInAio$1$2$a", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/qqnt/msg/d;", "value", "", "a", "(Lcom/tencent/qqnt/msg/d;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements FlowCollector<com.tencent.qqnt.msg.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f302688d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ NtTroopMsgHelper f302689e;

        a(String str, NtTroopMsgHelper ntTroopMsgHelper) {
            this.f302688d = str;
            this.f302689e = ntTroopMsgHelper;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) ntTroopMsgHelper);
            }
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object emit(@NotNull com.tencent.qqnt.msg.d dVar, @NotNull Continuation<? super Unit> continuation) {
            NtTroopMsgHelper.b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) continuation);
            }
            if (Intrinsics.areEqual(dVar.a().peerUid, this.f302688d)) {
                this.f302689e.troopAioLastMsgSeq = dVar.a().msgSeq;
                bVar = this.f302689e.msgUpdateListener;
                if (bVar != null) {
                    bVar.a(dVar);
                }
                if (QLog.isDebugVersion()) {
                    QLog.d("NtTroopMsgHelper", 4, "receive msg, troopUin=" + this.f302688d + ", senderUid=" + dVar.a().senderUid);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NtTroopMsgHelper$registerTroopMsgListenerInAio$1$2(String str, NtTroopMsgHelper ntTroopMsgHelper, Continuation<? super NtTroopMsgHelper$registerTroopMsgListenerInAio$1$2> continuation) {
        super(2, continuation);
        this.$troopUin = str;
        this.this$0 = ntTroopMsgHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, ntTroopMsgHelper, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new NtTroopMsgHelper$registerTroopMsgListenerInAio$1$2(this.$troopUin, this.this$0, continuation);
    }

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
                Flow<com.tencent.qqnt.msg.d> registerSendMsgNotificationFlow = ((IMsgService) QRoute.api(IMsgService.class)).registerSendMsgNotificationFlow();
                a aVar = new a(this.$troopUin, this.this$0);
                this.label = 1;
                if (registerSendMsgNotificationFlow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((NtTroopMsgHelper$registerTroopMsgListenerInAio$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
