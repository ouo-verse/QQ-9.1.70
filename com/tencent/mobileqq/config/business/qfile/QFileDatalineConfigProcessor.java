package com.tencent.mobileqq.config.business.qfile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class QFileDatalineConfigProcessor extends com.tencent.mobileqq.config.l<m> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public m migrateOldOrDefaultContent(int i3) {
        QLog.i("QFileDatalineConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + i3 + "]");
        return new m();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m onParsed(ai[] aiVarArr) {
        QLog.i("QFileDatalineConfigProcessor", 1, "onParsed");
        if (aiVarArr != null && aiVarArr.length > 0) {
            return (m) rb1.b.a(aiVarArr[0].f202268b, m.class);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(m mVar) {
        if (mVar == null) {
            QLog.i("QFileDatalineConfigProcessor", 1, "onUpdate: newConf is null.");
            return;
        }
        QLog.i("QFileDatalineConfigProcessor", 1, "onUpdate");
        BaseQQAppInterface A0 = QQFileManagerUtilImpl.A0();
        if (A0 != null) {
            com.tencent.mobileqq.filemanager.util.h.h(A0, "file_dataline_key", mVar.f202759m);
            QFileConfigManager.J(A0).s0(mVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<m> clazz() {
        return m.class;
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
    public void onReqFailed(int i3) {
        QLog.i("QFileDatalineConfigProcessor", 1, "onReqFailed: failCode[" + i3 + "]");
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 687;
    }
}
