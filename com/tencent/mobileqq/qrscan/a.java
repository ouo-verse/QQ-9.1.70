package com.tencent.mobileqq.qrscan;

import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f276531a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f276532b;

    /* renamed from: c, reason: collision with root package name */
    public float f276533c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f276532b = new Rect();
        }
    }

    public static String a(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "";
                }
                return "CLASS_FOR_WEIXINCODE";
            }
            return "CLASS_FOR_MINICODE";
        }
        return "CLASS_FOR_QRCODE";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return String.format("AIRect[%s,%.2f,%s]", a(this.f276531a), Float.valueOf(this.f276533c), this.f276532b);
    }
}
