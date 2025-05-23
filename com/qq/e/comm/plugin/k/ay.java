package com.qq.e.comm.plugin.k;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.util.StringUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ay {
    public static String a(String str, String str2, String str3) {
        if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3) || StringUtil.isEmpty(str)) {
            return str;
        }
        String str4 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str4 = ContainerUtils.FIELD_DELIMITER;
        }
        return str + str4 + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
    }

    public static Pair<Boolean, String> b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(Boolean.FALSE, str);
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z16 = false;
        try {
            String str4 = "(\\?|&|#)" + str2 + "=([^&#]*)";
            String str5 = str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
            Matcher matcher = Pattern.compile(str4).matcher(str);
            boolean z17 = false;
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, matcher.group(1) + str5);
                z17 = true;
            }
            matcher.appendTail(stringBuffer);
            z16 = z17;
        } catch (Exception e16) {
            stringBuffer = new StringBuffer(str);
            e16.printStackTrace();
        }
        return new Pair<>(Boolean.valueOf(z16), stringBuffer.toString());
    }

    public static String c(String str, String str2, String str3) {
        Pair<Boolean, String> b16 = b(str, str2, str3);
        if (b16 != null && ((Boolean) b16.first).booleanValue()) {
            return (String) b16.second;
        }
        return a(str, str2, str3);
    }

    public static String d(String str, String str2, String str3) {
        Pair<Boolean, String> b16 = b(str, str2, str3);
        if (b16 != null && !((Boolean) b16.first).booleanValue()) {
            return a(str, str2, str3);
        }
        return str;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Matcher matcher = Pattern.compile("[\\?&#]" + str2 + "=([^&#]*)").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static boolean a(String str) {
        return a(Uri.parse(str));
    }

    private static boolean a(Uri uri) {
        return (uri == null || uri.getScheme() == null || (!uri.getScheme().equalsIgnoreCase("http") && !uri.getScheme().equalsIgnoreCase("https"))) ? false : true;
    }

    public static boolean b(String str) {
        return (StringUtil.isEmpty(str) || a(str)) ? false : true;
    }
}
