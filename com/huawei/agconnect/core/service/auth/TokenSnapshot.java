package com.huawei.agconnect.core.service.auth;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface TokenSnapshot {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum State {
        SIGNED_IN,
        TOKEN_UPDATED,
        TOKEN_INVALID,
        SIGNED_OUT
    }

    State getState();

    String getToken();
}
