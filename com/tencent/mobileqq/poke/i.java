package com.tencent.mobileqq.poke;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f259066a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f259067b;

    /* renamed from: c, reason: collision with root package name */
    public int f259068c;

    /* renamed from: d, reason: collision with root package name */
    public String f259069d;

    /* renamed from: e, reason: collision with root package name */
    public String f259070e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f259071f;

    /* renamed from: g, reason: collision with root package name */
    public int f259072g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f259073h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f259074i;

    /* renamed from: j, reason: collision with root package name */
    public String f259075j;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
