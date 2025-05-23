package com.tencent.qqmini.miniapp.audiorecorder;

import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3EncodeThread;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.task.MiniAppSoLoader;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LameMp3EncodeThread extends BaseThread {
    public static final String TAG = "com.tencent.qqmini.miniapp.audiorecorder.LameMp3EncodeThread";
    private boolean isPause;
    private boolean isRecording;
    private String mAudioFileFormat;
    private int mAudioSource;
    private int mCallbackFrameSize;
    private int mEncodingPcmFormat;
    private int mInSampleRate;
    private Handler mMainHandler;
    private MediaPlayer mMediaPlayer;
    private boolean mNativeLoaded;
    private int mOutBitRate;
    private int mOutChannel;
    private int mOutSampleRate;
    private String mPlayFilePath;
    private int mQuality;
    private String mRecordFilPath;
    private long mRecordTime;
    private int mVoiceLevel;
    private LameMp3Recorder mp3Player;

    public LameMp3EncodeThread(LameMp3Recorder lameMp3Recorder, Handler handler) {
        super(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_thread));
        this.mAudioSource = 1;
        this.mEncodingPcmFormat = 2;
        this.mAudioFileFormat = FileReaderHelper.MP3_EXT;
        this.mInSampleRate = 8000;
        this.mOutSampleRate = 8000;
        this.mOutChannel = 1;
        this.mOutBitRate = 32;
        this.mQuality = 7;
        this.isRecording = false;
        this.isPause = false;
        this.mRecordTime = 60000L;
        this.mNativeLoaded = false;
        this.mp3Player = lameMp3Recorder;
        this.mMainHandler = handler;
        start();
        loadLameMp3So();
    }

    public static File createSDFile(String str) throws IOException {
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

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int encodeAndSave(int i3, short[] sArr, byte[] bArr, byte[] bArr2, byte[] bArr3, int i16, FileOutputStream fileOutputStream, AudioRecord audioRecord, boolean z16) {
        boolean z17;
        byte[] bArr4 = bArr2;
        int i17 = i16;
        boolean z18 = z16;
        while (true) {
            z17 = true;
            if (!this.isRecording) {
                break;
            }
            if (this.isPause) {
                if (!z18) {
                    z18 = true;
                }
            } else {
                if (z18) {
                    z18 = false;
                }
                int read = audioRecord.read(sArr, 0, i3);
                this.mVoiceLevel = getVoiceSize(read, sArr);
                if (read < 0) {
                    Handler handler = this.mMainHandler;
                    if (handler != null) {
                        handler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_error)));
                    }
                } else if (read != 0) {
                    int jniEncode = LameMp3Native.jniEncode(sArr, sArr, read, bArr);
                    if (jniEncode < 0) {
                        Handler handler2 = this.mMainHandler;
                        if (handler2 != null) {
                            handler2.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_encode_error)));
                        }
                    } else if (jniEncode != 0) {
                        try {
                            fileOutputStream.write(bArr, 0, jniEncode);
                            if (this.mCallbackFrameSize <= 0) {
                                continue;
                            } else {
                                if (bArr4 != null) {
                                    onFrameRecord(bArr4, false);
                                    bArr4 = null;
                                }
                                int i18 = jniEncode + i17;
                                int i19 = 0;
                                int i26 = i17;
                                i17 = i18;
                                while (true) {
                                    try {
                                        int i27 = this.mCallbackFrameSize;
                                        if (i17 < i27) {
                                            break;
                                        }
                                        bArr4 = new byte[i27];
                                        if (i26 > 0) {
                                            System.arraycopy(bArr3, 0, bArr4, 0, i26);
                                            int i28 = this.mCallbackFrameSize - i26;
                                            System.arraycopy(bArr, 0, bArr4, i26, i28);
                                            i19 += i28;
                                            i26 = 0;
                                        } else {
                                            System.arraycopy(bArr, i19, bArr4, 0, i27);
                                            i19 += this.mCallbackFrameSize;
                                        }
                                        int i29 = this.mCallbackFrameSize;
                                        i17 -= i29;
                                        if (i17 >= i29) {
                                            onFrameRecord(bArr4, false);
                                            bArr4 = null;
                                        }
                                    } catch (Throwable unused) {
                                        i17 = i26;
                                        Handler handler3 = this.mMainHandler;
                                        if (handler3 != null) {
                                            handler3.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_write_file_error)));
                                        }
                                        if (bArr4 != null) {
                                        }
                                        return i17;
                                    }
                                }
                                if (i17 > 0) {
                                    System.arraycopy(bArr, i19, bArr3, i26, i17 - i26);
                                } else {
                                    i17 = 0;
                                }
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        if (bArr4 != null) {
            if (i17 != 0) {
                z17 = false;
            }
            onFrameRecord(bArr4, z17);
        }
        return i17;
    }

    private FileOutputStream getFileOutputStream() {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(createSDFile(this.mRecordFilPath));
        } catch (FileNotFoundException unused) {
            Handler handler = this.mMainHandler;
            if (handler != null) {
                handler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_mk_file_error)));
            }
            return null;
        } catch (IOException unused2) {
            Handler handler2 = this.mMainHandler;
            if (handler2 != null) {
                handler2.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_wr_file_error)));
            }
            fileOutputStream = null;
        }
        if (fileOutputStream == null) {
            QMLog.e(TAG, "output is null!");
            Handler handler3 = this.mMainHandler;
            if (handler3 != null) {
                handler3.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_input_null)));
            }
            return null;
        }
        return fileOutputStream;
    }

    private void loadLameMp3So() {
        this.mNativeLoaded = MiniAppSoLoader.g().isLameMp3SoLoaded();
        QMLog.e("[miniapp]-LameMp3Native", "mNativeLoaded : " + this.mNativeLoaded);
        if (!this.mNativeLoaded) {
            try {
                this.mNativeLoaded = MiniAppSoLoader.g().loadLameMp3So();
            } catch (Throwable th5) {
                QMLog.e("[miniapp]-LameMp3Native", "load so exception, fail to load network libmini_lamemp3.so:" + this.mNativeLoaded, th5);
            }
        }
        if (!this.mNativeLoaded) {
            try {
                System.loadLibrary(MiniAppSoLoader.LIBNAME_LAME_MP3_SO);
                this.mNativeLoaded = true;
                QMLog.i("[miniapp]-LameMp3Native", "load so exception, load local libmini_lamemp3.so success!");
            } catch (Throwable th6) {
                this.mNativeLoaded = false;
                QMLog.i("[miniapp]-LameMp3Native", "load so exception, fail to load local libmini_lamemp3.so:" + this.mNativeLoaded, th6);
            }
        }
    }

    private void onFrameRecord(byte[] bArr, boolean z16) {
        if (this.mMainHandler != null && bArr != null) {
            Message obtain = Message.obtain();
            obtain.obj = bArr;
            obtain.what = 6;
            obtain.arg1 = z16 ? 1 : 0;
            this.mMainHandler.sendMessage(obtain);
        }
    }

    private void startRecording(int i3, short[] sArr, byte[] bArr, byte[] bArr2, byte[] bArr3, int i16, FileOutputStream fileOutputStream, AudioRecord audioRecord) {
        Handler handler;
        try {
            try {
                AudioMonitor.startRecording(audioRecord);
                try {
                    Handler handler2 = this.mMainHandler;
                    if (handler2 != null) {
                        handler2.sendEmptyMessage(1);
                    }
                    int encodeAndSave = encodeAndSave(i3, sArr, bArr, bArr2, bArr3, i16, fileOutputStream, audioRecord, false);
                    if (encodeAndSave > 0) {
                        byte[] bArr4 = new byte[encodeAndSave];
                        System.arraycopy(bArr3, 0, bArr4, 0, encodeAndSave);
                        onFrameRecord(bArr4, true);
                    }
                    int jniFlush = LameMp3Native.jniFlush(bArr);
                    if (jniFlush < 0 && (handler = this.mMainHandler) != null) {
                        handler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_encode_error)));
                    }
                    if (jniFlush != 0) {
                        try {
                            fileOutputStream.write(bArr, 0, jniFlush);
                        } catch (Throwable unused) {
                            if (this.mMainHandler != null) {
                                this.mMainHandler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_write_file_error)));
                            }
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused2) {
                        if (this.mMainHandler != null) {
                            this.mMainHandler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_close_error)));
                        }
                    }
                    LameMp3Native.jniClose();
                    this.isRecording = false;
                    if (this.mMainHandler != null) {
                        if (this.mp3Player.getRecordDuration() > 1) {
                            this.mMainHandler.sendEmptyMessage(5);
                            return;
                        }
                        File file = new File(this.mRecordFilPath);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                } finally {
                    audioRecord.stop();
                    audioRecord.release();
                }
            } catch (IllegalStateException unused3) {
                if (this.mMainHandler != null) {
                    this.mMainHandler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_init_error)));
                }
                LameMp3Native.jniClose();
                this.isRecording = false;
            }
        } catch (Throwable th5) {
            LameMp3Native.jniClose();
            this.isRecording = false;
            throw th5;
        }
    }

    public int getAudioSource() {
        return this.mAudioSource;
    }

    public int getEncodingPcmFormat() {
        return this.mEncodingPcmFormat;
    }

    public int getInSampleRate() {
        return this.mInSampleRate;
    }

    public MediaPlayer getMediaPlayer() {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = new ReportMediaPlayer();
        }
        return this.mMediaPlayer;
    }

    public int getOutBitRate() {
        return this.mOutBitRate;
    }

    public int getOutChannel() {
        return this.mOutChannel;
    }

    public int getOutSampleRate() {
        return this.mOutSampleRate;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public String getRecordFilPath() {
        return this.mRecordFilPath;
    }

    public long getRecordTime() {
        return this.mRecordTime;
    }

    public int getVoiceLevel() {
        return this.mVoiceLevel;
    }

    public int getVoiceSize(int i3, short[] sArr) {
        if (this.isRecording) {
            long j3 = 0;
            for (short s16 : sArr) {
                try {
                    j3 += s16 * s16;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            return (((int) (Math.log10(j3 / i3) * 10.0d)) / 10) - 1;
        }
        return 1;
    }

    public boolean isPause() {
        return this.isPause;
    }

    public boolean isRecording() {
        return this.isRecording;
    }

    public void onDestory() {
        stopPlay();
        restoreRecording();
    }

    public boolean play() {
        return play(this.mPlayFilePath);
    }

    public boolean playPause() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            return true;
        }
        return false;
    }

    public boolean playResume() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            return true;
        }
        return false;
    }

    public void restoreRecording() {
        this.isRecording = false;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] bArr;
        if (this.isRecording) {
            QMLog.w(TAG, "record thread is allready running!");
            return;
        }
        if (TextUtils.isEmpty(this.mRecordFilPath)) {
            QMLog.e(TAG, "run(), record file is null");
            return;
        }
        if (!this.mNativeLoaded) {
            Handler handler = this.mMainHandler;
            if (handler != null) {
                handler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_so_unload)));
                return;
            }
            return;
        }
        Process.setThreadPriority(-19);
        int minBufferSize = AudioRecord.getMinBufferSize(this.mInSampleRate, 16, 2);
        if (minBufferSize < 0) {
            Handler handler2 = this.mMainHandler;
            if (handler2 != null) {
                handler2.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_samplerate_error)));
                return;
            }
            return;
        }
        int i3 = this.mCallbackFrameSize;
        if (i3 > 0) {
            bArr = new byte[i3];
        } else {
            bArr = null;
        }
        byte[] bArr2 = bArr;
        FileOutputStream fileOutputStream = getFileOutputStream();
        if (fileOutputStream == null) {
            return;
        }
        int i16 = this.mInSampleRate;
        LameMp3Native.jniInit(i16, this.mOutChannel, i16, this.mOutBitRate, this.mQuality);
        this.isRecording = true;
        this.isPause = false;
        AudioRecord audioRecord = new AudioRecord(this.mAudioSource, this.mInSampleRate, 16, this.mEncodingPcmFormat, minBufferSize * 2);
        int i17 = this.mInSampleRate * 2 * 1 * 5;
        startRecording(minBufferSize, new short[i17], new byte[(int) ((i17 * 1.25d) + 7200.0d)], null, bArr2, 0, fileOutputStream, audioRecord);
    }

    public void setAudioSource(String str) {
        int i3 = 1;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if ("auto".equals(lowerCase)) {
                i3 = 0;
            } else if (!MiniGameLameMp3EncodeThread.AUDIO_SOURCE_MIC.equals(lowerCase)) {
                if (MiniGameLameMp3EncodeThread.AUDIO_SOURCE_CAMCORDER.equals(lowerCase)) {
                    i3 = 5;
                } else if (MiniGameLameMp3EncodeThread.AUDIO_SOURCE_VOICE_COMMUNICATION.equals(lowerCase)) {
                    i3 = 7;
                } else if (MiniGameLameMp3EncodeThread.AUDIO_SOURCE_VOICE_RECOGNITION.equals(lowerCase)) {
                    i3 = 6;
                }
            }
        }
        setAudioSource(i3);
    }

    public void setCallbackFrameSize(int i3) {
        this.mCallbackFrameSize = i3;
    }

    public void setEncodingPcmFormat(int i3) {
        this.mEncodingPcmFormat = i3;
    }

    public void setFilePath(String str) {
        this.mRecordFilPath = str;
    }

    public void setFilePlayPath(String str) {
        this.mPlayFilePath = str;
    }

    public void setInSampleRate(int i3) {
        this.mInSampleRate = i3;
    }

    public void setOutBitRate(int i3) {
        this.mOutBitRate = i3;
    }

    public void setOutChannel(int i3) {
        this.mOutChannel = i3;
    }

    public void setOutSampleRate(int i3) {
        this.mOutSampleRate = i3;
    }

    public void setPause(boolean z16) {
        this.isPause = z16;
    }

    public void setQuality(int i3) {
        this.mQuality = i3;
    }

    public void setRecordFilPath(String str) {
        this.mRecordFilPath = str;
    }

    public void setRecordFileFormat(String str) {
        this.mAudioFileFormat = str;
    }

    public void setRecordTime(long j3) {
        this.mRecordTime = j3;
    }

    public void startRecord() {
        ThreadManager.getSubThreadHandler().post(this);
    }

    public boolean stopPlay() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            return true;
        }
        return false;
    }

    public boolean play(String str) {
        if (this.isRecording) {
            QMLog.e(TAG, "\u8bf7\u5148\u5173\u95ed\u5f55\u97f3");
            return false;
        }
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = new ReportMediaPlayer();
        }
        try {
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setDataSource(str);
            this.mMediaPlayer.prepareAsync();
            this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.qqmini.miniapp.audiorecorder.LameMp3EncodeThread.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    LameMp3EncodeThread.this.mMainHandler.sendEmptyMessage(101);
                    LameMp3EncodeThread.this.mMediaPlayer.start();
                }
            });
            this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.qqmini.miniapp.audiorecorder.LameMp3EncodeThread.2
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    QMLog.i(LameMp3EncodeThread.TAG, "onCompletion");
                    LameMp3EncodeThread.this.mMainHandler.sendEmptyMessage(106);
                }
            });
        } catch (Exception e16) {
            e16.printStackTrace();
            this.mMainHandler.sendMessage(LameMp3Recorder.generatePlayErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_play_error)));
            stopPlay();
        }
        return false;
    }

    public void setAudioSource(int i3) {
        this.mAudioSource = i3;
    }

    public void getPlayTime() {
    }
}
