package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.muxer.IMediaMuxer;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface AssetWriterVideoEncoder {
    public static final String OUTPUT_VIDEO_MIME_TYPE = "video/avc";
    public static final long WRITER_FINISH = -1;

    Surface createInputSurface();

    MediaFormat getEncodeFormat();

    long getEncodePresentationTimeUs();

    CGSize getEncodeSize();

    Matrix getFrameMatrix();

    String getName();

    boolean isEncodeToEndOfStream();

    boolean isNeedVideoOutputTexture();

    void onOutputTextureUpdate(TextureInfo textureInfo, long j3);

    void onRenderRelease();

    boolean prepare(ExportConfig exportConfig, MediaFormat mediaFormat);

    void release();

    void setMediaMuxer(IMediaMuxer iMediaMuxer);

    void setVideoSampleRenderContext(RenderContext renderContext);

    void signalEndOfInputStream();

    boolean start();

    void stop();

    boolean writeVideoSample(@Nullable CMSampleBuffer cMSampleBuffer, @Nullable TextureInfo textureInfo, boolean z16);
}
