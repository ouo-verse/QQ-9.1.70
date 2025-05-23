package com.tencent.qzonehub.api.impl;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.f;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import com.tencent.qzonehub.api.IQzonePatchApi;
import cooperation.qzone.patch.QZonePatchRequest;
import cooperation.qzone.patch.QZonePatchService;
import cooperation.qzone.patch.QzoneUpdatePatchServlet;
import cooperation.qzone.plugin.PluginIntent;
import cooperation.qzone.plugin.QZonePluginUtils;

/* loaded from: classes34.dex */
public class QzonePatchApiImpl implements IQzonePatchApi {
    private boolean isLastSuccess;
    private boolean isRequesting;

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePatchResp(SQ_CLIENT_UPDATE_RSP sq_client_update_rsp) {
        if (QLog.isColorLevel()) {
            QLog.d(IQzonePatchApi.TAG, 2, "\u6536\u5230\u8865\u4e01\u5305\u4fe1\u606f\uff1a" + sq_client_update_rsp);
        }
        if (sq_client_update_rsp != null) {
            String str = sq_client_update_rsp.md5;
            String str2 = sq_client_update_rsp.upUrl;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(IQzonePatchApi.TAG, 2, "patchMd5\uff1a" + str + ", patchUrl:" + str2);
            }
            QZonePatchService.getInstance().onPatchResponse(str, str2);
        }
    }

    @Override // com.tencent.qzonehub.api.IQzonePatchApi
    public String getLoadQZoneLivePluginId() {
        return QZonePluginUtils.getLoadQZoneLivePluginId();
    }

    @Override // com.tencent.qzonehub.api.IQzonePatchApi
    public void getPatchList() {
        if (!this.isRequesting && !this.isLastSuccess) {
            this.isRequesting = true;
            PluginIntent pluginIntent = new PluginIntent(BaseApplication.getContext(), QzoneUpdatePatchServlet.class);
            pluginIntent.module_update_infos = ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).getUpdateInfo();
            pluginIntent.setResultListner(new a());
            return;
        }
        QLog.d(IQzonePatchApi.TAG, 2, "getPatchList() isRequesting:" + this.isRequesting + ", isLastSuccess:" + this.isLastSuccess);
    }

    @Override // com.tencent.qzonehub.api.IQzonePatchApi
    public void triggerQQDownloadPtuFilter() {
        if (QLog.isColorLevel()) {
            QLog.d(IQzonePatchApi.TAG, 1, "triggerQQDownloadPtuFilter");
        }
        if (f.m()) {
            QLog.w(IQzonePatchApi.TAG, 1, "triggerQQDownloadPtuFilter");
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.AE_RES_BASE_PACKAGE);
        }
    }

    /* loaded from: classes34.dex */
    class a implements PluginIntent.OnResultListner {
        a() {
        }

        @Override // cooperation.qzone.plugin.PluginIntent.OnResultListner
        public void onRecieve(Intent intent, FromServiceMsg fromServiceMsg) {
            if (fromServiceMsg == null || fromServiceMsg.getResultCode() != 1000) {
                QzonePatchApiImpl.this.isLastSuccess = false;
            } else {
                SQ_CLIENT_UPDATE_RSP onResponse = QZonePatchRequest.onResponse(fromServiceMsg.getWupBuffer());
                QzonePatchApiImpl.this.handlePatchResp(onResponse);
                ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).handleModuleRsp(onResponse);
                QzonePatchApiImpl.this.isLastSuccess = onResponse != null;
            }
            QzonePatchApiImpl.this.isRequesting = false;
        }
    }
}
