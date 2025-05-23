package com.tencent.mobileqq.minigame.va.intercept;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.minigame.api.MiniGameVAInterceptCallback;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class InterceptRequest {
    private static final String TAG = "MiniGameVAInterceptRequest";
    private static final String TEXT_CONFIG_IS_EMPTY = "\u62e6\u622a\u5931\u8d25\uff0c\u914d\u7f6e\u4e3a\u7a7a";
    private static final String TEXT_CONFIG_IS_ERROR = "\u62e6\u622a\u5931\u8d25\uff0c\u914d\u7f6e\u9519\u8bef";
    private MiniGameVAInterceptConfig.VAInterceptConfig appConfig;
    public String appId;
    private final MiniGameVAInterceptCallback callback;
    private WeakReference<Context> contextRef;
    public String firstPage;
    public String gameData;
    private MiniGameVAInterceptConfig globalConfig;
    public int scene;
    public long startInterceptTime;
    public String via;

    public InterceptRequest(Context context, MiniGameVAInterceptCallback miniGameVAInterceptCallback) {
        this.contextRef = new WeakReference<>(context);
        this.callback = miniGameVAInterceptCallback;
    }

    public boolean canJumpApp() {
        MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig = this.appConfig;
        if (vAInterceptConfig == null) {
            QLog.i(TAG, 1, "canJumpApp appConfig is null");
            return false;
        }
        if (vAInterceptConfig.isAllJumpApp()) {
            QLog.i(TAG, 1, "canJumpApp isAllJumpApp is true");
            return true;
        }
        if (TextUtils.isEmpty(this.via)) {
            QLog.i(TAG, 1, "canJumpApp via is null");
            return false;
        }
        List<String> viaWhiteList = this.appConfig.getViaWhiteList();
        if (viaWhiteList == null) {
            return false;
        }
        boolean contains = viaWhiteList.contains(this.via);
        QLog.i(TAG, 1, "canJumpApp canJump:" + contains);
        return contains;
    }

    public boolean checkVAConfig() {
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        this.globalConfig = miniGameVAInterceptConfig;
        if (miniGameVAInterceptConfig == null) {
            MiniGameVAUtil.showDebugToast(TEXT_CONFIG_IS_EMPTY);
            return false;
        }
        MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig = miniGameVAInterceptConfig.getInterceptConfigMap().get(this.appId);
        this.appConfig = vAInterceptConfig;
        if (vAInterceptConfig == null) {
            QLog.i(TAG, 1, "checkVAConfig not found appConfig, appId:" + this.appId);
            return false;
        }
        if (!TextUtils.isEmpty(vAInterceptConfig.getGameAppId()) && !TextUtils.isEmpty(this.appConfig.getGameAppPkgName()) && !TextUtils.isEmpty(this.appConfig.getConfigId())) {
            this.gameData = MiniGameVAUtil.matchGameDataForFirstPage(this.appConfig.getGameAppPkgName(), this.firstPage);
            return true;
        }
        MiniGameVAUtil.showDebugToast(TEXT_CONFIG_IS_ERROR);
        return false;
    }

    public MiniGameVAInterceptConfig.VAInterceptConfig getAppConfig() {
        return this.appConfig;
    }

    public MiniGameVAInterceptCallback getCallback() {
        return this.callback;
    }

    public Context getContext() {
        Context context;
        WeakReference<Context> weakReference = this.contextRef;
        return (weakReference == null || (context = weakReference.get()) == null) ? BaseApplication.getContext() : context;
    }

    public MiniGameVAInterceptConfig getGlobalConfig() {
        return this.globalConfig;
    }
}
