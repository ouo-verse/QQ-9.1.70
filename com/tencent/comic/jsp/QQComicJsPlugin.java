package com.tencent.comic.jsp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.comic.VipComicHelper;
import com.tencent.comic.data.f;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.comic.webbundle.WebBundleReportUtils;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.WebBundleConstants;
import com.tencent.webbundle.sdk.WebBundleManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class QQComicJsPlugin extends VasWebviewJsPlugin {
    private JSONObject C;
    private static final AtomicBoolean G = new AtomicBoolean(false);
    private static String H = null;
    public static final bc F = ThreadManagerV2.newHandlerRecycleThread("QQComicJsPluginDeamon", 0).b();

    /* renamed from: d, reason: collision with root package name */
    public String f99384d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f99385e = null;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicInteger f99386f = new AtomicInteger(-1);

    /* renamed from: h, reason: collision with root package name */
    public String f99387h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f99388i = "";

    /* renamed from: m, reason: collision with root package name */
    public int f99389m = 0;
    String D = null;
    c E = new a();

    /* loaded from: classes32.dex */
    class a implements c {
        a() {
        }
    }

    private void C() {
        JSONObject jSONObject = this.C;
        if (jSONObject != null) {
            f.f99355l.e(jSONObject);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQComicJsPlugin", 2, "setContainerInfo success on Resume extrasParams: " + f.f99355l.toString());
        }
    }

    private void D(JSONObject jSONObject) {
        this.f99389m = jSONObject.optInt("type");
    }

    private void E(JSONObject jSONObject, String str, WebViewFragment webViewFragment) throws JSONException {
        String[] strArr;
        int optInt = jSONObject.optInt("tabNum", 2);
        int optInt2 = jSONObject.optInt("subIndex");
        String optString = jSONObject.optString("switchCallback");
        JSONArray optJSONArray = jSONObject.optJSONArray("subTextArray");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            strArr = null;
        } else {
            String[] strArr2 = new String[optJSONArray.length()];
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                strArr2[i3] = optJSONArray.getString(i3);
            }
            strArr = strArr2;
        }
        if (webViewFragment != null) {
            webViewFragment.getSwiftTitleUI().M(new SwiftIphoneTitleBarUI.h(optInt2, optInt, optString, str, strArr));
        } else {
            callbackError(str, "webViewFragment == null");
        }
    }

    private void H(JSONObject jSONObject, String str, WebViewFragment webViewFragment) {
        int optInt = jSONObject.optInt(com.tencent.luggage.wxa.c8.c.f123400v);
        if (webViewFragment != null) {
            webViewFragment.getSwiftTitleUI().R(optInt);
        } else {
            QLog.e("QQComicJsPlugin", 1, "webViewFragment == null");
            callbackError(str, "webViewFragment == null");
        }
    }

    private void I(JSONObject jSONObject, String str, WebViewFragment webViewFragment) {
        String optString = jSONObject.optString("name", "");
        if (webViewFragment != null) {
            webViewFragment.getSwiftTitleUI().O(optString);
        } else {
            QLog.e("QQComicJsPlugin", 1, "webViewFragment == null");
            callbackError(str, "webViewFragment == null");
        }
    }

    private void J(JSONObject jSONObject) {
        VipComicHelper.j(jSONObject.optInt("useWebBundle"));
    }

    private void callbackError(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", -1);
            jSONObject.put("msg", str2);
            super.callJs(str + "&&" + str + "(" + jSONObject.toString() + ");");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQComicJsPlugin", 2, e16.getMessage());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("QQComicJsPlugin", 2, "callbackId->" + str + " errorMsg: " + str2);
        }
    }

    static /* bridge */ /* synthetic */ String r() {
        return u();
    }

    private void t(JSONObject jSONObject, String str, WebViewFragment webViewFragment) {
        String str2;
        int i3;
        String optString = jSONObject.optString("switchCallback");
        if (TextUtils.isEmpty(optString)) {
            i3 = -1;
            str2 = "the subTabCallback isEmpty";
        } else {
            if (webViewFragment != null) {
                webViewFragment.getSwiftTitleUI().f314061n0.a(optString, false);
            }
            str2 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            i3 = 0;
        }
        if (webViewFragment != null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2.put("code", i3);
                jSONObject2.put("message", str2);
                jSONObject3.put("subIndex", webViewFragment.getSwiftTitleUI().g());
                jSONObject2.put("data", jSONObject3);
            } catch (JSONException e16) {
                QLog.e("QQComicJsPlugin", 1, e16, new Object[0]);
                callbackError(str, e16.getMessage());
            }
            super.callJs(str, jSONObject2.toString());
            return;
        }
        callbackError(str, "webViewFragment == null");
    }

    private static String u() {
        File cacheDir = com.tencent.comic.utils.a.b().getCacheDir();
        if (cacheDir != null) {
            return cacheDir.getAbsolutePath() + "/qqcomic/cache/";
        }
        if (!Environment.getExternalStorageState().equals("mounted") || !Environment.getExternalStorageDirectory().exists()) {
            return null;
        }
        File externalCacheDir = com.tencent.comic.utils.a.b().getExternalCacheDir();
        if (externalCacheDir != null) {
            return externalCacheDir.getAbsolutePath() + "/qqcomic/cache/";
        }
        return VFSAssistantUtils.getSDKPrivatePath("tencent/MobileQQ/qqcomic/cache/");
    }

    private void y(JSONObject jSONObject, String str, WebViewFragment webViewFragment) throws JSONException {
        if (QLog.isColorLevel()) {
            QLog.i("QQComicJsPlugin", 2, "initPrivateSettingIcon " + jSONObject.optInt("status", -1));
        }
        if (webViewFragment != null) {
            this.f99386f.set(jSONObject.optInt("status", -1));
            this.f99384d = jSONObject.optString("name");
            this.f99385e = jSONObject.optString("callbackName");
            if (this.f99386f.get() >= 0) {
                if (!com.tencent.comic.utils.a.b().getSharedPreferences("boodo_" + this.mRuntime.b().getCurrentAccountUin(), 0).getBoolean("private_read_red_dot", false)) {
                    webViewFragment.getSwiftTitleUI().d0(true);
                    QLog.i("QQComicJsPlugin", 1, "show private read red dot.");
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", 0);
            super.callJs(str, jSONObject2.toString());
            return;
        }
        callbackError(str, "webViewFragment == null");
    }

    private void z(JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        String optString2 = jSONObject.optString("bundle_url", "");
        jSONObject.optString("preloadSource", "");
        Activity a16 = this.mRuntime.a();
        if (a16 != null) {
            Intent intent = new Intent();
            intent.putExtra("url", optString);
            VipComicHelper.g(intent);
            if (optJSONObject != null) {
                intent.putExtra(WebBundleConstants.OPEN_WITH_WEBBUNDLE, true);
                if (WebBundleManager.getInstance("comic").openWebViewWithWebBundle(a16, optString, optJSONObject, intent, optString2)) {
                    return;
                } else {
                    WebBundleReportUtils.b(optString, false, WebBundleReportUtils.f99494b);
                }
            } else {
                WebBundleReportUtils.b(optString, false, WebBundleReportUtils.f99496d);
            }
            A(intent.getExtras());
            VipComicHelper.f(a16, intent, 100);
        }
    }

    public void M(final String str, final JSONObject jSONObject, final String str2, final long j3) {
        F.post(new Runnable() { // from class: com.tencent.comic.jsp.QQComicJsPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("QQComicDebug", 2, "waitPluginAndHandleJsCall start, isReady:" + QQComicPluginBridge.f99473b);
                }
                long j16 = 0;
                if (!QQComicPluginBridge.f99473b) {
                    QQComicPluginBridge.b(com.tencent.comic.utils.a.a(), false, null);
                    for (long j17 = 0; !QQComicPluginBridge.f99473b && j17 < j3; j17 += 50) {
                        SystemClock.sleep(50L);
                    }
                    if (QQComicPluginBridge.f99473b) {
                        QQComicPluginBridge.g(com.tencent.comic.utils.a.b());
                    }
                }
                if (QQComicPluginBridge.f99473b) {
                    while (true) {
                        boolean z16 = QQComicPluginBridge.f99473b;
                        if (j16 >= 500) {
                            break;
                        }
                        SystemClock.sleep(50L);
                        j16 += 50;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QQComicDebug", 2, "waitPluginAndHandleJsCall calljs, jsready:false");
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.comic.jsp.QQComicJsPlugin.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            QQComicJsPlugin.this.w(str, jSONObject, str2);
                        }
                    });
                } else if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("code", 2001);
                        jSONObject2.put("message", "QQComic is not ready");
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    QQComicJsPlugin.super.callJs(str2, jSONObject2.toString());
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQComicDebug", 2, "waitPluginAndHandleJsCall end");
                }
            }
        });
    }

    public synchronized void clearCache(String str) {
        H = str;
        AtomicBoolean atomicBoolean = G;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.comic.jsp.QQComicJsPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                String r16 = QQComicJsPlugin.r();
                if (r16 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    FileUtils.deleteFile(new File(r16));
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (QLog.isColorLevel()) {
                        QLog.d("QQComicJsPlugin", 2, "clean cache cost " + (currentTimeMillis2 - currentTimeMillis) + " ms");
                    }
                }
                QQComicJsPlugin.G.set(false);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", 0);
                    jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("size", QQComicJsPlugin.this.getCacheSize());
                    jSONObject.put("data", jSONObject2);
                } catch (Exception unused) {
                }
                QQComicJsPlugin.this.callJs(QQComicJsPlugin.H, jSONObject.toString());
            }
        }, 5, null, true);
    }

    public synchronized long getCacheSize() {
        String[] list;
        String u16 = u();
        long j3 = 0;
        if (u16 == null) {
            return 0L;
        }
        Stack stack = new Stack();
        stack.push(u16);
        while (!stack.isEmpty()) {
            File file = new File((String) stack.pop());
            if (file.isDirectory() && (list = file.list()) != null) {
                for (String str : list) {
                    File file2 = new File(file, str);
                    if (file2.isDirectory()) {
                        stack.push(file2.getAbsolutePath());
                    } else {
                        j3 += file2.length();
                    }
                }
            }
            j3 += file.length();
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "comic";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 258L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, final String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("QQComicJsPlugin", 2, "handleJsRequest, url=" + str);
        }
        if (!"comic".equals(str2) || str == null || str3 == null) {
            return false;
        }
        try {
            final JSONObject jSONObject = strArr.length > 0 ? new JSONObject(strArr[0]) : new JSONObject();
            final String optString = jSONObject.optString("callback", "");
            Activity a16 = this.mRuntime.a();
            WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
            if ("getFirstShowData".equals(str3)) {
                String str4 = f.f99356m.get();
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                    jSONObject2.put("data", str4);
                } else {
                    jSONObject2.put("code", -1);
                    jSONObject2.put("message", "\u9996\u5c4f\u6570\u636e\u672a\u51c6\u5907\u597d");
                    jSONObject2.put("data", "");
                }
                super.callJs(optString, jSONObject2.toString());
                if (QLog.isColorLevel()) {
                    QLog.d("QQComicJsPlugin", 2, "js getFirstShowData:" + str4);
                }
            } else if ("setTitleBarBackground".equals(str3)) {
                H(jSONObject, optString, webViewFragment);
            } else if ("onWebViewScrollChanged".equals(str3)) {
                K(optString, webViewFragment);
            } else if ("setTitleName".equals(str3)) {
                I(jSONObject, optString, webViewFragment);
            } else if ("attachSwitchChannel".equals(str3)) {
                t(jSONObject, optString, webViewFragment);
            } else if ("setSwitchChannel".equals(str3)) {
                E(jSONObject, optString, webViewFragment);
            } else if ("getSwitchChannel".equals(str3)) {
                v(optString, webViewFragment);
            } else if ("showSwitchChannel".equals(str3)) {
                L(optString, webViewFragment);
            } else if ("hideSwitchChannel".equals(str3)) {
                x(optString, webViewFragment);
            } else if ("setTabRedPoint".equals(str3)) {
                F(jSONObject, optString, webViewFragment);
            } else if ("getTitleBarHeight".equals(str3)) {
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                int dimensionPixelSize = this.mRuntime.a().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
                if (ImmersiveUtils.isSupporImmersive() == 1) {
                    dimensionPixelSize += ImmersiveUtils.getStatusBarHeight(this.mRuntime.a());
                }
                jSONObject4.put("height", dimensionPixelSize);
                jSONObject3.put("code", 0);
                jSONObject3.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                jSONObject3.put("data", jSONObject4);
                super.callJs(optString, jSONObject3.toString());
            } else if ("openQQBrowser".equals(str3)) {
                Intent intent = new Intent();
                intent.putExtra("url", jSONObject.optString("url"));
                VipComicHelper.f(a16, intent, -1);
            } else if ("closeCurrentWebview".equals(str3)) {
                if (!a16.isFinishing()) {
                    a16.finish();
                }
            } else if ("setTitleAndBottomBar".equals(str3)) {
                G(jSONObject, optString, (u) a16, webViewFragment);
            } else if ("setLeftCallback".equals(str3)) {
                this.D = jSONObject.optString("leftcallback");
            } else if ("openView".equals(str3)) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("options");
                String optString2 = jSONObject.optString("name");
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("com.tencent.mobileqq", optString2));
                intent2.putExtra("options", jSONObject5.toString());
                a16.startActivity(intent2);
            } else if ("getReporterInfo".equals(str3)) {
                JSONObject jSONObject6 = new JSONObject();
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("mod", f.f99344a);
                jSONObject7.put("land_page", f.f99346c);
                jSONObject7.put("obj_ownerid", f.f99345b);
                jSONObject6.put("data", jSONObject7);
                jSONObject6.put(QzoneIPCModule.RESULT_CODE, 0);
                jSONObject6.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                super.callJs(optString, jSONObject6.toString());
            } else if ("getCacheSize".equals(str3)) {
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("result", 0);
                jSONObject8.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("size", getCacheSize());
                jSONObject9.put("status", G.get() ? 1 : 2);
                jSONObject8.put("data", jSONObject9);
                super.callJs(optString, jSONObject8.toString());
            } else if (HippyReporter.RemoveEngineReason.CLEAR_CACHE.equals(str3)) {
                clearCache(optString);
            } else if ("initPrivateSettingIcon".equals(str3)) {
                y(jSONObject, optString, webViewFragment);
            } else if ("openWebBundleView".equals(str3)) {
                z(jSONObject);
            } else if ("setColorfulTabInfo".equals(str3)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQComicJsPlugin", 2, "setColorfulTabInfo " + jSONObject.optString("tabTitle", "fail"));
                }
                this.f99387h = jSONObject.optString("tabTitle", "");
                this.f99388i = jSONObject.optString("tabSubTitle", "");
            } else if ("setWebBundleOption".equals(str3)) {
                J(jSONObject);
            } else if ("setShareOption".equals(str3)) {
                D(jSONObject);
            } else if ("setContainerInfo".equals(str3)) {
                JSONObject jSONObject10 = new JSONObject(jSONObject.optString("read_params"));
                this.C = jSONObject10;
                f.f99355l.e(jSONObject10);
                if (QLog.isColorLevel()) {
                    QLog.d("QQComicJsPlugin", 2, "setContainerInfo success extrasParams: " + f.f99355l.toString());
                }
            } else if (QQComicPluginBridge.f99473b) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.comic.jsp.QQComicJsPlugin.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QQComicJsPlugin.this.w(str3, jSONObject, optString);
                    }
                });
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("QQComicDebug", 2, "js plugin is not ready...");
                }
                M(str3, jSONObject, optString, 3000L);
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("QQComicJsPlugin", 1, "handle js error!", e16);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
    }

    void w(String str, JSONObject jSONObject, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "create a new js plugin");
        }
        QQComicPluginBridge.d(this.mRuntime, this.E);
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "create js plugin failed");
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("code", 2002);
            jSONObject2.put("message", "create js plugin failed");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        super.callJs(str2, jSONObject2.toString());
    }

    private void A(Bundle bundle) {
        if (bundle != null) {
            bundle.remove(WebBundleConstants.OPEN_WITH_WEBBUNDLE);
            bundle.remove(WebBundleConstants.WEBBUNDLE_REAL_URL);
            bundle.remove(WebBundleConstants.WEBBUNDLE_PRELOAD_URL);
            bundle.remove(WebBundleConstants.WEBBUNDLE_BUNDLE_DATA);
        }
    }

    private void F(JSONObject jSONObject, String str, WebViewFragment webViewFragment) throws JSONException {
        int[] iArr;
        if (webViewFragment != null) {
            int optInt = jSONObject.optInt("action");
            JSONArray optJSONArray = jSONObject.optJSONArray("subIndexArray");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                iArr = null;
            } else {
                iArr = new int[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    iArr[i3] = optJSONArray.getInt(i3);
                }
            }
            if ((optInt != 1 && optInt != 2) || iArr == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -1);
                jSONObject2.put("message", "param is invalid");
                super.callJs(str, jSONObject2.toString());
                return;
            }
            webViewFragment.getSwiftTitleUI().N(new SwiftIphoneTitleBarUI.i(iArr, optInt, str));
            return;
        }
        callbackError(str, "webViewFragment == null");
    }

    private void G(JSONObject jSONObject, String str, u uVar, WebViewFragment webViewFragment) {
        if (webViewFragment != null) {
            boolean optBoolean = jSONObject.optBoolean("titleHide");
            boolean optBoolean2 = jSONObject.optBoolean("bottomHide");
            webViewFragment.getSwiftTitleUI().X(!optBoolean);
            uVar.setBottomBarVisibility(!optBoolean2);
            return;
        }
        callbackError(str, "webViewFragment == null");
    }

    private void K(String str, WebViewFragment webViewFragment) {
        if (webViewFragment != null) {
            webViewFragment.getSwiftTitleUI().F(str);
        } else {
            QLog.e("QQComicJsPlugin", 1, "webViewFragment == null");
            callbackError(str, "webViewFragment == null");
        }
    }

    private void L(String str, WebViewFragment webViewFragment) {
        String str2;
        int i3;
        if (webViewFragment != null) {
            if (!webViewFragment.getSwiftTitleUI().Z(true)) {
                i3 = -1;
                str2 = "not exist sub tab";
            } else {
                str2 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                i3 = 0;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", i3);
                jSONObject.put("message", str2);
            } catch (JSONException e16) {
                QLog.e("QQComicJsPlugin", 1, e16, new Object[0]);
                callbackError(str, e16.getMessage());
            }
            super.callJs(str, jSONObject.toString());
            return;
        }
        callbackError(str, "webViewFragment == null");
    }

    private void v(String str, WebViewFragment webViewFragment) {
        if (webViewFragment != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("code", 0);
                jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                jSONObject2.put("subIndex", webViewFragment.getSwiftTitleUI().g());
                jSONObject.put("data", jSONObject2);
            } catch (JSONException e16) {
                QLog.e("QQComicJsPlugin", 1, e16, new Object[0]);
                callbackError(str, e16.getMessage());
            }
            super.callJs(str, jSONObject.toString());
            return;
        }
        callbackError(str, "webViewFragment == null");
    }

    private void x(String str, WebViewFragment webViewFragment) {
        String str2;
        int i3;
        if (webViewFragment != null) {
            if (!webViewFragment.getSwiftTitleUI().Z(false)) {
                i3 = -1;
                str2 = "not exist sub tab";
            } else {
                str2 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                i3 = 0;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", i3);
                jSONObject.put("message", str2);
            } catch (JSONException e16) {
                QLog.e("QQComicJsPlugin", 1, e16, new Object[0]);
                callbackError(str, e16.getMessage());
            }
            super.callJs(str, jSONObject.toString());
            return;
        }
        callbackError(str, "webViewFragment == null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934601L) {
            if (TextUtils.isEmpty(this.D)) {
                return false;
            }
            super.callJs(this.D, "");
            return true;
        }
        if (j3 != 2 && j3 != 256) {
            return false;
        }
        C();
        return false;
    }

    public void B() {
    }
}
