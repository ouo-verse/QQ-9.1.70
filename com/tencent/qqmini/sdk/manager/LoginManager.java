package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class LoginManager {
    private static volatile LoginManager sInstance;

    public static LoginManager getInstance() {
        if (sInstance == null) {
            synchronized (LoginManager.class) {
                if (sInstance == null) {
                    sInstance = new LoginManager();
                }
            }
        }
        return sInstance;
    }

    private MiniAppProxy getProxy() {
        return (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
    }

    public String getAccount() {
        String account = getProxy().getAccount();
        if (account == null && AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null) {
            return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getAccount();
        }
        return account;
    }

    public String getAppId() {
        String appId = getProxy().getAppId();
        if (appId == null && AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null) {
            return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getAppId();
        }
        return appId;
    }

    public byte[] getLoginSig() {
        byte[] loginSig = getProxy().getLoginSig();
        if (loginSig == null && AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null) {
            return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getLoginSig();
        }
        return loginSig;
    }

    public int getLoginType() {
        int loginType = getProxy().getLoginType();
        if (loginType == -1 && AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null) {
            return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getLoginType();
        }
        return loginType;
    }

    public String getNickName() {
        String nickName = getProxy().getNickName();
        if (nickName == null && AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null) {
            return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getNickName();
        }
        return nickName;
    }

    public String getPayAccessToken() {
        String payAccessToken = getProxy().getPayAccessToken();
        if (payAccessToken == null && AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null) {
            return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getPayAccessToken();
        }
        return payAccessToken;
    }

    public String getPayOpenId() {
        String payOpenId = getProxy().getPayOpenId();
        if (payOpenId == null && AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null) {
            return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getPayOpenId();
        }
        return payOpenId;
    }

    public String getPayOpenKey() {
        String payOpenKey = getProxy().getPayOpenKey();
        if (payOpenKey == null && AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null) {
            return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getPayOpenKey();
        }
        return payOpenKey;
    }

    public String getPlatformId() {
        String platformId = getProxy().getPlatformId();
        if (platformId == null && AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null) {
            return AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getPlatformId();
        }
        return platformId;
    }
}
