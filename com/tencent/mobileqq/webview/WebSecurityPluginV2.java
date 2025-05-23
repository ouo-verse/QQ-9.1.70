package com.tencent.mobileqq.webview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.o;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.config.SpringHbUrlCheckConfProcessor;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webviewplugin.s;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc04171;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneStringMatcher;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class WebSecurityPluginV2 extends WebViewPlugin {
    private static Boolean M;
    String C;
    com.tencent.biz.o E;
    com.tencent.biz.troop.b F;
    private int G;
    private URLCheckParams H;

    /* renamed from: e, reason: collision with root package name */
    String f313769e;

    /* renamed from: d, reason: collision with root package name */
    String f313768d = null;

    /* renamed from: f, reason: collision with root package name */
    boolean f313770f = true;

    /* renamed from: h, reason: collision with root package name */
    boolean f313771h = false;

    /* renamed from: i, reason: collision with root package name */
    boolean f313772i = true;

    /* renamed from: m, reason: collision with root package name */
    boolean f313773m = false;
    volatile com.tencent.mobileqq.springhb.config.i D = null;
    private ArrayList<String> I = new ArrayList<>();
    protected QQCustomDialog J = null;
    protected CountDownTimer K = null;
    private Runnable L = new Runnable() { // from class: com.tencent.mobileqq.webview.WebSecurityPluginV2.4
        @Override // java.lang.Runnable
        public void run() {
            QQCustomDialog qQCustomDialog = WebSecurityPluginV2.this.J;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                QLog.d("WebSecurityPluginV2", 1, "validCheck showing return");
            } else if (!WebSecurityPluginV2.this.f313771h) {
                QLog.d("WebSecurityPluginV2", 1, "validCheck c=0 return");
            } else {
                QLog.d("WebSecurityPluginV2", 1, "handleEvent [EVENT_LOAD_FINISH] load js...");
                WebSecurityPluginV2.this.callJs("if (!(document.body)) {\n    window.addEventListener('load', function() {\n        console.log(\"onload\")\n        validCheck();\n    });\n\n} else {\n    validCheck();\n\n}\n\nfunction validCheck() {\n    var maxlen = 102400\n    var text = document.body.innerText\n    if (text.length > maxlen) {\n        text = text.substring(0, maxlen);\n    }\n    text = text.replace(/[\\n\\r\\s\\t]/g, \"\");\n\n    console.log(\"len=\" + text.length)\n\n    var para = \"jsbridge://UrlSaveVerifyV2/validCheck/0/\" + s2h(text);\n\n    var jsbridgeNode = document.createElement('iframe');\n    var removeTimeStamp = 0;\n    jsbridgeNode.style.cssText = 'display:none;width:0px;height:0px;';\n    jsbridgeNode.onerror = function(e) {\n        //\u5728 android 4.0-4.3 \u4e2d,script\u8282\u70b9\u7684src\u8d4b\u503c\u6210jsbridge://ui/showDialog\u7684\u5f62\u5f0f\u4f1a\u62a5\u9519\n        e.stopPropagation();\n    };\n    var root = document.body || document.documentElement;\n    root.appendChild && root.appendChild(jsbridgeNode);\n    jsbridgeNode.src = para\n\n    // android \u6355\u83b7\u4e86iframe\u7684url\u4e4b\u540e, \u4e5f\u662f\u4e2d\u65ad js \u8fdb\u7a0b\u7684, \u6240\u4ee5\u8fd9\u91cc\u53ef\u4ee5\u7528\u4e2a setTimeout 0 \u6765\u5220\u9664 iframe\n    setTimeout(function() {\n        jsbridgeNode && jsbridgeNode.parentNode && jsbridgeNode.parentNode.removeChild(jsbridgeNode);\n    }, removeTimeStamp);\n}\n\nfunction s2h(str) {\n    var buf = new ArrayBuffer(str.length * 2); // 2 bytes for each char\n    var bufView = new Uint16Array(buf);\n    for (var i = 0, strLen = str.length; i < strLen; i++) {\n        var code = str.charCodeAt(i);\n        bufView[i] = (code & 0xFF) << 8 | ((code >> 8) & 0xFF)\n    }\n    var hexString = Array.from(new Uint8Array(buf)).map(byte => byte.toString(16).padStart(2, \"0\")).join(\"\");\n    return hexString;\n}");
            }
        }
    };

    /* loaded from: classes35.dex */
    class a implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f313774d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f313775e;

        a(String str, boolean z16) {
            this.f313774d = str;
            this.f313775e = z16;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            CustomWebView e16;
            WebSecurityPluginV2 webSecurityPluginV2 = WebSecurityPluginV2.this;
            if (!webSecurityPluginV2.isDestroy && webSecurityPluginV2.z(this.f313774d, this.f313775e)) {
                int i3 = bundle.getInt("result", -1);
                if (i3 == 0) {
                    int i16 = bundle.getInt("jumpResult");
                    int i17 = bundle.getInt("level");
                    int i18 = bundle.getInt("subLevel");
                    int i19 = bundle.getInt("umrType");
                    long j3 = bundle.getLong("operationBit");
                    int i26 = bundle.getInt("needSdkCheck", 0);
                    WebSecurityPluginV2 webSecurityPluginV22 = WebSecurityPluginV2.this;
                    webSecurityPluginV22.f313771h = i26 == 1;
                    webSecurityPluginV22.f313770f &= i17 == 15;
                    if (i16 == 0) {
                        r4 = this.f313775e ? null : this.f313774d;
                        QLog.i("UrlCheckLog_WebSecurityPluginV2", 1, "check pass l=" + i17 + ", c=" + i26);
                    } else {
                        webSecurityPluginV22.f313773m = true;
                        String string = bundle.getString(WadlProxyConsts.KEY_JUMP_URL);
                        QLog.i("UrlCheckLog_WebSecurityPluginV2", 1, "check finish jr=" + i16 + ", l=" + i17 + ", sl=" + i18 + ", umr=" + i19 + ", c=" + i26);
                        r4 = string;
                    }
                    WebSecurityPluginV2.this.y(j3);
                } else {
                    QLog.i("UrlCheckLog_WebSecurityPluginV2", 1, "check fail r=" + i3);
                    if (!this.f313775e) {
                        r4 = this.f313774d;
                    }
                }
                if (TextUtils.isEmpty(r4) || (e16 = WebSecurityPluginV2.this.mRuntime.e()) == null) {
                    return;
                }
                QLog.i("WebSecurityPluginV2", 1, "now jump url=" + com.tencent.biz.common.util.k.f(r4, new String[0]));
                WebSecurityPluginV2.this.f313768d = r4;
                e16.loadUrl(r4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class c implements o.a {
        c() {
        }

        @Override // com.tencent.biz.o.a
        public void N1(boolean z16, int i3, int i16) {
            s g16 = WebSecurityPluginV2.this.mRuntime.g();
            if (z16) {
                if (WebSecurityPluginV2.this.mRuntime.c() != null && !WebSecurityPluginV2.this.mRuntime.c().isLogin()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WebSecurityPluginV2", 2, "not login and url in whiteList, mShouldShowInputWarning=", Boolean.valueOf(WebSecurityPluginV2.this.f313770f));
                    }
                    WebSecurityPluginV2.this.f313770f = false;
                }
                if (WebSecurityPluginV2.this.f313770f) {
                    if (g16 != null && g16.getWebTitleBarInterface() != null) {
                        g16.getWebTitleBarInterface().Sc(true, 1, R.string.aja);
                    } else {
                        QQToast makeText = QQToast.makeText(BaseApplication.getContext(), 1, R.string.aja, 1);
                        makeText.show(makeText.getTitleBarHeight());
                    }
                }
                WebSecurityPluginV2.this.U();
                return;
            }
            if (g16 == null || g16.getWebTitleBarInterface() == null) {
                return;
            }
            g16.getWebTitleBarInterface().Sc(false, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public static class d implements com.tencent.mobileqq.dt.api.h {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<WebSecurityPluginV2> f313779a;

        d(WebSecurityPluginV2 webSecurityPluginV2) {
            this.f313779a = new WeakReference<>(webSecurityPluginV2);
        }

        @Override // com.tencent.mobileqq.dt.api.h
        public void a(final int i3, final String str) {
            final WebSecurityPluginV2 webSecurityPluginV2 = this.f313779a.get();
            if (webSecurityPluginV2 == null) {
                return;
            }
            QLog.d("WebSecurityPluginV2", 1, "validCheck code=" + i3 + ", msg=" + str);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.webview.l
                @Override // java.lang.Runnable
                public final void run() {
                    WebSecurityPluginV2.w(WebSecurityPluginV2.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public static class e extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        private TextView f313780a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<WebSecurityPluginV2> f313781b;

        public e(WebSecurityPluginV2 webSecurityPluginV2, TextView textView, long j3, long j16) {
            super(j3, j16);
            this.f313780a = textView;
            this.f313781b = new WeakReference<>(webSecurityPluginV2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Activity a16;
            WebSecurityPluginV2 webSecurityPluginV2 = this.f313781b.get();
            if (webSecurityPluginV2 == null || (a16 = webSecurityPluginV2.mRuntime.a()) == null || a16.isFinishing()) {
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("WebSecurityPluginV2", 1, "onFinish");
            }
            this.f313780a.setText(WebSecurityPluginV2.F(0L));
            this.f313780a.setEnabled(true);
            this.f313780a.setAlpha(1.0f);
            this.f313780a.getRootView().invalidate();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            Activity a16;
            WebSecurityPluginV2 webSecurityPluginV2 = this.f313781b.get();
            if (webSecurityPluginV2 == null || (a16 = webSecurityPluginV2.mRuntime.a()) == null || a16.isFinishing()) {
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("WebSecurityPluginV2", 1, "onTick " + j3);
            }
            this.f313780a.setText(WebSecurityPluginV2.F(j3));
            this.f313780a.getRootView().invalidate();
        }
    }

    private void B() {
        CustomWebView e16 = this.mRuntime.e();
        if (!TextUtils.isEmpty(this.C) || e16 == null) {
            return;
        }
        this.C = e16.getUrl();
        Intent intent = this.mRuntime.a().getIntent();
        if (!TextUtils.isEmpty(this.C) || intent == null) {
            return;
        }
        this.C = intent.getStringExtra("url");
    }

    private boolean C() {
        if (M == null) {
            M = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("webview_security_url_match", false));
            if (QLog.isColorLevel()) {
                QLog.i("WebSecurityPluginV2", 2, "ensureUrlMatchSwitch=" + M);
            }
        }
        return M.booleanValue();
    }

    private void D(String str) {
        if (this.I.contains(str) || TextUtils.isEmpty(str)) {
            return;
        }
        this.I.add(str);
    }

    private String[] E() {
        String[] split;
        String x16 = AuthorizeConfig.y().x("ban_domain", QzoneConfig.SECONDARY_IGNORE_DOWNLOAD_APK_DOMAINS_DEFAULT);
        if (TextUtils.isEmpty(x16) || (split = x16.split(",")) == null) {
            return null;
        }
        for (int i3 = 0; i3 < split.length; i3++) {
            if (TextUtils.isEmpty(split[i3])) {
                split[i3] = "";
            } else {
                split[i3] = split[i3].trim();
            }
        }
        return split;
    }

    private void G(String str, String str2) {
        WebView.HitTestResult hitTestResult;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.e() == null) {
            return;
        }
        if (this.I.isEmpty()) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.I.add(str2);
            return;
        }
        String k3 = com.tencent.mobileqq.webview.swift.utils.i.k(str);
        if (("http".equals(k3) || "https".equals(k3)) && (hitTestResult = this.mRuntime.e().getHitTestResult()) != null && hitTestResult.getType() == 0) {
            QLog.i("WebSecurityPluginV2", 1, "shouldOverrideUrlLoading detect 302, url: " + (QLog.isColorLevel() ? str : com.tencent.biz.common.util.k.f(str, new String[0])));
            D(str);
        }
    }

    private boolean I(String str) {
        return AuthorizeConfig.y().N(str);
    }

    private boolean J(String str) {
        return AuthorizeConfig.y().R(str);
    }

    private void L() {
        int size = this.I.size();
        if (size <= 0) {
            return;
        }
        String str = this.I.get(size - 1);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        this.I = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(String str, String[] strArr, com.tencent.mobileqq.dt.api.i iVar) {
        try {
            A(str, strArr, iVar);
        } catch (Exception e16) {
            QLog.e("WebSecurityPluginV2", 1, "validCheck exception: " + e16.getMessage(), e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || !peekAppRuntime.isLogin()) {
                return;
            }
            this.D = SpringHbUrlCheckConfProcessor.b();
        } catch (Exception e16) {
            QLog.e("WebSecurityPluginV2", 1, " init SpringHbUrlCheckConfProcessor error " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(Activity activity, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        activity.finish();
    }

    private static String R(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        QLog.d("WebSecurityPluginV2", 1, "parseHexStringOfUtf16:" + str);
        StringBuilder sb5 = new StringBuilder(3);
        try {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = i3 * 2;
                char charAt = str.charAt(i16);
                char charAt2 = str.charAt(i16 + 1);
                sb5.append(charAt);
                sb5.append(charAt2);
                int parseInt = Integer.parseInt(sb5.toString(), 16);
                sb5.delete(0, sb5.length());
                bArr[i3] = (byte) parseInt;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.BIG_ENDIAN);
            return StandardCharsets.UTF_16.decode(wrap).toString();
        } catch (Exception e16) {
            QLog.w("WebSecurityPluginV2", 1, "parseHexStringOfUtf16 exception: " + e16.getMessage(), e16);
            return null;
        }
    }

    private void S() {
        CustomWebView e16;
        if (this.E != null || (e16 = this.mRuntime.e()) == null) {
            return;
        }
        this.E = new com.tencent.biz.o(e16, new c());
    }

    private void T() {
        URLCheckParams uRLCheckParams = this.H;
        if (uRLCheckParams == null) {
            if (QLog.isColorLevel()) {
                QLog.d("WebSecurityPluginV2", 2, "reportArkMsgOnPageFinish urlCheckParams is null");
            }
        } else if (uRLCheckParams.E) {
            if (QLog.isColorLevel()) {
                QLog.d("WebSecurityPluginV2", 2, "reportArkMsgOnPageFinish isPageFinish");
            }
        } else {
            L();
            URLCheckParams uRLCheckParams2 = this.H;
            uRLCheckParams2.E = true;
            this.G = this.F.l(uRLCheckParams2, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void U() {
        int i3;
        String str;
        String str2;
        String str3;
        int i16;
        String stringExtra;
        String stringExtra2;
        int i17;
        String str4;
        String str5;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null) {
            Intent intent = this.mRuntime.a().getIntent();
            CustomWebView e16 = this.mRuntime.e();
            String originalUrl = e16 != null ? e16.getOriginalUrl() : "";
            int i18 = 0;
            if (intent != null) {
                if (intent.getBooleanExtra("fromQrcode", false)) {
                    str5 = "mqq.qrcode";
                } else {
                    if (!intent.getBooleanExtra("fromQZone", false)) {
                        int intExtra = intent.getIntExtra("uinType", -1);
                        if (intExtra == -1) {
                            intExtra = intent.getIntExtra("curtype", -1);
                        }
                        if (intExtra == 0) {
                            stringExtra = intent.getStringExtra("friend_uin");
                            stringExtra2 = intent.getStringExtra("friendUin");
                            i17 = intent.getBooleanExtra(QQBrowserActivity.KEY_IS_SEND, false) ? 1 : 2;
                            str4 = "mqq.c2c";
                        } else {
                            if (intExtra == 1) {
                                stringExtra = intent.getStringExtra("groupUin");
                                String stringExtra3 = intent.getStringExtra("friendUin");
                                i16 = intent.getBooleanExtra(QQBrowserActivity.KEY_IS_SEND, false) ? 1 : 2;
                                str2 = stringExtra3;
                                str = "mqq.group";
                                i3 = 2;
                                str3 = stringExtra;
                                if (QLog.isColorLevel()) {
                                }
                                LpReportInfo_dc04171.report(this.f313769e, originalUrl, str, i3, i16, str2, str3);
                                return;
                            }
                            if (intExtra == 1000 || intExtra == 1001 || intExtra == 1004 || intExtra == 1005) {
                                String stringExtra4 = intent.getStringExtra("friend_uin");
                                i3 = 1;
                                str2 = intent.getStringExtra("friendUin");
                                i16 = intent.getBooleanExtra(QQBrowserActivity.KEY_IS_SEND, false) ? 1 : 2;
                                str3 = stringExtra4;
                                str = "";
                                if (QLog.isColorLevel()) {
                                    QLog.d("WebSecurityPluginV2", 1, "reportSoftKeyboardToggled-- referer:" + originalUrl + " ,url:" + this.f313769e + " ,msgType:" + i3 + ",msgFrom:" + i16 + ",senderUin:" + str2 + ",chatId:" + str3 + ",urlSource:" + str);
                                }
                                LpReportInfo_dc04171.report(this.f313769e, originalUrl, str, i3, i16, str2, str3);
                                return;
                            }
                            if (intExtra != 3000) {
                                QLog.d("WebSecurityPluginV2", 4, "reportSoftKeyboardToggled:unknow uinType");
                            } else {
                                stringExtra = intent.getStringExtra("dicussgroup_uin");
                                stringExtra2 = intent.getStringExtra("friendUin");
                                i17 = intent.getBooleanExtra(QQBrowserActivity.KEY_IS_SEND, false) ? 1 : 2;
                                str4 = "mqq.discussion";
                                i18 = 3;
                            }
                        }
                        str = str4;
                        str2 = stringExtra2;
                        i3 = i18;
                        i16 = i17;
                        str3 = stringExtra;
                        if (QLog.isColorLevel()) {
                        }
                        LpReportInfo_dc04171.report(this.f313769e, originalUrl, str, i3, i16, str2, str3);
                        return;
                    }
                    str5 = "mqq.qzone";
                }
                str = str5;
                i3 = -1;
                str2 = "";
                str3 = str2;
                i16 = 0;
                if (QLog.isColorLevel()) {
                }
                LpReportInfo_dc04171.report(this.f313769e, originalUrl, str, i3, i16, str2, str3);
                return;
            }
            i3 = -1;
            str = "";
            str2 = str;
            str3 = str2;
            i16 = 0;
            if (QLog.isColorLevel()) {
            }
            LpReportInfo_dc04171.report(this.f313769e, originalUrl, str, i3, i16, str2, str3);
            return;
        }
        QLog.e("WebSecurityPluginV2", 1, "reportSoftKeyboardToggled mRuntime empty");
    }

    private Object V(String str) {
        WebViewPlugin.b bVar = this.mRuntime;
        Activity a16 = bVar != null ? bVar.a() : null;
        Intent intent = a16 != null ? a16.getIntent() : null;
        if (H(intent != null ? intent.getStringExtra("url") : null) && K(str)) {
            return new WebResourceResponse("text/javascript", "utf-8", new ByteArrayInputStream("if(1===1){};".getBytes()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void W(WebSecurityPluginV2 webSecurityPluginV2, int i3, String str) {
        final Activity a16;
        QQCustomDialog qQCustomDialog = webSecurityPluginV2.J;
        if ((qQCustomDialog != null && qQCustomDialog.isShowing()) || (a16 = webSecurityPluginV2.mRuntime.a()) == null || a16.isFinishing()) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(a16, 230, "\u98ce\u9669\u63d0\u793a", str + "(" + i3 + ")", F(0L), "\u9000\u51fa\u9875\u9762", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.webview.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                WebSecurityPluginV2.O(a16, dialogInterface, i16);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.webview.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                dialogInterface.dismiss();
            }
        });
        webSecurityPluginV2.J = createCustomDialog;
        TextView btnLeft = createCustomDialog.getBtnLeft();
        btnLeft.setEnabled(false);
        btnLeft.setAlpha(0.5f);
        webSecurityPluginV2.J.show();
        webSecurityPluginV2.J.setCancelable(false);
        CountDownTimer countDownTimer = webSecurityPluginV2.K;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        e eVar = new e(webSecurityPluginV2, btnLeft, 5000L, 1000L);
        webSecurityPluginV2.K = eVar;
        eVar.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void w(WebSecurityPluginV2 webSecurityPluginV2, int i3, String str) {
        W(webSecurityPluginV2, i3, str);
    }

    private boolean x(String str) {
        try {
            if (this.D == null) {
                this.D = SpringHbUrlCheckConfProcessor.b();
            }
            if (this.D != null) {
                ArrayList<String> a16 = this.D.a();
                if (QLog.isColorLevel()) {
                    QLog.d("WebSecurityPluginV2SpringHbSecurity", 1, "uncheckUrlPrefixes = " + a16);
                }
                if (a16 != null && !a16.isEmpty()) {
                    for (int i3 = 0; i3 < a16.size(); i3++) {
                        if (str.startsWith(a16.get(i3))) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SpringHbSecurity", 1, "isDisableSecurityCheck url=" + str);
                            }
                            return true;
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("SpringHbSecurity", 1, "notDisableSecurityCheck url=" + str);
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SpringHbSecurity", 2, "handleIsSecurityEnable e:", e16);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(String str, boolean z16) {
        if (C()) {
            if (TextUtils.equals(this.f313769e, str)) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WebSecurityPluginV2", 2, "receive check result but not current url");
            }
            return false;
        }
        if (z16 || TextUtils.equals(this.f313769e, str)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WebSecurityPluginV2", 2, "receive sync check result but not current url");
        }
        return false;
    }

    boolean H(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String domin = Utils.getDomin(str);
        if (TextUtils.isEmpty(domin)) {
            return false;
        }
        String lowerCase = domin.toLowerCase();
        String[] E = E();
        if (E != null && E.length != 0) {
            for (String str2 : E) {
                if (!TextUtils.isEmpty(str2)) {
                    String lowerCase2 = str2.toLowerCase();
                    if (lowerCase.endsWith("." + lowerCase2)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("WebSecurityPluginV2", 2, "match domain:" + lowerCase + ",webviewUrl=" + str);
                        }
                        return true;
                    }
                    if (lowerCase.equals(lowerCase2)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("WebSecurityPluginV2", 2, "match domain:" + lowerCase + ",webviewUrl=" + str);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean K(String str) {
        String x16 = AuthorizeConfig.y().x("call_app", QzoneConfig.QZONE_CALL_APP_URL_LIST_DEFAULT);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(x16)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(x16);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String optString = jSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString) && QzoneStringMatcher.isMatch(str, optString)) {
                    if (!QLog.isColorLevel()) {
                        return true;
                    }
                    QLog.d("WebSecurityPluginV2", 2, "isUrlInRegList match url:" + str + " ,reg=" + optString);
                    return true;
                }
            }
            return false;
        } catch (JSONException e16) {
            QZLog.e("WebSecurityPluginV2", "isUrlInRegList json error.", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "UrlSaveVerifyV2";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 3L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        if (j3 == 8) {
            return V(str);
        }
        return super.handleEvent(str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, final String str, String str2, String str3, final String... strArr) {
        if ("UrlSaveVerifyV2".equals(str2)) {
            if ("continueVisit".equals(str3) && strArr.length > 0) {
                try {
                    String optString = new JSONObject(strArr[0]).optString("url");
                    if (!TextUtils.isEmpty(optString)) {
                        CustomWebView e16 = this.mRuntime.e();
                        if (e16 != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("WebSecurityPluginV2", 2, "continueVisit url=" + com.tencent.biz.common.util.k.f(optString, new String[0]));
                            }
                            this.f313768d = optString;
                            e16.loadUrl(optString);
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("WebSecurityPluginV2", 2, "jump url is null");
                    }
                } catch (JSONException e17) {
                    QLog.e("WebSecurityPluginV2", 1, e17.toString());
                }
            } else if ("validCheck".equals(str3) && strArr.length > 0) {
                QQCustomDialog qQCustomDialog = this.J;
                if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                    QLog.d("WebSecurityPluginV2", 1, "validCheck showing return");
                    return false;
                }
                if (!this.f313771h) {
                    QLog.d("WebSecurityPluginV2", 1, "validCheck c=0 return");
                    return false;
                }
                final com.tencent.mobileqq.dt.api.i iVar = new com.tencent.mobileqq.dt.api.i();
                iVar.h(this.H.C);
                iVar.f(this.f313769e);
                iVar.g(this.H.f313765m);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebSecurityPluginV2.this.M(str, strArr, iVar);
                    }
                }, 16, null, true);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("UrlCheckLog_WebSecurityPluginV2", 2, " url = " + str + " scheme = " + str2);
        }
        if (this.f313773m) {
            if (QLog.isColorLevel()) {
                QLog.i("WebSecurityPluginV2", 2, "return cause of already warned");
            }
            return false;
        }
        if (!"http".equals(str2) && !"https".equals(str2)) {
            return false;
        }
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null) {
            S();
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null && !runtime.isLogin()) {
                QLog.e("WebSecurityPluginV2", 1, "return cause of not login");
                return false;
            }
            if (!AppNetConnInfo.isNetSupport()) {
                QLog.e("WebSecurityPluginV2", 1, "return cause of no network");
                return false;
            }
            B();
            if (x(str)) {
                QLog.e("WebSecurityPluginV2", 1, "return cause of operation activities");
                return false;
            }
            this.f313769e = str;
            if (str.equals(this.f313768d)) {
                this.f313768d = null;
                if (QLog.isColorLevel()) {
                    QLog.i("WebSecurityPluginV2", 2, "return cause of last safe url");
                }
                return false;
            }
            this.f313770f = !J(str);
            boolean z16 = !this.f313772i || I(str);
            if (this.f313772i) {
                this.f313772i = false;
                SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) getBrowserComponent(-2);
                if (swiftBrowserStatistics != null) {
                    swiftBrowserStatistics.P0 = !z16;
                }
            }
            QLog.i("UrlCheckLog_WebSecurityPluginV2", 1, ", async=" + z16 + ", showInputWarn=" + this.f313770f + ", now check url=" + (QLog.isColorLevel() ? str : com.tencent.biz.common.util.k.f(str, new String[0])));
            G(str, this.C);
            this.H = Q(str);
            if (this.F == null) {
                com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
                this.F = A;
                A.p();
            }
            this.G = this.F.l(this.H, new a(str, z16));
            return !z16;
        }
        QLog.e("WebSecurityPluginV2", 1, "handleSchemaRequest mRuntime empty");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.i
            @Override // java.lang.Runnable
            public final void run() {
                WebSecurityPluginV2.this.N();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        com.tencent.biz.troop.b bVar = this.F;
        if (bVar != null) {
            bVar.l0(this.G);
            this.F.q();
        }
        com.tencent.biz.o oVar = this.E;
        if (oVar != null) {
            oVar.a();
        }
        CountDownTimer countDownTimer = this.K;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        QQCustomDialog qQCustomDialog = this.J;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.J.dismiss();
        }
        this.I.clear();
    }

    void y(long j3) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("WebSecurityPluginV2", 2, "checkOperationBit ", Long.valueOf(j3));
        }
        if ((1 & j3) != 0) {
            CustomWebView e16 = this.mRuntime.e();
            if (e16 != null) {
                try {
                    if (e16.getX5WebViewExtension() != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("forbid-input", "*");
                        e16.getX5WebViewExtension().setFakeLoginParams(bundle);
                        if (QLog.isColorLevel()) {
                            QLog.d("WebSecurityPluginV2", 2, "checkOperationBit success");
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("WebSecurityPluginV2", 2, "initWebviewExtension e:", th5);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if ((j3 & 4) != 0) {
            Intent intent = this.mRuntime.a().getIntent();
            CustomWebView e17 = this.mRuntime.e();
            String str2 = "";
            if (e17 == null) {
                str = "";
            } else {
                str = e17.getUrl();
            }
            if (intent != null) {
                str2 = intent.getStringExtra("url");
            }
            if (this.F != null) {
                try {
                    Bundle r16 = SwiftBrowserStatistics.r(str2);
                    r16.putString("uin", this.mRuntime.b().getCurrentAccountUin());
                    if (e17 != null) {
                        String title = e17.getTitle();
                        if (!TextUtils.isEmpty(title)) {
                            r16.putString("title", title);
                        }
                    }
                    this.F.o0(1, str, str2, r16);
                } catch (Throwable th6) {
                    QLog.e("WebSecurityPluginV2", 1, th6, new Object[0]);
                }
            }
        }
    }

    private void A(String str, String[] strArr, com.tencent.mobileqq.dt.api.i iVar) {
        String str2 = strArr[0];
        int length = str2 == null ? 0 : str2.length();
        if (length > 409600) {
            str2 = str2.substring(0, QzoneConfig.DEFAULT_PHOTOVIEW_LIST_SIZE_TO_FINISH);
        }
        String R = R(str2);
        int length2 = R == null ? 0 : R.length();
        if (length2 >= 5 && this.H != null) {
            if (length2 > 102400) {
                R = R.substring(0, RFixConstants.MD5_FILE_BUF_LENGTH);
            }
            if (QLog.isColorLevel()) {
                QLog.i("WebSecurityPluginV2", 2, "doValidCheck ori=" + length + ", len=" + R.length() + ", text=" + R);
            } else {
                QLog.i("WebSecurityPluginV2", 2, "doValidCheck ori=" + length + ", len=" + R.length());
            }
            iVar.e(R);
            ((IDTAPI) QRoute.api(IDTAPI.class)).webCheck(iVar, new d(this));
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("validCheck return cause of len=");
        sb5.append(length2);
        sb5.append(", params valid=");
        sb5.append(this.H != null);
        QLog.d("WebSecurityPluginV2", 1, sb5.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private URLCheckParams Q(String str) {
        String str2;
        String str3;
        String str4;
        int i3;
        int i16;
        int i17;
        Intent intent = this.mRuntime.a().getIntent();
        if (intent == null) {
            str2 = "";
            str3 = str2;
            str4 = str3;
        } else {
            String stringExtra = intent.getStringExtra("key_url_source");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = "";
            }
            if (intent.getBooleanExtra("fromQrcode", false)) {
                int intExtra = intent.getIntExtra(QQBrowserActivity.KEY_MSG_TYPE, 0);
                String stringExtra2 = intent.getStringExtra("friend_uin");
                i17 = intent.getBooleanExtra(QQBrowserActivity.KEY_IS_SEND, false) ? 1 : 2;
                str4 = "mqq.qrcode";
                str2 = "";
                i3 = intExtra;
                str3 = stringExtra2;
            } else if (intent.getBooleanExtra("fromQZone", false)) {
                str4 = "mqq.qzone";
                str2 = "";
                str3 = str2;
            } else {
                int intExtra2 = intent.getIntExtra("uinType", -1);
                if (intExtra2 == -1) {
                    intExtra2 = intent.getIntExtra("curtype", -1);
                }
                if (intExtra2 == 0) {
                    String stringExtra3 = intent.getStringExtra("friend_uin");
                    String stringExtra4 = intent.getStringExtra("friendUin");
                    i17 = intent.getBooleanExtra(QQBrowserActivity.KEY_IS_SEND, false) ? 1 : 2;
                    str4 = "mqq.c2c";
                    str3 = stringExtra3;
                    str2 = stringExtra4;
                    i3 = 0;
                } else if (intExtra2 == 1) {
                    String stringExtra5 = intent.getStringExtra("groupUin");
                    String stringExtra6 = intent.getStringExtra("friendUin");
                    i17 = intent.getBooleanExtra(QQBrowserActivity.KEY_IS_SEND, false) ? 1 : 2;
                    str4 = "mqq.group";
                    i3 = 2;
                    str3 = stringExtra5;
                    str2 = stringExtra6;
                } else {
                    if (intExtra2 == 1000 || intExtra2 == 1001 || intExtra2 == 1004 || intExtra2 == 1005) {
                        String stringExtra7 = intent.getStringExtra("friend_uin");
                        String stringExtra8 = intent.getStringExtra("friendUin");
                        i16 = intent.getBooleanExtra(QQBrowserActivity.KEY_IS_SEND, false) ? 1 : 2;
                        str3 = stringExtra7;
                        str2 = stringExtra8;
                        str4 = stringExtra;
                        i3 = 1;
                    } else if (intExtra2 == 3000) {
                        String stringExtra9 = intent.getStringExtra("dicussgroup_uin");
                        String stringExtra10 = intent.getStringExtra("friendUin");
                        i17 = intent.getBooleanExtra(QQBrowserActivity.KEY_IS_SEND, false) ? 1 : 2;
                        str4 = "mqq.discussion";
                        str3 = stringExtra9;
                        str2 = stringExtra10;
                        i3 = 3;
                    } else if (intExtra2 != 10014) {
                        str2 = "";
                        str3 = str2;
                        i3 = -1;
                        i16 = 0;
                        str4 = stringExtra;
                    } else {
                        String stringExtra11 = intent.getStringExtra("friend_uin");
                        String stringExtra12 = intent.getStringExtra("friendUin");
                        i17 = intent.getBooleanExtra(QQBrowserActivity.KEY_IS_SEND, false) ? 1 : 2;
                        i3 = 4;
                        str3 = stringExtra11;
                        str2 = stringExtra12;
                        str4 = stringExtra;
                    }
                    URLCheckParams a16 = URLCheckParams.a(str, i3, i16, str2, str3, str4, this.C, this.mRuntime.a().getIntent().getStringExtra(AppConstants.Key.H5_ARK_APP_NAME), false, this.mRuntime.a().getIntent().getBooleanExtra("key_multiforward_root_msg_record", false), this.I);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("UrlCheckLog_WebSecurityPluginV2", 2, "makeUrlCheckParams: " + a16);
                    }
                    return a16;
                }
            }
            i16 = i17;
            URLCheckParams a162 = URLCheckParams.a(str, i3, i16, str2, str3, str4, this.C, this.mRuntime.a().getIntent().getStringExtra(AppConstants.Key.H5_ARK_APP_NAME), false, this.mRuntime.a().getIntent().getBooleanExtra("key_multiforward_root_msg_record", false), this.I);
            if (QLog.isDevelopLevel()) {
            }
            return a162;
        }
        i3 = -1;
        i16 = 0;
        URLCheckParams a1622 = URLCheckParams.a(str, i3, i16, str2, str3, str4, this.C, this.mRuntime.a().getIntent().getStringExtra(AppConstants.Key.H5_ARK_APP_NAME), false, this.mRuntime.a().getIntent().getBooleanExtra("key_multiforward_root_msg_record", false), this.I);
        if (QLog.isDevelopLevel()) {
        }
        return a1622;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934593L) {
            if (this.f313771h) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.L);
            }
        } else if (j3 == 8589934594L) {
            T();
            if (this.f313771h) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.L);
                ThreadManagerV2.getUIHandlerV2().postDelayed(this.L, 500L);
            }
        } else if (j3 == 8589934626L) {
            D(str);
        }
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String F(long j3) {
        if (j3 <= 0) {
            return "\u7ee7\u7eed\u8bbf\u95ee";
        }
        if (j3 % 1000 == 0) {
            return String.format("\u7ee7\u7eed\u8bbf\u95ee(%d\u79d2)", Long.valueOf(j3 / 1000));
        }
        return String.format("\u7ee7\u7eed\u8bbf\u95ee(%d\u79d2)", Long.valueOf((j3 / 1000) + 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class b implements ITroopMemberApiClientApi.a {
        b() {
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
        }
    }
}
