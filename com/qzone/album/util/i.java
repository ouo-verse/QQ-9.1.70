package com.qzone.album.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.component.network.utils.NetworkUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class i {
    public static String a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!NetworkUtils.isNetworkUrl(str)) {
            return str;
        }
        int indexOf = str.indexOf("//");
        if (indexOf != -1) {
            str2 = str.substring(indexOf + 2);
        }
        int indexOf2 = str2.indexOf("/");
        if (indexOf2 != -1) {
            str2 = str2.substring(indexOf2 + 1);
        }
        return str.indexOf(ContainerUtils.FIELD_DELIMITER) == -1 ? str2 : str2.substring(0, str2.indexOf(ContainerUtils.FIELD_DELIMITER));
    }
}
