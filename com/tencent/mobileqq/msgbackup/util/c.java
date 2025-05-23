package com.tencent.mobileqq.msgbackup.util;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f251371a;

    /* renamed from: b, reason: collision with root package name */
    public int f251372b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f251373c;

    /* renamed from: d, reason: collision with root package name */
    public int f251374d;

    /* renamed from: e, reason: collision with root package name */
    public long f251375e;

    /* renamed from: f, reason: collision with root package name */
    public double f251376f;

    /* renamed from: g, reason: collision with root package name */
    public long f251377g;

    /* renamed from: h, reason: collision with root package name */
    public long f251378h;

    /* renamed from: i, reason: collision with root package name */
    public long f251379i;

    /* renamed from: j, reason: collision with root package name */
    public long f251380j;

    /* renamed from: k, reason: collision with root package name */
    public long f251381k;

    /* renamed from: l, reason: collision with root package name */
    public long f251382l;

    /* renamed from: m, reason: collision with root package name */
    public long f251383m;

    /* renamed from: n, reason: collision with root package name */
    public long f251384n;

    /* renamed from: o, reason: collision with root package name */
    public long f251385o;

    /* renamed from: p, reason: collision with root package name */
    public long f251386p;

    /* renamed from: q, reason: collision with root package name */
    public long f251387q;

    /* renamed from: r, reason: collision with root package name */
    public long f251388r;

    /* renamed from: s, reason: collision with root package name */
    public long f251389s;

    /* renamed from: t, reason: collision with root package name */
    public long f251390t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f251391u;

    /* renamed from: v, reason: collision with root package name */
    public int f251392v;

    /* renamed from: w, reason: collision with root package name */
    public long f251393w;

    /* renamed from: x, reason: collision with root package name */
    public long f251394x;

    /* renamed from: y, reason: collision with root package name */
    public long f251395y;

    /* renamed from: z, reason: collision with root package name */
    public ArrayList<a> f251396z;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f251397a;

        /* renamed from: b, reason: collision with root package name */
        public int f251398b;

        /* renamed from: c, reason: collision with root package name */
        public int f251399c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "[errorCode = " + this.f251397a + ", fileType = " + this.f251398b + ", fileTrivial = " + this.f251399c + "]";
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f251400a;

        /* renamed from: b, reason: collision with root package name */
        public long f251401b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f251396z = new ArrayList<>();
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f251371a = 0;
        this.f251372b = 0;
        this.f251373c = false;
        this.f251374d = 0;
        this.f251375e = 0L;
        this.f251376f = 0.0d;
        this.f251377g = 0L;
        this.f251378h = 0L;
        this.f251379i = 0L;
        this.f251380j = 0L;
        this.f251381k = 0L;
        this.f251382l = 0L;
        this.f251383m = 0L;
        this.f251384n = 0L;
        this.f251385o = 0L;
        this.f251386p = 0L;
        this.f251387q = 0L;
        this.f251388r = 0L;
        this.f251389s = 0L;
        this.f251390t = 0L;
        this.f251391u = false;
        this.f251392v = 0;
        this.f251393w = 0L;
        this.f251394x = 0L;
        this.f251395y = 0L;
        this.f251396z.clear();
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "[bizType = " + this.f251371a + "\n platForm = " + this.f251372b + "\n requestStatus = " + this.f251373c + "\n errorCode = " + this.f251374d + "\n totalCost = " + this.f251375e + "\n averageSpeed = " + this.f251376f + "\n totalSessionCount = " + this.f251377g + "\n finishedSessionCount = " + this.f251378h + "\n resSessionContains = " + this.f251379i + "\n resTotalSize = " + this.f251380j + "\n dbTotalSize = " + this.f251381k + "\n resRequestCount = " + this.f251382l + "\n resRequestFailedCount = " + this.f251383m + "\n resRequestCancelCount = " + this.f251384n + "\n resTrivialCount = " + this.f251385o + "\n resTrivialFailedCount = " + this.f251386p + "\n resTrivialCancelCount = " + this.f251387q + "\n dbRequestCount = " + this.f251388r + "\n dbRequestFailedCount = " + this.f251389s + "\n dbRequestCancelCount = " + this.f251390t + "\n connectType = " + this.f251392v + "\n connectElipse = " + this.f251393w + "\n sessionReadyAllTimes = " + this.f251394x + "\n fileFailedCount = " + this.f251395y + "\n fileErrorList = " + this.f251396z + "]";
    }
}
