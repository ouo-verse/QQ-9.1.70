package com.huya.huyasdk.service.api;

import hynb.n.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ILoginService {
    long getLoginUid();

    String getToken();

    void init(b bVar);

    boolean isLogin();
}
