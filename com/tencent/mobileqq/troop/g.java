package com.tencent.mobileqq.troop;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public String f296167a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public String f296168b;

    /* renamed from: c, reason: collision with root package name */
    public int f296169c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public String f296170d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public String f296171e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f296172f;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f296167a = "";
        this.f296168b = "";
        this.f296169c = -1;
        this.f296170d = "";
        this.f296171e = "";
        this.f296172f = false;
    }
}
