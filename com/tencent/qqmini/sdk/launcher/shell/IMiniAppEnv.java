package com.tencent.qqmini.sdk.launcher.shell;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IMiniAppEnv {
    IActivityResultManager getActivityResultManager();

    BaselibLoader getBaselibLoader();

    boolean getInnerMode();

    LoginInfo getLoginInfo();

    String getMenuStyle();

    IMiniGameEnv getMiniGameEnv();

    IMiniServiceManager getMiniServiceManager();

    boolean getPreloadApkgState();

    IReceiverProxy getReceiverProxy();

    IShareManager getShareManager();

    IUIProxy getUIProxy(MiniAppInfo miniAppInfo);

    void init(Context context, Configuration configuration);

    void setupWithIntent(Intent intent);
}
