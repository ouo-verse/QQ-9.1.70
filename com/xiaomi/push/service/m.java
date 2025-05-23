package com.xiaomi.push.service;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static long f389750a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static String f389751b = "";

    public static String a() {
        if (TextUtils.isEmpty(f389751b)) {
            f389751b = com.xiaomi.push.ag.a(4);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f389751b);
        long j3 = f389750a;
        f389750a = 1 + j3;
        sb5.append(j3);
        return sb5.toString();
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 32) {
            try {
                return "BlockId_" + str.substring(8);
            } catch (Exception e16) {
                jz4.c.B("Exception occurred when filtering registration packet id for log. " + e16);
                return "UnexpectedId";
            }
        }
        return str;
    }

    public static String c() {
        return com.xiaomi.push.ag.a(32);
    }
}
