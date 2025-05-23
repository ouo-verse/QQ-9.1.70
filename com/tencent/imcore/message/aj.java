package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class aj {
    static IPatchRedirector $redirector_;
    public boolean A;
    public boolean B;
    public long C;
    public long D;
    public long E;
    private Bundle F;

    /* renamed from: a, reason: collision with root package name */
    public Object f116523a;

    /* renamed from: b, reason: collision with root package name */
    public List<MessageRecord> f116524b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f116525c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f116526d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f116527e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f116528f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f116529g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f116530h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f116531i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f116532j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f116533k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f116534l;

    /* renamed from: m, reason: collision with root package name */
    public int f116535m;

    /* renamed from: n, reason: collision with root package name */
    public int f116536n;

    /* renamed from: o, reason: collision with root package name */
    public int f116537o;

    /* renamed from: p, reason: collision with root package name */
    public int f116538p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f116539q;

    /* renamed from: r, reason: collision with root package name */
    public int f116540r;

    /* renamed from: s, reason: collision with root package name */
    public String f116541s;

    /* renamed from: t, reason: collision with root package name */
    public int f116542t;

    /* renamed from: u, reason: collision with root package name */
    public int f116543u;

    /* renamed from: v, reason: collision with root package name */
    public volatile boolean f116544v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f116545w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f116546x;

    /* renamed from: y, reason: collision with root package name */
    long f116547y;

    /* renamed from: z, reason: collision with root package name */
    long f116548z;

    public aj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f116523a = null;
        this.f116524b = null;
        this.f116525c = false;
        this.f116526d = true;
        this.f116527e = false;
        this.f116528f = true;
        this.f116529g = false;
        this.f116530h = false;
        this.f116531i = true;
        this.f116532j = true;
        this.f116533k = false;
        this.f116534l = false;
        this.f116535m = 0;
        this.f116536n = 0;
        this.f116537o = 0;
        this.f116538p = 0;
        this.f116539q = false;
        this.f116540r = 0;
        this.f116545w = false;
        this.f116547y = Long.MAX_VALUE;
        this.f116548z = 0L;
        this.A = false;
        this.B = false;
    }

    public Bundle a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.F == null) {
            this.F = new Bundle();
        }
        return this.F;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "[isComplete = " + this.f116525c + ", isJoined = " + this.f116526d + ", isLocalOnly = " + this.f116527e + ", repullC2CMsgIndex = " + this.f116538p + ", canRepullC2CMsg = " + this.f116539q + ", needNotifyUI = " + this.f116531i + ", hasC2CMessage = " + this.f116546x + "]";
    }
}
