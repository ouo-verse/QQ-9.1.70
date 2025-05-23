package com.tencent.mobileqq.zplan.room.impl.trtc;

import com.tencent.sqshow.zootopia.data.ErrorMessage;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCError;", "", "Lcom/tencent/sqshow/zootopia/data/a;", "convertToErrorMessage", "", "errorCode", "I", "getErrorCode", "()I", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "LOAD_SO_FAILED", "REQUEST_AV_FOCUS_FAILED", "INIT_TRTC_FAILED", "REQUEST_SIGN_FAILED", "REQUEST_PERMISSION_FAILED", "OPEN_MIC_FAILED", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public enum ZplanTRTCError {
    LOAD_SO_FAILED(-1, "\u52a0\u8f7dso\u51fa\u9519"),
    REQUEST_AV_FOCUS_FAILED(-2, "\u83b7\u53d6\u97f3\u9891\u7126\u70b9\u5931\u8d25"),
    INIT_TRTC_FAILED(-3, "\u521d\u59cb\u5316trtc\u5931\u8d25"),
    REQUEST_SIGN_FAILED(-4, "\u83b7\u53d6\u7b7e\u540d\u5931\u8d25"),
    REQUEST_PERMISSION_FAILED(-5, "\u83b7\u53d6\u6743\u9650\u5931\u8d25"),
    OPEN_MIC_FAILED(-6, "\u53ea\u6709\u4e3b\u64ad\u624d\u80fd\u8bf4\u8bdd");

    private final int errorCode;
    private final String errorMessage;

    ZplanTRTCError(int i3, String str) {
        this.errorCode = i3;
        this.errorMessage = str;
    }

    public final ErrorMessage convertToErrorMessage() {
        return new ErrorMessage(this.errorCode, this.errorMessage);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
