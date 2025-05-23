package com.tencent.mobileqq.zplan.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.utils.SknNetworkUtilKt$retryIfFailed$1", f = "SknNetworkUtil.kt", i = {0, 0, 0, 1, 1, 1}, l = {44, 52}, m = "invoke", n = {"this", "req", "t", "this", "req", "t"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
/* loaded from: classes34.dex */
public final class SknNetworkUtilKt$retryIfFailed$1$invoke$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SknNetworkUtilKt$retryIfFailed$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SknNetworkUtilKt$retryIfFailed$1$invoke$1(SknNetworkUtilKt$retryIfFailed$1 sknNetworkUtilKt$retryIfFailed$1, Continuation<? super SknNetworkUtilKt$retryIfFailed$1$invoke$1> continuation) {
        super(continuation);
        this.this$0 = sknNetworkUtilKt$retryIfFailed$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
