package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import Wallet.GetMiniAppReq;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.ext.ManagerProxy;
import com.tencent.mobileqq.microapp.sdk.BaseLibInfo;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ApkgConfigManager implements Manager {
    static IPatchRedirector $redirector_ = null;
    private static final String BASE_LIB_KEY_DEFAULT = "6VVmps6FEskvzUw+4t4BXEDUccolfE5bYliLLouIQUNUnYhBn/oSsktnohg3uFs0PDC+VDjsB2x7hkQ/G2m8OeCrSAYDQZwwmf1JZ+HYizxIj/i8SMs3ySNoCxiZc8s70BWR6wbjgRPt6p8+k3E5cS0Arcd+RwprVYpyDPuBiZg=";
    private static final String BASE_LIB_URL_DEFAULT = "https://i.gtimg.cn/channel/imglib/201811/upload_a84c998c33a7341a621a217cb90b7612.zip";
    private static final String BASE_LIB_VERSION_DEFAULT = "2.3.1";
    private static final String TAG = "ApkgConfigManager";
    private BaseLibInfo baseLibInfo;
    private QQAppInterface mApp;
    private com.tencent.mobileqq.microapp.apkg.a mConfig;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void onResult(int i3, MiniAppConfig miniAppConfig, String str, String str2);
    }

    public ApkgConfigManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ApkgConfigManager init");
        }
        this.mApp = qQAppInterface;
        this.mConfig = com.tencent.mobileqq.microapp.apkg.a.a(qQAppInterface);
    }

    public static boolean isCanNavigate(MiniAppConfig miniAppConfig, MiniAppConfig miniAppConfig2) {
        ApkgConfig apkgConfig;
        if (miniAppConfig != null && miniAppConfig.config != null && miniAppConfig2 != null && (apkgConfig = miniAppConfig2.config) != null) {
            if (LaunchParam.isCollectionPage(apkgConfig.mini_appid)) {
                return true;
            }
            return QWalletTools.isStringEquals(miniAppConfig.config.union_id, miniAppConfig2.config.union_id);
        }
        return false;
    }

    public BaseLibInfo getBaseLibInfo() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseLibInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.baseLibInfo == null) {
            QWalletConfigManager qWalletConfigManager = ManagerProxy.getQWalletConfigManager((AppRuntime) this.mApp);
            String str3 = "";
            if (qWalletConfigManager == null) {
                str = "";
                str2 = str;
            } else {
                String string = qWalletConfigManager.getString("miniapp", "", new String[]{"base_lib_url"});
                str2 = qWalletConfigManager.getString("miniapp", "", new String[]{"base_lib_key"});
                str = qWalletConfigManager.getString("miniapp", "", new String[]{"base_lib_version"});
                str3 = string;
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                this.baseLibInfo = new BaseLibInfo(str3, str2, str);
            } else {
                this.baseLibInfo = new BaseLibInfo(BASE_LIB_URL_DEFAULT, BASE_LIB_KEY_DEFAULT, BASE_LIB_VERSION_DEFAULT);
            }
        }
        return this.baseLibInfo;
    }

    public MiniAppConfig getConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MiniAppConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = str;
        return getConfig(launchParam);
    }

    public void getNewestConfig(LaunchParam launchParam, int i3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, launchParam, Integer.valueOf(i3), aVar);
            return;
        }
        GetMiniAppReq getMiniAppReq = new GetMiniAppReq(launchParam.miniAppId, i3, launchParam.getReqAction(), launchParam.extraKey);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getNewestConfig GetMiniAppReq|" + getMiniAppReq);
        }
        QWalletCommonServlet.sendRequest(getMiniAppReq, new c(this, aVar, launchParam));
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void tryUpdate(LaunchParam launchParam, int i3, OnUpdateListener onUpdateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, launchParam, Integer.valueOf(i3), onUpdateListener);
        } else {
            if (i3 == -1) {
                return;
            }
            getNewestConfig(launchParam, i3, new d(this, i3, onUpdateListener));
        }
    }

    public MiniAppConfig getConfig(LaunchParam launchParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MiniAppConfig) iPatchRedirector.redirect((short) 4, (Object) this, (Object) launchParam);
        }
        ApkgConfig b16 = this.mConfig.b(launchParam);
        if (b16 != null) {
            return new MiniAppConfig(b16, getBaseLibInfo());
        }
        return null;
    }
}
