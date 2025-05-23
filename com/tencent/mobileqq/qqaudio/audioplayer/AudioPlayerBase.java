package com.tencent.mobileqq.qqaudio.audioplayer;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.f;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes16.dex */
public abstract class AudioPlayerBase implements j, Runnable {
    static IPatchRedirector $redirector_;
    public static int M;
    public static boolean N;
    protected String C;
    protected volatile f.a D;
    protected volatile int E;
    protected volatile int F;
    protected boolean G;
    public int H;
    protected boolean I;
    protected boolean J;
    protected b K;
    protected Handler L;

    /* renamed from: d, reason: collision with root package name */
    protected Timer f262125d;

    /* renamed from: e, reason: collision with root package name */
    protected float f262126e;

    /* renamed from: f, reason: collision with root package name */
    protected long f262127f;

    /* renamed from: h, reason: collision with root package name */
    protected i f262128h;

    /* renamed from: i, reason: collision with root package name */
    protected AudioManager f262129i;

    /* renamed from: m, reason: collision with root package name */
    protected Application f262130m;

    /* loaded from: classes16.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioPlayerBase.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what == 1000 && AudioPlayerBase.this.F == 0 && AudioPlayerBase.this.r()) {
                AudioPlayerBase audioPlayerBase = AudioPlayerBase.this;
                int streamVolume = SystemMethodProxy.getStreamVolume(audioPlayerBase.f262129i, audioPlayerBase.D.f262193b);
                AudioPlayerBase audioPlayerBase2 = AudioPlayerBase.this;
                if (streamVolume / audioPlayerBase2.f262129i.getStreamMaxVolume(audioPlayerBase2.D.f262193b) > 0.18f) {
                    AudioPlayerBase.this.F = 1;
                    AudioPlayerBase audioPlayerBase3 = AudioPlayerBase.this;
                    i iVar = audioPlayerBase3.f262128h;
                    b bVar = audioPlayerBase3.K;
                    if (bVar != null && iVar != null) {
                        bVar.Tg(audioPlayerBase3, audioPlayerBase3.F, iVar.c());
                        return;
                    }
                    return;
                }
                AudioPlayerBase.this.L.sendEmptyMessageDelayed(1000, 200L);
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface b {
        void Tg(AudioPlayerBase audioPlayerBase, int i3, String str);

        void V3(AudioPlayerBase audioPlayerBase, int i3, String str);

        void W8(AudioPlayerBase audioPlayerBase, String str);

        void f9(AudioPlayerBase audioPlayerBase, String str);

        void j5(AudioPlayerBase audioPlayerBase, int i3, String str);

        void k9(AudioPlayerBase audioPlayerBase, int i3, String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36971);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            M = -999;
            N = false;
        }
    }

    public AudioPlayerBase(Context context, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) bVar);
            return;
        }
        this.f262126e = com.tencent.mobileqq.qqaudio.audioplayer.sonic.a.f262196a;
        this.f262127f = -1L;
        this.E = M;
        this.I = true;
        this.J = false;
        this.L = new a();
        Application application = (Application) context.getApplicationContext();
        this.f262130m = application;
        this.f262129i = (AudioManager) application.getSystemService("audio");
        this.K = bVar;
    }

    public static void x(float f16) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (f16 >= 0.0f && f16 < 24.0f) {
            hashMap.put("errorCode", String.valueOf(0));
        } else if (f16 >= 24.0f && f16 < 168.0f) {
            hashMap.put("errorCode", String.valueOf(1));
        } else if (f16 >= 168.0f && f16 < 360.0f) {
            hashMap.put("errorCode", String.valueOf(2));
        } else if (f16 > 360.0f) {
            hashMap.put("errorCode", String.valueOf(3));
        }
        hashMap.put(WidgetCacheWeatherData.HOUR, String.valueOf(f16));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pttPlayFileNotFind", true, 0L, 0L, hashMap, "");
    }

    public boolean A(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer", 2, "seekPlay ", new Exception());
        }
        return v(str, i3);
    }

    public void B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.E = i3;
        }
    }

    public void C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.H = i3;
        }
    }

    public void D(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, j3);
        } else {
            this.f262127f = j3;
        }
    }

    public void E(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.J = z16;
        }
    }

    public void F(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
            return;
        }
        this.f262126e = f16;
        if (QLog.isColorLevel()) {
            QLog.i("AudioPlayer", 2, "setPlaySpeed: " + f16);
        }
    }

    protected void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.f262128h instanceof AmrPlayer) {
            J();
            BaseTimer baseTimer = new BaseTimer();
            this.f262125d = baseTimer;
            baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioPlayerBase.this);
                    }
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AudioPlayerBase audioPlayerBase = AudioPlayerBase.this;
                    b bVar = audioPlayerBase.K;
                    if (bVar != null) {
                        try {
                            bVar.V3(audioPlayerBase, audioPlayerBase.m(), AudioPlayerBase.this.f262128h.c());
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("AudioPlayer", 2, "startProgressTimer e= " + e16);
                            }
                        }
                    }
                }
            }, 0L, 100L);
        }
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else if (N && this.f262129i.isBluetoothScoOn()) {
            this.f262129i.setBluetoothScoOn(false);
            this.f262129i.stopBluetoothSco();
            N = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        i iVar = this.f262128h;
        if (iVar != null) {
            if (iVar.isPlaying()) {
                this.f262128h.stop();
            }
            this.f262128h.reset();
            this.f262128h.release();
            this.f262128h = null;
        }
    }

    protected void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Timer timer = this.f262125d;
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.j
    public void a(i iVar, int i3, int i16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, iVar, Integer.valueOf(i3), Integer.valueOf(i16), str, str2);
            return;
        }
        stop();
        QLog.e("AudioPlayer", 2, "onError: " + i3);
        b bVar = this.K;
        if (bVar != null) {
            bVar.k9(this, -2, str2);
        }
        y(0, this.f262128h instanceof SilkPlayer ? 1 : 0, i3, str);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.j
    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        stop();
        b bVar = this.K;
        if (bVar != null) {
            bVar.W8(this, str);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.j
    public void f() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        this.G = this.f262129i.isSpeakerphoneOn();
        this.D = p();
        this.f262129i.setMode(this.D.f262192a);
        this.f262129i.setSpeakerphoneOn(this.D.f262194c);
        if (this.E != M) {
            this.D.f262193b = this.E;
        }
        b bVar = this.K;
        if (bVar != null && this.f262128h != null) {
            bVar.j5(this, this.D.f262193b, this.f262128h.c());
        }
        QQAudioUtils.i(this.f262130m, true);
        i iVar = this.f262128h;
        if (iVar != null) {
            iVar.e(this.D.f262193b);
            try {
                this.f262128h.prepare();
            } catch (Throwable th5) {
                th5.printStackTrace();
                QLog.e("AudioPlayer", 2, "mPlayer.prepare error", th5);
                y(0, this.f262128h instanceof SilkPlayer ? 1 : 0, 3, th5.toString());
                return;
            }
        }
        int streamVolume = SystemMethodProxy.getStreamVolume(this.f262129i, this.D.f262193b);
        int streamMaxVolume = this.f262129i.getStreamMaxVolume(this.D.f262193b);
        if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer", 2, "currentVolume=" + streamVolume + " maxVolume=" + streamMaxVolume);
        }
        if (streamVolume / streamMaxVolume < 0.18f) {
            this.F = 0;
            this.L.sendEmptyMessageDelayed(1000, 200L);
        } else {
            this.F = 1;
            this.L.removeMessages(1000);
        }
        b bVar2 = this.K;
        if (bVar2 != null && this.f262128h != null) {
            bVar2.Tg(this, this.F, this.f262128h.c());
        }
        y(1, this.f262128h instanceof SilkPlayer ? 1 : 0, 0, "");
        G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        if (FileUtils.fileExistsAndNotEmpty(this.C)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer", 2, "file not found, " + this.C);
        }
        stop();
        b bVar = this.K;
        if (bVar != null) {
            bVar.k9(this, -1, this.C);
            y(0, 1, 1, "ERROR_FILE_NOT_FOUND");
            if (this.f262127f > 0) {
                x(((float) (NetConnInfoCenter.getServerTime() - this.f262127f)) / 3600.0f);
            }
        }
        return false;
    }

    public abstract void i();

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            H();
        }
    }

    public AudioManager k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (AudioManager) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f262129i;
    }

    public String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        i iVar = this.f262128h;
        if (iVar != null) {
            return iVar.c();
        }
        return null;
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        i iVar = this.f262128h;
        if (iVar == null) {
            return 0;
        }
        return iVar.getCurrentPosition();
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        i iVar = this.f262128h;
        if (iVar == null) {
            return 0;
        }
        return iVar.getDuration();
    }

    public float o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Float) iPatchRedirector.redirect((short) 30, (Object) this)).floatValue();
        }
        return this.f262126e;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.j
    public void onProgressChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        b bVar = this.K;
        if (bVar != null) {
            try {
                bVar.V3(this, m(), this.f262128h.c());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AudioPlayer", 2, "startProgressTimer e= " + e16);
                }
            }
        }
    }

    protected abstract f.a p();

    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.C;
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        i iVar = this.f262128h;
        if (iVar != null && iVar.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        try {
            this.f262129i.setMode(0);
            this.f262129i.setSpeakerphoneOn(this.G);
            QQAudioUtils.i(this.f262130m, false);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("AudioPlayer", 2, e16, new Object[0]);
            }
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        }
    }

    public synchronized void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.L.removeMessages(1000);
        J();
        i iVar = this.f262128h;
        if (iVar != null) {
            if (iVar.isPlaying()) {
                b bVar = this.K;
                if (bVar != null) {
                    bVar.f9(this, this.f262128h.c());
                }
                this.f262128h.stop();
            }
            this.f262128h.reset();
            this.f262128h.release();
            this.f262126e = com.tencent.mobileqq.qqaudio.audioplayer.sonic.a.f262196a;
            this.f262127f = -1L;
            this.C = null;
            this.f262128h = null;
            this.E = M;
            ThreadManagerV2.post(this, 8, null, false);
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        }
    }

    public boolean u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str)).booleanValue();
        }
        return v(str, 0);
    }

    protected abstract boolean v(String str, int i3);

    public void w(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer", 2, "replay ", new Exception());
        }
        String str = this.C;
        if (str != null) {
            v(str, i3);
        }
    }

    public void y(int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("issilk", String.valueOf(i16));
        hashMap.put("isSuccess", String.valueOf(i3));
        hashMap.put("errorCode", String.valueOf(i17));
        hashMap.put("errormsg", str);
        hashMap.put(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, this.H + "");
        hashMap.put("filePath", this.C);
        hashMap.put("isfromLocal", (this.I ? 1 : 0) + "");
        hashMap.put("isfromBlueTooth", (this.J ? 1 : 0) + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pttplaysuc", true, 0L, 0L, hashMap, "");
    }

    public void z(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        int i3 = -1;
        if (z17) {
            if (z16) {
                i3 = 0;
            }
            c.f262174c = i3;
        } else {
            if (!z16) {
                i3 = 0;
            }
            c.f262174c = i3;
        }
        c.f262175d = false;
    }
}
