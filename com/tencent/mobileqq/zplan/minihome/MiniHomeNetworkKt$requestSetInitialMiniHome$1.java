package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.MiniHomeNetworkKt", f = "MiniHomeNetwork.kt", i = {}, l = {150}, m = "requestSetInitialMiniHome", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MiniHomeNetworkKt$requestSetInitialMiniHome$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniHomeNetworkKt$requestSetInitialMiniHome$1(Continuation<? super MiniHomeNetworkKt$requestSetInitialMiniHome$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MiniHomeNetworkKt.l(null, this);
    }
}
