package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface BitrateAdjuster {
    int getAdjustedBitrateBps();

    int getCodecConfigFramerate();

    void reportEncodedFrame(int i3);

    void setTargets(int i3, int i16);
}
