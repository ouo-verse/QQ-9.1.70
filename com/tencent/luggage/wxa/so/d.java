package com.tencent.luggage.wxa.so;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f140563a = {null, null};

    public static String a(Context context) {
        FileInputStream fileInputStream;
        String processName;
        String[] strArr = f140563a;
        if (strArr[0] == null) {
            synchronized (strArr) {
                if (strArr[0] == null) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        processName = Application.getProcessName();
                        if (!TextUtils.isEmpty(processName)) {
                            strArr[0] = processName;
                            return processName;
                        }
                    }
                    try {
                        Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]);
                        declaredMethod.setAccessible(true);
                        String str = (String) declaredMethod.invoke(null, new Object[0]);
                        if (!TextUtils.isEmpty(str)) {
                            strArr[0] = str;
                            return str;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        fileInputStream = new FileInputStream("/proc/self/cmdline");
                    } catch (Throwable unused2) {
                    }
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
                        byte[] bArr = new byte[256];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                        if (!TextUtils.isEmpty(byteArrayOutputStream2)) {
                            String[] strArr2 = f140563a;
                            String trim = byteArrayOutputStream2.trim();
                            strArr2[0] = trim;
                            fileInputStream.close();
                            return trim;
                        }
                        fileInputStream.close();
                        throw new IllegalStateException("Fail to get current process name.");
                    } finally {
                    }
                }
            }
        }
        return strArr[0];
    }

    public static String b(Context context) {
        String str;
        String[] strArr = f140563a;
        if (strArr[1] == null) {
            synchronized (strArr) {
                if (strArr[1] == null) {
                    String a16 = a(context);
                    int indexOf = a16.indexOf(58);
                    if (indexOf >= 0) {
                        str = a16.substring(indexOf);
                    } else {
                        str = "";
                    }
                    strArr[1] = str;
                }
            }
        }
        return strArr[1];
    }
}
