package com.huawei.agconnect.core.service.auth;

import com.huawei.hmf.tasks.Task;

/* loaded from: classes2.dex */
public interface AuthProvider {
    void addTokenListener(OnTokenListener onTokenListener);

    Task<Token> getTokens();

    Task<Token> getTokens(boolean z16);

    String getUid();

    void removeTokenListener(OnTokenListener onTokenListener);
}
