package com.tencent.msdk.dns.c.e;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.httpcore.message.TokenParser;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b {
    public static int a(String str, int i3) {
        int length = str.length();
        while (length > i3 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return length;
    }

    public static void b(String str, Map<String, String> map) {
        char charAt;
        int length = str.length();
        int d16 = d(str, 0);
        int i3 = d16;
        while (i3 < length && (charAt = str.charAt(i3)) != ':' && !Character.isWhitespace(charAt)) {
            i3++;
        }
        int i16 = i3;
        while (i16 < length) {
            char charAt2 = str.charAt(i16);
            i16++;
            if (charAt2 == ':') {
                break;
            }
        }
        int d17 = d(str, i16);
        int a16 = a(str, d17);
        String substring = str.substring(d16, i3);
        if (d17 <= a16) {
            String substring2 = str.substring(d17, a16);
            String lowerCase = substring.toLowerCase();
            String str2 = map.get(lowerCase);
            if (str2 != null) {
                substring2 = str2 + "," + substring2;
            }
            map.put(lowerCase, substring2);
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf(HttpRsp.HTTP_HEADER_END);
        if (indexOf < 0) {
            com.tencent.msdk.dns.base.log.c.c("HttpDns not finish header recv", new Object[0]);
            return false;
        }
        String substring = str.substring(indexOf + 4);
        HashMap hashMap = new HashMap();
        String[] split = str.split("\r\n");
        for (int i3 = 1; i3 < split.length; i3++) {
            b(split[i3], hashMap);
        }
        String str2 = (String) hashMap.get("Content-Length".toLowerCase());
        com.tencent.msdk.dns.base.log.c.c("HttpDns Content-Length len:%s, recved body:%d", str2, Integer.valueOf(substring.length()));
        if (str2 != null) {
            try {
                if (substring.length() == Integer.parseInt(str2)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static int d(String str, int i3) {
        while (i3 < str.length() && Character.isWhitespace(str.charAt(i3))) {
            i3++;
        }
        return i3;
    }

    public static String e(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                URL url = new URL(str);
                String host = url.getHost();
                return "GET " + url.getFile() + TokenParser.SP + "HTTP/1.1\r\nConnection: close\r\nHost" + MsgSummary.STR_COLON + host + "\r\n\r\n";
            } catch (MalformedURLException unused) {
                return "";
            }
        }
        throw new IllegalArgumentException("urlStr".concat(" can not be empty"));
    }

    public static String f(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(HttpRsp.HTTP_HEADER_END);
            if (2 != split.length || !split[0].contains("OK")) {
                return "";
            }
            return split[1];
        }
        throw new IllegalArgumentException("rawRsp".concat(" can not be empty"));
    }
}
