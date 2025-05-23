package com.tencent.tavkit.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ListUtils {
    public static <T> List<T> listWithObjects(T... tArr) {
        return new ArrayList(Arrays.asList(tArr));
    }
}
