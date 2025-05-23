package com.tencent.aelight.camera.aioeditor.config;

import com.tencent.aelight.camera.aioeditor.capture.paster.e;
import com.tencent.aelight.camera.aioeditor.capture.util.a;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fr.f;

/* loaded from: classes32.dex */
public class QIMPasterConfigProcessor extends l<a.c> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements a.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.util.a.b
        public void a(String str) {
            ((e) f.c(1)).h(str);
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
            QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onUpdate");
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
        if (e.j()) {
            return ea.Z0(BaseApplication.getContext());
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onReqFailed");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int onSend(int i3) {
        if (!e.j()) {
            QLog.i("QIMStickerConfigProcessor", 1, "config file not exist");
            am.s().P(304, 0);
            return 0;
        }
        return super.onSend(i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 304;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a.c onParsed(ai[] aiVarArr) {
        if (aiVarArr == null || aiVarArr.length == 0) {
            return null;
        }
        ai aiVar = aiVarArr[aiVarArr.length - 1];
        for (ai aiVar2 : aiVarArr) {
            if (aiVar2.f202267a > aiVar.f202267a) {
                aiVar = aiVar2;
            }
        }
        String str = aiVar.f202268b;
        if (QLog.isColorLevel()) {
            QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onParsed, content:" + str);
        }
        return new com.tencent.aelight.camera.aioeditor.capture.util.a().b(str, e.f66861e.getAbsolutePath(), "temp_sticker_zip", new a());
    }
}
