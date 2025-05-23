package com.tencent.aelight.camera.aioeditor.config;

import com.tencent.aelight.camera.aioeditor.capture.util.a;
import com.tencent.aelight.camera.qqstory.api.IQIMPtvTemplateManager;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class QIMTemplateConfigProcessor extends l<a.c> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements a.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.util.a.b
        public void a(String str) {
            ((IQIMPtvTemplateManager) QRoute.api(IQIMPtvTemplateManager.class)).handleGetServerConfig(str, 1);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a.c migrateOldOrDefaultContent(int i3) {
        return new a.c();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a.c cVar) {
        if (QLog.isColorLevel()) {
            QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onUpdate");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a.c> clazz() {
        return a.c.class;
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
    public int migrateOldVersion() {
        if (((IQIMPtvTemplateManager) QRoute.api(IQIMPtvTemplateManager.class)).isConfigFileExist()) {
            return ea.Q(BaseApplication.getContext());
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onReqFailed");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int onSend(int i3) {
        if (!((IQIMPtvTemplateManager) QRoute.api(IQIMPtvTemplateManager.class)).isConfigFileExist()) {
            QLog.i("QIMTemplateConfigProcessor", 1, "config file not exist");
            am.s().P(307, 0);
            return 0;
        }
        return super.onSend(i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 307;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a.c onParsed(ai[] aiVarArr) {
        if (aiVarArr == null || aiVarArr.length == 0) {
            return null;
        }
        String str = aiVarArr[0].f202268b;
        if (QLog.isColorLevel()) {
            QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onParsed, content:" + str);
        }
        return new com.tencent.aelight.camera.aioeditor.capture.util.a().b(str, ((IQIMPtvTemplateManager) QRoute.api(IQIMPtvTemplateManager.class)).getDoodleConfigAbsolutePath(), ((IQIMPtvTemplateManager) QRoute.api(IQIMPtvTemplateManager.class)).getTempFaceConfigZip(), new a());
    }
}
