package com.qzone.util;

import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes37.dex */
public class f {
    public static <T> List<T> a(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    public static <T> Set<T> b(Set<T> set) {
        if (set == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(set);
    }

    public static String c(Iterable iterable) {
        if (iterable == null) {
            return "null";
        }
        StringBuilder sb5 = new StringBuilder();
        for (Object obj : iterable) {
            sb5.append(";");
            sb5.append(obj.toString());
        }
        if (sb5.length() == 0) {
            return GlobalUtil.DEF_STRING;
        }
        return sb5.substring(1);
    }
}
