package com.tencent.mobileqq.zplan.web;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f336014a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder(str);
            int lastIndexOf = sb5.lastIndexOf("/");
            if (lastIndexOf < 0) {
                lastIndexOf = 0;
            }
            String str4 = ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.KEY_VALUE_DELIMITER;
            String str5 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.KEY_VALUE_DELIMITER;
            int length = str4.length();
            while (true) {
                try {
                    int indexOf = sb5.indexOf(str4, lastIndexOf);
                    if (-1 == indexOf) {
                        indexOf = sb5.indexOf(str5, lastIndexOf);
                    }
                    if (indexOf <= 0) {
                        break;
                    }
                    int indexOf2 = sb5.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf + length);
                    if (indexOf2 > 0) {
                        sb5.replace(indexOf + 1, indexOf2 + 1, "");
                    } else {
                        sb5.replace(indexOf, sb5.length(), "");
                    }
                } catch (Throwable th5) {
                    QLog.e("[zplan]apollo_client_ApolloClientUtil", 2, "addSonicUrlParam error:" + th5.getMessage());
                }
            }
            if (-1 != sb5.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(str2);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(str3);
            } else {
                sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                sb5.append(str2);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(str3);
            }
            return sb5.toString();
        }
        return str;
    }

    public static String b(String str) {
        return SwiftBrowserCookieMonster.r(str);
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes(), 0, str.getBytes().length);
            return j(messageDigest.digest());
        } catch (Exception e16) {
            QLog.e("[zplan]apollo_client_ApolloClientUtil", 1, e16.getMessage());
            return String.valueOf(str.hashCode());
        }
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/");
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/webview/";
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String str3 = str2 + str + "/";
        File file3 = new File(str3);
        if (!file3.exists()) {
            file3.mkdirs();
        }
        return str3 + str + ".txt";
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes(), 0, str.getBytes().length);
            return j(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String f(String str) {
        String host;
        int indexOf;
        try {
            if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf((host = Uri.parse(str).getHost()))) >= 0) {
                return str.substring(0, indexOf + host.length());
            }
        } catch (Throwable th5) {
            QLog.e("[zplan]apollo_client_ApolloClientUtil", 2, "getOrigin error:" + th5.getMessage());
        }
        return "";
    }

    public static String g() {
        File file = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/webview/");
        file.mkdirs();
        return new File(file, "apolloWebviewConfig.txt").getAbsolutePath();
    }

    public static String h(File file) {
        try {
            return FileUtils.readFileToString(file);
        } catch (IOException e16) {
            QLog.e("[zplan]apollo_client_ApolloClientUtil", 1, "readFileSafety ", e16);
            return "";
        } catch (OutOfMemoryError e17) {
            QLog.e("[zplan]apollo_client_ApolloClientUtil", 1, "readFileSafety ", e17);
            return "";
        }
    }

    private static String j(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            char[] cArr = f336014a;
            sb5.append(cArr[(b16 & 240) >>> 4]);
            sb5.append(cArr[b16 & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }

    public static InputStream k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new BufferedInputStream(new ByteArrayInputStream(str.getBytes("utf-8")));
        } catch (Throwable th5) {
            QLog.e("[zplan]apollo_client_ApolloClientUtil", 2, "toInputStream error:" + th5.getMessage());
            return null;
        }
    }

    public static boolean i(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        try {
            String[] strArr = new String[list.size()];
            list.toArray(strArr);
            HashMap hashMap = new HashMap(1);
            hashMap.put(str, strArr);
            CookieManager.getInstance().setCookies(hashMap);
            return true;
        } catch (Throwable th5) {
            QLog.e("[zplan]apollo_client_ApolloClientUtil", 1, "setCookies error:" + th5.getMessage());
            return false;
        }
    }
}
