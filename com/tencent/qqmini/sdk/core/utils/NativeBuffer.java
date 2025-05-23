package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NativeBuffer {
    private static final String JSON_TAG = "__nativeBuffers__";
    private static String TAG = "NativeBuffer";
    public static int TYPE_BUFFER_BASE64 = 2;
    public static int TYPE_BUFFER_NATIVE = 1;
    public byte[] buf;
    public int type;

    public static byte[] getBytesFromNativeBuffers(JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray != null && jSONArray.length() > 0 && (optJSONObject = jSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("base64");
            if (!TextUtils.isEmpty(optString)) {
                return Base64.decode(optString, 0);
            }
            return null;
        }
        return null;
    }

    public static boolean hasNativeBuffer(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.has(JSON_TAG);
    }

    public static void packNativeBuffer(IJsService iJsService, byte[] bArr, int i3, String str, JSONObject jSONObject) {
        packNativeBuffer(iJsService, bArr, 0, bArr.length, i3, str, jSONObject);
    }

    public static NativeBuffer unpackNativeBuffer(IJsService iJsService, JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        if (jSONObject == null || str == null || (optJSONArray = jSONObject.optJSONArray(JSON_TAG)) == null || optJSONArray.length() == 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        String optString = optJSONObject.optString("key");
        String optString2 = optJSONObject.optString("base64");
        int optInt = optJSONObject.optInt("id", -1);
        if (str.equals(optString)) {
            NativeBuffer nativeBuffer = new NativeBuffer();
            if (!TextUtils.isEmpty(optString2)) {
                nativeBuffer.buf = Base64.decode(optString2, 2);
                nativeBuffer.type = TYPE_BUFFER_BASE64;
            } else if (optInt != -1 && iJsService != null) {
                nativeBuffer.buf = iJsService.getNativeBuffer(optInt);
                nativeBuffer.type = TYPE_BUFFER_NATIVE;
            }
            return nativeBuffer;
        }
        return null;
    }

    public static void packNativeBuffer(IJsService iJsService, byte[] bArr, int i3, int i16, int i17, String str, JSONObject jSONObject) {
        if (jSONObject == null || str == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", str);
            if (i17 == TYPE_BUFFER_BASE64) {
                jSONObject2.put("base64", Base64.encodeToString(bArr, i3, i16, 2));
            } else if (i17 == TYPE_BUFFER_NATIVE && iJsService != null) {
                jSONObject2.put("id", iJsService.createNativeBuffer(bArr, i3, i16));
            }
            jSONArray.mo162put(jSONObject2);
            jSONObject.put(JSON_TAG, jSONArray);
        } catch (JSONException e16) {
            QMLog.e("[minigame]", "packNativeBuffer err :", e16);
        }
    }
}
