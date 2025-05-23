package com.tencent.mobileqq.search.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes18.dex */
public class TnnGroupSearchResultConfigProcessor extends l<c> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c migrateOldOrDefaultContent(int i3) {
        return new c();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c onParsed(ai[] aiVarArr) {
        return c.d(aiVarArr);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(c cVar) {
        QLog.i("search_manager_config.TnnGroupSearchResultConfigProcessor", 1, "onUpdate");
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<c> clazz() {
        return c.class;
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
        QLog.i("search_manager_config.TnnGroupSearchResultConfigProcessor", 1, "onReqFailed failCode=" + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 863;
    }
}
