package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.os.Handler;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public abstract class WebViewPlugin implements com.tencent.mobileqq.webviewplugin.i {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_ORIGINAL_LOAD = "original_load";
    public static final String KEY_PERFORMANCE = "performanceData";
    public static final String KEY_REQUEST = "requestData";
    public static final String KEY_RESPONSE = "responseData";
    public static final String KEY_TARGET = "target";
    public static final String KEY_URL = "url";
    public static final int RECODE_FAILED_FREQUENCY_LIMIT = 5;
    public static final int RECODE_FAILED_NATIVE_ERROR = -100;
    public static final int RECODE_FAILED_NO_SUCH_METHOD = 3;
    public static final int RECODE_FAILED_PARAMS_ERROR = 4;
    public static final int RECODE_FAILED_PERMISSION_DENIED = 1;
    public static final int RECODE_FAILED_TOKEN_VERIFY_TIME_OUT = 2;
    public static final int RECODE_SUCCESSED = 0;
    public static final int TARGET_LEFT_VIEW = 1;
    public static final int TARGET_NAV_BACK = 2;
    public static final int TARGET_SYS_BACK = 3;
    AtomicBoolean inited;
    public boolean isDestroy;
    private HashMap<String, Long> mCallTimeMaps;
    public HashMap<String, JsBridgeListener> mOpenApiListeners;
    public b mRuntime;
    public final String mTAG;
    public long pluginEventFlag;

    /* loaded from: classes20.dex */
    class a implements ThreadExcutor.IThreadListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewPlugin.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onAdded() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPostRun() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                WebViewPlugin.this.onPostPluginAsyncTask();
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPreRun() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* loaded from: classes20.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<CustomWebView> f314110a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<AppRuntime> f314111b;

        /* renamed from: c, reason: collision with root package name */
        WeakReference<Activity> f314112c;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<y> f314113d;

        /* renamed from: e, reason: collision with root package name */
        WeakReference<WebViewProvider> f314114e;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Activity activity, AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) appRuntime);
                return;
            }
            this.f314113d = null;
            this.f314114e = null;
            this.f314112c = new WeakReference<>(activity);
            this.f314111b = new WeakReference<>(appRuntime);
            if (activity instanceof y) {
                this.f314113d = new WeakReference<>((y) activity);
            }
        }

        public Activity a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Activity) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f314112c.get();
        }

        @Deprecated
        public AppInterface b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AppInterface) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            AppRuntime appRuntime = this.f314111b.get();
            if (appRuntime instanceof AppInterface) {
                return (AppInterface) appRuntime;
            }
            return null;
        }

        public AppRuntime c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AppRuntime) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f314111b.get();
        }

        public y d(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (y) iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            }
            WeakReference<y> weakReference = this.f314113d;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public CustomWebView e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CustomWebView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            WeakReference<CustomWebView> weakReference = this.f314110a;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public WebViewProvider f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (WebViewProvider) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            WeakReference<WebViewProvider> weakReference = this.f314114e;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public com.tencent.mobileqq.webviewplugin.s g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (com.tencent.mobileqq.webviewplugin.s) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            WeakReference<y> weakReference = this.f314113d;
            if (weakReference != null && weakReference.get() != null && (this.f314113d.get() instanceof com.tencent.mobileqq.webviewplugin.s)) {
                return (com.tencent.mobileqq.webviewplugin.s) this.f314113d.get();
            }
            return null;
        }

        public void h(y yVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) yVar);
            } else if (yVar != null) {
                this.f314113d = new WeakReference<>(yVar);
            }
        }

        public void i(WebViewProvider webViewProvider) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) webViewProvider);
            } else if (webViewProvider != null) {
                this.f314114e = new WeakReference<>(webViewProvider);
                this.f314113d = new WeakReference<>(webViewProvider);
            }
        }
    }

    public WebViewPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTAG = "WebViewPlugin";
        this.isDestroy = false;
        this.pluginEventFlag = 0L;
        this.mCallTimeMaps = new HashMap<>();
        this.inited = new AtomicBoolean(false);
    }

    public static JSONObject getJsonFromJSBridge(String str) {
        int i3;
        try {
            int indexOf = str.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
            if (indexOf != -1 && (i3 = indexOf + 1) <= str.length() - 1) {
                return new JSONObject(URLDecoder.decode(str.substring(i3), "UTF-8"));
            }
            throw new Exception("illegal json");
        } catch (Exception e16) {
            QLog.e("WebViewPlugin", 1, "getJsonFromJSBridge error!" + str, e16);
            return null;
        }
    }

    public static String toJsScript(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        return "window.mqq && mqq.execEventCallback && mqq.execEventCallback(" + com.tencent.mobileqq.webview.util.s.l(str) + "," + String.valueOf(jSONObject) + "," + String.valueOf(jSONObject2) + ");";
    }

    public void addOpenApiListenerIfNeeded(String str, JsBridgeListener jsBridgeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str, (Object) jsBridgeListener);
        } else if (jsBridgeListener != null && jsBridgeListener.f314008c) {
            if (this.mOpenApiListeners == null) {
                this.mOpenApiListeners = new HashMap<>();
            }
            this.mOpenApiListeners.put(str, jsBridgeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void bindWebViewProvider(WebViewProvider webViewProvider) {
        b bVar = this.mRuntime;
        if (bVar != null) {
            bVar.i(webViewProvider);
            return;
        }
        throw new IllegalArgumentException("plugin runtime must be init");
    }

    @Deprecated
    public void callJs(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (this.isDestroy) {
            return;
        }
        b bVar = this.mRuntime;
        CustomWebView e16 = bVar != null ? bVar.e() : null;
        if (e16 != null) {
            e16.callJs(str);
        }
    }

    public void callJs4OpenApi(JsBridgeListener jsBridgeListener, int i3, String str) {
        CustomWebView customWebView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, jsBridgeListener, Integer.valueOf(i3), str);
            return;
        }
        if (this.isDestroy) {
            return;
        }
        b bVar = this.mRuntime;
        if (bVar != null) {
            customWebView = bVar.e();
        } else {
            customWebView = null;
        }
        if (customWebView != null) {
            customWebView.callJs4OpenApi(jsBridgeListener, i3, str);
        }
    }

    public void callJs4OpenApiIfNeeded(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), str2);
            return;
        }
        HashMap<String, JsBridgeListener> hashMap = this.mOpenApiListeners;
        if (hashMap == null || !hashMap.containsKey(str)) {
            z16 = false;
        } else {
            callJs4OpenApi(this.mOpenApiListeners.remove(str), i3, JsBridgeListener.a(i3, null, str2));
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebViewPlugin.troop.openapi", 2, "callJs4OpenApiIfNeeded, methodName:" + str + "| callJs4OpenApi:" + z16);
        }
    }

    public void dispatchJsEvent(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, jSONObject, jSONObject2);
        } else {
            callJs(toJsScript(str, jSONObject, jSONObject2));
        }
    }

    public final <T> T getBrowserComponent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (T) iPatchRedirector.redirect((short) 28, (Object) this, i3);
        }
        b bVar = this.mRuntime;
        if (bVar != null) {
            WebViewProvider f16 = bVar.f();
            if (f16 != null) {
                return (T) f16.getComponentProvider().a(i3);
            }
            if (this.mRuntime.a() instanceof b.f) {
                return (T) ((b.f) this.mRuntime.a()).getComponentProvider().a(i3);
            }
            return null;
        }
        return null;
    }

    public long getLastCallTime(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Long) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str)).longValue();
        }
        if (!this.mCallTimeMaps.containsKey(str)) {
            return 0L;
        }
        return this.mCallTimeMaps.get(str).longValue();
    }

    @NotNull
    public abstract String getNameSpace();

    public int getRequestCode(byte b16) {
        y yVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, this, Byte.valueOf(b16))).intValue();
        }
        b bVar = this.mRuntime;
        if (bVar != null) {
            yVar = bVar.d(bVar.a());
        } else {
            yVar = null;
        }
        if (yVar instanceof af) {
            return ((af) yVar).switchRequestCode(this, b16);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WebViewPlugin", 4, "startActivityForResult not called, activity need implement Interface WebViewPluginContainer");
            return -1;
        }
        return -1;
    }

    public long getWebViewEventByNameSpace(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).longValue();
        }
        return 0L;
    }

    public long getWebViewSchemaByNameSpace(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str)).longValue();
        }
        return 0L;
    }

    public int getWebViewSchemaListIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object handleEvent(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return null;
        }
        return iPatchRedirector.redirect((short) 13, this, str, Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 10, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleSchemaRequest(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void initRuntime(Activity activity, AppRuntime appRuntime) {
        if (this.inited.compareAndSet(false, true)) {
            this.mRuntime = new b(activity, appRuntime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void onActivityResult(Intent intent, byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
        }
    }

    public void onAppRuntimeReady(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.isDestroy = true;
        HashMap<String, JsBridgeListener> hashMap = this.mOpenApiListeners;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    protected void onPostPluginAsyncTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.i
    public void onRuntimeUpdate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
            return;
        }
        b bVar = this.mRuntime;
        if (bVar != null) {
            bVar.f314111b = new WeakReference<>(appRuntime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onWebViewCreated(CustomWebView customWebView) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) customWebView);
        } else if (customWebView != null && (bVar = this.mRuntime) != null) {
            bVar.f314110a = new WeakReference<>(customWebView);
        }
    }

    public void postPluginAsyncTask(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) runnable);
        } else {
            ThreadManagerV2.post(runnable, 5, new a(), false);
        }
    }

    public void setCallTime(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        } else {
            this.mCallTimeMaps.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public WebViewPlugin setHandler(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (WebViewPlugin) iPatchRedirector.redirect((short) 23, (Object) this, (Object) handler);
        }
        return this;
    }

    public void setWebUiInterface(y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) yVar);
        } else if (yVar != null) {
            this.mRuntime.h(yVar);
        }
    }

    public void startActivityForResult(Intent intent, byte b16) {
        y yVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, intent, Byte.valueOf(b16));
            return;
        }
        b bVar = this.mRuntime;
        ComponentCallbacks2 componentCallbacks2 = null;
        if (bVar != null) {
            yVar = bVar.d(bVar.a());
        } else {
            yVar = null;
        }
        b bVar2 = this.mRuntime;
        if (bVar2 != null) {
            componentCallbacks2 = bVar2.a();
        }
        if (yVar instanceof af) {
            ((af) yVar).pluginStartActivityForResult(this, intent, b16);
        } else if (componentCallbacks2 instanceof af) {
            ((af) componentCallbacks2).pluginStartActivityForResult(this, intent, b16);
        } else if (QLog.isDevelopLevel()) {
            QLog.d("WebViewPlugin", 4, "startActivityForResult not called, activity need implement Interface WebViewPluginContainer");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 12, this, str, Long.valueOf(j3), map)).booleanValue();
    }

    public void callJs(String str, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) strArr);
            return;
        }
        if (this.isDestroy) {
            return;
        }
        b bVar = this.mRuntime;
        CustomWebView e16 = bVar != null ? bVar.e() : null;
        if (e16 != null) {
            e16.callJs(str, strArr);
        }
    }

    public void callJs4OpenApiIfNeeded(String str, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, str, Integer.valueOf(i3), obj);
            return;
        }
        HashMap<String, JsBridgeListener> hashMap = this.mOpenApiListeners;
        if (hashMap == null || !hashMap.containsKey(str)) {
            z16 = false;
        } else {
            callJs4OpenApi(this.mOpenApiListeners.remove(str), i3, JsBridgeListener.a(i3, obj, null));
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebViewPlugin.troop.openapi", 2, "callJs4OpenApiIfNeeded, methodName:" + str + "| callJs4OpenApi:" + z16);
        }
    }
}
