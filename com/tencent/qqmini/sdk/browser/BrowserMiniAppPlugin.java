package com.tencent.qqmini.sdk.browser;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class BrowserMiniAppPlugin extends BrowserPlugin {
    public static final String NAME_SPACE = "miniApp";
    public static final String TAG = "BrowserMiniAppPlugin";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqmini.sdk.browser.BrowserPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        String str2;
        Activity activity;
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay") && map != null && j3 == 1 && map.containsKey("errorCode")) {
                int intValue = ((Integer) map.get("errorCode")).intValue();
                QMLog.i(TAG, "paybyh5 handleEvent EVENT_RECEIVER_HTTP_ERROR errorCode:" + intValue);
                if (map.containsKey(BrowserPlugin.KEY_REQUEST_URL)) {
                    str2 = (String) map.get(BrowserPlugin.KEY_REQUEST_URL);
                } else {
                    str2 = "";
                }
                QMLog.i(TAG, "paybyh5 handleEvent realUrlStr:" + str2);
                if (!TextUtils.isEmpty(str2) && str2.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay")) {
                    Intent intent = new Intent();
                    intent.putExtra("errCode", -3);
                    intent.putExtra("errMsg", "EVENT_RECEIVER_HTTP_ERROR\uff1a" + intValue);
                    intent.putExtra(ImageTaskConst.ERROR_TYPE, 1L);
                    WeakReference<Activity> weakReference = this.mActivity;
                    if (weakReference != null) {
                        activity = weakReference.get();
                    } else {
                        activity = null;
                    }
                    if (activity != null) {
                        activity.setResult(-1, intent);
                        activity.finish();
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleEvent error.", th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqmini.sdk.browser.BrowserPlugin
    public boolean handleJsRequest(String str, String str2, String str3, String... strArr) {
        Activity activity;
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str2 != null && str2.equalsIgnoreCase("miniApp") && str3 != null) {
            WeakReference<Activity> weakReference = this.mActivity;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (this.mActivity != null && str3.equals("payCallback")) {
                try {
                    JSONObject jsonFromJSBridge = BrowserPlugin.getJsonFromJSBridge(str);
                    QMLog.w(TAG, "payCallback: " + jsonFromJSBridge);
                    Intent intent = new Intent();
                    if (jsonFromJSBridge == null) {
                        intent.putExtra("errCode", -1);
                        intent.putExtra("errMsg", "\u652f\u4ed8\u5931\u8d25\uff1a\u65e0\u652f\u4ed8\u4fe1\u606f\u3002");
                    } else {
                        intent.putExtra("errCode", jsonFromJSBridge.optInt("errCode"));
                        intent.putExtra("errMsg", jsonFromJSBridge.optString("errMsg"));
                        intent.putExtra("tipMsg", jsonFromJSBridge.optString("tipMsg"));
                    }
                    if (activity != null) {
                        activity.setResult(-1, intent);
                        activity.finish();
                        return true;
                    }
                    return true;
                } catch (Throwable th5) {
                    QMLog.e(TAG, "payCallback error.", th5);
                    return true;
                }
            }
        }
        return false;
    }
}
