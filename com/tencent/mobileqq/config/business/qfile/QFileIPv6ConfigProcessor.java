package com.tencent.mobileqq.config.business.qfile;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class QFileIPv6ConfigProcessor extends com.tencent.mobileqq.config.l<s> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public s migrateOldOrDefaultContent(int i3) {
        QLog.i("QFileIPv6ConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + i3 + "]");
        return new s();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s onParsed(ai[] aiVarArr) {
        QLog.i("QFileIPv6ConfigProcessor", 1, "onParsed");
        if (aiVarArr != null && aiVarArr.length > 0) {
            return (s) rb1.b.a(aiVarArr[0].f202268b, s.class);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(s sVar) {
        if (sVar == null) {
            QLog.i("QFileIPv6ConfigProcessor", 1, "FileIPv6Config onUpdate: newConf is null.");
            return;
        }
        QLog.i("QFileIPv6ConfigProcessor", 1, "FileIPv6Config onUpdate");
        BaseQQAppInterface A0 = QQFileManagerUtilImpl.A0();
        if (A0 != null) {
            com.tencent.mobileqq.filemanager.util.h.f(A0, "ipv6_all_switch", sVar.f202778d);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "ipv6_c2c_switch", sVar.f202779e);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "ipv6_group_switch", sVar.f202780f);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "ipv6_disc_switch", sVar.f202781h);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "ipv6_dataline_switch", sVar.f202782i);
            com.tencent.mobileqq.filemanager.util.h.g(A0, "ipv6_strategy", sVar.f202783m);
            Bundle bundle = new Bundle();
            bundle.putBoolean("ipv6_all_switch", sVar.f202778d);
            bundle.putBoolean("ipv6_c2c_switch", sVar.f202779e);
            bundle.putBoolean("ipv6_group_switch", sVar.f202780f);
            bundle.putBoolean("ipv6_disc_switch", sVar.f202781h);
            bundle.putBoolean("ipv6_dataline_switch", sVar.f202782i);
            bundle.putInt("ipv6_strategy", sVar.f202783m);
            QFileConfigManager.J(A0).D0(bundle);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<s> clazz() {
        return s.class;
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
        QLog.i("QFileIPv6ConfigProcessor", 1, "onReqFailed: failCode[" + i3 + "]");
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 449;
    }
}
