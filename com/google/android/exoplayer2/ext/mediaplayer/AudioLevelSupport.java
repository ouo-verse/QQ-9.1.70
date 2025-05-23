package com.google.android.exoplayer2.ext.mediaplayer;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface AudioLevelSupport {
    double getAudioDuration();

    double getAudioEnergy();

    double getAudioLevel();

    void setCalculateAudioLevel(boolean z16);
}
