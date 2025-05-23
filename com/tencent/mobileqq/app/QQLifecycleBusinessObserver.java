package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQLifecycleBusinessObserver implements BusinessObserver {
    static IPatchRedirector $redirector_ = null;
    public static final int ON_INIT = 0;
    public static final int ON_REMOVE = -1;
    public static final String TAG = "QQLifecycleBusinessObserver";
    private BusinessObserver businessObserver;
    public AtomicInteger lifeState;

    public QQLifecycleBusinessObserver(@NotNull BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) businessObserver);
        } else {
            this.lifeState = new AtomicInteger(0);
            this.businessObserver = businessObserver;
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.businessObserver.equals(((QQLifecycleBusinessObserver) obj).businessObserver);
        }
        return false;
    }

    public Class<?> getBusinessObserverClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.businessObserver.getClass();
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.businessObserver.hashCode();
    }

    public void markObserverRemove() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.lifeState.set(-1);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            if (this.lifeState.compareAndSet(-1, -1)) {
                return;
            }
            try {
                this.businessObserver.onUpdate(i3, z16, obj);
            } catch (Throwable th5) {
                QLog.e(TAG, 2, "onUpdate error!", th5);
            }
        }
    }
}
