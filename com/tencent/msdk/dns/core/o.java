package com.tencent.msdk.dns.core;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.i.a;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class o<LookupExtra extends i.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Context f336286a;

    /* renamed from: b, reason: collision with root package name */
    public final String f336287b;

    /* renamed from: c, reason: collision with root package name */
    public final int f336288c;

    /* renamed from: d, reason: collision with root package name */
    public final String f336289d;

    /* renamed from: e, reason: collision with root package name */
    public final LookupExtra f336290e;

    /* renamed from: f, reason: collision with root package name */
    public final String f336291f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f336292g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f336293h;

    /* renamed from: i, reason: collision with root package name */
    public final int f336294i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f336295j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f336296k;

    /* renamed from: l, reason: collision with root package name */
    public final int f336297l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f336298m;

    /* synthetic */ o(Context context, String str, int i3, String str2, i.a aVar, String str3, boolean z16, boolean z17, int i16, boolean z18, boolean z19, int i17, boolean z26, a aVar2) {
        this(context, str, i3, str2, aVar, str3, z16, z17, i16, z18, z19, i17, z26);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, str, Integer.valueOf(i3), str2, aVar, str3, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16), Boolean.valueOf(z18), Boolean.valueOf(z19), Integer.valueOf(i17), Boolean.valueOf(z26), aVar2);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f336288c == oVar.f336288c && this.f336292g == oVar.f336292g && this.f336293h == oVar.f336293h && this.f336294i == oVar.f336294i && this.f336295j == oVar.f336295j && this.f336296k == oVar.f336296k && this.f336297l == oVar.f336297l && this.f336298m == oVar.f336298m && com.tencent.msdk.dns.c.e.a.e(this.f336286a, oVar.f336286a) && com.tencent.msdk.dns.c.e.a.e(this.f336287b, oVar.f336287b) && com.tencent.msdk.dns.c.e.a.e(this.f336289d, oVar.f336289d) && com.tencent.msdk.dns.c.e.a.e(this.f336290e, oVar.f336290e) && com.tencent.msdk.dns.c.e.a.e(this.f336291f, oVar.f336291f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return com.tencent.msdk.dns.c.e.a.a(this.f336286a, this.f336287b, Integer.valueOf(this.f336288c), this.f336289d, this.f336290e, this.f336291f, Boolean.valueOf(this.f336292g), Boolean.valueOf(this.f336293h), Integer.valueOf(this.f336294i), Boolean.valueOf(this.f336295j), Boolean.valueOf(this.f336296k), Integer.valueOf(this.f336297l), Boolean.valueOf(this.f336298m));
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "LookupParameters{appContext=" + this.f336286a + ", hostname='" + this.f336287b + "', timeoutMills=" + this.f336288c + ", dnsIp=" + this.f336289d + ", lookupExtra=" + this.f336290e + ", channel='" + this.f336291f + "', fallback2Local=" + this.f336292g + ", blockFirst=" + this.f336293h + ", family=" + this.f336294i + ", ignoreCurNetStack=" + this.f336295j + ", enableAsyncLookup=" + this.f336296k + ", curRetryTime=" + this.f336297l + ", netChangeLookup=" + this.f336298m + '}';
    }

    o(Context context, String str, int i3, String str2, LookupExtra lookupextra, String str3, boolean z16, boolean z17, int i16, boolean z18, boolean z19, int i17, boolean z26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Integer.valueOf(i3), str2, lookupextra, str3, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16), Boolean.valueOf(z18), Boolean.valueOf(z19), Integer.valueOf(i17), Boolean.valueOf(z26));
            return;
        }
        this.f336286a = context;
        this.f336287b = str;
        this.f336288c = i3;
        this.f336289d = str2;
        this.f336290e = lookupextra;
        this.f336291f = str3;
        this.f336292g = z16;
        this.f336293h = z17;
        this.f336294i = i16;
        this.f336295j = z18;
        this.f336296k = z19;
        this.f336297l = i17;
        this.f336298m = z26;
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class b<LookupExtra extends i.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Context f336299a;

        /* renamed from: b, reason: collision with root package name */
        private String f336300b;

        /* renamed from: c, reason: collision with root package name */
        private int f336301c;

        /* renamed from: d, reason: collision with root package name */
        private String f336302d;

        /* renamed from: e, reason: collision with root package name */
        private LookupExtra f336303e;

        /* renamed from: f, reason: collision with root package name */
        private String f336304f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f336305g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f336306h;

        /* renamed from: i, reason: collision with root package name */
        private int f336307i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f336308j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f336309k;

        /* renamed from: l, reason: collision with root package name */
        private int f336310l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f336311m;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f336301c = -1;
            this.f336305g = true;
            this.f336306h = false;
            this.f336307i = 3;
            this.f336308j = false;
            this.f336309k = false;
            this.f336310l = 0;
            this.f336311m = false;
        }

        public b<LookupExtra> a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (b) iPatchRedirector.redirect((short) 14, (Object) this, i3);
            }
            if (i3 >= 0) {
                this.f336310l = i3;
                return this;
            }
            throw new IllegalArgumentException("curRetryTime".concat(" can not less than 0"));
        }

        public b<LookupExtra> b(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            }
            if (context != null) {
                this.f336299a = context.getApplicationContext();
                return this;
            }
            throw new IllegalArgumentException("context".concat(" can not be null"));
        }

        public b<LookupExtra> c(LookupExtra lookupextra) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) lookupextra);
            }
            if (lookupextra != null) {
                this.f336303e = lookupextra;
                return this;
            }
            throw new IllegalArgumentException("lookupExtra".concat(" can not be null"));
        }

        public b<LookupExtra> d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f336304f = str;
                return this;
            }
            throw new IllegalArgumentException(WadlProxyConsts.CHANNEL.concat(" can not be empty"));
        }

        public b<LookupExtra> e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (b) iPatchRedirector.redirect((short) 10, (Object) this, z16);
            }
            this.f336306h = z16;
            return this;
        }

        public o<LookupExtra> f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (o) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            Context context = this.f336299a;
            if (context != null) {
                String str = this.f336300b;
                if (str != null) {
                    int i3 = this.f336301c;
                    if (-1 != i3) {
                        String str2 = this.f336302d;
                        if (str2 != null) {
                            LookupExtra lookupextra = this.f336303e;
                            if (lookupextra != null) {
                                String str3 = this.f336304f;
                                if (str3 != null) {
                                    return new o<>(context, str, i3, str2, lookupextra, str3, this.f336305g, this.f336306h, this.f336307i, this.f336308j, this.f336309k, this.f336310l, this.f336311m, null);
                                }
                                throw new IllegalStateException("mChannel".concat(" is not initialized yet"));
                            }
                            throw new IllegalStateException("mLookupExtra".concat(" is not initialized yet"));
                        }
                        throw new IllegalStateException("mDnsIp".concat(" is not initialized yet"));
                    }
                    throw new IllegalStateException("mTimeoutMills".concat(" is not initialized yet"));
                }
                throw new IllegalStateException("mHostname".concat(" is not initialized yet"));
            }
            throw new IllegalStateException("mAppContext".concat(" is not initialized yet"));
        }

        public b<LookupExtra> g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (b) iPatchRedirector.redirect((short) 11, (Object) this, i3);
            }
            if (!f.a(i3)) {
                this.f336307i = i3;
                return this;
            }
            throw new IllegalArgumentException(IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY.concat(" is invalid"));
        }

        public b<LookupExtra> h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f336302d = str;
                return this;
            }
            throw new IllegalArgumentException("dnsIp".concat(" can not be empty"));
        }

        public b<LookupExtra> i(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (b) iPatchRedirector.redirect((short) 13, (Object) this, z16);
            }
            this.f336309k = z16;
            return this;
        }

        public b<LookupExtra> j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (b) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            if (i3 > 0) {
                this.f336301c = i3;
                return this;
            }
            throw new IllegalArgumentException("timeoutMills".concat(" can not less than 0"));
        }

        public b<LookupExtra> k(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f336300b = str;
                return this;
            }
            throw new IllegalArgumentException("hostname".concat(" can not be empty"));
        }

        public b<LookupExtra> l(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (b) iPatchRedirector.redirect((short) 9, (Object) this, z16);
            }
            this.f336305g = z16;
            return this;
        }

        public b<LookupExtra> m(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (b) iPatchRedirector.redirect((short) 12, (Object) this, z16);
            }
            this.f336308j = z16;
            return this;
        }

        public b<LookupExtra> n(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (b) iPatchRedirector.redirect((short) 15, (Object) this, z16);
            }
            this.f336311m = z16;
            return this;
        }

        public b(o<LookupExtra> oVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) oVar);
                return;
            }
            this.f336301c = -1;
            this.f336305g = true;
            this.f336306h = false;
            this.f336307i = 3;
            this.f336308j = false;
            this.f336309k = false;
            this.f336310l = 0;
            this.f336311m = false;
            this.f336299a = oVar.f336286a;
            this.f336300b = oVar.f336287b;
            this.f336301c = oVar.f336288c;
            this.f336302d = oVar.f336289d;
            this.f336303e = oVar.f336290e;
            this.f336304f = oVar.f336291f;
            this.f336305g = oVar.f336292g;
            this.f336306h = oVar.f336293h;
            this.f336307i = oVar.f336294i;
            this.f336308j = oVar.f336295j;
            this.f336309k = oVar.f336296k;
            this.f336310l = oVar.f336297l;
            this.f336311m = oVar.f336298m;
        }
    }
}
