package com.tencent.mobileqq.qrscan;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, String> f276771a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, String> f276772b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, String> f276773c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, String> f276774d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap<String, String> f276775e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, String> f276776f;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f276771a = new HashMap<>();
        this.f276776f = new HashMap<>();
        this.f276775e = new HashMap<>();
        this.f276774d = new HashMap<>();
        this.f276773c = new HashMap<>();
        this.f276772b = new HashMap<>();
        this.f276771a = new HashMap<>();
    }
}
