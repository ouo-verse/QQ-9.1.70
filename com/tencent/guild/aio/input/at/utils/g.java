package com.tencent.guild.aio.input.at.utils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g {
    public static long a(String str, long j3) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j3;
        }
    }
}
