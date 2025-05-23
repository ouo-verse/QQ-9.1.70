package com.tencent.qqlive.tvkplayer.tools.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHttpUtils {
    private static final Pattern IPV4_REGEX_NORMAL = Pattern.compile("((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)");
    private static final Pattern IPV6_REGEX_NORMAL = Pattern.compile("((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4}){1,2})|:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4}){1,5})|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:)))(%.+)?");
    private static final Pattern IP_ADDRESS_PATTERN = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|(\\[[0-9a-fA-F]*:[0-9a-fA-F:.]*)\\]|([\\d.]+)");
    private static final String TAG = "TVKHttpUtils";

    @Nullable
    public static byte[] convertStringToByte(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e16) {
            TVKLogUtil.e(TAG, e16, "Encoding format: " + str2 + " not supported");
            return null;
        }
    }

    @Nullable
    public static byte[] encodeParamsToByteForUrlEncoding(Map<String, String> map, String str) {
        return convertStringToByte(encodeParamsToStringForUrlEncoding(map, str), str);
    }

    @Nullable
    public static String encodeParamsToStringForUrlEncoding(Map<String, String> map, String str) {
        String value;
        if (map != null && !map.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        sb5.append(URLEncoder.encode(entry.getKey(), str));
                        sb5.append('=');
                        if (entry.getValue() == null) {
                            value = "";
                        } else {
                            value = entry.getValue();
                        }
                        sb5.append(URLEncoder.encode(value, str));
                        sb5.append(Typography.amp);
                    }
                }
                return sb5.toString();
            } catch (UnsupportedEncodingException e16) {
                TVKLogUtil.e(TAG, e16, "Encoding format: " + str + " not supported");
                return null;
            }
        }
        TVKLogUtil.w(TAG, "inputParams: " + map + " is invalid, return null");
        return null;
    }

    public static List<String> getIpAddress(String str) {
        List<String> ipv4Address = getIpv4Address(str);
        List<String> ipv6Address = getIpv6Address(str);
        if (!ipv6Address.isEmpty()) {
            ipv4Address.addAll(ipv6Address);
        }
        return ipv4Address;
    }

    public static List<String> getIpv4Address(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        Matcher matcher = IPV4_REGEX_NORMAL.matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    public static List<String> getIpv6Address(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        Matcher matcher = IPV6_REGEX_NORMAL.matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    public static boolean isIPv4(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return IPV4_REGEX_NORMAL.matcher(str).matches();
    }

    public static boolean isIPv6(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return IPV6_REGEX_NORMAL.matcher(str).matches();
    }

    public static boolean isIpAddress(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return IP_ADDRESS_PATTERN.matcher(str).matches();
    }

    public static boolean isIpv6OnlyAddresses(List<InetAddress> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<InetAddress> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Inet4Address) {
                return false;
            }
        }
        return true;
    }
}
