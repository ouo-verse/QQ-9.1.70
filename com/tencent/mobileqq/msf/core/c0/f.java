package com.tencent.mobileqq.msf.core.c0;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f247627a = "MsfAvReport";

    /* renamed from: b, reason: collision with root package name */
    public static final int f247628b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f247629c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f247630d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final int f247631e = 3;

    /* renamed from: f, reason: collision with root package name */
    public static final int f247632f = 4;

    /* renamed from: g, reason: collision with root package name */
    public static final int f247633g = 5;

    /* renamed from: h, reason: collision with root package name */
    public static final int f247634h = 6;

    /* renamed from: i, reason: collision with root package name */
    public static final int f247635i = 7;

    /* renamed from: j, reason: collision with root package name */
    public static final int f247636j = 8;

    /* renamed from: k, reason: collision with root package name */
    public static final int f247637k = 9;

    /* renamed from: l, reason: collision with root package name */
    public static final int f247638l = 10;

    /* renamed from: m, reason: collision with root package name */
    public static final int f247639m = 11;

    /* renamed from: n, reason: collision with root package name */
    public static final int f247640n = 12;

    /* renamed from: o, reason: collision with root package name */
    public static final int f247641o = 13;

    /* renamed from: p, reason: collision with root package name */
    public static final int f247642p = 14;

    /* renamed from: q, reason: collision with root package name */
    public static final int f247643q = 15;

    /* renamed from: r, reason: collision with root package name */
    public static final int f247644r = 16;

    /* renamed from: s, reason: collision with root package name */
    public static final int f247645s = 17;

    /* renamed from: t, reason: collision with root package name */
    public static final int f247646t = 18;

    /* renamed from: u, reason: collision with root package name */
    public static final int f247647u = 100;

    /* renamed from: v, reason: collision with root package name */
    static f f247648v;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final a f247649a;

        /* renamed from: b, reason: collision with root package name */
        public static final a f247650b;

        /* renamed from: c, reason: collision with root package name */
        public static final a f247651c;

        /* renamed from: d, reason: collision with root package name */
        public static final a f247652d;

        /* renamed from: e, reason: collision with root package name */
        public static final a f247653e;

        /* renamed from: f, reason: collision with root package name */
        public static final a f247654f;

        /* renamed from: g, reason: collision with root package name */
        public static final a f247655g;

        /* renamed from: h, reason: collision with root package name */
        public static final a f247656h;

        /* renamed from: i, reason: collision with root package name */
        public static final a f247657i;

        /* renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f247658j;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25450);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            a aVar = new a("eNone", 0);
            f247649a = aVar;
            a aVar2 = new a("eMSFRecvInviteMsg", 1);
            f247650b = aVar2;
            a aVar3 = new a("eMSFTransferInviteMsg", 2);
            f247651c = aVar3;
            a aVar4 = new a("eVideoServletCreate", 3);
            f247652d = aVar4;
            a aVar5 = new a("eVideoAddMsg", 4);
            f247653e = aVar5;
            a aVar6 = new a("eVideoMSFReceiverProcess", 5);
            f247654f = aVar6;
            a aVar7 = new a("eVideoRecvInviteMsg", 6);
            f247655g = aVar7;
            a aVar8 = new a("eVideoSendACK", 7);
            f247656h = aVar8;
            a aVar9 = new a("eMSFSendVideoACK", 8);
            f247657i = aVar9;
            f247658j = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9};
        }

        a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static a a(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f247658j.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20076);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(a aVar, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, aVar, bArr, Integer.valueOf(i3));
    }

    public static f a() {
        if (f247648v == null) {
            f247648v = new f();
        }
        return f247648v;
    }
}
