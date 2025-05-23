package com.tencent.timi.game.utils;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes26.dex */
public class p {
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
