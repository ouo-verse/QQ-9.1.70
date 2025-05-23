package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class TogetherBusinessConfProcessor extends com.tencent.mobileqq.config.l<bi> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bi migrateOldOrDefaultContent(int i3) {
        return new bi();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bi onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        com.tencent.mobileqq.config.ai aiVar;
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            bi a16 = bi.a(aiVar.f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("TogetherBusinessConfProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return a16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessConfProcessor", 2, "onParsed is null");
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(bi biVar) {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessConfProcessor", 2, "onUpdate " + biVar.toString());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<bi> clazz() {
        return bi.class;
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
            QLog.d("TogetherBusinessConfProcessor", 2, "migrateOldVersion");
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessConfProcessor", 2, "onReqFailed ", Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 535;
    }
}
