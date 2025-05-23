package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class OpenSdkFakeMsgProcessor extends com.tencent.mobileqq.config.l<an> {
    public static boolean a() {
        boolean z16;
        an anVar = (an) com.tencent.mobileqq.config.am.s().x(632);
        if (anVar != null) {
            z16 = anVar.a();
        } else {
            z16 = false;
        }
        QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, "isEnableFakeMsg = ", Boolean.valueOf(z16));
        return z16;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public an migrateOldOrDefaultContent(int i3) {
        return new an();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public an onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        Object[] objArr = new Object[2];
        int i3 = 0;
        objArr[0] = "onParsed confFiles.length=";
        if (aiVarArr != null) {
            i3 = aiVarArr.length;
        }
        objArr[1] = Integer.valueOf(i3);
        QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, objArr);
        if (aiVarArr != null && aiVarArr.length > 0) {
            new an();
            return an.b(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<an> clazz() {
        return an.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(an anVar) {
        if (QLog.isColorLevel()) {
            QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 2, "onUpdate " + anVar.toString());
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
        return 632;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
