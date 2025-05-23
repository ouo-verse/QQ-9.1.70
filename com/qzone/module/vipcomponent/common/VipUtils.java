package com.qzone.module.vipcomponent.common;

import cooperation.vip.vipcomponent.util.b;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VipUtils {
    public static final String TAG = "VipUtils";

    public static String generateOpenVipInfoResult(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "YellowInfo");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("vipType", str);
            jSONObject.put("data", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e16) {
            b.b(TAG, e16.getMessage());
            return null;
        }
    }

    public static int getIdFromZipUrl(String str) {
        String str2;
        int lastIndexOf;
        int lastIndexOf2;
        if (isEmpty(str) || (lastIndexOf = str.lastIndexOf((str2 = File.separator))) == -1 || lastIndexOf == str.length() - 1) {
            return 0;
        }
        String substring = str.substring(0, lastIndexOf);
        if (isEmpty(substring) || (lastIndexOf2 = substring.lastIndexOf(str2)) == -1 || lastIndexOf2 == substring.length() - 1) {
            return 0;
        }
        try {
            return Integer.parseInt(substring.substring(lastIndexOf2 + 1));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
