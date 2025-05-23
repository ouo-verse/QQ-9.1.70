package com.tencent.ecommerce.base.cache.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "DataType", "KeyType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/base/cache/service/PtsComposerCache$preBuildPtsComposer$1$1$1"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.cache.service.PtsComposerCache$preBuildPtsComposer$1$1$1", f = "PtsComposerCache.kt", i = {0, 1}, l = {133, 135}, m = "invokeSuspend", n = {"toBeRemoveKeys", "toBeRemoveKeys"}, s = {"L$0", "L$0"})
/* loaded from: classes32.dex */
public final class PtsComposerCache$preBuildPtsComposer$1$invokeSuspend$$inlined$withLock$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $this_launch$inlined;
    Object L$0;
    int label;
    final /* synthetic */ PtsComposerCache$preBuildPtsComposer$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "DataType", "KeyType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/base/cache/service/PtsComposerCache$preBuildPtsComposer$1$1$1$1"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.base.cache.service.PtsComposerCache$preBuildPtsComposer$1$1$1$1", f = "PtsComposerCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.base.cache.service.PtsComposerCache$preBuildPtsComposer$1$invokeSuspend$$inlined$withLock$lambda$1$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PtsComposerCache$preBuildPtsComposer$1$invokeSuspend$$inlined$withLock$lambda$1.this.this$0.$processor.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PtsComposerCache$preBuildPtsComposer$1$invokeSuspend$$inlined$withLock$lambda$1(Continuation continuation, PtsComposerCache$preBuildPtsComposer$1 ptsComposerCache$preBuildPtsComposer$1, CoroutineScope coroutineScope) {
        super(2, continuation);
        this.this$0 = ptsComposerCache$preBuildPtsComposer$1;
        this.$this_launch$inlined = coroutineScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PtsComposerCache$preBuildPtsComposer$1$invokeSuspend$$inlined$withLock$lambda$1(continuation, this.this$0, this.$this_launch$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PtsComposerCache$preBuildPtsComposer$1$invokeSuspend$$inlined$withLock$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Function1 function1;
        int collectionSizeOrDefault;
        Function1 function12;
        int collectionSizeOrDefault2;
        Set set;
        List minus;
        List list;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            List list2 = (List) this.this$0.$oldListGenerator.invoke();
            List list3 = (List) this.this$0.$newListGenerator.invoke();
            List list4 = list2;
            function1 = this.this$0.this$0.keyGenerator;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list4.iterator();
            while (it.hasNext()) {
                arrayList.add(function1.invoke(it.next()));
            }
            List list5 = list3;
            function12 = this.this$0.this$0.keyGenerator;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator it5 = list5.iterator();
            while (it5.hasNext()) {
                arrayList2.add(function12.invoke(it5.next()));
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList2);
            minus = CollectionsKt___CollectionsKt.minus((Iterable) arrayList, (Iterable) set);
            PtsComposerCache$preBuildPtsComposer$1 ptsComposerCache$preBuildPtsComposer$1 = this.this$0;
            PtsComposerCache ptsComposerCache = ptsComposerCache$preBuildPtsComposer$1.this$0;
            String str = ptsComposerCache$preBuildPtsComposer$1.$pageName;
            this.L$0 = minus;
            this.label = 1;
            if (ptsComposerCache.f(list3, str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    list = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.this$0.this$0.k(list);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list6 = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
            minus = list6;
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
        this.L$0 = minus;
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        list = minus;
        this.this$0.this$0.k(list);
        return Unit.INSTANCE;
    }
}
