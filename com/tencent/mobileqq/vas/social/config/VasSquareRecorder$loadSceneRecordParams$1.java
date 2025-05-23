package com.tencent.mobileqq.vas.social.config;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.vas.social.config.VasSquareRecorder", f = "VasSquareRecorder.kt", i = {0, 0, 0, 1, 1, 1}, l = {191, 194}, m = "loadSceneRecordParams", n = {"resource", "guestUin", "hostUin", "resource", "guestUin", "hostUin"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0"})
/* loaded from: classes35.dex */
public final class VasSquareRecorder$loadSceneRecordParams$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VasSquareRecorder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasSquareRecorder$loadSceneRecordParams$1(VasSquareRecorder vasSquareRecorder, Continuation<? super VasSquareRecorder$loadSceneRecordParams$1> continuation) {
        super(continuation);
        this.this$0 = vasSquareRecorder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        d16 = this.this$0.d(null, null, this);
        return d16;
    }
}
