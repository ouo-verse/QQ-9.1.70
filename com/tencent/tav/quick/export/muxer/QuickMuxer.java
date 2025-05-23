package com.tencent.tav.quick.export.muxer;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes26.dex */
public class QuickMuxer implements IMediaMuxer {
    private static final String TAG = "QuickMuxer";
    private final MediaMuxer mMuxer;
    private volatile boolean mIsStarted = false;
    private int mVideoTrackIndex = -1;
    private int mAudioTrackIndex = -1;
    private MediaFormat mAudioFormat = null;
    private MediaExtractor mAudioExtractor = null;
    private AtomicInteger mMuxerStopCount = new AtomicInteger(2);
    private AtomicInteger mMuxerReleaseCount = new AtomicInteger(2);
    private String mInputVideoPath = "";

    public QuickMuxer(@NonNull String str, int i3) throws IOException {
        this.mMuxer = new MediaMuxer(str, i3);
    }

    private synchronized void initAudio() {
        if (!TextUtils.isEmpty(this.mInputVideoPath)) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mAudioExtractor = mediaExtractor;
            try {
                mediaExtractor.setDataSource(this.mInputVideoPath);
                int selectTrack = DecoderUtils.selectTrack(this.mAudioExtractor, "audio/");
                if (selectTrack >= 0) {
                    this.mAudioExtractor.selectTrack(selectTrack);
                    MediaFormat trackFormat = this.mAudioExtractor.getTrackFormat(selectTrack);
                    this.mAudioFormat = trackFormat;
                    this.mAudioTrackIndex = this.mMuxer.addTrack(trackFormat);
                }
            } catch (IOException e16) {
                Logger.e(TAG, "create input video media extractor failed ", e16);
            }
        }
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public int addTrack(@NonNull MediaFormat mediaFormat) {
        int addTrack = this.mMuxer.addTrack(mediaFormat);
        if (mediaFormat.containsKey("mime")) {
            String string = mediaFormat.getString("mime");
            Logger.d(TAG, "add track mime:" + string);
            if (string.contains("video")) {
                this.mVideoTrackIndex = addTrack;
                initAudio();
            }
        }
        return addTrack;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public int audioTrackIndex() {
        return this.mAudioTrackIndex;
    }

    public synchronized MediaExtractor getAudioExtractor() {
        return this.mAudioExtractor;
    }

    public synchronized MediaFormat getAudioFormat() {
        return this.mAudioFormat;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public boolean ignoreHeader() {
        return true;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public boolean isMuxerStarted() {
        return this.mIsStarted;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void release() {
        if (this.mMuxerReleaseCount.decrementAndGet() == 0) {
            this.mMuxer.release();
            this.mIsStarted = false;
        }
        Logger.d(TAG, "quick release " + this.mMuxerReleaseCount.get());
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void setExportConfig(@NonNull ExportConfig exportConfig) {
        this.mMuxer.setOrientationHint(exportConfig.getOutputRotate() * 90);
    }

    public synchronized void setInputVideoPath(String str) {
        this.mInputVideoPath = str;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void start() {
        this.mMuxer.start();
        this.mIsStarted = true;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void stop() {
        if (this.mMuxerStopCount.decrementAndGet() == 0) {
            this.mMuxer.stop();
            this.mIsStarted = false;
        }
        Logger.d(TAG, "quick stop " + this.mMuxerStopCount.get());
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public int videoTrackIndex() {
        return this.mVideoTrackIndex;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void writeSampleData(int i3, @NonNull ByteBuffer byteBuffer, @NonNull MediaCodec.BufferInfo bufferInfo) {
        this.mMuxer.writeSampleData(i3, byteBuffer, bufferInfo);
    }
}
