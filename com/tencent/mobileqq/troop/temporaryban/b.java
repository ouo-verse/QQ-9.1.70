package com.tencent.mobileqq.troop.temporaryban;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f299206a;

    /* renamed from: b, reason: collision with root package name */
    public String f299207b;

    /* renamed from: c, reason: collision with root package name */
    public List<a> f299208c;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f299206a = "";
        this.f299207b = "";
        this.f299208c = new ArrayList();
    }
}
