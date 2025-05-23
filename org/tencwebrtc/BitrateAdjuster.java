package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
interface BitrateAdjuster {
    int getAdjustedBitrateBps();

    int getCodecConfigFramerate();

    void reportEncodedFrame(int i3);

    void setTargets(int i3, int i16);
}
