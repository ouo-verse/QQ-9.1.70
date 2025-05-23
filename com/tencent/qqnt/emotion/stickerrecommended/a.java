package com.tencent.qqnt.emotion.stickerrecommended;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f356428a;

    /* renamed from: b, reason: collision with root package name */
    private long f356429b;

    /* renamed from: c, reason: collision with root package name */
    private int f356430c;

    /* renamed from: d, reason: collision with root package name */
    private String f356431d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.d
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f356430c;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.d
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f356431d;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.d
    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f356430c = i3;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.d
    public void endExposed(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
            return;
        }
        long j16 = this.f356428a;
        if (j16 != 0) {
            this.f356429b += j3 - j16;
            this.f356428a = 0L;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.d
    public long exposedTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.f356429b;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.d
    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.f356431d = str;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.d
    public void startExposed(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.f356428a = j3;
        }
    }
}
