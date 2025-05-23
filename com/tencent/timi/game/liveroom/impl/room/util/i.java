package com.tencent.timi.game.liveroom.impl.room.util;

/* compiled from: P */
/* loaded from: classes26.dex */
public class i {
    public static int a(String str) {
        int i3 = 0;
        int i16 = 0;
        while (i3 < str.length()) {
            int i17 = i3 + 1;
            if (str.substring(i3, i17).matches("[\u4e00-\u9fa5]")) {
                i16 += 2;
            } else {
                i16++;
            }
            i3 = i17;
        }
        return i16;
    }
}
