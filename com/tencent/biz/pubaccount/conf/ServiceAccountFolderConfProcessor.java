package com.tencent.biz.pubaccount.conf;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import gy.e;
import mqq.app.AppRuntime;

/* loaded from: classes4.dex */
public class ServiceAccountFolderConfProcessor extends l<e> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e migrateOldOrDefaultContent(int i3) {
        if (i3 == 0) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderConfigData((QQAppInterface) runtime, true);
                return e.c();
            }
        }
        return new e();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderConfProcessor", 2, "[onParsed]");
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            return e.f(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(e eVar) {
        eVar.d();
        eVar.b();
        eVar.j();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<e> clazz() {
        return e.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderConfigVersionCode((QQAppInterface) runtime);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 81;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
