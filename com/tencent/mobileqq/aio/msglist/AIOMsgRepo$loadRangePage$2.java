package com.tencent.mobileqq.aio.msglist;

import android.os.Bundle;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.AIOMsgRepo$loadRangePage$2", f = "AIOMsgRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMsgRepo$loadRangePage$2 extends SuspendLambda implements Function2<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $beginMsgSeq;
    final /* synthetic */ int $count;
    final /* synthetic */ Bundle $extra;
    final /* synthetic */ MsgNavigationEvent.NavigateBySeqEvent $intent;
    final /* synthetic */ boolean $orderDown;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMsgRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgRepo$loadRangePage$2(AIOMsgRepo aIOMsgRepo, int i3, long j3, Bundle bundle, boolean z16, MsgNavigationEvent.NavigateBySeqEvent navigateBySeqEvent, Continuation<? super AIOMsgRepo$loadRangePage$2> continuation) {
        super(2, continuation);
        this.this$0 = aIOMsgRepo;
        this.$count = i3;
        this.$beginMsgSeq = j3;
        this.$extra = bundle;
        this.$orderDown = z16;
        this.$intent = navigateBySeqEvent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aIOMsgRepo, Integer.valueOf(i3), Long.valueOf(j3), bundle, Boolean.valueOf(z16), navigateBySeqEvent, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgRepo$loadRangePage$2 aIOMsgRepo$loadRangePage$2 = new AIOMsgRepo$loadRangePage$2(this.this$0, this.$count, this.$beginMsgSeq, this.$extra, this.$orderDown, this.$intent, continuation);
        aIOMsgRepo$loadRangePage$2.L$0 = obj;
        return aIOMsgRepo$loadRangePage$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgRepo$loadRangePage$2) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.aio.api.runtime.a D;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.aio.msgservice.h hVar = (com.tencent.aio.msgservice.h) this.L$0;
                boolean z16 = true;
                QLog.d("AIOMsgRepo", 1, "loadRangePage end. result=" + hVar.c() + " msg=" + hVar.b() + " listSize=" + hVar.a().size());
                this.this$0.A1(hVar, this.$count);
                if (hVar.d() && (!hVar.a().isEmpty())) {
                    this.this$0.c1(hVar.a(), this.$beginMsgSeq, 0L, 0L, false, this.$extra);
                    if (this.$orderDown) {
                        this.this$0.a();
                    }
                } else {
                    z16 = false;
                }
                D = this.this$0.D();
                D.e().h(new MsgNavigationEvent.NavigationResultNotify(z16, this.$beginMsgSeq, this.$intent));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
