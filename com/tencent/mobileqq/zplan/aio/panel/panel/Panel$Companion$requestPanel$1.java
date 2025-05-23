package com.tencent.mobileqq.zplan.aio.panel.panel;

import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.panel.Panel$Companion", f = "Panel.kt", i = {0, 1, 1}, l = {102, 114}, m = "requestPanel", n = {"builders", "builders", "destination$iv$iv"}, s = {"L$0", "L$0", "L$2"})
/* loaded from: classes35.dex */
public final class Panel$Companion$requestPanel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Panel.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Panel$Companion$requestPanel$1(Panel.Companion companion, Continuation<? super Panel$Companion$requestPanel$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object l3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        l3 = this.this$0.l(0, null, false, false, this);
        return l3;
    }
}
