package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class QQGameTeamConfProcessor extends com.tencent.mobileqq.config.l<ay> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ay migrateOldOrDefaultContent(int i3) {
        return new ay();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ay onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        ay ayVar;
        if (aiVarArr != null && aiVarArr.length > 0) {
            ayVar = ay.a(aiVarArr);
        } else {
            ayVar = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGameTeamConfProcessor", 2, "onParsed:" + ayVar);
        }
        return ayVar;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(ay ayVar) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGameTeamConfProcessor", 2, "onUpdate " + ayVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<ay> clazz() {
        return ay.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return true;
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
            QLog.d("QQGameTeamConfProcessor", 2, "onReqFailed " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 720;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqNoReceive() {
    }
}
