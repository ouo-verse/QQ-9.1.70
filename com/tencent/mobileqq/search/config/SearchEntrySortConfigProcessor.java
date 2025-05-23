package com.tencent.mobileqq.search.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes18.dex */
public class SearchEntrySortConfigProcessor extends l<b> {
    public static b a() {
        return (b) am.s().x(874);
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b migrateOldOrDefaultContent(int i3) {
        return new b();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b onParsed(ai[] aiVarArr) {
        return b.c(aiVarArr);
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<b> clazz() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(b bVar) {
        QLog.i("SearchEntrySortConfigProcessor", 1, "onUpdate");
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
        QLog.i("SearchEntrySortConfigProcessor", 1, "onReqFailed failCode=" + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 874;
    }
}
