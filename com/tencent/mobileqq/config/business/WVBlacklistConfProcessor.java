package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class WVBlacklistConfProcessor extends com.tencent.mobileqq.config.l<bk> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bk migrateOldOrDefaultContent(int i3) {
        return new bk();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bk onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) throws QStorageInstantiateException {
        com.tencent.mobileqq.config.ai aiVar;
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            bk c16 = bk.c(aiVar.f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("WVBlacklistConfProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return c16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WVBlacklistConfProcessor", 2, "onParsed is null");
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(bk bkVar) {
        if (QLog.isColorLevel()) {
            QLog.d("WVBlacklistConfProcessor", 2, "onUpdate " + bkVar.toString());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<bk> clazz() {
        return bk.class;
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
        if (QLog.isColorLevel()) {
            QLog.d("WVBlacklistConfProcessor", 2, "migrateOldVersion");
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("WVBlacklistConfProcessor", 2, "onReqFailed ", Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 811;
    }
}
