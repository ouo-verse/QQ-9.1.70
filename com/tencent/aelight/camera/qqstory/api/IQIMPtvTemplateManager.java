package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQIMPtvTemplateManager extends QRouteApi {
    String getDoodleConfigAbsolutePath();

    String getTempFaceConfigZip();

    void handleGetServerConfig(String str, int i3);

    boolean isConfigFileExist();

    String loadFileContent(File file);
}
