package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.report.WriteFrameReportSession;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MediaCodecAssetWriterVideoEncoder implements AssetWriterVideoEncoder {
    private static final long WAIT_TRANSIENT_MS = 20;
    private CGSize encodeSize;
    private Surface inputSurface;
    private IMediaMuxer muxer;
    private MediaCodec videoEncoder;
    private final String TAG = "MediaCodecAssetWriterVideoEncoder@" + hashCode();
    private final MediaCodec.BufferInfo videoBufferInfo = new MediaCodec.BufferInfo();
    private volatile MediaFormat videoEncodeFormat = null;
    private long videoPresentationTimeUs = 0;
    private boolean isEncodeToEndOfStream = false;
    private final WriteFrameReportSession reportSession = new WriteFrameReportSession();

    private int dequeueOutputBuffer(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo) {
        try {
            return mediaCodec.dequeueOutputBuffer(bufferInfo, 1000L);
        } catch (Exception e16) {
            Logger.e(this.TAG, "dequeueOutputBuffer e = ", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                String str = this.TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("CodecException - isTransient = ");
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) e16;
                sb5.append(codecException.isTransient());
                sb5.append(" , isRecoverable = ");
                sb5.append(codecException.isRecoverable());
                sb5.append(" , errorCode = ");
                sb5.append(codecException.getErrorCode());
                Logger.e(str, sb5.toString());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(20L);
                    return dequeueOutputBuffer(mediaCodec, bufferInfo);
                }
            }
            this.reportSession.error();
            throw e16;
        }
    }

    private ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int i3) {
        try {
            return DecoderUtils.getOutputBuffer(mediaCodec, i3);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "getOutputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                String str = this.TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("CodecException - isTransient = ");
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) e16;
                sb5.append(codecException.isTransient());
                sb5.append(" , isRecoverable = ");
                sb5.append(codecException.isRecoverable());
                sb5.append(" , errorCode = ");
                sb5.append(codecException.getErrorCode());
                Logger.e(str, sb5.toString());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(20L);
                    return getOutputBuffer(mediaCodec, i3);
                }
            }
            throw e16;
        }
    }

    private void releaseOutputBuffer(MediaCodec mediaCodec, int i3, boolean z16) {
        try {
            mediaCodec.releaseOutputBuffer(i3, z16);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "releaseOutputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                String str = this.TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("CodecException - isTransient = ");
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) e16;
                sb5.append(codecException.isTransient());
                sb5.append(" , isRecoverable = ");
                sb5.append(codecException.isRecoverable());
                sb5.append(" , errorCode = ");
                sb5.append(codecException.getErrorCode());
                Logger.e(str, sb5.toString());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(20L);
                    releaseOutputBuffer(mediaCodec, i3, z16);
                }
            }
            throw e16;
        }
    }

    private boolean retryPrepareVideoEncoder(ExportConfig exportConfig, MediaFormat mediaFormat) {
        Logger.i(this.TAG, "retryPrepareVideoEncoder: format fix to " + mediaFormat);
        if (mediaFormat.containsKey("profile")) {
            mediaFormat.setInteger("profile", 0);
        }
        if (mediaFormat.containsKey("level")) {
            mediaFormat.setInteger("level", 0);
        }
        try {
            MediaCodec createEncoder = MediaCodecManager.createEncoder(mediaFormat);
            this.videoEncoder = createEncoder;
            exportConfig.initOutputSize(true, true, createEncoder);
            updateSizeToField(exportConfig);
            this.videoEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            return true;
        } catch (Exception e16) {
            Logger.e(this.TAG, "retryPrepareVideoEncoder: fail format = " + mediaFormat, e16);
            MediaCodecManager.releaseCodec(this.videoEncoder);
            throw new ExportRuntimeException(new ExportErrorStatus(-103, e16, mediaFormat.toString()));
        }
    }

    private void updateSizeToField(ExportConfig exportConfig) {
        this.encodeSize = new CGSize(exportConfig.getOutputWidth(), exportConfig.getOutputHeight());
    }

    private boolean validAndCorrectBufferInfo(MediaCodec.BufferInfo bufferInfo) {
        if (bufferInfo.size > 0 && (bufferInfo.flags & 4) == 0) {
            return true;
        }
        return false;
    }

    private void waitTime(long j3) {
        try {
            wait(j3);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    @RequiresApi(api = 18)
    public Surface createInputSurface() {
        if (this.videoEncoder != null && this.inputSurface == null) {
            Logger.i(this.TAG, "createInputSurface");
            this.inputSurface = this.videoEncoder.createInputSurface();
        }
        return this.inputSurface;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public MediaFormat getEncodeFormat() {
        return this.videoEncodeFormat;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public long getEncodePresentationTimeUs() {
        return this.videoPresentationTimeUs;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public CGSize getEncodeSize() {
        return this.encodeSize;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public Matrix getFrameMatrix() {
        return null;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    @Nullable
    public String getName() {
        return CodecHelper.getCodecName(this.videoEncoder);
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean isEncodeToEndOfStream() {
        return this.isEncodeToEndOfStream;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean isNeedVideoOutputTexture() {
        return false;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean prepare(ExportConfig exportConfig, MediaFormat mediaFormat) {
        try {
            Logger.i(this.TAG, "prepareVideoEncoder: format = " + mediaFormat);
            MediaCodec createEncoder = MediaCodecManager.createEncoder(mediaFormat);
            this.videoEncoder = createEncoder;
            exportConfig.initOutputSize(false, false, createEncoder);
            exportConfig.initFrameRate(this.videoEncoder);
            updateSizeToField(exportConfig);
            Logger.i(this.TAG, "prepareVideoEncoder: format fix to " + mediaFormat);
            this.videoEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            return true;
        } catch (Exception e16) {
            Logger.e(this.TAG, "prepare: fail format = " + mediaFormat, e16);
            MediaCodecManager.releaseCodec(this.videoEncoder);
            this.videoEncoder = null;
            return retryPrepareVideoEncoder(exportConfig, mediaFormat);
        }
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void release() {
        MediaCodec mediaCodec = this.videoEncoder;
        if (mediaCodec != null) {
            MediaCodecManager.releaseCodec(mediaCodec);
        }
        this.reportSession.flush();
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void setMediaMuxer(IMediaMuxer iMediaMuxer) {
        this.muxer = iMediaMuxer;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    @RequiresApi(api = 18)
    public void signalEndOfInputStream() {
        MediaCodec mediaCodec = this.videoEncoder;
        if (mediaCodec != null) {
            mediaCodec.signalEndOfInputStream();
        }
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean start() {
        MediaCodec mediaCodec = this.videoEncoder;
        if (mediaCodec != null) {
            mediaCodec.start();
            return true;
        }
        return false;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void stop() {
        MediaCodec mediaCodec = this.videoEncoder;
        if (mediaCodec != null) {
            mediaCodec.stop();
        }
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean writeVideoSample(CMSampleBuffer cMSampleBuffer, TextureInfo textureInfo, boolean z16) {
        boolean z17;
        IMediaMuxer iMediaMuxer = this.muxer;
        if (iMediaMuxer != null) {
            z17 = iMediaMuxer.isMuxerStarted();
        } else {
            z17 = false;
        }
        if (!z17 && this.videoEncodeFormat != null) {
            if (z16) {
                return false;
            }
        } else {
            long nanoTime = System.nanoTime();
            int dequeueOutputBuffer = dequeueOutputBuffer(this.videoEncoder, this.videoBufferInfo);
            this.reportSession.tick(System.nanoTime() - nanoTime);
            if (dequeueOutputBuffer == -1) {
                if (z16) {
                    return false;
                }
            } else {
                if (dequeueOutputBuffer == -2) {
                    this.videoEncodeFormat = this.videoEncoder.getOutputFormat();
                    Logger.e(this.TAG, "videoEncodeFormat:" + this.videoEncodeFormat);
                    return false;
                }
                if (dequeueOutputBuffer >= 0) {
                    ByteBuffer outputBuffer = getOutputBuffer(this.videoEncoder, dequeueOutputBuffer);
                    if ((this.videoBufferInfo.flags & 2) != 0 && this.muxer.ignoreHeader()) {
                        this.videoBufferInfo.size = 0;
                    }
                    if (z17 && validAndCorrectBufferInfo(this.videoBufferInfo)) {
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        MediaCodec.BufferInfo bufferInfo2 = this.videoBufferInfo;
                        bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                        Logger.d(this.TAG, "muxer.writeSampleData start");
                        IMediaMuxer iMediaMuxer2 = this.muxer;
                        iMediaMuxer2.writeSampleData(iMediaMuxer2.videoTrackIndex(), outputBuffer, bufferInfo);
                        Logger.d(this.TAG, "muxer.writeSampleData end");
                        this.videoPresentationTimeUs = this.videoBufferInfo.presentationTimeUs;
                    }
                    releaseOutputBuffer(this.videoEncoder, dequeueOutputBuffer, false);
                    if ((this.videoBufferInfo.flags & 4) == 0) {
                        return false;
                    }
                    Logger.i(this.TAG, "writeVideoFrame: BUFFER_FLAG_END_OF_STREAM");
                    this.videoPresentationTimeUs = -1L;
                    this.isEncodeToEndOfStream = true;
                } else {
                    Logger.i(this.TAG, "writeVideoFrame: encoderStatus=" + dequeueOutputBuffer);
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void onRenderRelease() {
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void setVideoSampleRenderContext(RenderContext renderContext) {
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void onOutputTextureUpdate(TextureInfo textureInfo, long j3) {
    }
}
