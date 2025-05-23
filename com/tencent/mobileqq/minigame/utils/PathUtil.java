package com.tencent.mobileqq.minigame.utils;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.math.BigInteger;
import java.security.MessageDigest;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class PathUtil {

    /* renamed from: md, reason: collision with root package name */
    private static MessageDigest f247028md;

    public static JSONObject getJSONQueryString(String str) {
        int indexOf;
        int i3;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                int indexOf2 = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                if (indexOf2 > -1 && str.length() > (i3 = indexOf2 + 1)) {
                    str = str.substring(i3);
                }
                String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
                if (split != null && split.length > 0) {
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2) && (indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER)) >= 0) {
                            jSONObject.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("PathUtil", 1, "getJSONQueryString exception " + th5);
        }
        return jSONObject;
    }

    public static String getMD5String(String str) {
        try {
            if (f247028md == null) {
                f247028md = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            }
            f247028md.update(str.getBytes());
            return new BigInteger(1, f247028md.digest()).toString(16);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean isNetworkUrl(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("https://") || str.startsWith("http://"));
    }
}
