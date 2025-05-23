package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qqmini.proxyimpl.aq;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;

/* loaded from: classes33.dex */
public class MiniGetPhoneNumberReporter {
    private static final String ACTION_TYPE = "public_app";
    private static final String ADD_PHONE_NUMBER_CLICK = "add_phone_number_click";
    private static final String API_NAME = "getPhoneNumber";
    private static final String CHANGE_PHONE_NUMBER = "change_phone_number";
    private static final String GET_PHONE_NUMBER_ALLOW = "get_phone_number_allow";
    private static final String GET_PHONE_NUMBER_MANAGE = "get_phone_number_manage";
    private static final String GET_PHONE_NUMBER_REFUSE = "get_phone_number_refuse";
    private static final String GET_PHONE_NUMBER_SHOW = "get_phone_number_show";
    private static final String MANAGE_PHONE_NUMBER_CLICK = "manage_phone_number_click";
    private static final String PHONE_NUMBER_MANAGE_EXPO = "phone_number_manage_expo";
    private static final String SUB_ACTION_TYPE = "from_api";
    private static final String TAG = "MiniGetPhoneNumberReporter";
    private String mAppType;
    private BaseRuntime mBaseRuntime;
    private MiniAppConfig mMiniAppConfig;
    private String mUin;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class InstanceHolder {
        private static final MiniGetPhoneNumberReporter instance = new MiniGetPhoneNumberReporter();

        InstanceHolder() {
        }
    }

    MiniGetPhoneNumberReporter() {
        BaseRuntime currentRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
        this.mBaseRuntime = currentRuntime;
        MiniAppConfig h16 = aq.h(currentRuntime.getMiniAppInfo());
        this.mMiniAppConfig = h16;
        this.mAppType = MiniProgramLpReportDC04239.getAppType(h16);
        this.mUin = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAccount();
    }

    public static MiniGetPhoneNumberReporter getInstance() {
        return InstanceHolder.instance;
    }

    private void report(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5) {
        report(miniAppConfig, str, str2, str3, str4, str5, "");
    }

    public void addPhoneNumberClickReport() {
        MiniAppConfig miniAppConfig = this.mMiniAppConfig;
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        report(miniAppConfig, this.mAppType, null, "page_view", "click", ADD_PHONE_NUMBER_CLICK, this.mUin);
    }

    public void changePhoneNumberClickReport() {
        MiniAppConfig miniAppConfig = this.mMiniAppConfig;
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        report(miniAppConfig, this.mAppType, null, "page_view", "click", CHANGE_PHONE_NUMBER, this.mUin);
    }

    public void managePhoneNumberClickReport() {
        MiniAppConfig miniAppConfig = this.mMiniAppConfig;
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        report(miniAppConfig, this.mAppType, null, "page_view", "click", MANAGE_PHONE_NUMBER_CLICK, this.mUin);
    }

    public void phoneNumberAllowClickReport() {
        MiniAppConfig miniAppConfig = this.mMiniAppConfig;
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        report(miniAppConfig, this.mAppType, null, "page_view", "click", GET_PHONE_NUMBER_ALLOW, this.mUin);
    }

    public void phoneNumberApiInvokeReport() {
        MiniAppConfig miniAppConfig = this.mMiniAppConfig;
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        report(miniAppConfig, this.mAppType, null, ACTION_TYPE, "from_api", "getPhoneNumber", this.mUin);
    }

    public void phoneNumberDialogShowReport() {
        MiniAppConfig miniAppConfig = this.mMiniAppConfig;
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        report(miniAppConfig, this.mAppType, null, "page_view", "expo", GET_PHONE_NUMBER_SHOW, this.mUin);
    }

    public void phoneNumberManageClickReport() {
        MiniAppConfig miniAppConfig = this.mMiniAppConfig;
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        report(miniAppConfig, this.mAppType, null, "page_view", "click", GET_PHONE_NUMBER_MANAGE, this.mUin);
    }

    public void phoneNumberManagePageExpoReport() {
        MiniAppConfig miniAppConfig = this.mMiniAppConfig;
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        report(miniAppConfig, this.mAppType, null, "page_view", "expo", PHONE_NUMBER_MANAGE_EXPO, this.mUin);
    }

    public void phoneNumberRefuseClickReport() {
        MiniAppConfig miniAppConfig = this.mMiniAppConfig;
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        report(miniAppConfig, this.mAppType, null, "page_view", "click", GET_PHONE_NUMBER_REFUSE, this.mUin);
    }

    private void report(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.e
            @Override // java.lang.Runnable
            public final void run() {
                MiniProgramLpReportDC04239.report(MiniAppConfig.this, str, str2, str3, str4, str5, str6, null, null, null, null);
            }
        });
    }
}
