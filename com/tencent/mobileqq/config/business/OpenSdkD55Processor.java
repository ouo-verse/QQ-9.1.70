package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class OpenSdkD55Processor extends com.tencent.mobileqq.config.l<am> {
    public static boolean a() {
        boolean z16;
        am amVar = (am) com.tencent.mobileqq.config.am.s().x(613);
        if (amVar != null) {
            z16 = amVar.a();
        } else {
            z16 = false;
        }
        QLog.d("OpenSdkD55Processor", 1, "isSwitchOpen = ", Boolean.valueOf(z16));
        return z16;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public am migrateOldOrDefaultContent(int i3) {
        return new am();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public am onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        Object[] objArr = new Object[2];
        int i3 = 0;
        objArr[0] = "onParsed confFiles.length=";
        if (aiVarArr != null) {
            i3 = aiVarArr.length;
        }
        objArr[1] = Integer.valueOf(i3);
        QLog.d("OpenSdkD55Processor", 1, objArr);
        if (aiVarArr != null && aiVarArr.length > 0) {
            new am();
            return am.b(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<am> clazz() {
        return am.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(am amVar) {
        if (QLog.isColorLevel()) {
            QLog.d("OpenSdkD55Processor", 2, "onUpdate " + amVar.toString());
        }
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
    public int type() {
        return 613;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
