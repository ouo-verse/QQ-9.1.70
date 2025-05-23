package com.tencent.mobileqq.lyric.data;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f243155a;

    /* renamed from: b, reason: collision with root package name */
    public int f243156b;

    /* renamed from: c, reason: collision with root package name */
    public int f243157c;

    /* renamed from: d, reason: collision with root package name */
    public int f243158d;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f243156b = 1;
            this.f243157c = Color.parseColor("#FFFF0000");
        }
    }
}
