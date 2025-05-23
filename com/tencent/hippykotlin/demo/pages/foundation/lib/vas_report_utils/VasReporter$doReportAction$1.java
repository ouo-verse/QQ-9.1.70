package com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils;

import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasReporter;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasReporter$doReportAction$1", f = "VasReporter.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class VasReporter$doReportAction$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ int $deltaTime;
    public final /* synthetic */ int $durationTime;
    public final /* synthetic */ int $eventCode;
    public final /* synthetic */ long $now;
    public int label;
    public final /* synthetic */ VasReporter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/hippykotlin/demo/pages/foundation/lib/vas_report_utils/VasReporter;Ljava/lang/Object;JIILkotlin/coroutines/Continuation<-Lcom/tencent/hippykotlin/demo/pages/foundation/lib/vas_report_utils/VasReporter$doReportAction$1;>;)V */
    public VasReporter$doReportAction$1(VasReporter vasReporter, int i3, long j3, int i16, int i17, Continuation continuation) {
        super(2, continuation);
        this.this$0 = vasReporter;
        this.$eventCode = i3;
        this.$now = j3;
        this.$durationTime = i16;
        this.$deltaTime = i17;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VasReporter$doReportAction$1(this.this$0, this.$eventCode, this.$now, this.$durationTime, this.$deltaTime, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((VasReporter$doReportAction$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List<VasReportFullData> listOf;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                VasReporter.Companion companion = VasReporter.Companion;
                VasReporter vasReporter = this.this$0;
                String str = vasReporter.sessionId;
                String p16 = vasReporter.pager.getPageData().n().p("bundle_name");
                String pageName = this.this$0.pager.getPageName();
                String platform = companion.getPlatform();
                String appVersion = c.f117352a.g().getPageData().getAppVersion();
                String valueOf = String.valueOf(PageDataExtKt.getResVersion(this.this$0.pager.getPageData()));
                VasReporter vasReporter2 = this.this$0;
                VasReportFullData vasReportFullData = new VasReportFullData(this.$eventCode, this.$now, str, p16, pageName, platform, appVersion, valueOf, this.$durationTime, this.$deltaTime, vasReporter2.businessData);
                Function1<? super String, Unit> function1 = vasReporter2.logger;
                if (function1 == null) {
                    function1 = VasReporter$getLogger$1.INSTANCE;
                }
                this.label = 1;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(vasReportFullData);
                Object reportWeData = companion.reportWeData(listOf, function1, this);
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (reportWeData != coroutine_suspended2) {
                    reportWeData = Unit.INSTANCE;
                }
                if (reportWeData == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (this.$eventCode == 5) {
                this.this$0.lastReportHeartbeatTimestamp = this.$now;
            }
            return Unit.INSTANCE;
        } catch (Exception e16) {
            KLog.INSTANCE.e("VasReporter", "doReportAction exception, ex=" + e16);
            return Unit.INSTANCE;
        }
    }
}
