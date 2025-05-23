package com.tencent.qqmini.sdk.launcher.shell;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* loaded from: classes23.dex */
public interface IAppBrandProxy {
    void init(Context context, IServiceEvent iServiceEvent);

    void notifyShareResult(MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver);

    void onAppBackground(MiniAppInfo miniAppInfo, Bundle bundle);

    void onAppDestroy(MiniAppInfo miniAppInfo, Bundle bundle);

    void onAppForeground(MiniAppInfo miniAppInfo, Bundle bundle);

    void onAppStart(MiniAppInfo miniAppInfo, Bundle bundle);

    void preloadDownloadPackage(MiniAppInfo miniAppInfo, ResultReceiver resultReceiver);

    Bundle requestAync(String str, String str2, Bundle bundle);

    void startMiniApp(Activity activity, MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver);

    void stopAllMiniApp();

    void stopMiniApp(MiniAppInfo miniAppInfo);
}
