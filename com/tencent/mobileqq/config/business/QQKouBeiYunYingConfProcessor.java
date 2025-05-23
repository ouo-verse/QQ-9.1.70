package com.tencent.mobileqq.config.business;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class QQKouBeiYunYingConfProcessor extends com.tencent.mobileqq.config.l<az> {
    @NonNull
    public static az a() {
        az azVar;
        try {
            azVar = (az) com.tencent.mobileqq.config.am.s().x(676);
        } catch (Throwable th5) {
            QLog.e("QQKouBeiYunYingConfProcessor", 1, th5, new Object[0]);
            azVar = null;
        }
        if (azVar == null) {
            return new az();
        }
        return azVar;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public az migrateOldOrDefaultContent(int i3) {
        return new az();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public az onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) throws QStorageInstantiateException {
        az azVar;
        if (aiVarArr != null && aiVarArr.length > 0) {
            azVar = az.h(aiVarArr);
        } else {
            azVar = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQKouBeiYunYingConfProcessor", 2, "onParsed:" + azVar);
        }
        return azVar;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<az> clazz() {
        return az.class;
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
        return super.isNeedUpgradeReset();
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        if (QLog.isColorLevel()) {
            QLog.d("QQKouBeiYunYingConfProcessor", 2, "migrateOldVersion");
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("QQKouBeiYunYingConfProcessor", 2, "onReqFailed ", Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 676;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(az azVar) {
    }
}
