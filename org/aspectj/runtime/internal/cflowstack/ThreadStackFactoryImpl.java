package org.aspectj.runtime.internal.cflowstack;

import java.util.Stack;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ThreadStackFactoryImpl implements ThreadStackFactory {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class ThreadCounterImpl extends ThreadLocal implements ThreadCounter {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static class Counter {
            protected int value = 0;

            Counter() {
            }
        }

        ThreadCounterImpl() {
        }

        @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
        public void dec() {
            Counter threadCounter = getThreadCounter();
            threadCounter.value--;
        }

        public Counter getThreadCounter() {
            return (Counter) get();
        }

        @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
        public void inc() {
            getThreadCounter().value++;
        }

        @Override // java.lang.ThreadLocal
        public Object initialValue() {
            return new Counter();
        }

        @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
        public boolean isNotZero() {
            if (getThreadCounter().value != 0) {
                return true;
            }
            return false;
        }

        @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
        public void removeThreadCounter() {
            remove();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class ThreadStackImpl extends ThreadLocal implements ThreadStack {
        ThreadStackImpl() {
        }

        @Override // org.aspectj.runtime.internal.cflowstack.ThreadStack
        public Stack getThreadStack() {
            return (Stack) get();
        }

        @Override // java.lang.ThreadLocal
        public Object initialValue() {
            return new Stack();
        }

        @Override // org.aspectj.runtime.internal.cflowstack.ThreadStack
        public void removeThreadStack() {
            remove();
        }
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadStackFactory
    public ThreadCounter getNewThreadCounter() {
        return new ThreadCounterImpl();
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadStackFactory
    public ThreadStack getNewThreadStack() {
        return new ThreadStackImpl();
    }
}
