package com.tencent.mars.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class BridgeMap {
    static IPatchRedirector $redirector_;
    private ConcurrentHashMap<Object, Long> interfaceMap;

    public BridgeMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.interfaceMap = new ConcurrentHashMap<>();
        }
    }

    public long delete(Object obj) {
        long longValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, obj)).longValue();
        }
        synchronized (BridgeMap.class) {
            longValue = this.interfaceMap.remove(obj).longValue();
        }
        return longValue;
    }

    public void put(long j3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), obj);
        } else {
            synchronized (BridgeMap.class) {
                this.interfaceMap.put(obj, Long.valueOf(j3));
            }
        }
    }

    public Object transfer(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), str);
        }
        synchronized (BridgeMap.class) {
            try {
                AtomicReference atomicReference = new AtomicReference();
                if (j3 == 0) {
                    return null;
                }
                for (Map.Entry<Object, Long> entry : this.interfaceMap.entrySet()) {
                    Object key = entry.getKey();
                    if (entry.getValue().longValue() == j3) {
                        atomicReference.set(key);
                    }
                }
                if (atomicReference.get() != null) {
                    return atomicReference.get();
                }
                try {
                    Object newInstance = Class.forName(str).getConstructor(Long.TYPE).newInstance(Long.valueOf(j3));
                    this.interfaceMap.put(newInstance, Long.valueOf(j3));
                    return newInstance;
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                    return null;
                } catch (InstantiationException e17) {
                    e17.printStackTrace();
                    return null;
                } catch (NoSuchMethodException e18) {
                    e18.printStackTrace();
                    return null;
                } catch (InvocationTargetException e19) {
                    e19.printStackTrace();
                    return null;
                }
            } catch (ClassNotFoundException e26) {
                e26.printStackTrace();
            }
        }
    }
}
