package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameDLServiceImpl implements IQQGameDLService {
    private static final String TAG = "VM_QQGameVMServiceImpl";
    private CopyOnWriteArrayList<nl0.d> callbacks;
    private volatile AtomicBoolean isRelease = new AtomicBoolean(false);
    private kl0.c simpleDBHelper = new kl0.c();

    private void clearAppidDownloadInfo(String str) {
        GameCenterUtil.deleteAppidFromList(str, "VM_DELAY_LIST");
        GameCenterUtil.delAppDetail(str, "VM_DELAY_APPID_DETAIL_");
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void deleteDownload(int i3, String str) {
        QLog.d(TAG, 1, "deleteDownload packageName=" + str + ",businessId=" + i3);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        sendCommandToService(new WadlRequest(i3, WadlProxyConsts.REMOTE_CMD_APP_DELETE_ACTION), bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void doAppSystemReceiver(String str, String str2) {
        boolean a16 = this.simpleDBHelper.a(str2);
        QLog.d(TAG, 1, "doAppSystemReceiver cmd=" + str + ",packageName=" + str2 + ",exists=" + a16);
        if (!a16) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str2);
        sendCommandToService(new WadlRequest(3, str, bundle), bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void doDownloadAction(int i3, WadlParams wadlParams) {
        QLog.d(TAG, 1, "doDownloadAction wadlParams=" + wadlParams + ",businessId=" + i3);
        if (wadlParams == null) {
            return;
        }
        clearAppidDownloadInfo(wadlParams.appId);
        if (wadlParams.from == 2) {
            wadlParams.setFlags(8);
        }
        setSpeedBuffer(i3, wadlParams.speedBuffer);
        Bundle bundle = new Bundle();
        bundle.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlParams);
        sendCommandToService(new WadlRequest(i3, WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION), bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void doInstallAction(int i3, String str) {
        QLog.d(TAG, 1, "doInstallAction packageName=" + str + ",businessId=" + i3);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        sendCommandToService(new WadlRequest(i3, WadlProxyConsts.REMOTE_CMD_APP_INSTALL_ACTION), bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void doPauseAction(int i3, String str) {
        QLog.d(TAG, 1, "doPauseAction packageName=" + str + ",businessId=" + i3);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        sendCommandToService(new WadlRequest(i3, WadlProxyConsts.REMOTE_CMD_APP_PAUSE_ACTION), bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void doQueryAllTask(int i3) {
        QLog.d(TAG, 1, "doQueryAllTask businessId=" + i3);
        sendCommandToService(new WadlRequest(i3, WadlProxyConsts.REMOTE_CMD_QUERY_TASK), null);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void doResumeAction(int i3, String str) {
        QLog.d(TAG, 1, "doResumeAction packageName=" + str + ",businessId=" + i3);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        sendCommandToService(new WadlRequest(i3, WadlProxyConsts.REMOTE_CMD_APP_RESUME_ACTION), bundle);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.d(TAG, 1, "onCreate appRuntime=" + appRuntime);
        this.callbacks = new CopyOnWriteArrayList<>();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.callbacks.clear();
        g Z = g.Z();
        if (Z != null) {
            Z.destroy();
        }
        this.isRelease.set(true);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void onQueryCallback(ArrayList<WadlResult> arrayList) {
        Iterator<nl0.d> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onQueryCallback(arrayList);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void onWadlTaskStatusChanged(WadlResult wadlResult) {
        Iterator<nl0.d> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onWadlStatusChanged(wadlResult);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void receiveVMAction(Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("key_event_id", -1);
        QLog.d(TAG, 1, "receiveVMAction eventId=" + intExtra);
        if (intExtra != 1) {
            if (intExtra != 3) {
                if (intExtra != 5) {
                    if (intExtra == 6) {
                        String stringExtra = intent.getStringExtra("appid");
                        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
                        if (iMiniAppService != null) {
                            iMiniAppService.startAppByAppid(MobileQQ.sMobileQQ, stringExtra, "", "", LaunchScene.LAUNCH_SCENE_VM_NOTIFICATION, null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                doPauseAction(3, intent.getStringExtra("packageName"));
                return;
            }
            GameCenterUtil.goToInstall(intent.getStringExtra("appid"), intent.getStringExtra("packageName"), intent.getStringExtra(WadlProxyConsts.KEY_LOCAL_APK_PATH), null, "notification");
            return;
        }
        doResumeAction(3, intent.getStringExtra("packageName"));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void registerDownloadCallBack(nl0.d dVar) {
        QLog.d(TAG, 1, "registerDownloadCallBack callback=" + dVar);
        if (!this.isRelease.get() && dVar != null && !this.callbacks.contains(dVar)) {
            this.callbacks.add(dVar);
        }
    }

    protected void sendCommandToService(WadlRequest wadlRequest, Bundle bundle) {
        QLog.i(TAG, 1, "sendCommandToService wadlRequest=" + wadlRequest);
        if (this.isRelease.get()) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        wadlRequest.f106596h = bundle;
        g Z = g.Z();
        if (Z != null) {
            Z.e3(wadlRequest);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void setSpeedBuffer(int i3, int i16) {
        QLog.d(TAG, 1, "setSpeedBuffer speedBuffer=" + i16 + ",businessId=" + i3);
        Bundle bundle = new Bundle();
        bundle.putInt(WadlProxyConsts.PARAM_SPEED_BUFFER, i16);
        sendCommandToService(new WadlRequest(i3, WadlProxyConsts.REMOTE_CMD_SET_SPEED_BUFFER), bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLService
    public void unRegisterDownloadCallBack(nl0.d dVar) {
        QLog.d(TAG, 1, "unRegisterDownloadCallBack callback=" + dVar);
        if (dVar != null) {
            this.callbacks.remove(dVar);
        }
    }
}
