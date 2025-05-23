package com.tencent.mobileqq.qqaudio.audioplayer;

import android.media.AudioManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.audioplayer.f;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f262178a;

    /* renamed from: b, reason: collision with root package name */
    protected volatile boolean f262179b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f262180c;

    /* renamed from: d, reason: collision with root package name */
    protected volatile boolean f262181d;

    /* renamed from: e, reason: collision with root package name */
    protected volatile boolean f262182e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f262183f;

    /* renamed from: g, reason: collision with root package name */
    protected volatile a f262184g;

    /* renamed from: h, reason: collision with root package name */
    f.a[] f262185h;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f262186a;

        /* renamed from: b, reason: collision with root package name */
        f.a f262187b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f262188c;

        public a(f.a aVar, int i3) {
            this(aVar, i3, false);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, i3);
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f262186a;
        }

        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.f262188c;
        }

        public f.a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (f.a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f262187b;
        }

        public boolean d(a aVar) {
            f.a aVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar)).booleanValue();
            }
            if (aVar != null && (aVar2 = this.f262187b) != null) {
                return aVar2.equals(aVar.f262187b);
            }
            return false;
        }

        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else if (this.f262188c) {
                this.f262188c = false;
            }
        }

        public a(f.a aVar, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, aVar, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            this.f262187b = aVar;
            this.f262188c = z16;
            this.f262186a = i3;
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f262178a = true;
        this.f262179b = false;
        this.f262180c = false;
        this.f262181d = false;
        this.f262182e = false;
        this.f262183f = false;
        this.f262184g = null;
    }

    private f.a g(int i3) {
        if (this.f262185h == null) {
            this.f262185h = f.a();
        }
        f.a[] aVarArr = this.f262185h;
        f.a aVar = aVarArr[0];
        if (i3 >= 0 && i3 < aVarArr.length) {
            return aVarArr[i3];
        }
        return aVar;
    }

    public void a(AudioManager audioManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) audioManager);
            return;
        }
        l("doOnBluetoothSCODisconnected isBluetoothA2dpOn = " + audioManager.isBluetoothA2dpOn());
        if (this.f262180c && !audioManager.isBluetoothA2dpOn()) {
            this.f262180c = false;
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f262180c;
    }

    public a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (this.f262184g == null) {
            new a(g(0), 0);
        }
        return this.f262184g;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f262184g.f262186a;
    }

    public f.a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (f.a) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (this.f262184g != null && this.f262184g.c() != null) {
            l("getCurrentProperParam");
            return this.f262184g.c();
        }
        return g(0);
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f262181d;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f262178a;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f262179b;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f262184g = new a(g(0), 0);
        this.f262179b = c.f(BaseApplication.getContext());
        this.f262180c = c.c(BaseApplication.getContext());
        this.f262178a = c.b(MobileQQ.sMobileQQ.waitAppRuntime(null));
        this.f262182e = c.e(BaseApplication.getContext());
        t();
        l("init ");
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (!this.f262183f) {
            r(c.e(BaseApplication.getContext()));
            this.f262183f = true;
        }
    }

    public void l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            if (!StringUtil.isEmpty(str)) {
                sb5.append(str);
            }
            sb5.append("\n mCurDeviceStatus = " + this.f262184g.f262186a);
            sb5.append("\n  userLoudSpeakerStatus = " + this.f262178a);
            sb5.append("\n  mNearToEar = " + this.f262181d);
            sb5.append("\n  wiredHeadsetConnect = " + this.f262179b);
            sb5.append("\n  blueHeadsetConnect = " + this.f262180c);
            sb5.append("\n  mblueHeadsetSCOConnect = " + this.f262182e);
            QLog.d("AudioPlayer_DeviceStatus", 2, sb5.toString());
        }
    }

    public a m(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (a) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 == 8 || i3 == 16) {
                        n(z16);
                    }
                } else {
                    q(z16);
                }
            } else {
                o(z16);
            }
        } else {
            p(z16);
        }
        l("onAudioDeviceStatusChanged changeType = " + i3 + "|" + z16);
        return this.f262184g;
    }

    protected void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        this.f262180c = c.c(BaseApplication.getContext());
        this.f262182e = c.e(BaseApplication.getContext());
        t();
    }

    protected void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        if (this.f262181d != z16) {
            this.f262181d = z16;
        }
        t();
    }

    protected void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.f262178a = z16;
            t();
        }
    }

    protected void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.f262179b = z16;
            t();
        }
    }

    public void r(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.f262182e = z16;
            t();
        }
    }

    public int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return 31;
    }

    protected void t() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        a c16 = c();
        if (c.f262173b && this.f262182e) {
            i3 = 4;
        } else if (this.f262179b) {
            i3 = 2;
        } else {
            this.f262180c = c.c(BaseApplication.getContext());
            if (this.f262180c) {
                i3 = 3;
            } else if (this.f262178a && !this.f262181d) {
                i3 = 0;
            } else {
                i3 = 1;
            }
        }
        if (c16 == null) {
            return;
        }
        a aVar = new a(g(i3), i3, true);
        if (!c16.d(aVar)) {
            this.f262184g = aVar;
        }
        l("updateCurrentStatus end nextStatusType = " + i3);
    }
}
