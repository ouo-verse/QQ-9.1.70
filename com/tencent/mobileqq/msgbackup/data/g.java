package com.tencent.mobileqq.msgbackup.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f251132a;

    /* renamed from: b, reason: collision with root package name */
    private String f251133b;

    /* renamed from: c, reason: collision with root package name */
    private String f251134c;

    /* renamed from: d, reason: collision with root package name */
    private MsgBackupUserData f251135d;

    /* renamed from: e, reason: collision with root package name */
    private int f251136e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f251137a;

        /* renamed from: b, reason: collision with root package name */
        private String f251138b;

        /* renamed from: c, reason: collision with root package name */
        private String f251139c;

        /* renamed from: d, reason: collision with root package name */
        private MsgBackupUserData f251140d;

        /* renamed from: e, reason: collision with root package name */
        private int f251141e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public g a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (g) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return new g(this.f251137a, this.f251138b, this.f251139c, this.f251140d, this.f251141e);
        }

        public a b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.f251141e = i3;
            return this;
        }

        public a c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f251139c = str;
            return this;
        }

        public a d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.f251137a = i3;
            return this;
        }

        public a e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f251138b = str;
            return this;
        }

        public a f(MsgBackupUserData msgBackupUserData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgBackupUserData);
            }
            this.f251140d = msgBackupUserData;
            return this;
        }
    }

    public g(int i3, String str, String str2, MsgBackupUserData msgBackupUserData, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, msgBackupUserData, Integer.valueOf(i16));
            return;
        }
        this.f251132a = i3;
        this.f251133b = str;
        this.f251134c = str2;
        this.f251135d = msgBackupUserData;
        this.f251136e = i16;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f251136e;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f251134c;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f251132a;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f251133b;
    }

    public MsgBackupUserData e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MsgBackupUserData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f251135d;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "--MsgBackupQryStateRsp--,state:" + this.f251132a + ",token:" + this.f251133b + ",encryptKey:" + this.f251134c + ",userData:" + this.f251135d + ",bizType:" + this.f251136e;
    }
}
