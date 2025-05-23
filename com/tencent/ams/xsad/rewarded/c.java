package com.tencent.ams.xsad.rewarded;

import com.tencent.ams.xsad.rewarded.loader.DefaultRewardedAdResLoader;
import com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer;
import com.tencent.ams.xsad.rewarded.view.NetworkImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private static c f71733j;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.ams.xsad.rewarded.loader.a f71734a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.ams.xsad.rewarded.loader.c f71735b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.ams.xsad.rewarded.utils.d f71736c;

    /* renamed from: d, reason: collision with root package name */
    private Class<? extends RewardedAdPlayer> f71737d;

    /* renamed from: e, reason: collision with root package name */
    private String f71738e;

    /* renamed from: f, reason: collision with root package name */
    private int f71739f;

    /* renamed from: g, reason: collision with root package name */
    private a f71740g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f71741h;

    /* renamed from: i, reason: collision with root package name */
    private NetworkImageView.b f71742i;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12448);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            f71733j = new c();
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f71738e = "#0080FE";
        }
    }

    public static c f() {
        return f71733j;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        this.f71734a = null;
        this.f71735b = null;
        this.f71740g = null;
    }

    public com.tencent.ams.xsad.rewarded.loader.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.ams.xsad.rewarded.loader.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f71734a;
    }

    public Class<? extends RewardedAdPlayer> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Class) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f71737d;
    }

    public com.tencent.ams.xsad.rewarded.loader.c d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.ams.xsad.rewarded.loader.c) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        com.tencent.ams.xsad.rewarded.loader.c cVar = this.f71735b;
        if (cVar == null) {
            return DefaultRewardedAdResLoader.i();
        }
        return cVar;
    }

    public NetworkImageView.b e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (NetworkImageView.b) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        NetworkImageView.b bVar = this.f71742i;
        if (bVar == null) {
            return new NetworkImageView.a();
        }
        return bVar;
    }

    public com.tencent.ams.xsad.rewarded.utils.d g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.ams.xsad.rewarded.utils.d) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f71736c;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.f71739f;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f71738e;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.f71741h;
    }

    public void k(com.tencent.ams.xsad.rewarded.loader.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f71734a = aVar;
        }
    }

    public void l(Class<? extends RewardedAdPlayer> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) cls);
        } else {
            this.f71737d = cls;
        }
    }

    public void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.f71741h = z16;
        }
    }

    public void n(com.tencent.ams.xsad.rewarded.utils.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar);
        } else {
            this.f71736c = dVar;
        }
    }

    public void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        if (this.f71739f != i3) {
            this.f71739f = i3;
            a aVar = this.f71740g;
            if (aVar != null) {
                aVar.a(i3);
            }
        }
    }

    public void p(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar);
        } else {
            this.f71740g = aVar;
        }
    }

    public void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.f71738e = str;
        }
    }
}
