package org.aspectj.runtime.internal;

import org.aspectj.lang.ProceedingJoinPoint;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class AroundClosure {
    protected int bitflags = 1048576;
    protected Object[] preInitializationState;
    protected Object[] state;

    public AroundClosure() {
    }

    public int getFlags() {
        return this.bitflags;
    }

    public Object[] getPreInitializationState() {
        return this.preInitializationState;
    }

    public Object[] getState() {
        return this.state;
    }

    public ProceedingJoinPoint linkClosureAndJoinPoint() {
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) this.state[r0.length - 1];
        proceedingJoinPoint.set$AroundClosure(this);
        return proceedingJoinPoint;
    }

    public ProceedingJoinPoint linkStackClosureAndJoinPoint(int i3) {
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) this.state[r0.length - 1];
        proceedingJoinPoint.stack$AroundClosure(this);
        this.bitflags = i3;
        return proceedingJoinPoint;
    }

    public abstract Object run(Object[] objArr) throws Throwable;

    public void unlink() {
        ((ProceedingJoinPoint) this.state[r0.length - 1]).stack$AroundClosure(null);
    }

    public AroundClosure(Object[] objArr) {
        this.state = objArr;
    }

    public ProceedingJoinPoint linkClosureAndJoinPoint(int i3) {
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) this.state[r0.length - 1];
        proceedingJoinPoint.set$AroundClosure(this);
        this.bitflags = i3;
        return proceedingJoinPoint;
    }
}
