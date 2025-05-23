package com.tencent.ttpic.voicechanger.common.audio;

import android.os.AsyncTask;
import com.tencent.ttpic.baseutils.log.LogUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VoiceChangeTask extends AsyncTask<String, Integer, Integer> {
    private static final String TAG = "VoiceChangeTask";
    private int mEnvironment;
    VoiceChangeTaskListener mListener;
    private String mOutputPath;
    private String mSrcFile;
    private int mVoiceKind;
    private long timeStarted;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface VoiceChangeTaskListener {
        void onVoiceChangeTaskFailed(int i3);

        void onVoiceChangeTaskStart();

        void onVoiceChangeTaskSuccess(long j3);
    }

    public VoiceChangeTask(String str, String str2, int i3, int i16) {
        this.mSrcFile = str;
        this.mOutputPath = str2;
        this.mVoiceKind = i3;
        this.mEnvironment = i16;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        LogUtils.i(TAG, "<<<<<<<<<<\u3010\u4efb\u52a1\u3011\u53d8\u58f0\uff1a" + this.mSrcFile + " -> \u53d6\u6d88");
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        LogUtils.d(TAG, ">>>>>>>>>>\u3010\u4efb\u52a1\u3011\u53d8\u58f0\uff1a" + this.mSrcFile + "(" + this.mVoiceKind + ", " + this.mEnvironment + ") -> \u5f00\u59cb");
        this.timeStarted = System.currentTimeMillis();
        VoiceChangeTaskListener voiceChangeTaskListener = this.mListener;
        if (voiceChangeTaskListener != null) {
            voiceChangeTaskListener.onVoiceChangeTaskStart();
        }
    }

    public void setListener(VoiceChangeTaskListener voiceChangeTaskListener) {
        this.mListener = voiceChangeTaskListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Integer doInBackground(String... strArr) {
        return Integer.valueOf(VoiceChanger.changeVoice4File(this.mSrcFile, this.mOutputPath, AudioRecorderCompat.AUDIO_SAMPLE_RATE_IN_HZ, this.mVoiceKind, this.mEnvironment));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Integer num) {
        long currentTimeMillis = System.currentTimeMillis() - this.timeStarted;
        LogUtils.d(TAG, "<<<<<<<<<<\u3010\u4efb\u52a1\u3011\u53d8\u58f0\uff1a" + this.mOutputPath + "(" + String.valueOf(currentTimeMillis) + ") -> \u5b8c\u6210");
        if (this.mListener != null) {
            if (num.intValue() == 1) {
                this.mListener.onVoiceChangeTaskSuccess(currentTimeMillis);
            } else {
                this.mListener.onVoiceChangeTaskFailed(num.intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        LogUtils.d(TAG, "onProgressUpdate(" + numArr + ")");
    }
}
