package com.tencent.biz.TroopRedpoint;

import android.util.SparseIntArray;
import tencent.im.oidb.cmd0x791.oidb_0x791$RedDotInfo;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f78345a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f78345a = sparseIntArray;
        sparseIntArray.put(35, 3);
        sparseIntArray.put(11, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(37, 4);
        sparseIntArray.put(52, 5);
    }

    public static int a(oidb_0x791$RedDotInfo oidb_0x791_reddotinfo, oidb_0x791$RedDotInfo oidb_0x791_reddotinfo2) {
        if (oidb_0x791_reddotinfo == null) {
            if (oidb_0x791_reddotinfo2 == null) {
                return 0;
            }
            return -1;
        }
        if (oidb_0x791_reddotinfo2 == null) {
            return 1;
        }
        SparseIntArray sparseIntArray = f78345a;
        return sparseIntArray.get(oidb_0x791_reddotinfo.uint32_appid.get()) - sparseIntArray.get(oidb_0x791_reddotinfo2.uint32_appid.get());
    }

    public static boolean b(int i3) {
        if (i3 == 70) {
            return true;
        }
        return false;
    }

    public static boolean c(int i3) {
        if (!i(i3) && !h(i3) && !e(i3) && !d(i3) && !b(i3) && i3 != 40 && i3 != 39 && i3 != 41 && i3 != 42 && i3 != 58 && i3 != 56 && i3 != 57 && i3 != 59 && i3 != 60 && i3 != 61 && i3 != 65 && i3 != 63 && i3 != 53 && i3 != 54) {
            return false;
        }
        return true;
    }

    public static boolean d(int i3) {
        if (i3 == 38) {
            return true;
        }
        return false;
    }

    public static boolean e(int i3) {
        if (i3 != 24 && i3 != 27) {
            return false;
        }
        return true;
    }

    public static boolean f(int i3) {
        if (!g(i3) && i3 != 52) {
            return false;
        }
        return true;
    }

    public static boolean g(int i3) {
        if (i3 != 8 && i3 != 35 && i3 != 11 && i3 != 37) {
            return false;
        }
        return true;
    }

    public static boolean h(int i3) {
        if (i3 != 23 && i3 != 26) {
            return false;
        }
        return true;
    }

    public static boolean i(int i3) {
        if (i3 == 25) {
            return true;
        }
        return false;
    }
}
