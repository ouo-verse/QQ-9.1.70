package com.tencent.mobileqq.activity.photo.album.photolist;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: t, reason: collision with root package name */
    public static int f184288t;

    /* renamed from: u, reason: collision with root package name */
    public static Map<String, LocalMediaInfo> f184289u;

    /* renamed from: a, reason: collision with root package name */
    public boolean f184290a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f184291b;

    /* renamed from: c, reason: collision with root package name */
    public String f184292c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f184293d;

    /* renamed from: e, reason: collision with root package name */
    public int f184294e;

    /* renamed from: f, reason: collision with root package name */
    public int f184295f;

    /* renamed from: g, reason: collision with root package name */
    public LocalMediaInfo f184296g;

    /* renamed from: h, reason: collision with root package name */
    public int f184297h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f184298i;

    /* renamed from: j, reason: collision with root package name */
    public long f184299j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f184300k;

    /* renamed from: l, reason: collision with root package name */
    public int f184301l;

    /* renamed from: m, reason: collision with root package name */
    public String f184302m;

    /* renamed from: n, reason: collision with root package name */
    public volatile AtomicBoolean f184303n;

    /* renamed from: o, reason: collision with root package name */
    public int f184304o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f184305p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f184306q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f184307r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f184308s;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14745);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f184288t = -1;
            f184289u = new HashMap();
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184290a = true;
        this.f184291b = false;
        this.f184293d = false;
        this.f184294e = 0;
        this.f184295f = 0;
        this.f184296g = null;
        this.f184298i = true;
        this.f184300k = false;
        this.f184301l = 0;
        this.f184302m = null;
        this.f184303n = new AtomicBoolean(false);
        this.f184304o = 3;
        this.f184305p = false;
        this.f184306q = false;
        this.f184307r = false;
    }
}
