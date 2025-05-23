package com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils;

import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.b;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasReporter$reportHeartbeat$1", f = "VasReporter.kt", i = {0, 0, 0}, l = {161}, m = "invokeSuspend", n = {"$this$launch", "lastOne", "$this$forEach$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes31.dex */
public final class VasReporter$reportHeartbeat$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public int I$0;
    public int I$1;
    public /* synthetic */ Object L$0;
    public Ref.IntRef L$1;
    public int[] L$2;
    public VasReporter L$3;
    public int label;
    public final /* synthetic */ VasReporter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasReporter$reportHeartbeat$1(VasReporter vasReporter, Continuation<? super VasReporter$reportHeartbeat$1> continuation) {
        super(2, continuation);
        this.this$0 = vasReporter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VasReporter$reportHeartbeat$1 vasReporter$reportHeartbeat$1 = new VasReporter$reportHeartbeat$1(this.this$0, continuation);
        vasReporter$reportHeartbeat$1.L$0 = obj;
        return vasReporter$reportHeartbeat$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((VasReporter$reportHeartbeat$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0080  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0054 -> B:9:0x00aa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0074 -> B:5:0x0079). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x008f -> B:9:0x00aa). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        VasReporter$reportHeartbeat$1 vasReporter$reportHeartbeat$1;
        b bVar;
        int length;
        Ref.IntRef intRef;
        int i3;
        int[] iArr;
        VasReporter vasReporter;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            b bVar2 = (b) this.L$0;
            Ref.IntRef intRef2 = new Ref.IntRef();
            int[] iArr2 = VasReporter.STAY_ARRAY_DEFAULT;
            VasReporter vasReporter2 = this.this$0;
            vasReporter$reportHeartbeat$1 = this;
            bVar = bVar2;
            length = iArr2.length;
            intRef = intRef2;
            i3 = 0;
            iArr = iArr2;
            vasReporter = vasReporter2;
            if (i3 < length) {
            }
        } else if (i16 == 1) {
            length = this.I$1;
            i3 = this.I$0;
            VasReporter vasReporter3 = this.L$3;
            int[] iArr3 = this.L$2;
            Ref.IntRef intRef3 = this.L$1;
            b bVar3 = (b) this.L$0;
            ResultKt.throwOnFailure(obj);
            VasReporter$reportHeartbeat$1 vasReporter$reportHeartbeat$12 = this;
            VasReporter vasReporter4 = vasReporter3;
            int[] iArr4 = iArr3;
            Ref.IntRef intRef4 = intRef3;
            b bVar4 = bVar3;
            if (!VasReporter.access$shouldStopReportHeartbeat(vasReporter4)) {
                vasReporter4.doReportAction$enumunboxing$(5, 0L, 0L);
            }
            vasReporter = vasReporter4;
            iArr = iArr4;
            intRef = intRef4;
            bVar = bVar4;
            vasReporter$reportHeartbeat$1 = vasReporter$reportHeartbeat$12;
            i3++;
            if (i3 < length) {
                int i17 = iArr[i3];
                if (!VasReporter.access$shouldStopReportHeartbeat(vasReporter)) {
                    int i18 = i17 - intRef.element;
                    intRef.element = i17;
                    if (i18 > 0) {
                        vasReporter$reportHeartbeat$1.L$0 = bVar;
                        vasReporter$reportHeartbeat$1.L$1 = intRef;
                        vasReporter$reportHeartbeat$1.L$2 = iArr;
                        vasReporter$reportHeartbeat$1.L$3 = vasReporter;
                        vasReporter$reportHeartbeat$1.I$0 = i3;
                        vasReporter$reportHeartbeat$1.I$1 = length;
                        vasReporter$reportHeartbeat$1.label = 1;
                        if (BuildersKt.c(bVar, i18, vasReporter$reportHeartbeat$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        vasReporter4 = vasReporter;
                        iArr4 = iArr;
                        intRef4 = intRef;
                        bVar4 = bVar;
                        vasReporter$reportHeartbeat$12 = vasReporter$reportHeartbeat$1;
                        if (!VasReporter.access$shouldStopReportHeartbeat(vasReporter4)) {
                        }
                        vasReporter = vasReporter4;
                        iArr = iArr4;
                        intRef = intRef4;
                        bVar = bVar4;
                        vasReporter$reportHeartbeat$1 = vasReporter$reportHeartbeat$12;
                    } else {
                        vasReporter.debugLog("interval=" + i18 + " is invalid!");
                    }
                }
                i3++;
                if (i3 < length) {
                    return Unit.INSTANCE;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
