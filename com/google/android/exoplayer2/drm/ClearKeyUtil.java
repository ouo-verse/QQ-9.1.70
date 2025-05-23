package com.google.android.exoplayer2.drm;

import android.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
final class ClearKeyUtil {
    private static final Pattern REQUEST_KIDS_PATTERN = Pattern.compile("\"kids\":\\[\"(.*?)\"]");
    private static final String TAG = "ClearKeyUtil";

    ClearKeyUtil() {
    }

    public static byte[] adjustRequestData(byte[] bArr) {
        if (Util.SDK_INT >= 27) {
            return bArr;
        }
        String fromUtf8Bytes = Util.fromUtf8Bytes(bArr);
        Matcher matcher = REQUEST_KIDS_PATTERN.matcher(fromUtf8Bytes);
        if (!matcher.find()) {
            Log.e(TAG, "Failed to adjust request data: " + fromUtf8Bytes);
            return bArr;
        }
        int start = matcher.start(1);
        int end = matcher.end(1);
        StringBuilder sb5 = new StringBuilder(fromUtf8Bytes);
        base64ToBase64Url(sb5, start, end);
        return Util.getUtf8Bytes(sb5.toString());
    }

    public static byte[] adjustResponseData(byte[] bArr) {
        if (Util.SDK_INT >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(Util.fromUtf8Bytes(bArr));
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                jSONObject2.put("k", base64UrlToBase64(jSONObject2.getString("k")));
                jSONObject2.put("kid", base64UrlToBase64(jSONObject2.getString("kid")));
            }
            return Util.getUtf8Bytes(jSONObject.toString());
        } catch (JSONException e16) {
            Log.e(TAG, "Failed to adjust response data: " + Util.fromUtf8Bytes(bArr), e16);
            return bArr;
        }
    }

    private static void base64ToBase64Url(StringBuilder sb5, int i3, int i16) {
        while (i3 < i16) {
            char charAt = sb5.charAt(i3);
            if (charAt != '+') {
                if (charAt == '/') {
                    sb5.setCharAt(i3, util.base64_pad_url);
                }
            } else {
                sb5.setCharAt(i3, '-');
            }
            i3++;
        }
    }

    private static String base64UrlToBase64(String str) {
        return str.replace('-', '+').replace(util.base64_pad_url, '/');
    }
}
