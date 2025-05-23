package com.tencent.biz.richframework.part.utils;

import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ArrayUtils {
    public static boolean isOutOfArrayIndex(int i3, List list) {
        if (list != null && i3 >= 0 && i3 < list.size()) {
            return false;
        }
        return true;
    }
}
