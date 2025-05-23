package com.tencent.biz.richframework.util;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWUrlUtils {
    public static String encodeString(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return "\u3010RFWUrlUtils::class\u3011 URLCoder: " + URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                RFWLog.e("RFWUrlUtils", RFWLog.USR, "failed to encode string:" + e16);
            }
        }
        return "";
    }

    public static String getFileNameFromUrl(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        int lastIndexOf2 = str.lastIndexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (lastIndexOf == -1 || lastIndexOf == str.length() - 1) {
            return null;
        }
        if (lastIndexOf2 > lastIndexOf) {
            return str.substring(lastIndexOf + 1, lastIndexOf2);
        }
        return str.substring(lastIndexOf + 1);
    }

    public static boolean isNinePatchUrl(String str) {
        if (!TextUtils.isEmpty(str) && str.endsWith(".9.png")) {
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
}
