package com.qzone.reborn.part.publish.fakefeed;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.qzone.reborn.part.publish.fakefeed.QZoneGetFakeFeedFeature", f = "QZoneGetFakeFeedFeature.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {110, 111}, m = "retryWithResult", n = {"predicate", "block", "attempt", "maxRetryTimes", "predicate", "block", "result", "attempt", "maxRetryTimes"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
/* loaded from: classes37.dex */
public final class QZoneGetFakeFeedFeature$retryWithResult$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QZoneGetFakeFeedFeature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneGetFakeFeedFeature$retryWithResult$1(QZoneGetFakeFeedFeature qZoneGetFakeFeedFeature, Continuation<? super QZoneGetFakeFeedFeature$retryWithResult$1> continuation) {
        super(continuation);
        this.this$0 = qZoneGetFakeFeedFeature;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, null, this);
    }
}
