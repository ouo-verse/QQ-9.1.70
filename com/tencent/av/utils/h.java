package com.tencent.av.utils;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class h {
    public static boolean a(int i3, long j3) {
        if (i3 != 0 || j3 == 0) {
            return false;
        }
        long d16 = vu.a.c().d("c2c_talk_room_time");
        long d17 = vu.a.c().d("c2c_talk_room_key");
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        vu.a.c().m("c2c_talk_room_key", j3);
        vu.a.c().m("c2c_talk_room_time", serverTimeMillis);
        if (d17 != j3 || d16 + 86400000 < serverTimeMillis) {
            return false;
        }
        return true;
    }
}
