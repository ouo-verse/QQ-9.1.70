package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.av.temp.IQavTemp;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioprocessor.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VoiceChange extends com.tencent.mobileqq.qqaudio.audioprocessor.a {
    static IPatchRedirector $redirector_;
    private static boolean L;
    private long F;
    private int G;
    private long H;
    private int I;
    private long J;
    private String K;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46739);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            L = false;
        }
    }

    public VoiceChange(Context context, int i3, String str) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, Integer.valueOf(i3), str);
            return;
        }
        this.G = 0;
        if (!L) {
            com.tencent.mobileqq.qqaudio.silk.a.c(context, "codecsilk");
            L = true;
        }
        this.G = i3;
        try {
            this.K = new File(str).getCanonicalPath();
        } catch (Exception unused) {
        }
    }

    public native long Create(String str, String str2);

    public native int Init(long j3, int i3, int i16, int i17, int i18);

    public native int Release(long j3);

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.a, com.tencent.mobileqq.qqaudio.audioprocessor.c
    public c.a a(byte[] bArr, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (c.a) iPatchRedirector.redirect((short) 7, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        c.a a16 = super.a(bArr, i3, i16);
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (uptimeMillis2 > this.J) {
            this.J = uptimeMillis2;
        }
        this.H += uptimeMillis2;
        this.I++;
        return a16;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.a, com.tencent.mobileqq.qqaudio.audioprocessor.c
    public void b(int i3, int i16, int i17) throws IOException {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 3;
        int i26 = 6;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        super.b(i3, i16, i17);
        this.H = 0L;
        this.I = 0;
        this.J = 0L;
        this.E = QQAudioUtils.c(i3);
        String audio3ALicenseFilename = ((IQavTemp) QRoute.api(IQavTemp.class)).getAudio3ALicenseFilename();
        if (QLog.isColorLevel()) {
            QLog.e("QQVoiceChanger", 1, "voice Init getAudio3ALicenseFilename  = " + audio3ALicenseFilename);
        }
        long Create = Create(this.K, audio3ALicenseFilename);
        this.F = Create;
        if (Create == 0) {
            QLog.e("QQVoiceChanger", 1, "Create voiceChanger error with:" + this.K);
        }
        int i27 = this.G;
        int i28 = -1;
        if (i27 == 1) {
            i18 = -1;
            i28 = 1;
        } else if (i27 == 2) {
            i18 = -1;
            i28 = 2;
        } else {
            if (i27 == 3) {
                i28 = 8;
            } else {
                int i29 = 7;
                if (i27 != 4) {
                    if (i27 == 5) {
                        i18 = 2;
                    } else {
                        if (i27 != 6) {
                            if (i27 == 7) {
                                i18 = 4;
                            } else if (i27 == 8) {
                                i18 = 20;
                            } else {
                                i29 = 11;
                                if (i27 != 9) {
                                    i26 = 12;
                                    if (i27 != 10) {
                                        if (i27 == 11) {
                                            i18 = 51;
                                            i28 = 9;
                                        } else {
                                            i29 = 13;
                                            if (i27 == 12) {
                                                i28 = 13;
                                                i18 = 1;
                                            } else if (i27 == 13) {
                                                i19 = 50;
                                                i28 = 536936433;
                                            } else if (i27 == 14) {
                                                i18 = 5;
                                            } else if (i27 == 15) {
                                                i18 = 9;
                                            } else if (i27 != 16) {
                                                QLog.e("QQVoiceChanger", 1, "Init Error type=" + this.G);
                                                i28 = 0;
                                                i18 = 0;
                                            }
                                        }
                                    }
                                }
                            }
                            i28 = 10;
                        }
                        i18 = -1;
                        i28 = i26;
                    }
                }
                i18 = -1;
                i28 = i29;
            }
            i18 = i19;
        }
        Init(this.F, i3, 1, i28, i18);
        int i36 = this.E;
        this.f262203h = new byte[i36];
        byte[] bArr = new byte[i36 * 10];
        this.f262204i = bArr;
        byte[] bArr2 = new byte[bArr.length * 2];
        this.f262205m = bArr2;
        this.C = new c.a(bArr2, 0);
    }

    public native int doChange(long j3, byte[] bArr, byte[] bArr2);

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (this.f262202f.read(this.f262203h, 0, this.E) == -1) {
            return -1;
        }
        int doChange = doChange(this.F, this.f262203h, this.f262204i);
        System.arraycopy(this.f262204i, 0, bArr, i3, doChange);
        return doChange;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.a, com.tencent.mobileqq.qqaudio.audioprocessor.c
    public void release() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.H > 0 && this.I > 0 && this.G > 0) {
            ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).reportSoundProcessCost(this.H, this.I, this.J, this.G + 2);
        }
        Release(this.F);
        this.F = 0L;
        super.release();
    }
}
