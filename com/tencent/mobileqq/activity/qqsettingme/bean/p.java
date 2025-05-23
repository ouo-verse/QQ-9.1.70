package com.tencent.mobileqq.activity.qqsettingme.bean;

import com.tencent.mobileqq.activity.qqsettingme.bo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f184940a;

    /* renamed from: b, reason: collision with root package name */
    public String f184941b;

    /* renamed from: c, reason: collision with root package name */
    public int f184942c;

    /* renamed from: d, reason: collision with root package name */
    public String f184943d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f184944e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f184945f;

    /* renamed from: g, reason: collision with root package name */
    public int f184946g;

    /* renamed from: h, reason: collision with root package name */
    public String f184947h;

    /* renamed from: i, reason: collision with root package name */
    public String f184948i;

    /* renamed from: j, reason: collision with root package name */
    public List<bo> f184949j;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184949j = new ArrayList();
        }
    }
}
