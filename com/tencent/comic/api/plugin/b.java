package com.tencent.comic.api.plugin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface b {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final a f99255a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f99256a;

        /* renamed from: b, reason: collision with root package name */
        public int f99257b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f99258c;

        /* renamed from: d, reason: collision with root package name */
        public String f99259d;

        /* renamed from: e, reason: collision with root package name */
        public int f99260e;

        /* renamed from: f, reason: collision with root package name */
        public int f99261f;

        /* renamed from: g, reason: collision with root package name */
        public int f99262g;

        /* renamed from: h, reason: collision with root package name */
        public String f99263h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f99264i;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f99256a = null;
            this.f99257b = 256;
            this.f99258c = false;
            this.f99259d = null;
            this.f99260e = 0;
            this.f99261f = 0;
            this.f99262g = 0;
            this.f99263h = null;
            this.f99264i = false;
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(33777), (Class<?>) b.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            f99255a = new a();
        }
    }
}
