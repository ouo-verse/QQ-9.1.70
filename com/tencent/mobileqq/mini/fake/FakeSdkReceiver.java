package com.tencent.mobileqq.mini.fake;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FakeSdkReceiver implements IFakeReceiver {
    public static final String ACTION_KILL = "mini_process_kill";
    public static final String LOG_TAG = "AppBrandReceiver";
    private static int killOtherGamesOnStartFlag = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameKillOtherGamesOnStart", 0);

    @Override // com.tencent.mobileqq.mini.fake.IFakeReceiver
    public void onReceive(Context context, Intent intent) {
        QLog.i(AppLoaderFactory.TAG, 1, "AppBrandTaskPreloadReceiver onReceive action: " + intent.getAction());
        try {
            MiniSDK.init(context.getApplicationContext());
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.mini.fake.FakeSdkReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    FakeSdkBrandUI.initOKHttpClient();
                    FakeSdkBrandUI.setCookie();
                }
            });
            IReceiverProxy receiverProxy = AppLoaderFactory.g().getMiniAppEnv().getReceiverProxy();
            if (receiverProxy != null) {
                receiverProxy.onReceive(context, intent);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
