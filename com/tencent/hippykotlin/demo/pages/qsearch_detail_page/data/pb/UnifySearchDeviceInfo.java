package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchDeviceInfo implements ISSOReqModel, ISSORspModel<UnifySearchDeviceInfo> {
    public final boolean nightModeStatus;
    public final boolean studyModeStatus;

    public UnifySearchDeviceInfo(boolean z16, boolean z17) {
        this.studyModeStatus = z16;
        this.nightModeStatus = z17;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.w("study_mode_status", this.studyModeStatus);
        eVar.w("night_mode_status", this.nightModeStatus);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchDeviceInfo decode(e eVar) {
        boolean g16 = eVar.g("study_mode_status", false);
        eVar.g("night_mode_status", false);
        return new UnifySearchDeviceInfo(g16, false);
    }
}
