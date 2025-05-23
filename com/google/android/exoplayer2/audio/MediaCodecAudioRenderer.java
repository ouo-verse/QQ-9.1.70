package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import java.nio.ByteBuffer;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes2.dex */
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private boolean allowFirstBufferPositionDiscontinuity;
    private boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private int channelCount;
    private boolean codecNeedsDiscardChannelsWorkaround;
    private long currentPositionUs;
    private int encoderDelay;
    private int encoderPadding;
    private final AudioRendererEventListener.EventDispatcher eventDispatcher;
    private boolean passthroughEnabled;
    private MediaFormat passthroughMediaFormat;
    private int pcmEncoding;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class AudioSinkListener implements AudioSink.Listener {
        AudioSinkListener() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public boolean isNeedAudioData() {
            return MediaCodecAudioRenderer.this.eventDispatcher.isNeedAudioData();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSessionId(int i3) {
            MediaCodecAudioRenderer.this.eventDispatcher.audioSessionId(i3);
            MediaCodecAudioRenderer.this.onAudioSessionId(i3);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionDiscontinuity() {
            MediaCodecAudioRenderer.this.onAudioTrackPositionDiscontinuity();
            MediaCodecAudioRenderer.this.allowPositionDiscontinuity = true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onRenderAudioData(byte[] bArr) {
            MediaCodecAudioRenderer.this.eventDispatcher.onRenderAudioData(bArr);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onUnderrun(int i3, long j3, long j16) {
            MediaCodecAudioRenderer.this.eventDispatcher.audioTrackUnderrun(i3, j3, j16);
            MediaCodecAudioRenderer.this.onAudioTrackUnderrun(i3, j3, j16);
        }
    }

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector) {
        this(mediaCodecSelector, (DrmSessionManager<FrameworkMediaCrypto>) null, true);
    }

    private static boolean codecNeedsDiscardChannelsWorkaround(String str) {
        if (Util.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equals(Util.MANUFACTURER)) {
            String str2 = Util.DEVICE;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private void updateCurrentPosition() {
        long currentPositionUs = this.audioSink.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.allowPositionDiscontinuity) {
                currentPositionUs = Math.max(this.currentPositionUs, currentPositionUs);
            }
            this.currentPositionUs = currentPositionUs;
            this.allowPositionDiscontinuity = false;
        }
    }

    protected boolean allowPassthrough(String str) {
        int encoding = MimeTypes.getEncoding(str);
        if (encoding != 0 && this.audioSink.isEncodingSupported(encoding)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.codecNeedsDiscardChannelsWorkaround = codecNeedsDiscardChannelsWorkaround(mediaCodecInfo.name);
        MediaFormat mediaFormatForPlayback = getMediaFormatForPlayback(format);
        if (this.passthroughEnabled) {
            this.passthroughMediaFormat = mediaFormatForPlayback;
            mediaFormatForPlayback.setString("mime", "audio/raw");
            mediaCodec.configure(this.passthroughMediaFormat, (Surface) null, mediaCrypto, 0);
            this.passthroughMediaFormat.setString("mime", format.sampleMimeType);
            return;
        }
        mediaCodec.configure(mediaFormatForPlayback, (Surface) null, mediaCrypto, 0);
        this.passthroughMediaFormat = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecInfo getDecoderInfo(MediaCodecSelector mediaCodecSelector, Format format, boolean z16, boolean z17) throws MediaCodecUtil.DecoderQueryException {
        MediaCodecInfo passthroughDecoderInfo;
        if (allowPassthrough(format.sampleMimeType) && (passthroughDecoderInfo = mediaCodecSelector.getPassthroughDecoderInfo()) != null) {
            this.passthroughEnabled = true;
            return passthroughDecoderInfo;
        }
        this.passthroughEnabled = false;
        return super.getDecoderInfo(mediaCodecSelector, format, z16, z17);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.audioSink.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            updateCurrentPosition();
        }
        return this.currentPositionUs;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i3, Object obj) throws ExoPlaybackException {
        if (i3 != 2) {
            if (i3 != 3) {
                super.handleMessage(i3, obj);
                return;
            } else {
                this.audioSink.setAudioAttributes((AudioAttributes) obj);
                return;
            }
        }
        this.audioSink.setVolume(((Float) obj).floatValue());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        if (super.isEnded() && this.audioSink.isEnded()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (!this.audioSink.hasPendingData() && !super.isReady()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String str, long j3, long j16) {
        this.eventDispatcher.decoderInitialized(str, j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        try {
            this.audioSink.release();
            try {
                super.onDisabled();
            } finally {
            }
        } catch (Throwable th5) {
            try {
                super.onDisabled();
                throw th5;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z16) throws ExoPlaybackException {
        super.onEnabled(z16);
        this.eventDispatcher.enabled(this.decoderCounters);
        int i3 = getConfiguration().tunnelingAudioSessionId;
        if (i3 != 0) {
            this.audioSink.enableTunnelingV21(i3);
        } else {
            this.audioSink.disableTunneling();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(Format format) throws ExoPlaybackException {
        int i3;
        super.onInputFormatChanged(format);
        this.eventDispatcher.inputFormatChanged(format);
        if ("audio/raw".equals(format.sampleMimeType)) {
            i3 = format.pcmEncoding;
        } else {
            i3 = 2;
        }
        this.pcmEncoding = i3;
        this.channelCount = format.channelCount;
        int i16 = format.encoderDelay;
        int i17 = 0;
        if (i16 == -1) {
            i16 = 0;
        }
        this.encoderDelay = i16;
        int i18 = format.encoderPadding;
        if (i18 != -1) {
            i17 = i18;
        }
        this.encoderPadding = i17;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int i3;
        int[] iArr;
        int i16;
        MediaFormat mediaFormat2 = this.passthroughMediaFormat;
        if (mediaFormat2 != null) {
            i3 = MimeTypes.getEncoding(mediaFormat2.getString("mime"));
            mediaFormat = this.passthroughMediaFormat;
        } else {
            i3 = this.pcmEncoding;
        }
        int i17 = i3;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.codecNeedsDiscardChannelsWorkaround && integer == 6 && (i16 = this.channelCount) < 6) {
            iArr = new int[i16];
            for (int i18 = 0; i18 < this.channelCount; i18++) {
                iArr[i18] = i18;
            }
        } else {
            iArr = null;
        }
        try {
            this.audioSink.configure(i17, integer, integer2, 0, iArr, this.encoderDelay, this.encoderPadding);
        } catch (AudioSink.ConfigurationException e16) {
            throw ExoPlaybackException.createForRenderer(e16, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j3, boolean z16) throws ExoPlaybackException {
        super.onPositionReset(j3, z16);
        this.audioSink.reset();
        this.currentPositionUs = j3;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (this.allowFirstBufferPositionDiscontinuity && !decoderInputBuffer.isDecodeOnly()) {
            if (Math.abs(decoderInputBuffer.timeUs - this.currentPositionUs) > 500000) {
                this.currentPositionUs = decoderInputBuffer.timeUs;
            }
            this.allowFirstBufferPositionDiscontinuity = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.audioSink.play();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.audioSink.pause();
        updateCurrentPosition();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long j3, long j16, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i3, int i16, long j17, boolean z16) throws ExoPlaybackException {
        if (this.passthroughEnabled && (i16 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i3, false);
            return true;
        }
        if (z16) {
            mediaCodec.releaseOutputBuffer(i3, false);
            this.decoderCounters.skippedOutputBufferCount++;
            this.audioSink.handleDiscontinuity();
            return true;
        }
        try {
            if (!this.audioSink.handleBuffer(byteBuffer, j17)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i3, false);
            this.decoderCounters.renderedOutputBufferCount++;
            return true;
        } catch (AudioSink.InitializationException | AudioSink.WriteException e16) {
            throw ExoPlaybackException.createForRenderer(e16, getIndex());
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void renderToEndOfStream() throws ExoPlaybackException {
        try {
            this.audioSink.playToEndOfStream();
        } catch (AudioSink.WriteException e16) {
            throw ExoPlaybackException.createForRenderer(e16, getIndex());
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        return this.audioSink.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i3;
        boolean z16;
        int i16;
        int i17;
        String str = format.sampleMimeType;
        boolean z17 = false;
        if (!MimeTypes.isAudio(str)) {
            return 0;
        }
        if (Util.SDK_INT >= 21) {
            i3 = 32;
        } else {
            i3 = 0;
        }
        boolean supportsFormatDrm = BaseRenderer.supportsFormatDrm(drmSessionManager, format.drmInitData);
        int i18 = 4;
        if (supportsFormatDrm && allowPassthrough(str) && mediaCodecSelector.getPassthroughDecoderInfo() != null) {
            return i3 | 8 | 4;
        }
        if (("audio/raw".equals(str) && !this.audioSink.isEncodingSupported(format.pcmEncoding)) || !this.audioSink.isEncodingSupported(2)) {
            return 1;
        }
        DrmInitData drmInitData = format.drmInitData;
        if (drmInitData != null) {
            z16 = false;
            for (int i19 = 0; i19 < drmInitData.schemeDataCount; i19++) {
                z16 |= drmInitData.get(i19).requiresSecureDecryption;
            }
        } else {
            z16 = false;
        }
        MediaCodecInfo decoderInfo = mediaCodecSelector.getDecoderInfo(str, z16, false);
        if (decoderInfo == null) {
            if (!z16 || mediaCodecSelector.getDecoderInfo(str, false, false) == null) {
                return 1;
            }
            return 2;
        }
        if (!supportsFormatDrm) {
            return 2;
        }
        if (Util.SDK_INT < 21 || (((i16 = format.sampleRate) == -1 || decoderInfo.isAudioSampleRateSupportedV21(i16)) && ((i17 = format.channelCount) == -1 || decoderInfo.isAudioChannelCountSupportedV21(i17)))) {
            z17 = true;
        }
        if (!z17) {
            i18 = 3;
        }
        return i3 | 8 | i18;
    }

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z16) {
        this(mediaCodecSelector, drmSessionManager, z16, null, null);
    }

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
        this(mediaCodecSelector, null, true, handler, audioRendererEventListener);
    }

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z16, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
        this(mediaCodecSelector, drmSessionManager, z16, handler, audioRendererEventListener, null, new AudioProcessor[0]);
    }

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z16, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, @Nullable AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(mediaCodecSelector, drmSessionManager, z16, handler, audioRendererEventListener, new DefaultAudioSink(audioCapabilities, audioProcessorArr));
    }

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z16, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1, mediaCodecSelector, drmSessionManager, z16);
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.audioSink = audioSink;
        audioSink.setListener(new AudioSinkListener());
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public MediaClock getMediaClock() {
        return this;
    }

    protected void onAudioTrackPositionDiscontinuity() {
    }

    protected void onAudioSessionId(int i3) {
    }

    protected void onAudioTrackUnderrun(int i3, long j3, long j16) {
    }
}
