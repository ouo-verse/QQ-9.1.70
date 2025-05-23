package com.tencent.commonsdk.pool;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes5.dex */
public class RecyclablePool {
    static IPatchRedirector $redirector_ = null;
    private static final boolean DEBUG = false;
    volatile int mCapacity;
    volatile int mCount;
    private Recyclable mHead;

    /* loaded from: classes5.dex */
    public static class Recyclable {
        static IPatchRedirector $redirector_;
        public boolean inPool;
        private Recyclable next;

        public Recyclable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void changeNext(Recyclable recyclable, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, recyclable, Boolean.valueOf(z16));
            } else {
                if (this.inPool && z16) {
                    throw new RuntimeException("WTF");
                }
                this.next = recyclable;
            }
        }

        public Recyclable getNext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Recyclable) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.next;
        }

        public void recycle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.next = null;
            }
        }
    }

    public RecyclablePool(Class<? extends Recyclable> cls, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls, i3);
            return;
        }
        this.mHead = new Recyclable();
        this.mCount = 0;
        this.mCapacity = 0;
        synchronized (this.mHead) {
            this.mCapacity = i3;
            this.mHead.inPool = true;
            for (int i16 = 0; i16 < i3; i16++) {
                try {
                    Recyclable newInstance = cls.newInstance();
                    newInstance.inPool = true;
                    newInstance.changeNext(this.mHead.getNext(), false);
                    this.mHead.changeNext(newInstance, false);
                    this.mCount++;
                } catch (Throwable unused) {
                }
            }
        }
    }

    public Recyclable obtain(Class<? extends Recyclable> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Recyclable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
        }
        Recyclable recyclable = null;
        if (this.mCount > 0) {
            synchronized (this.mHead) {
                if (this.mCount > 0) {
                    recyclable = this.mHead.getNext();
                    if (recyclable != null) {
                        if (recyclable.inPool) {
                            this.mHead.changeNext(recyclable.next, false);
                            recyclable.inPool = false;
                            this.mCount--;
                        } else {
                            throw new RuntimeException("WTF");
                        }
                    } else {
                        throw new RuntimeException("WTF");
                    }
                }
            }
        }
        if (recyclable == null) {
            try {
                return cls.newInstance();
            } catch (Throwable unused) {
                return recyclable;
            }
        }
        return recyclable;
    }

    public void recycle(Recyclable recyclable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclable);
            return;
        }
        recyclable.recycle();
        if (this.mCount < this.mCapacity) {
            synchronized (this.mHead) {
                if (!recyclable.inPool) {
                    if (this.mCount < this.mCapacity) {
                        recyclable.changeNext(this.mHead.getNext(), false);
                        this.mHead.changeNext(recyclable, false);
                        recyclable.inPool = true;
                        this.mCount++;
                    }
                } else {
                    throw new RuntimeException("WTF");
                }
            }
        }
    }
}
