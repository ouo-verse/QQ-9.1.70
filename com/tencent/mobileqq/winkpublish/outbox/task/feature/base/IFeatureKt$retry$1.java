package com.tencent.mobileqq.winkpublish.outbox.task.feature.base;

import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.base.IFeatureKt", f = "IFeature.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {26, 30}, m = TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, n = {"predicate", "block", "attempt", "maxRetryTimes", "predicate", "block", "attempt", "maxRetryTimes"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"})
/* loaded from: classes35.dex */
public final class IFeatureKt$retry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IFeatureKt$retry$1(Continuation<? super IFeatureKt$retry$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return IFeatureKt.a(null, null, this);
    }
}
