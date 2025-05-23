package com.huawei.agconnect;

import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;

/* loaded from: classes2.dex */
public interface CustomAuthProvider {
    Task<Token> getTokens(boolean z16);

    String getUid();
}
