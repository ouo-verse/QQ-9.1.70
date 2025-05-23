package com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter;

import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class APICallTechReporter extends NearbyTechReporter {
    public final String apiName;
    public final int apiType;
    public String errorCode;
    public final String pageId;
    public long startTime;
    public int timeUsage;

    public /* synthetic */ APICallTechReporter(int i3, String str) {
        this(i3, str, APICallTechReporterKt.NBPCurrentTime(), NearbyTechReporterKt.currentPageId());
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final String getKey() {
        return "ev_nearby_tech_api_call";
    }

    public final void reportError(String str) {
        this.timeUsage = (int) (APICallTechReporterKt.NBPCurrentTime() - this.startTime);
        this.errorCode = str;
        report();
    }

    public final void reportSuccess() {
        this.timeUsage = (int) (APICallTechReporterKt.NBPCurrentTime() - this.startTime);
        this.errorCode = null;
        report();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final e toParams() {
        e eVar = new e();
        eVar.v("nearby_page_id", this.pageId);
        eVar.v("nearby_api_type", APICallTechReporter$APIType$EnumUnboxingLocalUtility.getValue(this.apiType));
        eVar.v("nearby_api_name", this.apiName);
        eVar.t("nearby_api_time_usage", this.timeUsage);
        eVar.w("nearby_api_success", this.errorCode == null);
        String str = this.errorCode;
        if (str != null) {
            eVar.v("nearby_api_err_code", str);
        }
        return eVar;
    }

    public APICallTechReporter(int i3, String str, long j3, String str2) {
        this.apiType = i3;
        this.apiName = str;
        this.startTime = j3;
        this.pageId = str2;
    }
}
