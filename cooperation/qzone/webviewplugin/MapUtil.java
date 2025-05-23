package cooperation.qzone.webviewplugin;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MapUtil {
    public static String covetH5ParamToMap(Map<Integer, Long> map) {
        String encode;
        StringBuilder sb5 = new StringBuilder();
        for (Integer num : map.keySet()) {
            if (sb5.length() > 0) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            Long l3 = map.get(num);
            String str = "";
            if (num == null) {
                encode = "";
            } else {
                try {
                    encode = URLEncoder.encode(num + "", "UTF-8");
                } catch (UnsupportedEncodingException e16) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e16);
                }
            }
            sb5.append(encode);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            if (l3 != null) {
                str = URLEncoder.encode(l3 + "", "UTF-8");
            }
            sb5.append(str);
        }
        return sb5.toString();
    }

    public static String covetMapToH5Param(Map<Integer, Long> map) {
        String encode;
        StringBuilder sb5 = new StringBuilder();
        for (Integer num : map.keySet()) {
            if (sb5.length() > 0) {
                sb5.append(",");
            }
            Long l3 = map.get(num);
            String str = "";
            if (num == null) {
                encode = "";
            } else {
                try {
                    encode = URLEncoder.encode(num + "", "UTF-8");
                } catch (UnsupportedEncodingException e16) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e16);
                }
            }
            sb5.append(encode);
            sb5.append("_");
            if (l3 != null) {
                str = URLEncoder.encode(l3 + "", "UTF-8");
            }
            sb5.append(str);
        }
        return sb5.toString();
    }

    public static String mapToString(Map<Integer, Long> map) {
        String encode;
        StringBuilder sb5 = new StringBuilder();
        for (Integer num : map.keySet()) {
            if (sb5.length() > 0) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            Long l3 = map.get(num);
            String str = "";
            if (num == null) {
                encode = "";
            } else {
                try {
                    encode = URLEncoder.encode(num + "", "UTF-8");
                } catch (UnsupportedEncodingException e16) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e16);
                }
            }
            sb5.append(encode);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            if (l3 != null) {
                str = URLEncoder.encode(l3 + "", "UTF-8");
            }
            sb5.append(str);
        }
        return sb5.toString();
    }

    public static void printMap(Map<Integer, Long> map) {
        mapToString(map);
    }

    public static Map<Integer, Long> stringToMap(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                try {
                    hashMap.put(Integer.valueOf(URLDecoder.decode(split[0], "UTF-8")), Long.valueOf(URLDecoder.decode(split[1], "UTF-8")));
                } catch (UnsupportedEncodingException e16) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e16);
                }
            }
        }
        return hashMap;
    }
}
