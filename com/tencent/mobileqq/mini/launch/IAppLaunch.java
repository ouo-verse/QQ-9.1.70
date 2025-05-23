package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IAppLaunch {
    void preloadMiniApp();

    void sendCmd(String str, Bundle bundle, CmdCallback cmdCallback);

    void startMiniApp(Activity activity, MiniAppConfig miniAppConfig, ResultReceiver resultReceiver);
}
