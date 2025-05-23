package com.tencent.mobileqq.aio.msglist.msgrepo;

import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.msgrepo.MsgLocationAbility$handleNavigateByTimeEvent$1", f = "MsgLocationAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class MsgLocationAbility$handleNavigateByTimeEvent$1 extends SuspendLambda implements Function2<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ MsgNavigationEvent.NavigateByTimeEvent $intent;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MsgLocationAbility this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgLocationAbility$handleNavigateByTimeEvent$1(MsgLocationAbility msgLocationAbility, MsgNavigationEvent.NavigateByTimeEvent navigateByTimeEvent, Continuation<? super MsgLocationAbility$handleNavigateByTimeEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = msgLocationAbility;
        this.$intent = navigateByTimeEvent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgLocationAbility, navigateByTimeEvent, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        MsgLocationAbility$handleNavigateByTimeEvent$1 msgLocationAbility$handleNavigateByTimeEvent$1 = new MsgLocationAbility$handleNavigateByTimeEvent$1(this.this$0, this.$intent, continuation);
        msgLocationAbility$handleNavigateByTimeEvent$1.L$0 = obj;
        return msgLocationAbility$handleNavigateByTimeEvent$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MsgLocationAbility$handleNavigateByTimeEvent$1) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.aio.msgservice.h hVar = (com.tencent.aio.msgservice.h) this.L$0;
                this.this$0.focusBottomOnBackground = false;
                QLog.i("MsgLocationAbility", 1, "[handleNavigatieByTimeEvent]: success is " + hVar.d() + ", errMsg is " + hVar.b() + ", listSize is " + hVar.a().size());
                if (hVar.d() && hVar.a().size() > 0) {
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) hVar.a());
                    com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) first;
                    QLog.i("MsgLocationAbility", 1, "[handleNavigatieByTimeEvent]: msgItemSeq is " + aVar.getMsgSeq() + ", msgItemId is " + aVar.getMsgId());
                    if (aVar.getMsgSeq() > 0) {
                        this.this$0.s(new MsgNavigationEvent.NavigateBySeqEvent(this.$intent.e(), aVar.getMsgSeq(), aVar.getMsgId(), this.$intent.d(), this.$intent.c(), false, false, null, 224, null));
                    } else if (aVar.getMsgId() > 0) {
                        this.this$0.r(new MsgNavigationEvent.NavigateByIdEvent(this.$intent.e(), aVar.getMsgId(), this.$intent.d(), this.$intent.c(), false, null, 48, null));
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
