package org.tencwebrtc.audio;

import android.content.Context;
import android.media.AudioManager;
import org.tencwebrtc.JniCommon;
import org.tencwebrtc.Logging;

/* compiled from: P */
/* loaded from: classes29.dex */
public class JavaAudioDeviceModule implements AudioDeviceModule {
    private static final String TAG = "JavaAudioDeviceModule";
    private final WebRtcAudioRecord audioInput;
    private final AudioManager audioManager;
    private final WebRtcAudioTrack audioOutput;
    private final Context context;
    private final int inputSampleRate;
    private long nativeAudioDeviceModule;
    private final Object nativeLock;
    private final int outputSampleRate;
    private final boolean useStereoInput;
    private final boolean useStereoOutput;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface AudioRecordErrorCallback {
        void onWebRtcAudioRecordError(String str);

        void onWebRtcAudioRecordInitError(String str);

        void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum AudioRecordStartErrorCode {
        AUDIO_RECORD_START_EXCEPTION,
        AUDIO_RECORD_START_STATE_MISMATCH
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class AudioSamples {
        private final int audioFormat;
        private final int channelCount;
        private final byte[] data;
        private final int sampleRate;

        public AudioSamples(int i3, int i16, int i17, byte[] bArr) {
            this.audioFormat = i3;
            this.channelCount = i16;
            this.sampleRate = i17;
            this.data = bArr;
        }

        public int getAudioFormat() {
            return this.audioFormat;
        }

        public int getChannelCount() {
            return this.channelCount;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getSampleRate() {
            return this.sampleRate;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface AudioTrackErrorCallback {
        void onWebRtcAudioTrackError(String str);

        void onWebRtcAudioTrackInitError(String str);

        void onWebRtcAudioTrackStartError(AudioTrackStartErrorCode audioTrackStartErrorCode, String str);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum AudioTrackStartErrorCode {
        AUDIO_TRACK_START_EXCEPTION,
        AUDIO_TRACK_START_STATE_MISMATCH
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Builder {
        private int audioFormat;
        private final AudioManager audioManager;
        private AudioRecordErrorCallback audioRecordErrorCallback;
        private int audioSource;
        private AudioTrackErrorCallback audioTrackErrorCallback;
        private final Context context;
        private boolean enableReadFile;
        private int inputSampleRate;
        private int outputSampleRate;
        private SamplesReadyCallback samplesReadyCallback;
        private boolean useHardwareAcousticEchoCanceler;
        private boolean useHardwareNoiseSuppressor;
        private boolean useOpenSlesPlayer;
        private boolean useStereoInput;
        private boolean useStereoOutput;

        public AudioDeviceModule createAudioDeviceModule() {
            Logging.d(JavaAudioDeviceModule.TAG, "createAudioDeviceModule audioSource: " + this.audioSource);
            if (this.useHardwareNoiseSuppressor) {
                Logging.d(JavaAudioDeviceModule.TAG, "HW NS will be used.");
            } else {
                if (JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported()) {
                    Logging.d(JavaAudioDeviceModule.TAG, "Overriding default behavior; now using WebRTC NS!");
                }
                Logging.d(JavaAudioDeviceModule.TAG, "HW NS will not be used.");
            }
            if (this.useHardwareAcousticEchoCanceler) {
                Logging.d(JavaAudioDeviceModule.TAG, "HW AEC will be used.");
            } else {
                if (JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported()) {
                    Logging.d(JavaAudioDeviceModule.TAG, "Overriding default behavior; now using WebRTC AEC!");
                }
                Logging.d(JavaAudioDeviceModule.TAG, "HW AEC will not be used.");
            }
            WebRtcAudioRecord webRtcAudioRecord = new WebRtcAudioRecord(this.context, this.audioManager, this.audioSource, this.audioFormat, this.audioRecordErrorCallback, this.samplesReadyCallback, this.useHardwareAcousticEchoCanceler, this.useHardwareNoiseSuppressor);
            webRtcAudioRecord.setStartReadFile(this.enableReadFile);
            if (this.useOpenSlesPlayer) {
                return new JavaAudioDeviceModule(this.context, this.audioManager, webRtcAudioRecord, null, this.inputSampleRate, this.outputSampleRate, this.useStereoInput, this.useStereoOutput);
            }
            return new JavaAudioDeviceModule(this.context, this.audioManager, webRtcAudioRecord, new WebRtcAudioTrack(this.context, this.audioManager, this.audioTrackErrorCallback), this.inputSampleRate, this.outputSampleRate, this.useStereoInput, this.useStereoOutput);
        }

        public Builder setAudioFormat(int i3) {
            this.audioFormat = i3;
            return this;
        }

        public Builder setAudioRecordErrorCallback(AudioRecordErrorCallback audioRecordErrorCallback) {
            this.audioRecordErrorCallback = audioRecordErrorCallback;
            return this;
        }

        public Builder setAudioSource(int i3) {
            this.audioSource = i3;
            return this;
        }

        public Builder setAudioTrackErrorCallback(AudioTrackErrorCallback audioTrackErrorCallback) {
            this.audioTrackErrorCallback = audioTrackErrorCallback;
            return this;
        }

        public Builder setEnableReadFile(boolean z16) {
            this.enableReadFile = z16;
            return this;
        }

        public Builder setInputSampleRate(int i3) {
            Logging.d(JavaAudioDeviceModule.TAG, "Input sample rate overridden to: " + i3);
            this.inputSampleRate = i3;
            return this;
        }

        public Builder setOutputSampleRate(int i3) {
            Logging.d(JavaAudioDeviceModule.TAG, "Output sample rate overridden to: " + i3);
            this.outputSampleRate = i3;
            return this;
        }

        public Builder setSampleRate(int i3) {
            Logging.d(JavaAudioDeviceModule.TAG, "Input/Output sample rate overridden to: " + i3);
            this.inputSampleRate = i3;
            this.outputSampleRate = i3;
            return this;
        }

        public Builder setSamplesReadyCallback(SamplesReadyCallback samplesReadyCallback) {
            this.samplesReadyCallback = samplesReadyCallback;
            return this;
        }

        public Builder setUseHardwareAcousticEchoCanceler(boolean z16) {
            if (z16 && !JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported()) {
                Logging.e(JavaAudioDeviceModule.TAG, "HW AEC not supported");
                z16 = false;
            }
            this.useHardwareAcousticEchoCanceler = z16;
            return this;
        }

        public Builder setUseHardwareNoiseSuppressor(boolean z16) {
            if (z16 && !JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported()) {
                Logging.e(JavaAudioDeviceModule.TAG, "HW NS not supported");
                z16 = false;
            }
            this.useHardwareNoiseSuppressor = z16;
            return this;
        }

        public Builder setUseOpenSlesPlayer(boolean z16) {
            this.useOpenSlesPlayer = z16;
            return this;
        }

        public Builder setUseStereoInput(boolean z16) {
            this.useStereoInput = z16;
            return this;
        }

        public Builder setUseStereoOutput(boolean z16) {
            this.useStereoOutput = z16;
            return this;
        }

        Builder(Context context) {
            this.audioSource = 7;
            this.audioFormat = 2;
            this.useHardwareAcousticEchoCanceler = JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported();
            this.useHardwareNoiseSuppressor = JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported();
            this.context = context;
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            this.audioManager = audioManager;
            this.inputSampleRate = WebRtcAudioManager.getSampleRate(audioManager);
            this.outputSampleRate = WebRtcAudioManager.getSampleRate(audioManager);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface SamplesReadyCallback {
        void onWebRtcAudioRecordSamplesReady(AudioSamples audioSamples);
    }

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    public static boolean isBuiltInAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.isAcousticEchoCancelerSupported();
    }

    public static boolean isBuiltInNoiseSuppressorSupported() {
        return WebRtcAudioEffects.isNoiseSuppressorSupported();
    }

    private static native long nativeCreateAudioDeviceModule(Context context, AudioManager audioManager, WebRtcAudioRecord webRtcAudioRecord, WebRtcAudioTrack webRtcAudioTrack, int i3, int i16, boolean z16, boolean z17);

    @Override // org.tencwebrtc.audio.AudioDeviceModule
    public long getNativeAudioDeviceModulePointer() {
        long j3;
        try {
            synchronized (this.nativeLock) {
                if (this.nativeAudioDeviceModule == 0) {
                    this.nativeAudioDeviceModule = nativeCreateAudioDeviceModule(this.context, this.audioManager, this.audioInput, this.audioOutput, this.inputSampleRate, this.outputSampleRate, this.useStereoInput, this.useStereoOutput);
                }
                j3 = this.nativeAudioDeviceModule;
            }
            return j3;
        } catch (Throwable th5) {
            Logging.e(TAG, "getNativeAudioDeviceModulePointer: " + th5.toString());
            return 0L;
        }
    }

    @Override // org.tencwebrtc.audio.AudioDeviceModule
    public void release() {
        synchronized (this.nativeLock) {
            long j3 = this.nativeAudioDeviceModule;
            if (j3 != 0) {
                JniCommon.nativeReleaseRef(j3);
                this.nativeAudioDeviceModule = 0L;
            }
        }
    }

    @Override // org.tencwebrtc.audio.AudioDeviceModule
    public void setMicrophoneMute(boolean z16) {
        Logging.d(TAG, "setMicrophoneMute: " + z16);
        this.audioInput.setMicrophoneMute(z16);
    }

    @Override // org.tencwebrtc.audio.AudioDeviceModule
    public void setSpeakerMute(boolean z16) {
        Logging.d(TAG, "setSpeakerMute: " + z16);
        this.audioOutput.setSpeakerMute(z16);
    }

    JavaAudioDeviceModule(Context context, AudioManager audioManager, WebRtcAudioRecord webRtcAudioRecord, WebRtcAudioTrack webRtcAudioTrack, int i3, int i16, boolean z16, boolean z17) {
        this.nativeLock = new Object();
        this.context = context;
        this.audioManager = audioManager;
        this.audioInput = webRtcAudioRecord;
        this.audioOutput = webRtcAudioTrack;
        this.inputSampleRate = i3;
        this.outputSampleRate = i16;
        this.useStereoInput = z16;
        this.useStereoOutput = z17;
    }
}
