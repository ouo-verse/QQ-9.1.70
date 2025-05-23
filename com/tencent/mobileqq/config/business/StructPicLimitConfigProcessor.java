package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class StructPicLimitConfigProcessor extends com.tencent.mobileqq.config.l<bd> {
    public static bd a() {
        if (!MobileQQ.sMobileQQ.waitAppRuntime(null).isLogin()) {
            return new bd();
        }
        return (bd) com.tencent.mobileqq.config.am.s().x(724);
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bd migrateOldOrDefaultContent(int i3) {
        return new bd();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bd onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        com.tencent.mobileqq.config.ai aiVar;
        QLog.i("StructPicLimitConfigProcessor", 1, "[onParsed] config");
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            bd a16 = bd.a(aiVar.f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("StructPicLimitConfigProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
                return a16;
            }
            return a16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructPicLimitConfigProcessor", 2, "onParsed is null");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<bd> clazz() {
        return bd.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(bd bdVar) {
        QLog.i("StructPicLimitConfigProcessor", 1, "[onUpdate]");
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
        QLog.i("StructPicLimitConfigProcessor", 1, "[onReqFailed] failCode=" + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 724;
    }
}
