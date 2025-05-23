package com.tencent.gamecenter.wadl.api.impl;

import com.tencent.gamecenter.wadl.api.IQQGameAutoUpdateService;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.biz.AutoUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameAutoUpdateServiceImpl implements IQQGameAutoUpdateService {
    private static final String TAG = "Wadl_QQGameAutoUpdateServiceImpl";
    private AutoUpdateBusiness mAutoUpdateBusiness;

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IQQGameCheckService iQQGameCheckService = (IQQGameCheckService) appRuntime.getRuntimeService(IQQGameCheckService.class, "");
        AutoUpdateBusiness autoUpdateBusiness = new AutoUpdateBusiness();
        this.mAutoUpdateBusiness = autoUpdateBusiness;
        autoUpdateBusiness.k(iQQGameCheckService);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, "---onDestroy---");
        AutoUpdateBusiness autoUpdateBusiness = this.mAutoUpdateBusiness;
        if (autoUpdateBusiness != null) {
            autoUpdateBusiness.l();
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameAutoUpdateService
    public void pullAutoUpdateTask(boolean z16) {
        QLog.i(TAG, 1, "pullAutoUpdateTask mAutoUpdateBusiness=" + this.mAutoUpdateBusiness + ",isForce=" + z16);
        AutoUpdateBusiness autoUpdateBusiness = this.mAutoUpdateBusiness;
        if (autoUpdateBusiness != null) {
            autoUpdateBusiness.h(z16);
        }
    }
}
