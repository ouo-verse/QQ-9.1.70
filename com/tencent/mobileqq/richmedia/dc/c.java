package com.tencent.mobileqq.richmedia.dc;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    public static int a(long j3, long j16) {
        if (j3 > 0 && j16 > 0) {
            long max = Math.max(j3, j16);
            if (max > 500 && max <= 960) {
                return 3;
            }
            if (max > 200 && max <= 500) {
                return 2;
            }
            if (max <= 200) {
                return 1;
            }
            if (b(j3, j16)) {
                return 0;
            }
            return 4;
        }
        return -1;
    }

    public static boolean b(long j3, long j16) {
        if (j3 < j16 * 3 && j16 < j3 * 3) {
            return false;
        }
        return true;
    }
}
