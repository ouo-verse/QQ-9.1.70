package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import com.tencent.mobileqq.winkpublish.report.PublishFeedErrorCode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/PublishFeedErrorCode;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.PublishFeedFeat$tryCheckFeedComplete$3", f = "PublishFeedFeat.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class PublishFeedFeat$tryCheckFeedComplete$3 extends SuspendLambda implements Function1<Continuation<? super PublishFeedErrorCode>, Object> {
    final /* synthetic */ long $createTime;
    final /* synthetic */ String $feedId;
    int label;
    final /* synthetic */ PublishFeedFeat this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishFeedFeat$tryCheckFeedComplete$3(PublishFeedFeat publishFeedFeat, String str, long j3, Continuation<? super PublishFeedFeat$tryCheckFeedComplete$3> continuation) {
        super(1, continuation);
        this.this$0 = publishFeedFeat;
        this.$feedId = str;
        this.$createTime = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PublishFeedFeat$tryCheckFeedComplete$3(this.this$0, this.$feedId, this.$createTime, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            PublishFeedFeat publishFeedFeat = this.this$0;
            String str = this.$feedId;
            long j3 = this.$createTime;
            this.label = 1;
            obj = publishFeedFeat.l(str, j3, this);
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
    public final Object invoke(Continuation<? super PublishFeedErrorCode> continuation) {
        return ((PublishFeedFeat$tryCheckFeedComplete$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
