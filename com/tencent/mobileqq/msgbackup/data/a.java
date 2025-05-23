package com.tencent.mobileqq.msgbackup.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f251109a;

    /* renamed from: b, reason: collision with root package name */
    private String f251110b;

    /* renamed from: c, reason: collision with root package name */
    private MsgBackupUserData f251111c;

    /* renamed from: d, reason: collision with root package name */
    private int f251112d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msgbackup.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8110a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f251113a;

        /* renamed from: b, reason: collision with root package name */
        private String f251114b;

        /* renamed from: c, reason: collision with root package name */
        private MsgBackupUserData f251115c;

        /* renamed from: d, reason: collision with root package name */
        private int f251116d;

        public C8110a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return new a(this.f251113a, this.f251114b, this.f251115c, this.f251116d);
        }

        public C8110a b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (C8110a) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.f251116d = i3;
            return this;
        }

        public C8110a c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (C8110a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f251114b = str;
            return this;
        }

        public C8110a d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C8110a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f251113a = str;
            return this;
        }

        public C8110a e(MsgBackupUserData msgBackupUserData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C8110a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgBackupUserData);
            }
            this.f251115c = msgBackupUserData;
            return this;
        }
    }

    public a(String str, String str2, MsgBackupUserData msgBackupUserData, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, msgBackupUserData, Integer.valueOf(i3));
            return;
        }
        this.f251109a = str;
        this.f251110b = str2;
        this.f251111c = msgBackupUserData;
        this.f251112d = i3;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f251112d;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f251110b;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f251109a;
    }

    public MsgBackupUserData d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MsgBackupUserData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f251111c;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "--MsgBackupConfirmQrRsp--,token:" + this.f251109a + ",encryptKey:" + this.f251110b + ",userData:" + this.f251111c + ",bizType:" + this.f251112d;
    }
}
