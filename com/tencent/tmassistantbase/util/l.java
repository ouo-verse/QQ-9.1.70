package com.tencent.tmassistantbase.util;

import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static String f380479a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f380480b = "TMAssistantDownloadSDKService";

    /* renamed from: c, reason: collision with root package name */
    private static String f380481c = "com.tencent.mobileqq";

    public static synchronized String a() {
        String str;
        synchronized (l.class) {
            if (TextUtils.isEmpty(f380479a)) {
                try {
                    f380479a = f();
                } catch (IOException unused) {
                }
            }
            str = f380479a;
        }
        return str;
    }

    public static void b() {
        try {
            String f16 = f();
            f380479a = f16;
            if (!f16.contains(f380480b)) {
                f380480b = f380479a;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public static void c() {
        try {
            String f16 = f();
            f380479a = f16;
            if (!f16.equals(f380481c)) {
                f380481c = f380479a;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public static boolean d() {
        if (TextUtils.isEmpty(f380479a)) {
            try {
                f380479a = f();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(f380479a)) {
            return f380479a.contains(f380480b);
        }
        return true;
    }

    public static boolean e() {
        if (TextUtils.isEmpty(f380479a)) {
            try {
                f380479a = f();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(f380479a)) {
            return f380479a.equals(f380481c);
        }
        return true;
    }

    private static String f() {
        byte[] bArr = new byte[64];
        FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
        try {
            int read = fileInputStream.read(bArr);
            int a16 = a(bArr, 0, read, (byte) 0);
            if (a16 > 0) {
                read = a16;
            }
            return new String(bArr, 0, read);
        } finally {
            try {
                fileInputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static int a(byte[] bArr, int i3, int i16, byte b16) {
        for (int i17 = 0; i17 < bArr.length; i17++) {
            if (bArr[i17] == b16) {
                return i17;
            }
        }
        return -1;
    }
}
