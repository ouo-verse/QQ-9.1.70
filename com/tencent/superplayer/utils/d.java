package com.tencent.superplayer.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {
    public static int a(List<Integer> list) {
        return b(list, true);
    }

    public static int b(List<Integer> list, boolean z16) {
        if (z16) {
            list = new ArrayList(list);
        }
        int size = list.size();
        int i3 = 0;
        if (size <= 0) {
            return 0;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            i3 += it.next().intValue();
        }
        return i3 / size;
    }
}
