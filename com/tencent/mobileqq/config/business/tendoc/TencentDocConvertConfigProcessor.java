package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import ta1.f;

/* loaded from: classes10.dex */
public class TencentDocConvertConfigProcessor extends l<f> {
    public static f a() {
        return new f();
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f migrateOldOrDefaultContent(int i3) {
        return new f();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f onParsed(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            return f.s(aiVarArr);
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
        QLog.d("TencentDocConvertConfigProcessor", 1, "TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:" + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 261;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(f fVar) {
    }
}
