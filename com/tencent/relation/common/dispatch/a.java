package com.tencent.relation.common.dispatch;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.dispatch.b;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class a<DATA, LISTENER extends b<DATA>> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BaseDispatcher";
    ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, LISTENER>> dispatchListenersMap;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.dispatchListenersMap = new ConcurrentHashMap<>();
        }
    }

    public synchronized void deregisterEventListener(int i3, LISTENER listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) listener);
            return;
        }
        ConcurrentHashMap<Integer, LISTENER> eventListeners = getEventListeners(i3);
        if (eventListeners != null && listener != null) {
            eventListeners.remove(Integer.valueOf(listener.hashCode()));
        } else {
            QLog.e(TAG, 1, getClass().getSimpleName() + " deregisterEventListner listeners is null or dispatchListener is null");
        }
    }

    public synchronized void dispatchEvent(int i3, DATA data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) data);
            return;
        }
        ConcurrentHashMap<Integer, LISTENER> eventListeners = getEventListeners(i3);
        if (eventListeners != null) {
            Iterator<LISTENER> it = eventListeners.values().iterator();
            while (it.hasNext()) {
                handleEvent(it.next(), data);
            }
        } else {
            QLog.e(TAG, 1, getClass().getSimpleName() + " dispatchEvent listeners is null or empty");
        }
    }

    protected ConcurrentHashMap<Integer, LISTENER> getEventListeners(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        if (this.dispatchListenersMap.get(Integer.valueOf(i3)) == null) {
            this.dispatchListenersMap.put(Integer.valueOf(i3), new ConcurrentHashMap<>());
        }
        return this.dispatchListenersMap.get(Integer.valueOf(i3));
    }

    protected abstract void handleEvent(LISTENER listener, DATA data);

    public synchronized void registerEventListener(int i3, LISTENER listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) listener);
            return;
        }
        ConcurrentHashMap<Integer, LISTENER> eventListeners = getEventListeners(i3);
        if (eventListeners != null && listener != null) {
            eventListeners.put(Integer.valueOf(listener.hashCode()), listener);
        } else {
            QLog.e(TAG, 1, getClass().getSimpleName() + " registerEventListener listeners is null or dispatchListener is null");
        }
    }
}
