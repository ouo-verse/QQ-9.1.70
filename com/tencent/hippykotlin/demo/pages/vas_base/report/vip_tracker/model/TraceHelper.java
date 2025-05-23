package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.URL;
import com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.d;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class TraceHelper {
    public static final TraceHelper INSTANCE = new TraceHelper();
    public static final VLog log = new VLog("VipTracker:ReportTrace");

    public final e decodeTraceDetail(String str) {
        String replace$default;
        boolean contains$default;
        CharSequence trim;
        String replace$default2;
        replace$default = StringsKt__StringsJVMKt.replace$default(str, "base64-", "", false, 4, (Object) null);
        final String decodeURIComponent = UriKt.decodeURIComponent(replace$default);
        e eVar = null;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) decodeURIComponent, (CharSequence) "trace_detail_ad_id=", false, 2, (Object) null);
        if (!contains$default) {
            trim = StringsKt__StringsKt.trim((CharSequence) decodeURIComponent);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(trim.toString(), "\n", "", false, 4, (Object) null);
            if (!(replace$default2.length() == 0)) {
                if (!new Regex("^[0-9a-zA-Z=+/]+$").matches(replace$default2)) {
                    if (!PageDataExtKt.isPublic(c.f117352a.g().getPageData())) {
                        log.log$enumunboxing$(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("invalid_base64 value=", replace$default2), 2, true);
                    }
                } else {
                    try {
                        replace$default2 = ((d) c.f117352a.g().acquireModule("KRCodecModule")).a(replace$default2);
                    } catch (Exception e16) {
                        if (!PageDataExtKt.isPublic(c.f117352a.g().getPageData())) {
                            log.log$enumunboxing$("base64Decode exception, base64Value=" + replace$default2 + ',' + e16, 2, true);
                        }
                        replace$default2 = "";
                    }
                }
            }
            if (!(replace$default2.length() == 0)) {
                try {
                    eVar = new e(replace$default2);
                } catch (JSONException unused) {
                }
            }
            return eVar == null ? new e() : eVar;
        }
        return new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceHelper$decodeTraceDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('?');
                m3.append(decodeURIComponent);
                for (Map.Entry entry : new URL(m3.toString()).searchParams.entrySet()) {
                    eVar3.z((String) entry.getKey(), entry.getValue());
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final String getEnteranceId() {
        List listOf;
        String lowerCase = "enteranceId".toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"enteranceId", lowerCase, "from"});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            String p16 = c.f117352a.g().getPageData().n().p((String) it.next());
            if (p16.length() > 0) {
                return p16;
            }
        }
        return "";
    }

    public final String getTraceDetailFromPageParams() {
        List listOf;
        String lowerCase = "traceDetail".toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"trace_detail", "traceDetail", lowerCase});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            String p16 = c.f117352a.g().getPageData().n().p((String) it.next());
            if (p16.length() > 0) {
                return p16;
            }
        }
        return "";
    }
}
