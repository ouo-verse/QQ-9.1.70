package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.qqstory.api.IQIMPtvTemplateManager;
import fr.f;
import java.io.File;

/* loaded from: classes32.dex */
public class QIMPtvTemplateManagerImpl implements IQIMPtvTemplateManager {
    @Override // com.tencent.aelight.camera.qqstory.api.IQIMPtvTemplateManager
    public String getDoodleConfigAbsolutePath() {
        return QIMPtvTemplateManager.Q.getAbsolutePath();
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IQIMPtvTemplateManager
    public String getTempFaceConfigZip() {
        return "temp_faceu_zip";
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IQIMPtvTemplateManager
    public boolean isConfigFileExist() {
        return QIMPtvTemplateManager.v();
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IQIMPtvTemplateManager
    public String loadFileContent(File file) {
        return QIMPtvTemplateManager.z(file);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IQIMPtvTemplateManager
    public void handleGetServerConfig(String str, int i3) {
        ((QIMPtvTemplateManager) f.c(3)).r(str, i3);
    }
}
