package com.tencent.hippykotlin.demo.pages.advertising_attribution;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.advertising_attribution.AdAttributionRepo", f = "AdAttributionRepo.kt", i = {}, l = {24}, m = "addAdAttributionData", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdAttributionRepo$addAdAttributionData$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AdAttributionRepo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdAttributionRepo$addAdAttributionData$1(AdAttributionRepo adAttributionRepo, Continuation<? super AdAttributionRepo$addAdAttributionData$1> continuation) {
        super(continuation);
        this.this$0 = adAttributionRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addAdAttributionData(null, this);
    }
}
