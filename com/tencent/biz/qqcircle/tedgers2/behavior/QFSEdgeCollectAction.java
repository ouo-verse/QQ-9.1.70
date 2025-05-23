package com.tencent.biz.qqcircle.tedgers2.behavior;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSEdgeCollectAction {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Integer, List<Integer>> f92449a = new HashMap<Integer, List<Integer>>() { // from class: com.tencent.biz.qqcircle.tedgers2.behavior.QFSEdgeCollectAction.1
        {
            put(4, Collections.singletonList(2));
            put(5, Collections.singletonList(2));
            put(6, Collections.singletonList(2));
            put(11, Collections.singletonList(3));
            put(12, Collections.singletonList(3));
            put(13, Collections.singletonList(3));
            put(23, Collections.singletonList(2));
            put(25, Collections.singletonList(2));
            put(26, Collections.singletonList(2));
            put(27, Collections.singletonList(2));
            put(28, Collections.singletonList(2));
            put(34, Collections.singletonList(2));
            put(36, Collections.singletonList(2));
            put(39, Collections.singletonList(2));
            put(50, Collections.singletonList(2));
            put(51, Collections.singletonList(2));
            put(55, Collections.singletonList(3));
            put(56, Collections.singletonList(2));
            put(57, Collections.singletonList(2));
            put(60, Collections.singletonList(3));
            put(61, Collections.singletonList(3));
            put(65, Collections.singletonList(-1));
            put(69, Collections.singletonList(2));
            put(80, Collections.singletonList(2));
            put(84, Collections.singletonList(2));
            put(122, Collections.singletonList(2));
            put(2, Collections.singletonList(7));
        }
    };

    public static boolean a(int i3, int i16) {
        List<Integer> list;
        if (i3 < 0 || !f92449a.containsKey(Integer.valueOf(i3)) || (list = f92449a.get(Integer.valueOf(i3))) == null || list.isEmpty()) {
            return false;
        }
        if (list.contains(-1)) {
            return true;
        }
        return list.contains(Integer.valueOf(i16));
    }
}
