package com.tencent.mobileqq.zplan.servlet;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.servlet.ZPlanCoupleAvatarRequest", f = "ZPlanCoupleAvatarRequest.kt", i = {0, 0}, l = {46}, m = "requestSetCoupleAvatarSwitch", n = {"switchInfo", "friendUin"}, s = {"L$0", "J$0"})
/* loaded from: classes34.dex */
public final class ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanCoupleAvatarRequest this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1(ZPlanCoupleAvatarRequest zPlanCoupleAvatarRequest, Continuation<? super ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1> continuation) {
        super(continuation);
        this.this$0 = zPlanCoupleAvatarRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(0L, null, this);
    }
}
