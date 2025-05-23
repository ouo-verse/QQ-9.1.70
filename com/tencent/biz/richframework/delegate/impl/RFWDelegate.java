package com.tencent.biz.richframework.delegate.impl;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWDelegate {
    private static final String BIZ_DEFAULT = "Common";
    private static final Map<String, Map<Class<?>, Object>> sDelegateByBiz = new HashMap();

    public static <T> T getDelegate(Class<T> cls) {
        return (T) getDelegate(BIZ_DEFAULT, cls, false);
    }

    private static <T> T newInstance(Class<? extends T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static <T> void registerDelegate(Class<T> cls, Class<? extends T> cls2) {
        registerDelegate(BIZ_DEFAULT, cls, cls2);
    }

    public static <T> T getDelegate(Class<T> cls, boolean z16) {
        return (T) getDelegate(BIZ_DEFAULT, cls, z16);
    }

    public static synchronized <T> void registerDelegate(String str, Class<T> cls, Class<? extends T> cls2) {
        synchronized (RFWDelegate.class) {
            Map<String, Map<Class<?>, Object>> map = sDelegateByBiz;
            Map<Class<?>, Object> map2 = map.get(str);
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            if (map2.get(cls) != null && RFWApplication.isDebug()) {
                throw new RuntimeException("has same delegate impl, please use diffirent biz id to support multi impl");
            }
            map2.put(cls, newInstance(cls2));
            map.put(str, map2);
        }
    }

    public static <T> T getDelegate(String str, Class<T> cls, boolean z16) {
        T t16;
        Map<Class<?>, Object> map = sDelegateByBiz.get(str);
        if (map == null || (t16 = (T) map.get(cls)) == null) {
            return null;
        }
        return z16 ? (T) newInstance(t16.getClass()) : t16;
    }
}
