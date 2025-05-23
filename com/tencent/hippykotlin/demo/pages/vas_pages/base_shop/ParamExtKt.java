package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop;

import com.tencent.hippykotlin.demo.pages.vas_base.misc.SchemaBuilder;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceHelper;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.ReportType;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.Tracker;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerView;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerViewAttr;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.functions.Function0;

/* loaded from: classes33.dex */
public final class ParamExtKt {
    public static final Function0<String> getTraceDetailStr = ParamExtKt$getTraceDetailStr$1.INSTANCE;

    static {
        ParamExtKt$getTraceDetailFromSchemaUrlKey$1 paramExtKt$getTraceDetailFromSchemaUrlKey$1 = new Function0<e>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.ParamExtKt$getTraceDetailFromSchemaUrlKey$1
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                String str = (String) ParamExtKt.getTraceDetailStr.invoke();
                return str.length() > 0 ? TraceHelper.INSTANCE.decodeTraceDetail(str) : new e();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final SchemaBuilder.TraceDetailInfo getTraceDetailInfo(VipTrackerView vipTrackerView) {
        SchemaBuilder.TraceDetailInfo traceDetailInfo = new SchemaBuilder.TraceDetailInfo();
        VipTrackerView vipTrackerView2 = vipTrackerView;
        while (true) {
            if (vipTrackerView2 == null) {
                break;
            }
            if (vipTrackerView2 instanceof VipTrackerView) {
                VipTrackerView vipTrackerView3 = vipTrackerView2;
                VipTrackerViewAttr vipTrackerViewAttr = (VipTrackerViewAttr) vipTrackerView3.getViewAttr();
                if (vipTrackerView3.getReportType() == ReportType.Page) {
                    Tracker tracker = vipTrackerViewAttr.tracker;
                    traceDetailInfo.appId = tracker.appId;
                    traceDetailInfo.pageId = tracker.pageId;
                    break;
                }
                if (vipTrackerView3.getReportType() == ReportType.Module) {
                    Tracker tracker2 = vipTrackerViewAttr.tracker;
                    traceDetailInfo.moduleId = tracker2.moduleId;
                    traceDetailInfo.subModuleId = tracker2.subModuleId;
                } else if (vipTrackerView3.getReportType() == ReportType.Item) {
                    Tracker tracker3 = vipTrackerViewAttr.tracker;
                    traceDetailInfo.itemId = tracker3.itemId;
                    traceDetailInfo.itemType = tracker3.itemType;
                }
            }
            vipTrackerView2 = vipTrackerView2.getParent();
        }
        return traceDetailInfo;
    }
}
