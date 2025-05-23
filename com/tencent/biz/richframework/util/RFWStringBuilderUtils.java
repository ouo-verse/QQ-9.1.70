package com.tencent.biz.richframework.util;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWStringBuilderUtils {
    private static final ThreadLocal<StringBuilder> sBuilder = new ThreadLocal<>();

    public static String getString(Object... objArr) {
        StringBuilder obtain = obtain();
        for (Object obj : objArr) {
            obtain.append(obj);
        }
        return obtain.toString();
    }

    public static StringBuilder obtain() {
        ThreadLocal<StringBuilder> threadLocal = sBuilder;
        StringBuilder sb5 = threadLocal.get();
        if (sb5 == null) {
            StringBuilder sb6 = new StringBuilder();
            threadLocal.set(sb6);
            return sb6;
        }
        sb5.setLength(0);
        return sb5;
    }
}
