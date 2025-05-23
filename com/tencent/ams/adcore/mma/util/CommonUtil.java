package com.tencent.ams.adcore.mma.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.qq.e.comm.plugin.k.al;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.ams.adcore.mma.bean.Argument;
import com.tencent.ams.adcore.mma.bean.Company;
import com.tencent.ams.adcore.utility.SLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CommonUtil {
    static IPatchRedirector $redirector_;

    public CommonUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String encodingUTF8(String str) {
        if (str != null) {
            try {
            } catch (UnsupportedEncodingException unused) {
                return "";
            }
        }
        return URLEncoder.encode(str, "utf-8");
    }

    public static String getHostURL(String str) {
        Matcher matcher = Pattern.compile("^([\\w\\d]+):\\/\\/([\\w\\d\\-_]+(?:\\.[\\w\\d\\-_]+)*)").matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    public static String getSignature(Context context, String str) {
        String lowerCase = str.toLowerCase();
        try {
            Class a16 = al.a("cn.mmachina.JniClient");
            if (a16 == null) {
                return null;
            }
            return (String) al.a(a16, al.a(a16, "MDString", String.class, Context.class, String.class), "", context, lowerCase);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isMobileConnected(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (networkInfo = connectivityManager.getNetworkInfo(0)) == null) {
            return false;
        }
        return networkInfo.isAvailable();
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (networkInfo = connectivityManager.getNetworkInfo(1)) != null) {
            return networkInfo.isAvailable();
        }
        return false;
    }

    public static String md5(String str) {
        NoSuchAlgorithmException e16;
        String str2;
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes());
            str2 = new BigInteger(1, messageDigest.digest()).toString(16);
            while (str2.length() < 32) {
                try {
                    str2 = "0" + str2;
                } catch (NoSuchAlgorithmException e17) {
                    e16 = e17;
                    e16.printStackTrace();
                    return str2;
                }
            }
            return str2.toUpperCase();
        } catch (NoSuchAlgorithmException e18) {
            e16 = e18;
            str2 = null;
        }
    }

    public static Map removeExistArgmentAndGetRedirectURL(String str, List<String> list, String str2, String str3, String str4) {
        List<String> sortByLength = sortByLength(list);
        HashMap hashMap = new HashMap();
        for (String str5 : sortByLength) {
            if (str.contains(str2 + str5)) {
                if (str5.equals(str4)) {
                    Matcher matcher = Pattern.compile(str2 + str5 + "[^" + str2 + "]*").matcher(str);
                    if (matcher.find()) {
                        matcher.group(0).replace(str2 + str5, "");
                    }
                }
                str = str.replaceAll(str2 + str5 + str3 + "[^" + str2 + "]*", "");
            }
        }
        hashMap.put(Global.TRACKING_URL, str);
        return hashMap;
    }

    public static String removeExistEvent(String str, List<String> list, String str2, String str3) {
        for (String str4 : list) {
            if (str.contains(str2 + str4)) {
                SLog.d("mma_" + str2 + str4 + str3 + "[^" + str2 + "]*");
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                sb5.append(str4);
                sb5.append(str3);
                sb5.append("[^");
                sb5.append(str2);
                sb5.append("]*");
                str = str.replaceAll(sb5.toString(), "");
            }
        }
        return str;
    }

    private static List<String> sortByLength(List list) {
        Collections.sort(list, new Comparator<String>() { // from class: com.tencent.ams.adcore.mma.util.CommonUtil.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
                }
                if (str == null) {
                    return -1;
                }
                return (str2 != null && str.length() > str2.length()) ? -1 : 1;
            }
        });
        return list;
    }

    public static String encodingUTF8(String str, Argument argument, Company company) {
        try {
            return !argument.urlEncode ? str == null ? "" : str : str == null ? "" : URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }
}
