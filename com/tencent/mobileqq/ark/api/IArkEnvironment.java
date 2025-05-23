package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkEnvironment extends QRouteApi {
    String getAppDebugInstallDirectory();

    String getRootDirectory();

    void initJSCLibPath();

    void initMultiProcEnv(IArkEnvDelegate iArkEnvDelegate, boolean z16);

    boolean isDebugMode();

    boolean isJSCLibExist();

    boolean isTestEnv();

    void onConfigurationChanged();

    void setDebugMode(boolean z16);

    void setScriptLeakCheckEnabled(boolean z16);
}
