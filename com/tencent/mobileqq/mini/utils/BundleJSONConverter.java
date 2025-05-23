package com.tencent.mobileqq.mini.utils;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/mini/utils/BundleJSONConverter;", "", "()V", "TAG", "", "jsonToBundle", "Landroid/os/Bundle;", "jsonStr", "jsonObj", "Lorg/json/JSONObject;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class BundleJSONConverter {
    public static final BundleJSONConverter INSTANCE = new BundleJSONConverter();
    public static final String TAG = "BundleJSONConverter";

    BundleJSONConverter() {
    }

    @JvmStatic
    public static final Bundle jsonToBundle(JSONObject jsonObj) {
        if (jsonObj == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        Iterator keys = jsonObj.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "jsonObj.keys()");
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jsonObj.get(str);
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Number) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof JSONArray) {
                bundle.putString(str, obj.toString());
            } else if (obj instanceof JSONObject) {
                Bundle jsonToBundle = jsonToBundle(obj.toString());
                if (jsonToBundle != null) {
                    bundle.putBundle(str, jsonToBundle);
                }
            } else {
                QLog.w(TAG, 1, "jsonToBundle error: key=" + str + ", value=" + obj);
            }
        }
        return bundle;
    }

    @JvmStatic
    public static final Bundle jsonToBundle(String jsonStr) {
        if (jsonStr == null) {
            return null;
        }
        try {
            return jsonToBundle(new JSONObject(jsonStr));
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "jsonToBundle error: " + e16.getMessage());
            return null;
        }
    }
}
