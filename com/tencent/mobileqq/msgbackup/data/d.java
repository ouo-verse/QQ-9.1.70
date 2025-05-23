package com.tencent.mobileqq.msgbackup.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f251118a;

    /* renamed from: b, reason: collision with root package name */
    private String f251119b;

    /* renamed from: c, reason: collision with root package name */
    private String f251120c;

    /* renamed from: d, reason: collision with root package name */
    private MsgBackupUserData f251121d;

    /* renamed from: e, reason: collision with root package name */
    private int f251122e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f251123a;

        /* renamed from: b, reason: collision with root package name */
        private String f251124b;

        /* renamed from: c, reason: collision with root package name */
        private String f251125c;

        /* renamed from: d, reason: collision with root package name */
        private MsgBackupUserData f251126d;

        /* renamed from: e, reason: collision with root package name */
        private int f251127e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public d a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (d) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return new d(this.f251123a, this.f251124b, this.f251125c, this.f251126d, this.f251127e);
        }

        public a b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.f251127e = i3;
            return this;
        }

        public a c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f251125c = str;
            return this;
        }

        public a d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f251123a = str;
            return this;
        }

        public a e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f251124b = str;
            return this;
        }

        public a f(MsgBackupUserData msgBackupUserData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgBackupUserData);
            }
            this.f251126d = msgBackupUserData;
            return this;
        }
    }

    public d(String str, String str2, String str3, MsgBackupUserData msgBackupUserData, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, msgBackupUserData, Integer.valueOf(i3));
            return;
        }
        this.f251118a = str;
        this.f251119b = str2;
        this.f251120c = str3;
        this.f251121d = msgBackupUserData;
        this.f251122e = i3;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f251122e;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f251120c;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f251118a;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f251119b;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "--MsgBackupGetQrRsp--,qr_sig:" + this.f251118a + ",token:" + this.f251119b + ",encryptKey:" + this.f251120c + ",userData:" + this.f251121d + ",bizType:" + this.f251122e;
    }
}
