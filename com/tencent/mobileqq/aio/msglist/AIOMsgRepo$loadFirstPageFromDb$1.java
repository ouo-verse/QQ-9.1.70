package com.tencent.mobileqq.aio.msglist;

import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Pair;
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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.AIOMsgRepo$loadFirstPageFromDb$1", f = "AIOMsgRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMsgRepo$loadFirstPageFromDb$1 extends SuspendLambda implements Function2<Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, ? extends Boolean>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $firstLoad;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMsgRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgRepo$loadFirstPageFromDb$1(AIOMsgRepo aIOMsgRepo, boolean z16, Continuation<? super AIOMsgRepo$loadFirstPageFromDb$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOMsgRepo;
        this.$firstLoad = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aIOMsgRepo, Boolean.valueOf(z16), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgRepo$loadFirstPageFromDb$1 aIOMsgRepo$loadFirstPageFromDb$1 = new AIOMsgRepo$loadFirstPageFromDb$1(this.this$0, this.$firstLoad, continuation);
        aIOMsgRepo$loadFirstPageFromDb$1.L$0 = obj;
        return aIOMsgRepo$loadFirstPageFromDb$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, ? extends Boolean> pair, Continuation<? super Unit> continuation) {
        return invoke2((Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Boolean>) pair, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        if ((!((com.tencent.aio.msgservice.h) r9.getFirst()).a().isEmpty()) != false) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.aio.api.runtime.a D;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                AIOMsgRepo.b1(this.this$0, (com.tencent.aio.msgservice.h) pair.getFirst(), this.$firstLoad, false, 4, null);
                if (this.$firstLoad) {
                    if (!((Boolean) pair.getSecond()).booleanValue()) {
                        D = this.this$0.D();
                        D.e().h(new AIOMsgListEvent.LoadRoamFirstMsgEvent(2));
                    } else {
                        AIOMsgRepo aIOMsgRepo = this.this$0;
                        if (((com.tencent.aio.msgservice.h) pair.getFirst()).d()) {
                            z16 = true;
                        }
                        z16 = false;
                        aIOMsgRepo.w1(z16);
                    }
                    com.tencent.aio.pref.a.f69788j.d();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull Pair<? extends com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Boolean> pair, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgRepo$loadFirstPageFromDb$1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) pair, (Object) continuation);
    }
}
