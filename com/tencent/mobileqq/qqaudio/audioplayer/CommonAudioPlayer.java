package com.tencent.mobileqq.qqaudio.audioplayer;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.PowerManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService;
import com.tencent.mobileqq.qqaudio.audioplayer.e;
import com.tencent.mobileqq.qqaudio.audioplayer.f;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes16.dex */
public class CommonAudioPlayer extends AudioPlayerBase implements IAudioDeviceService.a {
    static IPatchRedirector $redirector_;
    private e P;
    private com.tencent.mobileqq.qqaudio.audioplayer.a Q;
    private a R;
    private String S;
    private final PowerManager.WakeLock T;
    volatile boolean U;

    /* loaded from: classes16.dex */
    public interface a {
        void e(boolean z16, boolean z17);

        void k(boolean z16, boolean z17, boolean z18, boolean z19);
    }

    public CommonAudioPlayer(Context context, AudioPlayerBase.b bVar) {
        super(context, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) bVar);
            return;
        }
        this.U = false;
        this.T = ((PowerManager) context.getSystemService("power")).newWakeLock(32, context.getPackageName() + "AudioPlayer_Common");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit N() {
        stop();
        return null;
    }

    private void O() {
        String str = this.S;
        if (StringUtil.isEmpty(str)) {
            return;
        }
        this.S = null;
        Intent intent = new Intent();
        intent.setPackage(this.f262130m.getPackageName());
        intent.setAction("mqq.audiosenormanager.audio.end");
        intent.putExtra("audiosenormanager.playkey", str);
        this.f262130m.getApplicationContext().sendBroadcast(intent);
    }

    private void P() {
        String str = this.S;
        if (StringUtil.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setPackage(this.f262130m.getPackageName());
        intent.setAction("mqq.audiosenormanager.audio.start");
        intent.putExtra("audiosenormanager.playkey", str);
        this.f262130m.getApplicationContext().sendBroadcast(intent);
    }

    private void Q(e.a aVar) {
        a aVar2;
        if (aVar == null) {
            return;
        }
        this.P.l("CommonAudioPlayer.notifyUIDeviceStatusChanged getDeviceStatusType = " + aVar.a());
        int a16 = aVar.a();
        boolean z16 = false;
        if (a16 != 0 && a16 != 1) {
            if ((a16 == 2 || a16 == 3 || a16 == 4) && (aVar2 = this.R) != null) {
                boolean i3 = this.P.i();
                boolean b16 = this.P.b();
                boolean h16 = this.P.h();
                if (aVar.a() == 2) {
                    z16 = true;
                }
                aVar2.k(i3, b16, h16, z16);
                return;
            }
            return;
        }
        if (this.R != null) {
            boolean h17 = this.P.h();
            boolean f16 = this.P.f();
            if (!f16) {
                z16 = h17;
            }
            this.R.e(f16, z16);
        }
    }

    public boolean L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.P.f();
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.P = new e();
        com.tencent.mobileqq.qqaudio.audioplayer.a aVar = new com.tencent.mobileqq.qqaudio.audioplayer.a(this.f262130m);
        this.Q = aVar;
        aVar.c(this);
        this.P.j();
    }

    public void R(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar);
        } else {
            this.R = aVar;
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase, com.tencent.mobileqq.qqaudio.audioplayer.j
    public void a(i iVar, int i3, int i16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, iVar, Integer.valueOf(i3), Integer.valueOf(i16), str, str2);
            return;
        }
        this.Q.f();
        super.a(iVar, i3, i16, str, str2);
        this.U = false;
        PowerManager.WakeLock wakeLock = this.T;
        if (wakeLock != null) {
            wakeLock.setReferenceCounted(false);
            this.T.release();
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase, com.tencent.mobileqq.qqaudio.audioplayer.j
    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        this.Q.f();
        super.b(str);
        this.U = false;
        PowerManager.WakeLock wakeLock = this.T;
        if (wakeLock != null) {
            wakeLock.setReferenceCounted(false);
            this.T.release();
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService.a
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.P.s();
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase, com.tencent.mobileqq.qqaudio.audioplayer.j
    public void f() throws IOException {
        PowerManager.WakeLock wakeLock;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.f();
        this.U = false;
        if (com.tencent.qqnt.audio.injector.a.f352538a.a().a() && this.P.d() == 1 && (wakeLock = this.T) != null && !wakeLock.isHeld()) {
            this.T.acquire(301000L);
        }
        AudioManager audioManager = (AudioManager) this.f262130m.getSystemService("audio");
        AudioDeviceHelperKt audioDeviceHelperKt = AudioDeviceHelperKt.f262108a;
        if (audioDeviceHelperKt.e(audioManager)) {
            audioManager.setMode(0);
        }
        audioDeviceHelperKt.j(this.f262130m, new Function0() { // from class: com.tencent.mobileqq.qqaudio.audioplayer.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit N;
                N = CommonAudioPlayer.this.N();
                return N;
            }
        });
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService.a
    public void g(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (i3 != 8) {
            if (i3 == 16) {
                z(z16, true);
            }
        } else {
            z(z16, false);
        }
        this.P.m(i3, z16);
        e.a c16 = this.P.c();
        if (c16 != null) {
            boolean r16 = r();
            if (QLog.isColorLevel()) {
                QLog.d("AudioPlayer_Common", 2, "before notifyUIDeviceStatusChanged status = " + c16.a() + " | isPlaying = " + r16);
            }
            if (r16) {
                if (c16.b()) {
                    c16.e();
                    if (this.f262128h.getCurrentPosition() > 0) {
                        w(this.f262128h.getCurrentPosition() - f.f262189a);
                    } else {
                        w(this.f262128h.f() - f.f262189a);
                    }
                }
                Q(c16);
            }
        }
        if (i3 != 8) {
            if (i3 == 16 && z16) {
                H();
                return;
            }
            return;
        }
        if (!z16) {
            H();
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.P.a(this.f262129i);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            super.j();
            this.Q.f();
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
    protected f.a p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.P.e();
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (!super.r() && !this.U) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.P.r(true);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
    public synchronized void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        O();
        super.stop();
        this.U = false;
        PowerManager.WakeLock wakeLock = this.T;
        if (wakeLock != null) {
            wakeLock.setReferenceCounted(false);
            this.T.release();
        }
        AudioDeviceHelperKt.f262108a.l(this.f262130m);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.P.r(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x011b A[Catch: Exception -> 0x0194, TRY_ENTER, TryCatch #4 {Exception -> 0x0194, blocks: (B:37:0x00ab, B:54:0x011b, B:55:0x0147, B:61:0x0124, B:80:0x0193), top: B:36:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0124 A[Catch: Exception -> 0x0194, TryCatch #4 {Exception -> 0x0194, blocks: (B:37:0x00ab, B:54:0x011b, B:55:0x0147, B:61:0x0124, B:80:0x0193), top: B:36:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fa A[Catch: all -> 0x00ee, TRY_LEAVE, TryCatch #6 {all -> 0x00ee, blocks: (B:40:0x00b0, B:64:0x00f4, B:66:0x00fa), top: B:39:0x00b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean v(String str, int i3) {
        int i16;
        Exception exc;
        byte b16;
        byte b17;
        int i17;
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (i3 < 0) {
            i16 = 0;
        } else {
            i16 = i3;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.C = str;
        ThreadManagerV2.remove(this);
        if (!h()) {
            return false;
        }
        this.P.k();
        int b18 = this.Q.b(str, i16);
        if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer_Common", 2, "checkBluetoothHeadsetDeviceType result = " + b18);
        }
        if (b18 == 0) {
            this.U = false;
            return false;
        }
        if (b18 == 2) {
            this.U = false;
            return true;
        }
        if (c.h(this.f262129i)) {
            int e16 = this.Q.e(str, i16);
            if (QLog.isColorLevel()) {
                QLog.d("AudioPlayer_Common", 2, "play needWaitOpenScoTunnel tryStartBluetoothSCO result = " + e16);
            }
            if (e16 == 0) {
                this.U = false;
                return false;
            }
            if (e16 == 2) {
                this.U = false;
                return true;
            }
        }
        this.S = str + currentTimeMillis;
        try {
            I();
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (Exception e17) {
                    e = e17;
                }
                try {
                    try {
                        b17 = QQAudioUtils.f(fileInputStream);
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d("AudioPlayer_Common", 2, "try start path=" + str + " fsType=" + ((int) b17));
                            }
                        } catch (Exception e18) {
                            exc = e18;
                            b16 = b17;
                            fileInputStream2 = fileInputStream;
                            if (QLog.isColorLevel()) {
                            }
                            if (fileInputStream2 != null) {
                            }
                            b17 = b16;
                            if (b17 >= 0) {
                            }
                            com.tencent.mobileqq.qqaudio.b.a(i17);
                            this.f262128h.setDataSource(str);
                            this.f262128h.seekTo(i16);
                            this.f262128h.b(-1, b17);
                            this.f262128h.d(this);
                            this.f262128h.a(this.f262126e);
                            this.f262128h.start();
                            if (QLog.isColorLevel()) {
                            }
                            P();
                            return true;
                        }
                        try {
                            fileInputStream.close();
                        } catch (Exception unused) {
                            if (b17 >= 0) {
                            }
                            com.tencent.mobileqq.qqaudio.b.a(i17);
                            this.f262128h.setDataSource(str);
                            this.f262128h.seekTo(i16);
                            this.f262128h.b(-1, b17);
                            this.f262128h.d(this);
                            this.f262128h.a(this.f262126e);
                            this.f262128h.start();
                            if (QLog.isColorLevel()) {
                            }
                            P();
                            return true;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e19) {
                    e = e19;
                    fileInputStream2 = fileInputStream;
                    exc = e;
                    b16 = -1;
                    if (QLog.isColorLevel()) {
                        QLog.d("AudioPlayer_Common", 2, "play exception" + exc.getMessage());
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    b17 = b16;
                    if (b17 >= 0) {
                        this.f262128h = new SilkPlayer();
                        i17 = 1;
                    } else {
                        this.f262128h = new AmrPlayer();
                        QLog.e("AudioPlayer_Common", 1, "play : fsType = " + ((int) b17) + ", use amrPlayer");
                        i17 = 2;
                    }
                    com.tencent.mobileqq.qqaudio.b.a(i17);
                    this.f262128h.setDataSource(str);
                    this.f262128h.seekTo(i16);
                    this.f262128h.b(-1, b17);
                    this.f262128h.d(this);
                    this.f262128h.a(this.f262126e);
                    this.f262128h.start();
                    if (QLog.isColorLevel()) {
                        QLog.d("AudioPlayer_Common", 2, "play music time = " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    P();
                    return true;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPlayer_Common", 2, "play on error, ", e26);
            }
            a(this.f262128h, 2, 0, e26.toString(), this.f262128h.c());
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase
    public void w(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (this.C != null) {
            this.U = true;
        }
        super.w(i3);
    }
}
