package com.tencent.tavsticker.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CollectionUtil {
    public static boolean isEmptyCollection(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isEmptyList(List<?> list) {
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isEmptyMap(Map<?, ?> map) {
        if (map != null && !map.isEmpty()) {
            return false;
        }
        return true;
    }
}
