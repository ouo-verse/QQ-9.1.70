package com.tencent.mobileqq.mini.share;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.ResultReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.MiniAppStartUtils;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.util.QQToastUtil;

/* compiled from: P */
/* loaded from: classes33.dex */
public class WXShareHelperFromQQMiniApp extends BroadcastReceiver implements IWXAPIEventHandler {
    private static final int LAUNCH_WX_PENDING_INTENT_REQUEST_CODE = 1;
    private static final String TAG = "WXShareHelperFromQQMiniApp";
    public static final String WX_APPID_DEBUG = "wx76a769350165bcff";
    public static final String WX_APPID_RELEASE = "wxf0a80d0ac2e82aa7";
    private static final byte[] lock = new byte[0];
    private static WXShareHelperFromQQMiniApp mWxShareHelperFromQQMiniApp;
    private LaunchParam launchParamFromQQ;
    private MiniAppInfo miniAppInfoFromQQ;
    private com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfoFromSDK;
    private String mWxAppId = "wxf0a80d0ac2e82aa7";
    private IWXAPI api = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), this.mWxAppId, true);

    public WXShareHelperFromQQMiniApp() {
        BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
        registerApp();
    }

    public static WXShareHelperFromQQMiniApp getInstance() {
        if (mWxShareHelperFromQQMiniApp == null) {
            synchronized (lock) {
                if (mWxShareHelperFromQQMiniApp == null) {
                    mWxShareHelperFromQQMiniApp = new WXShareHelperFromQQMiniApp();
                }
            }
        }
        return mWxShareHelperFromQQMiniApp;
    }

    public void handleWXEntryActivityIntent(Activity activity, Intent intent) {
        String str;
        LaunchParam launchParam;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleWXEntryActivityIntent");
        }
        if (this.api != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "handleWXEntryActivityIntent api != null");
            }
            this.api.handleIntent(intent, this);
        }
        MiniAppInfo miniAppInfo = this.miniAppInfoFromQQ;
        if (miniAppInfo != null && (launchParam = this.launchParamFromQQ) != null) {
            MiniAppLauncher.launchAppByAppInfo(activity, miniAppInfo, launchParam, (ResultReceiver) null);
            this.miniAppInfoFromQQ = null;
            this.launchParamFromQQ = null;
            return;
        }
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo2 = this.miniAppInfoFromSDK;
        if (miniAppInfo2 != null) {
            com.tencent.qqmini.sdk.launcher.model.LaunchParam launchParam2 = miniAppInfo2.launchParam;
            if (launchParam2 != null) {
                str = String.valueOf(launchParam2.scene);
            } else {
                str = "";
            }
            if (MiniAppStartUtils.shouldInterceptStartMiniApp(this.miniAppInfoFromSDK.appId, str)) {
                QLog.i(TAG, 1, "study mode, can't start in current scene = " + str);
                QQToastUtil.showQQToast(0, R.string.f167672dk);
                return;
            }
            MiniSDK.startMiniApp(activity, this.miniAppInfoFromSDK);
            this.miniAppInfoFromSDK = null;
        }
    }

    public void recordMiniAppInfoFromQQ(MiniAppInfo miniAppInfo, LaunchParam launchParam) {
        this.miniAppInfoFromQQ = miniAppInfo;
        this.launchParamFromQQ = launchParam;
        this.miniAppInfoFromSDK = null;
        QLog.d(TAG, 4, "recordMiniAppInfoFromQQ miniAppInfoFromQQ:" + miniAppInfo + ", launchParamFromQQ:" + launchParam);
    }

    public void recordMiniAppInfoFromSDK(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo) {
        this.miniAppInfoFromSDK = miniAppInfo;
        this.miniAppInfoFromQQ = null;
        this.launchParamFromQQ = null;
    }

    public void registerApp() {
        try {
            this.api.registerApp(this.mWxAppId);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "registerApp()");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
    }
}
