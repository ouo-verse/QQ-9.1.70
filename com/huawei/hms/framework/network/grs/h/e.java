package com.huawei.hms.framework.network.grs.h;

import com.huawei.hms.framework.common.Logger;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37045a = "e";

    public static boolean a(Long l3) {
        if (l3 == null) {
            Logger.v(f37045a, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
        } catch (NumberFormatException unused) {
            Logger.v(f37045a, "isSpExpire spValue NumberFormatException.");
        }
        if (l3.longValue() - System.currentTimeMillis() >= 0) {
            Logger.i(f37045a, "isSpExpire false.");
            return false;
        }
        Logger.i(f37045a, "isSpExpire true.");
        return true;
    }

    public static boolean a(Long l3, long j3) {
        if (l3 == null) {
            Logger.v(f37045a, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l3.longValue() - (System.currentTimeMillis() + j3) >= 0) {
                Logger.v(f37045a, "isSpExpire false.");
                return false;
            }
        } catch (NumberFormatException unused) {
            Logger.v(f37045a, "isSpExpire spValue NumberFormatException.");
        }
        return true;
    }
}
