package com.tencent.qqmusic.mediaplayer.upstream;

import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface Loader {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Factory {
        Loader createLoader(Listener listener);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Listener {
        void onLoadCancelled(boolean z16);

        void onLoadCompleted();

        void onLoadError(IOException iOException);

        void onLoadProgress(long j3, long j16);
    }

    void cancelLoading();

    long getUpstreamSize();

    boolean isLoading();

    void prepare() throws IOException;

    void shutdown() throws InterruptedException;

    void startLoading(@NonNull Chunk chunk);
}
