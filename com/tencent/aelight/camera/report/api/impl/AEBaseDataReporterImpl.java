package com.tencent.aelight.camera.report.api.impl;

import com.tencent.aelight.camera.ae.report.b;
import com.tencent.aelight.camera.ae.report.d;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEBaseDataReporterImpl implements IAEBaseDataReporter {
    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void report3DPerformance(String str, HashMap<String, String> hashMap) {
        b.b().e(str, hashMap);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportAIEliminateTime(HashMap<String, String> hashMap) {
        b.b().v("performance#editor_eliminate#process_cost", hashMap);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportAIGCGenerateTime(HashMap<String, String> hashMap) {
        b.b().g(hashMap, "performance#magic_gallery#generate_ai_img_process");
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportAIGCSelectTime(HashMap<String, String> hashMap) {
        b.b().g(hashMap, "performance#magic_gallery#generate_ai_img_select");
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportAIGCUploadTime(HashMap<String, String> hashMap) {
        b.b().g(hashMap, "performance#magic_gallery#generate_ai_img_upload");
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportARVideoDownloadBtn() {
        b.b().j();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportARVideoExpose() {
        b.b().k();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportARVideoShareBtn() {
        b.b().l();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportCameraServer(int i3, String str, String str2, int i16) {
        b.b().w(i3, str, str2, i16);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportClickFilterItem(String str) {
        b.b().I(str);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportDownloadBtn() {
        b.b().h0();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportEditView() {
        b.b().i0();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportEditViewExpose() {
        b.b().j0();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportEditorFirstFrameError(HashMap<String, String> hashMap) {
        b.b().z0(hashMap);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportEmoFilterItem(String str) {
        b.b().A0(str);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportLoadError(HashMap<String, String> hashMap) {
        b.b().U1(hashMap);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportMagicAvatar(HashMap<String, String> hashMap) {
        b.b().g(hashMap, "performance#magic_avatar#generate_ai_avatar");
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportMaterialDownLoad(String str, int i3, long j3, long j16, String str2) {
        b.b().i1(str, i3, j3, j16, str2);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportPicChooseNextBtn() {
        b.b().p1();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportPostBtn(String str, int i3) {
        b.b().t1(str, i3);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportRephotoBtn() {
        b.b().E1();
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportTemplateLoad(HashMap<String, String> hashMap) {
        b.b().R1(hashMap);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportWinkClippingSeekFluency(HashMap<String, String> hashMap) {
        b.b().O1(hashMap);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportWinkCommonEvents(String str, Map<String, Object> map) {
        b.b().v(str, d.a(map));
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportWinkEditorFluency(HashMap<String, String> hashMap) {
        b.b().P1(hashMap);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportWinkEditorImport(HashMap<String, String> hashMap) {
        b.b().Q1(hashMap);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportWinkImageModeEditorFluency(HashMap<String, String> hashMap) {
        b.b().N1(hashMap);
    }

    @Override // com.tencent.aelight.camera.report.api.IAEBaseDataReporter
    public void reportPostBtn() {
        b.b().s1();
    }
}
