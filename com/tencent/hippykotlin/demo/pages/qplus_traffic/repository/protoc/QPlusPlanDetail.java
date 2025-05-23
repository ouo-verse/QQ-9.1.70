package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusPlanDetail implements ISSOReqModel, ISSORspModel<QPlusPlanDetail> {
    public final String audienceText;
    public final String endTime;
    public final String expectCovers;
    public final String improveText;
    public final String planId;
    public final String startTime;
    public final String statusText;
    public final String timeText;

    public QPlusPlanDetail(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.planId = str;
        this.startTime = str2;
        this.endTime = str3;
        this.expectCovers = str4;
        this.improveText = str5;
        this.audienceText = str6;
        this.timeText = str7;
        this.statusText = str8;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("plan_id", this.planId);
        eVar.v("start_time", this.startTime);
        eVar.v("end_time", this.endTime);
        eVar.v("expect_covers", this.expectCovers);
        eVar.v("improve_text", this.improveText);
        eVar.v("audience_text", this.audienceText);
        eVar.v("time_text", this.timeText);
        eVar.v("status_text", this.statusText);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusPlanDetail decode(e eVar) {
        return new QPlusPlanDetail(eVar.q("plan_id", ""), eVar.q("start_time", ""), eVar.q("end_time", ""), eVar.q("expect_covers", ""), eVar.q("improve_text", ""), eVar.q("audience_text", ""), eVar.q("time_text", ""), eVar.q("status_text", ""));
    }
}
