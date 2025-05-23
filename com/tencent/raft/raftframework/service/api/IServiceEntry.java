package com.tencent.raft.raftframework.service.api;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IServiceEntry {
    ServiceWrapper createService();

    String getKey();

    int getPriority();
}
