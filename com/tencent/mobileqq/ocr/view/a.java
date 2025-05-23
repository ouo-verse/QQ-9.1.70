package com.tencent.mobileqq.ocr.view;

import android.graphics.Point;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public List<Point> f254925a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f254926b;

    /* renamed from: c, reason: collision with root package name */
    public int f254927c;

    /* renamed from: d, reason: collision with root package name */
    public int f254928d;

    /* renamed from: e, reason: collision with root package name */
    public int f254929e;

    /* renamed from: f, reason: collision with root package name */
    public int f254930f;

    /* renamed from: g, reason: collision with root package name */
    public int f254931g;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f254925a = new ArrayList();
        this.f254926b = false;
        this.f254927c = 0;
        this.f254928d = Integer.MIN_VALUE;
        this.f254929e = Integer.MIN_VALUE;
        this.f254930f = Integer.MAX_VALUE;
        this.f254931g = Integer.MAX_VALUE;
    }
}
