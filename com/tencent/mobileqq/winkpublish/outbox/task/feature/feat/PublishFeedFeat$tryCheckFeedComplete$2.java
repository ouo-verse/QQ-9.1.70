package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import com.tencent.mobileqq.winkpublish.report.PublishFeedErrorCode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"", "attempt", "Lcom/tencent/mobileqq/winkpublish/report/PublishFeedErrorCode;", "winkErrorCode", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.PublishFeedFeat$tryCheckFeedComplete$2", f = "PublishFeedFeat.kt", i = {}, l = {208, 210}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class PublishFeedFeat$tryCheckFeedComplete$2 extends SuspendLambda implements Function3<Integer, PublishFeedErrorCode, Continuation<? super Boolean>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PublishFeedFeat this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishFeedFeat$tryCheckFeedComplete$2(PublishFeedFeat publishFeedFeat, Continuation<? super PublishFeedFeat$tryCheckFeedComplete$2> continuation) {
        super(3, continuation);
        this.this$0 = publishFeedFeat;
    }

    public final Object invoke(int i3, PublishFeedErrorCode publishFeedErrorCode, Continuation<? super Boolean> continuation) {
        PublishFeedFeat$tryCheckFeedComplete$2 publishFeedFeat$tryCheckFeedComplete$2 = new PublishFeedFeat$tryCheckFeedComplete$2(this.this$0, continuation);
        publishFeedFeat$tryCheckFeedComplete$2.I$0 = i3;
        publishFeedFeat$tryCheckFeedComplete$2.L$0 = publishFeedErrorCode;
        return publishFeedFeat$tryCheckFeedComplete$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            int i16 = this.I$0;
            PublishFeedErrorCode publishFeedErrorCode = (PublishFeedErrorCode) this.L$0;
            this.this$0.checkFeedCount = i16;
            if (i16 >= 3 || publishFeedErrorCode.isOK()) {
                return Boxing.boxBoolean(false);
            }
            if (i16 == 0) {
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 2;
                if (DelayKt.delay(i16 * 2000, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i3 != 1 && i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(true);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Integer num, PublishFeedErrorCode publishFeedErrorCode, Continuation<? super Boolean> continuation) {
        return invoke(num.intValue(), publishFeedErrorCode, continuation);
    }
}
