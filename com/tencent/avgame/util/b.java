package com.tencent.avgame.util;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ax;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static ax a(ax axVar, String str, String str2, String str3) {
        axVar.f307438c = str;
        axVar.f307439d = str2;
        axVar.f307440e = str3;
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return axVar;
        }
        for (String str4 : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
            if (str4.split(ContainerUtils.KEY_VALUE_DELIMITER).length == 2) {
                int indexOf = str4.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                axVar.r(str4.substring(0, indexOf), str4.substring(indexOf + 1));
            }
        }
        return axVar;
    }
}
