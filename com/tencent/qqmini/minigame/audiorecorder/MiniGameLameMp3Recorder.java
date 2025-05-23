package com.tencent.qqmini.minigame.audiorecorder;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniGameLameMp3Recorder {
    public static final String TAG = "MiniGameLameMp3Recorder";
    private AudioRecordListener mAudioRecordListener;
    private MiniGameLameMp3EncodeThread mEncodeThread;
    private long mPauseTime;
    private long mRecordTime;
    private long mStartTime;
    private long minRecordTime = 1000;
    private long maxRecordTime = 600000;
    private List<Integer> mPauseTimeList = new ArrayList();
    private final RecorderHandler recorderHandler = new RecorderHandler(this);

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface AudioRecordListener {
        void onRecordError(String str);

        void onRecordFrame(byte[] bArr, boolean z16);

        void onRecordPause();

        void onRecordResume();

        void onRecordStart();

        void onRecordStop(String str, long j3, long j16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class RecorderHandler extends Handler {
        public static final int MSG_RECORD_ERROR = -1;
        public static final int MSG_RECORD_FRAME = 6;
        public static final int MSG_RECORD_PAUSE = 3;
        public static final int MSG_RECORD_RESUME = 2;
        public static final int MSG_RECORD_START = 1;
        public static final int MSG_RECORD_STOP = 4;
        public static final int MSG_RECORD_UPDATE = 7;
        private static final long UPDATE_INTERVAL = 100;
        private final WeakReference<MiniGameLameMp3Recorder> recorder;

        public RecorderHandler(MiniGameLameMp3Recorder miniGameLameMp3Recorder) {
            super(Looper.getMainLooper());
            this.recorder = new WeakReference<>(miniGameLameMp3Recorder);
        }

        private void onMsgRecordError(MiniGameLameMp3Recorder miniGameLameMp3Recorder, Message message) {
            String str = (String) message.obj;
            if (!TextUtils.isEmpty(str) && miniGameLameMp3Recorder.mAudioRecordListener != null) {
                miniGameLameMp3Recorder.mAudioRecordListener.onRecordError(str);
            }
            miniGameLameMp3Recorder.mEncodeThread.deleteTmpFile();
            miniGameLameMp3Recorder.mEncodeThread = null;
            if (hasMessages(7)) {
                removeMessages(7);
            }
        }

        private void onMsgRecordFrame(MiniGameLameMp3Recorder miniGameLameMp3Recorder, Message message) {
            if (miniGameLameMp3Recorder.mAudioRecordListener != null) {
                byte[] bArr = (byte[]) message.obj;
                boolean z16 = true;
                if (message.arg1 != 1) {
                    z16 = false;
                }
                miniGameLameMp3Recorder.mAudioRecordListener.onRecordFrame(bArr, z16);
            }
        }

        private void onMsgRecordPause(MiniGameLameMp3Recorder miniGameLameMp3Recorder) {
            if (miniGameLameMp3Recorder.getRecordDuration() < miniGameLameMp3Recorder.getMinRecordTime()) {
                miniGameLameMp3Recorder.mEncodeThread.stopRecord();
            } else if (miniGameLameMp3Recorder.mAudioRecordListener != null) {
                miniGameLameMp3Recorder.mAudioRecordListener.onRecordPause();
            }
            if (hasMessages(7)) {
                removeMessages(7);
            }
        }

        private void onMsgRecordResume(MiniGameLameMp3Recorder miniGameLameMp3Recorder) {
            if (miniGameLameMp3Recorder.mAudioRecordListener != null) {
                miniGameLameMp3Recorder.mAudioRecordListener.onRecordResume();
            }
            if (!hasMessages(7)) {
                sendEmptyMessage(7);
            }
        }

        private void onMsgRecordStart(MiniGameLameMp3Recorder miniGameLameMp3Recorder) {
            if (miniGameLameMp3Recorder.mAudioRecordListener != null) {
                miniGameLameMp3Recorder.mAudioRecordListener.onRecordStart();
            }
            if (!hasMessages(7)) {
                sendEmptyMessage(7);
            }
        }

        private void onMsgRecordStop(MiniGameLameMp3Recorder miniGameLameMp3Recorder) {
            if (miniGameLameMp3Recorder.getRecordDuration() < miniGameLameMp3Recorder.getMinRecordTime()) {
                sendErrorMessage(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_game_record_too_short));
            } else {
                if (miniGameLameMp3Recorder.mAudioRecordListener != null) {
                    miniGameLameMp3Recorder.mAudioRecordListener.onRecordStop(miniGameLameMp3Recorder.getRecordFilePath(), miniGameLameMp3Recorder.getRecordDuration(), miniGameLameMp3Recorder.getRecordFileSize());
                }
                miniGameLameMp3Recorder.mEncodeThread = null;
            }
            if (hasMessages(7)) {
                removeMessages(7);
            }
        }

        private void onMsgRecordUpdate(MiniGameLameMp3Recorder miniGameLameMp3Recorder) {
            if (hasMessages(7)) {
                removeMessages(7);
            }
            long recordDuration = miniGameLameMp3Recorder.getRecordDuration();
            if (recordDuration < miniGameLameMp3Recorder.getRecordTime() && recordDuration < miniGameLameMp3Recorder.getMaxRecordTime()) {
                sendEmptyMessageDelayed(7, 100L);
            } else {
                miniGameLameMp3Recorder.mEncodeThread.stopRecord();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MiniGameLameMp3Recorder miniGameLameMp3Recorder = this.recorder.get();
            if (miniGameLameMp3Recorder != null) {
                int i3 = message.what;
                if (i3 != -1) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    if (i3 != 6) {
                                        if (i3 == 7) {
                                            onMsgRecordUpdate(miniGameLameMp3Recorder);
                                            return;
                                        }
                                        return;
                                    }
                                    onMsgRecordFrame(miniGameLameMp3Recorder, message);
                                    return;
                                }
                                onMsgRecordStop(miniGameLameMp3Recorder);
                                return;
                            }
                            onMsgRecordPause(miniGameLameMp3Recorder);
                            return;
                        }
                        onMsgRecordResume(miniGameLameMp3Recorder);
                        return;
                    }
                    onMsgRecordStart(miniGameLameMp3Recorder);
                    return;
                }
                onMsgRecordError(miniGameLameMp3Recorder, message);
            }
        }

        public void sendErrorMessage(String str) {
            Message obtain = Message.obtain();
            obtain.what = -1;
            obtain.obj = str;
            sendMessage(obtain);
        }

        public void sendFrameRecordMessage(byte[] bArr, boolean z16) {
            if (bArr != null) {
                Message obtain = Message.obtain();
                obtain.obj = bArr;
                obtain.what = 6;
                obtain.arg1 = z16 ? 1 : 0;
                sendMessage(obtain);
            }
        }
    }

    public int getAudioSource() {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            return miniGameLameMp3EncodeThread.getAudioSource();
        }
        return 0;
    }

    public int getCallbackFrameSize() {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            return miniGameLameMp3EncodeThread.getCallbackFrameSize();
        }
        return 0;
    }

    public int getInChannel() {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            return miniGameLameMp3EncodeThread.getInChannel();
        }
        return 0;
    }

    public long getMaxRecordTime() {
        return this.maxRecordTime;
    }

    public long getMinRecordTime() {
        return this.minRecordTime;
    }

    public int getOutBitRate() {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            return miniGameLameMp3EncodeThread.getOutBitRate();
        }
        return 0;
    }

    public long getRecordDuration() {
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        while (this.mPauseTimeList.iterator().hasNext()) {
            currentTimeMillis -= r2.next().intValue();
        }
        return currentTimeMillis;
    }

    public String getRecordFileFormat() {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            return miniGameLameMp3EncodeThread.getRecordFileFormat();
        }
        return "";
    }

    public String getRecordFilePath() {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            return miniGameLameMp3EncodeThread.getRecordFilePath();
        }
        return "";
    }

    public long getRecordFileSize() {
        String recordFilePath = getRecordFilePath();
        if (TextUtils.isEmpty(recordFilePath)) {
            return 0L;
        }
        File file = new File(recordFilePath);
        if (!file.exists()) {
            return 0L;
        }
        return file.length();
    }

    public long getRecordTime() {
        return this.mRecordTime;
    }

    public int getSampleRate() {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            return miniGameLameMp3EncodeThread.getSampleRate();
        }
        return 0;
    }

    public void initThread() {
        this.mEncodeThread = new MiniGameLameMp3EncodeThread(this.recorderHandler);
    }

    public boolean isPause() {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null && miniGameLameMp3EncodeThread.isPause()) {
            return true;
        }
        return false;
    }

    public boolean isRecordIdle() {
        if (this.mEncodeThread == null) {
            return true;
        }
        return false;
    }

    public boolean isRecording() {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null && miniGameLameMp3EncodeThread.isRecording()) {
            return true;
        }
        return false;
    }

    public void recordPause() {
        if (isRecording() && !isPause()) {
            this.mPauseTime = System.currentTimeMillis();
            this.mEncodeThread.pauseRecord();
        }
    }

    public void recordResume() {
        if (isRecording() && isPause()) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.mPauseTime);
            if (currentTimeMillis > 0) {
                this.mPauseTimeList.add(Integer.valueOf(currentTimeMillis));
            }
            this.mEncodeThread.resumeRecord();
        }
    }

    public void recordStart() {
        this.mPauseTimeList.clear();
        this.mStartTime = System.currentTimeMillis();
        this.mEncodeThread.startRecord();
    }

    public void recordStop() {
        if (isRecording()) {
            this.mEncodeThread.stopRecord();
        }
    }

    public void setAudioRecordListener(AudioRecordListener audioRecordListener) {
        this.mAudioRecordListener = audioRecordListener;
    }

    public void setAudioSource(String str) {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            miniGameLameMp3EncodeThread.setAudioSource(str);
        }
    }

    public void setCallbackFrameSize(int i3) {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            miniGameLameMp3EncodeThread.setCallbackFrameSize(i3);
        }
    }

    public void setInChannel(int i3) {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            miniGameLameMp3EncodeThread.setInChannel(i3);
        }
    }

    public void setMaxRecordTime(long j3) {
        this.maxRecordTime = j3;
    }

    public void setMinRecordTime(long j3) {
        this.minRecordTime = j3;
    }

    public void setOutBitRate(int i3) {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            miniGameLameMp3EncodeThread.setOutBitRate(i3);
        }
    }

    public void setRecordFileFormat(String str) {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            miniGameLameMp3EncodeThread.setRecordFileFormat(str);
        }
    }

    public void setRecordFilePath(String str) {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            miniGameLameMp3EncodeThread.setRecordFilePath(str);
        }
    }

    public void setRecordTime(long j3) {
        this.mRecordTime = j3;
    }

    public void setSampleRate(int i3) {
        MiniGameLameMp3EncodeThread miniGameLameMp3EncodeThread = this.mEncodeThread;
        if (miniGameLameMp3EncodeThread != null) {
            miniGameLameMp3EncodeThread.setSampleRate(i3);
        }
    }
}
