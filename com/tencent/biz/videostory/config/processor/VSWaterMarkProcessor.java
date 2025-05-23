package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.watermark.api.IAEWaterMarkManager;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mf0.f;

/* loaded from: classes5.dex */
public class VSWaterMarkProcessor extends l<f> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public f migrateOldOrDefaultContent(int i3) {
        return new f();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f onParsed(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            return f.a(aiVarArr[0].f202268b);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(f fVar) {
        ((IAEWaterMarkManager) QRoute.api(IAEWaterMarkManager.class)).onConfigChange(true);
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<f> clazz() {
        return f.class;
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
    public void onReqNoReceive() {
        super.onReqNoReceive();
        try {
            ((IAEWaterMarkManager) QRoute.api(IAEWaterMarkManager.class)).onConfigChange(false);
        } catch (Throwable th5) {
            QLog.e("VSWaterMarkProcessor", 2, "handle  onReqNoReceive error! ", th5);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 406;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
