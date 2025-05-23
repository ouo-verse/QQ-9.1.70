package com.tencent.mobileqq.activity.recent.guidebanner;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final int f185591a;

    /* renamed from: b, reason: collision with root package name */
    final Drawable f185592b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f185593c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f185594d;

    a(int i3, Drawable drawable, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), drawable, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f185591a = i3;
        this.f185592b = drawable;
        this.f185593c = z16;
        this.f185594d = z17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Drawable drawable, boolean z16) {
        return new a(0, drawable, z16, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b() {
        return new a(2, null, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(boolean z16) {
        return new a(1, null, false, z16);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "NewerGuideBannerData{event=" + this.f185591a + ", drawable=" + this.f185592b + ", isVisibility=" + this.f185593c + ", isShowLoading=" + this.f185594d + '}';
    }
}
