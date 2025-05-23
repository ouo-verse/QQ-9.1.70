package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.reporter;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.reporter.Reporter", f = "Reporter.kt", i = {}, l = {202}, m = "send", n = {}, s = {})
/* loaded from: classes33.dex */
public final class Reporter$send$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Reporter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Reporter$send$1(Reporter reporter, Continuation<? super Reporter$send$1> continuation) {
        super(continuation);
        this.this$0 = reporter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Reporter.access$send(this.this$0, null, this);
    }
}
