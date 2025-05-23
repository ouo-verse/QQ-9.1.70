package com.tencent.component.network.utils;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class PropertyUtil {
    private static final String CMD_GET_PROP = "getprop";
    public static final String PROPERTY_DNS_PRIMARY = "net.dns1";
    public static final String PROPERTY_DNS_SECNDARY = "net.dns2";
    private static Class sClassSystemProperties;
    private static Method sMethodGetString;

    static {
        try {
            sClassSystemProperties = SystemProperties.class;
            sMethodGetString = SystemProperties.class.getDeclaredMethod("get", String.class, String.class);
        } catch (Throwable unused) {
        }
    }

    public static String get(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String withReflect = getWithReflect(str, null);
        if (TextUtils.isEmpty(withReflect)) {
            withReflect = getWithCmd(str, null);
        }
        if (!TextUtils.isEmpty(withReflect)) {
            return withReflect;
        }
        return str2;
    }

    private static String getWithCmd(String str, String str2) {
        BufferedReader bufferedReader;
        try {
            Process exec = RuntimeMonitor.exec(Runtime.getRuntime(), "getprop " + str);
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            } catch (IOException unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                }
                String sb6 = sb5.toString();
                if (!TextUtils.isEmpty(sb6)) {
                    str2 = sb6;
                }
                bufferedReader.close();
            } catch (IOException unused2) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                exec.destroy();
                return str2;
            } catch (Throwable th6) {
                th = th6;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                throw th;
            }
            exec.destroy();
        } catch (Throwable unused3) {
        }
        return str2;
    }

    private static String getWithReflect(String str, String str2) {
        Method method;
        Class cls = sClassSystemProperties;
        if (cls != null && (method = sMethodGetString) != null) {
            try {
                return (String) method.invoke(cls, str, str2);
            } catch (Throwable unused) {
                return str2;
            }
        }
        return str2;
    }
}
