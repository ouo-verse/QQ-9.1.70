package com.tencent.ecommerce.biz.register.network;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/register/network/CaptchaErrorCode;", "", "errorCode", "", "(Ljava/lang/String;II)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "SEND_SMS_TOO_FREQUENT", "SEND_SMS_TOO_MANY", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum CaptchaErrorCode {
    SEND_SMS_TOO_FREQUENT(5103),
    SEND_SMS_TOO_MANY(10010);

    private int errorCode;

    CaptchaErrorCode(int i3) {
        this.errorCode = i3;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i3) {
        this.errorCode = i3;
    }
}
