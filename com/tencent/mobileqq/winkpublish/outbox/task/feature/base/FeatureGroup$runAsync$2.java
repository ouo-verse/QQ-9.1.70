package com.tencent.mobileqq.winkpublish.outbox.task.feature.base;

import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup$runAsync$2", f = "FeatureGroup.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class FeatureGroup$runAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ List<a> $features;
    final /* synthetic */ TaskContext $taskContext;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeatureGroup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FeatureGroup$runAsync$2(List<? extends a> list, FeatureGroup featureGroup, TaskContext taskContext, Continuation<? super FeatureGroup$runAsync$2> continuation) {
        super(2, continuation);
        this.$features = list;
        this.this$0 = featureGroup;
        this.$taskContext = taskContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FeatureGroup$runAsync$2 featureGroup$runAsync$2 = new FeatureGroup$runAsync$2(this.$features, this.this$0, this.$taskContext, continuation);
        featureGroup$runAsync$2.L$0 = obj;
        return featureGroup$runAsync$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<Unit>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ArrayList arrayList = new ArrayList();
            List<a> list = this.$features;
            FeatureGroup featureGroup = this.this$0;
            TaskContext taskContext = this.$taskContext;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, CoroutineStart.LAZY, new FeatureGroup$runAsync$2$1$1(featureGroup, (a) it.next(), taskContext, null), 1, null);
                arrayList.add(async$default);
            }
            this.label = 1;
            obj = AwaitKt.awaitAll(arrayList, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Unit>> continuation) {
        return ((FeatureGroup$runAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
