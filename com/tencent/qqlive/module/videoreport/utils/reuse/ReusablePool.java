package com.tencent.qqlive.module.videoreport.utils.reuse;

import com.tencent.qqlive.module.videoreport.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes22.dex */
public class ReusablePool {
    private static final int MAX_LIST_SIZE = 30;
    private static final Map<Class<? extends IReusable>, List<IReusable>> POOL = new HashMap();
    private static final String TAG = "common.ReusablePool";

    ReusablePool() {
        throw new ExceptionInInitializerError("ReusablePool is a util class,so it has private constructor");
    }

    private static <T extends IReusable> T createObject(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Exception e16) {
            Log.e(TAG, "new Instance exception " + e16);
            return null;
        }
    }

    public static <T extends IReusable> T obtain(Class<T> cls) {
        T t16;
        if (cls == null) {
            return null;
        }
        Map<Class<? extends IReusable>, List<IReusable>> map = POOL;
        synchronized (map) {
            List<IReusable> list = map.get(cls);
            if (list != null && !list.isEmpty() && (t16 = (T) list.remove(0)) != null) {
                return t16;
            }
            T t17 = (T) createObject(cls);
            if (t17 != null) {
                return t17;
            }
            throw new IllegalArgumentException("Reusable class illegal, reuseObjClass = " + cls + " must have public default constructor.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends IReusable> void recycle(T t16) {
        if (t16 == null) {
            return;
        }
        Map<Class<? extends IReusable>, List<IReusable>> map = POOL;
        synchronized (map) {
            List list = (List) map.get(t16.getClass());
            if (list == null) {
                list = new ArrayList();
                map.put(t16.getClass(), list);
            }
            if (list.size() < 30) {
                t16.reset();
                list.add(t16);
            }
        }
    }
}
