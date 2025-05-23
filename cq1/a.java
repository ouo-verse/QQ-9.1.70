package cq1;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.guild.feed.b;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a {
    public static String a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return str + ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
        }
        return str;
    }

    public static String b(String str) {
        String str2 = "";
        if (str == null) {
            return "";
        }
        if (!str.contains(b.f218131q)) {
            return str;
        }
        String[] split = str.substring(str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)).split(ContainerUtils.FIELD_DELIMITER);
        for (int i3 = 0; i3 < split.length; i3++) {
            if (split[i3].contains(b.f218131q)) {
                String str3 = split[i3];
                str2 = str3.substring(str3.indexOf(ContainerUtils.KEY_VALUE_DELIMITER));
            }
        }
        return str2;
    }
}
