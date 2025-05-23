package com.tencent.mobileqq.aio.msglist;

import android.os.Bundle;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.AIOMsgRepo$loadRangePage$4", f = "AIOMsgRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMsgRepo$loadRangePage$4 extends SuspendLambda implements Function2<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $count;
    final /* synthetic */ Bundle $extra;
    final /* synthetic */ boolean $ignoreErrCode;
    final /* synthetic */ boolean $orderDown;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMsgRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgRepo$loadRangePage$4(boolean z16, AIOMsgRepo aIOMsgRepo, int i3, Bundle bundle, boolean z17, Continuation<? super AIOMsgRepo$loadRangePage$4> continuation) {
        super(2, continuation);
        this.$ignoreErrCode = z16;
        this.this$0 = aIOMsgRepo;
        this.$count = i3;
        this.$extra = bundle;
        this.$orderDown = z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), aIOMsgRepo, Integer.valueOf(i3), bundle, Boolean.valueOf(z17), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgRepo$loadRangePage$4 aIOMsgRepo$loadRangePage$4 = new AIOMsgRepo$loadRangePage$4(this.$ignoreErrCode, this.this$0, this.$count, this.$extra, this.$orderDown, continuation);
        aIOMsgRepo$loadRangePage$4.L$0 = obj;
        return aIOMsgRepo$loadRangePage$4;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgRepo$loadRangePage$4) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar, (Object) continuation);
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
                QLog.d("AIOMsgRepo", 1, "loadRangePage end. result=" + hVar.c() + " msg=" + hVar.b() + " listSize=" + hVar.a().size() + " ignoreErrCode=" + this.$ignoreErrCode);
                this.this$0.A1(hVar, this.$count);
                if ((hVar.d() || this.$ignoreErrCode) && (!hVar.a().isEmpty())) {
                    MsgList M = this.this$0.M();
                    M.clear();
                    M.addAll(hVar.a());
                    this.this$0.l0(hVar.a());
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) M);
                    QLog.i("AIOMsgRepo", 1, "[loadRangePage]: firstMsgId is " + ((com.tencent.aio.data.msglist.a) first).getMsgId());
                    AIOMsgRepo aIOMsgRepo = this.this$0;
                    aIOMsgRepo.p0(IMsgListRepository.MsgListRepoOpType.LoadRangePage, aIOMsgRepo.M(), this.$extra, "msg_navigation");
                    if (this.$orderDown) {
                        this.this$0.a();
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
