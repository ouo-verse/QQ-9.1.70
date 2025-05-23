package com.tencent.mobileqq.startup;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f289660a;

    /* renamed from: b, reason: collision with root package name */
    public static long f289661b;

    /* renamed from: c, reason: collision with root package name */
    public static long f289662c;

    /* renamed from: d, reason: collision with root package name */
    public static long f289663d;

    /* renamed from: e, reason: collision with root package name */
    public static long f289664e;

    /* renamed from: f, reason: collision with root package name */
    public static long f289665f;

    /* renamed from: g, reason: collision with root package name */
    public static long f289666g;

    /* renamed from: h, reason: collision with root package name */
    public static long f289667h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f289668i;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f289669j;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f289670k;

    /* renamed from: l, reason: collision with root package name */
    public static long f289671l;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f289672m;

    /* renamed from: n, reason: collision with root package name */
    public static long f289673n;

    /* renamed from: o, reason: collision with root package name */
    public static long f289674o;

    /* renamed from: p, reason: collision with root package name */
    public static long f289675p;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f289676q;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f289677r;

    /* renamed from: s, reason: collision with root package name */
    public static long f289678s;

    /* renamed from: t, reason: collision with root package name */
    public static long f289679t;

    /* renamed from: u, reason: collision with root package name */
    public static long f289680u;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40681);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f289660a = 2000;
        f289661b = 0L;
        f289662c = 0L;
        f289663d = 0L;
        f289664e = 0L;
        f289665f = -1L;
        f289666g = -1L;
        f289667h = 0L;
        f289668i = false;
        f289669j = false;
        f289670k = false;
        f289671l = -1L;
        f289672m = false;
        f289673n = -1L;
        f289674o = -1L;
        f289675p = -1L;
        f289677r = false;
        f289678s = 0L;
        f289679t = 0L;
        f289680u = 0L;
    }
}
