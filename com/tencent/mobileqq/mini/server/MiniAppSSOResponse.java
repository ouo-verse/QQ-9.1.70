package com.tencent.mobileqq.mini.server;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/mini/server/MiniAppSSOResponse;", "", "retCode", "", "errMsg", "", "data", "", "(ILjava/lang/String;[B)V", "getData", "()[B", "getErrMsg", "()Ljava/lang/String;", "getRetCode", "()I", "isDataValid", "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppSSOResponse {
    public static final int SUCC = 0;
    private final byte[] data;
    private final String errMsg;
    private final int retCode;

    public MiniAppSSOResponse() {
        this(0, null, null, 7, null);
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final int getRetCode() {
        return this.retCode;
    }

    public final boolean isDataValid() {
        byte[] bArr;
        if (this.retCode != 0 || (bArr = this.data) == null) {
            return false;
        }
        return (bArr.length == 0) ^ true;
    }

    public MiniAppSSOResponse(int i3, String errMsg, byte[] bArr) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.retCode = i3;
        this.errMsg = errMsg;
        this.data = bArr;
    }

    public /* synthetic */ MiniAppSSOResponse(int i3, String str, byte[] bArr, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? "unknown" : str, (i16 & 4) != 0 ? null : bArr);
    }
}
