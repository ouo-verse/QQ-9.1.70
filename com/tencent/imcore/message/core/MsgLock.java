package com.tencent.imcore.message.core;

import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MsgLock extends ReentrantLock {
    static IPatchRedirector $redirector_;
    private volatile long mLatestLockTime;
    private a mListener;
    private long mLockDuration;
    private volatile int myOwnerTid;
    private final String tag;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
    }

    public MsgLock(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.tag = "MsgLock_" + str;
        g.b().c(this);
    }

    private void a() {
        int myTid = Process.myTid();
        if (myTid != this.myOwnerTid) {
            this.myOwnerTid = myTid;
            this.mLatestLockTime = System.currentTimeMillis();
        }
    }

    private void d() {
        this.mLockDuration = System.currentTimeMillis() - this.mLatestLockTime;
        this.myOwnerTid = -1;
    }

    private void e(Thread thread, StringBuilder sb5) {
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            sb5.append(stackTraceElement);
            sb5.append("\n");
        }
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public void lock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        c();
        super.lock();
        a();
    }

    public void setListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }

    @Override // java.util.concurrent.locks.ReentrantLock
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        Thread owner = getOwner();
        sb5.append(this.tag);
        sb5.append("@");
        sb5.append(Integer.toHexString(hashCode()));
        if (owner == null) {
            sb5.append("[Unlocked] st=");
            sb5.append(this.mLatestLockTime);
            sb5.append(", duration=");
            sb5.append(this.mLockDuration);
        } else {
            Collection<Thread> queuedThreads = getQueuedThreads();
            sb5.append("[Locked by thread ");
            sb5.append(owner.getName());
            sb5.append(", st=");
            sb5.append(this.mLatestLockTime);
            sb5.append(", duration=");
            sb5.append(System.currentTimeMillis() - this.mLatestLockTime);
            sb5.append(", myPid=");
            sb5.append(this.myOwnerTid);
            sb5.append(", tid=");
            sb5.append(owner.getId());
            if (queuedThreads != null && !queuedThreads.isEmpty()) {
                sb5.append(", queuedThreads=");
                sb5.append(queuedThreads);
            }
            sb5.append(", stackTrace of owner=");
            e(owner, sb5);
            sb5.append("]");
        }
        return sb5.toString();
    }

    @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
    public void unlock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        d();
        super.unlock();
        b();
    }

    private void b() {
    }

    private void c() {
    }
}
