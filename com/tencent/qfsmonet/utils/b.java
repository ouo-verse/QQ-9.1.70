package com.tencent.qfsmonet.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f342626a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26432);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342626a = "";
        }
    }

    @NonNull
    public static synchronized String a() {
        String replace;
        synchronized (b.class) {
            if (TextUtils.isEmpty(f342626a)) {
                f342626a = d();
            }
            replace = f342626a.replace(" ", "").replace(",", "");
        }
        return replace;
    }

    @NonNull
    public static String b() {
        if (TextUtils.isEmpty(DeviceInfoMonitor.getModel())) {
            return "";
        }
        return DeviceInfoMonitor.getModel();
    }

    @NonNull
    public static String c() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    @NonNull
    private static String d() {
        InputStreamReader inputStreamReader;
        Throwable th5;
        FileInputStream fileInputStream;
        String str;
        try {
            fileInputStream = new FileInputStream("/proc/cpuinfo");
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            } catch (Throwable th6) {
                inputStreamReader = null;
                th5 = th6;
            }
            try {
                str = e(inputStreamReader);
                try {
                    inputStreamReader.close();
                    fileInputStream.close();
                } catch (IOException e16) {
                    a.h("MonetUtils", "getCpuInfo, ex=" + e16.toString());
                }
            } catch (Throwable th7) {
                th5 = th7;
                try {
                    a.h("MonetUtils", "getCpuInfo, ex=" + th5.toString());
                    if (inputStreamReader != null) {
                        try {
                        } catch (IOException e17) {
                            str = "";
                            a.c("MonetUtils", "getCpuInfo,name=" + str);
                            return str;
                        }
                    }
                    str = "";
                    a.c("MonetUtils", "getCpuInfo,name=" + str);
                    return str;
                } finally {
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e172) {
                            a.h("MonetUtils", "getCpuInfo, ex=" + e172.toString());
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                }
            }
        } catch (Throwable th8) {
            inputStreamReader = null;
            th5 = th8;
            fileInputStream = null;
        }
        a.c("MonetUtils", "getCpuInfo,name=" + str);
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        r7 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        r2 = new java.lang.StringBuilder();
     */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String e(@NonNull InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = "";
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine) && readLine.startsWith("Hardware")) {
                        int indexOf = readLine.indexOf(":");
                        if (indexOf > 1) {
                            str = readLine.substring(indexOf + 1).trim().replace(" ", "");
                        }
                    }
                } catch (IOException e16) {
                    a.h("MonetUtils", "getCpuInfo, ex=" + e16.toString());
                    try {
                        bufferedReader.close();
                    } catch (Exception e17) {
                        e = e17;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getCpuInfo, ex=");
                        sb5.append(e.toString());
                        a.h("MonetUtils", sb5.toString());
                        return str;
                    }
                }
            } catch (Throwable th5) {
                try {
                    bufferedReader.close();
                } catch (Exception e18) {
                    a.h("MonetUtils", "getCpuInfo, ex=" + e18.toString());
                }
                throw th5;
            }
        }
        return str;
    }
}
