package com.tencent.mobileqq.qwallet.preload.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public abstract class PreloadManagerAbs implements IPreloadServiceAbs {
    private int transType2Int(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.equalsIgnoreCase("WiFi")) {
            return 1;
        }
        if (str.equalsIgnoreCase("4G")) {
            return 4;
        }
        if (str.equalsIgnoreCase("3G")) {
            return 3;
        }
        if (str.equalsIgnoreCase("2G")) {
            return 2;
        }
        if (!str.equalsIgnoreCase("5G")) {
            return 0;
        }
        return 6;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public void getResPath(String str, IPreloadService.c cVar) {
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.url = str;
        getResPath(downloadParam, cVar);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public String getVideoResPathByID(String str) {
        return null;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public boolean isNetValidToDownload(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String[] split = str.split("\\|");
        int systemNetwork = NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ);
        for (String str2 : split) {
            if (transType2Int(str2) == systemNetwork) {
                return true;
            }
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.d("PreloadManagerAbs", 1, "onCreate: ");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
