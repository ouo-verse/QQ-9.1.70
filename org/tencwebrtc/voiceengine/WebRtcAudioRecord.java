package org.tencwebrtc.voiceengine;

import android.media.AudioRecord;
import android.os.Process;
import android.support.annotation.Nullable;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.tencwebrtc.Logging;
import org.tencwebrtc.ThreadUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WebRtcAudioRecord {
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_AUDIO_SOURCE;
    private static final String TAG = "WebRtcAudioRecord";

    @Nullable
    private static WebRtcAudioRecordSamplesReadyCallback audioSamplesReadyCallback;
    private static int audioSource;

    @Nullable
    private static WebRtcAudioRecordErrorCallback errorCallback;
    private static volatile boolean microphoneMute;

    @Nullable
    private AudioRecord audioRecord;

    @Nullable
    private AudioRecordThread audioThread;
    private ByteBuffer byteBuffer;

    @Nullable
    private WebRtcAudioEffects effects;
    private byte[] emptyBytes;
    private final long nativeAudioRecord;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum AudioRecordStartErrorCode {
        AUDIO_RECORD_START_EXCEPTION,
        AUDIO_RECORD_START_STATE_MISMATCH
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private class AudioRecordThread extends BaseThread {
        private volatile boolean keepAlive;

        public AudioRecordThread(String str) {
            super(str);
            this.keepAlive = true;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z16;
            Process.setThreadPriority(-19);
            Logging.d(WebRtcAudioRecord.TAG, "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
            if (WebRtcAudioRecord.this.audioRecord.getRecordingState() == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            WebRtcAudioRecord.assertTrue(z16);
            System.nanoTime();
            while (this.keepAlive) {
                int read = WebRtcAudioRecord.this.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
                if (read == WebRtcAudioRecord.this.byteBuffer.capacity()) {
                    if (WebRtcAudioRecord.microphoneMute) {
                        WebRtcAudioRecord.this.byteBuffer.clear();
                        WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                    }
                    if (this.keepAlive) {
                        WebRtcAudioRecord webRtcAudioRecord = WebRtcAudioRecord.this;
                        webRtcAudioRecord.nativeDataIsRecorded(read, webRtcAudioRecord.nativeAudioRecord);
                    }
                    if (WebRtcAudioRecord.audioSamplesReadyCallback != null) {
                        WebRtcAudioRecord.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new AudioSamples(WebRtcAudioRecord.this.audioRecord, Arrays.copyOf(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.capacity())));
                    }
                } else {
                    String str = "AudioRecord.read failed: " + read;
                    Logging.e(WebRtcAudioRecord.TAG, str);
                    if (read == -3) {
                        this.keepAlive = false;
                        WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str);
                    }
                }
            }
            try {
                if (WebRtcAudioRecord.this.audioRecord != null) {
                    WebRtcAudioRecord.this.audioRecord.stop();
                }
            } catch (IllegalStateException e16) {
                Logging.e(WebRtcAudioRecord.TAG, "AudioRecord.stop failed: " + e16.getMessage());
            }
        }

        public void stopThread() {
            Logging.d(WebRtcAudioRecord.TAG, "stopThread");
            this.keepAlive = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class AudioSamples {
        private final int audioFormat;
        private final int channelCount;
        private final byte[] data;
        private final int sampleRate;

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

        AudioSamples(AudioRecord audioRecord, byte[] bArr) {
            this.audioFormat = audioRecord.getAudioFormat();
            this.channelCount = audioRecord.getChannelCount();
            this.sampleRate = audioRecord.getSampleRate();
            this.data = bArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface WebRtcAudioRecordErrorCallback {
        void onWebRtcAudioRecordError(String str);

        void onWebRtcAudioRecordInitError(String str);

        void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface WebRtcAudioRecordSamplesReadyCallback {
        void onWebRtcAudioRecordSamplesReady(AudioSamples audioSamples);
    }

    static {
        int defaultAudioSource = getDefaultAudioSource();
        DEFAULT_AUDIO_SOURCE = defaultAudioSource;
        audioSource = defaultAudioSource;
    }

    WebRtcAudioRecord(long j3) {
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioRecord = j3;
        this.effects = WebRtcAudioEffects.create();
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
            return 16;
        }
        return 12;
    }

    private boolean enableBuiltInAEC(boolean z16) {
        Logging.d(TAG, "enableBuiltInAEC(" + z16 + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects == null) {
            Logging.e(TAG, "Built-in AEC is not supported on this platform");
            return false;
        }
        return webRtcAudioEffects.setAEC(z16);
    }

    private boolean enableBuiltInNS(boolean z16) {
        Logging.d(TAG, "enableBuiltInNS(" + z16 + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects == null) {
            Logging.e(TAG, "Built-in NS is not supported on this platform");
            return false;
        }
        return webRtcAudioEffects.setNS(z16);
    }

    private static int getDefaultAudioSource() {
        return 7;
    }

    private int initRecording(int i3, int i16) {
        Logging.d(TAG, "initRecording(sampleRate=" + i3 + ", channels=" + i16 + ")");
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -1;
        }
        int i17 = i3 / 100;
        this.byteBuffer = ByteBuffer.allocateDirect(i16 * 2 * i17);
        Logging.d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
        int channelCountToConfiguration = channelCountToConfiguration(i16);
        int minBufferSize = AudioRecord.getMinBufferSize(i3, channelCountToConfiguration, 2);
        if (minBufferSize != -1 && minBufferSize != -2) {
            Logging.d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
            int max = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
            Logging.d(TAG, "bufferSizeInBytes: " + max);
            try {
                AudioRecord audioRecord = new AudioRecord(audioSource, i3, channelCountToConfiguration, 2, max);
                this.audioRecord = audioRecord;
                if (audioRecord.getState() != 1) {
                    reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
                    releaseAudioResources();
                    return -1;
                }
                WebRtcAudioEffects webRtcAudioEffects = this.effects;
                if (webRtcAudioEffects != null) {
                    webRtcAudioEffects.enable(this.audioRecord.getAudioSessionId());
                }
                logMainParameters();
                logMainParametersExtended();
                return i17;
            } catch (IllegalArgumentException e16) {
                reportWebRtcAudioRecordInitError("AudioRecord ctor error: " + e16.getMessage());
                releaseAudioResources();
                return -1;
            }
        }
        reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + minBufferSize);
        return -1;
    }

    private void logMainParameters() {
        Logging.d(TAG, "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
    }

    private void logMainParametersExtended() {
        Logging.d(TAG, "AudioRecord: buffer size in frames: " + this.audioRecord.getBufferSizeInFrames());
    }

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(int i3, long j3);

    private void releaseAudioResources() {
        Logging.d(TAG, "releaseAudioResources");
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            audioRecord.release();
            this.audioRecord = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioRecordError(String str) {
        Logging.e(TAG, "Run-time recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordError(str);
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        Logging.e(TAG, "Init recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
        }
    }

    private void reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        Logging.e(TAG, "Start recording error: " + audioRecordStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
        }
    }

    public static synchronized void setAudioSource(int i3) {
        synchronized (WebRtcAudioRecord.class) {
            Logging.w(TAG, "Audio source is changed from: " + audioSource + " to " + i3);
            audioSource = i3;
        }
    }

    public static void setErrorCallback(WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback) {
        Logging.d(TAG, "Set error callback");
        errorCallback = webRtcAudioRecordErrorCallback;
    }

    public static void setMicrophoneMute(boolean z16) {
        Logging.w(TAG, "setMicrophoneMute(" + z16 + ")");
        microphoneMute = z16;
    }

    public static void setOnAudioSamplesReady(WebRtcAudioRecordSamplesReadyCallback webRtcAudioRecordSamplesReadyCallback) {
        audioSamplesReadyCallback = webRtcAudioRecordSamplesReadyCallback;
    }

    private boolean startRecording() {
        boolean z16;
        boolean z17;
        Logging.d(TAG, "startRecording");
        if (this.audioRecord != null) {
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
            AudioMonitor.startRecording(this.audioRecord);
            if (this.audioRecord.getRecordingState() != 3) {
                reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState());
                return false;
            }
            AudioRecordThread audioRecordThread = new AudioRecordThread("AudioRecordJavaThread");
            this.audioThread = audioRecordThread;
            audioRecordThread.start();
            return true;
        } catch (IllegalStateException e16) {
            reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e16.getMessage());
            return false;
        }
    }

    private boolean stopRecording() {
        boolean z16;
        Logging.d(TAG, "stopRecording");
        if (this.audioThread != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        assertTrue(z16);
        this.audioThread.stopThread();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L)) {
            Logging.e(TAG, "Join of AudioRecordJavaThread timed out");
            WebRtcAudioUtils.logAudioState(TAG);
        }
        this.audioThread = null;
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            webRtcAudioEffects.release();
        }
        releaseAudioResources();
        return true;
    }
}
