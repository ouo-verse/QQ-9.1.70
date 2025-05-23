package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import android.text.TextUtils;
import com.tencent.mobileqq.microapp.sdk.BaseLibInfo;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppConfig implements Serializable {
    static IPatchRedirector $redirector_;
    public BaseLibInfo baseLibInfo;
    public ApkgConfig config;
    public LaunchParam launchParam;

    public MiniAppConfig(ApkgConfig apkgConfig, BaseLibInfo baseLibInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) apkgConfig, (Object) baseLibInfo);
        } else {
            this.config = apkgConfig;
            this.baseLibInfo = baseLibInfo;
        }
    }

    public static boolean isValid(MiniAppConfig miniAppConfig) {
        ApkgConfig apkgConfig;
        if (miniAppConfig != null && (apkgConfig = miniAppConfig.config) != null && !TextUtils.isEmpty(apkgConfig.mini_appid)) {
            return true;
        }
        return false;
    }

    public int getRuntimeType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        ApkgConfig apkgConfig = this.config;
        if (apkgConfig == null) {
            return 0;
        }
        return apkgConfig.getRuntimeType();
    }

    public boolean isDebugVersionChange(MiniAppConfig miniAppConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) miniAppConfig)).booleanValue();
        }
        if (miniAppConfig == null || getRuntimeType() != 1 || getRuntimeType() != miniAppConfig.getRuntimeType() || !miniAppConfig.config.mini_appid.equals(this.config.mini_appid) || miniAppConfig.config.qq_qr_code.equals(this.config.qq_qr_code)) {
            return false;
        }
        return true;
    }

    public boolean isInnerUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        ApkgConfig apkgConfig = this.config;
        if (apkgConfig != null && apkgConfig.isInnerUser()) {
            return true;
        }
        return false;
    }

    public boolean isRiskOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        ApkgConfig apkgConfig = this.config;
        if (apkgConfig != null && apkgConfig.isRiskOpen()) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "MiniAppConfig{config=" + this.config + ", launchParam=" + this.launchParam + ", baseLibInfo=" + this.baseLibInfo + '}';
    }
}
