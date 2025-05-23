package com.tencent.qqmini.minigame.audiorecorder;

import android.content.res.Resources;
import android.media.AudioRecord;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniGameLameMp3EncodeThread extends BaseThread {
    public static final String AUDIO_SOURCE_AUTO = "auto";
    public static final String AUDIO_SOURCE_CAMCORDER = "camcorder";
    public static final String AUDIO_SOURCE_MIC = "mic";
    public static final String AUDIO_SOURCE_VOICE_COMMUNICATION = "voice_communication";
    public static final String AUDIO_SOURCE_VOICE_RECOGNITION = "voice_recognition";
    public static final String TAG = "MiniGameLameMp3EncodeThread";
    private boolean isPause;
    private boolean isRecording;
    private String mAudioFileFormat;
    private int mAudioSource;
    private int mBufferTime;
    private int mCallbackFrameSize;
    private int mChannelConfig;
    private int mEncodingPcmFormat;
    private int mInChannel;
    private int mOutBitRate;
    private final int mQuality;
    private String mRecordFilePath;
    private Resources mResources;
    private int mSampleRate;
    private MiniGameLameMp3Recorder.RecorderHandler recorderHandler;

    public MiniGameLameMp3EncodeThread(MiniGameLameMp3Recorder.RecorderHandler recorderHandler) {
        super(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_game_record_encode_thread));
        this.mResources = AppLoaderFactory.g().getContext().getResources();
        this.isRecording = false;
        this.isPause = false;
        this.mBufferTime = 5;
        this.mAudioFileFormat = FileReaderHelper.MP3_EXT;
        this.mQuality = 7;
        this.mAudioSource = 1;
        this.mSampleRate = 8000;
        this.mEncodingPcmFormat = 2;
        this.mInChannel = 1;
        this.mChannelConfig = 16;
        this.mOutBitRate = 32;
        this.recorderHandler = recorderHandler;
    }

    private FileOutputStream getFileOutputStream() {
        try {
            return new FileOutputStream(createSDFile(this.mRecordFilePath));
        } catch (Exception e16) {
            QMLog.e(TAG, "getFileOutputStream exception", e16);
            return null;
        }
    }

    private boolean recording(FileOutputStream fileOutputStream, int i3) {
        int i16 = this.mSampleRate * 2 * this.mBufferTime;
        short[] sArr = new short[i16];
        byte[] bArr = new byte[(int) ((i16 * 1.25d) + 7200.0d)];
        byte[] bArr2 = new byte[this.mCallbackFrameSize * 3];
        try {
            this.isRecording = true;
            this.isPause = false;
            this.recorderHandler.sendEmptyMessage(1);
            AudioRecord audioRecord = new AudioRecord(this.mAudioSource, this.mSampleRate, this.mChannelConfig, this.mEncodingPcmFormat, i3 * 2);
            AudioMonitor.startRecording(audioRecord);
            int i17 = 0;
            while (this.isRecording) {
                if (!this.isPause) {
                    int read = audioRecord.read(sArr, 0, i3);
                    if (read < 0) {
                        QMLog.e(TAG, "recording readSize < 0");
                        this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_error));
                        return false;
                    }
                    int jniEncode = MiniGameLameMp3Native.jniEncode(sArr, sArr, read, bArr);
                    if (jniEncode < 0) {
                        QMLog.e(TAG, "recording encodeOutputLength < 0");
                        this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_encode_error));
                        return false;
                    }
                    if (jniEncode != 0) {
                        fileOutputStream.write(bArr, 0, jniEncode);
                        i17 = sendWhenRecording(bArr, jniEncode, bArr2, i17);
                    }
                }
            }
            sendAfterRecording(bArr2, i17);
            int jniFlush = MiniGameLameMp3Native.jniFlush(bArr);
            if (jniFlush < 0) {
                QMLog.e(TAG, "recording flushOutputLength < 0");
                this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_encode_error));
                return false;
            }
            fileOutputStream.write(bArr, 0, jniFlush);
            fileOutputStream.close();
            audioRecord.stop();
            audioRecord.release();
            this.isRecording = false;
            this.isPause = false;
            return true;
        } catch (IOException e16) {
            QMLog.e(TAG, "recording IOException", e16);
            this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_write_file_error));
            return false;
        } catch (IllegalStateException e17) {
            QMLog.e(TAG, "recording IllegalStateException", e17);
            this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_init_error));
            return false;
        }
    }

    private void sendAfterRecording(byte[] bArr, int i3) {
        int i16;
        int i17 = this.mCallbackFrameSize;
        if (i17 > 0) {
            if (i3 > i17) {
                byte[] bArr2 = new byte[i17];
                System.arraycopy(bArr, 0, bArr2, 0, i17);
                this.recorderHandler.sendFrameRecordMessage(bArr2, false);
                i16 = this.mCallbackFrameSize + 0;
            } else {
                i16 = 0;
            }
            byte[] bArr3 = new byte[this.mCallbackFrameSize];
            System.arraycopy(bArr, i16, bArr3, 0, i3 - i16);
            this.recorderHandler.sendFrameRecordMessage(bArr3, true);
        }
    }

    private int sendWhenRecording(byte[] bArr, int i3, byte[] bArr2, int i16) {
        int i17 = this.mCallbackFrameSize;
        if (i17 <= 0) {
            return 0;
        }
        int i18 = i16 + i3;
        if (i18 < i17 * 2) {
            System.arraycopy(bArr, 0, bArr2, i16, i3);
            return i18;
        }
        int i19 = 0;
        int i26 = 0;
        while (true) {
            int i27 = this.mCallbackFrameSize;
            if (i18 < i27 * 2) {
                break;
            }
            byte[] bArr3 = new byte[i27];
            int i28 = i16 - i19;
            if (i28 >= i27) {
                System.arraycopy(bArr2, i19, bArr3, 0, i27);
                i19 += this.mCallbackFrameSize;
            } else if (i28 > 0) {
                System.arraycopy(bArr2, i19, bArr3, 0, i28);
                System.arraycopy(bArr, 0, bArr3, i28, this.mCallbackFrameSize - i28);
                i26 += this.mCallbackFrameSize - i28;
                i19 = i16;
            } else {
                System.arraycopy(bArr, i26, bArr3, 0, i27);
                i26 += this.mCallbackFrameSize;
            }
            i18 -= this.mCallbackFrameSize;
            this.recorderHandler.sendFrameRecordMessage(bArr3, false);
        }
        int i29 = i16 - i19;
        int i36 = i3 - i26;
        if (i29 > 0) {
            byte[] bArr4 = new byte[i29];
            System.arraycopy(bArr2, i19, bArr4, 0, i29);
            System.arraycopy(bArr4, 0, bArr2, 0, i29);
            System.arraycopy(bArr, i26, bArr2, i29, i36);
            return i36 + i29;
        }
        System.arraycopy(bArr, i26, bArr2, 0, i36);
        return i36;
    }

    public File createSDFile(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            if (file.isDirectory()) {
                file.mkdirs();
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public void deleteTmpFile() {
        if (TextUtils.isEmpty(this.mRecordFilePath)) {
            return;
        }
        File file = new File(this.mRecordFilePath);
        if (file.exists()) {
            file.delete();
        }
    }

    public int getAudioSource() {
        return this.mAudioSource;
    }

    public int getCallbackFrameSize() {
        return this.mCallbackFrameSize;
    }

    public int getInChannel() {
        return this.mInChannel;
    }

    public int getMinBufferSize() {
        return AudioRecord.getMinBufferSize(this.mSampleRate, this.mChannelConfig, this.mEncodingPcmFormat);
    }

    public int getOutBitRate() {
        return this.mOutBitRate;
    }

    public String getRecordFileFormat() {
        return this.mAudioFileFormat;
    }

    public String getRecordFilePath() {
        return this.mRecordFilePath;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public boolean isPause() {
        return this.isPause;
    }

    public boolean isRecording() {
        return this.isRecording;
    }

    public void pauseRecord() {
        this.isPause = true;
        this.recorderHandler.sendEmptyMessage(3);
    }

    public void resumeRecord() {
        this.isPause = false;
        this.recorderHandler.sendEmptyMessage(2);
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.isRecording) {
            QMLog.w(TAG, "run thread is already running");
            return;
        }
        if (TextUtils.isEmpty(this.mRecordFilePath)) {
            QMLog.e(TAG, "run record file path is null");
            return;
        }
        Process.setThreadPriority(-19);
        FileOutputStream fileOutputStream = getFileOutputStream();
        if (fileOutputStream == null) {
            QMLog.e(TAG, "startRecording FileOutputStream output is null");
            this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_file_output_stream_error));
            return;
        }
        int minBufferSize = getMinBufferSize();
        if (minBufferSize < 0) {
            QMLog.e(TAG, "startRecording get minBufferSize < 0");
            this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_sample_rate_error));
            return;
        }
        try {
            int i3 = this.mSampleRate;
            MiniGameLameMp3Native.jniInit(i3, this.mInChannel, i3, this.mOutBitRate, 7);
            boolean recording = recording(fileOutputStream, minBufferSize);
            MiniGameLameMp3Native.jniClose();
            if (recording) {
                this.recorderHandler.sendEmptyMessage(4);
            }
            QMLog.d(TAG, "startRecording stop isSuccess: " + recording);
        } catch (Exception e16) {
            QMLog.e(TAG, "startRecording fail", e16);
        }
    }

    public void setAudioSource(String str) {
        int i3 = 1;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if ("auto".equals(lowerCase)) {
                i3 = 0;
            } else if (!AUDIO_SOURCE_MIC.equals(lowerCase)) {
                if (AUDIO_SOURCE_CAMCORDER.equals(lowerCase)) {
                    i3 = 5;
                } else if (AUDIO_SOURCE_VOICE_COMMUNICATION.equals(lowerCase)) {
                    i3 = 7;
                } else if (AUDIO_SOURCE_VOICE_RECOGNITION.equals(lowerCase)) {
                    i3 = 6;
                }
            }
        }
        setAudioSource(i3);
    }

    public void setCallbackFrameSize(int i3) {
        this.mCallbackFrameSize = i3;
    }

    public void setInChannel(int i3) {
        this.mInChannel = i3;
    }

    public void setOutBitRate(int i3) {
        this.mOutBitRate = i3;
    }

    public void setRecordFileFormat(String str) {
        this.mAudioFileFormat = str;
    }

    public void setRecordFilePath(String str) {
        this.mRecordFilePath = str;
    }

    public void setSampleRate(int i3) {
        this.mSampleRate = i3;
    }

    public void startRecord() {
        start();
    }

    public void stopRecord() {
        this.isRecording = false;
    }

    private void setAudioSource(int i3) {
        this.mAudioSource = i3;
    }
}
