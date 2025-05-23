package com.tencent.intervideo.nowproxy.ability;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.intervideo.nowproxy.Global;
import com.tencent.intervideo.nowproxy.NowCookieEvent;
import com.tencent.intervideo.nowproxy.NowEntryData;
import com.tencent.intervideo.nowproxy.WebCallHandler;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.intervideo.nowproxy.customized_interface.CustomCgi;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedChannel;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDns;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDownloader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoading;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedTicket;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedToast;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedWebView;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SdkBaseAbilityImpl {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SdkBaseAbilityImpl";
    public static SdkBaseAbilityImpl sInstance;
    CustomizedLoader customizedLoader;
    CustomCgi mCustomCgi;
    CustomizedChannel mCustomChannle;
    CustomizedDns mCustomDns;
    CustomizedDownloader mCustomizedDownloader;
    CustomizedLoading mCustomizedLoading;
    CustomizedLog mCustomizedLog;
    CustomizedReport mCustomizedReport;
    CustomizedTicket mCustomizedTiket;
    CustomizedToast mCustomizedToast;
    CustomizedWebView mCustomizedWebView;
    IShadow mShadowImpl;
    WebCallHandler mWebcallHandler;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_PRE_AD_TIMEOUT);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 37)) {
            redirector.redirect((short) 37);
        } else {
            sInstance = new SdkBaseAbilityImpl();
        }
    }

    SdkBaseAbilityImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SdkBaseAbilityImpl getsInstance() {
        return sInstance;
    }

    public void doCgiReq(Bundle bundle, CommonCallback<Bundle> commonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) bundle, (Object) commonCallback);
            return;
        }
        CustomCgi customCgi = this.mCustomCgi;
        if (customCgi != null) {
            customCgi.doCgiReq(bundle, commonCallback);
        }
    }

    public void download(boolean z16, String str, String str2, Bundle bundle, DownloadCallback downloadCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), str, str2, bundle, downloadCallback);
            return;
        }
        CustomizedDownloader customizedDownloader = this.mCustomizedDownloader;
        if (customizedDownloader != null) {
            customizedDownloader.onDownload(z16, str, str2, bundle, downloadCallback);
        }
    }

    public Future<Bundle> getA1(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (Future) iPatchRedirector.redirect((short) 31, this, str, str2, str3, str4);
        }
        CustomizedTicket customizedTicket = this.mCustomizedTiket;
        if (customizedTicket != null) {
            return customizedTicket.getA1(str, str2, str3, str4);
        }
        return null;
    }

    public Future<Bundle> getAccessToken(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Future) iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, (Object) str2);
        }
        CustomizedTicket customizedTicket = this.mCustomizedTiket;
        if (customizedTicket != null) {
            return customizedTicket.getAccessToken(str, str2);
        }
        return null;
    }

    public IShadow getShadowImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (IShadow) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mShadowImpl;
    }

    public Bundle getTickets() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Bundle) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        LoginData loginData = Global.sLoginData;
        if (loginData != null) {
            return LoginData.getLoginBundle(loginData);
        }
        return null;
    }

    public void hasPluginLoaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        CustomizedLoader customizedLoader = this.customizedLoader;
        if (customizedLoader != null) {
            customizedLoader.onPluginLoaded();
        }
    }

    public boolean isMobileNet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return true;
    }

    public void jumpAction(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        }
    }

    public void onFlushLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        CustomizedLog customizedLog = this.mCustomizedLog;
        if (customizedLog != null) {
            customizedLog.onFlushLogs();
        }
    }

    public void onUploadLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        CustomizedLog customizedLog = this.mCustomizedLog;
        if (customizedLog != null) {
            customizedLog.onUploadLogs();
        }
    }

    public void openWebView(Bundle bundle, WebCallHandler webCallHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) bundle, (Object) webCallHandler);
            return;
        }
        String string = bundle.getString("url");
        CustomizedWebView customizedWebView = this.mCustomizedWebView;
        if (customizedWebView != null) {
            WebCallHandler webCallHandler2 = this.mWebcallHandler;
            if (webCallHandler2 != null) {
                webCallHandler2.getCookieInfo(new NowCookieEvent(bundle, string) { // from class: com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Bundle val$bundle;
                    final /* synthetic */ String val$url;

                    {
                        this.val$bundle = bundle;
                        this.val$url = string;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, SdkBaseAbilityImpl.this, bundle, string);
                        }
                    }

                    @Override // com.tencent.intervideo.nowproxy.NowCookieEvent
                    public void onCookieReady(Bundle bundle2) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bundle2);
                            return;
                        }
                        this.val$bundle.putAll(bundle2);
                        SdkBaseAbilityImpl sdkBaseAbilityImpl = SdkBaseAbilityImpl.this;
                        sdkBaseAbilityImpl.mCustomizedWebView.onJumpWeb(this.val$url, this.val$bundle, sdkBaseAbilityImpl.mWebcallHandler);
                    }
                });
            } else {
                customizedWebView.onJumpWeb(string, bundle, webCallHandler2);
            }
        }
    }

    public void printLog(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), str, str2);
            return;
        }
        CustomizedLog customizedLog = this.mCustomizedLog;
        if (customizedLog != null) {
            customizedLog.onLog(2, str, str2);
        }
    }

    public void printQLog(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bundle);
            return;
        }
        String string = bundle.getString("tag", "nowplugin_dynamic");
        String string2 = bundle.getString("msg", "");
        CustomizedLog customizedLog = this.mCustomizedLog;
        if (customizedLog != null) {
            customizedLog.onLog(2, string, string2);
        }
    }

    public void reportData(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) bundle);
            return;
        }
        CustomizedReport customizedReport = this.mCustomizedReport;
        if (customizedReport != null) {
            customizedReport.onReport(bundle);
        }
    }

    public void reportNowEntry(NowEntryData nowEntryData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) nowEntryData);
            return;
        }
        CustomizedReport customizedReport = this.mCustomizedReport;
        if (customizedReport != null) {
            customizedReport.onNowEntry(null, nowEntryData);
        }
    }

    public String reqDns(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
        }
        try {
            return this.mCustomDns.getip(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public void sendSSOTask(Bundle bundle, CommonCallback<Bundle> commonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) bundle, (Object) commonCallback);
            return;
        }
        CustomizedChannel customizedChannel = this.mCustomChannle;
        if (customizedChannel != null) {
            customizedChannel.onSendTask(bundle, commonCallback);
        }
    }

    public void setCustomDns(CustomizedDns customizedDns) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) customizedDns);
        } else {
            this.mCustomDns = customizedDns;
        }
    }

    public void setCustomToast(CustomizedToast customizedToast) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) customizedToast);
        } else {
            this.mCustomizedToast = customizedToast;
        }
    }

    public void setCustomisedWebview(CustomizedWebView customizedWebView, WebCallHandler webCallHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) customizedWebView, (Object) webCallHandler);
        } else {
            this.mCustomizedWebView = customizedWebView;
            this.mWebcallHandler = webCallHandler;
        }
    }

    public void setCustomizeReport(CustomizedReport customizedReport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) customizedReport);
        } else {
            this.mCustomizedReport = customizedReport;
        }
    }

    public void setCustomizedCgi(CustomCgi customCgi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) customCgi);
        } else {
            this.mCustomCgi = customCgi;
        }
    }

    public void setCustomizedChannel(CustomizedChannel customizedChannel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) customizedChannel);
        } else {
            this.mCustomChannle = customizedChannel;
        }
    }

    public void setCustomizedDns(CustomizedDns customizedDns) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) customizedDns);
        } else {
            this.mCustomDns = customizedDns;
        }
    }

    public void setCustomizedDownloader(CustomizedDownloader customizedDownloader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) customizedDownloader);
        } else {
            this.mCustomizedDownloader = customizedDownloader;
        }
    }

    public void setCustomizedLoader(CustomizedLoader customizedLoader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) customizedLoader);
        } else {
            this.customizedLoader = customizedLoader;
        }
    }

    public void setCustomizedLoading(CustomizedLoading customizedLoading) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) customizedLoading);
        } else {
            this.mCustomizedLoading = customizedLoading;
        }
    }

    public void setCustomizedLog(CustomizedLog customizedLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) customizedLog);
        } else {
            this.mCustomizedLog = customizedLog;
        }
    }

    public void setShadowImpl(IShadow iShadow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) iShadow);
        } else {
            this.mShadowImpl = iShadow;
        }
    }

    public void setmCustomizedTiket(CustomizedTicket customizedTicket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) customizedTicket);
        } else {
            this.mCustomizedTiket = customizedTicket;
        }
    }

    public void showLoadingUI(Context context, Bundle bundle, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, context, bundle, view);
            return;
        }
        CustomizedLoading customizedLoading = this.mCustomizedLoading;
        if (customizedLoading != null) {
            customizedLoading.onShowLoading(context, bundle, view);
        }
    }

    public void showToast(Context context, CharSequence charSequence, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, context, charSequence, Integer.valueOf(i3));
            return;
        }
        CustomizedToast customizedToast = this.mCustomizedToast;
        if (customizedToast != null) {
            customizedToast.onShowToast(context, charSequence, i3);
        }
    }

    public void unInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public boolean useIpDirectConnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return true;
    }
}
