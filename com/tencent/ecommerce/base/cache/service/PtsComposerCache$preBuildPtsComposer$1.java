package com.tencent.ecommerce.base.cache.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "DataType", "KeyType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.cache.service.PtsComposerCache$preBuildPtsComposer$1", f = "PtsComposerCache.kt", i = {0, 0, 1, 1}, l = {195, 122}, m = "invokeSuspend", n = {"$this$launch", "$this$withLock$iv", "$this$launch", "$this$withLock$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes32.dex */
public final class PtsComposerCache$preBuildPtsComposer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $newListGenerator;
    final /* synthetic */ Function0 $oldListGenerator;
    final /* synthetic */ String $pageName;
    final /* synthetic */ Function0 $processor;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PtsComposerCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PtsComposerCache$preBuildPtsComposer$1(PtsComposerCache ptsComposerCache, Function0 function0, Function0 function02, String str, Function0 function03, Continuation continuation) {
        super(2, continuation);
        this.this$0 = ptsComposerCache;
        this.$oldListGenerator = function0;
        this.$newListGenerator = function02;
        this.$pageName = str;
        this.$processor = function03;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PtsComposerCache$preBuildPtsComposer$1 ptsComposerCache$preBuildPtsComposer$1 = new PtsComposerCache$preBuildPtsComposer$1(this.this$0, this.$oldListGenerator, this.$newListGenerator, this.$pageName, this.$processor, continuation);
        ptsComposerCache$preBuildPtsComposer$1.L$0 = obj;
        return ptsComposerCache$preBuildPtsComposer$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PtsComposerCache$preBuildPtsComposer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        Mutex mutex;
        Mutex mutex2;
        Job job;
        CoroutineScope coroutineScope2;
        Job job2;
        CoroutineScope coroutineScope3;
        Job launch$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                mutex = this.this$0.lastJobMutex;
                this.L$0 = coroutineScope;
                this.L$1 = mutex;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        mutex2 = (Mutex) this.L$1;
                        coroutineScope3 = (CoroutineScope) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            coroutineScope2 = coroutineScope3;
                            PtsComposerCache ptsComposerCache = this.this$0;
                            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new PtsComposerCache$preBuildPtsComposer$1$invokeSuspend$$inlined$withLock$lambda$1(null, this, coroutineScope2), 3, null);
                            ptsComposerCache.lastJob = launch$default;
                            Unit unit = Unit.INSTANCE;
                            mutex2.unlock(null);
                            return Unit.INSTANCE;
                        } catch (Throwable th5) {
                            th = th5;
                            mutex2.unlock(null);
                            throw th;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex = (Mutex) this.L$1;
                CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope = coroutineScope4;
            }
            job = this.this$0.lastJob;
            if (job.isActive()) {
                job2 = this.this$0.lastJob;
                this.L$0 = coroutineScope;
                this.L$1 = mutex;
                this.label = 2;
                if (JobKt.cancelAndJoin(job2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex;
                coroutineScope3 = coroutineScope;
                coroutineScope2 = coroutineScope3;
                PtsComposerCache ptsComposerCache2 = this.this$0;
                launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new PtsComposerCache$preBuildPtsComposer$1$invokeSuspend$$inlined$withLock$lambda$1(null, this, coroutineScope2), 3, null);
                ptsComposerCache2.lastJob = launch$default;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            }
            coroutineScope2 = coroutineScope;
            mutex2 = mutex;
            PtsComposerCache ptsComposerCache22 = this.this$0;
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new PtsComposerCache$preBuildPtsComposer$1$invokeSuspend$$inlined$withLock$lambda$1(null, this, coroutineScope2), 3, null);
            ptsComposerCache22.lastJob = launch$default;
            Unit unit22 = Unit.INSTANCE;
            mutex2.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th6) {
            th = th6;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }
}
