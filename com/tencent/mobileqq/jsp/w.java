package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.jsp.ShareMsgImpl;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.IOException;
import oicq.wlogin_sdk.tools.util;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class w extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    Context f238916d;

    /* renamed from: e, reason: collision with root package name */
    ShareMsgImpl f238917e;

    /* renamed from: f, reason: collision with root package name */
    com.tencent.mobileqq.webviewplugin.f f238918f;

    /* renamed from: h, reason: collision with root package name */
    ShareMsgImpl.b f238919h;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements ShareMsgImpl.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) w.this);
            }
        }

        @Override // com.tencent.mobileqq.jsp.ShareMsgImpl.b
        public void onSharMsgcallback(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else if (!TextUtils.isEmpty(str)) {
                w.this.callJs(str, str2);
            } else {
                w.this.callJs4OpenApiIfNeeded("shareMsg", 0, str2);
            }
        }

        @Override // com.tencent.mobileqq.jsp.ShareMsgImpl.b
        public void startActivityForResult(Intent intent, byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, intent, Byte.valueOf(b16));
            } else {
                w.this.startActivityForResult(intent, b16);
            }
        }
    }

    public w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f238918f = null;
            this.f238919h = new a();
        }
    }

    private static String q(Context context, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("appids", str2);
        String str5 = "vkey=" + str3 + ";uin=" + str4;
        if (QLog.isColorLevel()) {
            QLog.d("gamecenter", 2, "<--httpRequest vookies=" + str5 + ",appids=" + str2);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("Cookie", str5);
        try {
            String openUrl = HttpUtil.openUrl(context, str, "POST", bundle, bundle2);
            if (QLog.isColorLevel()) {
                QLog.i("gamecenter", 2, "httpRequest: result:" + openUrl);
            }
            return openUrl;
        } catch (ClientProtocolException unused) {
            if (QLog.isColorLevel()) {
                QLog.i("gamecenter", 2, "httpRequest:ClientProtocolException");
                return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
            }
            return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("gamecenter", 2, "httpRequest:" + e16.getMessage());
                return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
            }
            return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQApi";
    }

    public String getOpenidBatch(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        String account = this.mRuntime.c().getAccount();
        if (this.mRuntime.f() != null && this.mRuntime.f().getIntent() != null) {
            str2 = q(BaseApplicationImpl.getApplication(), "https://cgi.connect.qq.com/api/get_openids_by_appids", str, this.mRuntime.f().getIntent().getStringExtra("vkey"), account);
        } else {
            str2 = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQApi", 2, "<--getOpenidBatch result" + str2);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if ("QQApi".equals(str2)) {
            boolean z16 = jsBridgeListener != null && jsBridgeListener.f314008c;
            addOpenApiListenerIfNeeded(str3, jsBridgeListener);
            int length = strArr.length;
            if ("isAppInstalled".equals(str3) && length == 1) {
                valueOf = Boolean.valueOf(PackageUtil.isAppInstalled(this.f238916d, strArr[0]));
            } else if ("checkAppInstalled".equals(str3) && length == 1) {
                valueOf = PackageUtil.checkAppInstalled(this.f238916d, strArr[0]);
            } else if ("checkAppInstalledBatch".equals(str3) && length == 1) {
                valueOf = PackageUtil.checkAppInstalledBatch(this.f238916d, strArr[0]);
            } else if ("isAppInstalledBatch".equals(str3) && length == 1) {
                valueOf = PackageUtil.isAppInstalledBatch(this.f238916d, strArr[0]);
            } else if ("startAppWithPkgName".equals(str3) && length == 1) {
                valueOf = Boolean.valueOf(PackageUtil.startAppWithPkgName(this.f238916d, strArr[0], null));
            } else if ("startAppWithPkgNameAndOpenId".equals(str3) && length == 2) {
                valueOf = Boolean.valueOf(PackageUtil.startAppWithPkgName(this.f238916d, strArr[0], strArr[1]));
            } else if ("getOpenidBatch".equals(str3) && length == 1) {
                valueOf = getOpenidBatch(strArr[0]);
            } else {
                if ("launchAppWithTokens".equals(str3) && (length == 1 || length == 4)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("handleJsRequest", 2, "[launchAppWithTokens] length:" + length);
                    }
                    if (length == 1) {
                        r(strArr[0]);
                    } else if (length == 4) {
                        s(strArr[0], strArr[1], strArr[2], strArr[3], null, "");
                    }
                } else if ("getAppsVerionCodeBatch".equals(str3) && length == 1) {
                    valueOf = PackageUtil.getAppsVerionCodeBatch(this.f238916d, strArr[0]);
                } else if ("setShareURL".equals(str3) && length == 1) {
                    valueOf = Boolean.valueOf(this.f238917e.k(strArr[0]));
                } else if ("setShareInfo".equals(str3) && length == 1) {
                    valueOf = Boolean.valueOf(this.f238917e.i(strArr[0]));
                } else if ("setToolHiddenFlags".equals(str3) && length == 1) {
                    u(strArr[0]);
                } else if ("shareMsg".equals(str3) && length == 1) {
                    this.f238917e.r(strArr[0], z16);
                } else if (ThirdPartyMiniPageProxy.KEY_SHARE_TEXT.equals(str3) && length == 1) {
                    this.f238917e.z(strArr[0]);
                } else if ("shareHypertext".equals(str3) && length == 1) {
                    this.f238917e.q(strArr[0]);
                } else if ("sendPokeMsg".equals(str3) && length == 1) {
                    this.f238917e.h(strArr[0]);
                } else if ("shareArkMessage".equals(str3) && length == 1) {
                    this.f238917e.n(strArr[0]);
                } else if ("shareArkMessageSafe".equals(str3) && length == 1) {
                    this.f238917e.o(strArr[0], false);
                }
                valueOf = null;
            }
            if (z16) {
                callJs4OpenApiIfNeeded(str3, 0, valueOf);
            } else {
                jsBridgeListener.c(valueOf);
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
        } else {
            super.onActivityResult(intent, b16, i3);
            this.f238917e.f(intent, b16, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onCreate();
        Activity p16 = p();
        this.f238916d = p16;
        ShareMsgImpl shareMsgImpl = new ShareMsgImpl(p16, this.mRuntime.a(), this.mRuntime.b(), this.f238919h);
        this.f238917e = shareMsgImpl;
        shareMsgImpl.e(this);
        WebViewPlugin.b bVar = this.mRuntime;
        com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.f)) {
            this.f238918f = (com.tencent.mobileqq.webviewplugin.f) d16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f238917e.g();
            super.onDestroy();
        }
    }

    Activity p() {
        Activity a16 = this.mRuntime.a();
        while (a16 != null && (a16 instanceof BasePluginActivity)) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    public void r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            t(jSONObject.optString("appID"), jSONObject.optString("paramsStr"), jSONObject.optString("packageName"), jSONObject.optString(WadlProxyConsts.FLAGS), jSONObject.optString("type"), jSONObject.optString("subappid"), jSONObject.optString("from"));
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("launchAppWithTokens", 2, "parse params error");
            }
            e16.printStackTrace();
        }
    }

    public void s(String str, String str2, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3, str4, str5, str6);
        } else {
            t(str, str2, str3, str4, str5, str6, "");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void setWebUiInterface(com.tencent.mobileqq.webview.swift.y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) yVar);
            return;
        }
        super.setWebUiInterface(yVar);
        ShareMsgImpl shareMsgImpl = this.f238917e;
        if (shareMsgImpl != null) {
            shareMsgImpl.l(yVar);
            this.f238917e.j(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ff, code lost:
    
        if (com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor.queryIntentActivities(r1, r3, 0).size() > 0) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppInterface b16;
        AppInterface appInterface;
        String str8;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, str3, str4, str5, str6, str7);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("gamecenter", 2, "launchAppWithTokens " + str3);
        }
        eq2.a aVar = new eq2.a();
        if (this.f238918f == null) {
            Context context = this.f238916d;
            if (!(context instanceof PublicFragmentActivityForTool)) {
                if (context instanceof QBaseActivity) {
                    b16 = (AppInterface) ((QBaseActivity) context).getAppRuntime();
                } else {
                    b16 = null;
                }
                appInterface = b16;
                if (appInterface != null) {
                    return;
                }
                int i3 = 268435456;
                try {
                    int parseInt = Integer.parseInt(str4);
                    if ((parseInt & 67108864) == 67108864) {
                        i3 = 335544320;
                    }
                    if ((parseInt & 536870912) == 536870912) {
                        i3 |= 536870912;
                    }
                    if ((parseInt & 4194304) == 4194304) {
                        i3 |= 4194304;
                    }
                } catch (Exception unused) {
                }
                int i16 = i3;
                ReportController.o(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, str, "", "", "");
                String str9 = "tencentwtlogin" + str + QzoneWebViewOfflinePlugin.STR_DEVIDER;
                if (util.FILE_DIR.equals(str5)) {
                    PackageManager packageManager = this.f238916d.getPackageManager();
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent.setData(Uri.parse(str9));
                    if (packageManager != null) {
                    }
                }
                z16 = false;
                if (z16) {
                    WebViewPlugin.b bVar = this.mRuntime;
                    if (bVar != null && bVar.e() != null) {
                        str8 = this.mRuntime.e().getUrl();
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin webview is null");
                        }
                        str8 = "";
                    }
                    aVar.f(str9, this.f238916d, str8, appInterface, str, str3, i16, str6);
                    return;
                }
                aVar.e(appInterface, this.f238916d, str, str2, str3, i16, str7);
                return;
            }
        }
        b16 = this.mRuntime.b();
        appInterface = b16;
        if (appInterface != null) {
        }
    }

    public void u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        try {
            int parseInt = Integer.parseInt(str, 10);
            SwiftBrowserMiscHandler swiftBrowserMiscHandler = (SwiftBrowserMiscHandler) super.getBrowserComponent(32);
            if (swiftBrowserMiscHandler != null) {
                swiftBrowserMiscHandler.C.sendMessage(swiftBrowserMiscHandler.C.obtainMessage(0, parseInt, 0));
            }
        } catch (NumberFormatException unused) {
        }
    }
}
