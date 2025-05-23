package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.kandian.biz.video.feedback.api.IPlayFeedbackHelper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QQBridgeModule extends com.tencent.mobileqq.qqecommerce.biz.hr.api.a implements com.tencent.mobileqq.qqecommerce.biz.hr.api.g {
    private static final String TAG = "QQBridgeModule";
    public static final String WEISHI_PAKG_NAME = "com.tencent.weishi";
    private HashMap<String, Object> mCallbackMap = new HashMap<>();
    private int mEngineId = -1;
    private INetInfoHandler netInfoHandler;

    public QQBridgeModule() {
        setInvokeCallJSCallback(this);
    }

    private synchronized void addPromise(String str, Promise promise) {
        this.mCallbackMap.put(str, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPromiseCallback(Promise promise, JSONObject jSONObject) {
        if (promise != null && promise.isCallback()) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushJSONObject(jSONObject);
            promise.resolve(hippyMap);
        }
    }

    private String getCallbackId(Promise promise) {
        if (promise != null && promise.isCallback()) {
            String callId = promise.getCallId();
            addPromise(callId, promise);
            return callId;
        }
        return "";
    }

    private QBaseFragment getFragment() {
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mEngineId);
        if (engineInstance == null) {
            return null;
        }
        return engineInstance.getFragment();
    }

    private synchronized Object getPromise(String str) {
        return this.mCallbackMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popBackImpl(String str) {
        getFragment();
    }

    private synchronized void removePromise(String str) {
        this.mCallbackMap.remove(str);
    }

    public void cancelUploadingVideo(JSONObject jSONObject, Promise promise) {
        cancelUploadingVideo(jSONObject, getCallbackId(promise));
    }

    public void getALDConfig(JSONObject jSONObject, Promise promise) {
        if (!TextUtils.isEmpty(jSONObject.optString("key", "")) && jSONObject.has("id")) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("value", "");
                doPromiseCallback(promise, jSONObject2);
            } catch (JSONException unused) {
            }
        }
    }

    public void getAllowedStateOfOperationAction(JSONObject jSONObject, Promise promise) {
        Activity activity;
        fk0.c violaInstance = getViolaInstance();
        if (violaInstance != null) {
            activity = violaInstance.a();
        } else {
            activity = null;
        }
        if (activity == null) {
            String str = QBaseActivity.TAG;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("isAllow", false);
            doPromiseCallback(promise, jSONObject2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void getDeviceInfo(Promise promise, boolean z16) {
        JSONObject deviceInfo = getDeviceInfo();
        if (z16) {
            invokeCallJS(promise, deviceInfo);
        } else {
            doPromiseCallback(promise, deviceInfo);
        }
    }

    public void getGdtDeviceInfo(final Promise promise, JSONObject jSONObject, final boolean z16) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.hippy.qq.module.QQBridgeModule.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2;
                qq_ad_get.QQAdGet.DeviceInfo deviceInfo;
                Object pbToJson;
                Context applicationContext = BaseApplication.getContext().getApplicationContext();
                JSONObject jSONObject3 = new JSONObject();
                GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(applicationContext, new GdtDeviceInfoHelper.Params());
                if (create == null || (deviceInfo = create.deviceInfo) == null || (pbToJson = GdtJsonPbUtil.pbToJson(deviceInfo)) == null || !(pbToJson instanceof JSONObject)) {
                    jSONObject2 = null;
                } else {
                    jSONObject2 = (JSONObject) JSONObject.class.cast(pbToJson);
                }
                if (jSONObject2 != null && jSONObject2 != JSONObject.NULL) {
                    try {
                        jSONObject3.put("deviceInfo", jSONObject2);
                    } catch (JSONException e16) {
                        GdtLog.e(QQBridgeModule.TAG, "handleJsCallRequest", e16);
                    }
                } else {
                    GdtLog.e(QQBridgeModule.TAG, "handleJsCallRequest error");
                }
                if (!z16) {
                    QQBridgeModule.this.doPromiseCallback(promise, jSONObject3);
                } else {
                    QQBridgeModule.this.invokeCallJS(promise, jSONObject3);
                }
            }
        }, 4);
    }

    public void getMotiveAd(Promise promise, JSONObject jSONObject) {
        getMotiveAd(getCallbackId(promise), jSONObject);
    }

    public void getNetType(Promise promise, boolean z16) {
        int netWorkType = HttpUtil.getNetWorkType();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getNetType,netType:" + netWorkType);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", netWorkType);
        } catch (JSONException unused) {
        }
        if (z16) {
            invokeCallJS(promise, jSONObject);
        } else {
            doPromiseCallback(promise, jSONObject);
        }
        vaNetworkChange(promise);
    }

    public void getUploadVideoPermission(JSONObject jSONObject, Promise promise) {
        getUploadVideoPermission(jSONObject, getCallbackId(promise));
    }

    public void getUploadingVideoInfo(JSONObject jSONObject, Promise promise) {
        getUploadingVideoInfo(jSONObject, getCallbackId(promise));
    }

    public void getUserInfo(Promise promise, boolean z16) {
        JSONObject userInfo = getUserInfo();
        if (z16) {
            invokeCallJS(promise, userInfo);
        } else {
            doPromiseCallback(promise, userInfo);
        }
    }

    public void hasApp(String str, Promise promise, boolean z16) {
        boolean isWeishiInstalled;
        int i3;
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        if (!"weishi://feed".equals(str) && !"weishi".equals(str)) {
            isWeishiInstalled = PackageUtil.isAppInstalled(applicationContext, str);
        } else {
            isWeishiInstalled = isWeishiInstalled(applicationContext);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (isWeishiInstalled) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.put("result", i3);
            if (z16) {
                invokeCallJS(promise, jSONObject);
            } else {
                doPromiseCallback(promise, jSONObject);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "hasApp error" + e16.getMessage());
            }
        }
    }

    public void invoke(JSONObject jSONObject, Promise promise) {
        String callbackId = getCallbackId(promise);
        String optString = jSONObject.optString("ns");
        String optString2 = jSONObject.optString("method");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            getFragment();
            if (QZoneDTLoginReporter.SCHEMA.equals(optString) && "jumpAction".equals(optString2)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                if (optJSONObject == null) {
                    invokeErrorCallJS(callbackId, "params is null");
                    return;
                } else if (!optJSONObject.has(QZoneDTLoginReporter.SCHEMA)) {
                    invokeErrorCallJS(callbackId, "schema is null");
                    return;
                } else {
                    invokeErrorCallJS(callbackId, "fragment is null");
                    return;
                }
            }
            if (SensorJsPlugin.SENSOR_INTERVAL_UI.equals(optString) && "setNavBtn".equals(optString2)) {
                invokeErrorCallJS(callbackId, "fragment or params is null");
                return;
            } else {
                invoke(jSONObject, callbackId);
                return;
            }
        }
        invokeErrorCallJS(callbackId, HardCodeUtil.qqStr(R.string.zg8));
        QLog.d(TAG, 1, "ns or method not exists");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.g
    public void invokeCallJS(String str, Object obj) {
        Object promise;
        if (TextUtils.isEmpty(str) || (promise = getPromise(str)) == null || !(promise instanceof Promise)) {
            return;
        }
        invokeCallJS((Promise) promise, obj);
        removePromise(str);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.g
    public void invokeErrorCallJS(String str, String str2) {
        Object promise;
        if (TextUtils.isEmpty(str) || (promise = getPromise(str)) == null || !(promise instanceof Promise)) {
            return;
        }
        invokeErrorCallJS((Promise) promise, str2);
        removePromise(str);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.g
    public void invokeJS(String str, JSONObject jSONObject) {
        Object promise;
        if (TextUtils.isEmpty(str) || (promise = getPromise(str)) == null || !(promise instanceof Promise)) {
            return;
        }
        invokeJS((Promise) promise, jSONObject);
        removePromise(str);
    }

    public boolean isWeishiInstalled(Context context) {
        if (context == null) {
            return false;
        }
        try {
            com.tencent.util.pm.PackageUtil.getPackageInfo(context, WEISHI_PAKG_NAME);
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 2, "ErrorMsg:" + th5.getLocalizedMessage());
            return false;
        }
    }

    public void openAddVideoView(JSONObject jSONObject, Promise promise) {
        openAddVideoView(jSONObject, getCallbackId(promise));
    }

    public void openTopicVideoComment(JSONObject jSONObject, Promise promise) {
        getCallbackId(promise);
    }

    public void openUserLevelDialog(JSONObject jSONObject, Promise promise) {
        openLevelDialog(jSONObject, getCallbackId(promise));
    }

    public void pauseUploadingVideo(JSONObject jSONObject, Promise promise) {
        pauseUploadingVideo(jSONObject, getCallbackId(promise));
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.a, com.tencent.mobileqq.qqecommerce.biz.hr.api.c, com.tencent.mobileqq.qqecommerce.biz.hr.api.g
    public void popBack(final String str) {
        HippyQQEngine.runTaskInUIThread(new Runnable() { // from class: com.tencent.hippy.qq.module.QQBridgeModule.4
            @Override // java.lang.Runnable
            public void run() {
                QQBridgeModule.this.popBackImpl(str);
            }
        });
    }

    public void resumeUploadingVideo(JSONObject jSONObject, Promise promise) {
        resumeUploadingVideo(jSONObject, getCallbackId(promise));
    }

    public void setEngineId(int i3) {
        this.mEngineId = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNavBtn(JSONObject jSONObject, Promise promise) {
        getCallbackId(promise);
        getFragment();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.a, com.tencent.mobileqq.qqecommerce.biz.hr.api.c
    public void setTitle(final JSONObject jSONObject, final String str) {
        HippyQQEngine.runTaskInUIThread(new Runnable() { // from class: com.tencent.hippy.qq.module.QQBridgeModule.3
            @Override // java.lang.Runnable
            public void run() {
                QQBridgeModule.this.setTitleImpl(jSONObject, str);
            }
        });
    }

    public void shareVideoWithFriend(JSONObject jSONObject, Promise promise) {
        shareVideoWithFriend(jSONObject, getCallbackId(promise));
    }

    public void shareVideoWithGPro(JSONObject jSONObject, Promise promise) {
        shareVideoWithGPro(jSONObject, getCallbackId(promise));
    }

    public void vaNetworkChange(final Promise promise) {
        if (this.netInfoHandler == null) {
            this.netInfoHandler = new INetInfoHandler() { // from class: com.tencent.hippy.qq.module.QQBridgeModule.1
                @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
                public void onNetMobile2None() {
                    if (QLog.isColorLevel()) {
                        QLog.i(QQBridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_NONE");
                    }
                    QQBridgeModule.this.getNetType(promise, false);
                }

                @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
                public void onNetMobile2Wifi(String str) {
                    if (QLog.isColorLevel()) {
                        QLog.i(QQBridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_WIFI,ssid=" + str);
                    }
                    QQBridgeModule.this.getNetType(promise, false);
                }

                @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
                public void onNetNone2Mobile(String str) {
                    if (QLog.isColorLevel()) {
                        QLog.i(QQBridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_XG,ssid=" + str);
                    }
                    QQBridgeModule.this.getNetType(promise, false);
                }

                @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
                public void onNetNone2Wifi(String str) {
                    if (QLog.isColorLevel()) {
                        QLog.i(QQBridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_WIFI,ssid=" + str);
                    }
                    QQBridgeModule.this.getNetType(promise, false);
                }

                @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
                public void onNetWifi2Mobile(String str) {
                    if (QLog.isColorLevel()) {
                        QLog.i(QQBridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_XG,ssid=" + str);
                    }
                    QQBridgeModule.this.getNetType(promise, false);
                }

                @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
                public void onNetWifi2None() {
                    if (QLog.isColorLevel()) {
                        QLog.i(QQBridgeModule.TAG, 2, "INetInfoHandler onNetNone2Wifi():NET_NONE");
                    }
                    QQBridgeModule.this.getNetType(promise, false);
                }
            };
            AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext().getApplicationContext(), this.netInfoHandler);
        }
    }

    public void videoPlayFeedback(JSONObject jSONObject, Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "do videoPlayFeedback start data: " + jSONObject.toString());
        }
        ((IPlayFeedbackHelper) QRoute.api(IPlayFeedbackHelper.class)).feedbackViolaCall(null, jSONObject);
        if (getViolaInstance() != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("success", 1);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            doPromiseCallback(promise, jSONObject2);
        }
    }

    public void invokeCallJS(Promise promise, Object obj) {
        if (promise == null || !promise.isCallback()) {
            return;
        }
        JSONObject succInvokeObj = getSuccInvokeObj(obj);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushJSONObject(succInvokeObj);
        promise.resolve(hippyMap);
    }

    public void invokeErrorCallJS(Promise promise, String str) {
        invokeJS(promise, getFailInvokeObj(str));
    }

    public void invokeJS(Promise promise, JSONObject jSONObject) {
        if (promise == null || !promise.isCallback()) {
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushJSONObject(jSONObject);
        promise.resolve(hippyMap);
    }

    public void isKindCard(Promise promise) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleImpl(JSONObject jSONObject, String str) {
    }
}
