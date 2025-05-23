package com.huawei.hms.hwid;

import java.util.Collection;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ap {
    public static Boolean a(Collection collection) {
        if (collection != null && collection.size() != 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static Boolean b(Collection collection) {
        return Boolean.valueOf(!a(collection).booleanValue());
    }
}
