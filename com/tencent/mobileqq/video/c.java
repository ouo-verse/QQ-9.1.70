package com.tencent.mobileqq.video;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.video.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c implements b, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private MediaPlayer f312458d;

    /* renamed from: e, reason: collision with root package name */
    private int f312459e;

    /* renamed from: f, reason: collision with root package name */
    private int f312460f;

    /* renamed from: h, reason: collision with root package name */
    private b.a f312461h;

    /* renamed from: i, reason: collision with root package name */
    private b.c f312462i;

    /* renamed from: m, reason: collision with root package name */
    private b.InterfaceC8953b f312463m;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f312459e = 0;
        this.f312460f = 0;
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer construct");
        }
    }

    private void e(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer changePlayState " + i3);
        }
        this.f312459e = i3;
        b.InterfaceC8953b interfaceC8953b = this.f312463m;
        if (interfaceC8953b != null) {
            interfaceC8953b.onPlayStateChanged(i3);
        }
    }

    public static String f(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return "null";
                    }
                    return " error ";
                }
                return " pause ";
            }
            return " playing ";
        }
        return " idle ";
    }

    @Override // com.tencent.mobileqq.video.b
    public void a(b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setCompletionListener ");
        }
        this.f312461h = aVar;
    }

    @Override // com.tencent.mobileqq.video.b
    public void b(b.InterfaceC8953b interfaceC8953b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) interfaceC8953b);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setPlayStateListener ");
        }
        this.f312463m = interfaceC8953b;
    }

    @Override // com.tencent.mobileqq.video.b
    public void c(b.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) cVar);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setPreparedListener ");
        }
        this.f312462i = cVar;
    }

    @Override // com.tencent.mobileqq.video.b
    public boolean d(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer play " + i3);
        }
        this.f312460f = i3;
        try {
            if (QLog.isColorLevel()) {
                QLog.d("LocalVideoMediaPlayer", 2, "#play#, msec=" + i3);
            }
            release();
            ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
            this.f312458d = reportMediaPlayer;
            reportMediaPlayer.setAudioStreamType(3);
            this.f312458d.setOnCompletionListener(this);
            this.f312458d.setOnErrorListener(this);
            this.f312458d.setOnPreparedListener(this);
            this.f312458d.setDataSource(str);
            this.f312458d.prepareAsync();
            return true;
        } catch (Exception e16) {
            QLog.e("LocalVideoMediaPlayer", 2, "#play#, msec=" + i3, e16);
            g();
            return false;
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer reset ");
        }
        MediaPlayer mediaPlayer = this.f312458d;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            e(0);
        }
    }

    @Override // com.tencent.mobileqq.video.b
    public int getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        if (this.f312458d != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getCurrentPosition " + this.f312458d.getCurrentPosition());
            }
            return this.f312458d.getCurrentPosition();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getCurrentPosition -1");
            return -1;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.video.b
    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        if (this.f312458d != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getDuration " + this.f312458d.getDuration());
            }
            return this.f312458d.getDuration();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getDuration -1");
            return -1;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.video.b
    public int getPlayState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getPlayState " + this.f312459e);
        }
        if (this.f312458d != null) {
            return this.f312459e;
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.video.b
    public int getVideoHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        if (this.f312458d != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoHeight " + this.f312458d.getVideoHeight());
            }
            return this.f312458d.getVideoHeight();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoHeight -1");
            return -1;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.video.b
    public int getVideoWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        if (this.f312458d != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoWidth " + this.f312458d.getVideoWidth());
            }
            return this.f312458d.getVideoWidth();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoWidth -1");
            return -1;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.video.b
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer isPlaying ");
        }
        MediaPlayer mediaPlayer = this.f312458d;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) mediaPlayer);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer onCompletion ");
        }
        e(0);
        b.a aVar = this.f312461h;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        QLog.e("LocalVideoMediaPlayer", 2, "mMediaPlayer onError what=" + i3 + ",extra=" + i16);
        e(3);
        g();
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) mediaPlayer);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer onPrepared ");
        }
        b.c cVar = this.f312462i;
        if (cVar != null) {
            cVar.a(this);
        }
        start();
        int i3 = this.f312460f;
        if (i3 > 0) {
            seekTo(i3);
        }
    }

    @Override // com.tencent.mobileqq.video.b
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer pause");
        }
        if (isPlaying()) {
            this.f312458d.pause();
            e(2);
        }
    }

    @Override // com.tencent.mobileqq.video.b
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer release");
        }
        MediaPlayer mediaPlayer = this.f312458d;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f312458d.release();
            this.f312458d = null;
        }
        e(0);
    }

    @Override // com.tencent.mobileqq.video.b
    public boolean resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer resume");
        }
        if (getPlayState() == 2) {
            start();
        }
        if (getPlayState() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.video.b
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer seek to " + i3);
        }
        MediaPlayer mediaPlayer = this.f312458d;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.seekTo(i3);
            } catch (IllegalStateException unused) {
                QLog.e("LocalVideoMediaPlayer", 2, "mMediaPlayer seekTo " + i3 + " IllegalStateException");
            }
        }
    }

    @Override // com.tencent.mobileqq.video.b
    public void setDisplay(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) surfaceHolder);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setDisplay ");
        }
        MediaPlayer mediaPlayer = this.f312458d;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
        }
    }

    @Override // com.tencent.mobileqq.video.b
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer start");
        }
        MediaPlayer mediaPlayer = this.f312458d;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            e(1);
        }
    }
}
