package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.reporter;

import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.LaunchTimestamps;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.kelper.Kelper;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.KRequest;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Method;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportAction;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportAddition;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportInfo;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportItem;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportPageInfo;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceHelper;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceInfo;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Reporter implements c {
    public static final KRequest requester;
    public final String appId;
    public final TraceInfo baseTraceInfo;
    public final String pageId;
    public boolean waiting;
    public int state = 1;
    public final List<ReportPageInfo> queue = new ArrayList();
    public TraceInfo traceInfo = new TraceInfo(null, null, null, 0, 15, null);

    static {
        Function3<RequestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, Continuation<? super Response>, Object> function3;
        KRequest kRequest = new KRequest(null, 1, null);
        if (Kelper.canIUse) {
            function3 = Kelper.debugMiddleware;
        } else {
            function3 = Kelper.releaseMiddleware;
        }
        requester = kRequest.use(function3);
    }

    public Reporter(String str, String str2, TraceInfo traceInfo) {
        this.appId = str;
        this.pageId = str2;
        this.baseTraceInfo = traceInfo;
        com.tencent.kuikly.core.manager.c.f117352a.g().addPagerEventObserver(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object access$send(Reporter reporter, final List list, Continuation continuation) {
        Reporter$send$1 reporter$send$1;
        Object coroutine_suspended;
        int i3;
        Response response;
        reporter.getClass();
        if (continuation instanceof Reporter$send$1) {
            reporter$send$1 = (Reporter$send$1) continuation;
            int i16 = reporter$send$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                reporter$send$1.label = i16 - Integer.MIN_VALUE;
                Object obj = reporter$send$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = reporter$send$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    e eVar = new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.reporter.Reporter$send$params$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar2) {
                            e eVar3 = eVar2;
                            eVar3.z("type", 1);
                            eVar3.z("user_comm_report", ReportAddition.addition);
                            eVar3.A("report_infos", list);
                            return Unit.INSTANCE;
                        }
                    });
                    KRequest kRequest = requester;
                    RequestConfig requestConfig = new RequestConfig("https://h5.qzone.qq.com/report/action?contenttype=json", null, null, null, eVar, 6, null, 926);
                    reporter$send$1.label = 1;
                    kRequest.getClass();
                    requestConfig.method = Method.POST;
                    obj = kRequest.request(requestConfig, reporter$send$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                response = (Response) obj;
                if (response.status == 200) {
                    return new e();
                }
                e m3 = response.data.m("data");
                return m3 == null ? new e() : m3;
            }
        }
        reporter$send$1 = new Reporter$send$1(reporter, continuation);
        Object obj2 = reporter$send$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = reporter$send$1.label;
        if (i3 != 0) {
        }
        response = (Response) obj2;
        if (response.status == 200) {
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
        if (str == Pager.PAGER_EVENT_WILL_DESTROY) {
            this.state = 3;
            schedule();
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportPageInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportPageInfo>, java.lang.Iterable, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportPageInfo>, java.util.ArrayList] */
    public final void schedule() {
        int collectionSizeOrDefault;
        List windowed;
        if (this.queue.isEmpty()) {
            return;
        }
        ?? r06 = this.queue;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(r06, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = r06.iterator();
        while (it.hasNext()) {
            arrayList.add(new ReportInfo((ReportPageInfo) it.next(), this.traceInfo, 0));
        }
        windowed = CollectionsKt___CollectionsKt.windowed(arrayList, 10, 10, true);
        BuildersKt.e(VasBasePage.Companion.getCtx().getPageScope(), null, null, new Reporter$schedule$1(windowed, this, null), 3, null);
        this.waiting = false;
        this.queue.clear();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportPageInfo>, java.util.ArrayList] */
    public final void reportAction(ReportAction reportAction, String str, String str2, String str3, String str4, e eVar, e eVar2, String str5) {
        long j3;
        List listOf;
        String str6;
        String str7;
        if (!eVar.a("page_state")) {
            if (VasUIToken.INSTANCE.isDarkMode()) {
                str7 = "2";
            } else {
                str7 = "1";
            }
            eVar.v("page_state", str7);
        }
        if (!eVar.a(MiniAppPlugin.ATTR_PAGE_TYPE)) {
            eVar.v(MiniAppPlugin.ATTR_PAGE_TYPE, "kuikly");
        }
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        eVar.u("kuikly_res_version", PageDataExtKt.getResVersion(cVar.g().getPageData()));
        eVar.v("vas_pg", cVar.g().getPageName());
        if (reportAction.f114311id == 100) {
            VasBasePage ctx = VasBasePage.Companion.getCtx();
            VasBasePage.PagePerfReport pagePerfReport = ctx._perfReport;
            long j16 = pagePerfReport.firstScreenShowedTime;
            if (j16 <= 0) {
                j16 = pagePerfReport.viewDidLoadTime;
            }
            LaunchTimestamps launchTimestamps = ctx.launchTimestamps;
            if (launchTimestamps != null) {
                j3 = launchTimestamps.openPage;
            } else {
                j3 = ctx.createTime;
            }
            int i3 = (int) (j16 - j3);
            if (i3 > 6000) {
                i3 = 6000;
            }
            if (i3 > 0) {
                eVar.t("vas_timecost", i3);
            }
            TraceInfo traceInfo = this.baseTraceInfo;
            if (traceInfo == null) {
                TraceHelper traceHelper = TraceHelper.INSTANCE;
                String traceDetailFromPageParams = traceHelper.getTraceDetailFromPageParams();
                e eVar3 = new e();
                if (traceDetailFromPageParams.length() > 0) {
                    eVar3 = traceHelper.decodeTraceDetail(traceDetailFromPageParams);
                }
                String enteranceId = traceHelper.getEnteranceId();
                if (enteranceId.length() > 0) {
                    eVar3.v("enteranceId", enteranceId);
                }
                String p16 = cVar.g().getPageData().n().p("trace_id");
                String lowerCase = "traceIndex".toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"trace_index", "traceIndex", lowerCase});
                Iterator it = listOf.iterator();
                while (true) {
                    if (it.hasNext()) {
                        str6 = com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().n().p((String) it.next());
                        if (str6.length() > 0) {
                            break;
                        }
                    } else {
                        str6 = "";
                        break;
                    }
                }
                traceInfo = new TraceInfo(p16, eVar3, str6, com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().n().j("trace_num"));
            }
            BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new Reporter$expose$1(traceInfo, this, reportAction, eVar, null), 3, null);
            return;
        }
        this.queue.add(new ReportPageInfo(this.appId, this.pageId, new ReportItem(reportAction, str, str3, str4, eVar, str2, eVar2, str5)));
        int i16 = this.state;
        if (i16 == 3) {
            schedule();
        } else {
            if (i16 == 1 || this.waiting) {
                return;
            }
            this.waiting = true;
            TimerKt.d(300, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.reporter.Reporter$add$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    Reporter.this.schedule();
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
