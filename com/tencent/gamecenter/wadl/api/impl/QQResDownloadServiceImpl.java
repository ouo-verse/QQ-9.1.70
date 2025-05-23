package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService;
import com.tencent.gamecenter.wadl.api.IQQResDownloadService;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.notification.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import nl0.h;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQResDownloadServiceImpl implements IQQResDownloadService, h {
    private static final String TAG = "Wadl_QQGameResServiceImpl";
    private CopyOnWriteArrayList<nl0.g> callbacks;
    i tgpaNotification;
    private volatile AtomicBoolean isRelease = new AtomicBoolean(false);
    HashSet<String> cmds = new HashSet<>();

    @Override // com.tencent.gamecenter.wadl.api.IQQResDownloadService
    public void deleteResDownload(String str, String str2, String str3) {
        QLog.i(TAG, 1, "deleteResDownload pkgName=" + str + ",fileName=" + str2 + ",resId=" + str3);
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("packageName", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(WadlProxyConsts.PARAM_FILENAME, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            bundle.putString("resId", str3);
        }
        sendCommandToService(new WadlRequest(2, WadlProxyConsts.REMOTE_CMD_APP_DELETE_ACTION, bundle));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQResDownloadService
    public void downloadRes(WadlParams wadlParams) {
        QLog.d(TAG, 1, "downloadRes wadlParams=" + wadlParams);
        Bundle bundle = new Bundle();
        bundle.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlParams);
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).checkPreload(wadlParams, bundle);
    }

    @Override // nl0.h
    public HashSet<String> getFilterCmds() {
        return this.cmds;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.d(TAG, 1, "onCreate appRuntime=" + appRuntime);
        this.cmds.add(WadlProxyConsts.CMD_TRPC_CHECK_PRE_DOWNLOAD);
        this.callbacks = new CopyOnWriteArrayList<>();
        i iVar = new i();
        this.tgpaNotification = iVar;
        registerResCallBack(iVar);
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).addListener(this);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.callbacks.clear();
        i iVar = this.tgpaNotification;
        if (iVar != null) {
            unRegisterResCallBack(iVar);
            this.tgpaNotification.q();
        }
        g Z = g.Z();
        if (Z != null) {
            Z.destroy();
        }
        this.isRelease.set(true);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQResDownloadService
    public void onQueryCallback(ArrayList<WadlResult> arrayList) {
        Iterator<nl0.g> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().l(arrayList);
        }
    }

    @Override // nl0.h
    public void onTrpcRsp(String str, boolean z16, int i3, int i16, Intent intent, Object obj) {
        QLog.d(TAG, 1, "onTrpcRsp cmd=" + str + ",isSucc=" + z16 + ",trpcRspRetCode=" + i3 + ",trpcRspFuncRetCode=" + i16);
        if (WadlProxyConsts.CMD_TRPC_CHECK_PRE_DOWNLOAD.equals(str) && i3 == 0 && i16 == 0) {
            WadlParams wadlParams = (WadlParams) intent.getExtras().getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO);
            if (wadlParams == null) {
                QLog.w(TAG, 1, "onTrpcRsp checkDownload wadlParams is empty");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("resId", wadlParams.getResId());
            bundle.putInt("actionFrom", wadlParams.from);
            bundle.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlParams);
            sendCommandToService(new WadlRequest(2, WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION, bundle));
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQResDownloadService
    public void onWadlTaskStatusChanged(WadlResult wadlResult) {
        Iterator<nl0.g> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().d(wadlResult);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQResDownloadService
    public void pauseResDownload(String str) {
        QLog.i(TAG, 1, "pauseResDownload resId=" + str);
        Bundle bundle = new Bundle();
        bundle.putString("resId", str);
        sendCommandToService(new WadlRequest(2, WadlProxyConsts.REMOTE_CMD_APP_PAUSE_ACTION, bundle));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQResDownloadService
    public void queryAllResTask() {
        QLog.i(TAG, 1, "queryAllResTask");
        sendCommandToService(new WadlRequest(2, WadlProxyConsts.REMOTE_CMD_QUERY_TASK, null));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQResDownloadService
    public void registerResCallBack(nl0.g gVar) {
        QLog.i(TAG, 1, "registerResCallBack callback=" + gVar);
        if (!this.isRelease.get() && gVar != null && !this.callbacks.contains(gVar)) {
            this.callbacks.add(gVar);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQResDownloadService
    public void resumeResDownload(String str) {
        QLog.i(TAG, 1, "resumeResDownload resId=" + str);
        Bundle bundle = new Bundle();
        bundle.putString("resId", str);
        sendCommandToService(new WadlRequest(2, WadlProxyConsts.REMOTE_CMD_APP_RESUME_ACTION, bundle));
    }

    protected void sendCommandToService(WadlRequest wadlRequest) {
        g Z;
        QLog.i(TAG, 1, "sendCommandToService wadlRequest=" + wadlRequest);
        if (!this.isRelease.get() && wadlRequest != null && (Z = g.Z()) != null) {
            Z.e3(wadlRequest);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQResDownloadService
    public void unRegisterResCallBack(nl0.g gVar) {
        QLog.i(TAG, 1, "registerResCallBack callback=" + gVar);
        if (gVar != null) {
            this.callbacks.remove(gVar);
        }
    }
}
