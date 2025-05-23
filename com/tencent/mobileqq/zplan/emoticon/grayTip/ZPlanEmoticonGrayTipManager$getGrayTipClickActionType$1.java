package com.tencent.mobileqq.zplan.emoticon.grayTip;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.grayTip.ZPlanEmoticonGrayTipManager", f = "ZPlanEmoticonGrayTipManager.kt", i = {0}, l = {189}, m = "getGrayTipClickActionType", n = {"this"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonGrayTipManager$getGrayTipClickActionType$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanEmoticonGrayTipManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonGrayTipManager$getGrayTipClickActionType$1(ZPlanEmoticonGrayTipManager zPlanEmoticonGrayTipManager, Continuation<? super ZPlanEmoticonGrayTipManager$getGrayTipClickActionType$1> continuation) {
        super(continuation);
        this.this$0 = zPlanEmoticonGrayTipManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        b16 = this.this$0.b(this);
        return b16;
    }
}
