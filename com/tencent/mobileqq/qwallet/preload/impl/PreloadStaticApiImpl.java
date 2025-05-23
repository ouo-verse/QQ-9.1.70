package com.tencent.mobileqq.qwallet.preload.impl;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.d;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import eipc.EIPCResult;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* loaded from: classes16.dex */
public class PreloadStaticApiImpl implements IPreloadStaticApi {
    private static final int SAFE_FREE_SPACE = 52428800;
    private static final String TAG = "PreloadStaticApi";

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public void deleteRes(String str, boolean z16, int i3) {
        ResourceInfo resInfoByUrl = getResInfoByUrl(str, z16, i3);
        if (resInfoByUrl != null) {
            c.k(str, i3);
            d.d(resInfoByUrl.filePath);
            d.d(resInfoByUrl.folderPath);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public String getConfigFromQQ(String str) {
        SharedPreferences sharedPreferences;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null || (sharedPreferences = mobileQQ.getSharedPreferences(IPreloadService.PREF_NAME_QWALLET_PRELOAD_CONFIG, 4)) == null) {
            return null;
        }
        return sharedPreferences.getString(IPreloadService.KEY_CONFIG_FROM_QQ + str, null);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public String getFolderPathByMD5AndUrl(String str, String str2, int i3) {
        return PreloadResourceImpl.getFolderPathByMD5AndUrl(str, str2, i3);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public IPreloadServiceAbs getInstance() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            return (IPreloadServiceAbs) peekAppRuntime.getRuntimeService(IPreloadService.class, "");
        }
        return (IPreloadServiceAbs) peekAppRuntime.getRuntimeService(IPreloadServiceProxy.class, ProcessConstant.MULTI);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public String getRealMd5(String str, String str2, int i3) {
        return c.e(str, str2, i3);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public ResourceInfo getResInfoByUrl(String str, boolean z16, int i3) {
        ResourceInfo f16 = c.f(str, z16, 0, i3);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getResInfoByUrl :" + str + "|" + z16 + "|" + f16);
        }
        return f16;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public IPreloadService.PathResult getResPathSync(DownloadParam downloadParam) {
        Bundle bundle;
        if (QWalletHelperImpl.getAppRuntime() instanceof BaseQQAppInterface) {
            if (QLog.isColorLevel()) {
                QLog.d("PreloadServiceImpl", 2, "getResPathSync: param" + downloadParam);
            }
            if (downloadParam == null || TextUtils.isEmpty(downloadParam.url)) {
                return null;
            }
            downloadParam.standardlize();
            ResourceInfo resInfoByUrl = getResInfoByUrl(downloadParam.url, downloadParam.isForceUnzip, downloadParam.filePos);
            if (!isFileValid(resInfoByUrl, downloadParam)) {
                return null;
            }
            IPreloadService.PathResult pathResult = new IPreloadService.PathResult();
            pathResult.url = downloadParam.url;
            pathResult.filePath = resInfoByUrl.filePath;
            pathResult.folderPath = resInfoByUrl.folderPath;
            pathResult.isAlreadyExist = true;
            return pathResult;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("method_type", 4);
        bundle2.putSerializable("download_params", downloadParam);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QWalletIPCModule", "preloadCommon", bundle2);
        if (callServer != null && callServer.isSuccess() && (bundle = callServer.data) != null) {
            try {
                return (IPreloadService.PathResult) bundle.getSerializable("path_result");
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public String getResourcePathByUrl(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            String g16 = com.tencent.mobileqq.qwallet.preload.a.g(str, i3);
            if (!TextUtils.isEmpty(g16) && new File(g16).exists()) {
                c.n(str, i3, NetConnInfoCenter.getServerTimeMillis());
                return g16;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public String getUnzipFolderPath(String str) {
        ResourceInfo f16 = c.f(str, false, 0, 0);
        if (f16 != null) {
            return f16.folderPath;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public boolean isDiskEnoughToUnzip(String str) {
        long j3;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!TextUtils.isEmpty(str)) {
            j3 = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getFreeSpace(str);
            if (j3 > IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "isDiskEnoughToUnzip|true|" + str + "|" + j3);
                    return true;
                }
                return true;
            }
        } else {
            j3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isDiskEnoughToUnzip|false|" + str + "|" + j3);
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public boolean isFileValid(ResourceInfo resourceInfo, DownloadParam downloadParam) {
        if (downloadParam != null && resourceInfo != null && !TextUtils.isEmpty(resourceInfo.filePath)) {
            String str = downloadParam.md5;
            boolean z16 = downloadParam.isForceUnzip;
            String str2 = downloadParam.md5ForChecked;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(resourceInfo.filePath) && !str.equalsIgnoreCase(resourceInfo.fileMd5)) {
                return false;
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(resourceInfo.filePath) && !str2.equalsIgnoreCase(resourceInfo.fileMd5)) {
                return false;
            }
            if ((!z16 && !isNeedAutoUnzip(resourceInfo.url, 0)) || !TextUtils.isEmpty(resourceInfo.folderPath)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public boolean isFolderPathValid(String str) {
        return PreloadResourceImpl.isFolderPathValid(str);
    }

    public boolean isNeedAutoUnzip(String str, int i3) {
        if (i3 != 4) {
            if (str == null || str.length() <= 5 || !str.substring(str.length() - 4).equals(".zip")) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
    public synchronized boolean unzipAtomically(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!isDiskEnoughToUnzip(str2)) {
                return false;
            }
            return d.C(str, str2);
        }
        return false;
    }
}
