package com.tencent.luggage.wxaapi;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum LaunchWxaAppWithShortLinkResult {
    SUCCESS(com.tencent.luggage.wxa.fk.c.SUCCESS.b()),
    ILLEGAL_LINK(com.tencent.luggage.wxa.fk.c.ILLEGAL_LINK.b()),
    DECODE_LINK_FAIL(com.tencent.luggage.wxa.fk.c.DECODE_LINK_FAIL.b()),
    USER_CANCEL(com.tencent.luggage.wxa.fk.c.USER_CANCEL.b()),
    CONTEXT_RELEASE(com.tencent.luggage.wxa.fk.c.CONTEXT_RELEASE.b()),
    INTERRUPT(com.tencent.luggage.wxa.fk.c.INTERRUPT.b()),
    LAUNCH_PHASE_FAIL(com.tencent.luggage.wxa.fk.c.LAUNCH_PHASE_FAIL.b()),
    UNKNOWN(com.tencent.luggage.wxa.fk.c.UNKNOWN.b());

    public final int code;

    LaunchWxaAppWithShortLinkResult(int i3) {
        this.code = i3;
    }
}
