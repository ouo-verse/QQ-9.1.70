package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class MsgTabCameraSwitchProcessor extends com.tencent.mobileqq.config.l<ac> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ac migrateOldOrDefaultContent(int i3) {
        return new ac();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ac onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraSwitchProcessor", 2, "onParsed ");
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            return ac.a(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(ac acVar) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraSwitchProcessor", 2, "onUpdate " + acVar.toString());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<ac> clazz() {
        return ac.class;
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
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraSwitchProcessor", 2, "onReqFailed " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqNoReceive() {
        if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraSwitchProcessor", 2, "onReqNoReceive ");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 489;
    }
}
