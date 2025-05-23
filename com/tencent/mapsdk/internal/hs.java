package com.tencent.mapsdk.internal;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.map.lib.models.AccessibleTouchItem;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hs {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f148736a = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    private static boolean b(String str, String str2) {
        return (str2 == null || str == null || str2.indexOf(str) != 0) ? false : true;
    }

    public static String c(String str) {
        return str == null ? "" : str;
    }

    private static String d(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String e(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String f(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "gbk");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    private static boolean g(String str) {
        if (a(str)) {
            return false;
        }
        if (!str.equals(AccessibleTouchItem.MY_LOCATION_PREFIX) && !str.equals("\u5f53\u524d\u4f4d\u7f6e") && !str.equals("\u6211\u5728\u54ea") && !str.equals("\u6211\u5728\u54ea\u513f") && !str.equals("\u6211\u5728\u7684\u4f4d\u7f6e") && !str.equals("\u6211\u7684\u4f4d\u7f6e\u5728\u54ea") && !str.equals("\u6211\u7684\u4f4d\u7f6e\u5728\u54ea\u513f")) {
            return false;
        }
        return true;
    }

    private static boolean h(String str) {
        try {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    private static String i(String str) {
        if (a(str)) {
            return str;
        }
        try {
            URI uri = new URI(str);
            String[] split = uri.getQuery().split(ContainerUtils.FIELD_DELIMITER);
            Arrays.sort(split);
            StringBuilder sb5 = new StringBuilder();
            for (String str2 : split) {
                sb5.append(str2);
            }
            return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), sb5.toString(), uri.getFragment()).toString();
        } catch (URISyntaxException e16) {
            e16.printStackTrace();
            return str;
        }
    }

    private static int j(String str) {
        int i3 = 0;
        int i16 = 0;
        while (i3 < str.length()) {
            int i17 = i3 + 1;
            if (str.substring(i3, i17).matches("[\u4e00-\u9fa5]")) {
                i16++;
            } else {
                i16 = (int) (i16 + 0.5d);
            }
            i3 = i17;
        }
        return i16;
    }

    private static CharSequence a(String[] strArr, int[] iArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strArr[i3]);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(iArr[i3]), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        return spannableStringBuilder;
    }

    public static String b(String str) {
        int lastIndexOf;
        return (!a(str) && (lastIndexOf = str.lastIndexOf(".")) > 0) ? str.substring(0, lastIndexOf) : str;
    }

    private static boolean c(String str, String str2) {
        if (str2 == null || str == null) {
            return false;
        }
        return str2.contains(str);
    }

    private static int d(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i3 = 0;
        while (true) {
            if (i3 < (split.length > split2.length ? split2.length : split.length)) {
                int intValue = Integer.valueOf(split[i3]).intValue() - Integer.valueOf(split2[i3]).intValue();
                if (intValue != 0) {
                    return intValue;
                }
                i3++;
            } else {
                if (split.length != split2.length) {
                    return split.length - split2.length;
                }
                return 0;
            }
        }
    }

    public static String a(byte[] bArr, String str) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(256);
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() < 2) {
                sb5.append(0);
            }
            sb5.append(hexString);
        }
        return sb5.toString();
    }

    private static String a(long j3) {
        return f148736a.format(Long.valueOf(j3));
    }

    public static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 != null) {
            return str2.equals(str);
        }
        return false;
    }

    public static String a(Collection<String> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (String str2 : collection) {
            if (i3 == collection.size() - 1) {
                sb5.append(str2);
            } else {
                sb5.append(str2);
                sb5.append(str);
            }
            i3++;
        }
        return sb5.toString();
    }
}
