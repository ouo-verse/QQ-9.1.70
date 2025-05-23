package org.aspectj.lang;

import com.tencent.mobileqq.activity.recent.MsgSummary;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NoAspectBoundException extends RuntimeException {
    Throwable cause;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NoAspectBoundException(String str, Throwable th5) {
        super(str);
        if (th5 != null) {
            str = "Exception while initializing " + str + MsgSummary.STR_COLON + th5;
        }
        this.cause = th5;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public NoAspectBoundException() {
    }
}
