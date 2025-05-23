package com.tencent.tav.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.core.AssetReader;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class AssetReaderOutput {
    public static final String TAG = "AssetReaderOutput";
    protected int mediaType;
    private StatusListener statusListener;
    protected boolean alwaysCopiesSampleData = false;
    protected boolean supportsRandomAccess = false;
    private CMSampleBuffer nextAudioBuffer = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface StatusListener {
        void statusChanged(AssetReaderOutput assetReaderOutput, AssetReader.AVAssetReaderStatus aVAssetReaderStatus);
    }

    private CMSampleBuffer getNextAudioFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ExportConfig exportConfig) {
        if (byteBuffer != null && exportConfig != null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            Logger.v(TAG, "inputBuffer.size:" + byteBuffer2.capacity() + " position:" + position + " limit:" + limit);
            if (position < limit) {
                int min = Math.min(limit - position, byteBuffer2.capacity()) + position;
                byteBuffer.limit(min);
                byteBuffer.position(position);
                byteBuffer2.put(byteBuffer);
                byteBuffer2.flip();
                CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(this.nextAudioBuffer.getTime().add(DecoderUtils.getAudioDuration(position, exportConfig.getAudioChannelCount(), exportConfig.getAudioSampleRateHz())), byteBuffer2);
                byteBuffer.position(min);
                byteBuffer.limit(limit);
                return cMSampleBuffer;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addStatusListener(StatusListener statusListener) {
        this.statusListener = statusListener;
    }

    public final CMSampleBuffer copyNextAudioSampleBuffer(ByteBuffer byteBuffer, CMTime cMTime, ExportConfig exportConfig) {
        CMSampleBuffer nextAudioFrame;
        CMSampleBuffer cMSampleBuffer = this.nextAudioBuffer;
        if (cMSampleBuffer != null && (nextAudioFrame = getNextAudioFrame(cMSampleBuffer.getSampleByteBuffer(), byteBuffer, exportConfig)) != null) {
            return nextAudioFrame;
        }
        CMSampleBuffer nextSampleBuffer = nextSampleBuffer();
        Logger.d(TAG, "nextSampleBuffer status:" + nextSampleBuffer.getState().getStateCode() + " time:" + nextSampleBuffer.getTime().getTimeUs() + " inputBuffer.size:" + nextSampleBuffer.getSampleByteBuffer().capacity() + " position:" + nextSampleBuffer.getSampleByteBuffer().position() + " limit:" + nextSampleBuffer.getSampleByteBuffer().limit());
        if (nextSampleBuffer.getTime().getTimeUs() >= 0) {
            boolean smallThan = nextSampleBuffer.getTime().smallThan(CMTime.CMTimeZero);
            if (nextSampleBuffer.getSampleByteBuffer().position() != 0) {
                Logger.e(TAG, "copyNextAudioSampleBuffer change sampleBuffer position, time:" + nextSampleBuffer.getTime().getTimeUs() + " inputBuffer.size:" + nextSampleBuffer.getSampleByteBuffer().capacity() + " position:" + nextSampleBuffer.getSampleByteBuffer().position() + " limit:" + nextSampleBuffer.getSampleByteBuffer().limit());
                if (EncoderWriter.ENABLE_CHANGE_AUDIO_BYTEBUFFER_POSITION) {
                    nextSampleBuffer.getSampleByteBuffer().position(0);
                    Logger.e(TAG, "copyNextAudioSampleBuffer change sampleBuffer position success");
                }
            }
            if (!smallThan) {
                ByteBuffer allocate = ByteBuffer.allocate(nextSampleBuffer.getSampleByteBuffer().limit());
                allocate.order(nextSampleBuffer.getSampleByteBuffer().order());
                allocate.put(nextSampleBuffer.getSampleByteBuffer());
                allocate.flip();
                this.nextAudioBuffer = new CMSampleBuffer(nextSampleBuffer.getTime().sub(cMTime), allocate);
            } else {
                this.nextAudioBuffer = nextSampleBuffer;
            }
            CMSampleBuffer nextAudioFrame2 = getNextAudioFrame(this.nextAudioBuffer.getSampleByteBuffer(), byteBuffer, exportConfig);
            if (nextAudioFrame2 != null) {
                return nextAudioFrame2;
            }
            return nextSampleBuffer;
        }
        if (nextSampleBuffer.getState().getStateCode() == -1) {
            StatusListener statusListener = this.statusListener;
            if (statusListener != null) {
                statusListener.statusChanged(this, AssetReader.AVAssetReaderStatus.AssetReaderStatusCompleted);
            }
            return nextSampleBuffer;
        }
        StatusListener statusListener2 = this.statusListener;
        if (statusListener2 != null) {
            statusListener2.statusChanged(this, AssetReader.AVAssetReaderStatus.AssetReaderStatusFailed);
        }
        return nextSampleBuffer;
    }

    @NonNull
    public final CMSampleBuffer copyNextSampleBuffer() {
        CMSampleBuffer nextSampleBuffer = nextSampleBuffer();
        if (nextSampleBuffer.getTime().getTimeUs() > 0) {
            return nextSampleBuffer;
        }
        if (nextSampleBuffer.getState().getStateCode() == -1) {
            StatusListener statusListener = this.statusListener;
            if (statusListener != null) {
                statusListener.statusChanged(this, AssetReader.AVAssetReaderStatus.AssetReaderStatusCompleted);
            }
            return nextSampleBuffer;
        }
        StatusListener statusListener2 = this.statusListener;
        if (statusListener2 != null) {
            statusListener2.statusChanged(this, AssetReader.AVAssetReaderStatus.AssetReaderStatusFailed);
        }
        return nextSampleBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long duration() {
        return 0L;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public boolean isAlwaysCopiesSampleData() {
        return this.alwaysCopiesSampleData;
    }

    public boolean isSupportsRandomAccess() {
        return this.supportsRandomAccess;
    }

    public abstract void markConfigurationAsFinal();

    @NonNull
    public abstract CMSampleBuffer nextSampleBuffer();

    public abstract void preDecode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void release();

    public abstract void resetForReadingTimeRanges(List<CMTimeRange> list);

    public void setAlwaysCopiesSampleData(boolean z16) {
        this.alwaysCopiesSampleData = z16;
    }

    public void setSupportsRandomAccess(boolean z16) {
        this.supportsRandomAccess = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void start(@Nullable IContextCreate iContextCreate, AssetReader assetReader);

    public abstract void stopPreDecode();
}
