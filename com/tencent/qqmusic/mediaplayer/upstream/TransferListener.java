package com.tencent.qqmusic.mediaplayer.upstream;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface TransferListener {
    void onBytesTransferError(long j3, long j16, long j17);

    void onBytesTransferred(long j3, long j16);

    void onBytesTransferring(long j3, long j16);

    void onTransferEnd();

    void onTransferStart();
}
