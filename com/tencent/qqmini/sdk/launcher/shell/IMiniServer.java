package com.tencent.qqmini.sdk.launcher.shell;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IMiniServer {
    IBinder getBinder();

    IMiniServiceManager getMiniServiceManager();

    void init(Context context, Configuration configuration);

    void onHostAppBackground();

    void preDownloadPkg(MiniAppInfo miniAppInfo, ResultReceiver resultReceiver);

    void preloadMiniApp(Bundle bundle);

    void registerClientMessenger(String str, Messenger messenger);

    boolean sendCmdToMiniProcess(int i3, Bundle bundle, MiniAppInfo miniAppInfo, ResultReceiver resultReceiver);

    void setMute(boolean z16);

    void startMiniApp(Activity activity, MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver);
}
