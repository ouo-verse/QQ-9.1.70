package com.tenpay.face;

import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tenpay/face/FaceVerifyErr;", "", "retCode", "", "retMsg", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getRetCode", "()I", "getRetMsg", "()Ljava/lang/String;", "OK", "ERROR_CANCEL", "ERROR_PARAMS", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public enum FaceVerifyErr {
    OK(0, "\u6210\u529f"),
    ERROR_CANCEL(201, ShareJsPlugin.ERRMSG_INVITE_CANCEL),
    ERROR_PARAMS(-1, "\u53c2\u6570\u5f02\u5e38");

    private final int retCode;

    @NotNull
    private final String retMsg;

    FaceVerifyErr(int i3, String str) {
        this.retCode = i3;
        this.retMsg = str;
    }

    public final int getRetCode() {
        return this.retCode;
    }

    @NotNull
    public final String getRetMsg() {
        return this.retMsg;
    }
}
