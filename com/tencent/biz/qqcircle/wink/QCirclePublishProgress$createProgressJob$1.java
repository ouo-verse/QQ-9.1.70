package com.tencent.biz.qqcircle.wink;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.biz.qqcircle.wink.QCirclePublishProgress$createProgressJob$1", f = "QCirclePublishProgress.kt", i = {0}, l = {107}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class QCirclePublishProgress$createProgressJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $taskId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCirclePublishProgress$createProgressJob$1(long j3, Continuation<? super QCirclePublishProgress$createProgressJob$1> continuation) {
        super(2, continuation);
        this.$taskId = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        QCirclePublishProgress$createProgressJob$1 qCirclePublishProgress$createProgressJob$1 = new QCirclePublishProgress$createProgressJob$1(this.$taskId, continuation);
        qCirclePublishProgress$createProgressJob$1.L$0 = obj;
        return qCirclePublishProgress$createProgressJob$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        ConcurrentHashMap concurrentHashMap;
        Job computeJob;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        }
        while (CoroutineScopeKt.isActive(coroutineScope)) {
            concurrentHashMap = QCirclePublishProgress.progressInfoMap;
            ProgressInfo progressInfo = (ProgressInfo) concurrentHashMap.get(Boxing.boxLong(this.$taskId));
            if (progressInfo != null) {
                progressInfo.q(progressInfo.getTick() + 1);
                progressInfo.a();
                if (progressInfo.getCurrProgress() >= 100.0d && (computeJob = progressInfo.getComputeJob()) != null) {
                    Job.DefaultImpls.cancel$default(computeJob, (CancellationException) null, 1, (Object) null);
                }
                QCirclePublishProgress.f93922d.l(progressInfo);
            }
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(200L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QCirclePublishProgress$createProgressJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
