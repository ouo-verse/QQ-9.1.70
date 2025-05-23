package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f258804a;

    /* renamed from: b, reason: collision with root package name */
    public String f258805b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f258806c;

    /* renamed from: d, reason: collision with root package name */
    public String f258807d;

    /* renamed from: e, reason: collision with root package name */
    public String f258808e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f258809f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f258810g;

    /* renamed from: h, reason: collision with root package name */
    public int f258811h;

    /* renamed from: i, reason: collision with root package name */
    public int f258812i;

    /* renamed from: j, reason: collision with root package name */
    public HashMap<String, String> f258813j;

    /* renamed from: k, reason: collision with root package name */
    public String f258814k;

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f258812i = 2000;
        }
    }
}
