package com.tencent.luan.ioc.wrapper;

import com.tencent.luan.ioc.InjectConstructor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GlobalSingletonObjectWrapper<T> extends SingletonObjectWrapper<T> {
    static IPatchRedirector $redirector_;
    private static final ReadWriteLock LOCK;
    private static final Map<String, GlobalSingletonObjectWrapper<?>> SINGLETON_WRAPPER_MAP;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10486);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            LOCK = new ReentrantReadWriteLock();
            SINGLETON_WRAPPER_MAP = new HashMap();
        }
    }

    GlobalSingletonObjectWrapper(InjectConstructor<T> injectConstructor) {
        super(injectConstructor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) injectConstructor);
        }
    }

    public static <T> GlobalSingletonObjectWrapper<T> getInstanceByConstructor(InjectConstructor<T> injectConstructor) {
        String uniqueKey = injectConstructor.uniqueKey();
        ReadWriteLock readWriteLock = LOCK;
        readWriteLock.readLock().lock();
        try {
            Map<String, GlobalSingletonObjectWrapper<?>> map = SINGLETON_WRAPPER_MAP;
            GlobalSingletonObjectWrapper<T> globalSingletonObjectWrapper = (GlobalSingletonObjectWrapper) map.get(uniqueKey);
            if (globalSingletonObjectWrapper != null) {
                readWriteLock.readLock().unlock();
                return globalSingletonObjectWrapper;
            }
            readWriteLock.readLock().unlock();
            readWriteLock.writeLock().lock();
            try {
                GlobalSingletonObjectWrapper<T> globalSingletonObjectWrapper2 = (GlobalSingletonObjectWrapper) map.get(uniqueKey);
                if (globalSingletonObjectWrapper2 != null) {
                    readWriteLock.writeLock().unlock();
                    return globalSingletonObjectWrapper2;
                }
                GlobalSingletonObjectWrapper<T> globalSingletonObjectWrapper3 = new GlobalSingletonObjectWrapper<>(injectConstructor);
                map.put(uniqueKey, globalSingletonObjectWrapper3);
                readWriteLock.writeLock().unlock();
                return globalSingletonObjectWrapper3;
            } catch (Throwable th5) {
                LOCK.writeLock().unlock();
                throw th5;
            }
        } catch (Throwable th6) {
            LOCK.readLock().unlock();
            throw th6;
        }
    }
}
