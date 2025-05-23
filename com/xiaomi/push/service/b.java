package com.xiaomi.push.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.push.g;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.k;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<k.b<String, String, String>> f389691a = new a(6);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class a extends SparseArray<k.b<String, String, String>> {
        a(int i3) {
            super(i3);
            put(1, k.f389742i);
            put(2, k.f389741h);
            put(4, k.f389740g);
            put(8, k.f389737d);
            put(16, k.f389738e);
            put(32, k.f389743j);
        }
    }

    public static int a(Context context, String str) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26 = 0;
        if (context != null && !TextUtils.isEmpty(str)) {
            g.b f16 = com.xiaomi.push.g.f(context, str, true);
            if (f16 == g.b.ALLOWED) {
                i26 = 1;
            } else if (f16 == g.b.NOT_ALLOWED) {
                i26 = 2;
            }
            int i27 = 32;
            int i28 = 8;
            if (k.p()) {
                Bundle c16 = c(str);
                k.b<String, String, String> bVar = k.f389742i;
                if (c16.containsKey(bVar.f389747c)) {
                    if (c16.getBoolean(bVar.f389747c)) {
                        i28 = 4;
                    }
                    i26 |= i28;
                }
                k.b<String, String, String> bVar2 = k.f389740g;
                if (c16.containsKey(bVar2.f389747c)) {
                    if (c16.getBoolean(bVar2.f389747c)) {
                        i27 = 16;
                    }
                    i26 |= i27;
                }
                k.b<String, String, String> bVar3 = k.f389741h;
                if (c16.containsKey(bVar3.f389747c)) {
                    if (c16.getBoolean(bVar3.f389747c)) {
                        i19 = 64;
                    } else {
                        i19 = 128;
                    }
                    i26 |= i19;
                }
                k.b<String, String, String> bVar4 = k.f389737d;
                if (c16.containsKey(bVar4.f389747c)) {
                    if (c16.getBoolean(bVar4.f389747c)) {
                        i18 = 256;
                    } else {
                        i18 = 512;
                    }
                    i26 |= i18;
                }
                k.b<String, String, String> bVar5 = k.f389738e;
                if (c16.containsKey(bVar5.f389747c)) {
                    if (c16.getBoolean(bVar5.f389747c)) {
                        i17 = 1024;
                    } else {
                        i17 = 2048;
                    }
                    i26 |= i17;
                }
                k.b<String, String, String> bVar6 = k.f389743j;
                if (c16.containsKey(bVar6.f389747c)) {
                    if (c16.getBoolean(bVar6.f389747c)) {
                        i16 = 4096;
                    } else {
                        i16 = 8192;
                    }
                    return i26 | i16;
                }
                return i26;
            }
            int b16 = b(str, 1);
            if (b16 == 1) {
                i26 |= 4;
            } else if (b16 == 0) {
                i26 |= 8;
            }
            int b17 = b(str, 4);
            if (b17 == 1) {
                i26 |= 16;
            } else if (b17 == 0) {
                i26 |= 32;
            }
            int b18 = b(str, 2);
            if (b18 == 1) {
                i26 |= 64;
            } else if (b18 == 0) {
                i26 |= 128;
            }
            int b19 = b(str, 8);
            if (b19 == 1) {
                i26 |= 256;
            } else if (b19 == 0) {
                i26 |= 512;
            }
            int b26 = b(str, 16);
            if (b26 == 1) {
                i26 |= 1024;
            } else if (b26 == 0) {
                i26 |= 2048;
            }
            int b27 = b(str, 32);
            if (b27 == 1) {
                i3 = i26 | 4096;
            } else if (b27 == 0) {
                i3 = i26 | 8192;
            } else {
                return i26;
            }
            return i3;
        }
        jz4.c.m("context | packageName must not be null");
        return 0;
    }

    private static int b(String str, int i3) {
        return k.c(ii.b(), str, null, f389691a.get(i3));
    }

    private static Bundle c(String str) {
        return k.d(ii.b(), str, null);
    }
}
