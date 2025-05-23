package com.tencent.youtu.sdkkitframework.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class SimplePool<T> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SimplePool";
    private final Object[] pool;
    private int poolSize;

    public SimplePool(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            if (i3 > 0) {
                this.pool = new Object[i3];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
    }

    private boolean isInPool(T t16) {
        for (int i3 = 0; i3 < this.poolSize; i3++) {
            if (this.pool[i3] == t16) {
                return true;
            }
        }
        return false;
    }

    public T acquire() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        int i3 = this.poolSize;
        if (i3 <= 0) {
            return null;
        }
        int i16 = i3 - 1;
        Object[] objArr = this.pool;
        T t16 = (T) objArr[i16];
        objArr[i16] = null;
        this.poolSize = i16;
        return t16;
    }

    public boolean release(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16)).booleanValue();
        }
        if (!isInPool(t16)) {
            int i3 = this.poolSize;
            Object[] objArr = this.pool;
            if (i3 < objArr.length) {
                objArr[i3] = t16;
                this.poolSize = i3 + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
