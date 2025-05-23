package com.qq.e.comm.plugin.tangramsplash.video;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.qq.e.comm.pi.ITangramPlayer;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.splash.ITangramPlayerListener;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements ITangramPlayer {

    /* renamed from: a, reason: collision with root package name */
    private final TangramGdtVideoView f40391a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Handler f40392b;

    /* renamed from: c, reason: collision with root package name */
    private volatile HandlerThread f40393c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f40394d = com.qq.e.comm.plugin.j.c.f();

    public c(Context context) {
        this.f40391a = new TangramGdtVideoView(context);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f40394d && this.f40393c != null) {
            this.f40393c.quitSafely();
            this.f40393c = null;
            this.f40392b = null;
            GDTLogger.e("TangramGdtVideoViewProxy destroyVideoThread finished");
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void free() {
        Runnable runnable = new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.video.c.8
            @Override // java.lang.Runnable
            public void run() {
                TangramGdtVideoView tangramGdtVideoView = c.this.f40391a;
                if (tangramGdtVideoView == null) {
                    GDTLogger.e("TangramGdtVideoViewProxy free error : getVideoView() == null");
                } else {
                    tangramGdtVideoView.free();
                }
                c.this.c();
            }
        };
        GDTLogger.e("TangramGdtVideoViewProxy free before handleApi");
        a(runnable);
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public int getCurrentPosition() {
        TangramGdtVideoView tangramGdtVideoView = this.f40391a;
        if (tangramGdtVideoView == null) {
            GDTLogger.e("TangramGdtVideoViewProxy getCurrentPosition error : getVideoView() == null");
            return 0;
        }
        return tangramGdtVideoView.getCurrentPosition();
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public int getDuration() {
        TangramGdtVideoView tangramGdtVideoView = this.f40391a;
        if (tangramGdtVideoView == null) {
            GDTLogger.e("TangramGdtVideoViewProxy getDuration error : getVideoView() == null");
            return 0;
        }
        return tangramGdtVideoView.getDuration();
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public boolean isPlaying() {
        TangramGdtVideoView tangramGdtVideoView = this.f40391a;
        if (tangramGdtVideoView == null) {
            GDTLogger.e("TangramGdtVideoViewProxy isPlaying error : getVideoView() == null");
            return false;
        }
        return tangramGdtVideoView.isPlaying();
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void pause() {
        a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.video.c.2
            @Override // java.lang.Runnable
            public void run() {
                TangramGdtVideoView tangramGdtVideoView = c.this.f40391a;
                if (tangramGdtVideoView == null) {
                    GDTLogger.e("TangramGdtVideoViewProxy pause error : getVideoView() == null");
                } else {
                    tangramGdtVideoView.pause();
                }
            }
        });
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void play() {
        a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.video.c.1
            @Override // java.lang.Runnable
            public void run() {
                TangramGdtVideoView tangramGdtVideoView = c.this.f40391a;
                if (tangramGdtVideoView == null) {
                    GDTLogger.e("TangramGdtVideoViewProxy play error : getVideoView() == null");
                } else {
                    tangramGdtVideoView.play();
                }
            }
        });
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setDataSource(final String str) {
        a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.video.c.4
            @Override // java.lang.Runnable
            public void run() {
                TangramGdtVideoView tangramGdtVideoView = c.this.f40391a;
                if (tangramGdtVideoView == null) {
                    GDTLogger.e("TangramGdtVideoViewProxy setDataSource error : getVideoView() == null");
                } else {
                    tangramGdtVideoView.setDataSource(str);
                }
            }
        });
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setVideoPlayerListener(ITangramPlayerListener iTangramPlayerListener) {
        TangramGdtVideoView tangramGdtVideoView = this.f40391a;
        if (tangramGdtVideoView == null) {
            GDTLogger.e("TangramGdtVideoViewProxy setVideoPlayerListener error : getVideoView() == null");
        } else {
            tangramGdtVideoView.setVideoPlayerListener(iTangramPlayerListener);
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setVolume(final float f16) {
        a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.video.c.7
            @Override // java.lang.Runnable
            public void run() {
                TangramGdtVideoView tangramGdtVideoView = c.this.f40391a;
                if (tangramGdtVideoView == null) {
                    GDTLogger.e("TangramGdtVideoViewProxy setVolume error : getVideoView() == null");
                } else {
                    tangramGdtVideoView.setVolume(f16);
                }
            }
        });
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setVolumeOff() {
        a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.video.c.5
            @Override // java.lang.Runnable
            public void run() {
                TangramGdtVideoView tangramGdtVideoView = c.this.f40391a;
                if (tangramGdtVideoView == null) {
                    GDTLogger.e("TangramGdtVideoViewProxy setVolumeOff error : getVideoView() == null");
                } else {
                    tangramGdtVideoView.setVolumeOff();
                }
            }
        });
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setVolumeOn() {
        a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.video.c.6
            @Override // java.lang.Runnable
            public void run() {
                TangramGdtVideoView tangramGdtVideoView = c.this.f40391a;
                if (tangramGdtVideoView == null) {
                    GDTLogger.e("TangramGdtVideoViewProxy setVolumeOn error : getVideoView() == null");
                } else {
                    tangramGdtVideoView.setVolumeOn();
                }
            }
        });
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void stop() {
        a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.video.c.3
            @Override // java.lang.Runnable
            public void run() {
                TangramGdtVideoView tangramGdtVideoView = c.this.f40391a;
                if (tangramGdtVideoView == null) {
                    GDTLogger.e("TangramGdtVideoViewProxy stop error : getVideoView() == null");
                } else {
                    tangramGdtVideoView.stop();
                }
            }
        });
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            GDTLogger.e("TangramGdtVideoViewProxy handleApi error : runnable == null");
            a(2);
            return;
        }
        if (this.f40394d) {
            Handler handler = this.f40392b;
            HandlerThread handlerThread = this.f40393c;
            if (handlerThread != null && handlerThread.isAlive() && handler != null) {
                if (handler.post(runnable)) {
                    return;
                }
                a(3);
                return;
            }
            a(3);
            return;
        }
        runnable.run();
    }

    private void b() {
        if (this.f40394d) {
            try {
                this.f40393c = new BaseHandlerThread("TangramGdtVideoViewThread");
                this.f40393c.start();
                this.f40392b = new Handler(this.f40393c.getLooper());
                GDTLogger.d("TangramGdtVideoViewProxy initVideoHandlerThread finished");
            } catch (Throwable th5) {
                GDTLogger.e("initVideoHandlerThread error :", th5);
                this.f40393c = null;
                this.f40392b = null;
                a(1);
            }
        }
    }

    private void a(int i3) {
        ITangramPlayerListener a16;
        GDTLogger.e("TangramGdtVideoViewProxy onError :" + i3);
        StatTracer.trackEvent(30115, i3, (com.qq.e.comm.plugin.stat.b) null);
        TangramGdtVideoView tangramGdtVideoView = this.f40391a;
        if (tangramGdtVideoView == null || (a16 = tangramGdtVideoView.a()) == null) {
            return;
        }
        a16.onVideoError();
    }

    public TangramGdtVideoView a() {
        return this.f40391a;
    }
}
