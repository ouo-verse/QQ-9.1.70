package com.tencent.luggage.wxa.j0;

import com.tencent.luggage.wxa.n0.l;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f130762a = Pattern.compile("^NOTE(( |\t).*)?$");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f130763b = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");

    public static long a(String str) {
        String[] split = str.split("\\.", 2);
        long j3 = 0;
        for (String str2 : split[0].split(":")) {
            j3 = (j3 * 60) + Long.parseLong(str2);
        }
        return ((j3 * 1000) + Long.parseLong(split[1])) * 1000;
    }

    public static void b(l lVar) {
        String g16 = lVar.g();
        if (g16 != null && f130763b.matcher(g16).matches()) {
            return;
        }
        throw new com.tencent.luggage.wxa.h0.a("Expected WEBVTT. Got " + g16);
    }

    public static Matcher a(l lVar) {
        String g16;
        while (true) {
            String g17 = lVar.g();
            if (g17 == null) {
                return null;
            }
            if (f130762a.matcher(g17).matches()) {
                do {
                    g16 = lVar.g();
                    if (g16 != null) {
                    }
                } while (!g16.isEmpty());
            } else {
                Matcher matcher = a.f130760a.matcher(g17);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }
}
