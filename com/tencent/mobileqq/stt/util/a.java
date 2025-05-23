package com.tencent.mobileqq.stt.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.common.RTCAudioDefine;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f290857e;

    /* renamed from: a, reason: collision with root package name */
    private int f290858a;

    /* renamed from: b, reason: collision with root package name */
    private int f290859b;

    /* renamed from: c, reason: collision with root package name */
    private int f290860c;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f290861d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f290857e = new int[]{96000, 88200, 64000, 48000, 44100, 32000, RTCAudioDefine.RTC_AUDIO_SAMPLE_RATE_24000, 22050, 16000, 12000, 11025, 8000, 7350};
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f290860c = -1;
            this.f290861d = new byte[7];
        }
    }

    private boolean a() {
        if (this.f290860c < 0 || this.f290859b == 0) {
            return false;
        }
        return true;
    }

    public byte[] b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        if (!a()) {
            return null;
        }
        int i16 = i3 + 7;
        byte[] bArr = this.f290861d;
        bArr[0] = -1;
        bArr[1] = -15;
        int i17 = (this.f290858a << 6) | (this.f290860c << 2);
        int i18 = this.f290859b;
        bArr[2] = (byte) (i17 | (i18 >> 2));
        bArr[3] = (byte) (((i18 & 3) << 6) + (i16 >> 11));
        bArr[4] = (byte) ((i16 & 2047) >> 3);
        bArr[5] = (byte) (((i16 & 7) << 5) | 31);
        bArr[6] = -4;
        return bArr;
    }

    public a c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        this.f290859b = i3;
        return this;
    }

    public a d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        this.f290858a = i3;
        return this;
    }

    public a e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        this.f290860c = -1;
        int i16 = 0;
        while (true) {
            int[] iArr = f290857e;
            if (i16 >= iArr.length) {
                break;
            }
            if (iArr[i16] == i3) {
                this.f290860c = i16;
                break;
            }
            i16++;
        }
        return this;
    }
}
