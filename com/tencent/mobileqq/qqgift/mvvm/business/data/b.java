package com.tencent.mobileqq.qqgift.mvvm.business.data;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f264953a;

    /* renamed from: b, reason: collision with root package name */
    public int f264954b;

    /* renamed from: c, reason: collision with root package name */
    public int f264955c;

    /* renamed from: d, reason: collision with root package name */
    public int f264956d;

    /* renamed from: e, reason: collision with root package name */
    public int f264957e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f264958f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f264959g;

    /* renamed from: h, reason: collision with root package name */
    public float f264960h;

    /* renamed from: i, reason: collision with root package name */
    public int f264961i;

    /* renamed from: j, reason: collision with root package name */
    public int f264962j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f264963k;

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f264963k = false;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return getClass().getName() + "{bgColor=" + this.f264953a + ",contentColor=" + this.f264954b + ",subContentColor=" + this.f264955c + ",selectedColor=" + this.f264956d + ",tabColor=" + this.f264957e + ",isDark=" + this.f264958f + "}";
    }

    public b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        this.f264963k = false;
        this.f264958f = z16;
        this.f264953a = z16 ? -16777216 : -1;
        this.f264954b = z16 ? -1 : -16777216;
        this.f264955c = Color.parseColor(z16 ? "#80FFFFFF" : "#80000000");
        int parseColor = Color.parseColor(z16 ? "#4948F1" : "#00B5E2");
        this.f264956d = parseColor;
        this.f264962j = parseColor;
        this.f264957e = Color.parseColor(z16 ? "#A3FFFFFF" : "#66000000");
    }
}
