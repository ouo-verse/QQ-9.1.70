package com.tencent.tavkit.tavffmpeg;

import android.graphics.Matrix;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.player.TAVGLUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FFmpegVideoEncoder implements AssetWriterVideoEncoder {
    private static final String TAG = "TAV_FFmpeg-java";
    public static boolean USA_RGBA = false;
    private int height;
    private boolean isEndOfStream;
    private IMediaMuxer muxer;
    private ExportConfig outputConfig;
    private ByteBuffer pixelBuffer;
    private long ptsUs;
    private MediaFormat videoFormat;
    private int width;
    private long nativeContext = -1;
    private long muxerNativeContext = -1;
    private YUVConvert yuvConvert = new YUVConvert();

    private void doSetMediaMuxer() {
        Logger.d(TAG, "doSetMediaMuxer() called, nativeContext:" + this.nativeContext + ", muxerNativeContext:" + this.muxerNativeContext);
        long j3 = this.nativeContext;
        if (j3 != -1) {
            long j16 = this.muxerNativeContext;
            if (j16 != -1) {
                nativeSetMuxer(j3, j16);
            }
        }
    }

    private void encodeFrame(TextureInfo textureInfo, long j3) {
        readBuffer(textureInfo);
        this.ptsUs = j3;
        long nativeEncodeVideoSample = nativeEncodeVideoSample(this.nativeContext, this.pixelBuffer, textureInfo.width, textureInfo.height, j3, USA_RGBA);
        if (nativeEncodeVideoSample < 0) {
            Logger.e(TAG, "writeVideoSample: res = " + nativeEncodeVideoSample, new RuntimeException("stack"));
        }
    }

    private native long nativeEncodeVideoSample(long j3, ByteBuffer byteBuffer, int i3, int i16, long j16, boolean z16);

    private native void nativeFinish(long j3);

    private native long nativePrepare(int i3, int i16, int i17, int i18);

    private native void nativeRelease(long j3);

    private native long nativeSetMuxer(long j3, long j16);

    private native long nativeStart(long j3);

    private void readBuffer(@NonNull TextureInfo textureInfo) {
        Logger.v(TAG, "readBuffer() called with: texture = [" + textureInfo + "]");
        if (this.pixelBuffer == null) {
            this.pixelBuffer = ByteBuffer.allocateDirect(textureInfo.width * textureInfo.height * 4);
        }
        this.pixelBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.pixelBuffer.rewind();
        TAVGLUtils.readPixelBuffer(textureInfo, this.pixelBuffer);
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    @RequiresApi(api = 19)
    public Surface createInputSurface() {
        Logger.d(TAG, "createInputSurface() called");
        return null;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public MediaFormat getEncodeFormat() {
        return this.videoFormat;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public long getEncodePresentationTimeUs() {
        return this.ptsUs;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public CGSize getEncodeSize() {
        Logger.d(TAG, "getEncodeSize() called");
        return this.outputConfig.getOutputSize();
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public Matrix getFrameMatrix() {
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f);
        matrix.postTranslate(0.0f, 1.0f);
        return matrix;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public String getName() {
        Logger.d(TAG, "getName() called");
        return "ffmpeg_encoder";
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean isEncodeToEndOfStream() {
        Logger.v(TAG, "isEncodeToEndOfStream() called");
        return false;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean isNeedVideoOutputTexture() {
        return true;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void onOutputTextureUpdate(TextureInfo textureInfo, long j3) {
        synchronized (this.muxer) {
            if (textureInfo == null) {
                Logger.e(TAG, "onOutputTextureUpdate: texture is null");
                return;
            }
            if (!USA_RGBA) {
                textureInfo = this.yuvConvert.getYUVATextureInfo(textureInfo.textureID, textureInfo.width, textureInfo.height);
            }
            encodeFrame(textureInfo, j3);
        }
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void onRenderRelease() {
        this.yuvConvert.release();
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    @RequiresApi(api = 19)
    public boolean prepare(ExportConfig exportConfig, MediaFormat mediaFormat) {
        Logger.d(TAG, "prepare() called with: outputConfig = [" + exportConfig + "], videoFormat = [" + mediaFormat + "]");
        this.outputConfig = exportConfig;
        this.videoFormat = mediaFormat;
        CGSize outputSize = exportConfig.getOutputSize();
        int videoBitRate = exportConfig.getVideoBitRate();
        int videoFrameRate = exportConfig.getVideoFrameRate();
        int i3 = (int) outputSize.width;
        this.width = i3;
        int i16 = (int) outputSize.height;
        this.height = i16;
        this.nativeContext = nativePrepare(i3, i16, videoBitRate, videoFrameRate);
        doSetMediaMuxer();
        if (this.nativeContext > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void release() {
        Logger.d(TAG, "release() called");
        nativeRelease(this.nativeContext);
        ByteBuffer byteBuffer = this.pixelBuffer;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void setMediaMuxer(IMediaMuxer iMediaMuxer) {
        this.muxer = iMediaMuxer;
        Logger.d(TAG, "setMediaMuxer() called with: muxer = [" + iMediaMuxer + "]");
        if (iMediaMuxer instanceof FFmpegMuxer) {
            this.muxerNativeContext = ((FFmpegMuxer) iMediaMuxer).nativeContext;
        }
        doSetMediaMuxer();
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void signalEndOfInputStream() {
        Logger.d(TAG, "signalEndOfInputStream() called");
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean start() {
        Logger.d(TAG, "start() called");
        long nativeStart = nativeStart(this.nativeContext);
        if (nativeStart < 0) {
            Logger.e(TAG, "start: res = " + nativeStart, new RuntimeException("stack"));
            return false;
        }
        return true;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void stop() {
        Logger.d(TAG, "stop() called");
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean writeVideoSample(@Nullable CMSampleBuffer cMSampleBuffer, @Nullable TextureInfo textureInfo, boolean z16) {
        synchronized (this.muxer) {
            if (z16) {
                nativeFinish(this.nativeContext);
            }
        }
        return true;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void setVideoSampleRenderContext(RenderContext renderContext) {
    }
}
