package com.tencent.mobileqq.webview.util;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes20.dex */
public class s {
    static IPatchRedirector $redirector_;

    public static void a(String str) {
        ((com.tencent.mobileqq.webview.swift.injector.b) aa.k(com.tencent.mobileqq.webview.swift.injector.b.class)).beginTimeTrack(str);
    }

    public static void b(String str) {
        ((com.tencent.mobileqq.webview.swift.injector.b) aa.k(com.tencent.mobileqq.webview.swift.injector.b.class)).endTimeTrack(str);
    }

    public static String c(String str, String... strArr) {
        return ((com.tencent.mobileqq.webview.swift.injector.b) aa.k(com.tencent.mobileqq.webview.swift.injector.b.class)).b(str, strArr);
    }

    public static String d(String str, String... strArr) {
        return ((com.tencent.mobileqq.webview.swift.injector.b) aa.k(com.tencent.mobileqq.webview.swift.injector.b.class)).e(str, strArr);
    }

    @NonNull
    private static String e(int i3, long j3) {
        if (i3 <= 0) {
            return "";
        }
        Random random = new Random(j3);
        StringBuilder sb5 = new StringBuilder(i3);
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_".charAt(random.nextInt(63)));
        }
        return sb5.toString();
    }

    public static String f(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception e16) {
            QLog.e("webkit_util", 1, "getHostFromUrl exception: " + str, e16);
            return null;
        }
    }

    @NonNull
    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = 0;
        long longValue = ((Long) t.j().b("random_skey_ts_" + str, 0L)).longValue();
        if (longValue > 0 && currentTimeMillis - longValue < 86400000) {
            String str2 = (String) t.j().b("random_skey_" + str, "");
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        try {
            j3 = Long.valueOf(str).longValue();
        } catch (Exception e16) {
            QLog.w("webkit_util", 1, "getRandomSkey convert2Long exception: " + e16.getMessage(), e16);
        }
        String e17 = e(10, j3);
        t.j().d("random_skey_" + str, e17);
        t.j().d("random_skey_ts_" + str, Long.valueOf(currentTimeMillis));
        return e17;
    }

    public static String h(String str, int i3) {
        String host;
        String str2 = "";
        if (!TextUtils.isEmpty(str) && i3 > 0) {
            try {
                Uri parse = Uri.parse(str);
                if (parse.isHierarchical() && (host = parse.getHost()) != null) {
                    String[] split = host.split("\\.");
                    if (split.length > 0) {
                        int max = Math.max(0, split.length - (i3 + 1));
                        StringBuilder sb5 = new StringBuilder(256);
                        sb5.append(split[max]);
                        while (true) {
                            max++;
                            if (max >= split.length) {
                                break;
                            }
                            sb5.append('.');
                            sb5.append(split[max]);
                        }
                        str2 = sb5.toString();
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QLog", 2, "Get " + i3 + " level domain= " + str2 + " from " + str);
        }
        return str2;
    }

    public static String i(String str) {
        return h(str, 1);
    }

    public static boolean j(String str) {
        if (str != null && str.length() != 0) {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        }
        return false;
    }

    public static boolean k(WebView webView) {
        if (webView != null && webView.getX5WebViewExtension() != null) {
            return true;
        }
        return false;
    }

    public static String l(String str) {
        if (str == null) {
            return "null";
        }
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("\"");
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt != '\f') {
                if (charAt != '\r') {
                    if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                sb5.append("\\b");
                                break;
                            case '\t':
                                sb5.append("\\t");
                                break;
                            case '\n':
                                sb5.append(RedTouch.NEWLINE_CHAR);
                                break;
                            default:
                                if (charAt <= 31) {
                                    sb5.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                                    break;
                                } else {
                                    sb5.append(charAt);
                                    break;
                                }
                        }
                    } else {
                        sb5.append('\\');
                        sb5.append(charAt);
                    }
                } else {
                    sb5.append("\\r");
                }
            } else {
                sb5.append("\\f");
            }
        }
        sb5.append("\"");
        return sb5.toString();
    }

    public static boolean m(String str, String str2, boolean z16, boolean z17) {
        boolean z18;
        File file = new File(str);
        if (!file.exists()) {
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            } catch (IOException unused) {
                z18 = false;
            }
        }
        z18 = true;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z17);
            if (z16) {
                try {
                    try {
                        str2 = str2 + "\r\n";
                    } catch (IOException unused2) {
                        z18 = false;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.e("util", 2, th, new Object[0]);
                        }
                        if (fileOutputStream == null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Throwable th6) {
                            if (!QLog.isColorLevel()) {
                                return false;
                            }
                            QLog.e("util", 2, th6, new Object[0]);
                            return false;
                        }
                    } catch (Throwable th7) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th8) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("util", 2, th8, new Object[0]);
                                }
                            }
                        }
                        throw th7;
                    }
                }
            }
            fileOutputStream2.write(str2.getBytes());
            try {
                fileOutputStream2.flush();
            } catch (IOException unused3) {
                z18 = false;
            }
            try {
                fileOutputStream2.close();
                return z18;
            } catch (Throwable th9) {
                if (!QLog.isColorLevel()) {
                    return false;
                }
                QLog.e("util", 2, th9, new Object[0]);
                return false;
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }
}
