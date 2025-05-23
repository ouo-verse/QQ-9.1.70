package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.UrlCheckPlugin;
import com.tencent.comic.api.hippy.BoodoModuleProxy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vas.VasUserData;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.cookie.SwiftTicketCookie;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.WtloginPrivacyListenerImpl;
import mqq.app.WtloginReportListenerImpl;
import mqq.app.WtloginSwitchListenerImpl;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class DataApiPlugin extends WebViewPlugin {
    private static Boolean E;
    AuthorizeConfig C;
    CookieManager D;

    /* renamed from: d, reason: collision with root package name */
    com.tencent.biz.troop.b f238555d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.webviewplugin.p f238556e = null;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.webviewplugin.r f238557f = null;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.webviewplugin.u f238558h = null;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.webviewplugin.f f238559i = null;

    /* renamed from: m, reason: collision with root package name */
    protected com.tencent.mobileqq.emosm.t f238560m = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class b implements com.tencent.mobileqq.webview.swift.injector.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f238564a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f238565b;

        b(String[] strArr, String str) {
            this.f238564a = strArr;
            this.f238565b = str;
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onSuccess(Map<String, String> map) {
            if (map == null) {
                QLog.e("DataApiPlugin", 1, "getCachedPskeySync map is null");
                return;
            }
            this.f238564a[0] = map.get(this.f238565b);
            QLog.d("DataApiPlugin", 1, "getCachedPskeySync host:", this.f238565b, ", pskey:", com.tencent.mobileqq.webview.util.s.c(" p_skey=" + this.f238564a[0], new String[0]));
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onFail(String str) {
            QLog.d("DataApiPlugin", 1, "getCachedPskeySync onFail:" + str, ", ", this.f238565b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class c implements com.tencent.mobileqq.webview.swift.injector.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f238567a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f238568b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f238569c;

        c(String str, String str2, String str3) {
            this.f238567a = str;
            this.f238568b = str2;
            this.f238569c = str3;
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onFail(String str) {
            QLog.e("DataApiPlugin", 1, "handleUpdatePt4Token onFail: " + str);
            DataApiPlugin.this.t(this.f238567a, this.f238568b, 1);
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onSuccess(Map<String, String> map) {
            String str = map.get(this.f238567a);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleUpdatePt4Token onSuccess: ");
            sb5.append(com.tencent.mobileqq.webview.util.s.c(" pt4Token=" + str, new String[0]));
            QLog.d("DataApiPlugin", 1, sb5.toString());
            DataApiPlugin.this.H(this.f238568b, null, this.f238569c, 134217728, this.f238567a, str);
            if (TextUtils.isEmpty(str)) {
                DataApiPlugin.this.t(this.f238567a, this.f238568b, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class d implements com.tencent.mobileqq.webview.swift.injector.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f238571a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f238572b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f238573c;

        d(String str, String str2, String str3) {
            this.f238571a = str;
            this.f238572b = str2;
            this.f238573c = str3;
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onFail(String str) {
            DataApiPlugin.this.E(this.f238571a, -2, "pskey\u83b7\u53d6\u5931\u8d25");
            QLog.d("DataApiPlugin", 1, "handleUpdateNewPskey onFail:" + str, ", ", this.f238572b);
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onSuccess(Map<String, String> map) {
            if (map == null) {
                DataApiPlugin.this.E(this.f238571a, -2, "pskey\u83b7\u53d6\u5931\u8d25");
                QLog.e("DataApiPlugin", 1, "handleUpdateNewPskey map is null");
                return;
            }
            String str = map.get(this.f238572b);
            if (!TextUtils.isEmpty(str)) {
                DataApiPlugin.this.u("p_skey", str, this.f238572b, this.f238573c, false);
                DataApiPlugin.this.E(this.f238571a, 0, "");
            } else {
                DataApiPlugin.this.E(this.f238571a, -2, "pskey\u83b7\u53d6\u5931\u8d25");
                QLog.e("DataApiPlugin", 1, "handleUpdateNewPskey pskey is null ", this.f238572b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class e implements com.tencent.mobileqq.webview.swift.injector.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f238575a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f238576b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f238577c;

        e(String str, String str2, String str3) {
            this.f238575a = str;
            this.f238576b = str2;
            this.f238577c = str3;
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onFail(String str) {
            DataApiPlugin.this.E(this.f238575a, -2, "uskey\u83b7\u53d6\u5931\u8d25");
            QLog.d("DataApiPlugin", 1, "handleUpdateUskey onFail:" + str, ", ", this.f238576b);
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onSuccess(Map<String, String> map) {
            if (map == null) {
                DataApiPlugin.this.E(this.f238575a, -2, "uskey\u83b7\u53d6\u5931\u8d25");
                QLog.e("DataApiPlugin", 1, "handleUpdateUskey map is null");
                return;
            }
            String str = map.get(this.f238576b);
            if (!TextUtils.isEmpty(str)) {
                DataApiPlugin.this.u("uskey", str, this.f238576b, this.f238577c, false);
                DataApiPlugin.this.E(this.f238575a, 0, "");
            } else {
                DataApiPlugin.this.E(this.f238575a, -2, "uskey\u83b7\u53d6\u5931\u8d25");
                QLog.e("DataApiPlugin", 1, "handleUpdateUskey uskey is null ", this.f238576b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public static class f extends WtloginListener {

        /* renamed from: b, reason: collision with root package name */
        private String f238579b;

        /* renamed from: c, reason: collision with root package name */
        private String f238580c;

        /* renamed from: d, reason: collision with root package name */
        private String f238581d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<DataApiPlugin> f238582e;

        public f(DataApiPlugin dataApiPlugin, String str, String str2, String str3) {
            this.f238582e = new WeakReference<>(dataApiPlugin);
            this.f238579b = str;
            this.f238580c = str2;
            this.f238581d = str3;
        }

        @Override // oicq.wlogin_sdk.request.WtloginListener
        public void OnGetStWithoutPasswd(String str, long j3, long j16, int i3, long j17, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
            if (i16 == 0) {
                WeakReference<DataApiPlugin> weakReference = this.f238582e;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                this.f238582e.get().H(this.f238579b, wUserSigInfo, this.f238580c, i3, this.f238581d, null);
                return;
            }
            WeakReference<DataApiPlugin> weakReference2 = this.f238582e;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            this.f238582e.get().I(this.f238580c, "getTicket fail code = " + i16);
        }
    }

    private void A(String str, String str2, AppRuntime appRuntime) {
        String j06 = this.C.j0(str2);
        if (TextUtils.isEmpty(j06)) {
            QLog.d("DataApiPlugin", 1, "handleUpdateNewPskey pskeyDomain is empty");
            E(str, -2, HardCodeUtil.qqStr(R.string.l87));
        } else {
            com.tencent.mobileqq.webview.swift.cookie.a.c(j06, false, appRuntime, new d(str, j06, str2));
        }
    }

    private void B(String str, String str2, String str3) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str3);
        if (QLog.isColorLevel()) {
            QLog.i("DataApiPlugin", 2, "handleUpdatePt4Token domain:" + str3);
        }
        ((com.tencent.mobileqq.webview.swift.injector.s) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.s.class)).b(this.mRuntime.b(), 16, arrayList, new c(str3, str, str2));
    }

    private void C(String str, String str2, AppRuntime appRuntime) {
        String j06 = this.C.j0(str2);
        if (TextUtils.isEmpty(j06)) {
            QLog.d("DataApiPlugin", 1, "handleUpdateUskey pskeyDomain is empty");
            E(str, -2, HardCodeUtil.qqStr(R.string.l87));
        } else {
            com.tencent.mobileqq.webview.swift.cookie.a.e(j06, false, appRuntime, new e(str, j06, str2));
        }
    }

    private boolean D() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("webview_wtlogin_cutoff_switch", true);
        if (QLog.isDevelopLevel()) {
            QLog.d("DataApiPlugin", 1, "isWtLoginCutOff: " + isSwitchOn);
        }
        return isSwitchOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, int i3, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", i3);
            if (i3 < 0) {
                jSONObject.put("message", str2);
            }
            callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(String str, String str2, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("domain", str);
        if (str2.length() > 80) {
            hashMap.put("url", str2.substring(0, 80));
        } else {
            hashMap.put("url", str2);
        }
        hashMap.put("errCode", "" + i3);
        hashMap.put("tokenType", "pt4");
        StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, "actWebThirdSigError", true, 0L, 0L, hashMap, "");
    }

    private void G(String str, String[] strArr) {
        SwiftBrowserStatistics swiftBrowserStatistics;
        long j3;
        int i3;
        com.tencent.mobileqq.webviewplugin.p pVar = this.f238556e;
        if (pVar != null && this.f238558h != null) {
            i3 = pVar.C5();
            j3 = this.f238558h.getmClickTime();
            swiftBrowserStatistics = null;
        } else {
            swiftBrowserStatistics = (SwiftBrowserStatistics) super.getBrowserComponent(-2);
            if (swiftBrowserStatistics != null) {
                i3 = swiftBrowserStatistics.T0.f314408a;
                j3 = swiftBrowserStatistics.f314358f;
            } else {
                j3 = 0;
                i3 = 0;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            int i16 = jSONObject.getJSONObject("data").getInt("status");
            String str2 = "onFirstLine";
            String str3 = "state_activity_first_line";
            if (i16 == 12 || i16 == 13) {
                if (i16 == 12) {
                    str2 = "onPageVisible";
                } else {
                    str2 = "onPageFinished";
                }
                if (i16 == 12) {
                    str3 = "state_first_screen";
                } else {
                    str3 = "state_page_finished";
                }
            }
            if (swiftBrowserStatistics != null) {
                swiftBrowserStatistics.g0(str3);
            }
            if (i3 < i16 && this.f238557f != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQBrowser_report", 2, "try report web status, " + str2 + ", step: " + i16 + ", stepTime: " + (System.currentTimeMillis() - j3) + ", totalTime: " + (System.currentTimeMillis() - j3) + ", \n " + this.f238557f.getCurrentUrl());
                }
                com.tencent.mobileqq.webviewplugin.p pVar2 = this.f238556e;
                if (pVar2 != null) {
                    pVar2.S6(i16);
                    this.f238556e.Gf(System.currentTimeMillis());
                } else if (swiftBrowserStatistics != null) {
                    SwiftBrowserStatistics.b bVar = swiftBrowserStatistics.T0;
                    bVar.f314408a = i16;
                    bVar.f314412e = System.currentTimeMillis();
                    if (i16 == 12) {
                        swiftBrowserStatistics.f314372p0 = swiftBrowserStatistics.T0.f314412e - j3;
                    } else if (i16 != 13) {
                        swiftBrowserStatistics.f314371o0 = swiftBrowserStatistics.T0.f314412e - j3;
                    } else {
                        swiftBrowserStatistics.f314373q0 = swiftBrowserStatistics.T0.f314412e - j3;
                        String currentUrl = this.f238557f.getCurrentUrl();
                        SwiftBrowserStatistics.b bVar2 = swiftBrowserStatistics.T0;
                        GameCenterActivity.reportStep(currentUrl, bVar2.f314408a, true, bVar2.f314409b);
                    }
                }
            }
            String optString = jSONObject.optString("callback");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            callJs(optString, "{\"result\": 0}");
        } catch (JSONException unused) {
        }
    }

    private void J(String str, String str2) {
        AppInterface b16 = this.mRuntime.b();
        if (TextUtils.isEmpty(str) || !b16.isLogin()) {
            return;
        }
        String account = b16.getAccount();
        String cookie = CookieManager.getInstance().getCookie(str);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(cookie) || cookie.contains("p_uin=")) {
            return;
        }
        String e16 = com.tencent.mobileqq.webview.swift.cookie.b.e(account);
        QLog.e("DataApiPlugin", 1, "can not find p_uin from " + com.tencent.biz.common.util.k.f(str, new String[0]) + ", dump cookie: " + com.tencent.biz.common.util.k.e(cookie, new String[0]));
        u(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN, e16, str2, str, false);
    }

    private void K(String str) {
        AppInterface b16 = this.mRuntime.b();
        if (TextUtils.isEmpty(str) || !b16.isLogin()) {
            return;
        }
        String account = b16.getAccount();
        String cookie = CookieManager.getInstance().getCookie(str);
        if (TextUtils.isEmpty(cookie) || cookie.contains("uin=")) {
            return;
        }
        String e16 = com.tencent.mobileqq.webview.swift.cookie.b.e(account);
        String i3 = com.tencent.mobileqq.webview.util.s.i(str);
        QLog.e("DataApiPlugin", 1, "can not find uin from " + com.tencent.biz.common.util.k.f(str, new String[0]) + ", dump cookie: " + com.tencent.biz.common.util.k.e(cookie, new String[0]));
        u("uin", e16, i3, str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final String str, final String str2, final int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.jsp.e
            @Override // java.lang.Runnable
            public final void run() {
                DataApiPlugin.F(str, str2, i3);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, String str2, String str3, String str4, boolean z16) {
        String c16;
        if (this.D == null) {
            CookieManager cookieManager = CookieManager.getInstance();
            this.D = cookieManager;
            cookieManager.setAcceptCookie(true);
        }
        if (z16) {
            c16 = com.tencent.mobileqq.webview.swift.cookie.b.b(str, str2, str3, true);
        } else if (w()) {
            c16 = com.tencent.mobileqq.webview.swift.cookie.b.b(str, str2, str3, false);
        } else {
            c16 = com.tencent.mobileqq.webview.swift.cookie.b.c(str, str2, str3);
        }
        this.D.setCookie(str4, c16);
        QLog.d("DataApiPlugin", 1, "buildAndSetCookie " + com.tencent.biz.common.util.k.e(c16, new String[0]), " for ", str3);
    }

    private boolean w() {
        if (E == null) {
            E = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("webview_jscookie_back2_unsecure_switch", false));
            QLog.d("DataApiPlugin", 1, "ensureJSCookieBack2UnsecureSwitch=" + E);
        }
        return E.booleanValue();
    }

    private String y(AppInterface appInterface) {
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        aVar.d(appInterface.getCurrentUid());
        return ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
    }

    private String z(boolean z16) {
        try {
            AppInterface b16 = this.mRuntime.b();
            TicketManager ticketManager = (TicketManager) b16.getManager(2);
            if (z16) {
                return com.tencent.mobileqq.webview.util.s.g(b16.getAccount());
            }
            return ticketManager.getRealSkey(b16.getAccount());
        } catch (Exception e16) {
            QLog.e("DataApiPlugin", 1, "getSkey inNewWay:" + z16 + " exception" + e16.getMessage(), e16);
            return null;
        }
    }

    void I(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", -2);
            jSONObject.put("message", str2);
            callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "data";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x017d, code lost:
    
        if (r9 == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x017f, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01ae, code lost:
    
        if (r9 == null) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b6 A[Catch: JSONException -> 0x028f, TRY_ENTER, TryCatch #27 {JSONException -> 0x028f, blocks: (B:9:0x0037, B:11:0x004e, B:13:0x0057, B:14:0x005b, B:16:0x0068, B:18:0x007f, B:20:0x0083, B:21:0x0089, B:23:0x00c4, B:24:0x00e6, B:26:0x00ec, B:32:0x017f, B:33:0x01be, B:35:0x01c6, B:37:0x01db, B:38:0x01e4, B:40:0x01f1, B:41:0x0214, B:43:0x021a, B:46:0x0227, B:48:0x0238, B:50:0x023e, B:52:0x0248, B:53:0x0259, B:55:0x025f, B:57:0x0269, B:58:0x0279, B:60:0x027f, B:64:0x01e0, B:101:0x01b6, B:102:0x01b9, B:110:0x00c9, B:111:0x006e, B:113:0x0074), top: B:8:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[Catch: JSONException -> 0x028f, SYNTHETIC, TryCatch #27 {JSONException -> 0x028f, blocks: (B:9:0x0037, B:11:0x004e, B:13:0x0057, B:14:0x005b, B:16:0x0068, B:18:0x007f, B:20:0x0083, B:21:0x0089, B:23:0x00c4, B:24:0x00e6, B:26:0x00ec, B:32:0x017f, B:33:0x01be, B:35:0x01c6, B:37:0x01db, B:38:0x01e4, B:40:0x01f1, B:41:0x0214, B:43:0x021a, B:46:0x0227, B:48:0x0238, B:50:0x023e, B:52:0x0248, B:53:0x0259, B:55:0x025f, B:57:0x0269, B:58:0x0279, B:60:0x027f, B:64:0x01e0, B:101:0x01b6, B:102:0x01b9, B:110:0x00c9, B:111:0x006e, B:113:0x0074), top: B:8:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x089c A[Catch: JSONException -> 0x08bc, TRY_LEAVE, TryCatch #7 {JSONException -> 0x08bc, blocks: (B:336:0x07fb, B:338:0x0811, B:340:0x081d, B:342:0x0823, B:344:0x0837, B:346:0x0860, B:347:0x086c, B:349:0x0872, B:350:0x087e, B:352:0x0884, B:354:0x0896, B:356:0x089c), top: B:335:0x07fb }] */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0a88  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0a8c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0194 A[Catch: all -> 0x01b1, TRY_LEAVE, TryCatch #9 {all -> 0x01b1, blocks: (B:67:0x011f, B:69:0x0125, B:71:0x012e, B:75:0x013a, B:78:0x0142, B:79:0x0153, B:81:0x0159, B:85:0x018e, B:87:0x0194), top: B:66:0x011f }] */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        boolean z16;
        int i3;
        boolean isEmpty;
        Activity a16;
        JSONException jSONException;
        String str4;
        JSONObject jSONObject;
        int i16;
        Context context;
        String str5;
        CharSequence text;
        JSONException jSONException2;
        String str6;
        String str7;
        int i17;
        String str8;
        String property;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        TicketManager ticketManager;
        String str14;
        AppInterface appInterface;
        String str15;
        Throwable th5;
        Cursor cursor;
        Exception exc;
        Cursor cursor2;
        int columnIndex;
        if (!"data".equals(str2)) {
            return false;
        }
        if (ITVKPlayerEventListener.KEY_USER_INFO.equals(str3) && strArr != null && strArr.length == 1) {
            try {
                String optString = new JSONObject(strArr[0]).optString("callback");
                String url = this.mRuntime.e().getUrl();
                if (url != null && url.startsWith("file://")) {
                    url = HtmlOffline.y(url);
                }
                String str16 = url;
                AppInterface b16 = this.mRuntime.b();
                if ((TextUtils.isEmpty(str16) || !b16.isLogin()) && !TextUtils.isEmpty(optString)) {
                    callJs(optString, "{}");
                    return true;
                }
                if (this.C == null) {
                    this.C = AuthorizeConfig.y();
                }
                boolean l06 = this.C.l0(str16);
                String i06 = this.C.i0(str16);
                String k06 = this.C.k0(str16);
                String j06 = this.C.j0(str16);
                TicketManager ticketManager2 = (TicketManager) b16.getManager(2);
                JSONObject jSONObject2 = new JSONObject();
                String account = b16.getAccount();
                jSONObject2.put("uin", account);
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("use_name_service_for_data_api_plugin", true)) {
                    property = y(b16);
                } else {
                    property = b16.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + account);
                }
                if (TextUtils.isEmpty(property)) {
                    try {
                        cursor2 = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), Uri.parse("content://qq.friendlist/friendlist/" + account), null, "uin=?", new String[]{account}, null);
                        if (cursor2 != null) {
                            try {
                                try {
                                    if (cursor2.moveToFirst() && (columnIndex = cursor2.getColumnIndex("name")) >= 0) {
                                        String string = cursor2.getString(columnIndex);
                                        if (TextUtils.isEmpty(string)) {
                                            str9 = j06;
                                            str10 = k06;
                                        } else {
                                            str9 = j06;
                                            try {
                                                str10 = k06;
                                            } catch (Exception e16) {
                                                e = e16;
                                                str10 = k06;
                                                exc = e;
                                                if (QLog.isColorLevel()) {
                                                }
                                            }
                                            try {
                                                property = SecurityUtile.decode(new String(string.getBytes(), "utf-8"));
                                            } catch (Exception e17) {
                                                e = e17;
                                                exc = e;
                                                if (QLog.isColorLevel()) {
                                                    QLog.e("DataApiPlugin", 2, "getNickName by ContentProvider  Exception, trace=" + QLog.getStackTraceString(exc));
                                                }
                                            }
                                        }
                                        if (QLog.isColorLevel()) {
                                            QLog.i("DataApiPlugin", 2, "getNickName by ContentProvider success, name =" + property);
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th5 = th6;
                                    cursor = cursor2;
                                    if (cursor == null) {
                                        cursor.close();
                                        throw th5;
                                    }
                                    throw th5;
                                }
                            } catch (Exception e18) {
                                e = e18;
                                str9 = j06;
                            }
                        }
                        str9 = j06;
                        str10 = k06;
                    } catch (Exception e19) {
                        str9 = j06;
                        str10 = k06;
                        exc = e19;
                        cursor2 = null;
                    } catch (Throwable th7) {
                        th5 = th7;
                        cursor = null;
                        if (cursor == null) {
                        }
                    }
                } else {
                    str9 = j06;
                    str10 = k06;
                }
                jSONObject2.put("nick", property);
                if (l06) {
                    K(str16);
                    String i18 = com.tencent.mobileqq.webview.util.s.i(str16);
                    String g16 = ((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).u() ? com.tencent.mobileqq.webview.util.s.g(account) : ticketManager2.getRealSkey(account);
                    jSONObject2.put("skey", g16);
                    if (TextUtils.isEmpty(g16)) {
                        str12 = str9;
                        str13 = str10;
                        ticketManager = ticketManager2;
                        str14 = "";
                        str11 = optString;
                        appInterface = b16;
                        str15 = str16;
                    } else {
                        ticketManager = ticketManager2;
                        str12 = str9;
                        str13 = str10;
                        str14 = "";
                        appInterface = b16;
                        str11 = optString;
                        str15 = str16;
                        u("skey", g16, i18, str16, false);
                    }
                    if (!TextUtils.isEmpty(str12)) {
                        J(str15, str12);
                        String x16 = x(appInterface, str12);
                        String str17 = x16 == null ? str14 : x16;
                        jSONObject2.put("p_skey", str17);
                        u("p_skey", str17, str12, str15, false);
                    }
                    if (!TextUtils.isEmpty(str13)) {
                        String p16 = SwiftTicketCookie.p(appInterface, str13);
                        if (!TextUtils.isEmpty(p16)) {
                            jSONObject2.put("pt4_token", p16);
                            u("pt4_token", p16, str13, str15, false);
                        }
                    }
                    if (!TextUtils.isEmpty(i06) && !TextUtils.isEmpty(ticketManager.getA2(account))) {
                        u(ICustomDataEditor.STRING_ARRAY_PARAM_2, i06, str12, str15, true);
                    }
                } else {
                    str11 = optString;
                }
                if (!TextUtils.isEmpty(str11)) {
                    callJs(str11, jSONObject2.toString());
                }
            } catch (JSONException e26) {
                e26.printStackTrace();
            }
        } else {
            if ("updateLoginInfo".equals(str3) && strArr != null) {
                final String str18 = strArr[0];
                final String url2 = this.mRuntime.e().getUrl();
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.jsp.DataApiPlugin.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DataApiPlugin.this.v(str18, url2);
                    }
                }, 8, null, true);
                return true;
            }
            if ("getWebviewRunningEnvironment".equals(str3) && strArr != null) {
                Intent intent = this.mRuntime.a().getIntent();
                int intExtra = intent.getIntExtra("uinType", -1);
                JSONObject jSONObject3 = new JSONObject();
                String account2 = this.mRuntime.b().getAccount();
                try {
                    String optString2 = new JSONObject(strArr[0]).optString("callback");
                    jSONObject3.put("uin", account2);
                    if (intExtra == -1) {
                        jSONObject3.put("env_type", "unknown");
                    } else {
                        if (intExtra == 1) {
                            jSONObject3.put("group_uin", intent.getStringExtra("groupUin"));
                            jSONObject3.put("env_type", VipFunCallConstants.KEY_GROUP);
                        } else if (intExtra == 3000) {
                            jSONObject3.put("dicussgroup_uin", intent.getStringExtra("dicussgroup_uin"));
                            jSONObject3.put("env_type", "discussGroup");
                        } else {
                            String stringExtra = intent.getStringExtra("friend_uin");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                jSONObject3.put("friend_uin", stringExtra);
                            }
                            jSONObject3.put("env_type", GuildMsgItem.NICK_FRIEND);
                        }
                        jSONObject3.put("msg_sender_uin", intent.getStringExtra("friendUin"));
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        callJs(optString2, jSONObject3.toString());
                    }
                } catch (JSONException e27) {
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, "getWebviewRunningEnvironment error", e27);
                    }
                }
            } else if ("getVipType".equals(str3) && strArr != null) {
                try {
                    JSONObject jSONObject4 = new JSONObject(strArr[0]);
                    String optString3 = jSONObject4.optString("callback");
                    String optString4 = jSONObject4.optString("uin");
                    if (optString4.equals(this.mRuntime.b().getAccount()) && !TextUtils.isEmpty(optString3)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("uin", optString4);
                        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("getUserVipType", optString3, this.f238560m.key, bundle));
                    }
                } catch (JSONException e28) {
                    e28.printStackTrace();
                }
            } else if ("getSharedData".equals(str3) && strArr != null && strArr.length == 1) {
                try {
                    JSONObject jSONObject5 = new JSONObject(strArr[0]);
                    String optString5 = jSONObject5.optString("callback");
                    if (!TextUtils.isEmpty(optString5)) {
                        if ("qbrowserCount".equals(jSONObject5.optString("key"))) {
                            callJs(optString5, Integer.toString(QQBrowserActivity.sQQBrowserActivityCounter));
                            return true;
                        }
                        Activity a17 = this.mRuntime.a();
                        if (a17 != null) {
                            str8 = a17.getIntent().getStringExtra("sharedData");
                            i17 = 1;
                        } else {
                            i17 = 1;
                            str8 = null;
                        }
                        String[] strArr2 = new String[i17];
                        strArr2[0] = str8 == null ? "" : com.tencent.mobileqq.webview.util.s.l(str8);
                        callJs(optString5, strArr2);
                    }
                } catch (JSONException e29) {
                    e29.printStackTrace();
                }
            } else if ("setClipboard".equals(str3) && strArr != null && strArr.length == 1) {
                try {
                    JSONObject jSONObject6 = new JSONObject(strArr[0]);
                    String optString6 = jSONObject6.optString("text");
                    str6 = jSONObject6.optString("callback");
                    str7 = optString6 == null ? "" : optString6;
                } catch (JSONException e36) {
                    jSONException2 = e36;
                    str6 = null;
                }
                try {
                    ClipboardManager clipboardManager = (ClipboardManager) BaseApplication.getContext().getSystemService("clipboard");
                    if (clipboardManager != null) {
                        clipboardManager.setText(str7);
                        if (TextUtils.isEmpty(str6)) {
                            return true;
                        }
                        callJs(str6, "true");
                        return true;
                    }
                } catch (JSONException e37) {
                    jSONException2 = e37;
                    jSONException2.printStackTrace();
                    if (!TextUtils.isEmpty(str6)) {
                    }
                    return true;
                }
                if (!TextUtils.isEmpty(str6)) {
                    callJs(str6, "false");
                }
            } else if ("getClipboard".equals(str3) && strArr != null && strArr.length == 1) {
                try {
                    String optString7 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString7)) {
                        ClipboardManager clipboardManager2 = (ClipboardManager) BaseApplication.getContext().getSystemService("clipboard");
                        callJs(optString7, com.tencent.mobileqq.webview.util.s.l((clipboardManager2 == null || (text = clipboardManager2.getText()) == null) ? "" : text.toString()));
                    }
                } catch (Exception e38) {
                    QLog.e("DataApiPlugin", 1, "getClipboard exception e = " + e38.getMessage());
                    e38.printStackTrace();
                }
            } else if ("dcReport".equals(str3) && strArr != null && strArr.length == 1) {
                try {
                    JSONObject jSONObject7 = new JSONObject(strArr[0]);
                    String optString8 = jSONObject7.optString("table");
                    String optString9 = jSONObject7.optString("list");
                    boolean optBoolean = jSONObject7.optBoolean(DeviceType.DeviceCategory.MERGER, true);
                    String optString10 = jSONObject7.optString("callback");
                    JSONObject jSONObject8 = new JSONObject();
                    if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                        AppInterface b17 = this.mRuntime.b();
                        DcReportUtil.c(b17 instanceof QQAppInterface ? (QQAppInterface) b17 : null, optString8, optString9, optBoolean);
                        jSONObject8.put("result", 0);
                        jSONObject8.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                    } else {
                        jSONObject8.put("result", -1);
                        jSONObject8.put("message", "params table or list is null");
                    }
                    if (!TextUtils.isEmpty(optString10)) {
                        callJs(optString10, jSONObject8.toString());
                    }
                } catch (Exception e39) {
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, e39.getMessage());
                    }
                }
            } else if ("report".equals(str3) && strArr != null && strArr.length == 1) {
                try {
                    JSONObject jSONObject9 = new JSONObject(strArr[0]);
                    String optString11 = jSONObject9.optString("platform");
                    JSONObject jSONObject10 = jSONObject9.getJSONObject("payload");
                    AppInterface b18 = this.mRuntime.b();
                    if ("ads".equalsIgnoreCase(optString11)) {
                        String optString12 = jSONObject10.optString("departKey", "");
                        String string2 = jSONObject10.getString("logKey");
                        String string3 = jSONObject10.getString("opType");
                        String string4 = jSONObject10.getString("opName");
                        String optString13 = jSONObject10.optString(IProfileProtocolConst.PARAM_TARGET_UIN, "");
                        int optInt = jSONObject10.optInt("opEntry", 0);
                        int optInt2 = jSONObject10.optInt("opCount", 1);
                        int optInt3 = jSONObject10.optInt("opResult", 0);
                        String optString14 = jSONObject10.optString("reserve2", "");
                        String optString15 = jSONObject10.optString("reserve3", "");
                        String optString16 = jSONObject10.optString("reserve4", "");
                        String optString17 = jSONObject10.optString("reserve5", "");
                        QQAppInterface qQAppInterface = b18 instanceof QQAppInterface ? (QQAppInterface) b18 : null;
                        if (b18.isLogin()) {
                            ReportController.n(qQAppInterface, string2, optString12, optString13, string3, string4, optInt, optInt2, optInt3, optString14, optString15, optString16, optString17);
                        } else {
                            ReportController.q(qQAppInterface, string2, optString12, optString13, string3, string4, optInt, optInt2, optInt3, optString14, optString15, optString16, optString17);
                        }
                    } else if ("rdm".equalsIgnoreCase(optString11)) {
                        String string5 = jSONObject10.getString(AdMetricTag.EVENT_NAME);
                        boolean optBoolean2 = jSONObject10.optBoolean("reportNow", true);
                        boolean optBoolean3 = jSONObject10.optBoolean("isSucceed", true);
                        int optInt4 = jSONObject10.optInt("elapse", 0);
                        int optInt5 = jSONObject10.optInt("size", 0);
                        HashMap<String, String> hashMap = new HashMap<>();
                        JSONObject optJSONObject = jSONObject10.optJSONObject("extra");
                        if (optJSONObject != null) {
                            Iterator keys = optJSONObject.keys();
                            while (keys != null && keys.hasNext()) {
                                String str19 = (String) keys.next();
                                hashMap.put(str19, optJSONObject.optString(str19));
                            }
                        }
                        if (b18.isLogin()) {
                            str5 = b18.getAccount();
                            context = null;
                        } else {
                            context = null;
                            str5 = null;
                        }
                        StatisticCollector.getInstance(context).collectPerformance(str5, string5, optBoolean3, optInt4, optInt5, hashMap, "", optBoolean2);
                    } else if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, "Unsupported report platform!");
                    }
                } catch (JSONException e46) {
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, e46.getMessage());
                    }
                }
            } else if ("getFaceFile".equals(str3) && strArr != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("DataApiPlugin", 2, "getFaceFile");
                }
                try {
                    JSONObject jSONObject11 = new JSONObject(strArr[0]);
                    String optString18 = jSONObject11.optString("callback");
                    String optString19 = jSONObject11.optString("uin");
                    if (!TextUtils.isEmpty(optString18)) {
                        Bundle bundle2 = new Bundle();
                        if (!TextUtils.isEmpty(optString19)) {
                            bundle2.putString("uin", optString19);
                        } else {
                            bundle2.putString("uin", this.mRuntime.b().getAccount());
                        }
                        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("getFaceFilePath", optString18, this.f238560m.key, bundle2));
                    } else if (QLog.isColorLevel()) {
                        QLog.i("DataApiPlugin", 2, "getFaceFile, callback");
                    }
                } catch (JSONException e47) {
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, "error, getFaceFile:" + e47.getMessage());
                    }
                }
            } else if ("getInstanceID".equals(str3) && strArr != null && strArr.length == 1) {
                try {
                    String optString20 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString20)) {
                        callJs(optString20, "{InstanceID:" + AppSetting.f() + "}");
                    }
                } catch (JSONException e48) {
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, "error, getInstanceID:" + e48.getMessage());
                    }
                }
            } else if ("setPskeyByDomain".equals(str3) && strArr != null && strArr.length == 1) {
                try {
                    JSONObject jSONObject12 = new JSONObject(strArr[0]);
                    String optString21 = jSONObject12.optString("callback");
                    String optString22 = jSONObject12.optString("domain");
                    if (!TextUtils.isEmpty(optString22)) {
                        String lowerCase = optString22.toLowerCase();
                        AppInterface b19 = this.mRuntime.b();
                        if (b19 != null && b19.isLogin()) {
                            String account3 = b19.getAccount();
                            String x17 = x(b19, lowerCase);
                            String q16 = SwiftTicketCookie.q(b19, lowerCase, SwiftTicketCookie.f314548u);
                            if (!TextUtils.isEmpty(x17)) {
                                String str20 = "https://" + lowerCase + '/';
                                u(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN, com.tencent.mobileqq.webview.swift.cookie.b.e(account3), lowerCase, str20, false);
                                if (!TextUtils.isEmpty(x17)) {
                                    u("p_skey", x17, lowerCase, str20, false);
                                }
                                if (!TextUtils.isEmpty(q16)) {
                                    u("pt4_token", q16, lowerCase, str20, false);
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("DataApiPlugin", 1, "setPskeyByDomain done ", lowerCase);
                                }
                                i16 = 0;
                                if (!TextUtils.isEmpty(optString21)) {
                                    callJs(optString21, "{ret:" + i16 + "}");
                                }
                            }
                        }
                    }
                    i16 = 1;
                    if (!TextUtils.isEmpty(optString21)) {
                    }
                } catch (JSONException e49) {
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, "error setPskeyByDomain", e49);
                    }
                }
            } else if (BoodoModuleProxy.METHOD_NOTIFY_WEB_STATUS.equals(str3) && strArr != null) {
                G(str, strArr);
            } else if (IProfileProtocolConst.PARAM_IS_FRIEND.equals(str3) && strArr != null) {
                try {
                    jSONObject = new JSONObject(strArr[0]);
                    str4 = jSONObject.optString("callback");
                } catch (JSONException e56) {
                    jSONException = e56;
                    str4 = null;
                }
                try {
                    String string6 = jSONObject.getString("uin");
                    if (((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("uin", string6);
                        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("checkRelation", str4, this.f238560m.key, bundle3));
                    }
                } catch (JSONException e57) {
                    jSONException = e57;
                    if (!TextUtils.isEmpty(str4)) {
                        callJs(str4, String.format("{\"result\": -2, \"message\":\"%s\"}", jSONException));
                    }
                    return true;
                }
            } else if ("setReturnBackResult".equals(str3) && strArr != null) {
                try {
                    JSONObject jSONObject13 = new JSONObject(strArr[0]);
                    if ("RESULT_OK".equals(jSONObject13.optString(QzoneIPCModule.RESULT_CODE)) && (a16 = this.mRuntime.a()) != null) {
                        a16.setResult(-1);
                        a16.finish();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, "setReturnBackResult:" + jSONObject13);
                    }
                } catch (Exception e58) {
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, "error setReturnBackResult:", e58);
                    }
                    Activity a18 = this.mRuntime.a();
                    if (a18 != null) {
                        a18.setResult(0);
                        a18.finish();
                    }
                }
            } else if ("checkPermission".equals(str3) && strArr != null && strArr.length == 1) {
                try {
                    JSONObject jSONObject14 = new JSONObject(strArr[0]);
                    String string7 = jSONObject14.getString("callback");
                    String string8 = jSONObject14.getString("type");
                    String string9 = jSONObject14.getString("domain");
                    if (this.C == null) {
                        this.C = AuthorizeConfig.y();
                    }
                    if (!TextUtils.isEmpty(string8) && !TextUtils.isEmpty(string9)) {
                        String str21 = "https://" + string9 + "/";
                        if (DTConstants.TAG.API.equals(string8)) {
                            z16 = this.C.F(str21, jSONObject14.getString("cmd"));
                        } else if ("skey".equals(string8)) {
                            z16 = this.C.l0(str21);
                        } else {
                            if ("pskey".equals(string8)) {
                                isEmpty = TextUtils.isEmpty(this.C.j0(str21));
                            } else if (ZPlanPublishSource.FROM_SCHEME.equals(string8)) {
                                z16 = this.C.H(str21, jSONObject14.getString(ZPlanPublishSource.FROM_SCHEME));
                            } else if ("pt4_token".equals(string8)) {
                                isEmpty = TextUtils.isEmpty(this.C.k0(str21));
                            } else if (ICustomDataEditor.STRING_ARRAY_PARAM_2.equals(string8)) {
                                isEmpty = TextUtils.isEmpty(this.C.i0(str21));
                            }
                            i3 = 1;
                            z16 = !isEmpty;
                            String[] strArr3 = new String[i3];
                            strArr3[0] = z16 ? "{\"ret\": true}" : "{\"ret\": false}";
                            callJs(string7, strArr3);
                        }
                        i3 = 1;
                        String[] strArr32 = new String[i3];
                        strArr32[0] = z16 ? "{\"ret\": true}" : "{\"ret\": false}";
                        callJs(string7, strArr32);
                    }
                    z16 = false;
                    i3 = 1;
                    String[] strArr322 = new String[i3];
                    strArr322[0] = z16 ? "{\"ret\": true}" : "{\"ret\": false}";
                    callJs(string7, strArr322);
                } catch (JSONException e59) {
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, "error checkPermission", e59);
                    }
                }
            } else if ("notifyTroopAppListChanged".equals(str3) && strArr != null) {
                try {
                    JSONObject jSONObject15 = new JSONObject(strArr[0]);
                    boolean optBoolean4 = jSONObject15.optBoolean("result", false);
                    if (this.f238555d == null) {
                        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
                        this.f238555d = A;
                        A.p();
                    }
                    this.f238555d.U(optBoolean4);
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, "notifyTroopAppListChanged:" + jSONObject15);
                    }
                } catch (Exception e65) {
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, "error setReturnBackResult:", e65);
                    }
                }
            } else if ("urlShareRedirect".equals(str3) && strArr != null) {
                try {
                    JSONObject jSONObject16 = new JSONObject(strArr[0]);
                    String optString23 = jSONObject16.optString("targetUrl");
                    if (QLog.isColorLevel()) {
                        QLog.d("DataApiPlugin", 2, "Call Data Api urlShareRedirect, url:" + optString23);
                    }
                    CustomWebView webView = this.f238557f.getWebView();
                    if (webView != null) {
                        WebViewPluginEngine pluginEngine = webView.getPluginEngine();
                        pluginEngine.D(new String[]{"URL_CHECK"});
                        WebViewPlugin m3 = pluginEngine.m("URL_CHECK");
                        if (m3 != null && (m3 instanceof UrlCheckPlugin)) {
                            ((UrlCheckPlugin) m3).r(jSONObject16.getInt("code"), jSONObject16.getInt("delay"), jSONObject16.getInt("duration"));
                        }
                    }
                } catch (JSONException e66) {
                    e66.printStackTrace();
                }
            } else if ("GSBase64Encode".equals(str3)) {
                if (QLog.isColorLevel()) {
                    QLog.d("DataApiPlugin", 2, "Call Data Api GSBaze64Encode, args:" + strArr);
                }
                if (strArr != null && strArr.length > 0) {
                    try {
                        JSONObject jSONObject17 = new JSONObject(strArr[0]);
                        String optString24 = jSONObject17.optString("need_encode_string");
                        String optString25 = jSONObject17.optString("callback");
                        if (!TextUtils.isEmpty(optString25)) {
                            String b26 = com.tencent.mobileqq.nearby.k.b(optString24);
                            JSONObject jSONObject18 = new JSONObject();
                            jSONObject18.put("encoded_string", b26);
                            callJs(optString25, jSONObject18.toString());
                        }
                    } catch (JSONException e67) {
                        e67.printStackTrace();
                    }
                }
            } else if ("GSBase64Decode".equals(str3)) {
                if (QLog.isColorLevel()) {
                    QLog.d("DataApiPlugin", 2, "Call Data Api GSBase64Decode, args:" + strArr);
                }
                if (strArr != null && strArr.length > 0) {
                    try {
                        JSONObject jSONObject19 = new JSONObject(strArr[0]);
                        String optString26 = jSONObject19.optString("need_decode_string");
                        String optString27 = jSONObject19.optString("callback");
                        if (!TextUtils.isEmpty(optString27)) {
                            String a19 = com.tencent.mobileqq.nearby.k.a(optString26);
                            JSONObject jSONObject20 = new JSONObject();
                            jSONObject20.put("decoded_string", a19);
                            callJs(optString27, jSONObject20.toString());
                        }
                    } catch (JSONException e68) {
                        e68.printStackTrace();
                    }
                }
            } else if ("notifyTroopProfileAppListChanged".equals(str3) && strArr != null) {
                try {
                    String optString28 = new JSONObject(strArr[0]).optString("gc");
                    if (this.f238555d == null) {
                        com.tencent.biz.troop.b A2 = com.tencent.biz.troop.b.A();
                        this.f238555d = A2;
                        A2.p();
                    }
                    this.f238555d.Y(true, optString28);
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, "notifyTroopProfileAppListChanged:" + strArr[0]);
                    }
                } catch (Exception e69) {
                    if (QLog.isColorLevel()) {
                        QLog.w("DataApiPlugin", 2, "error notifyTroopProfileAppListChanged setReturnBackResult:", e69);
                    }
                }
            } else if ("setHSSourceId".equals(str3) && strArr != null) {
                try {
                    Activity a26 = this.mRuntime.a();
                    if (a26 != null) {
                        Intent intent2 = a26.getIntent();
                        JSONObject jSONObject21 = new JSONObject(strArr[0]);
                        String optString29 = jSONObject21.optString("hsSourceID");
                        String optString30 = jSONObject21.optString("hsSourceName");
                        if (!TextUtils.isEmpty(optString29) && intent2 != null) {
                            intent2.putExtra(LaunchParam.KEY_REF_ID, optString29);
                            if (QLog.isColorLevel()) {
                                QLog.i("DataApiPlugin", 2, "hsid not null");
                            }
                        }
                        if (!TextUtils.isEmpty(optString30) && intent2 != null) {
                            intent2.putExtra("big_brother_source_key", optString30);
                            if (QLog.isColorLevel()) {
                                QLog.i("DataApiPlugin", 2, "sourceId not null");
                            }
                        }
                    }
                } catch (Exception e75) {
                    QLog.e("DataApiPlugin", 2, "error sethsid erro", e75);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.f238560m);
        WebViewPlugin.b bVar = this.mRuntime;
        com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.p)) {
            this.f238556e = (com.tencent.mobileqq.webviewplugin.p) d16;
        }
        WebViewPlugin.b bVar2 = this.mRuntime;
        com.tencent.mobileqq.webview.swift.y d17 = bVar2.d(bVar2.a());
        if (d17 != null && (d17 instanceof com.tencent.mobileqq.webviewplugin.r)) {
            this.f238557f = (com.tencent.mobileqq.webviewplugin.r) d17;
        }
        WebViewPlugin.b bVar3 = this.mRuntime;
        com.tencent.mobileqq.webview.swift.y d18 = bVar3.d(bVar3.a());
        if (d18 != null && (d18 instanceof com.tencent.mobileqq.webviewplugin.u)) {
            this.f238558h = (com.tencent.mobileqq.webviewplugin.u) d18;
        }
        WebViewPlugin.b bVar4 = this.mRuntime;
        com.tencent.mobileqq.webview.swift.y d19 = bVar4.d(bVar4.a());
        if (d19 == null || !(d19 instanceof com.tencent.mobileqq.webviewplugin.f)) {
            return;
        }
        this.f238559i = (com.tencent.mobileqq.webviewplugin.f) d19;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.f238560m);
        com.tencent.biz.troop.b bVar = this.f238555d;
        if (bVar != null) {
            bVar.q();
        }
        super.onDestroy();
    }

    void v(String str, String str2) {
        JSONObject jSONObject;
        String str3;
        WUserSigInfo wUserSigInfo;
        String str4;
        int i3;
        int i16;
        try {
            String str5 = VasUserData.get(this.mRuntime.b(), VasUserData.Key.TICKET_REQ_INTERVAL);
            int parseInt = !TextUtils.isEmpty(str5) ? Integer.parseInt(str5) : QzoneConfig.DefaultValue.PRELOAD_CUSTOM_RESOURCES_INTERVAL_SECONDS_DEFAULT;
            JSONObject jSONObject2 = new JSONObject(str);
            String optString = jSONObject2.optString("callback");
            JSONObject jSONObject3 = new JSONObject();
            if (!this.mRuntime.b().isLogin()) {
                jSONObject3.put("result", -2);
                jSONObject3.put("message", HardCodeUtil.qqStr(R.string.l85));
                callJs(optString, jSONObject3.toString());
                return;
            }
            String currentAccountUin = this.mRuntime.b().getCurrentAccountUin();
            SharedPreferences sharedPreferences = this.mRuntime.b().getApplication().getSharedPreferences(currentAccountUin + "_get_ticket_interval", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (this.C == null) {
                this.C = AuthorizeConfig.y();
            }
            String optString2 = jSONObject2.optString("key");
            if (TextUtils.isEmpty(optString2)) {
                jSONObject3.put("result", -2);
                jSONObject3.put("message", "\u53c2\u6570key\u4e3a\u7a7a");
                callJs(optString, jSONObject3.toString());
                return;
            }
            WUserSigInfo wUserSigInfo2 = new WUserSigInfo();
            if ("skey".equals(optString2)) {
                if (System.currentTimeMillis() - sharedPreferences.getLong("skey", 0L) > parseInt * 1000) {
                    edit.putLong("skey", System.currentTimeMillis());
                    edit.commit();
                    if (this.C.l0(str2)) {
                        i16 = (((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).u() || D()) ? 0 : 4096;
                        H(str2, null, optString, 4096, null, z(true));
                        return;
                    }
                    i3 = i16;
                    jSONObject = jSONObject3;
                    str3 = currentAccountUin;
                    str4 = null;
                    wUserSigInfo = wUserSigInfo2;
                } else {
                    jSONObject3.put("result", 1);
                    jSONObject3.put("message", HardCodeUtil.qqStr(R.string.l86));
                    callJs(optString, jSONObject3.toString());
                    return;
                }
            } else {
                if ("pskey".equals(optString2)) {
                    A(optString, str2, this.mRuntime.b());
                    return;
                }
                if ("uskey".equals(optString2)) {
                    C(optString, str2, this.mRuntime.b());
                    return;
                }
                if ("pt4_token".equals(optString2)) {
                    String k06 = this.C.k0(str2);
                    str3 = currentAccountUin;
                    if (System.currentTimeMillis() - sharedPreferences.getLong("pt4_token_" + k06, 0L) > parseInt * 1000) {
                        edit.putLong("pt4_token_" + k06, System.currentTimeMillis());
                        edit.commit();
                        if (!TextUtils.isEmpty(k06)) {
                            if (!SwiftTicketCookie.H() && !D()) {
                                wUserSigInfo = wUserSigInfo2;
                                i3 = 134217728;
                                wUserSigInfo._domains.add(String.format(Locale.getDefault(), "(%d)%s", 134217728, k06));
                                str4 = k06;
                                jSONObject = jSONObject3;
                            }
                            B(str2, optString, k06);
                            return;
                        }
                        wUserSigInfo = wUserSigInfo2;
                        str4 = k06;
                        jSONObject = jSONObject3;
                    } else {
                        jSONObject3.put("result", 1);
                        jSONObject3.put("message", HardCodeUtil.qqStr(R.string.l89));
                        callJs(optString, jSONObject3.toString());
                        return;
                    }
                } else {
                    jSONObject = jSONObject3;
                    str3 = currentAccountUin;
                    wUserSigInfo = wUserSigInfo2;
                    str4 = null;
                }
                i3 = 0;
            }
            if (i3 == 0) {
                jSONObject.put("result", -2);
                jSONObject.put("message", HardCodeUtil.qqStr(R.string.l87));
                callJs(optString, jSONObject.toString());
                return;
            }
            QLog.d("DataApiPlugin", 1, "GetStWithoutPasswd|key=" + i3);
            WtloginHelper.setSwitchListener(WtloginSwitchListenerImpl.getSingleton());
            WtloginHelper.setReportListener(WtloginReportListenerImpl.getSingleton());
            WtloginHelper wtloginHelper = new WtloginHelper((Context) this.mRuntime.b().getApplication(), (PrivacyListener) WtloginPrivacyListenerImpl.getSingleton());
            wtloginHelper.setCallSource(30);
            wtloginHelper.SetListener(new f(this, str2, optString, str4));
            wtloginHelper.GetStWithoutPasswd(str3, 16L, 16L, 1L, i3, wUserSigInfo);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("source", "DataApiPlugin");
                hashMap.put("url", SwiftBrowserStatistics.u(str2));
                hashMap.put("param_key", optString2);
                QQBeaconReport.report(str3, "wtlogin_invalid_init", hashMap);
            } catch (Exception e16) {
                QLog.e("DataApiPlugin", 1, e16, new Object[0]);
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + e17.getMessage());
            }
        }
    }

    private String x(AppInterface appInterface, String str) {
        String[] strArr = {null};
        com.tencent.mobileqq.webview.swift.cookie.a.c(str, false, appInterface, new b(strArr, str));
        return strArr[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void H(String str, WUserSigInfo wUserSigInfo, String str2, int i3, String str3, String str4) {
        String str5;
        int i16;
        int i17;
        String str6;
        Ticket GetUserSigInfoTicket;
        String str7 = str4;
        if (wUserSigInfo == null && str7 == null) {
            QLog.d("DataApiPlugin", 1, "onDoneGetTicket domain:" + str3 + " type:" + i3 + " sigInfo error.");
            I(str2, "get WUserSigInfo = null");
            return;
        }
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onDoneGetTicket domain:");
        sb5.append(str3);
        sb5.append(" type:");
        sb5.append(i3);
        sb5.append(" with token len:");
        sb5.append(str7);
        objArr[0] = Integer.valueOf(sb5.toString() == null ? -1 : str4.length());
        QLog.d("DataApiPlugin", 1, objArr);
        StringBuilder sb6 = new StringBuilder();
        if ((i3 & 4096) != 0) {
            String h16 = com.tencent.mobileqq.webview.util.s.h(str, 1);
            if (TextUtils.isEmpty(str4)) {
                str7 = z(false);
            }
            str5 = str7;
            if (TextUtils.isEmpty(str5)) {
                sb6.append("skey\u83b7\u53d6\u5931\u8d25;");
                QLog.e("DataApiPlugin", 1, "skey is null ", h16);
                i16 = -2;
                if ((i3 & 134217728) != 0) {
                    if (!TextUtils.isEmpty(str5) || (GetUserSigInfoTicket = WtloginHelper.GetUserSigInfoTicket(wUserSigInfo, 134217728)) == null) {
                        str6 = str5;
                    } else {
                        String str8 = new String(GetUserSigInfoTicket._pt4token_map.get(str3));
                        QLog.i("DataApiPlugin", 1, "onDoneGetTicket last refresh pt4token time: " + GetUserSigInfoTicket._create_time);
                        str6 = str8;
                    }
                    if (TextUtils.isEmpty(str6)) {
                        sb6.append("pt4token\u83b7\u53d6\u5931\u8d25;Ticket = null");
                        QLog.e("DataApiPlugin", 1, "get pt4_token failed ", str3);
                        i17 = -2;
                        E(str2, i17, sb6.toString());
                    }
                    u("pt4_token", str6, str3, str, false);
                }
                i17 = i16;
                E(str2, i17, sb6.toString());
            }
            u("skey", str5, h16, str, false);
            K(str);
        } else {
            str5 = str7;
        }
        i16 = 0;
        if ((i3 & 134217728) != 0) {
        }
        i17 = i16;
        E(str2, i17, sb6.toString());
    }

    /* loaded from: classes33.dex */
    class a extends com.tencent.mobileqq.emosm.t {
        a() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onResponse(Bundle bundle) {
            Bitmap defaultFaceBitmap;
            if (bundle == null || bundle.getInt("respkey", 0) != DataApiPlugin.this.f238560m.key) {
                return;
            }
            String string = bundle.getString("cmd");
            String string2 = bundle.getString("callbackid");
            Bundle bundle2 = bundle.getBundle("response");
            if (QLog.isColorLevel()) {
                QLog.i("DataApiPlugin", 2, "response:" + string);
            }
            if (string != null) {
                if ("getUserVipType".equals(string)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        int i3 = bundle2.getInt("type");
                        jSONObject.put("result", 0);
                        jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("uin", bundle2.getString("uin"));
                        jSONObject2.put("type", i3);
                        jSONObject.put("data", jSONObject2);
                        if (TextUtils.isEmpty(string2)) {
                            return;
                        }
                        DataApiPlugin.this.callJs(string2 + "(" + jSONObject.toString() + ");");
                        return;
                    } catch (JSONException unused) {
                        return;
                    }
                }
                if ("getFaceFilePath".equals(string)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        if (bundle2 != null) {
                            String string3 = bundle2.getString("faceFilePath");
                            if (new File(string3).exists()) {
                                try {
                                    Bitmap decodeFile = BitmapFactory.decodeFile(string3, BaseImageUtil.calculateInSampleSize(new BitmapFactory.Options(), string3, 200));
                                    int width = decodeFile.getWidth();
                                    defaultFaceBitmap = BaseImageUtil.getRoundedCornerBitmap(decodeFile, width, width, decodeFile.getHeight());
                                    if (defaultFaceBitmap != null && defaultFaceBitmap.getWidth() > 200) {
                                        defaultFaceBitmap = BaseImageUtil.scaleBitmap(defaultFaceBitmap, 200);
                                    }
                                } catch (OutOfMemoryError unused2) {
                                    defaultFaceBitmap = null;
                                }
                            } else {
                                defaultFaceBitmap = BaseImageUtil.getDefaultFaceBitmap();
                            }
                            if (defaultFaceBitmap == null) {
                                jSONObject3.put("result", 1002);
                            } else {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                defaultFaceBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                                jSONObject3.put("result", 0);
                                jSONObject3.put("file", "data:image/png;base64," + encodeToString);
                                jSONObject3.put("size", defaultFaceBitmap.getWidth());
                                byteArrayOutputStream.close();
                            }
                        } else {
                            jSONObject3.put("result", 1002);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            return;
                        }
                        DataApiPlugin.this.callJs(string2 + "(" + jSONObject3.toString() + ");");
                        return;
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("DataApiPlugin", 2, "response IPC_FUNC_CMD_GET_FACE_FILE_PATH error: " + e16.getMessage());
                            return;
                        }
                        return;
                    }
                }
                if ("checkRelation".equals(string)) {
                    JSONObject jSONObject4 = new JSONObject();
                    try {
                        jSONObject4.put("result", 0);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("relation", bundle2.getBoolean("result", false) ? 1 : 2);
                        jSONObject4.put("data", jSONObject5);
                        if (TextUtils.isEmpty(string2)) {
                            return;
                        }
                        DataApiPlugin.this.callJs(string2, jSONObject4.toString());
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
        }
    }
}
