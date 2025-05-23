package com.tencent.ecommerce.biz.detail.repo.saas;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.saas.ECDetailCustomRepo$loadDetailFromCache$2", f = "ECDetailCustomRepo.kt", i = {0}, l = {446}, m = "invokeSuspend", n = {"$this$withLock$iv"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECDetailCustomRepo$loadDetailFromCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef $preloadAdapterData;
    final /* synthetic */ List $relatedData;
    Object L$0;
    int label;
    final /* synthetic */ ECDetailCustomRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECDetailCustomRepo$loadDetailFromCache$2(ECDetailCustomRepo eCDetailCustomRepo, Ref.ObjectRef objectRef, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCDetailCustomRepo;
        this.$preloadAdapterData = objectRef;
        this.$relatedData = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECDetailCustomRepo$loadDetailFromCache$2(this.this$0, this.$preloadAdapterData, this.$relatedData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECDetailCustomRepo$loadDetailFromCache$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Mutex mutex;
        Mutex mutex2;
        List list;
        List list2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.this$0.mutex;
            this.L$0 = mutex;
            this.label = 1;
            if (mutex.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex2 = mutex;
        } else if (i3 == 1) {
            mutex2 = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            List list3 = (List) this.$preloadAdapterData.element;
            if (list3 != null) {
                list2 = this.this$0.dataSourcePts;
                list2.set(0, list3);
            }
            List list4 = this.$relatedData;
            if (list4 != null) {
                list = this.this$0.dataSourcePts;
                list.set(1, list4);
            }
            this.this$0.r();
            Unit unit = Unit.INSTANCE;
            mutex2.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th5) {
            mutex2.unlock(null);
            throw th5;
        }
    }
}
