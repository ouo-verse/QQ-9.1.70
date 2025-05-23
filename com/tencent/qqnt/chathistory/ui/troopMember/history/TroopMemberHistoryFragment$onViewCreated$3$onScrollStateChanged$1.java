package com.tencent.qqnt.chathistory.ui.troopMember.history;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.troopMember.history.data.b;
import com.tencent.qqnt.chathistory.ui.troopMember.history.viewmodel.TroopMemberHistoryViewModel;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.troopMember.history.TroopMemberHistoryFragment$onViewCreated$3$onScrollStateChanged$1", f = "TroopMemberHistoryFragment.kt", i = {0}, l = {161}, m = "invokeSuspend", n = {"last"}, s = {"L$0"})
/* loaded from: classes23.dex */
final class TroopMemberHistoryFragment$onViewCreated$3$onScrollStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    Object L$0;
    int label;
    final /* synthetic */ TroopMemberHistoryFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopMemberHistoryFragment$onViewCreated$3$onScrollStateChanged$1(TroopMemberHistoryFragment troopMemberHistoryFragment, Continuation<? super TroopMemberHistoryFragment$onViewCreated$3$onScrollStateChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = troopMemberHistoryFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopMemberHistoryFragment, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopMemberHistoryFragment$onViewCreated$3$onScrollStateChanged$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        b Kh;
        Object last;
        long j3;
        List list;
        com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    aVar = (com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Kh = this.this$0.Kh();
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) Kh.getData());
                com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a aVar2 = (com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a) last;
                j3 = this.this$0.lastId;
                if (j3 != aVar2.f()) {
                    TroopMemberHistoryViewModel rh5 = this.this$0.rh();
                    list = this.this$0.senderUids;
                    if (list == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("senderUids");
                        list = null;
                    }
                    b.C9558b c9558b = new b.C9558b(list, aVar2.f(), aVar2.getMsgTime(), aVar2.g());
                    this.L$0 = aVar2;
                    this.label = 1;
                    if (rh5.sendUserIntent(c9558b, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar = aVar2;
                }
                return Unit.INSTANCE;
            }
            this.this$0.lastId = aVar.f();
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopMemberHistoryFragment$onViewCreated$3$onScrollStateChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
