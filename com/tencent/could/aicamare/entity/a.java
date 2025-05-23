package com.tencent.could.aicamare.entity;

import android.graphics.Point;
import android.hardware.Camera;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public volatile Camera f99925a;

    /* renamed from: b, reason: collision with root package name */
    public int f99926b;

    /* renamed from: c, reason: collision with root package name */
    public int f99927c;

    /* renamed from: d, reason: collision with root package name */
    public Camera.Size f99928d;

    /* renamed from: e, reason: collision with root package name */
    public int f99929e;

    /* renamed from: f, reason: collision with root package name */
    public Point f99930f;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f99926b = 0;
        this.f99927c = 0;
        this.f99929e = 0;
    }
}
