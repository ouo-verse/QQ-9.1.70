package com.tencent.upload.uinterface;

import com.tencent.upload.common.UploadConfiguration;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IUploadEnv {
    String getApnName();

    int getBatchControlCount();

    int getCurrentNetworkCategory();

    int getFileConcurrentCount();

    int getMobileOperatorCategory();

    String getProviderName();

    String getSDKPrivatePath(String str);

    int getSocketCount();

    boolean isAvailable();

    boolean isMobile();

    boolean isWap();

    boolean isWifi();

    void registerNetworkStateObserver(UploadConfiguration.NetworkStateObserver networkStateObserver);
}
