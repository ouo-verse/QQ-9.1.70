package com.tencent.hippy.qq.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQEventCenterModule.CLASSNAME)
/* loaded from: classes7.dex */
public class QQEventCenterModule extends QQBaseModule {
    private static final String ACTION_BROADCAST_HIPPY_EVENT = "com.tencent.mobileqq.action.ACTION_BROADCAST_HIPPY_EVENT";
    private static final long BROADCAST_DATA_MAX_SIZE = 460800;
    static final String CLASSNAME = "QQEventCenterModule";
    public static final int EVENT_TYPE_HIPPY = 1;
    public static final int EVENT_TYPE_KUIKLY = 3;
    public static final int EVENT_TYPE_WEB_VIEW = 2;
    public static final String KEY_IS_FROM_HIPPY = "isFromHippy";
    public static final String KEY_MODULES = "hippy_modules";
    private final ArrayList<String> mHippyEventNameList;
    private BroadcastReceiver mHippyEventReceiver;
    private final ArrayList<String> mKuiklyEventNameList;
    private BroadcastReceiver mKuiklyEventReceiver;
    private final ArrayList<String> mWebViewEventNameList;
    private BroadcastReceiver mWebViewEventReceiver;

    public QQEventCenterModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.mWebViewEventNameList = new ArrayList<>();
        this.mHippyEventNameList = new ArrayList<>();
        this.mKuiklyEventNameList = new ArrayList<>();
        this.mWebViewEventReceiver = null;
        this.mHippyEventReceiver = null;
        this.mKuiklyEventReceiver = null;
    }

    private ArrayList<String> convertToArrayList(HippyArray hippyArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (hippyArray != null) {
            for (int i3 = 0; i3 < hippyArray.size(); i3++) {
                arrayList.add(hippyArray.getString(i3));
            }
        }
        return arrayList;
    }

    private String convertToBroadcastData(HippyMap hippyMap) {
        String str;
        if (hippyMap != null) {
            str = hippyMap.toJSONObject().toString();
        } else {
            str = null;
        }
        if (str != null && str.length() >= BROADCAST_DATA_MAX_SIZE) {
            QLog.e(CLASSNAME, 1, "Broadcast data is over size! ", Integer.valueOf(str.length()));
            return null;
        }
        return str;
    }

    private HippyMap convertToHippyMap(String str) {
        HippyMap hippyMap = new HippyMap();
        if (!TextUtils.isEmpty(str)) {
            try {
                hippyMap.pushJSONObject(new JSONObject(str));
            } catch (JSONException e16) {
                QLog.e(CLASSNAME, 1, "convertToHippyMap json error:", e16);
            }
        }
        return hippyMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReceiveHippyEvent(Intent intent) {
        String stringExtra = intent.getStringExtra("event");
        String stringExtra2 = intent.getStringExtra("data");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        synchronized (this.mHippyEventNameList) {
            if (!this.mHippyEventNameList.contains(stringExtra)) {
                return;
            }
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(KEY_MODULES);
            if (stringArrayListExtra != null && stringArrayListExtra.contains(getBundleName())) {
                if (QLog.isColorLevel()) {
                    QLog.d(CLASSNAME, 2, "onReceiveHippyEvent event:", stringExtra, " data:", stringExtra2);
                }
                sendEventToJS(1, stringExtra, stringExtra2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReceiveKuiklyEvent(Intent intent) {
        String stringExtra = intent.getStringExtra(AdMetricTag.EVENT_NAME);
        String stringExtra2 = intent.getStringExtra("data");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        synchronized (this.mKuiklyEventNameList) {
            if (!this.mKuiklyEventNameList.contains(stringExtra)) {
                return;
            }
            if (!toJSONObject(stringExtra2).optString(KEY_MODULES).contains(getBundleName())) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(CLASSNAME, 2, "onReceiveHippyEvent event:", stringExtra, " data:", stringExtra2);
            }
            sendEventToJS(3, stringExtra, stringExtra2);
        }
    }

    private void registerHippyEvent(String str) {
        synchronized (this.mHippyEventNameList) {
            if (!this.mHippyEventNameList.contains(str)) {
                this.mHippyEventNameList.add(str);
            }
            if (this.mHippyEventReceiver == null) {
                registerHippyEventReceiver();
            }
        }
    }

    private void registerHippyEventReceiver() {
        this.mHippyEventReceiver = new BroadcastReceiver() { // from class: com.tencent.hippy.qq.module.QQEventCenterModule.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                QQEventCenterModule.this.onReceiveHippyEvent(intent);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_BROADCAST_HIPPY_EVENT);
        BaseApplication.getContext().getApplicationContext().registerReceiver(this.mHippyEventReceiver, intentFilter, "com.tencent.msg.permission.pushnotify", null);
    }

    private void registerKuiklyEvent(String str) {
        synchronized (this.mKuiklyEventNameList) {
            if (!this.mKuiklyEventNameList.contains(str)) {
                this.mKuiklyEventNameList.add(str);
            }
            if (this.mKuiklyEventReceiver == null) {
                registerKuiklyEventReceiver();
            }
        }
    }

    private void registerKuiklyEventReceiver() {
        this.mKuiklyEventReceiver = new BroadcastReceiver() { // from class: com.tencent.hippy.qq.module.QQEventCenterModule.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                QQEventCenterModule.this.onReceiveKuiklyEvent(intent);
            }
        };
        com.tencent.kuikly.core.render.android.expand.module.l.c(BaseApplication.getContext().getApplicationContext(), this.mKuiklyEventReceiver);
    }

    private void registerWebViewEvent(String str) {
        synchronized (this.mWebViewEventNameList) {
            if (!this.mWebViewEventNameList.contains(str)) {
                this.mWebViewEventNameList.add(str);
            }
            if (this.mWebViewEventReceiver == null) {
                registerWebViewEventReceiver();
            }
        }
    }

    private void registerWebViewEventReceiver() {
        this.mWebViewEventReceiver = new BroadcastReceiver() { // from class: com.tencent.hippy.qq.module.QQEventCenterModule.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                QQEventCenterModule.this.onReceiveWebViewEvent(intent);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        BaseApplication.getContext().getApplicationContext().registerReceiver(this.mWebViewEventReceiver, intentFilter, "com.tencent.msg.permission.pushnotify", null);
    }

    private void sendEventToJS(int i3, String str, String str2) {
        HippyMap convertToHippyMap = convertToHippyMap(str2);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("eventType", i3);
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushMap("data", convertToHippyMap);
        hippyMap2.pushMap("from", hippyMap);
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine != null) {
            hippyQQEngine.sendEvent(str, hippyMap2);
        } else {
            QLog.e(CLASSNAME, 1, "sendEventToJS engine is null");
        }
    }

    private JSONObject toJSONObject(String str) {
        if (str == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e16) {
            QLog.e(CLASSNAME, 1, "toJSONObject error: " + e16);
            return new JSONObject();
        }
    }

    private void unregisterHippyEvent(String str) {
        synchronized (this.mHippyEventNameList) {
            this.mHippyEventNameList.remove(str);
        }
    }

    private void unregisterKuiklyEvent(String str) {
        synchronized (this.mKuiklyEventNameList) {
            this.mKuiklyEventNameList.remove(str);
        }
    }

    private void unregisterWebViewEvent(String str) {
        synchronized (this.mWebViewEventNameList) {
            this.mWebViewEventNameList.remove(str);
        }
    }

    @HippyMethod(name = "addObserver")
    public void addObserver(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    QLog.e(CLASSNAME, 1, "addObserver unknown Event Type:", Integer.valueOf(i3));
                } else {
                    registerKuiklyEvent(str);
                }
            } else {
                registerWebViewEvent(str);
            }
        } else {
            registerHippyEvent(str);
        }
        if (QLog.isColorLevel()) {
            QLog.d(CLASSNAME, 2, "addObserver eventName:", str, " eventType:", Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        BroadcastReceiver broadcastReceiver = this.mWebViewEventReceiver;
        if (broadcastReceiver != null) {
            applicationContext.unregisterReceiver(broadcastReceiver);
        }
        BroadcastReceiver broadcastReceiver2 = this.mHippyEventReceiver;
        if (broadcastReceiver2 != null) {
            applicationContext.unregisterReceiver(broadcastReceiver2);
        }
        BroadcastReceiver broadcastReceiver3 = this.mKuiklyEventReceiver;
        if (broadcastReceiver3 != null) {
            com.tencent.kuikly.core.render.android.expand.module.l.f(applicationContext, broadcastReceiver3);
        }
        super.destroy();
    }

    @HippyMethod(name = "dispatchEventToHippy")
    public void dispatchEventToHippy(String str, HippyArray hippyArray, HippyMap hippyMap) {
        if (!TextUtils.isEmpty(str) && hippyArray != null && hippyArray.size() > 0) {
            Intent intent = new Intent(ACTION_BROADCAST_HIPPY_EVENT);
            intent.setPackage("com.tencent.mobileqq");
            intent.putExtra("event", str);
            intent.putStringArrayListExtra(KEY_MODULES, convertToArrayList(hippyArray));
            String convertToBroadcastData = convertToBroadcastData(hippyMap);
            if (convertToBroadcastData != null) {
                intent.putExtra("data", convertToBroadcastData);
            }
            BaseApplication.getContext().getApplicationContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
            if (QLog.isColorLevel()) {
                QLog.d(CLASSNAME, 2, "dispatchEventToHippy eventName:", str, " data:", convertToBroadcastData);
            }
        }
    }

    @HippyMethod(name = "dispatchEventToKuikly")
    public void dispatchEventToKuikly(String str, HippyMap hippyMap) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String convertToBroadcastData = convertToBroadcastData(hippyMap);
        com.tencent.kuikly.core.render.android.expand.module.l.e(BaseApplication.getContext().getApplicationContext(), str, toJSONObject(convertToBroadcastData));
        if (QLog.isColorLevel()) {
            QLog.d(CLASSNAME, 2, "dispatchEventToKuikly eventName:", str, " data:", convertToBroadcastData);
        }
    }

    @HippyMethod(name = "dispatchEventToWeb")
    public void dispatchEventToWeb(String str, HippyArray hippyArray, HippyMap hippyMap) {
        if (!TextUtils.isEmpty(str) && hippyArray != null && hippyArray.size() > 0) {
            Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            intent.setPackage("com.tencent.mobileqq");
            intent.putExtra("broadcast", true);
            intent.putExtra("event", str);
            intent.putExtra(KEY_IS_FROM_HIPPY, true);
            intent.putStringArrayListExtra("domains", convertToArrayList(hippyArray));
            String convertToBroadcastData = convertToBroadcastData(hippyMap);
            if (convertToBroadcastData != null) {
                intent.putExtra("data", convertToBroadcastData);
            }
            BaseApplication.getContext().getApplicationContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
            if (QLog.isColorLevel()) {
                QLog.d(CLASSNAME, 2, "dispatchEventToWeb eventName:", str, " data:", convertToBroadcastData);
            }
        }
    }

    protected void onReceiveWebViewEvent(Intent intent) {
        if (intent.getBooleanExtra(KEY_IS_FROM_HIPPY, false)) {
            return;
        }
        String stringExtra = intent.getStringExtra("event");
        String stringExtra2 = intent.getStringExtra("data");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        synchronized (this.mWebViewEventNameList) {
            if (!this.mWebViewEventNameList.contains(stringExtra)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(CLASSNAME, 2, "onReceiveWebViewEvent event:", stringExtra, " data:", stringExtra2);
            }
            sendEventToJS(2, stringExtra, stringExtra2);
        }
    }

    @HippyMethod(name = "removeObserver")
    public void removeObserver(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    QLog.e(CLASSNAME, 1, "removeObserver unknown Event Type:", Integer.valueOf(i3));
                } else {
                    unregisterKuiklyEvent(str);
                }
            } else {
                unregisterWebViewEvent(str);
            }
        } else {
            unregisterHippyEvent(str);
        }
        if (QLog.isColorLevel()) {
            QLog.d(CLASSNAME, 2, "removeObserver eventName:", str, " eventType:", Integer.valueOf(i3));
        }
    }
}
