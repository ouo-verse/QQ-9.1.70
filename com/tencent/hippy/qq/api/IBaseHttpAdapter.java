package com.tencent.hippy.qq.api;

import dk0.c;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IBaseHttpAdapter extends c {
    Executor getExecutor();

    @Override // dk0.c
    /* synthetic */ void sendRequest(dk0.a aVar, c.a aVar2, boolean z16);

    void shutdownExecutor();
}
