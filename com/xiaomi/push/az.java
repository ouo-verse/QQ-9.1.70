package com.xiaomi.push;

import java.net.InetSocketAddress;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class az {

    /* renamed from: a, reason: collision with root package name */
    private String f388234a;

    /* renamed from: b, reason: collision with root package name */
    private int f388235b;

    public az(String str, int i3) {
        this.f388234a = str;
        this.f388235b = i3;
    }

    public static az b(String str, int i3) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i3 = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new az(str, i3);
    }

    public static InetSocketAddress d(String str, int i3) {
        az b16 = b(str, i3);
        return new InetSocketAddress(b16.c(), b16.a());
    }

    public int a() {
        return this.f388235b;
    }

    public String c() {
        return this.f388234a;
    }

    public String toString() {
        if (this.f388235b > 0) {
            return this.f388234a + ":" + this.f388235b;
        }
        return this.f388234a;
    }
}
