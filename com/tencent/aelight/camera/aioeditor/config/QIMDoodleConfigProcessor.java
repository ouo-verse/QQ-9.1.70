package com.tencent.aelight.camera.aioeditor.config;

import com.tencent.aelight.camera.qqstory.api.IPtvTemplateManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class QIMDoodleConfigProcessor extends l<Object> {
    @Override // com.tencent.mobileqq.config.l
    public Class<Object> clazz() {
        return Object.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public Object migrateOldOrDefaultContent(int i3) {
        return new Object();
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        if (((IPtvTemplateManager) QRoute.api(IPtvTemplateManager.class)).isDoodleConfigFileExist()) {
            return ea.L(BaseApplication.getContext());
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onReqFailed");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqNoReceive() {
        if (QLog.isColorLevel()) {
            QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onReqNoReceive");
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (((IPtvTemplateManager) QRoute.api(IPtvTemplateManager.class)).hasDownloadFailed()) {
            ((IPtvTemplateManager) QRoute.api(IPtvTemplateManager.class)).initLocalDoodleInfo(qQAppInterface, null);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int onSend(int i3) {
        if (!((IPtvTemplateManager) QRoute.api(IPtvTemplateManager.class)).isDoodleConfigFileExist()) {
            QLog.i("QIMDoodleConfigProcessor", 1, "config file not exist");
            am.s().P(310, 0);
            return 0;
        }
        return super.onSend(i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public void onUpdate(Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onUpdate");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 310;
    }

    @Override // com.tencent.mobileqq.config.l
    public Object onParsed(ai[] aiVarArr) {
        if (aiVarArr == null || aiVarArr.length == 0) {
            return null;
        }
        String str = aiVarArr[0].f202268b;
        if (QLog.isColorLevel()) {
            QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onParsed, content:" + str);
        }
        ((IPtvTemplateManager) QRoute.api(IPtvTemplateManager.class)).handleGetDoodleConfig(str, (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
        return new Object();
    }
}
