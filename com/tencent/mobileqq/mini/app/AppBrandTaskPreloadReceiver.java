package com.tencent.mobileqq.mini.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.mini.fake.FakeSdkReceiver;
import com.tencent.mobileqq.mini.fake.IFakeReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;

/* loaded from: classes33.dex */
public class AppBrandTaskPreloadReceiver extends BroadcastReceiver {
    public static final String ACTION_BASELIB_UPDATED = "mini_baselib_updated";
    public static final String ACTION_KILL = "mini_process_kill";
    public static final String ACTION_PRELOAD_INTERNAL_APP = "mini_preload_internal_app";
    public static final String ACTION_UPDATE_PERIODIC_CACHE = "mini_periodic_cache_update";
    public static final String INTENT_KEY_RETCODE = "key_retcode";
    protected IFakeReceiver mFakeReceiver;

    public IFakeReceiver getFakeBrandUI() {
        IFakeReceiver iFakeReceiver = this.mFakeReceiver;
        if (iFakeReceiver != null) {
            return iFakeReceiver;
        }
        FakeSdkReceiver fakeSdkReceiver = new FakeSdkReceiver();
        this.mFakeReceiver = fakeSdkReceiver;
        return fakeSdkReceiver;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        QLog.i(com.tencent.qqmini.sdk.launcher.AppLoaderFactory.TAG, 1, "AppBrandTaskPreloadReceiver onReceive action: " + intent.getAction());
        getFakeBrandUI().onReceive(context, intent);
        if (this instanceof AppBrandTaskPreloadReceiver3) {
            context.getSharedPreferences(MiniSDKConst.SDK_CONF, 4).edit().putInt(MiniSDKConst.KEY_USE_SDK, 0).apply();
        }
    }
}
