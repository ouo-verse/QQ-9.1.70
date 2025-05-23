package com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils;

import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasReporter;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasReporter$Companion", f = "VasReporter.kt", i = {0, 0, 0}, l = {383}, m = "reportWeData", n = {"this", "reportList", "logger"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes31.dex */
public final class VasReporter$Companion$reportWeData$2 extends ContinuationImpl {
    public VasReporter.Companion L$0;
    public List L$1;
    public Function1 L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ VasReporter.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasReporter$Companion$reportWeData$2(VasReporter.Companion companion, Continuation<? super VasReporter$Companion$reportWeData$2> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.reportWeData(null, null, this);
    }
}
