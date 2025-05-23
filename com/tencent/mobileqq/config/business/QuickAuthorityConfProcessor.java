package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class QuickAuthorityConfProcessor extends com.tencent.mobileqq.config.l<QuickAuthorityConfBean> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QuickAuthorityConfBean migrateOldOrDefaultContent(int i3) {
        return new QuickAuthorityConfBean();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QuickAuthorityConfBean onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        com.tencent.mobileqq.config.ai aiVar;
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            QuickAuthorityConfBean a16 = QuickAuthorityConfBean.a(aiVar.f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("QuickAuthorityConfProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return a16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QuickAuthorityConfProcessor", 2, "onParsed is null");
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(QuickAuthorityConfBean quickAuthorityConfBean) {
        if (QLog.isColorLevel()) {
            QLog.d("QuickAuthorityConfProcessor", 2, "onUpdate " + quickAuthorityConfBean.toString());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QuickAuthorityConfBean> clazz() {
        return QuickAuthorityConfBean.class;
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
            QLog.d("QuickAuthorityConfProcessor", 2, "migrateOldVersion");
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("QuickAuthorityConfProcessor", 2, "onReqFailed ", Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 546;
    }
}
