package com.tencent.mobileqq.winkpublish.outbox.task.feature.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.base.IFeatureKt", f = "IFeature.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {50, 51}, m = "retryWithResult", n = {"predicate", "block", "attempt", "maxRetryTimes", "predicate", "block", "result", "attempt", "maxRetryTimes"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
/* loaded from: classes35.dex */
public final class IFeatureKt$retryWithResult$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IFeatureKt$retryWithResult$1(Continuation<? super IFeatureKt$retryWithResult$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return IFeatureKt.b(null, null, this);
    }
}
