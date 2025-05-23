package com.tencent.qqlive.module.videoreport.dtreport.audio;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioDataManager;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;

/* loaded from: classes22.dex */
public class AudioPlayerListenerImpl implements IAudioPlayListener {
    private static final String TAG = "audio.AudioPlayerListenerImpl";
    private Object mAudioPlayer;
    private AudioSession mCurrentAudioSession;
    private boolean mIsCanStartAudioTime;

    public AudioPlayerListenerImpl(IAudioPlayer iAudioPlayer) {
        this.mAudioPlayer = iAudioPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void audioBufferingEnd() {
        if (!this.mIsCanStartAudioTime) {
            return;
        }
        setCurrentAudioSessionBufferingEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void audioBufferingStart() {
        if (!this.mIsCanStartAudioTime) {
            return;
        }
        setCurrentAudioSessionBufferingStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void audioPause() {
        if (!this.mIsCanStartAudioTime) {
            return;
        }
        pauseCurrentAudioSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void audioResume() {
        if (!this.mIsCanStartAudioTime) {
            return;
        }
        resumeCurrentAudioSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void audioStart() {
        endCurrentAudioSession();
        boolean canStartAudioTime = canStartAudioTime();
        this.mIsCanStartAudioTime = canStartAudioTime;
        if (!canStartAudioTime) {
            return;
        }
        startAudioSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void audioStop() {
        if (!this.mIsCanStartAudioTime) {
            return;
        }
        endCurrentAudioSession();
    }

    private boolean canStartAudioTime() {
        if (!DTConfigConstants.config.audioReportSupport() || AudioDataManager.getInstance().getAudioInfo(this.mAudioPlayer) == null) {
            return false;
        }
        return true;
    }

    private void endCurrentAudioSession() {
        AudioSession audioSession = this.mCurrentAudioSession;
        if (audioSession != null && !audioSession.isInEndState()) {
            this.mCurrentAudioSession.onAudioEnd();
        }
    }

    private void pauseCurrentAudioSession() {
        AudioSession audioSession = this.mCurrentAudioSession;
        if (audioSession != null) {
            audioSession.onAudioPause();
        }
    }

    private void resumeCurrentAudioSession() {
        AudioSession audioSession = this.mCurrentAudioSession;
        if (audioSession != null) {
            audioSession.onAudioResume();
        }
    }

    private void setCurrentAudioSessionBufferingEnd() {
        AudioSession audioSession = this.mCurrentAudioSession;
        if (audioSession != null) {
            audioSession.onBufferingEnd();
        }
    }

    private void setCurrentAudioSessionBufferingStart() {
        AudioSession audioSession = this.mCurrentAudioSession;
        if (audioSession != null) {
            audioSession.onBufferingStart();
        }
    }

    private void startAudioSession() {
        AudioSession audioSession = this.mCurrentAudioSession;
        if (audioSession == null) {
            this.mCurrentAudioSession = new AudioSession(this.mAudioPlayer);
        } else {
            audioSession.reset();
        }
        this.mCurrentAudioSession.onAudioStart();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayListener
    public void onAudioComplete(@NonNull IAudioPlayer iAudioPlayer) {
        Log.d(TAG, "onAudioComplete(),");
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.AudioPlayerListenerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                AudioPlayerListenerImpl.this.audioStop();
            }
        });
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayListener
    public void onAudioError(@NonNull IAudioPlayer iAudioPlayer, int i3, int i16) {
        Log.d(TAG, "onAudioError(), errorCode " + i3 + ", " + i16);
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.AudioPlayerListenerImpl.7
            @Override // java.lang.Runnable
            public void run() {
                AudioPlayerListenerImpl.this.audioStop();
            }
        });
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayListener
    public void onAudioPause(IAudioPlayer iAudioPlayer) {
        Log.d(TAG, "onAudioPause(),");
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.AudioPlayerListenerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                AudioPlayerListenerImpl.this.audioPause();
            }
        });
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayListener
    public void onAudioStart(final boolean z16, @NonNull IAudioPlayer iAudioPlayer) {
        Log.d(TAG, "onAudioStart(),");
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.AudioPlayerListenerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (z16) {
                    AudioPlayerListenerImpl.this.audioStart();
                } else {
                    AudioPlayerListenerImpl.this.audioResume();
                }
            }
        });
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayListener
    public void onAudioStop(@NonNull IAudioPlayer iAudioPlayer) {
        Log.d(TAG, "onAudioStop(),");
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.AudioPlayerListenerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                AudioPlayerListenerImpl.this.audioStop();
            }
        });
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayListener
    public void onBufferingEnd(@NonNull IAudioPlayer iAudioPlayer) {
        Log.d(TAG, "onBufferingEnd(),");
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.AudioPlayerListenerImpl.6
            @Override // java.lang.Runnable
            public void run() {
                AudioPlayerListenerImpl.this.audioBufferingEnd();
            }
        });
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayListener
    public void onBufferingStart(@NonNull IAudioPlayer iAudioPlayer) {
        Log.d(TAG, "onBufferingStart(),");
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.AudioPlayerListenerImpl.5
            @Override // java.lang.Runnable
            public void run() {
                AudioPlayerListenerImpl.this.audioBufferingStart();
            }
        });
    }
}
