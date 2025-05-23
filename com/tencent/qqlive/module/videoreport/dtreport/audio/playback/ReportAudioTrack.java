package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioPresentation;
import android.media.AudioRouting;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.media.VolumeShaper;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioTrackListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.util.AudioUtil;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportAudioTrack extends AudioTrack implements IAudioPlayer, IAudioTrackListener {
    private static final String TAG = "ReportAudioTrack";
    private BaseAudioPlayerProxy mAudioProxy;
    private AudioTrack mRealAudioTrack;
    private long mTotalBytes;

    /* compiled from: P */
    @RequiresApi(api = 23)
    /* loaded from: classes22.dex */
    public static class Builder extends AudioTrack.Builder {
        private int mCachBufferSizeInBytes;
        private AudioAttributes mCacheAudioAttributes;
        private AudioFormat mCacheAudioFormat;
        private int mCacheSessionId = 0;

        @Override // android.media.AudioTrack.Builder
        @NonNull
        public AudioTrack build() throws UnsupportedOperationException {
            AudioTrack build = super.build();
            if (!DTConfigConstants.config.audioReportSupport()) {
                return build;
            }
            ReportAudioTrack reportAudioTrack = new ReportAudioTrack(this.mCacheAudioAttributes, this.mCacheAudioFormat, this.mCachBufferSizeInBytes, 1, this.mCacheSessionId);
            reportAudioTrack.setRealAudioTrack(build);
            return reportAudioTrack;
        }

        @Override // android.media.AudioTrack.Builder
        @NonNull
        public AudioTrack.Builder setAudioAttributes(@NonNull AudioAttributes audioAttributes) throws IllegalArgumentException {
            this.mCacheAudioAttributes = audioAttributes;
            return super.setAudioAttributes(audioAttributes);
        }

        @Override // android.media.AudioTrack.Builder
        @NonNull
        public AudioTrack.Builder setAudioFormat(@NonNull AudioFormat audioFormat) throws IllegalArgumentException {
            this.mCacheAudioFormat = audioFormat;
            return super.setAudioFormat(audioFormat);
        }

        @Override // android.media.AudioTrack.Builder
        @NonNull
        public AudioTrack.Builder setBufferSizeInBytes(int i3) throws IllegalArgumentException {
            this.mCachBufferSizeInBytes = i3;
            return super.setBufferSizeInBytes(i3);
        }

        @Override // android.media.AudioTrack.Builder
        @NonNull
        public AudioTrack.Builder setSessionId(int i3) throws IllegalArgumentException {
            this.mCacheSessionId = i3;
            return super.setSessionId(i3);
        }
    }

    public ReportAudioTrack(int i3, int i16, int i17, int i18, int i19, int i26) throws IllegalArgumentException {
        super(i3, i16, i17, i18, i19, i26);
        this.mRealAudioTrack = null;
        this.mAudioProxy = new BaseAudioPlayerProxy(this);
    }

    private int bytesToDuration(long j3) {
        return (int) ((((float) j3) * 1000.0f) / getByteRate());
    }

    private int getByteRate() {
        return getSampleRate() * getChannelCount() * AudioUtil.getBytesPerSample(getAudioFormat());
    }

    private void handleErr(int i3) {
        if (i3 < 0) {
            this.mAudioProxy.onAudioError(this, i3, i3);
        }
        if (this.mTotalBytes >= getDtAudioStreamLength() && getDtAudioStreamLength() > 0) {
            this.mAudioProxy.onAudioCompletion(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRealAudioTrack(AudioTrack audioTrack) {
        this.mRealAudioTrack = audioTrack;
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 30)
    public void addOnCodecFormatChangedListener(@androidx.annotation.NonNull Executor executor, @androidx.annotation.NonNull AudioTrack.OnCodecFormatChangedListener onCodecFormatChangedListener) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.addOnCodecFormatChangedListener(executor, onCodecFormatChangedListener);
        } else {
            super.addOnCodecFormatChangedListener(executor, onCodecFormatChangedListener);
        }
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 23)
    public void addOnRoutingChangedListener(AudioTrack.OnRoutingChangedListener onRoutingChangedListener, Handler handler) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.addOnRoutingChangedListener(onRoutingChangedListener, handler);
        } else {
            super.addOnRoutingChangedListener(onRoutingChangedListener, handler);
        }
    }

    @Override // android.media.AudioTrack
    public int attachAuxEffect(int i3) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.attachAuxEffect(i3);
        }
        return super.attachAuxEffect(i3);
    }

    @Override // android.media.AudioTrack, android.media.VolumeAutomation
    @NonNull
    @RequiresApi(api = 26)
    public VolumeShaper createVolumeShaper(@NonNull VolumeShaper.Configuration configuration) {
        VolumeShaper createVolumeShaper;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            createVolumeShaper = audioTrack.createVolumeShaper(configuration);
            return createVolumeShaper;
        }
        return super.createVolumeShaper(configuration);
    }

    @Override // android.media.AudioTrack
    public void flush() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.flush();
        } else {
            super.flush();
        }
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 29)
    public AudioAttributes getAudioAttributes() {
        AudioAttributes audioAttributes;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioAttributes = audioTrack.getAudioAttributes();
            return audioAttributes;
        }
        return super.getAudioAttributes();
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 30)
    public float getAudioDescriptionMixLeveldB() {
        float audioDescriptionMixLeveldB;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioDescriptionMixLeveldB = audioTrack.getAudioDescriptionMixLeveldB();
            return audioDescriptionMixLeveldB;
        }
        return super.getAudioDescriptionMixLeveldB();
    }

    @Override // android.media.AudioTrack
    public int getAudioFormat() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getAudioFormat();
        }
        return super.getAudioFormat();
    }

    @Override // android.media.AudioTrack
    public int getAudioSessionId() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getAudioSessionId();
        }
        return super.getAudioSessionId();
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 24)
    public int getBufferCapacityInFrames() {
        int bufferCapacityInFrames;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            bufferCapacityInFrames = audioTrack.getBufferCapacityInFrames();
            return bufferCapacityInFrames;
        }
        return super.getBufferCapacityInFrames();
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 23)
    public int getBufferSizeInFrames() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getBufferSizeInFrames();
        }
        return super.getBufferSizeInFrames();
    }

    @Override // android.media.AudioTrack
    public int getChannelConfiguration() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getChannelConfiguration();
        }
        return super.getChannelConfiguration();
    }

    @Override // android.media.AudioTrack
    public int getChannelCount() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getChannelCount();
        }
        return super.getChannelCount();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer
    public final int getCurrentPosition__() {
        return bytesToDuration(this.mTotalBytes);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioTrackListener
    public long getDtAudioStreamLength() {
        return -1L;
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 30)
    public int getDualMonoMode() {
        int dualMonoMode;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            dualMonoMode = audioTrack.getDualMonoMode();
            return dualMonoMode;
        }
        return super.getDualMonoMode();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer
    public final int getDuration__() {
        return bytesToDuration(getDtAudioStreamLength());
    }

    @Override // android.media.AudioTrack
    @NonNull
    @RequiresApi(api = 23)
    public AudioFormat getFormat() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getFormat();
        }
        return super.getFormat();
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 28)
    public PersistableBundle getMetrics() {
        PersistableBundle metrics;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            metrics = audioTrack.getMetrics();
            return metrics;
        }
        return super.getMetrics();
    }

    @Override // android.media.AudioTrack
    public int getNotificationMarkerPosition() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getNotificationMarkerPosition();
        }
        return super.getNotificationMarkerPosition();
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 29)
    public int getOffloadDelay() {
        int offloadDelay;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            offloadDelay = audioTrack.getOffloadDelay();
            return offloadDelay;
        }
        return super.getOffloadDelay();
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 29)
    public int getOffloadPadding() {
        int offloadPadding;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            offloadPadding = audioTrack.getOffloadPadding();
            return offloadPadding;
        }
        return super.getOffloadPadding();
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 26)
    public int getPerformanceMode() {
        int performanceMode;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            performanceMode = audioTrack.getPerformanceMode();
            return performanceMode;
        }
        return super.getPerformanceMode();
    }

    @Override // android.media.AudioTrack
    public int getPlayState() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getPlayState();
        }
        return super.getPlayState();
    }

    @Override // android.media.AudioTrack
    public int getPlaybackHeadPosition() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getPlaybackHeadPosition();
        }
        return super.getPlaybackHeadPosition();
    }

    @Override // android.media.AudioTrack
    @NonNull
    @RequiresApi(api = 23)
    public PlaybackParams getPlaybackParams() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getPlaybackParams();
        }
        return super.getPlaybackParams();
    }

    @Override // android.media.AudioTrack
    public int getPlaybackRate() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getPlaybackRate();
        }
        return super.getPlaybackRate();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer
    public final String getPlayerId__() {
        if (this.mRealAudioTrack != null) {
            return "AudioTrack_" + this.mRealAudioTrack.hashCode();
        }
        return "AudioTrack_" + hashCode();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer
    public final int getPlayerType__() {
        return 101;
    }

    @Override // android.media.AudioTrack
    public int getPositionNotificationPeriod() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getPositionNotificationPeriod();
        }
        return super.getPositionNotificationPeriod();
    }

    @Override // android.media.AudioTrack, android.media.AudioRouting
    @RequiresApi(api = 23)
    public AudioDeviceInfo getPreferredDevice() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getPreferredDevice();
        }
        return super.getPreferredDevice();
    }

    @Override // android.media.AudioTrack, android.media.AudioRouting
    @RequiresApi(api = 23)
    public AudioDeviceInfo getRoutedDevice() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getRoutedDevice();
        }
        return super.getRoutedDevice();
    }

    @Override // android.media.AudioTrack
    public int getSampleRate() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getSampleRate();
        }
        return super.getSampleRate();
    }

    @Override // android.media.AudioTrack
    public int getState() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getState();
        }
        return super.getState();
    }

    @Override // android.media.AudioTrack
    public int getStreamType() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getStreamType();
        }
        return super.getStreamType();
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 19)
    public boolean getTimestamp(AudioTimestamp audioTimestamp) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getTimestamp(audioTimestamp);
        }
        return super.getTimestamp(audioTimestamp);
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 24)
    public int getUnderrunCount() {
        int underrunCount;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            underrunCount = audioTrack.getUnderrunCount();
            return underrunCount;
        }
        return super.getUnderrunCount();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer
    public final boolean isAudioPlayer__() {
        return true;
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 29)
    public boolean isOffloadedPlayback() {
        boolean isOffloadedPlayback;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            isOffloadedPlayback = audioTrack.isOffloadedPlayback();
            return isOffloadedPlayback;
        }
        return super.isOffloadedPlayback();
    }

    @Override // android.media.AudioTrack
    public void pause() throws IllegalStateException {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.pause();
        } else {
            super.pause();
        }
        this.mAudioProxy.pause();
    }

    @Override // android.media.AudioTrack
    public void play() throws IllegalStateException {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.play();
        } else {
            super.play();
        }
        if (!this.mAudioProxy.isPaused()) {
            this.mAudioProxy.prepare();
            this.mAudioProxy.onAudioPrepared(this);
        }
        this.mAudioProxy.start();
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 29)
    public void registerStreamEventCallback(@NonNull Executor executor, @NonNull AudioTrack.StreamEventCallback streamEventCallback) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.registerStreamEventCallback(executor, streamEventCallback);
        } else {
            super.registerStreamEventCallback(executor, streamEventCallback);
        }
    }

    @Override // android.media.AudioTrack
    public void release() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.release();
        } else {
            super.release();
        }
    }

    @Override // android.media.AudioTrack
    public int reloadStaticData() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.reloadStaticData();
        }
        return super.reloadStaticData();
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 30)
    public void removeOnCodecFormatChangedListener(@NonNull AudioTrack.OnCodecFormatChangedListener onCodecFormatChangedListener) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.removeOnCodecFormatChangedListener(onCodecFormatChangedListener);
        } else {
            super.removeOnCodecFormatChangedListener(onCodecFormatChangedListener);
        }
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 23)
    public void removeOnRoutingChangedListener(AudioTrack.OnRoutingChangedListener onRoutingChangedListener) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.removeOnRoutingChangedListener(onRoutingChangedListener);
        } else {
            super.removeOnRoutingChangedListener(onRoutingChangedListener);
        }
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 30)
    public boolean setAudioDescriptionMixLeveldB(float f16) {
        boolean audioDescriptionMixLeveldB;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioDescriptionMixLeveldB = audioTrack.setAudioDescriptionMixLeveldB(f16);
            return audioDescriptionMixLeveldB;
        }
        return super.setAudioDescriptionMixLeveldB(f16);
    }

    @Override // android.media.AudioTrack
    public int setAuxEffectSendLevel(float f16) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.setAuxEffectSendLevel(f16);
        }
        return super.setAuxEffectSendLevel(f16);
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 24)
    public int setBufferSizeInFrames(int i3) {
        int bufferSizeInFrames;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            bufferSizeInFrames = audioTrack.setBufferSizeInFrames(i3);
            return bufferSizeInFrames;
        }
        return super.setBufferSizeInFrames(i3);
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 30)
    public boolean setDualMonoMode(int i3) {
        boolean dualMonoMode;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            dualMonoMode = audioTrack.setDualMonoMode(i3);
            return dualMonoMode;
        }
        return super.setDualMonoMode(i3);
    }

    @Override // android.media.AudioTrack
    public int setLoopPoints(int i3, int i16, int i17) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.setLoopPoints(i3, i16, i17);
        }
        return super.setLoopPoints(i3, i16, i17);
    }

    @Override // android.media.AudioTrack
    public int setNotificationMarkerPosition(int i3) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.setNotificationMarkerPosition(i3);
        }
        return super.setNotificationMarkerPosition(i3);
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 29)
    public void setOffloadDelayPadding(int i3, int i16) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.setOffloadDelayPadding(i3, i16);
        } else {
            super.setOffloadDelayPadding(i3, i16);
        }
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 29)
    public void setOffloadEndOfStream() {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.setOffloadEndOfStream();
        } else {
            super.setOffloadEndOfStream();
        }
    }

    @Override // android.media.AudioTrack
    public int setPlaybackHeadPosition(int i3) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.setPlaybackHeadPosition(i3);
        }
        return super.setPlaybackHeadPosition(i3);
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 23)
    public void setPlaybackParams(@NonNull PlaybackParams playbackParams) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.setPlaybackParams(playbackParams);
        } else {
            super.setPlaybackParams(playbackParams);
        }
    }

    @Override // android.media.AudioTrack
    public void setPlaybackPositionUpdateListener(AudioTrack.OnPlaybackPositionUpdateListener onPlaybackPositionUpdateListener) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.setPlaybackPositionUpdateListener(onPlaybackPositionUpdateListener);
        } else {
            super.setPlaybackPositionUpdateListener(onPlaybackPositionUpdateListener);
        }
    }

    @Override // android.media.AudioTrack
    public int setPlaybackRate(int i3) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.setPlaybackRate(i3);
        }
        return super.setPlaybackRate(i3);
    }

    @Override // android.media.AudioTrack
    public int setPositionNotificationPeriod(int i3) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.setPositionNotificationPeriod(i3);
        }
        return super.setPositionNotificationPeriod(i3);
    }

    @Override // android.media.AudioTrack, android.media.AudioRouting
    @RequiresApi(api = 23)
    public boolean setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.setPreferredDevice(audioDeviceInfo);
        }
        return super.setPreferredDevice(audioDeviceInfo);
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 28)
    public int setPresentation(@NonNull AudioPresentation audioPresentation) {
        int presentation;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            presentation = audioTrack.setPresentation(audioPresentation);
            return presentation;
        }
        return super.setPresentation(audioPresentation);
    }

    @Override // android.media.AudioTrack
    public int setStereoVolume(float f16, float f17) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.setStereoVolume(f16, f17);
        }
        return super.setStereoVolume(f16, f17);
    }

    @Override // android.media.AudioTrack
    public int setVolume(float f16) {
        return super.setVolume(f16);
    }

    @Override // android.media.AudioTrack
    public void stop() throws IllegalStateException {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.stop();
        } else {
            super.stop();
        }
        this.mAudioProxy.stop();
        this.mAudioProxy.reset();
        this.mTotalBytes = 0L;
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 29)
    public void unregisterStreamEventCallback(@NonNull AudioTrack.StreamEventCallback streamEventCallback) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.unregisterStreamEventCallback(streamEventCallback);
        } else {
            super.unregisterStreamEventCallback(streamEventCallback);
        }
    }

    @Override // android.media.AudioTrack
    public int write(@NonNull short[] sArr, int i3, int i16) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.write(sArr, i3, i16);
        }
        return super.write(sArr, i3, i16);
    }

    public ReportAudioTrack(int i3, int i16, int i17, int i18, int i19, int i26, int i27) throws IllegalArgumentException {
        super(i3, i16, i17, i18, i19, i26, i27);
        this.mRealAudioTrack = null;
        this.mAudioProxy = new BaseAudioPlayerProxy(this);
    }

    @Override // android.media.AudioTrack, android.media.AudioRouting
    @RequiresApi(api = 24)
    public void addOnRoutingChangedListener(AudioRouting.OnRoutingChangedListener onRoutingChangedListener, Handler handler) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.addOnRoutingChangedListener(onRoutingChangedListener, handler);
        } else {
            super.addOnRoutingChangedListener(onRoutingChangedListener, handler);
        }
    }

    @Override // android.media.AudioTrack, android.media.AudioRouting
    @RequiresApi(api = 24)
    public void removeOnRoutingChangedListener(AudioRouting.OnRoutingChangedListener onRoutingChangedListener) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.removeOnRoutingChangedListener(onRoutingChangedListener);
        } else {
            super.removeOnRoutingChangedListener(onRoutingChangedListener);
        }
    }

    @Override // android.media.AudioTrack
    public void setPlaybackPositionUpdateListener(AudioTrack.OnPlaybackPositionUpdateListener onPlaybackPositionUpdateListener, Handler handler) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            audioTrack.setPlaybackPositionUpdateListener(onPlaybackPositionUpdateListener, handler);
        } else {
            super.setPlaybackPositionUpdateListener(onPlaybackPositionUpdateListener, handler);
        }
    }

    @Override // android.media.AudioTrack
    public int write(@NonNull byte[] bArr, int i3, int i16) {
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            return audioTrack.write(bArr, i3, i16);
        }
        return super.write(bArr, i3, i16);
    }

    @RequiresApi(api = 21)
    public ReportAudioTrack(AudioAttributes audioAttributes, AudioFormat audioFormat, int i3, int i16, int i17) throws IllegalArgumentException {
        super(audioAttributes, audioFormat, i3, i16, i17);
        this.mRealAudioTrack = null;
        this.mAudioProxy = new BaseAudioPlayerProxy(this);
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 21)
    public int write(@NonNull float[] fArr, int i3, int i16, int i17) {
        int write;
        this.mTotalBytes += AudioUtil.floatByteCount() * i16;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            write = audioTrack.write(fArr, i3, i16, i17);
        } else {
            write = super.write(fArr, i3, i16, i17);
        }
        handleErr(write);
        return write;
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 21)
    public int write(@NonNull ByteBuffer byteBuffer, int i3, int i16) {
        int write;
        this.mTotalBytes += i3;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            write = audioTrack.write(byteBuffer, i3, i16);
        } else {
            write = super.write(byteBuffer, i3, i16);
        }
        handleErr(write);
        return write;
    }

    @Override // android.media.AudioTrack
    @RequiresApi(api = 23)
    public int write(@NonNull ByteBuffer byteBuffer, int i3, int i16, long j3) {
        int write;
        this.mTotalBytes += i3;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            write = audioTrack.write(byteBuffer, i3, i16, j3);
        } else {
            write = super.write(byteBuffer, i3, i16, j3);
        }
        handleErr(write);
        return write;
    }

    @Override // android.media.AudioTrack
    @RequiresApi(23)
    public int write(@NonNull byte[] bArr, int i3, int i16, int i17) {
        int write;
        this.mTotalBytes += i16;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            write = audioTrack.write(bArr, i3, i16, i17);
        } else {
            write = super.write(bArr, i3, i16, i17);
        }
        handleErr(write);
        return write;
    }

    @Override // android.media.AudioTrack
    @RequiresApi(23)
    public int write(@NonNull short[] sArr, int i3, int i16, int i17) {
        int write;
        this.mTotalBytes += AudioUtil.shortByteSize() * i16;
        AudioTrack audioTrack = this.mRealAudioTrack;
        if (audioTrack != null) {
            write = audioTrack.write(sArr, i3, i16, i17);
        } else {
            write = super.write(sArr, i3, i16, i17);
        }
        handleErr(write);
        return write;
    }
}
