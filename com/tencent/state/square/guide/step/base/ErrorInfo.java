package com.tencent.state.square.guide.step.base;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/guide/step/base/ErrorInfo;", "Ljava/io/Serializable;", "errCode", "", "errMsg", "", "(ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ErrorInfo implements Serializable {
    private final int errCode;
    private final String errMsg;

    public ErrorInfo(int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.errCode = i3;
        this.errMsg = errMsg;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public String toString() {
        return '{' + this.errCode + ", " + this.errMsg + '}';
    }
}
