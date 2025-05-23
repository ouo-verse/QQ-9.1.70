package com.tencent.halley;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@NotProguard
/* loaded from: classes6.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f113563a;

    /* renamed from: b, reason: collision with root package name */
    private Context f113564b;

    /* renamed from: c, reason: collision with root package name */
    private int f113565c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f113566d;

    /* renamed from: e, reason: collision with root package name */
    private String f113567e;

    /* renamed from: f, reason: collision with root package name */
    private String f113568f;

    /* renamed from: g, reason: collision with root package name */
    private String f113569g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f113570h;

    /* renamed from: i, reason: collision with root package name */
    private a f113571i;

    /* compiled from: P */
    @NotProguard
    /* loaded from: classes6.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f113572a;

        /* renamed from: b, reason: collision with root package name */
        private String f113573b;

        /* renamed from: c, reason: collision with root package name */
        private String f113574c;

        public a(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3);
                return;
            }
            this.f113572a = str;
            this.f113573b = str2;
            this.f113574c = str3;
        }
    }

    public d(Context context, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), str, str2);
            return;
        }
        this.f113563a = false;
        this.f113567e = "";
        this.f113568f = "";
        this.f113569g = "0M100WJ33N1CQ08O";
        this.f113570h = false;
        i(context, i3, true, str, str2, new a("-1", "-1", "-1"));
    }

    private void i(Context context, int i3, boolean z16, String str, String str2, a aVar) {
        this.f113564b = context.getApplicationContext();
        this.f113565c = i3;
        this.f113566d = z16;
        this.f113567e = str;
        this.f113568f = str2;
        this.f113571i = aVar;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f113565c;
    }

    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f113569g;
    }

    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f113568f;
    }

    public final Context d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Context) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f113564b;
    }

    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (!TextUtils.isEmpty(this.f113571i.f113573b)) {
            return this.f113571i.f113573b;
        }
        return "-1";
    }

    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (!TextUtils.isEmpty(this.f113571i.f113574c)) {
            return this.f113571i.f113574c;
        }
        return "-1";
    }

    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (!TextUtils.isEmpty(this.f113571i.f113572a)) {
            return this.f113571i.f113572a;
        }
        return "-1";
    }

    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f113567e;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f113566d;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f113570h;
    }

    public final String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "[,channelid:" + this.f113568f + ",isSDKMode:" + this.f113566d + ",isTest:" + this.f113570h + ",maskDeviceInfo:" + this.f113563a + ",httpDnsAppKey:" + this.f113571i.f113572a + ",dnsId:" + this.f113571i.f113573b + ",dnsKey:" + this.f113571i.f113574c + "]";
    }

    public d(Context context, int i3, String str, String str2, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), str, str2, aVar);
            return;
        }
        this.f113563a = false;
        this.f113567e = "";
        this.f113568f = "";
        this.f113569g = "0M100WJ33N1CQ08O";
        this.f113570h = false;
        i(context, i3, true, str, str2, aVar);
    }
}
