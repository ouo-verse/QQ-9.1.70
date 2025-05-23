package com.tencent.mobileqq.uniformdownload.data;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f305878a;

    /* renamed from: b, reason: collision with root package name */
    public String f305879b;

    /* renamed from: c, reason: collision with root package name */
    public String f305880c;

    /* renamed from: d, reason: collision with root package name */
    public long f305881d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f305882e;

    /* renamed from: f, reason: collision with root package name */
    public Bundle f305883f;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
