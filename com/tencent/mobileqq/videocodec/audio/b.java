package com.tencent.mobileqq.videocodec.audio;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f312508a;

    /* renamed from: b, reason: collision with root package name */
    public AudioEncoder.a f312509b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f312510c;

    /* renamed from: d, reason: collision with root package name */
    public int f312511d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f312512e;

    /* renamed from: f, reason: collision with root package name */
    public long f312513f;

    /* renamed from: g, reason: collision with root package name */
    public long f312514g;

    /* renamed from: h, reason: collision with root package name */
    public long f312515h;

    /* renamed from: i, reason: collision with root package name */
    public String f312516i;

    /* renamed from: j, reason: collision with root package name */
    public AudioEncoder.a f312517j;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f312510c = true;
        this.f312511d = 0;
        this.f312512e = false;
        this.f312513f = 0L;
        this.f312514g = 0L;
        this.f312515h = 0L;
    }

    public void a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        bVar.getClass();
        this.f312508a = bVar.f312508a;
        this.f312516i = bVar.f312516i;
        this.f312509b = bVar.f312509b;
        this.f312510c = bVar.f312510c;
        this.f312511d = bVar.f312511d;
        this.f312512e = bVar.f312512e;
        this.f312513f = bVar.f312513f;
        this.f312514g = bVar.f312514g;
        this.f312515h = bVar.f312515h;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "AudioDecodeConfig=[audioFilePath:" + this.f312508a + " repeat:" + this.f312510c + " speedType:" + this.f312511d + " mMuteAudio:" + this.f312512e + " startTimeMs:" + this.f312513f + " endTimeMs:" + this.f312514g + " videoDuration:" + this.f312515h + "]";
    }
}
