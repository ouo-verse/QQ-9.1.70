package com.tencent.mobileqq.aio.msglist;

import com.tencent.mobileqq.aio.utils.StopWatch;
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
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.AIOMsgRepo$loadLatestDbMsgs$1$onLoad$1", f = "AIOMsgRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
final class AIOMsgRepo$loadLatestDbMsgs$1$onLoad$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $needContinueGetMsg;
    final /* synthetic */ boolean $partialLoad;
    final /* synthetic */ com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> $rsp;
    final /* synthetic */ StopWatch $stopWatch;
    int label;
    final /* synthetic */ AIOMsgRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgRepo$loadLatestDbMsgs$1$onLoad$1(StopWatch stopWatch, AIOMsgRepo aIOMsgRepo, com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar, boolean z16, boolean z17, Continuation<? super AIOMsgRepo$loadLatestDbMsgs$1$onLoad$1> continuation) {
        super(2, continuation);
        this.$stopWatch = stopWatch;
        this.this$0 = aIOMsgRepo;
        this.$rsp = hVar;
        this.$needContinueGetMsg = z16;
        this.$partialLoad = z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, stopWatch, aIOMsgRepo, hVar, Boolean.valueOf(z16), Boolean.valueOf(z17), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AIOMsgRepo$loadLatestDbMsgs$1$onLoad$1(this.$stopWatch, this.this$0, this.$rsp, this.$needContinueGetMsg, this.$partialLoad, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$stopWatch.e("switch to display");
                this.this$0.a1(this.$rsp, true, this.$needContinueGetMsg);
                this.$stopWatch.b("handle msg");
                QLog.i("AIOMsgRepo", 1, "useDelegate.getLastDbMsgs, succ=" + this.$rsp.d() + " partialLoad=" + this.$partialLoad + " needContinueGetMsg=" + this.$needContinueGetMsg);
                com.tencent.aio.pref.a.f69788j.c("preLoadMsg");
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgRepo$loadLatestDbMsgs$1$onLoad$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
