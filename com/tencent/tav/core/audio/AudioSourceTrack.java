package com.tencent.tav.core.audio;

import androidx.annotation.NonNull;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioDecoderTrack;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
class AudioSourceTrack implements IAudioSource<AudioDecoderTrack> {
    public static final String TAG = "AudioCompositionTrackEncoder2";
    private AssetTrack mAssetTrack;
    private AudioInfo mAudioInfo = new AudioInfo(44100, 1, 2);

    public AudioSourceTrack(@NonNull AssetTrack assetTrack) {
        this.mAssetTrack = assetTrack;
    }

    @Override // com.tencent.tav.core.audio.IAudioSource
    public CMTime getDuration() {
        return this.mAssetTrack.getDuration();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tav.core.audio.IAudioSource
    public AudioDecoderTrack getSourceAudioDecoder(CMTimeRange cMTimeRange) {
        AudioDecoderTrack audioDecoderTrack = new AudioDecoderTrack();
        if (this.mAssetTrack.getMediaType() != 2) {
            return null;
        }
        AudioDecoderTrack audioDecoderTrack2 = new AudioDecoderTrack();
        List<AssetTrackSegment> segments = this.mAssetTrack.getSegments();
        ArrayList arrayList = new ArrayList();
        for (AssetTrackSegment assetTrackSegment : segments) {
            DecoderAssetTrack create = DecoderAssetTrack.create(this.mAssetTrack, assetTrackSegment);
            CMTimeRange source = assetTrackSegment.getTimeMapping().getSource();
            DecoderTrackSegment decoderTrackSegment = new DecoderTrackSegment(new CMTimeRange(source.getStart(), source.getDuration()), create);
            decoderTrackSegment.setScaledDuration(assetTrackSegment.getScaleDuration());
            arrayList.add(decoderTrackSegment);
        }
        audioDecoderTrack2.setTrackID(this.mAssetTrack.getTrackID());
        audioDecoderTrack2.setTrackSegments(arrayList);
        audioDecoderTrack2.setFrameRate((int) this.mAssetTrack.getNominalFrameRate());
        audioDecoderTrack2.setVolume(this.mAssetTrack.getPreferredVolume());
        audioDecoderTrack2.setDecodeType(IDecoder.DecodeType.Audio);
        audioDecoderTrack2.setAudioInfo(this.mAudioInfo);
        audioDecoderTrack2.clipRangeAndClearRange(new CMTimeRange(CMTime.CMTimeZero, cMTimeRange.getEnd()));
        return audioDecoderTrack;
    }
}
