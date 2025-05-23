package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public abstract class VasWebviewJsPluginV2 extends VasWebviewJsPlugin {
    private static final String TAG = "VasWebviewJsPluginV2";
    protected static final int THREADMODE_DEFAULT = 0;
    protected static final int THREADMODE_FILE = 2;
    protected static final int THREADMODE_UI = 1;
    private Map<String, SubscriberMethod> mMethodCache = null;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes20.dex */
    public static class JsData {
        String[] args;
        String callbackId;
        JsBridgeListener listener;
        String url;

        public JsData(String str, JsBridgeListener jsBridgeListener, String str2, String[] strArr) {
            this.listener = jsBridgeListener;
            this.url = str2;
            this.args = strArr;
            this.callbackId = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Target({ElementType.METHOD})
    @Keep
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes20.dex */
    public @interface JsbridgeSubscribe {
        String args() default "";

        String method();

        int threadMode() default 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class SubscriberMethod {
        final String args;
        final Method method;
        final String scheme;
        final int threadMode;

        public SubscriberMethod(Method method, String str, int i3, String str2) {
            this.method = method;
            this.threadMode = i3;
            this.scheme = str;
            this.args = str2;
        }

        public Runnable buildSafeRunnable(VasWebviewJsPluginV2 vasWebviewJsPluginV2, final JsData jsData, final JSONObject jSONObject) {
            final WeakReference weakReference = new WeakReference(vasWebviewJsPluginV2);
            return new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2.SubscriberMethod.1
                @Override // java.lang.Runnable
                public void run() {
                    Object obj;
                    try {
                        Class<?>[] parameterTypes = SubscriberMethod.this.method.getParameterTypes();
                        if (TextUtils.isEmpty(SubscriberMethod.this.args)) {
                            if (parameterTypes.length == 1 && JsData.class.isAssignableFrom(parameterTypes[0])) {
                                SubscriberMethod.this.method.invoke(weakReference.get(), jsData);
                                return;
                            } else {
                                SubscriberMethod.this.method.invoke(weakReference.get(), new Object[0]);
                                return;
                            }
                        }
                        String[] split = SubscriberMethod.this.args.split("\\|");
                        int length = split.length;
                        Object[] objArr = new Object[length];
                        for (int i3 = 0; i3 < length; i3++) {
                            try {
                                obj = jSONObject.get(split[i3]);
                            } catch (JSONException e16) {
                                QLog.e(VasWebviewJsPluginV2.TAG, 1, e16, new Object[0]);
                                obj = null;
                            }
                            if (String.class.isAssignableFrom(parameterTypes[i3]) && !(obj instanceof String)) {
                                objArr[i3] = String.valueOf(obj);
                            } else {
                                objArr[i3] = obj;
                            }
                        }
                        SubscriberMethod.this.method.invoke(weakReference.get(), objArr);
                    } catch (Exception e17) {
                        QLog.e(VasWebviewJsPluginV2.TAG, 1, e17, new Object[0]);
                    }
                }
            };
        }

        public String toString() {
            return "SubscriberMethod{method=" + this.method + ", threadMode=" + this.threadMode + ", scheme='" + this.scheme + "', args='" + this.args + "'}";
        }
    }

    private List<SubscriberMethod> findJSBMethod(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Method method : cls.getDeclaredMethods()) {
            if (QLog.isDebugVersion()) {
                QLog.e(TAG, 1, "method : " + method.toString());
                QLog.e(TAG, 1, "annotations : " + Arrays.toString(method.getAnnotations()));
            }
            JsbridgeSubscribe jsbridgeSubscribe = (JsbridgeSubscribe) method.getAnnotation(JsbridgeSubscribe.class);
            if (jsbridgeSubscribe != null && !TextUtils.isEmpty(jsbridgeSubscribe.method())) {
                SubscriberMethod subscriberMethod = new SubscriberMethod(method, jsbridgeSubscribe.method(), jsbridgeSubscribe.threadMode(), jsbridgeSubscribe.args());
                if (QLog.isDebugVersion()) {
                    QLog.e(TAG, 1, "register : " + subscriberMethod.toString());
                }
                arrayList.add(subscriberMethod);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public final boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jSONObject;
        int i3;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", nameSpace=" + str2 + ", method=" + str3);
        }
        if (getNameSpace().equals(str2) && str3 != null) {
            try {
                jSONObject = createJson(str, strArr);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleJsRequest, createJson error" + e16.getCause());
                }
                jSONObject = null;
            }
            if (jSONObject == null) {
                int indexOf = str.indexOf("#");
                if (indexOf != -1 && (i3 = indexOf + 1) <= str.length() - 1) {
                    try {
                        String decode = URLDecoder.decode(str.substring(i3), "UTF-8");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("callback", decode);
                        jSONObject = jSONObject2;
                    } catch (Exception e17) {
                        QLog.e("WebViewPlugin", 1, "getJsonFromJSBridge error!" + str, e17);
                    }
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleJsRequest JSON = " + jSONObject.toString());
            }
            String optString = jSONObject.optString("callback");
            if (this.mMethodCache == null) {
                List<SubscriberMethod> findJSBMethod = findJSBMethod(getClass());
                synchronized (this) {
                    if (this.mMethodCache == null) {
                        this.mMethodCache = new HashMap(findJSBMethod.size() * 2);
                        for (SubscriberMethod subscriberMethod : findJSBMethod) {
                            this.mMethodCache.put(subscriberMethod.scheme, subscriberMethod);
                        }
                    }
                }
            }
            SubscriberMethod subscriberMethod2 = this.mMethodCache.get(str3);
            if (subscriberMethod2 != null) {
                Runnable buildSafeRunnable = subscriberMethod2.buildSafeRunnable(this, new JsData(optString, jsBridgeListener, str, strArr), jSONObject);
                int i16 = subscriberMethod2.threadMode;
                if (i16 == 0) {
                    buildSafeRunnable.run();
                } else if (i16 == 1) {
                    ThreadManager.getUIHandler().post(buildSafeRunnable);
                } else if (i16 == 2) {
                    ThreadManager.getFileThreadHandler().post(buildSafeRunnable);
                }
                return true;
            }
            QLog.e(TAG, 1, "not find jsbridge");
        }
        return false;
    }
}
