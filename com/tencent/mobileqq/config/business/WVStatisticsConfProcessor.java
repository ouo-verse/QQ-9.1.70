package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class WVStatisticsConfProcessor extends com.tencent.mobileqq.config.l<bm> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bm migrateOldOrDefaultContent(int i3) {
        return new bm();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bm onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        com.tencent.mobileqq.config.ai aiVar;
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            bm a16 = bm.a(aiVar.f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("WVStatisticsConfProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return a16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(bm bmVar) {
        if (QLog.isColorLevel()) {
            QLog.d("WVStatisticsConfProcessor", 2, "onUpdate " + bmVar.toString());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<bm> clazz() {
        return bm.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return false;
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
        return 361;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
