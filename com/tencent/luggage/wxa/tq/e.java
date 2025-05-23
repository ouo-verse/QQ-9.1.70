package com.tencent.luggage.wxa.tq;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface e {
    void clearFormData();

    void clearHttpAuthUsernamePassword();

    void clearUsernamePassword();

    String[] getHttpAuthUsernamePassword(String str, String str2);

    boolean hasFormData();

    boolean hasHttpAuthUsernamePassword();

    boolean hasUsernamePassword();

    void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4);
}
