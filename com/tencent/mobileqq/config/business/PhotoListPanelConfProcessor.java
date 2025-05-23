package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.widget.bp;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfoConfig;

/* loaded from: classes10.dex */
public class PhotoListPanelConfProcessor extends com.tencent.mobileqq.config.l<as> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public as migrateOldOrDefaultContent(int i3) {
        return new as();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public as onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            as a16 = as.a(aiVarArr);
            if (QLog.isColorLevel()) {
                QLog.d("PhotoListPanelConfProcessor", 2, "onParsed " + aiVarArr.length);
                return a16;
            }
            return a16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(as asVar) {
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanelConfProcessor", 2, "onUpdate " + asVar.toString());
        }
        bp.b(asVar.f202526a);
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<as> clazz() {
        return as.class;
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
            QLog.d("PhotoListPanelConfProcessor", 2, "onReqFailed " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return LpReportInfoConfig.ACTION_HOMEPAGE_GUEST;
    }
}
