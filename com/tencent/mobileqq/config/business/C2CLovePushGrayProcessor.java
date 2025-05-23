package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class C2CLovePushGrayProcessor extends com.tencent.mobileqq.config.l<f> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public f migrateOldOrDefaultContent(int i3) {
        return new f().a("0");
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            f b16 = f.b(aiVarArr[0].f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("C2CLovePushGrayProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return b16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<f> clazz() {
        return f.class;
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
            QLog.d("C2CLovePushGrayProcessor", 2, "onReqFailed " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 452;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(f fVar) {
    }
}
