package com.qzone.util;

import com.huawei.hms.framework.common.ContainerUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public class n {
    public static final String a(String str, String str2) {
        String substring;
        if (str == null) {
            return str2;
        }
        int lastIndexOf = str.lastIndexOf("&rf=");
        if (lastIndexOf != -1) {
            substring = str.substring(lastIndexOf);
        } else {
            int lastIndexOf2 = str.lastIndexOf("#rf=");
            if (lastIndexOf2 == -1) {
                return str2;
            }
            substring = str.substring(lastIndexOf2);
        }
        int indexOf = substring.indexOf(61);
        String substring2 = (indexOf < 0 || indexOf >= substring.length()) ? null : substring.substring(indexOf + 1);
        if (substring2 == null) {
            return str2;
        }
        int indexOf2 = substring2.indexOf(ContainerUtils.FIELD_DELIMITER);
        return indexOf2 != -1 ? substring2.substring(0, indexOf2) : substring2;
    }
}
