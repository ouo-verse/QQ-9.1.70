package com.tencent.aelight.camera.aioeditor.capture.music;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.util.WeakReferenceHandler;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes32.dex */
public class QQMusicPlayerScene extends MusicPlayerScene implements Handler.Callback {

    /* renamed from: m, reason: collision with root package name */
    private Timer f66777m = null;
    private TimerTask C = null;
    private boolean D = true;
    WeakReferenceHandler E = new WeakReferenceHandler(Looper.getMainLooper(), this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public class MyMusicTimerTask extends TimerTask {
        MyMusicTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            QQMusicPlayerScene.this.E.sendEmptyMessage(1);
            if (QLog.isColorLevel()) {
                QLog.d("QQMusicPlayerScene", 2, "MyMusicTimerTask MSG_MUSIC_REPLAY");
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerScene
    public synchronized void g() {
        this.D = false;
        r();
        this.f66752e = null;
        super.g();
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlayerScene", 2, "QQMusicPlayerScene destroy");
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlayerScene", 2, "handleMessage MSG_MUSIC_REPLAY isNeedPlay=" + this.D);
        }
        if (this.D) {
            l();
            return false;
        }
        q();
        return false;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerScene
    public synchronized void k() {
        int i3;
        String str = "";
        this.D = false;
        StringBuilder sb5 = new StringBuilder("pauseMusic");
        if (this.f66751d.r()) {
            i3 = this.f66751d.m();
            this.f66753f = i3;
        } else {
            i3 = -1;
        }
        MusicItemInfo musicItemInfo = this.f66752e;
        if (musicItemInfo != null) {
            str = musicItemInfo.mMusicName;
        }
        this.f66751d.stop();
        r();
        b(i3, this.f66752e);
        sb5.append(" musicName=");
        sb5.append(str);
        sb5.append(" position=");
        sb5.append(i3);
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlayerScene", 2, sb5.toString());
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerScene
    public synchronized void l() {
        String str;
        int i3;
        MusicItemInfo musicItemInfo;
        int i16 = -1;
        this.f66753f = -1;
        this.D = true;
        StringBuilder sb5 = new StringBuilder("replayMusic");
        AudioPlayer audioPlayer = this.f66751d;
        if (audioPlayer == null || (musicItemInfo = this.f66752e) == null) {
            str = "";
            i3 = -1;
        } else {
            String str2 = musicItemInfo.mMusicName;
            audioPlayer.B(3);
            MusicItemInfo musicItemInfo2 = this.f66752e;
            if (musicItemInfo2.musicDuration < musicItemInfo2.musicEnd) {
                sb5.append(" music format no correct musicName=");
                sb5.append(str2);
                sb5.append(" musicDuration=");
                sb5.append(this.f66752e.musicDuration);
                sb5.append(" musicEnd=");
                sb5.append(this.f66752e.musicEnd);
                MusicItemInfo musicItemInfo3 = this.f66752e;
                musicItemInfo3.musicStart = 0;
                musicItemInfo3.musicEnd = musicItemInfo3.musicDuration;
            }
            MusicItemInfo musicItemInfo4 = this.f66752e;
            int i17 = musicItemInfo4.musicEnd;
            int i18 = musicItemInfo4.musicStart;
            if (i17 <= i18) {
                e(-1, musicItemInfo4);
                if (QLog.isColorLevel()) {
                    QLog.d("QQMusicPlayerScene", 2, "replayMusic music info musicEnd <= musicStart don't play music");
                }
                return;
            }
            int i19 = i17 - i18;
            if (j()) {
                this.f66751d.stop();
            }
            c(i18, this.f66752e);
            s(this.f66752e.getLocalPath(), this.f66752e.musicStart, i19);
            str = str2;
            i3 = i19;
            i16 = i18;
        }
        sb5.append(" musicName=");
        sb5.append(str);
        sb5.append(" position=");
        sb5.append(i16);
        sb5.append(" timer=");
        sb5.append(i3);
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlayerScene", 2, sb5.toString());
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerScene
    public synchronized void m() {
        int i3;
        AudioPlayer audioPlayer;
        int i16;
        String str = "";
        StringBuilder sb5 = new StringBuilder("resumeMusic");
        this.D = true;
        int i17 = -1;
        if (this.f66752e == null || (audioPlayer = this.f66751d) == null || audioPlayer.r() || (i16 = this.f66753f) == -1) {
            i3 = -1;
        } else {
            MusicItemInfo musicItemInfo = this.f66752e;
            String str2 = musicItemInfo.mMusicName;
            if (i16 >= musicItemInfo.musicEnd) {
                sb5.append(" mCurrentPosition>=musicEnd reset musicName");
                sb5.append(str2);
                sb5.append(" mCurrentPosition=");
                sb5.append(this.f66753f);
                sb5.append(" musicEnd");
                sb5.append(this.f66752e.musicEnd);
                this.f66753f = this.f66752e.musicStart;
            }
            MusicItemInfo musicItemInfo2 = this.f66752e;
            i3 = musicItemInfo2.musicEnd - this.f66753f;
            if (i3 <= 0) {
                e(-1, musicItemInfo2);
                sb5.append("resumeMusic music info musicEnd <= musicStart don't play music");
                if (QLog.isColorLevel()) {
                    QLog.d("QQMusicPlayerScene", 2, sb5.toString());
                }
                return;
            }
            s(musicItemInfo2.getLocalPath(), this.f66753f, i3);
            i17 = this.f66753f;
            str = str2;
        }
        d(i17, this.f66752e);
        sb5.append(" musicName=");
        sb5.append(str);
        sb5.append(" position=");
        sb5.append(i17);
        sb5.append(" timer=");
        sb5.append(i3);
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlayerScene", 2, sb5.toString());
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerScene
    public synchronized void p() {
        int i3;
        String str = "";
        this.D = true;
        int i16 = -1;
        this.f66753f = -1;
        StringBuilder sb5 = new StringBuilder("startMusic");
        AudioPlayer audioPlayer = this.f66751d;
        if (audioPlayer == null || this.f66752e == null) {
            i3 = -1;
        } else {
            audioPlayer.B(3);
            MusicItemInfo musicItemInfo = this.f66752e;
            String str2 = musicItemInfo.mMusicName;
            if (musicItemInfo.musicDuration < musicItemInfo.musicEnd) {
                sb5.append(" music format no correct musicName=");
                sb5.append(str2);
                sb5.append(" musicDuration=");
                sb5.append(this.f66752e.musicDuration);
                sb5.append(" musicEnd=");
                sb5.append(this.f66752e.musicEnd);
                MusicItemInfo musicItemInfo2 = this.f66752e;
                musicItemInfo2.musicStart = 0;
                musicItemInfo2.musicEnd = musicItemInfo2.musicDuration;
            }
            MusicItemInfo musicItemInfo3 = this.f66752e;
            int i17 = musicItemInfo3.musicEnd;
            int i18 = musicItemInfo3.musicStart;
            if (i17 <= i18) {
                sb5.append(" musicEnd <= musicStart don't play music musicName=");
                sb5.append(str2);
                sb5.append(" musicEnd=");
                sb5.append(this.f66752e.musicEnd);
                sb5.append(" musicStart=");
                sb5.append(this.f66752e.musicStart);
                sb5.append("\n");
                if (QLog.isColorLevel()) {
                    QLog.d("QQMusicPlayerScene", 2, sb5.toString());
                }
                e(-1, this.f66752e);
                return;
            }
            e(i18, musicItemInfo3);
            MusicItemInfo musicItemInfo4 = this.f66752e;
            int i19 = musicItemInfo4.musicEnd - musicItemInfo4.musicStart;
            s(musicItemInfo4.getLocalPath(), this.f66752e.musicStart, i19);
            str = str2;
            i3 = i19;
            i16 = i18;
        }
        sb5.append(" musicName=");
        sb5.append(str);
        sb5.append(" position=");
        sb5.append(i16);
        sb5.append(" timer=");
        sb5.append(i3);
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlayerScene", 2, sb5.toString());
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerScene
    public synchronized void q() {
        this.D = false;
        String str = "";
        r();
        MusicItemInfo musicItemInfo = this.f66752e;
        if (musicItemInfo != null) {
            str = musicItemInfo.mMusicName;
            this.f66752e = null;
        }
        super.q();
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlayerScene", 2, "QQMusicPlayerScene stopMusic musicName=" + str);
        }
    }

    public void r() {
        Timer timer = this.f66777m;
        if (timer != null) {
            timer.cancel();
            this.f66777m = null;
        }
        TimerTask timerTask = this.C;
        if (timerTask != null) {
            timerTask.cancel();
            this.C = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlayerScene", 2, "cancelMyMusicTimer");
        }
    }

    protected void s(final String str, final int i3, final int i16) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.music.QQMusicPlayerScene.1
            @Override // java.lang.Runnable
            public void run() {
                QQMusicPlayerScene.this.f66751d.C(15);
                QQMusicPlayerScene.this.f66751d.A(str, i3);
                QQMusicPlayerScene.this.t(i16);
            }
        }, null, true);
    }

    public void t(int i3) {
        r();
        this.f66777m = new BaseTimer();
        MyMusicTimerTask myMusicTimerTask = new MyMusicTimerTask();
        this.C = myMusicTimerTask;
        this.f66777m.schedule(myMusicTimerTask, i3);
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlayerScene", 2, "setMyMusicTimer");
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerScene, com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void W8(AudioPlayerBase audioPlayerBase, String str) {
    }
}
