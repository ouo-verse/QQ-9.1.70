package com.tencent.oskplayer.support.util;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OskCollection {
    public static int index(Object[] objArr, Object obj) {
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (obj.equals(objArr[i3])) {
                return i3;
            }
        }
        return -1;
    }
}
