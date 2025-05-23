package com.tencent.tav.decoder.factory;

import androidx.annotation.Nullable;
import com.tencent.tav.decoder.IAudioDecoder;
import com.tencent.tav.decoder.IVideoDecoder;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IDecoderFactory {
    @Nullable
    IAudioDecoder createAudioDecoder(IVideoDecoder.Params params) throws Exception;

    @Nullable
    IVideoDecoder createVideoDecoder(IVideoDecoder.Params params) throws Exception;
}
