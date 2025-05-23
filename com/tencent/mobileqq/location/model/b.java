package com.tencent.mobileqq.location.model;

import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public LocationRoom.b f241301a;

    /* renamed from: b, reason: collision with root package name */
    public LocationRoom.Venue f241302b;

    /* renamed from: c, reason: collision with root package name */
    public List<com.tencent.mobileqq.location.data.a> f241303c;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
