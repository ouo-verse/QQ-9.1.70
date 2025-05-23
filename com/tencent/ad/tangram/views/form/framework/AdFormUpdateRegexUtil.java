package com.tencent.ad.tangram.views.form.framework;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.views.form.AdFormData;
import com.tencent.ad.tangram.views.form.textbox.AdFormItemTextBoxData;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdFormUpdateRegexUtil {
    private static final String TAG = "AdFormUpdateRegexUtil";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Params extends AdHttp.Params {
        public int returnCode;

        Params() {
            this.returnCode = Integer.MIN_VALUE;
        }

        @Override // com.tencent.ad.tangram.net.AdHttp.Params
        public boolean isSuccess() {
            if (super.isSuccess() && this.responseData != null) {
                return true;
            }
            return false;
        }
    }

    @NonNull
    private static Params getRequestParams() {
        Params params = new Params();
        params.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
        params.method = "GET";
        params.contentType = "application/json";
        params.connectTimeoutMillis = 5000;
        params.readTimeoutMillis = 5000;
        return params;
    }

    @Nullable
    private static Map<Integer, String> parseRegex(@Nullable Params params, @NonNull JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (params != null) {
            try {
                if (!AdJSONUtil.isJSONObjectNull(jSONObject)) {
                    params.returnCode = jSONObject.getInt("code");
                    AdLog.i(TAG, "onResponse code:" + params.returnCode + " message:" + jSONObject.optString("message"));
                    if (params.returnCode == 0) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        if (!AdJSONUtil.isJSONObjectNull(jSONObject2)) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("regexMap");
                            if (!AdJSONUtil.isJSONObjectNull(jSONObject3)) {
                                Iterator keys = jSONObject3.keys();
                                while (keys.hasNext()) {
                                    String str = (String) keys.next();
                                    if (!TextUtils.isEmpty(str)) {
                                        Integer valueOf = Integer.valueOf(str);
                                        String string = jSONObject3.getString(str);
                                        if (!TextUtils.isEmpty(string)) {
                                            hashMap.put(valueOf, string);
                                        }
                                    }
                                }
                                return hashMap;
                            }
                        }
                    }
                }
            } catch (JSONException e16) {
                AdLog.e(TAG, "parseRegex", e16);
            } catch (Throwable th5) {
                AdLog.e(TAG, "parseRegex", th5);
            }
        }
        AdLog.e(TAG, "parseRegex error");
        return null;
    }

    private static void parseResponse(@Nullable WeakReference<AdFormData> weakReference, @Nullable Params params) {
        Map<Integer, String> parseRegex;
        if (params != null && params.isSuccess() && params.responseData != null && weakReference != null && weakReference.get() != null && weakReference.get().isValid()) {
            try {
                Charset forName = Charset.forName("UTF-8");
                if (forName != null) {
                    String str = new String(params.responseData, forName);
                    if (!TextUtils.isEmpty(str) && (parseRegex = parseRegex(params, new JSONObject(str))) != null) {
                        for (int i3 = 0; i3 < weakReference.get().table.getSize(); i3++) {
                            AdFormItemData item = weakReference.get().table.getItem(i3);
                            if (item != null && item.isValid()) {
                                if (item instanceof AdFormItemTextBoxData) {
                                    AdFormItemTextBoxData adFormItemTextBoxData = (AdFormItemTextBoxData) AdFormItemTextBoxData.class.cast(item);
                                    if (adFormItemTextBoxData == null) {
                                        AdLog.e(TAG, "parseResponse error");
                                    } else {
                                        int i16 = adFormItemTextBoxData.regexType;
                                        if (i16 != Integer.MIN_VALUE) {
                                            if (!parseRegex.containsKey(Integer.valueOf(i16))) {
                                                AdLog.e(TAG, "parseResponse error");
                                            } else {
                                                adFormItemTextBoxData.regex = parseRegex.get(Integer.valueOf(adFormItemTextBoxData.regexType));
                                            }
                                        }
                                    }
                                }
                            }
                            AdLog.e(TAG, "parseResponse error");
                        }
                        return;
                    }
                }
            } catch (JSONException e16) {
                AdLog.e(TAG, "parseResponse", e16);
            } catch (Throwable th5) {
                AdLog.e(TAG, "parseResponse", th5);
            }
        }
        AdLog.e(TAG, "parseResponse error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void update(WeakReference<AdFormData> weakReference) {
        Params requestParams;
        for (int i3 = 0; i3 < 3 && (requestParams = getRequestParams()) != null; i3++) {
            AdHttp.send(requestParams);
            parseResponse(weakReference, requestParams);
            if (requestParams.isSuccess() && requestParams.returnCode == 0) {
                return;
            }
        }
        AdLog.e(TAG, "update error");
    }

    public static void updateAsync(final WeakReference<AdFormData> weakReference) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.form.framework.AdFormUpdateRegexUtil.1
            @Override // java.lang.Runnable
            public void run() {
                AdFormUpdateRegexUtil.update(weakReference);
            }
        }, 3);
    }
}
