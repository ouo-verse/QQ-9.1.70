package com.tencent.biz.qqcircle.tedgers2.behavior;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSEdgeBasedAction {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Integer, Integer> f92448a = new HashMap<Integer, Integer>() { // from class: com.tencent.biz.qqcircle.tedgers2.behavior.QFSEdgeBasedAction.1
        {
            put(4, 9);
            put(5, 9);
            put(23, 10);
            put(25, 5);
            put(26, 5);
            put(27, 5);
            put(28, 5);
            put(36, 6);
            put(50, 14);
            put(69, 6);
            put(60, 4);
            put(65, 8);
            put(51, 12);
            put(80, 7);
            put(2, 3);
            put(6, 13);
            put(84, 14);
            put(34, 11);
            put(122, 12);
            put(55, 6);
            put(56, 11);
            put(57, 11);
            put(61, 4);
            put(11, 15);
            put(12, 15);
            put(13, 15);
        }
    };

    public static int a(int i3) {
        if (i3 < 0 || !f92448a.containsKey(Integer.valueOf(i3))) {
            return -1;
        }
        return f92448a.get(Integer.valueOf(i3)).intValue();
    }
}
