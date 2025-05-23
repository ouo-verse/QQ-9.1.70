package com.tencent.mobileqq.utils;

import androidx.annotation.Nullable;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bl {
    public static <T> boolean a(@Nullable Collection<T> collection, T t16) {
        if (collection == null) {
            return false;
        }
        return collection.contains(t16);
    }

    public static boolean b(Collection collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean c(Collection collection) {
        if (collection != null && !collection.isEmpty()) {
            return true;
        }
        return false;
    }

    public static int d(Collection collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }
}
