package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import com.tencent.mobileqq.winkpublish.fs.request.QCirclePublishFeedRequest;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.PublishFeedFeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/PublishFeedFeat$b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.PublishFeedFeat$tryPublishFeedComplete$3", f = "PublishFeedFeat.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class PublishFeedFeat$tryPublishFeedComplete$3 extends SuspendLambda implements Function1<Continuation<? super PublishFeedFeat.PublishResponse>, Object> {
    final /* synthetic */ QCirclePublishFeedRequest $request;
    int label;
    final /* synthetic */ PublishFeedFeat this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishFeedFeat$tryPublishFeedComplete$3(PublishFeedFeat publishFeedFeat, QCirclePublishFeedRequest qCirclePublishFeedRequest, Continuation<? super PublishFeedFeat$tryPublishFeedComplete$3> continuation) {
        super(1, continuation);
        this.this$0 = publishFeedFeat;
        this.$request = qCirclePublishFeedRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PublishFeedFeat$tryPublishFeedComplete$3(this.this$0, this.$request, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            PublishFeedFeat publishFeedFeat = this.this$0;
            QCirclePublishFeedRequest qCirclePublishFeedRequest = this.$request;
            this.label = 1;
            obj = publishFeedFeat.m(qCirclePublishFeedRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PublishFeedFeat.PublishResponse> continuation) {
        return ((PublishFeedFeat$tryPublishFeedComplete$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
