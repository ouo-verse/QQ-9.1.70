package com.tencent.mobileqq.tvideo.webview;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes19.dex */
public class TVideoPublicJsPlugin extends WebViewPlugin {
    private static final String NameSpace = "tvideoPublicAccount";
    private static final String TAG = "TVideoPublicJsPlugin";

    private Map<String, Object> getArgsFromArgs(String[] strArr) throws JSONException {
        HashMap hashMap = new HashMap();
        if (strArr != null && strArr.length != 0) {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String optString = jSONObject.optString(str);
                hashMap.put(str, optString);
                QLog.i(TAG, 1, "getArgsFromArgs  key = " + str + " value = " + optString);
            }
        }
        return hashMap;
    }

    private Map<String, Object> getArgsFromUrl(String str) throws UnsupportedEncodingException {
        String[] split;
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap();
        if (parse == null) {
            return hashMap;
        }
        for (String str2 : parse.getEncodedQuery().split(ContainerUtils.FIELD_DELIMITER)) {
            if (!TextUtils.isEmpty(str2) && (split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length > 1) {
                hashMap.put(split[0], URLDecoder.decode(split[1], "UTF-8"));
            }
        }
        return hashMap;
    }

    private void parseJsRequest(String str, Map<String, Object> map) throws JSONException {
        Object obj;
        CustomWebView customWebView;
        String jSONObject;
        boolean equals = TextUtils.equals(String.valueOf(map.get(ISchemeApi.KEY_IOS_SRC_TYPE)), "hippy");
        if (equals) {
            obj = map.get("callback");
        } else {
            obj = map.get("callback_name");
        }
        String str2 = (String) obj;
        QLog.i(TAG, 1, "parseJsRequest isFromHippy:" + equals + " ,callback:" + str2);
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            customWebView = bVar.e();
        } else {
            customWebView = null;
        }
        JSONObject o16 = d.o(str, map, customWebView, true);
        if (!TextUtils.isEmpty(str2)) {
            String[] strArr = new String[1];
            if (o16 == null) {
                jSONObject = "";
            } else {
                jSONObject = o16.toString();
            }
            strArr[0] = jSONObject;
            callJs(str2, strArr);
            QLog.i(TAG, 1, "callJs callback = " + str2 + " result = " + o16);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NonNull
    public String getNameSpace() {
        return NameSpace;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        Map<String, Object> argsFromUrl;
        if (NameSpace.equals(str2)) {
            QLog.i(TAG, 1, "handleJsRequest:" + str);
            try {
            } catch (Exception e16) {
                QLog.i(TAG, 1, e16.toString());
            }
            if (!TextUtils.isEmpty(str) && (argsFromUrl = getArgsFromUrl(str)) != null && argsFromUrl.size() > 0) {
                QLog.i(TAG, 1, "getArgsFromUrl");
                parseJsRequest(str3, argsFromUrl);
                return true;
            }
            QLog.i(TAG, 1, "getArgsFromArgs");
            parseJsRequest(str3, getArgsFromArgs(strArr));
            return true;
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }
}
