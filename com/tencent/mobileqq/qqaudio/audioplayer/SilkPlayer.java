package com.tencent.mobileqq.qqaudio.audioplayer;

import android.app.Application;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mobileqq.ptt.pttspeed.Sonic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.WeakReferenceHandler;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes16.dex */
public final class SilkPlayer implements Handler.Callback, i {
    static IPatchRedirector $redirector_;
    private byte C;
    private float D;
    private h E;
    private Application F;
    private SilkPlayerThread G;
    private j H;
    private WeakReferenceHandler I;
    private long J;

    /* renamed from: d, reason: collision with root package name */
    private int f262155d;

    /* renamed from: e, reason: collision with root package name */
    private String f262156e;

    /* renamed from: f, reason: collision with root package name */
    private int f262157f;

    /* renamed from: h, reason: collision with root package name */
    private int f262158h;

    /* renamed from: i, reason: collision with root package name */
    private int f262159i;

    /* renamed from: m, reason: collision with root package name */
    private int f262160m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class SilkPlayerThread extends BaseThread {
        static IPatchRedirector $redirector_;
        private SilkCodecWrapper C;
        private byte[] D;
        private byte[] E;
        private volatile boolean F;
        private AudioTrack G;
        private int H;
        private int I;
        int J;
        int K;

        public SilkPlayerThread(Application application) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SilkPlayer.this, (Object) application);
                return;
            }
            this.F = false;
            this.I = QQAudioUtils.d(SilkPlayer.this.C);
            this.C = new SilkCodecWrapper(application, false);
            int c16 = QQAudioUtils.c(this.I);
            this.H = c16;
            this.D = new byte[c16];
            this.E = new byte[c16];
            if (QLog.isColorLevel()) {
                QLog.d("SilkPlayer", 2, "SilkPlayerThread sampleRate=" + this.I + ", oneFrameSize=" + this.H + ", currenttime:" + System.currentTimeMillis());
            }
        }

        private boolean e(FileInputStream fileInputStream, int i3, Sonic sonic, byte[] bArr) throws IOException {
            if (SilkPlayer.this.f262158h == -1) {
                int read = fileInputStream.read(this.D, 0, i3);
                this.J += i3;
                if (read == -1) {
                    SilkPlayer.this.t(2, 6, "silk decode error: failed to read frameSize=" + i3);
                    if (QLog.isColorLevel()) {
                        QLog.d("SilkPlayer", 2, "silk decode error: failed to read frameSize=" + i3);
                    }
                    return false;
                }
                if (!this.F) {
                    return false;
                }
                SilkCodecWrapper silkCodecWrapper = this.C;
                byte[] bArr2 = this.D;
                byte[] bArr3 = this.E;
                int f16 = silkCodecWrapper.f(bArr2, bArr3, i3, bArr3.length);
                if (f16 == 0) {
                    SilkPlayer.this.t(3, 7, "silk decode jni error ret = 0");
                    if (QLog.isColorLevel()) {
                        QLog.d("SilkPlayer", 2, "silk decode jni error");
                    }
                    return false;
                }
                if (this.F) {
                    g(sonic, f16, bArr);
                }
                return true;
            }
            this.J += i3;
            fileInputStream.skip(i3);
            return true;
        }

        private void f(int i3) {
            synchronized ("SilkPlayer") {
                SilkPlayer.this.f262159i = i3;
                SilkPlayer.this.f262160m++;
                if (SilkPlayer.this.f262158h == -1) {
                    SilkPlayer silkPlayer = SilkPlayer.this;
                    silkPlayer.u(silkPlayer.f262160m * 20);
                }
            }
            if (SilkPlayer.this.f262158h != -1 && SilkPlayer.this.getCurrentPosition() >= SilkPlayer.this.f262158h) {
                SilkPlayer.this.f262158h = -1;
            }
        }

        private void g(Sonic sonic, int i3, byte[] bArr) {
            if (com.tencent.mobileqq.qqaudio.audioplayer.sonic.a.b(SilkPlayer.this.D) && bArr != null && com.tencent.mobileqq.qqaudio.audioplayer.sonic.a.a()) {
                if (i3 > 0) {
                    sonic.d(this.E, i3);
                } else {
                    sonic.c();
                }
                int a16 = sonic.a();
                if (a16 > 0) {
                    if (bArr.length < a16) {
                        bArr = new byte[a16 * 2];
                    }
                    sonic.e(bArr, a16);
                    this.G.write(bArr, 0, a16);
                    return;
                }
                return;
            }
            this.G.write(this.E, 0, this.H);
            if (SilkPlayer.this.E != null) {
                SilkPlayer.this.E.c(this.E);
            }
        }

        private FileInputStream o() throws IOException {
            if (SilkPlayer.this.f262158h != -1) {
                if (SilkPlayer.this.f262158h != SilkPlayer.this.getCurrentPosition()) {
                    SilkPlayer.this.f262160m = 0;
                    SilkPlayer.this.f262159i = 0;
                } else {
                    this.K = SilkPlayer.this.f262159i;
                    this.J = SilkPlayer.this.f262159i;
                    SilkPlayer.this.f262158h = -1;
                }
            }
            FileInputStream fileInputStream = new FileInputStream(SilkPlayer.this.f262156e);
            int i3 = this.K;
            if (i3 == 0) {
                fileInputStream.skip(10L);
                this.J += 10;
            } else {
                fileInputStream.skip(i3);
            }
            return fileInputStream;
        }

        private void p(boolean z16, FileInputStream fileInputStream) {
            this.F = false;
            AudioTrack audioTrack = this.G;
            if (audioTrack != null && audioTrack.getState() != 0) {
                try {
                    this.G.pause();
                    this.G.flush();
                    this.G.release();
                    if (QLog.isColorLevel()) {
                        QLog.d("SilkPlayer", 2, "SilkPlayerThread onEnd, release mAudioTrack.");
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                this.G = null;
            }
            this.C.g();
            if (z16) {
                SilkPlayer.this.s();
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x0128, code lost:
        
            r20.this$0.t(1, 4, "silk decode error: error frame size=" + r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0140, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0142, code lost:
        
            com.tencent.qphone.base.util.QLog.d("SilkPlayer", 2, "silk decode error: error frame size=" + r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00e9, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00eb, code lost:
        
            com.tencent.qphone.base.util.QLog.d("SilkPlayer", 2, "silk decode completed mCurrentPlayFrame=" + r20.this$0.f262160m + ", mCurrentFileOffset" + r20.this$0.f262159i);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0115, code lost:
        
            r5 = true;
         */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Exception exc;
            boolean z16;
            Sonic sonic;
            byte[] bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            byte[] bArr2 = new byte[2];
            int i3 = 0;
            r5 = false;
            r5 = false;
            r5 = false;
            r5 = false;
            r5 = false;
            r5 = false;
            boolean z17 = false;
            this.J = 0;
            this.K = 0;
            Process.setThreadPriority(-19);
            FileInputStream fileInputStream = null;
            try {
                this.C.b(this.I, 0, 1);
                if (com.tencent.mobileqq.qqaudio.audioplayer.sonic.a.b(SilkPlayer.this.D) && com.tencent.mobileqq.qqaudio.audioplayer.sonic.a.a()) {
                    sonic = new Sonic(this.I, 1);
                    sonic.f(SilkPlayer.this.D);
                    bArr = new byte[2048];
                } else {
                    sonic = null;
                    bArr = null;
                }
                if (SilkPlayer.this.H != null) {
                    SilkPlayer.this.H.f();
                }
                int minBufferSize = AudioTrack.getMinBufferSize(this.I, 4, 2);
                try {
                    this.G = new ReportAudioTrack(SilkPlayer.this.f262155d, this.I, 4, 2, minBufferSize, 1);
                    if (QLog.isColorLevel()) {
                        QLog.d("SilkPlayer", 2, "start play silk mStreamType=" + SilkPlayer.this.f262155d + ", rate=" + this.I + ", playBufferSize = " + minBufferSize + ", currentTime:" + System.currentTimeMillis());
                    }
                    this.G.play();
                    fileInputStream = o();
                    while (true) {
                        if (!this.F || fileInputStream == null) {
                            break;
                        }
                        int read = fileInputStream.read(bArr2, 0, 2);
                        this.J += 2;
                        if (read == -1) {
                            try {
                                break;
                            } catch (Exception e16) {
                                exc = e16;
                                z16 = true;
                                i3 = minBufferSize;
                                QLog.e("SilkPlayer", 1, "silk play exception " + exc.toString());
                                SilkPlayer.this.v(exc, this.G, this.I, i3);
                                SilkPlayer.this.t(4, 5, exc.getMessage());
                                z17 = z16;
                                p(z17, fileInputStream);
                            }
                        }
                        if (!this.F) {
                            break;
                        }
                        int b16 = QQAudioUtils.b(bArr2);
                        if (b16 <= 0) {
                            break;
                        } else if (this.F && e(fileInputStream, b16, sonic, bArr)) {
                            f(this.J);
                        }
                    }
                } catch (Exception e17) {
                    exc = e17;
                    z16 = false;
                }
            } catch (Exception e18) {
                exc = e18;
                z16 = false;
            }
            p(z17, fileInputStream);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread
        public void start() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.F = true;
                super.start();
            }
        }
    }

    public SilkPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f262155d = 3;
        this.f262157f = -1;
        this.f262158h = -1;
        this.f262159i = 0;
        this.f262160m = 0;
        this.C = (byte) -1;
        this.D = 1.0f;
        this.J = -1L;
        this.F = BaseApplication.getContext();
        this.I = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void a(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            return;
        }
        this.D = f16;
        com.tencent.mobileqq.qqaudio.audioplayer.sonic.a.c();
        if (QLog.isColorLevel()) {
            QLog.d("SilkPlayer", 2, "setPlaySpeed=" + f16);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void b(int i3, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Byte.valueOf(b16));
        } else {
            this.f262157f = i3;
            this.C = b16;
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f262156e;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void d(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) jVar);
        } else {
            this.H = jVar;
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f262155d = i3;
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f262158h;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public int getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f262160m * 20;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f262157f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        j jVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1) {
            j jVar2 = this.H;
            if (jVar2 != null) {
                jVar2.a(this, message.arg1, 0, (String) message.obj, this.f262156e);
            }
        } else if (i3 == 2) {
            j jVar3 = this.H;
            if (jVar3 != null) {
                jVar3.b(this.f262156e);
            }
        } else if (i3 == 3 && (jVar = this.H) != null) {
            jVar.onProgressChanged(((Integer) message.obj).intValue());
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        SilkPlayerThread silkPlayerThread = this.G;
        if (silkPlayerThread != null && silkPlayerThread.F) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        SilkPlayerThread silkPlayerThread = this.G;
        if (silkPlayerThread != null && silkPlayerThread.isAlive()) {
            this.G.F = false;
            this.G = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean] */
    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prepare() {
        ?? r26;
        Throwable th5;
        FileInputStream fileInputStream;
        Exception e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && (r26 = iPatchRedirector.hasPatch((short) 14)) != 0) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.f262157f == -1 || this.C == -1) {
            try {
                try {
                    fileInputStream = new FileInputStream(this.f262156e);
                } catch (Exception e17) {
                    fileInputStream = null;
                    e16 = e17;
                } catch (Throwable th6) {
                    r26 = 0;
                    th5 = th6;
                    if (r26 != 0) {
                    }
                    throw th5;
                }
                try {
                    if (this.C == -1) {
                        this.C = QQAudioUtils.f(fileInputStream);
                    } else {
                        fileInputStream.skip(10L);
                    }
                    if (this.f262157f == -1) {
                        this.f262157f = QQAudioUtils.e(this.C, fileInputStream);
                    }
                } catch (Exception e18) {
                    e16 = e18;
                    if (QLog.isColorLevel()) {
                        QLog.d("SilkPlayer", 2, "silk player prepare exception=" + e16.getMessage());
                    }
                    if (fileInputStream == null) {
                        return;
                    }
                    fileInputStream.close();
                }
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (r26 != 0) {
                    try {
                        r26.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th5;
            }
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        this.G = null;
        if (this.H != null) {
            this.I.sendEmptyMessage(2);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        this.f262158h = i3;
        if (QLog.isColorLevel()) {
            QLog.d("SilkPlayer", 2, "seekTo=" + i3);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void setDataSource(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.f262156e = str;
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (this.G == null) {
            this.G = new SilkPlayerThread(this.F);
            if (this.f262158h == -1 && this.f262160m > 0) {
                seekTo(getCurrentPosition());
            }
            this.G.start();
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.i
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        SilkPlayerThread silkPlayerThread = this.G;
        if (silkPlayerThread != null && silkPlayerThread.isAlive()) {
            this.G.F = false;
            this.G = null;
        }
        this.f262157f = -1;
        this.C = (byte) -1;
        this.f262159i = 0;
        this.f262160m = 0;
    }

    public void t(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        this.G = null;
        if (this.H != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i16;
            obtain.obj = str;
            this.I.sendMessage(obtain);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_succ_flag", "0");
        hashMap.put("errCode", i3 + "");
        hashMap.put("param_version", Build.VERSION.SDK_INT + "");
        hashMap.put("param_deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSilkPlaryerError", true, 0L, 0L, hashMap, null);
    }

    public void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        if (this.H != null) {
            if (this.J < 0) {
                this.I.sendMessage(this.I.obtainMessage(3, Integer.valueOf(i3)));
                this.J = System.currentTimeMillis();
            } else if (System.currentTimeMillis() - this.J > 100) {
                this.I.sendMessage(this.I.obtainMessage(3, Integer.valueOf(i3)));
                this.J = System.currentTimeMillis();
            }
        }
    }

    void v(Exception exc, AudioTrack audioTrack, int i3, int i16) {
        try {
            if (exc instanceof IllegalStateException) {
                HashMap<String, String> hashMap = new HashMap<>();
                if (audioTrack != null) {
                    int state = audioTrack.getState();
                    int playState = audioTrack.getPlayState();
                    hashMap.put("param_state", state + "");
                    hashMap.put("param_play_state", playState + "");
                }
                String str = this.f262156e;
                if (str != null) {
                    hashMap.put("param_filePath", str);
                }
                hashMap.put("param_streamType", this.f262155d + "");
                hashMap.put("param_sampleRate", i3 + "");
                hashMap.put("param_playBufferSize", i16 + "");
                hashMap.put("param_version", Build.VERSION.SDK_INT + "");
                hashMap.put("param_deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
                hashMap.put("param_exception_detail", exc.toString());
                StringBuilder sb5 = new StringBuilder();
                for (String str2 : hashMap.keySet()) {
                    sb5.append(str2);
                    sb5.append(" = ");
                    sb5.append(hashMap.get(str2));
                    sb5.append("; ");
                }
                QLog.e("SilkPlayer", 1, "reportIllegalStateException, " + sb5.toString());
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSilkPlayerStateError", true, 0L, 0L, hashMap, null);
            }
        } catch (Throwable th5) {
            QLog.e("SilkPlayer", 1, "reportIllegalStateException error.", th5);
        }
    }

    public void w(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) hVar);
        } else {
            this.E = hVar;
        }
    }
}
