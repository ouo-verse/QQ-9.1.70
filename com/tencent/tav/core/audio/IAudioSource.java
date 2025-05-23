package com.tencent.tav.core.audio;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IAudioSource<T extends IDecoderTrack> {
    CMTime getDuration();

    T getSourceAudioDecoder(CMTimeRange cMTimeRange);
}
