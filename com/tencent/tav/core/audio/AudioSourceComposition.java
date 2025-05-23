package com.tencent.tav.core.audio;

import androidx.annotation.NonNull;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.IDecoder;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioSourceComposition implements IAudioSource<AudioCompositionDecoderTrack> {
    private Asset mAsset;
    private AudioInfo mAudioInfo = new AudioInfo(44100, 1, 2);

    public AudioSourceComposition(@NonNull Asset asset) {
        this.mAsset = asset;
    }

    @Override // com.tencent.tav.core.audio.IAudioSource
    public CMTime getDuration() {
        return this.mAsset.getDuration();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tav.core.audio.IAudioSource
    public AudioCompositionDecoderTrack getSourceAudioDecoder(CMTimeRange cMTimeRange) {
        AudioCompositionDecoderTrack audioCompositionDecoderTrack = new AudioCompositionDecoderTrack(this.mAsset.getTracks(), -1);
        audioCompositionDecoderTrack.setAudioInfo(this.mAudioInfo);
        audioCompositionDecoderTrack.setDecodeType(IDecoder.DecodeType.Audio);
        audioCompositionDecoderTrack.setFrameRate(44);
        return audioCompositionDecoderTrack;
    }
}
