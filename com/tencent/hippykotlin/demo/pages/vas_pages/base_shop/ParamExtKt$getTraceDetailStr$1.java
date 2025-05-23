package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop;

import com.tencent.hippykotlin.demo.pages.vas_base.krequest.URL;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceHelper;
import com.tencent.kuikly.core.manager.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes33.dex */
public final class ParamExtKt$getTraceDetailStr$1 extends Lambda implements Function0<String> {
    public static final ParamExtKt$getTraceDetailStr$1 INSTANCE = new ParamExtKt$getTraceDetailStr$1();

    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        String traceDetailFromPageParams = TraceHelper.INSTANCE.getTraceDetailFromPageParams();
        if (!(traceDetailFromPageParams.length() == 0)) {
            return traceDetailFromPageParams;
        }
        ?? r06 = new URL(c.f117352a.g().getPageData().n().q("url", "")).searchParams;
        String str = (String) r06.get("traceDetail");
        if (str != null) {
            return str;
        }
        String str2 = (String) r06.get("trace_detail");
        return str2 == null ? "" : str2;
    }

    public ParamExtKt$getTraceDetailStr$1() {
        super(0);
    }
}
