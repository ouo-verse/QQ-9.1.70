package com.tencent.util;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class URLUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "URLUtil";
    public static final String URLPREFIX = "http://";
    public static final String URLSAFEPREFIX = "https://";

    public URLUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String addParameter(String str, String str2, String str3) {
        StringBuilder sb5;
        char c16 = '?';
        int indexOf = str.indexOf(63);
        int indexOf2 = str.indexOf(35);
        if (indexOf != -1) {
            c16 = Typography.amp;
        }
        String str4 = c16 + encodeUrl(str2) + '=' + encodeUrl(str3);
        if (indexOf2 == -1) {
            sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(str4);
        } else {
            sb5 = new StringBuilder();
            sb5.append(str.substring(0, indexOf2));
            sb5.append(str4);
            sb5.append(str.substring(indexOf2));
        }
        return sb5.toString();
    }

    public static String addParameterWithoutEncode(String str, String str2, String str3) {
        StringBuilder sb5;
        char c16 = '?';
        int indexOf = str.indexOf(63);
        int indexOf2 = str.indexOf(35);
        if (indexOf != -1) {
            c16 = Typography.amp;
        }
        String str4 = c16 + str2 + '=' + str3;
        if (indexOf2 == -1) {
            sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(str4);
        } else {
            sb5 = new StringBuilder();
            sb5.append(str.substring(0, indexOf2));
            sb5.append(str4);
            sb5.append(str.substring(indexOf2));
        }
        return sb5.toString();
    }

    public static String decodeUrl(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception e16) {
            throw new IllegalArgumentException(e16);
        }
    }

    public static String deleteParameter(String str, String str2) {
        StringBuilder sb5 = new StringBuilder(str);
        int i3 = -1;
        int i16 = -1;
        int i17 = 0;
        while (true) {
            if (i17 >= sb5.length()) {
                break;
            }
            if (sb5.charAt(i17) == '?' || sb5.charAt(i17) == '&') {
                if (isParameterMatch(sb5, str2, i17)) {
                    i16 = i17 + 1;
                } else if (i16 > 0) {
                    i3 = i17 + 1;
                    break;
                }
            }
            i17++;
        }
        if (i16 < 0) {
            return str;
        }
        if (i3 < 0) {
            i16--;
            i3 = sb5.length();
        }
        return sb5.substring(0, i16) + sb5.substring(i3, sb5.length());
    }

    public static String encodeUrl(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            throw new IllegalArgumentException(e16);
        }
    }

    public static Map<String, String> getArguments(String str) {
        HashMap hashMap = new HashMap();
        try {
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split != null && split.length == 2) {
                    hashMap.put(split[0], URLDecoder.decode(split[1]));
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public static Map<String, String> getArgumentsFromURL(String str) {
        Map<String, String> map;
        int indexOf;
        if (str != null && -1 != (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER))) {
            map = getArguments(str.substring(indexOf + 1));
        } else {
            map = null;
        }
        if (map == null) {
            return new HashMap();
        }
        return map;
    }

    public static Map<String, String> getArgusFromURLWithoutDecode(String str) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            try {
                int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                if (-1 != indexOf) {
                    for (String str2 : str.substring(indexOf + 1).split(ContainerUtils.FIELD_DELIMITER)) {
                        String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split.length == 2) {
                            hashMap.put(split[0], split[1]);
                        }
                    }
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "getArgusFromURLWithoutDecode exception:" + th5);
            }
        }
        return hashMap;
    }

    public static int getInt(Map<String, String> map, String str, int i3) {
        try {
            return Integer.parseInt(map.get(str));
        } catch (Exception unused) {
            return i3;
        }
    }

    public static long getLong(Map<String, String> map, String str, long j3) {
        try {
            return Long.parseLong(map.get(str));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getLong from url encounter exception", e16);
            return j3;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getString(Map<String, String> map, String str, String str2) {
        try {
            String str3 = map.get(str);
            return str3 == null ? "" : str3;
        } catch (Exception unused) {
            return str2;
        }
    }

    private static boolean isParameterMatch(StringBuilder sb5, String str, int i3) {
        int i16 = i3 + 1;
        if (str.length() + i16 <= sb5.length() && str.equals(sb5.substring(i16, str.length() + i16))) {
            return true;
        }
        return false;
    }

    public static boolean isValidUrl(String str) {
        if (str != null && !str.equals("")) {
            try {
                URI uri = new URI(str);
                if (uri.getHost() == null || uri.getScheme() == null) {
                    return false;
                }
                if (!uri.getScheme().equalsIgnoreCase("http") && !uri.getScheme().equalsIgnoreCase("https")) {
                    return false;
                }
                return true;
            } catch (URISyntaxException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static String getString(Map<String, String> map, String str) {
        return map.get(str);
    }
}
