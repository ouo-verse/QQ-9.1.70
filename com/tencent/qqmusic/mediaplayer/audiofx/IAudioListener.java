package com.tencent.qqmusic.mediaplayer.audiofx;

import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.BufferInfo;
import com.tencent.qqmusic.mediaplayer.FloatBufferInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IAudioListener {
    long getActualTime(long j3);

    boolean isEnabled();

    boolean isTerminal();

    boolean onPcm(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j3);

    boolean onPcm(FloatBufferInfo floatBufferInfo, FloatBufferInfo floatBufferInfo2, long j3);

    long onPlayerReady(int i3, AudioInformation audioInformation, long j3);

    void onPlayerSeekComplete(long j3);

    void onPlayerStopped();
}
