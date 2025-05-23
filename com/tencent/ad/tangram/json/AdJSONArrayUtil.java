package com.tencent.ad.tangram.json;

import com.qzone.misc.network.uploader.report.BusinessReport;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdJSONArrayUtil {
    private static final String TAG = "AdJSONArrayUtil";

    public static <T> ArrayList<T> arrayToList(JSONArray jSONArray, Class<T> cls) {
        if (isEmpty(jSONArray)) {
            AdLog.e(TAG, "[arrayToList] jsonArray error");
            return null;
        }
        if (cls == null) {
            AdLog.e(TAG, "[arrayToList] clazz error");
            return null;
        }
        BusinessReport.AnonymousClass1 anonymousClass1 = (ArrayList<T>) new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                Object opt = jSONArray.opt(i3);
                if (opt != null && opt.getClass() == cls) {
                    anonymousClass1.add((BusinessReport.AnonymousClass1) opt);
                }
            } catch (Throwable th5) {
                AdLog.e(TAG, "[arrayToList]", th5);
            }
        }
        return anonymousClass1;
    }

    public static boolean isEmpty(JSONArray jSONArray) {
        if (jSONArray != null && !JSONObject.NULL.equals(jSONArray) && jSONArray.length() > 0) {
            return false;
        }
        return true;
    }

    public static int length(JSONArray jSONArray) {
        if (!isEmpty(jSONArray)) {
            try {
                return jSONArray.length();
            } catch (Throwable th5) {
                AdLog.e(TAG, "[length]", th5);
            }
        }
        return 0;
    }

    public static JSONArray newJSONArray() {
        try {
            return new JSONArray();
        } catch (Throwable th5) {
            AdLog.e(TAG, "[newJSONArray]", th5);
            return null;
        }
    }

    public static JSONObject optJSONObject(JSONArray jSONArray, int i3) {
        if (!isEmpty(jSONArray)) {
            try {
                return jSONArray.optJSONObject(i3);
            } catch (Throwable th5) {
                AdLog.e(TAG, "[optString]", th5);
            }
        }
        return null;
    }

    public static String optString(JSONArray jSONArray, int i3, String str) {
        if (isEmpty(jSONArray)) {
            return null;
        }
        if (i3 >= 0 && i3 < jSONArray.length()) {
            try {
                return jSONArray.optString(i3, str);
            } catch (Throwable th5) {
                AdLog.e(TAG, "[optString]", th5);
                return null;
            }
        }
        AdLog.e(TAG, "[optString] error, index out of bounds");
        return null;
    }

    public static JSONArray put(JSONArray jSONArray, Object obj) {
        if (jSONArray != null) {
            try {
                jSONArray.mo162put(obj);
            } catch (Throwable th5) {
                AdLog.e(TAG, "[put]", th5);
            }
        }
        return jSONArray;
    }

    public static JSONArray newJSONArray(String str) {
        try {
            return new JSONArray(str);
        } catch (Throwable th5) {
            AdLog.e(TAG, "[newJSONArray]", th5);
            return null;
        }
    }
}
