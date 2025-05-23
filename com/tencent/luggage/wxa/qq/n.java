package com.tencent.luggage.wxa.qq;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.e0;
import com.tencent.luggage.wxa.ar.i0;
import com.tencent.luggage.wxa.ar.s;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.z0;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebChildProcessMonitor;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements IXWebBroadcastListener {

        /* renamed from: a, reason: collision with root package name */
        public final Context f139010a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f139011b;

        /* renamed from: c, reason: collision with root package name */
        public ProgressDialog f139012c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f139013d = false;

        /* renamed from: e, reason: collision with root package name */
        public boolean f139014e = false;

        /* renamed from: f, reason: collision with root package name */
        public final List f139015f = new ArrayList();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.qq.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class DialogInterfaceOnCancelListenerC6657a implements DialogInterface.OnCancelListener {
            public DialogInterfaceOnCancelListenerC6657a() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                com.tencent.luggage.wxa.yq.k.a(a.this);
                if (a.this.f139013d) {
                    e0.b(a.this.f139010a);
                }
            }
        }

        public a(Context context, boolean z16) {
            this.f139010a = context;
            this.f139011b = a(context, z16);
            a("\u00b7 \u5f00\u59cb\u68c0\u67e5\u66f4\u65b0 (\u70b9\u7a7a\u767d\u533a\u57df\u53d6\u6d88)");
        }

        @Override // com.tencent.xweb.updater.IXWebBroadcastListener
        public void onMainCfgUpdated() {
            a("\u00b7 \u4e3b\u914d\u7f6e\u66f4\u65b0\u5b8c\u6210");
        }

        @Override // com.tencent.xweb.updater.IXWebBroadcastListener
        public void onPluginCfgUpdated() {
            a("\u00b7 \u63d2\u4ef6\u914d\u7f6e\u66f4\u65b0\u5b8c\u6210");
        }

        @Override // com.tencent.xweb.updater.IXWebBroadcastListener
        public void onUpdateFinished(int i3, int i16) {
            try {
                if (i3 == 0) {
                    a("\u00b7 \u66f4\u65b0\u5b8c\u6210\uff0c\u70b9\u51fb\u91cd\u542f\u751f\u6548");
                    this.f139013d = true;
                    ProgressDialog progressDialog = this.f139012c;
                    if (progressDialog != null) {
                        progressDialog.setCancelable(true);
                        this.f139012c.setCanceledOnTouchOutside(true);
                        this.f139012c.setProgress(100);
                    }
                } else if (i3 == -2) {
                    a("\u00b7 \u66f4\u65b0\u53d6\u6d88(\u53ef\u80fd\u65e0\u65b0\u5185\u6838)");
                    ProgressDialog progressDialog2 = this.f139012c;
                    if (progressDialog2 != null) {
                        progressDialog2.setCancelable(true);
                        this.f139012c.setCanceledOnTouchOutside(true);
                    }
                } else {
                    a("\u00b7 \u66f4\u65b0\u5931\u8d25\uff0c\u9519\u8bef\u7801:" + i16);
                    ProgressDialog progressDialog3 = this.f139012c;
                    if (progressDialog3 != null) {
                        progressDialog3.setCancelable(true);
                        this.f139012c.setCanceledOnTouchOutside(true);
                    }
                }
            } catch (Exception e16) {
                x0.d("XWebDebugRuntimeHelper", "onUpdateFinished error:" + e16);
            }
        }

        @Override // com.tencent.xweb.updater.IXWebBroadcastListener
        public void onUpdateProgressed(int i3) {
            try {
                if (!this.f139014e) {
                    a("\u00b7 \u5185\u6838\u66f4\u65b0\u4e2d");
                    this.f139014e = true;
                }
                ProgressDialog progressDialog = this.f139012c;
                if (progressDialog != null) {
                    progressDialog.setCancelable(false);
                    this.f139012c.setProgress(i3);
                }
            } catch (Exception e16) {
                x0.d("XWebDebugRuntimeHelper", "onUpdateProgressed error:" + e16);
            }
        }

        @Override // com.tencent.xweb.updater.IXWebBroadcastListener
        public void onUpdateStart(int i3) {
            this.f139014e = false;
            if (i3 == 0) {
                a("\u00b7 \u5f00\u59cb\u66f4\u65b0\u5185\u6838");
            } else {
                a("\u00b7 \u5f00\u59cb\u66f4\u65b0\u5185\u6838(predown)");
            }
        }

        public final boolean a(Context context, boolean z16) {
            if (context instanceof Activity) {
                return z16;
            }
            return false;
        }

        public final void a(String str) {
            x0.d("XWebDebugRuntimeHelper", "showMessage, shouldAlert:" + this.f139011b + ", message:" + str);
            if (this.f139011b) {
                if (this.f139012c == null) {
                    ProgressDialog progressDialog = new ProgressDialog(this.f139010a);
                    this.f139012c = progressDialog;
                    progressDialog.setProgressStyle(1);
                    this.f139012c.setMessage(str);
                    this.f139012c.setOnCancelListener(new DialogInterfaceOnCancelListenerC6657a());
                    this.f139012c.setCancelable(true);
                    this.f139012c.show();
                }
                this.f139015f.add(str);
                this.f139012c.setMessage(TextUtils.join("\n", this.f139015f));
            }
        }
    }

    public static String a(WebView webView) {
        String str;
        String str2;
        StringBuilder sb5 = new StringBuilder();
        String str3 = "";
        sb5.append("");
        sb5.append("\n local gray value = ");
        sb5.append(v0.b());
        sb5.append("\n local device gray value = ");
        sb5.append(v0.a());
        sb5.append("\n today gray value = ");
        sb5.append(v0.d());
        sb5.append("\n config period(minutes) = ");
        sb5.append(i0.getFetchConfigPeriod() / 60000);
        sb5.append("\n config url = ");
        sb5.append(z0.b());
        sb5.append("\n\n system apilevel = ");
        sb5.append(Build.VERSION.SDK_INT);
        sb5.append("\n target apilevel = ");
        sb5.append(XWalkEnvironment.getApplicationContext().getApplicationInfo().targetSdkVersion);
        sb5.append("\n device brand = ");
        sb5.append(Build.BRAND);
        sb5.append("\n device model = ");
        sb5.append(DeviceInfoMonitor.getModel());
        sb5.append("\n device abi = ");
        sb5.append(com.tencent.luggage.wxa.ar.b.a());
        sb5.append("\n runtime abi = ");
        sb5.append(com.tencent.luggage.wxa.ar.b.b());
        sb5.append("\n system webview version = ");
        sb5.append(XWebSdk.safeGetChromiumVersion());
        sb5.append("\n\n XWEB_TEST_MODE:");
        sb5.append(XWalkEnvironment.getBuildConfigXWebTestMode());
        sb5.append("\n FORCE_XWEB_CORE:");
        sb5.append(XWalkEnvironment.getBuildConfigForceXWebCore());
        sb5.append("\n NEED_TURN_OFF_DYNAMIC_CODE:");
        sb5.append(XWalkEnvironment.getBuildConfigNeedTurnOffDynamicCode());
        sb5.append("\n THIRD_PARD_RELEASE:");
        sb5.append(XWalkEnvironment.getBuildConfigThirdPartyRelease());
        sb5.append("\n\n SHOULD_EMBED_XWEB_CORE:");
        sb5.append(XWalkEnvironment.getBuildConfigShouldEmbedXWebCore());
        sb5.append("\n XWEB_EMBED_LIB_MD5_MATCH = ");
        sb5.append(true);
        sb5.append("\n EMBED_APK_VERSION(32/64) = ");
        sb5.append(0);
        sb5.append("/");
        sb5.append(0);
        sb5.append("\n embed try installed ver = ");
        sb5.append(com.tencent.luggage.wxa.zq.b.a(com.tencent.luggage.wxa.ar.b.b()));
        sb5.append("\n installed ver for arm32 = ");
        sb5.append(XWalkEnvironment.getInstalledNewstVersion("armeabi-v7a"));
        sb5.append("\n installed ver for arm64 = ");
        sb5.append(XWalkEnvironment.getInstalledNewstVersion("arm64-v8a"));
        sb5.append("\n\n client version = 0x");
        sb5.append(Integer.toHexString(XWalkEnvironment.getInitConfig(ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, 0)));
        sb5.append("\n app info = ");
        sb5.append(XWalkEnvironment.dumpAppInfo());
        sb5.append("\n useragent = ");
        sb5.append(webView != null ? webView.getSettings().getUserAgentString() : "unknown");
        String str4 = sb5.toString() + "\n\n>>>>>> wechat prefer webview core start >>>>>>\n";
        try {
            str = ((str4 + a("mm") + "\n") + a("tools") + "\n") + a("appbrand") + "\n";
        } catch (Throwable th5) {
            str = str4 + "dump module prefer webview core, error";
            x0.f("XWebDebugRuntimeHelper", "dump module prefer webview core, error:" + th5.getMessage());
        }
        String str5 = str + "<<<<<< wechat prefer webview core end <<<<<<";
        String abstractInfo = CommandCfg.getInstance().getAbstractInfo();
        if (abstractInfo != null && !abstractInfo.isEmpty()) {
            str5 = ((str5 + "\n\n>>>>>> core config commands start >>>>>>\n") + abstractInfo) + "<<<<<< core config commands end <<<<<<";
        }
        String str6 = ((str5 + "\n\n>>>>>> core scheduler start >>>>>>") + "\n " + com.tencent.luggage.wxa.yq.m.f().dumpSchedule()) + "\n " + com.tencent.luggage.wxa.yq.l.g().dumpSchedule();
        com.tencent.luggage.wxa.yq.m f16 = com.tencent.luggage.wxa.yq.m.f();
        String str7 = ((str6 + "\n\n update match gap backward(update speed) = " + f16.getCurHourSpeed(f16.getCurHourSpeedConfig(false))) + "\n update match gap forward(\u63d0\u524d\u66f4\u65b0) = " + f16.getCurHourSpeed(f16.getCurHourSpeedConfig(true))) + "\n<<<<<< core scheduler end <<<<<<";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (com.tencent.luggage.wxa.yq.m.f().hasScheduler()) {
                String format = simpleDateFormat.format(new Date(com.tencent.luggage.wxa.yq.m.f().getCurSchedulerConfig().f121683k));
                str3 = (((((((((" going to update to apk ver = " + com.tencent.luggage.wxa.yq.m.f().getCurSchedulerConfig().f121684l) + "\n update time = " + format) + "\n is patch update = " + com.tencent.luggage.wxa.yq.m.f().getCurSchedulerConfig().f121678f) + "\n can use cellular = " + com.tencent.luggage.wxa.yq.m.f().getCurSchedulerConfig().f121689q) + "\n updateHourStart = " + com.tencent.luggage.wxa.yq.m.f().getCurSchedulerConfig().f121694v) + "\n updateHourEnd = " + com.tencent.luggage.wxa.yq.m.f().getCurSchedulerConfig().f121695w) + "\n versionId = " + com.tencent.luggage.wxa.yq.m.f().getCurSchedulerConfig().f121693u) + "\n try count = " + com.tencent.luggage.wxa.yq.m.f().getCurSchedulerConfig().f121687o) + "\n try use shared core count = " + com.tencent.luggage.wxa.yq.m.f().getCurSchedulerConfig().f121688p) + "\n";
            }
            str3 = str3 + " last fetch config time = " + simpleDateFormat.format(new Date(com.tencent.luggage.wxa.yq.m.f().getCurSchedulerConfig().f121674b));
            str2 = str3 + "\n last fetch config abi = " + com.tencent.luggage.wxa.yq.m.f().getCurSchedulerConfig().f121675c;
        } catch (Throwable th6) {
            x0.f("XWebDebugRuntimeHelper", "dump schedule updateInfo, error:" + th6.getMessage());
            str2 = str3 + "\n dump schedule updateInfo, error";
        }
        return ((str7 + "\n\n>>>>>> schedule updateInfo start >>>>>>\n") + str2) + "\n<<<<<< schedule updateInfo end <<<<<<";
    }

    public static String b(WebView webView) {
        String versionInfo;
        if (webView == null) {
            if (XWebSdk.isXWebView()) {
                versionInfo = "pinus, sdkver:" + XWebSdk.getXWebSdkVersion() + ", apkver:" + XWebSdk.getAvailableVersion();
            } else if (XWebSdk.isSysWebView()) {
                versionInfo = "sys, sdkver:" + XWebSdk.getXWebSdkVersion() + ", sysver:" + com.tencent.luggage.wxa.ar.g.a();
            } else {
                versionInfo = "unknown, sdkver:" + XWebSdk.getXWebSdkVersion();
            }
        } else {
            versionInfo = webView.getVersionInfo();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(versionInfo);
        sb5.append("\nprocess:");
        sb5.append(XWalkEnvironment.getProcessName());
        sb5.append(", module:");
        String str = "";
        sb5.append(XWalkEnvironment.getSafeModuleName(""));
        String sb6 = sb5.toString();
        if (webView != null && webView.getCurrentInstanceWebCoreType() == WebView.WebViewKind.WV_KIND_PINUS) {
            int multiProcessType = XWalkEnvironment.getMultiProcessType();
            if (multiProcessType != 0) {
                if (multiProcessType != 1) {
                    if (multiProcessType == 2) {
                        str = "Render&GPU";
                    }
                } else {
                    str = "Render";
                }
            } else {
                str = "Single";
            }
            if (XWalkEnvironment.getMultiProcessType() != 0) {
                return (sb6 + "\ntype:" + str) + ", sandbox: " + XWalkEnvironment.getEnableSandbox();
            }
            return sb6;
        }
        return sb6;
    }

    public static String a(String str) {
        WebView.WebViewKind webViewKind;
        WebView.WebViewKind webViewKind2 = WebView.sDefaultWebViewKind;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\n   default core type:");
        sb5.append(webViewKind2);
        WebView.WebViewKind webKind = CommandCfg.getInstance().getWebKind(str);
        WebView.WebViewKind webViewKind3 = WebView.WebViewKind.WV_KIND_NONE;
        if (webKind != webViewKind3) {
            webViewKind = CommandCfg.getInstance().getWebKind(str);
            sb5.append("\n   has command type:");
            sb5.append(webViewKind);
        } else {
            webViewKind = webViewKind2;
        }
        if (XWalkEnvironment.getBuildConfigForceXWebCore()) {
            sb5.append("\n   has compile type:");
            sb5.append(webViewKind2);
        } else {
            webViewKind2 = webViewKind;
        }
        if (WebDebugCfg.getInst().getWebViewKindTest(str, true) != webViewKind3) {
            webViewKind2 = WebDebugCfg.getInst().getWebViewKindTest(str, true);
            sb5.append("\n   has abtest type:");
            sb5.append(webViewKind2);
        }
        if (WebDebugCfg.getInst().getWebViewKindTest(str, false) != webViewKind3) {
            webViewKind2 = WebDebugCfg.getInst().getWebViewKindTest(str, false);
            sb5.append("\n   has hardcode type:");
            sb5.append(webViewKind2);
        }
        if (webViewKind2 == WebView.WebViewKind.WV_KIND_PINUS && !XWalkEnvironment.hasAvailableVersion()) {
            webViewKind2 = WebView.WebViewKind.WV_KIND_SYS;
            sb5.append("\n   prefer sys because xweb is not available");
        }
        if (XWebChildProcessMonitor.getShouldSwitchToSys()) {
            webViewKind2 = WebView.WebViewKind.WV_KIND_SYS;
            sb5.append("\n   prefer sys because child process monitor hit");
        }
        if (s.a(webViewKind2, str)) {
            sb5.append("\n   will not use ");
            sb5.append(webViewKind2);
            sb5.append(" because of CrashWatchDog hit");
        }
        sb5.insert(0, " module(" + str + ") webview core type:" + webViewKind2);
        return sb5.toString();
    }

    public static void a(Context context, boolean z16) {
        XWebSdk.setForceCheckUpdate();
        com.tencent.luggage.wxa.yq.k.a(context, new a(context, z16));
        new com.tencent.luggage.wxa.yq.s().startCheck(context, null);
    }
}
