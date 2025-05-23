package com.tencent.mobileqq.banner;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f200241a;

    /* renamed from: b, reason: collision with root package name */
    public int f200242b;

    /* renamed from: c, reason: collision with root package name */
    public View f200243c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f200244d;

    public a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f200241a = i3;
            this.f200242b = i16;
        }
    }

    public static boolean b(int i3) {
        if (i3 >= 2) {
            return true;
        }
        return false;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f200242b >= 2) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append("[");
        stringBuffer.append(this.f200241a);
        stringBuffer.append(",");
        stringBuffer.append(this.f200242b);
        stringBuffer.append(",");
        stringBuffer.append(this.f200244d);
        stringBuffer.append(",");
        stringBuffer.append(this.f200243c);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
