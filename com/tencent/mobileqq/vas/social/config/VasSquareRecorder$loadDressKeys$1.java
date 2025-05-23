package com.tencent.mobileqq.vas.social.config;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.vas.social.config.VasSquareRecorder", f = "VasSquareRecorder.kt", i = {}, l = {296}, m = "loadDressKeys", n = {}, s = {})
/* loaded from: classes35.dex */
public final class VasSquareRecorder$loadDressKeys$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VasSquareRecorder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasSquareRecorder$loadDressKeys$1(VasSquareRecorder vasSquareRecorder, Continuation<? super VasSquareRecorder$loadDressKeys$1> continuation) {
        super(continuation);
        this.this$0 = vasSquareRecorder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        c16 = this.this$0.c(null, this);
        return c16;
    }
}
