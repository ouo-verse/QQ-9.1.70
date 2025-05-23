package com.tencent.biz.videostory.video;

import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.widget.easylyric.h;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes5.dex */
public class VsMediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener {
    private long C;
    private long D;
    private long E;
    private long F;

    /* renamed from: d, reason: collision with root package name */
    private volatile MediaPlayer f97177d;

    /* renamed from: e, reason: collision with root package name */
    private a f97178e;

    /* renamed from: f, reason: collision with root package name */
    private Timer f97179f;

    /* renamed from: h, reason: collision with root package name */
    private VsMusicItemInfo f97180h;

    /* renamed from: m, reason: collision with root package name */
    private int f97182m;

    /* renamed from: i, reason: collision with root package name */
    private int f97181i = -1;
    private float G = 1.0f;

    /* loaded from: classes5.dex */
    public interface a {
        void onError(MediaPlayer mediaPlayer, int i3, int i16);

        void w(MediaPlayer mediaPlayer, VsMusicItemInfo vsMusicItemInfo);
    }

    public VsMediaPlayer() {
        g();
    }

    private void g() {
        this.f97177d = new ReportMediaPlayer();
        this.f97177d.setAudioStreamType(3);
        MediaPlayer mediaPlayer = this.f97177d;
        float f16 = this.G;
        mediaPlayer.setVolume(f16, f16);
        this.f97177d.setOnPreparedListener(this);
        this.f97177d.setOnSeekCompleteListener(this);
        this.f97177d.setOnErrorListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f97180h != null) {
            this.f97177d.seekTo(this.f97180h.musicStart);
            r();
        }
    }

    private void r() {
        t();
        BaseTimer baseTimer = new BaseTimer();
        this.f97179f = baseTimer;
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.biz.videostory.video.VsMediaPlayer.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    VsMediaPlayer.this.f97182m += 1000;
                    if (VsMediaPlayer.this.f97177d != null) {
                        h.b().e(VsMediaPlayer.this.f97177d.getCurrentPosition());
                    }
                    if (VsMediaPlayer.this.f97180h != null && VsMediaPlayer.this.f97181i != -1 && VsMediaPlayer.this.f97182m >= VsMediaPlayer.this.f97181i) {
                        VsMediaPlayer.this.k();
                    }
                } catch (Exception e16) {
                    QLog.e("VsMediaPlayer", 1, "startProgressTimer error! ", e16);
                }
            }
        }, 0L, 1000L);
    }

    private void t() {
        this.f97182m = 0;
        Timer timer = this.f97179f;
        if (timer != null) {
            timer.cancel();
        }
    }

    public VsMusicItemInfo h() {
        return this.f97180h;
    }

    public void i() {
        if (this.f97177d != null) {
            this.f97177d.pause();
        }
    }

    public void j() {
        if (this.f97177d != null) {
            s();
            this.f97177d.release();
            this.f97177d = null;
        }
    }

    public void l(int i3) {
        this.f97181i = i3;
    }

    public void m(long j3) {
        this.F = j3;
    }

    public void n(float f16) {
        this.G = f16;
    }

    public void o(a aVar) {
        this.f97178e = aVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        a aVar = this.f97178e;
        if (aVar != null && i3 != -38) {
            aVar.onError(mediaPlayer, i3, i16);
            return false;
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        VsMusicItemInfo vsMusicItemInfo;
        if (mediaPlayer != null && (vsMusicItemInfo = this.f97180h) != null) {
            mediaPlayer.seekTo(vsMusicItemInfo.musicStart);
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null && this.f97178e != null && !mediaPlayer.isPlaying()) {
            this.E = System.currentTimeMillis() - this.C;
            this.D = System.currentTimeMillis();
            this.f97178e.w(mediaPlayer, this.f97180h);
        }
    }

    public void p() {
        if (this.f97177d != null) {
            if (this.f97177d.isPlaying()) {
                if (this.f97181i == -1) {
                    k();
                }
            } else {
                this.f97177d.start();
                r();
            }
        }
    }

    public void q(VsMusicItemInfo vsMusicItemInfo) {
        if (this.f97180h != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ret_code", 0);
            hashMap.put("time_cost", Long.valueOf(this.E));
            hashMap.put("total_play_time", Long.valueOf(System.currentTimeMillis() - this.D));
            hashMap.put("video_duration", Long.valueOf(this.F));
            hashMap.put("music_source", Integer.valueOf(this.f97180h.f97248f));
            hashMap.put("file_size", Long.valueOf(this.f97180h.fileSize));
            hashMap.put("element_id", this.f97180h.mSongMid);
            VSReporter.q("edit_smart_music_play", VSReporter.h(hashMap));
        }
        if (vsMusicItemInfo == null) {
            return;
        }
        String str = vsMusicItemInfo.mUrl;
        if (str != null && str.trim().length() != 0) {
            Uri parse = Uri.parse(vsMusicItemInfo.mUrl);
            if (parse == null) {
                a aVar = this.f97178e;
                if (aVar != null) {
                    aVar.onError(this.f97177d, -1, -1);
                    return;
                }
                return;
            }
            this.C = System.currentTimeMillis();
            this.f97180h = vsMusicItemInfo;
            j();
            try {
                g();
                this.f97177d.setDataSource(BaseApplication.getContext(), parse);
                this.f97177d.prepareAsync();
                return;
            } catch (IOException e16) {
                e16.printStackTrace();
                return;
            }
        }
        a aVar2 = this.f97178e;
        if (aVar2 != null) {
            aVar2.onError(this.f97177d, -2, -1);
        }
    }

    public void s() {
        if (this.f97177d != null) {
            this.f97177d.stop();
        }
        t();
    }
}
