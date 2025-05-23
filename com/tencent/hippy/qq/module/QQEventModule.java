package com.tencent.hippy.qq.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = "QQEventModule")
/* loaded from: classes7.dex */
public class QQEventModule extends QQBaseModule {
    private static final long BROADCAST_DATA_MAX_SIZE = 460800;
    static final String CLASSNAME = "QQEventModule";
    private static final String TAG = "QQEventModule";
    private static volatile BroadcastReceiver sDispatchEventReceiver;
    public static AtomicInteger sPageCount = new AtomicInteger(0);

    public QQEventModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        init();
    }

    private void broadcast2WebView(HippyMap hippyMap) {
        String str;
        JSONObject jSONObject;
        boolean z16;
        try {
            String string = hippyMap.getString("event");
            if (TextUtils.isEmpty(string)) {
                QLog.w("QQEventModule", 2, "param event is requested");
                return;
            }
            String string2 = hippyMap.getString("data");
            if (string2 == null) {
                str = "";
            } else {
                str = string2;
            }
            if (!TextUtils.isEmpty(str) && str.length() >= BROADCAST_DATA_MAX_SIZE) {
                QLog.e("QQEventModule", 1, "param data is over size! " + str.length());
                return;
            }
            String string3 = hippyMap.getString("options");
            if (!TextUtils.isEmpty(string3)) {
                jSONObject = new JSONObject(string3);
            } else {
                jSONObject = null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            if (jSONObject != null) {
                z16 = jSONObject.optBoolean("broadcast", true);
                JSONArray optJSONArray = jSONObject.optJSONArray("domains");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String optString = optJSONArray.optString(i3);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                }
            } else {
                z16 = true;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("url", "");
            Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            intent.putExtra("broadcast", z16);
            intent.putExtra("event", string);
            if (string2 != null) {
                intent.putExtra("data", string2);
            }
            intent.putStringArrayListExtra("domains", arrayList);
            intent.putExtra("source", jSONObject2.toString());
            BaseApplication.getContext().getApplicationContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
            if (QLog.isColorLevel()) {
                QLog.d("QQEventModule", 2, "dispatchEvent:" + hippyMap.toJSONObject().toString());
            }
        } catch (Exception e16) {
            QLog.e("QQEventModule", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDispatchEvent(Context context, Intent intent) {
        if (!intent.getBooleanExtra("broadcast", true)) {
            return;
        }
        String stringExtra = intent.getStringExtra("event");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        String stringExtra2 = intent.getStringExtra("data");
        if (QLog.isColorLevel()) {
            QLog.d("QQEventModule", 2, "checkDispatchEvent event:" + stringExtra + " dataStr:" + stringExtra2);
        }
        if (stringExtra2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra2);
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushJSONObject(jSONObject);
                HippyQQEngine.dispatchEvent(stringExtra, null, hippyMap);
            } catch (JSONException e16) {
                QLog.e("QQEventModule", 1, e16, new Object[0]);
            }
        }
    }

    private void init() {
        if (sPageCount.getAndIncrement() == 0 && sDispatchEventReceiver == null) {
            sDispatchEventReceiver = new BroadcastReceiver() { // from class: com.tencent.hippy.qq.module.QQEventModule.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQEventModule", 2, "init onReceive getAction:" + intent.getAction());
                    }
                    QQEventModule.this.checkDispatchEvent(context, intent);
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            BaseApplication.getContext().getApplicationContext().registerReceiver(sDispatchEventReceiver, intentFilter, "com.tencent.msg.permission.pushnotify", null);
            QLog.i("QQEventModule", 1, "init registerReceiver sDispatchEventReceiver");
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        if (sPageCount.decrementAndGet() == 0 && sDispatchEventReceiver != null) {
            BaseApplication.getContext().getApplicationContext().unregisterReceiver(sDispatchEventReceiver);
            sDispatchEventReceiver = null;
            QLog.i("QQEventModule", 1, "destroy unregisterReceiver sDispatchEventReceiver");
        }
    }

    @HippyMethod(name = "dispatchEvent")
    public void dispatchEvent(String str, String str2, HippyMap hippyMap) {
        HippyQQEngine.dispatchEvent(str, str2, hippyMap);
        if (hippyMap != null && hippyMap.getBoolean("toWebView")) {
            broadcast2WebView(hippyMap);
        }
    }

    @HippyMethod(name = "dispatchEventToHippy")
    public void dispatchEventToHippy(String str, String str2, HippyMap hippyMap) {
        HippyQQEngine.dispatchEvent(str, str2, hippyMap);
    }
}
