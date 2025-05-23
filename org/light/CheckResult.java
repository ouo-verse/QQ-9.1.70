package org.light;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CheckResult {
    public static final int LightResourceCheckerError_Length = 2;
    public static final int LightResourceCheckerError_None = 0;
    public static final int LightResourceCheckerError_NotExist = 1;
    public boolean checkPass;
    public int errorCode;
    public long errorLength;
    public String errorPath;
    public long recordLength;

    public CheckResult(boolean z16, int i3, String str, long j3, long j16) {
        this.checkPass = z16;
        this.errorCode = i3;
        this.errorPath = str;
        this.errorLength = j3;
        this.recordLength = j16;
    }
}
