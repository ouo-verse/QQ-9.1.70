package com.tencent.hippykotlin.demo.pages.vas_base.report;

import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes33.dex */
public final class Vas04586ReportProxy extends VasBaseReportProxy {
    public Map<String, ? extends Object> traceInfo;
    public String appId = "";
    public String pageId = "";
    public long actionId = -1;
    public Map<String, Object> busiInfo = new LinkedHashMap();

    public Vas04586ReportProxy(Function1<? super Map<String, String>, Unit> function1) {
        Map<String, ? extends Object> emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.traceInfo = emptyMap;
    }

    public final String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Vas04586ReportProxy(appId='");
        sb5.append(this.appId);
        sb5.append("', pageId='");
        StringBuilder m3 = VasBusinessReportData$$ExternalSyntheticOutline0.m(VasBusinessReportData$$ExternalSyntheticOutline0.m(sb5, this.pageId, "', moduleId='", "", "', subModuleId='"), "", "', itemId='", "", "', itemType='");
        m3.append("");
        m3.append("', actionId=");
        m3.append(this.actionId);
        m3.append(", uid='");
        m3.append("");
        StringBuilder m16 = VasBusinessReportData$$ExternalSyntheticOutline0.m(m3, "', toUid='", "", "', positionId='", "");
        m16.append("', actionAttr='");
        m16.append("");
        m16.append("', actionValue='");
        StringBuilder m17 = VasBusinessReportData$$ExternalSyntheticOutline0.m(sb5, "", "', strRuleId='", "", "', busiInfo=");
        m17.append(this.busiInfo);
        m17.append(", traceInfo=");
        m17.append(this.traceInfo);
        m17.append(')');
        return sb5.toString();
    }
}
