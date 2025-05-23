package com.tencent.theme.utils;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* loaded from: classes26.dex */
public final class PropertyUtils {
    static IPatchRedirector $redirector_;
    private static Class<?> sClassSystemProperties;
    private static Method sMethodGetString;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11276);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        try {
            sClassSystemProperties = SystemProperties.class;
            sMethodGetString = SystemProperties.class.getDeclaredMethod("get", String.class, String.class);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    PropertyUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
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

    public static String getQuickly(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return getWithReflect(str, str2);
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
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return str2;
    }

    private static String getWithReflect(String str, String str2) {
        Method method;
        Class<?> cls = sClassSystemProperties;
        if (cls != null && (method = sMethodGetString) != null) {
            try {
                return (String) method.invoke(cls, str, str2);
            } catch (Exception e16) {
                e16.printStackTrace();
                return str2;
            }
        }
        return str2;
    }
}
