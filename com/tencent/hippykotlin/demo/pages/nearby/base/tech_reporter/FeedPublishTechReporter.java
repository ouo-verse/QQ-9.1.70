package com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class FeedPublishTechReporter extends NearbyTechReporter {
    public String errMsg;
    public int result = 1;
    public long startTime;
    public long submitStartTime;
    public Integer submitTimeUsage;
    public int totalTimeUsage;
    public long uploadStartTime;
    public Integer uploadTimeUsage;

    public FeedPublishTechReporter(long j3) {
        this.startTime = j3;
        this.uploadStartTime = j3;
        this.submitStartTime = j3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final String getKey() {
        return "ev_nearby_tech_publish";
    }

    public final void reportResult$enumunboxing$(int i3, String str) {
        this.result = i3;
        this.errMsg = str;
        this.totalTimeUsage = (int) (APICallTechReporterKt.NBPCurrentTime() - this.startTime);
        report();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final e toParams() {
        String str;
        e eVar = new e();
        eVar.v("nearby_publish_result", FeedPublishTechReporter$PublishResult$EnumUnboxingLocalUtility.getValue(this.result));
        eVar.t("nearby_publish_time", this.totalTimeUsage);
        Integer num = this.uploadTimeUsage;
        if (num != null) {
            eVar.v("nearby_publish_upload_time", num);
        }
        Integer num2 = this.submitTimeUsage;
        if (num2 != null) {
            eVar.v("nearby_publish_reqeust_time", num2);
        }
        String str2 = this.errMsg;
        if (str2 != null) {
            eVar.v("nearby_api_err_msg", str2);
        }
        eVar.w("nearby_publish_had_main_page", NearbyProUtilsKt.isInNBPMain());
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        if (QQNearbyModule.Companion.getInstance().getSig().length == 0) {
            str = "1";
        } else {
            str = "0";
        }
        eVar.v("sig_empty", str);
        return eVar;
    }
}
