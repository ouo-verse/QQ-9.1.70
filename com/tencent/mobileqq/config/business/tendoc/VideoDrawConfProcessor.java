package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class VideoDrawConfProcessor extends l<String> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String migrateOldOrDefaultContent(int i3) {
        return "";
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoDrawConfProcessor", 2, "onParsed");
        }
        if (aiVarArr != null && aiVarArr.length != 0) {
            String str = aiVarArr[0].f202268b;
            if (QLog.isColorLevel()) {
                QLog.d("VideoDrawConfProcessor", 2, " onParsed, content:" + str);
            }
            return str;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoDrawConfProcessor", 2, "onUpdate");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<String> clazz() {
        return String.class;
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
            QLog.d("VideoDrawConfProcessor", 2, "onReqFailed");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 462;
    }
}
