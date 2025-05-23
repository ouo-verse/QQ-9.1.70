package com.tencent.tavkit.tavffmpeg;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FFmpegMuxer implements IMediaMuxer {
    private static final int MUXER_STATE_INITIALIZED = 0;
    private static final int MUXER_STATE_STARTED = 1;
    private static final int MUXER_STATE_STOPPED = 2;
    private static final int MUXER_STATE_UNINITIALIZED = -1;
    private static final String TAG = "FfmpegMux";
    private int audioTrackIndex;
    private ExportConfig exportConfig;
    private int mState;
    long nativeContext;
    private int videoTrackIndex;

    public FFmpegMuxer(String str, String str2) {
        this.nativeContext = -1L;
        this.mState = -1;
        Log.d(TAG, "FFmpegMuxer() called with: filePath = [" + str + "], format = [" + str2 + "]");
        long nativeSetup = nativeSetup(str, str2);
        this.nativeContext = nativeSetup;
        if (nativeSetup != 0 && nativeSetup != -1) {
            this.mState = 0;
            return;
        }
        RuntimeException runtimeException = new RuntimeException("nativeSetup failed, nativeContext = " + this.nativeContext);
        Logger.e(TAG, "FFmpegMuxer: ", runtimeException);
        throw runtimeException;
    }

    static byte[] bufferToByte(@NonNull ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Log.d(TAG, "bufferToByte() called with: byteBuf = [" + byteBuffer + "], bufferInfo = [" + bufferInfo + "]");
        return bufferToByte(byteBuffer, bufferInfo.size, bufferInfo.offset);
    }

    private static native int nativeAddAudioTrack(long j3, String str, int i3, int i16, int i17);

    private static native int nativeAddVideoTrack(long j3, String str, int i3, int i16, int i17, int i18);

    private static native void nativeRelease(long j3);

    private static native void nativeSetLocation(long j3, float f16, float f17);

    private static native void nativeSetOrientationHint(long j3, String str);

    private static native long nativeSetup(String str, String str2);

    private static native void nativeStart(long j3);

    private static native void nativeStop(long j3);

    private static native void nativeWriteExtraData(long j3, int i3, byte[] bArr, int i16);

    private static native void nativeWriteSampleData(long j3, int i3, byte[] bArr, int i16, long j16, boolean z16);

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public int addTrack(@NonNull MediaFormat mediaFormat) {
        int i3;
        Log.d(TAG, "addTrack() called with: format = [" + mediaFormat + "]");
        if (!mediaFormat.containsKey("mime")) {
            return -1;
        }
        String string = mediaFormat.getString("mime");
        Logger.i(TAG, "add track mime:" + string);
        if (string == null) {
            return -1;
        }
        if (string.contains("video")) {
            int nativeAddVideoTrack = nativeAddVideoTrack(this.nativeContext, string, mediaFormat.getInteger("width"), mediaFormat.getInteger("height"), mediaFormat.getInteger("frame-rate"), mediaFormat.getInteger("bitrate"));
            this.videoTrackIndex = nativeAddVideoTrack;
            return nativeAddVideoTrack;
        }
        if (!string.contains("audio")) {
            return -1;
        }
        int integer = mediaFormat.getInteger("sample-rate");
        int integer2 = mediaFormat.getInteger("channel-count");
        if (mediaFormat.containsKey("bitrate")) {
            i3 = mediaFormat.getInteger("bitrate");
        } else {
            i3 = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
        }
        int nativeAddAudioTrack = nativeAddAudioTrack(this.nativeContext, string, integer, integer2, i3);
        this.audioTrackIndex = nativeAddAudioTrack;
        return nativeAddAudioTrack;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public int audioTrackIndex() {
        Log.d(TAG, "audioTrackIndex() called");
        return this.audioTrackIndex;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public boolean ignoreHeader() {
        Log.d(TAG, "ignoreHeader() called");
        return false;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public boolean isMuxerStarted() {
        if (this.mState == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void release() {
        Log.d(TAG, "release() called");
        nativeRelease(this.nativeContext);
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void setExportConfig(@NonNull ExportConfig exportConfig) {
        Log.d(TAG, "setExportConfig() called with: exportConfig = [" + exportConfig + "]");
        this.exportConfig = exportConfig;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void start() {
        Log.d(TAG, "start() called");
        nativeStart(this.nativeContext);
        this.mState = 1;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void stop() {
        Log.d(TAG, "stop() called");
        nativeStop(this.nativeContext);
        this.mState = 2;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public int videoTrackIndex() {
        Log.d(TAG, "videoTrackIndex() called");
        return this.videoTrackIndex;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public synchronized void writeSampleData(int i3, @NonNull ByteBuffer byteBuffer, @NonNull MediaCodec.BufferInfo bufferInfo) {
        boolean z16;
        Log.d(TAG, "writeSampleData() called with: trackIndex = [" + i3 + "], byteBuf = [" + byteBuffer + "], bufferInfo = [" + bufferInfo + "]");
        byte[] bufferToByte = bufferToByte(byteBuffer, bufferInfo);
        int i16 = bufferInfo.flags;
        if ((i16 & 2) != 0) {
            nativeWriteExtraData(this.nativeContext, i3, bufferToByte, bufferInfo.size);
        } else {
            long j3 = this.nativeContext;
            int i17 = bufferInfo.size;
            long j16 = bufferInfo.presentationTimeUs;
            if ((i16 & 1) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            nativeWriteSampleData(j3, i3, bufferToByte, i17, j16, z16);
        }
    }

    static byte[] bufferToByte(@NonNull ByteBuffer byteBuffer, int i3, int i16) {
        byte[] bArr = new byte[i3];
        byteBuffer.position(i16);
        byteBuffer.limit(i16 + i3);
        byteBuffer.get(bArr, 0, i3);
        byteBuffer.position(i16);
        return bArr;
    }
}
