package com.tencent.mobileqq.zplan.meme.prerecord;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.meme.prerecord.ZPlanPreRecordManager", f = "ZPlanPreRecordManager.kt", i = {0, 0}, l = {225, 240, 249}, m = "preRecordShareActions", n = {"priority", "app"}, s = {"L$0", "L$1"})
/* loaded from: classes34.dex */
public final class ZPlanPreRecordManager$preRecordShareActions$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanPreRecordManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanPreRecordManager$preRecordShareActions$1(ZPlanPreRecordManager zPlanPreRecordManager, Continuation<? super ZPlanPreRecordManager$preRecordShareActions$1> continuation) {
        super(continuation);
        this.this$0 = zPlanPreRecordManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m3 = this.this$0.m(null, null, this);
        return m3;
    }
}
