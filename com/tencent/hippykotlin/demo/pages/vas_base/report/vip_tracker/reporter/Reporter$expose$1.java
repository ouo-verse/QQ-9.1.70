package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.reporter;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import com.tencent.hippykotlin.demo.pages.vas_base.SessionIdGenerator;
import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.MemoryTraceStore;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportAction;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportInfo;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportItem;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportPageInfo;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceInfo;
import com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLog;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.vas.spanend.IH5DataCacheApi;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.reporter.Reporter$expose$1", f = "Reporter.kt", i = {}, l = {112, 116, 138}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class Reporter$expose$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ReportAction $action;
    public final /* synthetic */ e $busiInfo;
    public final /* synthetic */ TraceInfo $trace;
    public int label;
    public final /* synthetic */ Reporter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Reporter$expose$1(TraceInfo traceInfo, Reporter reporter, ReportAction reportAction, e eVar, Continuation<? super Reporter$expose$1> continuation) {
        super(2, continuation);
        this.$trace = traceInfo;
        this.this$0 = reporter;
        this.$action = reportAction;
        this.$busiInfo = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Reporter$expose$1(this.$trace, this.this$0, this.$action, this.$busiInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((Reporter$expose$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0195 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x01a1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object obj2;
        Continuation intercepted;
        Object orThrow;
        Object coroutine_suspended2;
        TraceInfo traceInfo;
        List listOf;
        Object access$send;
        TraceInfo traceInfo2;
        String o16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$trace.index.length() == 0) {
                MemoryTraceStore memoryTraceStore = MemoryTraceStore.INSTANCE;
                this.label = 1;
                if (memoryTraceStore.getLocalStorageTrace().f114312id.length() > 0) {
                    obj2 = memoryTraceStore.getLocalStorageTrace();
                    MemoryTraceStore.localStorageTrace$delegate.setValue(memoryTraceStore, MemoryTraceStore.$$delegatedProperties[0], new TraceInfo(null, null, null, 0, 15, null));
                } else {
                    obj2 = null;
                }
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            Reporter reporter = this.this$0;
            traceInfo = this.$trace;
            if (traceInfo.f114312id.length() != 0) {
            }
            traceInfo.num = Math.max(traceInfo.num + 1, 1);
            reporter.traceInfo = traceInfo;
            Reporter reporter2 = this.this$0;
            ReportPageInfo reportPageInfo = new ReportPageInfo(reporter2.appId, reporter2.pageId, new ReportItem(this.$action, "", "", "", this.$busiInfo, "", new e(), ""));
            Reporter reporter3 = this.this$0;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new ReportInfo(reportPageInfo, reporter3.traceInfo, 0));
            this.label = 3;
            access$send = Reporter.access$send(reporter3, listOf, this);
            if (access$send == coroutine_suspended) {
            }
            com.tencent.kuikly.core.nvi.serialization.json.b l3 = ((e) access$send).l("trace_details");
            if (l3 != null) {
            }
            Reporter reporter4 = this.this$0;
            TraceInfo traceInfo3 = reporter4.traceInfo;
            if (o16 == null) {
            }
            traceInfo3.index = o16;
            traceInfo3.detail = null;
            reporter4.state = 2;
            reporter4.schedule();
            return Unit.INSTANCE;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    ResultKt.throwOnFailure(obj);
                    access$send = obj;
                    com.tencent.kuikly.core.nvi.serialization.json.b l36 = ((e) access$send).l("trace_details");
                    o16 = l36 != null ? l36.o(0) : null;
                    Reporter reporter42 = this.this$0;
                    TraceInfo traceInfo32 = reporter42.traceInfo;
                    if (o16 == null) {
                        o16 = "unknown";
                    }
                    traceInfo32.index = o16;
                    traceInfo32.detail = null;
                    reporter42.state = 2;
                    reporter42.schedule();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            orThrow = obj;
            traceInfo2 = (TraceInfo) orThrow;
            if (traceInfo2 != null) {
                this.$trace.merge(traceInfo2);
            }
            Reporter reporter5 = this.this$0;
            traceInfo = this.$trace;
            if (traceInfo.f114312id.length() != 0) {
                traceInfo.f114312id = SessionIdGenerator.INSTANCE.getSessionId();
            }
            traceInfo.num = Math.max(traceInfo.num + 1, 1);
            reporter5.traceInfo = traceInfo;
            Reporter reporter22 = this.this$0;
            ReportPageInfo reportPageInfo2 = new ReportPageInfo(reporter22.appId, reporter22.pageId, new ReportItem(this.$action, "", "", "", this.$busiInfo, "", new e(), ""));
            Reporter reporter32 = this.this$0;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new ReportInfo(reportPageInfo2, reporter32.traceInfo, 0));
            this.label = 3;
            access$send = Reporter.access$send(reporter32, listOf, this);
            if (access$send == coroutine_suspended) {
                return coroutine_suspended;
            }
            com.tencent.kuikly.core.nvi.serialization.json.b l362 = ((e) access$send).l("trace_details");
            if (l362 != null) {
            }
            Reporter reporter422 = this.this$0;
            TraceInfo traceInfo322 = reporter422.traceInfo;
            if (o16 == null) {
            }
            traceInfo322.index = o16;
            traceInfo322.detail = null;
            reporter422.state = 2;
            reporter422.schedule();
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        obj2 = obj;
        TraceInfo traceInfo4 = (TraceInfo) obj2;
        if (traceInfo4 != null) {
            this.$trace.merge(traceInfo4);
            Reporter reporter52 = this.this$0;
            traceInfo = this.$trace;
            if (traceInfo.f114312id.length() != 0) {
            }
            traceInfo.num = Math.max(traceInfo.num + 1, 1);
            reporter52.traceInfo = traceInfo;
            Reporter reporter222 = this.this$0;
            ReportPageInfo reportPageInfo22 = new ReportPageInfo(reporter222.appId, reporter222.pageId, new ReportItem(this.$action, "", "", "", this.$busiInfo, "", new e(), ""));
            Reporter reporter322 = this.this$0;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new ReportInfo(reportPageInfo22, reporter322.traceInfo, 0));
            this.label = 3;
            access$send = Reporter.access$send(reporter322, listOf, this);
            if (access$send == coroutine_suspended) {
            }
            com.tencent.kuikly.core.nvi.serialization.json.b l3622 = ((e) access$send).l("trace_details");
            if (l3622 != null) {
            }
            Reporter reporter4222 = this.this$0;
            TraceInfo traceInfo3222 = reporter4222.traceInfo;
            if (o16 == null) {
            }
            traceInfo3222.index = o16;
            traceInfo3222.detail = null;
            reporter4222.state = 2;
            reporter4222.schedule();
            return Unit.INSTANCE;
        }
        this.label = 2;
        QQUtils qQUtils = QQUtils.INSTANCE;
        if (qQUtils.compare("9.0.65") >= 0) {
            final VLog vLog = new VLog("TraceStore");
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            VasModule companion = VasModule.Companion.getInstance();
            Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.StorageTraceStore$getTrace$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2;
                    long a16;
                    String p16;
                    e eVar3 = eVar;
                    TraceInfo traceInfo5 = null;
                    final Integer valueOf = eVar3 != null ? Integer.valueOf(eVar3.j("ret")) : null;
                    if (valueOf == null || valueOf.intValue() != 0) {
                        VLog vLog2 = VLog.this;
                        String str = "Get trace failed: " + valueOf;
                        Function0<Boolean> function0 = new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.StorageTraceStore$getTrace$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                Integer num = valueOf;
                                return Boolean.valueOf(num == null || num.intValue() != -11);
                            }
                        };
                        VLog.Companion companion2 = VLog.Companion;
                        vLog2.getClass();
                        if (((Boolean) function0.invoke()).booleanValue()) {
                            vLog2.log$enumunboxing$(str, 3, true);
                        }
                        safeContinuation.resumeWith(Result.m476constructorimpl(null));
                    } else {
                        QQUtils qQUtils2 = QQUtils.INSTANCE;
                        if (qQUtils2.compare("9.0.65") >= 0) {
                            VasModule companion3 = VasModule.Companion.getInstance();
                            StorageTraceStore$clearTrace$1 storageTraceStore$clearTrace$1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.StorageTraceStore$clearTrace$1
                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(e eVar4) {
                                    return Unit.INSTANCE;
                                }
                            };
                            companion3.getClass();
                            if (qQUtils2.compare("9.0.65") >= 0) {
                                e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("host", "qq.com", "path", "/vip/tracker/sdk");
                                m3.v("key", "vt_lastest_trace_detail");
                                m3.w("delAllHostData", false);
                                Unit unit = Unit.INSTANCE;
                                companion3.toNative(false, IH5DataCacheApi.METHOD_DELETE_H5_DATA, m3.toString(), storageTraceStore$clearTrace$1, false);
                            }
                        }
                        try {
                            if (c.f117352a.g().getPageData().getIsAndroid()) {
                                p16 = UriKt.decodeURIComponent(eVar3.p("data"));
                            } else {
                                p16 = eVar3.p("data");
                            }
                            eVar2 = new e(p16);
                        } catch (JSONException e16) {
                            VLog vLog3 = VLog.this;
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Parse trace failed: ");
                            m16.append(e16.getMessage());
                            vLog3.log$enumunboxing$(m16.toString(), 3, true);
                            safeContinuation.resumeWith(Result.m476constructorimpl(null));
                            eVar2 = null;
                        }
                        if (eVar2 != null) {
                            VLog.this.log$enumunboxing$("Trace is " + eVar2, 1, true);
                            a16 = com.tencent.kuikly.core.module.b.c((com.tencent.kuikly.core.module.b) c.f117352a.g().acquireModule("KRCalendarModule"), 0L, 1, null).a();
                            if (a16 - eVar2.n("time") > 5000) {
                                safeContinuation.resumeWith(Result.m476constructorimpl(null));
                            } else {
                                e m17 = eVar2.m("trace");
                                Continuation<TraceInfo> continuation = safeContinuation;
                                if (m17 != null) {
                                    String q16 = m17.q("trace_id", m17.p("traceId"));
                                    String q17 = m17.q("trace_index", m17.p("traceIndex"));
                                    int k3 = m17.k("trace_num", m17.j("traceNum"));
                                    e m18 = m17.m("trace_detail");
                                    if (m18 == null && (m18 = m17.m("traceDetail")) == null) {
                                        m18 = new e();
                                    }
                                    traceInfo5 = new TraceInfo(q16, m18, q17, k3);
                                }
                                continuation.resumeWith(Result.m476constructorimpl(traceInfo5));
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            companion.getClass();
            if (!(qQUtils.compare("9.0.65") >= 0)) {
                if (!(PageDataExtKt.isTim(c.f117352a.g().getPageData()) && qQUtils.compare("4.0.95") >= 0)) {
                    function1.invoke(new e());
                    orThrow = safeContinuation.getOrThrow();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (orThrow == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(this);
                    }
                }
            }
            e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("host", "qq.com", "path", "/vip/tracker/sdk");
            m3.v("key", "vt_lastest_trace_detail");
            Unit unit = Unit.INSTANCE;
            companion.toNative(false, IH5DataCacheApi.METHOD_READ_H5_DATA, m3.toString(), function1, false);
            orThrow = safeContinuation.getOrThrow();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended2) {
            }
        } else {
            orThrow = null;
        }
        if (orThrow == coroutine_suspended) {
            return coroutine_suspended;
        }
        traceInfo2 = (TraceInfo) orThrow;
        if (traceInfo2 != null) {
        }
        Reporter reporter522 = this.this$0;
        traceInfo = this.$trace;
        if (traceInfo.f114312id.length() != 0) {
        }
        traceInfo.num = Math.max(traceInfo.num + 1, 1);
        reporter522.traceInfo = traceInfo;
        Reporter reporter2222 = this.this$0;
        ReportPageInfo reportPageInfo222 = new ReportPageInfo(reporter2222.appId, reporter2222.pageId, new ReportItem(this.$action, "", "", "", this.$busiInfo, "", new e(), ""));
        Reporter reporter3222 = this.this$0;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ReportInfo(reportPageInfo222, reporter3222.traceInfo, 0));
        this.label = 3;
        access$send = Reporter.access$send(reporter3222, listOf, this);
        if (access$send == coroutine_suspended) {
        }
        com.tencent.kuikly.core.nvi.serialization.json.b l36222 = ((e) access$send).l("trace_details");
        if (l36222 != null) {
        }
        Reporter reporter42222 = this.this$0;
        TraceInfo traceInfo32222 = reporter42222.traceInfo;
        if (o16 == null) {
        }
        traceInfo32222.index = o16;
        traceInfo32222.detail = null;
        reporter42222.state = 2;
        reporter42222.schedule();
        return Unit.INSTANCE;
    }
}
