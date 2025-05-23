package com.tencent.luggage.wxa.fk;

import com.tenpay.sdk.net.core.comm.CGIErrorCode;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum c {
    SUCCESS(0, "OK"),
    ILLEGAL_LINK(-1001, "illegal link"),
    DECODE_LINK_FAIL(-1002, "decode link fail"),
    USER_CANCEL(-1003, "user cancel"),
    CONTEXT_RELEASE(-1004, "context release"),
    INTERRUPT(-1005, "interrupt"),
    LAUNCH_PHASE_FAIL(-1006, "launch phase fail"),
    UNKNOWN(CGIErrorCode.ERROR_NETWORK_END, "unknown");


    /* renamed from: a, reason: collision with root package name */
    public final int f126238a;

    /* renamed from: b, reason: collision with root package name */
    public final String f126239b;

    c(int i3, String str) {
        this.f126238a = i3;
        this.f126239b = str;
    }

    public final int b() {
        return this.f126238a;
    }
}
