package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f294906a;

    /* renamed from: b, reason: collision with root package name */
    public int f294907b;

    /* renamed from: c, reason: collision with root package name */
    public int f294908c;

    /* renamed from: d, reason: collision with root package name */
    public int f294909d;

    /* renamed from: e, reason: collision with root package name */
    public List<Integer> f294910e;

    /* renamed from: f, reason: collision with root package name */
    public int f294911f;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
