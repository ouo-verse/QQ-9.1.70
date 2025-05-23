package com.tencent.liteav.audio2;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import android.os.Process;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import java.nio.ByteBuffer;

/* compiled from: P */
@JNINamespace("liteav::audio")
/* loaded from: classes7.dex */
public class SystemLoopbackRecorder2 {
    private static final String TAG = "SystemLoopbackRecorder2";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f118846a = 0;
    private static final Object mLock = new Object();
    private static MediaProjection mMediaProjection;
    private static volatile long mNativeSystemLoopbackRecorder;

    public SystemLoopbackRecorder2(long j3) {
        mNativeSystemLoopbackRecorder = j3;
    }

    private static native void nativeSetMediaProjectionSession(long j3, MediaProjection mediaProjection);

    public static void notifyMediaProjectionState(MediaProjection mediaProjection) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("Received MediaProjection state ");
        if (mediaProjection != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        Log.i(TAG, sb5.toString(), new Object[0]);
        synchronized (mLock) {
            mMediaProjection = mediaProjection;
            setMediaProjectionSession();
        }
    }

    public static void setMediaProjectionSession() {
        if (mMediaProjection == null) {
            Log.i(TAG, "MediaProjection is null.", new Object[0]);
        } else if (mNativeSystemLoopbackRecorder != 0) {
            nativeSetMediaProjectionSession(mNativeSystemLoopbackRecorder, mMediaProjection);
        }
    }

    public MediaProjection getMediaProjection() {
        return mMediaProjection;
    }

    public void releaseNativeSystemLoopbackRecorder() {
        mNativeSystemLoopbackRecorder = 0L;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class Recorder {

        /* renamed from: a, reason: collision with root package name */
        private AudioRecord f118847a;

        /* renamed from: b, reason: collision with root package name */
        private AudioManager f118848b;

        public Recorder() {
            Context applicationContext = ContextUtils.getApplicationContext();
            ContextUtils.getApplicationContext();
            this.f118848b = (AudioManager) applicationContext.getSystemService("audio");
        }

        private static AudioRecord a(MediaProjection mediaProjection, int i3, int i16, int i17) {
            AudioPlaybackCaptureConfiguration build;
            AudioRecord.Builder audioPlaybackCaptureConfig;
            AudioPlaybackCaptureConfiguration.Builder builder = new AudioPlaybackCaptureConfiguration.Builder(mediaProjection);
            builder.addMatchingUsage(1);
            builder.addMatchingUsage(14);
            build = builder.build();
            if (build == null) {
                return null;
            }
            int i18 = i16 == 1 ? 16 : 12;
            AudioFormat build2 = new AudioFormat.Builder().setEncoding(2).setSampleRate(i3).setChannelMask(i18).build();
            int minBufferSize = AudioRecord.getMinBufferSize(i3, i18, 2);
            AudioRecord audioRecord = null;
            for (int i19 = 1; i19 <= 2 && audioRecord == null; i19++) {
                int i26 = minBufferSize * i19;
                if (i26 >= i17 * 4 || i19 >= 2) {
                    try {
                        audioPlaybackCaptureConfig = new AudioRecord.Builder().setAudioFormat(build2).setBufferSizeInBytes(i26).setAudioPlaybackCaptureConfig(build);
                        audioRecord = audioPlaybackCaptureConfig.build();
                    } catch (Throwable th5) {
                        Log.w(SystemLoopbackRecorder2.TAG, "Create record error " + th5.getMessage(), new Object[0]);
                        a(audioRecord);
                    }
                    if (audioRecord.getState() != 1) {
                        Log.e(SystemLoopbackRecorder2.TAG, "Audio record state error", new Object[0]);
                        a(audioRecord);
                        audioRecord = null;
                    } else {
                        AudioMonitor.startRecording(audioRecord);
                        Log.i(SystemLoopbackRecorder2.TAG, "Create audio record success", new Object[0]);
                    }
                }
            }
            return audioRecord;
        }

        public int read(ByteBuffer byteBuffer, int i3) {
            if (this.f118847a == null) {
                return -1;
            }
            byteBuffer.position(0);
            int read = this.f118847a.read(byteBuffer, i3);
            if (read <= 0) {
                Log.e(SystemLoopbackRecorder2.TAG, "Read failed ".concat(String.valueOf(read)), new Object[0]);
                return -1;
            }
            return read;
        }

        public int startRecording(MediaProjection mediaProjection, int i3, int i16, int i17) {
            int i18;
            try {
                AudioManager audioManager = this.f118848b;
                if (audioManager != null) {
                    audioManager.setAllowedCapturePolicy(3);
                }
            } catch (Throwable th5) {
                Log.e(SystemLoopbackRecorder2.TAG, "ForbidCaptureAudioFromCurrentApp error " + th5.getMessage(), new Object[0]);
            }
            AudioManager audioManager2 = this.f118848b;
            if (audioManager2 != null) {
                i18 = audioManager2.getMode();
            } else {
                i18 = 0;
            }
            a(0);
            this.f118847a = a(mediaProjection, i3, i16, i17);
            a(i18);
            if (this.f118847a == null) {
                return -1;
            }
            Process.setThreadPriority(-19);
            return 0;
        }

        public void stopRecording() {
            a(this.f118847a);
            this.f118847a = null;
        }

        private static void a(AudioRecord audioRecord) {
            if (audioRecord == null) {
                return;
            }
            try {
                if (audioRecord.getRecordingState() == 3) {
                    audioRecord.stop();
                }
                audioRecord.release();
            } catch (Throwable th5) {
                Log.e(SystemLoopbackRecorder2.TAG, "Destroy AudioRecord failed." + th5.getMessage(), new Object[0]);
            }
        }

        private void a(int i3) {
            try {
                AudioManager audioManager = this.f118848b;
                if (audioManager != null) {
                    audioManager.setMode(i3);
                }
            } catch (Throwable th5) {
                Log.e(SystemLoopbackRecorder2.TAG, "Set audio mode exception " + th5.getMessage(), new Object[0]);
            }
        }
    }
}
