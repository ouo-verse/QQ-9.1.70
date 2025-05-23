package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.reporter;

import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportInfo;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.b;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.reporter.Reporter$schedule$1", f = "Reporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class Reporter$schedule$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ List<List<ReportInfo>> $reportInfosList;
    public /* synthetic */ Object L$0;
    public final /* synthetic */ Reporter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Reporter$schedule$1(List<? extends List<ReportInfo>> list, Reporter reporter, Continuation<? super Reporter$schedule$1> continuation) {
        super(2, continuation);
        this.$reportInfosList = list;
        this.this$0 = reporter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Reporter$schedule$1 reporter$schedule$1 = new Reporter$schedule$1(this.$reportInfosList, this.this$0, continuation);
        reporter$schedule$1.L$0 = obj;
        return reporter$schedule$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((Reporter$schedule$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        b bVar = (b) this.L$0;
        List<List<ReportInfo>> list = this.$reportInfosList;
        Reporter reporter = this.this$0;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            BuildersKt.b(bVar, null, null, new Reporter$schedule$1$1$1(reporter, (List) it.next(), null), 3, null);
        }
        return Unit.INSTANCE;
    }
}
