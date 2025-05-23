package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class OpenSdkIFrameProcessor extends com.tencent.mobileqq.config.l<ao> {
    public static boolean a() {
        boolean z16;
        ao aoVar = (ao) com.tencent.mobileqq.config.am.s().x(675);
        if (aoVar != null) {
            z16 = aoVar.a();
        } else {
            z16 = true;
        }
        QLog.d("OpenSdkIFrameProcessor", 1, "isEnableIFrame = ", Boolean.valueOf(z16));
        return z16;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ao migrateOldOrDefaultContent(int i3) {
        return new ao();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ao onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        Object[] objArr = new Object[2];
        int i3 = 0;
        objArr[0] = "onParsed confFiles.length=";
        if (aiVarArr != null) {
            i3 = aiVarArr.length;
        }
        objArr[1] = Integer.valueOf(i3);
        QLog.d("OpenSdkIFrameProcessor", 1, objArr);
        if (aiVarArr != null && aiVarArr.length > 0) {
            new ao();
            return ao.b(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<ao> clazz() {
        return ao.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(ao aoVar) {
        if (QLog.isColorLevel()) {
            QLog.d("OpenSdkIFrameProcessor", 2, "onUpdate " + aoVar.toString());
        }
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
        return 675;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
