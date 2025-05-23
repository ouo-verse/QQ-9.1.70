package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes2.dex */
public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] ADAPTATION_WORKAROUND_BUFFER = Util.getBytesFromHexString("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private static final int ADAPTATION_WORKAROUND_MODE_ALWAYS = 2;
    private static final int ADAPTATION_WORKAROUND_MODE_NEVER = 0;
    private static final int ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION = 1;
    private static final int ADAPTATION_WORKAROUND_SLICE_WIDTH_HEIGHT = 32;
    private static final long MAX_CODEC_HOTSWAP_TIME_MS = 1000;
    private static final int RECONFIGURATION_STATE_NONE = 0;
    private static final int RECONFIGURATION_STATE_QUEUE_PENDING = 2;
    private static final int RECONFIGURATION_STATE_WRITE_PENDING = 1;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "MediaCodecRenderer";
    private final DecoderInputBuffer buffer;
    private MediaCodec codec;
    private int codecAdaptationWorkaroundMode;
    private long codecHotswapDeadlineMs;
    private MediaCodecInfo codecInfo;
    private boolean codecNeedsAdaptationWorkaroundBuffer;
    private boolean codecNeedsDiscardToSpsWorkaround;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosOutputExceptionWorkaround;
    private boolean codecNeedsEosPropagationWorkaround;
    private boolean codecNeedsFlushWorkaround;
    private boolean codecNeedsMonoChannelCountWorkaround;
    private boolean codecReceivedBuffers;
    private boolean codecReceivedEos;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private int codecReinitializationState;
    private final List<Long> decodeOnlyPresentationTimestamps;
    protected DecoderCounters decoderCounters;
    private DrmSession<FrameworkMediaCrypto> drmSession;

    @Nullable
    private final DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private Format format;
    private final FormatHolder formatHolder;
    private ByteBuffer[] inputBuffers;
    private int inputIndex;
    private boolean inputStreamEnded;
    private final MediaCodecSelector mediaCodecSelector;
    private ByteBuffer outputBuffer;
    private final MediaCodec.BufferInfo outputBufferInfo;
    private ByteBuffer[] outputBuffers;
    private int outputIndex;
    private boolean outputStreamEnded;
    private DrmSession<FrameworkMediaCrypto> pendingDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    private boolean shouldSkipOutputBuffer;
    private boolean waitingForFirstSyncFrame;
    private boolean waitingForKeys;

    public MediaCodecRenderer(int i3, MediaCodecSelector mediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z16) {
        super(i3);
        boolean z17;
        if (Util.SDK_INT >= 16) {
            z17 = true;
        } else {
            z17 = false;
        }
        Assertions.checkState(z17);
        this.mediaCodecSelector = (MediaCodecSelector) Assertions.checkNotNull(mediaCodecSelector);
        this.drmSessionManager = drmSessionManager;
        this.playClearSamplesWithoutKeys = z16;
        this.buffer = new DecoderInputBuffer(0);
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.formatHolder = new FormatHolder();
        this.decodeOnlyPresentationTimestamps = new ArrayList();
        this.outputBufferInfo = new MediaCodec.BufferInfo();
        this.codecReconfigurationState = 0;
        this.codecReinitializationState = 0;
    }

    private int codecAdaptationWorkaroundMode(String str) {
        int i3 = Util.SDK_INT;
        if (i3 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = Util.MODEL;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i3 < 24) {
            if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
                String str3 = Util.DEVICE;
                if ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }
        return 0;
    }

    private static boolean codecNeedsDiscardToSpsWorkaround(String str, Format format) {
        if (Util.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str)) {
            return true;
        }
        return false;
    }

    private static boolean codecNeedsEosFlushWorkaround(String str) {
        int i3 = Util.SDK_INT;
        if ((i3 <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (i3 <= 19 && "hb2000".equals(Util.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)))) {
            return true;
        }
        return false;
    }

    private static boolean codecNeedsEosOutputExceptionWorkaround(String str) {
        if (Util.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str)) {
            return true;
        }
        return false;
    }

    private static boolean codecNeedsEosPropagationWorkaround(String str) {
        if (Util.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str))) {
            return true;
        }
        return false;
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        int i3 = Util.SDK_INT;
        if (i3 >= 18 && ((i3 != 18 || (!"OMX.SEC.avc.dec".equals(str) && !"OMX.SEC.avc.dec.secure".equals(str))) && (i3 != 19 || !Util.MODEL.startsWith("SM-G800") || (!"OMX.Exynos.avc.dec".equals(str) && !"OMX.Exynos.avc.dec.secure".equals(str))))) {
            return false;
        }
        return true;
    }

    private static boolean codecNeedsMonoChannelCountWorkaround(String str, Format format) {
        if (Util.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return true;
        }
        return false;
    }

    @TargetApi(23)
    private static void configureMediaFormatForPlaybackV23(MediaFormat mediaFormat) {
        mediaFormat.setInteger("priority", 0);
    }

    private boolean drainOutputBuffer(long j3, long j16) throws ExoPlaybackException {
        boolean processOutputBuffer;
        int dequeueOutputBuffer;
        if (!hasOutputBuffer()) {
            if (this.codecNeedsEosOutputExceptionWorkaround && this.codecReceivedEos) {
                try {
                    dequeueOutputBuffer = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
                } catch (IllegalStateException unused) {
                    processEndOfStream();
                    if (this.outputStreamEnded) {
                        try {
                            releaseCodec();
                        } catch (Exception unused2) {
                        }
                    }
                    return false;
                }
            } else {
                try {
                    try {
                        dequeueOutputBuffer = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
                    } catch (Exception unused3) {
                        releaseCodec();
                        return false;
                    }
                } catch (Exception unused4) {
                    return false;
                }
            }
            if (dequeueOutputBuffer >= 0) {
                if (this.shouldSkipAdaptationWorkaroundOutputBuffer) {
                    this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
                    this.codec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    return true;
                }
                if ((this.outputBufferInfo.flags & 4) != 0) {
                    processEndOfStream();
                    return false;
                }
                this.outputIndex = dequeueOutputBuffer;
                ByteBuffer outputBuffer = getOutputBuffer(dequeueOutputBuffer);
                this.outputBuffer = outputBuffer;
                if (outputBuffer != null) {
                    outputBuffer.position(this.outputBufferInfo.offset);
                    ByteBuffer byteBuffer = this.outputBuffer;
                    MediaCodec.BufferInfo bufferInfo = this.outputBufferInfo;
                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                }
                this.shouldSkipOutputBuffer = shouldSkipOutputBuffer(this.outputBufferInfo.presentationTimeUs);
            } else {
                if (dequeueOutputBuffer == -2) {
                    processOutputFormat();
                    return true;
                }
                if (dequeueOutputBuffer == -3) {
                    processOutputBuffersChanged();
                    return true;
                }
                if (this.codecNeedsEosPropagationWorkaround && (this.inputStreamEnded || this.codecReinitializationState == 2)) {
                    processEndOfStream();
                }
                return false;
            }
        }
        if (this.codecNeedsEosOutputExceptionWorkaround && this.codecReceivedEos) {
            try {
                MediaCodec mediaCodec = this.codec;
                ByteBuffer byteBuffer2 = this.outputBuffer;
                int i3 = this.outputIndex;
                MediaCodec.BufferInfo bufferInfo2 = this.outputBufferInfo;
                processOutputBuffer = processOutputBuffer(j3, j16, mediaCodec, byteBuffer2, i3, bufferInfo2.flags, bufferInfo2.presentationTimeUs, this.shouldSkipOutputBuffer);
            } catch (IllegalStateException unused5) {
                processEndOfStream();
                if (this.outputStreamEnded) {
                    releaseCodec();
                }
                return false;
            }
        } else {
            MediaCodec mediaCodec2 = this.codec;
            ByteBuffer byteBuffer3 = this.outputBuffer;
            int i16 = this.outputIndex;
            MediaCodec.BufferInfo bufferInfo3 = this.outputBufferInfo;
            processOutputBuffer = processOutputBuffer(j3, j16, mediaCodec2, byteBuffer3, i16, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.shouldSkipOutputBuffer);
        }
        if (!processOutputBuffer) {
            return false;
        }
        onProcessedOutputBuffer(this.outputBufferInfo.presentationTimeUs);
        resetOutputBuffer();
        return true;
    }

    private boolean feedInputBuffer() throws ExoPlaybackException {
        int position;
        int readSource;
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null || this.codecReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputIndex < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.inputIndex = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            this.buffer.data = getInputBuffer(dequeueInputBuffer);
            this.buffer.clear();
        }
        if (this.codecReinitializationState == 1) {
            if (!this.codecNeedsEosPropagationWorkaround) {
                this.codecReceivedEos = true;
                this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                resetInputBuffer();
            }
            this.codecReinitializationState = 2;
            return false;
        }
        if (this.codecNeedsAdaptationWorkaroundBuffer) {
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            ByteBuffer byteBuffer = this.buffer.data;
            byte[] bArr = ADAPTATION_WORKAROUND_BUFFER;
            byteBuffer.put(bArr);
            this.codec.queueInputBuffer(this.inputIndex, 0, bArr.length, 0L, 0);
            resetInputBuffer();
            this.codecReceivedBuffers = true;
            return true;
        }
        if (this.waitingForKeys) {
            readSource = -4;
            position = 0;
        } else {
            if (this.codecReconfigurationState == 1) {
                for (int i3 = 0; i3 < this.format.initializationData.size(); i3++) {
                    this.buffer.data.put(this.format.initializationData.get(i3));
                }
                this.codecReconfigurationState = 2;
            }
            position = this.buffer.data.position();
            readSource = readSource(this.formatHolder, this.buffer, false);
        }
        if (readSource == -3) {
            return false;
        }
        if (readSource == -5) {
            if (this.codecReconfigurationState == 2) {
                this.buffer.clear();
                this.codecReconfigurationState = 1;
            }
            onInputFormatChanged(this.formatHolder.format);
            return true;
        }
        if (this.buffer.isEndOfStream()) {
            if (this.codecReconfigurationState == 2) {
                this.buffer.clear();
                this.codecReconfigurationState = 1;
            }
            this.inputStreamEnded = true;
            if (!this.codecReceivedBuffers) {
                processEndOfStream();
                return false;
            }
            try {
                if (!this.codecNeedsEosPropagationWorkaround) {
                    this.codecReceivedEos = true;
                    this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                    resetInputBuffer();
                }
                return false;
            } catch (MediaCodec.CryptoException e16) {
                throw ExoPlaybackException.createForRenderer(e16, getIndex());
            }
        }
        if (this.waitingForFirstSyncFrame && !this.buffer.isKeyFrame()) {
            this.buffer.clear();
            if (this.codecReconfigurationState == 2) {
                this.codecReconfigurationState = 1;
            }
            return true;
        }
        this.waitingForFirstSyncFrame = false;
        boolean isEncrypted = this.buffer.isEncrypted();
        boolean shouldWaitForKeys = shouldWaitForKeys(isEncrypted);
        this.waitingForKeys = shouldWaitForKeys;
        if (shouldWaitForKeys) {
            return false;
        }
        if (this.codecNeedsDiscardToSpsWorkaround && !isEncrypted) {
            NalUnitUtil.discardToSps(this.buffer.data);
            if (this.buffer.data.position() == 0) {
                return true;
            }
            this.codecNeedsDiscardToSpsWorkaround = false;
        }
        try {
            DecoderInputBuffer decoderInputBuffer = this.buffer;
            long j3 = decoderInputBuffer.timeUs;
            if (decoderInputBuffer.isDecodeOnly()) {
                this.decodeOnlyPresentationTimestamps.add(Long.valueOf(j3));
            }
            this.buffer.flip();
            onQueueInputBuffer(this.buffer);
            if (isEncrypted) {
                this.codec.queueSecureInputBuffer(this.inputIndex, 0, getFrameworkCryptoInfo(this.buffer, position), j3, 0);
            } else {
                this.codec.queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), j3, 0);
            }
            resetInputBuffer();
            this.codecReceivedBuffers = true;
            this.codecReconfigurationState = 0;
            this.decoderCounters.inputBufferCount++;
            return true;
        } catch (MediaCodec.CryptoException e17) {
            throw ExoPlaybackException.createForRenderer(e17, getIndex());
        } catch (RuntimeException e18) {
            throw ExoPlaybackException.createForRenderer(e18, getIndex());
        }
    }

    private void getCodecBuffers() {
        if (Util.SDK_INT < 21) {
            this.inputBuffers = this.codec.getInputBuffers();
            this.outputBuffers = this.codec.getOutputBuffers();
        }
    }

    private static MediaCodec.CryptoInfo getFrameworkCryptoInfo(DecoderInputBuffer decoderInputBuffer, int i3) {
        MediaCodec.CryptoInfo frameworkCryptoInfoV16 = decoderInputBuffer.cryptoInfo.getFrameworkCryptoInfoV16();
        if (i3 == 0) {
            return frameworkCryptoInfoV16;
        }
        if (frameworkCryptoInfoV16.numBytesOfClearData == null) {
            frameworkCryptoInfoV16.numBytesOfClearData = new int[1];
        }
        int[] iArr = frameworkCryptoInfoV16.numBytesOfClearData;
        iArr[0] = iArr[0] + i3;
        return frameworkCryptoInfoV16;
    }

    private ByteBuffer getInputBuffer(int i3) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getInputBuffer(i3);
        }
        return this.inputBuffers[i3];
    }

    private ByteBuffer getOutputBuffer(int i3) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getOutputBuffer(i3);
        }
        return this.outputBuffers[i3];
    }

    private boolean hasOutputBuffer() {
        if (this.outputIndex >= 0) {
            return true;
        }
        return false;
    }

    private void initMediaCodecInfo(String str, boolean z16, boolean z17) throws ExoPlaybackException {
        if (this.codecInfo == null) {
            try {
                MediaCodecInfo decoderInfo = getDecoderInfo(this.mediaCodecSelector, this.format, z16, z17);
                this.codecInfo = decoderInfo;
                if (decoderInfo == null && z16) {
                    MediaCodecInfo decoderInfo2 = getDecoderInfo(this.mediaCodecSelector, this.format, false, z17);
                    this.codecInfo = decoderInfo2;
                    if (decoderInfo2 != null) {
                        Log.w(TAG, "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.codecInfo.name + ".");
                    }
                }
            } catch (MediaCodecUtil.DecoderQueryException e16) {
                throwDecoderInitError(new DecoderInitializationException(this.format, e16, z16, -49998));
            }
            if (this.codecInfo == null) {
                throwDecoderInitError(new DecoderInitializationException(this.format, (Throwable) null, z16, -49999));
            }
        }
    }

    private void processEndOfStream() throws ExoPlaybackException {
        if (this.codecReinitializationState == 2) {
            releaseCodec();
            maybeInitCodec();
        } else {
            this.outputStreamEnded = true;
            renderToEndOfStream();
        }
    }

    private void processOutputBuffersChanged() {
        if (Util.SDK_INT < 21) {
            this.outputBuffers = this.codec.getOutputBuffers();
        }
    }

    private void processOutputFormat() throws ExoPlaybackException {
        MediaFormat outputFormat = this.codec.getOutputFormat();
        if (this.codecAdaptationWorkaroundMode != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
            return;
        }
        if (this.codecNeedsMonoChannelCountWorkaround) {
            outputFormat.setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.codec, outputFormat);
    }

    private void resetCodecBuffers() {
        if (Util.SDK_INT < 21) {
            this.inputBuffers = null;
            this.outputBuffers = null;
        }
    }

    private void resetInputBuffer() {
        this.inputIndex = -1;
        this.buffer.data = null;
    }

    private void resetOutputBuffer() {
        this.outputIndex = -1;
        this.outputBuffer = null;
    }

    private boolean shouldSkipOutputBuffer(long j3) {
        int size = this.decodeOnlyPresentationTimestamps.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.decodeOnlyPresentationTimestamps.get(i3).longValue() == j3) {
                this.decodeOnlyPresentationTimestamps.remove(i3);
                return true;
            }
        }
        return false;
    }

    private boolean shouldWaitForKeys(boolean z16) throws ExoPlaybackException {
        DrmSession<FrameworkMediaCrypto> drmSession = this.drmSession;
        if (drmSession == null || (!z16 && this.playClearSamplesWithoutKeys)) {
            return false;
        }
        int state = drmSession.getState();
        if (state != 1) {
            if (state == 4) {
                return false;
            }
            return true;
        }
        throw ExoPlaybackException.createForRenderer(this.drmSession.getError(), getIndex());
    }

    private void throwDecoderInitError(DecoderInitializationException decoderInitializationException) throws ExoPlaybackException {
        throw ExoPlaybackException.createForRenderer(decoderInitializationException, getIndex());
    }

    protected boolean canReconfigureCodec(MediaCodec mediaCodec, boolean z16, Format format, Format format2) {
        return false;
    }

    protected abstract void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void flushCodec() throws ExoPlaybackException {
        this.codecHotswapDeadlineMs = -9223372036854775807L;
        resetInputBuffer();
        resetOutputBuffer();
        this.waitingForFirstSyncFrame = true;
        this.waitingForKeys = false;
        this.shouldSkipOutputBuffer = false;
        this.decodeOnlyPresentationTimestamps.clear();
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        if (!this.codecNeedsFlushWorkaround && (!this.codecNeedsEosFlushWorkaround || !this.codecReceivedEos)) {
            if (this.codecReinitializationState != 0) {
                releaseCodec();
                maybeInitCodec();
            } else {
                this.codec.flush();
                this.codecReceivedBuffers = false;
            }
        } else {
            releaseCodec();
            maybeInitCodec();
        }
        if (this.codecReconfigured && this.format != null) {
            this.codecReconfigurationState = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodec getCodec() {
        return this.codec;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodecInfo getCodecInfo() {
        return this.codecInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MediaCodecInfo getDecoderInfo(MediaCodecSelector mediaCodecSelector, Format format, boolean z16, boolean z17) throws MediaCodecUtil.DecoderQueryException {
        return mediaCodecSelector.getDecoderInfo(format.sampleMimeType, z16, z17);
    }

    protected long getDequeueOutputBufferTimeoutUs() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaFormat getMediaFormatForPlayback(Format format) {
        MediaFormat frameworkMediaFormatV16 = format.getFrameworkMediaFormatV16();
        if (Util.SDK_INT >= 23) {
            configureMediaFormatForPlaybackV23(frameworkMediaFormatV16);
        }
        return frameworkMediaFormatV16;
    }

    public int getRenderIndex() {
        return getIndex();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (this.format != null && !this.waitingForKeys && (isSourceReady() || hasOutputBuffer() || (this.codecHotswapDeadlineMs != -9223372036854775807L && SystemClock.elapsedRealtime() < this.codecHotswapDeadlineMs))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0177 A[LOOP:0: B:15:0x0038->B:36:0x0177, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x017c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015e  */
    /* JADX WARN: Type inference failed for: r10v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void maybeInitCodec() throws ExoPlaybackException {
        Format format;
        MediaCrypto mediaCrypto;
        boolean z16;
        int i3;
        boolean z17;
        int i16;
        String str;
        boolean z18;
        ?? r102;
        long j3;
        if (this.codec == null && (format = this.format) != null) {
            DrmSession<FrameworkMediaCrypto> drmSession = this.pendingDrmSession;
            this.drmSession = drmSession;
            String str2 = format.sampleMimeType;
            MediaCodecInfo mediaCodecInfo = null;
            if (drmSession != null) {
                FrameworkMediaCrypto mediaCrypto2 = drmSession.getMediaCrypto();
                if (mediaCrypto2 == null) {
                    if (this.drmSession.getError() == null) {
                        return;
                    }
                } else {
                    MediaCrypto wrappedMediaCrypto = mediaCrypto2.getWrappedMediaCrypto();
                    z16 = mediaCrypto2.requiresSecureDecoderComponent(str2);
                    mediaCrypto = wrappedMediaCrypto;
                    i3 = 0;
                    while (i3 < 2) {
                        if (i3 == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (i3 > 0) {
                            this.codecInfo = mediaCodecInfo;
                        }
                        initMediaCodecInfo(str2, z16, z17);
                        if (!shouldInitCodec(this.codecInfo)) {
                            return;
                        }
                        String str3 = this.codecInfo.name;
                        this.codecAdaptationWorkaroundMode = codecAdaptationWorkaroundMode(str3);
                        this.codecNeedsDiscardToSpsWorkaround = codecNeedsDiscardToSpsWorkaround(str3, this.format);
                        this.codecNeedsFlushWorkaround = codecNeedsFlushWorkaround(str3);
                        this.codecNeedsEosPropagationWorkaround = codecNeedsEosPropagationWorkaround(str3);
                        this.codecNeedsEosFlushWorkaround = codecNeedsEosFlushWorkaround(str3);
                        this.codecNeedsEosOutputExceptionWorkaround = codecNeedsEosOutputExceptionWorkaround(str3);
                        this.codecNeedsMonoChannelCountWorkaround = codecNeedsMonoChannelCountWorkaround(str3, this.format);
                        try {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            TraceUtil.beginSection("createCodec:" + str3);
                            Log.i(TAG, "createCodec: " + str2 + ", " + str3);
                            this.codec = MediaCodec.createByCodecName(str3);
                            TraceUtil.endSection();
                            TraceUtil.beginSection("configureCodec:" + str3);
                            configureCodec(this.codecInfo, this.codec, this.format, mediaCrypto);
                            TraceUtil.endSection();
                            TraceUtil.beginSection("startCodec:" + str3);
                            this.codec.start();
                            TraceUtil.endSection();
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            i16 = 1;
                            str = str3;
                            try {
                                onCodecInitialized(str3, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                                getCodecBuffers();
                                z18 = false;
                                r102 = i16;
                            } catch (Exception e16) {
                                e = e16;
                                if (i3 >= i16) {
                                    throwDecoderInitError(new DecoderInitializationException(this.format, e, z16, str));
                                }
                                Log.w(TAG, "decoder creation for " + str2 + " failed," + this.codecInfo.name + ".", e);
                                z18 = i16 == true ? 1 : 0;
                                r102 = i16;
                                if (getState() != 2) {
                                }
                                this.codecHotswapDeadlineMs = j3;
                                resetInputBuffer();
                                resetOutputBuffer();
                                this.waitingForFirstSyncFrame = r102;
                                this.decoderCounters.decoderInitCount += r102;
                                if (!z18) {
                                }
                            }
                        } catch (Exception e17) {
                            e = e17;
                            i16 = 1;
                            str = str3;
                        }
                        if (getState() != 2) {
                            j3 = SystemClock.elapsedRealtime() + 1000;
                        } else {
                            j3 = -9223372036854775807L;
                        }
                        this.codecHotswapDeadlineMs = j3;
                        resetInputBuffer();
                        resetOutputBuffer();
                        this.waitingForFirstSyncFrame = r102;
                        this.decoderCounters.decoderInitCount += r102;
                        if (!z18) {
                            i3++;
                            mediaCodecInfo = null;
                        } else {
                            return;
                        }
                    }
                }
            }
            mediaCrypto = null;
            z16 = false;
            i3 = 0;
            while (i3 < 2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.format = null;
        try {
            releaseCodec();
            try {
                DrmSession<FrameworkMediaCrypto> drmSession = this.drmSession;
                if (drmSession != null) {
                    this.drmSessionManager.releaseSession(drmSession);
                }
                try {
                    DrmSession<FrameworkMediaCrypto> drmSession2 = this.pendingDrmSession;
                    if (drmSession2 != null && drmSession2 != this.drmSession) {
                        this.drmSessionManager.releaseSession(drmSession2);
                    }
                } finally {
                }
            } catch (Throwable th5) {
                try {
                    DrmSession<FrameworkMediaCrypto> drmSession3 = this.pendingDrmSession;
                    if (drmSession3 != null && drmSession3 != this.drmSession) {
                        this.drmSessionManager.releaseSession(drmSession3);
                    }
                    throw th5;
                } finally {
                }
            }
        } catch (Throwable th6) {
            try {
                if (this.drmSession != null) {
                    this.drmSessionManager.releaseSession(this.drmSession);
                }
                try {
                    DrmSession<FrameworkMediaCrypto> drmSession4 = this.pendingDrmSession;
                    if (drmSession4 != null && drmSession4 != this.drmSession) {
                        this.drmSessionManager.releaseSession(drmSession4);
                    }
                    throw th6;
                } finally {
                }
            } catch (Throwable th7) {
                try {
                    DrmSession<FrameworkMediaCrypto> drmSession5 = this.pendingDrmSession;
                    if (drmSession5 != null && drmSession5 != this.drmSession) {
                        this.drmSessionManager.releaseSession(drmSession5);
                    }
                    throw th7;
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z16) throws ExoPlaybackException {
        this.decoderCounters = new DecoderCounters();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0077, code lost:
    
        if (r5.height == r0.height) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onInputFormatChanged(Format format) throws ExoPlaybackException {
        DrmInitData drmInitData;
        MediaCodec mediaCodec;
        Format format2 = this.format;
        this.format = format;
        DrmInitData drmInitData2 = format.drmInitData;
        if (format2 == null) {
            drmInitData = null;
        } else {
            drmInitData = format2.drmInitData;
        }
        boolean areEqual = Util.areEqual(drmInitData2, drmInitData);
        boolean z16 = true;
        if (!areEqual) {
            if (this.format.drmInitData != null) {
                DrmSessionManager<FrameworkMediaCrypto> drmSessionManager = this.drmSessionManager;
                if (drmSessionManager != null) {
                    DrmSession<FrameworkMediaCrypto> acquireSession = drmSessionManager.acquireSession(Looper.myLooper(), this.format.drmInitData);
                    this.pendingDrmSession = acquireSession;
                    if (acquireSession == this.drmSession) {
                        this.drmSessionManager.releaseSession(acquireSession);
                    }
                } else {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
            } else {
                this.pendingDrmSession = null;
            }
        }
        if (this.pendingDrmSession == this.drmSession && (mediaCodec = this.codec) != null && canReconfigureCodec(mediaCodec, this.codecInfo.adaptive, format2, this.format)) {
            this.codecReconfigured = true;
            this.codecReconfigurationState = 1;
            int i3 = this.codecAdaptationWorkaroundMode;
            if (i3 != 2) {
                if (i3 == 1) {
                    Format format3 = this.format;
                    if (format3.width == format2.width) {
                    }
                }
                z16 = false;
            }
            this.codecNeedsAdaptationWorkaroundBuffer = z16;
            return;
        }
        if (this.codecReceivedBuffers) {
            this.codecReinitializationState = 1;
        } else {
            releaseCodec();
            maybeInitCodec();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j3, boolean z16) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.codec != null) {
            flushCodec();
        }
    }

    protected abstract boolean processOutputBuffer(long j3, long j16, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i3, int i16, long j17, boolean z16) throws ExoPlaybackException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseCodec() {
        this.codecHotswapDeadlineMs = -9223372036854775807L;
        resetInputBuffer();
        resetOutputBuffer();
        this.waitingForKeys = false;
        this.shouldSkipOutputBuffer = false;
        this.decodeOnlyPresentationTimestamps.clear();
        resetCodecBuffers();
        this.codecInfo = null;
        this.codecReconfigured = false;
        this.codecReceivedBuffers = false;
        this.codecNeedsDiscardToSpsWorkaround = false;
        this.codecNeedsFlushWorkaround = false;
        this.codecAdaptationWorkaroundMode = 0;
        this.codecNeedsEosPropagationWorkaround = false;
        this.codecNeedsEosFlushWorkaround = false;
        this.codecNeedsMonoChannelCountWorkaround = false;
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        this.codecReceivedEos = false;
        this.codecReconfigurationState = 0;
        this.codecReinitializationState = 0;
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec != null) {
            this.decoderCounters.decoderReleaseCount++;
            try {
                mediaCodec.stop();
                try {
                    this.codec.release();
                    this.codec = null;
                    DrmSession<FrameworkMediaCrypto> drmSession = this.drmSession;
                    if (drmSession != null && this.pendingDrmSession != drmSession) {
                        try {
                            this.drmSessionManager.releaseSession(drmSession);
                        } finally {
                        }
                    }
                } catch (Throwable th5) {
                    this.codec = null;
                    DrmSession<FrameworkMediaCrypto> drmSession2 = this.drmSession;
                    if (drmSession2 != null && this.pendingDrmSession != drmSession2) {
                        try {
                            this.drmSessionManager.releaseSession(drmSession2);
                        } finally {
                        }
                    }
                    throw th5;
                }
            } catch (Throwable th6) {
                try {
                    this.codec.release();
                    this.codec = null;
                    DrmSession<FrameworkMediaCrypto> drmSession3 = this.drmSession;
                    if (drmSession3 != null && this.pendingDrmSession != drmSession3) {
                        try {
                            this.drmSessionManager.releaseSession(drmSession3);
                        } finally {
                        }
                    }
                    throw th6;
                } catch (Throwable th7) {
                    this.codec = null;
                    DrmSession<FrameworkMediaCrypto> drmSession4 = this.drmSession;
                    if (drmSession4 != null && this.pendingDrmSession != drmSession4) {
                        try {
                            this.drmSessionManager.releaseSession(drmSession4);
                        } finally {
                        }
                    }
                    throw th7;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j3, long j16) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            renderToEndOfStream();
            return;
        }
        if (this.format == null) {
            this.flagsOnlyBuffer.clear();
            int readSource = readSource(this.formatHolder, this.flagsOnlyBuffer, true);
            if (readSource == -5) {
                onInputFormatChanged(this.formatHolder.format);
            } else {
                if (readSource == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    processEndOfStream();
                    return;
                }
                return;
            }
        }
        maybeInitCodec();
        if (this.codec != null) {
            TraceUtil.beginSection("drainAndFeed");
            do {
            } while (drainOutputBuffer(j3, j16));
            do {
            } while (feedInputBuffer());
            TraceUtil.endSection();
        } else {
            this.decoderCounters.skippedInputBufferCount += skipSource(j3);
            this.flagsOnlyBuffer.clear();
            int readSource2 = readSource(this.formatHolder, this.flagsOnlyBuffer, false);
            if (readSource2 == -5) {
                onInputFormatChanged(this.formatHolder.format);
            } else if (readSource2 == -4) {
                Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                this.inputStreamEnded = true;
                processEndOfStream();
            }
        }
        this.decoderCounters.ensureUpdated();
    }

    protected boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format) throws ExoPlaybackException {
        try {
            return supportsFormat(this.mediaCodecSelector, this.drmSessionManager, format);
        } catch (MediaCodecUtil.DecoderQueryException e16) {
            throw ExoPlaybackException.createForRenderer(e16, getIndex());
        }
    }

    protected abstract int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public final String decoderName;
        public final String diagnosticInfo;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, Throwable th5, boolean z16, int i3) {
            super("Decoder init failed: [" + i3 + "], " + format, th5);
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z16;
            this.decoderName = null;
            this.diagnosticInfo = buildCustomDiagnosticInfo(i3);
        }

        private static String buildCustomDiagnosticInfo(int i3) {
            String str;
            if (i3 < 0) {
                str = "neg_";
            } else {
                str = "";
            }
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(i3);
        }

        @TargetApi(21)
        private static String getDiagnosticInfoV21(Throwable th5) {
            if (th5 instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th5).getDiagnosticInfo();
            }
            return null;
        }

        public DecoderInitializationException(Format format, Throwable th5, boolean z16, String str) {
            super("Decoder init failed: " + str + ", " + format, th5);
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z16;
            this.decoderName = str;
            this.diagnosticInfo = Util.SDK_INT >= 21 ? getDiagnosticInfoV21(th5) : null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
    }

    protected void renderToEndOfStream() throws ExoPlaybackException {
    }

    protected void onProcessedOutputBuffer(long j3) {
    }

    protected void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }

    protected void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    protected void onCodecInitialized(String str, long j3, long j16) {
    }
}
