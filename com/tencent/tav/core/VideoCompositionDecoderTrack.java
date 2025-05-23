package com.tencent.tav.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.VideoDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoCompositionDecoderTrack implements IDecoderTrack {
    private static final String TAG = "VideoComDecoderTrack";
    private static final int WAIT_TIME = 200;
    private Asset asset;
    private AssetExtension assetExtension;
    private AsynchronousVideoCompositionRequest compositionRequest;
    private int index;
    private VideoCompositionRenderContext renderContext;
    private int trackId;
    private VideoCompositing videoCompositing;
    private VideoComposition videoComposition;
    private List<IDecoderTrack> decoderTrackList = new ArrayList();
    private List<AssetTrack> assetTrackList = new ArrayList();
    private boolean asynced = true;
    private int frameRate = 30;
    private CMTime frameDuration = new CMTime(1, 30);
    private CMSampleState lastSampleState = new CMSampleState();

    public VideoCompositionDecoderTrack(Asset asset, AssetExtension assetExtension, int i3) {
        this.asset = asset;
        this.assetExtension = assetExtension;
        this.trackId = i3;
    }

    @NonNull
    private AsynchronousVideoCompositionRequest createVideoCompositionRequest(CMTime cMTime) {
        AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest = new AsynchronousVideoCompositionRequest(this, this.assetExtension);
        asynchronousVideoCompositionRequest.setRenderContext(this.renderContext);
        this.renderContext.getRenderContext().getParams().putParam(RenderContextParams.INLINE_KEY_NEXT_FRAME_TIME, nextFrameTime(cMTime));
        asynchronousVideoCompositionRequest.setCompositionTime(cMTime);
        VideoComposition videoComposition = this.videoComposition;
        if (videoComposition != null) {
            asynchronousVideoCompositionRequest.setVideoCompositionInstruction(VideoComposition.findInstruction(videoComposition, cMTime));
        }
        return asynchronousVideoCompositionRequest;
    }

    private CMSampleBuffer getSampleFromRequest(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        synchronized (this) {
            if (asynchronousVideoCompositionRequest.getStatus() == Integer.MIN_VALUE) {
                waitForRequestFinish(200);
            }
        }
        if (asynchronousVideoCompositionRequest.getStatus() != 0) {
            this.lastSampleState = CMSampleState.fromError(-3L);
            Logger.e(TAG, "readSample: failed 1 " + this.lastSampleState);
            return new CMSampleBuffer(CMSampleState.fromError(-3L));
        }
        this.lastSampleState = asynchronousVideoCompositionRequest.getComposedSampleBuffer().getState();
        return asynchronousVideoCompositionRequest.getComposedSampleBuffer();
    }

    private CMTime nextFrameTime(CMTime cMTime) {
        return cMTime.add(this.frameDuration);
    }

    @Nullable
    private CMSampleBuffer readSampleToRequest(CMTime cMTime, AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        CMTime cMTime2 = cMTime;
        for (IDecoderTrack iDecoderTrack : this.decoderTrackList) {
            CMSampleBuffer readSample = iDecoderTrack.readSample(cMTime2);
            if (readSample.getState().stateMatchingTo(-3, -2, -100)) {
                this.lastSampleState = new CMSampleState(readSample.getTime());
                Logger.e(TAG, "readSample: failed 0 " + readSample.getTime());
                return new CMSampleBuffer(readSample.getState(), (TextureInfo) null);
            }
            if (readSample.getState().stateMatchingTo(-1)) {
                if (this.decoderTrackList.size() <= 1) {
                    Logger.d(TAG, "readSample: finish 1");
                    return readSample;
                }
            } else {
                if (cMTime2.equalsTo(cMTime)) {
                    cMTime2 = readSample.getTime();
                    asynchronousVideoCompositionRequest.setCompositionTime(cMTime2);
                }
                asynchronousVideoCompositionRequest.appendCMSampleBuffer(readSample, iDecoderTrack.getTrackId());
            }
        }
        return null;
    }

    private void waitForRequestFinish(int i3) {
        synchronized (this) {
            try {
                wait(i3);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public synchronized void addTrack(AssetTrack assetTrack) {
        this.assetTrackList.add(assetTrack);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void asyncReadNextSample(CMTime cMTime) {
        if (!this.asynced) {
            return;
        }
        Iterator<IDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            it.next().asyncReadNextSample(cMTime);
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void clipRangeAndClearRange(CMTimeRange cMTimeRange) {
        Iterator<IDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            it.next().clipRangeAndClearRange(cMTimeRange);
        }
    }

    public Asset getAsset() {
        return this.asset;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getCurrentSampleTime() {
        return this.lastSampleState.getTime();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getDuration() {
        CMTime cMTime = CMTime.CMTimeZero;
        Iterator<IDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            CMTime duration = it.next().getDuration();
            if (duration.bigThan(cMTime)) {
                cMTime = duration;
            }
        }
        return cMTime;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getFrameDuration() {
        return this.frameDuration;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getFrameRate() {
        return this.frameRate;
    }

    public VideoCompositionRenderContext getRenderContext() {
        return this.renderContext;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getTrackId() {
        return this.trackId;
    }

    public VideoCompositing getVideoCompositing() {
        return this.videoCompositing;
    }

    public VideoComposition getVideoComposition() {
        return this.videoComposition;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readCurrentSample() {
        if (this.lastSampleState != null && this.videoCompositing != null && this.compositionRequest != null) {
            Logger.v(TAG, "readSample: startVideoCompositionRequest ");
            this.videoCompositing.startVideoCompositionRequest(this.compositionRequest);
            Logger.v(TAG, "readSample: startVideoCompositionRequest finish ");
            return getSampleFromRequest(this.compositionRequest);
        }
        return null;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample() {
        if (!this.lastSampleState.stateMatchingTo(-100) && !this.lastSampleState.isInvalid()) {
            return readSample(nextFrameTime(this.lastSampleState.getTime()));
        }
        return readSample(CMTime.CMTimeZero);
    }

    public CMSampleBuffer readSampleFromSeek() {
        CMTime cMTime = CMTime.CMTimeZero;
        if (!this.lastSampleState.stateMatchingTo(-100) && !this.lastSampleState.isInvalid()) {
            cMTime = this.lastSampleState.getTime().add(this.frameDuration);
        }
        cMTime.setFlag(1);
        return readSample(cMTime);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void release() {
        Logger.d(TAG, "release:start " + this);
        Iterator<IDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.decoderTrackList.clear();
        this.assetTrackList.clear();
        this.videoComposition = null;
        this.videoCompositing = null;
        this.renderContext = null;
        Logger.d(TAG, "release:finish " + this);
    }

    public synchronized void removeTrack(AssetTrack assetTrack) {
        this.assetTrackList.remove(assetTrack);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer seekTo(CMTime cMTime, boolean z16, boolean z17) {
        Logger.d(TAG, "seekTo:[timeUs " + cMTime + "] [needRead " + z16 + "] [quickSeek " + z17 + "]");
        Iterator<IDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            it.next().seekTo(cMTime, false, z17);
        }
        if (cMTime.bigThan(this.frameDuration)) {
            this.lastSampleState = new CMSampleState(cMTime.sub(this.frameDuration));
        } else {
            this.lastSampleState = new CMSampleState(cMTime);
        }
        if (z16) {
            return readSampleFromSeek();
        }
        return null;
    }

    public void setFrameDuration(CMTime cMTime) {
        this.frameDuration = cMTime;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setFrameRate(int i3) {
        this.frameRate = i3;
        Iterator<IDecoderTrack> it = this.decoderTrackList.iterator();
        while (it.hasNext()) {
            it.next().setFrameRate(i3);
        }
    }

    public void setRenderContext(VideoCompositionRenderContext videoCompositionRenderContext) {
        this.renderContext = videoCompositionRenderContext;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackIndex(int i3) {
        this.index = i3;
    }

    public void setVideoCompositing(VideoCompositing videoCompositing) {
        this.videoCompositing = videoCompositing;
    }

    public void setVideoComposition(VideoComposition videoComposition) {
        this.videoComposition = videoComposition;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start() {
        start(null);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator) {
        start(surfaceCreator, null);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator, CMTimeRange cMTimeRange) {
        Logger.d(TAG, "start:[start] " + cMTimeRange + " size - " + this.assetTrackList.size());
        VideoCompositionRenderContext videoCompositionRenderContext = new VideoCompositionRenderContext((RenderContext) surfaceCreator);
        this.renderContext = videoCompositionRenderContext;
        videoCompositionRenderContext.setVideoComposition(this.videoComposition);
        for (AssetTrack assetTrack : this.assetTrackList) {
            if (assetTrack.getMediaType() == 1) {
                VideoDecoderTrack videoDecoderTrack = new VideoDecoderTrack(assetTrack);
                videoDecoderTrack.setTrackIndex((this.index * 100) + this.decoderTrackList.size());
                this.decoderTrackList.add(videoDecoderTrack);
                if (cMTimeRange != null) {
                    videoDecoderTrack.start(surfaceCreator, cMTimeRange);
                } else {
                    CMTimeRange timeRange = assetTrack.getTimeRange();
                    videoDecoderTrack.start(surfaceCreator, timeRange == null ? null : new CMTimeRange(timeRange.getStart(), timeRange.getDuration()));
                }
            }
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample(CMTime cMTime) {
        if (this.videoCompositing == null) {
            this.lastSampleState = CMSampleState.fromError(-3L);
            Logger.v(TAG, "readSample: failed 2 " + this.lastSampleState);
            return new CMSampleBuffer(CMSampleState.fromError(-3L));
        }
        CMTime nextFrameTime = cMTime.getValue() < 0 ? nextFrameTime(this.lastSampleState.getTime()) : cMTime;
        AsynchronousVideoCompositionRequest createVideoCompositionRequest = createVideoCompositionRequest(nextFrameTime);
        nextFrameTime.setFlag(cMTime.getFlag());
        CMSampleBuffer readSampleToRequest = readSampleToRequest(nextFrameTime, createVideoCompositionRequest);
        if (readSampleToRequest != null) {
            return readSampleToRequest;
        }
        if (createVideoCompositionRequest.getSourceTrackIDs().size() == 0) {
            Logger.v(TAG, "readSample: finish 2");
            return new CMSampleBuffer(CMSampleState.fromError(-1L));
        }
        this.compositionRequest = createVideoCompositionRequest;
        this.videoCompositing.startVideoCompositionRequest(createVideoCompositionRequest);
        return getSampleFromRequest(createVideoCompositionRequest);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setDecodeType(IDecoder.DecodeType decodeType) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackSegments(List<DecoderTrackSegment> list) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setVolume(float f16) {
    }
}
