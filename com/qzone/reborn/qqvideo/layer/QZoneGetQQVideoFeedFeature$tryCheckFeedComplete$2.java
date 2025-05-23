package com.qzone.reborn.qqvideo.layer;

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
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"", "attempt", "", "rsp", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.reborn.qqvideo.layer.QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$2", f = "QZoneGetQQVideoFeedFeature.kt", i = {}, l = {41, 43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$2 extends SuspendLambda implements Function3<Integer, Boolean, Continuation<? super Boolean>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ QZoneGetQQVideoFeedFeature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$2(QZoneGetQQVideoFeedFeature qZoneGetQQVideoFeedFeature, Continuation<? super QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$2> continuation) {
        super(3, continuation);
        this.this$0 = qZoneGetQQVideoFeedFeature;
    }

    public final Object invoke(int i3, boolean z16, Continuation<? super Boolean> continuation) {
        QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$2 qZoneGetQQVideoFeedFeature$tryCheckFeedComplete$2 = new QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$2(this.this$0, continuation);
        qZoneGetQQVideoFeedFeature$tryCheckFeedComplete$2.I$0 = i3;
        qZoneGetQQVideoFeedFeature$tryCheckFeedComplete$2.Z$0 = z16;
        return qZoneGetQQVideoFeedFeature$tryCheckFeedComplete$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int j3;
        long k3;
        long i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            int i17 = this.I$0;
            boolean z16 = this.Z$0;
            this.this$0.checkFeedCount = i17;
            j3 = this.this$0.j();
            if (i17 >= j3 || z16) {
                return Boxing.boxBoolean(false);
            }
            if (i17 == 0) {
                i3 = this.this$0.i();
                this.label = 1;
                if (DelayKt.delay(i3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                long j16 = i17;
                k3 = this.this$0.k();
                this.label = 2;
                if (DelayKt.delay(j16 * k3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i16 != 1 && i16 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(true);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Boolean bool, Continuation<? super Boolean> continuation) {
        return invoke(num.intValue(), bool.booleanValue(), continuation);
    }
}
