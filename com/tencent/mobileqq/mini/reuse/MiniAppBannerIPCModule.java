package com.tencent.mobileqq.mini.reuse;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.bannerprocessor.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.minigame.GameConst;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* loaded from: classes33.dex */
public class MiniAppBannerIPCModule extends QIPCModule {
    public static final String ACTION_ENTER_BACKGROUND = "action.miniapp.enterbackground";
    public static final String ACTION_ENTER_FOREGROUND = "action.miniapp.enterforeground";
    private static final int AUTO_CLOSE_DELAY = 300000;
    private static final int MSG_AUTO_CLOSE_TIMEOUT = 1;
    public static final String NAME = "MiniAppBannerIPCModule";
    public static final String TAG = "MiniAppBannerIPCModule";
    public static final String TVALUE_CLICK_MINIAPP = "0X800A123";
    public static final String TVALUE_CLOSE_MINIAPP = "0X800A124";
    public static final String TVALUE_SHOW_MINIAPP = "0X800A121";
    private Handler mHandler;
    private d.c mMessageToShowBanner;

    /* loaded from: classes33.dex */
    private static class Holder {
        private static MiniAppBannerIPCModule sInstance = new MiniAppBannerIPCModule();

        Holder() {
        }
    }

    MiniAppBannerIPCModule() {
        super("MiniAppBannerIPCModule");
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (1 != message.what) {
                    return;
                }
                MiniAppBannerIPCModule.this.hideExistingMessageToBanner();
            }
        };
    }

    static /* bridge */ /* synthetic */ QQAppInterface c() {
        return getAppInterface();
    }

    private static QQAppInterface getAppInterface() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null || !(runtime instanceof QQAppInterface)) {
            return null;
        }
        return (QQAppInterface) runtime;
    }

    public static MiniAppBannerIPCModule getInstance() {
        return Holder.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideExistingMessageToBanner() {
        if (this.mMessageToShowBanner != null) {
            com.tencent.mobileqq.activity.recent.bannerprocessor.d.f(getAppInterface(), this.mMessageToShowBanner);
            this.mMessageToShowBanner = null;
        }
    }

    public static void notifyEnterBackground(ApkgInfo apkgInfo) {
        notifyBannerStateChange(ACTION_ENTER_BACKGROUND, apkgInfo);
    }

    public static void notifyEnterForeground(ApkgInfo apkgInfo) {
        notifyBannerStateChange(ACTION_ENTER_FOREGROUND, apkgInfo);
    }

    private static void notifyBannerStateChange(final String str, final ApkgInfo apkgInfo) {
        if (apkgInfo != null && apkgInfo.appConfig.config.isSupportBlueBar) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule.2
                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle = new Bundle();
                    bundle.putString("appid", ApkgInfo.this.appId);
                    bundle.putString("apkgName", ApkgInfo.this.apkgName);
                    bundle.putString("iconUrl", ApkgInfo.this.iconUrl);
                    bundle.putParcelable("appConfig", ApkgInfo.this.appConfig);
                    QIPCClientHelper.getInstance().callServer("MiniAppBannerIPCModule", str, bundle, null);
                }
            }, 16, null, true);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        String str2;
        if (bundle == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppBannerIPCModule", 2, "MiniAppBannerIPCModule : " + str + ", " + bundle.toString(), ", " + i3);
        }
        bundle.setClassLoader(MiniAppConfig.class.getClassLoader());
        String string = bundle.getString("apkgName");
        MiniAppConfig miniAppConfig = (MiniAppConfig) bundle.getParcelable("appConfig");
        if (miniAppConfig == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        if (miniAppConfig.isReportTypeMiniGame()) {
            str2 = "\u6b63\u5728\u73a9";
        } else {
            str2 = "\u6b63\u5728\u4f7f\u7528";
        }
        sb5.append(str2);
        sb5.append(string);
        int i16 = miniAppConfig.isReportTypeMiniGame() ? 12 : 11;
        hideExistingMessageToBanner();
        if (ACTION_ENTER_BACKGROUND.equals(str)) {
            this.mMessageToShowBanner = com.tencent.mobileqq.activity.recent.bannerprocessor.d.g(getAppInterface(), i16, "com.tencent.mobileqq.miniapp", sb5.toString(), new BannerInteract(miniAppConfig));
            this.mHandler.sendEmptyMessageDelayed(1, MiniBoxNoticeInfo.MIN_5);
            ReportController.r(getAppInterface(), "dc00898", "", "", TVALUE_SHOW_MINIAPP, TVALUE_SHOW_MINIAPP, 4, 0, "", "", "", "");
        }
        return new EIPCResult();
    }

    /* loaded from: classes33.dex */
    private static class BannerInteract implements d.b {
        private MiniAppConfig mAppConfig;

        BannerInteract(MiniAppConfig miniAppConfig) {
            this.mAppConfig = miniAppConfig;
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public boolean isNeedAutoCloseWhenAccountChange() {
            return true;
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onClose() {
            ReportController.r(MiniAppBannerIPCModule.c(), "dc00898", "", "", MiniAppBannerIPCModule.TVALUE_CLOSE_MINIAPP, MiniAppBannerIPCModule.TVALUE_CLOSE_MINIAPP, 4, 0, "", "", "", "");
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onEnter() {
            MiniAppConfig miniAppConfig = this.mAppConfig;
            LaunchParam launchParam = miniAppConfig.launchParam;
            if (launchParam != null) {
                launchParam.scene = GameConst.GAME_RUNTIME_MSG_PROFILE_START;
            }
            MiniAppLauncher.launchAppByAppConfig(null, miniAppConfig, null);
            ReportController.r(MiniAppBannerIPCModule.c(), "dc00898", "", "", MiniAppBannerIPCModule.TVALUE_CLICK_MINIAPP, MiniAppBannerIPCModule.TVALUE_CLICK_MINIAPP, 4, 0, "", "", "", "");
        }

        @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
        public void onOverride() {
        }
    }
}
