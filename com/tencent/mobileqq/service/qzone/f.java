package com.tencent.mobileqq.service.qzone;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static String a(Map<Integer, String> map) {
        String encode;
        StringBuilder sb5 = new StringBuilder();
        for (Integer num : map.keySet()) {
            if (sb5.length() > 0) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            String str = map.get(num);
            String str2 = "";
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
            if (str != null) {
                str2 = URLEncoder.encode(str, "UTF-8");
            }
            sb5.append(str2);
        }
        return sb5.toString();
    }

    public static Map<Integer, String> b(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                try {
                    hashMap.put(Integer.valueOf(URLDecoder.decode(split[0], "UTF-8")), URLDecoder.decode(split[1], "UTF-8"));
                } catch (UnsupportedEncodingException e16) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e16);
                }
            }
        }
        return hashMap;
    }

    public static Map<String, String> c(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                try {
                    hashMap.put(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                } catch (UnsupportedEncodingException e16) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e16);
                }
            }
        }
        return hashMap;
    }
}
