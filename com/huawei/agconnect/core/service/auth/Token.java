package com.huawei.agconnect.core.service.auth;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface Token {
    long getExpiration();

    long getIssuedAt();

    long getNotBefore();

    String getTokenString();
}
