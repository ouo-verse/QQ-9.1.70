package com.tencent.mobileqq.zplan.emoticon.panel.util;

import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.zplan.meme.Priority;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1$1$1", f = "ZPlanEmoticonUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<com.tencent.mobileqq.qcoroutine.api.coroutine.b> $job;
    final /* synthetic */ List<ZPlanActionInfo> $limitRecordList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1$1$1(List<ZPlanActionInfo> list, Ref.ObjectRef<com.tencent.mobileqq.qcoroutine.api.coroutine.b> objectRef, Continuation<? super ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1$1$1> continuation) {
        super(2, continuation);
        this.$limitRecordList = list;
        this.$job = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1$1$1(this.$limitRecordList, this.$job, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Job a16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanEmoticonUtil.Q(ZPlanEmoticonUtil.f333176e, this.$limitRecordList, Priority.MIDDLE, null, 1, true, 4, null);
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.$job.element;
            if (bVar == null || (a16 = bVar.a()) == null) {
                return null;
            }
            Job.DefaultImpls.cancel$default(a16, (CancellationException) null, 1, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEmoticonUtil$requireZPlanActionsAndRecord$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
