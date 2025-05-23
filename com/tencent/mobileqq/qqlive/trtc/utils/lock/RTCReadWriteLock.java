package com.tencent.mobileqq.qqlive.trtc.utils.lock;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RTCReadWriteLock extends ReentrantReadWriteLock {
    static IPatchRedirector $redirector_;
    private final Condition mWriteLockCond;

    public RTCReadWriteLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mWriteLockCond = writeLock().newCondition();
        }
    }

    public boolean readTryLock(long j3) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, j3)).booleanValue();
        }
        while (true) {
            i3--;
            if (i3 >= 0) {
                try {
                    return readLock().tryLock(j3, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e16) {
                    QLog.e("RTCReadWriteLock", 1, e16, new Object[0]);
                }
            } else {
                throw new InterruptedException("tryLock interrupted.");
            }
        }
    }

    public void writeLockCondSignal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        writeLock().lock();
        try {
            try {
                this.mWriteLockCond.signal();
            } catch (IllegalMonitorStateException e16) {
                QLog.e("RTCReadWriteLock", 1, e16, new Object[0]);
            }
        } finally {
            writeLock().unlock();
        }
    }

    public void writeLockCondSignalAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        writeLock().lock();
        try {
            try {
                this.mWriteLockCond.signalAll();
            } catch (IllegalMonitorStateException e16) {
                QLog.e("RTCReadWriteLock", 1, e16, new Object[0]);
            }
        } finally {
            writeLock().unlock();
        }
    }

    public boolean writeLockCondWait(long j3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, j3)).booleanValue();
        }
        writeLock().lock();
        int i3 = 3;
        while (true) {
            i3--;
            z16 = false;
            if (i3 < 0) {
                break;
            }
            try {
                z16 = this.mWriteLockCond.await(j3, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException e16) {
                QLog.e("RTCReadWriteLock", 1, e16, new Object[0]);
            } finally {
                writeLock().unlock();
            }
        }
        return z16;
    }

    public boolean writeTryLock(long j3) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, j3)).booleanValue();
        }
        int i3 = 3;
        while (true) {
            i3--;
            if (i3 >= 0) {
                try {
                    return writeLock().tryLock(j3, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e16) {
                    QLog.e("RTCReadWriteLock", 1, e16, new Object[0]);
                }
            } else {
                throw new InterruptedException("tryLock interrupted.");
            }
        }
    }
}
