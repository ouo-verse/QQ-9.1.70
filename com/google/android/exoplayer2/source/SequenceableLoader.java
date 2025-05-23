package com.google.android.exoplayer2.source;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface SequenceableLoader {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface Callback<T extends SequenceableLoader> {
        void onContinueLoadingRequested(T t16);
    }

    boolean continueLoading(long j3);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    void reevaluateBuffer(long j3);
}
