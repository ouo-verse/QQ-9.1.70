package com.tencent.mobileqq.config.business;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class AvifDownloadConfProcessor extends com.tencent.mobileqq.config.l<c> {
    public static c a() {
        return (c) com.tencent.mobileqq.config.am.s().x(858);
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c migrateOldOrDefaultContent(int i3) {
        return new c();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (QLog.isColorLevel() && aiVarArr != null) {
            QLog.d("AvifDownloadConfProcessor", 2, "onParsed " + aiVarArr.length);
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            return c.h(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<c> clazz() {
        return c.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(c cVar) {
        if (QLog.isColorLevel()) {
            QLog.d("AvifDownloadConfProcessor", 2, "onUpdate " + cVar.toString());
        }
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
    public boolean isNeedUpgradeReset() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AvifDownloadConfProcessor", 2, "onReqFailed " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 858;
    }
}
