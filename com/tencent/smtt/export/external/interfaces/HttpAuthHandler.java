package com.tencent.smtt.export.external.interfaces;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface HttpAuthHandler {
    void cancel();

    void proceed(String str, String str2);

    boolean useHttpAuthUsernamePassword();
}
