package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f258654a;

        /* renamed from: b, reason: collision with root package name */
        public int f258655b;

        /* renamed from: c, reason: collision with root package name */
        public String f258656c;

        /* renamed from: d, reason: collision with root package name */
        public m.a f258657d;

        /* renamed from: e, reason: collision with root package name */
        public String f258658e;

        /* renamed from: f, reason: collision with root package name */
        public byte[] f258659f;

        /* renamed from: g, reason: collision with root package name */
        public String f258660g;

        /* renamed from: h, reason: collision with root package name */
        public int f258661h;

        /* renamed from: i, reason: collision with root package name */
        public int f258662i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f258663j;

        /* renamed from: k, reason: collision with root package name */
        public String f258664k;

        /* renamed from: l, reason: collision with root package name */
        public long f258665l;

        /* renamed from: m, reason: collision with root package name */
        public String f258666m;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    void a(int i3, boolean z16);

    void h(a aVar);
}
