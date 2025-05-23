package com.tencent.mobileqq.zplan.aigc.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper", f = "AIGCHelper.kt", i = {}, l = {218}, m = "fetchIblImage", n = {}, s = {})
/* loaded from: classes35.dex */
public final class AIGCHelper$fetchIblImage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIGCHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIGCHelper$fetchIblImage$1(AIGCHelper aIGCHelper, Continuation<? super AIGCHelper$fetchIblImage$1> continuation) {
        super(continuation);
        this.this$0 = aIGCHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(this);
    }
}
