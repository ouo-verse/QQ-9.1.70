package com.tencent.mobileqq.activity.photo.album;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends com.tencent.mobileqq.activity.photo.album.albumlist.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f184204a;

    /* renamed from: b, reason: collision with root package name */
    public l f184205b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable.ConstantState f184206c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184205b = null;
        }
    }
}
