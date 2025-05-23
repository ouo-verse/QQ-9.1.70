package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model;

import b01.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ReportItem implements b {
    public final ReportAction action;
    public final e busiInfo;
    public final String itemId;
    public final String itemType;
    public final String moduleId;
    public final String positionId;
    public final e ruleInfo;
    public final List<String> subItemId = new ArrayList();
    public final String subModuleId;

    public ReportItem(ReportAction reportAction, String str, String str2, String str3, e eVar, String str4, e eVar2, String str5) {
        this.action = reportAction;
        this.moduleId = str;
        this.itemId = str2;
        this.itemType = str3;
        this.busiInfo = eVar;
        this.subModuleId = str4;
        this.ruleInfo = eVar2;
        this.positionId = str5;
    }

    @Override // b01.b
    public final e serialization() {
        return new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportItem$serialization$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                List listOf;
                e eVar2 = eVar;
                eVar2.z("module_id", ReportItem.this.moduleId);
                eVar2.z("item_id", ReportItem.this.itemId);
                eVar2.z("item_type", ReportItem.this.itemType);
                eVar2.z("busi_info", ReportItem.this.busiInfo.toString());
                listOf = CollectionsKt__CollectionsJVMKt.listOf(ReportItem.this.action);
                eVar2.A("action_infos", listOf);
                eVar2.A("sub_item_id", ReportItem.this.subItemId);
                eVar2.z("sub_module_id", ReportItem.this.subModuleId);
                eVar2.z("rule_info", ReportItem.this.ruleInfo);
                eVar2.z(QCircleLpReportDc05507.KEY_POSITION_ID, ReportItem.this.positionId);
                return Unit.INSTANCE;
            }
        });
    }
}
