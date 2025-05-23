package com.tencent.mobileqq.zplan.easteregg.recent;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.easteregg.recent.ZPlanRecentHeadEffectProcessor", f = "ZPlanRecentHeadEffectProcessor.kt", i = {0}, l = {507}, m = "checkMessage", n = {PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class ZPlanRecentHeadEffectProcessor$checkMessage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanRecentHeadEffectProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanRecentHeadEffectProcessor$checkMessage$1(ZPlanRecentHeadEffectProcessor zPlanRecentHeadEffectProcessor, Continuation<? super ZPlanRecentHeadEffectProcessor$checkMessage$1> continuation) {
        super(continuation);
        this.this$0 = zPlanRecentHeadEffectProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object p16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        p16 = this.this$0.p(null, this);
        return p16;
    }
}
