package com.tencent.mobileqq.vaswebviewplugin;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.k;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSourceInfoBid;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public abstract class VasWebviewJsPlugin extends VasBasePlugin {
    private static final String TAG = "VasWebViewJsPlugin";
    AuthorizeConfig authCfg;
    public t mOnRemoteResp = new t() { // from class: com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin.1
        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
            VasWebviewJsPlugin.this.onBindedToClient();
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
            VasWebviewJsPlugin.this.onDisconnectWithService();
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
            VasWebviewJsPlugin.this.onPushMsg(bundle);
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onResponse(Bundle bundle) {
            VasWebviewJsPlugin.this.onResponse(bundle);
        }
    };
    protected VasCommonJsbProxy proxy;

    private Method getMethod(Class<?> cls, String str) {
        Method method = null;
        if (cls == null) {
            return null;
        }
        for (Method method2 : cls.getDeclaredMethods()) {
            if (method2.getName().equals(str)) {
                method = method2;
            }
        }
        if (method == null) {
            return getMethod(cls.getSuperclass(), str);
        }
        return method;
    }

    private boolean isArgsEnable(String[] strArr) {
        if (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(strArr[0])) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0034 A[Catch: Exception -> 0x0068, InvocationTargetException -> 0x00a6, IllegalAccessException -> 0x00e8, JSONException -> 0x0126, TryCatch #2 {IllegalAccessException -> 0x00e8, InvocationTargetException -> 0x00a6, JSONException -> 0x0126, Exception -> 0x0068, blocks: (B:38:0x001d, B:40:0x0023, B:6:0x002e, B:8:0x0034, B:9:0x005d, B:5:0x0029), top: B:37:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean call(String str, String str2, String str3) {
        JSONObject jSONObject;
        Method method = getMethod(getClass(), str);
        if (method != null) {
            if (str2 != null) {
                try {
                    if (str2.length() > 0) {
                        jSONObject = new JSONObject(str2);
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "JsHandler call class=" + getClass().getSimpleName() + ",methodName=" + str + ",args=" + jSONObject);
                        }
                        method.invoke(this, jSONObject, str3);
                        return true;
                    }
                } catch (IllegalAccessException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "Web Bridge call method IllegalAccessException:" + e16.getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + str + ",args=" + str2);
                    }
                    callJsOnError(str3, "No such method.");
                    return false;
                } catch (InvocationTargetException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "Web Bridge call method InvocationTargetException:" + e17.getTargetException().getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + str + ",args=" + str2);
                    }
                    callJsOnError(str3, "No such method.");
                    return false;
                } catch (JSONException e18) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "args is not json string,class=" + getClass().getSimpleName() + ",methodName=" + str + ",args=" + str2);
                    }
                    callJsOnError(str3, e18.getMessage());
                    return false;
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "Web Bridge call method Exception:" + e19.getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + str + ",args=" + str2);
                    }
                    callJsOnError(str3, "No such method.");
                    return false;
                }
            }
            jSONObject = new JSONObject();
            if (QLog.isColorLevel()) {
            }
            method.invoke(this, jSONObject, str3);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "not found method;class=" + getClass().getSimpleName() + ",methodName=" + str + ",args=" + str2);
        }
        callJsOnError(str3, "No such method.");
        return false;
    }

    public void callJsOnError(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "VasWebviewJsPlugin.callJsOnError, msg:" + str2);
        }
        super.callJs(str + "({'result':-1,'message':'" + str2 + "'})");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public JSONObject createJson(String str, String[] strArr) throws JSONException {
        if (isArgsEnable(strArr) && VasToggle.FEATURE_VAS_HIPPY_JS_ARGS.isEnable(true) && (TextUtils.isEmpty(str) || BaseApplication.getContext().getPackageName().equals(MobileQQ.processName))) {
            return new JSONObject(strArr[0]);
        }
        return WebViewPlugin.getJsonFromJSBridge(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        return false;
    }

    public void getDomainIpList(JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getDomainIpList: " + jSONObject);
        }
        try {
            String string = jSONObject.getString("domain");
            if (!TextUtils.isEmpty(string)) {
                Bundle bundle = new Bundle();
                bundle.putString("domain", string);
                sendRemoteReq(com.tencent.mobileqq.emosm.a.a("getDomainIpList", str, this.mOnRemoteResp.key, bundle), false, false);
                return;
            }
            throw new Exception("getDomainIpList host is null");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "getDomainIpList failed: " + e16.getMessage());
            }
            callJsOnError(str, e16.getMessage());
        }
    }

    public void getVipType(JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getVipType: " + jSONObject);
        }
        try {
            String string = jSONObject.getString("uin");
            if (string.equals(this.mRuntime.b().getAccount())) {
                Bundle bundle = new Bundle();
                bundle.putString("uin", string);
                sendRemoteReq(com.tencent.mobileqq.emosm.a.a("getUserVipType", str, this.mOnRemoteResp.key, bundle), false, false);
                return;
            }
            throw new Exception("uin illegal");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "getVipType failed: " + e16.getMessage());
            }
            callJsOnError(str, e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleEmojiSchemaRequest(String str, String str2) {
        if (str == null) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleSchemaRequest:" + k.f(str, new String[0]));
        }
        if (str.startsWith("qqvip:")) {
            return true;
        }
        if (!Uri.parse(str).getScheme().equals("qqjsbridge")) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "can no do with this url");
            }
            return false;
        }
        VasCommonReporter.getHistoryFeature().setValue1("js_schema").setValue2("emoji").report();
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        String str3 = (String) arrayList.get(2);
        String str4 = (String) arrayList.get(3);
        if (!EmojiJsPlugin.OBJECT_NAME.equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "can not handle objectname:" + str3);
            }
            return false;
        }
        List<String> subList = arrayList.subList(4, arrayList.size() - 1);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "calling " + str3 + "." + str4 + " args:" + subList);
        }
        String url = this.mRuntime.e().getUrl();
        if (!this.authCfg.F(url, str3 + "." + str4)) {
            return false;
        }
        return call(str4, subList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        try {
            if (j3 == 8589934593L) {
                this.onPageStartedTime = System.currentTimeMillis();
            } else if (j3 == 8589934594L) {
                this.onPageFinishedTime = System.currentTimeMillis();
            }
            return excuteEvent(str, j3, map);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleThemeAndBubbleSchemaRequest(String str, String str2, String str3) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (!Uri.parse(trim).getScheme().equals("qqjsbridge")) {
            return false;
        }
        VasCommonReporter.getHistoryFeature().setValue1("js_schema").setValue2("bubble").report();
        String[] split = trim.split("/");
        if (split.length < 6) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "url params error:url=" + trim + ",params num=" + split.length);
            }
            return false;
        }
        String str4 = split[2];
        String str5 = split[3];
        String str6 = split[4];
        String str7 = split[5];
        if (!str3.equals(str4)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "can not handle objectname:" + str4);
            }
            return false;
        }
        try {
            String decode = URLDecoder.decode(str7, "UTF-8");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "HandleUrl params objectName=" + str4 + ",methodName=" + str5 + ",callbackId=" + str6 + ",jsonParams=" + decode);
            }
            String url = this.mRuntime.e().getUrl();
            if (!this.authCfg.F(url, str4 + "." + str5)) {
                return false;
            }
            return call(str5, decode, str6);
        } catch (UnsupportedEncodingException e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "jsonParams UnsupportedEncodingException,jsonParams=" + str7);
            }
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        if (this.authCfg == null) {
            this.authCfg = AuthorizeConfig.y();
        }
        this.proxy = VasCommonJsbProxy.INSTANCE.createProxy(this);
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.mOnRemoteResp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.mOnRemoteResp);
        VasCommonJsbProxy vasCommonJsbProxy = this.proxy;
        if (vasCommonJsbProxy != null) {
            vasCommonJsbProxy.pageDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResponse(Bundle bundle) {
        if (bundle != null && bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
            String string = bundle.getString("cmd");
            String string2 = bundle.getString("callbackid");
            Bundle bundle2 = bundle.getBundle("response");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "response:" + string);
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
                        super.callJs(string2, jSONObject.toString());
                        return;
                    } catch (JSONException unused) {
                        return;
                    }
                }
                if ("getDomainIpList".equals(string)) {
                    super.callJs(string2, bundle2.getString("result"));
                }
            }
        }
    }

    public void sendRemoteReq(Bundle bundle, boolean z16, boolean z17) {
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            VasLogReporter.getProfileCard().reportHighest("sendRemoteReq error ipc service not ready");
        } else if (z16) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(bundle);
        } else {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(bundle);
        }
    }

    void onBindedToClient() {
    }

    void onDisconnectWithService() {
    }

    void onPushMsg(Bundle bundle) {
    }

    public boolean call(String str, List<String> list) {
        Method method;
        Method[] declaredMethods = getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                method = null;
                break;
            }
            method = declaredMethods[i3];
            if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                break;
            }
            i3++;
        }
        int size = list.size();
        for (int i16 = 0; i16 < size; i16++) {
            try {
                list.set(i16, URLDecoder.decode(list.get(i16), "UTF-8"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                if (QLog.isDevelopLevel()) {
                    QLog.i(GGProSourceInfoBid.JB, 4, "decode failed: " + list.get(i16));
                }
            }
        }
        if (method != null) {
            try {
                int size2 = list.size();
                if (size2 == 0) {
                    method.invoke(this, new Object[0]);
                } else if (size2 == 1) {
                    method.invoke(this, list.get(0));
                } else if (size2 == 2) {
                    method.invoke(this, list.get(0), list.get(1));
                } else if (size2 == 3) {
                    method.invoke(this, list.get(0), list.get(1), list.get(2));
                } else if (size2 == 4) {
                    method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3));
                } else if (size2 != 5) {
                    method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
                } else {
                    method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
                }
                return true;
            } catch (Exception e17) {
                QLog.e(TAG, 1, e17, new Object[0]);
                return false;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "cannot found match method,maybe your method using args type is NO String? request method:class:" + getClass().getSimpleName() + str + " args:" + list);
        }
        return false;
    }
}
