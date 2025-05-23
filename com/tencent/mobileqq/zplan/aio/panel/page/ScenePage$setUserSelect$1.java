package com.tencent.mobileqq.zplan.aio.panel.page;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.page.ScenePage$setUserSelect$1", f = "ScenePage.kt", i = {0}, l = {102}, m = "invokeSuspend", n = {"requestTime"}, s = {"J$0"})
/* loaded from: classes35.dex */
final class ScenePage$setUserSelect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.zplan.aio.panel.item.b $item;
    final /* synthetic */ int $position;
    long J$0;
    int label;
    final /* synthetic */ ScenePage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScenePage$setUserSelect$1(com.tencent.mobileqq.zplan.aio.panel.item.b bVar, ScenePage scenePage, int i3, Continuation<? super ScenePage$setUserSelect$1> continuation) {
        super(2, continuation);
        this.$item = bVar;
        this.this$0 = scenePage;
        this.$position = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScenePage$setUserSelect$1(this.$item, this.this$0, this.$position, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        long j3;
        Pair pair;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            long currentTimeMillis = System.currentTimeMillis();
            Deferred<Boolean> t16 = this.$item.t();
            this.J$0 = currentTimeMillis;
            this.label = 1;
            obj = t16.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = currentTimeMillis;
        } else if (i3 == 1) {
            j3 = this.J$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            this.this$0.z(TuplesKt.to(Boxing.boxInt(this.$position), Boxing.boxLong(j3)));
        }
        ScenePage scenePage = this.this$0;
        pair = scenePage.realSelected;
        scenePage.y(pair != null ? (Integer) pair.getFirst() : null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ScenePage$setUserSelect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
