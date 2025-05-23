package com.tencent.qqmini.minigame.yungame.va;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c {
    public static String a(long j3) {
        if (j3 >= 1073741824) {
            return "" + (Math.round((((((float) j3) / 1024.0f) / 1024.0f) / 1024.0f) * 10.0f) / 10.0f) + "G";
        }
        if (j3 >= 1048576) {
            return "" + (Math.round(((((float) j3) / 1024.0f) / 1024.0f) * 10.0f) / 10.0f) + "M";
        }
        if (j3 >= 1024) {
            return "" + (Math.round((((float) j3) / 1024.0f) * 10.0f) / 10.0f) + "k";
        }
        return j3 + "b";
    }

    public static String b(long j3, long j16) {
        return a(j3) + "/" + a(j16);
    }
}
