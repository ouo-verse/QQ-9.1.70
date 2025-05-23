package com.tencent.qqmini.miniapp.audiorecorder;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LameMp3Recorder {
    public static final int MSG_PLAY_ERROR = -11;
    public static final int MSG_PLAY_FINISH = 106;
    public static final int MSG_PLAY_PAUSE = 102;
    public static final int MSG_PLAY_RESUME = 103;
    public static final int MSG_PLAY_START = 101;
    public static final int MSG_PLAY_STOP = 105;
    public static final int MSG_PLAY_UPDATE = 104;
    public static final int MSG_RECORD_ERROR = -10;
    public static final int MSG_RECORD_FRAME = 6;
    public static final int MSG_RECORD_PAUSE = 2;
    public static final int MSG_RECORD_RESUME = 3;
    public static final int MSG_RECORD_START = 1;
    public static final int MSG_RECORD_STOP = 5;
    public static final int MSG_RECORD_UPDATE = 4;
    public static final String TAG = "com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder";
    private final AudioManager mAudioManger;
    private AudioRecordListener mAudioRecordListener;
    private final LameMp3EncodeThread mEncodeThread;
    private final Handler mMainHandler;
    private long mPauseTime;
    private long mStartPlayTime;
    private long mStartTime;
    private OnErrorListener onErrorListener;
    private AudioPlayerListener onPlayListener;
    private int mCallbackTime = 500;
    private int mMaxRecordTime = 30;
    private int mCallbackFrameSize = 50;
    private List<Integer> mPauseTimeList = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface AudioPlayerListener {
        void onPlayFinish();

        void onPlayPause();

        void onPlayResume();

        void onPlayStart();

        void onPlayStop();

        void onPlayUpdate(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface AudioRecordListener {
        void onRecordFrame(byte[] bArr, boolean z16);

        void onRecordPause();

        void onRecordResume();

        void onRecordStart();

        void onRecordStop(String str, long j3, long j16);

        void onRecordUpdate(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    static class MHandler extends Handler {
        int level = 1;
        private final WeakReference<LameMp3Recorder> recorder;

        public MHandler(LameMp3Recorder lameMp3Recorder) {
            this.recorder = new WeakReference<>(lameMp3Recorder);
        }

        private void onMsgError(Message message, LameMp3Recorder lameMp3Recorder, int i3) {
            String str = (String) message.obj;
            if (!TextUtils.isEmpty(str) && lameMp3Recorder.onErrorListener != null) {
                lameMp3Recorder.onErrorListener.onErrorInfo(str);
            }
            if (hasMessages(i3)) {
                removeMessages(i3);
            }
        }

        private void onMsgPlayFinish(LameMp3Recorder lameMp3Recorder) {
            if (lameMp3Recorder.onPlayListener != null) {
                lameMp3Recorder.onPlayListener.onPlayFinish();
            }
            if (hasMessages(104)) {
                removeMessages(104);
            }
        }

        private void onMsgPlayPause(LameMp3Recorder lameMp3Recorder) {
            if (lameMp3Recorder.onPlayListener != null) {
                lameMp3Recorder.onPlayListener.onPlayPause();
            }
            if (hasMessages(104)) {
                removeMessages(104);
            }
        }

        private void onMsgPlayResume(LameMp3Recorder lameMp3Recorder) {
            if (lameMp3Recorder.onPlayListener != null) {
                lameMp3Recorder.onPlayListener.onPlayResume();
            }
            if (!hasMessages(104)) {
                sendEmptyMessage(104);
            }
        }

        private void onMsgPlayStart(LameMp3Recorder lameMp3Recorder) {
            if (lameMp3Recorder.onPlayListener != null) {
                lameMp3Recorder.onPlayListener.onPlayStart();
            }
            lameMp3Recorder.mStartPlayTime = System.currentTimeMillis();
            sendEmptyMessageDelayed(104, lameMp3Recorder.getMaxRecordTime());
        }

        private void onMsgPlayStop(LameMp3Recorder lameMp3Recorder) {
            if (lameMp3Recorder.onPlayListener != null) {
                lameMp3Recorder.onPlayListener.onPlayStop();
            }
            if (hasMessages(104)) {
                removeMessages(104);
            }
        }

        private void onMsgPlayUpdate(LameMp3Recorder lameMp3Recorder) {
            if (hasMessages(104)) {
                removeMessages(104);
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() - lameMp3Recorder.mStartPlayTime);
            int i3 = this.level + 1;
            this.level = i3;
            if (i3 > 5) {
                this.level = 1;
            }
            if (lameMp3Recorder.onPlayListener != null) {
                lameMp3Recorder.onPlayListener.onPlayUpdate(this.level, currentTimeMillis / 1000);
            }
            sendEmptyMessageDelayed(104, lameMp3Recorder.getMaxRecordTime());
        }

        private void onMsgRecordPause(LameMp3Recorder lameMp3Recorder) {
            if (lameMp3Recorder.mAudioRecordListener != null) {
                lameMp3Recorder.mAudioRecordListener.onRecordPause();
            }
            if (hasMessages(4)) {
                removeMessages(4);
            }
        }

        private void onMsgRecordStart(LameMp3Recorder lameMp3Recorder) {
            if (lameMp3Recorder.mAudioRecordListener != null) {
                lameMp3Recorder.mAudioRecordListener.onRecordStart();
            }
            if (!hasMessages(4)) {
                sendEmptyMessage(4);
            }
        }

        private void onMsgRecordStop(LameMp3Recorder lameMp3Recorder) {
            if (lameMp3Recorder.mAudioRecordListener != null) {
                lameMp3Recorder.mAudioRecordListener.onRecordStop(lameMp3Recorder.getRecordFilPath(), lameMp3Recorder.getRecordDuration(), lameMp3Recorder.getRecordFileSize());
            }
            if (hasMessages(4)) {
                removeMessages(4);
            }
        }

        private void onMsgRecordUpdate(LameMp3Recorder lameMp3Recorder) {
            if (hasMessages(4)) {
                removeMessages(4);
            }
            int time = lameMp3Recorder.getTime();
            int voiceLevel = lameMp3Recorder.getVoiceLevel();
            if (lameMp3Recorder.mAudioRecordListener != null) {
                lameMp3Recorder.mAudioRecordListener.onRecordUpdate(voiceLevel, time);
            }
            if (time == lameMp3Recorder.mMaxRecordTime) {
                lameMp3Recorder.mEncodeThread.restoreRecording();
            } else {
                sendEmptyMessageDelayed(4, lameMp3Recorder.getMaxRecordTime());
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<LameMp3Recorder> weakReference = this.recorder;
            if (weakReference != null && weakReference.get() != null) {
                LameMp3Recorder lameMp3Recorder = this.recorder.get();
                int i3 = message.what;
                if (i3 != -11) {
                    if (i3 != -10) {
                        switch (i3) {
                            case 1:
                                onMsgRecordStart(lameMp3Recorder);
                                return;
                            case 2:
                                onMsgRecordPause(lameMp3Recorder);
                                return;
                            case 3:
                                LameMp3Recorder.onMsgRecordResume(lameMp3Recorder);
                                return;
                            case 4:
                                onMsgRecordUpdate(lameMp3Recorder);
                                return;
                            case 5:
                                onMsgRecordStop(lameMp3Recorder);
                                return;
                            case 6:
                                LameMp3Recorder.onMsgRecordFrame(message, lameMp3Recorder);
                                return;
                            default:
                                switch (i3) {
                                    case 101:
                                        onMsgPlayStart(lameMp3Recorder);
                                        return;
                                    case 102:
                                        onMsgPlayPause(lameMp3Recorder);
                                        return;
                                    case 103:
                                        onMsgPlayResume(lameMp3Recorder);
                                        return;
                                    case 104:
                                        onMsgPlayUpdate(lameMp3Recorder);
                                        return;
                                    case 105:
                                        onMsgPlayStop(lameMp3Recorder);
                                        return;
                                    case 106:
                                        onMsgPlayFinish(lameMp3Recorder);
                                        return;
                                    default:
                                        return;
                                }
                        }
                    }
                    onMsgError(message, lameMp3Recorder, 4);
                    return;
                }
                onMsgError(message, lameMp3Recorder, 104);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnErrorListener {
        void onErrorInfo(String str);
    }

    public LameMp3Recorder(Context context) {
        MHandler mHandler = new MHandler(this);
        this.mMainHandler = mHandler;
        this.mEncodeThread = new LameMp3EncodeThread(this, mHandler);
        this.mAudioManger = (AudioManager) context.getSystemService("audio");
    }

    private void callOnRecordStop() {
        AudioRecordListener audioRecordListener = this.mAudioRecordListener;
        if (audioRecordListener != null) {
            audioRecordListener.onRecordStop(getRecordFilPath(), getRecordDuration(), getRecordFileSize());
        }
        if (this.mMainHandler.hasMessages(4)) {
            this.mMainHandler.removeMessages(4);
        }
    }

    public static Message generatePlayErrMsg(String str) {
        Message message = new Message();
        message.what = -11;
        message.obj = str;
        return message;
    }

    public static Message generateRecordErrMsg(String str) {
        Message message = new Message();
        message.what = -10;
        message.obj = str;
        return message;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onMsgRecordFrame(Message message, LameMp3Recorder lameMp3Recorder) {
        AudioRecordListener audioRecordListener = lameMp3Recorder.mAudioRecordListener;
        if (audioRecordListener != null) {
            byte[] bArr = (byte[]) message.obj;
            boolean z16 = true;
            if (message.arg1 != 1) {
                z16 = false;
            }
            audioRecordListener.onRecordFrame(bArr, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onMsgRecordResume(LameMp3Recorder lameMp3Recorder) {
        AudioRecordListener audioRecordListener = lameMp3Recorder.mAudioRecordListener;
        if (audioRecordListener != null) {
            audioRecordListener.onRecordResume();
        }
        if (!lameMp3Recorder.mMainHandler.hasMessages(4)) {
            lameMp3Recorder.mMainHandler.sendEmptyMessage(4);
        }
    }

    public AudioRecordListener getAudioRecordListener() {
        return this.mAudioRecordListener;
    }

    public int getCallbackFrameSize() {
        return this.mCallbackFrameSize;
    }

    public int getCallbackTime() {
        return this.mCallbackTime;
    }

    public int getMaxRecordTime() {
        return this.mMaxRecordTime;
    }

    public int getPlayTime() {
        return (int) ((System.currentTimeMillis() - this.mStartPlayTime) / 1000);
    }

    public long getRecordDuration() {
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        while (this.mPauseTimeList.iterator().hasNext()) {
            currentTimeMillis -= r2.next().intValue();
        }
        return currentTimeMillis;
    }

    public String getRecordFilPath() {
        return this.mEncodeThread.getRecordFilPath();
    }

    public long getRecordFileSize() {
        return new File(getRecordFilPath()).length();
    }

    public long getRecordTime() {
        return this.mEncodeThread.getRecordTime();
    }

    public int getTime() {
        return (int) (getRecordDuration() / 1000);
    }

    public int getVoiceLevel() {
        return this.mEncodeThread.getVoiceLevel();
    }

    public boolean isPause() {
        if (!this.mEncodeThread.isRecording()) {
            return false;
        }
        return this.mEncodeThread.isPause();
    }

    public boolean isRecording() {
        return this.mEncodeThread.isRecording();
    }

    public void onDestory() {
        LameMp3EncodeThread lameMp3EncodeThread = this.mEncodeThread;
        if (lameMp3EncodeThread != null) {
            lameMp3EncodeThread.onDestory();
        }
    }

    public void playPause() {
        if (this.mEncodeThread.playPause()) {
            this.mMainHandler.sendEmptyMessage(102);
        }
    }

    public void playResume() {
        if (this.mEncodeThread.playResume()) {
            this.mMainHandler.sendEmptyMessage(103);
        }
    }

    public void playStart(String str) {
        if (TextUtils.isEmpty(str)) {
            QMLog.e(TAG, "\u8bf7\u5148\u8bbe\u7f6e\u97f3\u9891\u64ad\u653e\u8def\u5f84");
        } else {
            this.mEncodeThread.setFilePlayPath(str);
            this.mEncodeThread.play();
        }
    }

    public void playStop() {
        if (this.mEncodeThread.stopPlay()) {
            this.mMainHandler.sendEmptyMessage(105);
        }
    }

    public void recordPause() {
        if (this.mEncodeThread.isPause()) {
            return;
        }
        if (getTime() < 1) {
            this.mMainHandler.sendMessage(generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_too_short)));
            recordStop();
        }
        this.mPauseTime = System.currentTimeMillis();
        this.mEncodeThread.setPause(true);
        this.mMainHandler.sendEmptyMessage(2);
    }

    public void recordResume() {
        if (!this.mEncodeThread.isPause()) {
            return;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.mPauseTime);
        if (currentTimeMillis > 0) {
            this.mPauseTimeList.add(Integer.valueOf(currentTimeMillis));
        }
        this.mEncodeThread.setPause(false);
        this.mMainHandler.sendEmptyMessage(3);
    }

    public void recordStart() {
        this.mPauseTimeList.clear();
        this.mEncodeThread.startRecord();
        this.mStartTime = System.currentTimeMillis();
    }

    public void recordStop() {
        if (this.mEncodeThread.isRecording()) {
            this.mEncodeThread.restoreRecording();
        }
    }

    public void setAudioRecordListener(AudioRecordListener audioRecordListener) {
        this.mAudioRecordListener = audioRecordListener;
    }

    public void setAudioSource(String str) {
        this.mEncodeThread.setAudioSource(str);
    }

    public void setCallbackFrameSize(int i3) {
        this.mCallbackFrameSize = i3;
        this.mEncodeThread.setCallbackFrameSize(i3);
    }

    public void setCallbackTime(int i3) {
        this.mCallbackTime = i3;
    }

    public void setEncodingPcmFormat(int i3) {
        this.mEncodeThread.setEncodingPcmFormat(i3);
    }

    public void setInSampleRate(int i3) {
        this.mEncodeThread.setInSampleRate(i3);
    }

    public void setMaxRecordTime(int i3) {
        this.mMaxRecordTime = i3;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public void setOnPlayListener(AudioPlayerListener audioPlayerListener) {
        this.onPlayListener = audioPlayerListener;
    }

    public void setOutBitRate(int i3) {
        this.mEncodeThread.setOutBitRate(i3);
    }

    public void setOutChannel(int i3) {
        this.mEncodeThread.setOutChannel(i3);
    }

    public void setOutSampleRate(int i3) {
        this.mEncodeThread.setOutSampleRate(i3);
    }

    public void setPlayMode(boolean z16) {
        if (!z16) {
            this.mAudioManger.setSpeakerphoneOn(false);
            this.mAudioManger.setMode(3);
            this.mEncodeThread.getMediaPlayer().setAudioStreamType(0);
        } else {
            this.mAudioManger.setMode(0);
            this.mAudioManger.setSpeakerphoneOn(true);
            this.mEncodeThread.getMediaPlayer().setAudioStreamType(3);
        }
    }

    public void setQuality(int i3) {
        this.mEncodeThread.setQuality(i3);
    }

    public void setRecordFilPath(String str) {
        this.mEncodeThread.setRecordFilPath(str);
    }

    public void setRecordFileFormat(String str) {
        this.mEncodeThread.setRecordFileFormat(str);
    }

    public void setRecordTime(long j3) {
        this.mEncodeThread.setRecordTime(j3);
    }

    public void setSampleRate(int i3) {
        setInSampleRate(i3);
    }
}
