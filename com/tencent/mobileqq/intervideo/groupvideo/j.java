package com.tencent.mobileqq.intervideo.groupvideo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f238218a;

    /* renamed from: b, reason: collision with root package name */
    public int f238219b;

    /* renamed from: c, reason: collision with root package name */
    public int f238220c;

    /* renamed from: d, reason: collision with root package name */
    public int f238221d;

    /* renamed from: e, reason: collision with root package name */
    public int f238222e;

    /* renamed from: f, reason: collision with root package name */
    public List<Long> f238223f;

    /* renamed from: g, reason: collision with root package name */
    public int f238224g;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
