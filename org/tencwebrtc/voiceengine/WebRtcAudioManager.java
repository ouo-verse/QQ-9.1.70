package org.tencwebrtc.voiceengine;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import org.tencwebrtc.ContextUtils;
import org.tencwebrtc.Logging;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WebRtcAudioManager {
    private static final int BITS_PER_SAMPLE = 16;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_FRAME_PER_BUFFER = 256;
    private static final String TAG = "WebRtcAudioManager";
    private static final boolean blacklistDeviceForAAudioUsage = true;
    private static boolean blacklistDeviceForOpenSLESUsage;
    private static boolean blacklistDeviceForOpenSLESUsageIsOverridden;
    private static boolean useStereoInput;
    private static boolean useStereoOutput;
    private boolean aAudio;
    private final AudioManager audioManager;
    private boolean hardwareAEC;
    private boolean hardwareAGC;
    private boolean hardwareNS;
    private boolean initialized;
    private int inputBufferSize;
    private int inputChannels;
    private boolean lowLatencyInput;
    private boolean lowLatencyOutput;
    private final long nativeAudioManager;
    private int nativeChannels;
    private int nativeSampleRate;
    private int outputBufferSize;
    private int outputChannels;
    private boolean proAudio;
    private int sampleRate;
    private final VolumeLogger volumeLogger;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class VolumeLogger {
        private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
        private static final int TIMER_PERIOD_IN_SECONDS = 30;
        private final AudioManager audioManager;

        @Nullable
        private Timer timer;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public class LogVolumeTask extends TimerTask {
            private final int maxRingVolume;
            private final int maxVoiceCallVolume;

            LogVolumeTask(int i3, int i16) {
                this.maxRingVolume = i3;
                this.maxVoiceCallVolume = i16;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                int mode = VolumeLogger.this.audioManager.getMode();
                if (mode == 1) {
                    Logging.d(WebRtcAudioManager.TAG, "STREAM_RING stream volume: " + SystemMethodProxy.getStreamVolume(VolumeLogger.this.audioManager, 2) + " (max=" + this.maxRingVolume + ")");
                    return;
                }
                if (mode == 3) {
                    Logging.d(WebRtcAudioManager.TAG, "VOICE_CALL stream volume: " + SystemMethodProxy.getStreamVolume(VolumeLogger.this.audioManager, 0) + " (max=" + this.maxVoiceCallVolume + ")");
                }
            }
        }

        public VolumeLogger(AudioManager audioManager) {
            this.audioManager = audioManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
                this.timer = null;
            }
        }

        public void start() {
            BaseTimer baseTimer = new BaseTimer(THREAD_NAME);
            this.timer = baseTimer;
            baseTimer.schedule(new LogVolumeTask(this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
        }
    }

    WebRtcAudioManager(long j3) {
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioManager = j3;
        AudioManager audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
        this.audioManager = audioManager;
        this.volumeLogger = new VolumeLogger(audioManager);
        storeAudioParameters();
        nativeCacheAudioParameters(this.sampleRate, this.outputChannels, this.inputChannels, this.hardwareAEC, this.hardwareAGC, this.hardwareNS, this.lowLatencyOutput, this.lowLatencyInput, this.proAudio, this.aAudio, this.outputBufferSize, this.inputBufferSize, j3);
        WebRtcAudioUtils.logAudioState(TAG);
    }

    private static void assertTrue(boolean z16) {
        if (z16) {
        } else {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private void dispose() {
        Logging.d(TAG, "dispose" + WebRtcAudioUtils.getThreadInfo());
        if (this.initialized) {
            this.volumeLogger.stop();
        }
    }

    private int getLowLatencyInputFramesPerBuffer() {
        assertTrue(isLowLatencyInputSupported());
        return getLowLatencyOutputFramesPerBuffer();
    }

    private int getLowLatencyOutputFramesPerBuffer() {
        assertTrue(isLowLatencyOutputSupported());
        String property = this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
        if (property == null) {
            return 256;
        }
        return Integer.parseInt(property);
    }

    private static int getMinInputFrameSize(int i3, int i16) {
        int i17;
        int i18 = i16 * 2;
        if (i16 == 1) {
            i17 = 16;
        } else {
            i17 = 12;
        }
        return AudioRecord.getMinBufferSize(i3, i17, 2) / i18;
    }

    private static int getMinOutputFrameSize(int i3, int i16) {
        int i17;
        int i18 = i16 * 2;
        if (i16 == 1) {
            i17 = 4;
        } else {
            i17 = 12;
        }
        return AudioTrack.getMinBufferSize(i3, i17, 2) / i18;
    }

    private int getNativeOutputSampleRate() {
        if (WebRtcAudioUtils.runningOnEmulator()) {
            Logging.d(TAG, "Running emulator, overriding sample rate to 8 kHz.");
            return 8000;
        }
        if (WebRtcAudioUtils.isDefaultSampleRateOverridden()) {
            Logging.d(TAG, "Default sample rate is overriden to " + WebRtcAudioUtils.getDefaultSampleRateHz() + " Hz");
            return WebRtcAudioUtils.getDefaultSampleRateHz();
        }
        int sampleRateForApiLevel = getSampleRateForApiLevel();
        Logging.d(TAG, "Sample rate is set to " + sampleRateForApiLevel + " Hz");
        return sampleRateForApiLevel;
    }

    private int getSampleRateForApiLevel() {
        String property = this.audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        if (property == null) {
            return WebRtcAudioUtils.getDefaultSampleRateHz();
        }
        return Integer.parseInt(property);
    }

    public static synchronized boolean getStereoInput() {
        boolean z16;
        synchronized (WebRtcAudioManager.class) {
            z16 = useStereoInput;
        }
        return z16;
    }

    public static synchronized boolean getStereoOutput() {
        boolean z16;
        synchronized (WebRtcAudioManager.class) {
            z16 = useStereoOutput;
        }
        return z16;
    }

    private boolean hasEarpiece() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    private boolean init() {
        Logging.d(TAG, "init" + WebRtcAudioUtils.getThreadInfo());
        if (this.initialized) {
            return true;
        }
        Logging.d(TAG, "audio mode is: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
        this.initialized = true;
        this.volumeLogger.start();
        return true;
    }

    private boolean isAAudioSupported() {
        Logging.w(TAG, "AAudio support is currently disabled on all devices!");
        return false;
    }

    private static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    private boolean isCommunicationModeEnabled() {
        if (this.audioManager.getMode() == 3) {
            return true;
        }
        return false;
    }

    private boolean isDeviceBlacklistedForOpenSLESUsage() {
        boolean deviceIsBlacklistedForOpenSLESUsage;
        if (blacklistDeviceForOpenSLESUsageIsOverridden) {
            deviceIsBlacklistedForOpenSLESUsage = blacklistDeviceForOpenSLESUsage;
        } else {
            deviceIsBlacklistedForOpenSLESUsage = WebRtcAudioUtils.deviceIsBlacklistedForOpenSLESUsage();
        }
        if (deviceIsBlacklistedForOpenSLESUsage) {
            Logging.d(TAG, DeviceInfoMonitor.getModel() + " is blacklisted for OpenSL ES usage!");
        }
        return deviceIsBlacklistedForOpenSLESUsage;
    }

    private boolean isLowLatencyOutputSupported() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }

    private static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    private boolean isProAudioSupported() {
        if (ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.pro")) {
            return true;
        }
        return false;
    }

    private native void nativeCacheAudioParameters(int i3, int i16, int i17, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, int i18, int i19, long j3);

    public static synchronized void setBlacklistDeviceForOpenSLESUsage(boolean z16) {
        synchronized (WebRtcAudioManager.class) {
            blacklistDeviceForOpenSLESUsageIsOverridden = true;
            blacklistDeviceForOpenSLESUsage = z16;
        }
    }

    public static synchronized void setStereoInput(boolean z16) {
        synchronized (WebRtcAudioManager.class) {
            Logging.w(TAG, "Overriding default input behavior: setStereoInput(" + z16 + ')');
            useStereoInput = z16;
        }
    }

    public static synchronized void setStereoOutput(boolean z16) {
        synchronized (WebRtcAudioManager.class) {
            Logging.w(TAG, "Overriding default output behavior: setStereoOutput(" + z16 + ')');
            useStereoOutput = z16;
        }
    }

    private void storeAudioParameters() {
        int i3;
        int minOutputFrameSize;
        int minInputFrameSize;
        int i16 = 2;
        if (getStereoOutput()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        this.outputChannels = i3;
        if (!getStereoInput()) {
            i16 = 1;
        }
        this.inputChannels = i16;
        this.sampleRate = getNativeOutputSampleRate();
        this.hardwareAEC = isAcousticEchoCancelerSupported();
        this.hardwareAGC = false;
        this.hardwareNS = isNoiseSuppressorSupported();
        this.lowLatencyOutput = isLowLatencyOutputSupported();
        this.lowLatencyInput = isLowLatencyInputSupported();
        this.proAudio = isProAudioSupported();
        this.aAudio = isAAudioSupported();
        if (this.lowLatencyOutput) {
            minOutputFrameSize = getLowLatencyOutputFramesPerBuffer();
        } else {
            minOutputFrameSize = getMinOutputFrameSize(this.sampleRate, this.outputChannels);
        }
        this.outputBufferSize = minOutputFrameSize;
        if (this.lowLatencyInput) {
            minInputFrameSize = getLowLatencyInputFramesPerBuffer();
        } else {
            minInputFrameSize = getMinInputFrameSize(this.sampleRate, this.inputChannels);
        }
        this.inputBufferSize = minInputFrameSize;
    }

    public boolean isLowLatencyInputSupported() {
        if (isLowLatencyOutputSupported()) {
            return true;
        }
        return false;
    }
}
