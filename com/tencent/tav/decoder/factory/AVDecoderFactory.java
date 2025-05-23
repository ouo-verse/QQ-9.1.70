package com.tencent.tav.decoder.factory;

import androidx.annotation.Nullable;
import com.tencent.tav.decoder.AudioDecoder;
import com.tencent.tav.decoder.IAudioDecoder;
import com.tencent.tav.decoder.IVideoDecoder;
import com.tencent.tav.decoder.ImageDecoder;
import com.tencent.tav.decoder.VideoDecoder;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AVDecoderFactory implements IDecoderFactory {
    private static IDecoderFactory instance = new AVDecoderFactory();

    public static IDecoderFactory getInstance() {
        return instance;
    }

    public static void setInstance(IDecoderFactory iDecoderFactory) {
        instance = iDecoderFactory;
    }

    @Override // com.tencent.tav.decoder.factory.IDecoderFactory
    @Nullable
    public IAudioDecoder createAudioDecoder(IVideoDecoder.Params params) throws Exception {
        if (params.sourceType == 2) {
            return new AudioDecoder(params);
        }
        return null;
    }

    @Override // com.tencent.tav.decoder.factory.IDecoderFactory
    @Nullable
    public IVideoDecoder createVideoDecoder(IVideoDecoder.Params params) throws Exception {
        int i3 = params.sourceType;
        if (i3 == 3) {
            return new ImageDecoder(params);
        }
        if (i3 == 1) {
            return new VideoDecoder(params);
        }
        return null;
    }
}
