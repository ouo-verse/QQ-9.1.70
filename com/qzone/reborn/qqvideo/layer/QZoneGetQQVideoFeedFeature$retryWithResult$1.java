package com.qzone.reborn.qqvideo.layer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.qzone.reborn.qqvideo.layer.QZoneGetQQVideoFeedFeature", f = "QZoneGetQQVideoFeedFeature.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {135, 136}, m = "retryWithResult", n = {"predicate", "block", "attempt", "maxRetryTimes", "predicate", "block", "result", "attempt", "maxRetryTimes"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
/* loaded from: classes37.dex */
public final class QZoneGetQQVideoFeedFeature$retryWithResult$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QZoneGetQQVideoFeedFeature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneGetQQVideoFeedFeature$retryWithResult$1(QZoneGetQQVideoFeedFeature qZoneGetQQVideoFeedFeature, Continuation<? super QZoneGetQQVideoFeedFeature$retryWithResult$1> continuation) {
        super(continuation);
        this.this$0 = qZoneGetQQVideoFeedFeature;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m3 = this.this$0.m(null, null, this);
        return m3;
    }
}
