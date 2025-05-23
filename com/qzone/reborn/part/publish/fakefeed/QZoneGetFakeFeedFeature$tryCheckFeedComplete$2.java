package com.qzone.reborn.part.publish.fakefeed;

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
import qzone.QZIntimateSpaceReader$GetFeedDetailRsp;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u008a@"}, d2 = {"", "attempt", "Lqzone/QZIntimateSpaceReader$GetFeedDetailRsp;", "rsp", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.reborn.part.publish.fakefeed.QZoneGetFakeFeedFeature$tryCheckFeedComplete$2", f = "QZoneGetFakeFeedFeature.kt", i = {}, l = {32, 34}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class QZoneGetFakeFeedFeature$tryCheckFeedComplete$2 extends SuspendLambda implements Function3<Integer, QZIntimateSpaceReader$GetFeedDetailRsp, Continuation<? super Boolean>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QZoneGetFakeFeedFeature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneGetFakeFeedFeature$tryCheckFeedComplete$2(QZoneGetFakeFeedFeature qZoneGetFakeFeedFeature, Continuation<? super QZoneGetFakeFeedFeature$tryCheckFeedComplete$2> continuation) {
        super(3, continuation);
        this.this$0 = qZoneGetFakeFeedFeature;
    }

    public final Object invoke(int i3, QZIntimateSpaceReader$GetFeedDetailRsp qZIntimateSpaceReader$GetFeedDetailRsp, Continuation<? super Boolean> continuation) {
        QZoneGetFakeFeedFeature$tryCheckFeedComplete$2 qZoneGetFakeFeedFeature$tryCheckFeedComplete$2 = new QZoneGetFakeFeedFeature$tryCheckFeedComplete$2(this.this$0, continuation);
        qZoneGetFakeFeedFeature$tryCheckFeedComplete$2.I$0 = i3;
        qZoneGetFakeFeedFeature$tryCheckFeedComplete$2.L$0 = qZIntimateSpaceReader$GetFeedDetailRsp;
        return qZoneGetFakeFeedFeature$tryCheckFeedComplete$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int h16;
        long i3;
        long g16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            int i17 = this.I$0;
            QZIntimateSpaceReader$GetFeedDetailRsp qZIntimateSpaceReader$GetFeedDetailRsp = (QZIntimateSpaceReader$GetFeedDetailRsp) this.L$0;
            this.this$0.checkFeedCount = i17;
            h16 = this.this$0.h();
            if (i17 < h16) {
                if ((qZIntimateSpaceReader$GetFeedDetailRsp != null ? qZIntimateSpaceReader$GetFeedDetailRsp.feed : null) == null) {
                    if (i17 == 0) {
                        g16 = this.this$0.g();
                        this.label = 1;
                        if (DelayKt.delay(g16, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        long j3 = i17;
                        i3 = this.this$0.i();
                        this.label = 2;
                        if (DelayKt.delay(j3 * i3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
            return Boxing.boxBoolean(false);
        }
        if (i16 != 1 && i16 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Boxing.boxBoolean(true);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Integer num, QZIntimateSpaceReader$GetFeedDetailRsp qZIntimateSpaceReader$GetFeedDetailRsp, Continuation<? super Boolean> continuation) {
        return invoke(num.intValue(), qZIntimateSpaceReader$GetFeedDetailRsp, continuation);
    }
}
