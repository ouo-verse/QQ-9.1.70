package com.tencent.relation.common.widget.banner.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.relation.common.utils.j;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final int f364823a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f364824b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f364825c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f364826d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f364827e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f364828f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29894);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f364823a = j.a(5.0f);
        f364824b = j.a(7.0f);
        f364825c = j.a(5.0f);
        f364826d = j.a(5.0f);
        f364827e = j.a(3.0f);
        f364828f = j.a(3.0f);
    }
}
