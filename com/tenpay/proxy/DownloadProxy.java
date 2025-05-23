package com.tenpay.proxy;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* loaded from: classes27.dex */
public class DownloadProxy {
    public static final int DOWN_RES_SUCC = 0;
    public static final String KEY_FILE_PATH = "file_Path";
    public static final String KEY_FOLDER_PATH = "folder_Path";
    public static final String PARAMS_PATH = "path";
    public static final String PARAMS_URL = "url";
    private static final String TAG = "DownloadProxy";

    /* loaded from: classes27.dex */
    public interface OnGetResult {
        void getResult(Object obj);
    }

    public static void downloadUrls(List<String> list, final ResultReceiver resultReceiver) {
        ((IPreloadServiceProxy) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IPreloadServiceProxy.class, ProcessConstant.MULTI)).downloadUrls(list, new IPreloadService.c() { // from class: com.tenpay.proxy.DownloadProxy.1
            @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
            public void onResult(int i3, IPreloadService.PathResult pathResult) {
                if (resultReceiver != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("path", pathResult.filePath);
                    bundle.putString("url", pathResult.url);
                    resultReceiver.send(i3, bundle);
                }
            }
        });
    }

    public static void getPathByResID(String str, ResultReceiver resultReceiver) {
        ((IPreloadServiceProxy) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IPreloadServiceProxy.class, ProcessConstant.MULTI)).getFilePathByResID(str, resultReceiver);
    }

    public static String getPathByUrl(String str) {
        return com.tencent.mobileqq.qwallet.preload.a.n(str);
    }

    public static void getResPath(String str, final ResultReceiver resultReceiver) {
        ((IPreloadServiceProxy) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IPreloadServiceProxy.class, ProcessConstant.MULTI)).getResPath(str, new IPreloadService.c() { // from class: com.tenpay.proxy.DownloadProxy.2
            @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
            public void onResult(int i3, IPreloadService.PathResult pathResult) {
                if (resultReceiver != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(DownloadProxy.KEY_FILE_PATH, pathResult.filePath);
                    bundle.putString(DownloadProxy.KEY_FOLDER_PATH, pathResult.folderPath);
                    resultReceiver.send(i3, bundle);
                }
            }
        });
    }
}
