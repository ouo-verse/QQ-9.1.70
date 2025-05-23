package com.tencent.tav.core;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import java.nio.ByteBuffer;

/* loaded from: classes26.dex */
public interface AudioTapProcessor {
    ByteBuffer processAudioPCM(CMTime cMTime, ByteBuffer byteBuffer, AudioInfo audioInfo);

    void release();

    void seekTo(CMTime cMTime);
}
