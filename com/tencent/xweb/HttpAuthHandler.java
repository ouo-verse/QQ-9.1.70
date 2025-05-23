package com.tencent.xweb;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface HttpAuthHandler {
    void cancel();

    void proceed(String str, String str2);

    boolean useHttpAuthUsernamePassword();
}
