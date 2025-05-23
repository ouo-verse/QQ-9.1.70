package com.qq.e.tg.nativ;

import com.qq.e.comm.util.AdError;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface NativeExpressMediaListener {
    void onVideoCached(NativeExpressADView nativeExpressADView);

    void onVideoComplete(NativeExpressADView nativeExpressADView);

    void onVideoError(NativeExpressADView nativeExpressADView, AdError adError);

    void onVideoInit(NativeExpressADView nativeExpressADView);

    void onVideoLoading(NativeExpressADView nativeExpressADView);

    void onVideoPageClose(NativeExpressADView nativeExpressADView);

    void onVideoPageOpen(NativeExpressADView nativeExpressADView);

    void onVideoPause(NativeExpressADView nativeExpressADView);

    void onVideoReady(NativeExpressADView nativeExpressADView, long j3);

    void onVideoStart(NativeExpressADView nativeExpressADView);
}
