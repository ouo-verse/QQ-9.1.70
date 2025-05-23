package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.component.media.MtpConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.webview.api.IJumpApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.util.URLUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.util.QZoneNumberUtil;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* loaded from: classes35.dex */
public class WebViewJumpPlugin extends WebViewPlugin {

    /* renamed from: m, reason: collision with root package name */
    public static final String f315044m = "WebViewJumpPlugin";

    /* renamed from: d, reason: collision with root package name */
    WebView f315045d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f315046e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f315047f;

    /* renamed from: h, reason: collision with root package name */
    QQAppInterface f315048h = null;

    /* renamed from: i, reason: collision with root package name */
    private boolean f315049i = true;

    private void q(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("mqqapi://armap_entry/map?src_type=web&version=1&from_type=0&service_id=1") || str.startsWith("mqqapi://personal_tag/tag_list")) {
            new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.5
                @Override // java.lang.Runnable
                public void run() {
                    Activity a16 = WebViewJumpPlugin.this.mRuntime.a();
                    if (a16 == null || a16.isFinishing()) {
                        return;
                    }
                    a16.finish();
                }
            }, 2000L);
        }
    }

    private Activity r() {
        Activity a16 = this.mRuntime.a();
        while (a16 != null && (a16 instanceof BasePluginActivity)) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    private void s(String str) {
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            return;
        }
        a16.finish();
        if (com.tencent.biz.qrcode.util.h.I(str)) {
            Intent intent = new Intent(a16, (Class<?>) JoinDiscussionActivity.class);
            intent.putExtra("innerSig", str);
            startActivity(intent);
        } else {
            ax c16 = bi.c(this.f315048h, a16, str);
            if (c16 != null) {
                c16.b();
            }
        }
    }

    private void startActivity(Intent intent) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            return;
        }
        if (bVar.a() != null) {
            this.mRuntime.a().startActivity(intent);
        } else if (QLog.isColorLevel()) {
            QLog.d(f315044m, 2, "Activity is null");
        }
    }

    private boolean u(String str) {
        Uri parse;
        WebView webView = this.f315045d;
        if (webView == null || webView.getUrl() == null || !str.startsWith("txc://") || (parse = Uri.parse(this.f315045d.getUrl())) == null || parse.getHost() == null) {
            return false;
        }
        String scheme = parse.getScheme();
        if ("http".equals(scheme) || "https".equals(scheme)) {
            return parse.getHost().equals(IJumpApi.TXC_POSTSUBMIT_HOST_1) || parse.getHost().endsWith(".txc.qq.com") || parse.getHost().equals(IJumpApi.TXC_POSTSUBMIT_HOST_2) || parse.getHost().endsWith(".support.qq.com");
        }
        return false;
    }

    private void v(final String str) {
        WebView webView;
        if ((str.startsWith("http:") || str.startsWith("https:")) && (webView = this.f315045d) != null) {
            final String url = webView.getUrl();
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.4
                @Override // java.lang.Runnable
                public void run() {
                    MobileReportManager.getInstance().reportH5DomainClick(url, str);
                }
            });
        }
    }

    private boolean w() {
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("webview_txc_logReport", false);
        QLog.d(f315044m, 1, "close webview_txc_logReport:" + isFeatureSwitchEnable);
        return !isFeatureSwitchEnable;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return f315044m;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 2L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        ax c16;
        String substring;
        WebViewPlugin.b bVar;
        Intent intent;
        if (QLog.isColorLevel()) {
            QLog.d("WebViewPlugin", 2, "handleSchemaRequest-->url:" + str + ",scheme:" + str2 + "mActive=" + this.f315049i);
        }
        if (!this.f315049i) {
            return false;
        }
        if (com.tencent.mobileqq.qrscan.utils.b.d(str) && com.tencent.biz.qrcode.util.h.E(str)) {
            return false;
        }
        Activity r16 = r();
        String stringExtra = (r16 == null || (intent = r16.getIntent()) == null) ? null : intent.getStringExtra("big_brother_source_key");
        if (str.startsWith(WebView.SCHEME_TEL)) {
            Intent intent2 = new Intent("android.intent.action.DIAL", Uri.parse(str));
            intent2.putExtra("big_brother_source_key", stringExtra);
            if (!wy2.d.f446751a && wy2.c.d().f()) {
                wy2.c.d().h(intent2);
            }
            startActivity(intent2);
            return true;
        }
        if (((IGameCenterKuiklyApi) QRoute.api(IGameCenterKuiklyApi.class)).checkIfOpenFloatInCurProcess(str)) {
            return true;
        }
        if (str.startsWith("sms:")) {
            Intent intent3 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            intent3.putExtra("address", str.substring(str.indexOf(":") + 1, indexOf));
            int indexOf2 = str.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
            if (indexOf2 == -1) {
                indexOf2 = str.length() - 1;
            }
            intent3.putExtra(SmsPlugin.KEY_SYSTEM_SMS_CONTENT, str.substring(indexOf2 + 1, str.length()));
            intent3.setType(SmsPlugin.KEY_SYSTEM_SMS_TYPE);
            startActivity(intent3);
            return true;
        }
        if (str.startsWith("mqqapi://avatar/update?")) {
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 2, "enter WebViewJumpPlugin classicHeadActivity url=" + str);
            }
            String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
            if (split != null && split.length >= 5) {
                String[] split2 = split[2].split(ContainerUtils.KEY_VALUE_DELIMITER);
                String[] split3 = split[3].split(ContainerUtils.KEY_VALUE_DELIMITER);
                String[] split4 = split[4].split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2 != null && split2.length == 2 && split3 != null && split3.length == 2 && split4 != null && split4.length == 2) {
                    String str3 = split2[1];
                    long parseLong = Long.parseLong(split4[1]);
                    long parseLong2 = Long.parseLong(split3[1]);
                    Intent intent4 = new Intent(FaceConstant.HeadBroadcast.BROADCAST_QQHEAD_REFRESH_HEAD_REQ);
                    intent4.setPackage(this.mRuntime.a().getPackageName());
                    intent4.putExtra("faceType", 1);
                    intent4.putExtra("uin", str3);
                    intent4.putExtra("headSystemId", parseLong2);
                    intent4.putExtra(FaceConstant.AvatarInfoBuilderKeys.FACE_FLAG, parseLong);
                    this.mRuntime.a().sendBroadcast(intent4);
                    return true;
                }
            }
        } else {
            if (str.startsWith("mqqapi://tenpay/pay?")) {
                int requestCode = getRequestCode((byte) 3);
                if (requestCode != -1 && !this.f315047f) {
                    this.f315047f = true;
                    ax c17 = bi.c(this.f315048h, this.mRuntime.a(), str);
                    if (c17 != null) {
                        c17.v("webview");
                        c17.r("k_requestcode", String.valueOf(requestCode));
                        c17.r("url_app_info", QWalletPayJsPlugin.getPayAppInfo());
                        c17.b();
                        this.f315046e = true;
                        this.f315047f = false;
                    }
                }
                return true;
            }
            if (!com.tencent.biz.qrcode.util.h.E(str) && !str.startsWith("mqqopensdkapi:")) {
                if (str.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard")) {
                    String queryParameter = Uri.parse(str).getQueryParameter("xq_uin");
                    if (TextUtils.isEmpty(queryParameter)) {
                        return false;
                    }
                    String str4 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + queryParameter;
                    Activity a16 = this.mRuntime.a();
                    if (a16 == null) {
                        return true;
                    }
                    ax c18 = bi.c(this.f315048h, a16, str4);
                    if (c18 != null) {
                        c18.v("webview");
                        c18.b();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity a17 = WebViewJumpPlugin.this.mRuntime.a();
                            if (a17 == null || a17.isFinishing()) {
                                return;
                            }
                            a17.finish();
                        }
                    }, 2000L);
                    return true;
                }
                if (str.startsWith("http://clientui.3g.qq.com/mqqapi/")) {
                    WebView webView = this.f315045d;
                    if (webView == null) {
                        if (!QLog.isColorLevel()) {
                            return true;
                        }
                        QLog.d(f315044m, 2, "webview is null");
                        return true;
                    }
                    String url = webView.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        return false;
                    }
                    String f16 = com.tencent.biz.common.util.k.f(str, new String[0]);
                    if (f16.length() > 512) {
                        f16 = f16.substring(0, 512);
                    }
                    ReportController.n(null, "P_CliOper", "BizTechReport", "", "webview_jump", "http_jumpaction", 0, 1, 0, com.tencent.biz.common.util.k.f(url, new String[0]), f16, "", "");
                    return false;
                }
                if (str.startsWith("mqqapi://readinjoy")) {
                    ax c19 = bi.c(this.f315048h, this.mRuntime.a(), str);
                    if (c19 == null) {
                        return true;
                    }
                    c19.v("webview");
                    c19.b();
                    return true;
                }
                if (str.startsWith("mqqapi://now/playmedia")) {
                    ax c26 = bi.c(this.f315048h, this.mRuntime.a(), str);
                    if (c26 == null) {
                        return true;
                    }
                    c26.v("webview");
                    c26.b();
                    return true;
                }
                if (str.startsWith("mqqapi://now/playmedia")) {
                    ax c27 = bi.c(this.f315048h, this.mRuntime.a(), str);
                    if (c27 == null) {
                        return true;
                    }
                    c27.v("webview");
                    c27.u(this.mRuntime.b());
                    c27.b();
                    return true;
                }
                if (str.startsWith("mqqapi://now/openSmallVideoRecord")) {
                    ax c28 = bi.c(this.f315048h, this.mRuntime.a(), str);
                    if (c28 == null) {
                        return true;
                    }
                    c28.v("webview");
                    c28.u(this.mRuntime.b());
                    c28.b();
                    return true;
                }
                if (!str.startsWith("mqqapi://") && !str.startsWith("qqfav://operation/") && !str.startsWith("nowmqqapi://now/openroom") && !str.startsWith("mqqguild://")) {
                    if (str.startsWith("qb")) {
                        if (p(str, false) || (bVar = this.mRuntime) == null || bVar.a() == null) {
                            return true;
                        }
                        String validQBUrl = MttLoader.getValidQBUrl(this.mRuntime.a(), str);
                        WebView webView2 = this.f315045d;
                        if (webView2 == null) {
                            QLog.d(f315044m, 1, "webview is null");
                            return true;
                        }
                        webView2.loadUrl(validQBUrl);
                        return true;
                    }
                    if (!str.startsWith("mqqflyticket://") && !com.tencent.biz.qrcode.util.h.A(str)) {
                        if (str.startsWith("mqqwpa://im")) {
                            Intent intent5 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
                            intent5.addFlags(268435456);
                            intent5.putExtra("from", "webview");
                            startActivity(intent5);
                            return true;
                        }
                        if (str.startsWith("mqqapi://pay_for_emosm_success")) {
                            Activity a17 = this.mRuntime.a();
                            if (a17 != null) {
                                a17.setResult(MtpConstants.RESPONSE_NO_VALID_OBJECT_INFO);
                                a17.finish();
                            }
                        } else if (str.startsWith("mqqapi://od")) {
                            t(str);
                        } else if (str.startsWith(QZoneHelper.QZoneFamousSpaceHomeConstants.FAMOUS_SPACE_HOME_URL_PREFIX)) {
                            Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str);
                            if (argumentsFromURL.containsKey("uin")) {
                                substring = argumentsFromURL.get("uin");
                            } else {
                                int lastIndexOf = str.lastIndexOf(63);
                                if (lastIndexOf != -1) {
                                    substring = str.substring(26, lastIndexOf);
                                } else {
                                    substring = str.substring(26);
                                }
                            }
                            try {
                                ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchUserHome(this.mRuntime.a(), QZoneNumberUtil.safeParseLong(substring, 0L), argumentsFromURL.containsKey("is_famous_space") && "1".equals(argumentsFromURL.get("is_famous_space")), 0);
                                new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Activity a18 = WebViewJumpPlugin.this.mRuntime.a();
                                        if (a18 == null || a18.isFinishing()) {
                                            return;
                                        }
                                        a18.finish();
                                    }
                                }, 2000L);
                                return true;
                            } catch (NumberFormatException e16) {
                                e16.printStackTrace();
                            }
                        } else if (str.startsWith("mqqconferenceflyticket://")) {
                            this.mRuntime.a();
                        } else if (str.startsWith("mqqapi://groupvideo")) {
                            ax c29 = bi.c(this.f315048h, this.mRuntime.a(), str);
                            if (c29 != null) {
                                c29.b();
                            }
                        } else if (str.startsWith("mqqapi://stickynote")) {
                            ax c36 = bi.c(this.f315048h, this.mRuntime.a(), str);
                            if (c36 != null) {
                                c36.b();
                            }
                        } else if (str.startsWith("auth://tauth.qq.com/?#")) {
                            Activity a18 = this.mRuntime.a();
                            QLog.d("WebViewPlugin", 1, "qrcode login end activity=", a18);
                            if (a18 != null) {
                                Intent intent6 = new Intent(NewIntent.ACTION_QRCODE_LOGIN_FINISH);
                                intent6.setPackage(MobileQQ.sMobileQQ.getPackageName());
                                intent6.putExtra("param_qr_code_url", str);
                                a18.sendBroadcast(intent6);
                                a18.finish();
                                return true;
                            }
                        } else if (u(str) && w() && (c16 = bi.c(this.f315048h, this.mRuntime.a(), str)) != null) {
                            return c16.b();
                        }
                    } else {
                        s(str);
                        return true;
                    }
                } else {
                    QLog.d("WebViewPlugin", 1, "handleSchemaRequest--->url:" + str + ",scheme:" + str2 + "mActive=" + this.f315049i);
                    Intent intent7 = new Intent(this.mRuntime.a(), (Class<?>) JumpActivity.class);
                    intent7.setData(Uri.parse(str));
                    intent7.putExtra("from", "webview");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        intent7.putExtra("big_brother_source_key", stringExtra);
                    }
                    startActivity(intent7);
                    q(str);
                    return true;
                }
            } else {
                Activity a19 = this.mRuntime.a();
                if (a19 == null) {
                    return true;
                }
                ax c37 = bi.c(this.f315048h, a19, str);
                if (c37 != null) {
                    c37.v("webview");
                    c37.b();
                }
                if (!str.startsWith("http:") && !str.startsWith("https:")) {
                    return true;
                }
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity a26 = WebViewJumpPlugin.this.mRuntime.a();
                        if (a26 == null || a26.isFinishing() || (a26 instanceof SplashActivity)) {
                            return;
                        }
                        a26.finish();
                    }
                }, 2000L);
                return true;
            }
        }
        v(str);
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityReady() {
        if (this.mRuntime.b() instanceof QQAppInterface) {
            this.f315048h = (QQAppInterface) this.mRuntime.b();
        }
        this.f315045d = this.mRuntime.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        com.tencent.biz.troop.b.A().p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        com.tencent.biz.troop.b.A().q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        this.f315045d = customWebView;
    }

    protected boolean p(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(MttLoader.KEY_PID, String.valueOf(50079));
        hashMap.put(MttLoader.KEY_EUSESTAT, String.valueOf(5));
        int loadUrl = MttLoader.loadUrl(this.mRuntime.a(), MttLoader.getValidQBUrl(this.mRuntime.a(), str), hashMap, null);
        if (z16) {
            WebView webView = this.f315045d;
            if (webView == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(f315044m, 2, "webview is null");
                }
                return true;
            }
            if (4 == loadUrl) {
                webView.loadUrl(QQBrowserActivity.QQBROWSER_DOWNLOAD_URL_DIRECT);
            } else if (5 == loadUrl) {
                webView.loadUrl(QQBrowserActivity.QQBROWSER_DOWNLOAD_URL_DIRECT);
            } else if (loadUrl != 0) {
                webView.loadUrl(QQBrowserActivity.QQBROWSER_DOWNLOAD_URL_DIRECT);
            }
        }
        return loadUrl == 0;
    }

    public void t(String str) {
        ax c16 = bi.c(this.f315048h, this.mRuntime.a(), str);
        if (c16 != null) {
            c16.b();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        if (b16 == 3) {
            if (i3 != -1) {
                if (i3 == 0) {
                    this.f315046e = false;
                    return;
                }
                return;
            }
            if (this.f315046e && intent != null && this.f315045d != null) {
                String stringExtra = intent.getStringExtra("callback_type");
                if ("javascript".equals(stringExtra)) {
                    callJs(intent.getStringExtra("callback_name"), intent.getStringExtra("callback_data"));
                } else if ("url".equals(stringExtra)) {
                    if (this.f315045d == null && QLog.isColorLevel()) {
                        QLog.d(f315044m, 2, "webview is null");
                        return;
                    }
                    this.f315045d.loadUrl(intent.getStringExtra("callback_url"));
                }
            }
            this.f315046e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        WebViewPlugin.b bVar;
        WebViewPlugin.b bVar2;
        if (j3 == 2) {
            this.f315049i = true;
        } else if (j3 == 8589934597L) {
            this.f315049i = false;
        } else if (j3 == 8589934601L) {
            if (!TextUtils.isEmpty(str) && ((str.contains("chatplay/hall") || str.contains("avwithstranger/avchathall") || str.contains("chatplay/avchathall")) && str.endsWith("#child"))) {
                if (str.contains("adtag=client.tab") && (bVar2 = this.mRuntime) != null && bVar2.a() != null && (this.mRuntime.a() instanceof IphoneTitleBarActivity)) {
                    ((IphoneTitleBarActivity) this.mRuntime.a()).setLeftViewName(R.string.hvm);
                }
                WebViewPlugin.b bVar3 = this.mRuntime;
                if (bVar3 != null && bVar3.e() != null && this.mRuntime.e().canGoBack()) {
                    this.mRuntime.e().goBack();
                    return true;
                }
            }
        } else if (j3 == 8589934594L && !TextUtils.isEmpty(str) && ((str.contains("chatplay/hall") || str.contains("avwithstranger/avchathall") || str.contains("chatplay/avchathall")) && str.endsWith("#child") && str.contains("adtag=client.tab") && (bVar = this.mRuntime) != null && bVar.a() != null && (this.mRuntime.a() instanceof IphoneTitleBarActivity))) {
            ((IphoneTitleBarActivity) this.mRuntime.a()).setLeftViewName(R.string.button_back);
        }
        return false;
    }
}
