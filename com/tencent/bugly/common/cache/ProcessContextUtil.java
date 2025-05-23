package com.tencent.bugly.common.cache;

import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
class ProcessContextUtil {
    private static final String BASE64_PREFIX = "base64_";
    private static final int BASE64_PREFIX_LEN = 7;
    private static final String DELIMITER = "|";
    private static final String DELIMITER_REG = "\\|";
    private static final String ORIGIN_PREFIX = "origin_";
    private static final int ORIGIN_PREFIX_LEN = 7;

    ProcessContextUtil() {
    }

    public static String listToString(List<String> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder(256);
            int i3 = 0;
            for (String str : list) {
                if (str != null) {
                    if (i3 > 0) {
                        sb5.append("|");
                    }
                    if (!str.isEmpty()) {
                        if (str.contains("|")) {
                            str = BASE64_PREFIX + Base64.encodeToString(str.getBytes(), 2);
                        } else {
                            str = ORIGIN_PREFIX + str;
                        }
                    }
                    sb5.append(str);
                    i3++;
                }
            }
            return sb5.toString();
        }
        return "";
    }

    public static List<String> stringToList(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(DELIMITER_REG)) {
                    if (str2.startsWith(ORIGIN_PREFIX)) {
                        str2 = str2.substring(ORIGIN_PREFIX_LEN);
                    } else if (str2.startsWith(BASE64_PREFIX)) {
                        str2 = new String(Base64.decode(str2.substring(BASE64_PREFIX_LEN), 2));
                    }
                    arrayList.add(str2);
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }
}
