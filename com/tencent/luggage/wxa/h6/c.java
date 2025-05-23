package com.tencent.luggage.wxa.h6;

import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static List a(List list, List list2) {
        if (list2 != null) {
            list.addAll(list2);
        }
        return list;
    }

    public static List a(List list) {
        return list == null ? Collections.emptyList() : list;
    }
}
