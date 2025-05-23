package com.tencent.mobileqq.qqaudio.audioplayer;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.WeakReferenceHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes16.dex */
public final class AmrPlayer implements Handler.Callback, i, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    static IPatchRedirector $redirector_;
    protected AtomicBoolean C;
    Runnable D;

    /* renamed from: d, reason: collision with root package name */
    protected MediaPlayer f262102d;

    /* renamed from: e, reason: collision with root package name */
    protected int f262103e;

    /* renamed from: f, reason: collision with root package name */
    protected String f262104f;

    /* renamed from: h, reason: collision with root package name */
    protected j f262105h;

    /* renamed from: i, reason: collision with root package name */
    protected AmrPlayerThread f262106i;

    /* renamed from: m, reason: collision with root package name */
    protected WeakReferenceHandler f262107m;

    /* loaded from: classes16.dex */
    protected class AmrPlayerThread extends BaseThread {
        static IPatchRedirector $redirector_;

        protected AmrPlayerThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AmrPlayer.this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                AmrPlayer.this.g();
            }
        }
    }

    public AmrPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f262103e = -1;
        this.C = new AtomicBoolean(false);
        this.D = new Runnable() { // from class: com.tencent.mobileqq.qqaudio.audioplayer.AmrPlayer.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AmrPlayer.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    AmrPlayer.this.g();
                }
            }
        };
        this.f262102d = new ReportMediaPlayer();
        this.f262107m = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void a(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void b(int i3, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Byte.valueOf(b16));
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f262104f;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void d(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) jVar);
        } else {
            this.f262105h = jVar;
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr setStreamType");
        }
        this.f262102d.setAudioStreamType(i3);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.f262103e;
    }

    protected void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread " + this.f262104f);
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread onPlayThreadStart");
            }
            this.f262105h.f();
            if (QLog.isColorLevel()) {
                QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread start");
            }
            this.f262102d.start();
            int i3 = this.f262103e;
            if (i3 > 0) {
                this.f262102d.seekTo(i3);
            }
        } catch (Exception e16) {
            if (this.f262105h != null) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = e16.toString();
                this.f262107m.sendMessage(obtain);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public int getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        if (!this.C.get()) {
            return 0;
        }
        return this.f262102d.getCurrentPosition();
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        if (!this.C.get()) {
            return 0;
        }
        return this.f262102d.getDuration();
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr reStart");
        }
        this.f262102d.setOnCompletionListener(this);
        this.f262102d.setOnPreparedListener(this);
        this.f262102d.setOnErrorListener(this);
        Runnable runnable = this.D;
        if (runnable != null) {
            ThreadManagerV2.post(runnable, 5, null, false);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        j jVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1) {
            j jVar2 = this.f262105h;
            if (jVar2 != null) {
                jVar2.a(this, 8, 0, (String) message.obj, this.f262104f);
                i(0);
            }
        } else if (i3 == 2 && (jVar = this.f262105h) != null) {
            jVar.b(this.f262104f);
        }
        return true;
    }

    protected void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_succ_flag", "0");
        hashMap.put("errCode", i3 + "");
        hashMap.put("param_version", Build.VERSION.SDK_INT + "");
        hashMap.put("param_deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttAmrPlaryerError", true, 0L, 0L, hashMap, null);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        MediaPlayer mediaPlayer = this.f262102d;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) mediaPlayer);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr onCompletion");
        }
        this.f262106i = null;
        j jVar = this.f262105h;
        if (jVar != null) {
            jVar.b(this.f262104f);
        }
        this.C.set(false);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr onError");
        }
        this.f262106i = null;
        j jVar = this.f262105h;
        if (jVar != null) {
            jVar.a(this, 9, 0, "Error (" + i3 + "," + i16 + ")", this.f262104f);
        }
        i(i3);
        this.C.set(false);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) mediaPlayer);
        } else if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr onPrepared");
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr pause");
        }
        this.f262102d.pause();
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void prepare() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr prepare");
        }
        this.f262102d.prepare();
        this.C.set(true);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr release");
        }
        this.C.set(false);
        this.f262102d.release();
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr reset");
        }
        try {
            this.f262102d.reset();
        } catch (NullPointerException e16) {
            QLog.e("AmrPlayer", 1, "playAmr reset NullPointerException: " + e16);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr seekTo");
        }
        this.f262103e = i3;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void setDataSource(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr setDataSource");
        }
        this.f262104f = str;
        this.f262102d.setDataSource(str);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr start");
        }
        this.f262102d.setOnCompletionListener(this);
        this.f262102d.setOnPreparedListener(this);
        this.f262102d.setOnErrorListener(this);
        if (this.f262106i == null) {
            AmrPlayerThread amrPlayerThread = new AmrPlayerThread();
            this.f262106i = amrPlayerThread;
            amrPlayerThread.start();
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AmrPlayer", 2, "playAmr stop");
        }
        this.f262102d.stop();
        this.C.set(false);
        this.f262106i = null;
    }
}
