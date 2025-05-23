package cooperation.ilive.util;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d {
    public static Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        try {
            String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
            boolean z16 = false;
            for (String str2 : split) {
                String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length == 2) {
                    String str3 = split2[0];
                    if (str3 != null && str3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str3 = str3.substring(str3.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1);
                    }
                    if ("roomid".equals(str3) || "vid".equals(str3)) {
                        z16 = true;
                    }
                }
            }
            if (!z16) {
                split = URLDecoder.decode(str, "UTF-8").split(ContainerUtils.FIELD_DELIMITER);
            }
            for (String str4 : split) {
                String[] split3 = str4.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3 != null && split3.length == 2) {
                    String str5 = split3[0];
                    if (str5 != null && str5.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str5 = str5.substring(str5.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1);
                    }
                    if (str5 != null && str5.equalsIgnoreCase("pagetype")) {
                        str5 = "pagetype";
                    }
                    hashMap.put(str5, URLDecoder.decode(split3[1]));
                }
            }
        } catch (Exception e16) {
            QLog.e("UriUtil", 1, "parse mqq schema error " + e16);
        }
        return hashMap;
    }
}
