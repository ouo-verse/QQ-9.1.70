package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class TroopAnonyRevokeConfProcessor extends com.tencent.mobileqq.config.l<r> {
    public static r a() {
        return (r) com.tencent.mobileqq.config.am.s().x(633);
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r migrateOldOrDefaultContent(int i3) {
        return new r();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        com.tencent.mobileqq.config.ai aiVar;
        QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            r a16 = r.a(aiVar.f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
                return a16;
            }
            return a16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<r> clazz() {
        return r.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(r rVar) {
        QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
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
        QLog.i("TroopFoldMsgConfProcessor", 1, "[onReqFailed] failCode=" + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 633;
    }
}
