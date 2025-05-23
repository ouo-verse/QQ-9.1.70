package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model;

import b01.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes33.dex */
public final class ReportPageInfo implements b {
    public final String appId;
    public final ReportItem item;
    public final String pageId;

    public ReportPageInfo(String str, String str2, ReportItem reportItem) {
        this.appId = str;
        this.pageId = str2;
        this.item = reportItem;
    }

    @Override // b01.b
    public final e serialization() {
        return new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportPageInfo$serialization$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                List listOf;
                e eVar2 = eVar;
                eVar2.z("appid", ReportPageInfo.this.appId);
                eVar2.z("page_id", ReportPageInfo.this.pageId);
                listOf = CollectionsKt__CollectionsJVMKt.listOf(ReportPageInfo.this.item);
                eVar2.A("item_infos", listOf);
                return Unit.INSTANCE;
            }
        });
    }
}
