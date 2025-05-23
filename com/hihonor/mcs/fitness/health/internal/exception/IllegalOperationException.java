package com.hihonor.mcs.fitness.health.internal.exception;

/* compiled from: P */
/* loaded from: classes2.dex */
public class IllegalOperationException extends Exception {
    private int errorCode;

    public IllegalOperationException(int i3, String str) {
        super(str);
        this.errorCode = i3;
    }

    public int a() {
        return this.errorCode;
    }
}
