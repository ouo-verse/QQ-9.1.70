package com.tencent.biz.qqstory.utils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i {
    public static Throwable a(String str, Throwable th5) {
        if (th5 == null) {
            return new IllegalStateException(str);
        }
        return new IllegalStateException(str, th5);
    }

    public static Throwable b(String str) {
        return new NullPointerException(str);
    }
}
