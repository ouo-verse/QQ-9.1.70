package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class GlobalSearchConfProcessor extends com.tencent.mobileqq.config.l<t> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public t migrateOldOrDefaultContent(int i3) {
        return new t();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        com.tencent.mobileqq.config.ai aiVar;
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            t c16 = t.c(aiVar.f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("GlobalSearchConfProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return c16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(t tVar) {
        SearchConfig.needSeparate = tVar.a();
        if (QLog.isColorLevel()) {
            QLog.d("GlobalSearchConfProcessor", 2, "onUpdate " + tVar.toString());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<t> clazz() {
        return t.class;
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
        return 414;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
