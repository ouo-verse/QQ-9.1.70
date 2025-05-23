package com.google.android.exoplayer2.upstream;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface TransferListener<S> {
    void onBytesTransferred(S s16, int i3);

    void onTransferEnd(S s16);

    void onTransferStart(S s16, DataSpec dataSpec);
}
