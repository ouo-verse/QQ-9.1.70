package com.tencent.ecommerce.biz.register;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@"}, d2 = {"Landroid/content/Context;", "context", "", "psKey", "userName", "idCardNum", "sessionId", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/biz/register/network/k;", "continuation", "", "faceVerify"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.register.ECInnerFaceVerification", f = "ECInnerFaceVerification.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2}, l = {61, 89, 118}, m = "faceVerify", n = {"this", "context", "userName", "idCardNum", "sessionId", "requestForFaceVerificationConfigStartTimeMs", "nonce", "this", "userName", "idCardNum", "sessionId", "nonce", "startFaceVerificationStartTimeMs", "this", "verifyResultStartTimeMs"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "L$0", "J$0"})
/* loaded from: classes31.dex */
public final class ECInnerFaceVerification$faceVerify$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECInnerFaceVerification this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECInnerFaceVerification$faceVerify$1(ECInnerFaceVerification eCInnerFaceVerification, Continuation continuation) {
        super(continuation);
        this.this$0 = eCInnerFaceVerification;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, null, this);
    }
}
