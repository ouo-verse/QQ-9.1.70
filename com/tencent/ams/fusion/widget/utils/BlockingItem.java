package com.tencent.ams.fusion.widget.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BlockingItem<T> {
    static IPatchRedirector $redirector_;
    private volatile T item;
    final Lock lock;
    final Condition notEmpty;

    public BlockingItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
    }

    public T peek() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.item;
    }

    public void put(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16);
            return;
        }
        this.lock.lock();
        try {
            this.item = t16;
            if (t16 != null) {
                this.notEmpty.signal();
            }
        } finally {
            this.lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        this.lock.lock();
        while (this.item == null) {
            try {
                this.notEmpty.await();
            } finally {
                this.lock.unlock();
            }
        }
        T t16 = this.item;
        this.item = null;
        return t16;
    }

    public T tryTake(long j3) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
        this.lock.lock();
        do {
            try {
                if (this.item != null) {
                    T t16 = this.item;
                    this.item = null;
                    return t16;
                }
            } finally {
                this.lock.unlock();
            }
        } while (this.notEmpty.await(j3, TimeUnit.MILLISECONDS));
        return null;
    }
}
