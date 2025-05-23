package com.tencent.mobileqq.voicechange;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f313145a;

    /* renamed from: b, reason: collision with root package name */
    public String f313146b;

    /* renamed from: c, reason: collision with root package name */
    public String f313147c;

    /* renamed from: d, reason: collision with root package name */
    public int f313148d;

    /* renamed from: e, reason: collision with root package name */
    public int f313149e;

    /* renamed from: f, reason: collision with root package name */
    public int f313150f;

    /* renamed from: g, reason: collision with root package name */
    public a f313151g;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f313152a;

        /* renamed from: b, reason: collision with root package name */
        public String f313153b;

        /* renamed from: c, reason: collision with root package name */
        public int f313154c;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f313155d;

        public a(int i3, String str, String str2, Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, drawable);
                return;
            }
            this.f313154c = i3;
            this.f313152a = str;
            this.f313153b = str2;
            this.f313155d = drawable;
        }
    }

    public c(int i3, String str, String str2, int i16, int i17, int i18, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), aVar);
            return;
        }
        this.f313145a = i3;
        this.f313146b = str;
        this.f313147c = str2;
        this.f313149e = i16;
        this.f313148d = i17;
        this.f313150f = i18;
        this.f313151g = aVar;
    }
}
