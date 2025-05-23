package com.qzone.util;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes37.dex */
public class w {
    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
