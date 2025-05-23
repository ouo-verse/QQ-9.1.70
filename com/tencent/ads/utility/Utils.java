package com.tencent.ads.utility;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes37.dex */
public class Utils {
    public static String getValueFromLink(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf >= 0 && str.length() > indexOf) {
            str = str.substring(indexOf + 1);
        }
        for (String str4 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str4.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2 && (str3 = split[0]) != null && str3.endsWith(str2)) {
                return split[1];
            }
        }
        return null;
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean isHttpUrl(String str) {
        return str != null && (str.startsWith("http://") || str.startsWith("https://"));
    }

    public static boolean isNumeric(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}
