package org.tencwebrtc.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Environment;
import android.os.Process;
import android.support.annotation.Nullable;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.tencwebrtc.CalledByNative;
import org.tencwebrtc.Logging;
import org.tencwebrtc.ThreadUtils;
import org.tencwebrtc.audio.JavaAudioDeviceModule;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class WebRtcAudioRecord {
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    public static final int DEFAULT_AUDIO_FORMAT = 2;
    public static final int DEFAULT_AUDIO_SOURCE = 7;
    private static final String TAG = "WebRtcAudioRecordExternal";
    private final int audioFormat;
    private final AudioManager audioManager;

    @Nullable
    private AudioRecord audioRecord;

    @Nullable
    private final JavaAudioDeviceModule.SamplesReadyCallback audioSamplesReadyCallback;
    private final int audioSource;

    @Nullable
    private AudioRecordThread audioThread;

    @Nullable
    private ByteBuffer byteBuffer;
    private final Context context;
    private final WebRtcAudioEffects effects;
    private byte[] emptyBytes;

    @Nullable
    private final JavaAudioDeviceModule.AudioRecordErrorCallback errorCallback;

    @Nullable
    private File inputAudioFile;

    @Nullable
    private FileInputStream inputAudioFileStream;
    private final boolean isAcousticEchoCancelerSupported;
    private final boolean isNoiseSuppressorSupported;
    private volatile boolean microphoneMute;
    private long nativeAudioRecord;
    private boolean startReadFile;

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
                try {
                    int read = WebRtcAudioRecord.this.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
                    Logging.d(WebRtcAudioRecord.TAG, "AudioRecordThread" + WebRtcAudioRecord.this.byteBuffer);
                    byte[] bArr = new byte[WebRtcAudioRecord.this.byteBuffer.capacity()];
                    if (WebRtcAudioRecord.this.startReadFile) {
                        try {
                            if (WebRtcAudioRecord.this.inputAudioFileStream != null && (read = WebRtcAudioRecord.this.inputAudioFileStream.read(bArr)) > 0) {
                                WebRtcAudioRecord.this.byteBuffer.clear();
                                WebRtcAudioRecord.this.byteBuffer.put(bArr);
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                    if (read == WebRtcAudioRecord.this.byteBuffer.capacity()) {
                        if (WebRtcAudioRecord.this.microphoneMute) {
                            WebRtcAudioRecord.this.byteBuffer.clear();
                            WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                        }
                        if (this.keepAlive) {
                            WebRtcAudioRecord webRtcAudioRecord = WebRtcAudioRecord.this;
                            webRtcAudioRecord.nativeDataIsRecorded(webRtcAudioRecord.nativeAudioRecord, read);
                        }
                        if (WebRtcAudioRecord.this.audioSamplesReadyCallback != null) {
                            WebRtcAudioRecord.this.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new JavaAudioDeviceModule.AudioSamples(WebRtcAudioRecord.this.audioRecord.getAudioFormat(), WebRtcAudioRecord.this.audioRecord.getChannelCount(), WebRtcAudioRecord.this.audioRecord.getSampleRate(), Arrays.copyOfRange(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.arrayOffset(), WebRtcAudioRecord.this.byteBuffer.capacity() + WebRtcAudioRecord.this.byteBuffer.arrayOffset())));
                        }
                    } else {
                        String str = "AudioRecord.read failed: " + read;
                        Logging.e(WebRtcAudioRecord.TAG, str);
                        if (read == -3) {
                            this.keepAlive = false;
                            WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str);
                        }
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
            try {
                if (WebRtcAudioRecord.this.audioRecord != null) {
                    WebRtcAudioRecord.this.audioRecord.stop();
                }
            } catch (IllegalStateException e18) {
                Logging.e(WebRtcAudioRecord.TAG, "AudioRecord.stop failed: " + e18.getMessage());
            }
        }

        public void stopThread() {
            Logging.d(WebRtcAudioRecord.TAG, "stopThread");
            this.keepAlive = false;
            if (WebRtcAudioRecord.this.startReadFile) {
                try {
                    if (WebRtcAudioRecord.this.inputAudioFileStream != null) {
                        WebRtcAudioRecord.this.inputAudioFileStream.close();
                        WebRtcAudioRecord.this.inputAudioFileStream = null;
                    }
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    @CalledByNative
    WebRtcAudioRecord(Context context, AudioManager audioManager) {
        this(context, audioManager, 7, 2, null, null, WebRtcAudioEffects.isAcousticEchoCancelerSupported(), WebRtcAudioEffects.isNoiseSuppressorSupported());
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

    @CalledByNative
    private boolean enableBuiltInAEC(boolean z16) {
        Logging.d(TAG, "enableBuiltInAEC(" + z16 + ")");
        return this.effects.setAEC(z16);
    }

    @CalledByNative
    private boolean enableBuiltInNS(boolean z16) {
        Logging.d(TAG, "enableBuiltInNS(" + z16 + ")");
        return this.effects.setNS(z16);
    }

    private static int getBytesPerSample(int i3) {
        int i16 = 1;
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                i16 = 4;
                if (i3 != 4) {
                    if (i3 != 13) {
                        throw new IllegalArgumentException("Bad audio format " + i3);
                    }
                }
            }
            return i16;
        }
        return 2;
    }

    @CalledByNative
    private int initRecording(int i3, int i16) throws FileNotFoundException {
        String str;
        Logging.d(TAG, "initRecording(sampleRate=" + i3 + ", channels=" + i16 + ")");
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -1;
        }
        int i17 = i3 / 100;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(getBytesPerSample(this.audioFormat) * i16 * i17);
        this.byteBuffer = allocateDirect;
        if (!allocateDirect.hasArray()) {
            reportWebRtcAudioRecordInitError("ByteBuffer does not have backing array.");
            return -1;
        }
        Logging.d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.nativeAudioRecord, this.byteBuffer);
        int channelCountToConfiguration = channelCountToConfiguration(i16);
        int minBufferSize = AudioRecord.getMinBufferSize(i3, channelCountToConfiguration, this.audioFormat);
        if (minBufferSize != -1 && minBufferSize != -2) {
            Logging.d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
            int max = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
            Logging.d(TAG, "bufferSizeInBytes: " + max);
            try {
                this.audioRecord = new AudioRecord(this.audioSource, i3, channelCountToConfiguration, this.audioFormat, max);
                if (this.startReadFile) {
                    if (this.context != null) {
                        str = this.context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator + "testaudio.pcm";
                    } else {
                        str = Environment.getDataDirectory().getAbsolutePath() + File.separator + "testaudio.pcm";
                    }
                    File file = new File(str);
                    this.inputAudioFile = file;
                    if (file.exists()) {
                        this.inputAudioFileStream = new FileInputStream(this.inputAudioFile);
                    }
                }
                AudioRecord audioRecord = this.audioRecord;
                if (audioRecord != null && audioRecord.getState() == 1) {
                    this.effects.enable(this.audioRecord.getAudioSessionId());
                    logMainParameters();
                    logMainParametersExtended();
                    return i17;
                }
                releaseAudioResources();
                return -1;
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

    private native void nativeCacheDirectBufferAddress(long j3, ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(long j3, int i3);

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
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordError(str);
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        Logging.e(TAG, "Init recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
        }
    }

    private void reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        Logging.e(TAG, "Start recording error: " + audioRecordStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
        }
    }

    @CalledByNative
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
                reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState());
                return false;
            }
            AudioRecordThread audioRecordThread = new AudioRecordThread("AudioRecordJavaThread");
            this.audioThread = audioRecordThread;
            audioRecordThread.start();
            return true;
        } catch (IllegalStateException e16) {
            reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e16.getMessage());
            return false;
        }
    }

    @CalledByNative
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
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        }
        this.audioThread = null;
        this.effects.release();
        releaseAudioResources();
        return true;
    }

    @CalledByNative
    boolean isAcousticEchoCancelerSupported() {
        return this.isAcousticEchoCancelerSupported;
    }

    @CalledByNative
    boolean isNoiseSuppressorSupported() {
        return this.isNoiseSuppressorSupported;
    }

    public void setMicrophoneMute(boolean z16) {
        Logging.w(TAG, "setMicrophoneMute(" + z16 + ")");
        this.microphoneMute = z16;
    }

    @CalledByNative
    public void setNativeAudioRecord(long j3) {
        this.nativeAudioRecord = j3;
    }

    public void setStartReadFile(boolean z16) {
        this.startReadFile = z16;
    }

    public WebRtcAudioRecord(Context context, AudioManager audioManager, int i3, int i16, @Nullable JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback, @Nullable JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback, boolean z16, boolean z17) {
        this.effects = new WebRtcAudioEffects();
        if (z16 && !WebRtcAudioEffects.isAcousticEchoCancelerSupported()) {
            throw new IllegalArgumentException("HW AEC not supported");
        }
        if (z17 && !WebRtcAudioEffects.isNoiseSuppressorSupported()) {
            throw new IllegalArgumentException("HW NS not supported");
        }
        this.context = context;
        this.audioManager = audioManager;
        this.audioSource = i3;
        this.audioFormat = i16;
        this.errorCallback = audioRecordErrorCallback;
        this.audioSamplesReadyCallback = samplesReadyCallback;
        this.isAcousticEchoCancelerSupported = z16;
        this.isNoiseSuppressorSupported = z17;
    }
}
