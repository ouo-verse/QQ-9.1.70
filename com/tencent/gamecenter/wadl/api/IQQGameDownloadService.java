package com.tencent.gamecenter.wadl.api;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.entity.f;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameDownloadService extends IRuntimeService {
    void checkYunGameStatus(Bundle bundle);

    void deleteApkDownload(int i3, String str);

    void doAppSystemReceiver(String str, String str2, Bundle bundle);

    void downloadApk(WadlParams wadlParams);

    void downloadApkByIntercept(String str, String str2, int i3, String str3);

    boolean hasUnsentDlCmdWhenProcStartFailed();

    void installApkAction(WadlParams wadlParams);

    boolean isApkFileExpire(String str, String str2);

    void onInstalledEvent(String str);

    void onQueryCallback(ArrayList<WadlResult> arrayList);

    void onQueryCallbackByVia(ArrayList<WadlResult> arrayList);

    void onWadlTaskStatusChanged(WadlResult wadlResult);

    void pauseApkDownload(int i3, String str, String str2);

    void preLaunchWadlService();

    void queryAllApkTask(boolean z16);

    void queryApkTaskByApps(ArrayList<String> arrayList);

    void queryApkTaskByVia(String str);

    f queryFullPkgTask(String str);

    void registerWadlServiceCallBack(WadlProxyServiceCallBackInterface wadlProxyServiceCallBackInterface);

    void reportInstallRequest(String str, boolean z16);

    void resumeApkDownload(int i3, int i16, String str);

    void resumeApkDownload(int i3, String str);

    void runWaitInstallTask();

    void sendCommandToService(WadlRequest wadlRequest);

    void setSpeedBuffer(int i3);

    void syncTaskData(ArrayList<WadlResult> arrayList);

    void unRegisterWadlServiceCallBack(WadlProxyServiceCallBackInterface wadlProxyServiceCallBackInterface);
}
