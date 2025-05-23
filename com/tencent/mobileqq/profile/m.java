package com.tencent.mobileqq.profile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static Integer f260245k;

    /* renamed from: l, reason: collision with root package name */
    public static Integer f260246l;

    /* renamed from: m, reason: collision with root package name */
    public static Integer f260247m;

    /* renamed from: n, reason: collision with root package name */
    public static Integer f260248n;

    /* renamed from: a, reason: collision with root package name */
    public Long f260249a;

    /* renamed from: b, reason: collision with root package name */
    public String f260250b;

    /* renamed from: c, reason: collision with root package name */
    public String f260251c;

    /* renamed from: d, reason: collision with root package name */
    public String f260252d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f260253e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f260254f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f260255g;

    /* renamed from: h, reason: collision with root package name */
    public String f260256h;

    /* renamed from: i, reason: collision with root package name */
    public Integer f260257i;

    /* renamed from: j, reason: collision with root package name */
    public Integer f260258j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73806);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f260245k = 1;
        f260246l = 2;
        f260247m = 3;
        f260248n = 4;
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f260255g = 0;
        this.f260257i = 0;
        this.f260258j = f260245k;
    }
}
