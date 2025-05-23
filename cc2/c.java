package cc2;

import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c {
    public static final String a(String str, String str2) {
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf != -1) {
            int indexOf2 = str.indexOf(str2 + ContainerUtils.KEY_VALUE_DELIMITER, indexOf + 1);
            if (indexOf2 != -1) {
                int indexOf3 = str.indexOf(ContainerUtils.FIELD_DELIMITER, str2.length() + indexOf2 + 1);
                if (indexOf3 != -1) {
                    return str.substring(indexOf2 + str2.length() + 1, indexOf3);
                }
                return str.substring(indexOf2 + str2.length() + 1);
            }
        }
        return null;
    }

    public static final String b(String str, String str2, String str3) {
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf != -1) {
            int indexOf2 = str.indexOf(str2 + ContainerUtils.KEY_VALUE_DELIMITER, indexOf + 1);
            if (indexOf2 != -1) {
                int indexOf3 = str.indexOf(ContainerUtils.FIELD_DELIMITER, str2.length() + indexOf2 + 1);
                if (indexOf3 != -1) {
                    return str.substring(0, indexOf2) + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3 + str.substring(indexOf3);
                }
                return str.substring(0, indexOf2) + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
            }
            if (str.lastIndexOf(ContainerUtils.FIELD_DELIMITER) == str.length() - 1) {
                return str + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
            }
            return str + ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
        }
        return str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
    }
}
