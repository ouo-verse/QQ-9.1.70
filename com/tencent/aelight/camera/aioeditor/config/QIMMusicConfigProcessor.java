package com.tencent.aelight.camera.aioeditor.config;

import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.util.a;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fr.f;

/* loaded from: classes32.dex */
public class QIMMusicConfigProcessor extends l<a.c> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements a.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.util.a.b
        public void a(String str) {
            ((QIMMusicConfigManager) f.c(2)).D(str);
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
            QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onUpdate");
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
        if (QIMMusicConfigManager.E()) {
            return ea.Y0(BaseApplication.getContext());
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onReqFailed");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int onSend(int i3) {
        if (!QIMMusicConfigManager.E()) {
            QLog.i("QIMMusicConfigProcessor", 1, "config file not exist");
            am.s().P(305, 0);
            return 0;
        }
        return super.onSend(i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 305;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a.c onParsed(ai[] aiVarArr) {
        if (aiVarArr == null || aiVarArr.length == 0) {
            return null;
        }
        String str = aiVarArr[0].f202268b;
        if (QLog.isColorLevel()) {
            QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onParsed, content:" + str);
        }
        return new com.tencent.aelight.camera.aioeditor.capture.util.a().b(str, QIMMusicConfigManager.U.getAbsolutePath(), "temp_music_zip", new a());
    }
}
