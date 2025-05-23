package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import com.tencent.qqmini.sdk.runtime.AppUIProxy;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniLoadingUI;

/* loaded from: classes23.dex */
public class PreloadResource {
    private static final String TAG = "minisdk-start_PreloadResource";
    private static volatile PreloadResource instance;
    private static volatile byte[] lock = new byte[0];
    private volatile AppUIProxy.DebugLayout mAppDebugLayout;
    private volatile AppUIProxy.LoadingUI mAppLadingUI;
    private MiniLoadingUI mHalfLadingUI;

    public static PreloadResource g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new PreloadResource();
                }
            }
        }
        return instance;
    }

    private String getCurrProcessName() {
        return AppLoaderFactory.g().getProcessName();
    }

    private void preloadUI(Context context, Configuration configuration) {
        if (context != null && isMiniAppProcess(context, configuration)) {
            getAppLoadingUI(context);
            getAppDebugUI(context);
        }
    }

    public AppUIProxy.DebugLayout getAppDebugUI(Context context) {
        if (this.mAppDebugLayout == null) {
            synchronized (AppUIProxy.LoadingUI.class) {
                if (this.mAppDebugLayout == null) {
                    QMLog.w(TAG, "preload getAppDebugUI");
                    this.mAppDebugLayout = new AppUIProxy.DebugLayout(context);
                    this.mAppDebugLayout.setBackgroundColor(-822083584);
                    TextView textView = new TextView(context);
                    textView.setTextColor(-1);
                    textView.setTextSize(30.0f);
                    textView.setText("\u8c03\u8bd5\u65ad\u70b9\u4e2d...");
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.mAppDebugLayout.addView(textView, layoutParams);
                    this.mAppDebugLayout.setVisibility(4);
                }
            }
        }
        return this.mAppDebugLayout;
    }

    public AppUIProxy.LoadingUI getAppLoadingUI(Context context) {
        if (this.mAppLadingUI == null) {
            synchronized (AppUIProxy.LoadingUI.class) {
                if (this.mAppLadingUI == null) {
                    QMLog.w(TAG, "preload getAppLoadingUI");
                    this.mAppLadingUI = new AppUIProxy.LoadingUI(context);
                }
            }
        }
        return this.mAppLadingUI;
    }

    public MiniLoadingUI getHalfLoadingUI(Context context) {
        if (this.mHalfLadingUI == null) {
            synchronized (MiniLoadingUI.class) {
                if (this.mHalfLadingUI == null) {
                    QMLog.w(TAG, "preload getHalfLoadingUI");
                    this.mHalfLadingUI = new MiniLoadingUI(context);
                }
            }
        }
        return this.mHalfLadingUI;
    }

    public boolean isMiniAppProcess(Context context, Configuration configuration) {
        if (configuration == null || configuration.processInfoList == null) {
            return false;
        }
        String currProcessName = getCurrProcessName();
        for (Configuration.ProcessInfo processInfo : configuration.processInfoList) {
            if (processInfo.processType == ProcessType.MINI_APP && !TextUtils.isEmpty(currProcessName) && currProcessName.equals(processInfo.name)) {
                return true;
            }
        }
        return false;
    }

    public void preload(Context context, Configuration configuration) {
        QMLog.w(TAG, "preload start");
        QMLog.w(TAG, "preload QUAUtil.getSimpleDeviceInfo");
        QUAUtil.getSimpleDeviceInfo(context);
        QMLog.w(TAG, "preload QUAUtil.getSystemUA");
        QUAUtil.getSystemUA();
        preloadUI(context, configuration);
        QMLog.w(TAG, "preload end");
    }
}
