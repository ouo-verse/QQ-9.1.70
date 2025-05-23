package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager;
import com.tencent.aelight.camera.qqstory.api.IPtvTemplateManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import qs.b;

/* loaded from: classes32.dex */
public class PtvTemplateManagerImpl implements IPtvTemplateManager {
    @Override // com.tencent.aelight.camera.qqstory.api.IPtvTemplateManager
    public void handleGetDoodleConfig(String str, BaseQQAppInterface baseQQAppInterface) {
        PtvTemplateManager.j().k(str, (QQAppInterface) baseQQAppInterface);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPtvTemplateManager
    public boolean hasDownloadFailed() {
        return PtvTemplateManager.j().l();
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPtvTemplateManager
    public void initLocalDoodleInfo(AppInterface appInterface, b bVar) {
        PtvTemplateManager.j().m(appInterface, bVar);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPtvTemplateManager
    public boolean isDoodleConfigFileExist() {
        return PtvTemplateManager.n();
    }
}
