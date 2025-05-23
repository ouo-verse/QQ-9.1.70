package com.qq.e.comm.util;

import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ArrayUtilStub {
    public static boolean isNotNullAndEmpty(List list) {
        return list != null && list.size() > 0;
    }

    public static boolean isNullOrEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean isNotNullAndEmpty(Object[] objArr) {
        return objArr != null && objArr.length > 0;
    }

    public static boolean isNullOrEmpty(Map map) {
        return map == null || map.size() == 0;
    }

    public static boolean isNullOrEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }
}
