package com.tencent.mobileqq.troop.onlinemember.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public List<b> f298037a;

    /* renamed from: b, reason: collision with root package name */
    public String f298038b;

    /* renamed from: c, reason: collision with root package name */
    public long f298039c;

    /* renamed from: d, reason: collision with root package name */
    public long f298040d;

    /* renamed from: e, reason: collision with root package name */
    public int f298041e;

    /* renamed from: f, reason: collision with root package name */
    public int f298042f;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
