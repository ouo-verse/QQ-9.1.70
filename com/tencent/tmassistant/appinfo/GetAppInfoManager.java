package com.tencent.tmassistant.appinfo;

import com.tencent.tmassistant.appinfo.aidl.GetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;
import com.tencent.tmdownloader.c;

/* compiled from: P */
/* loaded from: classes26.dex */
public class GetAppInfoManager {
    private static volatile GetAppInfoManager sInstance;

    GetAppInfoManager() {
        c.a();
    }

    public static GetAppInfoManager get() {
        if (sInstance == null) {
            synchronized (GetAppInfoManager.class) {
                if (sInstance == null) {
                    sInstance = new GetAppInfoManager();
                }
            }
        }
        return sInstance;
    }

    public int requestAppInfo(AppDetailReqParam appDetailReqParam, GetAppInfoCallback getAppInfoCallback) {
        return c.a().a(appDetailReqParam, getAppInfoCallback);
    }
}
