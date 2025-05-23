package com.tencent.mobileqq.vas.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import cooperation.qzone.util.JarReflectUtil;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQVasUpdateBusinessUtil {
    private static ConcurrentHashMap<Class, Object> mCacheInstance = new ConcurrentHashMap<>();

    public static <T extends QQVasUpdateBusiness> T createInstance(Class<T> cls) {
        if (mCacheInstance.get(cls) != null) {
            return (T) mCacheInstance.get(cls);
        }
        T t16 = (T) JarReflectUtil.creatSpecifiedObject(cls.getName(), null, null);
        mCacheInstance.put(cls, t16);
        return t16;
    }

    @Deprecated
    public static <T extends QQVasUpdateBusiness> T getBusinessInstance(Class<T> cls) {
        return (T) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(cls);
    }
}
