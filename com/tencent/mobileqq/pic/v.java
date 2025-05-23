package com.tencent.mobileqq.pic;

import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class v extends h {
    static IPatchRedirector $redirector_;
    public b A0;
    public String K;
    public String L;
    public int M;
    public int N;
    public ArrayList<Integer> P;
    public int Q;
    public int R;
    public long S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;
    public String Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f258815a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f258816b0;

    /* renamed from: c0, reason: collision with root package name */
    public long f258817c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f258818d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f258819e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f258820f0;

    /* renamed from: g0, reason: collision with root package name */
    public Object f258821g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f258822h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f258823i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f258824j0;

    /* renamed from: k0, reason: collision with root package name */
    public long f258825k0;

    /* renamed from: l0, reason: collision with root package name */
    public String f258826l0;

    /* renamed from: m0, reason: collision with root package name */
    public long f258827m0;

    /* renamed from: n0, reason: collision with root package name */
    public long f258828n0;

    /* renamed from: o0, reason: collision with root package name */
    public PhotoSendParams f258829o0;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f258830p0;

    /* renamed from: q0, reason: collision with root package name */
    public long f258831q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f258832r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f258833s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f258834t0;

    /* renamed from: u0, reason: collision with root package name */
    public String f258835u0;

    /* renamed from: v0, reason: collision with root package name */
    public String f258836v0;

    /* renamed from: w0, reason: collision with root package name */
    public String f258837w0;

    /* renamed from: x0, reason: collision with root package name */
    public String f258838x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f258839y0;

    /* renamed from: z0, reason: collision with root package name */
    public u f258840z0;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a extends v {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void A(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            } else {
                this.C = str;
            }
        }

        public void B(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            } else {
                this.f258714i = str;
            }
        }

        public void C(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, i3);
            } else {
                this.R = i3;
            }
        }

        public void D(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                iPatchRedirector.redirect((short) 31, (Object) this, z16);
            } else {
                this.f258833s0 = z16;
            }
        }

        public void E(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.N = i3;
            }
        }

        public void F(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                this.L = str;
            }
        }

        public void G(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.M = i3;
            }
        }

        public void H(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                iPatchRedirector.redirect((short) 27, (Object) this, i3);
            } else {
                this.f258822h0 = i3;
            }
        }

        public void I(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, i3);
            } else {
                this.f258713h = i3;
            }
        }

        public void J(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this, i3);
            } else {
                this.f258815a0 = i3;
            }
        }

        public v l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (v) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this;
        }

        public void m(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
            } else {
                this.f258712f = i3;
            }
        }

        public void n(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                iPatchRedirector.redirect((short) 26, (Object) this, i3);
            } else {
                this.f258820f0 = i3;
            }
        }

        public void o(u uVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                iPatchRedirector.redirect((short) 32, (Object) this, (Object) uVar);
            } else {
                this.f258840z0 = uVar;
            }
        }

        public void p(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, j3);
            } else {
                this.f258817c0 = j3;
            }
        }

        public void q(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, (Object) this, i3);
            } else {
                this.f258818d0 = i3;
            }
        }

        public void r(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                iPatchRedirector.redirect((short) 29, (Object) this, j3);
            } else {
                this.f258831q0 = j3;
            }
        }

        public void s(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this, i3);
            } else {
                this.f258816b0 = i3;
            }
        }

        public void t(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                iPatchRedirector.redirect((short) 30, (Object) this, i3);
            } else {
                this.f258832r0 = i3;
            }
        }

        public void u(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, (Object) this, i3);
            } else {
                this.f258819e0 = i3;
            }
        }

        public void v(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                this.K = str;
            }
        }

        public void w(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            } else {
                this.J = str;
            }
        }

        public void x(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            } else {
                this.f258715m = str;
            }
        }

        public void y(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                this.Q = i3;
            }
        }

        public void z(b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, (Object) bVar);
            } else {
                this.A0 = bVar;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f258841a;

        /* renamed from: b, reason: collision with root package name */
        public long f258842b;

        /* renamed from: c, reason: collision with root package name */
        public long f258843c;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.Q = -1;
        this.S = 0L;
        this.T = true;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.f258820f0 = 0;
        this.f258823i0 = 0;
        this.f258824j0 = false;
        this.f258833s0 = false;
    }

    @Override // com.tencent.mobileqq.pic.h
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (!FileUtils.fileExistsAndNotEmpty(this.K)) {
            a("checkPicInfo", "path invalid,localPath:" + this.K);
            return false;
        }
        int i3 = this.f258713h;
        if ((i3 == 1000 || i3 == 1020 || i3 == 1004) && this.C == null) {
            a("checkPicInfo", "secondId invalid,uinType:" + this.f258713h + ",secondId:" + this.C);
            return false;
        }
        if (g() == -1) {
            a("PicBaseInfo.check", "protocolType invalid,protocolType:" + this.Q);
            return false;
        }
        return super.b();
    }

    @Override // com.tencent.mobileqq.pic.h
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        String str = this.I;
        if (str == null) {
            f.d("PIC_TAG_ERROR", "PicUploadInfo.getUrlString", "protocol == null");
            return null;
        }
        int i3 = 65537;
        if (!"chatthumb".equals(str)) {
            if (ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE.equals(this.I)) {
                i3 = 1;
            } else if (ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW.equals(this.I)) {
                i3 = 131075;
            }
        }
        URL url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(this, i3, (String) null);
        if (url == null) {
            return null;
        }
        return url.toString();
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        int i3 = this.Q;
        if (i3 != -1) {
            return i3;
        }
        if (this.K != null) {
            if (GifDrawable.isGifFile(new File(this.K))) {
                this.Q = 0;
                return 0;
            }
        } else {
            f.d("PIC_TAG_ERROR", "PicUploadInfo.getProtocolType", "localPath == null");
        }
        if (this.R == 2) {
            this.Q = 1;
        } else {
            this.Q = 0;
        }
        return this.Q;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        u uVar = this.f258840z0;
        if (uVar != null && uVar.f258806c) {
            return true;
        }
        return false;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        u uVar = this.f258840z0;
        if (uVar != null && uVar.f258809f) {
            return true;
        }
        return false;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        u uVar = this.f258840z0;
        if (uVar != null && uVar.f258810g) {
            return true;
        }
        return false;
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "\nPicUploadInfo\n |-localPath:" + this.K + "\n |-protocolType:" + this.Q + "\n |-md5:" + this.J + "\n |-sendSizeSpec:" + this.R + "\n |-thumbPath:" + this.L + "\n |-thumbWidth:" + this.M + "\n |-thumbHeight:" + this.N + "\n |-source_image_width:" + this.f258815a0 + "\n |-source_image_height:" + this.f258816b0 + "\n |-source_image_filesize:" + this.f258817c0 + "\n |-source_image_filesizeflag:" + this.f258818d0 + "\n |-source_image_type:" + this.f258819e0 + "\n |-entrance:" + this.f258820f0;
    }

    @Override // com.tencent.mobileqq.pic.h
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return k() + super.toString();
    }
}
