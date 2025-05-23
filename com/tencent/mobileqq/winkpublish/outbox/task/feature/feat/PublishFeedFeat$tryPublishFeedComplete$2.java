package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.PublishFeedFeat;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"", "attempt", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/PublishFeedFeat$b;", "winkErrorCode", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.PublishFeedFeat$tryPublishFeedComplete$2", f = "PublishFeedFeat.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class PublishFeedFeat$tryPublishFeedComplete$2 extends SuspendLambda implements Function3<Integer, PublishFeedFeat.PublishResponse, Continuation<? super Boolean>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PublishFeedFeat this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishFeedFeat$tryPublishFeedComplete$2(PublishFeedFeat publishFeedFeat, Continuation<? super PublishFeedFeat$tryPublishFeedComplete$2> continuation) {
        super(3, continuation);
        this.this$0 = publishFeedFeat;
    }

    public final Object invoke(int i3, PublishFeedFeat.PublishResponse publishResponse, Continuation<? super Boolean> continuation) {
        PublishFeedFeat$tryPublishFeedComplete$2 publishFeedFeat$tryPublishFeedComplete$2 = new PublishFeedFeat$tryPublishFeedComplete$2(this.this$0, continuation);
        publishFeedFeat$tryPublishFeedComplete$2.I$0 = i3;
        publishFeedFeat$tryPublishFeedComplete$2.L$0 = publishResponse;
        return publishFeedFeat$tryPublishFeedComplete$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int i3 = this.I$0;
            PublishFeedFeat.PublishResponse publishResponse = (PublishFeedFeat.PublishResponse) this.L$0;
            this.this$0.publishFeedCount = i3;
            if (i3 < 1 && publishResponse.getRetCode() == WinkBaseErrorCodeKt.ERROR_REQUEST_TIMEOUT) {
                return Boxing.boxBoolean(true);
            }
            return Boxing.boxBoolean(false);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Integer num, PublishFeedFeat.PublishResponse publishResponse, Continuation<? super Boolean> continuation) {
        return invoke(num.intValue(), publishResponse, continuation);
    }
}
