package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.nio.ByteBuffer;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes2.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static final String TAG = "MediaCodecVideoRenderer";
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsAutoFrcWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private long joiningDeadlineMs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private long outputStreamOffsetUs;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private Format[] streamFormats;
    private Surface surface;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i3, int i16, int i17) {
            this.width = i3;
            this.height = i16;
            this.inputSize = i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @TargetApi(23)
    /* loaded from: classes2.dex */
    public final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener {
        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(@NonNull MediaCodec mediaCodec, long j3, long j16) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener) {
                return;
            }
            mediaCodecVideoRenderer.maybeNotifyRenderedFirstFrame();
        }

        OnFrameRenderedListenerV23(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    private static boolean areAdaptationCompatible(boolean z16, Format format, Format format2) {
        if (format.sampleMimeType.equals(format2.sampleMimeType) && getRotationDegrees(format) == getRotationDegrees(format2) && (z16 || (format.width == format2.width && format.height == format2.height))) {
            return true;
        }
        return false;
    }

    private void clearRenderedFirstFrame() {
        MediaCodec codec;
        this.renderedFirstFrame = false;
        if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    private static boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        String str2 = Util.DEVICE;
        if (((!"deb".equals(str2) && !"flo".equals(str2)) || !"OMX.qcom.video.decoder.avc".equals(str)) && ((!"tcl_eu".equals(str2) && !"SVP-DTV15".equals(str2) && !"BRAVIA_ATV2".equals(str2) && !str2.startsWith("panell_") && !"F3311".equals(str2) && !"M5c".equals(str2) && !"A7010a48".equals(str2)) || !"OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
            String str3 = Util.MODEL;
            if ((!"ALE-L21".equals(str3) && !"CAM-L21".equals(str3)) || !"OMX.k3.video.decoder.avc".equals(str)) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(21)
    private static void configureTunnelingV21(MediaFormat mediaFormat, int i3) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i3);
    }

    private static boolean deviceNeedsAutoFrcWorkaround() {
        if (Util.SDK_INT <= 22 && "foster".equals(Util.DEVICE) && "NVIDIA".equals(Util.MANUFACTURER)) {
            return true;
        }
        return false;
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18 = format.height;
        int i19 = format.width;
        if (i18 > i19) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = i18;
        } else {
            i3 = i19;
        }
        if (z16) {
            i18 = i19;
        }
        float f16 = i18 / i3;
        for (int i26 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i27 = (int) (i26 * f16);
            if (i26 <= i3 || i27 <= i18) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                if (z16) {
                    i17 = i27;
                } else {
                    i17 = i26;
                }
                if (!z16) {
                    i26 = i27;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i17, i26);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                int ceilDivide = Util.ceilDivide(i26, 16) * 16;
                int ceilDivide2 = Util.ceilDivide(i27, 16) * 16;
                if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                    if (z16) {
                        i16 = ceilDivide2;
                    } else {
                        i16 = ceilDivide;
                    }
                    if (!z16) {
                        ceilDivide = ceilDivide2;
                    }
                    return new Point(i16, ceilDivide);
                }
            }
        }
        return null;
    }

    private static int getMaxInputSize(Format format) {
        if (format.maxInputSize != -1) {
            int size = format.initializationData.size();
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                i3 += format.initializationData.get(i16).length;
            }
            return format.maxInputSize + i3;
        }
        return getMaxInputSize(format.sampleMimeType, format.width, format.height);
    }

    private static float getPixelWidthHeightRatio(Format format) {
        float f16 = format.pixelWidthHeightRatio;
        if (f16 == -1.0f) {
            return 1.0f;
        }
        return f16;
    }

    private static int getRotationDegrees(Format format) {
        int i3 = format.rotationDegrees;
        if (i3 == -1) {
            return 0;
        }
        return i3;
    }

    private static boolean isBufferLate(long j3) {
        if (j3 < -30000) {
            return true;
        }
        return false;
    }

    private static boolean isBufferVeryLate(long j3) {
        if (j3 < -500000) {
            return true;
        }
        return false;
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeNotifyVideoSizeChanged() {
        int i3 = this.currentWidth;
        if (i3 != -1 || this.currentHeight != -1) {
            if (this.reportedWidth != i3 || this.reportedHeight != this.currentHeight || this.reportedUnappliedRotationDegrees != this.currentUnappliedRotationDegrees || this.reportedPixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
                this.eventDispatcher.videoSizeChanged(i3, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
                this.reportedWidth = this.currentWidth;
                this.reportedHeight = this.currentHeight;
                this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
                this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
            }
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        int i3 = this.reportedWidth;
        if (i3 != -1 || this.reportedHeight != -1) {
            this.eventDispatcher.videoSizeChanged(i3, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
        }
    }

    private void setJoiningDeadlineMs() {
        long j3;
        if (this.allowedJoiningTimeMs > 0) {
            j3 = SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs;
        } else {
            j3 = -9223372036854775807L;
        }
        this.joiningDeadlineMs = j3;
    }

    @TargetApi(23)
    private static void setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                surface = surface2;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo)) {
                    surface = DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    this.dummySurface = surface;
                }
            }
        }
        if (this.surface != surface) {
            this.surface = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec codec = getCodec();
                if (Util.SDK_INT >= 23 && codec != null && surface != null && !this.codecNeedsSetOutputSurfaceWorkaround) {
                    setOutputSurfaceV23(codec, surface);
                } else {
                    releaseCodec();
                    maybeInitCodec();
                }
            }
            if (surface != null && surface != this.dummySurface) {
                maybeRenotifyVideoSizeChanged();
                clearRenderedFirstFrame();
                if (state == 2) {
                    setJoiningDeadlineMs();
                    return;
                }
                return;
            }
            clearReportedVideoSize();
            clearRenderedFirstFrame();
            return;
        }
        if (surface != null && surface != this.dummySurface) {
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
        }
    }

    private static void setVideoScalingMode(MediaCodec mediaCodec, int i3) {
        mediaCodec.setVideoScalingMode(i3);
    }

    private boolean shouldUseDummySurface(MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || DummySurface.isSecureSupported(this.context))) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean canReconfigureCodec(MediaCodec mediaCodec, boolean z16, Format format, Format format2) {
        if (areAdaptationCompatible(z16, format, format2)) {
            int i3 = format2.width;
            CodecMaxValues codecMaxValues = this.codecMaxValues;
            if (i3 <= codecMaxValues.width && format2.height <= codecMaxValues.height && getMaxInputSize(format2) <= this.codecMaxValues.inputSize) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        CodecMaxValues codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, this.streamFormats);
        this.codecMaxValues = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(format, codecMaxValues, this.deviceNeedsAutoFrcWorkaround, this.tunnelingAudioSessionId);
        if (this.surface == null) {
            Assertions.checkState(shouldUseDummySurface(mediaCodecInfo));
            if (this.dummySurface == null) {
                this.dummySurface = DummySurface.newInstanceV17(this.context, mediaCodecInfo.secure);
            }
            this.surface = this.dummySurface;
        }
        mediaCodec.configure(mediaFormat, this.surface, mediaCrypto, 0);
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(mediaCodec);
        }
    }

    protected void dropOutputBuffer(MediaCodec mediaCodec, int i3, long j3) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i3, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void flushCodec() throws ExoPlaybackException {
        super.flushCodec();
        this.buffersInCodecCount = 0;
    }

    protected CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) throws MediaCodecUtil.DecoderQueryException {
        boolean z16;
        int i3 = format.width;
        int i16 = format.height;
        int maxInputSize = getMaxInputSize(format);
        if (formatArr.length == 1) {
            return new CodecMaxValues(i3, i16, maxInputSize);
        }
        boolean z17 = false;
        for (Format format2 : formatArr) {
            if (areAdaptationCompatible(mediaCodecInfo.adaptive, format, format2)) {
                int i17 = format2.width;
                if (i17 != -1 && format2.height != -1) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                z17 |= z16;
                i3 = Math.max(i3, i17);
                i16 = Math.max(i16, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(format2));
            }
        }
        if (z17) {
            Log.w(TAG, "Resolutions unknown. Codec max resolution: " + i3 + HippyTKDListViewAdapter.X + i16);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i3 = Math.max(i3, codecMaxSize.x);
                i16 = Math.max(i16, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(format.sampleMimeType, i3, i16));
                Log.w(TAG, "Codec max resolution adjusted to: " + i3 + HippyTKDListViewAdapter.X + i16);
            }
        }
        return new CodecMaxValues(i3, i16, maxInputSize);
    }

    @SuppressLint({"InlinedApi"})
    protected MediaFormat getMediaFormat(Format format, CodecMaxValues codecMaxValues, boolean z16, int i3) {
        MediaFormat mediaFormatForPlayback = getMediaFormatForPlayback(format);
        mediaFormatForPlayback.setInteger("max-width", codecMaxValues.width);
        mediaFormatForPlayback.setInteger("max-height", codecMaxValues.height);
        int i16 = codecMaxValues.inputSize;
        if (i16 != -1) {
            mediaFormatForPlayback.setInteger("max-input-size", i16);
        }
        if (z16) {
            mediaFormatForPlayback.setInteger("auto-frc", 0);
        }
        if (i3 != 0) {
            configureTunnelingV21(mediaFormatForPlayback, i3);
        }
        return mediaFormatForPlayback;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i3, Object obj) throws ExoPlaybackException {
        if (i3 == 1) {
            setSurface((Surface) obj);
            return;
        }
        if (i3 == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodec codec = getCodec();
            if (codec != null) {
                setVideoScalingMode(codec, this.scalingMode);
                return;
            }
            return;
        }
        super.handleMessage(i3, obj);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.renderedFirstFrame || (((surface = this.dummySurface) != null && this.surface == surface) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        }
        if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
            return true;
        }
        this.joiningDeadlineMs = -9223372036854775807L;
        return false;
    }

    protected boolean maybeDropBuffersToKeyframe(MediaCodec mediaCodec, int i3, long j3, long j16) throws ExoPlaybackException {
        int skipSource = skipSource(j16);
        if (skipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + skipSource);
        flushCodec();
        return true;
    }

    void maybeNotifyRenderedFirstFrame() {
        if (!this.renderedFirstFrame) {
            TraceUtil.beginSection("RenderedFirstFrame");
            this.renderedFirstFrame = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
            TraceUtil.endSection();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String str, long j3, long j16) {
        this.eventDispatcher.decoderInitialized(str, j3, j16);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.pendingOutputStreamOffsetCount = 0;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        this.tunneling = false;
        try {
            super.onDisabled();
        } finally {
            this.decoderCounters.ensureUpdated();
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z16) throws ExoPlaybackException {
        boolean z17;
        super.onEnabled(z16);
        int i3 = getConfiguration().tunnelingAudioSessionId;
        this.tunnelingAudioSessionId = i3;
        if (i3 != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.tunneling = z17;
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(Format format) throws ExoPlaybackException {
        super.onInputFormatChanged(format);
        this.eventDispatcher.inputFormatChanged(format);
        this.pendingPixelWidthHeightRatio = getPixelWidthHeightRatio(format);
        this.pendingRotationDegrees = getRotationDegrees(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z16;
        int integer;
        int integer2;
        if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.currentWidth = integer;
        if (z16) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.currentHeight = integer2;
        float f16 = this.pendingPixelWidthHeightRatio;
        this.currentPixelWidthHeightRatio = f16;
        if (Util.SDK_INT >= 21) {
            int i3 = this.pendingRotationDegrees;
            if (i3 == 90 || i3 == 270) {
                int i16 = this.currentWidth;
                this.currentWidth = integer2;
                this.currentHeight = i16;
                this.currentPixelWidthHeightRatio = 1.0f / f16;
            }
        } else {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        }
        setVideoScalingMode(mediaCodec, this.scalingMode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j3, boolean z16) throws ExoPlaybackException {
        super.onPositionReset(j3, z16);
        clearRenderedFirstFrame();
        this.consecutiveDroppedFrameCount = 0;
        int i3 = this.pendingOutputStreamOffsetCount;
        if (i3 != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[i3 - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
        if (z16) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void onProcessedOutputBuffer(long j3) {
        this.buffersInCodecCount--;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    protected void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        this.buffersInCodecCount++;
        if (Util.SDK_INT < 23 && this.tunneling) {
            maybeNotifyRenderedFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
        super.onStopped();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j3) throws ExoPlaybackException {
        this.streamFormats = formatArr;
        if (this.outputStreamOffsetUs == -9223372036854775807L) {
            this.outputStreamOffsetUs = j3;
        } else {
            int i3 = this.pendingOutputStreamOffsetCount;
            if (i3 == this.pendingOutputStreamOffsetsUs.length) {
                Log.w(TAG, "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
            } else {
                this.pendingOutputStreamOffsetCount = i3 + 1;
            }
            this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1] = j3;
        }
        super.onStreamChanged(formatArr, j3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long j3, long j16, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i3, int i16, long j17, boolean z16) throws ExoPlaybackException {
        boolean z17;
        long j18;
        long j19;
        while (true) {
            int i17 = this.pendingOutputStreamOffsetCount;
            if (i17 == 0) {
                break;
            }
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            long j26 = jArr[0];
            if (j17 < j26) {
                break;
            }
            this.outputStreamOffsetUs = j26;
            int i18 = i17 - 1;
            this.pendingOutputStreamOffsetCount = i18;
            System.arraycopy(jArr, 1, jArr, 0, i18);
        }
        long j27 = j17 - this.outputStreamOffsetUs;
        if (z16) {
            skipOutputBuffer(mediaCodec, i3, j27);
            return true;
        }
        long j28 = j17 - j3;
        if (this.surface == this.dummySurface) {
            if (!isBufferLate(j28)) {
                return false;
            }
            skipOutputBuffer(mediaCodec, i3, j27);
            return true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        if (getState() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.renderedFirstFrame && (!z17 || !shouldForceRenderOutputBuffer(j28, elapsedRealtime - this.lastRenderTimeUs))) {
            if (!z17) {
                return false;
            }
            long j29 = j28 - (elapsedRealtime - j16);
            long nanoTime = System.nanoTime();
            long adjustReleaseTime = this.frameReleaseTimeHelper.adjustReleaseTime(j17, (j29 * 1000) + nanoTime);
            long j36 = (adjustReleaseTime - nanoTime) / 1000;
            if (shouldDropBuffersToKeyframe(j36, j16)) {
                j18 = adjustReleaseTime;
                j19 = j36;
                if (maybeDropBuffersToKeyframe(mediaCodec, i3, j27, j3)) {
                    return false;
                }
            } else {
                j18 = adjustReleaseTime;
                j19 = j36;
            }
            if (shouldDropOutputBuffer(j19, j16)) {
                dropOutputBuffer(mediaCodec, i3, j27);
                return true;
            }
            if (Util.SDK_INT >= 21) {
                if (j19 < 50000) {
                    renderOutputBufferV21(mediaCodec, i3, j27, j18);
                    return true;
                }
                return false;
            }
            if (j19 < 30000) {
                if (j19 > 11000) {
                    try {
                        LockMethodProxy.sleep((j19 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                renderOutputBuffer(mediaCodec, i3, j27);
                return true;
            }
            return false;
        }
        if (Util.SDK_INT >= 21) {
            renderOutputBufferV21(mediaCodec, i3, j27, System.nanoTime());
            return true;
        }
        renderOutputBuffer(mediaCodec, i3, j27);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void releaseCodec() {
        try {
            super.releaseCodec();
            this.buffersInCodecCount = 0;
            Surface surface = this.dummySurface;
            if (surface != null) {
                if (this.surface == surface) {
                    this.surface = null;
                }
                surface.release();
                this.dummySurface = null;
            }
        } catch (Throwable th5) {
            this.buffersInCodecCount = 0;
            if (this.dummySurface != null) {
                Surface surface2 = this.surface;
                Surface surface3 = this.dummySurface;
                if (surface2 == surface3) {
                    this.surface = null;
                }
                surface3.release();
                this.dummySurface = null;
            }
            throw th5;
        }
    }

    protected void renderOutputBuffer(MediaCodec mediaCodec, int i3, long j3) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i3, true);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    @TargetApi(21)
    protected void renderOutputBufferV21(MediaCodec mediaCodec, int i3, long j3, long j16) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i3, j16);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    protected boolean shouldDropBuffersToKeyframe(long j3, long j16) {
        return isBufferVeryLate(j3);
    }

    protected boolean shouldDropOutputBuffer(long j3, long j16) {
        return isBufferLate(j3);
    }

    protected boolean shouldForceRenderOutputBuffer(long j3, long j16) {
        if (isBufferLate(j3) && j16 > JsonGrayBusiId.UI_RESERVE_100000_110000) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        if (this.surface == null && !shouldUseDummySurface(mediaCodecInfo)) {
            return false;
        }
        return true;
    }

    protected void skipOutputBuffer(MediaCodec mediaCodec, int i3, long j3) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i3, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        String str = format.sampleMimeType;
        int i19 = 0;
        if (!MimeTypes.isVideo(str)) {
            return 0;
        }
        DrmInitData drmInitData = format.drmInitData;
        if (drmInitData != null) {
            z16 = false;
            for (int i26 = 0; i26 < drmInitData.schemeDataCount; i26++) {
                z16 |= drmInitData.get(i26).requiresSecureDecryption;
            }
        } else {
            z16 = false;
        }
        MediaCodecInfo decoderInfo = mediaCodecSelector.getDecoderInfo(str, z16, false);
        boolean z17 = true;
        if (decoderInfo == null) {
            if (z16 && mediaCodecSelector.getDecoderInfo(str, false, false) != null) {
                return 2;
            }
            return 1;
        }
        if (!BaseRenderer.supportsFormatDrm(drmSessionManager, drmInitData)) {
            return 2;
        }
        boolean isCodecSupported = decoderInfo.isCodecSupported(format.codecs);
        if (isCodecSupported && (i17 = format.width) > 0 && (i18 = format.height) > 0) {
            if (Util.SDK_INT >= 21) {
                isCodecSupported = decoderInfo.isVideoSizeAndRateSupportedV21(i17, i18, format.frameRate);
            } else {
                if (i17 * i18 > MediaCodecUtil.maxH264DecodableFrameSize()) {
                    z17 = false;
                }
                if (!z17) {
                    Log.d(TAG, "FalseCheck [legacyFrameSize, " + format.width + HippyTKDListViewAdapter.X + format.height + "] [" + Util.DEVICE_DEBUG_INFO + "]");
                }
                isCodecSupported = z17;
            }
        }
        if (decoderInfo.adaptive) {
            i3 = 16;
        } else {
            i3 = 8;
        }
        if (decoderInfo.tunneling) {
            i19 = 32;
        }
        if (isCodecSupported) {
            i16 = 4;
        } else {
            i16 = 3;
        }
        return i16 | i3 | i19;
    }

    protected void updateDroppedBufferCounters(int i3) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += i3;
        this.droppedFrames += i3;
        int i16 = this.consecutiveDroppedFrameCount + i3;
        this.consecutiveDroppedFrameCount = i16;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i16, decoderCounters.maxConsecutiveDroppedBufferCount);
        if (this.droppedFrames >= this.maxDroppedFramesToNotify) {
            maybeNotifyDroppedFrames();
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j3) {
        this(context, mediaCodecSelector, j3, null, null, -1);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j3, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i3) {
        this(context, mediaCodecSelector, j3, null, false, handler, videoRendererEventListener, i3);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j3, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z16, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i3) {
        super(2, mediaCodecSelector, drmSessionManager, z16);
        this.allowedJoiningTimeMs = j3;
        this.maxDroppedFramesToNotify = i3;
        this.context = context.getApplicationContext();
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(context);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsAutoFrcWorkaround = deviceNeedsAutoFrcWorkaround();
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.joiningDeadlineMs = -9223372036854775807L;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        clearReportedVideoSize();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x005d. Please report as an issue. */
    private static int getMaxInputSize(String str, int i3, int i16) {
        char c16;
        int i17;
        if (i3 == -1 || i16 == -1) {
            return -1;
        }
        str.hashCode();
        int i18 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c16 = 5;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
            case 2:
            case 4:
                i17 = i3 * i16;
                i18 = 2;
                return (i17 * 3) / (i18 * 2);
            case 1:
            case 5:
                i17 = i3 * i16;
                return (i17 * 3) / (i18 * 2);
            case 3:
                if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
                    return -1;
                }
                i17 = Util.ceilDivide(i3, 16) * Util.ceilDivide(i16, 16) * 16 * 16;
                i18 = 2;
                return (i17 * 3) / (i18 * 2);
            default:
                return -1;
        }
    }
}
