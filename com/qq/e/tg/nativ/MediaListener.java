package com.qq.e.tg.nativ;

import com.qq.e.comm.util.AdError;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface MediaListener {
    void onADButtonClicked();

    void onFullScreenChanged(boolean z16);

    void onReplayButtonClicked();

    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoPause();

    void onVideoReady(long j3);

    void onVideoStart();
}
