package com.tencent.mobileqq.confess;

import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.util.Pair;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f202166c;

    /* renamed from: a, reason: collision with root package name */
    ConcurrentHashMap<String, ConfessInfo> f202167a;

    /* renamed from: b, reason: collision with root package name */
    Pair<String, Boolean> f202168b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71307);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f202166c = new Object();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f202167a = new ConcurrentHashMap<>();
            this.f202168b = new Pair<>("", Boolean.FALSE);
        }
    }

    public ConfessInfo a(String str, int i3, int i16) {
        ConfessInfo confessInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ConfessInfo) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        String e16 = ao.e(str, i3, i16);
        synchronized (f202166c) {
            confessInfo = this.f202167a.get(e16);
        }
        return confessInfo;
    }
}
