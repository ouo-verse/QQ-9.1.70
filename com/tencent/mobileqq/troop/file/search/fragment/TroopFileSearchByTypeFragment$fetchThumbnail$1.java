package com.tencent.mobileqq.troop.file.search.fragment;

import com.tencent.mobileqq.troop.file.search.vm.TroopFileSearchByTypeVM;
import com.tencent.mobileqq.troop.file.search.vm.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.file.search.fragment.TroopFileSearchByTypeFragment$fetchThumbnail$1", f = "TroopFileSearchByTypeFragment.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class TroopFileSearchByTypeFragment$fetchThumbnail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b.a $intent;
    int label;
    final /* synthetic */ TroopFileSearchByTypeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFileSearchByTypeFragment$fetchThumbnail$1(TroopFileSearchByTypeFragment troopFileSearchByTypeFragment, b.a aVar, Continuation<? super TroopFileSearchByTypeFragment$fetchThumbnail$1> continuation) {
        super(2, continuation);
        this.this$0 = troopFileSearchByTypeFragment;
        this.$intent = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TroopFileSearchByTypeFragment$fetchThumbnail$1(this.this$0, this.$intent, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        TroopFileSearchByTypeVM zh5;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            zh5 = this.this$0.zh();
            b.a aVar = this.$intent;
            this.label = 1;
            if (zh5.sendUserIntent(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TroopFileSearchByTypeFragment$fetchThumbnail$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
