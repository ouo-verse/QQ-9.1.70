package com.tencent.tav.coremedia;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CMSampleState {
    private boolean isNewFrame;

    /* renamed from: msg, reason: collision with root package name */
    private String f374240msg;
    private long stateCode;
    private Throwable throwable;

    @NonNull
    private final CMTime time;

    public CMSampleState() {
        this(CMTime.CMTimeInvalid);
    }

    public static CMSampleState fromError(long j3) {
        return fromError(j3, "state:" + j3);
    }

    public String getMsg() {
        return this.f374240msg;
    }

    public long getStateCode() {
        return this.stateCode;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    @NonNull
    public CMTime getTime() {
        return this.time;
    }

    public boolean isInvalid() {
        if (this.time == CMTime.CMTimeInvalid) {
            return true;
        }
        return false;
    }

    public boolean isNewFrame() {
        return this.isNewFrame;
    }

    public void setNewFrame(boolean z16) {
        this.isNewFrame = z16;
    }

    public boolean stateMatchingTo(long... jArr) {
        for (long j3 : jArr) {
            if (this.stateCode == j3) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "CMSampleState{time=" + this.time + ", isNewFrame=" + this.isNewFrame + ", stateCode=" + this.stateCode + ", throwable=" + this.throwable + ", msg='" + this.f374240msg + "'}";
    }

    public CMSampleState(@NonNull CMTime cMTime) {
        this.isNewFrame = true;
        this.stateCode = 0L;
        Utils.checkNotNull(cMTime);
        this.time = cMTime;
        long j3 = cMTime.value;
        if (j3 < 0) {
            this.stateCode = j3;
        }
    }

    public static CMSampleState fromError(long j3, String str) {
        return fromError(j3, str, new RuntimeException(str));
    }

    public static CMSampleState fromError(long j3, String str, Throwable th5) {
        return new CMSampleState(j3, str, th5);
    }

    public CMSampleState(long j3, String str, Throwable th5) {
        this.isNewFrame = true;
        this.stateCode = 0L;
        this.time = new CMTime(j3);
        this.stateCode = j3;
        this.f374240msg = str;
        this.throwable = th5;
    }
}
