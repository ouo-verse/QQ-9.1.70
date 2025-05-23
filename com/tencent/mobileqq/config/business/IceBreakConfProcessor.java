package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class IceBreakConfProcessor extends com.tencent.mobileqq.config.l<u> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public u migrateOldOrDefaultContent(int i3) {
        return new u();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            return u.a(aiVarArr[0].f202268b);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(u uVar) {
        if (QLog.isColorLevel()) {
            QLog.d("IceBreakConfProcessor", 2, "onUpdate newConf:" + uVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<u> clazz() {
        return u.class;
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
        if (QLog.isColorLevel()) {
            QLog.d("IceBreakConfProcessor", 2, "onReqFailed failCode:" + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 693;
    }
}
