package com.tencent.qqmini.sdk.monitor.common;

/* loaded from: classes23.dex */
public class RecyclablePool {
    private static final boolean DEBUG = false;
    volatile int mCapacity;
    volatile int mCount = 0;
    private Recyclable mHead;

    /* loaded from: classes23.dex */
    public static class Recyclable {
        public boolean inPool;
        private Recyclable next;

        public void changeNext(Recyclable recyclable, boolean z16) {
            if (this.inPool && z16) {
                throw new RuntimeException("WTF");
            }
            this.next = recyclable;
        }

        public Recyclable getNext() {
            return this.next;
        }

        public void recycle() {
            this.next = null;
        }
    }

    public RecyclablePool(Class<? extends Recyclable> cls, int i3) {
        this.mCapacity = 0;
        Recyclable recyclable = new Recyclable();
        this.mHead = recyclable;
        synchronized (recyclable) {
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
