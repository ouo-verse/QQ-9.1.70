package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.IJsHandler;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseJsReportHandler extends BaseJsHandler implements IJsHandler {
    private static final String KEY_APP_KEY = "appKey";
    private static final String KEY_EVENT_ID = "eventId";
    private static final String KEY_PARAMS = "params";
    private static final String TAG = "jsbridge.JsReportHandler";

    public BaseJsReportHandler(WeakReference<Object> weakReference) {
        super(weakReference);
    }

    private String getAppKey(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString("appKey", "");
    }

    private String getEventId(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString(KEY_EVENT_ID, "");
    }

    private JSONObject getParams(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject("params");
    }

    private void reportEvent(String str, Map<String, Object> map, String str2, String str3) {
        boolean reportEventWithoutFormat;
        if (TextUtils.isEmpty(str2)) {
            reportEventWithoutFormat = VideoReportInner.getInstance().reportEvent(str, getRealWebView(), map);
        } else {
            reportEventWithoutFormat = VideoReportInner.getInstance().reportEventWithoutFormat(str, map, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (reportEventWithoutFormat) {
                callback(str3, "200", "success", null);
            } else {
                callback(str3, "500", "fail", null);
            }
        }
    }

    private Map<String, Object> wrapJsonToMap(JSONObject jSONObject) {
        String str;
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String valueOf = String.valueOf(keys.next());
            try {
                str = jSONObject.get(valueOf).toString();
            } catch (JSONException e16) {
                Log.e(TAG, "wrapJsonToMap(), error: " + e16);
                str = null;
            }
            hashMap.put(valueOf, str);
        }
        return hashMap;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.IJsHandler
    public void handle(String str, JSONObject jSONObject) {
        String eventId = getEventId(jSONObject);
        String appKey = getAppKey(jSONObject);
        JSONObject params = getParams(jSONObject);
        if (TextUtils.isEmpty(eventId)) {
            return;
        }
        reportEvent(eventId, wrapJsonToMap(params), appKey, BaseJsHandler.getCallbackId(jSONObject));
    }
}
