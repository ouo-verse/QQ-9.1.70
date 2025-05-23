package com.tencent.raft.raftframework.service;

import com.tencent.raft.raftframework.IServiceProvider;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRAServiceManager {
    void destroy();

    <T> T getService(Class<T> cls, IServiceProvider iServiceProvider);
}
