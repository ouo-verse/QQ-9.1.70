package com.tencent.mobileqq.zplan.emoticon.panel.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil", f = "ZPlanEmoticonUtil.kt", i = {0}, l = {798}, m = "toResourceParam2", n = {"originSingleRecordRequestParams"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonUtil$toResourceParam2$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanEmoticonUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonUtil$toResourceParam2$1(ZPlanEmoticonUtil zPlanEmoticonUtil, Continuation<? super ZPlanEmoticonUtil$toResourceParam2$1> continuation) {
        super(continuation);
        this.this$0 = zPlanEmoticonUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m06;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m06 = this.this$0.m0(null, null, null, null, 0, this);
        return m06;
    }
}
