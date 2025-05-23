package com.tencent.mobileqq.troop.managerfactory.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.managerfactory.api.IManagerFactoryService;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class ManagerFactoryServiceImpl implements IManagerFactoryService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ManagerFactoryImpl";
    private AppRuntime mAppRuntime;
    private ConcurrentHashMap<Class, Object> managerLocks;
    private ConcurrentHashMap<Class, Manager> managers;

    public ManagerFactoryServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.managers = new ConcurrentHashMap<>();
            this.managerLocks = new ConcurrentHashMap<>();
        }
    }

    private <T extends Manager> T createManager(Class<T> cls) {
        T t16;
        if (this.managerLocks.get(cls) == null) {
            synchronized (this.managerLocks) {
                if (this.managerLocks.get(cls) == null) {
                    this.managerLocks.put(cls, new Object());
                }
            }
        }
        synchronized (this.managerLocks.get(cls)) {
            T t17 = (T) this.managers.get(cls);
            if (t17 != null) {
                return t17;
            }
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(AppRuntime.class);
                declaredConstructor.setAccessible(true);
                t16 = declaredConstructor.newInstance(this.mAppRuntime);
                if (t16 != null) {
                    try {
                        this.managers.put(cls, t16);
                    } catch (IllegalAccessException e16) {
                        e = e16;
                        t17 = t16;
                        QLog.e(TAG, 1, "IllegalAccessException:", e.toString());
                        t16 = t17;
                        return t16;
                    } catch (InstantiationException e17) {
                        e = e17;
                        t17 = t16;
                        QLog.e(TAG, 1, "InstantiationException:", e.toString());
                        t16 = t17;
                        return t16;
                    } catch (NoSuchMethodException e18) {
                        e = e18;
                        t17 = t16;
                        QLog.e(TAG, 1, "NoSuchMethodException:", e.toString());
                        t16 = t17;
                        return t16;
                    } catch (InvocationTargetException e19) {
                        e = e19;
                        t17 = t16;
                        QLog.e(TAG, 1, "InvocationTargetException:", e.toString());
                        t16 = t17;
                        return t16;
                    }
                }
            } catch (IllegalAccessException e26) {
                e = e26;
            } catch (InstantiationException e27) {
                e = e27;
            } catch (NoSuchMethodException e28) {
                e = e28;
            } catch (InvocationTargetException e29) {
                e = e29;
            }
            return t16;
        }
    }

    @Override // com.tencent.mobileqq.troop.managerfactory.api.IManagerFactoryService
    public <T extends Manager> T getManager(Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls);
        }
        T t16 = (T) this.managers.get(cls);
        if (t16 != null) {
            return t16;
        }
        T t17 = (T) createManager(cls);
        if (t17 != null) {
            return t17;
        }
        QLog.e(TAG, 1, "build Manager service fatal api:" + cls.getSimpleName());
        throw new IllegalStateException("build Manager fatal api:" + cls.getSimpleName());
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mAppRuntime = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<Manager> it = this.managers.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }
}
