package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.jsbridge.a;
import com.tencent.open.appcommon.js.OpenJsBridge;
import com.tencent.open.base.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseInterface extends a.b {
    protected static final int NO_AUTH_CODE = -1;
    protected static final String NO_AUTH_MSG = "baby,you don't have permission";
    private static final String TAG = "BaseInterface";
    protected static final Pattern qqPattern = Pattern.compile("^http://(\\w+\\.)+qq\\.com/.*");
    protected static final Pattern HTTPS_PATTERN = Pattern.compile("^https://(\\w+\\.)+qq\\.com/.*");
    protected String currentUrl = "";
    protected boolean jsRight = true;
    public List<String> batchCallbackQueue = new ArrayList();
    public int optLef = 0;
    protected boolean firstIn = true;
    public TimerTask mTask = null;

    public void addResult(final WebView webView, final long j3, String str, long j16, int i3) {
        com.tencent.open.base.f.a(TAG, "callBatch addResult result : " + str + ", timeout : " + j16 + ", queueLimit : " + i3);
        if (this.firstIn) {
            Timer timer = ThreadManagerV2.getTimer();
            TimerTask timerTask = new TimerTask() { // from class: com.tencent.open.appcommon.js.BaseInterface.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (BaseInterface.this.optLef <= 0) {
                        cancel();
                        BaseInterface.this.firstIn = true;
                    }
                    if (BaseInterface.this.batchCallbackQueue.size() > 0) {
                        BaseInterface.this.batchCallback(webView, j3);
                    }
                }
            };
            this.mTask = timerTask;
            timer.schedule(timerTask, j16, j16);
            this.firstIn = false;
        }
        synchronized (this) {
            this.batchCallbackQueue.add(str);
        }
        if (this.batchCallbackQueue.size() >= this.optLef || this.batchCallbackQueue.size() >= i3) {
            com.tencent.open.base.f.a(TAG, "callBatch one batch complete , call batchCallback once !!!");
            this.mTask.cancel();
            this.firstIn = true;
            batchCallback(webView, j3);
        }
    }

    protected void batchCallback(final WebView webView, final long j3) {
        final ArrayList arrayList = new ArrayList();
        synchronized (this) {
            this.optLef -= this.batchCallbackQueue.size();
            for (String str : this.batchCallbackQueue) {
                if (!str.equals("void")) {
                    arrayList.add(str);
                }
            }
            this.batchCallbackQueue.clear();
        }
        if (arrayList.size() > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.appcommon.js.BaseInterface.2
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('batchCallback',{'guid':" + j3 + ",'r':0,'data':" + arrayList.toString() + "})};";
                    WebView webView2 = webView;
                    if (webView2 != null) {
                        try {
                            webView2.loadUrl(str2);
                        } catch (Exception unused) {
                        }
                        com.tencent.open.base.f.e(BaseInterface.TAG, "Response<callBatch> AsyncInterface result : " + str2);
                        return;
                    }
                    com.tencent.open.base.f.c(BaseInterface.TAG, "Response<callBatch> AsyncInterface result : webview is null !!!");
                }
            });
        } else {
            com.tencent.open.base.f.a(TAG, "Response<callBatch> AsyncInterface no need response");
        }
    }

    protected void batchCallbackError(final WebView webView, final long j3, final String str) {
        com.tencent.open.base.f.a(TAG, "batchCallbackError guid : " + j3 + ", msg : " + str);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.appcommon.js.BaseInterface.3
            @Override // java.lang.Runnable
            public void run() {
                String str2 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('batchCallback',{guid:" + j3 + ",'r':-2,'data':['" + str + "']})};";
                com.tencent.open.base.f.c("Response<callBatch>", str2);
                try {
                    webView.loadUrl(str2);
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.jsbridge.a.b
    public void call(String str, List<String> list, a.C7950a c7950a) {
        Method method;
        Class<BaseJsCallBack> cls;
        Method[] methods;
        String name;
        Object invoke;
        long currentTimeMillis = System.currentTimeMillis();
        Method[] methods2 = getClass().getMethods();
        int length = methods2.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                method = methods2[i3];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                } else {
                    i3++;
                }
            } else {
                method = null;
                break;
            }
        }
        if (method == null) {
            try {
                cls = BaseJsCallBack.class;
                String str2 = BaseJsCallBack.LOG_TAG;
            } catch (Exception e16) {
                e16.printStackTrace();
                cls = null;
            }
            if (cls != null && (methods = cls.getMethods()) != null && methods.length > 0) {
                int length2 = methods.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length2) {
                        break;
                    }
                    Method method2 = methods[i16];
                    if (method2.getName().equals(str) && method2.getParameterTypes().length == list.size()) {
                        method = method2;
                        break;
                    }
                    i16++;
                }
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("AsyncInterface:[");
        if (method == null) {
            name = "";
        } else {
            name = method.getName();
        }
        sb5.append(name);
        sb5.append("]:Reflct find method cost::time6-time5=");
        sb5.append(currentTimeMillis2 - currentTimeMillis);
        com.tencent.open.base.f.e("TIME", sb5.toString());
        if (method != null) {
            try {
                if (list.size() == 0) {
                    invoke = method.invoke(this, new Object[0]);
                } else {
                    invoke = method.invoke(this, list.toArray());
                }
                com.tencent.open.base.f.e("TIME", "AsyncInterface:[" + method.getName() + "]:Invoke find method cost:time7-time6=" + (System.currentTimeMillis() - currentTimeMillis2));
                Class<?> returnType = method.getReturnType();
                if (returnType != Void.TYPE && returnType != Void.class) {
                    if (c7950a != null) {
                        if (customCallback()) {
                            if (c7950a instanceof OpenJsBridge.OpenJsBridgeListener) {
                                return;
                            }
                            c7950a.b(invoke.toString());
                            return;
                        } else if (c7950a instanceof OpenJsBridge.OpenJsBridgeListener) {
                            ((OpenJsBridge.OpenJsBridgeListener) c7950a).f(str, invoke);
                            return;
                        } else {
                            c7950a.a(invoke);
                            return;
                        }
                    }
                    return;
                }
                if (c7950a instanceof OpenJsBridge.OpenJsBridgeListener) {
                    ((OpenJsBridge.OpenJsBridgeListener) c7950a).f(str, null);
                    return;
                } else {
                    c7950a.a(null);
                    return;
                }
            } catch (IllegalAccessException unused) {
                if (c7950a != null) {
                    if (c7950a instanceof OpenJsBridge.OpenJsBridgeListener) {
                        ((OpenJsBridge.OpenJsBridgeListener) c7950a).e(str);
                    } else {
                        c7950a.c();
                    }
                }
            } catch (IllegalArgumentException unused2) {
                if (c7950a != null) {
                    if (c7950a instanceof OpenJsBridge.OpenJsBridgeListener) {
                        ((OpenJsBridge.OpenJsBridgeListener) c7950a).e(str);
                    } else {
                        c7950a.c();
                    }
                }
            } catch (InvocationTargetException unused3) {
                if (c7950a != null) {
                    if (c7950a instanceof OpenJsBridge.OpenJsBridgeListener) {
                        ((OpenJsBridge.OpenJsBridgeListener) c7950a).e(str);
                    } else {
                        c7950a.c();
                    }
                }
            } catch (Exception unused4) {
                if (c7950a != null) {
                    if (c7950a instanceof OpenJsBridge.OpenJsBridgeListener) {
                        ((OpenJsBridge.OpenJsBridgeListener) c7950a).e(str);
                    } else {
                        c7950a.c();
                    }
                }
            }
        }
        QLog.d(TAG, 4, "cannot found match method,maybe your method using args type is NO String? request method:class:" + getClass().getSimpleName() + str + " args:" + list);
        if (c7950a != null) {
            if (c7950a instanceof OpenJsBridge.OpenJsBridgeListener) {
                ((OpenJsBridge.OpenJsBridgeListener) c7950a).e(str);
            } else {
                c7950a.c();
            }
        }
    }

    public void callBatch(WebView webView, HashMap<String, a.b> hashMap, long j3, String str, long j16, int i3) {
        int i16;
        Class<?> cls;
        Method method;
        boolean z16;
        Object invoke;
        Class<?> returnType;
        Method[] methodArr;
        try {
            JSONArray jSONArray = new JSONArray(URLDecoder.decode(str, "UTF-8"));
            this.optLef = jSONArray.length();
            int i17 = 0;
            while (i17 < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i17);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("ns");
                    String optString2 = optJSONObject.optString("method");
                    String optString3 = optJSONObject.optString("guid");
                    String optString4 = optJSONObject.optString("args");
                    ArrayList arrayList = new ArrayList();
                    try {
                        JSONArray jSONArray2 = new JSONArray(optString4);
                        for (int i18 = 0; i18 < jSONArray2.length(); i18++) {
                            arrayList.add(jSONArray2.getString(i18));
                        }
                        if (c.f340695a.contains(optString2)) {
                            arrayList.add(optString3);
                        }
                        cls = c.f340696b.get(optString);
                    } catch (Exception e16) {
                        i16 = i17;
                        com.tencent.open.base.f.c(TAG, "callBatch args error : " + e16.toString());
                        this.optLef = this.optLef + (-1);
                    }
                    if (cls != null) {
                        Method[] methods = cls.getMethods();
                        int length = methods.length;
                        int i19 = 0;
                        while (true) {
                            if (i19 < length) {
                                method = methods[i19];
                                if (method.getName().equals(optString2)) {
                                    methodArr = methods;
                                    if (method.getParameterTypes().length == arrayList.size()) {
                                        break;
                                    }
                                } else {
                                    methodArr = methods;
                                }
                                i19++;
                                methods = methodArr;
                            } else {
                                method = null;
                                break;
                            }
                        }
                        Method method2 = method;
                        if (method2 != null) {
                            a.b bVar = hashMap.get(optString);
                            try {
                                com.tencent.open.base.f.e(TAG, "callBatch <call> class : " + bVar.getClass().getName() + " , method : " + optString2 + "\n , args : " + arrayList.toString());
                                if (arrayList.size() == 0) {
                                    z16 = false;
                                    try {
                                        invoke = method2.invoke(bVar, new Object[0]);
                                    } catch (Exception e17) {
                                        e = e17;
                                        i16 = i17;
                                        com.tencent.open.base.f.d(TAG, "callBatch error", e);
                                        i17 = i16 + 1;
                                    }
                                } else {
                                    z16 = false;
                                    invoke = method2.invoke(bVar, arrayList.toArray());
                                }
                                returnType = method2.getReturnType();
                            } catch (Exception e18) {
                                e = e18;
                                i16 = i17;
                            }
                            if (returnType != Void.TYPE && returnType != Void.class) {
                                String str2 = "'undefined'";
                                if (invoke instanceof String) {
                                    str2 = "'" + ((Object) ((String) invoke).replace("\\", "\\\\").replace("'", "\\'")) + "'";
                                } else {
                                    if (!(invoke instanceof Number) && !(invoke instanceof Long) && !(invoke instanceof Integer) && !(invoke instanceof Double) && !(invoke instanceof Float)) {
                                        if (invoke instanceof Boolean) {
                                            str2 = invoke.toString();
                                        }
                                    }
                                    str2 = invoke.toString();
                                }
                                i16 = i17;
                                try {
                                    addResult(webView, j3, "['interface." + optString2 + "',{'guid':" + optString3 + ",'r':0,'data':" + str2 + "}]", j16, i3);
                                } catch (Exception e19) {
                                    e = e19;
                                    com.tencent.open.base.f.d(TAG, "callBatch error", e);
                                    i17 = i16 + 1;
                                }
                                i17 = i16 + 1;
                            }
                            i16 = i17;
                            addResult(webView, j3, "void", j16, i3);
                            i17 = i16 + 1;
                        }
                    }
                }
                i16 = i17;
                i17 = i16 + 1;
            }
        } catch (UnsupportedEncodingException e26) {
            com.tencent.open.base.f.j(TAG, "callBatch decode params format err", e26);
            batchCallbackError(webView, j3, "callBatch callBatch decode params format err");
        } catch (JSONException e27) {
            com.tencent.open.base.f.j(TAG, "callBatch request params format err", e27);
            batchCallbackError(webView, j3, "callBatch request params format err");
        }
    }

    public void destroy() {
        TimerTask timerTask = this.mTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.mTask = null;
        }
    }

    public abstract String getInterfaceName();

    public boolean hasRight() {
        if (!this.jsRight) {
            com.tencent.open.base.f.c("AppStore", " js interface has no permission, " + this.currentUrl);
        }
        return this.jsRight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCurrentUrl(String str) {
        String lowerCase = str.toLowerCase();
        this.currentUrl = lowerCase;
        try {
            if (!j.d(lowerCase) && !this.currentUrl.startsWith("file://")) {
                if (qqPattern.matcher(this.currentUrl).find()) {
                    this.jsRight = true;
                    return;
                } else if (HTTPS_PATTERN.matcher(this.currentUrl).find()) {
                    this.jsRight = true;
                    return;
                } else {
                    this.jsRight = false;
                    return;
                }
            }
            this.jsRight = true;
        } catch (Exception unused) {
            this.jsRight = true;
        }
    }

    public void doOnCreate() {
    }

    public void doOnDestroy() {
    }

    public void doOnPause() {
    }

    public void doOnResume() {
    }
}
