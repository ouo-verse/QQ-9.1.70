package com.tencent.liteav.audio2;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import java.nio.ByteBuffer;

/* compiled from: P */
@JNINamespace("liteav::audio")
/* loaded from: classes7.dex */
class LiteavAudioRecord2 {
    private static final String TAG = "LiteavAudioRecord";
    private AudioRecord mAudioRecord;
    private int mBufferSize = 0;

    private static String audioSourceToString(int i3) {
        switch (i3) {
            case 0:
                return "DEFAULT";
            case 1:
                return "MIC";
            case 2:
                return "VOICE_UPLINK";
            case 3:
                return "VOICE_DOWNLINK";
            case 4:
                return "VOICE_CALL";
            case 5:
                return "CAMCORDER";
            case 6:
                return "VOICE_RECOGNITION";
            case 7:
                return "VOICE_COMMUNICATION";
            case 8:
            default:
                return "INVALID";
            case 9:
                return "UNPROCESSED";
            case 10:
                return "VOICE_PERFORMANCE";
        }
    }

    private static AudioRecord createStartedAudioRecord(int i3, int i16, int i17, int i18) {
        AudioRecord audioRecord;
        try {
            audioRecord = new AudioRecord(i3, i16, i17, 2, i18);
            try {
                if (audioRecord.getState() == 1) {
                    AudioMonitor.startRecording(audioRecord);
                    Log.i(TAG, "create AudioRecord success. sampleRate: %d, channelConfig: %d, bufferSize: %d, audio source: %s", Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), audioSourceToString(i3));
                    return audioRecord;
                }
                throw new RuntimeException("AudioRecord is not initialized.");
            } catch (Throwable unused) {
                Log.w(TAG, "create AudioRecord failed. source: %s, sampleRate: %d, channelConfig: %d, bufferSize: %d", audioSourceToString(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                destroyAudioRecord(audioRecord);
                return null;
            }
        } catch (Throwable unused2) {
            audioRecord = null;
        }
    }

    private static void destroyAudioRecord(AudioRecord audioRecord) {
        if (audioRecord == null) {
            return;
        }
        try {
            if (audioRecord.getRecordingState() == 3) {
                audioRecord.stop();
            }
            audioRecord.release();
        } catch (Throwable th5) {
            Log.e(TAG, "stop AudioRecord failed.", th5);
        }
    }

    public int getSessionId() {
        AudioRecord audioRecord = this.mAudioRecord;
        if (audioRecord == null) {
            return -1;
        }
        return audioRecord.getAudioSessionId();
    }

    public int read(ByteBuffer byteBuffer, int i3) {
        if (this.mAudioRecord == null) {
            return -1;
        }
        byteBuffer.position(0);
        int read = this.mAudioRecord.read(byteBuffer, i3);
        if (read < 0) {
            Log.e(TAG, "read failed, %d", Integer.valueOf(read));
            return -1;
        }
        return read;
    }

    public int startRecording(int i3, int i16, int i17, int i18) {
        int i19;
        int[] iArr = {i3, 1, 5, 0};
        if (i17 == 1) {
            i19 = 16;
        } else {
            i19 = 12;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(i16, i19, 2);
        if (minBufferSize <= 0) {
            Log.e(TAG, "AudioRecord.getMinBufferSize return error: ".concat(String.valueOf(minBufferSize)), new Object[0]);
        }
        int i26 = i17 * i16;
        if (minBufferSize < i26) {
            minBufferSize = i26;
        }
        for (int i27 = 0; i27 < 4 && this.mAudioRecord == null; i27++) {
            int i28 = iArr[i27];
            for (int i29 = 1; i29 <= 2 && this.mAudioRecord == null; i29++) {
                int i36 = minBufferSize * i29;
                this.mBufferSize = i36;
                if (i36 >= i18 * 4 || i29 >= 2) {
                    this.mAudioRecord = createStartedAudioRecord(i28, i16, i19, i36);
                }
            }
        }
        if (this.mAudioRecord == null) {
            return -1;
        }
        Process.setThreadPriority(-19);
        return 0;
    }

    public void stopRecording() {
        destroyAudioRecord(this.mAudioRecord);
        this.mAudioRecord = null;
    }
}
