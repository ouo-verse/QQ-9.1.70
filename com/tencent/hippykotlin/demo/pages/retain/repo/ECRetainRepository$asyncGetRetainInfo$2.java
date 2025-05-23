package com.tencent.hippykotlin.demo.pages.retain.repo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.retain.repo.ECRetainRepository", f = "ECRetainRepository.kt", i = {0}, l = {104}, m = "asyncGetRetainInfo", n = {"spuId"}, s = {"L$0"})
/* loaded from: classes33.dex */
public final class ECRetainRepository$asyncGetRetainInfo$2 extends ContinuationImpl {
    public String L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ECRetainRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECRetainRepository$asyncGetRetainInfo$2(ECRetainRepository eCRetainRepository, Continuation<? super ECRetainRepository$asyncGetRetainInfo$2> continuation) {
        super(continuation);
        this.this$0 = eCRetainRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        ECRetainRepository eCRetainRepository = this.this$0;
        ECRetainRepository eCRetainRepository2 = ECRetainRepository.INSTANCE;
        return eCRetainRepository.asyncGetRetainInfo(null, null, this);
    }
}
