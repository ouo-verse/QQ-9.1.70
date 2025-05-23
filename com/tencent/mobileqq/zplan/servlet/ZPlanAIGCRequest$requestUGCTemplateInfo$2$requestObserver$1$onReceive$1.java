package com.tencent.mobileqq.zplan.servlet;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import uv4.ac;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest$requestUGCTemplateInfo$2$requestObserver$1$onReceive$1", f = "ZPlanAIGCRequest.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class ZPlanAIGCRequest$requestUGCTemplateInfo$2$requestObserver$1$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $apiMethod;
    final /* synthetic */ byte[] $data;
    final /* synthetic */ int $gender;
    final /* synthetic */ Ref.ObjectRef<ac> $rsp;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAIGCRequest$requestUGCTemplateInfo$2$requestObserver$1$onReceive$1(String str, int i3, Ref.ObjectRef<ac> objectRef, byte[] bArr, Continuation<? super ZPlanAIGCRequest$requestUGCTemplateInfo$2$requestObserver$1$onReceive$1> continuation) {
        super(2, continuation);
        this.$apiMethod = str;
        this.$gender = i3;
        this.$rsp = objectRef;
        this.$data = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanAIGCRequest$requestUGCTemplateInfo$2$requestObserver$1$onReceive$1(this.$apiMethod, this.$gender, this.$rsp, this.$data, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            com.tencent.mobileqq.zplan.aigc.helper.h hVar = com.tencent.mobileqq.zplan.aigc.helper.h.f330325a;
            String str = this.$apiMethod + this.$gender;
            String str2 = this.$rsp.element.f440114c;
            Intrinsics.checkNotNullExpressionValue(str2, "rsp.seq");
            if (hVar.q(str, str2, this.$data)) {
                hVar.p("gender", String.valueOf(this.$gender));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanAIGCRequest$requestUGCTemplateInfo$2$requestObserver$1$onReceive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
