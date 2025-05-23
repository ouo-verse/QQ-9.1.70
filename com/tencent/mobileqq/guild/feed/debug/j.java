package com.tencent.mobileqq.guild.feed.debug;

import com.tencent.mobileqq.guild.util.bw;

/* compiled from: P */
/* loaded from: classes13.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static volatile j f218434a;

    j() {
    }

    public static j b() {
        if (f218434a == null) {
            synchronized (j.class) {
                if (f218434a == null) {
                    f218434a = new j();
                }
            }
        }
        return f218434a;
    }

    public boolean a(String str, boolean z16) {
        return bw.L().decodeBool(str, z16);
    }

    public String c(String str, String str2) {
        return bw.L().decodeString(str, str2);
    }

    public void d(String str, String str2) {
        bw.L().encodeString(str, str2);
    }

    public void e(String str, boolean z16) {
        bw.L().encodeBool(str, z16);
    }
}
