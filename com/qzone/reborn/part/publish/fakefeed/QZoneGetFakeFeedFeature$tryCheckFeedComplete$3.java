package com.qzone.reborn.part.publish.fakefeed;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import qzone.QZIntimateSpaceReader$GetFeedDetailRsp;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"Lqzone/QZIntimateSpaceReader$GetFeedDetailRsp;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.reborn.part.publish.fakefeed.QZoneGetFakeFeedFeature$tryCheckFeedComplete$3", f = "QZoneGetFakeFeedFeature.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class QZoneGetFakeFeedFeature$tryCheckFeedComplete$3 extends SuspendLambda implements Function1<Continuation<? super QZIntimateSpaceReader$GetFeedDetailRsp>, Object> {
    final /* synthetic */ long $createTime;
    final /* synthetic */ String $feedId;
    int label;
    final /* synthetic */ QZoneGetFakeFeedFeature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneGetFakeFeedFeature$tryCheckFeedComplete$3(QZoneGetFakeFeedFeature qZoneGetFakeFeedFeature, String str, long j3, Continuation<? super QZoneGetFakeFeedFeature$tryCheckFeedComplete$3> continuation) {
        super(1, continuation);
        this.this$0 = qZoneGetFakeFeedFeature;
        this.$feedId = str;
        this.$createTime = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new QZoneGetFakeFeedFeature$tryCheckFeedComplete$3(this.this$0, this.$feedId, this.$createTime, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QZoneGetFakeFeedFeature qZoneGetFakeFeedFeature = this.this$0;
            String str = this.$feedId;
            long j3 = this.$createTime;
            this.label = 1;
            obj = qZoneGetFakeFeedFeature.f(str, j3, this);
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
    public final Object invoke(Continuation<? super QZIntimateSpaceReader$GetFeedDetailRsp> continuation) {
        return ((QZoneGetFakeFeedFeature$tryCheckFeedComplete$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
