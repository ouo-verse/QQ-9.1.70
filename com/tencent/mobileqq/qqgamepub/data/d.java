package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public List<QQGameMsgInfo> f264504a;

    /* renamed from: b, reason: collision with root package name */
    public long f264505b;

    /* renamed from: c, reason: collision with root package name */
    public int f264506c;

    public d(List<QQGameMsgInfo> list, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        this.f264504a = list;
        this.f264505b = j3;
        this.f264506c = i3;
    }
}
