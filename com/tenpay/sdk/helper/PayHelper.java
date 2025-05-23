package com.tenpay.sdk.helper;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.ErrorCode;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class PayHelper {
    private static final String TAG = "PayHelper";

    public static Bundle createResult(String str) {
        if (str == null) {
            str = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString("retmsg", str);
        return bundle;
    }

    public static Bundle createResultForError(String str) {
        String format;
        if (str == null) {
            str = "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("err_msg", str);
            format = jSONObject.toString();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "", th5);
            format = String.format(ErrorCode.ERR_STR_FORMAT, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e");
        }
        Bundle bundle = new Bundle();
        bundle.putString("retmsg", format);
        return bundle;
    }

    public static Bundle createResult(Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (map == null) {
            return bundle;
        }
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }
}
