package com.tencent.raft.standard.report;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRReport {
    boolean report(BaseEvent baseEvent);

    boolean reportToBeacon(String str, BaseEvent baseEvent);
}
