package com.tencent.tav.decoder.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.decoder.logger.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
@RequiresApi(api = 18)
/* loaded from: classes26.dex */
public class DefaultMediaMuxer implements IMediaMuxer {
    private final MediaMuxer muxer;
    private final String TAG = "DefaultMediaMuxer";
    private boolean isStarted = false;
    private int videoTrackIndex = -1;
    private int audioTrackIndex = -1;
    private long audioPtsAdjust = -1;

    public DefaultMediaMuxer(@NonNull String str, int i3) throws IOException {
        this.muxer = new MediaMuxer(str, i3);
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public int addTrack(@NonNull MediaFormat mediaFormat) {
        int addTrack = this.muxer.addTrack(mediaFormat);
        if (mediaFormat.containsKey("mime")) {
            String string = mediaFormat.getString("mime");
            Logger.i("DefaultMediaMuxer", "add track mime:" + string);
            if (string.contains("video")) {
                this.videoTrackIndex = addTrack;
            } else if (string.contains("audio")) {
                this.audioTrackIndex = addTrack;
            }
        }
        return addTrack;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public int audioTrackIndex() {
        return this.audioTrackIndex;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public boolean ignoreHeader() {
        return true;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public boolean isMuxerStarted() {
        return this.isStarted;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void release() {
        this.muxer.release();
        this.isStarted = false;
        Logger.i("DefaultMediaMuxer", "release muxer");
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void setExportConfig(@NonNull ExportConfig exportConfig) {
        this.muxer.setOrientationHint(exportConfig.getOutputRotate() * 90);
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void start() {
        this.muxer.start();
        this.audioPtsAdjust = -1L;
        this.isStarted = true;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void stop() {
        this.muxer.stop();
        this.isStarted = false;
        Logger.i("DefaultMediaMuxer", "stop muxer");
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public int videoTrackIndex() {
        return this.videoTrackIndex;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void writeSampleData(int i3, @NonNull ByteBuffer byteBuffer, @NonNull MediaCodec.BufferInfo bufferInfo) {
        if (i3 == this.audioTrackIndex) {
            long j3 = this.audioPtsAdjust;
            if (j3 > 0) {
                bufferInfo.presentationTimeUs -= j3;
            }
        } else if (i3 == this.videoTrackIndex && this.audioPtsAdjust < 0) {
            this.audioPtsAdjust = bufferInfo.presentationTimeUs;
        }
        this.muxer.writeSampleData(i3, byteBuffer, bufferInfo);
    }
}
