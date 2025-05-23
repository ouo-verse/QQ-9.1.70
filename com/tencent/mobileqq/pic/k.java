package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes16.dex */
public class k extends h {
    static IPatchRedirector $redirector_;
    public String K;
    public long L;
    public String M;
    public String N;
    public String P;
    public String Q;
    public int R;
    public long S;
    public int T;
    public long U;
    public boolean V;
    public boolean W;
    public String X;
    public long Y;
    public String Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f258724a0;

    /* renamed from: b0, reason: collision with root package name */
    public String f258725b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f258726c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f258727d0;

    /* renamed from: e0, reason: collision with root package name */
    public ReportInfo f258728e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f258729f0;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a extends k {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public k i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (k) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this;
        }

        public void j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f258712f = i3;
            }
        }

        public void k(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, (Object) this, i3);
            } else {
                this.T = i3;
            }
        }

        public void l(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            } else {
                this.J = str;
            }
        }

        public void m(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            } else {
                this.f258715m = str;
            }
        }

        public void n(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                this.f258714i = str;
            }
        }

        public void o(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, j3);
            } else {
                this.S = j3;
            }
        }

        public void p(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.f258713h = i3;
            }
        }

        public void q(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, j3);
            } else {
                this.D = j3;
            }
        }

        public void r(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            } else {
                this.K = str;
            }
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f258726c0 = false;
            this.f258729f0 = false;
        }
    }

    @Override // com.tencent.mobileqq.pic.h
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (TextUtils.isEmpty(this.K)) {
            a("PicDownloadInfo.check", "uuid invaid:" + this.K);
            return false;
        }
        if (this.f258714i == null) {
            a("checkPicInfo", "selfUin invalid,selfUin:" + this.f258714i);
            return false;
        }
        if (this.V && this.Y == 0) {
            a("PicDownloadInfo.check", "groupFileID invaid:" + this.Y);
            return false;
        }
        return super.b();
    }

    @Override // com.tencent.mobileqq.pic.h
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        int i3 = 65537;
        if (!"chatthumb".equals(this.I)) {
            if (ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE.equals(this.I)) {
                i3 = 1;
            } else if (ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW.equals(this.I)) {
                i3 = 131075;
            }
        }
        if (this.H) {
            v vVar = new v();
            vVar.f258713h = this.f258713h;
            vVar.G = this.G;
            vVar.f258711e = this.f258711e;
            vVar.J = this.J;
            URL url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(vVar, i3, (String) null);
            if (url != null) {
                return url.toString();
            }
        } else {
            URL url2 = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(this, i3, (String) null);
            if (url2 != null) {
                return url2.toString();
            }
        }
        return null;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return d() + "_dp";
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "\nPicDownloadInfo\n |-md5:" + this.J + "\n |-uuid:" + this.K + "\n |-groupFileID:" + this.L + "\n |-uinType:" + this.f258713h + "\n |-subMsgId:" + this.f258724a0 + "\n |-subVersion:" + this.G + "\n |-protocol:" + this.I + "\n |-fileSizeFlag:" + this.R + "\n |-thumbMsgUrl:" + this.M + "\n |-bigthumbMsgUrl:" + this.Q + "\n |-bigMsgUrl:" + this.N + "\n |-rawMsgUrl:" + this.P + "\n |-isMixed:" + this.V + "\n |-shareAppID:" + this.Y + "\n |-action:" + this.X + "\n |-actMsgContentValue:" + this.W + "\n |-picExtraFlag:" + this.E + "\n |-picExtraObject:" + this.F + "\n |-downloadIndex:" + this.f258725b0;
    }

    @Override // com.tencent.mobileqq.pic.h
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return h() + super.toString();
    }
}
