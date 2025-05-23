package com.qzone.reborn.qqvideo.layer;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u000b\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.reborn.qqvideo.layer.QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$3", f = "QZoneGetQQVideoFeedFeature.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$3 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $feedId;
    int label;
    final /* synthetic */ QZoneGetQQVideoFeedFeature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$3(QZoneGetQQVideoFeedFeature qZoneGetQQVideoFeedFeature, String str, Continuation<? super QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$3> continuation) {
        super(1, continuation);
        this.this$0 = qZoneGetQQVideoFeedFeature;
        this.$feedId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$3(this.this$0, this.$feedId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QZoneGetQQVideoFeedFeature qZoneGetQQVideoFeedFeature = this.this$0;
            String str = this.$feedId;
            this.label = 1;
            obj = qZoneGetQQVideoFeedFeature.h(str, this);
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
    public final Object invoke(Continuation<? super Boolean> continuation) {
        return ((QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
