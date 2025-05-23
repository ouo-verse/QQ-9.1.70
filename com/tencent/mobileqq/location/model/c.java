package com.tencent.mobileqq.location.model;

import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public LocationRoom.Venue f241304a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f241305b;

    /* renamed from: c, reason: collision with root package name */
    public int f241306c;

    /* renamed from: d, reason: collision with root package name */
    public int f241307d;

    /* renamed from: e, reason: collision with root package name */
    public int f241308e;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
