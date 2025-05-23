package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.MiniHomeNetworkKt", f = "MiniHomeNetwork.kt", i = {0}, l = {287}, m = "requestGetActionPanel", n = {"rsp$iv"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class MiniHomeNetworkKt$requestGetActionPanel$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniHomeNetworkKt$requestGetActionPanel$1(Continuation<? super MiniHomeNetworkKt$requestGetActionPanel$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MiniHomeNetworkKt.b(this);
    }
}
