package com.tencent.qqlive.tvkplayer.postprocess.api;

import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx;

/* loaded from: classes23.dex */
public interface ITVKTPAudioProcessorInternal extends ITVKAudioFxProcessor {
    void connect();

    ITVKAudioFx currentEffect();

    void destroy();

    void disconnect();

    boolean hasAudioEffect();

    void reset();
}
