package com.tencent.rmonitor.fd.dump;

import com.tencent.rmonitor.fd.data.FdBaseResult;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FdLeakDumpResult extends FdBaseResult {
    private Object data;
    private long dumpDurationMillis;
    private final int dumpType;
    private String filePath;

    public FdLeakDumpResult(int i3, int i16, String str) {
        this.dumpType = i3;
        this.errorCode = i16;
        this.errorMessage = str;
    }

    public static FdLeakDumpResult failure(int i3, int i16) {
        return new FdLeakDumpResult(i3, i16, "");
    }

    public <T> T getData() {
        return (T) this.data;
    }

    public long getDumpDurationMillis() {
        return this.dumpDurationMillis;
    }

    public String getDumpFilePath() {
        return this.filePath;
    }

    public int getDumpType() {
        return this.dumpType;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setDumpDurationMillis(long j3) {
        this.dumpDurationMillis = j3;
    }

    public String toString() {
        return "FdLeakDumpResult{errorCode=" + this.errorCode + ", dumpFilePath='" + this.filePath + "', errorMessage='" + this.errorMessage + "'}";
    }

    public static FdLeakDumpResult failure(int i3, int i16, String str) {
        return new FdLeakDumpResult(i3, i16, str);
    }

    public FdLeakDumpResult(int i3, String str, Object obj) {
        this.dumpType = i3;
        this.data = obj;
        this.filePath = str;
    }
}
