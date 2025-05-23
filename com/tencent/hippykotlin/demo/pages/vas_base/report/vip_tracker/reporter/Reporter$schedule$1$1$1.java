package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.reporter;

import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportInfo;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.reporter.Reporter$schedule$1$1$1", f = "Reporter.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class Reporter$schedule$1$1$1 extends SuspendLambda implements Function2<b, Continuation<? super e>, Object> {
    public final /* synthetic */ List<ReportInfo> $it;
    public int label;
    public final /* synthetic */ Reporter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Reporter$schedule$1$1$1(Reporter reporter, List<ReportInfo> list, Continuation<? super Reporter$schedule$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = reporter;
        this.$it = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Reporter$schedule$1$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super e> continuation) {
        return ((Reporter$schedule$1$1$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Reporter reporter = this.this$0;
            List<ReportInfo> list = this.$it;
            this.label = 1;
            obj = Reporter.access$send(reporter, list, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
