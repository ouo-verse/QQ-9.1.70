package com.tencent.mobileqq.config.business.qfile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class QFileAppStorePromoteConfigProcessor extends com.tencent.mobileqq.config.l<j> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j migrateOldOrDefaultContent(int i3) {
        return new j();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j onParsed(ai[] aiVarArr) {
        QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onParsed");
        if (aiVarArr != null && aiVarArr.length > 0) {
            return (j) rb1.b.a(aiVarArr[0].f202268b, j.class);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(j jVar) {
        if (jVar == null) {
            QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onUpdate: newConf is null.");
            return;
        }
        QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onUpdate");
        BaseQQAppInterface A0 = QQFileManagerUtilImpl.A0();
        if (A0 != null) {
            com.tencent.mobileqq.filemanager.util.h.c(A0, "yyb_promote_action_key", jVar.f202745h);
            QFileConfigManager.J(A0).M0(jVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<j> clazz() {
        return j.class;
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
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 626;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
