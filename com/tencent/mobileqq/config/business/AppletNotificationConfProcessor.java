package com.tencent.mobileqq.config.business;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class AppletNotificationConfProcessor extends com.tencent.mobileqq.config.l<b> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b migrateOldOrDefaultContent(int i3) {
        return new b();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        com.tencent.mobileqq.config.ai aiVar;
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            b a16 = b.a(aiVar.f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("AppletNotificationConfProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return a16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppletNotificationConfProcessor", 2, "onParsed is null");
        }
        AppletsFolderManager.s(true);
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(b bVar) {
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AppletNotificationConfProcessor", 2, "onUpdate but newConf==null");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("AppletNotificationConfProcessor", 2, "onUpdate " + bVar.toString());
            }
            AppletsFolderManager.s(true);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<b> clazz() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return false;
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
        if (QLog.isColorLevel()) {
            QLog.d("AppletNotificationConfProcessor", 2, "migrateOldVersion");
        }
        AppletsFolderManager.s(true);
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AppletNotificationConfProcessor", 2, "onReqFailed ", Integer.valueOf(i3));
        }
        AppletsFolderManager.s(true);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 597;
    }
}
