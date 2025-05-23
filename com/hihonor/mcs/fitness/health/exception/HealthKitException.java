package com.hihonor.mcs.fitness.health.exception;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthKitException extends RuntimeException {
    private int errorCode;

    public HealthKitException(int i3, String str) {
        super(str);
        this.errorCode = i3;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
