package com.tencent.raft.standard.channel;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRChannel {
    void cancelTransfer(long j3);

    long transfer(BaseRTransferArgs baseRTransferArgs, IRTransferCallback iRTransferCallback);
}
