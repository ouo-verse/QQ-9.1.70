package com.tencent.biz.pubaccount.conf;

import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import gy.b;
import mqq.app.AppRuntime;

/* loaded from: classes32.dex */
public class PublicAccountCenterUrlConfProcessor extends l<b> {
    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountCenterUrlConfProcessor", 2, "[onParsed]");
        }
        if (aiVarArr == null || aiVarArr.length <= 0) {
            return null;
        }
        return b.e(aiVarArr);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(b bVar) {
        bVar.c();
        bVar.f();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<b> clazz() {
        return b.class;
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
        if (!(runtime instanceof QQAppInterface)) {
            return 0;
        }
        return ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountCenterUrlConfigVersionCode((QQAppInterface) runtime);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 70;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b migrateOldOrDefaultContent(int i3) {
        if (i3 == 0) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).loadPublicAccountCenterUrlConfig(qQAppInterface, ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountCenterUrlConfigData(qQAppInterface));
                return b.b();
            }
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
