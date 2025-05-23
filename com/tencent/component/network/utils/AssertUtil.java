package com.tencent.component.network.utils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AssertUtil {
    AssertUtil() {
    }

    public static void assertTrue(boolean z16) {
        if (z16) {
        } else {
            throw new AssertionError();
        }
    }
}
