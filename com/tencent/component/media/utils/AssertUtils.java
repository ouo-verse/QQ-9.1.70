package com.tencent.component.media.utils;

import com.tencent.component.media.annotation.Public;

/* compiled from: P */
@Public
/* loaded from: classes5.dex */
public class AssertUtils {
    AssertUtils() {
    }

    @Public
    public static void assertTrue(boolean z16) {
        if (!z16) {
            throw new AssertionError();
        }
    }

    @Public
    public static void assertTrue(boolean z16, String str) {
        if (!z16) {
            throw new AssertionError(str);
        }
    }
}
