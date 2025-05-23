package com.tencent.tav.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AssetReaderVideoCompositionOutput extends AssetReaderOutput {
    private AssetExtension assetExtension;
    private AssetReader assetReader;
    private IContextCreate contextCreate;
    private int frameRate;
    private VideoCompositing videoCompositing;

    @Nullable
    private VideoComposition videoComposition;
    private IDecoderTrack videoDecoderTrack;

    @Nullable
    private Map<String, Object> videoSettings;
    private List<AssetTrack> videoTracks;

    @Nullable
    private VideoCompositing customVideoCompositor = new VideoCompositor();
    private boolean decoderStarted = false;
    private boolean revertMode = false;
    private int videoRevertCacheFrames = 60;

    public AssetReaderVideoCompositionOutput(List<AssetTrack> list, Map<String, Object> map, AssetExtension assetExtension) {
        this.frameRate = -1;
        this.videoTracks = list;
        this.videoSettings = map;
        this.assetExtension = assetExtension;
        this.mediaType = 1;
        if (map != null && map.containsKey("frame-rate")) {
            this.frameRate = ((Integer) map.get("frame-rate")).intValue();
        }
    }

    private void tryStartDecoder() {
        RenderContext renderContext;
        if (!this.decoderStarted) {
            this.decoderStarted = true;
            this.videoDecoderTrack.setFrameRate(this.frameRate);
            IContextCreate iContextCreate = this.contextCreate;
            if (iContextCreate == null) {
                renderContext = null;
            } else {
                renderContext = iContextCreate.renderContext();
            }
            AssetReader assetReader = this.assetReader;
            if (assetReader != null && assetReader.getTimeRange() != null) {
                CMTime start = this.assetReader.getTimeRange().getStart();
                if (start.equals(CMTime.CMTimeZero)) {
                    this.videoDecoderTrack.start(renderContext, this.assetReader.getTimeRange());
                    return;
                } else {
                    this.videoDecoderTrack.start(renderContext);
                    this.videoDecoderTrack.seekTo(start, false, false);
                    return;
                }
            }
            this.videoDecoderTrack.start(renderContext);
        }
    }

    @Nullable
    public VideoComposition getVideoComposition() {
        return this.videoComposition;
    }

    @Nullable
    public Map<String, Object> getVideoSettings() {
        return this.videoSettings;
    }

    public List<AssetTrack> getVideoTracks() {
        return this.videoTracks;
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    @NonNull
    public synchronized CMSampleBuffer nextSampleBuffer() {
        CMSampleBuffer readSample;
        if (this.videoDecoderTrack != null) {
            tryStartDecoder();
            IDecoderTrack iDecoderTrack = this.videoDecoderTrack;
            if (iDecoderTrack == null) {
                readSample = new CMSampleBuffer(CMSampleState.fromError(-100L));
            } else {
                readSample = iDecoderTrack.readSample();
            }
            if (readSample.getTime().getTimeUs() >= 0) {
                this.videoDecoderTrack.asyncReadNextSample(readSample.getTime());
            }
            return readSample;
        }
        return new CMSampleBuffer(CMSampleState.fromError(-100L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.tav.core.AssetReaderOutput
    public synchronized void release() {
        IDecoderTrack iDecoderTrack = this.videoDecoderTrack;
        if (iDecoderTrack != null) {
            iDecoderTrack.release();
        }
    }

    public void setRevertVideoMaxFrameCounts(int i3) {
        this.videoRevertCacheFrames = i3;
    }

    public void setVideoCompositing(VideoCompositing videoCompositing) {
        this.videoCompositing = videoCompositing;
    }

    public void setVideoComposition(@Nullable VideoComposition videoComposition) {
        this.videoComposition = videoComposition;
    }

    public void setVideoRevertMode(boolean z16) {
        this.revertMode = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.tav.core.AssetReaderOutput
    public void start(@Nullable IContextCreate iContextCreate, AssetReader assetReader) {
        this.assetReader = assetReader;
        VideoCompositionDecoderTrack videoCompositionDecoderTrack = new VideoCompositionDecoderTrack(assetReader.getAsset(), this.assetExtension, 1);
        int i3 = this.frameRate;
        for (AssetTrack assetTrack : this.videoTracks) {
            if (assetTrack != null && assetTrack.isEnabled()) {
                videoCompositionDecoderTrack.addTrack(assetTrack);
                if (assetTrack.getNominalFrameRate() > 0.0f && this.frameRate < 0) {
                    i3 = (int) Math.min(assetTrack.getNominalFrameRate(), i3);
                }
            }
        }
        if (i3 <= 0) {
            i3 = 30;
        }
        videoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
        videoCompositionDecoderTrack.setVideoCompositing(this.videoCompositing);
        videoCompositionDecoderTrack.setFrameRate(i3);
        videoCompositionDecoderTrack.setFrameDuration(new CMTime(1L, i3));
        this.contextCreate = iContextCreate;
        if (this.revertMode) {
            CachedVideoDecoderTrack cachedVideoDecoderTrack = new CachedVideoDecoderTrack(videoCompositionDecoderTrack, true);
            this.videoDecoderTrack = cachedVideoDecoderTrack;
            cachedVideoDecoderTrack.setMaxFrameCacheSize(this.videoRevertCacheFrames);
            return;
        }
        this.videoDecoderTrack = videoCompositionDecoderTrack;
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void markConfigurationAsFinal() {
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void preDecode() {
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void stopPreDecode() {
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void resetForReadingTimeRanges(List<CMTimeRange> list) {
    }
}
