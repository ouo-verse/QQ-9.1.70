package com.tencent.gamecenter.wadl.api.impl;

import com.tencent.gamecenter.wadl.api.IQQGameAutoDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.biz.AutoDownloadBusiness;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.qqgame.QQGameAutoDownloadTask$GetPreCircleResponse;
import tencent.im.qqgame.QQGameAutoDownloadTask$GetPreUpdateResponse;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameAutoDownloadServiceImpl implements IQQGameAutoDownloadService {
    private static final String TAG = "Wadl_QQGameAutoDownloadServiceImpl";
    private AutoDownloadBusiness mAutoDownloadBusiness;

    public AutoDownloadBusiness getAutoDownloadBusiness() {
        if (this.mAutoDownloadBusiness == null) {
            QLog.i(TAG, 1, "AutoDownloadBusiness is null!!!");
        }
        return this.mAutoDownloadBusiness;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameAutoDownloadService
    public void handleAutoDownloadFail(int i3) {
        if (getAutoDownloadBusiness() != null) {
            getAutoDownloadBusiness().m(i3);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameAutoDownloadService
    public void handleCircleAutoDownloadSuccess(QQGameAutoDownloadTask$GetPreCircleResponse qQGameAutoDownloadTask$GetPreCircleResponse) {
        if (getAutoDownloadBusiness() != null) {
            getAutoDownloadBusiness().n(qQGameAutoDownloadTask$GetPreCircleResponse);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameAutoDownloadService
    public void handleUpdateAutoDownloadSuccess(QQGameAutoDownloadTask$GetPreUpdateResponse qQGameAutoDownloadTask$GetPreUpdateResponse) {
        if (getAutoDownloadBusiness() != null) {
            getAutoDownloadBusiness().o(qQGameAutoDownloadTask$GetPreUpdateResponse);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        AutoDownloadBusiness autoDownloadBusiness = new AutoDownloadBusiness();
        this.mAutoDownloadBusiness = autoDownloadBusiness;
        autoDownloadBusiness.p((IQQGameCheckService) appRuntime.getRuntimeService(IQQGameCheckService.class, ""));
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, "---onDestroy---");
        if (getAutoDownloadBusiness() != null) {
            getAutoDownloadBusiness().q();
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameAutoDownloadService
    public void pullAutoDownloadTask() {
        if (getAutoDownloadBusiness() == null) {
            return;
        }
        QLog.i(TAG, 1, "---start pullAutoDownloadTask---");
        try {
            getAutoDownloadBusiness().i();
            getAutoDownloadBusiness().j();
        } catch (Throwable th5) {
            QLog.e(TAG, 2, th5.getLocalizedMessage());
        }
    }
}
