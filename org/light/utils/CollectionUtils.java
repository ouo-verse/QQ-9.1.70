package org.light.utils;

import java.util.Collection;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CollectionUtils {
    public static boolean indexOutOfBounds(Collection collection, int i3) {
        if (collection != null && i3 >= 0 && i3 < collection.size()) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(Collection collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public static int size(Collection collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static int size(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }
}
