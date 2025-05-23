package com.tencent.liteav.audio2;

import android.media.AudioTrack;
import android.os.Process;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.nio.ByteBuffer;

/* compiled from: P */
@JNINamespace("liteav::audio")
/* loaded from: classes7.dex */
public class LiteavAudioTrack2 {
    private static final String TAG = "LiteavAudioTrack2";
    private AudioTrack mAudioTrack;
    private byte[] mPlayBuffer;
    private int mBufferSize = 0;
    private int mSystemOSVersion = 0;

    private static AudioTrack createStartedAudioTrack(int i3, int i16, int i17, int i18) {
        ReportAudioTrack reportAudioTrack;
        try {
            reportAudioTrack = new ReportAudioTrack(i18, i3, i16, 2, i17, 1);
            try {
                if (reportAudioTrack.getState() == 1) {
                    reportAudioTrack.play();
                    Log.i(TAG, "create AudioTrack success. sampleRate: %d, channelConfig: %d, bufferSize: %d, streamType: %s", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), streamTypeToString(i18));
                    return reportAudioTrack;
                }
                throw new RuntimeException("AudioTrack is not initialized.");
            } catch (Throwable unused) {
                Log.w(TAG, "create AudioTrack failed. sampleRate: %d, channelConfig: %d, bufferSize: %d, streamType: %s", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), streamTypeToString(i18));
                destroyAudioTrack(reportAudioTrack);
                return null;
            }
        } catch (Throwable unused2) {
            reportAudioTrack = null;
        }
    }

    private static void destroyAudioTrack(AudioTrack audioTrack) {
        if (audioTrack == null) {
            return;
        }
        try {
            if (audioTrack.getPlayState() == 3) {
                audioTrack.stop();
                audioTrack.flush();
            }
            audioTrack.release();
        } catch (Throwable th5) {
            Log.e(TAG, "stop AudioTrack failed.", th5);
        }
    }

    private static String streamTypeToString(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return "STREAM_INVALID";
                            }
                            return "STREAM_NOTIFICATION";
                        }
                        return "STREAM_ALARM";
                    }
                    return "STREAM_MUSIC";
                }
                return "STREAM_RING";
            }
            return "STREAM_SYSTEM";
        }
        return "STREAM_VOICE_CALL";
    }

    public int getBufferSize() {
        return this.mBufferSize;
    }

    public int startPlayout(int i3, int i16, int i17, int i18) {
        int i19;
        int[] iArr = {i3, 0, 3, 1};
        if (i17 == 1) {
            i19 = 4;
        } else {
            i19 = 12;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i16, i19, 2);
        if (minBufferSize <= 0) {
            Log.e(TAG, "AudioTrack.getMinBufferSize return error: ".concat(String.valueOf(minBufferSize)), new Object[0]);
            return -2;
        }
        for (int i26 = 0; i26 < 4 && this.mAudioTrack == null; i26++) {
            int i27 = iArr[i26];
            for (int i28 = 1; i28 <= 2 && this.mAudioTrack == null; i28++) {
                int i29 = minBufferSize * i28;
                this.mBufferSize = i29;
                if (i29 >= i18 * 4 || i28 >= 2) {
                    this.mAudioTrack = createStartedAudioTrack(i16, i19, i29, i27);
                }
            }
        }
        if (this.mAudioTrack == null) {
            return -1;
        }
        this.mSystemOSVersion = LiteavSystemInfo.getSystemOSVersionInt();
        Process.setThreadPriority(-19);
        return 0;
    }

    public void stopPlayout() {
        destroyAudioTrack(this.mAudioTrack);
        this.mAudioTrack = null;
    }

    public int write(ByteBuffer byteBuffer, int i3, int i16, boolean z16) {
        int write;
        if (this.mAudioTrack == null) {
            return -1;
        }
        byteBuffer.position(i3);
        if (this.mSystemOSVersion >= 21) {
            write = this.mAudioTrack.write(byteBuffer, i16, z16 ? 1 : 0);
        } else {
            byte[] bArr = this.mPlayBuffer;
            if (bArr == null || bArr.length < i16) {
                this.mPlayBuffer = new byte[i16];
            }
            byteBuffer.get(this.mPlayBuffer, 0, i16);
            write = this.mAudioTrack.write(this.mPlayBuffer, 0, i16);
        }
        if (write < 0) {
            Log.e(TAG, "write audio data to AudioTrack failed. ".concat(String.valueOf(write)), new Object[0]);
            return -1;
        }
        return write;
    }
}
