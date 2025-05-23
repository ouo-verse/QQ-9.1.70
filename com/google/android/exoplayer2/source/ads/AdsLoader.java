package com.google.android.exoplayer2.source.ads;

import android.view.ViewGroup;
import com.google.android.exoplayer2.ExoPlayer;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface AdsLoader {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface EventListener {
        void onAdClicked();

        void onAdLoadError(IOException iOException);

        void onAdPlaybackState(AdPlaybackState adPlaybackState);

        void onAdTapped();

        void onInternalAdLoadError(RuntimeException runtimeException);
    }

    void attachPlayer(ExoPlayer exoPlayer, EventListener eventListener, ViewGroup viewGroup);

    void detachPlayer();

    void handlePrepareError(int i3, int i16, IOException iOException);

    void release();

    void setSupportedContentTypes(int... iArr);
}
