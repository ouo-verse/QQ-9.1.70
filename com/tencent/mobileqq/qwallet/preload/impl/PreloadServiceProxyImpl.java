package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PreloadServiceProxyImpl extends PreloadManagerAbs implements IPreloadServiceProxy {
    private static final String TAG = "PreloadServiceProxy";

    /* loaded from: classes16.dex */
    class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f279090d;

        a(ResultReceiver resultReceiver) {
            this.f279090d = resultReceiver;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult != null && eIPCResult.isSuccess()) {
                this.f279090d.send(0, eIPCResult.data);
            } else {
                this.f279090d.send(0, new Bundle());
            }
        }
    }

    /* loaded from: classes16.dex */
    class b implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPreloadService.c f279092d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DownloadParam f279093e;

        b(IPreloadService.c cVar, DownloadParam downloadParam) {
            this.f279092d = cVar;
            this.f279093e = downloadParam;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle bundle;
            if (eIPCResult != null && eIPCResult.isSuccess() && (bundle = eIPCResult.data) != null) {
                int i3 = bundle.getInt("result_code");
                IPreloadService.PathResult pathResult = (IPreloadService.PathResult) eIPCResult.data.getSerializable("path_result");
                IPreloadService.c cVar = this.f279092d;
                if (cVar != null) {
                    cVar.onResult(i3, pathResult);
                    return;
                }
                return;
            }
            IPreloadService.c cVar2 = this.f279092d;
            if (cVar2 != null) {
                cVar2.onResult(1, IPreloadService.PathResult.getFailRes(this.f279093e.url));
            }
        }
    }

    /* loaded from: classes16.dex */
    class c implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPreloadService.d f279095d;

        c(IPreloadService.d dVar) {
            this.f279095d = dVar;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle bundle;
            if (eIPCResult != null && eIPCResult.isSuccess() && (bundle = eIPCResult.data) != null) {
                int i3 = bundle.getInt("result_code");
                HashMap<String, IPreloadService.PathResult> hashMap = (HashMap) eIPCResult.data.getSerializable("path_result");
                IPreloadService.d dVar = this.f279095d;
                if (dVar != null) {
                    dVar.onResult(i3, hashMap);
                    return;
                }
                return;
            }
            IPreloadService.d dVar2 = this.f279095d;
            if (dVar2 != null) {
                dVar2.onResult(1, null);
            }
        }
    }

    private void download(String str, Bundle bundle, final IPreloadService.a aVar, final String str2) {
        bundle.putParcelable("receiver", com.tencent.mobileqq.qwallet.preload.a.t(new ResultReceiver(null) { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceProxyImpl.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle2) {
                if (i3 == 0 && bundle2 != null) {
                    String string = bundle2.getString("id");
                    int i16 = bundle2.getInt("result");
                    String string2 = bundle2.getString("path");
                    ResourceInfo resourceInfo = (ResourceInfo) bundle2.getSerializable(IPreloadServiceProxy.KEY_RESINFO);
                    if (QLog.isColorLevel()) {
                        QLog.d(PreloadServiceProxyImpl.TAG, 2, "PreloadServiceProxyImpl downloadModule" + string2 + "|" + resourceInfo);
                    }
                    aVar.onDownloadResFinished(string, i16, string2, resourceInfo);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(PreloadServiceProxyImpl.TAG, 2, "PreloadServiceProxyImpl downloadModule IPC wrong");
                }
                aVar.onDownloadResFinished(str2, -8, null, null);
            }
        }));
        if (str.equals("downloadModule")) {
            QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "downloadModule", bundle, null);
        } else if (str.equals("downloadRes")) {
            QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "downloadRes", bundle, null);
        }
    }

    private static boolean isMainProcess() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    @Deprecated
    public void downloadModule(String str, String str2, IPreloadService.a aVar) {
        if (!isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putString(IPreloadServiceProxy.KEY_DOWNLOAD_CONFIG_STR, str2);
            download("downloadModule", bundle, aVar, str);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    @Deprecated
    public void downloadRes(String str, String str2, IPreloadService.a aVar) {
        if (!isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putString(IPreloadServiceProxy.KEY_DOWNLOAD_CONFIG_STR, str2);
            download("downloadRes", bundle, aVar, null);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public void downloadUrls(List<String> list, final IPreloadService.c cVar) {
        if (list != null && list.size() > 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("method_type", 2);
            bundle.putStringArray("url", (String[]) list.toArray(new String[list.size()]));
            bundle.putParcelable("receiver", com.tencent.mobileqq.qwallet.preload.a.t(new ResultReceiver(null) { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceProxyImpl.5
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int i3, Bundle bundle2) {
                    if (i3 == 0 && bundle2 != null) {
                        int i16 = bundle2.getInt("result_code");
                        IPreloadService.PathResult pathResult = (IPreloadService.PathResult) bundle2.getSerializable("path_result");
                        IPreloadService.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onResult(i16, pathResult);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(PreloadServiceProxyImpl.TAG, 2, "downloadUrls" + pathResult);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(PreloadServiceProxyImpl.TAG, 2, "downloadUrls IPC wrong");
                    }
                    IPreloadService.c cVar3 = cVar;
                    if (cVar3 != null) {
                        cVar3.onResult(1, IPreloadService.PathResult.getFailRes(null));
                    }
                }
            }));
            QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "preloadCommon", bundle, null);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public void getFilePathByResID(String str, ResultReceiver resultReceiver) {
        if (resultReceiver == null) {
            return;
        }
        if (!isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "getFilePathByResID", bundle, new a(resultReceiver));
            return;
        }
        resultReceiver.send(0, new Bundle());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ResourceInfo getResInfoByResId(String str) {
        ResourceInfo resourceInfo;
        if (!isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString(IPreloadServiceProxy.KEY_RESID, str);
            com.tencent.mobileqq.qwallet.ipc.impl.a.h().f();
            EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QWalletIPCModule", "getResInfoByResID", bundle);
            if (callServer != null && callServer.isSuccess()) {
                resourceInfo = (ResourceInfo) callServer.data.getSerializable(IPreloadServiceProxy.KEY_RESINFO);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getResInfoByResID:" + resourceInfo);
                }
                return resourceInfo;
            }
        }
        resourceInfo = null;
        if (QLog.isColorLevel()) {
        }
        return resourceInfo;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public void getResPath(DownloadParam downloadParam, IPreloadService.c cVar) {
        if (downloadParam == null || TextUtils.isEmpty(downloadParam.url)) {
            return;
        }
        if (isMainProcess()) {
            if (cVar != null) {
                cVar.onResult(1, IPreloadService.PathResult.getFailRes(downloadParam.url));
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt("method_type", 1);
            bundle.putSerializable("download_params", downloadParam);
            QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "preloadCommon", bundle, new b(cVar, downloadParam));
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.impl.PreloadManagerAbs, com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public String getVideoResPathByID(String str) {
        String str2 = null;
        if (!isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString("mid", str);
            com.tencent.mobileqq.qwallet.ipc.impl.a.h().f();
            EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QWalletIPCModule", "getVideoResPathByMID", bundle);
            if (callServer != null && callServer.isSuccess()) {
                str2 = callServer.data.getString("path");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getVideoResPathByID:" + str + "|" + str2);
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.impl.PreloadManagerAbs, mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        super.onCreate(appRuntime);
        com.tencent.mobileqq.qwallet.ipc.impl.a.h().f();
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public PreloadResourceImpl getResourceByResID(String str) {
        PreloadResourceImpl preloadResourceImpl = null;
        if (!isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString(IPreloadServiceProxy.KEY_RESID, str);
            com.tencent.mobileqq.qwallet.ipc.impl.a.h().f();
            EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QWalletIPCModule", "getResourceByResID", bundle);
            if (callServer != null && callServer.isSuccess()) {
                preloadResourceImpl = (PreloadResourceImpl) callServer.data.getSerializable(IPreloadServiceProxy.KEY_RESINFO);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getResourceByResID:" + str + "|" + preloadResourceImpl);
        }
        return preloadResourceImpl;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public void getResPath(LinkedList<DownloadParam> linkedList, IPreloadService.d dVar) {
        if (linkedList == null) {
            if (dVar != null) {
                dVar.onResult(1, null);
            }
        } else if (isMainProcess()) {
            if (dVar != null) {
                dVar.onResult(1, null);
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt("method_type", 3);
            bundle.putSerializable("download_params", linkedList);
            QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "preloadCommon", bundle, new c(dVar));
        }
    }
}
