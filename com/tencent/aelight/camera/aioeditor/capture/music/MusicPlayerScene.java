package com.tencent.aelight.camera.aioeditor.capture.music;

import com.tencent.biz.videostory.widget.easylyric.h;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes32.dex */
public class MusicPlayerScene implements AudioPlayerBase.b {

    /* renamed from: e, reason: collision with root package name */
    protected MusicItemInfo f66752e;

    /* renamed from: h, reason: collision with root package name */
    protected List<e> f66754h;

    /* renamed from: f, reason: collision with root package name */
    protected int f66753f = -1;

    /* renamed from: i, reason: collision with root package name */
    private long f66755i = 0;

    /* renamed from: d, reason: collision with root package name */
    protected AudioPlayer f66751d = new AudioPlayer(BaseApplicationImpl.getApplication(), this);

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void V3(AudioPlayerBase audioPlayerBase, int i3, String str) {
        h.b().e(i3);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void W8(AudioPlayerBase audioPlayerBase, String str) {
        a(this.f66752e);
        l();
        if (QLog.isColorLevel()) {
            QLog.d("MusicPlayerScene", 2, "MusicPlayerScene onCompletion");
        }
    }

    protected void a(MusicItemInfo musicItemInfo) {
        List<e> list = this.f66754h;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().c(this.f66752e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i3, MusicItemInfo musicItemInfo) {
        List<e> list = this.f66754h;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().e(i3, this.f66752e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i3, MusicItemInfo musicItemInfo) {
        List<e> list = this.f66754h;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().b(i3, this.f66752e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i3, MusicItemInfo musicItemInfo) {
        List<e> list = this.f66754h;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().f(i3, this.f66752e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i3, MusicItemInfo musicItemInfo) {
        List<e> list = this.f66754h;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().d(i3, this.f66752e);
            }
        }
    }

    protected void f() {
        List<e> list = this.f66754h;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public synchronized void g() {
        this.f66753f = -1;
        this.f66752e = null;
        AudioPlayer audioPlayer = this.f66751d;
        if (audioPlayer != null) {
            audioPlayer.stop();
        }
        this.f66751d = null;
        this.f66754h = null;
        if (QLog.isColorLevel()) {
            QLog.d("MusicPlayerScene", 2, "MusicPlayerScene destroy");
        }
    }

    public int h() {
        if (j()) {
            return this.f66751d.m();
        }
        return -1;
    }

    public synchronized void i(MusicItemInfo musicItemInfo) {
        this.f66752e = musicItemInfo;
        this.f66753f = musicItemInfo.musicStart;
    }

    public boolean j() {
        try {
            AudioPlayer audioPlayer = this.f66751d;
            if (audioPlayer != null) {
                return audioPlayer.r();
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public synchronized void k() {
        int i3;
        StringBuilder sb5 = new StringBuilder("pauseMusic");
        if (this.f66751d.r()) {
            i3 = this.f66751d.m();
            this.f66753f = i3;
        } else {
            i3 = -1;
        }
        this.f66751d.stop();
        b(i3, this.f66752e);
        sb5.append(" musicName=");
        sb5.append("");
        sb5.append(" position=");
        sb5.append(i3);
        if (QLog.isColorLevel()) {
            QLog.d("MusicPlayerScene", 2, sb5.toString());
        }
    }

    public synchronized void l() {
        MusicItemInfo musicItemInfo;
        int i3 = -1;
        this.f66753f = -1;
        StringBuilder sb5 = new StringBuilder("startMusic");
        String str = "";
        AudioPlayer audioPlayer = this.f66751d;
        if (audioPlayer != null && (musicItemInfo = this.f66752e) != null) {
            str = musicItemInfo.mMusicName;
            audioPlayer.B(3);
            if (this.f66752e.musicStart < 0) {
                sb5.append(" musicStart=");
                sb5.append(this.f66752e.musicStart);
                this.f66752e.musicStart = 0;
            }
            if (j()) {
                this.f66751d.stop();
            }
            MusicItemInfo musicItemInfo2 = this.f66752e;
            int i16 = musicItemInfo2.musicStart;
            c(i16, musicItemInfo2);
            n(this.f66752e.getLocalPath(), this.f66752e.musicStart);
            i3 = i16;
        }
        sb5.append(" musicName=");
        sb5.append(str);
        sb5.append(" position=");
        sb5.append(i3);
        if (QLog.isColorLevel()) {
            QLog.d("MusicPlayerScene", 2, sb5.toString());
        }
    }

    public synchronized void m() {
        AudioPlayer audioPlayer;
        String str = "";
        StringBuilder sb5 = new StringBuilder("resumeMusic");
        int i3 = -1;
        if (this.f66752e != null && (audioPlayer = this.f66751d) != null && !audioPlayer.r() && this.f66753f != -1) {
            MusicItemInfo musicItemInfo = this.f66752e;
            String str2 = musicItemInfo.mMusicName;
            n(musicItemInfo.getLocalPath(), this.f66753f);
            i3 = this.f66753f;
            str = str2;
        }
        d(i3, this.f66752e);
        sb5.append(" musicName=");
        sb5.append(str);
        sb5.append(" position=");
        sb5.append(i3);
        if (QLog.isColorLevel()) {
            QLog.d("MusicPlayerScene", 2, sb5.toString());
        }
    }

    protected void n(final String str, final int i3) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerScene.1
            @Override // java.lang.Runnable
            public void run() {
                MusicPlayerScene.this.f66751d.C(13);
                MusicPlayerScene.this.f66751d.A(str, i3);
            }
        }, null, true);
        this.f66755i = 0L;
    }

    public void o(List<e> list) {
        this.f66754h = list;
    }

    public synchronized void p() {
        MusicItemInfo musicItemInfo;
        int i3 = -1;
        this.f66753f = -1;
        StringBuilder sb5 = new StringBuilder("startMusic");
        String str = "";
        AudioPlayer audioPlayer = this.f66751d;
        if (audioPlayer != null && (musicItemInfo = this.f66752e) != null) {
            str = musicItemInfo.mMusicName;
            audioPlayer.B(3);
            if (this.f66752e.musicStart < 0) {
                sb5.append(" musicStart=");
                sb5.append(this.f66752e.musicStart);
                this.f66752e.musicStart = 0;
            }
            MusicItemInfo musicItemInfo2 = this.f66752e;
            int i16 = musicItemInfo2.musicStart;
            e(i16, musicItemInfo2);
            n(this.f66752e.getLocalPath(), this.f66752e.musicStart + ((int) this.f66755i));
            i3 = i16;
        }
        sb5.append(" musicName=");
        sb5.append(str);
        sb5.append(" position=");
        sb5.append(i3);
        if (QLog.isColorLevel()) {
            QLog.d("MusicPlayerScene", 2, sb5.toString());
        }
    }

    public synchronized void q() {
        this.f66753f = -1;
        String str = "";
        AudioPlayer audioPlayer = this.f66751d;
        if (audioPlayer != null) {
            audioPlayer.stop();
        }
        MusicItemInfo musicItemInfo = this.f66752e;
        if (musicItemInfo != null) {
            str = musicItemInfo.mMusicName;
            this.f66752e = null;
        }
        f();
        if (QLog.isColorLevel()) {
            QLog.d("MusicPlayerScene", 2, "MusicPlayerScene stopMusic musicName=" + str);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void f9(AudioPlayerBase audioPlayerBase, String str) {
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void Tg(AudioPlayerBase audioPlayerBase, int i3, String str) {
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void j5(AudioPlayerBase audioPlayerBase, int i3, String str) {
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void k9(AudioPlayerBase audioPlayerBase, int i3, String str) {
    }
}
