package com.tencent.hippykotlin.demo.pages.vas_base;

import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasReporter;
import com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLog;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.manager.c;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$vasReport$1", f = "VasBasePage.kt", i = {}, l = {756}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class VasBasePage$vasReport$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ VasBasePage $pager;
    public int label;
    public final /* synthetic */ VasBasePage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasBasePage$vasReport$1(VasBasePage vasBasePage, VasBasePage vasBasePage2, Continuation<? super VasBasePage$vasReport$1> continuation) {
        super(2, continuation);
        this.this$0 = vasBasePage;
        this.$pager = vasBasePage2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VasBasePage$vasReport$1(this.this$0, this.$pager, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((VasBasePage$vasReport$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            VasBasePage vasBasePage = this.this$0;
            this.label = 1;
            vasBasePage.getClass();
            if (coroutine_suspended == null) {
                return coroutine_suspended;
            }
            obj = null;
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        VasBusinessReportData vasBusinessReportData = (VasBusinessReportData) obj;
        if (vasBusinessReportData != null) {
            new VasReporter(this.$pager, vasBusinessReportData, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$vasReport$1.1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(String str) {
                    String str2 = str;
                    if (!PageDataExtKt.isPublic(c.f117352a.g().getPageData())) {
                        VLog.Companion.getInstance().log$enumunboxing$(str2, 1, true);
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        return Unit.INSTANCE;
    }
}
