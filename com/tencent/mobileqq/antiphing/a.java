package com.tencent.mobileqq.antiphing;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.biz.common.util.k;
import com.tencent.biz.m;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.ims.antiphishingAlertQuery$RequestPack;
import com.tencent.ims.antiphishingAlertQuery$ResponsePack;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.AntiphingToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.Cgi;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends WebViewPlugin implements BusinessObserver {
    private AntiphishingUrlConfig C;
    private AntiphingToast D;

    /* renamed from: d, reason: collision with root package name */
    private boolean f194348d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f194349e = true;

    /* renamed from: f, reason: collision with root package name */
    private int f194350f = 1;

    /* renamed from: h, reason: collision with root package name */
    private String f194351h = "Antiphishing";

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f194352i = null;

    /* renamed from: m, reason: collision with root package name */
    private int f194353m = 1;
    private final int E = 0;
    private final int F = 1;
    QQAppInterface G = null;
    BrowserAppInterface H = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.antiphing.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public class DialogInterfaceOnClickListenerC7370a implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC7370a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d(a.this.f194351h, 2, "On Click Left Button! ");
            }
            if (a.this.mRuntime.a() != null) {
                a.this.mRuntime.a().finish();
            } else if (QLog.isDevelopLevel()) {
                QLog.d(a.this.f194351h, 4, "Call back object is null!");
            }
            a.this.v(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (QLog.isDevelopLevel()) {
                QLog.d(a.this.f194351h, 4, "right button is clicked! ");
            }
            a.this.v(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f194356a = "0";

        /* renamed from: b, reason: collision with root package name */
        public int f194357b = 0;

        c() {
        }
    }

    public a() {
        this.C = null;
        this.D = null;
        this.C = new AntiphishingUrlConfig();
        this.D = new AntiphingToast();
    }

    private boolean E(Context context, String str, int i3) {
        FrameLayout frameLayout;
        WebViewPlugin.b bVar;
        if (this.f194348d) {
            if (QLog.isColorLevel()) {
                x(this.f194351h, 2, "Toast Already Shown! yoffset ");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            x(this.f194351h, 2, "Show Toast! yoffset =  " + i3);
        }
        this.f194348d = true;
        if (this.f194352i == null && (bVar = this.mRuntime) != null && bVar.a() != null) {
            this.f194352i = (FrameLayout) this.mRuntime.a().findViewById(R.id.f164351sq);
        }
        AntiphingToast antiphingToast = this.D;
        if (antiphingToast == null || (frameLayout = this.f194352i) == null) {
            return false;
        }
        antiphingToast.c(R.string.i36, 3000, frameLayout);
        this.D.h(str);
        return true;
    }

    private String s() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            return null;
        }
        AppRuntime b16 = bVar.b();
        if (b16 == null) {
            b16 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        }
        if (b16 == null) {
            return null;
        }
        return b16.getApplication().getFilesDir().getAbsolutePath() + File.separator + "antiphishingconfig.xml";
    }

    private void x(String str, int i3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(str, i3, str2);
        }
    }

    public boolean B() {
        AppRuntime appRuntime = this.G;
        if (appRuntime == null) {
            appRuntime = this.H;
        }
        if (appRuntime == null) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) appRuntime.getApplication().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    public void C(String str) {
        if (u(str)) {
            if (QLog.isColorLevel()) {
                x(this.f194351h, 2, "IS QQ Domain! ");
            }
        } else {
            if (QLog.isColorLevel()) {
                x(this.f194351h, 2, "The url is not QQ Domain and load js into webview");
            }
            callJs("function clickCheck() {\n    var objs = document.getElementsByTagName(\"input\");\n    for (var i = 0; i < objs.length; i++) {\n        if (objs[i].type != 'password') {\n            objs[i].addEventListener('blur', function(e) {\n                var valText = e.srcElement.value;\n                var rect = this.getBoundingClientRect();\n                var xoffset = rect.left + (document.documentElement.scrollLeft || document.body.scrollLeft || 0);\n                var yoffset = rect.top + (document.documentElement.scrollTop || document.body.scrollTop || 0);\n                var xWidth = rect.right - rect.left;\n                var yHeight = rect.bottom - rect.top;\n                valText = valText.replace(\"/\", \"_\");\n                if (valText.indexOf(\"/\") == -1) {\n                    var para = \"jsbridge://InputClickEvent/onClickInputCtrl/0/\" + valText + \"/\" + xoffset + \"/\" + yoffset + \"/\" + xWidth + \"/\" + yHeight;\n                    //window.open(para);\n                    doClickCheck(para)\n                }\n            }, false);\n        }\n    }\n\n\n    function doClickCheck(param) {\n        var jsbridgeNode = document.createElement('iframe');\n        var removeTimeStamp = 0;\n        jsbridgeNode.style.cssText = 'display:none;width:0px;height:0px;';\n        jsbridgeNode.onerror = function(e) {\n            //\u5728 android 4.0-4.3 \u4e2d,script\u8282\u70b9\u7684src\u8d4b\u503c\u6210jsbridge://ui/showDialog\u7684\u5f62\u5f0f\u4f1a\u62a5\u9519\n            e.stopPropagation();\n        };\n\n        //append\u5230\u6839root\u4e0a\n        var root = document.body || document.documentElement;\n        root.appendChild && root.appendChild(jsbridgeNode);\n\n        //\u8bbe\u7f6ejs\u8c03\u7528\n        jsbridgeNode.src = param\n\n        // android \u6355\u83b7\u4e86iframe\u7684url\u4e4b\u540e, \u4e5f\u662f\u4e2d\u65ad js \u8fdb\u7a0b\u7684, \u6240\u4ee5\u8fd9\u91cc\u53ef\u4ee5\u7528\u4e2a setTimeout 0 \u6765\u5220\u9664 iframe\n        setTimeout(function() {\n            jsbridgeNode && jsbridgeNode.parentNode && jsbridgeNode.parentNode.removeChild(jsbridgeNode);\n        }, removeTimeStamp);\n    }\n\n}\n\n\n\nclickCheck()");
        }
    }

    public void D(String str, String... strArr) {
        if (strArr.length < 5) {
            if (QLog.isColorLevel()) {
                QLog.d("antiphishing", 2, "Parameter size < 5");
                return;
            }
            return;
        }
        String str2 = strArr[0];
        String str3 = strArr[1];
        String str4 = strArr[2];
        String str5 = strArr[3];
        String str6 = strArr[4];
        if (QLog.isColorLevel()) {
            QLog.d("antiphishing", 2, "value:" + str2 + " xoffset:" + str3 + " yoffset:" + str4 + " xWidth:" + str5 + " yHeight:" + str6);
        }
        CustomWebView e16 = this.mRuntime.e();
        if (e16 != null) {
            r(str2, e16.getUrl(), str3, str4, str5, str6);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "InputClickEvent";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 2L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"InputClickEvent".equalsIgnoreCase(str2) || !"onClickInputCtrl".equalsIgnoreCase(str3)) {
            return false;
        }
        D(str, strArr);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityReady() {
        Context a16;
        AntiphishingUrlConfig antiphishingUrlConfig = this.C;
        String s16 = s();
        BrowserAppInterface browserAppInterface = this.H;
        if (browserAppInterface != null) {
            a16 = browserAppInterface.getApplication();
        } else {
            a16 = this.mRuntime.a();
        }
        antiphishingUrlConfig.k(s16, a16);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onAppRuntimeReady(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            this.G = (QQAppInterface) appRuntime;
        } else if (appRuntime instanceof BrowserAppInterface) {
            this.H = (BrowserAppInterface) appRuntime;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
    }

    public void w(String str, String str2, String str3, String str4) {
        if (this.f194348d) {
            if (QLog.isColorLevel()) {
                x(this.f194351h, 2, "Dlg Already Shown! ");
                return;
            }
            return;
        }
        this.f194348d = true;
        if (QLog.isColorLevel()) {
            QLog.d(this.f194351h, 2, "On Show Dialog !");
        }
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            return;
        }
        DialogUtil.createCustomDialog(a16, 230, str, str2, str3, str4, str4.equals("") ? null : new DialogInterfaceOnClickListenerC7370a(), str3.equals("") ? null : new b()).show();
    }

    public void y(int i3, int i16, int i17, int i18, String str, Long l3, int i19) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f194351h, 2, "Send a Packet to Server!, xffset = " + i3 + " yoffset = " + i16 + " nWidth = " + i17 + " nHeight = " + i18 + " url=" + str + " uin=" + l3 + " AccountType = " + i19);
        }
        if (l3.longValue() == 0 || str == null) {
            return;
        }
        antiphishingAlertQuery$RequestPack antiphishingalertquery_requestpack = new antiphishingAlertQuery$RequestPack();
        antiphishingalertquery_requestpack.u32_app_type.set(2);
        antiphishingalertquery_requestpack.u64_input_uin.set(l3.longValue());
        antiphishingalertquery_requestpack.u32_account_type.set(i19);
        antiphishingalertquery_requestpack.u32_ctrl_height.set(i18);
        antiphishingalertquery_requestpack.u32_ctrl_width.set(i17);
        antiphishingalertquery_requestpack.i32_xoffset.set(i3);
        antiphishingalertquery_requestpack.i32_yoffset.set(i16);
        antiphishingalertquery_requestpack.str_url.set(str);
        antiphishingalertquery_requestpack.u32_seq.set(this.f194350f);
        antiphishingalertquery_requestpack.u32_proto_ver.set(1);
        AppRuntime appRuntime = this.G;
        if (appRuntime == null) {
            appRuntime = this.H;
        }
        if (appRuntime == null || this.mRuntime.a() == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(this.mRuntime.a().getApplicationContext(), m.class);
        newIntent.putExtra("uin", appRuntime.getAccount());
        newIntent.putExtra("data", antiphishingalertquery_requestpack.toByteArray());
        newIntent.putExtra("cmd", "SecuritySvc.UrlQuery");
        newIntent.setObserver(this);
        appRuntime.startServlet(newIntent);
    }

    public void z(boolean z16) {
        if (QLog.isColorLevel()) {
            x(this.f194351h, 2, "bShow =  " + z16);
        }
        this.f194349e = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i3) {
        try {
            ReportController.o(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "UserChoose", 0, i3, "", "", "", "");
        } catch (Exception unused) {
        }
    }

    public void A() {
        this.f194348d = false;
        int i3 = this.f194350f + 1;
        this.f194350f = i3;
        if (i3 > 1000000) {
            this.f194350f = 1;
        }
    }

    public boolean r(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.f194348d) {
            if (QLog.isColorLevel()) {
                x(this.f194351h, 2, "Already Shown Tips!!");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            x(this.f194351h, 2, "Js is call back!");
        }
        c cVar = new c();
        if (!t(str, cVar)) {
            if (QLog.isColorLevel()) {
                x(this.f194351h, 2, "The input value is not uin!");
            }
            return false;
        }
        try {
            long parseLong = Long.parseLong(cVar.f194356a);
            y((int) Float.parseFloat(str3), (int) Float.parseFloat(str4), (int) Float.parseFloat(str5), (int) Float.parseFloat(str6), str2, Long.valueOf(parseLong), cVar.f194357b);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean t(String str, c cVar) {
        if (str == null) {
            return false;
        }
        String replace = str.trim().toLowerCase().replace(" ", "");
        boolean endsWith = replace.endsWith("@qq.com");
        AppRuntime appRuntime = this.G;
        if (appRuntime == null) {
            appRuntime = this.H;
        }
        if (appRuntime == null) {
            return false;
        }
        List<SimpleAccount> allAccounts = appRuntime.getApplication().getAllAccounts();
        if (allAccounts != null && allAccounts.size() != 0) {
            for (int i3 = 0; i3 < allAccounts.size(); i3++) {
                SimpleAccount simpleAccount = allAccounts.get(i3);
                if (simpleAccount == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(this.f194351h, 2, "sAccount == null!");
                    }
                } else {
                    String uin = simpleAccount.getUin();
                    if (uin == null) {
                        continue;
                    } else {
                        if (uin.equalsIgnoreCase(replace)) {
                            cVar.f194356a = uin;
                            cVar.f194357b = 1;
                            return true;
                        }
                        if (endsWith && replace.contains(uin)) {
                            cVar.f194356a = uin;
                            cVar.f194357b = 2;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f194351h, 2, "uin number is zero!");
        }
        return false;
    }

    private boolean u(String str) {
        String str2;
        AntiphishingUrlConfig antiphishingUrlConfig;
        if (str == null) {
            return false;
        }
        str.toLowerCase();
        try {
            str2 = new URL(str).getHost();
        } catch (MalformedURLException unused) {
            str2 = "";
        }
        if (QLog.isColorLevel()) {
            x(this.f194351h, 2, " Is QQ Domain, input url  : " + k.f(str, new String[0]) + " Domain = " + str2);
        }
        boolean z16 = true;
        boolean z17 = str2.endsWith("qq.com") || str2.endsWith("tencent.com") || str2.endsWith("imqq.com") || str2.endsWith("wanggou.com") || str2.endsWith("paipai.com") || str2.endsWith(Cgi.TENPAY_DOMAIN) || str2.endsWith("yixun.com") || str2.endsWith("weiyun.com") || str2.endsWith("soso.com") || str2.endsWith("myapp.com") || str2.endsWith("wechat.com") || str2.endsWith("gaopeng.com") || str2.endsWith("pengyou.com") || str2.endsWith("51buy.com") || str2.endsWith("weishi.com") || str2.endsWith("qqumall.com") || str2.endsWith("vip.surex.cn");
        if (B()) {
            if (!QLog.isColorLevel()) {
                return z17;
            }
            QLog.d(this.f194351h, 2, "Low Memory !");
            return z17;
        }
        if (z17 || (antiphishingUrlConfig = this.C) == null) {
            return z17;
        }
        ArrayList<String> g16 = antiphishingUrlConfig.g();
        if (g16 != null) {
            for (int i3 = 0; i3 < g16.size(); i3++) {
                if (str2.endsWith(g16.get(i3))) {
                    if (QLog.isColorLevel()) {
                        x(this.f194351h, 2, " Is trust Domain, match config, input url  : " + str + " Domain = " + str2);
                    }
                    return z16;
                }
            }
        }
        z16 = z17;
        return z16;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d(this.f194351h, 2, "Received AlertQuery Server Packet! type = " + i3);
        }
        if (this.f194349e && z16 && this.mRuntime.a() != null) {
            Context applicationContext = this.mRuntime.a().getApplicationContext();
            String string = applicationContext.getString(R.string.hav);
            String string2 = applicationContext.getString(R.string.hau);
            String string3 = applicationContext.getString(R.string.hat);
            String string4 = applicationContext.getString(R.string.has);
            if (!z16 || bundle == null) {
                return;
            }
            antiphishingAlertQuery$ResponsePack antiphishingalertquery_responsepack = new antiphishingAlertQuery$ResponsePack();
            try {
                antiphishingalertquery_responsepack.mergeFrom(bundle.getByteArray("data"));
                int i16 = antiphishingalertquery_responsepack.u32_alert_type.has() ? antiphishingalertquery_responsepack.u32_alert_type.get() : 0;
                int i17 = antiphishingalertquery_responsepack.u32_default_wording.has() ? antiphishingalertquery_responsepack.u32_default_wording.get() : 0;
                if (i16 == 1) {
                    if (QLog.isColorLevel()) {
                        QLog.d(this.f194351h, 2, "Safe Url! No ALert !");
                    }
                } else {
                    String str2 = "";
                    if (i17 == 2) {
                        if (i16 == 2 && antiphishingalertquery_responsepack.str_toast.has()) {
                            string = antiphishingalertquery_responsepack.str_toast.get().toString();
                        } else if (i16 == 3) {
                            if (antiphishingalertquery_responsepack.str_dialog_title.has()) {
                                string2 = antiphishingalertquery_responsepack.str_dialog_title.get().toString();
                            }
                            if (antiphishingalertquery_responsepack.str_dialog_text.has()) {
                                string3 = antiphishingalertquery_responsepack.str_dialog_text.get().toString();
                            }
                            if (!antiphishingalertquery_responsepack.str_dialog_btn_left.has()) {
                                str = "";
                            } else {
                                str = antiphishingalertquery_responsepack.str_dialog_btn_left.get().toString();
                            }
                            if (!antiphishingalertquery_responsepack.str_dialog_btn_right.has()) {
                                str2 = str;
                                string4 = "";
                            } else {
                                str2 = str;
                                string4 = antiphishingalertquery_responsepack.str_dialog_btn_right.get().toString();
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(this.f194351h, 2, "toasttext:" + string + "strDialogTitle" + string2 + "strDialogText" + string3 + " strDialogLeftBtnText:" + str2 + " StrDialogRightBtnText:" + string4);
                    }
                    if ((antiphishingalertquery_responsepack.u32_seq.has() ? antiphishingalertquery_responsepack.u32_seq.get() : 0) == this.f194350f) {
                        if (i16 == 2) {
                            if (QLog.isColorLevel()) {
                                QLog.d(this.f194351h, 2, "onReceive: Show Tips");
                            }
                            E(applicationContext, string, 104);
                        } else if (i16 == 3) {
                            if (QLog.isColorLevel()) {
                                QLog.d(this.f194351h, 2, "onReceive: Show Dlg");
                            }
                            w(string2, string3, str2, string4);
                        } else if (QLog.isDevelopLevel()) {
                            QLog.d(this.f194351h, 4, "onReceive: UnknowType ");
                        }
                    } else if (QLog.isDevelopLevel()) {
                        QLog.d(this.f194351h, 4, "onReceive: Sequence Changed!");
                    }
                }
                int i18 = antiphishingalertquery_responsepack.u32_svr_url_ver.has() ? antiphishingalertquery_responsepack.u32_svr_url_ver.get() : 0;
                String str3 = antiphishingalertquery_responsepack.str_download_link.has() ? antiphishingalertquery_responsepack.str_download_link.get() : null;
                String str4 = antiphishingalertquery_responsepack.str_hash.has() ? antiphishingalertquery_responsepack.str_hash.get() : null;
                if (i18 != 0 && str3 != null && str4 != null) {
                    AntiphishingUrlConfig antiphishingUrlConfig = this.C;
                    if (antiphishingUrlConfig != null) {
                        antiphishingUrlConfig.i(i18, str3, str4, applicationContext);
                        return;
                    }
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d(this.f194351h, 4, "onReceive: types unknow !");
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map map) {
        if (j3 == 8589934594L) {
            A();
            C(str);
            return false;
        }
        if (j3 == 8589934597L) {
            z(false);
        } else if (j3 != 8589934595L && j3 == 2) {
            z(true);
        }
        return false;
    }
}
