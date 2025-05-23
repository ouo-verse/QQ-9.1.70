package com.huawei.hms.hwid;

import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<Integer> f37316a;

    static {
        HashSet hashSet = new HashSet();
        f37316a = hashSet;
        hashSet.add(0);
    }

    public static int a(int i3) {
        if (f37316a.contains(Integer.valueOf(i3))) {
            return 0;
        }
        return 1;
    }
}
