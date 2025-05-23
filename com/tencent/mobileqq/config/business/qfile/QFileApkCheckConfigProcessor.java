package com.tencent.mobileqq.config.business.qfile;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.as;
import com.tencent.mobileqq.filemanager.api.IFileDataStorageUtil;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class QFileApkCheckConfigProcessor extends com.tencent.mobileqq.config.l<i> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public i migrateOldOrDefaultContent(int i3) {
        QLog.i("QFileApkCheckConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + i3 + "]");
        return new i();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i onParsed(ai[] aiVarArr) {
        QLog.i("QFileApkCheckConfigProcessor", 1, "onParsed");
        if (aiVarArr != null) {
            try {
                if (aiVarArr.length > 0) {
                    return (i) as.e(aiVarArr[0].f202268b, i.class);
                }
                return null;
            } catch (QStorageInstantiateException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(i iVar) {
        QQAppInterface qQAppInterface;
        if (iVar == null) {
            QLog.i("QFileApkCheckConfigProcessor", 1, "apkcheckConfig onUpdate: newConf is null.");
            return;
        }
        QLog.i("QFileApkCheckConfigProcessor", 1, "apkcheckConfig onUpdate");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) runtime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            ((IFileDataStorageUtil) QRoute.api(IFileDataStorageUtil.class)).putBool(qQAppInterface, "apkcheck_enable_switch", iVar.f202741a);
            ((IQFileConfigManager) qQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).setMMApkFileCheckEnable(iVar.f202741a);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<i> clazz() {
        return i.class;
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
        QLog.i("QFileApkCheckConfigProcessor", 1, "onReqFailed: failCode[" + i3 + "]");
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 663;
    }
}
