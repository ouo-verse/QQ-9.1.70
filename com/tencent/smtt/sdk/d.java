package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.IOException;
import java.util.UnknownFormatConversionException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    static int f369343a = 5;

    /* renamed from: b, reason: collision with root package name */
    static int f369344b = 16;

    /* renamed from: c, reason: collision with root package name */
    static char[] f369345c = new char[16];

    /* renamed from: d, reason: collision with root package name */
    static String f369346d = "dex2oat-cmdline";

    /* renamed from: e, reason: collision with root package name */
    static long f369347e = 4096;

    public static String a(Context context, String str) throws Exception {
        com.tencent.smtt.utils.c cVar = new com.tencent.smtt.utils.c(str);
        cVar.a(f369345c);
        cVar.a(f369345c[f369343a] == 1);
        cVar.a(f369347e);
        return a(new String(a(cVar)));
    }

    private static String a(String str) {
        String[] split = str.split(new String("\u0000"));
        int i3 = 0;
        while (i3 < split.length) {
            int i16 = i3 + 1;
            String str2 = split[i3];
            int i17 = i16 + 1;
            String str3 = split[i16];
            if (str2.equals(f369346d)) {
                return str3;
            }
            i3 = i17;
        }
        return "";
    }

    public static char[] a(com.tencent.smtt.utils.c cVar) throws IOException {
        char[] cArr = new char[4];
        char[] cArr2 = new char[4];
        cVar.a(cArr);
        if (cArr[0] == 'o' && cArr[1] == 'a' && cArr[2] == 't') {
            cVar.a(cArr2);
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            if (cArr2[1] <= '4') {
                cVar.b();
                cVar.b();
                cVar.b();
            }
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            char[] cArr3 = new char[cVar.b()];
            cVar.a(cArr3);
            return cArr3;
        }
        throw new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", Character.valueOf(cArr[0]), Character.valueOf(cArr[1]), Character.valueOf(cArr[2])));
    }
}
