package com.tencent.mobileqq.activity.qqsettingme.bean;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f184928a;

    /* renamed from: b, reason: collision with root package name */
    public String f184929b;

    /* renamed from: c, reason: collision with root package name */
    public String f184930c;

    /* renamed from: d, reason: collision with root package name */
    public String f184931d;

    /* renamed from: e, reason: collision with root package name */
    public String f184932e;

    /* renamed from: f, reason: collision with root package name */
    public String f184933f;

    /* renamed from: g, reason: collision with root package name */
    public Bitmap f184934g;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
