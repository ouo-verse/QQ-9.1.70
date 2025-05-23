package com.tencent.qqmusic.mediaplayer.upstream;

import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface UriLoader {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Callback {
        void onCancelled();

        void onFailed(Throwable th5);

        void onSucceed(StreamingRequest streamingRequest);
    }

    void cancelLoading();

    boolean isLoading();

    void startLoading(int i3, TimeUnit timeUnit, Callback callback);
}
