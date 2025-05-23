package org.tencwebrtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.nio.ByteBuffer;
import org.tencwebrtc.CalledByNative;
import org.tencwebrtc.Logging;
import org.tencwebrtc.ThreadUtils;
import org.tencwebrtc.audio.JavaAudioDeviceModule;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class WebRtcAudioTrack {
    private static final long AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final int DEFAULT_USAGE = getDefaultUsageAttribute();
    private static final String TAG = "WebRtcAudioTrackExternal";
    private final AudioManager audioManager;

    @Nullable
    private AudioTrackThread audioThread;

    @Nullable
    private AudioTrack audioTrack;
    private ByteBuffer byteBuffer;
    private final Context context;
    private byte[] emptyBytes;

    @Nullable
    private final JavaAudioDeviceModule.AudioTrackErrorCallback errorCallback;
    private long nativeAudioTrack;
    private volatile boolean speakerMute;
    private final ThreadUtils.ThreadChecker threadChecker;
    private final VolumeLogger volumeLogger;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private class AudioTrackThread extends BaseThread {
        private volatile boolean keepAlive;

        public AudioTrackThread(String str) {
            super(str);
            this.keepAlive = true;
        }

        private int writeBytes(AudioTrack audioTrack, ByteBuffer byteBuffer, int i3) {
            return audioTrack.write(byteBuffer, i3, 0);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z16;
            boolean z17;
            Process.setThreadPriority(-19);
            Logging.d(WebRtcAudioTrack.TAG, "AudioTrackThread" + WebRtcAudioUtils.getThreadInfo());
            if (WebRtcAudioTrack.this.audioTrack.getPlayState() == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            WebRtcAudioTrack.assertTrue(z16);
            int capacity = WebRtcAudioTrack.this.byteBuffer.capacity();
            while (this.keepAlive) {
                WebRtcAudioTrack.nativeGetPlayoutData(WebRtcAudioTrack.this.nativeAudioTrack, capacity);
                if (capacity <= WebRtcAudioTrack.this.byteBuffer.remaining()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                WebRtcAudioTrack.assertTrue(z17);
                if (WebRtcAudioTrack.this.speakerMute) {
                    WebRtcAudioTrack.this.byteBuffer.clear();
                    WebRtcAudioTrack.this.byteBuffer.put(WebRtcAudioTrack.this.emptyBytes);
                    WebRtcAudioTrack.this.byteBuffer.position(0);
                }
                int writeBytes = writeBytes(WebRtcAudioTrack.this.audioTrack, WebRtcAudioTrack.this.byteBuffer, capacity);
                if (writeBytes != capacity) {
                    Logging.e(WebRtcAudioTrack.TAG, "AudioTrack.write played invalid number of bytes: " + writeBytes);
                    if (writeBytes < 0) {
                        this.keepAlive = false;
                        WebRtcAudioTrack.this.reportWebRtcAudioTrackError("AudioTrack.write failed: " + writeBytes);
                    }
                }
                WebRtcAudioTrack.this.byteBuffer.rewind();
            }
            if (WebRtcAudioTrack.this.audioTrack != null) {
                Logging.d(WebRtcAudioTrack.TAG, "Calling AudioTrack.stop...");
                try {
                    WebRtcAudioTrack.this.audioTrack.stop();
                    Logging.d(WebRtcAudioTrack.TAG, "AudioTrack.stop is done.");
                } catch (IllegalStateException e16) {
                    Logging.e(WebRtcAudioTrack.TAG, "AudioTrack.stop failed: " + e16.getMessage());
                }
            }
        }

        public void stopThread() {
            Logging.d(WebRtcAudioTrack.TAG, "stopThread");
            this.keepAlive = false;
        }
    }

    @CalledByNative
    WebRtcAudioTrack(Context context, AudioManager audioManager) {
        this(context, audioManager, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertTrue(boolean z16) {
        if (z16) {
        } else {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private int channelCountToConfiguration(int i3) {
        if (i3 == 1) {
            return 4;
        }
        return 12;
    }

    @TargetApi(21)
    private static AudioTrack createAudioTrackOnLollipopOrHigher(int i3, int i16, int i17) {
        Logging.d(TAG, "createAudioTrackOnLollipopOrHigher");
        int nativeOutputSampleRate = AudioTrack.getNativeOutputSampleRate(3);
        Logging.d(TAG, "nativeOutputSampleRate: " + nativeOutputSampleRate);
        if (i3 != nativeOutputSampleRate) {
            Logging.w(TAG, "Unable to use fast mode since requested sample rate is not native");
        }
        return new ReportAudioTrack(new AudioAttributes.Builder().setUsage(DEFAULT_USAGE).setContentType(2).build(), new AudioFormat.Builder().setEncoding(2).setSampleRate(i3).setChannelMask(i16).build(), i17, 1, 0);
    }

    private static AudioTrack createAudioTrackOnLowerThanLollipop(int i3, int i16, int i17) {
        return new ReportAudioTrack(3, i3, i16, 2, i17, 1);
    }

    private static int getDefaultUsageAttribute() {
        return 1;
    }

    @CalledByNative
    private int getStreamMaxVolume() {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "getStreamMaxVolume");
        return this.audioManager.getStreamMaxVolume(3);
    }

    @CalledByNative
    private int getStreamVolume() {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "getStreamVolume");
        return SystemMethodProxy.getStreamVolume(this.audioManager, 3);
    }

    @CalledByNative
    private boolean initPlayout(int i3, int i16) {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "initPlayout(sampleRate=" + i3 + ", channels=" + i16 + ")");
        this.byteBuffer = ByteBuffer.allocateDirect(i16 * 2 * (i3 / 100));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("byteBuffer.capacity: ");
        sb5.append(this.byteBuffer.capacity());
        Logging.d(TAG, sb5.toString());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.nativeAudioTrack, this.byteBuffer);
        int channelCountToConfiguration = channelCountToConfiguration(i16);
        int minBufferSize = AudioTrack.getMinBufferSize(i3, channelCountToConfiguration, 2);
        Logging.d(TAG, "AudioTrack.getMinBufferSize: " + minBufferSize);
        if (minBufferSize < this.byteBuffer.capacity()) {
            reportWebRtcAudioTrackInitError("AudioTrack.getMinBufferSize returns an invalid value.");
            return false;
        }
        if (this.audioTrack != null) {
            reportWebRtcAudioTrackInitError("Conflict with existing AudioTrack.");
            return false;
        }
        Logging.d(TAG, "AudioTrack: samplerate: " + i3 + " channel: " + channelCountToConfiguration + " buffer size: " + minBufferSize);
        try {
            AudioTrack createAudioTrackOnLollipopOrHigher = createAudioTrackOnLollipopOrHigher(i3, channelCountToConfiguration, minBufferSize);
            this.audioTrack = createAudioTrackOnLollipopOrHigher;
            if (createAudioTrackOnLollipopOrHigher != null && createAudioTrackOnLollipopOrHigher.getState() == 1) {
                logMainParameters();
                logMainParametersExtended();
                return true;
            }
            reportWebRtcAudioTrackInitError("Initialization of audio track failed.");
            releaseAudioResources();
            return false;
        } catch (IllegalArgumentException e16) {
            reportWebRtcAudioTrackInitError(e16.getMessage());
            releaseAudioResources();
            return false;
        }
    }

    private boolean isVolumeFixed() {
        return this.audioManager.isVolumeFixed();
    }

    private void logBufferCapacityInFrames() {
        int bufferCapacityInFrames;
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("AudioTrack: buffer capacity in frames: ");
            bufferCapacityInFrames = this.audioTrack.getBufferCapacityInFrames();
            sb5.append(bufferCapacityInFrames);
            Logging.d(TAG, sb5.toString());
        }
    }

    private void logBufferSizeInFrames() {
        Logging.d(TAG, "AudioTrack: buffer size in frames: " + this.audioTrack.getBufferSizeInFrames());
    }

    private void logMainParameters() {
        Logging.d(TAG, "AudioTrack: session ID: " + this.audioTrack.getAudioSessionId() + ", channels: " + this.audioTrack.getChannelCount() + ", sample rate: " + this.audioTrack.getSampleRate() + ", max gain: " + AudioTrack.getMaxVolume());
    }

    private void logMainParametersExtended() {
        logBufferSizeInFrames();
        logBufferCapacityInFrames();
    }

    private void logUnderrunCount() {
        int underrunCount;
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("underrun count: ");
            underrunCount = this.audioTrack.getUnderrunCount();
            sb5.append(underrunCount);
            Logging.d(TAG, sb5.toString());
        }
    }

    private static native void nativeCacheDirectBufferAddress(long j3, ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeGetPlayoutData(long j3, int i3);

    private void releaseAudioResources() {
        Logging.d(TAG, "releaseAudioResources");
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this.audioTrack = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioTrackError(String str) {
        Logging.e(TAG, "Run-time playback error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback = this.errorCallback;
        if (audioTrackErrorCallback != null) {
            audioTrackErrorCallback.onWebRtcAudioTrackError(str);
        }
    }

    private void reportWebRtcAudioTrackInitError(String str) {
        Logging.e(TAG, "Init playout error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback = this.errorCallback;
        if (audioTrackErrorCallback != null) {
            audioTrackErrorCallback.onWebRtcAudioTrackInitError(str);
        }
    }

    private void reportWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode, String str) {
        Logging.e(TAG, "Start playout error: " + audioTrackStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback = this.errorCallback;
        if (audioTrackErrorCallback != null) {
            audioTrackErrorCallback.onWebRtcAudioTrackStartError(audioTrackStartErrorCode, str);
        }
    }

    @CalledByNative
    private boolean setStreamVolume(int i3) {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "setStreamVolume(" + i3 + ")");
        if (isVolumeFixed()) {
            Logging.e(TAG, "The device implements a fixed volume policy.");
            return false;
        }
        this.audioManager.setStreamVolume(3, i3, 0);
        return true;
    }

    @CalledByNative
    private boolean startPlayout() {
        boolean z16;
        boolean z17;
        this.threadChecker.checkIsOnValidThread();
        this.volumeLogger.start();
        Logging.d(TAG, "startPlayout");
        if (this.audioTrack != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        assertTrue(z16);
        if (this.audioThread == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        assertTrue(z17);
        try {
            this.audioTrack.play();
            if (this.audioTrack.getPlayState() != 3) {
                reportWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode.AUDIO_TRACK_START_STATE_MISMATCH, "AudioTrack.play failed - incorrect state :" + this.audioTrack.getPlayState());
                releaseAudioResources();
                return false;
            }
            AudioTrackThread audioTrackThread = new AudioTrackThread("AudioTrackJavaThread");
            this.audioThread = audioTrackThread;
            audioTrackThread.start();
            return true;
        } catch (IllegalStateException e16) {
            reportWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode.AUDIO_TRACK_START_EXCEPTION, "AudioTrack.play failed: " + e16.getMessage());
            releaseAudioResources();
            return false;
        }
    }

    @CalledByNative
    private boolean stopPlayout() {
        boolean z16;
        this.threadChecker.checkIsOnValidThread();
        this.volumeLogger.stop();
        Logging.d(TAG, "stopPlayout");
        if (this.audioThread != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        assertTrue(z16);
        logUnderrunCount();
        this.audioThread.stopThread();
        Logging.d(TAG, "Stopping the AudioTrackThread...");
        this.audioThread.interrupt();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L)) {
            Logging.e(TAG, "Join of AudioTrackThread timed out.");
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        }
        Logging.d(TAG, "AudioTrackThread has now been stopped.");
        this.audioThread = null;
        releaseAudioResources();
        return true;
    }

    @CalledByNative
    public void setNativeAudioTrack(long j3) {
        this.nativeAudioTrack = j3;
    }

    public void setSpeakerMute(boolean z16) {
        Logging.w(TAG, "setSpeakerMute(" + z16 + ")");
        this.speakerMute = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebRtcAudioTrack(Context context, AudioManager audioManager, @Nullable JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        threadChecker.detachThread();
        this.context = context;
        this.audioManager = audioManager;
        this.errorCallback = audioTrackErrorCallback;
        this.volumeLogger = new VolumeLogger(audioManager);
    }
}
