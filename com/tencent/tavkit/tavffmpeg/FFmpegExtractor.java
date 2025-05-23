package com.tencent.tavkit.tavffmpeg;

import android.media.MediaCodec;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.IExtractorDelegate;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FFmpegExtractor implements IExtractorDelegate {
    private static final String TAG = "FFmpeg-Java";
    private int currentTrackIndex = -1;
    private final long nativeContext = nativeInit();
    private String path;

    private static native boolean nativeAdvance(long j3);

    private static native int nativeGetSampleFlags(long j3);

    private static native long nativeGetSampleTime(long j3, int i3);

    private static native int nativeGetTrackCount(long j3);

    private static native long nativeInit();

    private static native byte[] nativeReadSampleData(long j3, int i3, int i16);

    private static native void nativeRelease(long j3);

    private static native void nativeSeek(long j3, int i3, long j16, int i16);

    private static native boolean nativeSelectTrack(long j3, int i3);

    private static native int nativeSetDataSource(long j3, String str);

    private static native synchronized int setTrackFormatNative(long j3, int i3, MediaFormat mediaFormat);

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public boolean advance() {
        return nativeAdvance(this.nativeContext);
    }

    public int getSampleFlags() {
        return nativeGetSampleFlags(this.nativeContext);
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public long getSampleTime() {
        return nativeGetSampleTime(this.nativeContext, this.currentTrackIndex);
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public int getSampleTrackIndex() {
        return this.currentTrackIndex;
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public int getTrackCount() {
        return nativeGetTrackCount(this.nativeContext);
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    @NonNull
    public MediaFormat getTrackFormat(int i3) {
        MediaFormat mediaFormat = new MediaFormat();
        if (setTrackFormatNative(this.nativeContext, i3, mediaFormat) >= 0) {
            Logger.d(TAG, "getTrackFormat: format = " + mediaFormat);
            return mediaFormat;
        }
        throw new RuntimeException("setTrackFormatNative fail");
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public boolean needMirror() {
        return false;
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public int readSampleData(@NonNull ByteBuffer byteBuffer, int i3) {
        byte[] nativeReadSampleData = nativeReadSampleData(this.nativeContext, this.currentTrackIndex, i3);
        if (nativeReadSampleData == null) {
            return -1;
        }
        byteBuffer.clear();
        byteBuffer.put(nativeReadSampleData);
        byteBuffer.position(0);
        byteBuffer.limit(nativeReadSampleData.length);
        return nativeReadSampleData.length;
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public void release() {
        nativeRelease(this.nativeContext);
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public synchronized void seekTo(long j3, int i3) {
        nativeSeek(this.nativeContext, this.currentTrackIndex, j3, i3);
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public void selectTrack(int i3) throws RuntimeException {
        this.currentTrackIndex = i3;
        if (nativeSelectTrack(this.nativeContext, i3)) {
        } else {
            throw new RuntimeException("nativeSelectTrack fail");
        }
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public void setDataSource(@NonNull String str) throws RuntimeException {
        this.path = str;
        if (nativeSetDataSource(this.nativeContext, str) >= 0) {
        } else {
            throw new RuntimeException("ffmpeg demux setup fail");
        }
    }

    @Override // com.tencent.tav.extractor.IExtractorDelegate
    public void unselectTrack(int i3) {
        this.currentTrackIndex = -1;
    }

    public void getSampleCryptoInfo(MediaCodec.CryptoInfo cryptoInfo) {
    }
}
