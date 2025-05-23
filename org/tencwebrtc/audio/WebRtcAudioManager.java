package org.tencwebrtc.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import org.tencwebrtc.CalledByNative;
import org.tencwebrtc.Logging;

/* compiled from: P */
/* loaded from: classes29.dex */
class WebRtcAudioManager {
    private static final int BITS_PER_SAMPLE = 16;
    private static final int DEFAULT_FRAME_PER_BUFFER = 256;
    private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    private static final String TAG = "WebRtcAudioManagerExternal";

    WebRtcAudioManager() {
    }

    @CalledByNative
    static AudioManager getAudioManager(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    @CalledByNative
    static int getInputBufferSize(Context context, AudioManager audioManager, int i3, int i16) {
        if (isLowLatencyInputSupported(context)) {
            return getLowLatencyFramesPerBuffer(audioManager);
        }
        return getMinInputFrameSize(i3, i16);
    }

    @CalledByNative
    static int getLowLatencyFrames(Context context, AudioManager audioManager, int i3, int i16) {
        Logging.d(TAG, "getLowLatencyFrames: isLowLatencyOutputSupported=" + isLowLatencyOutputSupported(context) + " getLowLatencyFramesPerBuffer=" + getLowLatencyFramesPerBuffer(audioManager) + " getMinOutputFrameSize=" + getMinOutputFrameSize(i3, i16));
        return getLowLatencyFramesPerBuffer(audioManager);
    }

    private static int getLowLatencyFramesPerBuffer(AudioManager audioManager) {
        String property = audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
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

    @CalledByNative
    static int getOutputBufferSize(Context context, AudioManager audioManager, int i3, int i16) {
        Logging.d(TAG, "isLowLatencyOutputSupported=" + isLowLatencyOutputSupported(context) + " getLowLatencyFramesPerBuffer=" + getLowLatencyFramesPerBuffer(audioManager) + " getMinOutputFrameSize=" + getMinOutputFrameSize(i3, i16));
        if (isLowLatencyOutputSupported(context)) {
            return getLowLatencyFramesPerBuffer(audioManager);
        }
        return getMinOutputFrameSize(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CalledByNative
    public static int getSampleRate(AudioManager audioManager) {
        int i3;
        if (WebRtcAudioUtils.runningOnEmulator()) {
            Logging.d(TAG, "Running emulator, overriding sample rate to 8 kHz.");
            return 8000;
        }
        int sampleRateForApiLevel = getSampleRateForApiLevel(audioManager);
        if (sampleRateForApiLevel == 24000) {
            i3 = 16000;
        } else {
            i3 = sampleRateForApiLevel;
        }
        Logging.d(TAG, "Sample rate is set to " + i3 + "(" + sampleRateForApiLevel + ") Hz");
        return i3;
    }

    private static int getSampleRateForApiLevel(AudioManager audioManager) {
        String property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        if (property == null) {
            return 16000;
        }
        return Integer.parseInt(property);
    }

    private static boolean isLowLatencyInputSupported(Context context) {
        if (isLowLatencyOutputSupported(context)) {
            return true;
        }
        return false;
    }

    @CalledByNative
    static boolean isLowLatencyOutputSupported(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }
}
