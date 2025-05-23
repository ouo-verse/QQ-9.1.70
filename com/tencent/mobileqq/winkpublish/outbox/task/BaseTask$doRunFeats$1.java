package com.tencent.mobileqq.winkpublish.outbox.task;

import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.BaseTask", f = "BaseTask.kt", i = {0, 0, 0, 0}, l = {PlayUI.UIType.BIG_CARD_SHAPED_PIC}, m = "doRunFeats", n = {"this", "headFeat", "expectState", "shouldRetry"}, s = {"L$0", "L$1", "I$0", "I$1"})
/* loaded from: classes35.dex */
public final class BaseTask$doRunFeats$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTask$doRunFeats$1(BaseTask baseTask, Continuation<? super BaseTask$doRunFeats$1> continuation) {
        super(continuation);
        this.this$0 = baseTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object q16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        q16 = this.this$0.q(this);
        return q16;
    }
}
