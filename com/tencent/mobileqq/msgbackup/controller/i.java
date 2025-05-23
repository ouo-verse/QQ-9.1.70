package com.tencent.mobileqq.msgbackup.controller;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public HashSet<com.tencent.mobileqq.msgbackup.data.j> f251073a;

    /* renamed from: b, reason: collision with root package name */
    public int f251074b;

    /* renamed from: c, reason: collision with root package name */
    public long f251075c;

    /* renamed from: d, reason: collision with root package name */
    public long f251076d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f251077e;

    /* renamed from: f, reason: collision with root package name */
    public int f251078f;

    /* renamed from: g, reason: collision with root package name */
    public int f251079g;

    /* renamed from: h, reason: collision with root package name */
    public c f251080h;

    /* renamed from: i, reason: collision with root package name */
    public String f251081i;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
