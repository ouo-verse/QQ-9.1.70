package com.tencent.aelight.camera.report.api.impl;

import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;

/* loaded from: classes32.dex */
public class AEBaseReportParamImpl implements IAEBaseReportParam {
    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void clearLatestPostMd5() {
        AEBaseReportParam.U().e();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public boolean getGifMode() {
        return AEBaseReportParam.U().O();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public String getIntentUidKey() {
        return "intent_key_uid_for_report";
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void resetEditInfo() {
        AEBaseReportParam.U().x0();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setContentType(long j3) {
        AEBaseReportParam.U().D0(j3);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setEditHasCut(boolean z16) {
        AEBaseReportParam.U().G0(z16);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setEditMusicId(String str) {
        AEBaseReportParam.U().H0(str);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setEditSpeedChanged(boolean z16) {
        AEBaseReportParam.U().J0(z16);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setEditStickerIds(String str) {
        AEBaseReportParam.U().K0(str);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setEditTextIds(String str) {
        AEBaseReportParam.U().L0(str);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setEntry(int i3, String str) {
        AEBaseReportParam.U().O0(i3, str);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setExperimentID(String str) {
        AEBaseReportParam.U().P0(str);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setFilterId(String str) {
        AEBaseReportParam.U().U0(str);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setNetWork() {
        AEBaseReportParam.U().g1();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setOprationTime() {
        AEBaseReportParam.U().h1();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setShootTime() {
        AEBaseReportParam.U().m1();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setUin(String str) {
        AEBaseReportParam.U().s1(str);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setVideoDuration(long j3) {
        AEBaseReportParam.U().t1(j3);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseReportParam
    public void setEditHasGraffiti(boolean z16) {
    }
}
