package com.tencent.open.appcommon.js;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class HttpInterface extends BaseInterface {
    public static final String PLUGIN_NAMESPACE = "qzone_http";
    private static final String TAG = "HttpInterface";
    protected WeakReference<WebView> mWebViewRef;
    protected WebView webView;
    protected Handler mHandler = new g();
    protected ArrayList<AsyncTask<Bundle, Void, HashMap<String, Object>>> asyncTaskList = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    protected class a implements HttpCgiAsyncTask.a {

        /* renamed from: d, reason: collision with root package name */
        protected final WebView f340678d;

        /* renamed from: e, reason: collision with root package name */
        protected final String f340679e;

        /* renamed from: f, reason: collision with root package name */
        protected final String f340680f;

        /* renamed from: h, reason: collision with root package name */
        protected final String f340681h;

        /* renamed from: i, reason: collision with root package name */
        protected final boolean f340682i;

        public a(WebView webView, String str, String str2, String str3, boolean z16) {
            this.f340678d = webView;
            this.f340680f = str3;
            this.f340679e = str2;
            this.f340681h = str;
            this.f340682i = z16;
        }

        @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
        public void f(JSONObject jSONObject) {
            String jSONObject2;
            if (HttpInterface.this.hasRight() && HttpInterface.this.mHandler != null) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                Message obtainMessage = HttpInterface.this.mHandler.obtainMessage(0);
                f fVar = new f();
                fVar.f340702a = this.f340678d;
                obtainMessage.obj = fVar;
                obtainMessage.arg1 = 0;
                try {
                    if (this.f340682i) {
                        jSONObject.put("guid", this.f340681h);
                        jSONObject2 = jSONObject.toString();
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("guid", this.f340681h);
                        jSONObject3.put("content", jSONObject.toString());
                        jSONObject2 = jSONObject3.toString();
                    }
                    com.tencent.open.base.f.h(HttpInterface.TAG, "onResult >>> " + jSONObject2);
                    if (TextUtils.isEmpty(this.f340679e)) {
                        fVar.f340703b = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpSuccess'," + jSONObject2 + ");}void(0);";
                    } else {
                        fVar.f340703b = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + this.f340679e + "(" + jSONObject2 + ");void(0);";
                    }
                } catch (JSONException unused) {
                    if (TextUtils.isEmpty(this.f340680f)) {
                        fVar.f340703b = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"" + this.f340681h + "\"});}void(0);";
                    } else {
                        fVar.f340703b = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + this.f340680f + "({\"guid\":\"" + this.f340681h + "\",\"err\":\"json format error\"});void(0);";
                    }
                }
                HttpInterface.this.mHandler.sendMessage(obtainMessage);
            }
        }

        @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
        public void onException(Exception exc) {
            if (HttpInterface.this.hasRight() && HttpInterface.this.mHandler != null) {
                com.tencent.open.base.f.a(HttpInterface.TAG, "onException >>> ");
                Message obtainMessage = HttpInterface.this.mHandler.obtainMessage(0);
                f fVar = new f();
                fVar.f340702a = this.f340678d;
                obtainMessage.obj = fVar;
                obtainMessage.arg1 = 0;
                if (TextUtils.isEmpty(this.f340680f)) {
                    fVar.f340703b = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('httpError',{\"guid\":\"" + this.f340681h + "\"});}void(0);";
                } else {
                    fVar.f340703b = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + this.f340680f + "({\"guid\":\"" + this.f340681h + "\",\"err\":\"\"});void(0);";
                }
                HttpInterface.this.mHandler.sendMessage(obtainMessage);
            }
        }
    }

    public HttpInterface(Activity activity, WebView webView) {
        this.webView = webView;
        this.mWebViewRef = new WeakReference<>(webView);
    }

    @TargetApi(11)
    protected void aSyncTaskExecute(HttpCgiAsyncTask httpCgiAsyncTask, Bundle bundle) {
        Executor obtainMultiExecutor = obtainMultiExecutor();
        if (obtainMultiExecutor != null) {
            httpCgiAsyncTask.executeOnExecutor(obtainMultiExecutor, bundle);
        } else {
            httpCgiAsyncTask.execute(bundle);
        }
    }

    public void clearWebViewCache() {
        try {
            WebView webView = this.webView;
            if (webView != null) {
                webView.clearCache(true);
            }
        } catch (Exception e16) {
            com.tencent.open.base.f.b(TAG, "clearWebViewCache>>>", e16);
        }
    }

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public void destroy() {
        int size = this.asyncTaskList.size();
        for (int i3 = 0; i3 < size; i3++) {
            AsyncTask<Bundle, Void, HashMap<String, Object>> asyncTask = this.asyncTaskList.get(i3);
            if (asyncTask != null && !asyncTask.isCancelled()) {
                com.tencent.open.base.f.a(TAG, "cancel AsyncTask when onDestory");
                asyncTask.cancel(true);
                if (asyncTask instanceof HttpCgiAsyncTask) {
                    ((HttpCgiAsyncTask) asyncTask).c();
                }
            }
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public String getInterfaceName() {
        return PLUGIN_NAMESPACE;
    }

    public void httpRequest(String str) {
        boolean z16;
        boolean z17;
        if (!hasRight()) {
            com.tencent.open.base.f.a(TAG, ">>httpReauest has not right>>");
            return;
        }
        com.tencent.open.base.f.a(TAG, "httpRequest >>> " + str.toString());
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("guid");
            String optString2 = jSONObject.optString("url");
            String optString3 = jSONObject.optString("method");
            String optString4 = jSONObject.optString("oncomplate");
            String optString5 = jSONObject.optString("onerror");
            if (jSONObject.optInt("supportetag", 1) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (jSONObject.optInt("from_h5", 0) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("from_h5", z17);
            bundle.putString("platform", com.tencent.open.adapter.a.f().h());
            bundle.putString("keystr", com.tencent.open.adapter.a.f().k());
            bundle.putString("uin", String.valueOf(com.tencent.open.adapter.a.f().l()));
            bundle.putString("resolution", MobileInfoUtil.getResolution());
            bundle.putString("keytype", "256");
            if (optString3.equals("POST")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                if (optJSONObject != null) {
                    Iterator keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String obj = keys.next().toString();
                        Object obj2 = optJSONObject.get(obj);
                        com.tencent.open.base.f.a(TAG, "key = " + obj + " value = " + obj2.toString());
                        if (!TextUtils.isEmpty(obj)) {
                            bundle.putString(obj, obj2.toString());
                        }
                    }
                }
            } else if (z16) {
                bundle.putString("needhttpcache", "");
                com.tencent.open.base.f.a(TAG, "use supportEtag");
            }
            com.tencent.open.base.f.a(TAG, "execute asyncTask url >>> " + optString2 + " methodName " + optString3);
            HttpCgiAsyncTask httpCgiAsyncTask = new HttpCgiAsyncTask(optString2, optString3, new a(this.mWebViewRef.get(), optString, optString4, optString5, z17));
            aSyncTaskExecute(httpCgiAsyncTask, bundle);
            this.asyncTaskList.add(httpCgiAsyncTask);
        } catch (JSONException e16) {
            com.tencent.open.base.f.d(TAG, "httpRequest JSONException", e16);
        } catch (Exception e17) {
            com.tencent.open.base.f.d(TAG, "httpRequest Exception", e17);
        }
    }

    @TargetApi(11)
    protected Executor obtainMultiExecutor() {
        return ThreadManagerV2.getNetExcutor();
    }
}
