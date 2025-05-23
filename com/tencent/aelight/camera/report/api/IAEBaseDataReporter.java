package com.tencent.aelight.camera.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEBaseDataReporter extends QRouteApi {
    void report3DPerformance(String str, HashMap<String, String> hashMap);

    void reportAIEliminateTime(HashMap<String, String> hashMap);

    void reportAIGCGenerateTime(HashMap<String, String> hashMap);

    void reportAIGCSelectTime(HashMap<String, String> hashMap);

    void reportAIGCUploadTime(HashMap<String, String> hashMap);

    void reportARVideoDownloadBtn();

    void reportARVideoExpose();

    void reportARVideoShareBtn();

    void reportCameraServer(int i3, String str, String str2, int i16);

    void reportClickFilterItem(String str);

    void reportDownloadBtn();

    void reportEditView();

    void reportEditViewExpose();

    void reportEditorFirstFrameError(HashMap<String, String> hashMap);

    void reportEmoFilterItem(String str);

    void reportLoadError(HashMap<String, String> hashMap);

    void reportMagicAvatar(HashMap<String, String> hashMap);

    void reportMaterialDownLoad(String str, int i3, long j3, long j16, String str2);

    void reportPicChooseNextBtn();

    void reportPostBtn();

    void reportPostBtn(String str, int i3);

    void reportRephotoBtn();

    void reportTemplateLoad(HashMap<String, String> hashMap);

    void reportWinkClippingSeekFluency(HashMap<String, String> hashMap);

    void reportWinkCommonEvents(String str, Map<String, Object> map);

    void reportWinkEditorFluency(HashMap<String, String> hashMap);

    void reportWinkEditorImport(HashMap<String, String> hashMap);

    void reportWinkImageModeEditorFluency(HashMap<String, String> hashMap);
}
