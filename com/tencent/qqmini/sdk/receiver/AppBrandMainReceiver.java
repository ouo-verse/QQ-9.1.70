package com.tencent.qqmini.sdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppBrandMainReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        QMLog.i(AppLoaderFactory.TAG, "AppBrandTaskPreloadReceiver onReceive action: " + intent.getAction());
        MiniSDK.init(context.getApplicationContext());
        AppLoaderFactory.g().getMiniAppEnv().setupWithIntent(intent);
        IReceiverProxy receiverProxy = AppLoaderFactory.g().getMiniAppEnv().getReceiverProxy();
        if (receiverProxy != null) {
            receiverProxy.onReceive(context, intent);
        }
    }
}
