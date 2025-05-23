package com.tencent.intervideo.nowproxy;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.tencent.intervideo.nowproxy.CustomInterface.CustomizedPushSetting;
import com.tencent.intervideo.nowproxy.CustomInterface.ShareMenuList;
import com.tencent.intervideo.nowproxy.ability.ExtSdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.baseability.DefaultLoading;
import com.tencent.intervideo.nowproxy.baseability.cookie.CookieHelper;
import com.tencent.intervideo.nowproxy.baseability.http.DefaultHttp;
import com.tencent.intervideo.nowproxy.baseability.log.DefaultLog;
import com.tencent.intervideo.nowproxy.baseability.report.BeaconReportHelper;
import com.tencent.intervideo.nowproxy.baseability.report.DataReport;
import com.tencent.intervideo.nowproxy.baseability.toast.DefautToast;
import com.tencent.intervideo.nowproxy.customized_interface.CustomCgi;
import com.tencent.intervideo.nowproxy.customized_interface.CustomKey;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDns;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDownloader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoading;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedToast;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedWebView;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.intervideo.nowproxy.whitelist.WelfareTaskCallback;
import com.tencent.intervideo.shadow_updater.ShadowImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CustomInterfaceLogic {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SdkBaseAbilityImpl";
    public static CustomInterfaceLogic sInstance;
    SdkBaseAbilityImpl baseImpl;
    SdkBizAbilityImpl bizImpl;
    CustomCgi customCgi;
    protected Bundle customiseByHost;
    protected Bundle customiseBySDK;
    CustomizedDownloader mCustomizedDownloader;
    CustomizedLoading mCustomizedLoading;
    CustomizedLog mCustomizedLog;
    CustomizedReport mDataReport;
    IShadow mShadow;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9737);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
        } else {
            sInstance = new CustomInterfaceLogic();
        }
    }

    CustomInterfaceLogic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.baseImpl = SdkBaseAbilityImpl.getsInstance();
        this.bizImpl = SdkBizAbilityImpl.getInstance();
        this.customiseByHost = new Bundle();
        this.customiseBySDK = new Bundle();
    }

    public static CustomInterfaceLogic getsInstance() {
        return sInstance;
    }

    public Bundle getCustomiseData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bundle) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.customiseByHost;
    }

    public boolean getFreeFlow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return this.customiseByHost.getBoolean(CustomKey.FREE_FLOW, false);
    }

    public void init(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        this.customiseBySDK.putBoolean(CustomKey.CUSTOM_WEBVIEW, true);
        this.customiseBySDK.putBoolean(CustomKey.CUSTOM_REPORT, true);
        this.customiseBySDK.putBoolean(CustomKey.CUSTOM_DNS, true);
        this.customiseBySDK.putBoolean(CustomKey.CUSTOM_CGIREQ, true);
        this.customiseBySDK.putBoolean(CustomKey.CUSTOM_BEACON_REPORT, true);
        this.customiseByHost.putBoolean(CustomKey.WELFARE_TASK_CALLBACK, true);
        this.customiseByHost.putBoolean(CustomKey.CORE_ACTION_CALLBACK, true);
        if (!str.equals("2")) {
            DataReport dataReport = DataReport.getInstance(str, Global.getApplicationContext());
            this.mDataReport = dataReport;
            setCustomizeReport(dataReport);
            IShadow shadowImpl = new ShadowImpl();
            this.mShadow = shadowImpl;
            this.baseImpl.setShadowImpl(shadowImpl);
            DefaultLog defaultLog = DefaultLog.getInstance();
            this.mCustomizedLog = defaultLog;
            defaultLog.init(Global.getApplicationContext(), "now", false);
            setCustomizedLog(this.mCustomizedLog);
            CustomCgi customCgi = DefaultHttp.getsInstance();
            this.customCgi = customCgi;
            this.baseImpl.setCustomizedCgi(customCgi);
            CustomizedLoading defaultLoading = new DefaultLoading();
            this.mCustomizedLoading = defaultLoading;
            this.baseImpl.setCustomizedLoading(defaultLoading);
            CustomizedDownloader defaultHttp = new DefaultHttp();
            this.mCustomizedDownloader = defaultHttp;
            this.baseImpl.setCustomizedDownloader(defaultHttp);
            this.baseImpl.setCustomToast(new DefautToast());
            if (AppidConfig.isBrowserPlugin(Global.sAppid)) {
                ExtSdkBizAbilityImpl.getInstance().setCustomizedBeaconReport(new CustomizedBeaconReport() { // from class: com.tencent.intervideo.nowproxy.CustomInterfaceLogic.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CustomInterfaceLogic.this);
                        }
                    }

                    public void onBeaconReport(Bundle bundle, int i3) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bundle, i3);
                        } else {
                            BeaconReportHelper.doBeaconReport(bundle, i3);
                        }
                    }
                });
            }
        }
    }

    public boolean isBeaconReportCustomizedBySdk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.customiseBySDK.getBoolean(CustomKey.CUSTOM_BEACON_REPORT, false);
    }

    public boolean isCGIReqCustomizedBySdk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.customiseBySDK.getBoolean(CustomKey.CUSTOM_CGIREQ, false);
    }

    public boolean isCustomCoverImg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        return this.customiseByHost.getBoolean(CustomKey.CUSTOM_COVER_IMG, false);
    }

    public boolean isDNSCustomizedByHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.customiseByHost.getBoolean(CustomKey.CUSTOM_DNS, false);
    }

    public boolean isDNSCustomizedBySDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return this.customiseBySDK.getBoolean(CustomKey.CUSTOM_DNS, false);
    }

    public boolean isDownLoadCustomizedBySdk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.customiseBySDK.getBoolean(CustomKey.CUSTOM_DOWNLOAD, false);
    }

    public boolean isDownloadCustomizedByHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.customiseByHost.getBoolean(CustomKey.CUSTOM_DOWNLOAD, false);
    }

    public boolean isLogCusomizedByHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return this.customiseByHost.getBoolean(CustomKey.CUSTOM_LOG, false);
    }

    public boolean isLogCusomizedBySdk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.customiseBySDK.getBoolean(CustomKey.CUSTOM_LOG, false);
    }

    public boolean isReportCustomizedByHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return this.customiseByHost.getBoolean(CustomKey.CUSTOM_REPORT, false);
    }

    public boolean isReportCustomizedBySDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        return this.customiseBySDK.getBoolean(CustomKey.CUSTOM_REPORT, false);
    }

    public boolean isToastCustomizedByHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return this.customiseByHost.getBoolean(CustomKey.CUSTOM_TOAST, false);
    }

    public boolean isToastCustomizedBySdk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return this.customiseBySDK.getBoolean(CustomKey.CUSTOM_TOAST, false);
    }

    public boolean isWebviewCusomizedByHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.customiseByHost.getBoolean(CustomKey.CUSTOM_WEBVIEW, false);
    }

    public boolean isWebviewCusomizedBySdk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.customiseBySDK.getBoolean(CustomKey.CUSTOM_WEBVIEW, false);
    }

    public void setCoreActionCallback(CoreActionCallback coreActionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) coreActionCallback);
        } else {
            this.customiseByHost.putBoolean(CustomKey.CORE_ACTION_CALLBACK, true);
            ExtSdkBizAbilityImpl.getInstance().setCoreActionCallback(coreActionCallback);
        }
    }

    public void setCustomCoverImg(CustomizedCoverImg customizedCoverImg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) customizedCoverImg);
        } else {
            this.customiseByHost.putBoolean(CustomKey.CUSTOM_COVER_IMG, true);
            ExtSdkBizAbilityImpl.getInstance().setCustomizedCoverImg(customizedCoverImg);
        }
    }

    public void setCustomDns(CustomizedDns customizedDns) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) customizedDns);
        } else {
            this.baseImpl.setCustomizedDns(customizedDns);
        }
    }

    public void setCustomisedWebview(CustomizedWebView customizedWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) customizedWebView);
            return;
        }
        this.customiseByHost.putBoolean(CustomKey.CUSTOM_WEBVIEW, true);
        this.customiseBySDK.putBoolean(CustomKey.CUSTOM_WEBVIEW, true);
        if (Global.sAppid.equals("2")) {
            this.baseImpl.setCustomisedWebview(customizedWebView, null);
        } else {
            this.baseImpl.setCustomisedWebview(customizedWebView, new WebCallHandler() { // from class: com.tencent.intervideo.nowproxy.CustomInterfaceLogic.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CustomInterfaceLogic.this);
                    }
                }

                @Override // com.tencent.intervideo.nowproxy.WebCallHandler
                public void getCookieInfo(NowCookieEvent nowCookieEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) nowCookieEvent);
                    } else {
                        CookieHelper.plant(Global.getApplicationContext(), nowCookieEvent);
                    }
                }

                @Override // com.tencent.intervideo.nowproxy.WebCallHandler
                public boolean onCallScheme(String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
                    }
                    return false;
                }

                @Override // com.tencent.intervideo.nowproxy.WebCallHandler
                public void onWebPageReady(Activity activity, WebView webView) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) activity, (Object) webView);
                    }
                }
            });
        }
    }

    public void setCustomizeReport(CustomizedReport customizedReport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) customizedReport);
            return;
        }
        this.customiseByHost.putBoolean(CustomKey.CUSTOM_REPORT, true);
        this.customiseBySDK.putBoolean(CustomKey.CUSTOM_REPORT, true);
        this.baseImpl.setCustomizeReport(customizedReport);
    }

    public void setCustomizedDownloader(CustomizedDownloader customizedDownloader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) customizedDownloader);
            return;
        }
        this.customiseByHost.putBoolean(CustomKey.CUSTOM_DOWNLOAD, true);
        this.customiseBySDK.putBoolean(CustomKey.CUSTOM_DOWNLOAD, true);
        this.baseImpl.setCustomizedDownloader(customizedDownloader);
    }

    public void setCustomizedLog(CustomizedLog customizedLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) customizedLog);
            return;
        }
        this.customiseByHost.putBoolean(CustomKey.CUSTOM_LOG, true);
        this.customiseBySDK.putBoolean(CustomKey.CUSTOM_LOG, true);
        this.baseImpl.setCustomizedLog(customizedLog);
    }

    public void setCustomizedOpenWxMiniProgram(CustomizedOpenWxMiniProgram customizedOpenWxMiniProgram) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) customizedOpenWxMiniProgram);
        } else {
            ExtSdkBizAbilityImpl.getInstance().setCustomizedOpenWxMiniProgram(customizedOpenWxMiniProgram);
        }
    }

    public void setCustomizedPay(CustomizedPayment customizedPayment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) customizedPayment);
        } else {
            this.customiseByHost.putBoolean(CustomKey.CUSTOM_PAY, true);
            ExtSdkBizAbilityImpl.getInstance().setCustomizedPay(customizedPayment);
        }
    }

    public void setCustomizedPushSetting(CustomizedPushSetting customizedPushSetting) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) customizedPushSetting);
        } else {
            ExtSdkBizAbilityImpl.getInstance().setCustomizedPushSetting(customizedPushSetting);
        }
    }

    public void setCustomizedShare(CustomizedShare customizedShare) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) customizedShare);
            return;
        }
        this.customiseByHost.putBoolean(CustomKey.CUSTOM_SHARE, true);
        this.customiseByHost.putInt(CustomKey.CUSTOM_SHARE_MENU_FLAG, 15);
        ExtSdkBizAbilityImpl.getInstance().setCustomShare(customizedShare);
    }

    public void setCustomizedToast(CustomizedToast customizedToast) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) customizedToast);
            return;
        }
        this.customiseByHost.putBoolean(CustomKey.CUSTOM_TOAST, true);
        this.customiseBySDK.putBoolean(CustomKey.CUSTOM_TOAST, true);
        this.baseImpl.setCustomToast(customizedToast);
    }

    public void setFreeFlow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.customiseByHost.putBoolean(CustomKey.FREE_FLOW, z16);
            Global.isQueenFreeFlow = z16;
        }
    }

    public void setWelfareTaskCallback(WelfareTaskCallback welfareTaskCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) welfareTaskCallback);
        } else {
            this.customiseByHost.putBoolean(CustomKey.WELFARE_TASK_CALLBACK, true);
            ExtSdkBizAbilityImpl.getInstance().setWelfareTaskCallback(welfareTaskCallback);
        }
    }

    public void unInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public void setCustomizedShare(ShareMenuList shareMenuList, CustomizedShare customizedShare) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) shareMenuList, (Object) customizedShare);
            return;
        }
        this.customiseByHost.putBoolean(CustomKey.CUSTOM_SHARE, true);
        this.customiseByHost.putInt(CustomKey.CUSTOM_SHARE_MENU_FLAG, shareMenuList.getValue());
        ExtSdkBizAbilityImpl.getInstance().setCustomShare(customizedShare);
    }
}
