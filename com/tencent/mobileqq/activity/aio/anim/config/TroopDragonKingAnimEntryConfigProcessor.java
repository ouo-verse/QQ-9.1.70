package com.tencent.mobileqq.activity.aio.anim.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import x51.a;

/* loaded from: classes10.dex */
public class TroopDragonKingAnimEntryConfigProcessor extends l<a> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "migrateOldOrDefaultContent, type = " + i3);
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "onParsed");
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            return a.b(aiVarArr[0].f202268b);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return true;
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
        QLog.d("TroopDragonKingAnimEntryConfig.config", 1, "onReqFailed, failCode = " + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 609;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
    }
}
