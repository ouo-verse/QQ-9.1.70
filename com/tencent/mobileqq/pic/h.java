package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class h extends m {
    static IPatchRedirector $redirector_;
    public String C;
    public long D;
    public int E;
    public Object F;
    public int G;
    public boolean H;
    public String I;
    public String J;

    /* renamed from: e, reason: collision with root package name */
    public String f258711e;

    /* renamed from: f, reason: collision with root package name */
    public int f258712f;

    /* renamed from: h, reason: collision with root package name */
    public int f258713h;

    /* renamed from: i, reason: collision with root package name */
    public String f258714i;

    /* renamed from: m, reason: collision with root package name */
    public String f258715m;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f258712f = -1;
        this.f258713h = -1;
        this.G = 5;
        this.H = false;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f258712f == -1) {
            a("PicBaseInfo.check", "busiType invalid,busiType:" + this.f258712f);
            return false;
        }
        if (this.f258713h == -1) {
            a("PicBaseInfo.check", "uinType invalid,uinType:" + this.f258713h);
            return false;
        }
        if (this.f258715m == null) {
            a("PicBaseInfo.check", "peerUin invalid,peerUin:" + this.f258715m);
            return false;
        }
        return true;
    }

    public File c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (File) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return AbsDownloader.getFile(e());
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return AbsDownloader.getFilePath(e());
    }

    public abstract String e();

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (c() != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "\nPicBaseInfo\n |-localUUID:" + this.f258711e + "\n |-uniseq:" + this.D + "\n |-busiType:" + this.f258712f + "\n |-selfUin:" + this.f258714i + "\n |-peerUin:" + this.f258715m + "\n |-secondId:" + this.C + "\n |-md5:" + this.J + "\n |-errInfo:" + this.f258735d;
    }
}
